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
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tabFuCho のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class tabFuChoDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplGenNendo")
    private tplGenNendoDiv tplGenNendo;
    @JsonProperty("tplKaNendo")
    private tplKaNendoDiv tplKaNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplGenNendo
     * @return tplGenNendo
     */
    @JsonProperty("tplGenNendo")
    public tplGenNendoDiv getTplGenNendo() {
        return tplGenNendo;
    }

    /*
     * settplGenNendo
     * @param tplGenNendo tplGenNendo
     */
    @JsonProperty("tplGenNendo")
    public void setTplGenNendo(tplGenNendoDiv tplGenNendo) {
        this.tplGenNendo = tplGenNendo;
    }

    /*
     * gettplKaNendo
     * @return tplKaNendo
     */
    @JsonProperty("tplKaNendo")
    public tplKaNendoDiv getTplKaNendo() {
        return tplKaNendo;
    }

    /*
     * settplKaNendo
     * @param tplKaNendo tplKaNendo
     */
    @JsonProperty("tplKaNendo")
    public void setTplKaNendo(tplKaNendoDiv tplKaNendo) {
        this.tplKaNendo = tplKaNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KibetsuJohoDiv getKibetsuJoho() {
        return this.getTplGenNendo().getKibetsuJoho();
    }

    @JsonIgnore
    public void setKibetsuJoho(KibetsuJohoDiv KibetsuJoho) {
        this.getTplGenNendo().setKibetsuJoho(KibetsuJoho);
    }

    @JsonIgnore
    public DataGrid<dgGenNendoKibetsuJoho_Row> getDgGenNendoKibetsuJoho() {
        return this.getTplGenNendo().getKibetsuJoho().getDgGenNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgGenNendoKibetsuJoho(DataGrid<dgGenNendoKibetsuJoho_Row> dgGenNendoKibetsuJoho) {
        this.getTplGenNendo().getKibetsuJoho().setDgGenNendoKibetsuJoho(dgGenNendoKibetsuJoho);
    }

    @JsonIgnore
    public KibetsuHasuDiv getKibetsuHasu() {
        return this.getTplGenNendo().getKibetsuHasu();
    }

    @JsonIgnore
    public void setKibetsuHasu(KibetsuHasuDiv KibetsuHasu) {
        this.getTplGenNendo().setKibetsuHasu(KibetsuHasu);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getTplGenNendo().getKibetsuHasu().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getTplGenNendo().getKibetsuHasu().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public ZanteiKeisanHohoDiv getZanteiKeisanHoho() {
        return this.getTplGenNendo().getZanteiKeisanHoho();
    }

    @JsonIgnore
    public void setZanteiKeisanHoho(ZanteiKeisanHohoDiv ZanteiKeisanHoho) {
        this.getTplGenNendo().setZanteiKeisanHoho(ZanteiKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFukaHoho() {
        return this.getTplGenNendo().getZanteiKeisanHoho().getDdlFukaHoho();
    }

    @JsonIgnore
    public void setDdlFukaHoho(DropDownList ddlFukaHoho) {
        this.getTplGenNendo().getZanteiKeisanHoho().setDdlFukaHoho(ddlFukaHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaHohoHelp() {
        return this.getTplGenNendo().getZanteiKeisanHoho().getTxtFukaHohoHelp();
    }

    @JsonIgnore
    public void setTxtFukaHohoHelp(TextBoxMultiLine txtFukaHohoHelp) {
        this.getTplGenNendo().getZanteiKeisanHoho().setTxtFukaHohoHelp(txtFukaHohoHelp);
    }

    @JsonIgnore
    public DropDownList getDdlIdoHoho() {
        return this.getTplGenNendo().getZanteiKeisanHoho().getDdlIdoHoho();
    }

    @JsonIgnore
    public void setDdlIdoHoho(DropDownList ddlIdoHoho) {
        this.getTplGenNendo().getZanteiKeisanHoho().setDdlIdoHoho(ddlIdoHoho);
    }

    @JsonIgnore
    public RadioButton getRadHasuChosei() {
        return this.getTplGenNendo().getZanteiKeisanHoho().getRadHasuChosei();
    }

    @JsonIgnore
    public void setRadHasuChosei(RadioButton radHasuChosei) {
        this.getTplGenNendo().getZanteiKeisanHoho().setRadHasuChosei(radHasuChosei);
    }

    @JsonIgnore
    public RadioButton getRadHeichoSha() {
        return this.getTplGenNendo().getZanteiKeisanHoho().getRadHeichoSha();
    }

    @JsonIgnore
    public void setRadHeichoSha(RadioButton radHeichoSha) {
        this.getTplGenNendo().getZanteiKeisanHoho().setRadHeichoSha(radHeichoSha);
    }

    @JsonIgnore
    public KaNendoDiv getKaNendo() {
        return this.getTplKaNendo().getKaNendo();
    }

    @JsonIgnore
    public void setKaNendo(KaNendoDiv KaNendo) {
        this.getTplKaNendo().setKaNendo(KaNendo);
    }

    @JsonIgnore
    public DataGrid<dgKaNendoKibetsuJoho_Row> getDgKaNendoKibetsuJoho() {
        return this.getTplKaNendo().getKaNendo().getDgKaNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgKaNendoKibetsuJoho(DataGrid<dgKaNendoKibetsuJoho_Row> dgKaNendoKibetsuJoho) {
        this.getTplKaNendo().getKaNendo().setDgKaNendoKibetsuJoho(dgKaNendoKibetsuJoho);
    }

    // </editor-fold>
}
