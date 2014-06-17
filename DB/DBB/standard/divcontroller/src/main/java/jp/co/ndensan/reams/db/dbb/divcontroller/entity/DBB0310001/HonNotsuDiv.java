package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
//import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonNotsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonNotsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("lblNotsuDaikou")
    private Label lblNotsuDaikou;
    @JsonProperty("ddlNotsuShuturyokuki")
    private DropDownList ddlNotsuShuturyokuki;
    @JsonProperty("chkNotsuTaishosha")
    private CheckBoxList chkNotsuTaishosha;
    @JsonProperty("radNotsuSeikatsuHogo")
    private RadioButton radNotsuSeikatsuHogo;
    @JsonProperty("radNotsuYamawake")
    private RadioButton radNotsuYamawake;
//    @JsonProperty("ShutsuryokuJunHonNotsu")
//    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonNotsu;

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

    @JsonProperty("lblNotsuDaikou")
    public Label getLblNotsuDaikou() {
        return lblNotsuDaikou;
    }

    @JsonProperty("lblNotsuDaikou")
    public void setLblNotsuDaikou(Label lblNotsuDaikou) {
        this.lblNotsuDaikou=lblNotsuDaikou;
    }

    @JsonProperty("ddlNotsuShuturyokuki")
    public DropDownList getDdlNotsuShuturyokuki() {
        return ddlNotsuShuturyokuki;
    }

    @JsonProperty("ddlNotsuShuturyokuki")
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.ddlNotsuShuturyokuki=ddlNotsuShuturyokuki;
    }

    @JsonProperty("chkNotsuTaishosha")
    public CheckBoxList getChkNotsuTaishosha() {
        return chkNotsuTaishosha;
    }

    @JsonProperty("chkNotsuTaishosha")
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.chkNotsuTaishosha=chkNotsuTaishosha;
    }

    @JsonProperty("radNotsuSeikatsuHogo")
    public RadioButton getRadNotsuSeikatsuHogo() {
        return radNotsuSeikatsuHogo;
    }

    @JsonProperty("radNotsuSeikatsuHogo")
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.radNotsuSeikatsuHogo=radNotsuSeikatsuHogo;
    }

    @JsonProperty("radNotsuYamawake")
    public RadioButton getRadNotsuYamawake() {
        return radNotsuYamawake;
    }

    @JsonProperty("radNotsuYamawake")
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.radNotsuYamawake=radNotsuYamawake;
    }

//    @JsonProperty("ShutsuryokuJunHonNotsu")
//    public ChohyoShutsuryokujunDiv getShutsuryokuJunHonNotsu() {
//        return ShutsuryokuJunHonNotsu;
//    }
//
//    @JsonProperty("ShutsuryokuJunHonNotsu")
//    public void setShutsuryokuJunHonNotsu(ChohyoShutsuryokujunDiv ShutsuryokuJunHonNotsu) {
//        this.ShutsuryokuJunHonNotsu=ShutsuryokuJunHonNotsu;
//    }

}
