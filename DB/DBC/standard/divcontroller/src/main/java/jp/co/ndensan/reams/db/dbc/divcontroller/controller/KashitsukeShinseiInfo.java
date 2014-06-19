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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
     * @param info info
     * @param list list
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiInfoDiv> onClickAddButton(KashitsukeShinseiInfoDiv info, KashitsukeShinseiListDiv list) {
        ResponseData<KashitsukeShinseiInfoDiv> response = new ResponseData<>();

        int index = -1;
        info.getTxtKashitsukeShinseiListSelectedIndex().setValue(new RString(String.valueOf(index)));

        ViewStateHolder.put("selectedIndex", new RString(String.valueOf(index)));

        setSummaryData(info, list);
        setServiceData(info);
        setShinseishaData(info);
        setHoshoninData(info);
        setHoshoninKinmusakiData(info);
        setTeishutsuData(info);
        response.data = info;
        return response;
    }

    /**
     * 申請書一覧で行の「選択」を押下したときの給付費貸付金申請情報パネルの処理です。
     *
     * @param info info
     * @param list list
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiInfoDiv> onSelectedShinseiList(KashitsukeShinseiInfoDiv info, KashitsukeShinseiListDiv list) {
        ResponseData<KashitsukeShinseiInfoDiv> response = new ResponseData<>();

        int index = list.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getClickedRowId();
        info.getTxtKashitsukeShinseiListSelectedIndex().setValue(new RString(String.valueOf(index)));

        ViewStateHolder.put("selectedIndex", new RString(String.valueOf(index)));

        setSummaryData(info, list);
        setServiceData(info);
        setShinseishaData(info);
        setHoshoninData(info);
        setHoshoninKinmusakiData(info);
        setTeishutsuData(info);
        response.data = info;
        return response;
    }

    /**
     * 「被保険者情報をコピーする」を押下したときの給付費貸付金申請情報パネルの処理です。
     *
     * @param info info
     * @param list list
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiInfoDiv> onClickShinseishaCopy(KashitsukeShinseiInfoDiv info, KashitsukeShinseiListDiv list) {
        ResponseData<KashitsukeShinseiInfoDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(getYaml().get(6));

        KashitsukeShinseishaDiv div = info.getKashitsukeShinseisha();
        div.getTxtShinseishaName().setValue(cg.getAsRString("氏名"));
        div.getTxtShinseishaKana().setValue(cg.getAsRString("カナ"));
        div.getTxtShinseishaKankei().setValue(cg.getAsRString("被保険者との関係"));
        div.getTxtShinseishaYubinNo().setValue(new YubinNo(cg.getAsRString("郵便番号")));
        div.getTxtShinseishaJusho().setValue(cg.getAsRString("住所"));
        div.getTxtShinseishaTelNo().setValue(cg.getAsRString("電話番号"));
        response.data = info;
        return response;
    }

    private void setSummaryData(KashitsukeShinseiInfoDiv info, KashitsukeShinseiListDiv list) {
        int index = Integer.parseInt(info.getTxtKashitsukeShinseiListSelectedIndex().getValue().toString());
        if (index == -1) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(0));

            info.getTxtShinseiYMD().setValue(new RDate(cg.getAsRString("申請日").toString()));
            info.getTxtRiyoKikan().setFromValue(new RDate(cg.getAsRString("利用期間開始日").toString()));
            info.getTxtRiyoKikan().setToValue(new RDate(cg.getAsRString("利用期間終了日").toString()));
            info.getTxtSeikyugaku().setValue(new Decimal(cg.getAsRString("事業者の支払い請求額").toString()));
            info.getTxtShinseiKingaku().setValue(new Decimal(cg.getAsRString("申請金額").toString()));
        } else {
            dgKyufuhiKashitsukekinList_Row row = list.getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource().get(index);

            info.getTxtShinseiYMD().setValue(new RDate(makeDateString(row.getTxtShinseiYMD().toString())));
            info.getTxtRiyoKikan().setFromValue(new RDate(makeDateString(row.getTxtKaishiYMD().toString())));
            info.getTxtRiyoKikan().setToValue(new RDate(makeDateString(row.getTxtShuryoYMD().toString())));
            info.getTxtSeikyugaku().setValue(new Decimal(row.getTxtSeikyugaku().toString()));
            info.getTxtShinseiKingaku().setValue(new Decimal(row.getTxtShinseigaku().toString()));
        }
    }

    private void setServiceData(KashitsukeShinseiInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(1));

        KashitsukeShinseiServiceDiv div = info.getKashitsukeShinseiService();
        KeyValueDataSource ds = new KeyValueDataSource(cg.getAsRString("key"), cg.getAsRString("value"));
        List<KeyValueDataSource> listDs = new ArrayList<>();
        listDs.add(ds);
        div.getChkService().setSelectedItems(listDs);
    }

    private void setShinseishaData(KashitsukeShinseiInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(2));

        KashitsukeShinseishaDiv div = info.getKashitsukeShinseisha();
        div.getTxtShinseishaName().setValue(cg.getAsRString("氏名"));
        div.getTxtShinseishaKana().setValue(cg.getAsRString("カナ"));
        div.getTxtShinseishaKankei().setValue(cg.getAsRString("被保険者との関係"));
        div.getTxtShinseishaYubinNo().setValue(new YubinNo(cg.getAsRString("郵便番号")));
        div.getTxtShinseishaJusho().setValue(cg.getAsRString("住所"));
        div.getTxtShinseishaTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setHoshoninData(KashitsukeShinseiInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(3));

        KashitsukeShinseiHoshoninDiv div = info.getKashitsukeShinseiHoshonin();
        div.getTxtHoshoninName().setValue(cg.getAsRString("氏名"));
        div.getTxtHoshoninKana().setValue(cg.getAsRString("カナ"));
        div.getTxtHoshoninSeiYMD().setValue(new RDate(cg.getAsRString("生年月日").toString()));
        div.getRadHoshoninSeibetsu().setSelectedItem(cg.getAsRString("性別"));
        div.getTxtHoshoninKankei().setValue(cg.getAsRString("申請者との関係"));
        div.getTxtHoshoninYubinNo().setValue(new YubinNo(cg.getAsRString("郵便番号")));
        div.getTxtHoshoninJusho().setValue(cg.getAsRString("住所"));
        div.getTxtHoshoninTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setHoshoninKinmusakiData(KashitsukeShinseiInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));

        KashitsukeShinseiHoshoninKinmuDiv div = info.getKashitsukeShinseiHoshonin().getKashitsukeShinseiHoshoninKinmu();
        div.getTxtHoshoninKinmuName().setValue(cg.getAsRString("名称"));
        div.getTxtHoshoninKinmuJusho().setValue(cg.getAsRString("所在地"));
        div.getTxtHoshoninKinmuTelNo().setValue(cg.getAsRString("電話番号"));
    }

    private void setTeishutsuData(KashitsukeShinseiInfoDiv info) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(5));

        KashitsukeShinseiTeishutsuDiv div = info.getKashitsukeShinseiTeishutsu();
        KeyValueDataSource ds = new KeyValueDataSource(cg.getAsRString("key"), cg.getAsRString("value"));
        List<KeyValueDataSource> listDs = new ArrayList<>();
        listDs.add(ds);

        div.getChkSeikyuRyoshusho().setSelectedItems(listDs);
        div.getTxtTeishutsuKanriNo().setValue(cg.getAsRString("提出物管理番号"));
    }

    private String makeDateString(String date) {
        return new FlexibleDate(date.replace(".", "")).toString();
    }
}
