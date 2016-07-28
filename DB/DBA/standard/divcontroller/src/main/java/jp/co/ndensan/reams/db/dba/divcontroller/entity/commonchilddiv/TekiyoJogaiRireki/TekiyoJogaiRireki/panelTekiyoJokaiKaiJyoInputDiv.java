package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
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
 * panelTekiyoJokaiKaiJyoInput のクラスファイル
 *
 */
public class panelTekiyoJokaiKaiJyoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelJogaisyaKaijo")
    private panelJogaisyaKaijoDiv panelJogaisyaKaijo;

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
