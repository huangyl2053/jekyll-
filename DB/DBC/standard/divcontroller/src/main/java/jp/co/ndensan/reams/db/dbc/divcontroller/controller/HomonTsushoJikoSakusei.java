/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HomonTsushoJikoSakuseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgHomonTushoJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 訪問通所（自己作成）のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HomonTsushoJikoSakusei {

    /**
     * 訪問通所（自己作成）の画面ロード時の処理です。
     *
     * @param panel 訪問通所（自己作成）
     * @return ResponseData
     */
    public ResponseData getOnLoadData(HomonTsushoJikoSakuseiDiv panel) {
        ResponseData<HomonTsushoJikoSakuseiDiv> response = new ResponseData<>();
        DataGrid<dgHomonTushoJikoSakusei_Row> dgRow = panel.getDgHomonTushoJikoSakusei();
        setSummaryData(panel);
        List<dgHomonTushoJikoSakusei_Row> arrayData = create訪問通所一覧();
        dgRow.setDataSource(arrayData);
        response.data = panel;
        return response;
    }

    private List<dgHomonTushoJikoSakusei_Row> create訪問通所一覧() {
        List<dgHomonTushoJikoSakusei_Row> arrayData = new ArrayList<>();
        dgHomonTushoJikoSakusei_Row item;
        Button btn = new Button();

        item = createRow(btn, "1234567890", "111111", "100000", "50", "50000", "30", "4000", "2800", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(btn, "1234567890", "111111", "200000", "50", "100000", "25", "5000", "3000", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "9000", "", "", "", "", "", "", "", "", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567891", "111111", "300000", "60", "120000", "30", "5000", "2000", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "5000", "", "", "", "", "", "", "", "", "", "");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "50000", "30", "4000", "2800", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "200000", "50", "100000", "25", "5000", "3000", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "100000", "50", "50000", "30", "4000", "2800", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111", "200000", "50", "100000", "25", "5000", "3000", "2000", "2500", "2000", "10000", "150000", "90", "30000", "3000", "100000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "18000", "", "", "", "", "", "", "", "", "", "");
        arrayData.add(item);

        return arrayData;
    }

    private dgHomonTushoJikoSakusei_Row createRow(
            Button btn,
            String JigyoshaNo,
            String ServiceCode,
            String Unit,
            String WaribikiRitsu,
            String WaribikiUnit,
            String Num,
            String ServiceUnit,
            String ShuruiKijunChoka,
            String ShuruiKijunNai,
            String KubunKijunChoka,
            String KubunKijunNai,
            String UnitTanka,
            String HiyoTotal,
            String KyufuRitsu,
            String HokenKyufuGaku,
            String HokenFutan,
            String ZengakuFutan) {
        dgHomonTushoJikoSakusei_Row item = new dgHomonTushoJikoSakusei_Row(
                btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        item.setSelfInfoJigyoshaNo(new RString(JigyoshaNo));
        item.setSelfInfoServiceCode(new RString(ServiceCode));
        item.setSelfInfoUnit(new RString(stringToKingakuFormat(Unit)));
        item.setSelfInfoWaribikiRitsu(new RString(WaribikiRitsu));
        item.setSelfInfoWaribikiUnit(new RString(stringToKingakuFormat(WaribikiUnit)));
        item.setSelfInfoNum(new RString(Num));
        item.setSelfInfoServiceUnit(new RString(stringToKingakuFormat(ServiceUnit)));
        item.setSelfInfoShuruiLimitChokaUnit(new RString(stringToKingakuFormat(ShuruiKijunChoka)));
        item.setSelfInfoShuruiLimitNaiUnit(new RString(stringToKingakuFormat(ShuruiKijunNai)));
        item.setSelfInfoKubunLimitChokaUnit(new RString(stringToKingakuFormat(KubunKijunChoka)));
        item.setSelfInfoKubunLimitNaiUnit(new RString(stringToKingakuFormat(KubunKijunNai)));
        item.setSelfInfoUnitTanka(new RString(stringToKingakuFormat(UnitTanka)));
        item.setSelfInfoHiyoTotal(new RString(stringToKingakuFormat(HiyoTotal)));
        item.setSelfInfoKyufuRitsu(new RString(KyufuRitsu));
        item.setSelfInfoHokenKyufuGaku(new RString(stringToKingakuFormat(HokenKyufuGaku)));
        item.setSelfInfoHokenFutan(new RString(stringToKingakuFormat(HokenFutan)));
        item.setSelfInfoFutanTotal(new RString(stringToKingakuFormat(ZengakuFutan)));
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
     * 訪問通所（自己作成）のデータグリッドで選択した計画を表示する際の処理。
     *
     * @param panel 居宅サービス計画一覧
     * @return ResponseData
     */
    public ResponseData<HomonTsushoJikoSakuseiDiv> onClick_JikoSakuseiShowDetail(HomonTsushoJikoSakuseiDiv panel) {
        ResponseData<HomonTsushoJikoSakuseiDiv> response = new ResponseData<>();
        panel.getHomonTsushoJikoSakuseiDetail().setVisible(true);
        panel.getHomonTsushoJikoSakuseiDetail().setDisplayNone(false);
        setDetailData(panel);
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(HomonTsushoJikoSakuseiDiv panel) {
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakusei1().setValue(new RString("888888"));
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakusei2().setValue(new RString("888888"));
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakusei3().setValue(new RString("888888"));
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakuseiSikyuuGendoGaku().setValue(new RString("888,888"));
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakuseiGendoKanriRange().setFromValue(new RString("平15.07.01"));
        panel.getHomonTsushoJikoSakuseiSummary().getTxtHomonTsushoJikoSakuseiGendoKanriRange().setToValue(new RString("平16.05.31"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(HomonTsushoJikoSakuseiDiv panel) {
        dgHomonTushoJikoSakusei_Row selectRow = panel.getDgHomonTushoJikoSakusei().getClickedItem();
        tblHomonTsushoJikoSakuseiDiv setTbl = panel.getHomonTsushoJikoSakuseiDetail().getTblHomonTsushoJikoSakusei();
        setTbl.getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getSelfInfoJigyoshaNo());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        setTbl.getTxtHomonTsushoJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        setTbl.getTxtHomonTsushoJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        setTbl.getTxtHomonTsushoJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        setTbl.getTxtHomonTsushoJikoSakuseiDetailUnit().setValue(selectRow.getSelfInfoUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu().setValue(selectRow.getSelfInfoWaribikiRitsu());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit().setValue(selectRow.getSelfInfoWaribikiUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailKaisu().setValue(selectRow.getSelfInfoNum());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailServiceUnit().setValue(selectRow.getSelfInfoServiceUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit().setValue(selectRow.getSelfInfoShuruiLimitChokaUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit().setValue(selectRow.getSelfInfoShuruiLimitNaiUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit().setValue(selectRow.getSelfInfoKubunLimitChokaUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getSelfInfoKubunLimitNaiUnit());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailUnitTanka().setValue(selectRow.getSelfInfoUnitTanka());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getSelfInfoKyufuRitsu());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailHiyoTotal().setValue(selectRow.getSelfInfoHiyoTotal());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailHokenKyufu().setValue(selectRow.getSelfInfoHokenKyufuGaku());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken().setValue(selectRow.getSelfInfoHokenFutan());
        setTbl.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getSelfInfoFutanTotal());
    }

}
