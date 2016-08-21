package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001;
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
 * TaishoShoriIchiranPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoShoriIchiranPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriNendo")
    private DropDownList ddlShoriNendo;
    @JsonProperty("ddlShichosonshitei")
    private DropDownList ddlShichosonshitei;
    @JsonProperty("btnShoriSettei")
    private Button btnShoriSettei;
    @JsonProperty("dgTaishoShoriItchiran")
    private DataGrid<dgTaishoShoriItchiran_Row> dgTaishoShoriItchiran;
    @JsonProperty("FuairuAppurodo")
    private FuairuAppurodoDiv FuairuAppurodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShoriNendo
     * @return ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public DropDownList getDdlShoriNendo() {
        return ddlShoriNendo;
    }

    /*
     * setddlShoriNendo
     * @param ddlShoriNendo ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.ddlShoriNendo = ddlShoriNendo;
    }

    /*
     * getddlShichosonshitei
     * @return ddlShichosonshitei
     */
    @JsonProperty("ddlShichosonshitei")
    public DropDownList getDdlShichosonshitei() {
        return ddlShichosonshitei;
    }

    /*
     * setddlShichosonshitei
     * @param ddlShichosonshitei ddlShichosonshitei
     */
    @JsonProperty("ddlShichosonshitei")
    public void setDdlShichosonshitei(DropDownList ddlShichosonshitei) {
        this.ddlShichosonshitei = ddlShichosonshitei;
    }

    /*
     * getbtnShoriSettei
     * @return btnShoriSettei
     */
    @JsonProperty("btnShoriSettei")
    public Button getBtnShoriSettei() {
        return btnShoriSettei;
    }

    /*
     * setbtnShoriSettei
     * @param btnShoriSettei btnShoriSettei
     */
    @JsonProperty("btnShoriSettei")
    public void setBtnShoriSettei(Button btnShoriSettei) {
        this.btnShoriSettei = btnShoriSettei;
    }

    /*
     * getdgTaishoShoriItchiran
     * @return dgTaishoShoriItchiran
     */
    @JsonProperty("dgTaishoShoriItchiran")
    public DataGrid<dgTaishoShoriItchiran_Row> getDgTaishoShoriItchiran() {
        return dgTaishoShoriItchiran;
    }

    /*
     * setdgTaishoShoriItchiran
     * @param dgTaishoShoriItchiran dgTaishoShoriItchiran
     */
    @JsonProperty("dgTaishoShoriItchiran")
    public void setDgTaishoShoriItchiran(DataGrid<dgTaishoShoriItchiran_Row> dgTaishoShoriItchiran) {
        this.dgTaishoShoriItchiran = dgTaishoShoriItchiran;
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
