/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TankiNyushoJikoSakuseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTankiNyushoJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiSummarySub3Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 短期入所（自己作成）のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class TankiNyushoJikoSakusei {

    /**
     * 短期入所（自己作成）の画面ロード時の処理です。
     *
     * @param panel 短期入所（自己作成）
     * @return ResponseData
     */
    public ResponseData getOnLoadData(TankiNyushoJikoSakuseiDiv panel) {
        ResponseData<TankiNyushoJikoSakuseiDiv> response = new ResponseData<>();
        DataGrid<dgTankiNyushoJikoSakusei_Row> dgRow = panel.getDgTankiNyushoJikoSakusei();
        setSummaryData(panel);
        List<dgTankiNyushoJikoSakusei_Row> arrayData = create短期入所一覧();
        dgRow.setDataSource(arrayData);
        setDetailData(panel, arrayData.get(0));
        response.data = panel;
        return response;
    }

    private List<dgTankiNyushoJikoSakusei_Row> create短期入所一覧() {
        List<dgTankiNyushoJikoSakusei_Row> arrayData = new ArrayList<>();
        dgTankiNyushoJikoSakusei_Row item;
        Button btn = new Button();

        /* ボタン, 事業者No, ｻｰﾋﾞｽｺｰﾄﾞ, 単位, 日数, 給付対象日数, 対象外日数, 単位単価, 給付率, 区分限度内単位, 費用総額, 保険給付額, 保険対象利用者負担分額, 給付対象外単位, 全額利用者負担額 */
        item = createRow(btn, "1234567890", "111111:身体介護１２３４５６７８９", "1000", "50", "40", "10", "20.00", "60", "40000", "800000", "480000", "320000", "10000", "200000");
        arrayData.add(item);
        item = createRow(btn, "1234567890", "111111:身体介護１", "1000", "50", "50", "0", "20.00", "60", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "", "", "90000", "1800000", "1080000", "720000", "", "200000");
        arrayData.add(item);
        item = createRow(btn, "1234567891", "111111:身体介護１", "1000", "50", "50", "0", "20.00", "60", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "", "", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "40", "10", "20.00", "60", "40000", "800000", "480000", "320000", "10000", "200000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "50", "0", "20.00", "60", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "50", "0", "20.00", "60", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "50", "0", "20.00", "60", "50000", "1000000", "600000", "400000", "", "");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "", "", "190000", "3800000", "2280000", "1920000", "", "200000");
        arrayData.add(item);

        return arrayData;
    }

    private dgTankiNyushoJikoSakusei_Row createRow(
            Button btn,
            String JigyoshaNo,
            String ServiceCode,
            String Unit,
            String DateNum,
            String KyufuDateNum,
            String KyufugaiDateNum,
            String UnitTanka,
            String KyufuRitsu,
            String KubunLimitNaiUnit,
            String HiyoTotal,
            String HokenKyufuGaku,
            String HokenFutan,
            String KyufuTaishogaiUnit,
            String FutanTotal) {
        dgTankiNyushoJikoSakusei_Row item = new dgTankiNyushoJikoSakusei_Row(
                btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        item.setTankiNyushoJigyoshaNo(new RString(JigyoshaNo));
        item.setTankiNyushoServiceCode(new RString(ServiceCode));
        item.setTankiNyushoUnit(new RString(stringToKingakuFormat(Unit)));
        item.setTankiNyushoDateNum(new RString(DateNum));
        item.setTankiNyushoKyufuDateNum(new RString(KyufuDateNum));
        item.setTankiNyushoKyufugaiDateNum(new RString(KyufugaiDateNum));
        item.setTankiNyushoUnitTanka(new RString(stringToKingakuFormat(UnitTanka)));
        item.setTankiNyushoKyufuRitsu(new RString(KyufuRitsu));
        item.setTankiNyushoKubunLimitNaiUnit(new RString(stringToKingakuFormat(KubunLimitNaiUnit)));
        item.setTankiNyushoHiyoTotal(new RString(stringToKingakuFormat(HiyoTotal)));
        item.setTankiNyushoHokenKyufuGaku(new RString(stringToKingakuFormat(HokenKyufuGaku)));
        item.setTankiNyushoHokenFutan(new RString(stringToKingakuFormat(HokenFutan)));
        item.setTankiNyushoKyufuTaishogaiUnit(new RString(stringToKingakuFormat(KyufuTaishogaiUnit)));
        item.setTankiNyushoFutanTotal(new RString(stringToKingakuFormat(FutanTotal)));

        return item;
    }

    /*
     文字列(数字)を金額フォーマットに変更する。
     */
    private String stringToKingakuFormat(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return new Decimal(str).toString("##,###,###");
    }

    /**
     * 短期入所（自己作成）のデータグリッドで選択した計画を表示する際の処理。
     *
     * @param panel 居宅サービス計画一覧
     * @return ResponseData
     */
    public ResponseData<TankiNyushoJikoSakuseiDiv> onClick_JikoSakuseiShowDetail(TankiNyushoJikoSakuseiDiv panel) {
        ResponseData<TankiNyushoJikoSakuseiDiv> response = new ResponseData<>();
        setDetailData(panel, panel.getDgTankiNyushoJikoSakusei().getClickedItem());
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(TankiNyushoJikoSakuseiDiv panel) {
        tblTankiNyushoJikoSakuseiSummarySub1Div tbl1 = panel.getTankiNyushoJikoSakuseiSummarySub1().getTblTankiNyushoJikoSakuseiSummarySub1();
        tblTankiNyushoJikoSakuseiSummarySub2Div tbl2 = panel.getTankiNyushoJikoSakuseiSummarySub2().getTblTankiNyushoJikoSakuseiSummarySub2();
        tblTankiNyushoJikoSakuseiSummarySub3Div tbl3 = panel.getTankiNyushoJikoSakuseiSummarySub2().getTblTankiNyushoJikoSakuseiSummarySub3();

        tbl1.getTxtTankiNyushoJikoSakusei1().setValue(new RString("150,000"));
        tbl1.getTxtTankiNyushoJikoSakusei2().setValue(new RString("30"));
        tbl1.getTxtTankiNyushoJikoSakusei3().setValue(new RString("10"));
        tbl2.getTxtTankiNyushoJikoSakusei4().setValue(new RString("20"));
        tbl2.getTxtTankiNyushoJikoSakusei5().setValue(new RString("5"));
        tbl3.getTxtTankiNyushoJikoSakuseiGendoKanriRange().setFromValue(new RDate("20010701"));
        tbl3.getTxtTankiNyushoJikoSakuseiGendoKanriRange().setToValue(new RDate("20011031"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(TankiNyushoJikoSakuseiDiv panel, dgTankiNyushoJikoSakusei_Row selectRow) {
        tblTankiNyushoJikoSakuseiMeisaiDiv meisai = panel.getTblTankiNyushoJikoSakuseiMeisai();
        meisai.getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getTankiNyushoJigyoshaNo());
        meisai.getTxtTankiNyushoJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        meisai.getTxtTankiNyushoJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        meisai.getTxtTankiNyushoJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        meisai.getTxtTankiNyushoJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        meisai.getTxtTankiNyushoJikoSakuseiDetailUnit().setValue(selectRow.getTankiNyushoUnit());
        meisai.getTxtTankiNyushoJikoSakuseiDetailDateNum().setValue(selectRow.getTankiNyushoDateNum());
        meisai.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum().setValue(selectRow.getTankiNyushoKyufuDateNum());
        meisai.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum().setValue(selectRow.getTankiNyushoKyufugaiDateNum());
        tblTankiNyushoJikoSakuseiGoukeiDiv goukei = panel.getTblTankiNyushoJikoSakuseiGoukei();
        goukei.getTxtTankiNyushoJikoSakuseiDetailUnitTanka().setValue(selectRow.getTankiNyushoUnitTanka());
        goukei.getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getTankiNyushoKyufuRitsu());
        goukei.getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getTankiNyushoKubunLimitNaiUnit());
        goukei.getTxtTankiNyushoJikoSakuseiDetailHiyoTotal().setValue(selectRow.getTankiNyushoHiyoTotal());
        goukei.getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku().setValue(selectRow.getTankiNyushoHokenKyufuGaku());
        goukei.getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku().setValue(selectRow.getTankiNyushoHokenFutan());
        goukei.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit().setValue(selectRow.getTankiNyushoKyufuTaishogaiUnit());
        goukei.getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getTankiNyushoFutanTotal());
    }

}
