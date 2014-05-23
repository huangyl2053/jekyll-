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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetTokusokuDiv;
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
        if (_selectedItems(div2).isEmpty()) {
            _setdisplayNone(div, true);
        } else {
            _setdisplayNone(div, false);
            NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(
                    div2.getDgNinteichosaIraiList().getSelectedItems());
            div.getTxtCurrentIndex().setValue(new Decimal(0));
            _setUp(div, _selectedItems(div2));
        }
        response.data = div;
        return response;
    }

    private void _setdisplayNone(NinteichosaIraiEntryDiv div, boolean isDisplayNone) {
        div.getNinteichosaIraiEntryContent().setDisplayNone(isDisplayNone);
        div.getNinteichosaIraiEntryTarget().setDisplayNone(isDisplayNone);
        div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext().setVisible(!isDisplayNone);
    }

    private void _setUp(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        div.setTitle(_newTitle(div, targets));
        dgNinteichosaIraiList_Row item = targets.get(_currentIndex(div));
        _setUpForCurrentItem(div, item);

        Button btnToCallNext = div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();
        if (_isLast(div, targets)) {
            btnToCallNext.setVisible(false);
        } else {
            btnToCallNext.setVisible(true);
            btnToCallNext.setDisabled(true);
        }
    }

    private boolean _isLast(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        return _currentIndex(div) + 1 == targets.size();
    }

    private RString _newTitle(NinteichosaIraiEntryDiv div, List<dgNinteichosaIraiList_Row> targets) {
        return new RString("認定調査依頼登録" + "(" + (_currentIndex(div) + 1) + "/" + targets.size() + ")");
    }

    private void _setUpForCurrentItem(NinteichosaIraiEntryDiv div, dgNinteichosaIraiList_Row item) {
        NinteichosaIraiEntryTarget.setUp(div.getNinteichosaIraiEntryTarget(), item);
        NinteichosaIraiEntryContent.setUp(div.getNinteichosaIraiEntryContent(), item);
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
        NinteichosaIraiEntryPaperDiv paper = _paper(div);
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (NinteichosaIraiEntryPaper.selectsIraisho(paper)) {
            _request(div).getTxtIraishoHakkoDate().setValue(nowDate);
        }
        if (NinteichosaIraiEntryPaper.selectsTokusokujo(paper)) {
            _tokusoku(div).getTxtTokusokujoHakkoDate().setValue(nowDate);
            _tokusoku(div).getDdlTokukuHoho().setSelectedItem(new RString("1"));
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
        int index = _currentIndex(div);
        dgNinteichosaIraiList_Row item = _selectedItems(div2).get(index);
        NinteichosaIraiEntryContent.reflectInputedContentTo(item, div.getNinteichosaIraiEntryContent());
        list.set(index, item);
        NinteichosaIraiList.NinteichosaIraiListHolder.saveNinteichosaIraiList(list);

        Button btnToCallNext = div.getButtonsForNinteichosaIraiEntry().getBtnToCallNext();

        if (!_isLast(div, _selectedItems(div2))) {
            btnToCallNext.setDisabled(false);
        }

        response.data = div;
        return response;
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

        div.getTxtCurrentIndex().setValue(new Decimal(_currentIndex(div) + 1));
        _setUp(div, _selectedItems(div2));

        response.data = div;
        return response;
    }

    private static final class NinteichosaIraiEntryTarget {

        private static void setUp(NinteichosaIraiEntryTargetDiv div, dgNinteichosaIraiList_Row item) {
            div.getTxtBirthDay().setValue(item.get生年月日().getValue());
            div.getTxtGender().setValue(item.get性別());
            div.getTxtHihokenshaNo().setValue(item.get被保険者番号());
            div.getTxtJusho().setValue(item.get住所());
            div.getTxtShikibetsuCode().setValue(item.get識別コード());
            div.getTxtShimei().setValue(item.get氏名());
            div.getTxtYubinNo().setValue(new YubinNo(item.get郵便番号()));
            NinteichosaIraiEntryTargetLatestChosain.setUp(div.getNinteichosaIraiEntryTargetLatestChosain(), item);
        }

        private static final class NinteichosaIraiEntryTargetLatestChosain {

            private static void setUp(NinteichosaIraiEntryTargetLatestChosainDiv div, dgNinteichosaIraiList_Row item) {
                div.getTxtLatestChosaItakusakiCode().setValue(item.get前回調査委託先コード());
                div.getTxtLatestChosaItakusakiName().setValue(item.get前回調査委託先());
                div.getTxtLatestChosainCode().setValue(item.get前回調査員コード());
                div.getTxtLatestChosainCode().setValue(item.get前回調査員());
            }

        }
    }

    private static final class NinteichosaIraiEntryContent {

        private static void setUp(NinteichosaIraiEntryContentDiv div, dgNinteichosaIraiList_Row item) {
            NinteichosaIraiEntryTargetChosain.setUp(div.getNinteichosaIraiEntryTargetChosain(), item);
            NinteichosaIraiEntryRequest.setUp(div.getNinteichosaIraiEntryRequest(), item);
            NinteichosaIraiEntryTargetTokusoku.setUp(div.getNinteichosaIraiEntryTargetTokusoku(), item);
        }

        private static void reflectInputedContentTo(dgNinteichosaIraiList_Row item, NinteichosaIraiEntryContentDiv div) {
            NinteichosaIraiEntryTargetChosain.reflectContentTo(item, div.getNinteichosaIraiEntryTargetChosain());
            NinteichosaIraiEntryRequest.reflectContentTo(item, div.getNinteichosaIraiEntryRequest());
            NinteichosaIraiEntryTargetTokusoku.reflectContentTo(item, div.getNinteichosaIraiEntryTargetTokusoku());
            item.set依頼書発行済(NinteichosaIraiEntryRequest.is依頼書発行済み(div.getNinteichosaIraiEntryRequest()));
            System.out.println("依頼書発行済み : " + NinteichosaIraiEntryRequest.is依頼書発行済み(div.getNinteichosaIraiEntryRequest()));
            item.set依頼登録済(
                    NinteichosaIraiEntryRequest.is登録済み(div.getNinteichosaIraiEntryRequest())
                    && NinteichosaIraiEntryTargetChosain.is登録済み(div.getNinteichosaIraiEntryTargetChosain()));
            System.out.println("依頼書登録済み : " + (NinteichosaIraiEntryRequest.is登録済み(div.getNinteichosaIraiEntryRequest())
                    && NinteichosaIraiEntryTargetChosain.is登録済み(div.getNinteichosaIraiEntryTargetChosain())));
        }

        private static boolean is依頼登録済(NinteichosaIraiEntryContentDiv div) {
            return true;
        }

        private static final class NinteichosaIraiEntryTargetChosain {

            private static void setUp(NinteichosaIraiEntryTargetChosainDiv div, dgNinteichosaIraiList_Row item) {
                div.getTxtChosaItakusakiCode().setValue(item.get調査委託先コード());
                div.getTxtChosaItakusakiName().setValue(item.get調査委託先());
                div.getTxtChosainCode().setValue(item.get調査員コード());
                div.getTxtChosainName().setValue(item.get調査員());
            }

            private static void reflectContentTo(dgNinteichosaIraiList_Row item, NinteichosaIraiEntryTargetChosainDiv div) {
                item.set調査委託先コード(div.getTxtChosaItakusakiCode().getValue());
                item.set調査委託先(div.getTxtChosaItakusakiName().getValue());
                item.set調査員コード(div.getTxtChosainCode().getValue());
                item.set調査員(div.getTxtChosainName().getValue());
            }

            private static boolean is登録済み(NinteichosaIraiEntryTargetChosainDiv div) {
                return !(div.getTxtChosaItakusakiCode().getValue().equals(RString.EMPTY)
                        || div.getTxtChosainCode().getValue().equals(RString.EMPTY));
            }
        }

        private static final class NinteichosaIraiEntryRequest {

            private static void setUp(NinteichosaIraiEntryRequestDiv div, dgNinteichosaIraiList_Row item) {
                div.getDdlChosaIraiKubun().setSelectedItem(composeKey(item.get調査依頼区分()));
                div.getTxtChosaIraiDate().setValue(item.get調査依頼日().getValue());
                div.getTxtChosaKigenDate().setValue(item.get調査期限日().getValue());
                div.getTxtIraishoHakkoDate().setValue(item.get調査依頼書発行日().getValue());
            }

            private static RString composeKey(RString value) {
                System.out.println(value.substring(0, 0));
                return value.equals(RString.EMPTY) ? new RString("1") : value.substring(0, 0);
            }

            private static void reflectContentTo(dgNinteichosaIraiList_Row item, NinteichosaIraiEntryRequestDiv div) {
                item.set調査依頼区分(div.getDdlChosaIraiKubun().getSelectedValue());
                item.get調査依頼日().setValue(div.getTxtChosaIraiDate().getValue());
                item.get調査期限日().setValue(div.getTxtChosaKigenDate().getValue());
                item.get調査依頼書発行日().setValue(div.getTxtIraishoHakkoDate().getValue());
            }

            private static boolean is登録済み(NinteichosaIraiEntryRequestDiv div) {
                return !(div.getTxtChosaIraiDate().getValue() == null
                        || div.getTxtChosaKigenDate().getValue() == null);
            }

            private static boolean is依頼書発行済み(NinteichosaIraiEntryRequestDiv div) {
                FlexibleDate iraishoHakkoDate = div.getTxtIraishoHakkoDate().getValue();
                return !(iraishoHakkoDate == null || iraishoHakkoDate.equals(FlexibleDate.EMPTY));
            }
        }

        private static final class NinteichosaIraiEntryTargetTokusoku {

            private static void setUp(NinteichosaIraiEntryTargetTokusokuDiv div, dgNinteichosaIraiList_Row item) {
                div.getDdlTokukuHoho().setSelectedItem(composeKey(item.get督促方法()));
                div.getTxtTokusokuCount().setValue(item.get督促回数());
                div.getTxtTokusokuDate().setValue(item.get督促年月日().getValue());
                div.getTxtTokusokujoHakkoDate().setValue(item.get督促発行日().getValue());
                div.getTxtTokusokuKigenDate().setValue(item.get督促期限日().getValue());
            }

            private static RString composeKey(RString value) {
                return value.equals(RString.EMPTY) ? new RString("0") : value.substring(0, 0);
            }

            private static void reflectContentTo(dgNinteichosaIraiList_Row item, NinteichosaIraiEntryTargetTokusokuDiv div) {
                item.set督促方法(div.getDdlTokukuHoho().getSelectedValue());
                item.set督促回数(div.getTxtTokusokuCount().getValue());
                item.get督促年月日().setValue(div.getTxtTokusokuDate().getValue());
                item.get督促発行日().setValue(div.getTxtTokusokujoHakkoDate().getValue());
                item.get督促期限日().setValue(div.getTxtTokusokuKigenDate().getValue());
            }
        }
    }

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

    private static int _currentIndex(NinteichosaIraiEntryDiv div) {
        return div.getTxtCurrentIndex().getValue().intValue();
    }

    private static List<dgNinteichosaIraiList_Row> _selectedItems(NinteichosaIraiListDiv div2) {
        return div2.getDgNinteichosaIraiList().getSelectedItems();
    }

    private static NinteichosaIraiEntryPaperDiv _paper(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryPaper();
    }

    private static NinteichosaIraiEntryRequestDiv _request(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryRequest();
    }

    private static NinteichosaIraiEntryTargetTokusokuDiv _tokusoku(NinteichosaIraiEntryDiv div) {
        return div.getNinteichosaIraiEntryContent().getNinteichosaIraiEntryTargetTokusoku();
    }
}
