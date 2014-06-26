/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kaigoNinteiKekka.KaigoNinteiKekkaDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * 共有子Div、KaigoNinteiKekkaDivを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class KaigoNinteiKekka {

    //<editor-fold defaultstate="collapsed" desc="enum Mode">
    enum Mode {

        INPUT("0"), READ("09");
        private final RString theCode;

        private Mode(String code) {
            this.theCode = new RString(code);
        }

        public RString code() {
            return this.theCode;
        }

        public static Mode toValue(RString code) {
            for (Mode item : values()) {
                if (item.code().equals(code)) {
                    return item;
                }
            }
            return INPUT;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="enum NinteiKubun">
    enum NinteiKubun {

        認定("01"), 再調査("02"), 再審査("03"), 却下("09"), 区却("11");
        private final RString theCode;
        private final RString theName;

        private NinteiKubun(String code) {
            this.theCode = new RString(code);
            this.theName = new RString(name());
        }

        RString getCode() {
            return this.theCode;
        }

        RString getName() {
            return this.theName;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="enum TokuteiShippei">
    enum TokuteiShippei {

        EMPTY("00", ""),
        筋萎縮性側索硬化症("01", "筋萎縮性側索硬化症"),
        後縦靭帯骨化症("02", "後縦靭帯骨化症");
        private final RString theCode;
        private final RString theName;

        private TokuteiShippei(String code, String name) {
            this.theCode = new RString(code);
            this.theName = new RString(name);
        }

        RString getCode() {
            return this.theCode;
        }

        RString getName() {
            return this.theName;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="enum Yokaigodo">
    enum Yokaigodo {

        EMPTY("01", ""),
        要支援１("12", "要支援１"),
        要支援２("13", "要支援２"),
        要介護１("21", "要介護１"),
        要介護２("22", "要介護２"),
        要介護３("23", "要介護３"),
        要介護４("24", "要介護４"),
        要介護５("25", "要介護５"),
        非該当("31", "未該当");
        private final RString theCode;
        private final RString theName;

        private Yokaigodo(String code, String name) {
            this.theCode = new RString(code);
            this.theName = new RString(name);
        }

        RString getCode() {
            return this.theCode;
        }

        RString getName() {
            return this.theName;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="enum JotaiZo">
    enum JotaiZo {

        EMPTY("00", ""),
        認知機能の低下等("01", "01:認知機能の低下等"),
        不安定な状態("02", "02:不安定な状態");
        private final RString theCode;
        private final RString theName;

        private JotaiZo(String code, String name) {
            this.theCode = new RString(code);
            this.theName = new RString(name);
        }

        RString getCode() {
            return this.theCode;
        }

        RString getName() {
            return this.theName;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="enum YukoKIkanTsukisu">
    enum YukoKikanTsukisu {

        ZERO("00", 0),
        TwoYears("24", 24),
        AYear("12", 12),
        SixMonths("06", 6),
        AMonth("01", 1);
        private final int numOfMonth;
        private final RString theCode;

        YukoKikanTsukisu(String code, int numOfMonth) {
            this.theCode = new RString(code);
            this.numOfMonth = numOfMonth;
        }

        RString getCode() {
            return this.theCode;
        }

        RString valueAsRString() {
            return new RString(String.valueOf(numOfMonth));
        }

        int value() {
            return this.numOfMonth;
        }

    }
//</editor-fold>

    /**
     * モードを設定します。
     *
     * @param div
     * @param mode
     */
    static void setModeWithInit(KaigoNinteiKekkaDiv div, Mode mode) {
        setValues(div, new Values());
        div.getTxtShinsaJun().setDisplayNone(true);
        switch (mode) {
            case INPUT:
                _setMode(div, false);
                break;
            case READ:
                _setMode(div, true);
                break;
            default:
                break;
        }
    }

    private static void _setMode(KaigoNinteiKekkaDiv div, boolean isReadOnly) {
        div.setReadOnly(isReadOnly);
        div.getDdlNinteiKubun().setRequired(!isReadOnly);
        div.getTxtNinteibi().setRequired(!isReadOnly);
        div.getDdlNijiHanteiKekka().setRequired(!isReadOnly);
    }

    /**
     *
     * @param div KaigoNinteiKekkaDiv
     * @param disabled disabled
     */
    static void selectNoneSettingDisabled_TokuteiShippei(KaigoNinteiKekkaDiv div, boolean disabled) {
        DropDownList ddl = div.getDdlTokuteiShippei();
        ddl.setDisabled(disabled);
        ddl.setSelectedItem(TokuteiShippei.EMPTY.getCode());
    }

    /**
     *
     * @param div KaigoNinteiKekkaDiv
     * @param disabled disabled
     */
    static void selectNoneSettingDisabled_JotaiZo(KaigoNinteiKekkaDiv div, boolean disabled) {
        DropDownList ddl = div.getDdlJotaiZo();
        ddl.setDisabled(disabled);
        ddl.setSelectedItem(JotaiZo.EMPTY.getCode());
    }

    /**
     *
     * @param div
     * @param values
     */
    static void setValues(KaigoNinteiKekkaDiv div, Values values) {
        div.getTxtIchijiHanteiKekka().setValue(values.getIchijiHanteiKekka().getName());
        div.getTxtNinteiYukoKikanStart().setValue(values.getYukoKikanFrom());
        div.getTxtNinteiYukoKikanEnd().setValue(
                calcYukoKikanTo(values.getYukoKikanFrom(), values.getTsukisu()));
        div.getTxtNinteibi().setValue(values.getNinteiDate());
        div.getTxtShinsaJun().setValue(new RString(String.valueOf(values.getShinsaJun())));
        div.getTxtShinsakaiIken().setValue(values.getShisakaiIken());
        div.getTxtShinsakaiMemo().setValue(values.getShisakaiMemo());
        div.getTxtShinseiKubunHorei().setValue(values.getShinseiKubunHorei());
        div.getTxtShinseiKubunShinsei().setValue(values.getShiseiKubunShinseiji());
        div.getTxtShinseibi().setValue(values.getShinseiDate());
        div.getDdlJotaiZo().setSelectedItem(values.getJotaizo().getCode());
        div.getDdlNijiHanteiKekka().setSelectedItem(values.getNijiHanteiKekka().getCode());
        div.getDdlNinteiKubun().setSelectedItem(values.getNijiHanteiKekka().getCode());
        div.getDdlNinteiYukoTsukisu().setSelectedItem(values.getTsukisu().getCode());
        div.getDdlTokuteiShippei().setSelectedItem(values.getTokuteiShippei().getCode());
    }

    /**
     *
     * @param yukoKikanFrom
     * @param tsukisu
     * @return
     */
    static final FlexibleDate calcYukoKikanTo(FlexibleDate yukoKikanFrom, YukoKikanTsukisu tsukisu) {
        if (!yukoKikanFrom.isValid()) {
            return FlexibleDate.EMPTY;
        }
        FlexibleDate yukoKikanTo;
        if (yukoKikanFrom.getDayValue() == 1) {
            yukoKikanTo = yukoKikanFrom.plusMonth(tsukisu.value() - 1);
        } else {
            yukoKikanTo = yukoKikanFrom.plusMonth(tsukisu.value());
        }
        return new FlexibleDate(yukoKikanTo.getYearMonth().toDateString() + String.valueOf(yukoKikanTo.getLastDay()));
    }

    //<editor-fold defaultstate="collapsed" desc="static class Values">
    static class Values {

        private FlexibleDate shinseiDate = FlexibleDate.EMPTY;
        private RString shiseiKubunShinseiji = RString.EMPTY;
        private RString shinseiKubunHorei = RString.EMPTY;
        private int shinsaJun = 0;
        private NinteiKubun ninteiKubun = NinteiKubun.認定;
        private Yokaigodo ichijiHanteiKekka = Yokaigodo.EMPTY;
        private TokuteiShippei tokuteiShippei = TokuteiShippei.EMPTY;
        private FlexibleDate ninteiDate = FlexibleDate.EMPTY;
        private Yokaigodo nijiHanteiKekka = Yokaigodo.EMPTY;
        private JotaiZo jotaizo = JotaiZo.EMPTY;
        private FlexibleDate yukoKikanFrom = FlexibleDate.EMPTY;
        private YukoKikanTsukisu tsukisu = YukoKikanTsukisu.ZERO;
        private RString shisakaiIken = RString.EMPTY;
        private RString shisakaiMemo = RString.EMPTY;

        public Values() {

        }

        /**
         * @return the shinseiDate
         */
        public FlexibleDate getShinseiDate() {
            return shinseiDate;
        }

        /**
         * @return the shiseiKubunShinseiji
         */
        public RString getShiseiKubunShinseiji() {
            return shiseiKubunShinseiji;
        }

        /**
         * @return the shinseiKubunHorei
         */
        public RString getShinseiKubunHorei() {
            return shinseiKubunHorei;
        }

        /**
         * @return the shinsaJun
         */
        public int getShinsaJun() {
            return shinsaJun;
        }

        /**
         * @return the ninteiKubun
         */
        public NinteiKubun getNinteiKubun() {
            return ninteiKubun;
        }

        /**
         * @return the ichijiHanteiKekka
         */
        public Yokaigodo getIchijiHanteiKekka() {
            return ichijiHanteiKekka;
        }

        /**
         * @return the tokuteiShippei
         */
        public TokuteiShippei getTokuteiShippei() {
            return tokuteiShippei;
        }

        /**
         * @return the ninteiDate
         */
        public FlexibleDate getNinteiDate() {
            return ninteiDate;
        }

        /**
         * @return the nijiHanteiKekka
         */
        public Yokaigodo getNijiHanteiKekka() {
            return nijiHanteiKekka;
        }

        /**
         * @return the jotaizo
         */
        public JotaiZo getJotaizo() {
            return jotaizo;
        }

        /**
         * @return the yukoKikanFrom
         */
        public FlexibleDate getYukoKikanFrom() {
            return yukoKikanFrom;
        }

        /**
         * @return the tsukisu
         */
        public YukoKikanTsukisu getTsukisu() {
            return tsukisu;
        }

        /**
         * @return the shisakaiIken
         */
        public RString getShisakaiIken() {
            return shisakaiIken;
        }

        /**
         * @return the shisakaiMemo
         */
        public RString getShisakaiMemo() {
            return shisakaiMemo;
        }

        /**
         * @param shinseiDate the shinseiDate to set
         */
        public void set申請日(FlexibleDate shinseiDate) {
            this.shinseiDate = shinseiDate;
        }

        /**
         * @param shiseiKubunShinseiji the shiseiKubunShinseiji to set
         */
        public void set申請区分_申請時(RString shiseiKubunShinseiji) {
            this.shiseiKubunShinseiji = shiseiKubunShinseiji;
        }

        /**
         * @param shinseiKubunHorei the shinseiKubunHorei to set
         */
        public void setShinseiKubunHorei(RString shinseiKubunHorei) {
            this.shinseiKubunHorei = shinseiKubunHorei;
        }

        /**
         * @param shinsaJun the shinsaJun to set
         */
        public void setShinsaJun(int shinsaJun) {
            this.shinsaJun = shinsaJun;
        }

        /**
         * @param ninteiKubun the ninteiKubun to set
         */
        public void set認定区分(NinteiKubun ninteiKubun) {
            this.ninteiKubun = ninteiKubun;
        }

        /**
         * @param ichijiHanteiKekka the ichijiHanteiKekka to set
         */
        public void set一次判定結果(Yokaigodo ichijiHanteiKekka) {
            this.ichijiHanteiKekka = ichijiHanteiKekka;
        }

        /**
         * @param tokuteiShippei the tokuteiShippei to set
         */
        public void setTokuteiShippei(TokuteiShippei tokuteiShippei) {
            this.tokuteiShippei = tokuteiShippei;
        }

        /**
         * @param ninteiDate the ninteiDate to set
         */
        public void set認定日(FlexibleDate ninteiDate) {
            this.ninteiDate = ninteiDate;
        }

        /**
         * @param nijiHanteiKekka the nijiHanteiKekka to set
         */
        public void set二次判定結果(Yokaigodo nijiHanteiKekka) {
            this.nijiHanteiKekka = nijiHanteiKekka;
        }

        /**
         * @param jotaizo the jotaizo to set
         */
        public void set状態像(JotaiZo jotaizo) {
            this.jotaizo = jotaizo;
        }

        /**
         * @param yukoKikanFrom the yukoKikanFrom to set
         */
        public void set有効期間開始日(FlexibleDate yukoKikanFrom) {
            this.yukoKikanFrom = yukoKikanFrom;
        }

        /**
         * @param tsukisu the tsukisu to set
         */
        public void set有効期間月数(YukoKikanTsukisu tsukisu) {
            this.tsukisu = tsukisu;
        }

        /**
         * @param shisakaiIken the shisakaiIken to set
         */
        public void setShisakaiIken(RString shisakaiIken) {
            this.shisakaiIken = shisakaiIken;
        }

        /**
         * @param shisakaiMemo the shisakaiMemo to set
         */
        public void setShisakaiMemo(RString shisakaiMemo) {
            this.shisakaiMemo = shisakaiMemo;
        }

    }
//</editor-fold>

}
