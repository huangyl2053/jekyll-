package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
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
 * IraiprintPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraiprintPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-04_20-07-38">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIrai")
    private CheckBoxList chkIrai;
    @JsonProperty("txtHokkoymd")
    private TextBoxDate txtHokkoymd;
    @JsonProperty("radKigen")
    private RadioButton radKigen;
    @JsonProperty("txtKigenymd")
    private TextBoxDate txtKigenymd;
    @JsonProperty("NiteiChosaSelect")
    private NiteiChosaSelectDiv NiteiChosaSelect;
    @JsonProperty("TokkiJokoSelect")
    private TokkiJokoSelectDiv TokkiJokoSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIrai
     * @return chkIrai
     */
    @JsonProperty("chkIrai")
    public CheckBoxList getChkIrai() {
        return chkIrai;
    }

    /*
     * setchkIrai
     * @param chkIrai chkIrai
     */
    @JsonProperty("chkIrai")
    public void setChkIrai(CheckBoxList chkIrai) {
        this.chkIrai = chkIrai;
    }

    /*
     * gettxtHokkoymd
     * @return txtHokkoymd
     */
    @JsonProperty("txtHokkoymd")
    public TextBoxDate getTxtHokkoymd() {
        return txtHokkoymd;
    }

    /*
     * settxtHokkoymd
     * @param txtHokkoymd txtHokkoymd
     */
    @JsonProperty("txtHokkoymd")
    public void setTxtHokkoymd(TextBoxDate txtHokkoymd) {
        this.txtHokkoymd = txtHokkoymd;
    }

    /*
     * getradKigen
     * @return radKigen
     */
    @JsonProperty("radKigen")
    public RadioButton getRadKigen() {
        return radKigen;
    }

    /*
     * setradKigen
     * @param radKigen radKigen
     */
    @JsonProperty("radKigen")
    public void setRadKigen(RadioButton radKigen) {
        this.radKigen = radKigen;
    }

    /*
     * gettxtKigenymd
     * @return txtKigenymd
     */
    @JsonProperty("txtKigenymd")
    public TextBoxDate getTxtKigenymd() {
        return txtKigenymd;
    }

    /*
     * settxtKigenymd
     * @param txtKigenymd txtKigenymd
     */
    @JsonProperty("txtKigenymd")
    public void setTxtKigenymd(TextBoxDate txtKigenymd) {
        this.txtKigenymd = txtKigenymd;
    }

    /*
     * getNiteiChosaSelect
     * @return NiteiChosaSelect
     */
    @JsonProperty("NiteiChosaSelect")
    public NiteiChosaSelectDiv getNiteiChosaSelect() {
        return NiteiChosaSelect;
    }

    /*
     * setNiteiChosaSelect
     * @param NiteiChosaSelect NiteiChosaSelect
     */
    @JsonProperty("NiteiChosaSelect")
    public void setNiteiChosaSelect(NiteiChosaSelectDiv NiteiChosaSelect) {
        this.NiteiChosaSelect = NiteiChosaSelect;
    }

    /*
     * getTokkiJokoSelect
     * @return TokkiJokoSelect
     */
    @JsonProperty("TokkiJokoSelect")
    public TokkiJokoSelectDiv getTokkiJokoSelect() {
        return TokkiJokoSelect;
    }

    /*
     * setTokkiJokoSelect
     * @param TokkiJokoSelect TokkiJokoSelect
     */
    @JsonProperty("TokkiJokoSelect")
    public void setTokkiJokoSelect(TokkiJokoSelectDiv TokkiJokoSelect) {
        this.TokkiJokoSelect = TokkiJokoSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkNinteichosaDesign() {
        return this.getNiteiChosaSelect().getChkNinteichosaDesign();
    }

    @JsonIgnore
    public void  setChkNinteichosaDesign(CheckBoxList chkNinteichosaDesign) {
        this.getNiteiChosaSelect().setChkNinteichosaDesign(chkNinteichosaDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteichosaOcr() {
        return this.getNiteiChosaSelect().getChkNinteichosaOcr();
    }

    @JsonIgnore
    public void  setChkNinteichosaOcr(CheckBoxList chkNinteichosaOcr) {
        this.getNiteiChosaSelect().setChkNinteichosaOcr(chkNinteichosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiCheck() {
        return this.getNiteiChosaSelect().getChkSaiCheck();
    }

    @JsonIgnore
    public void  setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.getNiteiChosaSelect().setChkSaiCheck(chkSaiCheck);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiJko() {
        return this.getTokkiJokoSelect().getChkTokkiJko();
    }

    @JsonIgnore
    public void  setChkTokkiJko(CheckBoxList chkTokkiJko) {
        this.getTokkiJokoSelect().setChkTokkiJko(chkTokkiJko);
    }

    @JsonIgnore
    public CheckBoxList getChkTenyuryoku() {
        return this.getTokkiJokoSelect().getChkTenyuryoku();
    }

    @JsonIgnore
    public void  setChkTenyuryoku(CheckBoxList chkTenyuryoku) {
        this.getTokkiJokoSelect().setChkTenyuryoku(chkTenyuryoku);
    }

    // </editor-fold>
}
