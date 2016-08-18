package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
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
 * TanitsuTaishoShoriIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TanitsuTaishoShoriIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTanitsuTaishoShoriItchiran")
    private DataGrid<dgTanitsuTaishoShoriItchiran_Row> dgTanitsuTaishoShoriItchiran;
    @JsonProperty("FuairuAppurodo")
    private FuairuAppurodoDiv FuairuAppurodo;
    @JsonProperty("txtShoriNendo")
    private TextBox txtShoriNendo;
    @JsonProperty("txtTuki")
    private TextBox txtTuki;
    @JsonProperty("txtShori")
    private TextBox txtShori;
    @JsonProperty("txtFuairuMei")
    private TextBox txtFuairuMei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTanitsuTaishoShoriItchiran
     * @return dgTanitsuTaishoShoriItchiran
     */
    @JsonProperty("dgTanitsuTaishoShoriItchiran")
    public DataGrid<dgTanitsuTaishoShoriItchiran_Row> getDgTanitsuTaishoShoriItchiran() {
        return dgTanitsuTaishoShoriItchiran;
    }

    /*
     * setdgTanitsuTaishoShoriItchiran
     * @param dgTanitsuTaishoShoriItchiran dgTanitsuTaishoShoriItchiran
     */
    @JsonProperty("dgTanitsuTaishoShoriItchiran")
    public void setDgTanitsuTaishoShoriItchiran(DataGrid<dgTanitsuTaishoShoriItchiran_Row> dgTanitsuTaishoShoriItchiran) {
        this.dgTanitsuTaishoShoriItchiran = dgTanitsuTaishoShoriItchiran;
    }

    /*
     * getFuairuAppurodo
     * @return FuairuAppurodo
     */
    @JsonProperty("FuairuAppurodo")
    public FuairuAppurodoDiv getFuairuAppurodo() {
        return FuairuAppurodo;
    }

    /*
     * setFuairuAppurodo
     * @param FuairuAppurodo FuairuAppurodo
     */
    @JsonProperty("FuairuAppurodo")
    public void setFuairuAppurodo(FuairuAppurodoDiv FuairuAppurodo) {
        this.FuairuAppurodo = FuairuAppurodo;
    }

    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBox getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBox txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
    }

    /*
     * gettxtTuki
     * @return txtTuki
     */
    @JsonProperty("txtTuki")
    public TextBox getTxtTuki() {
        return txtTuki;
    }

    /*
     * settxtTuki
     * @param txtTuki txtTuki
     */
    @JsonProperty("txtTuki")
    public void setTxtTuki(TextBox txtTuki) {
        this.txtTuki = txtTuki;
    }

    /*
     * gettxtShori
     * @return txtShori
     */
    @JsonProperty("txtShori")
    public TextBox getTxtShori() {
        return txtShori;
    }

    /*
     * settxtShori
     * @param txtShori txtShori
     */
    @JsonProperty("txtShori")
    public void setTxtShori(TextBox txtShori) {
        this.txtShori = txtShori;
    }

    /*
     * gettxtFuairuMei
     * @return txtFuairuMei
     */
    @JsonProperty("txtFuairuMei")
    public TextBox getTxtFuairuMei() {
        return txtFuairuMei;
    }

    /*
     * settxtFuairuMei
     * @param txtFuairuMei txtFuairuMei
     */
    @JsonProperty("txtFuairuMei")
    public void setTxtFuairuMei(TextBox txtFuairuMei) {
        this.txtFuairuMei = txtFuairuMei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplTaishoFuairu() {
        return this.getFuairuAppurodo().getUplTaishoFuairu();
    }

    @JsonIgnore
    public void  setUplTaishoFuairu(UploadPanel uplTaishoFuairu) {
        this.getFuairuAppurodo().setUplTaishoFuairu(uplTaishoFuairu);
    }

    @JsonIgnore
    public Button getBtnAppurodo() {
        return this.getFuairuAppurodo().getBtnAppurodo();
    }

    @JsonIgnore
    public void  setBtnAppurodo(Button btnAppurodo) {
        this.getFuairuAppurodo().setBtnAppurodo(btnAppurodo);
    }

    // </editor-fold>
}
