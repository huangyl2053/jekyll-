/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryPaperDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestContentDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetLatestChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuContentDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuPublishDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.dgNinteichosaIraiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.shozokuChosainList.dgShozokuChosainList_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * NinteichosaIraiEntryDivを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaIraiEntry {

    private static final int NUM_OF_DAYS_IN_A_WEEK = 7;

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onLoad(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        new NinteichosaTokusoku(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku()).onLoad();
        return onClick_btnToCallContinuousEntry(div, div2);
    }

    /**
     * btnToCallContinuousEntry押下時の処理です。
     *
     * @param panel NinteichosaIraiEntryDiv
     * @param allTargets NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToCallContinuousEntry(NinteichosaIraiEntryDiv panel,
            NinteichosaIraiListDiv allTargets) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        List<dgNinteichosaIraiList_Row> selectedTargets = selectedTargetsFrom(allTargets);
        if (selectedTargets.isEmpty()) {
            changeMode_DisplayNone(panel, true);
        } else {
            changeMode_DisplayNone(panel, false);
            init(panel, selectedTargets);
        }

        response.data = panel;
        return response;
    }

    private void changeMode_DisplayNone(NinteichosaIraiEntryDiv div, boolean isDisplayNone) {
        div.getNinteichosaIraiEntryMain().setDisplayNone(isDisplayNone);
        div.getNinteichosaIraiEntryTarget().setDisplayNone(isDisplayNone);
//        div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext().setVisible(!isDisplayNone);
//        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToCallNext"), true);
    }

    private void init(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> selectedTargets) {
        NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(selectedTargets);
        setCurrentTargetIndex(panel, 0);
        setUpPanelFromTargets(panel, selectedTargets);
    }

    private void setUpTokusoku(NinteichosaIraiEntryDiv panel) {
        new NinteichosaTokusoku(panel.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku()).init();
    }

    private void setUpPanelFromTargets(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
        setNewTitle(panel, targets);
        setUpPanelFromTargetInfo(panel, currentTarget(panel, targets));
        setUpTokusoku(panel);
//        stateChange_btnToCallNext(panel, targets);
    }

    private void setNewTitle(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
        panel.setTitle(composeNewTitle(panel, targets));
    }

    private RString composeNewTitle(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
        return new RString("認定調査依頼登録" + "(" + (getCurrentTargetIndex(panel) + 1) + "/" + targets.size() + ")");
    }

    private dgNinteichosaIraiList_Row currentTarget(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
        return targets.get(getCurrentTargetIndex(panel));
    }

    private void setUpPanelFromTargetInfo(NinteichosaIraiEntryDiv panel, dgNinteichosaIraiList_Row targetInfo) {
        new NinteichosaIraiEntryTarget(panel.getNinteichosaIraiEntryTarget()).setTargetInfo(targetInfo);
        new NinteichosaIraiEntryMain(panel.getNinteichosaIraiEntryMain()).setTargetInfo(targetInfo);
    }

    private void stateChange_btnToCallNext(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
//        Button btnToCallNext = panel.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();
        if (isLastPerson(panel, targets)) {
//            btnToCallNext.setVisible(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToCallNext"), true);
        } else {
//            btnToCallNext.setVisible(true);
//            btnToCallNext.setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToCallNext"), false);
        }
    }

    /**
     * btnToPublish押下時の処理です。
     *
     * @param panel NinteichosaIraiEntryDiv
     * @param xxx NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToPublishChohyo(NinteichosaIraiEntryDiv panel, NinteichosaIraiListDiv xxx) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        _onClick_btnToPublishChohyo(panel);

        response.data = panel;
        return response;
    }

    private void _onClick_btnToPublishChohyo(NinteichosaIraiEntryDiv panel) {
        NinteichosaPaper paper = new NinteichosaPaper(panel
                .getNinteichosaIraiEntryMain().getNinteichosaIraiEntryRequest().getNinteichosaIraiEntryPaper());
        if (paper.isSelected依頼書()) {
            FlexibleDate nowDate = FlexibleDate.getNowDate();
            paper.set依頼書発行日(nowDate);
        }
    }

    /**
     * btnToEntryChosaIrai押下時の処理です。
     *
     * @param panel NinteichosaIraiEntryDiv
     * @param allTargets NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToEntryChosaIrai(NinteichosaIraiEntryDiv panel, NinteichosaIraiListDiv allTargets) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        increase_TokusokuCount(panel, allTargets);
        saveToViewState(panel, allTargets);
        stateChange_btnToCallNext(panel, allTargets);

        response.data = panel;
        return response;
    }

    private void saveToViewState(NinteichosaIraiEntryDiv panel, NinteichosaIraiListDiv allTargets) {
        int index = getCurrentTargetIndex(panel);
        dgNinteichosaIraiList_Row target = selectedTargetsFrom(allTargets).get(index);
        List<dgNinteichosaIraiList_Row> list = NinteichosaIraiList.NinteichosaIraiListHolder.getNinteichosaIraiList();
        list.set(index, modified(target, panel));
        NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(list);
    }

    private dgNinteichosaIraiList_Row modified(dgNinteichosaIraiList_Row target, NinteichosaIraiEntryDiv panel) {
        return new NinteichosaIraiEntryMain(panel.getNinteichosaIraiEntryMain()).reflect(target);
    }

    private void stateChange_btnToCallNext(NinteichosaIraiEntryDiv panel, NinteichosaIraiListDiv allTargets) {
//        Button btnToCallNext = panel.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();
        if (!isLastPerson(panel, selectedTargetsFrom(allTargets))) {
//            btnToCallNext.setDisabled(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnToCallNext"), false);
        }
    }

    /**
     * btnToCallNext押下時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToCallNext(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        setCurrentTargetIndex(div, getCurrentTargetIndex(div) + 1);
        setUpPanelFromTargets(div, selectedTargetsFrom(div2));

        response.data = div;
        return response;
    }

    /**
     * radTokusoku
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onChange_radTokusoku(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        new NinteichosaTokusoku(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku()).onChange_radTokusoku();

        response.data = div;
        return response;
    }

    /**
     * ddlTokukuHoho
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onChange_ddlTokukuHoho(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        new NinteichosaTokusoku(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku()).onChange_ddlTokukuHoho();

        response.data = div;
        return response;
    }

    /**
     * onClick_btnToPublishTokusokujo
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToPublishTokusokujo(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        new NinteichosaTokusoku(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku()).onClick_btnToPublishTokusokujo();

        response.data = div;
        return response;
    }

    private int getCurrentTargetIndex(NinteichosaIraiEntryDiv panel) {
        return panel.getTxtCurrentIndex().getValue().intValue();
    }

    private void setCurrentTargetIndex(NinteichosaIraiEntryDiv panel, int index) {
        panel.getTxtCurrentIndex().setValue(new Decimal(index));
    }

    private static List<dgNinteichosaIraiList_Row> selectedTargetsFrom(NinteichosaIraiListDiv div2) {
        return div2.getDgNinteichosaIraiList().getSelectedItems();
    }

    private boolean isLastPerson(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        return getCurrentTargetIndex(div) + 1 == targets.size();
    }

    private void increase_TokusokuCount(NinteichosaIraiEntryDiv panel, NinteichosaIraiListDiv allTargets) {
        dgNinteichosaIraiList_Row target = currentTarget(panel, selectedTargetsFrom(allTargets));
        NinteichosaTokusoku tokusoku = new NinteichosaTokusoku(panel.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTokusoku());
        RString tokusokuCount = tokusoku.getContent().getTokusokuCount().getValue();
        if ((target.get督促回数().equals(tokusokuCount)) && (tokusoku.is督促する())) {
            int value = Integer.parseInt(tokusokuCount.toString());
            tokusoku.getContent().getTokusokuCount().setValue(new RString(String.valueOf(value + 1)));
        }
    }

    /**
     * txtChosaItakusakiCodeのonChange時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onChange_txtChosaItakusakiCode(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        new NinteichosaChosain(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTargetChosain()).onChange_txtChosaItakusakiCode();

        response.data = div;
        return response;
    }

    /**
     * txtChosainCodeのonChange時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onChange_txtChosainCode(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        new NinteichosaChosain(div.getNinteichosaIraiEntryMain().getNinteichosaIraiEntryTargetChosain()).onChange_txtChosainCode();

        response.data = div;
        return response;
    }

    /**
     * 調査依頼対象者です。
     */
    private static final class NinteichosaIraiEntryTarget {

        private final NinteichosaIraiEntryTargetDiv panel;
        private final _LatestChosain latestChosain;

        NinteichosaIraiEntryTarget(NinteichosaIraiEntryTargetDiv panel) {
            this.panel = panel;
            this.latestChosain = new _LatestChosain(
                    this.panel.getNinteichosaIraiEntryTargetLatestChosain());
        }

        /**
         * 個人の情報を設定します。
         */
        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            this._setTargetInfo(targetInfo);
            latestChosain.setTargetInfo(targetInfo);
        }

        private void _setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            panel.getTxtBirthDay().setValue(targetInfo.get生年月日().getValue());
            panel.getTxtGender().setValue(targetInfo.get性別());
            panel.getTxtHihokenshaNo().setValue(targetInfo.get被保険者番号());
            panel.getTxtJusho().setValue(targetInfo.get住所());
            panel.getTxtShikibetsuCode().setValue(targetInfo.get識別コード());
            panel.getTxtShimei().setValue(targetInfo.get氏名());
            panel.getTxtYubinNo().setValue(new YubinNo(targetInfo.get郵便番号()));
            panel.getTxtShinseiDate().setValue(targetInfo.get認定申請日().getValue());
            panel.getTxtShinseiKubun().setValue(targetInfo.get認定申請区分申請時());
        }

        private static final class _LatestChosain {

            private final NinteichosaIraiEntryTargetLatestChosainDiv panel;

            private _LatestChosain(NinteichosaIraiEntryTargetLatestChosainDiv panel) {
                this.panel = panel;
            }

            private void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
                this.panel.getTxtLatestChosaItakusakiCode().setValue(targetInfo.get前回調査委託先コード());
                this.panel.getTxtLatestChosaItakusakiName().setValue(targetInfo.get前回調査委託先());
                this.panel.getTxtLatestChosainCode().setValue(targetInfo.get前回調査員コード());
                this.panel.getTxtLatestChosainName().setValue(targetInfo.get前回調査員());
            }
        }
    }

    /**
     * 調査員・調査委託先です。
     */
    private static final class NinteichosaChosain {

        private final NinteichosaIraiEntryTargetChosainDiv panel;

        NinteichosaChosain(NinteichosaIraiEntryTargetChosainDiv panel) {
            this.panel = panel;
        }

        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            _txtChosaItakusakiCode().setValue(targetInfo.get調査委託先コード());
            _txtChosaItakusakiName().setValue(targetInfo.get調査委託先());
            _txtChosainCode().setValue(targetInfo.get調査員コード());
            _txtChosainName().setValue(targetInfo.get調査員());
        }

        dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            targetInfo.set調査委託先コード(_txtChosaItakusakiCode().getValue());
            targetInfo.set調査委託先(_txtChosaItakusakiName().getValue());
            targetInfo.set調査員コード(_txtChosainCode().getValue());
            targetInfo.set調査員(_txtChosainName().getValue());
            return targetInfo;
        }

        private boolean is登録済み() {
            return !(_isEmpty(panel.getTxtChosaItakusakiCode().getValue())
                    || _isEmpty(panel.getTxtChosainCode().getValue()));
        }

        private boolean _isEmpty(RString rstr) {
            return RString.EMPTY.equals(rstr);
        }

        void onChange_txtChosaItakusakiCode() {
            RString chosaItakusakiCode = _txtChosaItakusakiCode().getValue();
            for (dgChosaItakusakiList_Row itakusaki : _itakusakiList()) {
                if (chosaItakusakiCode.equals(itakusaki.getChosaItakusakiNo())) {
                    _txtChosaItakusakiName().setValue(itakusaki.getChosaItakusakiName());
                    return;
                }
            }
            _txtChosaItakusakiName().clearValue();
        }

        private List<dgChosaItakusakiList_Row> _itakusakiList() {
            return new NinteichosaIraiByHand.DemoData().get調査委託先一覧();
        }

        private TextBoxCode _txtChosaItakusakiCode() {
            return this.panel.getTxtChosaItakusakiCode();
        }

        private TextBox _txtChosaItakusakiName() {
            return this.panel.getTxtChosaItakusakiName();
        }

        void onChange_txtChosainCode() {
            RString chosainCode = _txtChosainCode().getValue();
            RString chosaItakusakiCode = _txtChosaItakusakiCode().getValue();
            for (dgShozokuChosainList_Row chosain : _chosainList()) {
                if ((chosaItakusakiCode.equals(chosain.getChousaItakusakiNo()))
                        && (chosainCode.equals(chosain.getChosainNo()))) {
                    _txtChosainName().setValue(chosain.getChosainName());
                    return;
                }
            }
            _txtChosainName().clearValue();
        }

        private List<dgShozokuChosainList_Row> _chosainList() {
            return new NinteichosaIraiByHand.DemoData().get所属調査員一覧();
        }

        private TextBoxCode _txtChosainCode() {
            return this.panel.getTxtChosainCode();
        }

        private TextBox _txtChosainName() {
            return this.panel.getTxtChosainName();
        }
    }

    /**
     * 調査依頼書です。
     */
    private static final class NinteichosaPaper {

        private final NinteichosaIraiEntryPaperDiv panel;

        NinteichosaPaper(NinteichosaIraiEntryPaperDiv panel) {
            this.panel = panel;
        }

        /**
         * 依頼書がチェックされているとき、trueを返します。
         *
         * @return 依頼書がチェックされているとき、true
         */
        boolean isSelected依頼書() {
            return _isSelected(new RString("依頼書"));
        }

        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            this.panel.getNinteichosaIraiEntryPaperPublish()
                    .getTxtIraishoHakkoDate().setValue(targetInfo.get調査依頼書発行日().getValue());
        }

        dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            targetInfo.get調査依頼書発行日().setValue(this.get依頼書発行日());
            targetInfo.set依頼書発行済(this.is依頼書発行済み());
            return targetInfo;
        }

        /**
         * 指定の依頼書発行日を設定します。
         *
         * @param date 依頼書発行日
         */
        void set依頼書発行日(FlexibleDate date) {
            panel.getNinteichosaIraiEntryPaperPublish().getTxtIraishoHakkoDate().setValue(date);
        }

        FlexibleDate get依頼書発行日() {
            return panel.getNinteichosaIraiEntryPaperPublish().getTxtIraishoHakkoDate().getValue();
        }

        boolean is依頼書発行済み() {
            return (this.get依頼書発行日() != null) && (this.get依頼書発行日() != FlexibleDate.EMPTY);
        }

        private boolean _isSelected(RString value) {
            for (KeyValueDataSource item : this.panel.getChkPaperType().getSelectedItems()) {
                if (item.getValue().contains(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 認定調査依頼の主な項目です。
     */
    private static final class NinteichosaRequestContent {

        private final NinteichosaIraiEntryRequestContentDiv panel;

        NinteichosaRequestContent(NinteichosaIraiEntryRequestContentDiv panel) {
            this.panel = panel;
        }

        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            this.chosaIraiKubun().setSelectedItem(_composeItemValue(targetInfo.get調査依頼区分()));
            this.chosaIraiDate().setValue(targetInfo.get調査依頼日().getValue());
            this.chosaKigenDate().setValue(targetInfo.get調査期限日().getValue());

            if (_isNull(panel.getTxtChosaIraiDate().getValue())) {
                this._setDefault_iraiDateAndKigenDate();
            }
        }

        dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            targetInfo.set調査依頼区分(this.chosaIraiKubun().getSelectedValue());
            targetInfo.get調査依頼日().setValue(this.chosaIraiDate().getValue());
            targetInfo.get調査期限日().setValue(this.chosaKigenDate().getValue());
            return targetInfo;
        }

        private void _setDefault_iraiDateAndKigenDate() {
            FlexibleDate nowDate = FlexibleDate.getNowDate();
            this.chosaIraiDate().setValue(nowDate);
            this.chosaKigenDate().setValue(nowDate.plusDay(NUM_OF_DAYS_IN_A_WEEK));
        }

        private boolean is登録済み() {
            return !(_isNull(panel.getTxtChosaIraiDate().getValue())
                    || _isNull(panel.getTxtChosaKigenDate().getValue()));
        }

        DropDownList chosaIraiKubun() {
            return panel.getDdlChosaIraiKubun();
        }

        TextBoxFlexibleDate chosaIraiDate() {
            return panel.getTxtChosaIraiDate();
        }

        TextBoxFlexibleDate chosaKigenDate() {
            return panel.getTxtChosaKigenDate();
        }

        private RString _composeItemValue(RString value) {
            return value.equals(RString.EMPTY) ? new RString("1") : value.substring(0, 1);
        }

        private boolean _isNull(Object obj) {
            return obj == null;
        }

    }

    /**
     * 認定調査の依頼です。
     */
    private static final class NinteichosaRequest {

        private final NinteichosaRequestContent content;
        private final NinteichosaPaper paper;

        NinteichosaRequest(NinteichosaIraiEntryRequestDiv panel) {
            this.content = new NinteichosaRequestContent(panel.getNinteichosaIraiEntryRequestContent());
            this.paper = new NinteichosaPaper(panel.getNinteichosaIraiEntryPaper());
        }

        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            content.setTargetInfo(targetInfo);
            paper.setTargetInfo(targetInfo);
        }

        dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            return content.reflect(paper.reflect(targetInfo));
        }

        boolean is依頼書発行済み() {
            return this.getPapger().is依頼書発行済み();
        }

        boolean is登録済み() {
            return this.getContent().is登録済み();
        }

        NinteichosaRequestContent getContent() {
            return this.content;
        }

        NinteichosaPaper getPapger() {
            return this.paper;
        }

    }

    /**
     * 認定調査の督促です。
     */
    private static final class NinteichosaTokusoku {

        private enum DataSource_radTokusoku {

            しない("0", "しない"), する("1", "する");
            private final RString theKey;
            private final RString theValue;

            private DataSource_radTokusoku(String key, String value) {
                this.theKey = new RString(key);
                this.theValue = new RString(value);
            }

            RString item() {
                return this.theKey;
            }

            RString value() {
                return this.theValue;
            }

            KeyValueDataSource toKeyValueDataSource() {
                return new KeyValueDataSource(theKey, theValue);
            }

            static List<KeyValueDataSource> toList_KeyValueDataSource() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (DataSource_radTokusoku v : values()) {
                    list.add(v.toKeyValueDataSource());
                }
                return list;
            }
        }

        private enum TokusokuHoho {

            なし("0"),
            督促状("1"),
            FAX("2"),
            電話("3");
            private final RString theKey;
            private final RString theValue;

            private TokusokuHoho(String key) {
                this.theKey = new RString(key);
                this.theValue = new RString(key + "：" + name());
            }

            RString item() {
                return this.theKey;
            }

            RString value() {
                return this.theValue;
            }

            KeyValueDataSource toKeyValueDataSource() {
                return new KeyValueDataSource(theKey, theValue);
            }

            static List<KeyValueDataSource> toList_KeyValueDataSource() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (TokusokuHoho v : values()) {
                    list.add(v.toKeyValueDataSource());
                }
                return list;
            }

            static List<KeyValueDataSource> toList_KeyValueDataSource_only_なし() {
                List<KeyValueDataSource> list = new ArrayList<>();
                list.add(なし.toKeyValueDataSource());
                return list;
            }

            static List<KeyValueDataSource> toList_KeyValueDataSource_withoutなし() {
                List<KeyValueDataSource> list = new ArrayList<>();
                for (TokusokuHoho v : values()) {
                    if (v == なし) {
                        continue;
                    }
                    list.add(v.toKeyValueDataSource());
                }
                return list;
            }
        }
        private final NinteichosaIraiEntryTokusokuDiv panel;
        private final _Content content;

        /**
         * 新しいNinteichosaTokusokuを生成します。
         */
        NinteichosaTokusoku(NinteichosaIraiEntryTokusokuDiv panel) {
            this.panel = panel;
            this.content = new _Content(panel.getNinteichosaIraiEntryTokusokuContent());
        }

        /**
         * onLoad時の処理です。
         */
        void onLoad() {
            getRadTokusoku().setDataSource(DataSource_radTokusoku.toList_KeyValueDataSource());
            this.content.getTokusokuHoho().setDataSource(TokusokuHoho.toList_KeyValueDataSource_only_なし());
            _init();
        }

        /**
         * 画面表示時の初期処理です。
         */
        void init() {
            _init();
        }

        void _init() {
            getRadTokusoku().setSelectedItem(DataSource_radTokusoku.しない.item());
            this.content.getTokusokuHoho().setSelectedItem(TokusokuHoho.なし.item());
            this.content.setCanEdit(false);
        }

        /**
         * 指定の対象者情報から、コントロールの値を初期化します。
         *
         * @param targetInfo 対象者情報
         */
        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            this.content.getTokusokuCount().setValue(targetInfo.get督促回数());
        }

        private RString _composeKey(RString value) {
            return value.equals(RString.EMPTY) ? new RString("0") : value.substring(0, 1);
        }

        /**
         * 指定の対象者情報に、コントロールの値を反映して返します。
         *
         * @param targetInfo 対象者情報
         * @return コントロールの値を反映した対象者情報
         */
        dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            return is督促する() ? _reflect(targetInfo) : targetInfo;
        }

        dgNinteichosaIraiList_Row _reflect(dgNinteichosaIraiList_Row targetInfo) {
            targetInfo.set督促方法(this.content.getTokusokuHoho().getSelectedValue());
            targetInfo.set督促回数(this.content.getTokusokuCount().getValue());
            targetInfo.get督促年月日().setValue(this.content.getTokusokuDate().getValue());
            if (this.content.is督促方法_督促状()) {
                targetInfo.get督促発行日().setValue(this.content.getTokusokujoHakkoDate().getValue());
            } else {
                targetInfo.get督促発行日().setValue(null);
            }
            targetInfo.get督促期限日().setValue(this.content.getTokusokuKigenDate().getValue());
            return targetInfo;
        }

        _Content getContent() {
            return content;
        }

        private static final class _Content {

            private final NinteichosaIraiEntryTokusokuContentDiv panel;
            private final _Pablish pablish;

            /**
             * 新しい_Contentを生成します。
             */
            _Content(NinteichosaIraiEntryTokusokuContentDiv panel) {
                this.panel = panel;
                this.pablish = new _Pablish(panel.getNinteichosaIraiEntryTokusokuPublish());
            }

            DropDownList getTokusokuHoho() {
                return this.panel.getDdlTokukuHoho();
            }

            boolean is督促方法_なし() {
                return TokusokuHoho.なし.item().equals(this.getTokusokuHoho().getSelectedItem());
            }

            boolean is督促方法_督促状() {
                return TokusokuHoho.督促状.item().equals(this.getTokusokuHoho().getSelectedItem());
            }

            TextBox getTokusokuCount() {
                return this.panel.getTxtTokusokuCount();
            }

            void setCanEdit(boolean canEdit) {
                this.panel.setDisabled(!canEdit);
            }

            TextBoxFlexibleDate getTokusokuDate() {
                return this.panel.getTxtTokusokuDate();
            }

            TextBoxFlexibleDate getTokusokujoHakkoDate() {
                return this.panel
                        .getNinteichosaIraiEntryTokusokuPublish().getTxtTokusokujoHakkoDate();
            }

            TextBoxFlexibleDate getTokusokuKigenDate() {
                return this.panel.getTxtTokusokuKigenDate();
            }

            _Pablish getPablishPanel() {
                return this.pablish;
            }

            class _Pablish {

                private final NinteichosaIraiEntryTokusokuPublishDiv panel;

                _Pablish(NinteichosaIraiEntryTokusokuPublishDiv panel) {
                    this.panel = panel;
                }

                void setCanPush_btnToPublishTokusokujo(boolean canPush) {
                    this.panel.getBtnToPublishTokusokujo().setDisabled(!canPush);
                }

                void onClick_btnToPublishTokusokujo() {
                    this.panel.getTxtTokusokujoHakkoDate().setValue(FlexibleDate.getNowDate());
                }
            }
        }

        RadioButton getRadTokusoku() {
            return panel.getRadTokusoku();
        }

        void onChange_radTokusoku() {
            if (is督促する()) {
                _toBeEditable();
            } else {
                _toBeNonEditable();
            }
        }

        boolean is督促する() {
            return DataSource_radTokusoku.する.item().equals(getRadTokusoku().getSelectedItem());
        }

        private void _toBeEditable() {
            this.content.setCanEdit(true);
            if (this.content.is督促方法_なし()) {
                this.content.getTokusokuHoho().setSelectedItem(TokusokuHoho.督促状.item());
                this.content.getPablishPanel().setCanPush_btnToPublishTokusokujo(true);
            }
            FlexibleDate nowDate = FlexibleDate.getNowDate();
            this.content.getTokusokuDate().setValue(nowDate);
            this.content.getTokusokuKigenDate().setValue(nowDate.plusDay(NUM_OF_DAYS_IN_A_WEEK));
            this.content.getTokusokuHoho().setDataSource(TokusokuHoho.toList_KeyValueDataSource_withoutなし());
        }

        private void _toBeNonEditable() {
            this.content.setCanEdit(false);
            this.content.getTokusokuHoho().setDataSource(TokusokuHoho.toList_KeyValueDataSource_only_なし());
            this.content.getTokusokuHoho().setSelectedItem(TokusokuHoho.なし.item());
        }

        void onChange_ddlTokukuHoho() {
            if (this.content.is督促方法_督促状()) {
                this.content.getPablishPanel().setCanPush_btnToPublishTokusokujo(true);
            } else {
                this.content.getPablishPanel().setCanPush_btnToPublishTokusokujo(false);
            }
        }

        void onClick_btnToPublishTokusokujo() {
            this.content.getPablishPanel().onClick_btnToPublishTokusokujo();
        }

    }

    /**
     * 認定調査の依頼・督促をまとめて扱います。
     */
    private static final class NinteichosaIraiEntryMain {

        private final NinteichosaRequest request;
        private final NinteichosaTokusoku tokusoku;
        private final NinteichosaChosain chosain;

        NinteichosaIraiEntryMain(NinteichosaIraiEntryMainDiv panel) {
            request = new NinteichosaRequest(panel.getNinteichosaIraiEntryRequest());
            tokusoku = new NinteichosaTokusoku(panel.getNinteichosaIraiEntryTokusoku());
            chosain = new NinteichosaChosain(panel.getNinteichosaIraiEntryTargetChosain());
        }

        void setTargetInfo(dgNinteichosaIraiList_Row targetInfo) {
            chosain.setTargetInfo(targetInfo);
            request.setTargetInfo(targetInfo);
            tokusoku.setTargetInfo(targetInfo);
        }

        private dgNinteichosaIraiList_Row reflect(dgNinteichosaIraiList_Row targetInfo) {
            targetInfo.set依頼登録済(is依頼登録済み());
            return chosain.reflect(request.reflect(tokusoku.reflect(targetInfo)));
        }

        private boolean is依頼登録済み() {
            return request.is登録済み() && chosain.is登録済み();
        }
    }

}
