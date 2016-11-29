/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5000011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140010.DBC140010_JukyushaKyufujissekiDaichoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140020.DBC140020_JukyushaKyufujissekiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoDiv;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績一覧表発行 のDivControllerクラスです。
 *
 * @reamsid_L DBC-3070-010 dangjingjing
 */
public class JukyushaKyufuJissekiDaichoHandler {

    private final JukyushaKyufuJissekiDaichoDiv div;
    private static final RString 全て = new RString("全て");
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final RString ゼロ = new RString("0");
    private static final RString ゼロゼロ = new RString("0000000000");
    private static final RString く = new RString("9999999999");
    private static final RString いち = new RString("1");
    private static final RString に = new RString("2");
    private static final RString さん = new RString("3");
    private static final RString 訪問通所他_サービス_全て_償還 = new RString("key0");
    private static final RString 短期入所生活介護_審査年月_現物 = new RString("key1");
    private static final RString 短期入所療養介護_老健施設 = new RString("key2");
    private static final RString 短期入所療養介護_医療施設 = new RString("key3");
    private static final RString 認知症対応型共同生活 = new RString("key4");
    private static final RString 特定施設入居者生活介護 = new RString("key5");
    private static final RString 認知症対応型共同生活_短期 = new RString("key6");
    private static final RString 特定施設入居生活介護_短期 = new RString("key7");
    private static final RString 居宅介護支援 = new RString("key8");
    private static final RString 介護老人福祉施設サービス = new RString("key9");
    private static final RString 介護老人保健施設サービス = new RString("key10");
    private static final RString 介護療養型医療施設サービス = new RString("key11");
    private static final RString 特定福祉用具販売費 = new RString("key12");
    private static final RString 住宅改修費 = new RString("key13");
    private static final RString 高額介護サービス費 = new RString("key14");
    private static final RString 予防訪問通所他 = new RString("key15");
    private static final RString 予防短期入所生活介護 = new RString("key16");
    private static final RString 予防短期入所療養介護_老健施設 = new RString("key17");
    private static final RString 予防短期入所療養介護_医療施設 = new RString("key18");
    private static final RString 予防認知症対応型共同生活 = new RString("key19");
    private static final RString 予防特定施設入居者生活介護 = new RString("key20");
    private static final RString 予防認知症対応型共同生活_短期 = new RString("key21");
    private static final RString 予防支援 = new RString("key22");
    private static final RString 予防特定福祉用具販売費 = new RString("key23");
    private static final RString 予防住宅改修費 = new RString("key24");
    private static final RString 介護予防_生活支援_経過 = new RString("key25");
    private static final RString 経過措置ケアマネジメント = new RString("key26");
    private static final RString 介護予防_生活支援総合事業 = new RString("key27");
    private static final RString 総合事業ケアマネジメント = new RString("key28");
    private static final RString MENUID_DBCMNJ1001 = new RString("DBCMNJ1001");
    private static final RString MENUID_DBCMNJ1002 = new RString("DBCMNJ1002");
    private static final int SELECT_KEY_4 = 4;
    private static final int SELECT_KEY_7 = 7;
    private static final int SELECT_KEY_15 = 15;

    /**
     * コンストラクタです。
     *
     * @param div 受給者給付実績一覧表発行Div
     */
    public JukyushaKyufuJissekiDaichoHandler(JukyushaKyufuJissekiDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面 初期化を処理します。
     */
    public void onLond() {
        set初期化_抽出条件1();
        set初期化_抽出条件2();
        set帳票出力順の初期化();
    }

    private void set初期化_抽出条件1() {
        RDate hakkoYMD = RDate.getNowDate().minusMonth(2);
        div.getTabChushutsuJoken().getTxtRangeYM().setFromValue(new RDate(hakkoYMD.wareki().toDateString().toString()));
        div.getTabChushutsuJoken().getTxtRangeYM().setToValue(new RDate(hakkoYMD.wareki().toDateString().toString()));
    }

    private void set初期化_抽出条件2() {
        RString 老人保健市町村番号有無 = div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue();
        if (老人保健市町村番号有無.equals(全て)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(true);
        } else if (老人保健市町村番号有無.equals(なし)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(true);
        } else if (老人保健市町村番号有無.equals(あり)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(false);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(false);
        }
        RString 老人保健受給者番号有無 = div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue();
        if (老人保健受給者番号有無.equals(全て)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(true);
        } else if (老人保健受給者番号有無.equals(なし)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(true);
        } else if (老人保健受給者番号有無.equals(あり)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(false);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(false);
        }
    }

    private void set帳票出力順の初期化() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (MENUID_DBCMNJ1001.equals(menuID)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100055.getReportId());
        } else if (MENUID_DBCMNJ1002.equals(menuID)) {
            div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200002.getReportId());
        }
    }

    /**
     * 出力様式ボタンのメソッドます。
     */
    public void set出力様式ボタン() {
        List<RString> 出力様式_1 = new ArrayList<>();
        List<RString> 出力様式_2 = new ArrayList<>();
        List<RString> 出力様式_3 = new ArrayList<>();
        List<RString> 出力様式_4 = new ArrayList<>();
        List<RString> 出力様式_5 = new ArrayList<>();
        if (div.getTabChushutsuJoken().getChkShutsuryokuYoshiki1().getSelectedKeys().size() != SELECT_KEY_15
                || div.getTabChushutsuJoken().getChkShutsuryokuYoshiki2().getSelectedKeys().size() != SELECT_KEY_7
                || div.getTabChushutsuJoken().getChkShutsuryokuYoshiki3().getSelectedKeys().size() != 1
                || div.getTabChushutsuJoken().getChkShutsuryokuYoshiki4().getSelectedKeys().size() != 2
                || div.getTabChushutsuJoken().getChkShutsuryokuYoshiki5().getSelectedKeys().size() != SELECT_KEY_4) {
            出力様式_1.add(訪問通所他_サービス_全て_償還);
            出力様式_1.add(短期入所生活介護_審査年月_現物);
            出力様式_1.add(短期入所療養介護_老健施設);
            出力様式_1.add(短期入所療養介護_医療施設);
            出力様式_1.add(認知症対応型共同生活);
            出力様式_1.add(特定施設入居者生活介護);
            出力様式_1.add(認知症対応型共同生活_短期);
            出力様式_1.add(特定施設入居生活介護_短期);
            出力様式_1.add(居宅介護支援);
            出力様式_1.add(介護老人福祉施設サービス);
            出力様式_1.add(介護老人保健施設サービス);
            出力様式_1.add(介護療養型医療施設サービス);
            出力様式_1.add(特定福祉用具販売費);
            出力様式_1.add(住宅改修費);
            出力様式_1.add(高額介護サービス費);
            出力様式_2.add(予防訪問通所他);
            出力様式_2.add(予防短期入所生活介護);
            出力様式_2.add(予防短期入所療養介護_老健施設);
            出力様式_2.add(予防短期入所療養介護_医療施設);
            出力様式_2.add(予防認知症対応型共同生活);
            出力様式_2.add(予防特定施設入居者生活介護);
            出力様式_2.add(予防認知症対応型共同生活_短期);
            出力様式_3.add(予防支援);
            出力様式_4.add(予防特定福祉用具販売費);
            出力様式_4.add(予防住宅改修費);
            出力様式_5.add(介護予防_生活支援_経過);
            出力様式_5.add(経過措置ケアマネジメント);
            出力様式_5.add(介護予防_生活支援総合事業);
            出力様式_5.add(総合事業ケアマネジメント);
        }
        div.getTabChushutsuJoken().getChkShutsuryokuYoshiki1().setSelectedItemsByKey(出力様式_1);
        div.getTabChushutsuJoken().getChkShutsuryokuYoshiki2().setSelectedItemsByKey(出力様式_2);
        div.getTabChushutsuJoken().getChkShutsuryokuYoshiki3().setSelectedItemsByKey(出力様式_3);
        div.getTabChushutsuJoken().getChkShutsuryokuYoshiki4().setSelectedItemsByKey(出力様式_4);
        div.getTabChushutsuJoken().getChkShutsuryokuYoshiki5().setSelectedItemsByKey(出力様式_5);
    }

    /**
     * 「実行する」（一覧表用）
     *
     * @return DBC140020_JukyushaKyufujissekiIchiranParameter
     */
    public DBC140020_JukyushaKyufujissekiIchiranParameter setバッチパラメータの設定() {
        DBC140020_JukyushaKyufujissekiIchiranParameter batchParameter = new DBC140020_JukyushaKyufujissekiIchiranParameter();
        if (!div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().equals(訪問通所他_サービス_全て_償還)) {
                batchParameter.set対象年月(いち);
            } else if (div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().equals(短期入所生活介護_審査年月_現物)) {
                batchParameter.set対象年月(に);
            }
        }
        if (!div.getTabChushutsuJoken().getTxtRangeYM().getFromValue().toString().isEmpty()) {
            batchParameter.set年月範囲_開始(div.getTxtRangeYM().getFromValue().getYearMonth().toDateString());
        }
        if (!div.getTabChushutsuJoken().getTxtRangeYM().getToValue().toString().isEmpty()) {
            batchParameter.set年月範囲_終了(div.getTxtRangeYM().getToValue().getYearMonth().toDateString());
        }
        if (!div.getTabChushutsuJoken().getTxtRangeHihokenshaNoFrom().getValue().isEmpty()) {
            batchParameter.set被保険者番号_開始(div.getTabChushutsuJoken().getTxtRangeHihokenshaNoFrom().getValue());
        } else {
            batchParameter.set被保険者番号_開始(ゼロゼロ);
        }
        if (!div.getTabChushutsuJoken().getTxtRangeHihokenshaNoTo().getValue().isEmpty()) {
            batchParameter.set被保険者番号_終了(div.getTabChushutsuJoken().getTxtRangeHihokenshaNoTo().getValue());
        } else {
            batchParameter.set被保険者番号_終了(く);
        }
        if (!div.getTabChushutsuJoken().getChkYokaigodo().getSelectedKeys().isEmpty()) {
            batchParameter.setすべて選択(いち);
        } else {
            batchParameter.setすべて選択(ゼロ);
        }
        List<RString> すべて選択 = div.getTabChushutsuJoken().getChkYokaigodo().getSelectedValues();
        if (すべて選択.contains(new RString("要介護1"))) {
            batchParameter.set要介護1(いち);
        } else {
            batchParameter.set要介護1(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護2"))) {
            batchParameter.set要介護2(いち);
        } else {
            batchParameter.set要介護2(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護3"))) {
            batchParameter.set要介護3(いち);
        } else {
            batchParameter.set要介護3(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護4"))) {
            batchParameter.set要介護4(いち);
        } else {
            batchParameter.set要介護4(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護5"))) {
            batchParameter.set要介護5(いち);
        } else {
            batchParameter.set要介護5(ゼロ);
        }
        if (すべて選択.contains(new RString("要支援1"))) {
            batchParameter.set要支援1(いち);
        } else {
            batchParameter.set要支援1(ゼロ);
        }
        if (すべて選択.contains(new RString("要支援2"))) {
            batchParameter.set要支援2(いち);
        } else {
            batchParameter.set要支援2(ゼロ);
        }
        if (すべて選択.contains(new RString("事業対象者"))) {
            batchParameter.set事業対象者(いち);
        } else {
            batchParameter.set事業対象者(ゼロ);
        }
        if (すべて選択.contains(new RString("経過的要介護"))) {
            batchParameter.set経過的要介護(いち);
        } else {
            batchParameter.set経過的要介護(ゼロ);
        }
        if (すべて選択.contains(new RString("自立"))) {
            batchParameter.set自立(いち);
        } else {
            batchParameter.set自立(ゼロ);
        }
        setバッチ1(batchParameter);
        setバッチ2(batchParameter);
        setバッチ3(batchParameter);
        setバッチ4(batchParameter);
        return batchParameter;
    }

    private void setバッチ1(DBC140020_JukyushaKyufujissekiIchiranParameter batchParameter) {
        List<RString> 出力様式ボタン1 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki1().getSelectedKeys();
        if (出力様式ボタン1.contains(訪問通所他_サービス_全て_償還)) {
            batchParameter.set訪問通所他(いち);
        } else {
            batchParameter.set訪問通所他(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所生活介護_審査年月_現物)) {
            batchParameter.set短期入所生活介護(いち);
        } else {
            batchParameter.set短期入所生活介護(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所療養介護_老健施設)) {
            batchParameter.set短期入所療養介護_老健施設(いち);
        } else {
            batchParameter.set短期入所療養介護_老健施設(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所療養介護_医療施設)) {
            batchParameter.set短期入所療養介護_医療施設(いち);
        } else {
            batchParameter.set短期入所療養介護_医療施設(ゼロ);
        }
        if (出力様式ボタン1.contains(認知症対応型共同生活)) {
            batchParameter.set認知症対応型共同生活(いち);
        } else {
            batchParameter.set認知症対応型共同生活(ゼロ);
        }
        if (出力様式ボタン1.contains(特定施設入居者生活介護)) {
            batchParameter.set特定施設入居者生活介護(いち);
        } else {
            batchParameter.set特定施設入居者生活介護(ゼロ);
        }
        if (出力様式ボタン1.contains(認知症対応型共同生活_短期)) {
            batchParameter.set認知症対応型共同生活_短期(いち);
        } else {
            batchParameter.set認知症対応型共同生活_短期(ゼロ);
        }
        if (出力様式ボタン1.contains(特定施設入居生活介護_短期)) {
            batchParameter.set特定施設入居生活介護_短期(いち);
        } else {
            batchParameter.set特定施設入居生活介護_短期(ゼロ);
        }
        if (出力様式ボタン1.contains(居宅介護支援)) {
            batchParameter.set居宅介護支援(いち);
        } else {
            batchParameter.set居宅介護支援(ゼロ);
        }
        if (出力様式ボタン1.contains(介護老人福祉施設サービス)) {
            batchParameter.set介護老人福祉施設サービス(いち);
        } else {
            batchParameter.set介護老人福祉施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(介護老人保健施設サービス)) {
            batchParameter.set介護老人保健施設サービス(いち);
        } else {
            batchParameter.set介護老人保健施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(介護療養型医療施設サービス)) {
            batchParameter.set介護療養型医療施設サービス(いち);
        } else {
            batchParameter.set介護療養型医療施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(特定福祉用具販売費)) {
            batchParameter.set特定福祉用具販売費(いち);
        } else {
            batchParameter.set特定福祉用具販売費(ゼロ);
        }
        if (出力様式ボタン1.contains(住宅改修費)) {
            batchParameter.set住宅改修費(いち);
        } else {
            batchParameter.set住宅改修費(ゼロ);
        }
        if (出力様式ボタン1.contains(高額介護サービス費)) {
            batchParameter.set高額介護サービス費(いち);
        } else {
            batchParameter.set高額介護サービス費(ゼロ);
        }
    }

    private void setバッチ2(DBC140020_JukyushaKyufujissekiIchiranParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(訪問通所他_サービス_全て_償還)) {
                batchParameter.set給付実績区分(ゼロ);
            } else if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(短期入所生活介護_審査年月_現物)) {
                batchParameter.set給付実績区分(いち);
            } else if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(短期入所療養介護_老健施設)) {
                batchParameter.set給付実績区分(に);
            }
        }
        List<RString> 出力様式ボタン2 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki2().getSelectedKeys();
        if (出力様式ボタン2.contains(予防訪問通所他)) {
            batchParameter.set予防訪問通所他(いち);
        } else {
            batchParameter.set予防訪問通所他(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所生活介護)) {
            batchParameter.set予防短期入所生活介護(いち);
        } else {
            batchParameter.set予防短期入所生活介護(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所療養介護_老健施設)) {
            batchParameter.set予防短期入所療養介護_老健施設(いち);
        } else {
            batchParameter.set予防短期入所療養介護_老健施設(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所療養介護_医療施設)) {
            batchParameter.set予防短期入所療養介護_医療施設(いち);
        } else {
            batchParameter.set予防短期入所療養介護_医療施設(ゼロ);
        }
        if (出力様式ボタン2.contains(予防認知症対応型共同生活)) {
            batchParameter.set予防認知症対応型共同生活(いち);
        } else {
            batchParameter.set予防認知症対応型共同生活(ゼロ);
        }
        if (出力様式ボタン2.contains(予防特定施設入居者生活介護)) {
            batchParameter.set予防特定施設入居者生活介護(いち);
        } else {
            batchParameter.set予防特定施設入居者生活介護(ゼロ);
        }
        if (出力様式ボタン2.contains(予防認知症対応型共同生活_短期)) {
            batchParameter.set予防認知症対応型共同生活_短期(いち);
        } else {
            batchParameter.set予防認知症対応型共同生活_短期(ゼロ);
        }
        List<RString> 出力様式ボタン3 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki3().getSelectedKeys();
        if (出力様式ボタン3.contains(予防支援)) {
            batchParameter.set予防支援(いち);
        } else {
            batchParameter.set予防支援(ゼロ);
        }
        List<RString> 出力様式ボタン4 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki4().getSelectedKeys();
        if (出力様式ボタン4.contains(予防特定福祉用具販売費)) {
            batchParameter.set予防特定福祉用具販売費(いち);
        } else {
            batchParameter.set予防特定福祉用具販売費(ゼロ);
        }
        if (出力様式ボタン4.contains(予防住宅改修費)) {
            batchParameter.set予防住宅改修費(いち);
        } else {
            batchParameter.set予防住宅改修費(ゼロ);
        }
        List<RString> 出力様式ボタン5 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki5().getSelectedKeys();
        if (出力様式ボタン5.contains(介護予防_生活支援_経過)) {
            batchParameter.set介護予防_生活支援_経過(いち);
        } else {
            batchParameter.set介護予防_生活支援_経過(ゼロ);
        }
        if (出力様式ボタン5.contains(経過措置ケアマネジメント)) {
            batchParameter.set経過措置ケアマネジメント(いち);
        } else {
            batchParameter.set経過措置ケアマネジメント(ゼロ);
        }
        if (出力様式ボタン5.contains(介護予防_生活支援総合事業)) {
            batchParameter.set介護予防_生活支援総合事業(いち);
        } else {
            batchParameter.set介護予防_生活支援総合事業(ゼロ);
        }
        if (出力様式ボタン5.contains(総合事業ケアマネジメント)) {
            batchParameter.set総合事業ケアマネジメント(いち);
        } else {
            batchParameter.set総合事業ケアマネジメント(ゼロ);
        }
    }

    private void setバッチ3(DBC140020_JukyushaKyufujissekiIchiranParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(全て)) {
                batchParameter.set旧措置特定有無(いち);
            } else if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(なし)) {
                batchParameter.set旧措置特定有無(に);
            } else if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(あり)) {
                batchParameter.set旧措置特定有無(さん);
            }
        }
        if (!div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(全て)) {
                batchParameter.set老人保健市町村番号有無(いち);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(なし)) {
                batchParameter.set老人保健市町村番号有無(に);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(あり)) {
                batchParameter.set老人保健市町村番号有無(さん);
            }
        }
        if (!div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().getValue().isEmpty()) {
            batchParameter.set老人保健市町村番号有_開始(div.getTxtRojinhokenShikuchosonNoRangeFrom().getValue());
        } else {
            batchParameter.set老人保健市町村番号有_開始(new RString("00000000"));
        }
        if (!div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().getValue().isEmpty()) {
            batchParameter.set老人保健市町村番号有_終了(div.getTxtRojinhokenShikuchosonNoRangeTo().getValue());
        } else {
            batchParameter.set老人保健市町村番号有_終了(new RString("99999999"));
        }
        if (!div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(全て)) {
                batchParameter.set老人保健受給者番号有無(いち);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(なし)) {
                batchParameter.set老人保健受給者番号有無(に);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(あり)) {
                batchParameter.set老人保健受給者番号有無(さん);
            }
        }

    }

    private void setバッチ4(DBC140020_JukyushaKyufujissekiIchiranParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().getValue().isEmpty()) {
            batchParameter.set老人保健受給者番号有_開始(div.getTxtRojinHokenJukyushaNoFrom().getValue());
        } else {
            batchParameter.set老人保健受給者番号有_開始(new RString("0000000"));
        }
        if (!div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().getValue().isEmpty()) {
            batchParameter.set老人保健受給者番号有_終了(div.getTxtRojinHokenJukyushaNoTo().getValue());
        } else {
            batchParameter.set老人保健受給者番号有_終了(new RString("9999999"));
        }
        if (!div.getTabChushutsuJoken().getTxtKohiFutanshaNo().getValue().isEmpty()) {
            batchParameter.set公費負担者番号(div.getTxtKohiFutanshaNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getTxtKohiJukyushaNo().getValue().isEmpty()) {
            batchParameter.set公費受給者番号(div.getTxtKohiJukyushaNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getTxtJigyoshaNoFrom().getValue().isEmpty()) {
            batchParameter.set事業者番号_開始(div.getTxtJigyoshaNoFrom().getValue());
        } else {
            batchParameter.set事業者番号_開始(ゼロゼロ);
        }
        if (!div.getTabChushutsuJoken().getTxtJigyoshaNoTo().getValue().isEmpty()) {
            batchParameter.set事業者番号_終了(div.getTxtJigyoshaNoTo().getValue());
        } else {
            batchParameter.set事業者番号_終了(く);
        }
        if (!div.getTabChushutsuJoken().getTxtKeikakuSakuseiJigyoshoNo().getValue().isEmpty()) {
            batchParameter.set計画作成事業者番号(div.getTxtKeikakuSakuseiJigyoshoNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("同じ"))) {
                batchParameter.set給付率区分(いち);
            } else if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("超える"))) {
                batchParameter.set給付率区分(に);
            } else if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("未満"))) {
                batchParameter.set給付率区分(さん);
            }
        }
        if (div.getTabChushutsuJoken().getTxtKyufuritsu().getValue() != null) {
            batchParameter.set給付率(new RString(div.getTxtKyufuritsu().getValue().toString()));
        }
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            batchParameter.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        }
    }

    /**
     * 「実行する」（台帳用）
     *
     * @return DBC140010_JukyushaKyufujissekiDaichoParameter
     */
    public DBC140010_JukyushaKyufujissekiDaichoParameter setバッチパラメータの設定1() {
        DBC140010_JukyushaKyufujissekiDaichoParameter batchParameter = new DBC140010_JukyushaKyufujissekiDaichoParameter();
        if (!div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().equals(訪問通所他_サービス_全て_償還)) {
                batchParameter.set対象年月(いち);
            } else if (div.getTabChushutsuJoken().getRadKonkaiTaishoYM().getSelectedKey().equals(短期入所生活介護_審査年月_現物)) {
                batchParameter.set対象年月(に);
            }
        }
        if (!div.getTabChushutsuJoken().getTxtRangeYM().getFromValue().toString().isEmpty()) {
            batchParameter.set年月範囲_開始(div.getTxtRangeYM().getFromValue().getYearMonth().toDateString());
        }
        if (!div.getTabChushutsuJoken().getTxtRangeYM().getToValue().toString().isEmpty()) {
            batchParameter.set年月範囲_終了(div.getTxtRangeYM().getToValue().getYearMonth().toDateString());
        }
        if (!div.getTabChushutsuJoken().getTxtRangeHihokenshaNoFrom().getValue().isEmpty()) {
            batchParameter.set被保険者番号_開始(div.getTabChushutsuJoken().getTxtRangeHihokenshaNoFrom().getValue());
        } else {
            batchParameter.set被保険者番号_開始(ゼロゼロ);
        }
        if (!div.getTabChushutsuJoken().getTxtRangeHihokenshaNoTo().getValue().isEmpty()) {
            batchParameter.set被保険者番号_終了(div.getTabChushutsuJoken().getTxtRangeHihokenshaNoTo().getValue());
        } else {
            batchParameter.set被保険者番号_終了(く);
        }
        if (!div.getTabChushutsuJoken().getChkYokaigodo().getSelectedKeys().isEmpty()) {
            batchParameter.setすべて選択(いち);
        } else {
            batchParameter.setすべて選択(ゼロ);
        }
        List<RString> すべて選択 = div.getTabChushutsuJoken().getChkYokaigodo().getSelectedValues();
        if (すべて選択.contains(new RString("要介護1"))) {
            batchParameter.set要介護1(いち);
        } else {
            batchParameter.set要介護1(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護2"))) {
            batchParameter.set要介護2(いち);
        } else {
            batchParameter.set要介護2(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護3"))) {
            batchParameter.set要介護3(いち);
        } else {
            batchParameter.set要介護3(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護4"))) {
            batchParameter.set要介護4(いち);
        } else {
            batchParameter.set要介護4(ゼロ);
        }
        if (すべて選択.contains(new RString("要介護5"))) {
            batchParameter.set要介護5(いち);
        } else {
            batchParameter.set要介護5(ゼロ);
        }
        if (すべて選択.contains(new RString("要支援1"))) {
            batchParameter.set要支援1(いち);
        } else {
            batchParameter.set要支援1(ゼロ);
        }
        if (すべて選択.contains(new RString("要支援2"))) {
            batchParameter.set要支援2(いち);
        } else {
            batchParameter.set要支援2(ゼロ);
        }
        if (すべて選択.contains(new RString("事業対象者"))) {
            batchParameter.set事業対象者(いち);
        } else {
            batchParameter.set事業対象者(ゼロ);
        }
        if (すべて選択.contains(new RString("経過的要介護"))) {
            batchParameter.set経過的要介護(いち);
        } else {
            batchParameter.set経過的要介護(ゼロ);
        }
        if (すべて選択.contains(new RString("自立"))) {
            batchParameter.set自立(いち);
        } else {
            batchParameter.set自立(ゼロ);
        }
        setバッチ11(batchParameter);
        setバッチ21(batchParameter);
        setバッチ31(batchParameter);
        setバッチ41(batchParameter);
        return batchParameter;
    }

    private void setバッチ11(DBC140010_JukyushaKyufujissekiDaichoParameter batchParameter) {
        List<RString> 出力様式ボタン1 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki1().getSelectedKeys();
        if (出力様式ボタン1.contains(訪問通所他_サービス_全て_償還)) {
            batchParameter.set訪問通所他(いち);
        } else {
            batchParameter.set訪問通所他(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所生活介護_審査年月_現物)) {
            batchParameter.set短期入所生活介護(いち);
        } else {
            batchParameter.set短期入所生活介護(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所療養介護_老健施設)) {
            batchParameter.set短期入所療養介護_老健施設(いち);
        } else {
            batchParameter.set短期入所療養介護_老健施設(ゼロ);
        }
        if (出力様式ボタン1.contains(短期入所療養介護_医療施設)) {
            batchParameter.set短期入所療養介護_医療施設(いち);
        } else {
            batchParameter.set短期入所療養介護_医療施設(ゼロ);
        }
        if (出力様式ボタン1.contains(認知症対応型共同生活)) {
            batchParameter.set認知症対応型共同生活(いち);
        } else {
            batchParameter.set認知症対応型共同生活(ゼロ);
        }
        if (出力様式ボタン1.contains(特定施設入居者生活介護)) {
            batchParameter.set特定施設入居者生活介護(いち);
        } else {
            batchParameter.set特定施設入居者生活介護(ゼロ);
        }
        if (出力様式ボタン1.contains(認知症対応型共同生活_短期)) {
            batchParameter.set認知症対応型共同生活_短期(いち);
        } else {
            batchParameter.set認知症対応型共同生活_短期(ゼロ);
        }
        if (出力様式ボタン1.contains(特定施設入居生活介護_短期)) {
            batchParameter.set特定施設入居生活介護_短期(いち);
        } else {
            batchParameter.set特定施設入居生活介護_短期(ゼロ);
        }
        if (出力様式ボタン1.contains(居宅介護支援)) {
            batchParameter.set居宅介護支援(いち);
        } else {
            batchParameter.set居宅介護支援(ゼロ);
        }
        if (出力様式ボタン1.contains(介護老人福祉施設サービス)) {
            batchParameter.set介護老人福祉施設サービス(いち);
        } else {
            batchParameter.set介護老人福祉施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(介護老人保健施設サービス)) {
            batchParameter.set介護老人保健施設サービス(いち);
        } else {
            batchParameter.set介護老人保健施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(介護療養型医療施設サービス)) {
            batchParameter.set介護療養型医療施設サービス(いち);
        } else {
            batchParameter.set介護療養型医療施設サービス(ゼロ);
        }
        if (出力様式ボタン1.contains(特定福祉用具販売費)) {
            batchParameter.set特定福祉用具販売費(いち);
        } else {
            batchParameter.set特定福祉用具販売費(ゼロ);
        }
        if (出力様式ボタン1.contains(住宅改修費)) {
            batchParameter.set住宅改修費(いち);
        } else {
            batchParameter.set住宅改修費(ゼロ);
        }
        if (出力様式ボタン1.contains(高額介護サービス費)) {
            batchParameter.set高額介護サービス費(いち);
        } else {
            batchParameter.set高額介護サービス費(ゼロ);
        }
    }

    private void setバッチ21(DBC140010_JukyushaKyufujissekiDaichoParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(訪問通所他_サービス_全て_償還)) {
                batchParameter.set給付実績区分(ゼロ);
            } else if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(短期入所生活介護_審査年月_現物)) {
                batchParameter.set給付実績区分(いち);
            } else if (div.getTabChushutsuJoken().getRadKyufuJissekiKubun().getSelectedKey().equals(短期入所療養介護_老健施設)) {
                batchParameter.set給付実績区分(に);
            }
        }
        List<RString> 出力様式ボタン2 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki2().getSelectedKeys();
        if (出力様式ボタン2.contains(予防訪問通所他)) {
            batchParameter.set予防訪問通所他(いち);
        } else {
            batchParameter.set予防訪問通所他(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所生活介護)) {
            batchParameter.set予防短期入所生活介護(いち);
        } else {
            batchParameter.set予防短期入所生活介護(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所療養介護_老健施設)) {
            batchParameter.set予防短期入所療養介護_老健施設(いち);
        } else {
            batchParameter.set予防短期入所療養介護_老健施設(ゼロ);
        }
        if (出力様式ボタン2.contains(予防短期入所療養介護_医療施設)) {
            batchParameter.set予防短期入所療養介護_医療施設(いち);
        } else {
            batchParameter.set予防短期入所療養介護_医療施設(ゼロ);
        }
        if (出力様式ボタン2.contains(予防認知症対応型共同生活)) {
            batchParameter.set予防認知症対応型共同生活(いち);
        } else {
            batchParameter.set予防認知症対応型共同生活(ゼロ);
        }
        if (出力様式ボタン2.contains(予防特定施設入居者生活介護)) {
            batchParameter.set予防特定施設入居者生活介護(いち);
        } else {
            batchParameter.set予防特定施設入居者生活介護(ゼロ);
        }
        if (出力様式ボタン2.contains(予防認知症対応型共同生活_短期)) {
            batchParameter.set予防認知症対応型共同生活_短期(いち);
        } else {
            batchParameter.set予防認知症対応型共同生活_短期(ゼロ);
        }
        List<RString> 出力様式ボタン3 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki3().getSelectedKeys();
        if (出力様式ボタン3.contains(予防支援)) {
            batchParameter.set予防支援(いち);
        } else {
            batchParameter.set予防支援(ゼロ);
        }
        List<RString> 出力様式ボタン4 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki4().getSelectedKeys();
        if (出力様式ボタン4.contains(予防特定福祉用具販売費)) {
            batchParameter.set予防特定福祉用具販売費(いち);
        } else {
            batchParameter.set予防特定福祉用具販売費(ゼロ);
        }
        if (出力様式ボタン4.contains(予防住宅改修費)) {
            batchParameter.set予防住宅改修費(いち);
        } else {
            batchParameter.set予防住宅改修費(ゼロ);
        }
        List<RString> 出力様式ボタン5 = div.getTabChushutsuJoken().getChkShutsuryokuYoshiki5().getSelectedKeys();
        if (出力様式ボタン5.contains(介護予防_生活支援_経過)) {
            batchParameter.set介護予防_生活支援_経過(いち);
        } else {
            batchParameter.set介護予防_生活支援_経過(ゼロ);
        }
        if (出力様式ボタン5.contains(経過措置ケアマネジメント)) {
            batchParameter.set経過措置ケアマネジメント(いち);
        } else {
            batchParameter.set経過措置ケアマネジメント(ゼロ);
        }
        if (出力様式ボタン5.contains(介護予防_生活支援総合事業)) {
            batchParameter.set介護予防_生活支援総合事業(いち);
        } else {
            batchParameter.set介護予防_生活支援総合事業(ゼロ);
        }
        if (出力様式ボタン5.contains(総合事業ケアマネジメント)) {
            batchParameter.set総合事業ケアマネジメント(いち);
        } else {
            batchParameter.set総合事業ケアマネジメント(ゼロ);
        }
    }

    private void setバッチ31(DBC140010_JukyushaKyufujissekiDaichoParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(全て)) {
                batchParameter.set旧措置特定有無(いち);
            } else if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(なし)) {
                batchParameter.set旧措置特定有無(に);
            } else if (div.getTabChushutsuJoken().getRadKyuSochiTokureiUmu().getSelectedValue().equals(あり)) {
                batchParameter.set旧措置特定有無(さん);
            }
        }
        if (!div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(全て)) {
                batchParameter.set老人保健市町村番号有無(いち);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(なし)) {
                batchParameter.set老人保健市町村番号有無(に);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue().equals(あり)) {
                batchParameter.set老人保健市町村番号有無(さん);
            }
        }
        if (!div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().getValue().isEmpty()) {
            batchParameter.set老人保健市町村番号有_開始(div.getTxtRojinhokenShikuchosonNoRangeFrom().getValue());
        } else {
            batchParameter.set老人保健市町村番号有_開始(new RString("00000000"));
        }
        if (!div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().getValue().isEmpty()) {
            batchParameter.set老人保健市町村番号有_終了(div.getTxtRojinhokenShikuchosonNoRangeTo().getValue());
        } else {
            batchParameter.set老人保健市町村番号有_終了(new RString("99999999"));
        }
        if (!div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(全て)) {
                batchParameter.set老人保健受給者番号有無(いち);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(なし)) {
                batchParameter.set老人保健受給者番号有無(に);
            } else if (div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue().equals(あり)) {
                batchParameter.set老人保健受給者番号有無(さん);
            }
        }

    }

    private void setバッチ41(DBC140010_JukyushaKyufujissekiDaichoParameter batchParameter) {
        if (!div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().getValue().isEmpty()) {
            batchParameter.set老人保健受給者番号有_開始(div.getTxtRojinHokenJukyushaNoFrom().getValue());
        } else {
            batchParameter.set老人保健受給者番号有_開始(new RString("0000000"));
        }
        if (!div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().getValue().isEmpty()) {
            batchParameter.set老人保健受給者番号有_終了(div.getTxtRojinHokenJukyushaNoTo().getValue());
        } else {
            batchParameter.set老人保健受給者番号有_終了(new RString("9999999"));
        }
        if (!div.getTabChushutsuJoken().getTxtKohiFutanshaNo().getValue().isEmpty()) {
            batchParameter.set公費負担者番号(div.getTxtKohiFutanshaNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getTxtKohiJukyushaNo().getValue().isEmpty()) {
            batchParameter.set公費受給者番号(div.getTxtKohiJukyushaNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getTxtJigyoshaNoFrom().getValue().isEmpty()) {
            batchParameter.set事業者番号_開始(div.getTxtJigyoshaNoFrom().getValue());
        } else {
            batchParameter.set事業者番号_開始(ゼロゼロ);
        }
        if (!div.getTabChushutsuJoken().getTxtJigyoshaNoTo().getValue().isEmpty()) {
            batchParameter.set事業者番号_終了(div.getTxtJigyoshaNoTo().getValue());
        } else {
            batchParameter.set事業者番号_終了(く);
        }
        if (!div.getTabChushutsuJoken().getTxtKeikakuSakuseiJigyoshoNo().getValue().isEmpty()) {
            batchParameter.set計画作成事業者番号(div.getTxtKeikakuSakuseiJigyoshoNo().getValue());
        }
        if (!div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().isEmpty()) {
            if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("同じ"))) {
                batchParameter.set給付率区分(いち);
            } else if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("超える"))) {
                batchParameter.set給付率区分(に);
            } else if (div.getTabChushutsuJoken().getRadKyufuritsu().getSelectedValue().equals(new RString("未満"))) {
                batchParameter.set給付率区分(さん);
            }
        }
        if (div.getTabChushutsuJoken().getTxtKyufuritsu().getValue() != null) {
            batchParameter.set給付率(new RString(div.getTxtKyufuritsu().getValue().toString()));
        }
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            batchParameter.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        }
    }
}
