/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiHoshoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiHoshoninKinmuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiServiceDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiTeishutsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付費貸付金申請登録の給付費貸付金申請情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KashitsukeShinseiInfo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc1800000/KashitsukeShinseiInfo.yml"));
    }

    /**
     * 申請書一覧で「申請書情報を追加する」ボタンを押下したときの給付費貸付金申請情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onClickAddButton(KashitsukeShinseiTorokuDiv panel) {
        ResponseData<KashitsukeShinseiTorokuDiv> response = new ResponseData<>();

        int index = -1;
        panel.getKashitsukeShinseiInfo().getTxtKashitsukeShinseiListSelectedIndex().setValue(new RString(String.valueOf(index)));

        ViewStateHolder.put("selectedIndex", new RString(String.valueOf(index)));

        setSummaryData(panel.getKashitsukeShinseiInfo(), panel.getKashitsukeShinseiList());
        setServiceData(panel.getKashitsukeShinseiInfo());
        setShinseishaData(panel.getKashitsukeShinseiInfo());
        setHoshoninData(panel.getKashitsukeShinseiInfo());
        setHoshoninKinmusakiData(panel.getKashitsukeShinseiInfo());
        setTeishutsuData(panel.getKashitsukeShinseiInfo());
        response.data = panel;
        return response;
    }

    /**
     * 申請書一覧で行の「選択」を押下したときの給付費貸付金申請情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onSelectedShinseiList(KashitsukeShinseiTorokuDiv panel) {
        ResponseData<KashitsukeShinseiTorokuDiv> response = new ResponseData<>();

        int index = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getClickedRowId();
        panel.getKashitsukeShinseiInfo().getTxtKashitsukeShinseiListSelectedIndex().setValue(new RString(String.valueOf(index)));

        ViewStateHolder.put("selectedIndex", new RString(String.valueOf(index)));

        setSummaryData(panel.getKashitsukeShinseiInfo(), panel.getKashitsukeShinseiList());
        setServiceData(panel.getKashitsukeShinseiInfo());
        setShinseishaData(panel.getKashitsukeShinseiInfo());
        setHoshoninData(panel.getKashitsukeShinseiInfo());
        setHoshoninKinmusakiData(panel.getKashitsukeShinseiInfo());
        setTeishutsuData(panel.getKashitsukeShinseiInfo());
        response.data = panel;
        return response;
    }

    /**
     * 「被保険者情報をコピーする」を押下したときの給付費貸付金申請情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiTorokuDiv> onClickShinseishaCopy(KashitsukeShinseiTorokuDiv panel) {
        ResponseData<KashitsukeShinseiTorokuDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(getYaml().get(6));

        KashitsukeShinseishaDiv div = panel.getKashitsukeShinseiInfo().getKashitsukeShinseisha();
        div.getTxtShinseishaName().setValue(cg.getAsRString("氏名"));
        div.getTxtShinseishaKana().setValue(cg.getAsRString("カナ"));
        div.getTxtShinseishaKankei().setValue(cg.getAsRString("被保険者との関係"));
        div.getTxtShinseishaYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
        div.getTxtShinseishaJusho().setValue(cg.getAsRString("住所"));
        div.getTxtShinseishaTelNo().setValue(cg.getAsRString("電話番号"));
        response.data = panel;
        return response;
    }

    private void setSummaryData(KashitsukeShinseiInfoDiv info, KashitsukeShinseiListDiv list) {
        int index = Integer.parseInt(info.getTxtKashitsukeShinseiListSelectedIndex().getValue().toString());
        dgKyufuhiKashitsukekinList_Row row = null;
        if (index != -1) {
            row = list.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource().get(index);
        }
        info.getTxtUketsukeYMD().setValue(row == null ? null : new RDate(makeDateString(row.getTxtUketsukeYMD().toString())));
        info.getTxtShinseiYMD().setValue(row == null ? null : new RDate(makeDateString(row.getTxtShinseiYMD().toString())));
        info.getTxtRiyoKikan().setFromValue(row == null ? null : new RDate(makeDateString(row.getTxtKaishiYMD().toString())));
        info.getTxtRiyoKikan().setToValue(row == null ? null : new RDate(makeDateString(row.getTxtShuryoYMD().toString())));
        info.getTxtSeikyugaku().setValue(row == null ? null : new Decimal(row.getTxtSeikyugaku().toString()));
        info.getTxtShinseiKingaku().setValue(row == null ? null : new Decimal(row.getTxtShinseigaku().toString()));
    }

    private void setServiceData(KashitsukeShinseiInfoDiv info) {
        boolean newFlg = isNew(info);
        KashitsukeShinseiServiceDiv div = info.getKashitsukeShinseiService();
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));
        KeyValueDataSource ds = new KeyValueDataSource(cg.getAsRString("key"), cg.getAsRString("value"));
        List<KeyValueDataSource> listDs = new ArrayList<>();
        if (!newFlg) {
            listDs.add(ds);
        }
        div.getChkService().setSelectedItems(listDs);
    }

    private void setShinseishaData(KashitsukeShinseiInfoDiv info) {
        boolean newFlg = isNew(info);
        KashitsukeShinseishaDiv div = info.getKashitsukeShinseisha();
        ControlGenerator cg = new ControlGenerator(getYaml().get(2));
        div.getTxtShinseishaName().setValue(cg.getAsRString(newFlg ? "" : "氏名"));
        div.getTxtShinseishaKana().setValue(cg.getAsRString(newFlg ? "" : "カナ"));
        div.getTxtShinseishaKankei().setValue(cg.getAsRString(newFlg ? "" : "被保険者との関係"));
        div.getTxtShinseishaYubinNo().setValue(cg.getAsYubinNo(newFlg ? "" : "郵便番号"));
        div.getTxtShinseishaJusho().setValue(cg.getAsRString(newFlg ? "" : "住所"));
        div.getTxtShinseishaTelNo().setValue(cg.getAsRString(newFlg ? "" : "電話番号"));
    }

    private void setHoshoninData(KashitsukeShinseiInfoDiv info) {
        boolean newFlg = isNew(info);
        KashitsukeShinseiHoshoninDiv div = info.getKashitsukeShinseiHoshonin();
        ControlGenerator cg = new ControlGenerator(getYaml().get(3));
        div.getTxtHoshoninName().setValue(cg.getAsRString(newFlg ? "" : "氏名"));
        div.getTxtHoshoninKana().setValue(cg.getAsRString(newFlg ? "" : "カナ"));
        div.getTxtHoshoninSeiYMD().setValue(cg.getAsRDate(newFlg ? "" : "生年月日"));
        div.getRadHoshoninSeibetsu().setSelectedItem(newFlg ? new RString("key0") : cg.getAsRString("性別"));
        div.getTxtHoshoninKankei().setValue(cg.getAsRString(newFlg ? "" : "申請者との関係"));
        div.getTxtHoshoninYubinNo().setValue(cg.getAsYubinNo(newFlg ? "" : "郵便番号"));
        div.getTxtHoshoninJusho().setValue(cg.getAsRString(newFlg ? "" : "住所"));
        div.getTxtHoshoninTelNo().setValue(cg.getAsRString(newFlg ? "" : "電話番号"));
    }

    private void setHoshoninKinmusakiData(KashitsukeShinseiInfoDiv info) {
        boolean newFlg = isNew(info);
        KashitsukeShinseiHoshoninKinmuDiv div = info.getKashitsukeShinseiHoshonin().getKashitsukeShinseiHoshoninKinmu();
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));
        div.getTxtHoshoninKinmuName().setValue(cg.getAsRString(newFlg ? "" : "名称"));
        div.getTxtHoshoninKinmuJusho().setValue(cg.getAsRString(newFlg ? "" : "所在地"));
        div.getTxtHoshoninKinmuTelNo().setValue(cg.getAsRString(newFlg ? "" : "電話番号"));
    }

    private void setTeishutsuData(KashitsukeShinseiInfoDiv info) {
        boolean newFlg = isNew(info);
        KashitsukeShinseiTeishutsuDiv div = info.getKashitsukeShinseiTeishutsu();
        ControlGenerator cg = new ControlGenerator(getYaml().get(5));
        KeyValueDataSource ds = new KeyValueDataSource(cg.getAsRString("key"), cg.getAsRString("value"));
        List<KeyValueDataSource> listDs = new ArrayList<>();
        if (!newFlg) {
            listDs.add(ds);
        }
        div.getChkSeikyuRyoshusho().setSelectedItems(listDs);
        div.getTxtTeishutsuKanriNo().setValue(cg.getAsRString(newFlg ? "" : "提出物管理番号"));
    }

    private String makeDateString(String date) {
        return new FlexibleDate(date.replace(".", "")).toString();
    }

    private boolean isNew(KashitsukeShinseiInfoDiv info) {
        return Integer.parseInt(info.getTxtKashitsukeShinseiListSelectedIndex().getValue().toString()) == -1;
    }
}
