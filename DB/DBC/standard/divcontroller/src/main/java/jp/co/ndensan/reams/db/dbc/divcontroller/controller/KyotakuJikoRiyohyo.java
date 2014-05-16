/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoRiyoNissuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceRiyohyoBeppyoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceRiyohyoList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 居宅サービス自己作成サービス利用票登録の居宅サービス自己作成サービス利用票をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyo {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 履歴一覧
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        setRiyohyoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * 利用票のデータ設定
     */
    private void setRiyohyoData(KyotakuJikoRiyohyoDiv panel) {
        setSummaryData(panel);
        setServiceRiyohyoData(panel);
        setServiceRiyohyoBeppyoData(panel);
    }

    /**
     * 届出日など、タブ以外のデータの設定
     *
     * @param panel
     */
    private void setSummaryData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoInfoDiv info = panel.getKyotakuJikoRiyohyoInfo();
        info.getTxtTodokedeYMD().setValue(new RDate("20140601"));
        info.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));
        info.getTxtTekiyoKikan().setToValue(new RDate("20140630"));
        info.getTxtTaishoYM().setValue(new RDate("20140601"));
        info.getTxtRiyohyoSakuseiYMD().setValue(new RDate("20140701"));
        info.getTxtRiyohyoTodokedeYMD().setValue(new RDate("20140702"));
        info.getTxtKubunShikyuGendogaku().setValue(new RString("30"));
        info.getTxtRiyohyoSakuseisha().setValue(new RString("電算　太郎"));
        info.getTxtGendoKanriKikan().setFromValue(new RDate("20140601"));
        info.getTxtGendoKanriKikan().setToValue(new RDate("20140630"));

    }

    /**
     * サービス利用票タブのデータ設定
     *
     * @param panel
     */
    private void setServiceRiyohyoData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoDiv riyohyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
        List<dgServiceRiyohyoList_Row> dgRowList = riyohyo.getDgServiceRiyohyoList().getDataSource();
        Button btnDelete = new Button();
        Button btnService = new Button();
        Button btnJigyosha = new Button();

        dgServiceRiyohyoList_Row rowItem = createサービス利用票(btnDelete,
                "10:00",
                "15:00",
                btnService,
                "111111:通所介護",
                btnJigyosha,
                "1111111111:電算介護サービス",
                "予定",
                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
                "63");
        dgRowList.add(rowItem);
        rowItem = createサービス利用票(btnDelete,
                "",
                "",
                btnService,
                "",
                btnJigyosha,
                "",
                "実績",
                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
                "63");
        dgRowList.add(rowItem);
        riyohyo.getDgServiceRiyohyoList().setDataSource(dgRowList);
    }

    private void setServiceRiyohyoBeppyoData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo();

        ServiceRiyohyoBeppyoRiyoNissuDiv nissu = beppyo.getServiceRiyohyoBeppyoRiyoNissu();
        ServiceRiyohyoBeppyoListDiv list = beppyo.getServiceRiyohyoBeppyoList();
        ServiceRiyohyoBeppyoMeisaiDiv meisai = beppyo.getServiceRiyohyoBeppyoMeisai();
        ServiceRiyohyoBeppyoGokeiDiv goukei = beppyo.getServiceRiyohyoBeppyoGokei();
        setBeppyoNissuData(nissu);
        setBeppyoListData(list);
        setBeppyoMeisaiData(meisai);
        setBeppyoGokeiData(goukei);
    }

    private void setBeppyoNissuData(ServiceRiyohyoBeppyoRiyoNissuDiv nissu) {
        nissu.getTxtZengetsuRiyoNissu().setValue(new Decimal("30"));
        nissu.getTxtTogetsuRiyoNissu().setValue(new Decimal("30"));
        nissu.getTxtRuikeiRiyoNissu().setValue(new Decimal("60"));
    }

    private void setBeppyoListData(ServiceRiyohyoBeppyoListDiv list) {
        List<dgServiceRiyohyoBeppyoList_Row> listRow = list.getDgServiceRiyohyoBeppyoList().getDataSource();
        Button btnSelect = new Button();
        Button btnDelete = new Button();

        dgServiceRiyohyoBeppyoList_Row rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "111111:通所介護１１１", "", "", "", "1", "588", "", "", "", "", "", "", "", "", "", "");
        listRow.add(rowItem);
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "111112:通所介護１１２", "", "", "", "1", "50", "", "", "", "", "", "", "", "", "", "");
        listRow.add(rowItem);
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "222222:通所介護合計", "", "", "", "", "(638)", "", "", "", "638", "10.0", "6,380", "90", "5,742", "638", "");
        listRow.add(rowItem);
        list.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    private dgServiceRiyohyoBeppyoList_Row create別票一覧リスト(
            Button btnSelect,
            Button btnDelete,
            String txtJigyosha,
            String txtService,
            String txtTani,
            String txtWaribikigoRitsu,
            String txtWaribikigoTani,
            String txtKaisu,
            String txtServiceTani,
            String txtShuruiGendoChokaTani,
            String txtShuruiGendonaiTani,
            String txtKubunGendoChokaTani,
            String txtKubunGendonaiTani,
            String txtTanisuTanka,
            String txtHiyoSogaku,
            String txtKyufuritsu,
            String txtHokenFutangaku,
            String txtRiyoshaFutangakuHoken,
            String txtRiyoshaFutangakuZengaku
    ) {

        return new dgServiceRiyohyoBeppyoList_Row(
                btnSelect,
                btnDelete,
                new RString(txtJigyosha),
                new RString(txtService),
                new RString(txtTani),
                new RString(txtWaribikigoRitsu),
                new RString(txtWaribikigoTani),
                new RString(txtKaisu),
                new RString(txtServiceTani),
                new RString(txtShuruiGendoChokaTani),
                new RString(txtShuruiGendonaiTani),
                new RString(txtKubunGendoChokaTani),
                new RString(txtKubunGendonaiTani),
                new RString(txtTanisuTanka),
                new RString(txtHiyoSogaku),
                new RString(txtKyufuritsu),
                new RString(txtHokenFutangaku),
                new RString(txtRiyoshaFutangakuHoken),
                new RString(txtRiyoshaFutangakuZengaku)
        );

    }

    private void setBeppyoMeisaiData(ServiceRiyohyoBeppyoMeisaiDiv meisai) {
        meisai.getTxtJigyoshaCode().setValue(new RString("1111111111"));
        meisai.getBtnJigyoshaName().setValue(new RString("電算サービスセンター"));
        meisai.getTxtServiceShuruiCode().setValue(new RString("11"));
        meisai.getTxtServiceCode().setValue(new RString("1111"));
        meisai.getBtnServiceName().setValue(new RString("通所介護１１１"));
        meisai.getTxtTani().setValue(new Decimal("0"));
        meisai.getTxtWaribikigoRitsu().setValue(new Decimal("0"));
        meisai.getTxtWaribikigoTain().setValue(new Decimal("0"));
        meisai.getTxtKaisu().setValue(new Decimal("1"));
        meisai.getTxtServiceTani().setValue(new Decimal("588"));

    }

    private void setBeppyoGokeiData(ServiceRiyohyoBeppyoGokeiDiv goukei) {
        goukei.getTxtShuruiGendoChokaTani().setValue(new Decimal("0"));
        goukei.getTxtShuruiGendonaiTani().setValue(new Decimal("0"));
        goukei.getTxtTanisuTanka().setValue(new Decimal("10"));
        goukei.getTxtKubunGendoChokaTani().setValue(new Decimal("0"));
        goukei.getTxtKubunGendonaiTani().setValue(new Decimal("638"));
        goukei.getTxtKyufuritsu().setValue(new Decimal("90"));
        goukei.getTxtHiyoSogaku().setValue(new Decimal("6380"));
        goukei.getTxtHokenKyufugaku().setValue(new Decimal("5742"));
        goukei.getTxtRiyoshaFutangakuHoken().setValue(new Decimal("638"));
        goukei.getTxtRiyoshaFutangakuZengaku().setValue(new Decimal("0"));
    }

    private dgServiceRiyohyoList_Row createサービス利用票(Button btnDelete,
            String txtKaishi,
            String txtShuryo,
            Button btnService,
            String txtService,
            Button btnJigyosha,
            String txtJigyosha,
            String txtYoJitsu,
            String txtDay1, String txtDay2, String txtDay3, String txtDay4, String txtDay5,
            String txtDay6, String txtDay7, String txtDay8, String txtDay9, String txtDay10,
            String txtDay11, String txtDay12, String txtDay13, String txtDay14, String txtDay15,
            String txtDay16, String txtDay17, String txtDay18, String txtDay19, String txtDay20,
            String txtDay21, String txtDay22, String txtDay23, String txtDay24, String txtDay25,
            String txtDay26, String txtDay27, String txtDay28, String txtDay29, String txtDay30,
            String txtDay31, String txtGokei) {

        TextBox txtBoxKaishi = new TextBox();
        TextBox txtBoxShuryo = new TextBox();
        txtBoxKaishi.setValue(new RString(txtKaishi));
        txtBoxShuryo.setValue(new RString(txtShuryo));
        TextBoxNum txtBoxDay1 = new TextBoxNum();
        TextBoxNum txtBoxDay2 = new TextBoxNum();
        TextBoxNum txtBoxDay3 = new TextBoxNum();
        TextBoxNum txtBoxDay4 = new TextBoxNum();
        TextBoxNum txtBoxDay5 = new TextBoxNum();
        TextBoxNum txtBoxDay6 = new TextBoxNum();
        TextBoxNum txtBoxDay7 = new TextBoxNum();
        TextBoxNum txtBoxDay8 = new TextBoxNum();
        TextBoxNum txtBoxDay9 = new TextBoxNum();
        TextBoxNum txtBoxDay10 = new TextBoxNum();
        TextBoxNum txtBoxDay11 = new TextBoxNum();
        TextBoxNum txtBoxDay12 = new TextBoxNum();
        TextBoxNum txtBoxDay13 = new TextBoxNum();
        TextBoxNum txtBoxDay14 = new TextBoxNum();
        TextBoxNum txtBoxDay15 = new TextBoxNum();
        TextBoxNum txtBoxDay16 = new TextBoxNum();
        TextBoxNum txtBoxDay17 = new TextBoxNum();
        TextBoxNum txtBoxDay18 = new TextBoxNum();
        TextBoxNum txtBoxDay19 = new TextBoxNum();
        TextBoxNum txtBoxDay20 = new TextBoxNum();
        TextBoxNum txtBoxDay21 = new TextBoxNum();
        TextBoxNum txtBoxDay22 = new TextBoxNum();
        TextBoxNum txtBoxDay23 = new TextBoxNum();
        TextBoxNum txtBoxDay24 = new TextBoxNum();
        TextBoxNum txtBoxDay25 = new TextBoxNum();
        TextBoxNum txtBoxDay26 = new TextBoxNum();
        TextBoxNum txtBoxDay27 = new TextBoxNum();
        TextBoxNum txtBoxDay28 = new TextBoxNum();
        TextBoxNum txtBoxDay29 = new TextBoxNum();
        TextBoxNum txtBoxDay30 = new TextBoxNum();
        TextBoxNum txtBoxDay31 = new TextBoxNum();
        txtBoxDay1.setValue(new Decimal(txtDay1));
        txtBoxDay2.setValue(new Decimal(txtDay2));
        txtBoxDay3.setValue(new Decimal(txtDay3));
        txtBoxDay4.setValue(new Decimal(txtDay4));
        txtBoxDay5.setValue(new Decimal(txtDay5));
        txtBoxDay6.setValue(new Decimal(txtDay6));
        txtBoxDay7.setValue(new Decimal(txtDay7));
        txtBoxDay8.setValue(new Decimal(txtDay8));
        txtBoxDay9.setValue(new Decimal(txtDay9));
        txtBoxDay10.setValue(new Decimal(txtDay10));
        txtBoxDay11.setValue(new Decimal(txtDay11));
        txtBoxDay12.setValue(new Decimal(txtDay12));
        txtBoxDay13.setValue(new Decimal(txtDay13));
        txtBoxDay14.setValue(new Decimal(txtDay14));
        txtBoxDay15.setValue(new Decimal(txtDay15));
        txtBoxDay16.setValue(new Decimal(txtDay16));
        txtBoxDay17.setValue(new Decimal(txtDay17));
        txtBoxDay18.setValue(new Decimal(txtDay18));
        txtBoxDay19.setValue(new Decimal(txtDay19));
        txtBoxDay20.setValue(new Decimal(txtDay20));
        txtBoxDay21.setValue(new Decimal(txtDay21));
        txtBoxDay22.setValue(new Decimal(txtDay22));
        txtBoxDay23.setValue(new Decimal(txtDay23));
        txtBoxDay24.setValue(new Decimal(txtDay24));
        txtBoxDay25.setValue(new Decimal(txtDay25));
        txtBoxDay26.setValue(new Decimal(txtDay26));
        txtBoxDay27.setValue(new Decimal(txtDay27));
        txtBoxDay28.setValue(new Decimal(txtDay28));
        txtBoxDay29.setValue(new Decimal(txtDay29));
        txtBoxDay30.setValue(new Decimal(txtDay30));
        txtBoxDay31.setValue(new Decimal(txtDay31));

        return new dgServiceRiyohyoList_Row(
                btnDelete,
                txtBoxKaishi,
                txtBoxShuryo,
                btnService,
                new RString(txtService),
                btnJigyosha,
                new RString(txtJigyosha),
                new RString(txtYoJitsu),
                txtBoxDay1, txtBoxDay2, txtBoxDay3, txtBoxDay4, txtBoxDay5,
                txtBoxDay6, txtBoxDay7, txtBoxDay8, txtBoxDay9, txtBoxDay10,
                txtBoxDay11, txtBoxDay12, txtBoxDay13, txtBoxDay14, txtBoxDay15,
                txtBoxDay16, txtBoxDay17, txtBoxDay18, txtBoxDay19, txtBoxDay20,
                txtBoxDay21, txtBoxDay22, txtBoxDay23, txtBoxDay24, txtBoxDay25,
                txtBoxDay26, txtBoxDay27, txtBoxDay28, txtBoxDay29, txtBoxDay30, txtBoxDay31,
                new RString(txtGokei));
    }

}
