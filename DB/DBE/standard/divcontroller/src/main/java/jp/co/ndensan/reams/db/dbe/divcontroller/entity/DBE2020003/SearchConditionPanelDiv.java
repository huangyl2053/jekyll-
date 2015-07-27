package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSearchCondition")
    private tblSearchConditionDiv tblSearchCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblSearchCondition")
    public tblSearchConditionDiv getTblSearchCondition() {
        return tblSearchCondition;
    }

    @JsonProperty("tblSearchCondition")
    public void setTblSearchCondition(tblSearchConditionDiv tblSearchCondition) {
        this.tblSearchCondition=tblSearchCondition;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKensakuTaisho() {
        return this.getTblSearchCondition().getRadKensakuTaisho();
    }

    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.getTblSearchCondition().getDdlHokensha();
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getTblSearchCondition().getTxtShimei();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiShinseiYMD() {
        return this.getTblSearchCondition().getTxtNinteiShinseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusaki() {
        return this.getTblSearchCondition().getDdlNinteiChosaItakusaki();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiChosaYMD() {
        return this.getTblSearchCondition().getTxtNinteiChosaYMD();
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getTblSearchCondition().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.getTblSearchCondition().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaShimei() {
        return this.getTblSearchCondition().getTxtKanaShimei();
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthDay() {
        return this.getTblSearchCondition().getTxtBirthDay();
    }

    @JsonIgnore
    public TextBox getTxtMemo() {
        return this.getTblSearchCondition().getTxtMemo();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosain() {
        return this.getTblSearchCondition().getDdlNinteiChosain();
    }

    @JsonIgnore
    public TextBox getTxtMaxRow() {
        return this.getTblSearchCondition().getTxtMaxRow();
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getTblSearchCondition().getBtnSearch();
    }

    // </editor-fold>
}
