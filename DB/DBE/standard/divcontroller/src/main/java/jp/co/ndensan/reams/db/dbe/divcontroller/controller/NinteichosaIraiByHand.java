/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaIraiListForByHandCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ChosaItakusakiAndChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ChosairaiBindByHandMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.NinteichosaIraiByHandDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.RequestContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteichosaIraiListForByHand_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShozokuChosainList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;

/**
 * NinteichosaIraiByHandDivを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaIraiByHand {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaIraiByHandDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiByHandDiv> onLoad(NinteichosaIraiByHandDiv div) {
        ResponseData<NinteichosaIraiByHandDiv> response = new ResponseData<>();

        ChosairaiBindByHandMain.onLoad(div.getChosairaiBindByHandMain());
        ChosaItakusakiAndChosainList.onLoad(div.getChosaItakusakiAndChosainList());

        response.data = div;
        return response;
    }

    private static final class ChosaItakusakiAndChosainList {

        private static void onLoad(ChosaItakusakiAndChosainListDiv div) {
            init_dgChosaItakusakiList(div);
            init_comChosainListAll(div);
        }

        private static void init_dgChosaItakusakiList(ChosaItakusakiAndChosainListDiv div) {
            div.getDgChosaItakusakiList().setDataSource(
                    new DemoData().get調査委託先一覧());
        }

        private static void init_comChosainListAll(ChosaItakusakiAndChosainListDiv div) {
            div.getShozokuChosainList().getComChosainListAll().getDgShozokuChosainList().setDataSource(
                    new DemoData().get所属調査員一覧());
        }

    }

    //<editor-fold defaultstate="collapsed" desc="ChosairaiBindByHandMain">
    /**
     * ChosairaiBindByHandMainDivを操作するためのクラスです。
     */
    private static final class ChosairaiBindByHandMain {

        private static void onLoad(ChosairaiBindByHandMainDiv div) {
            DataGrids.onLoad(div);
            RequestContents.onLoad(div.getRequestContents());
        }

        /**
         * RequestContentsDivを操作するためのクラスです。
         */
        private static final class RequestContents {

            private static final int NUM_OF_A_WEEK = 7;

            private static void onLoad(RequestContentsDiv div) {
                div.getDdlIraiKubun().setSelectedItem(new RString("1"));
                FlexibleDate nowDate = FlexibleDate.getNowDate();
                div.getTxtChosaIraiDate().setValue(nowDate);
                div.getTxtChosaKigenDate().setValue(nowDate.plusDay(NUM_OF_A_WEEK));
            }
        }

        /**
         * ChosairaiBindByHandMainDivが保持するDataGridを操作するためのクラスです。
         */
        private static final class DataGrids {

            private static void onLoad(ChosairaiBindByHandMainDiv div) {
                setGridSetting(div);
                init_comNinteichosaIraiListGod(div);
            }

            private static void setGridSetting(ChosairaiBindByHandMainDiv div) {
                setSettingToWariatezumiList(div.getComWaritukezumiList());
                setSettingToMiwarituskeList(div.getComMiwarituskeList());
            }

            private static void init_comNinteichosaIraiListGod(ChosairaiBindByHandMainDiv div) {
                div.getComNinteichosaIraiListGod().getDgNinteichosaIraiListForByHand().setDataSource(
                        new DemoData().get依頼者一覧());
            }

            enum Column {

                chosaKanryoFlag,
                chosaJokyo,
                btnToShowDetail,
                hokenshaNo,
                shichoson,
                shishoCode,
                shoshoName,
                hihokenshaNo,
                shimei,
                kanaShimei,
                shimeiWithKana,
                ninteiShinseiKubun,
                ninteiShinseiDate,
                chosaIraiKubun,
                chosaIraiDate,
                chosaKigenDate,
                iraishoHakkoDate,
                chosaItakusakiNo,
                chosaItakusakiName,
                chosainNo,
                chosainName,
                chosaItakusakiNo1TA,
                chosaItakusakiName1TA,
                chosainNo1TA,
                chosainName1TA,
                chosaItakusakiNo2TA,
                chosaItakusakiName2TA,
                chosainNo2TA,
                chosainName2TA,
                tokusokuDate,
                tokusokuCount,
                yubinNo,
                jusho,
                nyushoShisetsu;
                private final RString theDataName;

                private Column() {
                    this.theDataName = new RString(name());
                }

                private RString dataName() {
                    return this.theDataName;
                }
            }

            private static void setSettingToWariatezumiList(NinteichosaIraiListForByHandCom com) {
                DataGridSetting setting
                        = com.getDgNinteichosaIraiListForByHand().getGridSetting();
                hideColumn(setting, Column.chosaItakusakiNo2TA);
                hideColumn(setting, Column.chosaItakusakiName2TA);
                hideColumn(setting, Column.chosainNo2TA);
                hideColumn(setting, Column.chosainName2TA);
            }

            private static void setSettingToMiwarituskeList(NinteichosaIraiListForByHandCom com) {
                DataGridSetting setting
                        = com.getDgNinteichosaIraiListForByHand().getGridSetting();
                hideColumn(setting, Column.chosaJokyo);
                hideColumn(setting, Column.btnToShowDetail);
                hideColumn(setting, Column.chosaIraiKubun);
                hideColumn(setting, Column.chosaIraiDate);
                hideColumn(setting, Column.chosaKigenDate);
                hideColumn(setting, Column.iraishoHakkoDate);
                hideColumn(setting, Column.chosaItakusakiNo);
                hideColumn(setting, Column.chosaItakusakiName);
                hideColumn(setting, Column.chosainNo);
                hideColumn(setting, Column.chosainName);
                hideColumn(setting, Column.tokusokuDate);
                hideColumn(setting, Column.tokusokuCount);
            }

            private static void hideColumn(DataGridSetting setting, Column item) {
                setting.getColumn(item.dataName()).setVisible(false);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DemoData">
    /**
     * demo用のデータを取得します。
     */
    private static final class DemoData {

        /**
         * デモ用データの種類の列挙型です。
         */
        private enum DemoDataType {

            依頼者一覧("ChosaIraiTargets.yml"),
            所属調査員一覧("ShozokuChosainList.yml"),
            調査委託先一覧("ChosaItakusakiList.yml");
            private final RString path;

            private DemoDataType(String fileName) {
                this.path = new RString("dbeuc21000/" + fileName);
            }

            RString getPath() {
                return this.path;
            }
        }

        private final List<dgNinteichosaIraiListForByHand_Row> _targetList;
        private final List<dgShozokuChosainList_Row> _chosainList;
        private final List<dgChosaItakusakiList_Row> _chosaItakusakiList;

        /**
         * DemoDataを生成します。
         */
        DemoData() {
            _targetList = _createList(DemoDataType.依頼者一覧);
            _chosainList = _createList(DemoDataType.所属調査員一覧);
            _chosaItakusakiList = _createList(DemoDataType.調査委託先一覧);
        }

        /**
         * 依頼者一覧を取得します。
         *
         * @return 依頼者一覧
         */
        List<dgNinteichosaIraiListForByHand_Row> get依頼者一覧() {
            return this._targetList;
        }

        /**
         * 所属調査員一覧を取得します。
         *
         * @return 所属調査員一覧
         */
        List<dgShozokuChosainList_Row> get所属調査員一覧() {
            return this._chosainList;
        }

        /**
         * 調査委託先一覧を取得します。
         *
         * @return 調査委託先一覧
         */
        List<dgChosaItakusakiList_Row> get調査委託先一覧() {
            return this._chosaItakusakiList;
        }

        private static <T> List<T> _createList(DemoDataType type) {
            List<HashMap> dataFromYaml = YamlLoader.FOR_DBE.loadAsList(type.getPath());
            return YamlUtil.convertList(dataFromYaml, _createDataEditor(type));
        }

        private static Converter.IConverter _createDataEditor(DemoDataType type) {
            switch (type) {
                case 依頼者一覧:
                    return new Converter.IConverter<dgNinteichosaIraiListForByHand_Row>() {

                        @Override
                        public dgNinteichosaIraiListForByHand_Row exec(Map map) {
                            return _to_dgNinteichosaIraiListForByHand_Row(map);

                        }

                    };
                case 所属調査員一覧:
                    return new Converter.IConverter<dgShozokuChosainList_Row>() {

                        @Override
                        public dgShozokuChosainList_Row exec(Map map) {
                            return _to_dgShozokuChosainList_Row(map);

                        }

                    };
                case 調査委託先一覧:
                    return new Converter.IConverter<dgChosaItakusakiList_Row>() {

                        @Override
                        public dgChosaItakusakiList_Row exec(Map map) {
                            return _to_dgChosaItakusakiList_Row(map);

                        }

                    };
                default:
                    return Converter.NO_CHANGE;
            }

        }

        private static dgChosaItakusakiList_Row _to_dgChosaItakusakiList_Row(Map map) {
            return new dgChosaItakusakiList_Row(
                    YamlUtil.toRString(map.get("調査委託先番号")),
                    YamlUtil.toRString(map.get("調査委託先名称")),
                    YamlUtil.toRString(map.get("割付定員")),
                    YamlUtil.toRString(map.get("割付済み")),
                    YamlUtil.toRString(map.get("割付地区査員番号")));
        }

        private static dgShozokuChosainList_Row _to_dgShozokuChosainList_Row(Map map) {
            return new dgShozokuChosainList_Row(new Button(),
                    YamlUtil.toRString(map.get("調査員番号")),
                    YamlUtil.toRString(map.get("調査員氏名")),
                    YamlUtil.toRString(map.get("割付済人数")),
                    YamlUtil.toRString(map.get("地区")),
                    YamlUtil.toRString(map.get("調査委託先番号")));
        }

        private static dgNinteichosaIraiListForByHand_Row _to_dgNinteichosaIraiListForByHand_Row(Map map) {
            RString shimei = YamlUtil.toRString(map.get("氏名"));
            RString kanaShimei = YamlUtil.toRString(map.get("カナ氏名"));
            return new dgNinteichosaIraiListForByHand_Row(
                    YamlUtil.toBoolean(map.get("調査状況")),
                    _compose調査状況(YamlUtil.toRString(map.get("調査状況"))),
                    new Button(),
                    YamlUtil.toRString(map.get("保険者番号")),
                    YamlUtil.toRString(map.get("市町村")),
                    YamlUtil.toRString(map.get("支所コード")),
                    YamlUtil.toRString(map.get("支所")),
                    YamlUtil.toRString(map.get("被保番号")),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    YamlUtil.toRString(map.get("認定申請区分")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("認定申請日")),
                    YamlUtil.toRString(map.get("調査依頼区分")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("調査依頼日")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("調査期限日")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("依頼書発行日")),
                    YamlUtil.toRString(map.get("調査委託先番号")),
                    YamlUtil.toRString(map.get("調査委託先名")),
                    YamlUtil.toRString(map.get("調査員番号")),
                    YamlUtil.toRString(map.get("調査員名")),
                    YamlUtil.toRString(map.get("前回調査委託先番号")),
                    YamlUtil.toRString(map.get("前回調査委託先名")),
                    YamlUtil.toRString(map.get("前回調査員番号")),
                    YamlUtil.toRString(map.get("前回調査員名")),
                    YamlUtil.toRString(map.get("前々回調査委託先番号")),
                    YamlUtil.toRString(map.get("前々回調査委託先名")),
                    YamlUtil.toRString(map.get("前々回調査員番号")),
                    YamlUtil.toRString(map.get("前々回調査員名")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("督促日")),
                    YamlUtil.toRString(map.get("督促回数")),
                    YamlUtil.toRString(map.get("郵便番号")),
                    YamlUtil.toRString(map.get("住所")),
                    YamlUtil.toRString(map.get("入所施設"))
            );
        }

        private static RString _compose調査状況(RString rstr) {
            if (rstr.equals(new RString("true"))) {
                return new RString("済");
            } else {
                return new RString("未済");
            }
        }
    }
    //</editor-fold>
}
