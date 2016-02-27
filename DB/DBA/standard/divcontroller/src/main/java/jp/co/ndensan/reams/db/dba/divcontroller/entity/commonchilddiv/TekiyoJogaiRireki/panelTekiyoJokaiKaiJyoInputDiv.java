package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelTekiyoJokaiKaiJyoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelTekiyoJokaiKaiJyoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelJogaisyaKaijo")
    private panelJogaisyaKaijoDiv panelJogaisyaKaijo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("idoYMD")
    private RString idoYMD;
    @JsonProperty("edaNo")
    private RString edaNo;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelJogaisyaKaijo
     * @return panelJogaisyaKaijo
     */
    @JsonProperty("panelJogaisyaKaijo")
    public panelJogaisyaKaijoDiv getPanelJogaisyaKaijo() {
        return panelJogaisyaKaijo;
    }

    /*
     * setpanelJogaisyaKaijo
     * @param panelJogaisyaKaijo panelJogaisyaKaijo
     */
    @JsonProperty("panelJogaisyaKaijo")
    public void setPanelJogaisyaKaijo(panelJogaisyaKaijoDiv panelJogaisyaKaijo) {
        this.panelJogaisyaKaijo = panelJogaisyaKaijo;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getidoYMD
     * @return idoYMD
     */
    @JsonProperty("idoYMD")
    public RString getIdoYMD() {
        return idoYMD;
    }

    /*
     * setidoYMD
     * @param idoYMD idoYMD
     */
    @JsonProperty("idoYMD")
    public void setIdoYMD(RString idoYMD) {
        this.idoYMD = idoYMD;
    }

    /*
     * getedaNo
     * @return edaNo
     */
    @JsonProperty("edaNo")
    public RString getEdaNo() {
        return edaNo;
    }

    /*
     * setedaNo
     * @param edaNo edaNo
     */
    @JsonProperty("edaNo")
    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTaisyoDateInput() {
        return this.getPanelJogaisyaKaijo().getTxtTaisyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTaisyoDateInput(TextBoxDate txtTaisyoDateInput) {
        this.getPanelJogaisyaKaijo().setTxtTaisyoDateInput(txtTaisyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoDateInput() {
        return this.getPanelJogaisyaKaijo().getTxtKaijoDateInput();
    }

    @JsonIgnore
    public void  setTxtKaijoDateInput(TextBoxDate txtKaijoDateInput) {
        this.getPanelJogaisyaKaijo().setTxtKaijoDateInput(txtKaijoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoTododkDateIn() {
        return this.getPanelJogaisyaKaijo().getTxtKaijoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtKaijoTododkDateIn(TextBoxDate txtKaijoTododkDateIn) {
        this.getPanelJogaisyaKaijo().setTxtKaijoTododkDateIn(txtKaijoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyuInput() {
        return this.getPanelJogaisyaKaijo().getDdlKaijoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyuInput(DropDownList ddlKaijoJiyuInput) {
        this.getPanelJogaisyaKaijo().setDdlKaijoJiyuInput(ddlKaijoJiyuInput);
    }

    // </editor-fold>
}
