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
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tplGenNendo のクラスファイル
 *
 * @reamsid_L DBB-1770-050 xupeng
 */
public class tplGenNendoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KibetsuJoho")
    private KibetsuJohoDiv KibetsuJoho;
    @JsonProperty("KibetsuHasu")
    private KibetsuHasuDiv KibetsuHasu;
    @JsonProperty("ZanteiKeisanHoho")
    private ZanteiKeisanHohoDiv ZanteiKeisanHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKibetsuJoho
     * @return KibetsuJoho
     */
    @JsonProperty("KibetsuJoho")
    public KibetsuJohoDiv getKibetsuJoho() {
        return KibetsuJoho;
    }

    /*
     * setKibetsuJoho
     * @param KibetsuJoho KibetsuJoho
     */
    @JsonProperty("KibetsuJoho")
    public void setKibetsuJoho(KibetsuJohoDiv KibetsuJoho) {
        this.KibetsuJoho = KibetsuJoho;
    }

    /*
     * getKibetsuHasu
     * @return KibetsuHasu
     */
    @JsonProperty("KibetsuHasu")
    public KibetsuHasuDiv getKibetsuHasu() {
        return KibetsuHasu;
    }

    /*
     * setKibetsuHasu
     * @param KibetsuHasu KibetsuHasu
     */
    @JsonProperty("KibetsuHasu")
    public void setKibetsuHasu(KibetsuHasuDiv KibetsuHasu) {
        this.KibetsuHasu = KibetsuHasu;
    }

    /*
     * getZanteiKeisanHoho
     * @return ZanteiKeisanHoho
     */
    @JsonProperty("ZanteiKeisanHoho")
    public ZanteiKeisanHohoDiv getZanteiKeisanHoho() {
        return ZanteiKeisanHoho;
    }

    /*
     * setZanteiKeisanHoho
     * @param ZanteiKeisanHoho ZanteiKeisanHoho
     */
    @JsonProperty("ZanteiKeisanHoho")
    public void setZanteiKeisanHoho(ZanteiKeisanHohoDiv ZanteiKeisanHoho) {
        this.ZanteiKeisanHoho = ZanteiKeisanHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgGenNendoKibetsuJoho_Row> getDgGenNendoKibetsuJoho() {
        return this.getKibetsuJoho().getDgGenNendoKibetsuJoho();
    }

    @JsonIgnore
    public void setDgGenNendoKibetsuJoho(DataGrid<dgGenNendoKibetsuJoho_Row> dgGenNendoKibetsuJoho) {
        this.getKibetsuJoho().setDgGenNendoKibetsuJoho(dgGenNendoKibetsuJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getKibetsuHasu().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getKibetsuHasu().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public DropDownList getDdlFukaHoho() {
        return this.getZanteiKeisanHoho().getDdlFukaHoho();
    }

    @JsonIgnore
    public void setDdlFukaHoho(DropDownList ddlFukaHoho) {
        this.getZanteiKeisanHoho().setDdlFukaHoho(ddlFukaHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFukaHohoHelp() {
        return this.getZanteiKeisanHoho().getTxtFukaHohoHelp();
    }

    @JsonIgnore
    public void setTxtFukaHohoHelp(TextBoxMultiLine txtFukaHohoHelp) {
        this.getZanteiKeisanHoho().setTxtFukaHohoHelp(txtFukaHohoHelp);
    }

    @JsonIgnore
    public DropDownList getDdlIdoHoho() {
        return this.getZanteiKeisanHoho().getDdlIdoHoho();
    }

    @JsonIgnore
    public void setDdlIdoHoho(DropDownList ddlIdoHoho) {
        this.getZanteiKeisanHoho().setDdlIdoHoho(ddlIdoHoho);
    }

    @JsonIgnore
    public RadioButton getRadHasuChosei() {
        return this.getZanteiKeisanHoho().getRadHasuChosei();
    }

    @JsonIgnore
    public void setRadHasuChosei(RadioButton radHasuChosei) {
        this.getZanteiKeisanHoho().setRadHasuChosei(radHasuChosei);
    }

    @JsonIgnore
    public RadioButton getRadHeichoSha() {
        return this.getZanteiKeisanHoho().getRadHeichoSha();
    }

    @JsonIgnore
    public void setRadHeichoSha(RadioButton radHeichoSha) {
        this.getZanteiKeisanHoho().setRadHeichoSha(radHeichoSha);
    }

    // </editor-fold>
}
