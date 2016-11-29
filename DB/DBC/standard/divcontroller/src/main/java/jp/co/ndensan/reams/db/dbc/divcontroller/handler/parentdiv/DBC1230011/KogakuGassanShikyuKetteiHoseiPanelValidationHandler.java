/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanelValidationHandler {

    private final KogakuGassanShikyuKetteiHoseiPanelDiv div;
    private static final int NUM_TWENTY = 20;
    private static final RString TWENTY = new RString("20");
    private static final RString 年度 = new RString("年度");
    private static final RString 対象年度 = new RString("対象年度");
    private static final RString 先頭3桁 = new RString("先頭3桁");
    private static final RString 支給 = new RString("支給");
    private static final RString 不支給 = new RString("不支給");
    private static final RString 先頭6桁目から11桁目 = new RString("先頭6桁目から11桁目");
    private static final RString 証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString 不支給選択時_不支給理由 = new RString("不支給選択時、不支給理由");
    private static final RString 連絡票整理番号 = new RString("連絡票整理番号");
    private static final RString 負担額証明書整理番号 = new RString("自己負担額証明書整理番号は数値のみです。");
    private static final RString 自己負担額証明書整理番号 = new RString("自己負担額証明書整理番号");
    private static final RString 支給指定時は支給金額 = new RString("支給指定時は支給金額");
    private static final RString 日付の指定に誤りがあります = new RString("日付の指定に誤りがあります。[計算期間]");
    private static final RString 計算期間 = new RString("計算期間");
    private static final RString 対象年度内 = new RString("対象年度内");
    private static final RString 支給申請書整理番号 = new RString("連絡票整理番号(支給申請書整理番号)");
    private static final RString 指定された記載保険者番号 = new RString("指定された記載保険者番号");
    private static final RString 平成20年度以降の年度 = new RString("平成20年度以降の年度");
    private static final RDate 定値_年度年度1 = new RDate("2008");
    private static final RDate 定値_年度年度2 = new RDate("2009");
    private static final RString 定値_日付2 = new RString("0801");
    private static final RString 定値_日付3 = new RString("0731");
    private static final RDate 定値_開始計算対象期間1 = new RDate("20080401");
    private static final RDate 定値_終了計算対象期間1 = new RDate("20090731");

    /**
     * 初期化
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     */
    public KogakuGassanShikyuKetteiHoseiPanelValidationHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 新規登録_対象年度入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate新規登録対象年度() {
        IValidationMessages messages = new ControlValidator(div).valide新規登録対象年度();
        return createDictionary新規登録対象年度().check(messages);
    }

    /**
     * 検索条件対象年度入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate検索条件対象年度() {
        IValidationMessages messages = new ControlValidator(div).valide検索条件対象年度();
        return createDictionary検索条件対象年度().check(messages);
    }

    /**
     * 新規登録_証記載保険者番号入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate新規登録証記載保険者番号() {
        IValidationMessages messages = new ControlValidator(div).valide新規登録証記載保険者番号();
        return createDictionary新規登録証記載保険者番号().check(messages);
    }

    /**
     * 検索条件_証記載保険者番号入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate検索条件証記載保険者番号() {
        IValidationMessages messages = new ControlValidator(div).valide検索条件証記載保険者番号();
        return createDictionary検索条件証記載保険者番号().check(messages);
    }

    /**
     * 新規登録_連絡票整理番号入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate新規登録連絡票整理番号() {
        IValidationMessages messages = new ControlValidator(div).valide新規登録連絡票整理番号();
        return createDictionary新規登録連絡票整理番号().check(messages);
    }

    /**
     * 検索条件_連絡票整理番号入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate検索条件連絡票整理番号() {
        IValidationMessages messages = new ControlValidator(div).valide検索条件連絡票整理番号();
        return createDictionary検索条件連絡票整理番号().check(messages);
    }

    /**
     * 検索条件_連絡票整理番号入力値チェックです。
     *
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs validate決定情報を追加する() {
        IValidationMessages messages = new ControlValidator(div).valide決定情報を追加する();
        return createDictionary決定情報を追加する().check(messages);
    }

    private ValidationDictionary createDictionary新規登録対象年度() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.新規登録_対象年度入力値が不正,
                        div.getShinkiPanel().getTxtShinkiTaishoNendo())
                .add(ChoteiboSakuseiValidationMessages.新規登録_対象年度_未指定,
                        div.getShinkiPanel().getTxtShinkiTaishoNendo())
                .build();
    }

    private ValidationDictionary createDictionary検索条件対象年度() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.検索条件_対象年度入力値が不正,
                        div.getSearchPanel().getTxtKensakuTaishoNendo())
                .add(ChoteiboSakuseiValidationMessages.検索条件_対象年度_未指定,
                        div.getSearchPanel().getTxtKensakuTaishoNendo())
                .build();
    }

    private ValidationDictionary createDictionary新規登録証記載保険者番号() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.新規登録_証記載保険者番号入力値が不正,
                        div.getShinkiPanel().getTxtShinkiHihokenshaNo())
                .add(ChoteiboSakuseiValidationMessages.新規登録_証記載保険者番号存在しない,
                        div.getShinkiPanel().getTxtShinkiHihokenshaNo())
                .build();
    }

    private ValidationDictionary createDictionary検索条件証記載保険者番号() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.検索条件_証記載保険者番号入力値が不正,
                        div.getSearchPanel().getTxtKensakuHihokenshaNo())
                .add(ChoteiboSakuseiValidationMessages.検索条件_証記載保険者番号存在しない,
                        div.getSearchPanel().getTxtKensakuHihokenshaNo())
                .build();
    }

    private ValidationDictionary createDictionary新規登録連絡票整理番号() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号入力値が不正,
                        div.getShinkiPanel().getTxtShinkiShikyuSeiriNo())
                .add(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号不一致_先頭3桁,
                        div.getShinkiPanel().getTxtShinkiShikyuSeiriNo())
                .add(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号不一致_先頭6桁目から11桁目,
                        div.getShinkiPanel().getTxtShinkiShikyuSeiriNo())
                .build();
    }

    private ValidationDictionary createDictionary検索条件連絡票整理番号() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号入力値が不正,
                        div.getSearchPanel().getTxtKensakuShikyuSeiriNo())
                .add(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号不一致_先頭3桁,
                        div.getSearchPanel().getTxtKensakuShikyuSeiriNo())
                .add(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号不一致_先頭6桁目から11桁目,
                        div.getSearchPanel().getTxtKensakuShikyuSeiriNo())
                .build();
    }

    private ValidationDictionary createDictionary決定情報を追加する() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.対象年度必須入力,
                        div.getShinkiPanel().getTxtShinkiTaishoNendo())
                .add(ChoteiboSakuseiValidationMessages.証記載保険者番号必須入力,
                        div.getShinkiPanel().getTxtShinkiHihokenshaNo())
                .add(ChoteiboSakuseiValidationMessages.支給申請書整理番号必須入力,
                        div.getShinkiPanel().getTxtShinkiShikyuSeiriNo())
                .build();
    }

    private static class ControlValidator {

        private final KogakuGassanShikyuKetteiHoseiPanelDiv div;

        public ControlValidator(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            this.div = div;
        }

        /**
         * 新規登録_対象年度入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide新規登録対象年度() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_対象年度入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_対象年度入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_対象年度_未指定)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_対象年度_未指定).messages());
            return messages;
        }

        /**
         * 検索条件_対象年度入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide検索条件対象年度() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_対象年度入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_対象年度入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_対象年度_未指定)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_対象年度_未指定).messages());
            return messages;
        }

        /**
         * 新規登録_証記載保険者番号入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide新規登録証記載保険者番号() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_証記載保険者番号入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_証記載保険者番号入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_証記載保険者番号存在しない)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_証記載保険者番号存在しない).messages());
            return messages;
        }

        /**
         * 検索条件_証記載保険者番号入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide検索条件証記載保険者番号() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_証記載保険者番号入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_証記載保険者番号入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_証記載保険者番号存在しない)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_証記載保険者番号存在しない).messages());
            return messages;
        }

        /**
         * 新規登録_連絡票整理番号入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide新規登録連絡票整理番号() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_連絡票整理番号入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_連絡票整理番号不一致_先頭3桁)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号不一致_先頭3桁)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.新規登録_連絡票整理番号不一致_先頭6桁目から11桁目)
                    .thenAdd(ChoteiboSakuseiValidationMessages.新規登録_連絡票整理番号不一致_先頭6桁目から11桁目).messages());
            return messages;
        }

        /**
         * 検索条件_連絡票整理番号入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide検索条件連絡票整理番号() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_連絡票整理番号入力値が不正)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号入力値が不正)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_連絡票整理番号不一致_先頭3桁)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号不一致_先頭3桁)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.検索条件_連絡票整理番号不一致_先頭6桁目から11桁目)
                    .thenAdd(ChoteiboSakuseiValidationMessages.検索条件_連絡票整理番号不一致_先頭6桁目から11桁目).messages());
            return messages;
        }

        /**
         * 決定情報を追加する入力値チェックです。
         *
         * @return IValidationMessages
         */
        public IValidationMessages valide決定情報を追加する() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.対象年度必須入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.対象年度必須入力)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.証記載保険者番号必須入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.証記載保険者番号必須入力)
                    .ifNot(KogakuGassanShikyuKetteiHoseiPanelSpec.支給申請書整理番号必須入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.支給申請書整理番号必須入力).messages());
            return messages;
        }
    }

    private static enum ChoteiboSakuseiValidationMessages implements IValidationMessage {

        対象年度必須入力(UrErrorMessages.必須, 対象年度.toString()),
        証記載保険者番号必須入力(UrErrorMessages.必須, 証記載保険者番号.toString()),
        支給申請書整理番号必須入力(UrErrorMessages.必須, 支給申請書整理番号.toString()),
        新規登録_対象年度入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 年度.toString()),
        新規登録_対象年度_未指定(UrErrorMessages.未指定, 平成20年度以降の年度.toString()),
        新規登録_証記載保険者番号入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 証記載保険者番号.toString()),
        新規登録_証記載保険者番号存在しない(UrErrorMessages.存在しない, 指定された記載保険者番号.toString()),
        新規登録_連絡票整理番号入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 連絡票整理番号.toString()),
        新規登録_連絡票整理番号不一致_先頭3桁(DbcErrorMessages.支給申請書整理番号_不一致,
                対象年度.toString(), 連絡票整理番号.toString(), 先頭3桁.toString()),
        新規登録_連絡票整理番号不一致_先頭6桁目から11桁目(DbcErrorMessages.支給申請書整理番号_不一致,
                証記載保険者番号.toString(), 連絡票整理番号.toString(), 先頭6桁目から11桁目.toString()),
        検索条件_対象年度入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 年度.toString()),
        検索条件_対象年度_未指定(UrErrorMessages.未指定, 平成20年度以降の年度.toString()),
        検索条件_証記載保険者番号入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 証記載保険者番号.toString()),
        検索条件_証記載保険者番号存在しない(UrErrorMessages.存在しない, 指定された記載保険者番号.toString()),
        検索条件_連絡票整理番号入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, 連絡票整理番号.toString()),
        検索条件_連絡票整理番号不一致_先頭3桁(DbcErrorMessages.支給申請書整理番号_不一致,
                対象年度.toString(), 連絡票整理番号.toString(), 先頭3桁.toString()),
        検索条件_連絡票整理番号不一致_先頭6桁目から11桁目(DbcErrorMessages.支給申請書整理番号_不一致,
                証記載保険者番号.toString(), 連絡票整理番号.toString(), 先頭6桁目から11桁目.toString());
        private final Message message;

        ChoteiboSakuseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    /**
     * 決定情報を保存する入力値チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check決定情報保存() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (不支給.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())
                && (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().getValue() == null
                || div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須, 不支給選択時_不支給理由.toString())));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtTaishoNendo().getValue() != null
                && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue() != null
                && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue() != null) {
            boolean flag1 = 定値_年度年度1.getYear().equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtTaishoNendo().getValue().getYear())
                    && !(定値_開始計算対象期間1.isBeforeOrEquals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue())
                    && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue().isBeforeOrEquals(定値_終了計算対象期間1));
            RDate 対象年度日付 = new RDate(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().getYear().toDateString().concat(定値_日付2).toString());
            RDate 翌対象年度日付 = new RDate(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().getYear().plusYear(1).toDateString().concat(定値_日付3).toString());
            boolean flag2 = 定値_年度年度2.getYear().isBeforeOrEquals(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtTaishoNendo().getValue().getYear())
                    && !(対象年度日付.isBeforeOrEquals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue())
                    && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue().isBeforeOrEquals(翌対象年度日付));
            if (flag1 || flag2) {
                validPairs.add(new ValidationMessageControlPair(
                        new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                                UrErrorMessages.項目に対する制約, 計算期間.toString(), 対象年度内.toString())));
            }
        }
        check決定情報(validPairs);
        return validPairs;
    }

    /**
     * データ存在チェックです。
     *
     * @param 受給者台帳データ 受給者台帳データ
     * @param 総合事業対象者データ 総合事業対象者データ
     * @return IValidationMessages
     */
    public ValidationMessageControlPairs getデータ存在チェック(List<JukyushaDaicho> 受給者台帳データ, List<SogoJigyoTaishosha> 総合事業対象者データ) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            if ((受給者台帳データ == null || 受給者台帳データ.isEmpty())
                    && (総合事業対象者データ == null || 総合事業対象者データ.isEmpty())) {
                validPairs.add(new ValidationMessageControlPair(
                        new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(DbdErrorMessages.受給共通_受給者_事業対象者登録なし)));
            }
        } else if (受給者台帳データ == null || 受給者台帳データ.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(DbcInformationMessages.被保険者でないデータ)));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs check決定情報(ValidationMessageControlPairs validPairs) {
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getValue() != null
                && !div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getValue().isEmpty()
                && !RStringUtil.isHalfsizeNumberOnly(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtJikoFutanSeiriNo().getValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.入力値が不正_追加メッセージあり, 負担額証明書整理番号.toString())));
            return validPairs;
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getValue() != null
                && !div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getValue().isEmpty()
                && NUM_TWENTY != div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtJikoFutanSeiriNo().getValue().length()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.桁数が不正, 自己負担額証明書整理番号.toString(), TWENTY.toString())));
            return validPairs;
        }
        if (支給.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getRadShikyuKubunCode().getSelectedValue()) && ((div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtShikyugaku().getValue() != null && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtShikyugaku().getValue().compareTo(Decimal.ONE) < 0)
                || (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue() == null))) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.未入力, 支給指定時は支給金額.toString())));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue() != null
                && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue() != null
                && div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue().isBefore(
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuGassanShikyuKetteiHoseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.入力値が不正_追加メッセージあり, 日付の指定に誤りがあります.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
