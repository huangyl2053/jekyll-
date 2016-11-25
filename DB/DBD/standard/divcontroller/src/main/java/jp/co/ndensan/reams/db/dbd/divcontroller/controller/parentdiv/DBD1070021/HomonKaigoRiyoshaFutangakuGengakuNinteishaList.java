/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1070021;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD202010.DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 訪問介護利用者負担額減額認定者リスト画面バッチ用パラメータクラスを作成する
 *
 * @reamsid_L DBD-3970-040 xuejm
 */
public class HomonKaigoRiyoshaFutangakuGengakuNinteishaList {

    private final DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter bparamt
            = new DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter();
    private static final RString 認定者リスト = new RString("ninteisha");
    private static final RString 対象年度 = new RString("taishoNendo");
    private static final RString 表示する = new RString("hyoji");
    private static final RString 市町村民税非課税世帯 = new RString("shichosonMinzeiHikazeiSetai");
    private static final RString 所得税非課税世帯 = new RString("shotokuzeiHikazeiSetai");
    private static final RString 市町村民税本人非課税者 = new RString("sichosonMinzeiHonninHikazeisha");
    private static final RString 老齢福祉年金受給者 = new RString("roreiFukushiNenkinJukyusha");
    private static final RString 生活保護受給者 = new RString("seikatsuHogoJukyusha");
    private static final RString 項目名付加 = new RString("komokuMeiFuka");
    private static final RString 連番付加 = new RString("renbanFuka");
    private static final RString 日付スラッシュ編集 = new RString("hizukeHenshu");
    private static final RString 被保険者 = new RString("hihokensha");
    private static final RString 受給者 = new RString("jukyusha");
    private static final RString 両方 = new RString("ryoho");
    private static final RString 旧措置者のみ = new RString("kyusochishaNomi");
    private static final RString 平11年 = new RString("1999");
    private static final RString 平12年 = new RString("2000");
    private static final RString KEY0 = new RString("all");
    private static final RString KEY1 = new RString("56");
    private static final RString KEY2 = new RString("57");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_31 = 31;

    /**
     * 訪問介護利用者負担額減額認定者リストコンストラクタです。
     *
     */
    public HomonKaigoRiyoshaFutangakuGengakuNinteishaList() {

    }

    /**
     * バッチパラメータ作成します．
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return 訪問介護利用者負担額減額認定者リスト（画面）バッチパラメター
     */
    public DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter createParameter(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        if (div.getRadTaishoList().getSelectedKey().equals(認定者リスト)) {
            bparamt.set対象リスト(TargetList.認定者リスト);
            set法別区分の設定(div);
            bparamt.set帳票ID(ReportIdDBD.DBD200014.getReportId());
        } else {
            bparamt.set対象リスト(TargetList.該当者リスト);
            set受給者区分の設定(div);
            bparamt.set帳票ID(ReportIdDBD.DBD200003.getReportId());
        }

        FlexibleDate taishokaishi = div.getTxtTaishoKikanKaishi().getValue();
        FlexibleDate taishoshuryo = div.getTxtTaishoKikanShuryo().getValue();
        FlexibleDate kijunymd = new FlexibleDate(div.getTxtKijunYMD().getValue().toDateString());
        FlexibleDate kazeitokijundate = new FlexibleDate(div.getTxtKazeiHanteiToKijunDate().getValue().toDateString());
        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
            bparamt.set対象期間指定(TaishoKikan.対象年度);
            if (div.getTxtTaishoYM().getValue() != null && !div.getTxtTaishoYM().getValue().toDateString().isEmpty()) {
                FlexibleYear taishonendo = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
                bparamt.set対象年度(taishonendo);
            }
            bparamt.set対象年度の開始年月日(taishokaishi);
            bparamt.set対象年度の終了年月日(taishoshuryo);
            bparamt.set課税判定等基準日(kazeitokijundate);

        } else {
            bparamt.set対象期間指定(TaishoKikan.基準日);
            bparamt.set基準日(kijunymd);
            bparamt.set課税判定等基準日(kijunymd);
        }

        if (div.getTxtShotokuNendo().getValue() != null && !div.getTxtShotokuNendo().getValue().toDateString().isEmpty()) {
            FlexibleYear shotokunendo = new FlexibleYear(div.getTxtShotokuNendo().getValue().toString().substring(NO_0, NO_4));
            bparamt.set所得年度(shotokunendo);
        }
        set旧措置区分の設定(div);
        if (div.getRadSetaiHyoji().getSelectedKey().equals(表示する)) {
            bparamt.set世帯表示(SetaiHyoji.表示する);
        } else {
            bparamt.set世帯表示(SetaiHyoji.表示しない);
        }

        ArrayList<HihokenshaKeizaiJokyo> 世帯非課税等 = new ArrayList<>();
        for (int i = 0; i < div.getChkShoriTaisho().getSelectedKeys().size(); i++) {
            if (div.getChkShoriTaisho().getSelectedKeys().get(i).equals(市町村民税非課税世帯)) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.市町村民税非課税世帯);
            }
            if (div.getChkShoriTaisho().getSelectedKeys().get(i).equals(所得税非課税世帯)) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.所得税非課税世帯);
            }
            if (div.getChkShoriTaisho().getSelectedKeys().get(i).equals(市町村民税本人非課税者)) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.市町村民税本人非課税者);
            }
            if (div.getChkShoriTaisho().getSelectedKeys().get(i).equals(老齢福祉年金受給者)) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.老齢福祉年金受給者);
            }
            if (div.getChkShoriTaisho().getSelectedKeys().get(i).equals(生活保護受給者)) {
                世帯非課税等.add(HihokenshaKeizaiJokyo.生活保護受給者);
            }
        }
        bparamt.set世帯非課税等(世帯非課税等);

        ArrayList<CSVSettings> csv出力設定 = new ArrayList<>();
        for (int i = 0; i < div.getChkCsvShutsuryoku().getSelectedKeys().size(); i++) {
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(項目名付加)) {
                csv出力設定.add(CSVSettings.項目名付加);
            }
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(連番付加)) {
                csv出力設定.add(CSVSettings.連番付加);
            }
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(日付スラッシュ編集)) {
                csv出力設定.add(CSVSettings.日付スラッシュ編集);
            }
        }
        bparamt.setCsv出力設定(csv出力設定);
        bparamt.set改頁出力順ID(div.getCcdChohyoShuturyokujun().get出力順ID());
        return bparamt;
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト画面入力．年度、対象期間を設定する
     *
     * @param 対象年度 FlexibleYear
     * @return Range<FlexibleDate>
     */
    public Range<FlexibleDate> estimate対象期間(FlexibleYear 対象年度) {
        FlexibleDate 年度開始日 = new FlexibleDate(RString.EMPTY);
        FlexibleDate 年度終了日 = new FlexibleDate(RString.EMPTY);
        if (対象年度.isBeforeOrEquals(new FlexibleYear(平11年))) {
            年度開始日 = FlexibleDate.EMPTY;
            年度終了日 = FlexibleDate.EMPTY;
        } else if (対象年度.isBeforeOrEquals(new FlexibleYear(平12年))) {
            年度開始日 = new FlexibleDate(対象年度.getYearValue(), NO_4, NO_1);
            年度終了日 = new FlexibleDate(対象年度.getYearValue() + NO_1, NO_5, NO_31);
        } else {
            年度開始日 = new FlexibleDate(対象年度.getYearValue(), NO_6, NO_1);
            年度終了日 = new FlexibleDate(対象年度.getYearValue() + NO_1, NO_5, NO_31);
        }
        return new Range<>(年度開始日, 年度終了日);
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト画面,batchparameter法別区分の設定します。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return bparamt
     */
    public DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter set法別区分の設定(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        RString ddlhobetsu = div.getDdlHobetsuKubun().getSelectedKey();
        if (ddlhobetsu.equals(KEY0)) {
            bparamt.set法別区分(HobetsuKubun.すべて);
        } else if (ddlhobetsu.equals(KEY1)) {
            bparamt.set法別区分(HobetsuKubun.施行時ホームヘルプ);
        } else if (ddlhobetsu.equals(KEY2)) {
            bparamt.set法別区分(HobetsuKubun.障害時ホームヘルプ);
        } else {
            bparamt.set法別区分(HobetsuKubun.障害ヘルプ全額免除);
        }
        return bparamt;
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト画面,batchparameter受給者区分の設定します。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return bparamt
     */
    public DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter set受給者区分の設定(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        RString jukyushakubun = div.getRadJukyushaKubun().getSelectedKey();
        if (jukyushakubun.equals(被保険者)) {
            bparamt.set受給者区分(JukyushaKubun2.被保険者);
        } else if (jukyushakubun.equals(受給者)) {
            bparamt.set受給者区分(JukyushaKubun2.受給者);
        } else {
            bparamt.set受給者区分(JukyushaKubun2.事業対象者);
        }
        return bparamt;
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト画面,batchparameter旧措置区分の設定します。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return bparamt
     */
    public DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter set旧措置区分の設定(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        if (div.getRadKyusochishaKubun().getSelectedKey().equals(両方)) {
            bparamt.set旧措置区分(KyusochishaJukyushaKubun.両方);
        } else if (div.getRadKyusochishaKubun().getSelectedKey().equals(旧措置者のみ)) {
            bparamt.set旧措置区分(KyusochishaJukyushaKubun.旧措置者のみ);
        } else {
            bparamt.set旧措置区分(KyusochishaJukyushaKubun.旧措置者以外);
        }
        return bparamt;
    }
}
