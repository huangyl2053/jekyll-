/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKozaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKozaInfoKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKozaInfoMadoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShinseishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.dgShokanShikyuKetteiInfoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoList.dgServiceTeikyoShomeishoList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 償還支給申請決定の支給申請書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiShinseisho {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShinseisho.yml"));
    }

    /**
     * 申請書一覧で行を選択した時の支給申請書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoDiv> onSelectedShinseishoList(ShokanShikyuKetteiShinseishoDiv panel) {
        setTopData(panel);
        setShinseishoData(panel);

        showKozaJoho(panel, 口座情報.口座払);
        setKozaJohoData(panel, 口座情報.口座払);

        setShomeishoData(panel);
        setShomeishoList(panel);

        setKetteiInfoList(panel);

        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        ControlGenerator cg = new ControlGenerator(getYaml().get(9));
        infoDiv.getRadKetteiShikyuKubun().setSelectedItem(cg.getAsRString("支給区分key"));

        setKetteiInfoData(panel, 支給区分.支給);
        showKetteiInfo(panel, 支給区分.支給);

        ResponseData<ShokanShikyuKetteiShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private enum 口座情報 {

        窓口払,
        口座払
    }

    private enum 支給区分 {

        支給,
        不支給
    }

    /**
     * 支給申請書情報の償還払決定情報で支給区分を変更したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoDiv> onChangeShikyuKubun(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        if (infoDiv.getRadKetteiShikyuKubun().getSelectedValue().equals(new RString(支給区分.支給.toString()))) {
            setKetteiInfoData(panel, 支給区分.支給);
            showKetteiInfo(panel, 支給区分.支給);
        } else {
            setKetteiInfoData(panel, 支給区分.不支給);
            showKetteiInfo(panel, 支給区分.不支給);

        }

        ResponseData<ShokanShikyuKetteiShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setTopData(ShokanShikyuKetteiShinseishoDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        panel.getTxtShinseiTeikyoYM().setValue(cg.getAsRDate("提供年月"));
        panel.getTxtShinseiSeiriNo().setValue(cg.getAsRString("整理番号"));
    }

    private void setShinseishoData(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShinseiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiShinseiInfo();
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));
        infoDiv.getTxtShinseiShinseiYMD().setValue(cg.getAsRDate("申請日"));
        infoDiv.getTxtShinseiUketsukeYMD().setValue(cg.getAsRDate("受付日"));
        infoDiv.getTxtShinseiShinseiKubun().setValue(cg.getAsRString("申請者区分value"));
//      南魚沼市デモでは証記載保険者は表示しない
//        infoDiv.getTxtShinseiShokisai().setValue(new RString(source.get("証記載保険者").toString()));
        infoDiv.getTxtShinseiSaiso().setValue(cg.getAsRString("国保連再送"));

        infoDiv.getTxtShinseiName().setValue(cg.getAsRString("氏名"));
        infoDiv.getTxtShinseiKana().setValue(cg.getAsRString("カナ"));
        infoDiv.getTxtShinseiTelNo().setValue(cg.getAsRString("電話番号"));
        infoDiv.getTxtShinseiRiyu().setValue(cg.getAsRString("申請理由"));
        infoDiv.getTxtShinseiShiharaiGokei().setValue(cg.getAsDecimal("支払金額合計"));
        infoDiv.getTxtShinseiHokenGokei().setValue(cg.getAsDecimal("保険請求額合計"));
        infoDiv.getTxtShinseiJikoGokei().setValue(cg.getAsDecimal("自己負担額合計"));

//      南魚沼市デモでは証記載保険者は表示しない
        infoDiv.getTxtShinseiShokisai().setVisible(false);
        infoDiv.getTxtShinseiShokisai().setDisplayNone(true);
    }

    private void showKozaJoho(ShokanShikyuKetteiShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuKetteiKozaInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiKozaInfo();
        ShokanShikyuKetteiKozaInfoMadoDiv mado = infoDiv.getShokanShikyuKetteiKozaInfoMado();
        ShokanShikyuKetteiKozaInfoKozaDiv koza = infoDiv.getShokanShikyuKetteiKozaInfoKoza();
        if (kozaJoho.equals(口座情報.窓口払)) {
            mado.setVisible(true);
            mado.setDisplayNone(false);
            koza.setVisible(false);
            koza.setDisplayNone(true);
        } else {
            mado.setVisible(false);
            mado.setDisplayNone(true);
            koza.setVisible(true);
            koza.setDisplayNone(false);
        }
    }

    private void setKozaJohoData(ShokanShikyuKetteiShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuKetteiKozaInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiKozaInfo();
        ShokanShikyuKetteiKozaInfoMadoDiv mado = infoDiv.getShokanShikyuKetteiKozaInfoMado();
        ShokanShikyuKetteiKozaInfoKozaDiv koza = infoDiv.getShokanShikyuKetteiKozaInfoKoza();

        if (kozaJoho.equals(口座情報.窓口払)) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(2));
            infoDiv.getTxtShinseiShiharaiKubun().setValue(cg.getAsRString("支払区分"));
            mado.getTxtShinseiShiharaiBasho().setValue(cg.getAsRString("支払場所"));
            mado.getTxtShinseiKaishiYMD().setValue(cg.getAsRDate("開始日"));
            mado.getTxtShinseiKaishiH().setValue(cg.getAsDecimal("開始時"));
            mado.getTxtShinseiKaishiM().setValue(cg.getAsDecimal("開始分"));
            mado.getTxtShinseiShuryoYMD().setValue(cg.getAsRDate("終了日"));
            mado.getTxtShinseiShuryoH().setValue(cg.getAsDecimal("終了時"));
            mado.getTxtShinseiShuryoM().setValue(cg.getAsDecimal("終了分"));
        } else {
            ControlGenerator cg = new ControlGenerator(getYaml().get(3));
            infoDiv.getTxtShinseiShiharaiKubun().setValue(cg.getAsRString("支払区分"));
            koza.getTxtShinseiKinyuKikanCode().setValue(cg.getAsRString("金融機関コード"));
            koza.getTxtShinseiShitenCode().setValue(cg.getAsRString("支店コード"));
            koza.getTxtShinseiKozaShubetsu().setValue(cg.getAsRString("口座種別"));
            koza.getTxtShinseiKozaNo().setValue(cg.getAsDecimal("口座番号"));
            koza.getTxtShinseiKinyuKikanName().setValue(cg.getAsRString("金融機関名"));
            koza.getTxtShinseiMeigininName().setValue(cg.getAsRString("名義人"));
            koza.getTxtShinseiMeigininKana().setValue(cg.getAsRString("カナ"));
        }
    }

    private void setShomeishoData(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().
                getShokanShikyuKetteiShomeishoInfo();
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));

        infoDiv.getTxtShinseiTeikyoshoShinseiYMD().setValue(cg.getAsRDate("申請日"));
        infoDiv.getTxtShinseiShomeisho().setValue(cg.getAsRString("証明書"));
        infoDiv.getTxtShinseiJigyoshaCode().setValue(cg.getAsRString("事業者コード"));
        infoDiv.getTxtShinseiJigyoshaName().setValue(cg.getAsRString("事業者名"));
    }

    private void setShomeishoList(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().
                getShokanShikyuKetteiShomeishoInfo();
        List<dgServiceTeikyoShomeishoList_Row> dgRowList = infoDiv.getShokanShikyuKetteiShomeishoListInfo().
                getDgServiceTeikyoShomeishoList().getDataSource();
        List<HashMap> sourceList = getYaml();
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        Button btnGokei = new Button();
        dgRowList.clear();
        for (int i = 5; i < 6; i++) {
            ControlGenerator cg = new ControlGenerator(sourceList.get(i));
            dgRowList.add(new dgServiceTeikyoShomeishoList_Row(
                    btnSelect,
                    btnEdit,
                    btnDelete,
                    cg.getAsRString("サービス提供証明書"),
                    cg.getAsRString("事業者"),
                    btnGokei));
        }
        infoDiv.getShokanShikyuKetteiShomeishoListInfo().getDgServiceTeikyoShomeishoList().setDataSource(dgRowList);
    }

    private void setKetteiInfoList(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        List<dgShokanShikyuKetteiInfoList_Row> dgRowList = infoDiv.getDgShokanShikyuKetteiInfoList().getDataSource();
        List<HashMap> sourceList = getYaml();
        dgRowList.clear();
        for (int i = 11; i < 12; i++) {
            ControlGenerator cg = new ControlGenerator(sourceList.get(i));
            dgRowList.add(new dgShokanShikyuKetteiInfoList_Row(
                    cg.getAsRString("サービス種類"),
                    cg.getAsRString("単位金額"),
                    cg.getAsRString("支払金額"),
                    cg.getAsRString("差額")));
        }
        infoDiv.getDgShokanShikyuKetteiInfoList().setDataSource(dgRowList);
    }

    private void setKetteiInfoData(ShokanShikyuKetteiShinseishoDiv panel, 支給区分 shikyuKubun) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();

        if (shikyuKubun.equals(支給区分.支給)) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(9));
//            infoDiv.getTxtKetteiYMD().setValue(cg.getAsRDate("決定日"));
            infoDiv.getTxtKetteiZogenTanisu().setValue(cg.getAsDecimal("増減単位数"));
            infoDiv.getTxtKetteiZogenRiyu().setValue(cg.getAsRString("増減理由"));
            infoDiv.getTxtKetteiFushikyuRiyu().clearValue();
            infoDiv.getTxtKetteiShiharaiGokei().setValue(cg.getAsDecimal("支払金額合計"));
            infoDiv.getTxtKetteiHokenGokei().setValue(cg.getAsDecimal("保険請求額合計"));
            infoDiv.getTxtKetteiJikoGokei().setValue(cg.getAsDecimal("自己負担額合計"));
            infoDiv.getTxtKetteiSagakuGokei().setValue(cg.getAsDecimal("差額支払金額合計"));
        } else {
            ControlGenerator cg = new ControlGenerator(getYaml().get(10));
//            infoDiv.getTxtKetteiYMD().setValue(cg.getAsRDate("決定日"));
            infoDiv.getTxtKetteiZogenTanisu().clearValue();
            infoDiv.getTxtKetteiZogenRiyu().clearValue();
//            infoDiv.getTxtKetteiFushikyuRiyu().setValue(cg.getAsRString("不支給理由"));
            infoDiv.getTxtKetteiShiharaiGokei().setValue(cg.getAsDecimal("支払金額合計"));
            infoDiv.getTxtKetteiHokenGokei().setValue(cg.getAsDecimal("保険請求額合計"));
            infoDiv.getTxtKetteiJikoGokei().setValue(cg.getAsDecimal("自己負担額合計"));
            infoDiv.getTxtKetteiSagakuGokei().setValue(cg.getAsDecimal("差額支払金額合計"));
        }
    }

    private void showKetteiInfo(ShokanShikyuKetteiShinseishoDiv panel, 支給区分 shikyuKubun) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        if (shikyuKubun.equals(支給区分.支給)) {
            infoDiv.getTxtKetteiYMD().setDisabled(false);
            infoDiv.getTxtKetteiZogenTanisu().setDisabled(true);
            infoDiv.getTxtKetteiZogenRiyu().setDisabled(false);
            infoDiv.getTxtKetteiFushikyuRiyu().setDisabled(true);
            infoDiv.getTxtKetteiShiharaiGokei().setDisabled(true);
            infoDiv.getTxtKetteiHokenGokei().setDisabled(true);
            infoDiv.getTxtKetteiJikoGokei().setDisabled(true);
            infoDiv.getTxtKetteiSagakuGokei().setDisabled(true);
        } else {
            infoDiv.getTxtKetteiYMD().setDisabled(false);
            infoDiv.getTxtKetteiZogenTanisu().setDisabled(true);
            infoDiv.getTxtKetteiZogenRiyu().setDisabled(true);
            infoDiv.getTxtKetteiFushikyuRiyu().setDisabled(false);
            infoDiv.getTxtKetteiShiharaiGokei().setDisabled(true);
            infoDiv.getTxtKetteiHokenGokei().setDisabled(true);
            infoDiv.getTxtKetteiJikoGokei().setDisabled(true);
            infoDiv.getTxtKetteiSagakuGokei().setDisabled(true);
        }
    }
}
