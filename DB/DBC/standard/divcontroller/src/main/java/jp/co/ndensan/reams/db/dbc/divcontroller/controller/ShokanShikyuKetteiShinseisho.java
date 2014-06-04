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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 償還支給申請決定の支給申請書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiShinseisho {

    private List<HashMap> getShokanShikyuTorokuShinseishoYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShinseisho.yml"));
    }

    private HashMap getShokanShikyuTorokuShinseishoYamlId(int index) {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShinseisho.yml")).get(index);
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
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(9);
        infoDiv.getRadKetteiShikyuKubun().setSelectedItem(new RString(source.get("支給区分key").toString()));

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
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(0);
        panel.getTxtShinseiTeikyoYM().setValue(new RDate(source.get("提供年月").toString()));
        panel.getTxtShinseiSeiriNo().setValue(new RString(source.get("整理番号").toString()));
    }

    private void setShinseishoData(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShinseiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiShinseiInfo();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(1);
        infoDiv.getTxtShinseiShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiUketsukeYMD().setValue(new RDate(source.get("受付日").toString()));
        infoDiv.getTxtShinseiShinseiKubun().setValue(new RString(source.get("申請者区分value").toString()));
//      南魚沼市デモでは証記載保険者は表示しない
//        infoDiv.getTxtShinseiShokisai().setValue(new RString(source.get("証記載保険者").toString()));
        infoDiv.getTxtShinseiSaiso().setValue(new RString(source.get("国保連再送").toString()));

        infoDiv.getTxtShinseiName().setValue(new RString(source.get("氏名").toString()));
        infoDiv.getTxtShinseiKana().setValue(new RString(source.get("カナ").toString()));
        infoDiv.getTxtShinseiTelNo().setValue(new RString(source.get("電話番号").toString()));
        infoDiv.getTxtShinseiRiyu().setValue(new RString(source.get("申請理由").toString()));
        infoDiv.getTxtShinseiShiharaiGokei().setValue(new Decimal(source.get("支払金額合計").toString()));
        infoDiv.getTxtShinseiHokenGokei().setValue(new Decimal(source.get("保険請求額合計").toString()));
        infoDiv.getTxtShinseiJikoGokei().setValue(new Decimal(source.get("自己負担額合計").toString()));

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

        infoDiv.getTxtShinseiShiharaiKubun().setValue(new RString("口座払"));

        if (kozaJoho.equals(口座情報.窓口払)) {
            HashMap source = getShokanShikyuTorokuShinseishoYamlId(2);
            mado.getTxtShinseiShiharaiBasho().setValue(new RString(source.get("支払場所").toString()));
            mado.getTxtShinseiKaishiYMD().setValue(new RDate(source.get("開始日").toString()));
            mado.getTxtShinseiKaishiH().setValue(new Decimal(source.get("開始時").toString()));
            mado.getTxtShinseiKaishiM().setValue(new Decimal(source.get("開始分").toString()));
            mado.getTxtShinseiShuryoYMD().setValue(new RDate(source.get("終了日").toString()));
            mado.getTxtShinseiShuryoH().setValue(new Decimal(source.get("終了時").toString()));
            mado.getTxtShinseiShuryoM().setValue(new Decimal(source.get("終了分").toString()));
        } else {
            HashMap source = getShokanShikyuTorokuShinseishoYamlId(3);
            koza.getTxtShinseiKinyuKikanCode().setValue(new RString(source.get("金融機関コード").toString()));
            koza.getTxtShinseiShitenCode().setValue(new RString(source.get("支店コード").toString()));
            koza.getTxtShinseiKozaShubetsu().setValue(new RString(source.get("口座種別").toString()));
            koza.getTxtShinseiKozaNo().setValue(new Decimal(source.get("口座番号").toString()));
            koza.getTxtShinseiKinyuKikanName().setValue(new RString(source.get("金融機関名").toString()));
            koza.getTxtShinseiMeigininName().setValue(new RString(source.get("名義人").toString()));
            koza.getTxtShinseiMeigininKana().setValue(new RString(source.get("カナ").toString()));
        }
    }

    private void setShomeishoData(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().
                getShokanShikyuKetteiShomeishoInfo();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(4);

        infoDiv.getTxtShinseiTeikyoshoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiShomeisho().setValue(new RString("2131 訪問通所他"));
        infoDiv.getTxtShinseiJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        infoDiv.getTxtShinseiJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
    }

    private void setShomeishoList(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().
                getShokanShikyuKetteiShomeishoInfo();
        List<dgServiceTeikyoShomeishoList_Row> dgRowList = infoDiv.getShokanShikyuKetteiShomeishoListInfo().
                getDgServiceTeikyoShomeishoList().getDataSource();
        List<HashMap> sourceList = getShokanShikyuTorokuShinseishoYaml();
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        Button btnGokei = new Button();
        dgRowList.clear();
        for (int i = 5; i < 6; i++) {
            dgRowList.add(new dgServiceTeikyoShomeishoList_Row(
                    btnSelect,
                    btnEdit,
                    btnDelete,
                    new RString(sourceList.get(i).get("サービス提供証明書").toString()),
                    new RString(sourceList.get(i).get("事業者").toString()),
                    btnGokei));
        }
        infoDiv.getShokanShikyuKetteiShomeishoListInfo().getDgServiceTeikyoShomeishoList().setDataSource(dgRowList);
    }

    private void setKetteiInfoList(ShokanShikyuKetteiShinseishoDiv panel) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        List<dgShokanShikyuKetteiInfoList_Row> dgRowList = infoDiv.getDgShokanShikyuKetteiInfoList().getDataSource();
        List<HashMap> sourceList = getShokanShikyuTorokuShinseishoYaml();
        dgRowList.clear();
        for (int i = 10; i < 11; i++) {
            dgRowList.add(new dgShokanShikyuKetteiInfoList_Row(
                    new RString(sourceList.get(i).get("サービス種類").toString()),
                    new RString(sourceList.get(i).get("単位金額").toString()),
                    new RString(sourceList.get(i).get("支払金額").toString()),
                    new RString(sourceList.get(i).get("差額").toString())));
        }
        infoDiv.getDgShokanShikyuKetteiInfoList().setDataSource(dgRowList);
    }

    private void setKetteiInfoData(ShokanShikyuKetteiShinseishoDiv panel, 支給区分 shikyuKubun) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(9);

        if (shikyuKubun.equals(支給区分.支給)) {
            infoDiv.getTxtKetteiYMD().setValue(new RDate(source.get("決定日").toString()));
            infoDiv.getTxtKetteiZogenTanisu().setValue(new Decimal(source.get("増減単位数").toString()));
            infoDiv.getTxtKetteiZogenRiyu().setValue(new RString(source.get("増減理由").toString()));
            infoDiv.getTxtKetteiFushikyuRiyu().clearValue();
            infoDiv.getTxtKetteiShiharaiGokei().setValue(new Decimal(source.get("支払金額合計").toString()));
            infoDiv.getTxtKetteiHokenGokei().setValue(new Decimal(source.get("保険請求額合計").toString()));
            infoDiv.getTxtKetteiJikoGokei().setValue(new Decimal(source.get("自己負担額合計").toString()));
            infoDiv.getTxtKetteiSagakuGokei().setValue(new Decimal(source.get("差額支払金額合計").toString()));
        } else {
            infoDiv.getTxtKetteiYMD().setValue(new RDate(source.get("決定日").toString()));
            infoDiv.getTxtKetteiZogenTanisu().clearValue();
            infoDiv.getTxtKetteiZogenRiyu().clearValue();
            infoDiv.getTxtKetteiFushikyuRiyu().setValue(new RString(source.get("不支給理由").toString()));
            infoDiv.getTxtKetteiShiharaiGokei().setValue(new Decimal(source.get("支払金額合計").toString()));
            infoDiv.getTxtKetteiHokenGokei().setValue(new Decimal(source.get("保険請求額合計").toString()));
            infoDiv.getTxtKetteiJikoGokei().setValue(new Decimal(source.get("自己負担額合計").toString()));
            infoDiv.getTxtKetteiSagakuGokei().setValue(new Decimal(source.get("差額支払金額合計").toString()));
        }
    }

    private void showKetteiInfo(ShokanShikyuKetteiShinseishoDiv panel, 支給区分 shikyuKubun) {
        ShokanShikyuKetteiInfoDiv infoDiv = panel.getTabShokanShikyuKetteiShinseisho().getShokanShikyuKetteiInfo();
        if (shikyuKubun.equals(支給区分.支給)) {
            infoDiv.getTxtKetteiYMD().setDisabled(false);
            infoDiv.getTxtKetteiZogenTanisu().setDisabled(false);
            infoDiv.getTxtKetteiZogenRiyu().setDisabled(false);
            infoDiv.getTxtKetteiFushikyuRiyu().setDisabled(true);
            infoDiv.getTxtKetteiShiharaiGokei().setDisabled(false);
            infoDiv.getTxtKetteiHokenGokei().setDisabled(false);
            infoDiv.getTxtKetteiJikoGokei().setDisabled(false);
            infoDiv.getTxtKetteiSagakuGokei().setDisabled(false);
        } else {
            infoDiv.getTxtKetteiYMD().setDisabled(true);
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
