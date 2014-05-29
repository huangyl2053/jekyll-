/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryContentDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryPaperDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetLatestChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.dgNinteichosaIraiList_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * NinteichosaIraiEntryDivを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaIraiEntry {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onLoad(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        return onClick_btnToCallContinuousEntry(div, div2);
    }

    /**
     * btnToCallContinuousEntry押下時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToCallContinuousEntry(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();
        if (selectedTargets(div2).isEmpty()) {
            toDisplayNone(div, true);
        } else {
            toDisplayNone(div, false);
            NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(
                    div2.getDgNinteichosaIraiList().getSelectedItems());
            div.getTxtCurrentIndex().setValue(new Decimal(0));
            setUpPanelFromTargets(div, selectedTargets(div2));
        }
        response.data = div;
        return response;
    }

    /**
     * 対象者情報panelと、依頼入力panelの表示/非表示を設定します。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param isDisplayNone 非表示ならtrue、表示ならfalse。
     */
    private void toDisplayNone(NinteichosaIraiEntryDiv div, boolean isDisplayNone) {
        div.getNinteichosaIraiEntryContent().setDisplayNone(isDisplayNone);
        div.getNinteichosaIraiEntryTarget().setDisplayNone(isDisplayNone);
        div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext().setVisible(!isDisplayNone);
    }

    /**
     * btnToPublish押下時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToPublishChohyo(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        _onClick_btnToPublishChohyo(div);

        response.data = div;
        return response;
    }

    private void _onClick_btnToPublishChohyo(NinteichosaIraiEntryDiv div) {
        NinteichosaIraiEntryPaperDiv paper = _ninteichosaIraiEntryPaper(div);
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (NinteichosaIraiEntryPaper.selectsIraisho(paper)) {
            _ninteichosaIraiEntryRequest(div).getTxtIraishoHakkoDate().setValue(nowDate);
        }
        if (NinteichosaIraiEntryPaper.selectsTokusokujo(paper)) {
            _ninteichosaIraiEntryTokusoku(div).getTxtTokusokujoHakkoDate().setValue(nowDate);
            _ninteichosaIraiEntryTokusoku(div).getDdlTokukuHoho().setSelectedItem(new RString("1"));
        }
    }

    /**
     * btnToEntryChosaIrai押下時の処理です。
     *
     * @param div NinteichosaIraiEntryDiv
     * @param div2 NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiEntryDiv> onClick_btnToEntryChosaIrai(NinteichosaIraiEntryDiv div, NinteichosaIraiListDiv div2) {
        ResponseData<NinteichosaIraiEntryDiv> response = new ResponseData<>();

        List<dgNinteichosaIraiList_Row> list = NinteichosaIraiList.NinteichosaIraiListHolder.getNinteichosaIraiList();
        int index = currentTargetIndex(div);
        dgNinteichosaIraiList_Row target = selectedTargets(div2).get(index);
        NinteichosaIraiEntryContent.setTargetInfoToPanel(target, div.getNinteichosaIraiEntryContent());
        list.set(index, target);
        NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(list);

        Button btnToCallNext = div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();

        if (!isLast(div, selectedTargets(div2))) {
            btnToCallNext.setDisabled(false);
        }

        response.data = div;
        return response;
    }

    private boolean isLast(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        return currentTargetIndex(div) + 1 == targets.size();
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

        div.getTxtCurrentIndex().setValue(new Decimal(currentTargetIndex(div) + 1));
        setUpPanelFromTargets(div, selectedTargets(div2));

        response.data = div;
        return response;
    }

    private void setUpPanelFromTargets(NinteichosaIraiEntryDiv panel, List<dgNinteichosaIraiList_Row> targets) {
        panel.setTitle(newTitle(panel, targets));
        dgNinteichosaIraiList_Row targetInfo = targets.get(currentTargetIndex(panel));
        setUpPanelFromTargetInfo(panel, targetInfo);

        Button btnToCallNext = panel.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();
        if (isLast(panel, targets)) {
            btnToCallNext.setVisible(false);
        } else {
            btnToCallNext.setVisible(true);
            btnToCallNext.setDisabled(true);
        }
    }

    private RString newTitle(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        return new RString("認定調査依頼登録" + "(" + (currentTargetIndex(div) + 1) + "/" + targets.size() + ")");
    }

    private void setUpPanelFromTargetInfo(NinteichosaIraiEntryDiv panel, dgNinteichosaIraiList_Row targetInfo) {
        NinteichosaIraiEntryTarget.initFromTargetInfo(panel.getNinteichosaIraiEntryTarget(), targetInfo);
        NinteichosaIraiEntryContent.initPanelFromTargetInfo(panel.getNinteichosaIraiEntryContent(), targetInfo);
    }

    /**
     * NinteichosaIraiEntryTargetDivに対する操作です。
     */
    private static final class NinteichosaIraiEntryTarget {

        private static void initFromTargetInfo(NinteichosaIraiEntryTargetDiv panel, dgNinteichosaIraiList_Row targetInfo) {
            _initPanelFromTargetInfo(panel, targetInfo);
            NinteichosaIraiEntryTargetLatestChosain.
                    initPanelFromTargetInfo(panel.getNinteichosaIraiEntryTargetLatestChosain(), targetInfo);
        }

        private static void _initPanelFromTargetInfo(NinteichosaIraiEntryTargetDiv panel, dgNinteichosaIraiList_Row targetInfo) {
            panel.getTxtBirthDay().setValue(targetInfo.get生年月日().getValue());
            panel.getTxtGender().setValue(targetInfo.get性別());
            panel.getTxtHihokenshaNo().setValue(targetInfo.get被保険者番号());
            panel.getTxtJusho().setValue(targetInfo.get住所());
            panel.getTxtShikibetsuCode().setValue(targetInfo.get識別コード());
            panel.getTxtShimei().setValue(targetInfo.get氏名());
            panel.getTxtYubinNo().setValue(new YubinNo(targetInfo.get郵便番号()));
        }

        private static final class NinteichosaIraiEntryTargetLatestChosain {

            private static void initPanelFromTargetInfo(NinteichosaIraiEntryTargetLatestChosainDiv panel, dgNinteichosaIraiList_Row targetInfo) {
                panel.getTxtLatestChosaItakusakiCode().setValue(targetInfo.get前回調査委託先コード());
                panel.getTxtLatestChosaItakusakiName().setValue(targetInfo.get前回調査委託先());
                panel.getTxtLatestChosainCode().setValue(targetInfo.get前回調査員コード());
                panel.getTxtLatestChosainCode().setValue(targetInfo.get前回調査員());
            }

        }
    }

    /**
     * NinteichosaIraiEntryContentDivに対する操作です。
     */
    private static final class NinteichosaIraiEntryContent {

        private static void initPanelFromTargetInfo(NinteichosaIraiEntryContentDiv panel, dgNinteichosaIraiList_Row targetInfo) {
            NinteichosaIraiEntryTargetChosain.initPanelFromTargetInfo(panel.getNinteichosaIraiEntryTargetChosain(), targetInfo);
            NinteichosaIraiEntryRequest.initPanelFromTargetInfo(panel.getNinteichosaIraiEntryRequest(), targetInfo);
            NinteichosaIraiEntryTargetTokusoku.initPanelFromTargetInfo(panel.getNinteichosaIraiEntryTokusoku(), targetInfo);
        }

        private static void setTargetInfoToPanel(dgNinteichosaIraiList_Row targetInfo, NinteichosaIraiEntryContentDiv panel) {
            NinteichosaIraiEntryTargetChosain.setTargetInfoToPanel(targetInfo, panel.getNinteichosaIraiEntryTargetChosain());
            NinteichosaIraiEntryRequest.setTargetInfoToPanel(targetInfo, panel.getNinteichosaIraiEntryRequest());
            NinteichosaIraiEntryTargetTokusoku.setTargetInfoToPanel(targetInfo, panel.getNinteichosaIraiEntryTokusoku());
            targetInfo.set依頼書発行済(NinteichosaIraiEntryRequest.is依頼書発行済み(panel.getNinteichosaIraiEntryRequest()));
            targetInfo.set依頼登録済(is依頼登録済(panel));
        }

        private static boolean is依頼登録済(NinteichosaIraiEntryContentDiv panel) {
            return NinteichosaIraiEntryRequest.is登録済み(panel.getNinteichosaIraiEntryRequest())
                    && NinteichosaIraiEntryTargetChosain.is登録済み(panel.getNinteichosaIraiEntryTargetChosain());
        }

        /**
         * NinteichosaIraiEntryTargetChosainDivに対する操作です。
         */
        private static final class NinteichosaIraiEntryTargetChosain {

            private static void initPanelFromTargetInfo(NinteichosaIraiEntryTargetChosainDiv panel, dgNinteichosaIraiList_Row target) {
                panel.getTxtChosaItakusakiCode().setValue(target.get調査委託先コード());
                panel.getTxtChosaItakusakiName().setValue(target.get調査委託先());
                panel.getTxtChosainCode().setValue(target.get調査員コード());
                panel.getTxtChosainName().setValue(target.get調査員());
            }

            private static void setTargetInfoToPanel(dgNinteichosaIraiList_Row targetInfo, NinteichosaIraiEntryTargetChosainDiv panel) {
                targetInfo.set調査委託先コード(panel.getTxtChosaItakusakiCode().getValue());
                targetInfo.set調査委託先(panel.getTxtChosaItakusakiName().getValue());
                targetInfo.set調査員コード(panel.getTxtChosainCode().getValue());
                targetInfo.set調査員(panel.getTxtChosainName().getValue());
            }

            private static boolean is登録済み(NinteichosaIraiEntryTargetChosainDiv div) {
                return _isNotEmpty(div.getTxtChosaItakusakiCode().getValue())
                        && _isNotEmpty(div.getTxtChosainCode().getValue());
            }

            private static boolean _isNotEmpty(Object obj) {
                return !RString.EMPTY.equals(obj);
            }
        }

        /**
         * NinteichosaIraiEntryRequestDivに対する操作です。
         */
        private static final class NinteichosaIraiEntryRequest {

            private static void initPanelFromTargetInfo(NinteichosaIraiEntryRequestDiv panel, dgNinteichosaIraiList_Row targetInfo) {
                panel.getDdlChosaIraiKubun().setSelectedItem(_composeItemValue(targetInfo.get調査依頼区分()));
                panel.getTxtChosaIraiDate().setValue(targetInfo.get調査依頼日().getValue());
                panel.getTxtChosaKigenDate().setValue(targetInfo.get調査期限日().getValue());
                panel.getTxtIraishoHakkoDate().setValue(targetInfo.get調査依頼書発行日().getValue());
            }

            private static RString _composeItemValue(RString value) {
                return value.equals(RString.EMPTY) ? new RString("1") : value.substring(0, 1);
            }

            private static void setTargetInfoToPanel(dgNinteichosaIraiList_Row targetInfo, NinteichosaIraiEntryRequestDiv panel) {
                targetInfo.set調査依頼区分(panel.getDdlChosaIraiKubun().getSelectedValue());
                targetInfo.get調査依頼日().setValue(panel.getTxtChosaIraiDate().getValue());
                targetInfo.get調査期限日().setValue(panel.getTxtChosaKigenDate().getValue());
                targetInfo.get調査依頼書発行日().setValue(panel.getTxtIraishoHakkoDate().getValue());
            }

            private static boolean is登録済み(NinteichosaIraiEntryRequestDiv div) {
                return _isNotNull(div.getTxtChosaIraiDate().getValue())
                        && _isNotNull(div.getTxtChosaKigenDate().getValue());
            }

            private static boolean is依頼書発行済み(NinteichosaIraiEntryRequestDiv div) {
                FlexibleDate iraishoHakkoDate = div.getTxtIraishoHakkoDate().getValue();
                return _isNotNull(iraishoHakkoDate) && _isNotEmpty(iraishoHakkoDate);
            }

            private static boolean _isNotNull(Object obj) {
                return obj == null;
            }

            private static boolean _isNotEmpty(FlexibleDate date) {
                return !FlexibleDate.EMPTY.equals(date);
            }
        }

        /**
         * NinteichosaIraiEntryTargetTokusokuDivに対する操作です。
         */
        private static final class NinteichosaIraiEntryTargetTokusoku {

            private static void initPanelFromTargetInfo(NinteichosaIraiEntryTokusokuDiv panel, dgNinteichosaIraiList_Row targetInfo) {
                panel.getDdlTokukuHoho().setSelectedItem(_composeKey(targetInfo.get督促方法()));
                panel.getTxtTokusokuCount().setValue(targetInfo.get督促回数());
                panel.getTxtTokusokuDate().setValue(targetInfo.get督促年月日().getValue());
                panel.getTxtTokusokujoHakkoDate().setValue(targetInfo.get督促発行日().getValue());
                panel.getTxtTokusokuKigenDate().setValue(targetInfo.get督促期限日().getValue());
            }

            private static RString _composeKey(RString value) {
                return value.equals(RString.EMPTY) ? new RString("0") : value.substring(0, 0);
            }

            private static void setTargetInfoToPanel(dgNinteichosaIraiList_Row targetInfo, NinteichosaIraiEntryTokusokuDiv panel) {
                targetInfo.set督促方法(panel.getDdlTokukuHoho().getSelectedValue());
                targetInfo.set督促回数(panel.getTxtTokusokuCount().getValue());
                targetInfo.get督促年月日().setValue(panel.getTxtTokusokuDate().getValue());
                targetInfo.get督促発行日().setValue(panel.getTxtTokusokujoHakkoDate().getValue());
                targetInfo.get督促期限日().setValue(panel.getTxtTokusokuKigenDate().getValue());
            }
        }
    }

    /**
     * NinteichosaIraiEntryPaperDivに対する操作です。
     */
    private static final class NinteichosaIraiEntryPaper {

        private static boolean selectsIraisho(NinteichosaIraiEntryPaperDiv div) {
            return selects(new RString("依頼書"), div);
        }

        private static boolean selectsTokusokujo(NinteichosaIraiEntryPaperDiv div) {
            return selects(new RString("督促状"), div);
        }

        private static boolean selects(RString value, NinteichosaIraiEntryPaperDiv div) {
            for (KeyValueDataSource item : div.getChkPaperType().getSelectedItems()) {
                if (item.getValue().contains(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static int currentTargetIndex(NinteichosaIraiEntryDiv div) {
        return div.getTxtCurrentIndex().getValue().intValue();
    }

    private static List<dgNinteichosaIraiList_Row> selectedTargets(NinteichosaIraiListDiv div2) {
        return div2.getDgNinteichosaIraiList().getSelectedItems();
    }

    private static NinteichosaIraiEntryPaperDiv _ninteichosaIraiEntryPaper(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryPaper();
    }

    private static NinteichosaIraiEntryRequestDiv _ninteichosaIraiEntryRequest(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryRequest();
    }

    private static NinteichosaIraiEntryTokusokuDiv _ninteichosaIraiEntryTokusoku(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryTokusoku();
    }
}
