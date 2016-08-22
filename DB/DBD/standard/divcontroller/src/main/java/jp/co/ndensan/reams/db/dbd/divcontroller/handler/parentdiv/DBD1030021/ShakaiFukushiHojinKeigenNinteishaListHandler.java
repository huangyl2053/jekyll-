/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030021;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT00004.DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.shafuku.ChushutsuTaisho;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030021.ShakaiFukushiHojinKeigenNinteishaListDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 社会福祉法人軽減認定者リストハンドラクラスです。
 *
 * @reamsid_L DBD-3830-010 tianyh
 */
public class ShakaiFukushiHojinKeigenNinteishaListHandler {

    private final ShakaiFukushiHojinKeigenNinteishaListDiv div;
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_7 = 7;
    private static final int NO_9 = 9;
    private static final int NO_10 = 10;
    private static final int NO_30 = 30;
    private static final int NO_31 = 31;
    private static final int 平17 = 2005;
    private static final int 平18 = 2006;
    private static final RString 平11年 = new RString("1999");
    private static final RString 平12年 = new RString("2000");
    private static final RString 平16年 = new RString("2004");
    private static final RString 平17年 = new RString("2005");
    private static final RString 旧措置者区分入力項目 = new RString("旧措置者区分");
    private static final RString 世帯表示入力項目 = new RString("世帯表示");
    private static final RString 所得年度入力項目 = new RString("所得年度");
    private static final RString 課税判定等基準日入力項目 = new RString("課税判定等基準日");
    private static final RString 対象年度入力項目 = new RString("対象年度");
    private static final RString 基準日入力項目 = new RString("基準日");
    private static final RString 受給者区分入力項目 = new RString("受給者区分");
    private final FlexibleYear システム日付の年度 = new FlexibleYear(RDate.getNowDate().getYear().toDateString());

    /**
     * コンストラクタです。
     *
     * @param div ShakaiFukushiHojinKeigenNinteishaListDiv
     */
    public ShakaiFukushiHojinKeigenNinteishaListHandler(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     */
    public void onLoad() {
        div.getCcdChohyoShuturyokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200004.getReportId());
        ShakaiFukushiHojinKeigenNinteishaListHandler shakaifukushi = new ShakaiFukushiHojinKeigenNinteishaListHandler(div);
        div.getTxtTaishoYM().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getTxtKijunYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getTxtShotokuNendo().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        Range<FlexibleDate> range = shakaifukushi.estimate対象期間(システム日付の年度, Boolean.TRUE, null);
        div.getRadJukyushaKubun().setDisplayNone(true);
        div.getChkShoriTaisho().setDisplayNone(true);
        div.getChkNinteishaNomi().setDisplayNone(false);
        div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
        div.getTxtTaishoKikanShuryo().setValue(range.getTo());
    }

    /**
     * 「「認定者リスト」ラジオと「該当者リスト」ラジオの変更」の処理です。
     */
    public void radTaishoList_onchange() {
        if (div.getRadTaishoList().getSelectedIndex() == NO_0) {
            div.getRadJukyushaKubun().setDisplayNone(true);
            div.getChkShoriTaisho().setDisplayNone(true);
            div.getChkNinteishaNomi().setDisplayNone(false);
        } else {
            div.getRadJukyushaKubun().setDisplayNone(false);
            div.getChkShoriTaisho().setDisplayNone(false);
            div.getChkNinteishaNomi().setDisplayNone(true);
            div.getRadJukyushaKubun().setSelectedIndex(NO_0);
        }
    }

    /**
     * 「対象年度」ラジオと「基準日」ラジオの変更」の処理です。
     */
    public void radTaishoKikanShitei_onchange() {
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_0) {
            div.getTxtKijunYMD().setDisplayNone(true);
            div.getTxtTaishoYM().setDisplayNone(false);
            div.getTxtTaishoKikanKaishi().setDisplayNone(false);
            div.getTxtTaishoKikanShuryo().setDisplayNone(false);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(false);
            div.getLblTaishoKikan().setDisplayNone(false);
            if (div.getRadTaishoList().getSelectedIndex() == NO_0) {
                set認定者(div);
            } else {
                set該当者(div);
            }
        }
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_1) {
            div.getRadHeisei17NendoSeidoKaisei().setDisplayNone(true);
            div.getTxtKijunYMD().setDisplayNone(false);
            div.getTxtTaishoYM().setDisplayNone(true);
            div.getTxtTaishoKikanKaishi().setDisplayNone(true);
            div.getTxtTaishoKikanShuryo().setDisplayNone(true);
            div.getTxtKazeiHanteiToKijunDate().setDisplayNone(true);
            div.getLblTaishoKikan().setDisplayNone(true);
        }
    }

    /**
     * 「対象年度」の変更」の処理です。
     */
    public void taishoYM_onchange() {
        Boolean 認定者リスト = false;
        Boolean 軽減 = false;
        if (div.getRadTaishoList().getSelectedIndex() == NO_0) {
            認定者リスト = true;
        }
        if (div.getRadHeisei17NendoSeidoKaisei().getSelectedIndex() == NO_0) {
            軽減 = true;
        }
        ShakaiFukushiHojinKeigenNinteishaListHandler shakaifukushi = new ShakaiFukushiHojinKeigenNinteishaListHandler(div);
        FlexibleYear flexibleyear = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
        Range<FlexibleDate> range = shakaifukushi.estimate対象期間(flexibleyear, 認定者リスト, 軽減);
        div.getTxtTaishoKikanKaishi().setValue(range.getFrom());
        div.getTxtTaishoKikanShuryo().setValue(range.getTo());
    }

    /**
     * 社会福祉法人軽減認定者リスト作成バッチ用パラメータを作成する
     *
     * @return DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter
     */
    public DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter createParameter() {
        DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter batchParameter = new DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter();
        RString 対象リスト;
        RString 対象期間指定;
        FlexibleDate 対象年度の開始年月日 = new FlexibleDate("");
        FlexibleDate 対象年度の終了年月日 = new FlexibleDate("");
        FlexibleYear 所得年度;
        RString 旧措置者区分;
        RString 世帯表示;
        FlexibleDate 基準日 = new FlexibleDate("");
        RString 受給者区分;
        ArrayList<RString> 世帯非課税等 = new ArrayList<>();
        RString 抽出対象;
        ArrayList<RString> 出力設定 = new ArrayList<>();
        long 改頁出力順ID;
        RString 帳票ID;
        FlexibleDate 課税判定等基準日;

        if (div.getRadTaishoList().getSelectedIndex() == NO_0) {
            対象リスト = TargetList.認定者リスト.getコード();
            帳票ID = new RString("DBD200015_ShakaiFukushiHojinKeigenNinteishaIchiran");
            batchParameter.set帳票ID(帳票ID);
            batchParameter.set対象リスト(対象リスト);
        } else {
            対象リスト = TargetList.該当者リスト.getコード();
            帳票ID = new RString("DBD200004_ShakaiFukushiHojinKeigenGaitoshaIchiran");
            batchParameter.set帳票ID(帳票ID);
            batchParameter.set対象リスト(対象リスト);
        }
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_0) {
            対象期間指定 = TaishoKikan.対象年度.getコード();
            対象年度の開始年月日 = div.getTxtTaishoKikanKaishi().getValue();
            対象年度の終了年月日 = div.getTxtTaishoKikanShuryo().getValue();
            課税判定等基準日 = div.getTxtKazeiHanteiToKijunDate().getValue();
        } else {
            対象期間指定 = TaishoKikan.基準日.getコード();
            基準日 = div.getTxtKijunYMD().getValue();
            課税判定等基準日 = div.getTxtKijunYMD().getValue();
        }
        所得年度 = div.getTxtShotokuNendo().getValue().getYear();
        if (div.getRadKyusochishaKubun().getSelectedIndex() == NO_0) {
            旧措置者区分 = KyusochishaJukyushaKubun.両方.getコード();
        } else if (div.getRadKyusochishaKubun().getSelectedIndex() == NO_1) {
            旧措置者区分 = KyusochishaJukyushaKubun.旧措置者のみ.getコード();
        } else {
            旧措置者区分 = KyusochishaJukyushaKubun.旧措置者以外.getコード();
        }
        if (div.getRadSetaiHyoji().getSelectedIndex() == NO_0) {
            世帯表示 = SetaiHyoji.表示する.getコード();
        } else {
            世帯表示 = SetaiHyoji.表示しない.getコード();
        }
        if (div.getRadJukyushaKubun().getSelectedIndex() == NO_0) {
            受給者区分 = JukyushaKubun2.被保険者.getコード();
        } else if (div.getRadJukyushaKubun().getSelectedIndex() == NO_1) {
            受給者区分 = JukyushaKubun2.受給者.getコード();
        } else {
            受給者区分 = JukyushaKubun2.事業対象者.getコード();
        }
        if (div.getChkNinteishaNomi().getSelectedItems().isEmpty()) {
            抽出対象 = ChushutsuTaisho.指定なし.getコード();
        } else {
            抽出対象 = ChushutsuTaisho.認定者のみ.getコード();
        }
        改頁出力順ID = div.getCcdChohyoShuturyokujun().get出力順ID();
        for (int i = 0; i < div.getChkShoriTaisho().getSelectedValues().size(); i++) {
            if (div.getChkShoriTaisho().getSelectedValues().get(i).equals(new RString("市町村民税非課税世帯"))) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.市町村民税非課税世帯.getコード());
            }
            if (div.getChkShoriTaisho().getSelectedValues().get(i).equals(new RString("所得税非課税世帯"))) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.所得税非課税世帯.getコード());
            }
            if (div.getChkShoriTaisho().getSelectedValues().get(i).equals(new RString("市町村民税本人非課税者"))) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.市町村民税本人非課税者.getコード());
            }
            if (div.getChkShoriTaisho().getSelectedValues().get(i).equals(new RString("老齢福祉年金受給者"))) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.老齢福祉年金受給者.getコード());
            }
            if (div.getChkShoriTaisho().getSelectedValues().get(i).equals(new RString("生活保護受給者"))) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.生活保護受給者.getコード());
            }
        }
        for (int i = 0; i < div.getChkCsvShutsuryoku().getSelectedValues().size(); i++) {
            if (div.getChkCsvShutsuryoku().getSelectedValues().get(i).equals(new RString("項目名付加"))) {
                出力設定.add(CSVSettings.項目名付加.getコード());
            }
            if (div.getChkCsvShutsuryoku().getSelectedValues().get(i).equals(new RString("連番付加"))) {
                出力設定.add(CSVSettings.連番付加.getコード());
            }
            if (div.getChkCsvShutsuryoku().getSelectedValues().get(i).equals(new RString("日付\"/\"編集"))) {
                出力設定.add(CSVSettings.日付スラッシュ編集.getコード());
            }
        }

        batchParameter.set出力設定(出力設定);
        batchParameter.set世帯表示(世帯表示);
        batchParameter.set世帯非課税等(世帯非課税等);
        batchParameter.set受給者区分(受給者区分);
        batchParameter.set基準日(基準日);
        batchParameter.set対象リスト(対象リスト);
        batchParameter.set対象年度の終了年月日(対象年度の終了年月日);
        batchParameter.set対象年度の開始年月日(対象年度の開始年月日);
        batchParameter.set対象期間指定(対象期間指定);
        batchParameter.set帳票ID(帳票ID);
        batchParameter.set所得年度(所得年度);
        batchParameter.set抽出対象(抽出対象);
        batchParameter.set改頁出力順ID(改頁出力順ID);
        batchParameter.set旧措置者区分(旧措置者区分);
        batchParameter.set課税判定等基準日(課税判定等基準日);
        return batchParameter;
    }

    /**
     * 社会福祉法人軽減認定者リスト作成バッチ用パラメータを作成する
     *
     * @param 年度 FlexibleYear
     * @param is認定者リスト Boolean
     * @param is軽減 Boolean
     * @return Range<FlexibleDate>
     */
    public Range<FlexibleDate> estimate対象期間(FlexibleYear 年度, Boolean is認定者リスト, Boolean is軽減) {
        FlexibleDate 開始年 = new FlexibleDate(RString.EMPTY);
        FlexibleDate 終了年 = new FlexibleDate(RString.EMPTY);
        if (年度.isBeforeOrEquals(new FlexibleYear(平11年))) {
            開始年 = FlexibleDate.EMPTY;
            終了年 = FlexibleDate.EMPTY;
        } else if (年度.isBeforeOrEquals(new FlexibleYear(平12年))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_4, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_5, NO_31);
        } else if (年度.isBeforeOrEquals(new FlexibleYear(平16年))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_6, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_5, NO_31);
        } else if (年度.isBeforeOrEquals(new FlexibleYear(平17年))) {
            if (is認定者リスト && (!is軽減)) {
                開始年 = new FlexibleDate(年度.getYearValue(), NO_6, NO_1);
                終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_9, NO_30);
            } else {
                開始年 = new FlexibleDate(年度.getYearValue(), NO_10, NO_1);
                終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_6, NO_30);
            }
        }
        if (!年度.isBeforeOrEquals(new FlexibleYear(平17年))) {
            開始年 = new FlexibleDate(年度.getYearValue(), NO_7, NO_1);
            終了年 = new FlexibleDate(年度.getYearValue() + NO_1, NO_6, NO_30);
        }
        return new Range<>(開始年, 終了年);
    }

    /**
     * バッチ実行前チェックを行う
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs バッチ実行前チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getRadKyusochishaKubun().getSelectedValue() == null || div.getRadKyusochishaKubun().getSelectedValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 旧措置者区分入力項目.toString())));
        }
        if (div.getRadSetaiHyoji().getSelectedValue() == null || div.getRadSetaiHyoji().getSelectedValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 世帯表示入力項目.toString())));
        }
        if (div.getTxtShotokuNendo().getValue() == null || div.getTxtShotokuNendo().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 所得年度入力項目.toString())));
        }
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_0
                && (div.getTxtKijunYMD().getValue() == null || div.getTxtKijunYMD().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 課税判定等基準日入力項目.toString())));
        }
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_0
                && (div.getTxtTaishoYM().getValue() == null || div.getTxtTaishoYM().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 対象年度入力項目.toString())));
        }
        if (div.getRadTaishoKikanShitei().getSelectedIndex() == NO_1
                && (div.getTxtKijunYMD().getValue() == null || div.getTxtKijunYMD().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 基準日入力項目.toString())));
        }
        if ((div.getRadTaishoList().getSelectedIndex() == NO_1)
                && (div.getRadJukyushaKubun().getSelectedValue() == null || div.getRadJukyushaKubun().getSelectedValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShakaiFukushiHojinKeigenNinteishaListHandler.IdocheckMessages(UrErrorMessages.必須項目, 受給者区分入力項目.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private void set認定者(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        div.getRadHeisei17NendoSeidoKaisei().setDisplayNone(true);
        FlexibleYear flexibleyear = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
        if ((flexibleyear.isBeforeOrEquals(new FlexibleYear(平17年))) && !(flexibleyear.isBeforeOrEquals(new FlexibleYear(平16年)))) {
            div.getRadHeisei17NendoSeidoKaisei().setDisplayNone(false);
            if (div.getRadHeisei17NendoSeidoKaisei().getSelectedIndex() == NO_0) {
                div.getTxtTaishoKikanKaishi().setValue(new FlexibleDate(平17, NO_10, NO_1));
                div.getTxtTaishoKikanShuryo().setValue(new FlexibleDate(平18, NO_6, NO_30));
            }
            if (div.getRadHeisei17NendoSeidoKaisei().getSelectedIndex() == NO_1) {
                div.getTxtTaishoKikanKaishi().setValue(new FlexibleDate(平17, NO_6, NO_1));
                div.getTxtTaishoKikanShuryo().setValue(new FlexibleDate(平17, NO_9, NO_30));
            }
        } else {
            div.getRadHeisei17NendoSeidoKaisei().setDisplayNone(true);
            div.getTxtTaishoKikanKaishi().setValue(new FlexibleDate(flexibleyear.getYearValue(), NO_6, NO_1));
            div.getTxtTaishoKikanShuryo().setValue(new FlexibleDate(flexibleyear.getYearValue() + NO_1, NO_5, NO_31));
        }
    }

    private void set該当者(ShakaiFukushiHojinKeigenNinteishaListDiv div) {
        div.getRadHeisei17NendoSeidoKaisei().setDisplayNone(true);
        FlexibleYear flexibleyear = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
        if (flexibleyear.isBeforeOrEquals(new FlexibleYear(平17年))) {
            div.getTxtTaishoKikanKaishi().setValue(new FlexibleDate(平17, NO_10, NO_1));
            div.getTxtTaishoKikanShuryo().setValue(new FlexibleDate(平18, NO_6, NO_30));
        } else {
            div.getTxtTaishoKikanKaishi().setValue(new FlexibleDate(flexibleyear.getYearValue(), NO_6, NO_1));
            div.getTxtTaishoKikanShuryo().setValue(new FlexibleDate(flexibleyear.getYearValue() + NO_1, NO_5, NO_31));
        }
    }

}
