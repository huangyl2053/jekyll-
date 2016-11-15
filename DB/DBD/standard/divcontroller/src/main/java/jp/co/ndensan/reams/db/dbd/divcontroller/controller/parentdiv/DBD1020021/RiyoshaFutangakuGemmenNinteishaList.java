/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1020021;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD201010.DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021.RiyoshaFutanGenmenListDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減免認定者リスト画面のバッチ用パラメータの設定します。
 *
 * @reamsid_L DBD-3980-040 xuejm
 */
public class RiyoshaFutangakuGemmenNinteishaList {

    private static final RString 認定者リスト = new RString("ninteisha");
    private static final RString 両方 = new RString("ryoho");
    private static final RString 旧措置者のみ = new RString("kyusochishaNomi");
    private static final RString 表示する = new RString("hyoji");
    private static final RString 被保険者 = new RString("hihokensha");
    private static final RString 受給者 = new RString("jukyusha");
    private static final RString 市町村民税非課税世帯 = new RString("shichosonMinzeiHikazeiSetai");
    private static final RString 所得税非課税世帯 = new RString("shotokuzeiHikazeiSetai");
    private static final RString 市町村民税本人非課税者 = new RString("sichosonMinzeiHonninHikazeisha");
    private static final RString 老齢福祉年金受給者 = new RString("roreiFukushiNenkinJukyusha");
    private static final RString 生活保護受給者 = new RString("seikatsuHogoJukyusha");
    private static final RString 項目名付加 = new RString("komokuMeiFuka");
    private static final RString 連番付加 = new RString("renbanFuka");
    private static final RString 日付編集 = new RString("hizukeHenshu");
    private static final int NO_0 = 0;
    private static final int NO_4 = 4;

    /**
     * 利用者負担額減免認定者リストコンストラクタです。
     *
     */
    public RiyoshaFutangakuGemmenNinteishaList() {

    }

    /**
     * チパラメータ作成します．
     *
     * @param div RiyoshaFutanGenmenListDiv
     * @return 利用者負担額減免認定者リスト（画面）バッチパラメター
     */
    public DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter createRiyoshaFutangakuGemmenNinteishaIchiranParameter(RiyoshaFutanGenmenListDiv div) {
        DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter batchparameter
                = new DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter();
        if (div.getRadTaishoList().getSelectedKey().equals(認定者リスト)) {
            batchparameter.set対象リスト(TargetList.認定者リスト);
            batchparameter.set帳票ID(ReportIdDBD.DBD200013.getReportId().value());
        } else {
            batchparameter.set対象リスト(TargetList.該当者リスト);
            set受給者区分の設定(div, batchparameter);
            batchparameter.set帳票ID(ReportIdDBD.DBD200002.getReportId().value());
        }

        RDate kijunymd = div.getTxtKijunYMD().getValue();
        batchparameter.set基準日(new FlexibleDate(kijunymd.toDateString()));

        FlexibleYear shotokunendo = new FlexibleYear(div.getTxtShotokuNendo().getValue().toString().substring(NO_0, NO_4));
        batchparameter.set所得年度(shotokunendo);

        if (div.getRadKyusochishaKubun().getSelectedKey().equals(両方)) {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.両方);
        } else if (div.getRadKyusochishaKubun().getSelectedKey().equals(旧措置者のみ)) {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.旧措置者のみ);
        } else {
            batchparameter.set旧措置区分(KyusochishaJukyushaKubun.旧措置者以外);
        }

        if (div.getRadSetaiHyoji().getSelectedKey().equals(表示する)) {
            batchparameter.set世帯表示(SetaiHyoji.表示する);
        } else {
            batchparameter.set世帯表示(SetaiHyoji.表示しない);
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
        batchparameter.set世帯非課税等(世帯非課税等);

        ArrayList<CSVSettings> csv出力設定 = new ArrayList<>();
        for (int i = 0; i < div.getChkCsvShutsuryoku().getSelectedKeys().size(); i++) {
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(項目名付加)) {
                csv出力設定.add(CSVSettings.項目名付加);
            }
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(連番付加)) {
                csv出力設定.add(CSVSettings.連番付加);
            }
            if (div.getChkCsvShutsuryoku().getSelectedKeys().get(i).equals(日付編集)) {
                csv出力設定.add(CSVSettings.日付スラッシュ編集);
            }
        }
        batchparameter.setCsv出力設定(csv出力設定);
        batchparameter.set改頁出力順ID(div.getCcdChohyoShuturyokujun().get出力順ID());
        return batchparameter;
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト画面,batchparameter受給者区分の設定します。
     *
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @param batchparameter DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter
     * @return bparamt
     */
    public DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter set受給者区分の設定(RiyoshaFutanGenmenListDiv div,
            DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter batchparameter) {
        RString jukyushakubun = div.getRadJukyushaKubun().getSelectedKey();
        if (jukyushakubun.equals(被保険者)) {
            batchparameter.set受給者区分(JukyushaKubun2.被保険者);
        } else if (jukyushakubun.equals(受給者)) {
            batchparameter.set受給者区分(JukyushaKubun2.受給者);
        } else {
            batchparameter.set受給者区分(JukyushaKubun2.事業対象者);
        }
        return batchparameter;
    }
}
