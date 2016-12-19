/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsaschedulehyo;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.WeekRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import static jp.co.ndensan.reams.db.dbz.definition.core.hokensha.UnyoKeitaiKubun.広域連合;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会スケジュール表（年間）の曜日クラスです。
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class ShinsaschedulehyoBusiness {

    private static final RString 文字列0 = new RString("0");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private RString year = RString.EMPTY;

    /**
     * 介護認定審査会スケジュール表（年間）の曜日Entityを返します。
     *
     * @param 年度 RString
     * @return WeekRelateEntity
     */
    public WeekRelateEntity getWeekRelateEntity(RString 年度) {
        year = 年度;
        WeekRelateEntity entity = new WeekRelateEntity();
        RStringBuilder nendoBuilder = new RStringBuilder();
        nendoBuilder.append(new FlexibleYear(年度).wareki().eraType(EraType.KANJI).toDateString());
        nendoBuilder.append(new RString("年度"));
        entity.setNendoWareki(nendoBuilder.toRString());
        entity.setCityName(DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        entity.setHakkoYMD(get印刷日時());
        set1月曜日(entity);
        set2月曜日(entity);
        set3月曜日(entity);
        set4月曜日(entity);
        set5月曜日(entity);
        set6月曜日(entity);
        set7月曜日(entity);
        set8月曜日(entity);
        set9月曜日(entity);
        set10月曜日(entity);
        set11月曜日(entity);
        set12月曜日(entity);
        return entity;
    }

    private void set3月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.MARCH.getValue());
        int i = 1;
        entity.setListWeek12_1(曜日.get(i++));
        entity.setListWeek12_2(曜日.get(i++));
        entity.setListWeek12_3(曜日.get(i++));
        entity.setListWeek12_4(曜日.get(i++));
        entity.setListWeek12_5(曜日.get(i++));
        entity.setListWeek12_6(曜日.get(i++));
        entity.setListWeek12_7(曜日.get(i++));
        entity.setListWeek12_8(曜日.get(i++));
        entity.setListWeek12_9(曜日.get(i++));
        entity.setListWeek12_10(曜日.get(i++));
        entity.setListWeek12_11(曜日.get(i++));
        entity.setListWeek12_12(曜日.get(i++));
        entity.setListWeek12_13(曜日.get(i++));
        entity.setListWeek12_14(曜日.get(i++));
        entity.setListWeek12_15(曜日.get(i++));
        entity.setListWeek12_16(曜日.get(i++));
        entity.setListWeek12_17(曜日.get(i++));
        entity.setListWeek12_18(曜日.get(i++));
        entity.setListWeek12_19(曜日.get(i++));
        entity.setListWeek12_20(曜日.get(i++));
        entity.setListWeek12_21(曜日.get(i++));
        entity.setListWeek12_22(曜日.get(i++));
        entity.setListWeek12_23(曜日.get(i++));
        entity.setListWeek12_24(曜日.get(i++));
        entity.setListWeek12_25(曜日.get(i++));
        entity.setListWeek12_26(曜日.get(i++));
        entity.setListWeek12_27(曜日.get(i++));
        entity.setListWeek12_28(曜日.get(i++));
        entity.setListWeek12_29(曜日.get(i++));
        entity.setListWeek12_30(曜日.get(i++));
        entity.setListWeek12_31(曜日.get(i++));
    }

    private void set2月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.FEBRUARY.getValue());
        int i = 1;
        entity.setListWeek11_1(曜日.get(i++));
        entity.setListWeek11_2(曜日.get(i++));
        entity.setListWeek11_3(曜日.get(i++));
        entity.setListWeek11_4(曜日.get(i++));
        entity.setListWeek11_5(曜日.get(i++));
        entity.setListWeek11_6(曜日.get(i++));
        entity.setListWeek11_7(曜日.get(i++));
        entity.setListWeek11_8(曜日.get(i++));
        entity.setListWeek11_9(曜日.get(i++));
        entity.setListWeek11_10(曜日.get(i++));
        entity.setListWeek11_11(曜日.get(i++));
        entity.setListWeek11_12(曜日.get(i++));
        entity.setListWeek11_13(曜日.get(i++));
        entity.setListWeek11_14(曜日.get(i++));
        entity.setListWeek11_15(曜日.get(i++));
        entity.setListWeek11_16(曜日.get(i++));
        entity.setListWeek11_17(曜日.get(i++));
        entity.setListWeek11_18(曜日.get(i++));
        entity.setListWeek11_19(曜日.get(i++));
        entity.setListWeek11_20(曜日.get(i++));
        entity.setListWeek11_21(曜日.get(i++));
        entity.setListWeek11_22(曜日.get(i++));
        entity.setListWeek11_23(曜日.get(i++));
        entity.setListWeek11_24(曜日.get(i++));
        entity.setListWeek11_25(曜日.get(i++));
        entity.setListWeek11_26(曜日.get(i++));
        entity.setListWeek11_27(曜日.get(i++));
        entity.setListWeek11_28(曜日.get(i++));
        entity.setListWeek11_29(曜日.get(i++));
        entity.setListWeek11_30(曜日.get(i++));
        entity.setListWeek11_31(曜日.get(i++));
    }

    private void set1月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.JANUARY.getValue());
        int i = 1;
        entity.setListWeek10_1(曜日.get(i++));
        entity.setListWeek10_2(曜日.get(i++));
        entity.setListWeek10_3(曜日.get(i++));
        entity.setListWeek10_4(曜日.get(i++));
        entity.setListWeek10_5(曜日.get(i++));
        entity.setListWeek10_6(曜日.get(i++));
        entity.setListWeek10_7(曜日.get(i++));
        entity.setListWeek10_8(曜日.get(i++));
        entity.setListWeek10_9(曜日.get(i++));
        entity.setListWeek10_10(曜日.get(i++));
        entity.setListWeek10_11(曜日.get(i++));
        entity.setListWeek10_12(曜日.get(i++));
        entity.setListWeek10_13(曜日.get(i++));
        entity.setListWeek10_14(曜日.get(i++));
        entity.setListWeek10_15(曜日.get(i++));
        entity.setListWeek10_16(曜日.get(i++));
        entity.setListWeek10_17(曜日.get(i++));
        entity.setListWeek10_18(曜日.get(i++));
        entity.setListWeek10_19(曜日.get(i++));
        entity.setListWeek10_20(曜日.get(i++));
        entity.setListWeek10_21(曜日.get(i++));
        entity.setListWeek10_22(曜日.get(i++));
        entity.setListWeek10_23(曜日.get(i++));
        entity.setListWeek10_24(曜日.get(i++));
        entity.setListWeek10_25(曜日.get(i++));
        entity.setListWeek10_26(曜日.get(i++));
        entity.setListWeek10_27(曜日.get(i++));
        entity.setListWeek10_28(曜日.get(i++));
        entity.setListWeek10_29(曜日.get(i++));
        entity.setListWeek10_30(曜日.get(i++));
        entity.setListWeek10_31(曜日.get(i++));
    }

    private void set12月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.DECEMBER.getValue());
        int i = 1;
        entity.setListWeek9_1(曜日.get(i++));
        entity.setListWeek9_2(曜日.get(i++));
        entity.setListWeek9_3(曜日.get(i++));
        entity.setListWeek9_4(曜日.get(i++));
        entity.setListWeek9_5(曜日.get(i++));
        entity.setListWeek9_6(曜日.get(i++));
        entity.setListWeek9_7(曜日.get(i++));
        entity.setListWeek9_8(曜日.get(i++));
        entity.setListWeek9_9(曜日.get(i++));
        entity.setListWeek9_10(曜日.get(i++));
        entity.setListWeek9_11(曜日.get(i++));
        entity.setListWeek9_12(曜日.get(i++));
        entity.setListWeek9_13(曜日.get(i++));
        entity.setListWeek9_14(曜日.get(i++));
        entity.setListWeek9_15(曜日.get(i++));
        entity.setListWeek9_16(曜日.get(i++));
        entity.setListWeek9_17(曜日.get(i++));
        entity.setListWeek9_18(曜日.get(i++));
        entity.setListWeek9_19(曜日.get(i++));
        entity.setListWeek9_20(曜日.get(i++));
        entity.setListWeek9_21(曜日.get(i++));
        entity.setListWeek9_22(曜日.get(i++));
        entity.setListWeek9_23(曜日.get(i++));
        entity.setListWeek9_24(曜日.get(i++));
        entity.setListWeek9_25(曜日.get(i++));
        entity.setListWeek9_26(曜日.get(i++));
        entity.setListWeek9_27(曜日.get(i++));
        entity.setListWeek9_28(曜日.get(i++));
        entity.setListWeek9_29(曜日.get(i++));
        entity.setListWeek9_30(曜日.get(i++));
        entity.setListWeek9_31(曜日.get(i++));
    }

    private void set11月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.NOVEMBER.getValue());
        int i = 1;
        entity.setListWeek8_1(曜日.get(i++));
        entity.setListWeek8_2(曜日.get(i++));
        entity.setListWeek8_3(曜日.get(i++));
        entity.setListWeek8_4(曜日.get(i++));
        entity.setListWeek8_5(曜日.get(i++));
        entity.setListWeek8_6(曜日.get(i++));
        entity.setListWeek8_7(曜日.get(i++));
        entity.setListWeek8_8(曜日.get(i++));
        entity.setListWeek8_9(曜日.get(i++));
        entity.setListWeek8_10(曜日.get(i++));
        entity.setListWeek8_11(曜日.get(i++));
        entity.setListWeek8_12(曜日.get(i++));
        entity.setListWeek8_13(曜日.get(i++));
        entity.setListWeek8_14(曜日.get(i++));
        entity.setListWeek8_15(曜日.get(i++));
        entity.setListWeek8_16(曜日.get(i++));
        entity.setListWeek8_17(曜日.get(i++));
        entity.setListWeek8_18(曜日.get(i++));
        entity.setListWeek8_19(曜日.get(i++));
        entity.setListWeek8_20(曜日.get(i++));
        entity.setListWeek8_21(曜日.get(i++));
        entity.setListWeek8_22(曜日.get(i++));
        entity.setListWeek8_23(曜日.get(i++));
        entity.setListWeek8_24(曜日.get(i++));
        entity.setListWeek8_25(曜日.get(i++));
        entity.setListWeek8_26(曜日.get(i++));
        entity.setListWeek8_27(曜日.get(i++));
        entity.setListWeek8_28(曜日.get(i++));
        entity.setListWeek8_29(曜日.get(i++));
        entity.setListWeek8_30(曜日.get(i++));
        entity.setListWeek8_31(曜日.get(i++));
    }

    private void set10月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.OCTOBER.getValue());
        int i = 1;
        entity.setListWeek7_1(曜日.get(i++));
        entity.setListWeek7_2(曜日.get(i++));
        entity.setListWeek7_3(曜日.get(i++));
        entity.setListWeek7_4(曜日.get(i++));
        entity.setListWeek7_5(曜日.get(i++));
        entity.setListWeek7_6(曜日.get(i++));
        entity.setListWeek7_7(曜日.get(i++));
        entity.setListWeek7_8(曜日.get(i++));
        entity.setListWeek7_9(曜日.get(i++));
        entity.setListWeek7_10(曜日.get(i++));
        entity.setListWeek7_11(曜日.get(i++));
        entity.setListWeek7_12(曜日.get(i++));
        entity.setListWeek7_13(曜日.get(i++));
        entity.setListWeek7_14(曜日.get(i++));
        entity.setListWeek7_15(曜日.get(i++));
        entity.setListWeek7_16(曜日.get(i++));
        entity.setListWeek7_17(曜日.get(i++));
        entity.setListWeek7_18(曜日.get(i++));
        entity.setListWeek7_19(曜日.get(i++));
        entity.setListWeek7_20(曜日.get(i++));
        entity.setListWeek7_21(曜日.get(i++));
        entity.setListWeek7_22(曜日.get(i++));
        entity.setListWeek7_23(曜日.get(i++));
        entity.setListWeek7_24(曜日.get(i++));
        entity.setListWeek7_25(曜日.get(i++));
        entity.setListWeek7_26(曜日.get(i++));
        entity.setListWeek7_27(曜日.get(i++));
        entity.setListWeek7_28(曜日.get(i++));
        entity.setListWeek7_29(曜日.get(i++));
        entity.setListWeek7_30(曜日.get(i++));
        entity.setListWeek7_31(曜日.get(i++));
    }

    private void set9月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.SEPTEMBER.getValue());
        int i = 1;
        entity.setListWeek6_1(曜日.get(i++));
        entity.setListWeek6_2(曜日.get(i++));
        entity.setListWeek6_3(曜日.get(i++));
        entity.setListWeek6_4(曜日.get(i++));
        entity.setListWeek6_5(曜日.get(i++));
        entity.setListWeek6_6(曜日.get(i++));
        entity.setListWeek6_7(曜日.get(i++));
        entity.setListWeek6_8(曜日.get(i++));
        entity.setListWeek6_9(曜日.get(i++));
        entity.setListWeek6_10(曜日.get(i++));
        entity.setListWeek6_11(曜日.get(i++));
        entity.setListWeek6_12(曜日.get(i++));
        entity.setListWeek6_13(曜日.get(i++));
        entity.setListWeek6_14(曜日.get(i++));
        entity.setListWeek6_15(曜日.get(i++));
        entity.setListWeek6_16(曜日.get(i++));
        entity.setListWeek6_17(曜日.get(i++));
        entity.setListWeek6_18(曜日.get(i++));
        entity.setListWeek6_19(曜日.get(i++));
        entity.setListWeek6_20(曜日.get(i++));
        entity.setListWeek6_21(曜日.get(i++));
        entity.setListWeek6_22(曜日.get(i++));
        entity.setListWeek6_23(曜日.get(i++));
        entity.setListWeek6_24(曜日.get(i++));
        entity.setListWeek6_25(曜日.get(i++));
        entity.setListWeek6_26(曜日.get(i++));
        entity.setListWeek6_27(曜日.get(i++));
        entity.setListWeek6_28(曜日.get(i++));
        entity.setListWeek6_29(曜日.get(i++));
        entity.setListWeek6_30(曜日.get(i++));
        entity.setListWeek6_31(曜日.get(i++));
    }

    private void set8月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.AUGUST.getValue());
        int i = 1;
        entity.setListWeek5_1(曜日.get(i++));
        entity.setListWeek5_2(曜日.get(i++));
        entity.setListWeek5_3(曜日.get(i++));
        entity.setListWeek5_4(曜日.get(i++));
        entity.setListWeek5_5(曜日.get(i++));
        entity.setListWeek5_6(曜日.get(i++));
        entity.setListWeek5_7(曜日.get(i++));
        entity.setListWeek5_8(曜日.get(i++));
        entity.setListWeek5_9(曜日.get(i++));
        entity.setListWeek5_10(曜日.get(i++));
        entity.setListWeek5_11(曜日.get(i++));
        entity.setListWeek5_12(曜日.get(i++));
        entity.setListWeek5_13(曜日.get(i++));
        entity.setListWeek5_14(曜日.get(i++));
        entity.setListWeek5_15(曜日.get(i++));
        entity.setListWeek5_16(曜日.get(i++));
        entity.setListWeek5_17(曜日.get(i++));
        entity.setListWeek5_18(曜日.get(i++));
        entity.setListWeek5_19(曜日.get(i++));
        entity.setListWeek5_20(曜日.get(i++));
        entity.setListWeek5_21(曜日.get(i++));
        entity.setListWeek5_22(曜日.get(i++));
        entity.setListWeek5_23(曜日.get(i++));
        entity.setListWeek5_24(曜日.get(i++));
        entity.setListWeek5_25(曜日.get(i++));
        entity.setListWeek5_26(曜日.get(i++));
        entity.setListWeek5_27(曜日.get(i++));
        entity.setListWeek5_28(曜日.get(i++));
        entity.setListWeek5_29(曜日.get(i++));
        entity.setListWeek5_30(曜日.get(i++));
        entity.setListWeek5_31(曜日.get(i++));
    }

    private void set7月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.JULY.getValue());
        int i = 1;
        entity.setListWeek4_1(曜日.get(i++));
        entity.setListWeek4_2(曜日.get(i++));
        entity.setListWeek4_3(曜日.get(i++));
        entity.setListWeek4_4(曜日.get(i++));
        entity.setListWeek4_5(曜日.get(i++));
        entity.setListWeek4_6(曜日.get(i++));
        entity.setListWeek4_7(曜日.get(i++));
        entity.setListWeek4_8(曜日.get(i++));
        entity.setListWeek4_9(曜日.get(i++));
        entity.setListWeek4_10(曜日.get(i++));
        entity.setListWeek4_11(曜日.get(i++));
        entity.setListWeek4_12(曜日.get(i++));
        entity.setListWeek4_13(曜日.get(i++));
        entity.setListWeek4_14(曜日.get(i++));
        entity.setListWeek4_15(曜日.get(i++));
        entity.setListWeek4_16(曜日.get(i++));
        entity.setListWeek4_17(曜日.get(i++));
        entity.setListWeek4_18(曜日.get(i++));
        entity.setListWeek4_19(曜日.get(i++));
        entity.setListWeek4_20(曜日.get(i++));
        entity.setListWeek4_21(曜日.get(i++));
        entity.setListWeek4_22(曜日.get(i++));
        entity.setListWeek4_23(曜日.get(i++));
        entity.setListWeek4_24(曜日.get(i++));
        entity.setListWeek4_25(曜日.get(i++));
        entity.setListWeek4_26(曜日.get(i++));
        entity.setListWeek4_27(曜日.get(i++));
        entity.setListWeek4_28(曜日.get(i++));
        entity.setListWeek4_29(曜日.get(i++));
        entity.setListWeek4_30(曜日.get(i++));
        entity.setListWeek4_31(曜日.get(i++));
    }

    private void set6月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.JUNE.getValue());
        int i = 1;
        entity.setListWeek3_1(曜日.get(i++));
        entity.setListWeek3_2(曜日.get(i++));
        entity.setListWeek3_3(曜日.get(i++));
        entity.setListWeek3_4(曜日.get(i++));
        entity.setListWeek3_5(曜日.get(i++));
        entity.setListWeek3_6(曜日.get(i++));
        entity.setListWeek3_7(曜日.get(i++));
        entity.setListWeek3_8(曜日.get(i++));
        entity.setListWeek3_9(曜日.get(i++));
        entity.setListWeek3_10(曜日.get(i++));
        entity.setListWeek3_11(曜日.get(i++));
        entity.setListWeek3_12(曜日.get(i++));
        entity.setListWeek3_13(曜日.get(i++));
        entity.setListWeek3_14(曜日.get(i++));
        entity.setListWeek3_15(曜日.get(i++));
        entity.setListWeek3_16(曜日.get(i++));
        entity.setListWeek3_17(曜日.get(i++));
        entity.setListWeek3_18(曜日.get(i++));
        entity.setListWeek3_19(曜日.get(i++));
        entity.setListWeek3_20(曜日.get(i++));
        entity.setListWeek3_21(曜日.get(i++));
        entity.setListWeek3_22(曜日.get(i++));
        entity.setListWeek3_23(曜日.get(i++));
        entity.setListWeek3_24(曜日.get(i++));
        entity.setListWeek3_25(曜日.get(i++));
        entity.setListWeek3_26(曜日.get(i++));
        entity.setListWeek3_27(曜日.get(i++));
        entity.setListWeek3_28(曜日.get(i++));
        entity.setListWeek3_29(曜日.get(i++));
        entity.setListWeek3_30(曜日.get(i++));
        entity.setListWeek3_31(曜日.get(i++));
    }

    private void set5月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.MAY.getValue());
        int i = 1;
        entity.setListWeek2_1(曜日.get(i++));
        entity.setListWeek2_2(曜日.get(i++));
        entity.setListWeek2_3(曜日.get(i++));
        entity.setListWeek2_4(曜日.get(i++));
        entity.setListWeek2_5(曜日.get(i++));
        entity.setListWeek2_6(曜日.get(i++));
        entity.setListWeek2_7(曜日.get(i++));
        entity.setListWeek2_8(曜日.get(i++));
        entity.setListWeek2_9(曜日.get(i++));
        entity.setListWeek2_10(曜日.get(i++));
        entity.setListWeek2_11(曜日.get(i++));
        entity.setListWeek2_12(曜日.get(i++));
        entity.setListWeek2_13(曜日.get(i++));
        entity.setListWeek2_14(曜日.get(i++));
        entity.setListWeek2_15(曜日.get(i++));
        entity.setListWeek2_16(曜日.get(i++));
        entity.setListWeek2_17(曜日.get(i++));
        entity.setListWeek2_18(曜日.get(i++));
        entity.setListWeek2_19(曜日.get(i++));
        entity.setListWeek2_20(曜日.get(i++));
        entity.setListWeek2_21(曜日.get(i++));
        entity.setListWeek2_22(曜日.get(i++));
        entity.setListWeek2_23(曜日.get(i++));
        entity.setListWeek2_24(曜日.get(i++));
        entity.setListWeek2_25(曜日.get(i++));
        entity.setListWeek2_26(曜日.get(i++));
        entity.setListWeek2_27(曜日.get(i++));
        entity.setListWeek2_28(曜日.get(i++));
        entity.setListWeek2_29(曜日.get(i++));
        entity.setListWeek2_30(曜日.get(i++));
        entity.setListWeek2_31(曜日.get(i++));
    }

    private void set4月曜日(WeekRelateEntity entity) {
        Map<Integer, RString> 曜日 = get曜日(Month.APRIL.getValue());
        int i = 1;
        entity.setListWeek1_1(曜日.get(i++));
        entity.setListWeek1_2(曜日.get(i++));
        entity.setListWeek1_3(曜日.get(i++));
        entity.setListWeek1_4(曜日.get(i++));
        entity.setListWeek1_5(曜日.get(i++));
        entity.setListWeek1_6(曜日.get(i++));
        entity.setListWeek1_7(曜日.get(i++));
        entity.setListWeek1_8(曜日.get(i++));
        entity.setListWeek1_9(曜日.get(i++));
        entity.setListWeek1_10(曜日.get(i++));
        entity.setListWeek1_11(曜日.get(i++));
        entity.setListWeek1_12(曜日.get(i++));
        entity.setListWeek1_13(曜日.get(i++));
        entity.setListWeek1_14(曜日.get(i++));
        entity.setListWeek1_15(曜日.get(i++));
        entity.setListWeek1_16(曜日.get(i++));
        entity.setListWeek1_17(曜日.get(i++));
        entity.setListWeek1_18(曜日.get(i++));
        entity.setListWeek1_19(曜日.get(i++));
        entity.setListWeek1_20(曜日.get(i++));
        entity.setListWeek1_21(曜日.get(i++));
        entity.setListWeek1_22(曜日.get(i++));
        entity.setListWeek1_23(曜日.get(i++));
        entity.setListWeek1_24(曜日.get(i++));
        entity.setListWeek1_25(曜日.get(i++));
        entity.setListWeek1_26(曜日.get(i++));
        entity.setListWeek1_27(曜日.get(i++));
        entity.setListWeek1_28(曜日.get(i++));
        entity.setListWeek1_29(曜日.get(i++));
        entity.setListWeek1_30(曜日.get(i++));
        entity.setListWeek1_31(曜日.get(i++));
    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }

    private Map<Integer, RString> get曜日(int 月) {
        Map<Integer, RString> 曜日 = new HashMap();
        RStringBuilder builder = new RStringBuilder();
        builder.append(year);
        builder.append((new RString(String.valueOf(月))).padLeft(文字列0, 2));
        int lastDay = (new FlexibleYearMonth(builder.toString())).getLastDay();
        for (int i = 1; i <= lastDay; i++) {
            RStringBuilder dateBuilder = new RStringBuilder();
            dateBuilder.append(builder);
            dateBuilder.append((new RString(String.valueOf(i))).padLeft(文字列0, 2));
            FlexibleDate flexibleDate = new FlexibleDate(dateBuilder.toRString());
            曜日.put(i, new RString(flexibleDate.getDayOfWeek().getShortTerm().toString()));
        }
        return 曜日;
    }

}
