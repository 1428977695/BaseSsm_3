package com.hbst.basessm_1.util.constant;

public interface CommonConstant {
	
	//session对象集团组织信息
	public static final String SESSION_ORGANIZATION_NAME = "OrganizationName";
	public static final String SESSION_ORGANIZATION_ID = "OrganizationID";
	public static final String SESSION_BRANCH_NAME = "BranchName";
	public static final String SESSION_BRANCH_ID = "BranchID";
	
	// Session对象（门店及用户相关）
	public static final String SESSION_CLINIC_ID = "ClinicID";
	public static final String SESSION_CLINIC_NAME = "ClinicNAME";
	public static final String SESSION_CLINIC_SHORT_NAME = "ClinicShortName";
	public static final String SESSION_CLINIC_ICON = "ClinicICON";
	public static final String SESSION_USER_ID = "UserID";
	public static final String SESSION_USER_NAME = "UserNAME";
	public static final String SESSION_USER_ICON = "UserICON";
	public static final String SESSION_USER_TYPE = "UserTYPE";
	public static final String SESSION_ROLE_ID = "RoleID";
	public static final String SESSION_EX_DOCTOR_ID = "ExDoctorID";

	// 数据表记录删除成功标志
	public static final Integer DELETED_RECORD_SUCCESS = 1;
	public static final boolean INSERT_RECORD_SUCCESS = true;
	
	// 所有接口列表返回的对象名称
	public static final String QUERY_LIST_NAME = "queryList";
	
	// 预约订单状态：未确认、已确认、已到店、已取消
	public static final Integer BOOKS_ORDER_STATUS_WXCANCELED = 0;
	public static final Integer BOOKS_ORDER_STATUS_UNCONFIRMED = 10;
	public static final Integer BOOKS_ORDER_STATUS_CONFIRMED = 20;
	public static final Integer BOOKS_ORDER_STATUS_ARRIVED = 30;
	public static final Integer BOOKS_ORDER_STATUS_CANCELED = 40;

	// 挂号后的订单状态：已到店、治疗中、已完成、已取消
	public static final Integer DOCTOR_ORDER_STATUS_ARRIVED = 30;
	public static final Integer DOCTOR_ORDER_STATUS_TREATING = 50;
	public static final Integer DOCTOR_ORDER_STATUS_FINISHED = 60;
	public static final Integer DOCTOR_ORDER_STATUS_CANCELED = 70;

	// 订单支付状态：待收费、未付清、已付清、已作废
	public static final Integer DOCTOR_PAY_STATUS_UNCHARGE = 10;
	public static final Integer DOCTOR_PAY_STATUS_UNPAID = 20;
	public static final Integer DOCTOR_PAY_STATUS_PAID = 30;
	public static final Integer DOCTOR_PAY_STATUS_CANCELED = 40;

	// 日结账单结算状态：未结算、已结算
	public static final Integer DOCTOR_STATEMENT_STATUS_UNCLOSED = 0;
	public static final Integer DOCTOR_STATEMENT_STATUS_CLOSED = 1;

	// 支付手续费类型：无手续费、按费率计算、固定金额、按金额范围计算费率、按金额范围收取固定金额
	public static final Integer PAYMENT_TYPE_FEERATE_NONE = 0;
	public static final Integer PAYMENT_TYPE_FEERATE_PERCENT = 1;
	public static final Integer PAYMENT_TYPE_FEERATE_FIXED = 2;
	public static final Integer PAYMENT_TYPE_FEERATE_REGION_PERCENT = 3;
	public static final Integer PAYMENT_TYPE_FEERATE_REGION_FIXED = 4;
	
	// 收支方式：0：收入，1：支出
	public static final Integer PAYMENT_PAY_TYPE_REVENUE = 0;
	public static final Integer PAYMENT_PAY_TYPE_EXPENDITURE = 1;
	
	// 退费状态：无退费，有未完成的退费
	public static final Integer PAYMENT_TYPE_REFUND_NONE = 0;
	public static final Integer PAYMENT_TYPE_REFUND_PROCESSING = 1;
	
	// 退费角色，0：不允许审批人是同一个人，1：允许审批人是同一个人
	public static final Integer PAYMENT_REFUND_ROLE_LIMIT = 0;
	public static final Integer PAYMENT_REFUND_ROLE_NOTLIMIT = 1;
	
	// 退费订单状态：0：已撤销，1：已拒绝，10：已完成，20：医生待审，30：财务待审，40：待退款
	public static final Integer PAYMENT_REFUND_STATUS_CANCELED = 0;
	public static final Integer PAYMENT_REFUND_STATUS_REJECTED = 1;
	public static final Integer PAYMENT_REFUND_STATUS_FINISHED = 10;
	public static final Integer PAYMENT_REFUND_STATUS_DOCTORCHECKS = 20;
	public static final Integer PAYMENT_REFUND_STATUS_APPROVES = 30;
	public static final Integer PAYMENT_REFUND_STATUS_PAYMONEY = 40;
	
	// 退费订单审核状态：0：未审批，1：拒绝，2：批准
	public static final Integer PAYMENT_REFUND_APPROVESTATUS_UNAPPROVED = 0;
	public static final Integer PAYMENT_REFUND_APPROVESTATUS_REJECTED = 1;
	public static final Integer PAYMENT_REFUND_APPROVESTATUS_APPROVED = 2;
	
	
	// ************************************************************
	// ****************** SYSTEM SEQUENCE BEGIN *******************
	// ************************************************************
	public static final Integer SEQ_TYPE_SYS_PATIENTS = 1000;
	public static final Integer SEQ_TYPE_BUS_BOOKEDCALLRECORDS = 1001;
	public static final Integer SEQ_TYPE_SYS_MESSAGESTORE = 1002;
	public static final Integer SEQ_TYPE_BUS_DOCTORTREATS = 1003;
	public static final Integer SEQ_TYPE_BUS_TREATMEDICALTEMPLATE = 1004;
	public static final Integer SEQ_TYPE_PAY_PAYMENTRECORDS = 1005;
	public static final Integer SEQ_TYPE_BUS_REFERRECORDS = 1006;
	public static final Integer SEQ_TYPE_BUS_BOOKEDORDERS = 1007;
	
	// ************************************************************
	// ******************* SYSTEM SEQUENCE END ********************
	// ************************************************************

	
	// ************************************************************
	// ***************** BUSINESS SEQUENCE BEGIN ******************
	// ************************************************************
	public static final Integer SEQ_BUSINESS_PATIENT_PROFILEID = 2000;
	public static final Integer SEQ_BUSINESS_DOCTOR_TREATID = 2001;
	public static final Integer SEQ_BUSINESS_DOCTOR_PRICINGID = 2002;
	public static final Integer SEQ_BUSINESS_PAYMENT_REFUNDID = 2003;
	
	public static final Integer SEQ_BUSINESS_PURCHASE_REQUESTID=2004;//需求请购单
	public static final Integer SEQ_BUSINESS_PURCHASE_BILLID=2005;//采购单
	public static final Integer SEQ_BUSINESS_INSTOCK_BILLID=2006;//入库单
	public static final Integer SEQ_BUSINESS_APPLY_BILLID=2007;//領用单
	public static final Integer SEQ_BUSINESS_CHECK_BILLID=2008;//检查单
	public static final Integer SEQ_BUSINESS_LOSE_BILLID=2009;//损耗单
	public static final Integer SEQ_BUSINESS_REFUNDS_BILLID=2010;//退货单
	public static final Integer SEQ_BUSINESS_RETURNSROCK_BILLID=2011;//退库单
	public static final Integer SEQ_BUSINESS_RQN_BILLID=2012;//调拨单
	public static final Integer SEQ_BUSINESS_TRANSFER_BILLID=2013;//转移单
	public static final Integer SEQ_BUSINESS_ADJUST_BILLID=2014;//调整单
	
	// ************************************************************
	// ****************** BUSINESS SEQUENCE END *******************
	// ************************************************************

	
	// 门店端发送短信列表
	public static final Integer SMS_BUSINESS_20001_NOTIFY_NEWPASSWORD = 20001;
	public static final Integer SMS_BUSINESS_20002_NOTIFY_DOCTOR_NEWBOOKS = 20002;
	public static final Integer SMS_BUSINESS_20003_NOTIFY_DOCTOR_CANCELED = 20003;
	public static final Integer SMS_BUSINESS_20004_NOTIFY_PATIENT_CANCELED = 20004;
	public static final Integer SMS_BUSINESS_20005_NOTIFY_DOCTOR_NEWREGISTER = 20005;
	public static final Integer SMS_BUSINESS_20006_NOTIFY_OPERATOR_NEWPRICING = 20006;
	public static final Integer SMS_BUSINESS_20007_NOTIFY_DOCTOR_NEWREFUND = 20007;
	public static final Integer SMS_BUSINESS_20008_NOTIFY_PATIENT_CONFIRMED = 20008;
	public static final Integer SMS_BUSINESS_20011_NOTIFY_PATIENT_CONFIRMED = 20011;
	
}
