package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList;
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
 * JutokuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutokuTekiyoInput")
    private JutokuTekiyoInputDiv JutokuTekiyoInput;
    @JsonProperty("JutokuKaijoInput")
    private JutokuKaijoInputDiv JutokuKaijoInput;
    @JsonProperty("btnJutokuKakutei")
    private Button btnJutokuKakutei;
    @JsonProperty("btnJutokuTorikeshi")
    private Button btnJutokuTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutokuTekiyoInput
     * @return JutokuTekiyoInput
     */
    @JsonProperty("JutokuTekiyoInput")
    public JutokuTekiyoInputDiv getJutokuTekiyoInput() {
        return JutokuTekiyoInput;
    }

    /*
     * setJutokuTekiyoInput
     * @param JutokuTekiyoInput JutokuTekiyoInput
     */
    @JsonProperty("JutokuTekiyoInput")
    public void setJutokuTekiyoInput(JutokuTekiyoInputDiv JutokuTekiyoInput) {
        this.JutokuTekiyoInput = JutokuTekiyoInput;
    }

    /*
     * getJutokuKaijoInput
     * @return JutokuKaijoInput
     */
    @JsonProperty("JutokuKaijoInput")
    public JutokuKaijoInputDiv getJutokuKaijoInput() {
        return JutokuKaijoInput;
    }

    /*
     * setJutokuKaijoInput
     * @param JutokuKaijoInput JutokuKaijoInput
     */
    @JsonProperty("JutokuKaijoInput")
    public void setJutokuKaijoInput(JutokuKaijoInputDiv JutokuKaijoInput) {
        this.JutokuKaijoInput = JutokuKaijoInput;
    }

    /*
     * getbtnJutokuKakutei
     * @return btnJutokuKakutei
     */
    @JsonProperty("btnJutokuKakutei")
    public Button getBtnJutokuKakutei() {
        return btnJutokuKakutei;
    }

    /*
     * setbtnJutokuKakutei
     * @param btnJutokuKakutei btnJutokuKakutei
     */
    @JsonProperty("btnJutokuKakutei")
    public void setBtnJutokuKakutei(Button btnJutokuKakutei) {
        this.btnJutokuKakutei = btnJutokuKakutei;
    }

    /*
     * getbtnJutokuTorikeshi
     * @return btnJutokuTorikeshi
     */
    @JsonProperty("btnJutokuTorikeshi")
    public Button getBtnJutokuTorikeshi() {
        return btnJutokuTorikeshi;
    }

    /*
     * setbtnJutokuTorikeshi
     * @param btnJutokuTorikeshi btnJutokuTorikeshi
     */
    @JsonProperty("btnJutokuTorikeshi")
    public void setBtnJutokuTorikeshi(Button btnJutokuTorikeshi) {
        this.btnJutokuTorikeshi = btnJutokuTorikeshi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return this.getJutokuTekiyoInput().getTxtTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.getJutokuTekiyoInput().setTxtTekiyoDate(txtTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoTodokedeDate() {
        return this.getJutokuTekiyoInput().getTxtTekiyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoTodokedeDate(TextBoxFlexibleDate txtTekiyoTodokedeDate) {
        this.getJutokuTekiyoInput().setTxtTekiyoTodokedeDate(txtTekiyoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyu() {
        return this.getJutokuTekiyoInput().getDdlTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.getJutokuTekiyoInput().setDdlTekiyoJiyu(ddlTekiyoJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getJutokuKaijoInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getJutokuKaijoInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getJutokuKaijoInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getJutokuKaijoInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyu() {
        return this.getJutokuKaijoInput().getDdlKaijoJiyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.getJutokuKaijoInput().setDdlKaijoJiyu(ddlKaijoJiyu);
    }

    // </editor-fold>
}
