package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelJogaisyaKaijo のクラスファイル
 *
 */
public class panelJogaisyaKaijoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTaisyoDateInput")
    private TextBoxDate txtTaisyoDateInput;
    @JsonProperty("txtKaijoDateInput")
    private TextBoxDate txtKaijoDateInput;
    @JsonProperty("txtKaijoTododkDateIn")
    private TextBoxDate txtKaijoTododkDateIn;
    @JsonProperty("ddlKaijoJiyuInput")
    private DropDownList ddlKaijoJiyuInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTaisyoDateInput
     * @return txtTaisyoDateInput
     */
    @JsonProperty("txtTaisyoDateInput")
    public TextBoxDate getTxtTaisyoDateInput() {
        return txtTaisyoDateInput;
    }

    /*
     * settxtTaisyoDateInput
     * @param txtTaisyoDateInput txtTaisyoDateInput
     */
    @JsonProperty("txtTaisyoDateInput")
    public void setTxtTaisyoDateInput(TextBoxDate txtTaisyoDateInput) {
        this.txtTaisyoDateInput = txtTaisyoDateInput;
    }

    /*
     * gettxtKaijoDateInput
     * @return txtKaijoDateInput
     */
    @JsonProperty("txtKaijoDateInput")
    public TextBoxDate getTxtKaijoDateInput() {
        return txtKaijoDateInput;
    }

    /*
     * settxtKaijoDateInput
     * @param txtKaijoDateInput txtKaijoDateInput
     */
    @JsonProperty("txtKaijoDateInput")
    public void setTxtKaijoDateInput(TextBoxDate txtKaijoDateInput) {
        this.txtKaijoDateInput = txtKaijoDateInput;
    }

    /*
     * gettxtKaijoTododkDateIn
     * @return txtKaijoTododkDateIn
     */
    @JsonProperty("txtKaijoTododkDateIn")
    public TextBoxDate getTxtKaijoTododkDateIn() {
        return txtKaijoTododkDateIn;
    }

    /*
     * settxtKaijoTododkDateIn
     * @param txtKaijoTododkDateIn txtKaijoTododkDateIn
     */
    @JsonProperty("txtKaijoTododkDateIn")
    public void setTxtKaijoTododkDateIn(TextBoxDate txtKaijoTododkDateIn) {
        this.txtKaijoTododkDateIn = txtKaijoTododkDateIn;
    }

    /*
     * getddlKaijoJiyuInput
     * @return ddlKaijoJiyuInput
     */
    @JsonProperty("ddlKaijoJiyuInput")
    public DropDownList getDdlKaijoJiyuInput() {
        return ddlKaijoJiyuInput;
    }

    /*
     * setddlKaijoJiyuInput
     * @param ddlKaijoJiyuInput ddlKaijoJiyuInput
     */
    @JsonProperty("ddlKaijoJiyuInput")
    public void setDdlKaijoJiyuInput(DropDownList ddlKaijoJiyuInput) {
        this.ddlKaijoJiyuInput = ddlKaijoJiyuInput;
    }

    // </editor-fold>
}
