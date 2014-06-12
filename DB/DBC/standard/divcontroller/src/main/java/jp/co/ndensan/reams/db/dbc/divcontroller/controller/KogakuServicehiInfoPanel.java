/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.KogakuServicehiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultL_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult.dgJudgementResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 高額介護サービス費照会 #37963
 *
 * @author n8223
 */
public class KogakuServicehiInfoPanel {

    final static String PayToJuryoinin = "受領委任払い";
    final static String PayToKoza = "口座払い";
    final static String PayToMadoguchi = "窓口払い";

    /**
     * 高額介護サービス費照会 高額介護サービス費情報 勧奨通知発行を設定する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<KogakuServicehiInfoPanelDiv> onLoad(KogakuServicehiInfoPanelDiv panel) {
        ResponseData<KogakuServicehiInfoPanelDiv> response = new ResponseData<>();

//        //高額介護サービス費情報 
//        setKogakuServicehiInfo(panel);
//        
//        //申請者情報 TAB
//        setKogakuServicehiInfoPanelShinseisha(panel);
//        //口座情報 TAB
//        setKogakuServicehiInfoPanelPaymentMethod(panel);
//        //高額決定情報 TAB
//        KogakuServiceDetaildgJudgementinfo(panel);
//        //高額決定情報 TAB     dgJudgementResult
//        KogakuServiceDetaildgJudgementResult(panel);
        response.data = panel;
        return response;
    }

    // 高額介護サービス費情報を設定する。
    private void setKogakuServicehiInfo(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfo.yml");

        //高額介護サービス費情報  (被保険者番号～所得段階）
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtHihokenshaNo().setValue(new RString(
                ymlData.get(0).get("hihokenshaNo").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtTsuchishoNo().setValue(new RString(
                ymlData.get(0).get("tsuchishoNo").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtShikakuShutokuYMD().setValue(new FlexibleDate(
                ymlData.get(0).get("shikakuShutokuYMD").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtChoshuHoho().setValue(new RString(
                ymlData.get(0).get("choshuHoho").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtKyuHihokenshaNo().setValue(new RString(
                ymlData.get(0).get("kyuHihokenshaNo").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtKyuShichosonCode().setValue(new RString(
                ymlData.get(0).get("kyuShichosonCode").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtKyuShichosonName().setValue(new RString(
                ymlData.get(0).get("kyuShichosonName").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtShikakuSoshitsuYMD().setValue(new FlexibleDate(
                ymlData.get(0).get("shikakuSoshitsuYMD").toString()));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getKogakuKaigoJuminJoho().getTxtShotokuDankai().setValue(new RString(
                ymlData.get(0).get("shotokuDankai").toString()));

        //高額介護サービス費情報  (氏名～住所）
        panel.getKogakuNushiJuminJoho().getTxtNushiShikibetsuCode().setValue(new RString(
                ymlData.get(0).get("nushiShikibetsuCode").toString()));
        panel.getKogakuNushiJuminJoho().getTxtNushiName().setValue(new RString(
                ymlData.get(0).get("nushiName").toString()));
        panel.getKogakuNushiJuminJoho().getTxtNushiSetaiCode().setValue(new RString(
                ymlData.get(0).get("nushiSetaiCode").toString()));
        panel.getKogakuNushiJuminJoho().getTxtNushiGyoseiku().setValue(new RString(
                ymlData.get(0).get("nushiGyoseiku").toString()));
        panel.getKogakuNushiJuminJoho().getTxtNushiYubinNo().setValue(new YubinNo(
                ymlData.get(0).get("nushiYubinNo").toString()));
        panel.getKogakuNushiJuminJoho().getTxtNushiJusho().setValue(new RString(
                ymlData.get(0).get("nushiJusho").toString()));

        panel.getKogakuServiceDetail().getTxtTeikyoYM().setValue(new RDate(
                ymlData.get(0).get("teikyoYM").toString()));
    }

    //申請者情報 TAB
    private void setKogakuServicehiInfoPanelShinseisha(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfoPanelShinseisha.yml");

        //申請日～申請理由
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseiDate().setValue(
                        new RDate(ymlData.get(0).get("shinseiDate").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseishaName().setValue(
                        new RString(ymlData.get(0).get("shinseishaName").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtTelNo().setValue(
                        new RString(ymlData.get(0).get("telNo").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseishaNameKana().setValue(
                        new RString(ymlData.get(0).get("shinseishaNameKana").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtYubinNo().setValue(
                        new YubinNo(ymlData.get(0).get("yubinNo").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getTxtShiharaiTotalAmount().setValue(
                        new Decimal(ymlData.get(0).get("shiharaiTotalAmount").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getTxtShinseiRiyu().setValue(
                        new RString(ymlData.get(0).get("shinseiRiyu").toString()));

    }

    //口座情報 TAB
    private void setKogakuServicehiInfoPanelPaymentMethod(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfoPanelPaymentMethod.yml");

        //受領委任情報
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJuryoininKeiyakuNo().setValue(new RString(
                                ymlData.get(0).get("juryoininKeiyakuNo").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaNo().setValue(new RString(
                                ymlData.get(0).get("jigyoshaNo").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaName().setValue(new RString(
                                ymlData.get(0).get("jigyoshaName").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaNameKana().setValue(new RString(
                                ymlData.get(0).get("jigyoshaNameKana").toString()));
        //口座払い
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanCode().setValue(new RString(
                                ymlData.get(0).get("kinyuKikanCode").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanName().setValue(new RString(
                                ymlData.get(0).get("kinyuKikanName").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanBrunchCode().setValue(new RString(
                                ymlData.get(0).get("kinyuKikanBrunchCode").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanBrunchName().setValue(new RString(
                                ymlData.get(0).get("kinyuKikanBrunchName").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaNo().setValue(new RString(
                                ymlData.get(0).get("kozaNo").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaMeigininKana().setValue(new RString(
                                ymlData.get(0).get("kozaMeigininKana").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaMeiginin().setValue(new RString(
                                ymlData.get(0).get("kozaMeiginin").toString()));

        //窓口払い
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiBasho().setValue(new RString(
                                ymlData.get(0).get("shiharaiBasho").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiKaishiDate().setValue(new RDate(
                                ymlData.get(0).get("shiharaiKaishiDate").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiKaishiDay().setValue(new RString(
                                ymlData.get(0).get("shiharaiKaishiDay").toString()));
//        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
//                getMadoguchiPayment().getTxtShiharaiKaishiTime().setValue(
//                        RTime.of(Integer.parseInt(ymlData.get(0).get("shiharaiKaishiTime").toString())));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiShuryoDate().setValue(new RDate(
                                ymlData.get(0).get("shiharaiShuryoDate").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiShuryoDay().setValue(new RString(
                                ymlData.get(0).get("shiharaiShuryoDay").toString()));
//        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
//                getMadoguchiPayment().getTxtShiharaiShuryoTime().setValue(
//                        RTime.of(Long.parseLong(ymlData.get(0).get("shiharaiShuryoTime").toString())));

    }

    //高額決定情報 TAB
    private void KogakuServiceDetaildgJudgementinfo(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServiceDetaildgJudgementinfo.yml");

        //受付日
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtUketsukeDate().
                setValue(new RDate(ymlData.get(0).get("uketsukeDate").toString()));
        //本人支払額
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtHonninPaymentAmount().
                setValue(new Decimal(ymlData.get(0).get("honninPaymentAmount").toString()));
        //決定日
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtKetteiDate().
                setValue(new RDate(ymlData.get(0).get("ktteiDate").toString()));
        //世帯集約番号
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtsetaiShuyakuNo().
                setValue(new RString(ymlData.get(0).get("setaiShuyakuNo").toString()));
        //支給金額
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtShikyuAmount().
                setValue(new Decimal(ymlData.get(0).get("shikyuAmount").toString()));
        //不支給理由
        
        if(!ymlData.get(0).get("fushikyuRiyu").toString().equals("")) {
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail2().getTxtFushikyuRiyu().
                setValue(new RString(ymlData.get(0).get("fushikyuRiyu").toString()));
        } 

        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail2().getTxtBiko().
                setValue(new RString(ymlData.get(0).get("biko").toString()));

    }

    //高額決定情報 TAB     高額介護サービス費一覧 dgJudgementResult
    private void KogakuServiceDetaildgJudgementResult(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServiceDetaildgJudgementResult.yml");

        List<dgJudgementResult_Row> arraydata = createRowKogakuServiceDetaildgJudgementResultTestData(ymlData);
        DataGrid<dgJudgementResult_Row> grid = panel.getKogakuServiceDetail().
                getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getDgJudgementResult();

        grid.setDataSource(arraydata);

    }

    private List<dgJudgementResult_Row> createRowKogakuServiceDetaildgJudgementResultTestData(List<HashMap> ymlData) {
        List<dgJudgementResult_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMap(hashMap, arrayData);
        }

        return arrayData;

    }

    private void hashMap(HashMap hashMap, List<dgJudgementResult_Row> arrayData) {

        dgJudgementResult_Row item;

        item = createRowKogakuServiceDetaildgJudgementResultData(
                hashMap.get("jigyosha").toString(),
                hashMap.get("serviceShurui").toString(),
                hashMap.get("serviceHiyoTotal").toString(),
                hashMap.get("riyoshaFutanTotalAmount").toString(),
                hashMap.get("santeiKijunAmount").toString(),
                hashMap.get("shiharaizumiAmount").toString(),
                hashMap.get("kogakuShikyuAmount").toString()
        );
        arrayData.add(item);
    }

    private dgJudgementResult_Row createRowKogakuServiceDetaildgJudgementResultData(
            String jigyosha,
            String serviceShurui,
            String serviceHiyoTotal,
            String riyoshaFutanTotalAmount,
            String santeiKijunAmount,
            String shiharaizumiAmount,
            String kogakuShikyuAmount
    ) {
        dgJudgementResult_Row rowKogakuServiceDetaildgJudgementResultData;
        rowKogakuServiceDetaildgJudgementResultData = new dgJudgementResult_Row(
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum()
        );

        //事業者
        rowKogakuServiceDetaildgJudgementResultData.setTxtJigyosha(new RString(jigyosha));
        //サービス種類
        rowKogakuServiceDetaildgJudgementResultData.setTxtServiceShurui(new RString(serviceShurui));
        //サービス費用合計
        rowKogakuServiceDetaildgJudgementResultData.getTxtServiceHiyoTotal().setValue(new Decimal(serviceHiyoTotal));

        rowKogakuServiceDetaildgJudgementResultData.getTxtRiyoshaFutanTotalAmount().setValue(new Decimal(riyoshaFutanTotalAmount));
        //利用者<負担額合計
        rowKogakuServiceDetaildgJudgementResultData.getTxtSanteiKijunAmount().setValue(new Decimal(santeiKijunAmount));
        //算定基準額
        rowKogakuServiceDetaildgJudgementResultData.getTxtShiharaizumiAmount().setValue(new Decimal(shiharaizumiAmount));
        //支払済金額
        rowKogakuServiceDetaildgJudgementResultData.getTxtKogakuShikyuAmount().setValue(new Decimal(kogakuShikyuAmount));

        return rowKogakuServiceDetaildgJudgementResultData;

    }

    /**
     * 高額介護サービス費照会 並べて照会表示画面の個人照会に戻るボタン押下後、高額介護サービス費照会画面に戻る
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<KogakuServicehiInfoPanelDiv> onClick_btnReturnShowOne(KogakuServicehiInfoPanelDiv panel) {
        ResponseData<KogakuServicehiInfoPanelDiv> response = new ResponseData<>();

        //口座払いので表示 
        setKozaPaymentVisible(panel);

        //高額介護サービス費情報 
        setKogakuServicehiInfo(panel);

        //申請者情報 TAB
        setKogakuServicehiInfoPanelShinseisha(panel);
        //口座情報 TAB
        setKogakuServicehiInfoPanelPaymentMethod(panel);
        //高額決定情報 TAB
        KogakuServiceDetaildgJudgementinfo(panel);
        //高額決定情報 TAB     dgJudgementResult
        KogakuServiceDetaildgJudgementResult(panel);

        response.data = panel;
        return response;
    }

    /**
     * 高額介護サービス費照会 高額介護サービス費一覧で、選択された情報をもとに高額介護サービス費照会の情報を表示する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<KogakuServicehiInfoPanelDiv> onClick_ShowDetail(KogakuServicehiInfoPanelDiv panel) {
        ResponseData<KogakuServicehiInfoPanelDiv> response = new ResponseData<>();

        //口座払いので表示 
        setKozaPaymentVisible(panel);
        //高額介護サービス費情報 
        setKogakuServicehiInfo(panel);
        //申請者情報 TAB
        setKogakuServicehiInfoPanelShinseisha(panel);
        //口座情報 TAB
        setKogakuServicehiInfoPanelPaymentMethod(panel);
        //高額決定情報 TAB
        KogakuServiceDetaildgJudgementinfo(panel);
        //高額決定情報 TAB     dgJudgementResult
        KogakuServiceDetaildgJudgementResult(panel);

        response.data = panel;
        return response;

    }

    /**
     * 高額介護サービス費照会 口座情報で。①口座払い　②受領委任払い　③窓口払いの選択によって非表示する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<KogakuServicehiInfoPanelDiv> onClick_radPayMethod(KogakuServicehiInfoPanelDiv panel) {
        ResponseData<KogakuServicehiInfoPanelDiv> response = new ResponseData<>();
        setRadPayMethod(panel);

        response.data = panel;
        return response;

    }

    private void setRadPayMethod(KogakuServicehiInfoPanelDiv panel) {
        //受領委任払い 　→　　口座払い・窓口払い　 非表示に設定する
        switch (panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().
                getRadPayMethod().getSelectedValue().toString()) {
            case PayToJuryoinin:
                //受領委任払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setDisplayNone(false);
                //口座払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setDisplayNone(true);
                //窓口払い　 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setDisplayNone(true);
                
                //口座払い　→　　受領委任払い・窓口払い　非表示に設定する
                break;
            case PayToKoza:
                //受領委任払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setDisplayNone(true);
                //口座払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setDisplayNone(false);
                //窓口払い　 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setDisplayNone(true);
                
                //窓口払い　→　口座払い・受領委任払い　非表示に設定する
                break;
            case PayToMadoguchi:
                //受領委任払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getJuryoininJoho().setDisplayNone(true);
                //口座払い 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getKozaPayment().setDisplayNone(true);
                //窓口払い　 非表示に設定する
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setVisible(true);
                panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                        getTplKoza().getPaymentMethod().getMadoguchiPayment().setDisplayNone(false);
                break;
        }
    }

    private void setKozaPaymentVisible(KogakuServicehiInfoPanelDiv panel) {
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().
                getRadPayMethod().setSelectedItem(new RString("payToKoza"));
        
       if( panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getRadPayMethod().getSelectedValue().toString().equals(PayToKoza)){
        //受領委任払い 非表示に設定する
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getJuryoininJoho().setVisible(true);
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getJuryoininJoho().setDisplayNone(true);

        //口座払い 非表示に設定する
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getKozaPayment().setVisible(true);
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getKozaPayment().setDisplayNone(false);

        //窓口払い　 非表示に設定する
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getMadoguchiPayment().setVisible(true);
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getMadoguchiPayment().setDisplayNone(true);

       }
       
    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }

}
