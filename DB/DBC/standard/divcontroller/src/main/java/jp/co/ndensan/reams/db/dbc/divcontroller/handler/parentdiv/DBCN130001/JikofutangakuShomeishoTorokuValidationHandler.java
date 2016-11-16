/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 事業分自己負担額証明書登録（単）のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JikofutangakuShomeishoTorokuValidationHandler {

    private final JikofutangakuShomeishoTorokuDiv div;

    private static final int 桁数_17 = 17;
    private static final int 桁数_4 = 4;
    private static final int INDEX_3 = 3;
    private static final RString 平成26年度 = new RString("426");
    private static final RString STATUS_修正 = new RString("修正");

    /**
     * 初期化です。
     *
     * @param div JikofutangakuShomeishoTorokuDiv
     */
    public JikofutangakuShomeishoTorokuValidationHandler(JikofutangakuShomeishoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 新規追加処理を行うために必要な項目のチェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 新規追加空白チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        RString 対象年度 = div.getDdlShinkiTaishoNendo().getSelectedKey();
        if (RString.isNullOrEmpty(対象年度)) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.必須項目), div.getDdlShinkiTaishoNendo()));
        }

        RString 証記載保険者番号 = div.getTxtShinkiTuikaShokisaiHokenshaNo().getValue();
        if (RString.isNullOrEmpty(証記載保険者番号)) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.必須項目), div.getTxtShinkiTuikaShokisaiHokenshaNo()));
        }

        RString 支給申請書整理番号 = div.getTxtShinkiShikyuShinseishoSeiriNo().getValue();
        if (RString.isNullOrEmpty(支給申請書整理番号)) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.必須項目), div.getTxtShinkiShikyuShinseishoSeiriNo()));
        }
        return validPairs;
    }

    /**
     * 新規追加処理を行うために必要な項目の妥当性チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 新規追加妥当性チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 対象年度 = div.getDdlShinkiTaishoNendo().getSelectedKey();
        if (対象年度.compareTo(平成26年度) < 0) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.項目に対する制約, "対象年度", "平成26年度以降"), div.getDdlShinkiTaishoNendo()));
        }

        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurityJoho != null) {
            DonyuKeitaiCode 導入形態コード = shichosonSecurityJoho.get導入形態コード();
            RString 証記載保険者番号 = div.getTxtShinkiTuikaShokisaiHokenshaNo().getValue();
            if (DonyuKeitaiCode.事務単一.equals(導入形態コード) && !証記載保険者番号.equals(shichosonSecurityJoho.get市町村情報().get証記載保険者番号().value())) {
                validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "妥当な証記載保険者番号ではありません。"),
                        div.getTxtShinkiTuikaShokisaiHokenshaNo()));
            } else if (DonyuKeitaiCode.事務広域.equals(導入形態コード) || DonyuKeitaiCode.事務構成市町村.equals(導入形態コード)) {
                check証記載保険者番号(validPairs, 証記載保険者番号);
            }
        }

        RString 支給申請書整理番号 = div.getTxtShinkiShikyuShinseishoSeiriNo().getValue();
        if (支給申請書整理番号.length() != 桁数_17) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.桁数が不正, "支給申請書整理番号", String.valueOf(桁数_17)),
                    div.getTxtShinkiShikyuShinseishoSeiriNo()));
        }
        if (!div.getDdlShinkiTaishoNendo().getSelectedKey().equals(支給申請書整理番号.substring(0, INDEX_3))) {
            RStringBuilder 追加メッセージ = new RStringBuilder();
            追加メッセージ.append(new RString("申請書管理番号の先頭3桁は、"));
            追加メッセージ.append(div.getDdlShinkiTaishoNendo().getSelectedKey());
            追加メッセージ.append(new RString("（"));
            追加メッセージ.append(div.getDdlShinkiTaishoNendo().getSelectedValue());
            追加メッセージ.append(new RString("）でなければならない"));
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, 追加メッセージ.toString()),
                    div.getTxtShinkiShikyuShinseishoSeiriNo()));
        }
        return validPairs;
    }

    private void check証記載保険者番号(ValidationMessageControlPairs validPairs, RString 証記載保険者番号) {
        List<KoseiShichoson> list = KoikiShichosonJohoFinder.createInstance().getKoseiShichosonList().records();
        boolean is存在 = false;
        for (KoseiShichoson koseiShichoson : list) {
            if (証記載保険者番号.equals(koseiShichoson.get証記載保険者番号().value())) {
                is存在 = true;
            }
        }
        if (!is存在) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, "妥当な証記載保険者番号ではありません。"),
                    div.getTxtShinkiTuikaShokisaiHokenshaNo()));
        }
    }

    /**
     * 検索処理を行うために必要な項目の妥当性チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 検索チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 対象年度 = div.getDdlKoshinTaishoNendo().getSelectedKey();
        if (対象年度.compareTo(平成26年度) < 0) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(
                    UrErrorMessages.項目に対する制約, "対象年度", "平成26年度以降"), div.getDdlKoshinTaishoNendo()));
        }

        return validPairs;
    }

    /**
     * 検索対象データなし。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 検索対象データなし() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(UrErrorMessages.対象データなし)));
        return validPairs;
    }

    /**
     * DB更新チェック処理です。
     *
     * @param is変更 boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 更新処理チェック(boolean is変更) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 保険者コード = div.getCcdTennyumaeHokensha().getHokenjaNo();
        RString 保険者名 = div.getCcdTennyumaeHokensha().getHokenjaName();
        if (RString.isNullOrEmpty(保険者コード) || RString.isNullOrEmpty(保険者名)) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(UrErrorMessages.必須項目)));
        }

        if (STATUS_修正.equals(div.getExecutionStatus()) && !is変更) {
            validPairs.add(new ValidationMessageControlPair(new ValidationCheckMessages(UrErrorMessages.編集なしで更新不可)));
        }

        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RString 対象年度 = txtTorokuTaishoNendo.substring(0, 桁数_4);
        RStringBuilder 対象年度_FROM = new RStringBuilder();
        RStringBuilder 対象年度_TO = new RStringBuilder();
        対象年度_FROM.append(対象年度);
        対象年度_TO.append(対象年度);
        if (対象年度.contains(new RString("年"))) {
            対象年度_FROM.append(new RString("8月1日"));
            対象年度_TO.append(new RString("7月31日"));
        } else {
            対象年度_FROM.append(new RString("年8月1日"));
            対象年度_TO.append(new RString("年7月31日"));
        }
        RDate 対象年度_開始 = new RDate(対象年度_FROM.toString());
        RDate 対象年度_終了 = new RDate(対象年度_TO.toString()).plusYear(1);

        RDate txtTaishoKikanFrom = div.getTxtTaishoKikan().getFromValue();
        RDate txtTaishoKikanTo = div.getTxtTaishoKikan().getToValue();
        if (!(対象年度_開始.isBeforeOrEquals(txtTaishoKikanFrom)
                && txtTaishoKikanFrom.isBefore(txtTaishoKikanTo)
                && txtTaishoKikanTo.isBeforeOrEquals(対象年度_終了))) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(UrErrorMessages.項目に対する制約, "計算対象期間", "対象年度内"), div.getTxtTaishoKikan()));
        }

        RString 住所TXT = div.getTxtRenrakusakiJusho().getValue();
        if (!RStringUtil.is全角Only(住所TXT)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(UrErrorMessages.使用不可文字), div.getTxtRenrakusakiJusho()));
        }

        RString 連絡先名1TXT = div.getTxtRenrakusakiMei1().getValue();
        if (!RStringUtil.is全角Only(連絡先名1TXT)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(UrErrorMessages.使用不可文字), div.getTxtRenrakusakiMei1()));
        }

        RString 連絡先名2TXT = div.getTxtRenrakusakiMei2().getValue();
        if (!RStringUtil.is全角Only(連絡先名2TXT)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(UrErrorMessages.使用不可文字), div.getTxtRenrakusakiMei2()));

        }

        Decimal jikofutangakuGokei = nullToZero(div.getTxtJikofutangaku8().getValue())
                .add(nullToZero(div.getTxtJikofutangaku9().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku10().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku11().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku12().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku1().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku2().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku3().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku4().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku5().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku6().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku7().getValue()));

        if (!jikofutangakuGokei.equals(nullToZero(div.getTxtJikofutangakuGokei().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(DbcErrorMessages.合計ボタン未押下),
                    div.getTxtJikofutangakuGokei()));
        }
        Decimal uchiFutangakuGokei = nullToZero(div.getTxtUchiFutangaku8().getValue())
                .add(nullToZero(div.getTxtUchiFutangaku9().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku10().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku11().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku12().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku1().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku2().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku3().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku4().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku5().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku6().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku7().getValue()));

        if (!uchiFutangakuGokei.equals(nullToZero(div.getTxtUchiFutangakuGokei().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new ValidationCheckMessages(DbcErrorMessages.合計ボタン未押下),
                    div.getTxtUchiFutangakuGokei()));
        }

        return validPairs;
    }

    private Decimal nullToZero(Decimal obj) {
        if (obj == null) {
            return Decimal.ZERO;
        } else {
            return obj;
        }
    }

    private static class ValidationCheckMessages implements IValidationMessage {

        private final Message message;

        public ValidationCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
