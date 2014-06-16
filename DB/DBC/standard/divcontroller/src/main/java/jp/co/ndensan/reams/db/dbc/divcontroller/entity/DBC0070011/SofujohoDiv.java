package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011.SofuIchiranDiv;
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
    @JsonProperty("txtSofuYM")
    public TextBoxDate getTxtSofuYM() {
        return txtSofuYM;
    }

    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxDate txtSofuYM) {
        this.txtSofuYM=txtSofuYM;
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

    @JsonProperty("SofuIchiran")
    public SofuIchiranDiv getSofuIchiran() {
        return SofuIchiran;
    }

    @JsonProperty("SofuIchiran")
    public void setSofuIchiran(SofuIchiranDiv SofuIchiran) {
        this.SofuIchiran=SofuIchiran;
    }

}
