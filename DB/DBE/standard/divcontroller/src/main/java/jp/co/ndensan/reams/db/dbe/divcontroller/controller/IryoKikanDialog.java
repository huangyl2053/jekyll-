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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanDialog.IryoKikanDialogDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanDialog.dgKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanDialog.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 医療機関ダイアログの処理を表します。
 *
 * @author N1013 松本直樹
 */
public class IryoKikanDialog {

    /**
     * ロード時の処理です。
     *
     * @param div IryoKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanDialogDiv> onLoad(IryoKikanDialogDiv div) {
        ResponseData<IryoKikanDialogDiv> response = new ResponseData<>();

        div.getDgKikanIchiran().setDataSource(createListOfKikanIchiran());
        List<dgShujiiIchiran_Row> list = new ArrayList<>();
        div.getDgShujiiIchiran().setDataSource(list);

        response.data = div;
        return response;
    }

    /**
     * 機関一覧の機関選択時の処理です。
     *
     * @param div IryoKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanDialogDiv> onSelect_dgKikanIchiran(IryoKikanDialogDiv div) {
        ResponseData<IryoKikanDialogDiv> response = new ResponseData<>();
        RString ymlFile = new RString("IryoKikanDialog/IshiList"
                + div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo() + ".yml");
        div.getDgShujiiIchiran().setDataSource(createListOfShujiiIchiran(ymlFile));

        div.setIryokikanCode(div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo());
        div.setIryokikanName(div.getDgKikanIchiran().getSelectedItems().get(0).getKikanMeisho());

        response.data = div;
        return response;
    }

    /**
     * 医師一覧の医師選択時の処理です。
     *
     * @param div IryoKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanDialogDiv> onSelect_dgIshiIchiran(IryoKikanDialogDiv div) {
        ResponseData<IryoKikanDialogDiv> response = new ResponseData<>();

        div.setIshiCode(div.getDgShujiiIchiran().getSelectedItems().get(0).getIshiNo());
        div.setIshiName(div.getDgShujiiIchiran().getSelectedItems().get(0).getIshiMeisho());

        response.data = div;
        return response;
    }

    /**
     * 「選択する」ボタン押下時の処理を表します。
     *
     * @param div IryoKikanDialogDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanDialogDiv> onClick_btnSelectKikan(IryoKikanDialogDiv div) {
        ResponseData<IryoKikanDialogDiv> response = new ResponseData<>();

        ViewStateHolder.put("機関番号", div.getDgKikanIchiran().getSelectedItems().get(0).getKikanNo());
        ViewStateHolder.put("機関名称", div.getDgKikanIchiran().getSelectedItems().get(0).getKikanMeisho());

        if (!div.getDgShujiiIchiran().getSelectedItems().isEmpty()) {
            ViewStateHolder.put("医師番号", div.getDgShujiiIchiran().getSelectedItems().get(0).getIshiNo());
            ViewStateHolder.put("医師名", div.getDgShujiiIchiran().getSelectedItems().get(0).getIshiMeisho());
        }

        response.data = div;
        return response;
    }

    private static List<dgKikanIchiran_Row> createListOfKikanIchiran() {
        List<dgKikanIchiran_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("IryoKikanDialog/IryoKikanList.yml"));
        for (Map info : targetSource) {
            list.add(toDgKikanIchiran_Row(info));
        }
        return list;
    }

    private static List<dgShujiiIchiran_Row> createListOfShujiiIchiran(RString yml) {
        List<dgShujiiIchiran_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(yml);
        for (Map info : targetSource) {
            list.add(toDgShujiiIchiran_Row(info));
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

    private static dgShujiiIchiran_Row toDgShujiiIchiran_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString ishiNo = cg.getAsRString("医師番号");
        RString ishiMeisho = cg.getAsRString("医師名");
        dgShujiiIchiran_Row row = new dgShujiiIchiran_Row(ishiNo, ishiMeisho);
        return row;
    }
}
