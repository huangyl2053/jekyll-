/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog.ChosaKikanDialogDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog.dgKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 調査機関ダイアログの処理を表します。
 *
 * @author N1013 松本直樹
 */
public class ChosaKikanDialog {

    /**
     * ロード時の処理です。
     *
     * @param div ChosaKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKikanDialogDiv> onLoad(ChosaKikanDialogDiv div) {
        ResponseData<ChosaKikanDialogDiv> response = new ResponseData<>();

        div.getDgKikanIchiran().setDataSource(createListOfKikanIchiran());
        List<dgChosainIchiran_Row> list = new ArrayList<>();
        div.getDgChosainIchiran().setDataSource(list);

        response.data = div;
        return response;
    }

    /**
     * 機関一覧の機関選択時の処理です。
     *
     * @param div ChosaKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKikanDialogDiv> onSelect_dgKikanIchiran(ChosaKikanDialogDiv div) {
        ResponseData<ChosaKikanDialogDiv> response = new ResponseData<>();
        RString ymlFile = new RString("ChosaKikanDialog/ChosainList"
                + div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo() + ".yml");
        div.getDgChosainIchiran().setDataSource(createListOfChosainIchiran(ymlFile));

        div.setChosaItakusakiCode(div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo());
        div.setChosaItakusakiName(div.getDgKikanIchiran().getSelectedItems().get(0).getKikanMeisho());

        response.data = div;
        return response;
    }

    /**
     * 調査員一覧の調査員選択時の処理です。
     *
     * @param div ChosaKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKikanDialogDiv> onSelect_dgChosainIchiran(ChosaKikanDialogDiv div) {
        ResponseData<ChosaKikanDialogDiv> response = new ResponseData<>();

        div.setChosainCode(div.getDgChosainIchiran().getSelectedItems().get(0).getChosainNo());
        div.setChosainName(div.getDgChosainIchiran().getSelectedItems().get(0).getChosainMeisho());

        response.data = div;
        return response;
    }

    /**
     * 「選択する」ボタン押下時の処理を表します。
     *
     * @param div ChosaKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<ChosaKikanDialogDiv> onClick_btnSelectKikan(ChosaKikanDialogDiv div) {
        ResponseData<ChosaKikanDialogDiv> response = new ResponseData<>();

        ViewStateHolder.put("機関番号", div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo());
        ViewStateHolder.put("機関名称", div.getDgKikanIchiran().getSelectedItems().get(0).getKikanMeisho());

        if (!div.getDgChosainIchiran().getSelectedItems().isEmpty()) {
            ViewStateHolder.put("調査員番号", div.getDgChosainIchiran().getSelectedItems().get(0).getChosainNo());
            ViewStateHolder.put("調査員名", div.getDgChosainIchiran().getSelectedItems().get(0).getChosainMeisho());
        }

        response.data = div;
        return response;
    }

    private static List<dgKikanIchiran_Row> createListOfKikanIchiran() {
        List<dgKikanIchiran_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("ChosaKikanDialog/ChosaKikanList.yml"));
        for (Map info : targetSource) {
            list.add(toDgKikanIchiran_Row(info));
        }
        return list;
    }

    private static List<dgChosainIchiran_Row> createListOfChosainIchiran(RString yml) {
        List<dgChosainIchiran_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(yml);
        for (Map info : targetSource) {
            list.add(toDgChosainIchiran_Row(info));
        }
        return list;
    }

    private static dgKikanIchiran_Row toDgKikanIchiran_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString kikanNo = cg.getAsRString("機関番号");
        RString kikanMeisho = cg.getAsRString("機関名称");
        dgKikanIchiran_Row row = new dgKikanIchiran_Row(kikanNo, kikanMeisho);
        return row;
    }

    private static dgChosainIchiran_Row toDgChosainIchiran_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString chosainNo = cg.getAsRString("調査員番号");
        RString chosainMeisho = cg.getAsRString("調査員名");
        dgChosainIchiran_Row row = new dgChosainIchiran_Row(chosainNo, chosainMeisho);
        return row;
    }
}
