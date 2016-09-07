package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011;
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
 * SoufuJouhou のクラスファイル 
 * 
 * @author 自動生成
 */
public class SoufuJouhouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSofuYM")
    private TextBoxDate txtSofuYM;
    @JsonProperty("ddlShichosonName")
    private DropDownList ddlShichosonName;
    @JsonProperty("btnSearchSofuzumi")
    private Button btnSearchSofuzumi;
    @JsonProperty("btnSearchMisofu")
    private Button btnSearchMisofu;
    @JsonProperty("SofuIchiran")
    private SofuIchiranDiv SofuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSofuYM
     * @return txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public TextBoxDate getTxtSofuYM() {
        return txtSofuYM;
    }

    /*
     * settxtSofuYM
     * @param txtSofuYM txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxDate txtSofuYM) {
        this.txtSofuYM = txtSofuYM;
    }

    /*
     * getddlShichosonName
     * @return ddlShichosonName
     */
    @JsonProperty("ddlShichosonName")
    public DropDownList getDdlShichosonName() {
        return ddlShichosonName;
    }

    /*
     * setddlShichosonName
     * @param ddlShichosonName ddlShichosonName
     */
    @JsonProperty("ddlShichosonName")
    public void setDdlShichosonName(DropDownList ddlShichosonName) {
        this.ddlShichosonName = ddlShichosonName;
    }

    /*
     * getbtnSearchSofuzumi
     * @return btnSearchSofuzumi
     */
    @JsonProperty("btnSearchSofuzumi")
    public Button getBtnSearchSofuzumi() {
        return btnSearchSofuzumi;
    }

    /*
     * setbtnSearchSofuzumi
     * @param btnSearchSofuzumi btnSearchSofuzumi
     */
    @JsonProperty("btnSearchSofuzumi")
    public void setBtnSearchSofuzumi(Button btnSearchSofuzumi) {
        this.btnSearchSofuzumi = btnSearchSofuzumi;
    }

    /*
     * getbtnSearchMisofu
     * @return btnSearchMisofu
     */
    @JsonProperty("btnSearchMisofu")
    public Button getBtnSearchMisofu() {
        return btnSearchMisofu;
    }

    /*
     * setbtnSearchMisofu
     * @param btnSearchMisofu btnSearchMisofu
     */
    @JsonProperty("btnSearchMisofu")
    public void setBtnSearchMisofu(Button btnSearchMisofu) {
        this.btnSearchMisofu = btnSearchMisofu;
    }

    /*
     * getSofuIchiran
     * @return SofuIchiran
     */
    @JsonProperty("SofuIchiran")
    public SofuIchiranDiv getSofuIchiran() {
        return SofuIchiran;
    }

    /*
     * setSofuIchiran
     * @param SofuIchiran SofuIchiran
     */
    @JsonProperty("SofuIchiran")
    public void setSofuIchiran(SofuIchiranDiv SofuIchiran) {
        this.SofuIchiran = SofuIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgSofuIchiran_Row> getDgSofuIchiran() {
        return this.getSofuIchiran().getDgSofuIchiran();
    }

    @JsonIgnore
    public void  setDgSofuIchiran(DataGrid<dgSofuIchiran_Row> dgSofuIchiran) {
        this.getSofuIchiran().setDgSofuIchiran(dgSofuIchiran);
    }

    // </editor-fold>
}
