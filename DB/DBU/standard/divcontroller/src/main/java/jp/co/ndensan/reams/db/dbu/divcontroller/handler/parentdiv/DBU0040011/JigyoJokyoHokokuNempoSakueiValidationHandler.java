/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.message.DbuErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiDiv;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 境界層該当者台帳管理画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBU-5600-010 linghuhang
 */
public class JigyoJokyoHokokuNempoSakueiValidationHandler {

    private final JigyoJokyoHokokuNempoSakueiDiv div;
    private static final int INT_ZERO = 0;
    private static final int INT_ITTI = 1;
    private static final int INT_NI = 2;
    private static final int INT_YOU = 4;
    private static final int INT_JUSAN = 13;
    private static final int INT_HYAKU = 100;
    private static final int INT_1988 = 1988;
    private static final RString 旧市町村分KEY = new RString("kyuShichoson");
    private static final RString 構成市町村分KEY = new RString("koseiShichoson");
    private static final RString 集計開始日期 = new RString("200904");
    private static final RString 年報報告様式12KEY = new RString("yoshiki12");
    private static final RString 年報報告一般状況111KEY = new RString("ippan1_11");
    private static final RString 年報報告一般状況1214現物分KEY = new RString("ippan12_14Genbutsu");
    private static final RString 年報報告保険給付決定現物分KEY = new RString("hokenKyufuGenbutsu");
    private static final RString 年報報告一般状況1214償還分KEY = new RString("ippan12_14Shokan");
    private static final RString 年報報告一般状況償還分KEY = new RString("hokenKyufuShokan");
    private static final RString 年報報告一般状況高額分KEY = new RString("hokenKyufuKogaku");
    private static final RString 年報報告一般状況高額合算分KEY = new RString("hokenKyufuKogakuGassan");
    private static final RString メッセージ内容 = new RString("事業状況報告（月報）：");

    /**
     * コンストラクタです。
     *
     * @param div 事業状況報告（年報）Div
     */
    public JigyoJokyoHokokuNempoSakueiValidationHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param is合併市町村 is合併市町村
     * @param is広域市町村 is広域市町村
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(boolean is合併市町村, boolean is広域市町村) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!RString.isNullOrEmpty(div.getRadJikkoTaniShukeiOnly().getSelectedKey())
                || !RString.isNullOrEmpty(div.getRadJikkoTani2().getSelectedKey())) {
            doチェック(validPairs);
        }
        if (!RString.isNullOrEmpty(div.getRadJikkoTani3().getSelectedKey())
                && RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.過去報告年月の必須入力チェック, div.getDdlKakoHokokuNendo()));
        }
        if (((is合併市町村 && 旧市町村分KEY.equals(div.getRadGappeiShichoson().getSelectedKey()))
                || (is広域市町村 && 構成市町村分KEY.equals(div.getRadKoikiRengo().getSelectedKey())))
                && RString.isNullOrEmpty(div.getShichosonList())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.市町村コードのチェック));
        }
        do保険給付決定状況_高額合算分(validPairs);
        do作成日付チェック(validPairs);
        do出力対象チェック(validPairs);
        return validPairs;
    }

    /**
     * 月報未処理のチックを実行する。
     *
     * @param 処理日付管理情報 処理日付管理情報
     * @param 処理名 処理名
     * @param 報告開始年月 報告開始年月
     * @param 報告終了年月 報告終了年月
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check月報未処理(
            List<ShoriDateKanri> 処理日付管理情報, RString 処理名, RString 報告開始年月, RString 報告終了年月) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RStringBuilder builder = new RStringBuilder();
        builder.append(メッセージ内容).append(処理名).append(new RString("<br>"));
        int year = Integer.parseInt(報告開始年月.substring(INT_ZERO, INT_YOU).toString());
        List<RString> ym = new ArrayList();
        if (Integer.parseInt(報告開始年月.toString()) < Integer.parseInt(報告終了年月.toString())) {
            for (int i = Integer.parseInt(報告開始年月.toString()); i <= Integer.parseInt(報告終了年月.toString()); i++) {
                if (i == year * INT_HYAKU + INT_JUSAN) {
                    i = (year + INT_ITTI) * INT_HYAKU + INT_ITTI;
                }
                ym.add(new RString(i));
            }
            for (RString 年日付 : ym) {
                boolean flag = false;
                for (ShoriDateKanri 処理日付管理 : 処理日付管理情報) {
                    RString 処理日付 = 処理日付管理.get年度().seireki().getYear().concat(処理日付管理.get処理枝番().substring(INT_NI));
                    if (年日付.equals(処理日付)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    builder.append(toWareki(年日付)).append(new RString(":"));
                }
            }
            if (処理日付管理情報 == null || 処理日付管理情報.isEmpty() || 処理日付管理情報.size() < ym.size()) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(DbuErrorMessages.月報全て未処理, builder.toString().substring(INT_ZERO, builder.lastIndexOf(":")))));
            }
        }
        return validPairs;
    }

    private String toWareki(RString 処理日付) {
        int year = Integer.parseInt(処理日付.toString().substring(INT_ZERO, INT_YOU));
        RString month = new RString(処理日付.toString().substring(INT_YOU));
        return new RString(year - INT_1988).insert(0, "平").concat("." + month).toString();
    }

    /**
     * 月報未処理のチックを実行する。
     *
     * @param validPairs validPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check月報未処理(ValidationMessageControlPairs validPairs) {
        if (validPairs == null) {
            validPairs = new ValidationMessageControlPairs();
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(メッセージ内容).append(new RString("出力対象名（全ての年月）")).append(new RString("<br>"));
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(DbuErrorMessages.月報全て未処理, builder.toString())));
        return validPairs;
    }

    /**
     * DBUE00006 「出力対象の指定を確認してください。」
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check出力対象の指定を確認() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbuErrorMessages.出力対象未選択)));
        return validPairs;
    }

    private void doチェック(ValidationMessageControlPairs validPairs) {
        if (RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.報告年度の必須入力チェック, div.getDdlHokokuNendo()));
        }
        if (RString.isNullOrEmpty(div.getDdlShukeiFromYM().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.報告開始年月の必須入力チェック, div.getDdlShukeiFromYM()));
        }
        if (RString.isNullOrEmpty(div.getDdlShukeiToYM().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.報告終了年月の必須入力チェック, div.getDdlShukeiToYM()));
        }
        if (!RString.isNullOrEmpty(div.getDdlShukeiFromYM().getSelectedKey()) && !RString.isNullOrEmpty(div.getDdlShukeiToYM().getSelectedKey())) {
            int 終了日 = Integer.parseInt(get報告年月(div.getDdlShukeiToYM()).toString());
            int 開始日 = Integer.parseInt(get報告年月(div.getDdlShukeiFromYM()).toString());
            if (終了日 < 開始日) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.報告開始年月と報告終了年月の範囲チェック, div.getDdlShukeiFromYM(), div.getDdlShukeiToYM()));
            }
        }
    }

    private RString get報告年月(DropDownList list) {
        RString 報告年度 = new RString(div.getDdlHokokuNendo().getSelectedKey().toString());
        RString 報告月 = new RString(list.getSelectedKey().toString());
        int year = Integer.parseInt(報告年度.toString());
        int month = Integer.parseInt(報告月.toString());
        if (month < INT_YOU) {
            year = year + INT_ITTI;
            報告年度 = new RString(year);
        }
        return 報告年度.concat(報告月);
    }

    private void do保険給付決定状況_高額合算分(ValidationMessageControlPairs validPairs) {
        if (div.getCblShutsuryokuTaishoHokenKogakuGassan().getSelectedKeys().contains(年報報告一般状況高額合算分KEY)) {
            if (div.getTxtShukeiFromYM8().getValue() == null || div.getTxtShukeiFromYM8().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.集計開始年月の必須入力チェック, div.getTxtShukeiFromYM8()));
            }
            if (div.getTxtShukeiToYM8().getValue() == null || div.getTxtShukeiToYM8().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.集計終了年月の必須入力チェック, div.getTxtShukeiToYM8()));
            }
            if (div.getTxtShukeiFromYM8().getValue() != null && !div.getTxtShukeiFromYM8().getValue().isEmpty()
                    && div.getTxtShukeiToYM8().getValue() != null && !div.getTxtShukeiToYM8().getValue().isEmpty()
                    && div.getTxtShukeiToYM8().getValue().isBefore(div.getTxtShukeiFromYM8().getValue())) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.集計開始年月と集計終了年月の範囲チェック,
                        div.getTxtShukeiFromYM8(), div.getTxtShukeiToYM8()));
            }
            if (div.getTxtShukeiFromYM8().getValue() != null && !div.getTxtShukeiFromYM8().getValue().isEmpty()
                    && div.getTxtShukeiFromYM8().getValue().getYearMonth().isBefore(new FlexibleYearMonth(集計開始日期))) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.集計開始年月の範囲チェック, div.getTxtShukeiFromYM8()));
            }
        }
    }

    private void do作成日付チェック(ValidationMessageControlPairs validPairs) {
        if (div.getCblShutsuryokuTaishoYoshiki1().getSelectedKeys().contains(年報報告様式12KEY)) {
            if (div.getTxtSakuseiYMD1().getValue() == null || div.getTxtSakuseiYMD1().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD1()));
            }
            if (div.getTxtSakuseiTime1().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime1()));
            }
        }
        if (div.getCblShutsuryokuTaishoIppan1to11().getSelectedKeys().contains(年報報告一般状況111KEY)) {
            if (div.getTxtSakuseiYMD2().getValue() == null || div.getTxtSakuseiYMD2().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD2()));
            }
            if (div.getTxtSakuseiTime2().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime2()));
            }
        }
        if (div.getCblShutsuryokuTaishoIppanGembutsu().getSelectedKeys().contains(年報報告一般状況1214現物分KEY)) {
            if (div.getTxtSakuseiYMD3().getValue() == null || div.getTxtSakuseiYMD3().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD3()));
            }
            if (div.getTxtSakuseiTime3().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime3()));
            }
        }
        if (div.getCblShutsuryokuTaishoHokenGembutsu().getSelectedKeys().contains(年報報告保険給付決定現物分KEY)) {
            if (div.getTxtSakuseiYMD4().getValue() == null || div.getTxtSakuseiYMD4().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD4()));
            }
            if (div.getTxtSakuseiTime4().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime4()));
            }
        }
        check作成日付(validPairs);
    }

    private void check作成日付(ValidationMessageControlPairs validPairs) {
        if (div.getCblShutsuryokuTaishoIppanShokan().getSelectedKeys().contains(年報報告一般状況1214償還分KEY)) {
            if (div.getTxtSakuseiYMD5().getValue() == null || div.getTxtSakuseiYMD5().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD5()));
            }
            if (div.getTxtSakuseiTime5().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime5()));
            }
        }
        if (div.getCblShutsuryokuTaishoHokenShokan().getSelectedKeys().contains(年報報告一般状況償還分KEY)) {
            if (div.getTxtSakuseiYMD6().getValue() == null || div.getTxtSakuseiYMD6().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD6()));
            }
            if (div.getTxtSakuseiTime6().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime6()));
            }
        }
        if (div.getCblShutsuryokuTaishoHokenKogaku().getSelectedKeys().contains(年報報告一般状況高額分KEY)) {
            if (div.getTxtSakuseiYMD7().getValue() == null || div.getTxtSakuseiYMD7().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD7()));
            }
            if (div.getTxtSakuseiTime7().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime7()));
            }
        }
        if (div.getCblShutsuryokuTaishoHokenKogakuGassan().getSelectedKeys().contains(年報報告一般状況高額合算分KEY)) {
            if (div.getTxtSakuseiYMD8().getValue() == null || div.getTxtSakuseiYMD8().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成日付の必須入力チェック, div.getTxtSakuseiYMD8()));
            }
            if (div.getTxtSakuseiTime8().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.作成時刻の必須入力チェック, div.getTxtSakuseiTime8()));
            }
        }

    }

    private void do出力対象チェック(ValidationMessageControlPairs validPairs) {
        if ((div.getCblShutsuryokuTaishoYoshiki1().getSelectedKeys() == null || div.getCblShutsuryokuTaishoYoshiki1().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoIppan1to11().getSelectedKeys() == null || div.getCblShutsuryokuTaishoIppan1to11().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoIppanGembutsu().getSelectedKeys() == null || div.getCblShutsuryokuTaishoIppanGembutsu().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoHokenGembutsu().getSelectedKeys() == null || div.getCblShutsuryokuTaishoHokenGembutsu().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoIppanShokan().getSelectedKeys() == null || div.getCblShutsuryokuTaishoIppanShokan().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoHokenShokan().getSelectedKeys() == null || div.getCblShutsuryokuTaishoHokenShokan().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoHokenKogaku().getSelectedKeys() == null || div.getCblShutsuryokuTaishoHokenKogaku().getSelectedKeys().isEmpty())
                && (div.getCblShutsuryokuTaishoHokenKogakuGassan().getSelectedKeys() == null || div.getCblShutsuryokuTaishoHokenKogakuGassan().getSelectedKeys().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.出力対象チェック,
                    div.getCblShutsuryokuTaishoYoshiki1(),
                    div.getCblShutsuryokuTaishoIppan1to11(),
                    div.getCblShutsuryokuTaishoIppanGembutsu(),
                    div.getCblShutsuryokuTaishoHokenGembutsu(),
                    div.getCblShutsuryokuTaishoIppanShokan(),
                    div.getCblShutsuryokuTaishoHokenShokan(),
                    div.getCblShutsuryokuTaishoHokenKogaku(),
                    div.getCblShutsuryokuTaishoHokenKogakuGassan()));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        報告年度の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "報告年度"),
        報告開始年月の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "報告開始年月"),
        報告終了年月の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "報告終了年月"),
        報告開始年月と報告終了年月の範囲チェック(UrErrorMessages.終了日が開始日以前),
        過去報告年月の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "過去報告年月"),
        市町村コードのチェック(UrErrorMessages.必須項目_追加メッセージあり, "対象市町村"),
        集計開始年月の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "集計開始年月"),
        集計終了年月の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "集計終了年月"),
        集計開始年月の日付チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "集計開始年月"),
        集計終了年月の日付チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "集計終了年月"),
        集計開始年月と集計終了年月の範囲チェック(UrErrorMessages.終了日が開始日以前),
        集計開始年月の範囲チェック(DbuErrorMessages.開始日不正, "平成21年4月"),
        作成日付の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "作成日付"),
        作成時刻の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "作成時刻"),
        作成日付の日付チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "作成日付"),
        作成時刻の時刻チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "作成時刻"),
        出力対象チェック(DbuErrorMessages.出力対象未選択);

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
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
