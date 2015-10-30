/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.HonKakushuTsuchiUchiwakeKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.HonKakushuTsuchiUchiwakeSentakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.dgKakushuTsuchiUchiwakeSentaku_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.dgTsuchishoSettei_Row;
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

    private static final int LENGTH = 7;

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onLoad(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(div, new RString("初期"));

        response.data = div;
        return response;
    }

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onSelect(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(div, new RString("選択"));

        response.data = div;
        return response;
    }

    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onClick(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> response = new ResponseData<>();

        setParam(div, new RString("押下"));

        response.data = div;
        return response;
    }

    private void setParam(HonKakushuTsuchiUchiwakeKakuninDiv div, RString mode) {

        RString no = null;
        if (mode.contains("初期")) {
            setHonKakushuTsuchiUchiwakeSentaku(div);
            no = new RString("1");

        } else if (mode.contains("選択")) {
            List<dgKakushuTsuchiUchiwakeSentaku_Row> seletedSettei;
            seletedSettei = div.getHonKakushuTsuchiUchiwakeSentaku().getDgKakushuTsuchiUchiwakeSentaku().getSelectedItems();
            for (dgKakushuTsuchiUchiwakeSentaku_Row selectData : seletedSettei) {
                no = selectData.getTxtUchiwake();
            }
        } else if (mode.contains("押下")) {

            dgKakushuTsuchiUchiwakeSentaku_Row clickedItem;
            clickedItem = div.getHonKakushuTsuchiUchiwakeSentaku().getDgKakushuTsuchiUchiwakeSentaku().getClickedItem();
            no = clickedItem.getTxtUchiwake();
        }

        setDgTsuchishoSettei(div, no);
    }

    private void setHonKakushuTsuchiUchiwakeSentaku(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        HonKakushuTsuchiUchiwakeSentakuDiv uchiwakeSentakuDiv = div.getHonKakushuTsuchiUchiwakeSentaku();

        List<HashMap> uchiwakeHohoData = YamlLoader.DBB.loadAsList(new RString("HonKakushuTsuchiUchiwakeKakunin/Uchiwake.yml"));

        List<dgKakushuTsuchiUchiwakeSentaku_Row> arrayData = new ArrayList<>();
        dgKakushuTsuchiUchiwakeSentaku_Row item;

        for (int i = 1; i <= Integer.parseInt(uchiwakeHohoData.get(0).get("データ数").toString()); i++) {
            RString no = (RString) uchiwakeHohoData.get(i).get("内訳No");
            RString 内容 = (RString) uchiwakeHohoData.get(i).get("内容");

            item = createRowUchiwakeHoho(
                    no, 内容);
            arrayData.add(item);
        }

        DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> grid = uchiwakeSentakuDiv.getDgKakushuTsuchiUchiwakeSentaku();
        grid.setDataSource(arrayData);
    }

    private void setDgTsuchishoSettei(HonKakushuTsuchiUchiwakeKakuninDiv div, RString no) {
        List<HashMap> tsuchishoSetteiData = YamlLoader.DBB.loadAsList(new RString("HonKakushuTsuchiUchiwakeKakunin/TsuchishoSettei.yml"));

        List<dgTsuchishoSettei_Row> arrayData = new ArrayList<>();
        dgTsuchishoSettei_Row item;

        for (int i = 1; i <= Integer.parseInt(tsuchishoSetteiData.get(0).get("データ数").toString()); i++) {
            if (no.contains((RString) tsuchishoSetteiData.get(i).get("設定No"))) {
                RString 徴収方法 = (RString) tsuchishoSetteiData.get(i).get("徴収方法");
                RString 状態 = (RString) tsuchishoSetteiData.get(i).get("状態");
                RString 通知書 = (RString) tsuchishoSetteiData.get(i).get("通知書");
                RString 対象者 = (RString) tsuchishoSetteiData.get(i).get("対象者");
                RString 出力順グループ = (RString) tsuchishoSetteiData.get(i).get("出力順グループ");

                item = createRowTsuchishoSettei(
                        徴収方法, 状態, 通知書, 対象者, 出力順グループ);
                arrayData.add(item);
            }
        }
        DataGrid<dgTsuchishoSettei_Row> grid = div.getDgTsuchishoSettei();
        grid.setDataSource(arrayData);

        for (int i = 0; i < LENGTH; i++) {
            grid.getDataSource().get(i).getTxtGenkinKozaShitei().setDisabled(true);
        }
    }

    private dgKakushuTsuchiUchiwakeSentaku_Row createRowUchiwakeHoho(RString no, RString 内容) {
        dgKakushuTsuchiUchiwakeSentaku_Row rowUchiwakeHohoData = new dgKakushuTsuchiUchiwakeSentaku_Row(new Button(), RString.EMPTY, RString.EMPTY);

        rowUchiwakeHohoData.setTxtJokenMeisho(内容);
        rowUchiwakeHohoData.setTxtUchiwake(no);

        return rowUchiwakeHohoData;
    }

    private dgTsuchishoSettei_Row createRowTsuchishoSettei(RString 徴収方法, RString 状態, RString 通知書, RString 対象者, RString 出力順グループ) {
        dgTsuchishoSettei_Row rowTsuchishoSetteiData = new dgTsuchishoSettei_Row(RString.EMPTY, RString.EMPTY, new DropDownList(), new DropDownList(), new TextBox());

        if (new RString("決定通知書").equals(通知書)) {
            通知書 = new RString("key0");
        } else if (new RString("変更兼特徴中止通知書").equals(通知書)) {
            通知書 = new RString("key1");
        } else if (new RString("発行しない").equals(通知書)) {
            通知書 = new RString("key2");
        }

        if (出力順グループ == null) {
            出力順グループ = new RString("");
        }

        rowTsuchishoSetteiData.setTxtChosyuHoho(徴収方法);
        rowTsuchishoSetteiData.setTxtJotai(状態);
        rowTsuchishoSetteiData.getTxtTsuchisyoShitei().setSelectedItem(通知書);
        rowTsuchishoSetteiData.getTxtGenkinKozaShitei().setSelectedItem(対象者);
        rowTsuchishoSetteiData.getTxtHakkojiGroup().setValue(出力順グループ);

        return rowTsuchishoSetteiData;
    }
}
