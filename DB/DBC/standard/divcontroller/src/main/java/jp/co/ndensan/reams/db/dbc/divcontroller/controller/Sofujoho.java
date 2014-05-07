/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SofujohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSofuIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 過誤申立書送付情報照会画面です。
 *
 * @author N3317 塚田 萌
 */
public class Sofujoho {

    final int 未送付 = 0;
    final int 送付済 = 1;
    final int 最新 = 2;

    /**
     * パネル読み込み時は最新の送付情報を表示します。
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onLoad(SofujohoDiv panel) {
        set送付年月(panel, 最新);
        set送付情報List(panel, 送付済);

        ResponseData<SofujohoDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

    /**
     * 未送付情報を表示するボタンで未送付情報一覧を表示します。
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onClick_btnMisofu(SofujohoDiv panel) {
        set送付年月(panel, 未送付);
        set送付情報List(panel, 未送付);

        ResponseData<SofujohoDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

    /**
     * 送付年月を指定して表示するボタンで指定年月の送付済情報を表示します。
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onClick_btnSofuzumi(SofujohoDiv panel) {
        set送付情報List(panel, 送付済);

        ResponseData<SofujohoDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

    private void set送付年月(SofujohoDiv panel, int dataType) {
        switch (dataType) {
            case 未送付:
                panel.getTxtSofuYM().setValue(null);
                break;
            case 最新:
                //TODO 最新の情報がある年月を取得・設定する。
                RDate recentlyYearMonth = new RDate("201404");
                panel.getTxtSofuYM().setValue(recentlyYearMonth);
                break;
        }
    }

    private void set送付情報List(SofujohoDiv panel, int dataType) {
        List<dgSofuIchiran_Row> list = null;
        switch (dataType) {
            case 未送付:
                list = create未送付情報List();
                break;
            case 送付済:
                //TODO 送付年月をキーにして該当情報を取得・設定する。
                list = create送付済情報List();
                list = get送付情報By送付年月(panel.getTxtSofuYM(), list);
                break;
        }
        DataGrid<dgSofuIchiran_Row> grid = panel.getSofuIchiran().getDgSofuIchiran();
        grid.setDataSource(list);
    }

    private List<dgSofuIchiran_Row> get送付情報By送付年月(
            TextBoxDate 送付年月, List<dgSofuIchiran_Row> list) {

        List<dgSofuIchiran_Row> selectedList = new ArrayList<>();
        for (dgSofuIchiran_Row row : list) {
            //デモでは送付年月とサービス提供年月が一致したものを抽出する
            if (row.getTxtServiceTeikyoYM().getValue().equals(送付年月.getValue())) {
                selectedList.add(row);
            }
        }
        return selectedList;
    }

    private List<dgSofuIchiran_Row> create未送付情報List() {
        List<dgSofuIchiran_Row> list = new ArrayList<>();
        dgSofuIchiran_Row row;

        row = createRow("0000000001", "たいよう", "0000000001", "未送　一郎", "1:サービス事業所等申立",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201406", "20110407", "000003");
        list.add(row);

        row = createRow("0000000001", "たいよう", "0000000002", "未送　二郎", "2:保険者申立",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201406", "20110407", "000003");
        list.add(row);

        return list;
    }

    private List<dgSofuIchiran_Row> create送付済情報List() {
        List<dgSofuIchiran_Row> list = new ArrayList<>();
        dgSofuIchiran_Row row;

        for (int i = 0; i < 50; i++) {
            row = createRow("0000000001", "ひまわり", "0000000011", "最新　一郎", "2:保険者申立",
                    "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                    "201404", "20110407", "000003");
            list.add(row);
        }

        row = createRow("0000000001", "ひまわり", "0000000012", "最新　二郎", "3:公費負担者申立等の区分",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201404", "20110407", "000003");
        list.add(row);

        row = createRow("0000000001", "ひまわり", "0000000013", "過去　一郎", "2:保険者申立",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "20110407", "000003");
        list.add(row);

        row = createRow("0000000001", "ひまわり", "0000000014", "過去　二郎", "2:保険者申立",
                "21:居宅サービス介護給付費明細書(短期入所生活介護)", "02:請求誤りによる実績取り下げ",
                "201402", "20110407", "000003");
        list.add(row);

        return list;
    }

    private dgSofuIchiran_Row createRow(String 事業者番号, String 事業者名,
            String 被保番号, String 氏名, String 申立者区分, String 様式, String 申立理由,
            String サービス提供年月, String 申立日, String 証記載保険者番号) {

        dgSofuIchiran_Row row = new dgSofuIchiran_Row(
                new TextBoxCode(), new TextBox(), new TextBoxCode(), new TextBox(), new TextBoxCode(),
                new TextBox(), new TextBox(), new TextBoxDate(), new TextBoxDate(), new TextBoxCode());

        row.getTxtJigyoshaNo().setValue(new RString(事業者番号));
        row.getTxtJigyoshaName().setValue(new RString(事業者名));
        row.getTxtHihoNo().setValue(new RString(被保番号));
        row.getTxtHihoName().setValue(new RString(氏名));
        row.getTxtMoshitateshaKubun().setValue(new RString(申立者区分));
        row.getTxtStyle().setValue(new RString(様式));
        row.getTxtMoshitateRiyu().setValue(new RString(申立理由));
        row.getTxtServiceTeikyoYM().setValue(new RDate(サービス提供年月));
        row.getTxtMoshitateYMD().setValue(new RDate(申立日));
        row.getTxtShokisaiHokenshaNo().setValue(new RString(証記載保険者番号));

        return row;
    }
}
