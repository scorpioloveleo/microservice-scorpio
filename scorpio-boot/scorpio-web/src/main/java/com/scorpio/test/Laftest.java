package com.scorpio.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scorpio.entity.Student;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Laftest {

    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        JSONObject json = new JSONObject();
        json.put("bvn","11114654564564");
        json.put("product", "PalmCredit");
        json.put("status","Frozen");
        json.put("label","AF-RISK");
        json.put("freezeExpireTime", LocalDateTime.now());
        json.put("reason", "风控冻结");
        json.put("source","System-C");
        json1.put("data", json);
        System.out.println(json1.toJSONString());


        /*Student student = new Student();
        student.setName("zhangsan");
        student.setId(1);
        List<Student> lists = new ArrayList<>();
        lists.add(student);
        Map<String, Integer> maps =  lists.stream().collect(Collectors.toMap(Student::getName, Student::getId));
        System.out.println(maps.size());*/


    }



    public static List<String> StringToList(String str,String replaceChar){
        List<String> list = new ArrayList();
        if(StringUtils.isNotBlank(str)){
            String strArray[] = str.split(replaceChar);
            for (int i = 0; i < strArray.length; i++) {
                String array = strArray[i].trim();
                String key = array.substring(0, array.indexOf(" "));
                String value = array.substring(array.indexOf(" ") + 1, array.length());
                list.add(key+"@@"+value);
            }
        }
        return list;
    }

   public static void judge(){

        String xx = "#UPDATE#update wcs_CM_ACCOUNT  wca   set updflag      = 'D',wca.DLQDATE = 0,wca.ACCTTATDUE = 0,wca.ACCTUPAMT = 0,wca.ACCTUPAMT_ORI = 0,wca.ACCTUPBJ = 0,wca.ACCTUPLX = 0," +
                " wca.ACCTUPFY =0,satisfy_date = DATE_FORMAT(?,'%Y-%m-%d'), " +
                "updflag_date = (select cr.curr_date from SM_CUTOVER cr where cr.case_type_id = '0001')  " +
                "where not exists (select 1 from unionpay_account ua where ua.acctnbr = wca.acctnbr) and wca.updflag != 'D'#RULE:1001:1002";


       /*String rule = "SQL#MAPP#135052#;\n" +
               "SQL#MAPP#135050#;\n" +
               "SQL#UPDATE# update wcs_CM_ACCOUNT t1 set t1.is_new_rc = 'N', \n" +
               "  t1.create_date = (select cr.curr_date from SM_CUTOVER cr where cr.case_type_id = '0001')\n" +
               "  where exists (select 1 from unionpay_account t2 where t1.acctnbr=t2.acctnbr)  and t1.updflag='D' #;" ;*/
     String rule = "SQL#UPDATE#update wcs_CM_ACCOUNT  wca\n" +
             "   set updflag      = 'D',wca.DLQDATE = 0,wca.ACCTTATDUE = 0,wca.ACCTUPAMT = 0,wca.ACCTUPAMT_ORI = 0,wca.ACCTUPBJ = 0,wca.ACCTUPLX = 0,\n" +
             "        wca.ACCTUPFY =0,satisfy_date = DATE_FORMAT(?,'%Y-%m-%d'),\n" +
             "       updflag_date = (select cr.curr_date from SM_CUTOVER cr where cr.case_type_id = '0001')\n" +
             "  where not exists (select 1 from unionpay_account ua where ua.acctnbr = wca.acctnbr) and wca.updflag != 'D'#RULE:1001:1002;\n" +
             "SQL#UPDATE# update wcs_CM_ACCOUNT t1 set t1.is_new_rc = 'N', \n" +
             "  t1.create_date = (select cr.curr_date from SM_CUTOVER cr where cr.case_type_id = '0001')\n" +
             "  where exists (select 1 from unionpay_account t2 where t1.acctnbr=t2.acctnbr)  and t1.updflag='D' #;\n" +
             "SQL#MAPP#135052#;\n" +
             "SQL#MAPP#135050#;\n" +
             "SQL#DELETE#delete waj from wcs_cm_account_join waj,wcs_cm_account wac where wac.ACCT_ENTITY_ID = waj.ACCT_ENTITY_ID and exists (select 1 from unionpay_account ua  where wac.ACCTNBR = ua.ACCTNBR)#;\n" +
             "SQL#INSERT# insert into wcs_cm_account_join (ACCT_ENTITY_ID,column1,column51,column52,column53,column54,column55,column56,column57,column58,column59,column60\n" +
             ",column2,column3,column4,column5,column6,column7,column8,column9,column10,column11,column64,column65,column66,column61,column62,column63)  \n" +
             " select ACCT_ENTITY_ID,LOAN_TYPE,FILING_DATE,ua.FIRST_PAYMENT,ua.NUMBER_PERIODSED,LAST_PAY_TIME,ua.LOAN_AMOUNT,ua.NUMBER_PERIODS,PAYMENT,TOTAL_CONTRACT_NUMBER,UNPAID_PERIOD,TOTAL_AMOUNT_DEBT,MERCHANT_NAME,LOCAL_AREA,SALE_PLACE,ua.BRAND\n" +
             ",ua.PRODUCT,SALES_NOTES,PUBLIC_ACCOUNT,CUST_WITHHOLDING_CARD,CUST_WITHHOLDING_BANK ,CONTRACT_AMOUNT,DATE_LOAN,SURRENDER,PRE_DEPOSIT,PRE_DEPOSIT_BALANCE,EARLY_REPAYMENT_CHARGE,COLLECTION_CHARGE from unionpay_account ua,wcs_cm_account wa where wa.ACCTNBR = ua.ACCTNBR#;\n" +
             "SQL#UPDATE# update  wcs_CM_ACCOUNT a set a.is_new_rc='N' where a.is_new_rc ='Y'\n" +
             "    and EXISTS (select 1 from wcs_cm_customer c where c.custnbr = a.acctnbr) #;\n" +
             "SQL#UPDATE# update  wcs_CM_ACCOUNT a set a.is_new_rc='Y' where a.is_new_rc IS NULL\n" +
             "    and EXISTS (select 1 from wcs_cm_customer c where c.custnbr = a.acctnbr) #;\n" +
             "SQL#UPDATE# update wcs_CM_ACCOUNT a set a.has_rp = (select case when count(b.TRANSACTION)>0 then 'Y' else 'N' end as has_rp\n" +
             "    from unionpay_chargebacks_flow b where b.JOB_NUMBER=a.BUS_JOB_NUMBER and  (a.has_rp is null or a.has_rp='N')\n" +
             "    and (a.has_rp is null or a.has_rp='N')  and a.create_date< (select cr.curr_date from SM_CUTOVER cr where cr.case_type_id = '0001')  and a.updflag!='D')  #;\n" +
             "SQL#UPDATE# update wcs_cm_customer c,wcs_CM_ACCOUNT a set a.ACCTCUSTNAME =c.CUSTLNAME where c.CUSTIDNBR=a.ACCTCUST  and a.ACCTCUSTNAME is null #;\n" +
             "SQL#UPDATE# update wcs_CM_ACCOUNT a set a.acctbank=a.acctbank where length(a.acctbank)=1 #;";
       String sqlScripts[] = rule.trim().replaceAll("\r", "").replaceAll("\n", "").split(";");
       for (int i = 0; i < sqlScripts.length; i++) {

           long startTime = System.currentTimeMillis();
           String sql[] = sqlScripts[i].trim().split("#");
           String params[] = sql.length == 4 ? sql[3].split(",") : null;
           if (params != null && params.length > 0) {
               for (int j = 0; j < params.length; j++) {
                   String ruleParam[] = params[j].split(":");
                   if (ruleParam.length > 0 && "RULE".equals(ruleParam[0]))
                       System.out.println(Long.valueOf(Long.parseLong(ruleParam[1])));
                       System.out.println(ruleParam.length != 3 ? null : ruleParam[2]);
                       System.out.println();
                      // params[j] = getRuleResult(Long.valueOf(Long.parseLong(ruleParam[1])), ruleParam.length != 3 ? null : ruleParam[2], new ConcurrentHashMap());
               }

           }
           System.out.println(111);
           /*if ("HQL".equals(sql[0].trim())) {
               if ("FIND".equals(sql[1].trim())) {
                   result = (new StringBuilder(String.valueOf(result))).append(",").append(i).append(":").append(String.valueOf(smSourceDataHandleRuleMapper.superManagerSelect(SqlUtils.convertToStr(sql[2], params)))).toString();
               }else if ("UPDATE".equals(sql[1].trim()) || "DELETE".equals(sql[1].trim()) || "INSERT".equals(sql[1].trim())) {
                   result = getSqlResult(result, i, sql, params);
               }
           } else if ("FIND".equals(sql[1].trim())) {
               result = (new StringBuilder(String.valueOf(result))).append(",").append(i).append(":").append(String.valueOf(smSourceDataHandleRuleMapper.superManagerSelect(SqlUtils.convertToStr(sql[2], params)))).toString();
           } else if ("UPDATE".equals(sql[1].trim()) || "DELETE".equals(sql[1].trim()) || "INSERT".equals(sql[1].trim())) {
               //result = (new StringBuilder(String.valueOf(result))).append(",").append(i).append(":").append(String.valueOf(smSourceDataHandleRuleMapper.superManagerSelect(SqlUtils.convertToStr(sql[2], params)))).toString();
               result = getSqlResult(result, i, sql, params);
           } else if ("MAPP".equals(sql[1].trim())) {
               Map map = dataTransferService.transferToSql(smTableFieldMappService.findTableFieldMappById(Long.valueOf(Long.parseLong(sql[2].trim()))), null);
               for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                   java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
                   result = (new StringBuilder(String.valueOf(result))).append(",").append(i).append(":").append(String.valueOf(smSourceDataHandleRuleMapper.superManagerSelect(SqlUtils.convertToStr((String) entry.getKey(), ((List) entry.getValue()).toArray())))).toString();
               }

           }

           long endTime=System.currentTimeMillis();
           LOGGER.info("规则:[" + rule.getCode() + "][" + sqlScripts[i] + "]耗时： " + DateUtils.formatTime((endTime - startTime)));*/
       }
    }
}
