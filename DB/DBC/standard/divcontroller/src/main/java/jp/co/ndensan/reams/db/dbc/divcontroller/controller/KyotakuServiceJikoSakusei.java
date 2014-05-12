/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServiceJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 居宅サービス計画情報（自己作成）のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuServiceJikoSakusei {

    /**
     * 居宅サービス計画情報（自己作成）の画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画情報（自己作成）
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuServiceJikoSakuseiDiv panel) {
        ResponseData<KyotakuServiceJikoSakuseiDiv> response = new ResponseData<>();
        DataGrid<dgKyotakuServiceJikoSakusei_Row> dgRow = panel.getDgKyotakuServiceJikoSakusei();
        setSummaryData(panel);
        List<dgKyotakuServiceJikoSakusei_Row> arrayData = create居宅サービス一覧();
        dgRow.setDataSource(arrayData);
        setDetailData(panel, arrayData.get(0));
        response.data = panel;
        return response;
    }

    private List<dgKyotakuServiceJikoSakusei_Row> create居宅サービス一覧() {
        List<dgKyotakuServiceJikoSakusei_Row> arrayData = new ArrayList<>();
        dgKyotakuServiceJikoSakusei_Row item;
        Button btn = new Button();

        /* ボタン, 事業者No, ｻｰﾋﾞｽｺｰﾄﾞ, 単位, 割引後率, 割引後単位, 回数, サービス単位, 種類限度超過単位, 種類限度内単位, 区分限度超過単位, 区分限度内単位, 単位単価, 費用総額, 給付率, 保険給付額, 利用者負担（保険対象分）, 利用者負担（全額対象分）*/
        item = createRow(btn, "1234567890", "111111:身体介護１２３４５６７８９", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "53000");
        arrayData.add(item);
        item = createRow(btn, "1234567890", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "55000");
        arrayData.add(item);
        item = createRow(null, "", "             合計", "", "", "", "", "40000", "5800", "4000", "5000", "4000", "", "40000", "", "36000", "4000", "108000");
        arrayData.add(item);
        item = createRow(btn, "1234567891", "111111:身体介護１", "3000", "60", "1800", "30", "54000", "2000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "45000");
        arrayData.add(item);
        item = createRow(null, "", "             合計", "", "", "", "", "54000", "2000", "2000", "2500", "2000", "", "20000", "", "18000", "2000", "45000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "1000", "50", "500", "30", "15000", "2800", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(btn, "1234567892", "111111:身体介護１", "2000", "50", "1000", "25", "25000", "3000", "2000", "2500", "2000", "10.00", "20000", "90", "18000", "2000", "40000");
        arrayData.add(item);
        item = createRow(null, "", "             合計", "", "", "", "", "80000", "11600", "8000", "10000", "8000", "", "80000", "", "72000", "8000", "160000");
        arrayData.add(item);

        return arrayData;
    }

    private dgKyotakuServiceJikoSakusei_Row createRow(
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
        dgKyotakuServiceJikoSakusei_Row item = new dgKyotakuServiceJikoSakusei_Row(
                btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        item.setSelfInfoJigyoshaNo(new RString(JigyoshaNo));
        item.setSelfInfoServiceCode(new RString(ServiceCode));
//        if (btn != null) {
//            item.getSelfInfoBtnSelect().setVisible(true);
//        } else {
//            Button button = new Button();
//            button.setVisible(false);
//            button.setDisplayNone(true);
//            button.setDisabled(true);
//            button.setText(RString.EMPTY);
//            item.setSelfInfoBtnSelect(button);
//        }
        item.setSelfInfoUnit(new RString(stringToKingakuFormat(Unit)));
        item.setSelfInfoWaribikiRitsu(new RString(WaribikiRitsu));
        item.setSelfInfoWaribikiUnit(new RString(stringToKingakuFormat(WaribikiUnit)));
        item.setSelfInfoNum(new RString(Num));
        item.setSelfInfoServiceUnit(new RString(stringToKingakuFormat(ServiceUnit)));
        item.setSelfInfoShuruiLimitChokaUnit(new RString(stringToKingakuFormat(ShuruiKijunChoka)));
        item.setSelfInfoShuruiLimitNaiUnit(new RString(stringToKingakuFormat(ShuruiKijunNai)));
        item.setSelfInfoKubunLimitChokaUnit(new RString(stringToKingakuFormat(KubunKijunChoka)));
        item.setSelfInfoKubunLimitNaiUnit(new RString(stringToKingakuFormat(KubunKijunNai)));
        item.setSelfInfoUnitTanka(new RString(UnitTanka));
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
     * 居宅サービス計画情報（自己作成）のデータグリッドで選択した計画を表示する際の処理。
     *
     * @param panel 居宅サービス計画情報（自己作成）
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceJikoSakuseiDiv> onClick_JikoSakuseiShowDetail(KyotakuServiceJikoSakuseiDiv panel) {
        ResponseData<KyotakuServiceJikoSakuseiDiv> response = new ResponseData<>();
        setDetailData(panel, panel.getDgKyotakuServiceJikoSakusei().getClickedItem());
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(KyotakuServiceJikoSakuseiDiv panel) {
        tblKyotakuServiceJikoSakuseiSummarySub1Div tbl1 = panel.getKyotakuServiceJikoSakuseiSummarySub1().getTblKyotakuServiceJikoSakuseiSummarySub1();
        tblKyotakuServiceJikoSakuseiSummarySub2Div tbl2 = panel.getKyotakuServiceJikoSakuseiSummarySub2().getTblKyotakuServiceJikoSakuseiSummarySub2();
        tbl1.getTxtKyotakuServiceJikoSakusei1().setValue(new RString("30"));
        tbl1.getTxtKyotakuServiceJikoSakusei2().setValue(new RString("10"));
        tbl1.getTxtKyotakuServiceJikoSakusei3().setValue(new RString("40"));
        tbl2.getTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku().setValue(new RString("150,000"));
        tbl2.getTxtKyotakuServiceJikoSakuseiGendoKanriRange().setFromValue(new RDate("20140701"));
        tbl2.getTxtKyotakuServiceJikoSakuseiGendoKanriRange().setToValue(new RDate("20150531"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(KyotakuServiceJikoSakuseiDiv panel, dgKyotakuServiceJikoSakusei_Row selectRow) {
        tblKyotakuServiceJikoSakuseiMeisaiDiv meisai = panel.getTblKyotakuServiceJikoSakuseiMeisai();
        meisai.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getSelfInfoJigyoshaNo());
        meisai.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        meisai.getTxtKyotakuServiceJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        meisai.getTxtKyotakuServiceJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        meisai.getTxtKyotakuServiceJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        meisai.getTxtKyotakuServiceJikoSakuseiDetailUnit().setValue(selectRow.getSelfInfoUnit());
        meisai.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu().setValue(selectRow.getSelfInfoWaribikiRitsu());
        meisai.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit().setValue(selectRow.getSelfInfoWaribikiUnit());
        meisai.getTxtKyotakuServiceJikoSakuseiDetailKaisu().setValue(selectRow.getSelfInfoNum());
        meisai.getTxtKyotakuServiceJikoSakuseiDetailServiceUnit().setValue(selectRow.getSelfInfoServiceUnit());
        tblKyotakuServiceJikoSakuseiGoukeiDiv goukei = panel.getTblKyotakuServiceJikoSakuseiGoukei();
        goukei.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit().setValue(selectRow.getSelfInfoShuruiLimitChokaUnit());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit().setValue(selectRow.getSelfInfoShuruiLimitNaiUnit());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit().setValue(selectRow.getSelfInfoKubunLimitChokaUnit());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getSelfInfoKubunLimitNaiUnit());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailUnitTanka().setValue(selectRow.getSelfInfoUnitTanka());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getSelfInfoKyufuRitsu());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal().setValue(selectRow.getSelfInfoHiyoTotal());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu().setValue(selectRow.getSelfInfoHokenKyufuGaku());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken().setValue(selectRow.getSelfInfoHokenFutan());
        goukei.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getSelfInfoFutanTotal());
    }
}
