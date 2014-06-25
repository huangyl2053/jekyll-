/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310003.HonKakushuTsuchiUchiwakeKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310003.HonKakushuTsuchiUchiwakeSentakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310003.dgKakushuTsuchiUchiwakeSentaku_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310003.dgTsuchishoSettei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 *
 * @author n8211 田辺 紘一
 */
public class HonKakushuTsuchiUchiwakeKakunin {

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onLoad(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(honKakushuTsuchiUchiwakeKakuninDiv, new RString("初期"));

        response.data = honKakushuTsuchiUchiwakeKakuninDiv;
        return response;
    }

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onSelect(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(honKakushuTsuchiUchiwakeKakuninDiv, new RString("選択"));

        response.data = honKakushuTsuchiUchiwakeKakuninDiv;
        return response;
    }

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onClick(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(honKakushuTsuchiUchiwakeKakuninDiv, new RString("押下"));

        response.data = honKakushuTsuchiUchiwakeKakuninDiv;
        return response;
    }

    private void setParam(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv, RString mode) {

        RString No = null;
        if (mode.contains("初期")) {
            setHonKakushuTsuchiUchiwakeSentaku(honKakushuTsuchiUchiwakeKakuninDiv);
            No = new RString("1");

        } else if (mode.contains("選択")) {
            List<dgKakushuTsuchiUchiwakeSentaku_Row> seletedSettei;
            seletedSettei = honKakushuTsuchiUchiwakeKakuninDiv.getHonKakushuTsuchiUchiwakeSentaku().getDgKakushuTsuchiUchiwakeSentaku().getSelectedItems();
            for (dgKakushuTsuchiUchiwakeSentaku_Row selectData : seletedSettei) {
                No = selectData.getTxtUchiwake();
            }
        } else if (mode.contains("押下")) {

            dgKakushuTsuchiUchiwakeSentaku_Row clickedItem;
            clickedItem = honKakushuTsuchiUchiwakeKakuninDiv.getHonKakushuTsuchiUchiwakeSentaku().getDgKakushuTsuchiUchiwakeSentaku().getClickedItem();
            No = clickedItem.getTxtUchiwake();
        }

        setDgTsuchishoSettei(honKakushuTsuchiUchiwakeKakuninDiv, No);
    }

    private void setHonKakushuTsuchiUchiwakeSentaku(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv) {
        HonKakushuTsuchiUchiwakeSentakuDiv uchiwakeSentakuDiv = honKakushuTsuchiUchiwakeKakuninDiv.getHonKakushuTsuchiUchiwakeSentaku();

        List<HashMap> uchiwakeHohoData = YamlLoader.DBB.loadAsList(new RString("HonKakushuTsuchiUchiwakeKakunin/Uchiwake.yml"));

        List<dgKakushuTsuchiUchiwakeSentaku_Row> arrayData = new ArrayList<>();
        dgKakushuTsuchiUchiwakeSentaku_Row item;

        for (int i = 1; i <= Integer.parseInt(uchiwakeHohoData.get(0).get("データ数").toString()); i++) {
            String No = (String) uchiwakeHohoData.get(i).get("内訳No");
            String 内容 = (String) uchiwakeHohoData.get(i).get("内容");

            item = createRowUchiwakeHoho(
                    No, 内容);
            arrayData.add(item);
        }

        DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> grid = uchiwakeSentakuDiv.getDgKakushuTsuchiUchiwakeSentaku();
        grid.setDataSource(arrayData);
    }

    private void setDgTsuchishoSettei(HonKakushuTsuchiUchiwakeKakuninDiv honKakushuTsuchiUchiwakeKakuninDiv, RString No) {
        List<HashMap> tsuchishoSetteiData = YamlLoader.DBB.loadAsList(new RString("HonKakushuTsuchiUchiwakeKakunin/TsuchishoSettei.yml"));

        List<dgTsuchishoSettei_Row> arrayData = new ArrayList<>();
        dgTsuchishoSettei_Row item;

        for (int i = 1; i <= Integer.parseInt(tsuchishoSetteiData.get(0).get("データ数").toString()); i++) {
            if (No.contains((String) tsuchishoSetteiData.get(i).get("設定No"))) {
                String 徴収方法 = (String) tsuchishoSetteiData.get(i).get("徴収方法");
                String 状態 = (String) tsuchishoSetteiData.get(i).get("状態");
                String 通知書 = (String) tsuchishoSetteiData.get(i).get("通知書");
                String 対象者 = (String) tsuchishoSetteiData.get(i).get("対象者");
                String 出力順グループ = (String) tsuchishoSetteiData.get(i).get("出力順グループ");

                item = createRowTsuchishoSettei(
                        徴収方法, 状態, 通知書, 対象者, 出力順グループ);
                arrayData.add(item);
            }
        }
        DataGrid<dgTsuchishoSettei_Row> grid = honKakushuTsuchiUchiwakeKakuninDiv.getDgTsuchishoSettei();
        grid.setDataSource(arrayData);

        for (int i = 0; i < 7; i++) {
            grid.getDataSource().get(i).getTxtGenkinKozaShitei().setDisabled(true);
        }
    }

    private dgKakushuTsuchiUchiwakeSentaku_Row createRowUchiwakeHoho(String No, String 内容) {
        dgKakushuTsuchiUchiwakeSentaku_Row rowUchiwakeHohoData = new dgKakushuTsuchiUchiwakeSentaku_Row(new Button(), RString.EMPTY, RString.EMPTY);

        rowUchiwakeHohoData.setTxtJokenMeisho(new RString(内容));
        rowUchiwakeHohoData.setTxtUchiwake(new RString(No));

        return rowUchiwakeHohoData;
    }

    private dgTsuchishoSettei_Row createRowTsuchishoSettei(String 徴収方法, String 状態, String 通知書, String 対象者, String 出力順グループ) {
        dgTsuchishoSettei_Row rowTsuchishoSetteiData = new dgTsuchishoSettei_Row(RString.EMPTY, RString.EMPTY, new DropDownList(), new DropDownList(), new TextBox());

        if (通知書.equals("決定通知書")) {
            通知書 = "key0";
        } else if (通知書.equals("変更兼特徴中止通知書")) {
            通知書 = "key1";
        } else if (通知書.equals("発行しない")) {
            通知書 = "key2";
        }

        if (出力順グループ == null) {
            出力順グループ = "";
        }

        rowTsuchishoSetteiData.setTxtChosyuHoho(new RString(徴収方法));
        rowTsuchishoSetteiData.setTxtJotai(new RString(状態));
        rowTsuchishoSetteiData.getTxtTsuchisyoShitei().setSelectedItem(new RString(通知書));
        rowTsuchishoSetteiData.getTxtGenkinKozaShitei().setSelectedItem(new RString(対象者));
        rowTsuchishoSetteiData.getTxtHakkojiGroup().setValue(new RString(出力順グループ));

        return rowTsuchishoSetteiData;
    }
}
