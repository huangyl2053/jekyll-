package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelDetailGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelDetailGokeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyouHisu")
    private TextBoxNum txtTeikyouHisu;
    @JsonProperty("txtHigaku")
    private TextBoxNum txtHigaku;
    @JsonProperty("txtGetsugaku")
    private TextBoxNum txtGetsugaku;
    @JsonProperty("txtTeikyohiGokei")
    private TextBoxNum txtTeikyohiGokei;
    @JsonProperty("txtShokujiShiseigaku")
    private TextBoxNum txtShokujiShiseigaku;
    @JsonProperty("btnShukei")
    private Button btnShukei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeikyouHisu
     * @return txtTeikyouHisu
     */
    @JsonProperty("txtTeikyouHisu")
    public TextBoxNum getTxtTeikyouHisu() {
        return txtTeikyouHisu;
    }

    /*
     * settxtTeikyouHisu
     * @param txtTeikyouHisu txtTeikyouHisu
     */
    @JsonProperty("txtTeikyouHisu")
    public void setTxtTeikyouHisu(TextBoxNum txtTeikyouHisu) {
        this.txtTeikyouHisu = txtTeikyouHisu;
    }

    /*
     * gettxtHigaku
     * @return txtHigaku
     */
    @JsonProperty("txtHigaku")
    public TextBoxNum getTxtHigaku() {
        return txtHigaku;
    }

    /*
     * settxtHigaku
     * @param txtHigaku txtHigaku
     */
    @JsonProperty("txtHigaku")
    public void setTxtHigaku(TextBoxNum txtHigaku) {
        this.txtHigaku = txtHigaku;
    }

    /*
     * gettxtGetsugaku
     * @return txtGetsugaku
     */
    @JsonProperty("txtGetsugaku")
    public TextBoxNum getTxtGetsugaku() {
        return txtGetsugaku;
    }

    /*
     * settxtGetsugaku
     * @param txtGetsugaku txtGetsugaku
     */
    @JsonProperty("txtGetsugaku")
    public void setTxtGetsugaku(TextBoxNum txtGetsugaku) {
        this.txtGetsugaku = txtGetsugaku;
    }

    /*
     * gettxtTeikyohiGokei
     * @return txtTeikyohiGokei
     */
    @JsonProperty("txtTeikyohiGokei")
    public TextBoxNum getTxtTeikyohiGokei() {
        return txtTeikyohiGokei;
    }

    /*
     * settxtTeikyohiGokei
     * @param txtTeikyohiGokei txtTeikyohiGokei
     */
    @JsonProperty("txtTeikyohiGokei")
    public void setTxtTeikyohiGokei(TextBoxNum txtTeikyohiGokei) {
        this.txtTeikyohiGokei = txtTeikyohiGokei;
    }

    /*
     * gettxtShokujiShiseigaku
     * @return txtShokujiShiseigaku
     */
    @JsonProperty("txtShokujiShiseigaku")
    public TextBoxNum getTxtShokujiShiseigaku() {
        return txtShokujiShiseigaku;
    }

    /*
     * settxtShokujiShiseigaku
     * @param txtShokujiShiseigaku txtShokujiShiseigaku
     */
    @JsonProperty("txtShokujiShiseigaku")
    public void setTxtShokujiShiseigaku(TextBoxNum txtShokujiShiseigaku) {
        this.txtShokujiShiseigaku = txtShokujiShiseigaku;
    }

    /*
     * getbtnShukei
     * @return btnShukei
     */
    @JsonProperty("btnShukei")
    public Button getBtnShukei() {
        return btnShukei;
    }

    /*
     * setbtnShukei
     * @param btnShukei btnShukei
     */
    @JsonProperty("btnShukei")
    public void setBtnShukei(Button btnShukei) {
        this.btnShukei = btnShukei;
    }

    // </editor-fold>
}
