/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010041;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD205010.DBD205010_FutanGendoGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.RiyoshaFutanDankaiHanni;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.FutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 負担限度額認定者リスト画面のビジネス設計です。
 *
 * @reamsid_L DBD-3960-040 xuejm
 */
public class FutanGendogakuNinteiNinteishaIchiran {

    private final DBD205010_FutanGendoGakuNinteishaListParameter batchparameter
            = new DBD205010_FutanGendoGakuNinteishaListParameter();
    private static final RString 認定者リスト = new RString("ninteisha");
    private static final RString 対象年度 = new RString("taishoNendo");
    private static final RString 両方 = new RString("ryoho");
    private static final RString 旧措置者のみ = new RString("kyusochishaNomi");
    private static final RString 被保険者 = new RString("hihokensha");
    private static final RString 表示する = new RString("hyoji");
    private static final RString 利用者負担１段階 = new RString("dankai1");
    private static final RString 利用者負担２段階 = new RString("dankai2");
    private static final RString 利用者負担３段階 = new RString("dankai3");
    private static final RString 利用者負担４段階 = new RString("dankai4");
    private static final RString 項目名付加 = new RString("komokuMeiFuka");
    private static final RString 連番付加 = new RString("renbanFuka");
    private static final RString 日付スラッシュ編集 = new RString("hizukeHenshu");
    private static final RString 平16年 = new RString("2004");
    private static final RString 平17年 = new RString("2005");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_4 = 4;
    private static final int NO_7 = 7;
    private static final int NO_8 = 8;
    private static final int NO_10 = 10;
    private static final int NO_31 = 31;

    /**
     * 負担限度額認定者リストコンストラクタです。
     *
     */
    public FutanGendogakuNinteiNinteishaIchiran() {

    }

    /**
     * バッチパラメータ作成します．
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return 負担限度額認定者リスト（画面）バッチパラメター
     */
    public DBD205010_FutanGendoGakuNinteishaListParameter createParameter(FutanGengakuNinteishaListDiv div) {

        if (div.getRadTaishoList().getSelectedKey().equals(認定者リスト)) {
            batchparameter.set対象リスト(TargetList.認定者リスト);
            batchparameter.set帳票ID(ReportIdDBD.DBD200016.getReportId());
        } else {
            batchparameter.set対象リスト(TargetList.該当者リスト);
            batchparameter.set基準日(div.getTxtKijunYMD().getValue());
            set受給者区分の設定(div);
            set利用者負担段階の設定(div);
            batchparameter.set帳票ID(ReportIdDBD.DBD200001.getReportId());
        }

        if (div.getRadTaishoKikanShitei().getSelectedKey().equals(対象年度)) {
            batchparameter.set対象期間指定(TaishoKikan.対象年度);
            if (div.getTxtTaishoYM().getValue() != null && !div.getTxtTaishoYM().getValue().isEmpty()) {
                FlexibleYear taishonendo = new FlexibleYear(div.getTxtTaishoYM().getValue().toString().substring(NO_0, NO_4));
                batchparameter.set対象年度(taishonendo);
            }
            batchparameter.set対象年度の開始年月日(div.getTxtTaishoKikanKaishi().getValue());
            batchparameter.set対象年度の終了年月日(div.getTxtTaishoKikanShuryo().getValue());
            batchparameter.set課税判定等基準日(div.getTxtKazeiHanteiToKijunDate().getValue());
        } else {
            batchparameter.set対象期間指定(TaishoKikan.基準日);
            batchparameter.set基準日(div.getTxtKijunYMD().getValue());
            batchparameter.set課税判定等基準日(div.getTxtKijunYMD().getValue());
        }

        if (div.getTxtShotokuNendo().getValue() != null && !div.getTxtShotokuNendo().getValue().isEmpty()) {
            FlexibleYear shotokunendo = new FlexibleYear(div.getTxtShotokuNendo().getValue().toString().substring(NO_0, NO_4));
            batchparameter.set所得年度(shotokunendo);
        }
        set旧措置区分の設定(div);
        if (div.getRadSetaiHyoji().getSelectedKey().equals(表示する)) {
            batchparameter.set世帯表示(SetaiHyoji.表示する);
        } else {
            batchparameter.set世帯表示(SetaiHyoji.表示しない);
        }

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
        batchparameter.setCsv出力設定(csv出力設定);
        batchparameter.set改頁出力順ID(div.getCcdChohyoShuturyokujun().get出力順ID());
        return batchparameter;
    }

    /**
     * 負担限度額認定者リスト画面画面入力．年度、対象期間を設定する
     *
     * @param 年度 FlexibleYear
     * @return Range<FlexibleDate>
     */
    public Range<FlexibleDate> estimate対象期間(FlexibleYear 年度) {
        FlexibleDate 年度開始日 = new FlexibleDate(RString.EMPTY);
        FlexibleDate 年度終了日 = new FlexibleDate(RString.EMPTY);
        if (年度.isBeforeOrEquals(new FlexibleYear(平16年))) {
            年度開始日 = FlexibleDate.EMPTY;
            年度終了日 = FlexibleDate.EMPTY;
        } else if (年度.isBeforeOrEquals(new FlexibleYear(平17年))) {
            年度開始日 = new FlexibleDate(年度.getYearValue(), NO_10, NO_1);
            年度終了日 = new FlexibleDate(年度.getYearValue() + NO_1, NO_7, NO_31);
        } else {
            年度開始日 = new FlexibleDate(年度.getYearValue(), NO_8, NO_1);
            年度終了日 = new FlexibleDate(年度.getYearValue() + NO_1, NO_7, NO_31);
        }
        return new Range<>(年度開始日, 年度終了日);
    }

    /**
     * 負担限度額認定者リスト画面,batchparameter旧措置区分の設定します。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return batchparameter
     */
    public DBD205010_FutanGendoGakuNinteishaListParameter set旧措置区分の設定(FutanGengakuNinteishaListDiv div) {
        if (div.getRadKyusochishaKubun().getSelectedValue().equals(両方)) {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.両方);
        } else if (div.getRadKyusochishaKubun().getSelectedValue().equals(旧措置者のみ)) {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.旧措置者のみ);
        } else {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.旧措置者以外);
        }
        return batchparameter;
    }

    /**
     * 負担限度額認定者リスト画面batchparameter受給者区分の設定します。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return batchparameter
     */
    public DBD205010_FutanGendoGakuNinteishaListParameter set受給者区分の設定(FutanGengakuNinteishaListDiv div) {
        RString jukyushakubun = div.getRadJukyushaKubun().getSelectedKey();
        if (jukyushakubun.equals(被保険者)) {
            batchparameter.set受給者区分(JukyushaKubun2.被保険者);
        } else {
            batchparameter.set受給者区分(JukyushaKubun2.受給者);
        }
        return batchparameter;
    }

    /**
     * 負担限度額認定者リスト画面batchparameter利用者負担段階の設定します。
     *
     * @param div FutanGengakuNinteishaListDiv
     * @return batchparameter
     */
    public DBD205010_FutanGendoGakuNinteishaListParameter set利用者負担段階の設定(FutanGengakuNinteishaListDiv div) {
        RString riyoshafutandankai = div.getDdlRiyoshaFutanDankai().getSelectedKey();
        if (riyoshafutandankai.equals(利用者負担１段階)) {
            batchparameter.set利用者負担段階(RiyoshaFutanDankaiHanni.利用者負担1段階);
        } else if (riyoshafutandankai.equals(利用者負担２段階)) {
            batchparameter.set利用者負担段階(RiyoshaFutanDankaiHanni.利用者負担2段階);
        } else if (riyoshafutandankai.equals(利用者負担３段階)) {
            batchparameter.set利用者負担段階(RiyoshaFutanDankaiHanni.利用者負担3段階);
        } else if (riyoshafutandankai.equals(利用者負担４段階)) {
            batchparameter.set利用者負担段階(RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯);
        } else {
            batchparameter.set利用者負担段階(RiyoshaFutanDankaiHanni.利用者負担1から3段階);
        }
        return batchparameter;
    }
}
