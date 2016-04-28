/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 保険料ランクのクラスです。
 *
 * @reamsid_L DBB-9020-150 sunhaidi
 */
public class HokenryoRank {

    private static final int DAY = 31;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final long serialVersionUID = -100741497961633311L;

    /**
     * 年額計算に必要な月別市町村情報情報を、指定された資格の情報のリスト、賦課年度から編集し、返します。
     *
     * @param 資格の情報のリスト 資格の情報のリスト
     * @param 賦課年度 賦課年度
     * @return 月別市町村情報
     */
    public List<MonthShichoson> get月別市町村情報(List<HihokenshaDaicho> 資格の情報のリスト, FlexibleYear 賦課年度) {
        RDate 年度期間開始日 = NendoUtil.toNendoStartDate(賦課年度);
        RDate 年度期間終了日 = new RDate(賦課年度.plusYear(1).getYearValue(), Month.MARCH.getValue(), DAY);
        Collections.sort(資格の情報のリスト, new DateComparator());
        FlexibleDate 市町村コード取得用基準日 = null;
        LasdecCode 市町村コード = LasdecCode.EMPTY;
        if (!資格の情報のリスト.isEmpty()) {
            HihokenshaDaicho hihokenshaDaicho = 資格の情報のリスト.get(0);
            if (hihokenshaDaicho.get第1号資格取得年月日().isBeforeOrEquals(new FlexibleDate(年度期間開始日.toDateString()))) {
                市町村コード取得用基準日 = new FlexibleDate(年度期間開始日.toDateString());
            } else if (hihokenshaDaicho.get第1号資格取得年月日().isBeforeOrEquals(new FlexibleDate(年度期間終了日.toDateString()))) {
                市町村コード取得用基準日 = hihokenshaDaicho.get第1号資格取得年月日();
            }
            市町村コード = get市町村コード(hihokenshaDaicho);
        }

        Map<Integer, MonthShichoson> monthShichosonSet = createMonthShichosonMap();
        if (市町村コード取得用基準日 == null) {
            return toList(monthShichosonSet);
        }
        setMonthShichosonMap(monthShichosonSet, 市町村コード取得用基準日, 市町村コード);
        for (HihokenshaDaicho hihokenshaDaicho : 資格の情報のリスト) {
            FlexibleDate 異動日 = hihokenshaDaicho.get異動日();
            if (異動日 != null && !異動日.isEmpty()
                    && 市町村コード取得用基準日.isBeforeOrEquals(異動日)
                    && 異動日.isBeforeOrEquals(new FlexibleDate(年度期間終了日.toDateString()))) {
                市町村コード = get市町村コード(hihokenshaDaicho);
                setMonthShichosonMap(monthShichosonSet, 異動日, 市町村コード);
            }
            FlexibleDate 資格喪失年月日 = hihokenshaDaicho.get資格喪失年月日();
            if (資格喪失年月日 != null && !資格喪失年月日.isEmpty()
                    && 市町村コード取得用基準日.isBeforeOrEquals(資格喪失年月日)
                    && 資格喪失年月日.isBeforeOrEquals(new FlexibleDate(年度期間終了日.toDateString()))) {
                edit第1号資格取得年月日(hihokenshaDaicho, 資格喪失年月日, monthShichosonSet);
            }
        }

        return toList(monthShichosonSet);
    }

    private void edit第1号資格取得年月日(HihokenshaDaicho hihokenshaDaicho,
            FlexibleDate 資格喪失年月日, Map<Integer, MonthShichoson> monthShichosonSet) {
        FlexibleDate 第1号資格取得年月日 = hihokenshaDaicho.get第1号資格取得年月日();
        if (第1号資格取得年月日 != null && !第1号資格取得年月日.isEmpty()) {
            if (資格喪失年月日.equals(第1号資格取得年月日)) {
                clearMonthShichosonMap(monthShichosonSet, 資格喪失年月日.minusMonth(1));
            } else if (資格喪失年月日.getYearMonth().equals(第1号資格取得年月日.getYearMonth())) {
                clearMonthShichosonMap(monthShichosonSet, 資格喪失年月日.minusMonth(1));
            } else {
                clearMonthShichosonMap(monthShichosonSet, 資格喪失年月日);
            }
        }
    }

    /**
     * 年額計算に必要な月別ランク情報を、指定された資格の情報のリスト、賦課年度から編集し、返します。
     *
     * @param 資格の情報のリスト 資格の情報のリスト
     * @param 賦課年度 賦課年度
     * @return 月別市町村情報
     */
    public List<MonthShichoson> get月別ランク情報(List<HihokenshaDaicho> 資格の情報のリスト, FlexibleYear 賦課年度) {
        List<MonthShichoson> monthShichosonList = get月別市町村情報(資格の情報のリスト, 賦課年度);
        DbT2012HokenryoRankDac hokenryoRankDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
        for (MonthShichoson monthShichoson : monthShichosonList) {
            LasdecCode 市町村コード = monthShichoson.get市町村コード();
            if (市町村コード != null && !市町村コード.isEmpty()) {
                DbT2012HokenryoRankEntity entity = hokenryoRankDac.selectByKey(賦課年度, 市町村コード);
                if (entity != null) {
                    monthShichoson.setランク区分(entity.getRankKubun());
                }
            }
        }
        return monthShichosonList;
    }

    private List<MonthShichoson> toList(Map<Integer, MonthShichoson> monthShichosonSet) {
        List<MonthShichoson> monthShichosonList = new ArrayList<>();
        for (MonthShichoson monthShichoson : monthShichosonSet.values()) {
            monthShichosonList.add(monthShichoson);
        }
        return monthShichosonList;
    }

    private LasdecCode get市町村コード(HihokenshaDaicho hihokenshaDaicho) {
        LasdecCode 旧市町村コード = hihokenshaDaicho.get旧市町村コード();
        LasdecCode 広住特措置元市町村コード = hihokenshaDaicho.get広住特措置元市町村コード();
        if (旧市町村コード != null && !旧市町村コード.isEmpty()) {
            return 旧市町村コード;
        } else if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            return 広住特措置元市町村コード;
        } else {
            return hihokenshaDaicho.get市町村コード();
        }
    }

    private void setMonthShichosonMap(Map<Integer, MonthShichoson> monthShichosonSet, FlexibleDate 基準日, LasdecCode 市町村コード) {
        int month = 基準日.getMonthValue();
        int start;
        if (month < INDEX_4) {
            start = month + INDEX_9;
        } else {
            start = month - INDEX_3;
        }
        for (int i = start; i <= INDEX_12; i++) {
            MonthShichoson monthShichoson = monthShichosonSet.get(i);
            monthShichoson.set市町村コード(市町村コード);
            monthShichosonSet.put(i, monthShichoson);
        }
    }

    private void clearMonthShichosonMap(Map<Integer, MonthShichoson> monthShichosonSet, FlexibleDate 基準日) {
        int month = 基準日.getMonthValue();
        int start;
        if (month < INDEX_4) {
            start = month + INDEX_9;
        } else {
            start = month - INDEX_3;
        }
        for (int i = start; i <= INDEX_12; i++) {
            MonthShichoson monthShichoson = monthShichosonSet.get(i);
            monthShichoson.set市町村コード(LasdecCode.EMPTY);
            monthShichosonSet.put(i, monthShichoson);
        }
    }

    private Map<Integer, MonthShichoson> createMonthShichosonMap() {
        Map<Integer, MonthShichoson> monthShichosonSet = new HashMap<>();
        MonthShichoson monthShichoson4 = new MonthShichoson();
        monthShichoson4.set月(Tsuki._4月);
        monthShichoson4.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(1, monthShichoson4);
        MonthShichoson monthShichoson5 = new MonthShichoson();
        monthShichoson5.set月(Tsuki._5月);
        monthShichoson5.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_2, monthShichoson5);
        MonthShichoson monthShichoson6 = new MonthShichoson();
        monthShichoson6.set月(Tsuki._6月);
        monthShichoson6.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_3, monthShichoson6);
        MonthShichoson monthShichoson7 = new MonthShichoson();
        monthShichoson7.set月(Tsuki._7月);
        monthShichoson7.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_4, monthShichoson7);
        MonthShichoson monthShichoson8 = new MonthShichoson();
        monthShichoson8.set月(Tsuki._8月);
        monthShichoson8.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_5, monthShichoson8);
        MonthShichoson monthShichoson9 = new MonthShichoson();
        monthShichoson9.set月(Tsuki._9月);
        monthShichoson9.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_6, monthShichoson9);
        MonthShichoson monthShichoson10 = new MonthShichoson();
        monthShichoson10.set月(Tsuki._10月);
        monthShichoson10.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_7, monthShichoson10);
        MonthShichoson monthShichoson11 = new MonthShichoson();
        monthShichoson11.set月(Tsuki._11月);
        monthShichoson11.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_8, monthShichoson11);
        MonthShichoson monthShichoson12 = new MonthShichoson();
        monthShichoson12.set月(Tsuki._12月);
        monthShichoson12.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_9, monthShichoson12);
        MonthShichoson monthShichoson1 = new MonthShichoson();
        monthShichoson1.set月(Tsuki._1月);
        monthShichoson1.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_10, monthShichoson1);
        MonthShichoson monthShichoson2 = new MonthShichoson();
        monthShichoson2.set月(Tsuki._2月);
        monthShichoson2.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_11, monthShichoson2);
        MonthShichoson monthShichoson3 = new MonthShichoson();
        monthShichoson3.set月(Tsuki._3月);
        monthShichoson3.set市町村コード(LasdecCode.EMPTY);
        monthShichosonSet.put(INDEX_12, monthShichoson3);
        return monthShichosonSet;
    }

    private static class DateComparator implements Comparator<HihokenshaDaicho>, Serializable {

        private static final long serialVersionUID = -2242303980089636394L;

        /**
         * compare処理です。
         *
         * @param hihokenshaDaicho1 資格の情報1
         * @param hihokenshaDaicho2 資格の情報2
         * @return 結果
         */
        @Override
        public int compare(HihokenshaDaicho hihokenshaDaicho1, HihokenshaDaicho hihokenshaDaicho2) {
            FlexibleDate 異動日1 = hihokenshaDaicho1.get異動日();
            FlexibleDate 異動日2 = hihokenshaDaicho2.get異動日();
            if (異動日1.isBefore(異動日2)) {
                return -1;
            } else if (異動日2.isBefore(異動日1)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
