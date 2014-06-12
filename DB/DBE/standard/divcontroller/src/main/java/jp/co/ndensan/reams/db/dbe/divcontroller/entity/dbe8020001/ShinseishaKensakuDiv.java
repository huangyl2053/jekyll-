package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
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
 * ShinseishaKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaKensakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKeyHokensha")
    private DropDownList ddlKeyHokensha;
    @JsonProperty("txtKeyHihoNo")
    private TextBoxCode txtKeyHihoNo;
    @JsonProperty("txtKeyShinseibi")
    private TextBoxDate txtKeyShinseibi;
    @JsonProperty("ddlKeyShinseiKbn")
    private DropDownList ddlKeyShinseiKbn;
    @JsonProperty("ddlKeyHihokenshaKbn")
    private DropDownList ddlKeyHihokenshaKbn;
    @JsonProperty("txtKeyShimei")
    private TextBox txtKeyShimei;
    @JsonProperty("ddlKeyPadding")
    private DropDownList ddlKeyPadding;
    @JsonProperty("txtKeyUmareYmd")
    private TextBoxDate txtKeyUmareYmd;
    @JsonProperty("ddlKeySeibetsu")
    private DropDownList ddlKeySeibetsu;
    @JsonProperty("txtKeyYubinNo")
    private TextBoxYubinNo txtKeyYubinNo;
    @JsonProperty("txtKeyJusho")
    private TextBox txtKeyJusho;
    @JsonProperty("txtKeyTel")
    private TextBox txtKeyTel;
    @JsonProperty("btnShinseishaKensaku")
    private Button btnShinseishaKensaku;
    @JsonProperty("btnKensakuKeyClear")
    private Button btnKensakuKeyClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlKeyHokensha")
    public DropDownList getDdlKeyHokensha() {
        return ddlKeyHokensha;
    }

    @JsonProperty("ddlKeyHokensha")
    public void setDdlKeyHokensha(DropDownList ddlKeyHokensha) {
        this.ddlKeyHokensha=ddlKeyHokensha;
    }

    @JsonProperty("txtKeyHihoNo")
    public TextBoxCode getTxtKeyHihoNo() {
        return txtKeyHihoNo;
    }

    @JsonProperty("txtKeyHihoNo")
    public void setTxtKeyHihoNo(TextBoxCode txtKeyHihoNo) {
        this.txtKeyHihoNo=txtKeyHihoNo;
    }

    @JsonProperty("txtKeyShinseibi")
    public TextBoxDate getTxtKeyShinseibi() {
        return txtKeyShinseibi;
    }

    @JsonProperty("txtKeyShinseibi")
    public void setTxtKeyShinseibi(TextBoxDate txtKeyShinseibi) {
        this.txtKeyShinseibi=txtKeyShinseibi;
    }

    @JsonProperty("ddlKeyShinseiKbn")
    public DropDownList getDdlKeyShinseiKbn() {
        return ddlKeyShinseiKbn;
    }

    @JsonProperty("ddlKeyShinseiKbn")
    public void setDdlKeyShinseiKbn(DropDownList ddlKeyShinseiKbn) {
        this.ddlKeyShinseiKbn=ddlKeyShinseiKbn;
    }

    @JsonProperty("ddlKeyHihokenshaKbn")
    public DropDownList getDdlKeyHihokenshaKbn() {
        return ddlKeyHihokenshaKbn;
    }

    @JsonProperty("ddlKeyHihokenshaKbn")
    public void setDdlKeyHihokenshaKbn(DropDownList ddlKeyHihokenshaKbn) {
        this.ddlKeyHihokenshaKbn=ddlKeyHihokenshaKbn;
    }

    @JsonProperty("txtKeyShimei")
    public TextBox getTxtKeyShimei() {
        return txtKeyShimei;
    }

    @JsonProperty("txtKeyShimei")
    public void setTxtKeyShimei(TextBox txtKeyShimei) {
        this.txtKeyShimei=txtKeyShimei;
    }

    @JsonProperty("ddlKeyPadding")
    public DropDownList getDdlKeyPadding() {
        return ddlKeyPadding;
    }

    @JsonProperty("ddlKeyPadding")
    public void setDdlKeyPadding(DropDownList ddlKeyPadding) {
        this.ddlKeyPadding=ddlKeyPadding;
    }

    @JsonProperty("txtKeyUmareYmd")
    public TextBoxDate getTxtKeyUmareYmd() {
        return txtKeyUmareYmd;
    }

    @JsonProperty("txtKeyUmareYmd")
    public void setTxtKeyUmareYmd(TextBoxDate txtKeyUmareYmd) {
        this.txtKeyUmareYmd=txtKeyUmareYmd;
    }

    @JsonProperty("ddlKeySeibetsu")
    public DropDownList getDdlKeySeibetsu() {
        return ddlKeySeibetsu;
    }

    @JsonProperty("ddlKeySeibetsu")
    public void setDdlKeySeibetsu(DropDownList ddlKeySeibetsu) {
        this.ddlKeySeibetsu=ddlKeySeibetsu;
    }

    @JsonProperty("txtKeyYubinNo")
    public TextBoxYubinNo getTxtKeyYubinNo() {
        return txtKeyYubinNo;
    }

    @JsonProperty("txtKeyYubinNo")
    public void setTxtKeyYubinNo(TextBoxYubinNo txtKeyYubinNo) {
        this.txtKeyYubinNo=txtKeyYubinNo;
    }

    @JsonProperty("txtKeyJusho")
    public TextBox getTxtKeyJusho() {
        return txtKeyJusho;
    }

    @JsonProperty("txtKeyJusho")
    public void setTxtKeyJusho(TextBox txtKeyJusho) {
        this.txtKeyJusho=txtKeyJusho;
    }

    @JsonProperty("txtKeyTel")
    public TextBox getTxtKeyTel() {
        return txtKeyTel;
    }

    @JsonProperty("txtKeyTel")
    public void setTxtKeyTel(TextBox txtKeyTel) {
        this.txtKeyTel=txtKeyTel;
    }

    @JsonProperty("btnShinseishaKensaku")
    public Button getBtnShinseishaKensaku() {
        return btnShinseishaKensaku;
    }

    @JsonProperty("btnShinseishaKensaku")
    public void setBtnShinseishaKensaku(Button btnShinseishaKensaku) {
        this.btnShinseishaKensaku=btnShinseishaKensaku;
    }

    @JsonProperty("btnKensakuKeyClear")
    public Button getBtnKensakuKeyClear() {
        return btnKensakuKeyClear;
    }

    @JsonProperty("btnKensakuKeyClear")
    public void setBtnKensakuKeyClear(Button btnKensakuKeyClear) {
        this.btnKensakuKeyClear=btnKensakuKeyClear;
    }

}
