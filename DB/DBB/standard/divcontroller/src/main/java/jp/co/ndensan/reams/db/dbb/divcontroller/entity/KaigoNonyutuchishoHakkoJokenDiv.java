package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.IKaigoNonyutuchishoHakkoJokenDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoNonyutuchishoHakkoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNonyutuchishoHakkoJokenDiv extends Panel implements IKaigoNonyutuchishoHakkoJokenDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoYmd")
    private TextBoxDate txtHakkoYmd;
    @JsonProperty("lblMsg")
    private Label lblMsg;
    @JsonProperty("txtShutsuryokuKi")
    private TextBox txtShutsuryokuKi;
    @JsonProperty("ddlShutsuryokuKi")
    private DropDownList ddlShutsuryokuKi;
    @JsonProperty("chkTaishosha")
    private CheckBoxList chkTaishosha;
    @JsonProperty("radSeiho")
    private RadioButton radSeiho;
    @JsonProperty("radYamawake")
    private RadioButton radYamawake;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHakkoYmd")
    public TextBoxDate getTxtHakkoYmd() {
        return txtHakkoYmd;
    }

    @JsonProperty("txtHakkoYmd")
    public void setTxtHakkoYmd(TextBoxDate txtHakkoYmd) {
        this.txtHakkoYmd=txtHakkoYmd;
    }

    @JsonProperty("lblMsg")
    public Label getLblMsg() {
        return lblMsg;
    }

    @JsonProperty("lblMsg")
    public void setLblMsg(Label lblMsg) {
        this.lblMsg=lblMsg;
    }

    @JsonProperty("txtShutsuryokuKi")
    public TextBox getTxtShutsuryokuKi() {
        return txtShutsuryokuKi;
    }

    @JsonProperty("txtShutsuryokuKi")
    public void setTxtShutsuryokuKi(TextBox txtShutsuryokuKi) {
        this.txtShutsuryokuKi=txtShutsuryokuKi;
    }

    @JsonProperty("ddlShutsuryokuKi")
    public DropDownList getDdlShutsuryokuKi() {
        return ddlShutsuryokuKi;
    }

    @JsonProperty("ddlShutsuryokuKi")
    public void setDdlShutsuryokuKi(DropDownList ddlShutsuryokuKi) {
        this.ddlShutsuryokuKi=ddlShutsuryokuKi;
    }

    @JsonProperty("chkTaishosha")
    public CheckBoxList getChkTaishosha() {
        return chkTaishosha;
    }

    @JsonProperty("chkTaishosha")
    public void setChkTaishosha(CheckBoxList chkTaishosha) {
        this.chkTaishosha=chkTaishosha;
    }

    @JsonProperty("radSeiho")
    public RadioButton getRadSeiho() {
        return radSeiho;
    }

    @JsonProperty("radSeiho")
    public void setRadSeiho(RadioButton radSeiho) {
        this.radSeiho=radSeiho;
    }

    @JsonProperty("radYamawake")
    public RadioButton getRadYamawake() {
        return radYamawake;
    }

    @JsonProperty("radYamawake")
    public void setRadYamawake(RadioButton radYamawake) {
        this.radYamawake=radYamawake;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
