/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.WeekRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;

/**
 * 介護認定審査会スケジュール表（年間）のHeadEditorです。
 *
 * @reamsid_L DBE-0130-081 duanzhanli
 */
public class ShinsaschedulehyoHeadEditor implements IShinsaschedulehyoHeadEditor {

    private final WeekRelateEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link WeekRelateEntity}
     */
    protected ShinsaschedulehyoHeadEditor(WeekRelateEntity target) {
        this.target = target;
    }

    @Override
    public ShinsaschedulehyoReportSource edit(ShinsaschedulehyoReportSource source) {
        edit1月Source(source);
        edit2月Source(source);
        edit3月Source(source);
        edit4月Source(source);
        edit5月Source(source);
        edit6月Source(source);
        edit7月Source(source);
        edit8月Source(source);
        edit9月Source(source);
        edit10月Source(source);
        edit11月Source(source);
        edit12月Source(source);
        return source;
    }

    private ShinsaschedulehyoReportSource edit4月Source(ShinsaschedulehyoReportSource source) {
        source.nendoWareki = target.getNendoWareki();
        source.cityName = target.getCityName();
        source.hakkoYMD = target.getHakkoYMD();
        source.listWeek1_1 = target.getListWeek1_1();
        source.listWeek1_2 = target.getListWeek1_2();
        source.listWeek1_3 = target.getListWeek1_3();
        source.listWeek1_4 = target.getListWeek1_4();
        source.listWeek1_5 = target.getListWeek1_5();
        source.listWeek1_6 = target.getListWeek1_6();
        source.listWeek1_7 = target.getListWeek1_7();
        source.listWeek1_8 = target.getListWeek1_8();
        source.listWeek1_9 = target.getListWeek1_9();
        source.listWeek1_10 = target.getListWeek1_10();
        source.listWeek1_11 = target.getListWeek1_11();
        source.listWeek1_12 = target.getListWeek1_12();
        source.listWeek1_13 = target.getListWeek1_13();
        source.listWeek1_14 = target.getListWeek1_14();
        source.listWeek1_15 = target.getListWeek1_15();
        source.listWeek1_16 = target.getListWeek1_16();
        source.listWeek1_17 = target.getListWeek1_17();
        source.listWeek1_18 = target.getListWeek1_18();
        source.listWeek1_19 = target.getListWeek1_19();
        source.listWeek1_20 = target.getListWeek1_20();
        source.listWeek1_21 = target.getListWeek1_21();
        source.listWeek1_22 = target.getListWeek1_22();
        source.listWeek1_23 = target.getListWeek1_23();
        source.listWeek1_24 = target.getListWeek1_24();
        source.listWeek1_25 = target.getListWeek1_25();
        source.listWeek1_26 = target.getListWeek1_26();
        source.listWeek1_27 = target.getListWeek1_27();
        source.listWeek1_28 = target.getListWeek1_28();
        source.listWeek1_29 = target.getListWeek1_29();
        source.listWeek1_30 = target.getListWeek1_30();
        source.listWeek1_31 = target.getListWeek1_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit5月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek2_1 = target.getListWeek2_1();
        source.listWeek2_2 = target.getListWeek2_2();
        source.listWeek2_3 = target.getListWeek2_3();
        source.listWeek2_4 = target.getListWeek2_4();
        source.listWeek2_5 = target.getListWeek2_5();
        source.listWeek2_6 = target.getListWeek2_6();
        source.listWeek2_7 = target.getListWeek2_7();
        source.listWeek2_8 = target.getListWeek2_8();
        source.listWeek2_9 = target.getListWeek2_9();
        source.listWeek2_10 = target.getListWeek2_10();
        source.listWeek2_11 = target.getListWeek2_11();
        source.listWeek2_12 = target.getListWeek2_12();
        source.listWeek2_13 = target.getListWeek2_13();
        source.listWeek2_14 = target.getListWeek2_14();
        source.listWeek2_15 = target.getListWeek2_15();
        source.listWeek2_16 = target.getListWeek2_16();
        source.listWeek2_17 = target.getListWeek2_17();
        source.listWeek2_18 = target.getListWeek2_18();
        source.listWeek2_19 = target.getListWeek2_19();
        source.listWeek2_20 = target.getListWeek2_20();
        source.listWeek2_21 = target.getListWeek2_21();
        source.listWeek2_22 = target.getListWeek2_22();
        source.listWeek2_23 = target.getListWeek2_23();
        source.listWeek2_24 = target.getListWeek2_24();
        source.listWeek2_25 = target.getListWeek2_25();
        source.listWeek2_26 = target.getListWeek2_26();
        source.listWeek2_27 = target.getListWeek2_27();
        source.listWeek2_28 = target.getListWeek2_28();
        source.listWeek2_29 = target.getListWeek2_29();
        source.listWeek2_30 = target.getListWeek2_30();
        source.listWeek2_31 = target.getListWeek2_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit6月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek3_1 = target.getListWeek3_1();
        source.listWeek3_2 = target.getListWeek3_2();
        source.listWeek3_3 = target.getListWeek3_3();
        source.listWeek3_4 = target.getListWeek3_4();
        source.listWeek3_5 = target.getListWeek3_5();
        source.listWeek3_6 = target.getListWeek3_6();
        source.listWeek3_7 = target.getListWeek3_7();
        source.listWeek3_8 = target.getListWeek3_8();
        source.listWeek3_9 = target.getListWeek3_9();
        source.listWeek3_10 = target.getListWeek3_10();
        source.listWeek3_11 = target.getListWeek3_11();
        source.listWeek3_12 = target.getListWeek3_12();
        source.listWeek3_13 = target.getListWeek3_13();
        source.listWeek3_14 = target.getListWeek3_14();
        source.listWeek3_15 = target.getListWeek3_15();
        source.listWeek3_16 = target.getListWeek3_16();
        source.listWeek3_17 = target.getListWeek3_17();
        source.listWeek3_18 = target.getListWeek3_18();
        source.listWeek3_19 = target.getListWeek3_19();
        source.listWeek3_20 = target.getListWeek3_20();
        source.listWeek3_21 = target.getListWeek3_21();
        source.listWeek3_22 = target.getListWeek3_22();
        source.listWeek3_23 = target.getListWeek3_23();
        source.listWeek3_24 = target.getListWeek3_24();
        source.listWeek3_25 = target.getListWeek3_25();
        source.listWeek3_26 = target.getListWeek3_26();
        source.listWeek3_27 = target.getListWeek3_27();
        source.listWeek3_28 = target.getListWeek3_28();
        source.listWeek3_29 = target.getListWeek3_29();
        source.listWeek3_30 = target.getListWeek3_30();
        source.listWeek3_31 = target.getListWeek3_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit7月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek4_1 = target.getListWeek4_1();
        source.listWeek4_2 = target.getListWeek4_2();
        source.listWeek4_3 = target.getListWeek4_3();
        source.listWeek4_4 = target.getListWeek4_4();
        source.listWeek4_5 = target.getListWeek4_5();
        source.listWeek4_6 = target.getListWeek4_6();
        source.listWeek4_7 = target.getListWeek4_7();
        source.listWeek4_8 = target.getListWeek4_8();
        source.listWeek4_9 = target.getListWeek4_9();
        source.listWeek4_10 = target.getListWeek4_10();
        source.listWeek4_11 = target.getListWeek4_11();
        source.listWeek4_12 = target.getListWeek4_12();
        source.listWeek4_13 = target.getListWeek4_13();
        source.listWeek4_14 = target.getListWeek4_14();
        source.listWeek4_15 = target.getListWeek4_15();
        source.listWeek4_16 = target.getListWeek4_16();
        source.listWeek4_17 = target.getListWeek4_17();
        source.listWeek4_18 = target.getListWeek4_18();
        source.listWeek4_19 = target.getListWeek4_19();
        source.listWeek4_20 = target.getListWeek4_20();
        source.listWeek4_21 = target.getListWeek4_21();
        source.listWeek4_22 = target.getListWeek4_22();
        source.listWeek4_23 = target.getListWeek4_23();
        source.listWeek4_24 = target.getListWeek4_24();
        source.listWeek4_25 = target.getListWeek4_25();
        source.listWeek4_26 = target.getListWeek4_26();
        source.listWeek4_27 = target.getListWeek4_27();
        source.listWeek4_28 = target.getListWeek4_28();
        source.listWeek4_29 = target.getListWeek4_29();
        source.listWeek4_30 = target.getListWeek4_30();
        source.listWeek4_31 = target.getListWeek4_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit8月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek5_1 = target.getListWeek5_1();
        source.listWeek5_2 = target.getListWeek5_2();
        source.listWeek5_3 = target.getListWeek5_3();
        source.listWeek5_4 = target.getListWeek5_4();
        source.listWeek5_5 = target.getListWeek5_5();
        source.listWeek5_6 = target.getListWeek5_6();
        source.listWeek5_7 = target.getListWeek5_7();
        source.listWeek5_8 = target.getListWeek5_8();
        source.listWeek5_9 = target.getListWeek5_9();
        source.listWeek5_10 = target.getListWeek5_10();
        source.listWeek5_11 = target.getListWeek5_11();
        source.listWeek5_12 = target.getListWeek5_12();
        source.listWeek5_13 = target.getListWeek5_13();
        source.listWeek5_14 = target.getListWeek5_14();
        source.listWeek5_15 = target.getListWeek5_15();
        source.listWeek5_16 = target.getListWeek5_16();
        source.listWeek5_17 = target.getListWeek5_17();
        source.listWeek5_18 = target.getListWeek5_18();
        source.listWeek5_19 = target.getListWeek5_19();
        source.listWeek5_20 = target.getListWeek5_20();
        source.listWeek5_21 = target.getListWeek5_21();
        source.listWeek5_22 = target.getListWeek5_22();
        source.listWeek5_23 = target.getListWeek5_23();
        source.listWeek5_24 = target.getListWeek5_24();
        source.listWeek5_25 = target.getListWeek5_25();
        source.listWeek5_26 = target.getListWeek5_26();
        source.listWeek5_27 = target.getListWeek5_27();
        source.listWeek5_28 = target.getListWeek5_28();
        source.listWeek5_29 = target.getListWeek5_29();
        source.listWeek5_30 = target.getListWeek5_30();
        source.listWeek5_31 = target.getListWeek5_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit9月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek6_1 = target.getListWeek6_1();
        source.listWeek6_2 = target.getListWeek6_2();
        source.listWeek6_3 = target.getListWeek6_3();
        source.listWeek6_4 = target.getListWeek6_4();
        source.listWeek6_5 = target.getListWeek6_5();
        source.listWeek6_6 = target.getListWeek6_6();
        source.listWeek6_7 = target.getListWeek6_7();
        source.listWeek6_8 = target.getListWeek6_8();
        source.listWeek6_9 = target.getListWeek6_9();
        source.listWeek6_10 = target.getListWeek6_10();
        source.listWeek6_11 = target.getListWeek6_11();
        source.listWeek6_12 = target.getListWeek6_12();
        source.listWeek6_13 = target.getListWeek6_13();
        source.listWeek6_14 = target.getListWeek6_14();
        source.listWeek6_15 = target.getListWeek6_15();
        source.listWeek6_16 = target.getListWeek6_16();
        source.listWeek6_17 = target.getListWeek6_17();
        source.listWeek6_18 = target.getListWeek6_18();
        source.listWeek6_19 = target.getListWeek6_19();
        source.listWeek6_20 = target.getListWeek6_20();
        source.listWeek6_21 = target.getListWeek6_21();
        source.listWeek6_22 = target.getListWeek6_22();
        source.listWeek6_23 = target.getListWeek6_23();
        source.listWeek6_24 = target.getListWeek6_24();
        source.listWeek6_25 = target.getListWeek6_25();
        source.listWeek6_26 = target.getListWeek6_26();
        source.listWeek6_27 = target.getListWeek6_27();
        source.listWeek6_28 = target.getListWeek6_28();
        source.listWeek6_29 = target.getListWeek6_29();
        source.listWeek6_30 = target.getListWeek6_30();
        source.listWeek6_31 = target.getListWeek6_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit10月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek7_1 = target.getListWeek7_1();
        source.listWeek7_2 = target.getListWeek7_2();
        source.listWeek7_3 = target.getListWeek7_3();
        source.listWeek7_4 = target.getListWeek7_4();
        source.listWeek7_5 = target.getListWeek7_5();
        source.listWeek7_6 = target.getListWeek7_6();
        source.listWeek7_7 = target.getListWeek7_7();
        source.listWeek7_8 = target.getListWeek7_8();
        source.listWeek7_9 = target.getListWeek7_9();
        source.listWeek7_10 = target.getListWeek7_10();
        source.listWeek7_11 = target.getListWeek7_11();
        source.listWeek7_12 = target.getListWeek7_12();
        source.listWeek7_13 = target.getListWeek7_13();
        source.listWeek7_14 = target.getListWeek7_14();
        source.listWeek7_15 = target.getListWeek7_15();
        source.listWeek7_16 = target.getListWeek7_16();
        source.listWeek7_17 = target.getListWeek7_17();
        source.listWeek7_18 = target.getListWeek7_18();
        source.listWeek7_19 = target.getListWeek7_19();
        source.listWeek7_20 = target.getListWeek7_20();
        source.listWeek7_21 = target.getListWeek7_21();
        source.listWeek7_22 = target.getListWeek7_22();
        source.listWeek7_23 = target.getListWeek7_23();
        source.listWeek7_24 = target.getListWeek7_24();
        source.listWeek7_25 = target.getListWeek7_25();
        source.listWeek7_26 = target.getListWeek7_26();
        source.listWeek7_27 = target.getListWeek7_27();
        source.listWeek7_28 = target.getListWeek7_28();
        source.listWeek7_29 = target.getListWeek7_29();
        source.listWeek7_30 = target.getListWeek7_30();
        source.listWeek7_31 = target.getListWeek7_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit11月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek8_1 = target.getListWeek8_1();
        source.listWeek8_2 = target.getListWeek8_2();
        source.listWeek8_3 = target.getListWeek8_3();
        source.listWeek8_4 = target.getListWeek8_4();
        source.listWeek8_5 = target.getListWeek8_5();
        source.listWeek8_6 = target.getListWeek8_6();
        source.listWeek8_7 = target.getListWeek8_7();
        source.listWeek8_8 = target.getListWeek8_8();
        source.listWeek8_9 = target.getListWeek8_9();
        source.listWeek8_10 = target.getListWeek8_10();
        source.listWeek8_11 = target.getListWeek8_11();
        source.listWeek8_12 = target.getListWeek8_12();
        source.listWeek8_13 = target.getListWeek8_13();
        source.listWeek8_14 = target.getListWeek8_14();
        source.listWeek8_15 = target.getListWeek8_15();
        source.listWeek8_16 = target.getListWeek8_16();
        source.listWeek8_17 = target.getListWeek8_17();
        source.listWeek8_18 = target.getListWeek8_18();
        source.listWeek8_19 = target.getListWeek8_19();
        source.listWeek8_20 = target.getListWeek8_20();
        source.listWeek8_21 = target.getListWeek8_21();
        source.listWeek8_22 = target.getListWeek8_22();
        source.listWeek8_23 = target.getListWeek8_23();
        source.listWeek8_24 = target.getListWeek8_24();
        source.listWeek8_25 = target.getListWeek8_25();
        source.listWeek8_26 = target.getListWeek8_26();
        source.listWeek8_27 = target.getListWeek8_27();
        source.listWeek8_28 = target.getListWeek8_28();
        source.listWeek8_29 = target.getListWeek8_29();
        source.listWeek8_30 = target.getListWeek8_30();
        source.listWeek8_31 = target.getListWeek8_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit12月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek9_1 = target.getListWeek9_1();
        source.listWeek9_2 = target.getListWeek9_2();
        source.listWeek9_3 = target.getListWeek9_3();
        source.listWeek9_4 = target.getListWeek9_4();
        source.listWeek9_5 = target.getListWeek9_5();
        source.listWeek9_6 = target.getListWeek9_6();
        source.listWeek9_7 = target.getListWeek9_7();
        source.listWeek9_8 = target.getListWeek9_8();
        source.listWeek9_9 = target.getListWeek9_9();
        source.listWeek9_10 = target.getListWeek9_10();
        source.listWeek9_11 = target.getListWeek9_11();
        source.listWeek9_12 = target.getListWeek9_12();
        source.listWeek9_13 = target.getListWeek9_13();
        source.listWeek9_14 = target.getListWeek9_14();
        source.listWeek9_15 = target.getListWeek9_15();
        source.listWeek9_16 = target.getListWeek9_16();
        source.listWeek9_17 = target.getListWeek9_17();
        source.listWeek9_18 = target.getListWeek9_18();
        source.listWeek9_19 = target.getListWeek9_19();
        source.listWeek9_20 = target.getListWeek9_20();
        source.listWeek9_21 = target.getListWeek9_21();
        source.listWeek9_22 = target.getListWeek9_22();
        source.listWeek9_23 = target.getListWeek9_23();
        source.listWeek9_24 = target.getListWeek9_24();
        source.listWeek9_25 = target.getListWeek9_25();
        source.listWeek9_26 = target.getListWeek9_26();
        source.listWeek9_27 = target.getListWeek9_27();
        source.listWeek9_28 = target.getListWeek9_28();
        source.listWeek9_29 = target.getListWeek9_29();
        source.listWeek9_30 = target.getListWeek9_30();
        source.listWeek9_31 = target.getListWeek9_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit1月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek10_1 = target.getListWeek10_1();
        source.listWeek10_2 = target.getListWeek10_2();
        source.listWeek10_3 = target.getListWeek10_3();
        source.listWeek10_4 = target.getListWeek10_4();
        source.listWeek10_5 = target.getListWeek10_5();
        source.listWeek10_6 = target.getListWeek10_6();
        source.listWeek10_7 = target.getListWeek10_7();
        source.listWeek10_8 = target.getListWeek10_8();
        source.listWeek10_9 = target.getListWeek10_9();
        source.listWeek10_10 = target.getListWeek10_10();
        source.listWeek10_11 = target.getListWeek10_11();
        source.listWeek10_12 = target.getListWeek10_12();
        source.listWeek10_13 = target.getListWeek10_13();
        source.listWeek10_14 = target.getListWeek10_14();
        source.listWeek10_15 = target.getListWeek10_15();
        source.listWeek10_16 = target.getListWeek10_16();
        source.listWeek10_17 = target.getListWeek10_17();
        source.listWeek10_18 = target.getListWeek10_18();
        source.listWeek10_19 = target.getListWeek10_19();
        source.listWeek10_20 = target.getListWeek10_20();
        source.listWeek10_21 = target.getListWeek10_21();
        source.listWeek10_22 = target.getListWeek10_22();
        source.listWeek10_23 = target.getListWeek10_23();
        source.listWeek10_24 = target.getListWeek10_24();
        source.listWeek10_25 = target.getListWeek10_25();
        source.listWeek10_26 = target.getListWeek10_26();
        source.listWeek10_27 = target.getListWeek10_27();
        source.listWeek10_28 = target.getListWeek10_28();
        source.listWeek10_29 = target.getListWeek10_29();
        source.listWeek10_30 = target.getListWeek10_30();
        source.listWeek10_31 = target.getListWeek10_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit2月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek11_1 = target.getListWeek11_1();
        source.listWeek11_2 = target.getListWeek11_2();
        source.listWeek11_3 = target.getListWeek11_3();
        source.listWeek11_4 = target.getListWeek11_4();
        source.listWeek11_5 = target.getListWeek11_5();
        source.listWeek11_6 = target.getListWeek11_6();
        source.listWeek11_7 = target.getListWeek11_7();
        source.listWeek11_8 = target.getListWeek11_8();
        source.listWeek11_9 = target.getListWeek11_9();
        source.listWeek11_10 = target.getListWeek11_10();
        source.listWeek11_11 = target.getListWeek11_11();
        source.listWeek11_12 = target.getListWeek11_12();
        source.listWeek11_13 = target.getListWeek11_13();
        source.listWeek11_14 = target.getListWeek11_14();
        source.listWeek11_15 = target.getListWeek11_15();
        source.listWeek11_16 = target.getListWeek11_16();
        source.listWeek11_17 = target.getListWeek11_17();
        source.listWeek11_18 = target.getListWeek11_18();
        source.listWeek11_19 = target.getListWeek11_19();
        source.listWeek11_20 = target.getListWeek11_20();
        source.listWeek11_21 = target.getListWeek11_21();
        source.listWeek11_22 = target.getListWeek11_22();
        source.listWeek11_23 = target.getListWeek11_23();
        source.listWeek11_24 = target.getListWeek11_24();
        source.listWeek11_25 = target.getListWeek11_25();
        source.listWeek11_26 = target.getListWeek11_26();
        source.listWeek11_27 = target.getListWeek11_27();
        source.listWeek11_28 = target.getListWeek11_28();
        source.listWeek11_29 = target.getListWeek11_29();
        source.listWeek11_30 = target.getListWeek11_30();
        source.listWeek11_31 = target.getListWeek11_31();
        return source;
    }

    private ShinsaschedulehyoReportSource edit3月Source(ShinsaschedulehyoReportSource source) {
        source.listWeek12_1 = target.getListWeek12_1();
        source.listWeek12_2 = target.getListWeek12_2();
        source.listWeek12_3 = target.getListWeek12_3();
        source.listWeek12_4 = target.getListWeek12_4();
        source.listWeek12_5 = target.getListWeek12_5();
        source.listWeek12_6 = target.getListWeek12_6();
        source.listWeek12_7 = target.getListWeek12_7();
        source.listWeek12_8 = target.getListWeek12_8();
        source.listWeek12_9 = target.getListWeek12_9();
        source.listWeek12_10 = target.getListWeek12_10();
        source.listWeek12_11 = target.getListWeek12_11();
        source.listWeek12_12 = target.getListWeek12_12();
        source.listWeek12_13 = target.getListWeek12_13();
        source.listWeek12_14 = target.getListWeek12_14();
        source.listWeek12_15 = target.getListWeek12_15();
        source.listWeek12_16 = target.getListWeek12_16();
        source.listWeek12_17 = target.getListWeek12_17();
        source.listWeek12_18 = target.getListWeek12_18();
        source.listWeek12_19 = target.getListWeek12_19();
        source.listWeek12_20 = target.getListWeek12_20();
        source.listWeek12_21 = target.getListWeek12_21();
        source.listWeek12_22 = target.getListWeek12_22();
        source.listWeek12_23 = target.getListWeek12_23();
        source.listWeek12_24 = target.getListWeek12_24();
        source.listWeek12_25 = target.getListWeek12_25();
        source.listWeek12_26 = target.getListWeek12_26();
        source.listWeek12_27 = target.getListWeek12_27();
        source.listWeek12_28 = target.getListWeek12_28();
        source.listWeek12_29 = target.getListWeek12_29();
        source.listWeek12_30 = target.getListWeek12_30();
        source.listWeek12_31 = target.getListWeek12_31();
        return source;
    }

}
