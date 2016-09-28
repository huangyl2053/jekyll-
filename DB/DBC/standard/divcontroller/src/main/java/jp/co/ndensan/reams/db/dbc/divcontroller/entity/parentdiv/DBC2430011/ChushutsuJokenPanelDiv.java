package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZnkaiKetteiYMD")
    private TextBoxDateRange txtZnkaiKetteiYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDateRange txtKetteiYMD;
    @JsonProperty("spcInsho")
    private Space spcInsho;
    @JsonProperty("chkShiteiJigyoshaNomi")
    private CheckBoxList chkShiteiJigyoshaNomi;
    @JsonProperty("ddlJigyosha")
    private DropDownList ddlJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZnkaiKetteiYMD
     * @return txtZnkaiKetteiYMD
     */
    @JsonProperty("txtZnkaiKetteiYMD")
    public TextBoxDateRange getTxtZnkaiKetteiYMD() {
        return txtZnkaiKetteiYMD;
    }

    /*
     * settxtZnkaiKetteiYMD
     * @param txtZnkaiKetteiYMD txtZnkaiKetteiYMD
     */
    @JsonProperty("txtZnkaiKetteiYMD")
    public void setTxtZnkaiKetteiYMD(TextBoxDateRange txtZnkaiKetteiYMD) {
        this.txtZnkaiKetteiYMD = txtZnkaiKetteiYMD;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDateRange getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getspcInsho
     * @return spcInsho
     */
    @JsonProperty("spcInsho")
    public Space getSpcInsho() {
        return spcInsho;
    }

    /*
     * setspcInsho
     * @param spcInsho spcInsho
     */
    @JsonProperty("spcInsho")
    public void setSpcInsho(Space spcInsho) {
        this.spcInsho = spcInsho;
    }

    /*
     * getchkShiteiJigyoshaNomi
     * @return chkShiteiJigyoshaNomi
     */
    @JsonProperty("chkShiteiJigyoshaNomi")
    public CheckBoxList getChkShiteiJigyoshaNomi() {
        return chkShiteiJigyoshaNomi;
    }

    /*
     * setchkShiteiJigyoshaNomi
     * @param chkShiteiJigyoshaNomi chkShiteiJigyoshaNomi
     */
    @JsonProperty("chkShiteiJigyoshaNomi")
    public void setChkShiteiJigyoshaNomi(CheckBoxList chkShiteiJigyoshaNomi) {
        this.chkShiteiJigyoshaNomi = chkShiteiJigyoshaNomi;
    }

    /*
     * getddlJigyosha
     * @return ddlJigyosha
     */
    @JsonProperty("ddlJigyosha")
    public DropDownList getDdlJigyosha() {
        return ddlJigyosha;
    }

    /*
     * setddlJigyosha
     * @param ddlJigyosha ddlJigyosha
     */
    @JsonProperty("ddlJigyosha")
    public void setDdlJigyosha(DropDownList ddlJigyosha) {
        this.ddlJigyosha = ddlJigyosha;
    }

    // </editor-fold>
}
