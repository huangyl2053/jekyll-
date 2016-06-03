/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * KaigoGekihenKanwaSettei_激変緩和ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBB-1770-020 wangkanglei
 */
public class KaigoGekihenKanwaSetteiHandler {

    private final KaigoGekihenKanwaSetteiDiv div;
    private static final RString 第1段階 = new RString("第1段階");
    private static final RString 第2段階 = new RString("第2段階");
    private static final RString 第3段階 = new RString("第3段階");
    private static final RString 第4段階 = new RString("第4段階");
    private static final RString 第5段階 = new RString("第5段階");
    private static final RString 税改正前 = new RString("txtKaiseiMaeDankai");
    private static final RString 税改正後 = new RString("txtKaiseiAtoDankai");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;

    /**
     * コンストラクタです。
     *
     * @param div PaymentDateDiv
     */
    public KaigoGekihenKanwaSetteiHandler(KaigoGekihenKanwaSetteiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return PaymentDateDiv
     */
    public static KaigoGekihenKanwaSetteiHandler of(KaigoGekihenKanwaSetteiDiv div) {
        return new KaigoGekihenKanwaSetteiHandler(div);
    }

    /**
     * 激変緩和Gridの初期設定のンメソッドます。
     *
     * @param hdnGekihenIndex04 保険料率04
     * @param hdnGekihenIndex05 保険料率05
     * @param hdnGekihenIndex06 保険料率06
     * @param hdnGekihenIndex08 保険料率08
     * @param hdnGekihenIndex09 保険料率09
     * @param hdnGekihenIndex10 保険料率10
     * @param hdnGekihenIndex11 保険料率11
     */
    public void onLoad(Decimal hdnGekihenIndex04,
            Decimal hdnGekihenIndex05,
            Decimal hdnGekihenIndex06,
            Decimal hdnGekihenIndex08,
            Decimal hdnGekihenIndex09,
            Decimal hdnGekihenIndex10,
            Decimal hdnGekihenIndex11) {

        List<dgGekihenKanwa_Row> rowList = new ArrayList<>();
        dgGekihenKanwa_Row row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第1段階);
        row.getTxtKaiseiAtoDankai().setValue(第4段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex04);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第2段階);
        row.getTxtKaiseiAtoDankai().setValue(第4段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex05);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第3段階);
        row.getTxtKaiseiAtoDankai().setValue(第4段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex06);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第1段階);
        row.getTxtKaiseiAtoDankai().setValue(第5段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex08);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第2段階);
        row.getTxtKaiseiAtoDankai().setValue(第5段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex09);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第3段階);
        row.getTxtKaiseiAtoDankai().setValue(第5段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex10);
        rowList.add(row);
        row = new dgGekihenKanwa_Row();
        row.getTxtKaiseiMaeDankai().setValue(第4段階);
        row.getTxtKaiseiAtoDankai().setValue(第5段階);
        row.getTxtHokenryoRitsu().setValue(hdnGekihenIndex11);
        rowList.add(row);
        div.getDgGekihenKanwa().setDataSource(rowList);

        for (int i = NUM_0; i <= NUM_6; i++) {
            if (i < NUM_3) {
                div.getDgGekihenKanwa().getDataSource().get(i).setCellBgColor(
                        税改正前.toString(), DataGridCellBgColor.bgColorLightRed);
                div.getDgGekihenKanwa().getDataSource().get(i).setCellBgColor(
                        税改正後.toString(), DataGridCellBgColor.bgColorLightRed);
            } else {
                div.getDgGekihenKanwa().getDataSource().get(i).setCellBgColor(
                        税改正前.toString(), DataGridCellBgColor.bgColorLightGreen);
                div.getDgGekihenKanwa().getDataSource().get(i).setCellBgColor(
                        税改正後.toString(), DataGridCellBgColor.bgColorLightGreen);
            }
        }
    }

    /**
     * 激変緩和Gridの保険料率をhiddenInputに保持してのンメソッドます。
     *
     * @return boolean
     */
    public boolean isHiddenInput() {

        List<dgGekihenKanwa_Row> rowList = div.getDgGekihenKanwa().getDataSource();
        Decimal 保険料率4 = rowList.get(NUM_0).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_0).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率5 = rowList.get(NUM_1).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_1).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率6 = rowList.get(NUM_2).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_2).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率8 = rowList.get(NUM_3).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_3).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率9 = rowList.get(NUM_4).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_4).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率10 = rowList.get(NUM_5).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_5).getTxtHokenryoRitsu().getValue();
        Decimal 保険料率11 = rowList.get(NUM_6).getTxtHokenryoRitsu().getValue() == null
                ? Decimal.ZERO : rowList.get(NUM_6).getTxtHokenryoRitsu().getValue();
        if (保険料率4.compareTo(保険料率5) == NUM_1) {
            return true;
        }
        if (保険料率5.compareTo(保険料率6) == NUM_1) {
            return true;
        }
        if (保険料率8.compareTo(保険料率9) == NUM_1) {
            return true;
        }
        if (保険料率9.compareTo(保険料率10) == NUM_1) {
            return true;
        }
        if (保険料率10.compareTo(保険料率11) == NUM_1) {
            return true;
        }
        div.setHdnGekihenIndex04(DataPassingConverter.serialize(保険料率4));
        div.setHdnGekihenIndex05(DataPassingConverter.serialize(保険料率5));
        div.setHdnGekihenIndex06(DataPassingConverter.serialize(保険料率6));
        div.setHdnGekihenIndex08(DataPassingConverter.serialize(保険料率8));
        div.setHdnGekihenIndex09(DataPassingConverter.serialize(保険料率9));
        div.setHdnGekihenIndex10(DataPassingConverter.serialize(保険料率10));
        div.setHdnGekihenIndex11(DataPassingConverter.serialize(保険料率11));
        return false;
    }
}
