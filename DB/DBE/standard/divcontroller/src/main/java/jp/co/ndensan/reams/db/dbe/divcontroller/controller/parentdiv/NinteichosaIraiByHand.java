/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosaItakusakiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ninteichosaIraiListForByHandCom.dgNinteichosaIraiListForByHand_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.NinteichosaIraiByHandDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.RequestContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.shozokuChosainList.dgShozokuChosainList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
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
        new ChosairaiBindByHandMain(div).onLoad();
        new ChosaItakusakiAndChosainList(div).onLoad();
        return createResponseData(div);
    }

    /**
     * 共通ボタン btnCommonSaveChosaIrai を押した時の処理です。
     *
     * @param div NinteichosaIraiByHandDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiByHandDiv> onClick_btnCommonSaveChosaIrai(NinteichosaIraiByHandDiv div) {
        return addMessage(createResponseData(div), new InformationMessage("I", "保存しました。"));
    }

    private <T> ResponseData<T> addMessage(ResponseData<T> response, Message message) {
        response.addMessage(message);
        return response;
    }

    private <T> ResponseData<T> createResponseData(T div) {
        ResponseData<T> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    //<editor-fold defaultstate="collapsed" desc="ChosaItakusakiAndChosainList">
    private static final class ChosaItakusakiAndChosainList {

       // private IChosaItakusakiAndChosainInputDiv div;

        ChosaItakusakiAndChosainList(NinteichosaIraiByHandDiv div) {
            //this.div = div.getCcdItakusakiAndChosainInput();
        }

        private void onLoad() {
//            _init_dgChosaItakusakiList();
//            _init_comChosainListAll();
        }

//        private void _init_dgChosaItakusakiList() {
//            div.getWaritsukesakiChosaItakusakiList().getDgChosaItakusakiList().setDataSource(
//                    new DemoData().get調査委託先一覧());
//        }
//
//        private void _init_comChosainListAll() {
//            div.getShozokuChosainList().getComChosainListAll().getDgShozokuChosainList().setDataSource(
//                    new DemoData().get所属調査員一覧());
//        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ChosairaiBindByHandMain">
    /**
     * ChosairaiBindByHandMainDivを操作するためのクラスです。
     */
    private static final class ChosairaiBindByHandMain {

        private final RequestContents contents;
        private final DataGrids dataGrids;

        ChosairaiBindByHandMain(NinteichosaIraiByHandDiv div) {
            this.dataGrids = new DataGrids(div);
            this.contents = new RequestContents(div);
        }

        void onLoad() {
            contents.onLoad();
            dataGrids.onLoad();
        }

        /**
         * RequestContentsDivを操作するためのクラスです。
         */
        private static final class RequestContents {

            private final RequestContentsDiv panel;

            RequestContents(NinteichosaIraiByHandDiv div) {
                this.panel = null;
            }
            private static final int NUM_OF_A_WEEK = 7;

            private void onLoad() {
                panel.getDdlIraiKubun().setSelectedItem(new RString("1"));
                FlexibleDate nowDate = FlexibleDate.getNowDate();
                panel.getTxtChosaIraiDate().setValue(nowDate);
                panel.getTxtChosaKigenDate().setValue(nowDate.plusDay(NUM_OF_A_WEEK));
            }
        }

        /**
         * ChosairaiBindByHandMainDivが保持するDataGridを操作するためのクラスです。
         */
        private static final class DataGrids {

            private final NinteichosaIraiByHandDiv panel;

            DataGrids(NinteichosaIraiByHandDiv div) {
                this.panel = div;
            }

            private void onLoad() {
                setGridSetting();
                _init_comNinteichosaIraiListGod();
            }

            private void setGridSetting() {
                _setGridSetting_WariatezumiList();
                _setGridSetting_MiwarituskeList();
            }

            private void _init_comNinteichosaIraiListGod() {
//                panel.getComNinteichosaIraiListGod().getDgNinteichosaIraiListForByHand().setDataSource(
//                        new DemoData().get依頼者一覧());
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

            void _setGridSetting_WariatezumiList() {
//                DataGridSetting setting
//                        = panel.getTblChosaIraiWaritsuke().getComWaritukezumiList()
//                        .getDgNinteichosaIraiListForByHand().getGridSetting();
//                _hideColumn(setting, Column.chosaItakusakiNo2TA);
//                _hideColumn(setting, Column.chosaItakusakiName2TA);
//                _hideColumn(setting, Column.chosainNo2TA);
//                _hideColumn(setting, Column.chosainName2TA);
            }

            void _setGridSetting_MiwarituskeList() {
//                DataGridSetting setting
//                        = panel.getTblChosaIraiWaritsuke().
//                        getComMiwarituskeList().getDgNinteichosaIraiListForByHand().getGridSetting();
//                _hideColumn(setting, Column.chosaJokyo);
//                _hideColumn(setting, Column.btnToShowDetail);
//                _hideColumn(setting, Column.chosaIraiKubun);
//                _hideColumn(setting, Column.chosaIraiDate);
//                _hideColumn(setting, Column.chosaKigenDate);
//                _hideColumn(setting, Column.iraishoHakkoDate);
//                _hideColumn(setting, Column.chosaItakusakiNo);
//                _hideColumn(setting, Column.chosaItakusakiName);
//                _hideColumn(setting, Column.chosainNo);
//                _hideColumn(setting, Column.chosainName);
//                _hideColumn(setting, Column.tokusokuDate);
//                _hideColumn(setting, Column.tokusokuCount);
            }

            private void _hideColumn(DataGridSetting setting, Column item) {
                setting.getColumn(item.dataName()).setVisible(false);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DemoData">
    /**
     * demo用のデータを取得します。
     */
    static final class DemoData {

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

        private final List<dgNinteichosaIraiListForByHand_Row> targetList;
        private final List<dgShozokuChosainList_Row> chosainList;
        private final List<dgChosaItakusakiList_Row> chosaItakusakiList;

        /**
         * DemoDataを生成します。
         */
        DemoData() {
            targetList = _createList(DemoDataType.依頼者一覧);
            chosainList = _createList(DemoDataType.所属調査員一覧);
            chosaItakusakiList = _createList(DemoDataType.調査委託先一覧);
        }

        /**
         * 依頼者一覧を取得します。
         *
         * @return 依頼者一覧
         */
        List<dgNinteichosaIraiListForByHand_Row> get依頼者一覧() {
            return this.targetList;
        }

        /**
         * 所属調査員一覧を取得します。
         *
         * @return 所属調査員一覧
         */
        List<dgShozokuChosainList_Row> get所属調査員一覧() {
            return this.chosainList;
        }

        /**
         * 調査委託先一覧を取得します。
         *
         * @return 調査委託先一覧
         */
        List<dgChosaItakusakiList_Row> get調査委託先一覧() {
            return this.chosaItakusakiList;
        }

        private <T> List<T> _createList(DemoDataType type) {
            List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(type.getPath());
            return YamlUtil.convertList(dataFromYaml, _createDataEditor(type));
        }

        private Converter.IConverter _createDataEditor(DemoDataType type) {
            switch (type) {
                case 依頼者一覧:
                    return new Converter.IConverter<dgNinteichosaIraiListForByHand_Row>() {

                        @Override
                        public dgNinteichosaIraiListForByHand_Row exec(Map map) {
                            return _toDgNinteichosaIraiListForByHand_Row(map);

                        }

                    };
                case 所属調査員一覧:
                    return new Converter.IConverter<dgShozokuChosainList_Row>() {

                        @Override
                        public dgShozokuChosainList_Row exec(Map map) {
                            return _toDgShozokuChosainList_Row(map);

                        }

                    };
                case 調査委託先一覧:
                    return new Converter.IConverter<dgChosaItakusakiList_Row>() {

                        @Override
                        public dgChosaItakusakiList_Row exec(Map map) {
                            return _toDgChosaItakusakiList_Row(map);

                        }

                    };
                default:
                    return Converter.NO_CHANGE;
            }

        }

        private dgChosaItakusakiList_Row _toDgChosaItakusakiList_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            ChosaItakusakiData.ChosaItakusaki chosaItakusaki
                    = new ChosaItakusakiData().get調査委託先From(cg.getAsRString("調査委託先番号"));
            return new dgChosaItakusakiList_Row(
                    chosaItakusaki.code(),
                    chosaItakusaki.name(),
                    cg.getAsRString("割付定員"),
                    cg.getAsRString("割付済み"),
                    cg.getAsRString("割付地区査員番号")
            );
        }

        private dgShozokuChosainList_Row _toDgShozokuChosainList_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            ChosainData.Chosain chosain
                    = new ChosainData().get調査員From(cg.getAsRString("調査員番号"));
            return new dgShozokuChosainList_Row(new Button(),
                    chosain.code(),
                    chosain.name(),
                    cg.getAsRString("割付済人数"),
                    cg.getAsRString("地区"),
                    chosain.itakusaki().code()
            );
        }

        private dgNinteichosaIraiListForByHand_Row _toDgNinteichosaIraiListForByHand_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            RString shimei = cg.getAsRString("氏名");
            RString kanaShimei = cg.getAsRString("カナ氏名");
            ChosainData.Chosain chosain
                    = new ChosainData().get調査員From(cg.getAsRString("調査員番号"));
            ChosainData.Chosain zen_chosain
                    = new ChosainData().get調査員From(cg.getAsRString("前回調査員番号"));
            ChosainData.Chosain zenzen_chosain
                    = new ChosainData().get調査員From(cg.getAsRString("前々回調査員番号"));
            return new dgNinteichosaIraiListForByHand_Row(
                    cg.getAsBooleanValue("調査状況"),
                    _compose調査状況(cg.getAsRString("調査状況")),
                    new Button(),
                    cg.getAsRString("保険者番号"),
                    cg.getAsRString("市町村"),
                    cg.getAsRString("支所コード"),
                    cg.getAsRString("支所"),
                    cg.getAsRString("被保番号"),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    cg.getAsRString("認定申請区分"),
                    cg.getAsTextBoxFlexibleDate("認定申請日"),
                    cg.getAsRString("地区"),
                    cg.getAsRString("調査依頼区分"),
                    cg.getAsTextBoxFlexibleDate("調査依頼日"),
                    cg.getAsTextBoxFlexibleDate("調査期限日"),
                    cg.getAsTextBoxFlexibleDate("依頼書発行日"),
                    chosain.itakusaki().code(),
                    chosain.itakusaki().name(),
                    chosain.code(),
                    chosain.name(),
                    zen_chosain.itakusaki().code(),
                    zen_chosain.itakusaki().name(),
                    zen_chosain.code(),
                    zen_chosain.name(),
                    zenzen_chosain.itakusaki().code(),
                    zenzen_chosain.itakusaki().name(),
                    zenzen_chosain.code(),
                    zenzen_chosain.name(),
                    cg.getAsTextBoxFlexibleDate("督促日"),
                    cg.getAsRString("督促回数"),
                    cg.getAsRString("郵便番号"),
                    cg.getAsRString("住所"),
                    cg.getAsRString("入所施設")
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
