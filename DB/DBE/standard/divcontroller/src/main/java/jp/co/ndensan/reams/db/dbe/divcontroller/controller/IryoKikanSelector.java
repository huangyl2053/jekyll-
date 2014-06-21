/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiData.Doctor;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiIryoKikanData;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiIryoKikanData.IryoKikan;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IryoKikanListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IryoKikanSelectorDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IshiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.SelectedContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.dgIryoKikanList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.dgIshiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * 医療機関検索用ダイアログ用のクラスです。
 *
 * @author N1013 松本直樹
 */
public class IryoKikanSelector {

    /**
     * onLoad
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onLoad(IryoKikanSelectorDiv div) {
        div.getIryoKikan().getIryoKikanList().
                getDgIryoKikanList().setDataSource(
                        toDataSouceForDgIryoKikanList(find医療機関All())
                );
        div.getBtnSelectAndClose().setDisabled(true);
        return _createResponseData(div);
    }

    private List<IryoKikan> find医療機関All() {
        return new ShujiiIryoKikanData().get医療機関一覧().asConvetedType();
    }

    private List<dgIryoKikanList_Row> toDataSouceForDgIryoKikanList(List<IryoKikan> iryoKikans) {
        List<dgIryoKikanList_Row> dataSource = new ArrayList<>();
        for (IryoKikan kikan : iryoKikans) {
            dataSource.add(toDgIryoKikanList_Row(kikan));
        }
        return dataSource;
    }

    private dgIryoKikanList_Row toDgIryoKikanList_Row(IryoKikan kikan) {
        return new dgIryoKikanList_Row(kikan.code(), kikan.name());
    }

    /**
     * 医療機関一覧のonSelect時の処理です。
     *
     * @param div 医師リストDiv
     * @param kikan 医療機関リストDiv
     * @return ResponseData
     */
    public ResponseData<IshiListDiv> onSelect_dgIryoKikanList(IshiListDiv div, IryoKikanListDiv kikan) {
        for (dgIryoKikanList_Row row : extractDataSouceOf(kikan)) {
            if (row.getSelected()) {
                RString iryoKikanCode = row.getIryoKikanNo();
                div.getDgIshiList().setDataSource(
                        toDataSouceForDgChosainList(find所属医師AllFrom(iryoKikanCode))
                );
                break;//ミリ秒単位で、getSelectedItems.get(0)よりはやい。
            }
        }
        return _createResponseData(div);
    }

    private List<dgIryoKikanList_Row> extractDataSouceOf(IryoKikanListDiv kikan) {
        return kikan.getDgIryoKikanList().getDataSource();
    }

    private List<Doctor> find所属医師AllFrom(RString iryoKikanCode) {
        return new ShujiiData().get医師ListOf(iryoKikanCode).asConvetedType();
    }

    private List<dgIshiList_Row> toDataSouceForDgChosainList(List<Doctor> doctors) {
        List<dgIshiList_Row> dataSource = new ArrayList<>();
        for (Doctor doctor : doctors) {
            dataSource.add(toDgIshiList_Row(doctor));
        }
        return dataSource;
    }

    private dgIshiList_Row toDgIshiList_Row(Doctor doctor) {
        return new dgIshiList_Row(doctor.code(), doctor.name());
    }

    /**
     * 医療機関を、ダブルクリックで、選択した時の処理です。
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onSelectByDC_IryoKikan(IryoKikanSelectorDiv div) {
        setIntoSelectedContens_IryoKikan(div, selectedItem(_dgIryoKikanList(div)));
        return _common_onSelect_IryoKikan(div);
    }

    private DataGrid<dgIryoKikanList_Row> _dgIryoKikanList(IryoKikanSelectorDiv div) {
        return div.getIryoKikan().getIryoKikanList().getDgIryoKikanList();
    }

    private <T extends DataRow> T selectedItem(DataGrid<T> dataGrid) {
        return dataGrid.getSelectedItems().get(0);
    }

    private void setIntoSelectedContens_IryoKikan(IryoKikanSelectorDiv div, dgIryoKikanList_Row kikan) {
        SelectedContentsDivEditor editor = new SelectedContentsDivEditor(div);
        editor.set医療機関(kikan.getIryoKikanNo(), kikan.getIryoKikanName());
    }

    private ResponseData<IryoKikanSelectorDiv> _common_onSelect_IryoKikan(IryoKikanSelectorDiv div) {
        new SelectedContentsDivEditor(div).clear医師();
        return _common_onSelect(div);
    }

    private ResponseData<IryoKikanSelectorDiv> _common_onSelect(IryoKikanSelectorDiv div) {
        div.getBtnSelectAndClose().setDisabled(new SelectedContentsDivEditor(div).isSelectedContentsEmpty());
        return _createResponseData(div);
    }

    /**
     * 医療機関を、選択ボタンで、選択した時の処理です。
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onSelectBySB_IryoKikan(IryoKikanSelectorDiv div) {
        setIntoSelectedContens_IryoKikan(div, _dgIryoKikanList(div).getClickedItem());
        return _common_onSelect_IryoKikan(div);
    }

    /**
     * 医師を、ダブルクリックで、選択した際の処理です。
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onSelectByDC_Ishi(IryoKikanSelectorDiv div) {
        setIntoSelectedContens_Ishi(div, selectedItem(_dgIshiList(div)));
        return _common_onSelect_Ishi(div);
    }

    /**
     * 医師を、選択ボタンで、選択した際の処理です。
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onSelectBySB_Ishi(IryoKikanSelectorDiv div) {
        setIntoSelectedContens_Ishi(div, _dgIshiList(div).getClickedItem());
        return _common_onSelect_Ishi(div);
    }

    private ResponseData<IryoKikanSelectorDiv> _common_onSelect_Ishi(IryoKikanSelectorDiv div) {
        setIntoSelectedContens_IryoKikan(div, _dgIryoKikanList(div).getSelectedItems().get(0));
        return _common_onSelect(div);
    }

    private void setIntoSelectedContens_Ishi(IryoKikanSelectorDiv div, dgIshiList_Row ishi) {
        SelectedContentsDivEditor editor = new SelectedContentsDivEditor(div);
        editor.set医師(ishi.getIshiNo(), ishi.getIshiName());
    }

    private DataGrid<dgIshiList_Row> _dgIshiList(IryoKikanSelectorDiv div) {
        return div.getIryoKikan().getIshi().getIshiList().getDgIshiList();
    }

    /**
     * onClick btnSelectAndClose
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onClick_btnSelectAndClose(IryoKikanSelectorDiv div) {
        new SelectedContentsDivEditor(div).reflectValueTo(div);
        return _createResponseData(div);
    }

    /**
     * onClick btnNonSelectReturn
     *
     * @param div IryoKikanSelectorDiv
     * @return ResponseData
     */
    public ResponseData<IryoKikanSelectorDiv> onClick_btnNonSelectReturn(IryoKikanSelectorDiv div) {
        return _createResponseData(div);
    }

    /**
     * 選択結果を入れるDivを操作するためのクラスです。
     */
    private static class SelectedContentsDivEditor {

        private final SelectedContentsDiv panel;

        private SelectedContentsDivEditor(IryoKikanSelectorDiv div) {
            this.panel = div.getSelectedContents();
        }

        public void set医療機関(RString code, RString name) {
            panel.getTxtiryoKikanCode().setValue(code);
            panel.getTxtiryoKikanName().setValue(name);
        }

        public void set医師(RString code, RString name) {
            panel.getTxtishiCode().setValue(code);
            panel.getTxtishiName().setValue(name);
        }

        public void clear医療機関() {
            panel.getTxtiryoKikanCode().clearValue();
            panel.getTxtiryoKikanName().clearValue();
        }

        public void clear医師() {
            panel.getTxtishiCode().clearValue();
            panel.getTxtishiName().clearValue();
        }

        public void reflectValueTo(IryoKikanSelectorDiv div) {
            div.setIryoKikanCode(panel.getTxtiryoKikanCode().getValue());
            div.setIryoKikanName(panel.getTxtiryoKikanName().getValue());
            div.setIshiCode(panel.getTxtishiCode().getValue());
            div.setIshiName(panel.getTxtishiName().getValue());
        }

        public boolean isSelectedContentsEmpty() {
            return isEmpty(panel.getTxtiryoKikanCode())
                    && isEmpty(panel.getTxtiryoKikanName())
                    && isEmpty(panel.getTxtishiCode())
                    && isEmpty(panel.getTxtishiName());
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
