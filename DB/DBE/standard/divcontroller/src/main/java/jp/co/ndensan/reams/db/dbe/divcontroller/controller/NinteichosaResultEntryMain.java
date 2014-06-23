/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kihonchosaResultInputCom.KihonchosaResultInputCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.HihokenshaForNinteichosaResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0911Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0912Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0921Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0931Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0941Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0942Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0951Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0961Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0971Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa09Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.NinteichosaDetailDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.NinteichosaResultEntryMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.ServiceJokyoServicesCountsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.ServiceJokyoTabDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.ShisakaiWaritsukeKiboDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.serviceWithCountCom.ServiceWithCountCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tokkijikoCom.TokkijikoCom;
//import jp.co.ndensan.reams.ur.urz.business.DateOfBirthFactory;
//import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.ControlRepeater;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * NinteichosaResultEntryMainDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryMain {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onLoad(NinteichosaResultEntryMainDiv div) {
        return onStart_NinteichosaResultEntryMain(div);
    }

    /**
     * NinteichosaResultEntryMainDivを表示した時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onStart_NinteichosaResultEntryMain(NinteichosaResultEntryMainDiv div) {
        dgNinteichosaResultTaishosha_Row targetInfo = targetInfo();
        new HihokenshaForNinteichosaResult(div).init(targetInfo);
        new NinteichosaDetail(div).init(targetInfo);
        new ShinsakaiWaritsukeKibo(div).init();
        new ServiceJokyoTab(div).init();
        new Kihonchosa09(div).init();
        return _createResponseData(div);
    }

    private dgNinteichosaResultTaishosha_Row targetInfo() {
        return NinteichosaResultEntryTarget.Holder.get();
    }

    /**
     * radServiceKubunを変更した時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onChange_radServiceKubun(NinteichosaResultEntryMainDiv div) {
        new ServiceJokyoTab(div).onChange_radサービス区分();
        return _createResponseData(div);
    }

    /**
     * radChosaJisshiBashoをClickした時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onChange_radChosaJisshiBasho(NinteichosaResultEntryMainDiv div) {
        new NinteichosaDetail(div).onChange_radChosaJisshiBasho();
        return _createResponseData(div);
    }

    /**
     * btnToRegisterResultをClickした時の処理です。
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onClick_btnToRegisterResult(NinteichosaResultEntryMainDiv div) {
        dgNinteichosaResultTaishosha_Row target = targetInfo();
        new NinteichosaDetail(div).reflectPanelValueTo(target);
        NinteichosaResultEntryTarget.Holder.save(target);
        return addMessage(_createResponseData(div), new InformationMessage("1", "処理は正常に終了しました。"));
    }

    /**
     *
     * @param div NinteichosaResultEntryMainDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onClick_btnAddTokkijiko(NinteichosaResultEntryMainDiv div) {
        ControlRepeater<TokkijikoCom> rep = repTokkijikoCom(div);
        rep.setRepeateData(createIncreasedRepeateData(rep));
        return _createResponseData(div);
    }

    private ControlRepeater<TokkijikoCom> repTokkijikoCom(NinteichosaResultEntryMainDiv div) {
        return div.getTabNinteichosaResult().getTokkijikoTab().getRepTokkijikoCom();
    }

    private List<TokkijikoCom> createIncreasedRepeateData(ControlRepeater<TokkijikoCom> rep) {
        List<TokkijikoCom> repeateData = rep.getRepeateData();
        TokkijikoCom newOne = new TokkijikoComFactroy(repeateData.get(0)).createTokkijikoCom();
        if (isEvenNumber(repeateData.size())) {
            newOne.setWrap(true);
        }
        repeateData.add(newOne);
        return repeateData;
    }

    private class TokkijikoComFactroy {

        private final TokkijikoCom copyOrigin;

        private TokkijikoComFactroy(TokkijikoCom com) {
            this.copyOrigin = com;
        }

        private TokkijikoCom createTokkijikoCom() {
            TokkijikoCom tokkijikoCom = new TokkijikoCom();
            tokkijikoCom.setDdlChosaItem(createDdlChosaItem());
            tokkijikoCom.setLblSpace(createLblSpace());
            tokkijikoCom.setTxtTokkijikoContent(createTxtTokkijikoContent());
            tokkijikoCom.setDisplayNone(false);
            tokkijikoCom.setDisabled(false);
            tokkijikoCom.setVisible(true);
            tokkijikoCom.setWrap(false);
            return tokkijikoCom;
        }

        private DropDownList createDdlChosaItem() {
            DropDownList sample = copyOrigin.getDdlChosaItem();
            DropDownList chosaItem = new DropDownList();
            chosaItem.setLabelLText(sample.getLabelLText());
            chosaItem.setDataSource(sample.getDataSource());
            chosaItem.setDisplayNone(sample.isDisabled());
            chosaItem.setDisabled(sample.isDisabled());
            chosaItem.setVisible(sample.isVisible());
            chosaItem.setWrap(sample.isWrap());
            return chosaItem;
        }

        private Label createLblSpace() {
            Label sample = copyOrigin.getLblSpace();
            Label space = new Label();
            space.setText(sample.getText());
            space.setDisplayNone(sample.isDisplayNone());
            space.setVisible(sample.isVisible());
            space.setWrap(sample.isWrap());
            return space;
        }

        private TextBoxMultiLine createTxtTokkijikoContent() {
            TextBoxMultiLine sample = copyOrigin.getTxtTokkijikoContent();
            TextBoxMultiLine content = new TextBoxMultiLine();
            content.setCountDisp(sample.getCountDisp());
            content.setDisplayNone(sample.isDisplayNone());
            content.setReadOnly(sample.isReadOnly());
            content.setDisabled(sample.isDisabled());
            content.setValue(RString.EMPTY);
            content.setVisible(sample.isVisible());
            content.setWrap(sample.isWrap());
            return content;
        }
    }

    private boolean isEvenNumber(int targetNum) {
        return targetNum % 2 == 0;
    }

    //<editor-fold defaultstate="collapsed" desc="HihokenshaForNinteichosaResult">
    /**
     * HihokenshaForNinteichosaResultDivを操作するためのクラスです。
     */
    private static final class HihokenshaForNinteichosaResult {

        private final HihokenshaForNinteichosaResultDiv panel;

        public HihokenshaForNinteichosaResult(NinteichosaResultEntryMainDiv main) {
            this.panel = main.getHihokenshaForNinteichosaResult();
        }

        public void init(dgNinteichosaResultTaishosha_Row targetInfo) {
            _initWithTargetInfo(targetInfo);
        }

        private void _initWithTargetInfo(dgNinteichosaResultTaishosha_Row targetInfo) {
            panel.getTxtHihokenshaNo().setValue(targetInfo.getHihokenshaNo());
            panel.getTxtShikibetsuCode().setValue(targetInfo.getShikibetsuCode());
            panel.getTxtShinseiDate().setValue(targetInfo.getShinseiDate().getValue());
            panel.getTxtShinseiKubun().setValue(targetInfo.getShinseiKubun());
            panel.getTxtHihokenshaName().setValue(targetInfo.getShimei());
            panel.getTxtHihokenshaGender().setValue(targetInfo.getGender());
            panel.getTxtHihokenshaYubinNo().setValue(targetInfo.getYubinNo());
            panel.getTxtHihokenshaJusho().setValue(targetInfo.getJusho());
            panel.getTxtHihokenshaBirthDay().setValue(targetInfo.getBirthDay().getValue());
//            IDateOfBirth birthDay = DateOfBirthFactory.createInstance(targetInfo.getBirthDay().getValue());
//            panel.getTxtHihokenshaAge().setValue(new RString(Integer.toString(birthDay.get年齢())));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="NinteichosaDetail">
    /**
     * NinteichosaDetailDivを操作するためのクラスです。
     */
    private static class NinteichosaDetail {

        private final NinteichosaDetailDiv panel;

        public NinteichosaDetail(NinteichosaResultEntryMainDiv main) {
            this.panel = main.getNinteichosaDetail();
        }

        public void onLoad() {
            //_onLoad_radChosaJisshiBasho();
        }

        public void init(dgNinteichosaResultTaishosha_Row targetInfo) {
            _init_ChosaItakusakiAndChosain(targetInfo);
            _init_ChosaJisshiBasho(targetInfo);
            _init_ChosaJisshiDate(targetInfo);
        }

        private void _init_ChosaItakusakiAndChosain(dgNinteichosaResultTaishosha_Row targetInfo) {
            _txtChosainCode().setValue(targetInfo.getChosainCode());
            _txtChosainName().setValue(targetInfo.getChosainName());
            _txtChosaItakusakiCode().setValue(targetInfo.getChosaItakusakiCode());
            _txtChosaItakusakiName().setValue(targetInfo.getChosaItakusakiName());
        }

        private TextBoxCode _txtChosainCode() {
            return this.panel.getTxtChosainCode();
        }

        private TextBox _txtChosainName() {
            return this.panel.getTxtChosainName();
        }

        private TextBoxCode _txtChosaItakusakiCode() {
            return this.panel.getTxtChosaItakusakiCode();
        }

        private TextBox _txtChosaItakusakiName() {
            return this.panel.getTxtChosaItakusakiName();
        }

        private void _init_ChosaJisshiBasho(dgNinteichosaResultTaishosha_Row targetInfo) {
            ChosaJisshiBasho place;
            place = ChosaJisshiBasho.toValue(maybeRString(targetInfo.getChosaJisshiBashoType()).substring(0, 1));
            _radChosaJisshiBasho().setSelectedItem(place.item());
            if (place != ChosaJisshiBasho.その他) {
                _txtChosaJisshiBashoFreeInput().clearValue();
            } else {
                _txtChosaJisshiBashoFreeInput().setValue(targetInfo.getChosaJisshiBashoOther());
            }
            _setDisable_txtChosaJisshiBashoFreeInput_when_調査実施場所(_is_not_その他());
        }

        private void _init_ChosaJisshiDate(dgNinteichosaResultTaishosha_Row targetInfo) {
            _txtChosaJisshiDate().setValue(targetInfo.getChosaJisshiDate().getValue());
        }

        private TextBox _txtChosaJisshiBashoFreeInput() {
            return this.panel.getTxtChosaJisshiBashoFreeInput();
        }

        private TextBoxFlexibleDate _txtChosaJisshiDate() {
            return this.panel.getTxtChosaJisshiDate();
        }

        private RString maybeRString(RString rstr) {
            if ((rstr == null) || (rstr.length() == 0)) {
                return ChosaJisshiBasho.自宅.item();
            }
            return rstr;
        }

        /**
         * radChosaJisshiBasho
         *
         * @return radChosaJisshiBasho
         */
        private RadioButton _radChosaJisshiBasho() {
            return this.panel.getRadChosaJisshiBasho();
        }

        //<editor-fold defaultstate="collapsed" desc="ChosaJisshiBasho">
        enum ChosaJisshiBasho {

            自宅("1"),
            自宅外("2"),
            その他("9");
            private final RString theKey;
            private final RString theValue;
            private final RString theValueWithCode;

            private ChosaJisshiBasho(String key) {
                this.theKey = new RString(key);
                this.theValue = new RString(name());
                this.theValueWithCode = new RString(theKey + ":" + theValue);
            }

            public RString item() {
                return this.theKey;
            }

            public RString value() {
                return this.theValue;
            }

            public RString valueWithCode() {
                return this.theValueWithCode;
            }

            public KeyValueDataSource toKeyValueDataSource() {
                return new KeyValueDataSource(theKey, theValue);
            }

            public static List<KeyValueDataSource> toDataSource() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (ChosaJisshiBasho place : values()) {
                    list.add(place.toKeyValueDataSource());
                }
                return list;
            }

            public static ChosaJisshiBasho toValue(RString key) {
                for (ChosaJisshiBasho place : values()) {
                    if (place.theKey.equals(key)) {
                        return place;
                    }
                }
                return その他;

            }
        }

        //</editor-fold>
        public void onChange_radChosaJisshiBasho() {
            _setDisable_txtChosaJisshiBashoFreeInput_when_調査実施場所(_is_not_その他());
        }

//        private void _onLoad_radChosaJisshiBasho() {
//            _radChosaJisshiBasho().setDataSource(ChosaJisshiBasho.toDataSource());
//        }
        private void _setDisable_txtChosaJisshiBashoFreeInput_when_調査実施場所(boolean is_not_その他) {
            _txtChosaJisshiBashoFreeInput().setDisabled(is_not_その他);
        }

        private boolean _is_not_その他() {
            return !ChosaJisshiBasho.その他.item().equals(_radChosaJisshiBasho().getSelectedItem());
        }

        public void reflectPanelValueTo(dgNinteichosaResultTaishosha_Row targetInfo) {
            targetInfo.getChosaJisshiDate().setValue(_txtChosaJisshiDate().getValue());
            ChosaJisshiBasho place = ChosaJisshiBasho.toValue(_radChosaJisshiBasho().getSelectedItem());
            targetInfo.setChosaJisshiBashoType(place.valueWithCode());
            if (place == ChosaJisshiBasho.その他) {
                targetInfo.setChosaJisshiBashoOther(_txtChosaJisshiBashoFreeInput().getValue());
            } else {
                targetInfo.setChosaJisshiBashoOther(RString.EMPTY);
            }
            targetInfo.setChosaItakusakiCode(_txtChosainCode().getValue());
            targetInfo.setChosaItakusakiName(_txtChosaItakusakiName().getValue());
            targetInfo.setChosainCode(_txtChosainCode().getValue());
            targetInfo.setChosainName(_txtChosainName().getValue());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ShinsakaiWaritsukeKibo">
    private static final class ShinsakaiWaritsukeKibo {

        private final ShisakaiWaritsukeKiboDiv panel;

        public ShinsakaiWaritsukeKibo(NinteichosaResultEntryMainDiv div) {
            this.panel = div.getShisakaiWaritsukeKibo();
        }

        enum ShinsakaiWaritsukeKiboType {

            なし("1", "なし"),
            直近("2", "直近の審査会"),
            精神科医("3", "精神科医のいる審査会");
            private final RString theKey;
            private final RString theValue;

            private ShinsakaiWaritsukeKiboType(String key, String value) {
                this.theKey = new RString(key);
                this.theValue = new RString(value);
            }

            public RString item() {
                return theKey;
            }

            public RString value() {
                return theValue;
            }

            public KeyValueDataSource toKeyValueDataSource() {
                return new KeyValueDataSource(theKey, theValue);
            }

            public static List<KeyValueDataSource> toList_KeyValueDataSource() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (ShinsakaiWaritsukeKiboType v : values()) {
                    list.add(v.toKeyValueDataSource());
                }
                return list;
            }
        }

        public void onLoad() {
            //_onLoad_rad審査会割付希望();
        }

        public void init() {
            _init_rad審査会割付希望();
        }

        /**
         * radShinsakaiWaritsukeKibo
         *
         * @return radShinsakaiWaritsukeKibo
         */
        private RadioButton _radShinsakaiWaritsukeKibo() {
            return this.panel.getRadShinsakaiWaritsukeKibo();
        }

//        private void _onLoad_rad審査会割付希望() {
//            _radShinsakaiWaritsukeKibo().setDataSource(ShinsakaiWaritsukeKiboType.toList_KeyValueDataSource());
//        }
        private void _init_rad審査会割付希望() {
            _radShinsakaiWaritsukeKibo().setSelectedItem(ShinsakaiWaritsukeKiboType.なし.item());
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ServiceJokyoTab">
    private static final class ServiceJokyoTab {

        private final ServiceJokyoTabDiv tab;
        private final ServiceJokyoServicesCounts 利用回数;

        public ServiceJokyoTab(NinteichosaResultEntryMainDiv main) {
            this.tab = main.getTabNinteichosaResult().getServiceJokyoTab();
            this.利用回数 = new ServiceJokyoServicesCounts(this.tab);
        }

        public void onLoad() {
            //_onLoad_radサービス区分();
            //this.利用回数.onLoad();
        }

        public void init() {
            _init_radサービス区分();
            this.利用回数.init();
        }

        /**
         * radServiceKubun
         *
         * @return radServiceKubun
         */
        private RadioButton _radServiceKubun() {
            return this.tab.getRadServiceKubun();
        }

        //<editor-fold defaultstate="collapsed" desc="ServiceKubun">
        enum ServiceKubun {

            なし("0"), 介護("1"), 予防("2");
            private final RString theKey;
            private final RString theValue;

            private ServiceKubun(String key) {
                this.theKey = new RString(key);
                this.theValue = new RString(name());
            }

            public RString item() {
                return theKey;
            }

            public RString value() {
                return theValue;
            }

            public KeyValueDataSource toKeyValueDataSource() {
                return new KeyValueDataSource(theKey, theValue);
            }

            public static List<KeyValueDataSource> toList_KeyValueDataSource() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (ServiceKubun v : values()) {
                    list.add(v.toKeyValueDataSource());
                }
                return list;
            }

            public static ServiceKubun toValue(RString key) {
                for (ServiceKubun v : values()) {
                    if (v.theKey.equals(key)) {
                        return v;
                    }
                }
                return なし;
            }

        }
        //</editor-fold>

//        private void _onLoad_radサービス区分() {
//            _radServiceKubun().setDataSource(ServiceKubun.toList_KeyValueDataSource());
//        }
        private void _init_radサービス区分() {
            _radServiceKubun().setSelectedItem(ServiceKubun.なし.item());
        }

        public void onChange_radサービス区分() {
            ServiceKubun kubun = ServiceKubun.toValue(_radServiceKubun().getSelectedItem());
            System.out.println(RTime.now() + ":" + kubun.name());
            this.利用回数.changeStateFromServiceKubun(kubun);
        }

        //<editor-fold defaultstate="collapsed" desc="ServiceJokyoServicesCounts">
        private static final class ServiceJokyoServicesCounts {

            private final ServiceJokyoServicesCountsDiv panel;
            private final List<ServiceWithCountCom> countComs;

            private ServiceJokyoServicesCounts(ServiceJokyoTabDiv tab) {
                this.panel = tab.getServiceJokyoServicesCounts();
                this.countComs = _createList_ServiceWithCountCom();
            }

            private List<ServiceWithCountCom> _createList_ServiceWithCountCom() {
                List<ServiceWithCountCom> list = new ArrayList<>();
                list.add(this.panel.getComCountChiikiRojinFukushiShisetsuKaigo());
                list.add(this.panel.getComCountChiikiTokuteiShisetsuKaigo());
                list.add(this.panel.getComCountDayService());
                list.add(this.panel.getComCountHomeHelp());
                list.add(this.panel.getComCountHomonBathing());
                list.add(this.panel.getComCountHomonKango());
                list.add(this.panel.getComCountHomonRehabilitation());
                list.add(this.panel.getComCountFukushiyoguHanbai());
                list.add(this.panel.getComCountFukushiyoguTaiyo());
                list.add(this.panel.getComCountNinchishoKyodoKaigo());
                list.add(this.panel.getComCountNinchishoTsushoKaigo());
                list.add(this.panel.getComCountRyoyoKanriShido());
                list.add(this.panel.getComCountSmallTakinoKaigo());
                list.add(this.panel.getComCountTankiRyoyoKaigo());
                list.add(this.panel.getComCountTankiSeikatsuKaigo());
                list.add(this.panel.getComCountTeikiJunkaiHomonKaigo());
                list.add(this.panel.getComCountTokuteiSeikatsuKaigo());
                list.add(this.panel.getComCountTsushoRehabilitation());
                list.add(this.panel.getComCountYakanHomonKaigo());
                return list;
            }

            public void onLoad() {
                //_onLoad_radJutakuKaishu();
            }

            public void init() {
                _init_radJutakuKaishu();
                _init_countComs();
                changeStateFromServiceKubun(ServiceKubun.なし);
            }

            private void _init_countComs() {
                for (ServiceWithCountCom com : countComs) {
                    com.getTxtNum().setValue(Decimal.ZERO);
                }
            }

            public void changeStateFromServiceKubun(ServiceKubun kubun) {
                switch (kubun) {
                    case なし:
                        _changeStateFromServiceKubun_なし();
                        break;
                    case 予防:
                        _changeStateFromServiceKubun_予防();
                        break;
                    case 介護:
                        _changeStateCountComsFromServiceKubun_介護();
                        break;
                    default:
                        _changeStateFromServiceKubun_なし();
                        break;
                }
            }

            private void _changeStateFromServiceKubun_なし() {
                for (ServiceWithCountCom com : countComs) {
                    com.getTxtNum().setDisabled(true);
                }
                _radJutakuKaishu().setDisabled(true);
            }

            private void _changeStateFromServiceKubun_予防() {
                for (ServiceWithCountCom com : countComs) {
                    if (_is予防給付(com)) {
                        com.getTxtNum().setDisabled(false);
                    } else {
                        com.getTxtNum().setDisabled(true);
                    }
                }
                _radJutakuKaishu().setDisabled(false);
            }

            private boolean _is予防給付(ServiceWithCountCom com) {
                return new RString("予防").equals(com.getRadKaigoOrYobo().getSelectedValue());
            }

            private void _changeStateCountComsFromServiceKubun_介護() {
                for (ServiceWithCountCom com : countComs) {
                    com.getTxtNum().setDisabled(false);
                }
                _radJutakuKaishu().setDisabled(false);
            }

            /**
             * radJutakuKaishu
             *
             * @return radJutakuKaishu
             */
            private RadioButton _radJutakuKaishu() {
                return this.panel.getRadJutakuKaishu();
            }

            //<editor-fold defaultstate="collapsed" desc="JutakuKaishu">
            enum JutakuKaishu {

                あり("1"), なし("0"),;
                private final RString theKey;
                private final RString theValue;

                private JutakuKaishu(String key) {
                    this.theKey = new RString(key);
                    this.theValue = new RString(name());
                }

                public RString item() {
                    return theKey;
                }

                public RString value() {
                    return theValue;
                }

                public KeyValueDataSource toKeyValueDataSource() {
                    return new KeyValueDataSource(theKey, theValue);
                }

                public static List<KeyValueDataSource> toList_KeyValueDataSource() {
                    List<KeyValueDataSource> list = new ArrayList<>();
                    for (JutakuKaishu v : values()) {
                        list.add(v.toKeyValueDataSource());
                    }
                    return list;
                }
            }
            //</editor-fold>

            private void _onLoad_radJutakuKaishu() {
                _radJutakuKaishu().setDataSource(JutakuKaishu.toList_KeyValueDataSource());
            }

            private void _init_radJutakuKaishu() {
                _radJutakuKaishu().setSelectedItem(JutakuKaishu.なし.item());
                System.out.println(_radJutakuKaishu().getSelectedValue());
            }

            /**
             * txtShichosonTokubetsuKyufu
             *
             * @return txtShichosonTokubetsuKyufu
             */
            private TextBox _txt市町村特別給付() {
                return this.panel.getTxtShichosonTokubetsuKyufu();
            }

            /**
             * txtZaitakuSeriviceOutsideKaigoKyufu
             *
             * @return txtZaitakuSeriviceOutsideKaigoKyufu
             */
            private TextBox _txt介護給付外在宅サービス() {
                return this.panel.getTxtZaitakuSeriviceOutsideKaigoKyufu();
            }

        }
        //</editor-fold>
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kihonchosa09">
    private static final class Kihonchosa09 {

        private final Kihonchosa09Div panel;

        public Kihonchosa09(NinteichosaResultEntryMainDiv main) {
            this.panel = main.getTabNinteichosaResult().getKihonchosaResultInputTab().getKihonchosa09();
        }

        public void init() {
            _init(_itemsForResultInput());
        }

        private void _init(List<KihonchosaResultInputCom> items) {
            for (KihonchosaResultInputCom item : items) {
                item.getTxtAnswer().setValue(new RString("1"));
            }
        }

        private List<KihonchosaResultInputCom> _itemsForResultInput() {
            List<KihonchosaResultInputCom> itemsForResultInput = new ArrayList<>();
            _extract_ItemsForResultInput_Kihonchosa09Center(itemsForResultInput);
            _extract_ItemsForResultInput_Kihonchosa09CenterLeft(itemsForResultInput);
            _extract_ItemsForResultInput_Kihonchosa09CenterRight(itemsForResultInput);
            _extract_ItemsForResultInput_Kihonchosa09Left(itemsForResultInput);
            _extract_ItemsForResultInput_Kihonchosa09Right(itemsForResultInput);
            System.out.println(itemsForResultInput.size());
            return itemsForResultInput;
        }

        private void _extract_ItemsForResultInput_Kihonchosa09Center(List<KihonchosaResultInputCom> list) {
            _extract_ItemsForResultInput_Kihonchosa0931(list);
            _extract_ItemsForResultInput_Kihonchosa0941(list);
        }

        private void _extract_ItemsForResultInput_Kihonchosa0931(List<KihonchosaResultInputCom> list) {
            Kihonchosa0931Div div = panel.getKihonchosa09Center().getKihonchosa0931();
            list.add(div.getComKihonchosaResult301());
            list.add(div.getComKihonchosaResult302());
            list.add(div.getComKihonchosaResult303());
            list.add(div.getComKihonchosaResult304());
            list.add(div.getComKihonchosaResult305());
            list.add(div.getComKihonchosaResult306());
            list.add(div.getComKihonchosaResult307());
            list.add(div.getComKihonchosaResult308());
            list.add(div.getComKihonchosaResult309());
        }

        private void _extract_ItemsForResultInput_Kihonchosa0941(List<KihonchosaResultInputCom> list) {
            Kihonchosa0941Div div = panel.getKihonchosa09Center().getKihonchosa0941();
            list.add(div.getComKihonchosaResult401());
            list.add(div.getComKihonchosaResult402());
            list.add(div.getComKihonchosaResult403());
            list.add(div.getComKihonchosaResult404());
            list.add(div.getComKihonchosaResult405());
            list.add(div.getComKihonchosaResult406());
            list.add(div.getComKihonchosaResult407());
        }

        private void _extract_ItemsForResultInput_Kihonchosa09CenterLeft(List<KihonchosaResultInputCom> list) {
            _extract_ItemsForResultInput_Kihonchosa0912(list);
            _extract_ItemsForResultInput_Kihonchosa0921(list);
        }

        private void _extract_ItemsForResultInput_Kihonchosa0912(List<KihonchosaResultInputCom> list) {
            Kihonchosa0912Div div = panel.getKihonchosa09CenterLeft().getKihonchosa0912();
            list.add(div.getComKihonchosaResult110());
            list.add(div.getComKihonchosaResult111());
            list.add(div.getComKihonchosaResult112());
            list.add(div.getComKihonchosaResult113());
        }

        private void _extract_ItemsForResultInput_Kihonchosa0921(List<KihonchosaResultInputCom> list) {
            Kihonchosa0921Div div = panel.getKihonchosa09CenterLeft().getKihonchosa0921();
            list.add(div.getComKihonchosaResult201());
            list.add(div.getComKihonchosaResult202());
            list.add(div.getComKihonchosaResult203());
            list.add(div.getComKihonchosaResult204());
            list.add(div.getComKihonchosaResult205());
            list.add(div.getComKihonchosaResult206());
            list.add(div.getComKihonchosaResult207());
            list.add(div.getComKihonchosaResult208());
            list.add(div.getComKihonchosaResult209());
            list.add(div.getComKihonchosaResult210());
            list.add(div.getComKihonchosaResult211());
            list.add(div.getComKihonchosaResult212());
        }

        private void _extract_ItemsForResultInput_Kihonchosa09CenterRight(List<KihonchosaResultInputCom> list) {
            _extract_ItemsForResultInput_Kihonchosa0942(list);
            _extract_ItemsForResultInput_Kihonchosa0951(list);
        }

        private void _extract_ItemsForResultInput_Kihonchosa0942(List<KihonchosaResultInputCom> list) {
            Kihonchosa0942Div div = panel.getKihonchosa09CenterRight().getKihonchosa0942();
            list.add(div.getComKihonchosaResult408());
            list.add(div.getComKihonchosaResult409());
            list.add(div.getComKihonchosaResult410());
            list.add(div.getComKihonchosaResult411());
            list.add(div.getComKihonchosaResult412());
            list.add(div.getComKihonchosaResult413());
            list.add(div.getComKihonchosaResult414());
            list.add(div.getComKihonchosaResult415());
        }

        private void _extract_ItemsForResultInput_Kihonchosa0951(List<KihonchosaResultInputCom> list) {
            Kihonchosa0951Div div = panel.getKihonchosa09CenterRight().getKihonchosa0951();
            list.add(div.getComKihonchosaResult501());
            list.add(div.getComKihonchosaResult502());
            list.add(div.getComKihonchosaResult503());
            list.add(div.getComKihonchosaResult504());
            list.add(div.getComKihonchosaResult505());
            list.add(div.getComKihonchosaResult506());
        }

        private void _extract_ItemsForResultInput_Kihonchosa09Left(List<KihonchosaResultInputCom> list) {
            _extract_ItemsForResultInput_Kihonchosa0911(list);
        }

        private void _extract_ItemsForResultInput_Kihonchosa0911(List<KihonchosaResultInputCom> list) {
            Kihonchosa0911Div div = panel.getKihonchosa09Left().getKihonchosa0911();
            list.add(div.getComKihonchosaResult101a());
            list.add(div.getComKihonchosaResult101b());
            list.add(div.getComKihonchosaResult101c());
            list.add(div.getComKihonchosaResult101d());
            list.add(div.getComKihonchosaResult101e());
            list.add(div.getComKihonchosaResult102a());
            list.add(div.getComKihonchosaResult102b());
            list.add(div.getComKihonchosaResult102c());
            list.add(div.getComKihonchosaResult102d());
            list.add(div.getComKihonchosaResult103());
            list.add(div.getComKihonchosaResult104());
            list.add(div.getComKihonchosaResult105());
            list.add(div.getComKihonchosaResult106());
            list.add(div.getComKihonchosaResult107());
            list.add(div.getComKihonchosaResult108());
            list.add(div.getComKihonchosaResult109());
        }

        private void _extract_ItemsForResultInput_Kihonchosa09Right(List<KihonchosaResultInputCom> list) {
            _extract_ItemsForResultInput_Kihonchosa0961(list);
            _extract_ItemsForResultInput_Kihonchosa0971(list);
        }

        private void _extract_ItemsForResultInput_Kihonchosa0961(List<KihonchosaResultInputCom> list) {
            Kihonchosa0961Div div = panel.getKihonchosa09Right().getKihonchosa0961();
            list.add(div.getComKihonchosaResult601());
            list.add(div.getComKihonchosaResult602());
            list.add(div.getComKihonchosaResult603());
            list.add(div.getComKihonchosaResult604());
            list.add(div.getComKihonchosaResult605());
            list.add(div.getComKihonchosaResult606());
            list.add(div.getComKihonchosaResult607());
            list.add(div.getComKihonchosaResult608());
            list.add(div.getComKihonchosaResult609());
            list.add(div.getComKihonchosaResult610());
            list.add(div.getComKihonchosaResult611());
            list.add(div.getComKihonchosaResult612());
        }

        private void _extract_ItemsForResultInput_Kihonchosa0971(List<KihonchosaResultInputCom> list) {
            Kihonchosa0971Div div = panel.getKihonchosa09Right().getKihonchosa0971();
            list.add(div.getComKihonchosaResult701());
            list.add(div.getComKihonchosaResult702());
        }
    }
//</editor-fold>

    private ResponseData<NinteichosaResultEntryMainDiv> _createResponseData(NinteichosaResultEntryMainDiv div) {
        ResponseData<NinteichosaResultEntryMainDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private <T> ResponseData<T> addMessage(ResponseData<T> response, InformationMessage message) {
        response.addMessage(message);
        return response;
    }
}
