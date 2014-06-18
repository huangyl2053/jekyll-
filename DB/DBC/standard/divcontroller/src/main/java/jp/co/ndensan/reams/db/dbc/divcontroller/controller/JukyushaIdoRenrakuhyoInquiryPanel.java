/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoInquiryPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKihonJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyotakuServicePlanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoNijiyoboJigyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRojinHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoYokaigoninteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.dgJukyushaIdoRenrakuhyoSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * 受給者異動連絡票情報照会の照会パネルです。
 *
 * @author N3317 塚田 萌
 * @author n8823 ymlData 適用
 */
public class JukyushaIdoRenrakuhyoInquiryPanel {

    /**
     * 照会パネル読み込み時は、検索条件に基づいた連絡票情報を表示します。
     *
     * @param inquiryPanel 照会パネル
     * @param searchPanel 検索パネル
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> onClick_btnShowDetail(
            JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

//        set連絡票(inquiryPanel,
//                searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem());
        //連絡票
        setJukyushaIdoRenrakuhyoInquiry(inquiryPanel, searchPanel);

        ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> response = new ResponseData<>();
        response.data = inquiryPanel;

        return response;
    }

    /**
     * 再検索ボタンが押された時は特別な処理はせず、検索パネルに戻る。
     *
     * @param inquiryPanel 照会パネル
     * @param searchPanel 検索パネル
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> onClick_btnReSearch(
            JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> response = new ResponseData<>();
        response.data = inquiryPanel;
        return response;
    }

    //連絡票
    private void setJukyushaIdoRenrakuhyoInquiry(JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        //基本情報 要介護認定 支給限度基準額 居宅サービス計画 後期高齢国保
        setJukyushaIdoRenrakuhyoKihonJoho(inquiryPanel, searchPanel);

    }

    //set情報
    private void setJukyushaIdoRenrakuhyoKihonJoho(JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
        List<HashMap> ymlData = ymlData("dbc0040011/JukyushaIdoRenrakuhyoInquiryInfo.yml");

        HashMap hashMap = null;
        //## set基本情報 
        //①対象者一覧から選択した内容をもとに基本情報に設定する
        //異動日

        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtRenrakuhyoIdoDate().setValue(new FlexibleDate(
                                setSeireki(searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                                        getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem().getTxtResultIdoDate())));

        //被保険番号
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtRenrakuhyoHihoNo().setValue(new RString(
                                searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                                getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem().getTxtResultHihoNo().toString()));

        //カナ氏名
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtRenrakuhyoHihoName().setValue(new RString(
                                searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                                getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem().getTxtResultHihoName().toString()));

        //送付年月
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtRenrakuhyoSendYM().setValue(new FlexibleDate(
                                setSeireki(searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                                        getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem().getTxtResultSendYM())));
        //テスト用
        switch (searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem().getTxtResultHihoNo().toString()) {
            case "0000000001":
                hashMap = ymlData.get(0);
                break;
            case "0000000002":
                hashMap = ymlData.get(1);
                break;
            case "0000000003":
                hashMap = ymlData.get(2);
                break;
        }

       // HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtHihoBirthday().setValue(ymlDt.getAsFlexibleDate("hihoBirthday"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getTxtShikakuShutokuDate().setValue(ymlDt.getAsFlexibleDate("shikakuShutokuDate"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtShokisaiHokenshaNo().
                setValue(ymlDt.getAsRString("shokisaiHokenshaNo"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().
                setValue(ymlDt.getAsRString("koikiHokenshaNo"));

        //##set要介護認定
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getTxtShinseiDate().setValue(ymlDt.getAsFlexibleDate("shinseiDate"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getTxtNinteiDateRange().setFromValue(ymlDt.getAsRDate("ninteiDateRangefrom"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getTxtNinteiDateRange().setToValue(ymlDt.getAsRDate("ninteiDateRangeto"));

        //##set支給限度基準額    
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuHomonTsushoShikyuGendoKijungaku().setValue(ymlDt.getAsDecimal("kyuHomonTsushoShikyuGendoKijungaku"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuHomonTsushoKanriTekiyoDateRange().setFromValue(ymlDt.getAsRDate("kyuHomonTsushoKanriTekiyoDateRangefrom"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuHomonTsushoKanriTekiyoDateRange().setToValue(ymlDt.getAsRDate("kyuHomonTsushoKanriTekiyoDateRangeto"));

        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuTankiNyushoShikyuGendoKijungaku().setValue(ymlDt.getAsDecimal("kyuTankiNyushoShikyuGendoKijungaku"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuTankiNyushoKanriTekiyoDateRange().setFromValue(ymlDt.getAsRDate("kyuTankiNyushoKanriTekiyoDateRangefrom"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().
                getTxtKyuTankiNyushoKanriTekiyoDateRange().setToValue(ymlDt.getAsRDate("kyuTankiNyushoKanriTekiyoDateRangeto"));

        //##set居宅サービス計画
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getTxtShienJigyoshaNo().setValue(ymlDt.getAsRString("shienJigyoshaNo"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getTxtShienJigyoshaName().setValue(ymlDt.getAsRString("shienJigyoshaName"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getTxtKyotakuServicePlanTekiyoDateRange().setFromValue(ymlDt.getAsRDate("kyuTankiNyushoKanriTekiyoDateRangefrom"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getTxtKyotakuServicePlanTekiyoDateRange().setToValue(ymlDt.getAsRDate("kyuTankiNyushoKanriTekiyoDateRangeto"));

        //##set後期高齢国保
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokiKorei()
                .getTxtKokiKoreiHokenshaNo().setValue(ymlDt.getAsRString("shienJigyoshaNo"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokiKorei()
                .getTxtKokiKoreiHihokenshaNo().setValue(ymlDt.getAsRString("shienJigyoshaNo"));

        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokuho().
                getTxtKokuhoHokenshaNo().setValue(ymlDt.getAsRString("kokuhoHokenshaNo"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokuho().
                getTxtKokuhoHihokenshashoNo().setValue(ymlDt.getAsRString("kokuhoHihokenshashoNo"));
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokuho().
                getTxtKokuhoKojinNo().setValue(ymlDt.getAsRString("kokuhoKojinNo"));
        
        //##setRadio
        //異動区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getRadRenrakuhyoIdoKubun().setSelectedItem(ymlDt.getAsRString("radRenrakuhyoIdoKubun"));
        //性別
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().
                getRadHihoSex().setSelectedItem(ymlDt.getAsRString("radHihoSex"));
        //申請種別
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getRadShinseiType().setSelectedItem(ymlDt.getAsRString("radShinseiType"));
        //変更申請中区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getRadHenkoShinseichuKubun().setSelectedItem(ymlDt.getAsRString("radHenkoShinseichuKubun"));
        //みなし区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().
                getRadMinashiYokaigoKubun().setSelectedItem(ymlDt.getAsRString("radMinashiYokaigoKubun"));
        //計画作成区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getRadPlanSakuseiKubun().setSelectedItem(ymlDt.getAsRString("radPlanSakuseiKubun"));
        //小規模居宅サービス利用区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().
                getRadShokiboKyotakuServiceRiyoUmu().setSelectedItem(ymlDt.getAsRString("radShokiboKyotakuServiceRiyoUmu"));
        //減免申請中区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getRadGemmenShinseichuKubun().setSelectedItem(ymlDt.getAsRString("radGemmenShinseichuKubun"));
        //区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan().
                getRadRiyoshaFutanKubun().setSelectedItem(ymlDt.getAsRString("radRiyoshaFutanKubun"));
        //区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan().
                getRadHyojunFutanKubun().setSelectedItem(ymlDt.getAsRString("radHyojunFutanKubun"));
        //認定申請中区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getRadNinteiShinseichuKubun().
                setSelectedItem(ymlDt.getAsRString("radNinteiShinseichuKubun"));
        //サービス区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getRadServiceKubun().
                setSelectedItem(ymlDt.getAsRString("radServiceKubun"));
        //特例減額措置対象
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku().
                getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi().getRadTokureiKeigenSochiTaisho().
                setSelectedItem(ymlDt.getAsRString("radTokureiKeigenSochiTaisho"));
        //公費負担上限額減額(生活保護等)
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyufuSeigen().getRadKohiFutanJogengakuGengakuUmu().
                setSelectedItem(ymlDt.getAsRString("radKohiFutanJogengakuGengakuUmu"));
        //事業区分
        inquiryPanel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoNijiyoboJigyo().getRadNijiyoboJigyoKubun().
                setSelectedItem(ymlDt.getAsRString("radNijiyoboJigyoKubun"));
        

    }

    private String setSeireki(RString seireki) {
        RDate seirekiYmd = new RDate(seireki.toString());
        return seirekiYmd.toString();
    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }

}
