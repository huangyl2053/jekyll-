/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosaItakusakiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosaItakusakiData.ChosaItakusaki;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData.Chosain;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosaItakusakiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosaItakusakiSelectorDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.SelectedContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.dgChosaItakusakiList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.dgChosainList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 *
 * @author N3327 三浦 凌
 */
public class ChosaItakusakiSelector {

    /**
     * onLoad
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onLoad(ChosaItakusakiSelectorDiv div) {
        div.getChosaItakusaki().getChosaItakusakiList().
                getDgChosaItakusakiList().setDataSource(
                        toDataSouceForDgChosaItakusakiList(find調査委託先All())
                );
        div.getBtnSelectAndClose().setDisabled(true);
        return _createResponseData(div);
    }

    private List<ChosaItakusaki> find調査委託先All() {
        return new ChosaItakusakiData().get調査委託先一覧().asConvetedType();
    }

    private List<dgChosaItakusakiList_Row> toDataSouceForDgChosaItakusakiList(List<ChosaItakusaki> chosaItakusakis) {
        List<dgChosaItakusakiList_Row> dataSource = new ArrayList<>();
        for (ChosaItakusaki itakusaki : chosaItakusakis) {
            dataSource.add(toDdChosaItakusakiList_Row(itakusaki));
        }
        return dataSource;
    }

    private dgChosaItakusakiList_Row toDdChosaItakusakiList_Row(ChosaItakusaki itakusaki) {
        return new dgChosaItakusakiList_Row(itakusaki.code(), itakusaki.name());
    }

    /**
     * 調査委託先一覧のonSelect時の処理です。
     *
     * @param div
     * @param itakusaki
     * @return
     */
    public ResponseData<ChosainListDiv> onSelect_dgChosaItakusakiList(ChosainListDiv div, ChosaItakusakiListDiv itakusaki) {
        for (dgChosaItakusakiList_Row row : extractDataSouceOf(itakusaki)) {
            if (row.getSelected()) {
                RString chosaItakusakiCode = row.getChosaItakusakiNo();
                div.getDgChosainList().setDataSource(
                        toDataSouceForDgChosainList(find所属調査員AllFrom(chosaItakusakiCode))
                );
                break;//ミリ秒単位で、getSelectedItems.get(0)よりはやい。
            }
        }
        return _createResponseData(div);
    }

    private List<dgChosaItakusakiList_Row> extractDataSouceOf(ChosaItakusakiListDiv itakusaki) {
        return itakusaki.getDgChosaItakusakiList().getDataSource();
    }

    private List<Chosain> find所属調査員AllFrom(RString chosaItakusakiCode) {
        return new ChosainData().get調査員ListOf(chosaItakusakiCode).asConvetedType();
    }

    private List<dgChosainList_Row> toDataSouceForDgChosainList(List<Chosain> chosains) {
        List<dgChosainList_Row> dataSource = new ArrayList<>();
        for (Chosain chosain : chosains) {
            dataSource.add(toDgChosainList_Row(chosain));
        }
        return dataSource;
    }

    private dgChosainList_Row toDgChosainList_Row(Chosain chosain) {
        return new dgChosainList_Row(chosain.code(), chosain.name());
    }

    /**
     * 調査委託先を、ダブルクリックで、選択した時の処理です。
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onSelectByDC_ChosaItakusaki(ChosaItakusakiSelectorDiv div) {
        setIntoSelectedContens_ChosaItakusaki(div, selectedItem(_dgChosaItakusakiList(div)));
        return _common_onSelect_ChosaItakusaki(div);
    }

    private DataGrid<dgChosaItakusakiList_Row> _dgChosaItakusakiList(ChosaItakusakiSelectorDiv div) {
        return div.getChosaItakusaki().getChosaItakusakiList().getDgChosaItakusakiList();
    }

    private <T extends DataRow> T selectedItem(DataGrid<T> dataGrid) {
        return dataGrid.getSelectedItems().get(0);
    }

    private void setIntoSelectedContens_ChosaItakusaki(ChosaItakusakiSelectorDiv div, dgChosaItakusakiList_Row itakusaki) {
        SelectedContentsDivEditor editor = new SelectedContentsDivEditor(div);
        editor.set調査委託先(itakusaki.getChosaItakusakiNo(), itakusaki.getChosaItakusakiName());
    }

    private ResponseData<ChosaItakusakiSelectorDiv> _common_onSelect_ChosaItakusaki(ChosaItakusakiSelectorDiv div) {
        new SelectedContentsDivEditor(div).clear調査員();
        return _common_onSelect(div);
    }

    private ResponseData<ChosaItakusakiSelectorDiv> _common_onSelect(ChosaItakusakiSelectorDiv div) {
        div.getBtnSelectAndClose().setDisabled(new SelectedContentsDivEditor(div).isSelectedContentsEmpty());
        return _createResponseData(div);
    }

    /**
     * 調査委託先を、選択ボタンで、選択した時の処理です。
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onSelectBySB_ChosaItakusaki(ChosaItakusakiSelectorDiv div) {
        setIntoSelectedContens_ChosaItakusaki(div, _dgChosaItakusakiList(div).getClickedItem());
        return _common_onSelect_ChosaItakusaki(div);
    }

    /**
     * 調査員を、ダブルクリックで、選択した際の処理です。
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onSelectByDC_Chosain(ChosaItakusakiSelectorDiv div) {
        setIntoSelectedContens_Chosain(div, selectedItem(_dgChosainList(div)));
        return _common_onSelect_Chosain(div);
    }

    /**
     * 調査員を、選択ボタンで、選択した際の処理です。
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onSelectBySB_Chosain(ChosaItakusakiSelectorDiv div) {
        setIntoSelectedContens_Chosain(div, _dgChosainList(div).getClickedItem());
        return _common_onSelect_Chosain(div);
    }

    private ResponseData<ChosaItakusakiSelectorDiv> _common_onSelect_Chosain(ChosaItakusakiSelectorDiv div) {
        setIntoSelectedContens_ChosaItakusaki(div, _dgChosaItakusakiList(div).getSelectedItems().get(0));
        return _common_onSelect(div);
    }

    private void setIntoSelectedContens_Chosain(ChosaItakusakiSelectorDiv div, dgChosainList_Row chosain) {
        SelectedContentsDivEditor editor = new SelectedContentsDivEditor(div);
        editor.set調査員(chosain.getChosainNo(), chosain.getChosainName());
    }

    private DataGrid<dgChosainList_Row> _dgChosainList(ChosaItakusakiSelectorDiv div) {
        return div.getChosaItakusaki().getChosain().getChosainList().getDgChosainList();
    }

    /**
     * onClick btnSelectAndClose
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onClick_btnSelectAndClose(ChosaItakusakiSelectorDiv div) {
        new SelectedContentsDivEditor(div).reflectValueTo(div);
        return _createResponseData(div);
    }

    /**
     * onClick btnNonSelectReturn
     *
     * @param div ChosaItakusakiSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ChosaItakusakiSelectorDiv> onClick_btnNonSelectReturn(ChosaItakusakiSelectorDiv div) {
        return _createResponseData(div);
    }

    /**
     * 選択結果を入れるDivを操作するためのクラスです。
     */
    private static class SelectedContentsDivEditor {

        private final SelectedContentsDiv panel;

        private SelectedContentsDivEditor(ChosaItakusakiSelectorDiv div) {
            this.panel = div.getSelectedContents();
        }

        public void set調査委託先(RString code, RString name) {
            panel.getTxtChosaItakusakiCode().setValue(code);
            panel.getTxtChosaItakusakiName().setValue(name);
        }

        public void set調査員(RString code, RString name) {
            panel.getTxtChosainCode().setValue(code);
            panel.getTxtChosainName().setValue(name);
        }

        public void clear調査委託先() {
            panel.getTxtChosaItakusakiCode().clearValue();
            panel.getTxtChosaItakusakiName().clearValue();
        }

        public void clear調査員() {
            panel.getTxtChosainCode().clearValue();
            panel.getTxtChosainName().clearValue();
        }

        public void reflectValueTo(ChosaItakusakiSelectorDiv div) {
            div.setChosaItakusakiCode(panel.getTxtChosaItakusakiCode().getValue());
            div.setChosaItakusakiName(panel.getTxtChosaItakusakiName().getValue());
            div.setChosainCode(panel.getTxtChosainCode().getValue());
            div.setChosainName(panel.getTxtChosainName().getValue());
        }

        public boolean isSelectedContentsEmpty() {
            return isEmpty(panel.getTxtChosaItakusakiCode())
                    && isEmpty(panel.getTxtChosaItakusakiName())
                    && isEmpty(panel.getTxtChosainCode())
                    && isEmpty(panel.getTxtChosainName());
        }

        private boolean isEmpty(TextBox txtBox) {
            return txtBox.getValue().equals(RString.EMPTY);
        }

        private boolean isEmpty(TextBoxCode txtBoxCode) {
            return txtBoxCode.getValue().equals(RString.EMPTY);
        }
    }

    private <T> ResponseData<T> _createResponseData(T div) {
        ResponseData<T> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
