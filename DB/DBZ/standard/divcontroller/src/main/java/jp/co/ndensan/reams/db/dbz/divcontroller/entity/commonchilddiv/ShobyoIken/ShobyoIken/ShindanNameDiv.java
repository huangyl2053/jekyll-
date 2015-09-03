package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShindanName のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShindanNameDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShindanName1")
    private TextBox txtShindanName1;
    @JsonProperty("txtShindanYMD1")
    private TextBoxDate txtShindanYMD1;
    @JsonProperty("txtShindanName2")
    private TextBox txtShindanName2;
    @JsonProperty("txtShindanYMD2")
    private TextBoxDate txtShindanYMD2;
    @JsonProperty("txtShindanName")
    private TextBox txtShindanName;
    @JsonProperty("txtShindanYMD3")
    private TextBoxDate txtShindanYMD3;
    @JsonProperty("btnShuyoShippeiGuide")
    private ButtonDialog btnShuyoShippeiGuide;
    @JsonProperty("txtShuyoShippeiCode")
    private TextBox txtShuyoShippeiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShindanName1")
    public TextBox getTxtShindanName1() {
        return txtShindanName1;
    }

    @JsonProperty("txtShindanName1")
    public void setTxtShindanName1(TextBox txtShindanName1) {
        this.txtShindanName1=txtShindanName1;
    }

    @JsonProperty("txtShindanYMD1")
    public TextBoxDate getTxtShindanYMD1() {
        return txtShindanYMD1;
    }

    @JsonProperty("txtShindanYMD1")
    public void setTxtShindanYMD1(TextBoxDate txtShindanYMD1) {
        this.txtShindanYMD1=txtShindanYMD1;
    }

    @JsonProperty("txtShindanName2")
    public TextBox getTxtShindanName2() {
        return txtShindanName2;
    }

    @JsonProperty("txtShindanName2")
    public void setTxtShindanName2(TextBox txtShindanName2) {
        this.txtShindanName2=txtShindanName2;
    }

    @JsonProperty("txtShindanYMD2")
    public TextBoxDate getTxtShindanYMD2() {
        return txtShindanYMD2;
    }

    @JsonProperty("txtShindanYMD2")
    public void setTxtShindanYMD2(TextBoxDate txtShindanYMD2) {
        this.txtShindanYMD2=txtShindanYMD2;
    }

    @JsonProperty("txtShindanName")
    public TextBox getTxtShindanName() {
        return txtShindanName;
    }

    @JsonProperty("txtShindanName")
    public void setTxtShindanName(TextBox txtShindanName) {
        this.txtShindanName=txtShindanName;
    }

    @JsonProperty("txtShindanYMD3")
    public TextBoxDate getTxtShindanYMD3() {
        return txtShindanYMD3;
    }

    @JsonProperty("txtShindanYMD3")
    public void setTxtShindanYMD3(TextBoxDate txtShindanYMD3) {
        this.txtShindanYMD3=txtShindanYMD3;
    }

    @JsonProperty("btnShuyoShippeiGuide")
    public ButtonDialog getBtnShuyoShippeiGuide() {
        return btnShuyoShippeiGuide;
    }

    @JsonProperty("btnShuyoShippeiGuide")
    public void setBtnShuyoShippeiGuide(ButtonDialog btnShuyoShippeiGuide) {
        this.btnShuyoShippeiGuide=btnShuyoShippeiGuide;
    }

    @JsonProperty("txtShuyoShippeiCode")
    public TextBox getTxtShuyoShippeiCode() {
        return txtShuyoShippeiCode;
    }

    @JsonProperty("txtShuyoShippeiCode")
    public void setTxtShuyoShippeiCode(TextBox txtShuyoShippeiCode) {
        this.txtShuyoShippeiCode=txtShuyoShippeiCode;
    }

    // </editor-fold>
}
