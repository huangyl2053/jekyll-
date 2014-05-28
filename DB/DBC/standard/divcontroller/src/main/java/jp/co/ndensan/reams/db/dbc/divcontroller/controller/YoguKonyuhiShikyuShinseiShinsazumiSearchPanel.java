/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 福祉用具購入費支給申請決定 福祉用具購入費支給申請決定のパネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiShinsazumiSearchPanel {
    
        /*
     * 福祉用具購入費支給申請決定 審査日の情報を表示する。
     */
      public ResponseData<YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv> response = new ResponseData<>();

        panel.getYoguKonyuhiShikyuShinseiShinsazumiSearchCondition().getTxtShinsaDateRange().setFromPlaceHolder(new RString("平26.07.01"));
        panel.getYoguKonyuhiShikyuShinseiShinsazumiSearchCondition().getTxtShinsaDateRange().setToPlaceHolder(new RString("平26.07.31"));

        response.data = panel;
        return response;

    }
  
    /*
     * 福祉用具購入費支給申請決定 審査済支給申請一覧情報を表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv> onClick_btnSearchMishinsa(YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv> response = new ResponseData<>();

        //TO DO 2014.5.20 追加決定日（審査済分検索ボタン押下、表示される）
        setKetteiDateClear(panel);
        //TO DO 2014.5.20 審査済支給申請一覧情報を設定する。
        setShinseiShinsazumiData(panel);

        response.data = panel;
        return response;

    }

    /**
     * 福祉用具購入費支給申請決定 審査済決定日をクリア処理が行う
     *
     * @param panel YoguKonyuhiShikyuShinseiMishinsaResultListDiv
     * @return PanelDivのResponseData
     */
    private void setKetteiDateClear(YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv panel) {
        panel.getYoguKonyuhiShikyuShinseiShinsazumiResultList().getTxtKetteiDate().setValue(new RDate("20140712"));
    }

    /**
     * 福祉用具購入費支給申請決定 審査済支給申請一覧情報を表示する。
     *
     * @param panel YoguKonyuhiShikyuShinseiMishinsaResultListDiv
     * @return PanelDivのResponseData
     */
    private void setShinseiShinsazumiData(YoguKonyuhiShikyuShinseiShinsazumiSearchPanelDiv panel) {

        List<dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row> arraydata = createRowShinseiShinsazumiData();
        DataGrid<dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row> grid = panel.getYoguKonyuhiShikyuShinseiShinsazumiResultList().getDgYoguKonyuhiKetteiMishinsaShikyuShinseiList();
        grid.setDataSource(arraydata);

    }

    /*
     *審査済支給申請一覧情報の初期値をセットします。
     */
    private List<dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row> createRowShinseiShinsazumiData() {

        List<dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row> arrayDataList = new ArrayList<>();

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111111",
                "電算　太郎",
                "18000",
                "2000",
                "0",
                "承認",
                "20140701",
                "0000000001"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111112",
                "電算　一輝",
                "27000",
                "3000",
                "0",
                "承認",
                "20140702",
                "0000000002"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111113",
                "電算　涼太",
                "36000",
                "4000",
                "0",
                "承認",
                "20140703",
                "0000000003"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111114",
                "電算　陸斗",
                "45000",
                "5000",
                "0",
                "承認",
                "20140704",
                "0000000004"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111115",
                "電算　悠馬",
                "54000",
                "6000",
                "0",
                "承認",
                "20140705",
                "0000000005"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111116",
                "電算　嗚呼",
                "63000",
                "7000",
                "0",
                "承認",
                "20140706",
                "0000000006"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111117",
                "電算　長野",
                "9000",
                "1000",
                "0",
                "承認",
                "20140707",
                "0000000007"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111118",
                "電算　知",
                "27000",
                "3000",
                "0",
                "承認",
                "20140708",
                "0000000008"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111119",
                "電算　網",
                "72000",
                "8000",
                "0",
                "承認",
                "20140709",
                "0000000009"
        ));

        arrayDataList.add(createRowShinseiShinsazumiData(
                "20140701",
                "201406",
                "1111111110",
                "電算　箕",
                "81000",
                "9000",
                "0",
                "承認",
                "20140710",
                "0000000010"
        ));

        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する支給審査済データを作成します。
     */
    private dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row createRowShinseiShinsazumiData(String 支給申請日,
            String 提供年月,
            String 被保番号,
            String 氏名,
            String 保険請求額,
            String 利用者負担額,
            String 限度超過額,
            String 審査結果,
            String 審査日,
            String 整理番号
    ) {

        dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row rowShinseiShinsazumiData = new dgYoguKonyuhiKetteiMishinsaShikyuShinseiList_Row(
                new TextBoxDate(),
                new TextBoxDate(),
                new TextBoxCode(),
                new TextBox(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBox(),
                new TextBoxDate(),
                new TextBox());

        rowShinseiShinsazumiData.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日));
        rowShinseiShinsazumiData.getTxtTenkyoYM().setValue(new RDate(提供年月));
        rowShinseiShinsazumiData.getTxtHihoNo().setValue(new RString(被保番号));
        rowShinseiShinsazumiData.getTxtHihoName().setValue(new RString(氏名));
        rowShinseiShinsazumiData.getTxtHokenSeikyuAmount().setValue(new Decimal(保険請求額));
        rowShinseiShinsazumiData.getTxtRiyoshaFutanAmount().setValue(new Decimal(利用者負担額));
        rowShinseiShinsazumiData.getTxtLimitOverAmount().setValue(new Decimal(限度超過額));
        rowShinseiShinsazumiData.getTxtShinsaResult().setValue(new RString(審査結果));
        rowShinseiShinsazumiData.getTxtShinsaDate().setValue(new RDate(審査日));
        rowShinseiShinsazumiData.getTxtSeiriNo().setValue(new RString(整理番号));

        return rowShinseiShinsazumiData;

    }

 
}

