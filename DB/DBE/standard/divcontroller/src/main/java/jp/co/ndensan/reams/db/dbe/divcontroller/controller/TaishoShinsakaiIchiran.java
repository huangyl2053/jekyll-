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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030001.TaishoShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030001.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査結果入力を行う対象審査会を一覧で表示します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakaiIchiran {

    static final int SELECT_IDX = 0;

    /**
     * 審査会審査結果入力対象の審査会一覧画面のロード時の内容設定を行います。
     *
     * @param div 対象審査会一覧Div
     * @return ResponseData
     */
    public ResponseData onLoadData(TaishoShinsakaiIchiranDiv div) {
        ResponseData<TaishoShinsakaiIchiranDiv> response = new ResponseData<>();

        div.getDgShinsakaiIchiran().setDataSource(createRowShinsakaiTestData());
        response.data = div;
        return response;
    }

    /**
     * データグリッドの登録ボタン押下時の処理を押下した時の処理を表します
     *
     * @param div 対象審査会一覧Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToroku(TaishoShinsakaiIchiranDiv div) {
        ResponseData<TaishoShinsakaiIchiranDiv> response = new ResponseData<>();

        dgShinsakaiIchiran_Row dataRow = div.getDgShinsakaiIchiran().getSelectedItems().get(SELECT_IDX);

        ViewStateHolder.put("審査会番号", dataRow.get審査会名());

        response.data = div;
        return response;
    }

    /**
     * 審査会審査結果入力対象の審査会一覧画面の再ロードした時の内容設定を行います。
     *
     * @param div 対象審査会一覧Div
     * @return ResponseData
     */
    public ResponseData reLoadData(TaishoShinsakaiIchiranDiv div) {
        ResponseData<TaishoShinsakaiIchiranDiv> response = new ResponseData<>();

        div.getDgShinsakaiIchiran().getSelectedItems().get(SELECT_IDX).set審査会状況(new RString("開催済"));

        response.data = div;
        return response;
    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsakaiIchiran_Row> createRowShinsakaiTestData() {
        List<dgShinsakaiIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5030001/ShinsakaiIchiranList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiIchiran_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiIchiran_Row toDgShinsakaiIchiran_Row(Map map) {
        ControlGenerator ymlData = new ControlGenerator(map);
        RString shinsakai = ymlData.getAsRString("審査会名");
        RString gogitai = ymlData.getAsRString("合議体");
        RString kaijo = ymlData.getAsRString("審査会会場");
        TextBoxFlexibleDate kaisaiDate = ymlData.getAsTextBoxFlexibleDate("開催日");
        RString startTime = ymlData.getAsRString("開始時間");
        RString endTime = ymlData.getAsRString("終了時間");
        RString taishoNinzu = ymlData.getAsRString("対象人数");
        RString jokyo = ymlData.getAsRString("状況");
        Button btn = new Button();
        dgShinsakaiIchiran_Row row = new dgShinsakaiIchiran_Row(btn, shinsakai, gogitai, kaijo, kaisaiDate,
                startTime, endTime, taishoNinzu, jokyo);
        return row;
    }

}
