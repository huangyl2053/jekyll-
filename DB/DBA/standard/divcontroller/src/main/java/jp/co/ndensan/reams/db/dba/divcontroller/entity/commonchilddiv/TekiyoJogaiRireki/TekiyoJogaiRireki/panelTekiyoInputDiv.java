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
 * panelTekiyoInput のクラスファイル
 *
 */
public class panelTekiyoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoDate")
    private TextBoxDate txtTekiyoDate;
    @JsonProperty("txtTekiyoTodokeDate")
    private TextBoxDate txtTekiyoTodokeDate;
    @JsonProperty("ddlTekiyoJiyu")
    private DropDownList ddlTekiyoJiyu;
    @JsonProperty("txtKayijoDate")
    private TextBoxDate txtKayijoDate;
    @JsonProperty("txtKaijoTodokedeDate")
    private TextBoxDate txtKaijoTodokedeDate;
    @JsonProperty("ddlKaijyoJiyu")
    private DropDownList ddlKaijyoJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoDate
     * @return txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public TextBoxDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    /*
     * settxtTekiyoDate
     * @param txtTekiyoDate txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxDate txtTekiyoDate) {
        this.txtTekiyoDate = txtTekiyoDate;
    }

    /*
     * gettxtTekiyoTodokeDate
     * @return txtTekiyoTodokeDate
     */
    @JsonProperty("txtTekiyoTodokeDate")
    public TextBoxDate getTxtTekiyoTodokeDate() {
        return txtTekiyoTodokeDate;
    }

    /*
     * settxtTekiyoTodokeDate
     * @param txtTekiyoTodokeDate txtTekiyoTodokeDate
     */
    @JsonProperty("txtTekiyoTodokeDate")
    public void setTxtTekiyoTodokeDate(TextBoxDate txtTekiyoTodokeDate) {
        this.txtTekiyoTodokeDate = txtTekiyoTodokeDate;
    }

    /*
     * getddlTekiyoJiyu
     * @return ddlTekiyoJiyu
     */
    @JsonProperty("ddlTekiyoJiyu")
    public DropDownList getDdlTekiyoJiyu() {
        return ddlTekiyoJiyu;
    }

    /*
     * setddlTekiyoJiyu
     * @param ddlTekiyoJiyu ddlTekiyoJiyu
     */
    @JsonProperty("ddlTekiyoJiyu")
    public void setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.ddlTekiyoJiyu = ddlTekiyoJiyu;
    }

    /*
     * gettxtKayijoDate
     * @return txtKayijoDate
     */
    @JsonProperty("txtKayijoDate")
    public TextBoxDate getTxtKayijoDate() {
        return txtKayijoDate;
    }

    /*
     * settxtKayijoDate
     * @param txtKayijoDate txtKayijoDate
     */
    @JsonProperty("txtKayijoDate")
    public void setTxtKayijoDate(TextBoxDate txtKayijoDate) {
        this.txtKayijoDate = txtKayijoDate;
    }

    /*
     * gettxtKaijoTodokedeDate
     * @return txtKaijoTodokedeDate
     */
    @JsonProperty("txtKaijoTodokedeDate")
    public TextBoxDate getTxtKaijoTodokedeDate() {
        return txtKaijoTodokedeDate;
    }

    /*
     * settxtKaijoTodokedeDate
     * @param txtKaijoTodokedeDate txtKaijoTodokedeDate
     */
    @JsonProperty("txtKaijoTodokedeDate")
    public void setTxtKaijoTodokedeDate(TextBoxDate txtKaijoTodokedeDate) {
        this.txtKaijoTodokedeDate = txtKaijoTodokedeDate;
    }

    /*
     * getddlKaijyoJiyu
     * @return ddlKaijyoJiyu
     */
    @JsonProperty("ddlKaijyoJiyu")
    public DropDownList getDdlKaijyoJiyu() {
        return ddlKaijyoJiyu;
    }

    /*
     * setddlKaijyoJiyu
     * @param ddlKaijyoJiyu ddlKaijyoJiyu
     */
    @JsonProperty("ddlKaijyoJiyu")
    public void setDdlKaijyoJiyu(DropDownList ddlKaijyoJiyu) {
        this.ddlKaijyoJiyu = ddlKaijyoJiyu;
    }

    // </editor-fold>
}
