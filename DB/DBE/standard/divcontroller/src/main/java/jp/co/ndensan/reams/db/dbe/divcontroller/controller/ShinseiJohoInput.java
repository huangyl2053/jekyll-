/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoOrYoshienKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoninteiShinseiKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.HihokenshaSearchForShinsei.ForDemo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoninteiShinseishaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaShujiiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KankeiIinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.LatestNinteiResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.N2HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseiJigyoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseishaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseishaTudukigaraDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosainAdvanceEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuinNyushoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinseiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShisetsuRerekiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgKankeiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShisetsuRereki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 申請情報入力用Div制御クラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShinseiJohoInput {

    /**
     * Divが表示されたときの、初期値を設定します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onLoad(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();

        dgSearchResult_Row hihokensha = clickedItemOf(searchResult);
        DdlShinseiKubunShinseiji.onLoad(div.getDdlShinseiKubunShinseiji());
        RadYokaigoOrYoshien.onLoad(div.getRadYokaigoOrYoshien());

        HihokenshaOutline.onLoad(div.getHihokenshaOutline(), hihokensha);
        NinteiShinseisha.onLoad(div.getNinteiShinseisha(), hihokensha);
        LatestNinteiResult.onLoad(div, hihokensha);
        N2Hihokensha.onLoad(div.getN2Hihokensha(), hihokensha);

        NyuinNyusho.onLoad(div.getNyuinNyusho(), hihokensha);
        KankeiIin.onLoad(div.getKankeiIin(), hihokensha);

        div.getTxtShinseiYukoKubun().setValue(new RString(NinteiShinseiYukoKubun.申請中.name()));

        response.data = div;
        return response;
    }

    /**
     * 申請者区分の変更によって、divの画面項目を編集します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onChange_radShinseishaKubun(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();

        NinteiShinseisha.onChange_radShinseishaKubun(div.getNinteiShinseisha(), clickedItemOf(searchResult));

        response.data = div;
        return response;
    }

    private dgSearchResult_Row clickedItemOf(HihokenshaSearchForShinseiDiv searchResult) {
        return searchResult.getSearchResultForShinsei().getDgSearchResult().getClickedItem();
    }

    /**
     * 前回の主治医を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestShujii(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();

        HihokenshaShujii.onClick_btnToCopyLatestShujii(div.getHihokenshaShujii(), clickedItemOf(searchResult));

        response.data = div;
        return response;
    }

    /**
     * 前回の認定調査委託先を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestItakusaki(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();

        NinteichosainAdvanceEntry.onClick_btnToCopyLatestItakusaki(div.getNinteichosainAdvanceEntry(), clickedItemOf(searchResult));

        response.data = div;
        return response;
    }

    /**
     * 前回の認定調査員を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestNinteichosain(
            ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {

        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();

        NinteichosainAdvanceEntry.onClick_btnToCopyLatestNinteichosain(div.getNinteichosainAdvanceEntry(), clickedItemOf(searchResult));

        response.data = div;
        return response;
    }

    private static final class DdlShinseiKubunShinseiji {

        private DdlShinseiKubunShinseiji() {
        }

        public static void onLoad(DropDownList ddl) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (YokaigoninteiShinseiKubun kubun : YokaigoninteiShinseiKubun.values()) {
                dataSource.add(new KeyValueDataSource(kubun.getCode(), kubun.toRString()));
            }
            ddl.setDataSource(dataSource);
        }

        public static void select(DropDownList ddl, YokaigoninteiShinseiKubun kubun) {
            ddl.setSelectedItem(kubun.getCode());
        }

    }

    private static final class RadYokaigoOrYoshien {

        private RadYokaigoOrYoshien() {
        }

        public static void onLoad(RadioButton rad) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (YokaigoOrYoshienKubun kubun : YokaigoOrYoshienKubun.values()) {
                dataSource.add(new KeyValueDataSource(kubun.getCode(), kubun.toRString()));
            }
            rad.setDataSource(dataSource);
        }

        public static void select(RadioButton rad, YokaigoOrYoshienKubun kubun) {
            rad.setSelectedItem(kubun.getCode());
        }
    }

    /**
     * HihokenshaOutlineDivへの操作をまとめたクラスです。
     */
    private static final class HihokenshaOutline {

        private HihokenshaOutline() {
        }

        public static void onLoad(HihokenshaOutlineDiv div, dgSearchResult_Row hihokensha) {
            div.getTxtHihokenshaNo().setValue(hihokensha.getHihokenshaNo());
            div.getTxtHihokenshaKubun().setValue(hihokensha.getHihokenshaKubun());
            div.getTxtShimei().setValue(hihokensha.getShimei());
        }
    }

    /**
     * NinteiShinseishaDivへの操作をまとめたクラスです。
     */
    private static final class NinteiShinseisha {

        private NinteiShinseisha() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div NinteiShinseishaDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onLoad(NinteiShinseishaDiv div, dgSearchResult_Row hihokensha) {
            _onLoad(div, hihokensha);
            NinteiShinseishaTudukigara.onLoad(div.getNinteiShinseishaTudukigara());
            NinteiShinseiJigyosha.onLoad(div.getNinteiShinseiJigyosha());
        }

        private static void _onLoad(NinteiShinseishaDiv div, dgSearchResult_Row hihokensha) {
            _init_radShinseishaKubun(div.getRadShinseishaKubun());
            onChange_radShinseishaKubun(div, hihokensha);
        }

        /**
         * 内包する編集可能なUI部品への設定値をクリアします。
         *
         * @param div NinteiShinseishaDiv
         */
        public static void clear(NinteiShinseishaDiv div) {
            _setUpItem(div, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, true, true);
        }

        /**
         * radShinseishaKubunの選択値が変化したときの処理です。
         *
         * 選択内容によって、panelを非表示にしたり、 初期値を設定したりします。
         *
         * @param div NinteiShinseishaDiv
         * @param hihokensha gSearchResult_Row
         */
        public static void onChange_radShinseishaKubun(NinteiShinseishaDiv div, dgSearchResult_Row hihokensha) {
            RadioButton shinseishaKubun = div.getRadShinseishaKubun();
            RString key = shinseishaKubun.getSelectedItem();
            YokaigoninteiShinseishaKubun shinseisha = _toYokaigoninteiShinseishaKubun(key);
            switch (shinseisha) {
                case 本人:
                    _onChange_radShinseishaKubun_本人(div, hihokensha);
                    break;
                case 家族:
                    _onChange_radShinseishaKubun_家族(div, hihokensha);
                    break;
                case 施設職員:
                    _onChange_radShinseishaKubun_施設職員(div);
                    break;
                default:
                    _onChange_radShinseishaKubun_その他(div);
                    break;
            }
        }

        private static void _onChange_radShinseishaKubun_本人(NinteiShinseishaDiv div, dgSearchResult_Row hihokensha) {
            _setUpItem(div, hihokensha.getShimei(), hihokensha.getKanaShimsei(),
                    hihokensha.getYubinNo(), hihokensha.getJusho(), false, false);
        }

        private static void _onChange_radShinseishaKubun_家族(NinteiShinseishaDiv div, dgSearchResult_Row hihokensha) {
            _setUpItem(div, null, null, hihokensha.getYubinNo(), hihokensha.getJusho(), true, false);
        }

        private static void _onChange_radShinseishaKubun_施設職員(NinteiShinseishaDiv div) {
            _setUpItem(div, null, null, null, null, false, true);
        }

        private static void _onChange_radShinseishaKubun_その他(NinteiShinseishaDiv div) {
            _setUpItem(div, null, null, null, null, false, false);
        }

        private static void _setUpItem(NinteiShinseishaDiv div,
                RString name, RString kanaName, RString yubinNo, RString jusho, boolean isFamily, boolean isJighosya) {

            div.getTxtShinseishaName().setValue(name);
            div.getTxtShinseishaNameKana().setValue(kanaName);
            div.getTxtYubinNo().setValue(new YubinNo(yubinNo));
            div.getTxtShinseishaJusho().setValue(jusho);

            div.getNinteiShinseishaTudukigara().setDisplayNone(!isFamily);
            div.getNinteiShinseiJigyosha().setDisplayNone(!isJighosya);

            NinteiShinseiJigyosha.clear(div.getNinteiShinseiJigyosha());
            NinteiShinseishaTudukigara.clear(div.getNinteiShinseishaTudukigara());
        }

        /**
         * radShinseishaKubunの値を、YokaigoninteiShinseishaKubunへ変換します。
         *
         * @param value radShinseishaKubunのvalue
         * @return YokaigoninteiShinseishaKubun
         */
        private static YokaigoninteiShinseishaKubun _toYokaigoninteiShinseishaKubun(RString key) {
            return YokaigoninteiShinseishaKubun.toValue(key);
        }

        /**
         * radShinseishaKubunを初期化します。
         *
         * @param radShinseishaKubun radShinseishaKubunのインスタンス
         */
        private static void _init_radShinseishaKubun(RadioButton radShinseishaKubun) {
            _setUpFromYokaigoninteiShinseishaKubun(radShinseishaKubun);
            _selectFirst(radShinseishaKubun);
        }

        /**
         * 先頭の要素を選択します。
         */
        private static void _selectFirst(RadioButton radShinseishaKubun) {
            List<KeyValueDataSource> dataSource = radShinseishaKubun.getDataSource();
            if (!dataSource.isEmpty()) {
                radShinseishaKubun.setSelectedItem(radShinseishaKubun.getDataSource().get(0).getKey());
            }
        }

        /**
         * YokaigoninteiShinseishaKubunと同じ値を、選択肢に設定します。
         */
        private static void _setUpFromYokaigoninteiShinseishaKubun(RadioButton radShinseishaKubun) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (YokaigoninteiShinseishaKubun kubun : YokaigoninteiShinseishaKubun.values()) {
                dataSource.add(new KeyValueDataSource(kubun.getCode(), kubun.toRString()));
            }
            radShinseishaKubun.setDataSource(dataSource);
        }

        /**
         * NinteiShinseishaTudukigaraDivへの操作をまとめたクラスです。
         */
        private static final class NinteiShinseishaTudukigara {

            private NinteiShinseishaTudukigara() {
            }

            /**
             * ロード時の処理です。
             *
             * @param div NinteiShinseishaTudukigaraDiv
             */
            public static void onLoad(NinteiShinseishaTudukigaraDiv div) {
                _initDataSource(div.getDdlShinseishaTsuzukigara());
            }

            private static void _initDataSource(DropDownList ddlShinseishaTsuzukigara) {
                List<KeyValueDataSource> dataSource = new ArrayList<>();
                dataSource.add(new KeyValueDataSource(new RString("1"), new RString("子")));
                dataSource.add(new KeyValueDataSource(new RString("2"), new RString("孫")));
                dataSource.add(new KeyValueDataSource(new RString("3"), new RString("兄")));
                dataSource.add(new KeyValueDataSource(new RString("4"), new RString("弟")));
                dataSource.add(new KeyValueDataSource(new RString("5"), new RString("姉")));
                dataSource.add(new KeyValueDataSource(new RString("6"), new RString("妹")));
                dataSource.add(new KeyValueDataSource(new RString("7"), new RString("甥")));
                dataSource.add(new KeyValueDataSource(new RString("8"), new RString("姪")));
                dataSource.add(new KeyValueDataSource(new RString("9"), new RString("その他")));
                ddlShinseishaTsuzukigara.setDataSource(dataSource);
            }

            /**
             * 内包する編集可能なUI部品への設定値をクリアします。
             *
             * @param div NinteiShinseishaTudukigaraDiv
             */
            public static void clear(NinteiShinseishaTudukigaraDiv div) {
                div.getDdlShinseishaTsuzukigara().setSelectedItem(RString.EMPTY);
            }

        }

        /**
         * NinteiShinseiJigyoshaDvへの操作をまとめたクラスです。
         */
        private static final class NinteiShinseiJigyosha {

            private NinteiShinseiJigyosha() {
            }

            /**
             * ロード時の処理です。
             *
             * @param div NinteiShinseiJigyoshaDiv
             */
            public static void onLoad(NinteiShinseiJigyoshaDiv div) {
            }

            /**
             * 内包する編集可能なUI部品への設定値をクリアします。
             *
             * @param div NinteiShinseiJigyoshaDiv
             */
            public static void clear(NinteiShinseiJigyoshaDiv div) {
                div.getDdlJigyoshaKubun().setSelectedItem(RString.EMPTY);
                div.getTxtJigyoshaCode().setValue(RString.EMPTY);
                div.getTxtJigyoshaName().setValue(RString.EMPTY);
            }

        }
    }

    /**
     * LatestNinteiResultDivへの操作をまとめたクラスです。
     */
    private static final class LatestNinteiResult {

        private LatestNinteiResult() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div LatestNinteiResultDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onLoad(ShinseiJohoInputDiv div, dgSearchResult_Row hihokensha) {
            _onLoad_demo(div, hihokensha);
        }

        private static void _onLoad_demo(ShinseiJohoInputDiv div, dgSearchResult_Row hihokensha) {
            ForDemo.LatestNinteiResult latestResult = ForDemo.getLatestNinteiResultMap().get(hihokensha.getHihokenshaNo());
            _setUpItems(div.getLatestNinteiResult(), latestResult.yokaigodo().toRString(), latestResult.ninteiDate(),
                    latestResult.yukoKikan().getFrom(), latestResult.yukoKikan().getTo());

            RadYokaigoOrYoshien.select(div.getRadYokaigoOrYoshien(), YokaigoOrYoshienKubun.要介護);
            if (latestResult == ForDemo.LatestNinteiResult.NOTHING) {
                LatestNinteiResult.setDisplayNone(div.getLatestNinteiResult(), true);
                DdlShinseiKubunShinseiji.select(div.getDdlShinseiKubunShinseiji(), YokaigoninteiShinseiKubun.新規申請);
            } else {
                LatestNinteiResult.setDisplayNone(div.getLatestNinteiResult(), false);
                DdlShinseiKubunShinseiji.select(div.getDdlShinseiKubunShinseiji(), YokaigoninteiShinseiKubun.新規申請);
                if (!latestResult.yokaigodo().is要介護()) {
                    RadYokaigoOrYoshien.select(div.getRadYokaigoOrYoshien(), YokaigoOrYoshienKubun.要支援);
                }
            }
        }

        public static void setDisplayNone(LatestNinteiResultDiv div, boolean displayNone) {
            div.setDisplayNone(displayNone);
        }

        /**
         * 内包する編集可能なUI部品への設定値をクリアします。
         *
         * @param div LatestNinteiResultDiv
         */
        public static void clear(LatestNinteiResultDiv div) {
            _setUpItems(div, RString.EMPTY, null, null, null);
        }

        private static void _setUpItems(LatestNinteiResultDiv div,
                RString yokaigodo, RDate ninteiDate, RDate fromDate, RDate toDate) {

            div.getTxtYokaigodo().setValue(yokaigodo);
            div.getTxtNinteiDate().setValue(ninteiDate);
            div.getTxtNinteiYukokikan().setFromValue(fromDate);
            div.getTxtNinteiYukokikan().setToValue(toDate);
        }
    }

    /**
     * HihokenshaShujiiDivへの操作をまとめたクラスです。
     */
    private static final class HihokenshaShujii {

        private HihokenshaShujii() {
        }

        /**
         * 前回の主治医を貼り付けます。
         *
         * @param div HihokenshaShujiiDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onClick_btnToCopyLatestShujii(HihokenshaShujiiDiv div, dgSearchResult_Row hihokensha) {
            _setUpItems(div, new RString("1"), new RString("長野病院"), new RString("1"), new RString("石野 鑑"));
        }

        private static void _setUpItems(HihokenshaShujiiDiv div,
                RString iryoKikanCode, RString iryoKikanName, RString shujiiCode, RString shujiiName) {
            div.getTxtIryokikanCode().setValue(iryoKikanCode);
            div.getTxtIryokikanName().setValue(iryoKikanName);
            div.getTxtShujiiCode().setValue(shujiiCode);
            div.getTxtShujiiName().setValue(shujiiName);
        }
    }

    /**
     * NinteichosainAdvanceEntryDivへの操作をまとめたクラスです。
     */
    private static final class NinteichosainAdvanceEntry {

        private NinteichosainAdvanceEntry() {
        }

        /**
         * 前回の認定調査委託先を貼り付けます。
         *
         * @param div NinteichosainAdvanceEntryDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onClick_btnToCopyLatestItakusaki(NinteichosainAdvanceEntryDiv div, dgSearchResult_Row hihokensha) {
            _setUpChosaItankusai(div, new RString("7"), new RString("認定調査委託先α"));
        }

        /**
         * 前回の認定調査員を貼り付けます。
         *
         * @param div NinteichosainAdvanceEntryDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onClick_btnToCopyLatestNinteichosain(NinteichosainAdvanceEntryDiv div, dgSearchResult_Row hihokensha) {
            _setUpChosain(div, new RString("1"), new RString("前野 仁"));
        }

        private static void _setUpChosaItankusai(NinteichosainAdvanceEntryDiv div, RString chosaItakusakiCode, RString chosaItakusakiName) {
            div.getTxtChosaItakusakiCode().setValue(chosaItakusakiCode);
            div.getTxtChosaItakusakiName().setValue(chosaItakusakiName);
        }

        private static void _setUpChosain(NinteichosainAdvanceEntryDiv div, RString ninteichosainCode, RString ninteichosainName) {
            div.getTxtNinteichosainCode().setValue(ninteichosainCode);
            div.getTxtNinteichosainName().setValue(ninteichosainName);
        }
    }

    /**
     * N2HihokenshaDivへの操作をまとめたクラスです。
     */
    private static final class N2Hihokensha {

        private N2Hihokensha() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div N2HihokenshaDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onLoad(N2HihokenshaDiv div, dgSearchResult_Row hihokensha) {
            _onLoad_demo(div, hihokensha);
        }

        private static void _onLoad_demo(N2HihokenshaDiv div, dgSearchResult_Row hihokensha) {
            ForDemo.HihokenshaKubun hihoKubun = ForDemo.HihokenshaKubun.toValue(hihokensha.getHihokenshaKubun());
            System.out.println(hihokensha.getHihokenshaKubun());
            if (hihoKubun != ForDemo.HihokenshaKubun.第2号被保険者) {
                div.setDisplayNone(true);
            } else {
                div.setDisplayNone(false);
            }
        }
    }

    private static final class NyuinNyusho {

        private NyuinNyusho() {
        }

        public static void onLoad(NyuinNyushoDiv div, dgSearchResult_Row hihokensha) {
            ShisetsuRereki.onLoad(div.getShisetsuRereki(), hihokensha);
        }

        /**
         * ShisetsuRerekiDivへの操作をまとめたクラスです。
         */
        private static final class ShisetsuRereki {

            private ShisetsuRereki() {
            }

            /**
             * ロード時の処理です。
             *
             * @param div ShisetsuRerekiDiv
             * @param hihokensha dgSearchResult_Row
             */
            public static void onLoad(ShisetsuRerekiDiv div, dgSearchResult_Row hihokensha) {
                _onLoad_demo(div);
            }

            private static void _onLoad_demo(ShisetsuRerekiDiv div) {
                List<dgShisetsuRereki_Row> dataSource = new ArrayList<>();
                dataSource.add(createDgShisetsuRereki(new RString("入所施設A"), new RDate("20130301"), new RDate("20130630")));
                div.getDgShisetsuRereki().setDataSource(dataSource);
            }

            private static dgShisetsuRereki_Row createDgShisetsuRereki(RString name, RDate startDate, RDate endDate) {
                TextBoxDate ForStartDate = new TextBoxDate();
                ForStartDate.setValue(startDate);
                TextBoxDate ForEndDate = new TextBoxDate();
                ForEndDate.setValue(endDate);
                return new dgShisetsuRereki_Row(new Button(), name, ForStartDate, ForEndDate);
            }
        }
    }

    /**
     * KankeiIinDivへの操作をまとめたクラスです。
     */
    private static final class KankeiIin {

        private KankeiIin() {
        }

        /**
         * ロード時の処理です。
         *
         * @param div KankeiIinDiv
         * @param hihokensha dgSearchResult_Row
         */
        public static void onLoad(KankeiIinDiv div, dgSearchResult_Row hihokensha) {
            _onLoad_demo(div);
        }

        private static void _onLoad_demo(KankeiIinDiv div) {
            List<dgKankeiIin_Row> dataSource = new ArrayList<>();
            dataSource.add(createDgKankeiIin_Row(new RString("00000001"), new RString("新坂井 太郎"), new RString("所属機関B")));
            div.getDgKankeiIin().setDataSource(dataSource);
        }

        private static dgKankeiIin_Row createDgKankeiIin_Row(RString code, RString name, RString shozokuKikan) {
            return new dgKankeiIin_Row(new Button(), code, name, shozokuKikan);
        }
    }
}
