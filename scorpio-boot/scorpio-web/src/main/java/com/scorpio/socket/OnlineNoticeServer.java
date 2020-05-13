package com.scorpio.socket;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**  
 * <pre>
 * Description	WebSocket服务-定义成一个WebSocket服务器端，用于监听用户连接的终端访问URL地址
 * Copyright:	Copyright (c)2017
 * Company:		杭州启冠网络技术有限公司
 * Author:		Administrator
 * Version: 	1.0
 * Create at:	2017年3月27日 下午4:42:36  
 *  
 * Modification History:  
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------  
 * 
 * </pre>
 */  
@ServerEndpoint(value = "/websocket/{userno}/{loginName}", configurator = HttpChatSessionConfigurator.class)
@Component
public class OnlineNoticeServer {
	
	/**
	 * 当前会话
	 */
	private static CopyOnWriteArraySet<OnlineNoticeServer> webSocketSet = Sets.newCopyOnWriteArraySet();

	private static ConcurrentHashMap<String, OnlineNoticeServer> webSocketSet_oes = new ConcurrentHashMap<String, OnlineNoticeServer>();
	
	/**
	 * 与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	private Session session;
	
	/**
	 * 用户名
	 */
	private String userid;

	private String userno = "";

	private static int onlineCount = 0;
	
	
	/**
	 * request的session
	 */
	private HttpSession httpSession; 

	/**
	 * 在线列表,记录用户名称
	 */
	private static List<String> OnlineUserlist = Lists.newCopyOnWriteArrayList();
	
	/**
	 *  用户名和websocket的session绑定的路由表
	 */
	private static Map<String, Session> routetabMap = Maps.newConcurrentMap();
	
	
	
	/**
	 * 连接建立成功调用的方法-与前端JS代码对应
	 * 
	 * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam(value = "userno") String param, @PathParam(value = "loginName") String loginName, Session session, EndpointConfig config) {
		// 单个会话对象保存
		/*this.session = session;
		webSocketSet.add(this); // 加入set中
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		String uId = (String) httpSession.getAttribute("userid"); // 获取当前用户
		//String uId = "0000";
		String sessionId = httpSession.getId();
		this.userid = uId + "|" + sessionId;
		if (!OnlineUserlist.contains(this.userid)) {
			OnlineUserlist.add(userid); // 将用户名加入在线列表
		}
		routetabMap.put(userid, session); // 将用户名和session绑定到路由表
		System.out.println(userid + " -> 已上线");
		String message = getMessage(userid + " -> 已上线", "notice", OnlineUserlist);
		broadcast(message); // 广播*/


		//
		System.out.println(param +"  |  "+ loginName);
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		userno = param;//接收到发送消息的人员编号
		this.session = session;
		webSocketSet_oes.put(param, this);//加入map中
		addOnlineCount();           //在线数加1
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 连接关闭调用的方法-与前端JS代码对应
	 */
	@OnClose
	public void onClose() {
		/*webSocketSet.remove(this); // 从set中删除
		routetabMap.remove(userid); 
		OnlineUserlist.remove(userid);
		System.out.println(userid + " -> 已下线");
		String message = getMessage(userid + " -> 已下线", "notice", OnlineUserlist);
		broadcast(message);
		//singleSend(message, sn); // 广播*/

		if (!userno.equals("")) {
			webSocketSet.remove(userno);  //从set中删除
			subOnlineCount();           //在线数减1
			System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
		}
	}

	/**
	 * 接收客户端的message,判断是否有接收人而选择进行广播还是指定发送 -与前端JS代码对应
	 * 消息格式JSON，参数如下：
	 * "massage" : { "from" : "xxx", "to" : "xxx", "content" : "xxx", "time" :
	 * "xxxx.xx.xx" }, 
	 * "type" : {notice|message},
	 *  "list" : {[xx],[xx],[xx]}
	 *  
	 * @param _message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String _message) {
		
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param error
	 */
	@OnError
	public void onError(Throwable error) {
		System.out.println(error.getLocalizedMessage());
	}

	/**
	 * 广播消息
	 * 
	 * @param message
	 */
	public void broadcast(String message) {
		// 判断当前会话人数
		if (webSocketSet.size() == 0) return;
		
		// 获取当前所有的会话session
		for (OnlineNoticeServer chat : webSocketSet) {
			chat.session.getAsyncRemote().sendText(message);
		}
	}

	/**
	 * 对特定用户发送消息
	 * 
	 * @param message
	 * @param session
	 */
	public void singleSend(String message, Session session) {
		session.getAsyncRemote().sendText(message); // 异步发送
	}

	/**
	 * 组装返回给前台的消息
	 * 
	 * @param message 交互信息
	 * @param type 信息类型
	 * @param list 在线列表
	 * @return
	 */
	public String getMessage(String message, String type, List<String> list) {
		JSONObject member = new JSONObject();
		member.put("message", message);
		member.put("type", type);
		member.put("list", list);
		return member.toString();
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		OnlineNoticeServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		OnlineNoticeServer.onlineCount--;
	}
}
