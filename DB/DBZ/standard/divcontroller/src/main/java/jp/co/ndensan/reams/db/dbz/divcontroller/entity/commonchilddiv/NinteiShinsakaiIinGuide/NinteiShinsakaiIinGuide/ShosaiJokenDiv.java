package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShosaiJoken のクラスファイル 
 * 
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class ShosaiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShozoku")
    private Label lblShozoku;
    @JsonProperty("ddlIryoKikan")
    private DropDownList ddlIryoKikan;
    @JsonProperty("ddlKaigoJigyosha")
    private DropDownList ddlKaigoJigyosha;
    @JsonProperty("ddlSonotaJigyosha")
    private DropDownList ddlSonotaJigyosha;
    @JsonProperty("chkKiken")
    private CheckBoxList chkKiken;
    @JsonProperty("chkHaishi")
    private CheckBoxList chkHaishi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShozoku
     * @return lblShozoku
     */
    @JsonProperty("lblShozoku")
    public Label getLblShozoku() {
        return lblShozoku;
    }

    /*
     * setlblShozoku
     * @param lblShozoku lblShozoku
     */
    @JsonProperty("lblShozoku")
    public void setLblShozoku(Label lblShozoku) {
        this.lblShozoku = lblShozoku;
    }

    /*
     * getddlIryoKikan
     * @return ddlIryoKikan
     */
    @JsonProperty("ddlIryoKikan")
    public DropDownList getDdlIryoKikan() {
        return ddlIryoKikan;
    }

    /*
     * setddlIryoKikan
     * @param ddlIryoKikan ddlIryoKikan
     */
    @JsonProperty("ddlIryoKikan")
    public void setDdlIryoKikan(DropDownList ddlIryoKikan) {
        this.ddlIryoKikan = ddlIryoKikan;
    }

    /*
     * getddlKaigoJigyosha
     * @return ddlKaigoJigyosha
     */
    @JsonProperty("ddlKaigoJigyosha")
    public DropDownList getDdlKaigoJigyosha() {
        return ddlKaigoJigyosha;
    }

    /*
     * setddlKaigoJigyosha
     * @param ddlKaigoJigyosha ddlKaigoJigyosha
     */
    @JsonProperty("ddlKaigoJigyosha")
    public void setDdlKaigoJigyosha(DropDownList ddlKaigoJigyosha) {
        this.ddlKaigoJigyosha = ddlKaigoJigyosha;
    }

    /*
     * getddlSonotaJigyosha
     * @return ddlSonotaJigyosha
     */
    @JsonProperty("ddlSonotaJigyosha")
    public DropDownList getDdlSonotaJigyosha() {
        return ddlSonotaJigyosha;
    }

    /*
     * setddlSonotaJigyosha
     * @param ddlSonotaJigyosha ddlSonotaJigyosha
     */
    @JsonProperty("ddlSonotaJigyosha")
    public void setDdlSonotaJigyosha(DropDownList ddlSonotaJigyosha) {
        this.ddlSonotaJigyosha = ddlSonotaJigyosha;
    }

    /*
     * getchkKiken
     * @return chkKiken
     */
    @JsonProperty("chkKiken")
    public CheckBoxList getChkKiken() {
        return chkKiken;
    }

    /*
     * setchkKiken
     * @param chkKiken chkKiken
     */
    @JsonProperty("chkKiken")
    public void setChkKiken(CheckBoxList chkKiken) {
        this.chkKiken = chkKiken;
    }

    /*
     * getchkHaishi
     * @return chkHaishi
     */
    @JsonProperty("chkHaishi")
    public CheckBoxList getChkHaishi() {
        return chkHaishi;
    }

    /*
     * setchkHaishi
     * @param chkHaishi chkHaishi
     */
    @JsonProperty("chkHaishi")
    public void setChkHaishi(CheckBoxList chkHaishi) {
        this.chkHaishi = chkHaishi;
    }

    // </editor-fold>
}
