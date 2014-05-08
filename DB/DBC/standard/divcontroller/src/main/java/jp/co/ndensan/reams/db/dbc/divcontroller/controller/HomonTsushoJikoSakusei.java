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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
        setDetailData(panel, arrayData.get(0));
        response.data = panel;
        return response;
    }

    private List<dgHomonTushoJikoSakusei_Row> create訪問通所一覧() {
        List<dgHomonTushoJikoSakusei_Row> arrayData = new ArrayList<>();
        dgHomonTushoJikoSakusei_Row item;
        Button btn = new Button();

        /* ボタン, 事業者No, ｻｰﾋﾞｽｺｰﾄﾞ, 単位, 割引後率, 割引後単位, 回数, サービス単位, 種類限度超過単位, 種類限度内単位, 区分限度超過単位, 区分限度内単位, 単位単価, 費用総額, 給付率, 保険給付額, 利用者負担（保険対象分）, 利用者負担（全額対象分）*/
        item = createRow(btn, "1234567890", "111111:身体介護１２３４５６７８９", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "53000");
        arrayData.add(item);
        item = createRow(btn, "1234567890", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "55000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "40000", "5800", "4000", "5000", "4000", "", "40000", "", "36000", "4000", "108000");
        arrayData.add(item);
        item = createRow(btn, "1234567891", "111111:身体介護１", "3000", "60", "1800", "30", "54000", "2000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "45000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "54000", "2000", "2000", "2500", "2000", "", "20000", "", "18000", "2000", "45000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(null, "", "合計", "", "", "", "", "80000", "11600", "8000", "10000", "8000", "", "80000", "", "72000", "8000", "160000");
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
        item.setHomonTushoJigyoshaNo(new RString(JigyoshaNo));
        item.setHomonTushoServiceCode(new RString(ServiceCode));
        item.setHomonTushoUnit(new RString(stringToKingakuFormat(Unit)));
        item.setHomonTushoWaribikiRitsu(new RString(WaribikiRitsu));
        item.setHomonTushoWaribikiUnit(new RString(stringToKingakuFormat(WaribikiUnit)));
        item.setHomonTushoNum(new RString(Num));
        item.setHomonTushoServiceUnit(new RString(stringToKingakuFormat(ServiceUnit)));
        item.setHomonTushoShuruiLimitChokaUnit(new RString(stringToKingakuFormat(ShuruiKijunChoka)));
        item.setHomonTushoShuruiLimitNaiUnit(new RString(stringToKingakuFormat(ShuruiKijunNai)));
        item.setHomonTushoKubunLimitChokaUnit(new RString(stringToKingakuFormat(KubunKijunChoka)));
        item.setHomonTushoKubunLimitNaiUnit(new RString(stringToKingakuFormat(KubunKijunNai)));
        item.setHomonTushoUnitTanka(new RString(UnitTanka));
        item.setHomonTushoHiyoTotal(new RString(stringToKingakuFormat(HiyoTotal)));
        item.setHomonTushoKyufuRitsu(new RString(KyufuRitsu));
        item.setHomonTushoHokenKyufuGaku(new RString(stringToKingakuFormat(HokenKyufuGaku)));
        item.setHomonTushoHokenFutan(new RString(stringToKingakuFormat(HokenFutan)));
        item.setHomonTushoFutanTotal(new RString(stringToKingakuFormat(ZengakuFutan)));
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
        setDetailData(panel, panel.getDgHomonTushoJikoSakusei().getClickedItem());
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(HomonTsushoJikoSakuseiDiv panel) {
        tblHomonTsushoJikoSakuseiSummarySub1Div tbl1 = panel.getHomonTsushoJikoSakuseiSummarySub1().getTblHomonTsushoJikoSakuseiSummarySub1();
        tblHomonTsushoJikoSakuseiSummarySub2Div tbl2 = panel.getHomonTsushoJikoSakuseiSummarySub2().getTblHomonTsushoJikoSakuseiSummarySub2();
        tbl1.getTxtHomonTsushoJikoSakusei1().setValue(new RString("30"));
        tbl1.getTxtHomonTsushoJikoSakusei2().setValue(new RString("10"));
        tbl1.getTxtHomonTsushoJikoSakusei3().setValue(new RString("40"));
        tbl2.getTxtHomonTsushoJikoSakuseiSikyuuGendoGaku().setValue(new RString("150,000"));
        tbl2.getTxtHomonTsushoJikoSakuseiGendoKanriRange().setFromValue(new RDate("20010701"));
        tbl2.getTxtHomonTsushoJikoSakuseiGendoKanriRange().setToValue(new RDate("20011031"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(HomonTsushoJikoSakuseiDiv panel, dgHomonTushoJikoSakusei_Row selectRow) {
        tblHomonTsushoJikoSakuseiMeisaiDiv meisai = panel.getTblHomonTsushoJikoSakuseiMeisai();
        meisai.getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getHomonTushoJigyoshaNo());
        meisai.getTxtHomonTsushoJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        meisai.getTxtHomonTsushoJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        meisai.getTxtHomonTsushoJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        meisai.getTxtHomonTsushoJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        meisai.getTxtHomonTsushoJikoSakuseiDetailUnit().setValue(selectRow.getHomonTushoUnit());
        meisai.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu().setValue(selectRow.getHomonTushoWaribikiRitsu());
        meisai.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit().setValue(selectRow.getHomonTushoWaribikiUnit());
        meisai.getTxtHomonTsushoJikoSakuseiDetailKaisu().setValue(selectRow.getHomonTushoNum());
        meisai.getTxtHomonTsushoJikoSakuseiDetailServiceUnit().setValue(selectRow.getHomonTushoServiceUnit());
        tblHomonTsushoJikoSakuseiGoukeiDiv goukei = panel.getTblHomonTsushoJikoSakuseiGoukei();
        goukei.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit().setValue(selectRow.getHomonTushoShuruiLimitChokaUnit());
        goukei.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit().setValue(selectRow.getHomonTushoShuruiLimitNaiUnit());
        goukei.getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit().setValue(selectRow.getHomonTushoKubunLimitChokaUnit());
        goukei.getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getHomonTushoKubunLimitNaiUnit());
        goukei.getTxtHomonTsushoJikoSakuseiDetailUnitTanka().setValue(selectRow.getHomonTushoUnitTanka());
        goukei.getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getHomonTushoKyufuRitsu());
        goukei.getTxtHomonTsushoJikoSakuseiDetailHiyoTotal().setValue(selectRow.getHomonTushoHiyoTotal());
        goukei.getTxtHomonTsushoJikoSakuseiDetailHokenKyufu().setValue(selectRow.getHomonTushoHokenKyufuGaku());
        goukei.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken().setValue(selectRow.getHomonTushoHokenFutan());
        goukei.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getHomonTushoFutanTotal());
    }

}
