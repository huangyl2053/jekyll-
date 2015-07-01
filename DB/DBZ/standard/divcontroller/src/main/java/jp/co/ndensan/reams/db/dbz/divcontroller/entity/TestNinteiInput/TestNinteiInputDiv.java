package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestNinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestNinteiInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestNinteiInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radModeSet")
    private RadioButton radModeSet;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtIfShikibetsuCode")
    private TextBox txtIfShikibetsuCode;
    @JsonProperty("txtShinseishoKanriNo")
    private TextBox txtShinseishoKanriNo;
    @JsonProperty("btnLoad")
    private Button btnLoad;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("ccdNinteiInput")
    private NinteiInputDiv ccdNinteiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radModeSet")
    public RadioButton getRadModeSet() {
        return radModeSet;
    }

    @JsonProperty("radModeSet")
    public void setRadModeSet(RadioButton radModeSet) {
        this.radModeSet=radModeSet;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtIfShikibetsuCode")
    public TextBox getTxtIfShikibetsuCode() {
        return txtIfShikibetsuCode;
    }

    @JsonProperty("txtIfShikibetsuCode")
    public void setTxtIfShikibetsuCode(TextBox txtIfShikibetsuCode) {
        this.txtIfShikibetsuCode=txtIfShikibetsuCode;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public TextBox getTxtShinseishoKanriNo() {
        return txtShinseishoKanriNo;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public void setTxtShinseishoKanriNo(TextBox txtShinseishoKanriNo) {
        this.txtShinseishoKanriNo=txtShinseishoKanriNo;
    }

    @JsonProperty("btnLoad")
    public Button getBtnLoad() {
        return btnLoad;
    }

    @JsonProperty("btnLoad")
    public void setBtnLoad(Button btnLoad) {
        this.btnLoad=btnLoad;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("ccdNinteiInput")
    public INinteiInputDiv getCcdNinteiInput() {
        return ccdNinteiInput;
    }

    // </editor-fold>
}
