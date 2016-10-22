/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額合算自己負担額情報補正(単)_補正入力20年度のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFH2ValidationHandler {

    private final JikoFutangakuHosei2PanelDiv div;
    private final FlexibleDate 生年月日;
    private final FlexibleYear 対象年度;

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @param 生年月日 FlexibleDate
     * @param 対象年度 FlexibleYear
     */
    public JikoFH2ValidationHandler(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        this.div = div;
        this.生年月日 = 生年月日;
        this.対象年度 = 対象年度;
    }

    /**
     * 「自己負担額情報を確定する」ボタン入力チェック
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate補正後チェック() {
        IValidationMessages messages = new ControlValidator(div, 生年月日, 対象年度)
                .validate補正後チェック();
        return createDictionary補正後チェック().check(messages);
    }

    private ValidationDictionary createDictionary補正後チェック() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック１, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック２, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック３, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック４, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック５, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック６, div.getTbl20Nendo())
                .add(JikoFutangakuHosei2ValidationMessages.高額介護_予防_サービス費チェック, div.getTbl20Nendo())
                .build();
    }

    /**
     * 「自己負担額情報を確定する」ボタン入力チェック
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate補正後チェック_20年度以外() {
        IValidationMessages messages = new ControlValidator(div, 生年月日, 対象年度)
                .validate補正後チェック_20年度以外();
        return createDictionary補正後チェック_20年度以外().check(messages);
    }

    private ValidationDictionary createDictionary補正後チェック_20年度以外() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック１, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック２, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック３, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック４, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック５, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック６, div.getTbl20Igai())
                .add(JikoFutangakuHosei2ValidationMessages.高額介護_予防_サービス費チェック, div.getTbl20Igai())
                .build();
    }

    private static class ControlValidator {

        private final JikoFutangakuHosei2PanelDiv div;
        private final FlexibleDate 生年月日;
        private final FlexibleYear 対象年度;
        private static final int 歳_75 = 75;
        private static final int CODE_35 = 35;
        private static final int CODE_36 = 36;
        private static final int 歳_70 = 70;
        private static final RString 日_31 = new RString("31");
        private static final RString 月_003 = new RString("03");
        private static final RString 月_004 = new RString("04");
        private static final RString 月_005 = new RString("05");
        private static final RString 月_006 = new RString("06");
        private static final RString 月_007 = new RString("07");
        private static final RString 月_008 = new RString("08");
        private static final RString 月_009 = new RString("09");
        private static final RString 月_010 = new RString("10");
        private static final RString 月_011 = new RString("11");
        private static final RString 月_012 = new RString("12");
        private static final RString 月_101 = new RString("01");
        private static final RString 月_102 = new RString("02");
        private static final RString 月_103 = new RString("03");
        private static final RString 月_104 = new RString("04");
        private static final RString 月_105 = new RString("05");
        private static final RString 月_106 = new RString("06");
        private static final RString 月_107 = new RString("07");
        private static final int INT_0 = 0;
        private static final int INT_1 = 1;
        private static final int INT_6 = 6;

        public ControlValidator(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            this.div = div;
            this.生年月日 = 生年月日;
            this.対象年度 = 対象年度;
        }

        public IValidationMessages validate補正後チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JikoFH2Spec.補正後チェック１)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック１)
                    .ifNot(JikoFH2Spec.補正後チェック２)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック２)
                    .ifNot(JikoFH2Spec.補正後チェック３)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック３)
                    .ifNot(JikoFH2Spec.高額介護_予防_サービス費チェック)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.高額介護_予防_サービス費チェック)
                    .messages());
            FlexibleDate 対象年_3月_31日 = new FlexibleDate(対象年度.toString().concat(月_003.toString()).concat(日_31.toString()));
            if (生年月日.plusYear(歳_75).isBeforeOrEquals(対象年_3月_31日)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFH2Spec.補正後チェック4)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック４)
                        .messages());
            }
            if (!messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック４)) {
                int message_code = is補正後チェック4_6(div, 生年月日, 対象年度);
                if (CODE_35 == message_code) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JikoFH2Spec.補正後チェック5)
                            .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                            .messages());
                }
                if (CODE_36 == message_code) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JikoFH2Spec.補正後チェック6)
                            .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                            .messages());
                }
            }
            return messages;
        }

        public IValidationMessages validate補正後チェック_20年度以外() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JikoFH2Spec.補正後チェック１_20年度以外)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック１)
                    .ifNot(JikoFH2Spec.補正後チェック２_20年度以外)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック２)
                    .ifNot(JikoFH2Spec.補正後チェック３_20年度以外)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック３)
                    .ifNot(JikoFH2Spec.高額介護_予防_サービス費チェック_20年度以外)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.高額介護_予防_サービス費チェック)
                    .messages());
            FlexibleDate 対象年_7月_31日 = new FlexibleDate(対象年度.toString().concat(月_007.toString()).concat(日_31.toString()));
            if (生年月日.plusYear(歳_75).isBeforeOrEquals(対象年_7月_31日)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFH2Spec.補正後チェック4_20年度以外)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック４)
                        .messages());
            }
            if (!messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック４)) {
                int message_code = is補正後チェック8_10(div, 生年月日, 対象年度);
                if (CODE_35 == message_code) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JikoFH2Spec.補正後チェック5)
                            .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                            .messages());
                }
                if (CODE_36 == message_code) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JikoFH2Spec.補正後チェック6)
                            .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                            .messages());
                }
            }
            return messages;
        }

        public int is補正後チェック4_6(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_004 = new FlexibleYearMonth(対象年度.toString().concat(月_004.toString()));
            FlexibleYearMonth 対象年月_005 = new FlexibleYearMonth(対象年度.toString().concat(月_005.toString()));
            FlexibleYearMonth 対象年月_006 = new FlexibleYearMonth(対象年度.toString().concat(月_006.toString()));
            Decimal うち70_74歳に係る負担額_4月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
            if (対象年月_004.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_004)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_5月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
            if (対象年月_005.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_005)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_6月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
            if (対象年月_006.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_006)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック7_9(div, 生年月日, 対象年度);
        }

        private int is補正後チェック7_9(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_007 = new FlexibleYearMonth(対象年度.toString().concat(月_007.toString()));
            FlexibleYearMonth 対象年月_008 = new FlexibleYearMonth(対象年度.toString().concat(月_008.toString()));
            FlexibleYearMonth 対象年月_009 = new FlexibleYearMonth(対象年度.toString().concat(月_009.toString()));
            Decimal うち70_74歳に係る負担額_7月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
            if (対象年月_007.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_007)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_8月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
            if (対象年月_008.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_008)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_9月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
            if (対象年月_009.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_009)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック10_12(div, 生年月日, 対象年度);
        }

        private int is補正後チェック10_12(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_010 = new FlexibleYearMonth(対象年度.toString().concat(月_010.toString()));
            FlexibleYearMonth 対象年月_011 = new FlexibleYearMonth(対象年度.toString().concat(月_011.toString()));
            FlexibleYearMonth 対象年月_012 = new FlexibleYearMonth(対象年度.toString().concat(月_012.toString()));
            Decimal うち70_74歳に係る負担額_10月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
            if (対象年月_010.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_010)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_11月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
            if (対象年月_011.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_011)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_12月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
            if (対象年月_012.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_012)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック翌年1_3(div, 生年月日, 対象年度);
        }

        private int is補正後チェック翌年1_3(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_101 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_101.toString()));
            FlexibleYearMonth 対象年月_102 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_102.toString()));
            FlexibleYearMonth 対象年月_103 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_103.toString()));
            Decimal うち70_74歳に係る負担額_翌年1月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
            if (対象年月_101.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_101)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年2月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
            if (対象年月_102.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_102)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年3月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
            if (対象年月_103.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_103)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック翌年4_6(div, 生年月日, 対象年度);
        }

        private int is補正後チェック翌年4_6(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_104 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_104.toString()));
            FlexibleYearMonth 対象年月_105 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_105.toString()));
            FlexibleYearMonth 対象年月_106 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_106.toString()));
            Decimal うち70_74歳に係る負担額_翌年4月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
            if (対象年月_104.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_104)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年5月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
            if (対象年月_105.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_105)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年6月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
            if (対象年月_106.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_106)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック翌年7(div, 生年月日, 対象年度);
        }

        private int is補正後チェック翌年7(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_107 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_107.toString()));
            Decimal うち70_74歳に係る負担額_翌年7月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
            if (対象年月_107.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_107)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                    return CODE_36;
                }
            }
            return INT_0;
        }

        public int is補正後チェック8_10(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_008 = new FlexibleYearMonth(対象年度.toString().concat(月_008.toString()));
            FlexibleYearMonth 対象年月_009 = new FlexibleYearMonth(対象年度.toString().concat(月_009.toString()));
            FlexibleYearMonth 対象年月_010 = new FlexibleYearMonth(対象年度.toString().concat(月_010.toString()));
            Decimal うち70_74歳に係る負担額_8月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
            if (対象年月_008.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_008)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_9月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
            if (対象年月_009.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_009)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_10月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
            if (対象年月_010.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_010)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック11_翌年1(div, 生年月日, 対象年度);
        }

        private int is補正後チェック11_翌年1(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_011 = new FlexibleYearMonth(対象年度.toString().concat(月_011.toString()));
            FlexibleYearMonth 対象年月_012 = new FlexibleYearMonth(対象年度.toString().concat(月_012.toString()));
            FlexibleYearMonth 対象年月_101 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_101.toString()));
            Decimal うち70_74歳に係る負担額_11月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
            if (対象年月_011.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_011)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_12月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
            if (対象年月_012.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_012)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年1月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
            if (対象年月_101.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_101)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック翌年2_4(div, 生年月日, 対象年度);
        }

        private int is補正後チェック翌年2_4(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_102 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_102.toString()));
            FlexibleYearMonth 対象年月_103 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_103.toString()));
            FlexibleYearMonth 対象年月_104 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_104.toString()));
            Decimal うち70_74歳に係る負担額_翌年2月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
            if (対象年月_102.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_102)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年3月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
            if (対象年月_103.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_103)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年4月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
            if (対象年月_104.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_104)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                    return CODE_36;
                }
            }
            return is補正後チェック翌年5_7(div, 生年月日, 対象年度);
        }

        private int is補正後チェック翌年5_7(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
            FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
            FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
            FlexibleYearMonth 対象年月_105 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_105.toString()));
            FlexibleYearMonth 対象年月_106 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_106.toString()));
            FlexibleYearMonth 対象年月_107 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_107.toString()));
            Decimal うち70_74歳に係る負担額_翌年5月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
            if (対象年月_105.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_105)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年6月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
            if (対象年月_106.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_106)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                    return CODE_36;
                }
            }
            Decimal うち70_74歳に係る負担額_翌年7月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
            if (対象年月_107.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_107)) {
                if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                    return CODE_35;
                }
            } else {
                if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                    return CODE_36;
                }
            }
            return INT_0;
        }
    }

    private static enum JikoFutangakuHosei2ValidationMessages implements IValidationMessage {

        補正後チェック１(DbcErrorMessages.うち70_74歳に係る負担額関連３),
        補正後チェック２(DbcErrorMessages.高額合算自己負担額関連１),
        補正後チェック３(DbcErrorMessages.高額合算自己負担額関連２),
        補正後チェック４(DbcErrorMessages.うち70_74歳に係る負担額関連１),
        補正後チェック５(DbcErrorMessages.うち70_74歳に係る負担額関連４),
        補正後チェック６(DbcErrorMessages.うち70_74歳に係る負担額関連２),
        高額介護_予防_サービス費チェック(DbcErrorMessages.高額合算自己負担額関連3);
        private final Message message;

        JikoFutangakuHosei2ValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
