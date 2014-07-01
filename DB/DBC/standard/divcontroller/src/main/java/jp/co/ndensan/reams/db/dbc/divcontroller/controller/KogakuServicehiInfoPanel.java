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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
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
 * @author n8223　2014.06.28 朴　共有DIV適用
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

    // 高額介護サービス費情報を設定する。
    private void setKogakuServicehiInfo(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfo.yml");

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //高額介護サービス費情報  (被保険者番号～所得段階）
        //氏名漢字～個人番号
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtAtenaMeisho().setValue(
                ymlDt.getAsRString("atenaMeisho"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtAtenaKanaMeisho().setValue(
                ymlDt.getAsRString("atenaKanMeisho"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtSeinengappiYMD().setValue(
                ymlDt.getAsRDate("seinengappiYmd"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtNenrei().setValue(
                ymlDt.getAsRString("nenrei"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtSeibetsu().setValue(
                ymlDt.getAsRString("seibetsu"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtJusho().setValue(
                ymlDt.getAsRString("jusho"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtGyoseiku().setValue(
                ymlDt.getAsRString("gyoseiku"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtShikibetsuCode().setValue(
                ymlDt.getAsRString("shikibetsuCode"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtYubinNo().setValue(
                ymlDt.getAsYubinNo("yubinNo"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtJuminJotai().setValue(
                ymlDt.getAsRString("juminJotai"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtSetaiCode().setValue(
                ymlDt.getAsRString("setaiCode"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuNushiJuminJohoChildDiv1().getAtenaInfo().getTxtKojinHojinCode().setValue(
                ymlDt.getAsRString("kojinHojinCode"));

        //資格取得 ～　認定期間
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtHihokenshaNo().setValue(
                ymlDt.getAsRString("hihokenshaNo"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtShutokuYmd().setValue(
                ymlDt.getAsRDate("shotokuYmd"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtShutokuJiyu().setValue(
                ymlDt.getAsRString("shotokuJiyu"));
//        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtJutokuTekiyo().setValue(
//                ymlDt.getAsRDate("jutokuTekiyo"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtYokaigoJotaiKubun().setValue(
                ymlDt.getAsRString("yokaigojotaiKubun"));
//        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtShikakuJotai().setValue(
//                ymlDt.getAsRString("shikakuJotai"));
//        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtJutokuKaijo().setValue(
//                ymlDt.getAsRDate("jutokuKaijo"));
//        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtNinteiKikan().setFromValue(
//                ymlDt.getAsRDate("niteikikanfrom"));
//        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtNinteiKikan().setToValue(
//                ymlDt.getAsRDate("niteikikanto"));
        //2014/0628 朴　KaigoShikakuKihonDIV対応
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtJutokuKubun().setValue(
                ymlDt.getAsRString("jutokuKubun"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtNinteiKaishiYmd().setValue(
                ymlDt.getAsRDate("niteikikanfrom"));
        panel.getKogakuNushiJuminJoho().getKogakuJumin().getCommonKogakuKaigoJuminJohoChildDiv2().getTxtNinteiShuryoYmd().setValue(
                ymlDt.getAsRDate("niteikikanto"));

        panel.getKogakuServiceDetail().getTxtTeikyoYM().setValue(
                ymlDt.getAsRDate("teikyoYM"));
    }

    //申請者情報 TAB
    private void setKogakuServicehiInfoPanelShinseisha(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfoPanelShinseisha.yml");

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //申請日～申請理由
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseiDate().setValue(
                        ymlDt.getAsRDate("shinseiDate"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseishaName().setValue(
                        ymlDt.getAsRString("shinseishaName"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtTelNo().setValue(
                        ymlDt.getAsRString("telNo"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtShinseishaNameKana().setValue(
                        ymlDt.getAsRString("shinseishaNameKana"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getShinseisha().getTxtYubinNo().setValue(
                        ymlDt.getAsYubinNo("yubinNo"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getTxtShiharaiTotalAmount().setValue(
                        ymlDt.getAsDecimal("shiharaiTotalAmount"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplShinseisha().getTxtShinseiRiyu().setValue(
                        ymlDt.getAsRString("shinseiRiyu"));

    }

    //口座情報 TAB
    private void setKogakuServicehiInfoPanelPaymentMethod(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfoPanelPaymentMethod.yml");

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //受領委任情報
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJuryoininKeiyakuNo().setValue(
                        ymlDt.getAsRString("juryoininKeiyakuNo"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaNo().setValue(
                        ymlDt.getAsRString("jigyoshaNo"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaName().setValue(
                        ymlDt.getAsRString("jigyoshaName"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getJuryoininJoho().getTxtJigyoshaNameKana().setValue(
                        ymlDt.getAsRString("jigyoshaNameKana"));
        //口座払い
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanCode().setValue(
                        ymlDt.getAsRString("kinyuKikanCode"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanName().setValue(
                        ymlDt.getAsRString("kinyuKikanName"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanBrunchCode().setValue(
                        ymlDt.getAsRString("kinyuKikanBrunchCode"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKinyuKikanBrunchName().setValue(
                        ymlDt.getAsRString("kinyuKikanBrunchName"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaNo().setValue(
                        ymlDt.getAsRString("kozaNo"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaMeigininKana().setValue(
                        ymlDt.getAsRString("kozaMeigininKana"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getKozaPayment().getTxtKozaMeiginin().setValue(
                        ymlDt.getAsRString("kozaMeiginin"));

        //窓口払い
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiBasho().setValue(new RString(
                                ymlDt.getAsRString("shiharaiBasho").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiKaishiDate().setValue(new RDate(
                                ymlDt.getAsRString("shiharaiKaishiDate").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiKaishiDay().setValue(new RString(
                                ymlDt.getAsRString("shiharaiKaishiDay").toString()));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiKaishiTime().setValue(
                        RTime.of(Long.parseLong(ymlDt.getAsRString("shiharaiKaishiTime").toString())));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiShuryoDate().setValue(
                        ymlDt.getAsRDate("shiharaiShuryoDate"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiShuryoDay().setValue(
                        ymlDt.getAsRString("shiharaiShuryoDay"));
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplKoza().getPaymentMethod().
                getMadoguchiPayment().getTxtShiharaiShuryoTime().setValue(
                        RTime.of(Long.parseLong(ymlDt.getAsRString("shiharaiShuryoTime").toString())));

    }

    //高額決定情報 TAB
    private void KogakuServiceDetaildgJudgementinfo(KogakuServicehiInfoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServiceDetaildgJudgementinfo.yml");

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //受付日
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtUketsukeDate().
                setValue(ymlDt.getAsRDate("uketsukeDate"));
        //本人支払額
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtHonninPaymentAmount().
                setValue(ymlDt.getAsDecimal("honninPaymentAmount"));
        //決定日
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtKetteiDate().
                setValue(ymlDt.getAsRDate("ktteiDate"));
        //世帯集約番号
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtsetaiShuyakuNo().
                setValue(ymlDt.getAsRString("setaiShuyakuNo"));
        //支給金額
        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail1().getTxtShikyuAmount().
                setValue(ymlDt.getAsDecimal("shikyuAmount"));
        //不支給理由

        if (!ymlDt.getAsRString("fushikyuRiyu").equals("")) {
            panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                    getJudgementResult().getKogakuServicehiJudgementResultDetail2().getTxtFushikyuRiyu().
                    setValue(ymlDt.getAsRString("fushikyuRiyu"));
        }

        panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().getTplJudgementResult().
                getJudgementResult().getKogakuServicehiJudgementResultDetail2().getTxtBiko().
                setValue(ymlDt.getAsRString("biko"));

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
            ControlGenerator ymlDt = new ControlGenerator(hashMap);
            hashMap(ymlDt, arrayData);
        }

        return arrayData;

    }

    private void hashMap(ControlGenerator hashMap, List<dgJudgementResult_Row> arrayData) {

        dgJudgementResult_Row item;

        item = createRowKogakuServiceDetaildgJudgementResultData(
                hashMap.getAsRString("jigyosha"),
                hashMap.getAsRString("serviceShurui"),
                hashMap.getAsDecimal("serviceHiyoTotal"),
                hashMap.getAsDecimal("riyoshaFutanTotalAmount"),
                hashMap.getAsDecimal("santeiKijunAmount"),
                hashMap.getAsDecimal("shiharaizumiAmount"),
                hashMap.getAsDecimal("kogakuShikyuAmount")
        );
        arrayData.add(item);
    }

    private dgJudgementResult_Row createRowKogakuServiceDetaildgJudgementResultData(
            RString jigyosha,
            RString serviceShurui,
            Decimal serviceHiyoTotal,
            Decimal riyoshaFutanTotalAmount,
            Decimal santeiKijunAmount,
            Decimal shiharaizumiAmount,
            Decimal kogakuShikyuAmount
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
        rowKogakuServiceDetaildgJudgementResultData.setTxtJigyosha(jigyosha);
        //サービス種類
        rowKogakuServiceDetaildgJudgementResultData.setTxtServiceShurui(serviceShurui);
        //サービス費用合計
        rowKogakuServiceDetaildgJudgementResultData.getTxtServiceHiyoTotal().setValue(serviceHiyoTotal);

        rowKogakuServiceDetaildgJudgementResultData.getTxtRiyoshaFutanTotalAmount().setValue(riyoshaFutanTotalAmount);
        //利用者<負担額合計
        rowKogakuServiceDetaildgJudgementResultData.getTxtSanteiKijunAmount().setValue(santeiKijunAmount);
        //算定基準額
        rowKogakuServiceDetaildgJudgementResultData.getTxtShiharaizumiAmount().setValue(shiharaizumiAmount);
        //支払済金額
        rowKogakuServiceDetaildgJudgementResultData.getTxtKogakuShikyuAmount().setValue(kogakuShikyuAmount);

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
        //setKozaPaymentVisible(panel);
        //高額介護サービス費情報
        //setKogakuServicehiInfo(panel);
        //申請者情報 TAB
        //setKogakuServicehiInfoPanelShinseisha(panel);
        //口座情報 TAB
        //setKogakuServicehiInfoPanelPaymentMethod(panel);
        //高額決定情報 TAB
        //KogakuServiceDetaildgJudgementinfo(panel);
        //高額決定情報 TAB     dgJudgementResult
        //KogakuServiceDetaildgJudgementResult(panel);
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
                //受領委任払い 表示に設定する
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
                //口座払い 表示に設定する
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
                //窓口払い　 表示に設定する
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

        if (panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                getTplKoza().getPaymentMethod().getRadPayMethod().getSelectedValue().toString().equals(PayToKoza)) {

            //受領委任払い 非表示に設定する
            panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                    getTplKoza().getPaymentMethod().getJuryoininJoho().setVisible(true);
            panel.getKogakuServiceDetail().getTabKogakuServicehiDetail().
                    getTplKoza().getPaymentMethod().getJuryoininJoho().setDisplayNone(true);

            //口座払い 表示に設定する
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
        return YamlLoader.DBC.loadAsList(new RString(ymlDataName));
    }
}
