package jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestChosaItakusakiAndchosainInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestChosaItakusakiAndchosainInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestChosaItakusakiAndchosainInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSubGyomuCode")
    private TextBox txtSubGyomuCode;
    @JsonProperty("txtShichosonCode")
    private TextBox txtShichosonCode;
    @JsonProperty("txtShinseishoKanriNo")
    private TextBox txtShinseishoKanriNo;
    @JsonProperty("btnSetinput")
    private Button btnSetinput;
    @JsonProperty("ccdChosaItakutsakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdChosaItakutsakiAndChosainInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSubGyomuCode")
    public TextBox getTxtSubGyomuCode() {
        return txtSubGyomuCode;
    }

    @JsonProperty("txtSubGyomuCode")
    public void setTxtSubGyomuCode(TextBox txtSubGyomuCode) {
        this.txtSubGyomuCode=txtSubGyomuCode;
    }

    @JsonProperty("txtShichosonCode")
    public TextBox getTxtShichosonCode() {
        return txtShichosonCode;
    }

    @JsonProperty("txtShichosonCode")
    public void setTxtShichosonCode(TextBox txtShichosonCode) {
        this.txtShichosonCode=txtShichosonCode;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public TextBox getTxtShinseishoKanriNo() {
        return txtShinseishoKanriNo;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public void setTxtShinseishoKanriNo(TextBox txtShinseishoKanriNo) {
        this.txtShinseishoKanriNo=txtShinseishoKanriNo;
    }

    @JsonProperty("btnSetinput")
    public Button getBtnSetinput() {
        return btnSetinput;
    }

    @JsonProperty("btnSetinput")
    public void setBtnSetinput(Button btnSetinput) {
        this.btnSetinput=btnSetinput;
    }

    @JsonProperty("ccdChosaItakutsakiAndChosainInput")
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakutsakiAndChosainInput() {
        return ccdChosaItakutsakiAndChosainInput;
    }

    // </editor-fold>
}
