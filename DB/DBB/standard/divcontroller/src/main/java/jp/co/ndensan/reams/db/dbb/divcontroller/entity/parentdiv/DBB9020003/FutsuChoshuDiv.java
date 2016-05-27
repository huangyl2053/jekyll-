package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * FutsuChoshu のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class FutsuChoshuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabFuCho")
    private tabFuChoDiv tabFuCho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabFuCho
     * @return tabFuCho
     */
    @JsonProperty("tabFuCho")
    public tabFuChoDiv getTabFuCho() {
        return tabFuCho;
    }

    /*
     * settabFuCho
     * @param tabFuCho tabFuCho
     */
    @JsonProperty("tabFuCho")
    public void setTabFuCho(tabFuChoDiv tabFuCho) {
        this.tabFuCho = tabFuCho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplGenNendoDiv getTplGenNendo() {
        return this.getTabFuCho().getTplGenNendo();
    }

    @JsonIgnore
    public void setTplGenNendo(tplGenNendoDiv tplGenNendo) {
        this.getTabFuCho().setTplGenNendo(tplGenNendo);
    }

    @JsonIgnore
    public KibetsuJohoDiv getKibetsuJoho() {
        return this.getTabFuCho().getTplGenNendo().getKibetsuJoho();
    }

    @JsonIgnore
    public void setKibetsuJoho(KibetsuJohoDiv KibetsuJoho) {
        this.getTabFuCho().getTplGenNendo().setKibetsuJoho(KibetsuJoho);
    }

    @JsonIgnore
    public DataGrid<dgGenNendoKibetsuJoho_Row> getDgGenNendoKibetsuJoho() {
        return this.getTabFuCho().getTplGenNendo().getKibetsuJoho().getDgGenNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgGenNendoKibetsuJoho(DataGrid<dgGenNendoKibetsuJoho_Row> dgGenNendoKibetsuJoho) {
        this.getTabFuCho().getTplGenNendo().getKibetsuJoho().setDgGenNendoKibetsuJoho(dgGenNendoKibetsuJoho);
    }

    @JsonIgnore
    public KibetsuHasuDiv getKibetsuHasu() {
        return this.getTabFuCho().getTplGenNendo().getKibetsuHasu();
    }

    @JsonIgnore
    public void setKibetsuHasu(KibetsuHasuDiv KibetsuHasu) {
        this.getTabFuCho().getTplGenNendo().setKibetsuHasu(KibetsuHasu);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getTabFuCho().getTplGenNendo().getKibetsuHasu().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getTabFuCho().getTplGenNendo().getKibetsuHasu().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public ZanteiKeisanHohoDiv getZanteiKeisanHoho() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho();
    }

    @JsonIgnore
    public void setZanteiKeisanHoho(ZanteiKeisanHohoDiv ZanteiKeisanHoho) {
        this.getTabFuCho().getTplGenNendo().setZanteiKeisanHoho(ZanteiKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFukaHoho() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().getDdlFukaHoho();
    }

    @JsonIgnore
    public void setDdlFukaHoho(DropDownList ddlFukaHoho) {
        this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().setDdlFukaHoho(ddlFukaHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaHohoHelp() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().getTxtFukaHohoHelp();
    }

    @JsonIgnore
    public void setTxtFukaHohoHelp(TextBoxMultiLine txtFukaHohoHelp) {
        this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().setTxtFukaHohoHelp(txtFukaHohoHelp);
    }

    @JsonIgnore
    public DropDownList getDdlIdoHoho() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().getDdlIdoHoho();
    }

    @JsonIgnore
    public void setDdlIdoHoho(DropDownList ddlIdoHoho) {
        this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().setDdlIdoHoho(ddlIdoHoho);
    }

    @JsonIgnore
    public RadioButton getRadHasuChosei() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().getRadHasuChosei();
    }

    @JsonIgnore
    public void setRadHasuChosei(RadioButton radHasuChosei) {
        this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().setRadHasuChosei(radHasuChosei);
    }

    @JsonIgnore
    public RadioButton getRadHeichoSha() {
        return this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().getRadHeichoSha();
    }

    @JsonIgnore
    public void setRadHeichoSha(RadioButton radHeichoSha) {
        this.getTabFuCho().getTplGenNendo().getZanteiKeisanHoho().setRadHeichoSha(radHeichoSha);
    }

    @JsonIgnore
    public tplKaNendoDiv getTplKaNendo() {
        return this.getTabFuCho().getTplKaNendo();
    }

    @JsonIgnore
    public void setTplKaNendo(tplKaNendoDiv tplKaNendo) {
        this.getTabFuCho().setTplKaNendo(tplKaNendo);
    }

    @JsonIgnore
    public KaNendoDiv getKaNendo() {
        return this.getTabFuCho().getTplKaNendo().getKaNendo();
    }

    @JsonIgnore
    public void setKaNendo(KaNendoDiv KaNendo) {
        this.getTabFuCho().getTplKaNendo().setKaNendo(KaNendo);
    }

    @JsonIgnore
    public DataGrid<dgKaNendoKibetsuJoho_Row> getDgKaNendoKibetsuJoho() {
        return this.getTabFuCho().getTplKaNendo().getKaNendo().getDgKaNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgKaNendoKibetsuJoho(DataGrid<dgKaNendoKibetsuJoho_Row> dgKaNendoKibetsuJoho) {
        this.getTabFuCho().getTplKaNendo().getKaNendo().setDgKaNendoKibetsuJoho(dgKaNendoKibetsuJoho);
    }

    // </editor-fold>
}
