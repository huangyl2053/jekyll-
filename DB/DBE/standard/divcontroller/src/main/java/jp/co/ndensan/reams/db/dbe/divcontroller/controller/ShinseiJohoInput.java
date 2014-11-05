/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJohoValidate;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinKoza;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinShikaku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiShinseiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiShinseishaKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData.Chosain;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiData.Doctor;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.EditShinsakaiIinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.HihokenshaShujiiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.KankeiIinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.LatestNinteiResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.N2HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.NinteiShinseiJigyoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.NinteiShinseishaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.NinteichosainAdvanceEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.NyuinNyushoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.ShichosonRenrakuJikoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.ShinseiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.dgKankeiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.dgShisetsuRereki_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.SinseiRiyuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.mapper.YokaigoNinteiShinseiDivMapper;
import jp.co.ndensan.reams.db.dbe.realservice.JogaiShinsakaiIinManager;
import jp.co.ndensan.reams.db.dbe.realservice.YokaigoNinteiShinseiManager;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.TeikeibunKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.TeikeibunShubetsuElseTokki;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

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
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onLoad(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        //三浦 onLoadが遅いのでいったんやめます。
        //new ShinseiJohoInputPanels(div).onLoad();
        new ShinseiJohoInputPanels(div).onLoad();
        return createResponseData(div);
    }

    /**
     * onStart
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onStart(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
//        dgSearchResult_Row hihokensha = clickedItemOf();
//        new ShinseiJohoInputPanels(div).init(hihokensha);
        return createResponseData(div);
    }

    /**
     * 申請者区分の変更によって、divの画面項目を編集します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onChange_radShinseishaKubun(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new NinteiShinseisha(div).onChange_radShinseishaKubun(clickedItem());
        return createResponseData(div);
    }

    private dgSearchResult_Row clickedItem() {
        return YokaigoNinteiShinseisha.getInstance().get();
    }

    /**
     * 前回の主治医を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestShujii(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new HihokenshaShujii(div).onClick_btnToCopyLatestShujii(clickedItem());
        return createResponseData(div);
    }

    /**
     * 前回の認定調査委託先を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestItakusaki(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new NinteichosainAdvanceEntry(div).onClick_btnToCopyLatestItakusaki(clickedItem());
        return createResponseData(div);
    }

    /**
     * 前回の認定調査員を転写します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToCopyLatestNinteichosain(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new NinteichosainAdvanceEntry(div).onClick_btnToCopyLatestNinteichosain(clickedItem());
        return createResponseData(div);
    }

    /**
     * バリデーションをします
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnValidation(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        return validate(div);
    }

    /**
     * 申請情報を保存します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnCommonSaveShinsei(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        ResponseData<ShinseiJohoInputDiv> response = createResponseData(div);
        //      try {
        new YokaigoNinteiShinseiManager().save(YokaigoNinteiShinseiDivMapper.toYokaigoNinteiShinsei(
                new YokaigoNinteiShinseiDivMapper.YokaigoNinteiShinseiDiv(div, hihokenshaDiv)));

        new KankeiIin(div).save();
//        } catch (Throwable e) {
//            response.addMessage(new InformationMessage("", e.getMessage()));
//        }
        return response;
    }

    /**
     * 申請者に関係する除外審査会委員の情報について、追加、修正、削除情報を確定します。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnDecideJogaiIin(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new KankeiIin(div).onClick_btnDecideJogaiIin();
        return createResponseData(div);
    }

    /**
     * 関係委員gridに対する追加ボタンを押した際に、gridに情報を追加する準備を行います。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onClick_btnToAddKankeiIin(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new KankeiIin(div).onClick_btnToAddKankeiIin();
        return createResponseData(div);
    }

    /**
     * 関係委員grid内の修正ボタンを押した際に、gridの情報を修正する準備を行います。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onSelectByModifyButton_dgKankeiIin(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new KankeiIin(div).onSelectByModifyButton_dgKankeiIin();
        return createResponseData(div);
    }

    /**
     * 関係委員grid内の削除ボタンを押した際に、gridの情報を削除する準備を行います。
     *
     * @param div ShinseiJohoInputDiv
     * @param hihokenshaDiv HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoInputDiv> onSelectByDeleteButton_dgKankeiIin(ShinseiJohoInputDiv div, HihokenshaOutlineDiv hihokenshaDiv) {
        new KankeiIin(div).onSelectByDeleteButton_dgKankeiIin();
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
            panelList.add(new NinteiShinseisha(div));
            panelList.add(new LatestNinteiResult(div));
            panelList.add(new HihokenshaShujii(div));
            panelList.add(new NinteichosainAdvanceEntry(div));
            panelList.add(new N2Hihokensha(div));
            panelList.add(new NyuinNyusho(div));
            panelList.add(new ShichosonRenrakuJiko(div));
            panelList.add(new KankeiIin(div));
            panelList.add(new SinseiRiyu(div));
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
            dataSource.add(new KeyValueDataSource(YokaigoNinteiShinseiKubun.新規申請.getCode(),
                    YokaigoNinteiShinseiKubun.新規申請.toRString()));
            dataSource.add(new KeyValueDataSource(YokaigoNinteiShinseiKubun.更新申請.getCode(),
                    YokaigoNinteiShinseiKubun.更新申請.toRString()));
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
     * Stashed changes NinteiShinseishaDivへの操作をまとめたクラスです。
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
            for (YokaigoNinteiShinseishaKubun kubun : YokaigoNinteiShinseishaKubun.values()) {
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
            div.getRadShinseishaKubun().setSelectedItem(YokaigoNinteiShinseishaKubun.本人.getCode());
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
            YokaigoNinteiShinseishaKubun shinseisha = _toYokaigoninteiShinseishaKubun(key);
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

        private YokaigoNinteiShinseishaKubun _toYokaigoninteiShinseishaKubun(RString key) {
            return YokaigoNinteiShinseishaKubun.toValue(key);
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
            div.getNinteiShinseiJigyosha().setDisabled(!isJighosya);
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
                this.shiseijiKubun.setSelectedItem(YokaigoNinteiShinseiKubun.新規申請.getCode());
                setDisplayNone_buttons_toCopyLatest(true);
            } else {
                setDisplayNone(false);
                this.shiseijiKubun.setSelectedItem(YokaigoNinteiShinseiKubun.更新申請.getCode());
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
            div.getDdltTokuteiShippei().setSelectedItem(new RString("00"));
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

        //TODO n8178 城間篤人 固定値で必要な項目を用意。本来は基本情報から取得すべきで、修正が必要 2014年9月
        private final ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(new RString("012345"));
        private final HihokenshaNo kaigoHihokenshaNo = new HihokenshaNo(new RString("0123456789"));

        private enum KankeiIinDecideFlag {

            ADD("add"), MODIFY("update"), DELETE("delete"), NOT_SELECTED("notSelected");
            private final RString flagText;

            private KankeiIinDecideFlag(String flagText) {
                this.flagText = new RString(flagText);
            }

            public RString getFlagText() {
                return flagText;
            }
        }

        public KankeiIin(ShinseiJohoInputDiv div) {
            this.div = div.getKankeiIin();
        }

        private dgKankeiIin_Row createDgKankeiIin_Row(RString code, RString name, RString shozokuKikan) {
            return createDgKankeiIin_Row(code, name, shozokuKikan, RString.EMPTY, new Decimal(1));
        }

        private dgKankeiIin_Row createDgKankeiIin_Row(RString code, RString name, RString shozokuKikanCode,
                RString shozokuKikanMeisho, Decimal kanriNo) {
            dgKankeiIin_Row row = new dgKankeiIin_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, new TextBoxNum());
            row.setCode(code);
            row.setName(name);
            row.setShozokuKikanCode(shozokuKikanCode);
            row.setShozokuKikanMeisho(shozokuKikanMeisho);
            row.setShozokuKikan(row.getShozokuKikanCode().concat(":").concat(row.getShozokuKikanMeisho()));
            row.getKanriNo().setValue(kanriNo);
            return row;
        }

        @Override
        public void onLoad() {

            JogaiShinsakaiIinManager jogaiShinsakaiIinManager = new JogaiShinsakaiIinManager();
            JogaiShinsakaiIinList jogaiIinList = jogaiShinsakaiIinManager.get除外審査会委員List(shoKisaiHokenshaNo, kaigoHihokenshaNo);

            List<dgKankeiIin_Row> dataSource = new ArrayList<>();
            for (JogaiShinsakaiIin jogaiIin : jogaiIinList) {
                dataSource.add(
                        createDgKankeiIin_Row(jogaiIin.get除外対象審査会委員().get審査会委員コード().value(),
                                jogaiIin.get除外対象審査会委員().get氏名().getColumnValue(),
                                jogaiIin.get除外対象審査会委員().get事業者番号().value(),
                                new RString("電算介護支援協会"),
                                new Decimal(jogaiIin.get管理番号()))
                );
            }
            div.getDgKankeiIin().setDataSource(dataSource);

            this.div.setDecideFlag(KankeiIinDecideFlag.NOT_SELECTED.getFlagText());
            div.getEditShinsakaiIin().setDisabled(true);
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

        /**
         * 追加ボタンを押した際に、gridに情報を追加する準備を行います。
         */
        public void onClick_btnToAddKankeiIin() {
            div.setDecideFlag(KankeiIinDecideFlag.ADD.getFlagText());

            div.getEditShinsakaiIin().setTitle(new RString("関係審査会委員追加"));
            div.getEditShinsakaiIin().setDisabled(false);
        }

        /**
         * グリッド内の修正ボタンを押した際に、gridの情報を修正する準備を行います。
         */
        public void onSelectByModifyButton_dgKankeiIin() {
            div.setDecideFlag(KankeiIinDecideFlag.MODIFY.getFlagText());
            dgKankeiIin_Row row = div.getDgKankeiIin().getSelectedItems().get(0);
            setEditShinsakaiIinDiv(div.getEditShinsakaiIin(), row);

            div.getEditShinsakaiIin().setTitle(new RString("関係審査会委員修正"));
            div.getEditShinsakaiIin().setDisabled(false);
        }

        /**
         * グリッド内の削除ボタンを押した際に、gridの情報を削除する準備を行います。
         */
        public void onSelectByDeleteButton_dgKankeiIin() {
            div.setDecideFlag(KankeiIinDecideFlag.DELETE.getFlagText());
            dgKankeiIin_Row row = div.getDgKankeiIin().getSelectedItems().get(0);
            setEditShinsakaiIinDiv(div.getEditShinsakaiIin(), row);

            div.getEditShinsakaiIin().setTitle(new RString("関係審査会委員削除"));
            div.getEditShinsakaiIin().getTxtKankeiIinCode().setReadOnly(true);
            div.getEditShinsakaiIin().setDisabled(false);
        }

        private void setEditShinsakaiIinDiv(EditShinsakaiIinDiv editDiv, dgKankeiIin_Row row) {
            editDiv.getTxtKankeiIinCode().setValue(row.getCode());
            editDiv.getTxtKankeiIinName().setValue(row.getName());
            editDiv.getTxtShozokuKikan().setValue(row.getShozokuKikanCode());
            editDiv.getTxtShozokuKikanMeisho().setValue(row.getShozokuKikanMeisho());
        }

        /**
         * 申請者に関係する除外審査会委員の情報について、追加、修正、削除情報を確定し、gridに反映します。
         */
        public void onClick_btnDecideJogaiIin() {

            if (div.getDecideFlag().equals(KankeiIinDecideFlag.ADD.getFlagText())) {
                decideAdd(div.getDgKankeiIin(), div.getEditShinsakaiIin());
            } else {
                dgKankeiIin_Row selectedRow = div.getDgKankeiIin().getSelectedItems().get(0);

                if (div.getDecideFlag().equals(KankeiIinDecideFlag.MODIFY.getFlagText())) {
                    decideUpdate(selectedRow, div.getDgKankeiIin(), div.getEditShinsakaiIin());
                } else if (div.getDecideFlag().equals(KankeiIinDecideFlag.DELETE.getFlagText())) {
                    decideDelete(selectedRow, div.getDgKankeiIin());
                }
            }

            clearEditShinsakaiIin();
        }

        private void clearEditShinsakaiIin() {
            div.getEditShinsakaiIin().getTxtKankeiIinCode().setValue(RString.EMPTY);
            div.getEditShinsakaiIin().getTxtKankeiIinName().setValue(RString.EMPTY);
            div.getEditShinsakaiIin().getTxtShozokuKikan().setValue(RString.EMPTY);
            div.getEditShinsakaiIin().getTxtShozokuKikanMeisho().setValue(RString.EMPTY);

            div.getEditShinsakaiIin().setTitle(new RString("関係審査会委員"));
            div.getEditShinsakaiIin().getTxtKankeiIinCode().setReadOnly(false);
            div.getEditShinsakaiIin().setDisabled(true);
        }

        private void decideAdd(DataGrid<dgKankeiIin_Row> grid, EditShinsakaiIinDiv editDiv) {
            //TODO n8178 城間篤人 ButtonのonBeforeClickイベントがUIデザイナ安定版で使用可能になった後、処理を移譲する。 2014年9月
            RString iinCode = editDiv.getTxtKankeiIinCode().getValue();
            for (dgKankeiIin_Row row : grid.getDataSource()) {
                if (row.getCode().equals(iinCode)) {
                    return;
                }
            }

            dgKankeiIin_Row row = createDgKankeiIin_Row(iinCode,
                    editDiv.getTxtKankeiIinName().getValue(),
                    editDiv.getTxtShozokuKikan().getValue(),
                    editDiv.getTxtShozokuKikanMeisho().getValue(),
                    new Decimal(getMaxKanriNo(grid.getDataSource()) + 1));
            row.setRowState(RowState.Added);
            grid.getDataSource().add(row);
        }

        private int getMaxKanriNo(List<dgKankeiIin_Row> dataSource) {
            int maxKanriNo = 0;
            for (dgKankeiIin_Row row : dataSource) {
                int comparisonValue = row.getKanriNo().getValue().intValue();
                if (maxKanriNo < comparisonValue) {
                    maxKanriNo = comparisonValue;
                }
            }
            return maxKanriNo;
        }

        private void decideUpdate(dgKankeiIin_Row selectedRow, DataGrid<dgKankeiIin_Row> grid, EditShinsakaiIinDiv editDiv) {
            //TODO n8178 城間篤人 ButtonのonBeforeClickイベントがUIデザイナ安定版で使用可能になった後、処理を移譲する。 2014年9月
            RString iinCode = editDiv.getTxtKankeiIinCode().getValue();
            for (dgKankeiIin_Row row : grid.getDataSource()) {
                if (row.getId() == selectedRow.getId()) {
                } else if (row.getCode().equals(iinCode)) {
                    return;
                }
            }

            selectedRow.setCode(editDiv.getTxtKankeiIinCode().getValue());
            selectedRow.setName(editDiv.getTxtKankeiIinName().getValue());
            selectedRow.setShozokuKikanCode(editDiv.getTxtShozokuKikan().getValue());
            selectedRow.setShozokuKikanMeisho(editDiv.getTxtShozokuKikanMeisho().getValue());
            selectedRow.setShozokuKikan(selectedRow.getShozokuKikanCode().concat(":").concat(selectedRow.getShozokuKikanMeisho()));
            selectedRow.setRowState(RowState.Modified);
        }

        private void decideDelete(dgKankeiIin_Row selectedRow, DataGrid<dgKankeiIin_Row> grid) {
            if (selectedRow.getRowState().equals(RowState.Added)) {
                grid.getDataSource().remove(selectedRow);
            } else {
                selectedRow.setRowState(RowState.Deleted);
            }
        }

        public void save() {
            JogaiShinsakaiIinManager manager = new JogaiShinsakaiIinManager();
            for (dgKankeiIin_Row row : div.getDgKankeiIin().getDataSource()) {

                //TODO n8178 城間篤人 後日、Div用Mapperに処理を移譲予定 2014年9月
                JogaiShinsakaiIin jogaiIin = new JogaiShinsakaiIin(shoKisaiHokenshaNo, kaigoHihokenshaNo,
                        row.getKanriNo().getValue().intValue(), create審査会委員(row.getCode().toString()));

                if (row.getRowState().equals(RowState.Added) || row.getRowState().equals(RowState.Modified)) {
                    manager.save(jogaiIin);
                } else if (row.getRowState().equals(RowState.Deleted)) {
                    manager.remove(jogaiIin);
                }
            }
        }

        //TODO n8178 城間篤人 除外審査会委員を生成するために、委員情報をDBから取得or除外情報のみで扱える形にクラスを修正のいずれかが必要。 2014年9月
        private ShinsakaiIin create審査会委員(String 委員コード) {
            return new ShinsakaiIin(new ShinsakaiIinCode(new RString(委員コード)),
                    new Range(new FlexibleDate("19800101"), FlexibleDate.MAX), ShinsakaiIinJokyo.有効,
                    new JigyoshaNo(RString.EMPTY), new AtenaMeisho("宛名名称"), new AtenaKanaMeisho("アテナカナメイショウ"),
                    Gender.MALE, new ShinsakaiIinShikaku(new Code("kubun01"), RString.EMPTY, RString.EMPTY), ShinsainYusoKubun.自宅,
                    new YubinNo("904-0000"), new AtenaJusho("住所"), new TelNo("098-000-0000"),
                    new ShinsakaiIinKoza(new KinyuKikanCode("0001"), new KinyuKikanShitenCode("011"),
                            RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY)
            );
        }
    }

    private static final class SinseiRiyu implements IPanelAdapter {

        private final SinseiRiyuDiv div;

        SinseiRiyu(ShinseiJohoInputDiv div) {
            this.div = div.getSinseiRiyu();
        }

        @Override
        public void onLoad() {
            div.setTeikeiKbn(TeikeibunKubun.特記事項以外.getCode());
            div.setTeikeiShubetsu(TeikeibunShubetsuElseTokki.申請理由.getCode());
        }

        @Override
        public void init(dgSearchResult_Row hihokensha) {
            div.setIsOpen(false);
        }

        @Override
        public void clear() {
            div.getTxtShinseiRiyu().clearValue();
        }

    }

    private ResponseData<ShinseiJohoInputDiv> validate(ShinseiJohoInputDiv div) {
        ResponseData<ShinseiJohoInputDiv> response = new ResponseData<>();
        NinteiShinseiJohoValidate validate = new NinteiShinseiJohoValidate();

//        div.getLatestNinteiResult().getTxtNinteiYukokikanTo().clearValue();                               //test用
        div.getLatestNinteiResult().getTxtNinteiYukokikanTo().setValue(new FlexibleDate("20140920"));    //test用

        if (validate.validateShinseiKbn(div.getDdlShinseiKubunShinseiji().getSelectedItem(), div.getTxtShinseiDate().getValue(),
                new RString(div.getLatestNinteiResult().getTxtNinteiYukokikanTo().getValue().toString()))) {
            response.addValidateMessage(new ErrorMessage("",
                    YokaigoNinteiShinseiKubun.更新申請.toString() + "期間前です。申請区分を"
                    + YokaigoNinteiShinseiKubun.区分変更申請.toString() + "に変更してください。"), "ddlShinseiKubunShinseiji");
        }

        //申請者が施設職員のとき
        if (div.getNinteiShinseisha().getRadShinseishaKubun().getSelectedItem().equalsIgnoreCase(
                YokaigoNinteiShinseishaKubun.施設職員.getCode())) {
            if (div.getNinteiShinseisha().getNinteiShinseiJigyosha().getTxtJigyoshaCode().getText().isEmpty()) {
                response.addValidateMessage(new ErrorMessage("", "事業者情報を入力してください。"), "txtJigyoshaCode");
            } else if (validate.validateJigyosha(div.getNinteiShinseisha().getNinteiShinseiJigyosha().getTxtJigyoshaCode().getText(),
                    div.getNinteiShinseisha().getNinteiShinseiJigyosha().getTxtJigyoshaName().getText())) {
                response.addValidateMessage(new ErrorMessage("", "事業者情報が不正です。"), "txtJigyoshaCode");
            }
        }

        if (validate.validateIryokikan(div.getHihokenshaShujii().getTxtIryokikanCode().getText(),
                div.getHihokenshaShujii().getTxtIryokikanName().getText())) {
            response.addValidateMessage(new ErrorMessage("", "医療機関情報が不正です。"), "txtIryokikanCode");
        }

        if (validate.validateShujii(div.getHihokenshaShujii().getTxtShujiiCode().getText(),
                div.getHihokenshaShujii().getTxtShujiiName().getText())) {
            response.addValidateMessage(new ErrorMessage("", "主治医情報が不正です。"), "txtShujiiCode");
        }

        //2号被保険者のときチェック
//        if (div.getN2Hihokensha().getIryohokensha().getTxtIryohokenshaNo().getText().isEmpty()){
//            response.addValidateMessage(new ErrorMessage("", "医療保険者番号を入力してください。"), "txtIryohokenshaNo");
//        }
//        if (div.getN2Hihokensha().getIryohokensha().getTxtIryohokenshaName().getText().isEmpty()){
//            response.addValidateMessage(new ErrorMessage("", "医療保険者名を入力してください。"), "txtIryohokenshaName");
//        }
//        if (div.getN2Hihokensha().getIryohokensha().getTxtIryohokenKigo().getText().isEmpty()){
//            response.addValidateMessage(new ErrorMessage("", "医療保険記号を入力してください。"), "txtIryohokenKigo");
//        }
//        if (div.getN2Hihokensha().getIryohokensha().getTxtIryohokenBango().getText().isEmpty()){
//            response.addValidateMessage(new ErrorMessage("", "医療保険番号を入力してください。"), "txtIryohokenBango");
//        }
//        if (div.getN2Hihokensha().getDdltTokuteiShippei().getSelectedItem().equalsIgnoreCase("00")){
//            response.addValidateMessage(new ErrorMessage("", "特定疾病を選択してください。"), "ddltTokuteiShippei");
//        }
        if (div.getChkEnkitsuchiHakko().getSelectedValues().isEmpty()) {
            response.addValidateMessage(new WarningMessage("", "認定延期通知を発行しないことへの同意が選択されていません。"), "chkEnkitsuchiHakko");
        }
        if (div.getChkJohoteikyo().getSelectedValues().isEmpty()) {
            response.addValidateMessage(new WarningMessage("", "認定調査/意見書/審査会へ情報提供をすることへの同意が選択されていません。"), "chkJohoteikyo");
        }

        response.data = div;
        return response;
    }
}
