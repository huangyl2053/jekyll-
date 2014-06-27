/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoninteiShinseiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoninteiShinseishaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData.Chosain;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiData.Doctor;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaShujiiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KankeiIinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.LatestNinteiResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.N2HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseiJigyoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinseishaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosainAdvanceEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuinNyushoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShichosonRenrakuJikoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinseiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgKankeiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShisetsuRereki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

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
        //三浦 onLoadが遅いのでいったんやめます。
        //new ShinseiJohoInputPanels(div).onLoad();
        return onStart(div, searchResult);
    }

    /**
     * onStart
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onStart(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        dgSearchResult_Row hihokensha = clickedItemOf(searchResult);
        new ShinseiJohoInputPanels(div).init(hihokensha);
        return createResponseData(div);
    }

    /**
     * 申請者区分の変更によって、divの画面項目を編集します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onChange_radShinseishaKubun(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        new NinteiShinseisha(div).onChange_radShinseishaKubun(clickedItemOf(searchResult));
        return createResponseData(div);
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
        new HihokenshaShujii(div).onClick_btnToCopyLatestShujii(clickedItemOf(searchResult));
        return createResponseData(div);
    }

    /**
     * 前回の認定調査委託先を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param searchResult HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestItakusaki(ShinseiJohoInputDiv div, HihokenshaSearchForShinseiDiv searchResult) {
        new NinteichosainAdvanceEntry(div).onClick_btnToCopyLatestItakusaki(clickedItemOf(searchResult));
        return createResponseData(div);
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
        new NinteichosainAdvanceEntry(div).onClick_btnToCopyLatestNinteichosain(clickedItemOf(searchResult));
        return createResponseData(div);
    }

    private ResponseData<ShinseiJohoInputDiv> createResponseData(ShinseiJohoInputDiv div) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private interface IPanelAdapter {

        void onLoad();

        void init(dgSearchResult_Row hihokensha);

        void clear();
    }

    private static final class ShinseiJohoInputPanels implements IPanelAdapter {

        private final ShinseiJohoInputDiv div;
        private final List<IPanelAdapter> panelList;

        private ShinseiJohoInputPanels(ShinseiJohoInputDiv div) {
            this.div = div;
            panelList = new ArrayList<>();
            panelList.add(new HihokenshaOutline(div));
            panelList.add(new NinteiShinseisha(div));
            panelList.add(new LatestNinteiResult(div));
            panelList.add(new HihokenshaShujii(div));
            panelList.add(new NinteichosainAdvanceEntry(div));
            panelList.add(new N2Hihokensha(div));
            panelList.add(new NyuinNyusho(div));
            panelList.add(new ShichosonRenrakuJiko(div));
            panelList.add(new KankeiIin(div));
        }

        @Override
        public void onLoad() {
            _onLoad();
            for (IPanelAdapter editor : panelList) {
                editor.onLoad();
            }
        }

        private void _onLoad() {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            dataSource.add(new KeyValueDataSource(YokaigoninteiShinseiKubun.新規申請.getCode(),
                    YokaigoninteiShinseiKubun.新規申請.toRString()));
            dataSource.add(new KeyValueDataSource(YokaigoninteiShinseiKubun.更新申請.getCode(),
                    YokaigoninteiShinseiKubun.更新申請.toRString()));
            div.getDdlShinseiKubunShinseiji().setDataSource(dataSource);
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            _init();
            for (IPanelAdapter editor : panelList) {
                editor.init(hihokensha);
            }
        }

        private void _init() {
            div.getChkEnkitsuchiHakko().setSelectedItems(Collections.EMPTY_LIST);
            div.getChkJohoteikyo().setSelectedItems(Collections.EMPTY_LIST);
        }

        @Override
        public void clear() {
            for (IPanelAdapter editor : panelList) {
                editor.clear();
            }
        }
    }

    /**
     * HihokenshaOutlineDivへの操作をまとめたクラスです。
     */
    private static final class HihokenshaOutline implements IPanelAdapter {

        private final HihokenshaOutlineDiv panel;

        private HihokenshaOutline(ShinseiJohoInputDiv div) {
            this.panel = div.getHihokenshaOutline();
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            panel.getTxtHihokenshaNo().setValue(hihokensha.getHihokenshaNo());
            panel.getTxtHihokenshaKubun().setValue(hihokensha.getHihokenshaKubun());
            panel.getTxtShimei().setValue(hihokensha.getShimei());
        }

        @Override
        public void clear() {
            panel.getTxtHihokenshaKubun().clearValue();
            panel.getTxtHihokenshaNo().clearValue();
            panel.getTxtShimei().clearValue();
        }

    }

    /**
     * NinteiShinseishaDivへの操作をまとめたクラスです。
     */
    private static final class NinteiShinseisha implements IPanelAdapter {

        private final NinteiShinseishaDiv div;
        private final NinteiShinseiJigyosha jigyosha;

        public NinteiShinseisha(ShinseiJohoInputDiv div) {
            this.div = div.getNinteiShinseisha();
            this.jigyosha = new NinteiShinseiJigyosha(div);
        }

        @Override
        public void onLoad() {
            _onLoad();
            this.jigyosha.onLoad();
        }

        private void _onLoad() {
            div.getRadShinseishaKubun().setDataSource(createDataSourceForRadShinseishaKubun());
        }

        private List<KeyValueDataSource> createDataSourceForRadShinseishaKubun() {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (YokaigoninteiShinseishaKubun kubun : YokaigoninteiShinseishaKubun.values()) {
                dataSource.add(new KeyValueDataSource(kubun.getCode(), kubun.toRString()));
            }
            return dataSource;
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            this._init(hihokensha);
            this.jigyosha.init(hihokensha);
        }

        private void _init(dgSearchResult_Row hihokensha) {
            div.getRadShinseishaKubun().setSelectedItem(YokaigoninteiShinseishaKubun.本人.getCode());
            _onChange_radShinseishaKubun(hihokensha);
        }

        /**
         * 内包する編集可能なUI部品への設定値をクリアします。
         */
        @Override
        public void clear() {
            _clear();
            this.jigyosha.clear();
        }

        public void _clear() {
            div.getTxtShinseishaJusho().clearValue();
            div.getTxtShinseishaName().clearValue();
            div.getTxtShinseishaNameKana().clearValue();
            div.getTxtShinseishaTelNo().clearValue();
            div.getTxtYubinNo().clearValue();
        }

        /**
         * radShinseishaKubunの選択値が変化したときの処理です。
         *
         * @param hihokensha gSearchResult_Row
         */
        public void onChange_radShinseishaKubun(dgSearchResult_Row hihokensha) {
            _onChange_radShinseishaKubun(hihokensha);
        }

        public void _onChange_radShinseishaKubun(dgSearchResult_Row hihokensha) {
            RadioButton shinseishaKubun = div.getRadShinseishaKubun();
            RString key = shinseishaKubun.getSelectedItem();
            YokaigoninteiShinseishaKubun shinseisha = _toYokaigoninteiShinseishaKubun(key);
            switch (shinseisha) {
                case 本人:
                    _onChange_radShinseishaKubun_本人(hihokensha);
                    break;
                case 家族:
                    _onChange_radShinseishaKubun_家族(hihokensha);
                    break;
                case 施設職員:
                    _onChange_radShinseishaKubun_施設職員();
                    break;
                default:
                    _onChange_radShinseishaKubun_その他();
                    break;
            }
        }

        private YokaigoninteiShinseishaKubun _toYokaigoninteiShinseishaKubun(RString key) {
            return YokaigoninteiShinseishaKubun.toValue(key);
        }

        private void _onChange_radShinseishaKubun_本人(dgSearchResult_Row hihokensha) {
            _setUpItems(hihokensha.getShimei(), hihokensha.getKanaShimsei(),
                    new YubinNo(hihokensha.getYubinNo()), hihokensha.getJusho(), false, false);
            div.getDdlShinseishaTsuzukigara().setDataSource(Tsudukigara.toDataSources());
            div.getDdlShinseishaTsuzukigara().setSelectedItem(Tsudukigara.本人.code());
        }

        private void _onChange_radShinseishaKubun_家族(dgSearchResult_Row hihokensha) {
            _setUpItems(RString.EMPTY, RString.EMPTY,
                    new YubinNo(hihokensha.getYubinNo()), hihokensha.getJusho(), true, false);
            div.getDdlShinseishaTsuzukigara().setDataSource(Tsudukigara.toDataSourcesWithOut本人());
            div.getDdlShinseishaTsuzukigara().setSelectedItem(Tsudukigara.その他.code());
        }

        private void _onChange_radShinseishaKubun_施設職員() {
            _setUpItems(RString.EMPTY, RString.EMPTY,
                    null, RString.EMPTY, false, true);
            div.getDdlShinseishaTsuzukigara().setSelectedItem(Tsudukigara.その他.code());
        }

        private void _onChange_radShinseishaKubun_その他() {
            _setUpItems(RString.EMPTY, RString.EMPTY,
                    null, RString.EMPTY, false, false);
            div.getDdlShinseishaTsuzukigara().setSelectedItem(Tsudukigara.その他.code());
        }

        private enum Tsudukigara {

            本人("1"), その他("10");
            private final RString theCode;
            private final RString theValue;

            private Tsudukigara(String code) {
                this.theCode = new RString(code);
                this.theValue = new RString(name());
            }

            public RString code() {
                return this.theCode;
            }

            public RString value() {
                return this.theValue;
            }

            private KeyValueDataSource toKeyValueDataSouce() {
                return new KeyValueDataSource(theCode, theValue);
            }

            public static List<KeyValueDataSource> toDataSources() {
                List<KeyValueDataSource> dataSource = new ArrayList<>();
                for (Tsudukigara item : values()) {
                    dataSource.add(item.toKeyValueDataSouce());
                }
                return dataSource;
            }

            public static List<KeyValueDataSource> toDataSourcesWithOut本人() {
                List<KeyValueDataSource> dataSource = toDataSources();
                dataSource.remove(本人.ordinal());
                return dataSource;
            }
        }

        private void _setUpItems(RString name, RString kanaName,
                YubinNo yubinNo, RString jusho, boolean isFamily, boolean isJighosya) {
            div.getTxtShinseishaName().setValue(name);
            div.getTxtShinseishaNameKana().setValue(kanaName);
            div.getTxtYubinNo().setValue(yubinNo);
            div.getTxtShinseishaJusho().setValue(jusho);
            div.getDdlShinseishaTsuzukigara().setDisabled(!isFamily);
            div.getBtnSetaiin().setVisible(isFamily);
            div.getNinteiShinseiJigyosha().setVisible(isJighosya);
        }

        //<editor-fold defaultstate="collapsed" desc="jigyosha">
        /**
         * NinteiShinseiJigyoshaDvへの操作をまとめたクラスです。
         */
        private static final class NinteiShinseiJigyosha implements IPanelAdapter {

            private final NinteiShinseiJigyoshaDiv panel;

            private NinteiShinseiJigyosha(ShinseiJohoInputDiv div) {
                this.panel = div.getNinteiShinseisha().getNinteiShinseiJigyosha();
            }

            @Override
            public void clear() {
                panel.getDdlJigyoshaKubun().setSelectedItem(new RString("0"));
                panel.getTxtJigyoshaCode().clearValue();
                panel.getTxtJigyoshaName().clearValue();
            }

            @Override
            public void onLoad() {
            }

            @Override
            public void init(dgSearchResult_Row hihokensha) {
            }
        }
        //</editor-fold>
    }

    /**
     * LatestNinteiResultDivへの操作をまとめたクラスです。
     */
    private static final class LatestNinteiResult implements IPanelAdapter {

        private final LatestNinteiResultDiv div;
        private final DropDownList shiseijiKubun;
        private final HihokenshaShujiiDiv shujii;
        private final NinteichosainAdvanceEntryDiv chosain;

        public LatestNinteiResult(ShinseiJohoInputDiv div) {
            this.div = div.getLatestNinteiResult();
            this.shiseijiKubun = div.getDdlShinseiKubunShinseiji();
            this.shujii = div.getHihokenshaShujii();
            this.chosain = div.getNinteichosainAdvanceEntry();
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            _init(hihokensha);
        }

        private void _init(dgSearchResult_Row hihokensha) {
            YokaigoninteiShinseishaData.LatestNinteiResult latestResult
                    = new YokaigoninteiShinseishaData().get前回認定結果(hihokensha.getHihokenshaNo());
            _setUp(latestResult.yokaigodo().toRString(), latestResult.ninteiDate(),
                    latestResult.yukoKikan().getFrom(), latestResult.yukoKikan().getTo());
            if (FlexibleDate.EMPTY.equals(latestResult.ninteiDate())) {
                setDisplayNone(true);
                this.shiseijiKubun.setSelectedItem(YokaigoninteiShinseiKubun.新規申請.getCode());
                setDisplayNone_buttons_toCopyLatest(true);
            } else {
                setDisplayNone(false);
                this.shiseijiKubun.setSelectedItem(YokaigoninteiShinseiKubun.更新申請.getCode());
                HihokenshaShujii.setLatestValue(shujii, hihokensha.getHihokenshaNo());
                setDisplayNone_buttons_toCopyLatest(false);
            }
        }

        private void setDisplayNone_buttons_toCopyLatest(boolean displayNone) {
            this.shujii.getBtnToCopyLatestShujii().setDisplayNone(displayNone);
            this.chosain.getBtnToCopyLatestItakusaki().setDisplayNone(displayNone);
            this.chosain.getBtnToCopyLatestNinteichosain().setDisplayNone(displayNone);
        }

        /**
         * 非表示にします。
         */
        public void setDisplayNone(boolean displayNone) {
            div.setDisplayNone(displayNone);
        }

        @Override
        public void clear() {
            div.getTxtNinteiDate().clearValue();
            div.getTxtNinteiYukokikanFrom().clearValue();
            div.getTxtNinteiYukokikanTo().clearValue();
            div.getTxtYokaigodo().clearValue();
        }

        private void _setUp(RString yokaigodo, FlexibleDate ninteiDate, FlexibleDate fromDate, FlexibleDate toDate) {
            div.getTxtYokaigodo().setValue(yokaigodo);
            div.getTxtNinteiDate().setValue(ninteiDate);
            div.getTxtNinteiYukokikanFrom().setValue(fromDate);
            div.getTxtNinteiYukokikanTo().setValue(toDate);
        }

        @Override
        public void onLoad() {
        }
    }

    /**
     * HihokenshaShujiiDivへの操作をまとめたクラスです。
     */
    private static final class HihokenshaShujii implements IPanelAdapter {

        private final HihokenshaShujiiDiv div;

        private HihokenshaShujii(ShinseiJohoInputDiv div) {
            this.div = div.getHihokenshaShujii();
        }

        /**
         * 前回の主治医を貼り付けます。
         *
         * @param div HihokenshaShujiiDiv
         * @param hihokensha dgSearchResult_Row
         */
        public void onClick_btnToCopyLatestShujii(dgSearchResult_Row hihokensha) {
            setLatestValue(div, hihokensha.getHihokenshaNo());
        }

        public static void setLatestValue(HihokenshaShujiiDiv shujii, RString hihokenshaNo) {
            Doctor doctor = new YokaigoninteiShinseishaData().get前回主治医(hihokenshaNo);
            shujii.getTxtIryokikanCode().setValue(doctor.iryoKikan().code());
            shujii.getTxtIryokikanName().setValue(doctor.iryoKikan().name());
            shujii.getTxtShujiiCode().setValue(doctor.code());
            shujii.getTxtShujiiName().setValue(doctor.name());
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            div.setCanOpenAndClose(false);
        }

        @Override
        public void clear() {
            div.getTxtIryokikanCode().clearValue();
            div.getTxtIryokikanName().clearValue();
            div.getTxtShujiiCode().clearValue();
            div.getTxtShujiiName().clearValue();
        }
    }

    /**
     * NinteichosainAdvanceEntryDivへの操作をまとめたクラスです。
     */
    private static final class NinteichosainAdvanceEntry implements IPanelAdapter {

        private final NinteichosainAdvanceEntryDiv div;

        public NinteichosainAdvanceEntry(ShinseiJohoInputDiv div) {
            this.div = div.getNinteichosainAdvanceEntry();
        }

        /**
         * 前回の認定調査委託先を貼り付けます。
         *
         * @param div NinteichosainAdvanceEntryDiv
         * @param hihokensha dgSearchResult_Row
         */
        public void onClick_btnToCopyLatestItakusaki(dgSearchResult_Row hihokensha) {
            Chosain chosain = new YokaigoninteiShinseishaData().get前回調査員(hihokensha.getHihokenshaNo());
            _setUpChosaItankusai(chosain.itakusaki().code(), chosain.itakusaki().name());
        }

        private void _setUpChosaItankusai(RString chosaItakusakiCode, RString chosaItakusakiName) {
            div.getTxtChosaItakusakiCode().setValue(chosaItakusakiCode);
            div.getTxtChosaItakusakiName().setValue(chosaItakusakiName);
        }

        /**
         * 前回の認定調査員を貼り付けます。
         *
         * @param div NinteichosainAdvanceEntryDiv
         * @param hihokensha dgSearchResult_Row
         */
        public void onClick_btnToCopyLatestNinteichosain(dgSearchResult_Row hihokensha) {
            Chosain chosain = new YokaigoninteiShinseishaData().get前回調査員(hihokensha.getHihokenshaNo());
            _setUpChosain(chosain.code(), chosain.name());
        }

        private void _setUpChosain(RString ninteichosainCode, RString ninteichosainName) {
            div.getTxtNinteichosainCode().setValue(ninteichosainCode);
            div.getTxtNinteichosainName().setValue(ninteichosainName);
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            div.setIsOpen(false);
        }

        @Override
        public void clear() {
            div.getTxtChosaItakusakiCode().clearValue();
            div.getTxtChosaItakusakiName().clearValue();
            div.getTxtNinteichosainCode().clearValue();
            div.getTxtNinteichosainName().clearValue();
        }
    }

    /**
     * N2HihokenshaDivへの操作をまとめたクラスです。
     */
    private static final class N2Hihokensha implements IPanelAdapter {

        private final N2HihokenshaDiv div;

        public N2Hihokensha(ShinseiJohoInputDiv div) {
            this.div = div.getN2Hihokensha();
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            set表示Or非表示(div, hihokensha);
        }

        private void set表示Or非表示(N2HihokenshaDiv div, dgSearchResult_Row hihokensha) {
            if (hihokensha.getHihokenshaKubun().contains("2")) {
                div.setDisplayNone(false);
            } else {
                div.setDisplayNone(true);
            }
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void clear() {
            div.getIryohokensha().getDdlIryohokenType().setSelectedItem(new RString("1"));
            div.getIryohokensha().getTxtIryohokenBango().clearValue();
            div.getIryohokensha().getTxtIryohokenKigo().clearValue();
            div.getIryohokensha().getTxtIryohokenshaName().clearValue();
            div.getIryohokensha().getTxtIryohokenshaNo().clearValue();
            div.getTxtTokuteiShippei().clearValue();
        }
    }

    /**
     * NyuinNyushoDivへの操作をまとめたクラスです。
     */
    private static final class NyuinNyusho implements IPanelAdapter {

        private final NyuinNyushoDiv div;

        private NyuinNyusho(ShinseiJohoInputDiv div) {
            this.div = div.getNyuinNyusho();
        }

        @Override
        public void onLoad() {
            //this.shisetsuRireki.onLoad();
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            _init();
        }

        private void _init() {
            List<dgShisetsuRereki_Row> dataSource = new ArrayList<>();
            dataSource.add(createDgShisetsuRereki(
                    new RString("入所施設A"),
                    new FlexibleDate("20130301"),
                    new FlexibleDate("20130630")));
            div.getDgShisetsuRereki().setDataSource(dataSource);
            div.setIsOpen(false);
        }

        private static dgShisetsuRereki_Row createDgShisetsuRereki(RString name, FlexibleDate startDate, FlexibleDate endDate) {
            TextBoxFlexibleDate forStartDate = new TextBoxFlexibleDate();
            forStartDate.setValue(startDate);
            TextBoxFlexibleDate forEndDate = new TextBoxFlexibleDate();
            forEndDate.setValue(endDate);
            return new dgShisetsuRereki_Row(new Button(), name, forStartDate, forEndDate);
        }

        @Override
        public void clear() {
            div.getDgShisetsuRereki().setDataSource(Collections.EMPTY_LIST);
        }
    }

    private static final class ShichosonRenrakuJiko implements IPanelAdapter {

        ShichosonRenrakuJikoDiv div;

        ShichosonRenrakuJiko(ShinseiJohoInputDiv shiseiJohoDiv) {
            this.div = shiseiJohoDiv.getShichosonRenrakuJiko();
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            div.setIsOpen(false);
        }

        @Override
        public void clear() {
            div.getTxtShichosonRenrakuJiko().clearValue();
        }

    }

    /**
     * KankeiIinDivへの操作をまとめたクラスです。
     */
    private static final class KankeiIin implements IPanelAdapter {

        private final KankeiIinDiv div;

        public KankeiIin(ShinseiJohoInputDiv div) {
            this.div = div.getKankeiIin();
        }

        private dgKankeiIin_Row createDgKankeiIin_Row(RString code, RString name, RString shozokuKikan) {
            return new dgKankeiIin_Row(new Button(), code, name, shozokuKikan);
        }

        @Override
        public void onLoad() {
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            _init();
            div.setIsOpen(false);
        }

        private void _init() {
            List<dgKankeiIin_Row> dataSource = new ArrayList<>();
            dataSource.add(createDgKankeiIin_Row(new RString("00000001"), new RString("審査会 太郎"), new RString("所属機関B")));
            div.getDgKankeiIin().setDataSource(dataSource);
        }

        @Override
        public void clear() {
            div.getDgKankeiIin().setDataSource(Collections.EMPTY_LIST);
        }
    }
}
