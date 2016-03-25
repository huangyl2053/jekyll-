package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChoshuInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendo")
    private TextBoxDate txtFukaNendo;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("lblLine")
    private Label lblLine;
    @JsonProperty("ddlFucho")
    private DropDownList ddlFucho;
    @JsonProperty("choshuHouhou")
    private DataGrid<choshuHouhou_Row> choshuHouhou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxDate getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtHokensha
     * @return txtHokensha
     */
    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    /*
     * settxtHokensha
     * @param txtHokensha txtHokensha
     */
    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha = txtHokensha;
    }

    /*
     * getlblLine
     * @return lblLine
     */
    @JsonProperty("lblLine")
    public Label getLblLine() {
        return lblLine;
    }

    /*
     * setlblLine
     * @param lblLine lblLine
     */
    @JsonProperty("lblLine")
    public void setLblLine(Label lblLine) {
        this.lblLine = lblLine;
    }

    /*
     * getddlFucho
     * @return ddlFucho
     */
    @JsonProperty("ddlFucho")
    public DropDownList getDdlFucho() {
        return ddlFucho;
    }

    /*
     * setddlFucho
     * @param ddlFucho ddlFucho
     */
    @JsonProperty("ddlFucho")
    public void setDdlFucho(DropDownList ddlFucho) {
        this.ddlFucho = ddlFucho;
    }

    /*
     * getchoshuHouhou
     * @return choshuHouhou
     */
    @JsonProperty("choshuHouhou")
    public DataGrid<choshuHouhou_Row> getChoshuHouhou() {
        return choshuHouhou;
    }

    /*
     * setchoshuHouhou
     * @param choshuHouhou choshuHouhou
     */
    @JsonProperty("choshuHouhou")
    public void setChoshuHouhou(DataGrid<choshuHouhou_Row> choshuHouhou) {
        this.choshuHouhou = choshuHouhou;
    }

    // </editor-fold>
}
