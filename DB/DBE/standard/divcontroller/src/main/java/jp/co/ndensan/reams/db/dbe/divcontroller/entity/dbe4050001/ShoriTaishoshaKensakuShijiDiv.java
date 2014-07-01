package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShoriTaishoshaKensakuShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriTaishoshaKensakuShijiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("ddlKensakuTaisho")
    private DropDownList ddlKensakuTaisho;
    @JsonProperty("txtSearchStYMD")
    private TextBoxFlexibleDate txtSearchStYMD;
    @JsonProperty("txtSearchEdYMD")
    private TextBoxFlexibleDate txtSearchEdYMD;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxNum txtHihokenshaNo;
    @JsonProperty("btnTaishoKensaku")
    private Button btnTaishoKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("ddlKensakuTaisho")
    public DropDownList getDdlKensakuTaisho() {
        return ddlKensakuTaisho;
    }

    @JsonProperty("ddlKensakuTaisho")
    public void setDdlKensakuTaisho(DropDownList ddlKensakuTaisho) {
        this.ddlKensakuTaisho=ddlKensakuTaisho;
    }

    @JsonProperty("txtSearchStYMD")
    public TextBoxFlexibleDate getTxtSearchStYMD() {
        return txtSearchStYMD;
    }

    @JsonProperty("txtSearchStYMD")
    public void setTxtSearchStYMD(TextBoxFlexibleDate txtSearchStYMD) {
        this.txtSearchStYMD=txtSearchStYMD;
    }

    @JsonProperty("txtSearchEdYMD")
    public TextBoxFlexibleDate getTxtSearchEdYMD() {
        return txtSearchEdYMD;
    }

    @JsonProperty("txtSearchEdYMD")
    public void setTxtSearchEdYMD(TextBoxFlexibleDate txtSearchEdYMD) {
        this.txtSearchEdYMD=txtSearchEdYMD;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBoxNum getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxNum txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("btnTaishoKensaku")
    public Button getBtnTaishoKensaku() {
        return btnTaishoKensaku;
    }

    @JsonProperty("btnTaishoKensaku")
    public void setBtnTaishoKensaku(Button btnTaishoKensaku) {
        this.btnTaishoKensaku=btnTaishoKensaku;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

}
