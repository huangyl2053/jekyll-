package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020009;
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
    @JsonProperty("PrintConditionPanel")
    private PrintConditionPanelDiv PrintConditionPanel;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("PrintConditionPanel")
    public PrintConditionPanelDiv getPrintConditionPanel() {
        return PrintConditionPanel;
    }

    @JsonProperty("PrintConditionPanel")
    public void setPrintConditionPanel(PrintConditionPanelDiv PrintConditionPanel) {
        this.PrintConditionPanel=PrintConditionPanel;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTaishoShichoson() {
        return this.getPrintConditionPanel().getDdlTaishoShichoson();
    }

    @JsonIgnore
    public void  setDdlTaishoShichoson(DropDownList ddlTaishoShichoson) {
        this.getPrintConditionPanel().setDdlTaishoShichoson(ddlTaishoShichoson);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiChosaYoteiYMD() {
        return this.getPrintConditionPanel().getTxtNinteiChosaYoteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYoteiYMD(TextBoxDateRange txtNinteiChosaYoteiYMD) {
        this.getPrintConditionPanel().setTxtNinteiChosaYoteiYMD(txtNinteiChosaYoteiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoNinteiChosainShozokuKikan() {
        return this.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan();
    }

    @JsonIgnore
    public void  setDdlTaishoNinteiChosainShozokuKikan(DropDownList ddlTaishoNinteiChosainShozokuKikan) {
        this.getPrintConditionPanel().setDdlTaishoNinteiChosainShozokuKikan(ddlTaishoNinteiChosainShozokuKikan);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoNinteiChosain() {
        return this.getPrintConditionPanel().getDdlTaishoNinteiChosain();
    }

    @JsonIgnore
    public void  setDdlTaishoNinteiChosain(DropDownList ddlTaishoNinteiChosain) {
        this.getPrintConditionPanel().setDdlTaishoNinteiChosain(ddlTaishoNinteiChosain);
    }

    @JsonIgnore
    public RadioButton getRadJokyo() {
        return this.getPrintConditionPanel().getRadJokyo();
    }

    @JsonIgnore
    public void  setRadJokyo(RadioButton radJokyo) {
        this.getPrintConditionPanel().setRadJokyo(radJokyo);
    }

    // </editor-fold>
}
