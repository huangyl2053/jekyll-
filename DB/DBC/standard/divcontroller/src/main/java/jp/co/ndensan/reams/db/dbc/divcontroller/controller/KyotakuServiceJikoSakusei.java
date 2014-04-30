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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiDiv;
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
        initPanel(panel);
        List<dgKyotakuServiceJikoSakusei_Row> arrayData = create居宅サービス一覧();
        dgRow.setDataSource(arrayData);
        response.data = panel;
        return response;
    }

    /*
     画面ロード時の初期化処理です。
     */
    private void initPanel(KyotakuServiceJikoSakuseiDiv panel) {
        panel.getKyotakuServiceJikoSakuseiDetail().setVisible(false);
        panel.getKyotakuServiceJikoSakuseiDetail().setDisplayNone(true);
    }

    private List<dgKyotakuServiceJikoSakusei_Row> create居宅サービス一覧() {
        List<dgKyotakuServiceJikoSakusei_Row> arrayData = new ArrayList<>();
        dgKyotakuServiceJikoSakusei_Row item;
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
     * 居宅サービス計画情報（自己作成）のデータグリッドで選択した計画を表示する際の処理。
     *
     * @param panel 居宅サービス計画情報（自己作成）
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceJikoSakuseiDiv> onClick_JikoSakuseiShowDetail(KyotakuServiceJikoSakuseiDiv panel) {
        ResponseData<KyotakuServiceJikoSakuseiDiv> response = new ResponseData<>();
        panel.getKyotakuServiceJikoSakuseiDetail().setVisible(true);
        panel.getKyotakuServiceJikoSakuseiDetail().setDisplayNone(false);
        setDetailData(panel);
        response.data = panel;
        return response;
    }

    /*
     SummaryPanelにデータを設定
     */
    private void setSummaryData(KyotakuServiceJikoSakuseiDiv panel) {
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakusei1().setValue(new RString("888888"));
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakusei2().setValue(new RString("888888"));
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakusei3().setValue(new RString("888888"));
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku().setValue(new RString("888,888"));
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakuseiGendoKanriRange().setFromValue(new RDate("20030701"));
        panel.getKyotakuServiceJikoSakuseiSummary().getTxtKyotakuServiceJikoSakuseiGendoKanriRange().setToValue(new RDate("20040531"));
    }

    /*
     詳細Panelにデータを設定
     */
    private void setDetailData(KyotakuServiceJikoSakuseiDiv panel) {
        dgKyotakuServiceJikoSakusei_Row selectRow = panel.getDgKyotakuServiceJikoSakusei().getClickedItem();
        tblKyotakuServiceJikoSakuseiDiv setTbl = panel.getKyotakuServiceJikoSakuseiDetail().getTblKyotakuServiceJikoSakusei();
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo().setValue(selectRow.getSelfInfoJigyoshaNo());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName().setValue(new RString("あああ介護事業者"));
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailServiceCode1().setValue(new RString("11"));
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailServiceCode2().setValue(new RString("1111"));
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailServiceCode3().setValue(new RString("身体介護１"));
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailUnit().setValue(selectRow.getSelfInfoUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu().setValue(selectRow.getSelfInfoWaribikiRitsu());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit().setValue(selectRow.getSelfInfoWaribikiUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailKaisu().setValue(selectRow.getSelfInfoNum());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailServiceUnit().setValue(selectRow.getSelfInfoServiceUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit().setValue(selectRow.getSelfInfoShuruiLimitChokaUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit().setValue(selectRow.getSelfInfoShuruiLimitNaiUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit().setValue(selectRow.getSelfInfoKubunLimitChokaUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit().setValue(selectRow.getSelfInfoKubunLimitNaiUnit());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailUnitTanka().setValue(selectRow.getSelfInfoUnitTanka());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu().setValue(selectRow.getSelfInfoKyufuRitsu());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal().setValue(selectRow.getSelfInfoHiyoTotal());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu().setValue(selectRow.getSelfInfoHokenKyufuGaku());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken().setValue(selectRow.getSelfInfoHokenFutan());
        setTbl.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal().setValue(selectRow.getSelfInfoFutanTotal());
    }
}
