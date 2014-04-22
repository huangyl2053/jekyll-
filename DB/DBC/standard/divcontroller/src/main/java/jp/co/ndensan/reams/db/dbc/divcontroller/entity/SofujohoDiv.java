package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSofuIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Sofujoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofujohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSofuYM")
    private Label lblSofuYM;
    @JsonProperty("txtSofuYM")
    private TextBoxFlexibleDate txtSofuYM;
    @JsonProperty("lblShichosonName")
    private Label lblShichosonName;
    @JsonProperty("ddlShichosonName")
    private DropDownList ddlShichosonName;
    @JsonProperty("btnSearchSofuzumi")
    private Button btnSearchSofuzumi;
    @JsonProperty("btnSearchMisofu")
    private Button btnSearchMisofu;
    @JsonProperty("dgSofuIchiran")
    private DataGrid<dgSofuIchiran_Row> dgSofuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblSofuYM")
    public Label getLblSofuYM() {
        return lblSofuYM;
    }

    @JsonProperty("lblSofuYM")
    public void setLblSofuYM(Label lblSofuYM) {
        this.lblSofuYM=lblSofuYM;
    }

    @JsonProperty("txtSofuYM")
    public TextBoxFlexibleDate getTxtSofuYM() {
        return txtSofuYM;
    }

    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxFlexibleDate txtSofuYM) {
        this.txtSofuYM=txtSofuYM;
    }

    @JsonProperty("lblShichosonName")
    public Label getLblShichosonName() {
        return lblShichosonName;
    }

    @JsonProperty("lblShichosonName")
    public void setLblShichosonName(Label lblShichosonName) {
        this.lblShichosonName=lblShichosonName;
    }

    @JsonProperty("ddlShichosonName")
    public DropDownList getDdlShichosonName() {
        return ddlShichosonName;
    }

    @JsonProperty("ddlShichosonName")
    public void setDdlShichosonName(DropDownList ddlShichosonName) {
        this.ddlShichosonName=ddlShichosonName;
    }

    @JsonProperty("btnSearchSofuzumi")
    public Button getBtnSearchSofuzumi() {
        return btnSearchSofuzumi;
    }

    @JsonProperty("btnSearchSofuzumi")
    public void setBtnSearchSofuzumi(Button btnSearchSofuzumi) {
        this.btnSearchSofuzumi=btnSearchSofuzumi;
    }

    @JsonProperty("btnSearchMisofu")
    public Button getBtnSearchMisofu() {
        return btnSearchMisofu;
    }

    @JsonProperty("btnSearchMisofu")
    public void setBtnSearchMisofu(Button btnSearchMisofu) {
        this.btnSearchMisofu=btnSearchMisofu;
    }

    @JsonProperty("dgSofuIchiran")
    public DataGrid<dgSofuIchiran_Row> getDgSofuIchiran() {
        return dgSofuIchiran;
    }

    @JsonProperty("dgSofuIchiran")
    public void setDgSofuIchiran(DataGrid<dgSofuIchiran_Row> dgSofuIchiran) {
        this.dgSofuIchiran=dgSofuIchiran;
    }

}
