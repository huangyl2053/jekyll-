package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020003.dgResultList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("ResultListPanel")
    private ResultListPanelDiv ResultListPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchConditionPanel")
    public SearchConditionPanelDiv getSearchConditionPanel() {
        return SearchConditionPanel;
    }

    @JsonProperty("SearchConditionPanel")
    public void setSearchConditionPanel(SearchConditionPanelDiv SearchConditionPanel) {
        this.SearchConditionPanel=SearchConditionPanel;
    }

    @JsonProperty("ResultListPanel")
    public ResultListPanelDiv getResultListPanel() {
        return ResultListPanel;
    }

    @JsonProperty("ResultListPanel")
    public void setResultListPanel(ResultListPanelDiv ResultListPanel) {
        this.ResultListPanel=ResultListPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblSearchConditionDiv getTblSearchCondition() {
        return this.getSearchConditionPanel().getTblSearchCondition();
    }

    @JsonIgnore
    public void  setTblSearchCondition(tblSearchConditionDiv tblSearchCondition) {
        this.getSearchConditionPanel().setTblSearchCondition(tblSearchCondition);
    }

    @JsonIgnore
    public RadioButton getRadKensakuTaisho() {
        return this.getSearchConditionPanel().getTblSearchCondition().getRadKensakuTaisho();
    }

    @JsonIgnore
    public TextBox getTxtMaxRow() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtMaxRow();
    }

    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.getSearchConditionPanel().getTblSearchCondition().getDdlHokensha();
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtShimei();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiShinseiYMD() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtNinteiShinseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusaki() {
        return this.getSearchConditionPanel().getTblSearchCondition().getDdlNinteiChosaItakusaki();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiChosaYMD() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtNinteiChosaYMD();
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaShimei() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtKanaShimei();
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthDay() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtBirthDay();
    }

    @JsonIgnore
    public TextBox getTxtMemo() {
        return this.getSearchConditionPanel().getTblSearchCondition().getTxtMemo();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosain() {
        return this.getSearchConditionPanel().getTblSearchCondition().getDdlNinteiChosain();
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchConditionPanel().getTblSearchCondition().getBtnSearch();
    }

    @JsonIgnore
    public DataGrid<dgResultList_Row> getDgResultList() {
        return this.getResultListPanel().getDgResultList();
    }

    @JsonIgnore
    public void  setDgResultList(DataGrid<dgResultList_Row> dgResultList) {
        this.getResultListPanel().setDgResultList(dgResultList);
    }

    // </editor-fold>
}
