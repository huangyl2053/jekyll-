/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

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
            div.getDgChosaItakusakiList().setDataSource(DemoData.ITAKUSAKI_LIST);
        }

        private static void init_comChosainListAll(ChosaItakusakiAndChosainListDiv div) {
            div.getShozokuChosainList().getComChosainListAll().getDgShozokuChosainList().setDataSource(DemoData.CHOSAIN_LIST);
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
                div.getComNinteichosaIraiListGod().getDgNinteichosaIraiListForByHand()
                        .setDataSource(DemoData.TARGET_LIST);
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

        private enum DemoDataType {

            依頼者一覧("ChosaIraiTargets.yml"),
            所属調査員一覧("ShozokuChosainList.yml"),
            調査委託先一覧("ChosaItakusakiList.yml");
            private final RString path;

            private DemoDataType(String fileName) {
                this.path = new RString("dbe2010002/" + fileName);
            }

            RString getPath() {
                return this.path;
            }
        }

        private static final List<dgNinteichosaIraiListForByHand_Row> TARGET_LIST;
        private static final List<dgShozokuChosainList_Row> CHOSAIN_LIST;
        private static final List<dgChosaItakusakiList_Row> ITAKUSAKI_LIST;

        static {
            TARGET_LIST = new ArrayList<>();
            CHOSAIN_LIST = new ArrayList<>();
            ITAKUSAKI_LIST = new ArrayList();
            init(DemoDataType.依頼者一覧);
            init(DemoDataType.所属調査員一覧);
            init(DemoDataType.調査委託先一覧);
        }

        private static void init(DemoDataType type) {
            try {
                List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(type.getPath());
                for (Map target : targetSource) {
                    switch (type) {
                        case 依頼者一覧:
                            TARGET_LIST.add(to_dgNinteichosaIraiListForByHand_Row(target));
                            break;
                        case 所属調査員一覧:
                            CHOSAIN_LIST.add(to_dgShozokuChosainList_Row(target));
                            break;
                        case 調査委託先一覧:
                            ITAKUSAKI_LIST.add(to_dgChosaItakusakiList(target));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private static dgChosaItakusakiList_Row to_dgChosaItakusakiList(Map map) {
            return new dgChosaItakusakiList_Row(
                    toRString(map.get("調査委託先番号")),
                    toRString(map.get("調査委託先名称")),
                    toRString(map.get("割付定員")),
                    toRString(map.get("割付済み")),
                    toRString(map.get("割付地区査員番号")));
        }

        private static dgShozokuChosainList_Row to_dgShozokuChosainList_Row(Map map) {
            return new dgShozokuChosainList_Row(
                    toRString(map.get("調査員番号")),
                    toRString(map.get("調査員氏名")),
                    toRString(map.get("割付済人数")),
                    toRString(map.get("地区")),
                    toRString(map.get("調査委託先番号")));
        }

        private static dgNinteichosaIraiListForByHand_Row to_dgNinteichosaIraiListForByHand_Row(Map map) {
            RString shimei = toRString(map.get("氏名"));
            RString kanaShimei = toRString(map.get("カナ氏名"));
            return new dgNinteichosaIraiListForByHand_Row(
                    toBoolean(map.get("調査状況")),
                    compose調査状況(toRString(map.get("調査状況"))),
                    new Button(),
                    toRString(map.get("保険者番号")),
                    toRString(map.get("市町村")),
                    toRString(map.get("支所コード")),
                    toRString(map.get("支所")),
                    toRString(map.get("被保番号")),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    toRString(map.get("認定申請区分")),
                    toTextBoxFlexibleDate(map.get("認定申請日")),
                    toRString(map.get("調査依頼区分")),
                    toTextBoxFlexibleDate(map.get("調査依頼日")),
                    toTextBoxFlexibleDate(map.get("調査期限日")),
                    toTextBoxFlexibleDate(map.get("依頼書発行日")),
                    toRString(map.get("調査委託先番号")),
                    toRString(map.get("調査委託先名")),
                    toRString(map.get("調査員番号")),
                    toRString(map.get("調査員名")),
                    toRString(map.get("前回調査委託先番号")),
                    toRString(map.get("前回調査委託先名")),
                    toRString(map.get("前回調査員番号")),
                    toRString(map.get("前回調査員名")),
                    toRString(map.get("前々回調査委託先番号")),
                    toRString(map.get("前々回調査委託先名")),
                    toRString(map.get("前々回調査員番号")),
                    toRString(map.get("前々回調査員名")),
                    toTextBoxFlexibleDate(map.get("督促日")),
                    toRString(map.get("督促回数")),
                    toRString(map.get("郵便番号")),
                    toRString(map.get("住所")),
                    toRString(map.get("入所施設"))
            );
        }

        private static RString toRString(Object obj) {
            if (obj == null) {
                return RString.EMPTY;
            }
            return new RString(obj.toString());
        }

        private static boolean toBoolean(Object obj) {
            return obj.toString().equals(Boolean.TRUE.toString());
        }

        private static RString compose調査状況(RString rstr) {
            if (rstr.equals(new RString("true"))) {
                return new RString("済");
            } else {
                return new RString("未済");
            }
        }

        private static TextBoxFlexibleDate toTextBoxFlexibleDate(Object obj) {
            TextBoxFlexibleDate textBox = new TextBoxFlexibleDate();
            RString date = toRString(obj);
            if (date.equals(RString.EMPTY)) {
                textBox.setValue(FlexibleDate.EMPTY);
            } else {
                textBox.setValue(new FlexibleDate(date));
            }
            return textBox;
        }
    }
    //</editor-fold>
}
