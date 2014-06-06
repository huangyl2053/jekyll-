/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.IkenshoIraiIkkatuHakkoTabDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraiIkkatuHakkoTabDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoPublishingOptionsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoRelatedDatesDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraishoTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaRelatedReportTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.SerachCriteriaForNinteichosaIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoPublishingOptionsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoRelatedDatesDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoIraishoTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.ShujiiIkenshoRelatedReportTypeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.dgNinteichosaIraishoTargetPersons_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.dgShujiiIkenshoIraishoTargetPersons_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * IraishoIkkatsuHakkoDivを操作するクラスです。
 *
 * @author N3327 三浦 凌
 */
public class IraishoIkkatsuHakko {

    /**
     * ロード時の処理です。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onLoad(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        NinteichosaIraishoTargetPersons.onLoad(_ninteichosaIraishoTargetPersons(div));
        ShujiiIkenshoIraishoTargetPersons.onLoad(_shujiiIkenshoIraishoTargetPersons(div));

        response.data = div;
        return response;
    }

    /**
     * btnToSearchOfChosaをclickしたときの処理です。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnToSearchOfChosa(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        NinteichosaIraishoTargetPersons.onClick_btnToSearchOfChosa(_ninteichosaIraishoTargetPersons(div));

        response.data = div;
        return response;
    }

    /**
     * btnToSearchOfIkenshoをclickしたときの処理です。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnToSearchOfIkensho(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        ShujiiIkenshoIraishoTargetPersons.onClick_btnToSearchOfIkensh(_shujiiIkenshoIraishoTargetPersons(div));

        response.data = div;
        return response;
    }

    /**
     * btnToClearCriteriaOfChosaをclickしたときの処理です。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnToClearCriteriaOfChosa(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        NinteichosaIraishoTargetPersons.SearchCriteriaForNinteichosa.clear(
                NinteichosaIraishoTargetPersons._searchCriteria(_ninteichosaIraishoTargetPersons(div)));

        response.data = div;
        return response;
    }

    /**
     * btnToClearCriteriaOfIkenshoをclickしたときの処理です。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnToClearCriteriaOfIkensho(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        ShujiiIkenshoIraishoTargetPersons.SearchCriteriaForShujiiIkensho.clear(
                ShujiiIkenshoIraishoTargetPersons._searchCriteria(_shujiiIkenshoIraishoTargetPersons(div)));

        response.data = div;
        return response;
    }

    /**
     * 入力値をクリアします。
     *
     * @param div IraishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> clear(IraishoIkkatsuHakkoDiv div) {
        ResponseData<IraishoIkkatsuHakkoDiv> response = new ResponseData<>();

        _clearNinteichosaIraiIkkatuHakkoTab(div.getTabIraishoIkkatsuHakko().getNinteichosaIraiIkkatuHakkoTab());
        _clearIkenshoIraiIkkatuHakkoTab(div.getTabIraishoIkkatsuHakko().getIkenshoIraiIkkatuHakkoTab());

        response.data = div;
        return response;
    }

    /**
     * 依頼書発行済み区分
     */
    private static enum IraishoHakkoType {

        済(1),
        未済(0);
        private final RString theKey;
        private final RString theValue;

        private IraishoHakkoType(int key) {
            this.theKey = new RString(String.valueOf(key));
            this.theValue = new RString(name());
        }

        private RString key() {
            return this.theKey;
        }

        private RString value() {
            return this.theValue;
        }

        private static List<KeyValueDataSource> getKeyValueDateSource() {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (IraishoHakkoType element : values()) {
                dataSource.add(new KeyValueDataSource(element.key(), element.value()));
            }
            return dataSource;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="NinteichosaIraishoPublishingOptions">
    /**
     * NinteichosaIraishoPublishingOptionsDivに対する操作です。
     */
    private static final class NinteichosaIraishoPublishingOptions {

        private NinteichosaIraishoPublishingOptions() {
        }

        /**
         * 入力値をクリアします。
         *
         * @param div NinteichosaIraishoPublishingOptionsDiv
         */
        static void clear(NinteichosaIraishoPublishingOptionsDiv div) {
            NinteichosaIraishoType.clear(div.getNinteichosaIraishoType());
            NinteichosaRelatedReportType.clear(div.getNinteichosaRelatedReportType());
        }

        /**
         * NinteichosaIraishoTypeDivを操作します。
         */
        private static final class NinteichosaIraishoType {

            private NinteichosaIraishoType() {
            }

            /**
             * 入力値をクリアします。
             *
             * @param div NinteichosaIraishoTypeDiv
             */
            static void clear(NinteichosaIraishoTypeDiv div) {
                div.getRadNinteichosaIraishoType().setSelectedItem(RString.EMPTY);
            }
        }

        /**
         * NinteichosaRelatedReportTypeDivを操作します。
         */
        private static final class NinteichosaRelatedReportType {

            private NinteichosaRelatedReportType() {
            }

            /**
             * 入力値をクリアします。
             *
             * @param div NinteichosaRelatedReportTypeDiv
             */
            static void clear(NinteichosaRelatedReportTypeDiv div) {
                div.getChkNinteichosaRelatedReportType().setSelectedItems(Collections.EMPTY_LIST);
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="NinteichosaIraishoTargetPersons">
    /**
     * NinteichosaIraishoTargetPersonsDivに対する操作です。
     */
    private static final class NinteichosaIraishoTargetPersons {

        private NinteichosaIraishoTargetPersons() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div NinteichosaIraishoTargetPersonsDiv
         */
        static void onLoad(NinteichosaIraishoTargetPersonsDiv div) {
            _searchCriteria(div).getChkNinteichosaIraishoHakkoExistence()
                    .setDataSource(IraishoHakkoType.getKeyValueDateSource());
        }

        /**
         * btnToSearchOfChosaをclickしたときの処理です。
         *
         * @param div NinteichosaIraishoTargetPersonsDiv
         */
        static void onClick_btnToSearchOfChosa(NinteichosaIraishoTargetPersonsDiv div) {
            div.getDgNinteichosaIraishoTargetPersons()
                    .setDataSource(_extractDataSourceFromSearhcCriteria(div));
        }

        /**
         * 入力値をクリアします。
         *
         * @param div NinteichosaIraishoTargetPersonsDiv
         */
        static void clear(NinteichosaIraishoTargetPersonsDiv div) {
            SearchCriteriaForNinteichosa.clear(_searchCriteria(div));
            div.getDgNinteichosaIraishoTargetPersons().setDataSource(Collections.EMPTY_LIST);
        }

        private static List<dgNinteichosaIraishoTargetPersons_Row>
                _extractDataSourceFromSearhcCriteria(NinteichosaIraishoTargetPersonsDiv div) {
            List<dgNinteichosaIraishoTargetPersons_Row> list = new ArrayList<>();
            for (dgNinteichosaIraishoTargetPersons_Row target : new DemoData().get調査依頼対象者()) {
                if (SearchCriteriaForNinteichosa._fulfilsConditon(_searchCriteria(div), target)) {
                    list.add(target);
                }
            }
            return list;
        }

        private static SerachCriteriaForNinteichosaIraishoTargetPersonsDiv
                _searchCriteria(NinteichosaIraishoTargetPersonsDiv div) {
            return div.getSerachCriteriaForNinteichosaIraishoTargetPersons();
        }

        /**
         * SerachCriteriaForNinteichosaIraishoTargetPersonsDivに対する操作です。
         */
        private static class SearchCriteriaForNinteichosa {

            /**
             * 入力値をクリアします。
             *
             * @param div SerachCriteriaForNinteichosaIraishoTargetPersonsDiv
             */
            static void clear(SerachCriteriaForNinteichosaIraishoTargetPersonsDiv div) {
                div.getChkNinteichosaIraishoHakkoExistence().setSelectedItems(Collections.EMPTY_LIST);
                div.getTxtChosaIraiDateRange().setFromValue(null);
                div.getTxtChosaIraiDateRange().setToValue(null);
                div.getTxtShinseiDateRangeOfChosa().setFromValue(null);
                div.getTxtShinseiDateRangeOfChosa().setToValue(null);
            }

            private static boolean _fulfilsConditon(
                    SerachCriteriaForNinteichosaIraishoTargetPersonsDiv div,
                    dgNinteichosaIraishoTargetPersons_Row target) {
                return _fulfilsHakkoDateCondition(div, target.getIraishoHakkoDate().getValue())
                        && _between_chosaIraiDate(div, target.getChosaIraiDate().getValue())
                        && _between_shinsaiDate(div, target.getShinseiDate().getValue());
            }

            private static boolean _fulfilsHakkoDateCondition(
                    SerachCriteriaForNinteichosaIraishoTargetPersonsDiv div, FlexibleDate iraishoHakkoDate) {
                CheckBoxList chk = div.getChkNinteichosaIraishoHakkoExistence();
                if (chk.getSelectedItems().isEmpty()) {
                    return true;
                } else {
                    for (KeyValueDataSource dataSource : chk.getSelectedItems()) {
                        if (dataSource.getKey().equals(IraishoHakkoType.済.key())) {
                            return !_isEmpty_FlexibleDate(iraishoHakkoDate);
                        } else {
                            return _isEmpty_FlexibleDate(iraishoHakkoDate);
                        }
                    }
                    return true;
                }
            }

            private static boolean _between_chosaIraiDate(
                    SerachCriteriaForNinteichosaIraishoTargetPersonsDiv div, FlexibleDate date) {
                FlexibleDate from = _toFlexibleDate_From(div.getTxtChosaIraiDateRange());
                FlexibleDate to = _toFlexibleDate_To(div.getTxtChosaIraiDateRange());
                return new Range<>(from, to).between(date);
            }

            private static boolean _between_shinsaiDate(
                    SerachCriteriaForNinteichosaIraishoTargetPersonsDiv div, FlexibleDate date) {
                FlexibleDate from = _toFlexibleDate_From(div.getTxtShinseiDateRangeOfChosa());
                FlexibleDate to = _toFlexibleDate_To(div.getTxtShinseiDateRangeOfChosa());
                return new Range<>(from, to).between(date);
            }

        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="NinteichosaIraishoRelatedDates">
    /**
     * NinteichosaIraishoRelatedDatesDivに対する操作です。
     */
    private static final class NinteichosaIraishoRelatedDates {

        private NinteichosaIraishoRelatedDates() {
        }

        /**
         * 入力値をクリアします。
         *
         * @param div NinteichosaIraishoRelatedDatesDiv
         */
        static void clear(NinteichosaIraishoRelatedDatesDiv div) {
            div.getTxtHakkoDateOfChosa().clearValue();
            div.getTxtKigenDateOfChosa().clearValue();
            div.getTxtShoriDateOfChosa().clearValue();
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ShujiiIkenshoIraishoPublishingOptions">
    /**
     * ShujiiIkenshoIraishoPublishingOptionsDivに対する操作です。
     */
    private static final class ShujiiIkenshoIraishoPublishingOptions {

        private ShujiiIkenshoIraishoPublishingOptions() {
        }

        /**
         * 入力値をクリアします。
         *
         * @param div ShujiiIkenshoIraishoPublishingOptionsDiv
         */
        static void clear(ShujiiIkenshoIraishoPublishingOptionsDiv div) {
            ShujiiIkenshoIraishoType.clear(div.getShujiiIkenshoIraishoType());
            ShujiiIkenshoRelatedReportType.clear(div.getShujiiIkenshoRelatedReportType());
        }

        /**
         * ShujiiIkenshoIraishoTypeDivに対する操作です。
         */
        private static final class ShujiiIkenshoIraishoType {

            private ShujiiIkenshoIraishoType() {
            }

            /**
             * 入力値をクリアします。
             *
             * @param div ShujiiIkenshoIraishoTypeDiv
             */
            static void clear(ShujiiIkenshoIraishoTypeDiv div) {
                div.getRadShujiiIkenshoIraishoType().setSelectedItem(RString.EMPTY);
            }
        }

        /**
         * ShujiiIkenshoRelatedReportType
         */
        private static final class ShujiiIkenshoRelatedReportType {

            private ShujiiIkenshoRelatedReportType() {
            }

            /**
             * 入力値をクリアします。
             *
             * @param div ShujiiIkenshoRelatedReportTypeDiv
             */
            static void clear(ShujiiIkenshoRelatedReportTypeDiv div) {
                div.getChkShujiiIkenshoRelatedReportType().setSelectedItems(Collections.EMPTY_LIST);
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ShujiiIkenshoIraishoTargetPersonsDiv">
    /**
     * ShujiiIkenshoIraishoTargetPersonsDivに対する操作です。
     */
    private static final class ShujiiIkenshoIraishoTargetPersons {

        private ShujiiIkenshoIraishoTargetPersons() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div ShujiiIkenshoIraishoTargetPersonsDiv d
         */
        static void onLoad(ShujiiIkenshoIraishoTargetPersonsDiv div) {
            _searchCriteria(div).getChkIkenshoIraishoHakkoExistence()
                    .setDataSource(IraishoHakkoType.getKeyValueDateSource());
        }

        /**
         * btnToSearchOfChosaをclickしたときの処理です。
         *
         * @param div ShujiiIkenshoIraishoTargetPersonsDiv d
         */
        static void onClick_btnToSearchOfIkensh(ShujiiIkenshoIraishoTargetPersonsDiv div) {
            div.getDgShujiiIkenshoIraishoTargetPersons()
                    .setDataSource(_extractDataSourceFromSearhcCriteria(div));
        }

        /**
         * 入力値をクリアします。
         *
         * @param div ShujiiIkenshoIraishoTargetPersonsDiv
         */
        static void clear(ShujiiIkenshoIraishoTargetPersonsDiv div) {
            div.getDgShujiiIkenshoIraishoTargetPersons().setDataSource(Collections.EMPTY_LIST);
            SearchCriteriaForShujiiIkensho.clear(_searchCriteria(div));
        }

        private static List<dgShujiiIkenshoIraishoTargetPersons_Row>
                _extractDataSourceFromSearhcCriteria(ShujiiIkenshoIraishoTargetPersonsDiv div) {
            List<dgShujiiIkenshoIraishoTargetPersons_Row> list = new ArrayList<>();
            for (dgShujiiIkenshoIraishoTargetPersons_Row target : new DemoData().get作成依頼対象者()) {
                if (SearchCriteriaForShujiiIkensho._fulfilsConditon(_searchCriteria(div), target)) {
                    list.add(target);
                }
            }
            return list;
        }

        private static SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv
                _searchCriteria(ShujiiIkenshoIraishoTargetPersonsDiv div) {
            return div.getSerachCriteriaForShujiiIkenshoIraishoTargetPersons();
        }

        /**
         * SerachCriteriaForNinteichosaIraishoTargetPersonsDivに対する操作です。
         */
        private static class SearchCriteriaForShujiiIkensho {

            /**
             * 入力値をクリアします。
             *
             * @param div SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv
             */
            static void clear(SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv div) {
                div.getChkIkenshoIraishoHakkoExistence().setSelectedItems(Collections.EMPTY_LIST);
                div.getTxtSakuseiIraiDateRange().setFromValue(null);
                div.getTxtSakuseiIraiDateRange().setToValue(null);
                div.getTxtShinseiDateRangeOfIkensho().setFromValue(null);
                div.getTxtShinseiDateRangeOfIkensho().setToValue(null);
            }

            private static boolean _fulfilsConditon(
                    SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv div,
                    dgShujiiIkenshoIraishoTargetPersons_Row target) {
                return _fulfilsHakkoDateCondition(div, target.getIraishoHakkoDate().getValue())
                        && _between_chosaIraiDate(div, target.getSakuseiIraiDate().getValue())
                        && _between_shinsaiDate(div, target.getShinseiDate().getValue());
            }

            private static boolean _fulfilsHakkoDateCondition(
                    SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv div, FlexibleDate iraishoHakkoDate) {
                CheckBoxList chk = div.getChkIkenshoIraishoHakkoExistence();
                if (chk.getSelectedItems().isEmpty()) {
                    return true;
                } else {
                    for (KeyValueDataSource dataSource : chk.getSelectedItems()) {
                        if (dataSource.getKey().equals(IraishoHakkoType.済.key())) {
                            return !_isEmpty_FlexibleDate(iraishoHakkoDate);
                        } else {
                            return _isEmpty_FlexibleDate(iraishoHakkoDate);
                        }
                    }
                    return true;
                }
            }

            private static boolean _between_chosaIraiDate(
                    SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv div, FlexibleDate date) {
                FlexibleDate from = _toFlexibleDate_From(div.getTxtSakuseiIraiDateRange());
                FlexibleDate to = _toFlexibleDate_To(div.getTxtSakuseiIraiDateRange());
                return new Range<>(from, to).between(date);
            }

            private static boolean _between_shinsaiDate(
                    SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv div, FlexibleDate date) {
                FlexibleDate from = _toFlexibleDate_From(div.getTxtShinseiDateRangeOfIkensho());
                FlexibleDate to = _toFlexibleDate_To(div.getTxtShinseiDateRangeOfIkensho());
                return new Range<>(from, to).between(date);
            }

        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ShujiiIkenshoIraishoRelatedDates">
    /**
     * ShujiiIkenshoIraishoRelatedDatesDivに対する操作です。
     */
    private static final class ShujiiIkenshoIraishoRelatedDates {

        private ShujiiIkenshoIraishoRelatedDates() {
        }

        /**
         * 入力値をクリアします。
         *
         * @param div ShujiiIkenshoIraishoRelatedDatesDiv
         */
        static final void clear(ShujiiIkenshoIraishoRelatedDatesDiv div) {
            div.getTxtHakkoDateOfIkensho().clearValue();
            div.getTxtKigenDateOfIkensho().clearValue();
            div.getTxtShoriDateOfIkensho().clearValue();
        }
    }
//</editor-fold>

    private void _clearNinteichosaIraiIkkatuHakkoTab(NinteichosaIraiIkkatuHakkoTabDiv div) {
        NinteichosaIraishoPublishingOptions.clear(div.getNinteichosaIraishoPublishingOptions());
        NinteichosaIraishoTargetPersons.clear(div.getNinteichosaIraishoTargetPersons());
        NinteichosaIraishoRelatedDates.clear(div.getNinteichosaIraishoRelatedDates());
    }

    private void _clearIkenshoIraiIkkatuHakkoTab(IkenshoIraiIkkatuHakkoTabDiv div) {
        ShujiiIkenshoIraishoPublishingOptions.clear(div.getShujiiIkenshoIraishoPublishingOptions());
        ShujiiIkenshoIraishoTargetPersons.clear(div.getShujiiIkenshoIraishoTargetPersons());
        ShujiiIkenshoIraishoRelatedDates.clear(div.getShujiiIkenshoIraishoRelatedDates());
    }

    private NinteichosaIraishoTargetPersonsDiv _ninteichosaIraishoTargetPersons(IraishoIkkatsuHakkoDiv div) {
        return div.getTabIraishoIkkatsuHakko()
                .getNinteichosaIraiIkkatuHakkoTab()
                .getNinteichosaIraishoTargetPersons();
    }

    private ShujiiIkenshoIraishoTargetPersonsDiv _shujiiIkenshoIraishoTargetPersons(IraishoIkkatsuHakkoDiv div) {
        return div.getTabIraishoIkkatsuHakko()
                .getIkenshoIraiIkkatuHakkoTab()
                .getShujiiIkenshoIraishoTargetPersons();
    }

    private static FlexibleDate _toFlexibleDate_From(TextBoxDateRange txtBoxRange) {
        RDate date = txtBoxRange.getFromValue();
        if (date == null) {
            return FlexibleDate.MIN;
        } else {
            return _toFlexibleDate(date);
        }
    }

    private static FlexibleDate _toFlexibleDate_To(TextBoxDateRange txtBoxRange) {
        RDate date = txtBoxRange.getToValue();
        if (date == null) {
            return FlexibleDate.MAX;
        } else {
            return _toFlexibleDate(date);
        }
    }

    private static FlexibleDate _toFlexibleDate(RDate date) {
        return new FlexibleDate(date.toDateString());
    }

    private static boolean _isEmpty_FlexibleDate(FlexibleDate date) {
        if (date == null) {
            return true;
        }
        return FlexibleDate.EMPTY.equals(date);
    }

    //<editor-fold defaultstate="collapsed" desc="DemoData">
    /**
     * デモ用のデータです。
     */
    private static class DemoData {

        /**
         * デモ用データの種類の列挙型です。
         */
        private enum DemoDataType {

            調査依頼書対象(new RString("IraishoIkkatsuHakkoTargets.yml")),
            作成依頼書対象(new RString("IraishoIkkatsuHakkoTargets.yml"));
            private final RString thePath;

            private DemoDataType(RString fileName) {
                this.thePath = new RString("dbe2050001/" + fileName);
            }

            public RString path() {
                return thePath;
            }
        }

        /**
         * 調査依頼対象者
         */
        private final List<dgNinteichosaIraishoTargetPersons_Row> choraIraiTargets;
        /**
         * 作成依頼対象者
         */
        private final List<dgShujiiIkenshoIraishoTargetPersons_Row> sakuseiIraiTargets;

        DemoData() {
            choraIraiTargets = _createList(DemoDataType.調査依頼書対象);
            sakuseiIraiTargets = _createList(DemoDataType.作成依頼書対象);
        }

        /**
         * 調査依頼対象者を返します。
         *
         * @return 調査依頼対象者
         */
        List<dgNinteichosaIraishoTargetPersons_Row> get調査依頼対象者() {
            return this.choraIraiTargets;
        }

        /**
         * 作成依頼対象者を返します。
         *
         * @return 作成依頼対象者
         */
        List<dgShujiiIkenshoIraishoTargetPersons_Row> get作成依頼対象者() {
            return this.sakuseiIraiTargets;
        }

        private <T> List<T> _createList(DemoDataType type) {
            List<HashMap> dataFromYaml = YamlLoader.FOR_DBE.loadAsList(type.path());
            return YamlUtil.convertList(dataFromYaml, _createConverter(type));
        }

        private Converter.IConverter _createConverter(DemoDataType type) {
            switch (type) {
                case 調査依頼書対象:
                    return new Converter.IConverter<dgNinteichosaIraishoTargetPersons_Row>() {

                        @Override
                        public dgNinteichosaIraishoTargetPersons_Row exec(Map map) {
                            return _toDgNinteichosaIraishoTargetPersons_Row(map);
                        }
                    };
                case 作成依頼書対象:
                    return new Converter.IConverter<dgShujiiIkenshoIraishoTargetPersons_Row>() {

                        @Override
                        public dgShujiiIkenshoIraishoTargetPersons_Row exec(Map map) {
                            return _toDgShujiiIkenshoIraishoTargetPersons_Row(map);
                        }
                    };
                default:
                    return Converter.NO_CHANGE;
            }
        }

        private dgNinteichosaIraishoTargetPersons_Row _toDgNinteichosaIraishoTargetPersons_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            RString shimei = cg.getAsRString("氏名");
            RString kanaShimei = cg.getAsRString("カナ氏名");
            return new dgNinteichosaIraishoTargetPersons_Row(
                    cg.getAsRString("調査委託先番号"),
                    cg.getAsRString("調査委託先名称"),
                    cg.getAsRString("調査員番号"),
                    cg.getAsRString("調査員名称"),
                    cg.getAsRString("被保番号"),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    cg.getAsTextBoxFlexibleDate("申請日"),
                    cg.getAsRString("申請区分"),
                    cg.getAsTextBoxFlexibleDate("調査依頼日"),
                    cg.getAsTextBoxFlexibleDate("調査依頼書発行日")
            );
        }

        private dgShujiiIkenshoIraishoTargetPersons_Row _toDgShujiiIkenshoIraishoTargetPersons_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            RString shimei = cg.getAsRString("氏名");
            RString kanaShimei = cg.getAsRString("カナ氏名");
            return new dgShujiiIkenshoIraishoTargetPersons_Row(
                    cg.getAsRString("医療機関番号"),
                    cg.getAsRString("医療機関名称"),
                    cg.getAsRString("主治医番号"),
                    cg.getAsRString("主治医名称"),
                    cg.getAsRString("被保番号"),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    cg.getAsTextBoxFlexibleDate("申請日"),
                    cg.getAsRString("申請区分"),
                    cg.getAsTextBoxFlexibleDate("作成依頼日"),
                    cg.getAsTextBoxFlexibleDate("作成依頼書発行日")
            );
        }
    }
    //</editor-fold>
}
