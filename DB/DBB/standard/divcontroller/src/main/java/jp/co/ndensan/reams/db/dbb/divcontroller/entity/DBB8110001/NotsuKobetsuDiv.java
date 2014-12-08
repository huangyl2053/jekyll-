package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NotsuKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NotsuKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("ddlNotsuShuturyokuKi")
    private DropDownList ddlNotsuShuturyokuKi;
    @JsonProperty("chkNotsuShuturyokuKi")
    private CheckBoxList chkNotsuShuturyokuKi;
    @JsonProperty("lblNotsuShuturyokuKeishiki")
    private Label lblNotsuShuturyokuKeishiki;
    @JsonProperty("radNotsuShuturyokuKeishiki")
    private RadioButton radNotsuShuturyokuKeishiki;
    @JsonProperty("lblNotsuTaishoChohyo")
    private Label lblNotsuTaishoChohyo;
    @JsonProperty("radNotsuTaishoChohyo")
    private RadioButton radNotsuTaishoChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNotsuHakkoYMD")
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return txtNotsuHakkoYMD;
    }

    @JsonProperty("txtNotsuHakkoYMD")
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.txtNotsuHakkoYMD=txtNotsuHakkoYMD;
    }

    @JsonProperty("ddlNotsuShuturyokuKi")
    public DropDownList getDdlNotsuShuturyokuKi() {
        return ddlNotsuShuturyokuKi;
    }

    @JsonProperty("ddlNotsuShuturyokuKi")
    public void setDdlNotsuShuturyokuKi(DropDownList ddlNotsuShuturyokuKi) {
        this.ddlNotsuShuturyokuKi=ddlNotsuShuturyokuKi;
    }

    @JsonProperty("chkNotsuShuturyokuKi")
    public CheckBoxList getChkNotsuShuturyokuKi() {
        return chkNotsuShuturyokuKi;
    }

    @JsonProperty("chkNotsuShuturyokuKi")
    public void setChkNotsuShuturyokuKi(CheckBoxList chkNotsuShuturyokuKi) {
        this.chkNotsuShuturyokuKi=chkNotsuShuturyokuKi;
    }

    @JsonProperty("lblNotsuShuturyokuKeishiki")
    public Label getLblNotsuShuturyokuKeishiki() {
        return lblNotsuShuturyokuKeishiki;
    }

    @JsonProperty("lblNotsuShuturyokuKeishiki")
    public void setLblNotsuShuturyokuKeishiki(Label lblNotsuShuturyokuKeishiki) {
        this.lblNotsuShuturyokuKeishiki=lblNotsuShuturyokuKeishiki;
    }

    @JsonProperty("radNotsuShuturyokuKeishiki")
    public RadioButton getRadNotsuShuturyokuKeishiki() {
        return radNotsuShuturyokuKeishiki;
    }

    @JsonProperty("radNotsuShuturyokuKeishiki")
    public void setRadNotsuShuturyokuKeishiki(RadioButton radNotsuShuturyokuKeishiki) {
        this.radNotsuShuturyokuKeishiki=radNotsuShuturyokuKeishiki;
    }

    @JsonProperty("lblNotsuTaishoChohyo")
    public Label getLblNotsuTaishoChohyo() {
        return lblNotsuTaishoChohyo;
    }

    @JsonProperty("lblNotsuTaishoChohyo")
    public void setLblNotsuTaishoChohyo(Label lblNotsuTaishoChohyo) {
        this.lblNotsuTaishoChohyo=lblNotsuTaishoChohyo;
    }

    @JsonProperty("radNotsuTaishoChohyo")
    public RadioButton getRadNotsuTaishoChohyo() {
        return radNotsuTaishoChohyo;
    }

    @JsonProperty("radNotsuTaishoChohyo")
    public void setRadNotsuTaishoChohyo(RadioButton radNotsuTaishoChohyo) {
        this.radNotsuTaishoChohyo=radNotsuTaishoChohyo;
    }

}
