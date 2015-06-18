package jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestShinseiSonotaJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestShinseiSonotaJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestShinseiSonotaJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSetMode")
    private RadioButton radSetMode;
    @JsonProperty("txtShinseishoKanriNo")
    private TextBox txtShinseishoKanriNo;
    @JsonProperty("btnLoad")
    private Button btnLoad;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("ccdShinseiSonotaJohoInput")
    private ShinseiSonotaJohoInputDiv ccdShinseiSonotaJohoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radSetMode")
    public RadioButton getRadSetMode() {
        return radSetMode;
    }

    @JsonProperty("radSetMode")
    public void setRadSetMode(RadioButton radSetMode) {
        this.radSetMode=radSetMode;
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

    @JsonProperty("ccdShinseiSonotaJohoInput")
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return ccdShinseiSonotaJohoInput;
    }

    // </editor-fold>
}
