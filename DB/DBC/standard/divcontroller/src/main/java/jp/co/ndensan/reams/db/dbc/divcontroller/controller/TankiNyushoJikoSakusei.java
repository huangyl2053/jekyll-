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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiDiv;
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
        response.data = panel;
        return response;
    }

    private List<dgTankiNyushoJikoSakusei_Row> create短期入所一覧() {
        List<dgTankiNyushoJikoSakusei_Row> arrayData = new ArrayList<>();
        dgTankiNyushoJikoSakusei_Row item;
        Button btn = new Button();

        item = createRow(btn, "1234567890", "111111", "100000", "50", "40", "10", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(btn, "1234567890", "111111", "100000", "50", "50", "0", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "9000", "", "", "", "", "", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567891", "111111", "100000", "50", "50", "0", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "4000", "", "", "", "", "", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "40", "10", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "50", "0", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "50", "0", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "50", "0", "4000", "60", "2400", "2400", "2400", "2000", "1000", "10000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "16000", "", "", "", "", "", "", "");
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
        item.setSelfInfoJigyoshaNo(new RString(JigyoshaNo));
        item.setSelfInfoServiceCode(new RString(ServiceCode));
        item.setSelfInfoUnit(new RString(stringToKingakuFormat(Unit)));
        item.setSelfInfoDateNum(new RString(DateNum));
        item.setSelfInfoKyufuDateNum(new RString(KyufuDateNum));
        item.setSelfInfoKyufugaiDateNum(new RString(KyufugaiDateNum));
        item.setSelfInfoUnitTanka(new RString(stringToKingakuFormat(UnitTanka)));
        item.setSelfInfoKyufuRitsu(new RString(KyufuRitsu));
        item.setSelfInfoKubunLimitNaiUnit(new RString(stringToKingakuFormat(KubunLimitNaiUnit)));
        item.setSelfInfoHiyoTotal(new RString(stringToKingakuFormat(HiyoTotal)));
        item.setSelfInfoHokenKyufuGaku(new RString(stringToKingakuFormat(HokenKyufuGaku)));
        item.setSelfInfoHokenFutan(new RString(stringToKingakuFormat(HokenFutan)));
        item.setSelfInfoKyufuTaishogaiUnit(new RString(stringToKingakuFormat(KyufuTaishogaiUnit)));
        item.setSelfInfoFutanTotal(new RString(stringToKingakuFormat(FutanTotal)));

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
        panel.getTankiNyushoJikoSakuseiDetail().setVisible(true);
        panel.getTankiNyushoJikoSakuseiDetail().setDisplayNone(false);
        setDetailData(panel);
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(TankiNyushoJikoSakuseiDiv panel) {
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakusei1().setValue(new RString("888888"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakusei2().setValue(new RString("888888"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakusei3().setValue(new RString("888888"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakusei4().setValue(new RString("888888"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakusei5().setValue(new RString("888888"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakuseiGendoKanriRange().setFromValue(new RDate("20030701"));
        panel.getTankiNyushoJikoSakuseiSummary().getTxtTankiNyushoJikoSakuseiGendoKanriRange().setToValue(new RDate("20040531"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(TankiNyushoJikoSakuseiDiv panel) {
        dgTankiNyushoJikoSakusei_Row selectRow = panel.getDgTankiNyushoJikoSakusei().getClickedItem();
        tblTankiNyushoJikoSakuseiDiv setTbl = panel.getTankiNyushoJikoSakuseiDetail().getTblTankiNyushoJikoSakusei();
        setTbl.getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getSelfInfoJigyoshaNo());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        setTbl.getTxtTankiNyushoJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        setTbl.getTxtTankiNyushoJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        setTbl.getTxtTankiNyushoJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        setTbl.getTxtTankiNyushoJikoSakuseiDetailUnit().setValue(selectRow.getSelfInfoUnit());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailDateNum().setValue(selectRow.getSelfInfoDateNum());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum().setValue(selectRow.getSelfInfoKyufuDateNum());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum().setValue(selectRow.getSelfInfoKyufugaiDateNum());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailUnitTanka().setValue(selectRow.getSelfInfoUnitTanka());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getSelfInfoKyufuRitsu());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getSelfInfoKubunLimitNaiUnit());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailHiyoTotal().setValue(selectRow.getSelfInfoHiyoTotal());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku().setValue(selectRow.getSelfInfoHokenKyufuGaku());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku().setValue(selectRow.getSelfInfoHokenFutan());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit().setValue(selectRow.getSelfInfoKyufuTaishogaiUnit());
        setTbl.getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getSelfInfoFutanTotal());
    }

}
