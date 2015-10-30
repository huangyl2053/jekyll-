/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuKozaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuKozaInfoKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuKozaInfoMadoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShinseishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ServiceTeikyoShomeishoList.dgServiceTeikyoShomeishoList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 償還支給申請登録の支給申請書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuTorokuShinseisho {
    
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

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
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onSelectedShinseishoList(ShokanShikyuTorokuShinseishoDiv panel) {
        setTopData(panel);
        setShinseishoData(panel);

        eraseAnotherKozaJoho(panel, 口座情報.口座払);
        setKozaJohoEnable(panel, 口座情報.口座払);
        setKozaJohoData(panel, 口座情報.口座払);

        setShomeishoData(panel);
        setShomeishoList(panel);

        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 申請書一覧で「申請書を追加する」ボタンを押下した時の支給申請書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickAddShinseisho(ShokanShikyuTorokuShinseishoDiv panel) {
        setTopData(panel);
        setShinseishoData(panel);

        eraseAnotherKozaJoho(panel, 口座情報.口座払);
        setKozaJohoEnable(panel, 口座情報.口座払);
        setKozaJohoData(panel, 口座情報.口座払);

        setShomeishoData(panel);
        setShomeishoList(panel);

        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報で「証明書情報を確定する」ボタンを押下した時の支給申請書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickShomeishoKakutei(ShokanShikyuTorokuShinseishoDiv panel) {
        addShomeishoList(panel);

        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private enum 口座情報 {

        窓口払,
        口座払
    }

    /**
     * 支給申請書情報の口座情報で窓口払を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickMado(ShokanShikyuTorokuShinseishoDiv panel) {
        eraseAnotherKozaJoho(panel, 口座情報.窓口払);
        setKozaJohoEnable(panel, 口座情報.窓口払);
        setKozaJohoData(panel, 口座情報.窓口払);
        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 支給申請書情報の口座情報で口座払を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoDiv> onClickKoza(ShokanShikyuTorokuShinseishoDiv panel) {
        eraseAnotherKozaJoho(panel, 口座情報.口座払);
        setKozaJohoEnable(panel, 口座情報.口座払);
        setKozaJohoData(panel, 口座情報.口座払);
        ResponseData<ShokanShikyuTorokuShinseishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setTopData(ShokanShikyuTorokuShinseishoDiv panel) {
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(0);
        panel.getTxtShinseiTeikyoYM().setValue(new RDate(source.get("提供年月").toString()));
        panel.getTxtShinseiSeiriNo().setValue(new RString(source.get("整理番号").toString()));
        panel.getTxtShinseiInputKubun().setValue(new RString(source.get("入力区分").toString()));
    }

    private void setShinseishoData(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShinseiInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuShinseiInfo();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(1);
        infoDiv.getTxtShinseiShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiUketsukeYMD().setValue(new RDate(source.get("受付日").toString()));
        infoDiv.getRadShinseiShinseiKubun().setSelectedItem(new RString(source.get("申請者区分key").toString()));
//      南魚沼市デモでは証記載保険者は表示しない
//        infoDiv.getTxtShinseiShokisai().setValue(new RString(source.get("証記載保険者").toString()));
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

    /**
     * 支給申請書情報の口座情報で窓口払・口座払を選択したとき、選択していない支払の情報を初期化する処理です。
     *
     * @param panel
     * @param kozaJoho
     */
    private void eraseAnotherKozaJoho(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();
        if (kozaJoho.equals(口座情報.窓口払)) {
            koza.getTxtShinseiKinyuKikanCode().clearValue();
            koza.getTxtShinseiShitenCode().clearValue();
            koza.getTxtShinseiKozaShubetsu().clearValue();
            koza.getTxtShinseiKozaNo().clearValue();
            koza.getTxtShinseiKinyuKikanName().clearValue();
            koza.getTxtShinseiMeigininName().clearValue();
            koza.getTxtShinseiMeigininKana().clearValue();
        } else {
            mado.getTxtShinseiShiharaiBasho().clearValue();
            mado.getTxtShinseiKaishiYMD().clearValue();
            mado.getTxtShinseiKaishiH().clearValue();
            mado.getTxtShinseiKaishiM().clearValue();
            mado.getTxtShinseiShuryoYMD().clearValue();
            mado.getTxtShinseiShuryoH().clearValue();
            mado.getTxtShinseiShuryoM().clearValue();
        }
    }

    private void setKozaJohoEnable(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();
        if (kozaJoho.equals(口座情報.窓口払)) {
            mado.getRadShinseiMadoBarai().setSelectedItem(new RString("key0"));
            koza.getRadShinseiKozaBarai().setSelectedItem(RString.EMPTY);
            mado.getTxtShinseiShiharaiBasho().setDisabled(false);
            mado.getTxtShinseiKaishiYMD().setDisabled(false);
            mado.getTxtShinseiKaishiH().setDisabled(false);
            mado.getTxtShinseiKaishiM().setDisabled(false);
            mado.getTxtShinseiShuryoYMD().setDisabled(false);
            mado.getTxtShinseiShuryoH().setDisabled(false);
            mado.getTxtShinseiShuryoM().setDisabled(false);
            koza.getDdlShinseiRirekiNo().setDisabled(true);
        } else {
            mado.getRadShinseiMadoBarai().setSelectedItem(RString.EMPTY);
            koza.getRadShinseiKozaBarai().setSelectedItem(new RString("key0"));
            mado.getTxtShinseiShiharaiBasho().setDisabled(true);
            mado.getTxtShinseiKaishiYMD().setDisabled(true);
            mado.getTxtShinseiKaishiH().setDisabled(true);
            mado.getTxtShinseiKaishiM().setDisabled(true);
            mado.getTxtShinseiShuryoYMD().setDisabled(true);
            mado.getTxtShinseiShuryoH().setDisabled(true);
            mado.getTxtShinseiShuryoM().setDisabled(true);
            koza.getDdlShinseiRirekiNo().setDisabled(false);
        }
    }

    private void setKozaJohoData(ShokanShikyuTorokuShinseishoDiv panel, 口座情報 kozaJoho) {
        ShokanShikyuTorokuKozaInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().getShokanShikyuTorokuKozaInfo();
        ShokanShikyuTorokuKozaInfoMadoDiv mado = infoDiv.getShokanShikyuTorokuKozaInfoMado();
        ShokanShikyuTorokuKozaInfoKozaDiv koza = infoDiv.getShokanShikyuTorokuKozaInfoKoza();

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
            HashMap source = getShokanShikyuTorokuShinseishoYamlId(INDEX_3);
            koza.getTxtShinseiKinyuKikanCode().setValue(new RString(source.get("金融機関コード").toString()));
            koza.getTxtShinseiShitenCode().setValue(new RString(source.get("支店コード").toString()));
            koza.getTxtShinseiKozaShubetsu().setValue(new RString(source.get("口座種別").toString()));
            koza.getTxtShinseiKozaNo().setValue(new Decimal(source.get("口座番号").toString()));
            koza.getTxtShinseiKinyuKikanName().setValue(new RString(source.get("金融機関名").toString()));
            koza.getTxtShinseiMeigininName().setValue(new RString(source.get("名義人").toString()));
            koza.getTxtShinseiMeigininKana().setValue(new RString(source.get("カナ").toString()));
        }
    }

    private void setShomeishoData(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().
                getShokanShikyuTorokuShomeishoInfo();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(INDEX_4);

        infoDiv.getTxtShinseiTeikyoshoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        infoDiv.getTxtShinseiJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        infoDiv.getTxtShinseiJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
    }

    private void setShomeishoList(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().
                getShokanShikyuTorokuShomeishoInfo();
        List<dgServiceTeikyoShomeishoList_Row> dgRowList = infoDiv.getShokanShikyuTorokuShomeishoListInfo().
                getDgServiceTeikyoShomeishoList().getDataSource();
        List<HashMap> sourceList = getShokanShikyuTorokuShinseishoYaml();
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        Button btnGokei = new Button();
        dgRowList.clear();
        for (int i = INDEX_5; i < INDEX_6; i++) {
            dgRowList.add(new dgServiceTeikyoShomeishoList_Row(
                    btnSelect,
                    btnEdit,
                    btnDelete,
                    new RString(sourceList.get(i).get("サービス提供証明書").toString()),
                    new RString(sourceList.get(i).get("事業者").toString()),
                    btnGokei));
        }
        infoDiv.getShokanShikyuTorokuShomeishoListInfo().getDgServiceTeikyoShomeishoList().setDataSource(dgRowList);
    }

    private void addShomeishoList(ShokanShikyuTorokuShinseishoDiv panel) {
        ShokanShikyuTorokuShomeishoInfoDiv infoDiv = panel.getTabShokanShikyuTorokuShinseisho().
                getShokanShikyuTorokuShomeishoInfo();
        List<dgServiceTeikyoShomeishoList_Row> dgRowList = infoDiv.getShokanShikyuTorokuShomeishoListInfo().
                getDgServiceTeikyoShomeishoList().getDataSource();
        HashMap source = getShokanShikyuTorokuShinseishoYamlId(INDEX_8);
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        Button btnGokei = new Button();
        dgRowList.add(new dgServiceTeikyoShomeishoList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(source.get("サービス提供証明書").toString()),
                new RString(source.get("事業者").toString()),
                btnGokei));
        infoDiv.getShokanShikyuTorokuShomeishoListInfo().getDgServiceTeikyoShomeishoList().setDataSource(dgRowList);
    }
}
