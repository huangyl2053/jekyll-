/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kihonchosaResultInputCom.KihonchosaResultInputCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.HihokenshaForNinteichosaResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0911Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0912Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0921Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0931Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0941Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0942Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0951Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0961Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0971Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa09Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaDetailDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaResultEntryMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.ur.urz.business.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

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
     * @param target NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryMainDiv> onLoad(NinteichosaResultEntryMainDiv div, NinteichosaResultEntryTargetDiv target) {
        ResponseData<NinteichosaResultEntryMainDiv> response = new ResponseData<>();

        new NinteichosaDetail(div).onLoad();

        response.data = div;
        return response;
    }

    public ResponseData<NinteichosaResultEntryMainDiv> onStart_NinteichosaResultEntryMain(NinteichosaResultEntryMainDiv div, NinteichosaResultEntryTargetDiv target) {
        ResponseData<NinteichosaResultEntryMainDiv> response = new ResponseData<>();

        dgNinteichosaResultTaishosha_Row targetInfo = target.getDgNinteichosaResultTaishosha().getClickedItem();
        new HihokenshaForNinteichosaResult(div).init(targetInfo);
        new NinteichosaDetail(div).init(targetInfo);
        new Kihonchosa09(div).init();

        response.data = div;
        return response;
    }

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
            IDateOfBirth birthDay = DateOfBirthFactory.createInstance(targetInfo.getBirthDay().getValue());
            panel.getTxtHihokenshaBirthDay().setValue(birthDay.toFlexibleDate());
            panel.getTxtHihokenshaAge().setValue(new RString(Integer.toString(birthDay.get年齢())));
        }
    }

    /**
     * NinteichosaDetailDivを操作するためのクラスです。
     */
    private static class NinteichosaDetail {

        private final NinteichosaDetailDiv panel;

        public NinteichosaDetail(NinteichosaResultEntryMainDiv main) {
            this.panel = main.getNinteichosaDetail();
        }

        public void onLoad() {
            _onLoad_radChosaJisshiBasho();
        }

        public void init(dgNinteichosaResultTaishosha_Row targetInfo) {
            _initWithTargetInfo(targetInfo);
            _initControls();
        }

        private void _initWithTargetInfo(dgNinteichosaResultTaishosha_Row targetInfo) {
            panel.getTxtChosainCode().setValue(targetInfo.getChosainCode());
            panel.getTxtChosainName().setValue(targetInfo.getChosainName());
            panel.getTxtChosaItakusakiCode().setValue(targetInfo.getChosaItakusakiCode());
            panel.getTxtChosaItakusakiName().setValue(targetInfo.getChosaItakusakiName());
        }

        private void _initControls() {
            _init_txtChosaJisshiBashoFreeInput();
            _init_radChosaJisshiBasho();
            _init_txtChosaJisshiDate();
        }

        enum ChosaJisshiBasho {

            自宅("1"),
            自宅外("2"),
            その他("9");
            private final RString theKey;
            private final RString theValue;

            private ChosaJisshiBasho(String key) {
                this.theKey = new RString(key);
                this.theValue = new RString(name());
            }

            public RString item() {
                return this.theKey;
            }

            public RString value() {
                return this.theValue;
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
        }

        private void _onLoad_radChosaJisshiBasho() {
            _radChosaJisshiBasho().setDataSource(ChosaJisshiBasho.toDataSource());
        }

        private void _init_radChosaJisshiBasho() {
            _radChosaJisshiBasho().setSelectedItem(ChosaJisshiBasho.自宅.item());
        }

        private RadioButton _radChosaJisshiBasho() {
            return this.panel.getRadChosaJisshiBasho();
        }

        private void _init_txtChosaJisshiBashoFreeInput() {
            _txtChosaJisshiBashoFreeInput().clearValue();
            _txtChosaJisshiBashoFreeInput().setDisabled(true);
        }

        private TextBox _txtChosaJisshiBashoFreeInput() {
            return this.panel.getTxtChosaJisshiBashoFreeInput();
        }

        private void _init_txtChosaJisshiDate() {
            _txtChosaJisshiDate().clearValue();
        }

        private TextBoxFlexibleDate _txtChosaJisshiDate() {
            return this.panel.getTxtChosaJisshiDate();
        }
    }

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

}
