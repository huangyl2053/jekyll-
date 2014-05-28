/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaResultListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のパネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanel {

    
        /*
     * 福祉用具購入費支給申請審査 申請一覧情報を表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> response = new ResponseData<>();

       
        panel.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setFromPlaceHolder(new RString("平26.07.01"));
        panel.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setToPlaceHolder(new RString("平26.07.31"));

        response.data = panel;
        return response;

    }

    
    /*
     * 福祉用具購入費支給申請審査 未審査支給申請一覧情報を表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSearchMishinsa(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> response = new ResponseData<>();

        //TO DO 2014.5.20 追加① 審査日（検索ボタン押下、表示される）
        panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtShinsaDate().setValue(new RDate("20140712"));
        setMishinsaShikyuShinseiData(panel);

        response.data = panel;
        return response;

    }

    /**
     * 福祉用具購入費支給申請審査 未審査支給申請一覧情報を表示する。
     *
     * @param panel YoguKonyuhiShikyuShinseiMishinsaResultListDiv
     * @return PanelDivのResponseData
     */
    private void setMishinsaShikyuShinseiData(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {

        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> arraydata = createRowMishinsaShikyuShinseiData();
        DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> grid = panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList();
        grid.setDataSource(arraydata);

    }

    /*
     *未審査支給申請一覧の初期値をセットします。
     */
    private List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> createRowMishinsaShikyuShinseiData() {

        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> arrayDataList = new ArrayList<>();

        dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row item;

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111111",
                "電算　太郎",
                "18000",
                "2000",
                "0",
                "0000000001"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111112",
                "電算　一輝",
                "27000",
                "3000",
                "0",
                "0000000002"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111113",
                "電算　涼太",
                "36000",
                "4000",
                "0",
                "0000000003"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111114",
                "電算　陸斗",
                "45000",
                "5000",
                "0",
                "0000000004"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111115",
                "電算　悠馬",
                "54000",
                "6000",
                "0",
                "0000000005"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111116",
                "電算　嗚呼",
                "63000",
                "7000",
                "0",
                "0000000006"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111117",
                "電算　長野",
                "9000",
                "1000",
                "0",
                "0000000007"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111118",
                "電算　知",
                "27000",
                "3000",
                "0",
                "0000000008"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111119",
                "電算　網",
                "72000",
                "8000",
                "0",
                "0000000009"
        ));

        arrayDataList.add(createRowMishinsaShikyuShinseiData(
                "20140701",
                "201406",
                "1111111110",
                "電算　箕",
                "81000",
                "9000",
                "0",
                "0000000010"
        ));

        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する支給申請データを作成します。
     */
    private dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row createRowMishinsaShikyuShinseiData(
            String 支給申請日,
            String 提供年月,
            String 被保番号,
            String 氏名,
            String 保険請求額,
            String 利用者負担額,
            String 限度超過額,
            String 整理番号) {

        dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row rowMishinsaShikyuShinseiData = new dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(
                new Button(),
                new TextBoxDate(),
                new TextBoxDate(),
                new TextBoxCode(),
                new TextBox(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBox(),
                new TextBox());

        rowMishinsaShikyuShinseiData.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日));
        rowMishinsaShikyuShinseiData.getTxtTenkyoYM().setValue(new RDate(提供年月));
        rowMishinsaShikyuShinseiData.getTxtHihoNo().setValue(new RString(被保番号));
        rowMishinsaShikyuShinseiData.getTxtHihoName().setValue(new RString(氏名));
        rowMishinsaShikyuShinseiData.getTxtHokenSeikyuAmount().setValue(new Decimal(保険請求額));
        rowMishinsaShikyuShinseiData.getTxtRiyoshaFutanAmount().setValue(new Decimal(利用者負担額));
        rowMishinsaShikyuShinseiData.getTxtLimitOverAmount().setValue(new Decimal(限度超過額));
        rowMishinsaShikyuShinseiData.getTxtSeiriNo().setValue(new RString(整理番号));

        return rowMishinsaShikyuShinseiData;

    }

    /*
     * 福祉用具購入費支給申請審査 選択された未審査支給申請一覧情報をもとに、
     * 支給申請内容を一括審査するボタンを押下後、審査結果の内容をセットされる。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnIkkatsuShinsa(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> response = new ResponseData<>();
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = panel.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();

        //TO DO 2014.5.19 承認却下区分
        for (int i = 0; i < selectedMishinsaShikyuShinsei.size(); i++) {

            dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row mishinsaShikyuShinseiList_Row = selectedMishinsaShikyuShinsei.get(i);
            if (i == 3) {
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().setValue(new RString("却下：種目重複"));
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().getValue();
            } else {
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().setValue(new RString("承認"));
            }

        }
        
        
        

        response.data = panel;
        return response;

    }

}
