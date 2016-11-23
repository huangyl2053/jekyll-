package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NotsuKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NotsuKobetsuDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxFlexibleDate txtNotsuHakkoYMD;
    @JsonProperty("ddlNotsuShuturyokuKi")
    private DropDownList ddlNotsuShuturyokuKi;
    @JsonProperty("chkNotsuShuturyokuKi")
    private CheckBoxList chkNotsuShuturyokuKi;
    @JsonProperty("radNotsuShuturyokuKeishiki")
    private RadioButton radNotsuShuturyokuKeishiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNotsuHakkoYMD
     * @return txtNotsuHakkoYMD
     */
    @JsonProperty("txtNotsuHakkoYMD")
    public TextBoxFlexibleDate getTxtNotsuHakkoYMD() {
        return txtNotsuHakkoYMD;
    }

    /*
     * settxtNotsuHakkoYMD
     * @param txtNotsuHakkoYMD txtNotsuHakkoYMD
     */
    @JsonProperty("txtNotsuHakkoYMD")
    public void setTxtNotsuHakkoYMD(TextBoxFlexibleDate txtNotsuHakkoYMD) {
        this.txtNotsuHakkoYMD = txtNotsuHakkoYMD;
    }

    /*
     * getddlNotsuShuturyokuKi
     * @return ddlNotsuShuturyokuKi
     */
    @JsonProperty("ddlNotsuShuturyokuKi")
    public DropDownList getDdlNotsuShuturyokuKi() {
        return ddlNotsuShuturyokuKi;
    }

    /*
     * setddlNotsuShuturyokuKi
     * @param ddlNotsuShuturyokuKi ddlNotsuShuturyokuKi
     */
    @JsonProperty("ddlNotsuShuturyokuKi")
    public void setDdlNotsuShuturyokuKi(DropDownList ddlNotsuShuturyokuKi) {
        this.ddlNotsuShuturyokuKi = ddlNotsuShuturyokuKi;
    }

    /*
     * getchkNotsuShuturyokuKi
     * @return chkNotsuShuturyokuKi
     */
    @JsonProperty("chkNotsuShuturyokuKi")
    public CheckBoxList getChkNotsuShuturyokuKi() {
        return chkNotsuShuturyokuKi;
    }

    /*
     * setchkNotsuShuturyokuKi
     * @param chkNotsuShuturyokuKi chkNotsuShuturyokuKi
     */
    @JsonProperty("chkNotsuShuturyokuKi")
    public void setChkNotsuShuturyokuKi(CheckBoxList chkNotsuShuturyokuKi) {
        this.chkNotsuShuturyokuKi = chkNotsuShuturyokuKi;
    }

    /*
     * getradNotsuShuturyokuKeishiki
     * @return radNotsuShuturyokuKeishiki
     */
    @JsonProperty("radNotsuShuturyokuKeishiki")
    public RadioButton getRadNotsuShuturyokuKeishiki() {
        return radNotsuShuturyokuKeishiki;
    }

    /*
     * setradNotsuShuturyokuKeishiki
     * @param radNotsuShuturyokuKeishiki radNotsuShuturyokuKeishiki
     */
    @JsonProperty("radNotsuShuturyokuKeishiki")
    public void setRadNotsuShuturyokuKeishiki(RadioButton radNotsuShuturyokuKeishiki) {
        this.radNotsuShuturyokuKeishiki = radNotsuShuturyokuKeishiki;
    }

    // </editor-fold>
}
