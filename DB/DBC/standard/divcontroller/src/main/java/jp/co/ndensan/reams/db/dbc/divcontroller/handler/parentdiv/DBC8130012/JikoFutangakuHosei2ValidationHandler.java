/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.JikoFutangakuHosei2Div;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業分自己負担額情報補正（単）_補正入力のクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public class JikoFutangakuHosei2ValidationHandler {

    private final JikoFutangakuHosei2Div div;
    private final FlexibleDate 生年月日;
    private final FlexibleYear 対象年度;

    /**
     * コンストラクタです。
     *
     * @param div NushiJuminJohoDiv
     * @param 生年月日 FlexibleDate
     * @param 対象年度 FlexibleYear
     */
    public JikoFutangakuHosei2ValidationHandler(JikoFutangakuHosei2Div div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        this.div = div;
        this.生年月日 = 生年月日;
        this.対象年度 = 対象年度;
    }

    /**
     * 「補正前の金額をコピーする」ボタン入力済チェック
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div, 生年月日, 対象年度)
                .validate();
        return createDictionary().check(messages);
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

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuHosei2ValidationMessages.補正後のデータ入力済, div.getJikoFutangakuHosei2a())
                .build();
    }

    private ValidationDictionary createDictionary補正後チェック() {
        return new ValidationDictionaryBuilder()
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック１, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック２, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック３, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック４, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック５, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.補正後チェック６, div.getJikoFutangakuHosei2a())
                .add(JikoFutangakuHosei2ValidationMessages.高額総合事業サービス費チェック, div.getJikoFutangakuHosei2a())
                .build();
    }

    private static class ControlValidator {

        private final JikoFutangakuHosei2Div div;
        private final FlexibleDate 生年月日;
        private final FlexibleYear 対象年度;
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
        private static final RString 日 = new RString("31");
        private static final int 歳_75 = 75;
        private static final int 歳_74 = 74;
        private static final int 歳_70 = 70;
        private static final int INT_0 = 0;
        private static final int INT_1 = 1;
        private static final int INT_6 = 6;

        public ControlValidator(JikoFutangakuHosei2Div div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
            this.div = div;
            this.生年月日 = 生年月日;
            this.対象年度 = 対象年度;
        }

        /**
         * 選択世帯員の印字内容を確認するボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JikoFutangakuHosei2Spec.補正後のデータ入力済)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後のデータ入力済)
                    .messages());
            return messages;
        }

        public IValidationMessages validate補正後チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JikoFutangakuHosei2Spec.補正後チェック１)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック１)
                    .ifNot(JikoFutangakuHosei2Spec.補正後チェック２)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック２)
                    .ifNot(JikoFutangakuHosei2Spec.補正後チェック３)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック３)
                    .ifNot(JikoFutangakuHosei2Spec.高額総合事業サービス費チェック)
                    .thenAdd(JikoFutangakuHosei2ValidationMessages.高額総合事業サービス費チェック)
                    .messages());
            FlexibleDate 対象年月日 = new FlexibleDate(対象年度.toString().concat(月_107.toString()).concat(日.toString()));
            if (生年月日.plusYear(歳_75).isBeforeOrEquals(対象年月日)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック４)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック４)
                        .messages());
            }
            if (!messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック４)) {
                FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
                FlexibleYearMonth 対象年月_008 = new FlexibleYearMonth(対象年度.toString().concat(月_008.toString()));
                FlexibleYearMonth 対象年月_009 = new FlexibleYearMonth(対象年度.toString().concat(月_009.toString()));
                FlexibleYearMonth 対象年月_010 = new FlexibleYearMonth(対象年度.toString().concat(月_010.toString()));
                FlexibleYearMonth 対象年月_011 = new FlexibleYearMonth(対象年度.toString().concat(月_011.toString()));
                FlexibleYearMonth 対象年月_012 = new FlexibleYearMonth(対象年度.toString().concat(月_012.toString()));
                FlexibleYearMonth 対象年月_101 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_101.toString()));
                FlexibleYearMonth 対象年月_102 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_102.toString()));
                FlexibleYearMonth 対象年月_103 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_103.toString()));
                FlexibleYearMonth 対象年月_104 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_104.toString()));
                FlexibleYearMonth 対象年月_105 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_105.toString()));
                FlexibleYearMonth 対象年月_106 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_106.toString()));
                FlexibleYearMonth 対象年月_107 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_107.toString()));
                validate補正後チェック５(生年月, 対象年月_008, messages, 対象年月_009, 対象年月_010, 対象年月_011, 対象年月_012, 対象年月_101,
                        対象年月_102, 対象年月_103, 対象年月_104, 対象年月_105, 対象年月_106, 対象年月_107);
                validate補正後チェック６(対象年月_008, 生年月, messages, 対象年月_009, 対象年月_010, 対象年月_011, 対象年月_012);
                validate補正後チェック６_翌年(対象年月_101, 生年月, messages, 対象年月_102, 対象年月_103, 対象年月_104, 対象年月_105,
                        対象年月_106, 対象年月_107);
            }
            return messages;
        }

        private void validate補正後チェック５(FlexibleYearMonth 生年月, FlexibleYearMonth 対象年月_008, IValidationMessages messages,
                FlexibleYearMonth 対象年月_009, FlexibleYearMonth 対象年月_010, FlexibleYearMonth 対象年月_011, FlexibleYearMonth 対象年月_012,
                FlexibleYearMonth 対象年月_101, FlexibleYearMonth 対象年月_102, FlexibleYearMonth 対象年月_103, FlexibleYearMonth 対象年月_104,
                FlexibleYearMonth 対象年月_105, FlexibleYearMonth 対象年月_106, FlexibleYearMonth 対象年月_107) {
            if (対象年月_008.isBefore(生年月.plusYear(歳_70))) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_008)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            boolean is補正後チェック５ = messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック５);
            validate補正後チェック５_対象年月_009(対象年月_009, 生年月, is補正後チェック５, messages);
            validate補正後チェック５_対象年月_010(対象年月_010, 生年月, is補正後チェック５, messages);
            validate補正後チェック５_対象年月_011(対象年月_011, 生年月, is補正後チェック５, messages);
            validate補正後チェック５_対象年月_012(対象年月_012, 生年月, is補正後チェック５, messages);
            if (対象年月_101.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_101)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_102.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_102)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_103.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_103)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_104.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_104)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_105.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_105)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_106.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_106)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
            if (対象年月_107.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_107)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
        }

        private void validate補正後チェック５_対象年月_012(FlexibleYearMonth 対象年月_012, FlexibleYearMonth 生年月,
                boolean is補正後チェック５, IValidationMessages messages) {
            if (対象年月_012.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_012)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
        }

        private void validate補正後チェック５_対象年月_011(FlexibleYearMonth 対象年月_011, FlexibleYearMonth 生年月,
                boolean is補正後チェック５, IValidationMessages messages) {
            if (対象年月_011.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_011)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
        }

        private void validate補正後チェック５_対象年月_010(FlexibleYearMonth 対象年月_010, FlexibleYearMonth 生年月,
                boolean is補正後チェック５, IValidationMessages messages) {
            if (対象年月_010.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_010)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
        }

        private void validate補正後チェック５_対象年月_009(FlexibleYearMonth 対象年月_009, FlexibleYearMonth 生年月,
                boolean is補正後チェック５, IValidationMessages messages) {
            if (対象年月_009.isBefore(生年月.plusYear(歳_70)) && !is補正後チェック５) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック５_009)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック５)
                        .messages());
            }
        }

        private void validate補正後チェック６(FlexibleYearMonth 対象年月_008, FlexibleYearMonth 生年月, IValidationMessages messages,
                FlexibleYearMonth 対象年月_009, FlexibleYearMonth 対象年月_010, FlexibleYearMonth 対象年月_011, FlexibleYearMonth 対象年月_012) {
            if (対象年月_008.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_008)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_008)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            boolean is補正後チェック６ = messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック６);
            if (対象年月_009.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_009) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_009)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            if (対象年月_010.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_010) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_010)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            if (対象年月_011.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_011) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_011)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            if (対象年月_012.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_012) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_012)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

        private void validate補正後チェック６_翌年(FlexibleYearMonth 対象年月_101, FlexibleYearMonth 生年月, IValidationMessages messages,
                FlexibleYearMonth 対象年月_102, FlexibleYearMonth 対象年月_103, FlexibleYearMonth 対象年月_104, FlexibleYearMonth 対象年月_105,
                FlexibleYearMonth 対象年月_106, FlexibleYearMonth 対象年月_107) {
            boolean is補正後チェック６ = messages.contains(JikoFutangakuHosei2ValidationMessages.補正後チェック６);
            validate補正後チェック６_対象年月_101(対象年月_101, 生年月, is補正後チェック６, messages);
            validate補正後チェック６_対象年月_102(対象年月_102, 生年月, is補正後チェック６, messages);
            validate補正後チェック６_対象年月_103(対象年月_103, 生年月, is補正後チェック６, messages);
            validate補正後チェック６_対象年月_105(対象年月_104, 生年月, is補正後チェック６, messages);
            if (対象年月_105.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_105) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_105)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            if (対象年月_106.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_106) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_106)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
            if (対象年月_107.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_107) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_107)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

        private void validate補正後チェック６_対象年月_105(FlexibleYearMonth 対象年月_104, FlexibleYearMonth 生年月, boolean is補正後チェック６,
                IValidationMessages messages) {
            if (対象年月_104.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_104) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_104)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

        private void validate補正後チェック６_対象年月_103(FlexibleYearMonth 対象年月_103, FlexibleYearMonth 生年月, boolean is補正後チェック６,
                IValidationMessages messages) {
            if (対象年月_103.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_103) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_103)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

        private void validate補正後チェック６_対象年月_102(FlexibleYearMonth 対象年月_102, FlexibleYearMonth 生年月, boolean is補正後チェック６,
                IValidationMessages messages) {
            if (対象年月_102.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_102) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_102)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

        private void validate補正後チェック６_対象年月_101(FlexibleYearMonth 対象年月_101, FlexibleYearMonth 生年月, boolean is補正後チェック６,
                IValidationMessages messages) {
            if (対象年月_101.isBeforeOrEquals(生年月.plusYear(歳_74)) && 生年月.plusYear(歳_70).isBeforeOrEquals(対象年月_101) && !is補正後チェック６) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JikoFutangakuHosei2Spec.補正後チェック６_101)
                        .thenAdd(JikoFutangakuHosei2ValidationMessages.補正後チェック６)
                        .messages());
            }
        }

    }

    private static enum JikoFutangakuHosei2ValidationMessages implements IValidationMessage {

        補正後のデータ入力済(DbcWarningMessages.高額合算補正前コピー),
        補正後チェック１(DbcErrorMessages.うち70_74歳に係る負担額関連３),
        補正後チェック２(DbcErrorMessages.高額合算自己負担額関連１),
        補正後チェック３(DbcErrorMessages.事業高額合算自己負担額関連１),
        補正後チェック４(DbcErrorMessages.うち70_74歳に係る負担額関連１),
        補正後チェック５(DbcErrorMessages.うち70_74歳に係る負担額関連１),
        補正後チェック６(DbcErrorMessages.うち70_74歳に係る負担額関連２),
        高額総合事業サービス費チェック(DbcErrorMessages.事業高額合算自己負担額関連２);
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
