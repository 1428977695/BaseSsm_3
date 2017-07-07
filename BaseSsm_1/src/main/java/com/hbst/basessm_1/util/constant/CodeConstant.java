package com.hbst.basessm_1.util.constant;

/**
 * 返回码
 * 
 * @author lanshiyan description: code码为6位 每两位为一个级别分别代表不同的意思 前两位：级别 00 系统级别 01
 *         业务级别 02 其他 中间两位：模块 00 公共 01登录 02 患者管理 03 预约管理 04 挂号管理 05 治疗管理 06收费 07
 *         门店设置 以此类推 最后两位：具体提示信息 如：01 患者已存在
 */
public interface CodeConstant {

	/****************************************************************************/
	/************************ BEGIN 00系统级别公共错误码 *************************/
	/****************************************************************************/

	/**
	 * 成功
	 */
	public static final String SUCCESS = "000000";
	/**
	 * 参数验证错误码
	 */
	public static final String PARAMS_ERROR = "000001";
	public static final String PARAMS_ERROR_DESCRIPTION = "Invalid method required parameter";

	/**
	 * 系统异常错误码
	 */
	public static final String SYSTEM_ERROR = "000002";
	public static final String SYSTEM_ERROR_DESCRIPTION = "Unknow system exception";

	/****************************************************************************/
	/************************ BEGIN 01业务级别登录错误码 **************************/
	/****************************************************************************/

	// ===========================================================================
	// BEGIN 00公共错误码
	// ===========================================================================

	/**
	 * 用户名密码错误
	 */
	public static final String USERNAME_PWD_ERROR = "010001";
	
	

	/**
	 * 参数为空
	 */
	public static final String PARARM_IS_EMPTY = "010002";

	/**
	 * 不存在此用户
	 */
	public static final String SYSTEM_USER_NOT_EXISTS = "010003";
	public static final String SYSTEM_USER_NOT_EXISTS_DESCRIPTION = "User not exists or bad user ID";

	/**
	 * 密码复杂度不符合要求
	 */
	public static final String SYSTEM_BAD_PASSWORD_COMPLEXITY = "010004";
	public static final String SYSTEM_BAD_PASSWORD_COMPLEXITY_DESCRIPTION = "Invalid password of complexity";

	/**
	 * 旧密码错误
	 */
	public static final String SYSTEM_BAD_OLD_PASSWORD = "010005";
	public static final String SYSTEM_BAD_OLD_PASSWORD_DESCRIPTION = "Invalid old password";
//
	// ===========================================================================
	// BEGIN 01登录错误码: 0101xx
	// ===========================================================================

	// ===========================================================================
	// BEGIN 02患者管理错误码: 0102xx
	// ===========================================================================

	/**
	 * 出现多个姓名和手机号码重复的病人资料
	 */
	public static final String BUSINESS_DUPLICATE_PATIENT = "010201";
	public static final String BUSINESS_DUPLICATE_PATIENT_DESCRIPTION = "Found more than one same name patients";

	// ===========================================================================
	// BEGIN 03预约管理错误码: 0103xx
	// ===========================================================================

	/**
	 * 根据BookID和门店ID查询预约记录时出现无效订单号
	 */
	public static final String BUSINESS_INVALID_BOOKSORDER = "010301";
	public static final String BUSINESS_INVALID_BOOKSORDER_DESCRIPTION = "Invalid booked order";

	/**
	 * 预约的患者信息无效
	 */
	public static final String BUSINESS_INVALID_BOOKSPATIENT = "010302";
	public static final String BUSINESS_INVALID_BOOKSPATIENT_DESCRIPTION = "Invalid booked patient";

	/**
	 * 预约已经是取消状态
	 */
	public static final String BUSINESS_BOOKS_ALREADY_CANCELED = "010303";
	public static final String BUSINESS_BOOKS_ALREADY_CANCELED_DESCRIPTION = "Booked order already canceled";

	/**
	 * 已经到店的患者预约信息不允许取消
	 */
	public static final String BUSINESS_BOOKS_CANNOT_CANCELED = "010304";
	public static final String BUSINESS_BOOKS_CANNOT_CANCELED_DESCRIPTION = "Booked order cannot canceled beause patient is arrived";

	/**
	 * 预约的有效期超出门店规定的日期范围
	 */
	public static final String BUSINESS_BOOKS_TIMEOUT_DAYS = "010305";
	public static final String BUSINESS_BOOKS_TIMEOUT_DAYS_DESCRIPTION = "Booked order time out of days limit";

	/**
	 * 预约的有效期超出门店规定的限制
	 */
	public static final String BUSINESS_BOOKS_OVERRANGE = "010306";
	public static final String BUSINESS_BOOKS_OVERRANGE_DESCRIPTION = "Booked order over range limit level";

	/**
	 * 预约的数量已经超出门店规定的数量
	 */
	public static final String BUSINESS_BOOKS_OVERFLOW = "010307";
	public static final String BUSINESS_BOOKS_OVERFLOW_DESCRIPTION = "Booked order over flow limit times";

	/**
	 * 预约的时间长度低于10分钟
	 */
	public static final String BUSINESS_BOOKS_TIME_TOOSHORT = "010308";
	public static final String BUSINESS_BOOKS_TIME_TOOSHORT_DESCRIPTION = "Booked order time to short";

	/**
	 * 预约的时间长度超出一天的时间
	 */
	public static final String BUSINESS_BOOKS_TIME_TOOLONG = "010309";
	public static final String BUSINESS_BOOKS_TIME_TOOLONG_DESCRIPTION = "Booked order time to long";

	/**
	 * 预约时间参数或格式无效
	 */
	public static final String BUSINESS_BOOKS_TIME_INVALID = "010310";
	public static final String BUSINESS_BOOKS_TIME_INVALID_DESCRIPTION = "Booked order time invalid";

	/**
	 * 预约订单已经是确认状态
	 */
	public static final String BUSINESS_BOOKS_ALREADY_CONFIRMED = "010311";
	public static final String BUSINESS_BOOKS_ALREADY_CONFIRMED_DESCRIPTION = "Booked order already confirmed";

	/**
	 * 不允许备注的信息全部为空格
	 */
	public static final String BUSINESS_BOOKS_INVALID_MEMO = "010312";
	public static final String BUSINESS_BOOKS_INVALID_MEMO_DESCRIPTION = "Invalid books memo content";

	// ===========================================================================
	// BEGIN 04挂号管理错误码: 0104xx
	// ===========================================================================

	/**
	 * 根据OrderID和门店ID查询挂号记录时出现无效订单号
	 */
	public static final String BUSINESS_INVALID_REGISTERORDER = "010401";
	public static final String BUSINESS_INVALID_REGISTERORDER_DESCRIPTION = "Invalid registered order";

	/**
	 * 挂号的患者信息无效
	 */
	public static final String BUSINESS_INVALID_REGISTERPATIENT = "010402";
	public static final String BUSINESS_INVALID_REGISTERPATIENT_DESCRIPTION = "Invalid registered patient";

	/**
	 * 挂号已经是取消状态
	 */
	public static final String BUSINESS_REGISTER_ALREADY_CANCELED = "010403";
	public static final String BUSINESS_REGISTER_ALREADY_CANCELED_DESCRIPTION = "Registered order already canceled";

	/**
	 * 订单为已完成则不允许再取消
	 */
	public static final String BUSINESS_REGISTER_CANNOT_CANCELED = "010404";
	public static final String BUSINESS_REGISTER_CANNOT_CANCELED_DESCRIPTION = "Registered order cannot canceled beause patient is arrived";

	/**
	 * 挂号的时间长度低于10分钟
	 */
	public static final String BUSINESS_REGISTER_TIME_TOOSHORT = "010405";
	public static final String BUSINESS_REGISTER_TIME_TOOSHORT_DESCRIPTION = "Registered order time to short";

	/**
	 * 挂号的时间长度超出一天的时间
	 */
	public static final String BUSINESS_REGISTER_TIME_TOOLONG = "010406";
	public static final String BUSINESS_REGISTER_TIME_TOOLONG_DESCRIPTION = "Registered order time to long";

	/**
	 * 挂号时需要指定医生
	 */
	public static final String BUSINESS_REGISTER_NONE_DOCTOR = "010407";
	public static final String BUSINESS_REGISTER_NONE_DOCTOR_DESCRIPTION = "Doctor needs to chose";

	/**
	 * 订单为已完成则不允许再取消
	 */
	public static final String BUSINESS_REGISTER_CANNOT_EDIT_FINISHED = "010408";
	public static final String BUSINESS_REGISTER_CANNOT_EDIT_FINISHED_DESCRIPTION = "Registered order cannot modify beause it is finished";

	/**
	 * 转诊的时间长度低于10分钟
	 */
	public static final String BUSINESS_REFER_TIME_TOOSHORT = "010409";
	public static final String BUSINESS_REFER_TIME_TOOSHORT_DESCRIPTION = "Registered order time to short";

	/**
	 * 转诊的时间长度超出一天的时间
	 */
	public static final String BUSINESS_REFER_TIME_TOOLONG = "010410";
	public static final String BUSINESS_REFER_TIME_TOOLONG_DESCRIPTION = "Registered order time to long";

	/**
	 * 存在重复的转诊记录
	 */
	public static final String BUSINESS_REFER_RECORD_REPEAT = "010411";
	public static final String BUSINESS_REFER_RECORD_REPEAT_DESCRIPTION = "Refer order repeated";

	/**
	 * 不允许转诊给自己
	 */
	public static final String BUSINESS_REFER_SAME_DOCTOR = "010412";
	public static final String BUSINESS_REFER_SAME_DOCTOR_DESCRIPTION = "Refer doctor is a same people";

	/**
	 * 不允许医生进行挂号
	 */
	public static final String BUSINESS_DISABLED_DOCTOR_REGISTER = "010413";
	public static final String BUSINESS_DISABLED_DOCTOR_REGISTER_DESCRIPTION = "Disabled doctor to register";

	/**
	 * 已经存在一个该医生的挂号信息
	 */
	public static final String BUSINESS_DOCTOR_REGISTER_EXISTS = "010414";
	public static final String BUSINESS_DOCTOR_REGISTER_EXISTS_DESCRIPTION = "Doctor register is exists";

	// ===========================================================================
	// BEGIN 05治疗管理错误码: 0105xx
	// ===========================================================================

	/**
	 * 医生不存在
	 */
	public static final String BUSINESS_DOCTOR_NOT_EXISTS = "010501";
	public static final String BUSINESS_DOCTOR_NOT_EXISTS_DESCRIPTION = "Doctor needs to chose";

	/**
	 * 病人就诊记录不存在
	 */
	public static final String BUSINESS_DOCTOR_NO_TREATS = "010502";
	public static final String BUSINESS_DOCTOR_NO_TREATS_DESCRIPTION = "Patient treats record not exists";

	/**
	 * 病人资料不存在
	 */
	public static final String BUSINESS_DOCTOR_NO_PATIENT = "010503";
	public static final String BUSINESS_DOCTOR_NO_PATIENT_DESCRIPTION = "Patient not found";

	/**
	 * 划价汇总信息不存在
	 */
	public static final String BUSINESS_DOCTOR_NO_PRICED = "010504";
	public static final String BUSINESS_DOCTOR_NO_PRICED_DESCRIPTION = "Priced total not exists";

	/**
	 * 无效的就诊订单
	 */
	public static final String BUSINESS_INVALID_TREATORDER = "010505";
	public static final String BUSINESS_INVALID_TREATORDER_DESCRIPTION = "Invalid treats order";
	
	/**
	 * 收费单本身已经是作废状态
	 */
	public static final String BUSINESS_TREATS_ALREADY_CANCELED = "010506";
	public static final String BUSINESS_TREATS_ALREADY_CANCELED_DESCRIPTION = "Treat order already canceled";

	/**
	 * 无效的支付状态
	 */
	public static final String BUSINESS_INVALID_PAYSTATUS = "010507";
	public static final String BUSINESS_INVALID_PAYSTATUS_DESCRIPTION = "Invalid order pay status";

	/**
	 * 当天已经结账不允许修改费用
	 */
	public static final String BUSINESS_TREAT_PAY_CLOSED = "010508";
	public static final String BUSINESS_TREAT_PAY_CLOSED_DESCRIPTION = "Cann't change pricing for a closed order";

	/**
	 * 无法找到划价记录信息
	 */
	public static final String BUSINESS_TREAT_NO_PRICINGS = "010509";
	public static final String BUSINESS_TREAT_NO_PRICINGS_DESCRIPTION = "Cann't found pricing for order";

	/**
	 * 订单需要重置支付状态为未支付状态
	 */
	public static final String BUSINESS_NEED_RESET_PAYSTATUS = "010510";
	public static final String BUSINESS_NEED_RESET_PAYSTATUS_DESCRIPTION = "Order pay status need reset to unpay status";

	// ===========================================================================
	// BEGIN 06收费错误码: 0106xx
	// ===========================================================================
	/**
	 * 存在未完成的退费请求
	 */
	public static final String BUSINESS_PAYMENT_REFUND_PROCESSING = "010601";
	public static final String BUSINESS_PAYMENT_REFUND_PROCESSING_DESCRIPTION = "There is an unfinished refund request";

	/**
	 * 退费金额超出实际可退费的金额
	 */
	public static final String BUSINESS_PAYMENT_REFUND_OVERFLOW = "010602";
	public static final String BUSINESS_PAYMENT_REFUND_OVERFLOW_DESCRIPTION = "Refund amount overflow current payment amount";

	/**
	 * 未进行日结的订单不需要退费
	 */
	public static final String BUSINESS_PAYMENT_UNCLOSED_NOT_REFUND = "010603";
	public static final String BUSINESS_PAYMENT_UNCLOSED_NOT_REFUND_DESCRIPTION = "Unclosed order naver need to refund";

	/**
	 * 不存在进行的退费请求
	 */
	public static final String BUSINESS_PAYMENT_REFUND_NOT_FOUND = "010604";
	public static final String BUSINESS_PAYMENT_REFUND_NOT_FOUND_DESCRIPTION = "There is none refund request";

	/**
	 * 退费审批状态为未全部完成
	 */
	public static final String BUSINESS_PAYMENT_REFUND_STATUS_INVALID = "010605";
	public static final String BUSINESS_PAYMENT_REFUND_STATUS_INVALID_DESCRIPTION = "Refund approved status invalid";

	/**
	 * 退费审批人不允许为同一个人
	 */
	public static final String BUSINESS_PAYMENT_REFUND_ROLE_SAME = "010606";
	public static final String BUSINESS_PAYMENT_REFUND_ROLE_SAME_DESCRIPTION = "Refund approved role need two different people";

	/**
	 * 已产生退费记录的收费不允许重新收费
	 */
	public static final String BUSINESS_PAYMENT_CANNOT_RESET_REFUNDED = "010607";
	public static final String BUSINESS_PAYMENT_CANNOT_RESET_REFUNDED_DESCRIPTION = "Can not reset payment for had refunded.";

	/**
	 * 对于全部都是微信或支付宝支付的则不需要退费
	 */
	public static final String BUSINESS_PAYMENT_CANNOT_RESET_ONLINEPAID = "010608";
	public static final String BUSINESS_PAYMENT_CANNOT_RESET_ONLINEPAID_DESCRIPTION = "Can not reset payment for all of alipay or weixin.";
	

	// ===========================================================================
	// BEGIN 08朗朗二期   错误码: 0108xx
	// ===========================================================================
	
	/**
	 * 状态异常，此单据不允许被操作
	 */
	public static final String BUSINESS_DOCUMENT_CANNOT_OPERATION_ONLINEPAID = "010801";
	public static final String BUSINESS_DOCUMENT_CANNOT_OPERATION_ONLINEPAID_DESCRIPTION = "Abnormal state, this document is not permitted to operate.";
	
	/**
	 * 操作异常，单据不存在
	 */
	public static final String BUSINESS_DOCUMENT_NULL_ERROR_ONLINEPAID = "010802";
	public static final String BUSINESS_DOCUMENT_NULL_ERROR_ONLINEPAID_DESCRIPTION = "Abnormal operation, the documents do not exist.";
	/**
	 * 库存操作失败。
	 */
	public static final String BUSINESS_STOCK_OPERATION_ERROR_ONLINEPAID = "010803";
	public static final String BUSINESS_STOCK_OPERATION_ERROR_ONLINEPAID_DESCRIPTION = "Inventory operation fails.";
	/**
	 * 操作失败，此信息已经存在，请不要重复添加。
	 */
	public static final String BUSINESS_SUR_MATERIAL_ERROR_ONLINEPAID = "010804";
	public static final String BUSINESS_SUR_MATERIAL_ERROR_ONLINEPAID_DESCRIPTION = "This information already exists. Please do not add a duplicate.";
	
	/**
	 * 存在未完成的单据，不允许结账
	 */
	public static final String NOT_ALLOWED_ACCOUNTSETTLE = "010901";
	public static final String NOT_ALLOWED_ACCOUNTSETTLE_DESCRIPTION = "not allowed to accountSettle.";
	
	/**
	 * 存在未完成的单据，不允许盘点、调整
	 */
	public static final String NOT_ALLOWED_CHECKORADJUST = "010902";
	public static final String NOT_ALLOWED_CHECKORADJUST_DESCRIPTION = "not allowed to check, adjust.";
	
	/**
	 * 存在未完成的盘点、调整单据，不允许制单
	 */
	public static final String NOT_ALLOWED_MAKING_BILL = "010903";
	public static final String NOT_ALLOWED_MAKING_BILL_DESCRIPTION = "not allow making bill.";
	/**
	 * 此信息已经被使用
	 */
	public static final String THIS_MESSAGE_IS_ALREADY_USE = "010904";
	public static final String  THIS_MESSAGE_IS_ALREADY_USE_DESCRIPTION = "this message is already use.";
	
	/**
	 * 患者余额不足
	 */
	public static final String NOT_SUFFICIENT_FUNDS = "010905";
	public static final String NOT_SUFFICIENT_FUNDS_DESCRIPTION = "not sufficient funds.";
	
	/**
	 * 账户被锁定
	 */
	public static final String LOCK_THE_ACCOUNT = "010906";
	public static final String LOCK_THE_ACCOUNT_DESCRIPTION = "not sufficient funds.";
	/**
	 * 账户无菜单信息
	 */
	public static final String ACCOUNT_NOT_MENUID = "010907";
	
	/**
	 * 患者余额不足
	 */
	public static final String NOT_PATIENT_ACCOUNT = "010908";
	public static final String NOT_PATIENT_ACCOUNT_DESCRIPTION = "not patient account.";
	/**
	 * 参数异常(未找到对应库存信息)！
	 */
	public static final String INVENTORY_NOT_FOUND = "010909";
	public static final String INVENTORY_NOT_FOUND_DESCRIPTION = "inventory not found.";
	
	/**
	 * 退费申请异常(未找到审批人电话号码)！
	 */
	public static final String PHONE_NOT_FOUND = "010910";

	
	public static final String ACCOUNT_BRANCH_DELETEFLAG="010911";
	
	public static final String ACCOUNT_CLINIC_DELETEFLAG="010912";
	
	public static final String ACCOUNT_YEAR_NOTOK="010913";
	
	/**
	 * 操作失败(省公司下存在门店)
	 */
	public static final String  COMPANY_HAVE_STORES ="There are stores under the provincial company.";       
	
	/**
	 * 查询不到排班信息！
	 */
	public static final String SCHEDULING_NOT_FOUND = "010914";
	
	/**
	 * 无法取消任务！
	 */
	public static final String TASK_NOT_FOUND = "010915";
	
	/**
	 * 已有员工配置改角色！
	 */
	public static final String EMP_DEPLOY_ROLE = "010916";

	/**
	 * status 0-5
	 *  "0" 正常
	 *  "1" 服务器内部错误
	 *  "2" 请求参数非法
	 *  "3" 权限校验失败
	 *  "4" 配额校验失败
	 *  "5" ak不存在或者非法
	 *  "101" 服务禁用
	 *  "102" 不通过白名单或者安全码不对
	 */
	
	public static final String OPERATION ="Please send the request again match failure";
}
