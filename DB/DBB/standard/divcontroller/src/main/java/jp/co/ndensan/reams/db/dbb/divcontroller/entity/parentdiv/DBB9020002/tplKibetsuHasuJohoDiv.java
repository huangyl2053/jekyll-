package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
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

/**
 * tplKibetsuHasuJoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class tplKibetsuHasuJohoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KibetsuJohoHasu")
    private KibetsuJohoHasuDiv KibetsuJohoHasu;
    @JsonProperty("HasuHeijunkaJoho")
    private HasuHeijunkaJohoDiv HasuHeijunkaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKibetsuJohoHasu
     * @return KibetsuJohoHasu
     */
    @JsonProperty("KibetsuJohoHasu")
    public KibetsuJohoHasuDiv getKibetsuJohoHasu() {
        return KibetsuJohoHasu;
    }

    /*
     * setKibetsuJohoHasu
     * @param KibetsuJohoHasu KibetsuJohoHasu
     */
    @JsonProperty("KibetsuJohoHasu")
    public void setKibetsuJohoHasu(KibetsuJohoHasuDiv KibetsuJohoHasu) {
        this.KibetsuJohoHasu = KibetsuJohoHasu;
    }

    /*
     * getHasuHeijunkaJoho
     * @return HasuHeijunkaJoho
     */
    @JsonProperty("HasuHeijunkaJoho")
    public HasuHeijunkaJohoDiv getHasuHeijunkaJoho() {
        return HasuHeijunkaJoho;
    }

    /*
     * setHasuHeijunkaJoho
     * @param HasuHeijunkaJoho HasuHeijunkaJoho
     */
    @JsonProperty("HasuHeijunkaJoho")
    public void setHasuHeijunkaJoho(HasuHeijunkaJohoDiv HasuHeijunkaJoho) {
        this.HasuHeijunkaJoho = HasuHeijunkaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKibetsuJoho_Row> getDgKibetsuJoho() {
        return this.getKibetsuJohoHasu().getDgKibetsuJoho();
    }

    @JsonIgnore
    public void setDgKibetsuJoho(DataGrid<dgKibetsuJoho_Row> dgKibetsuJoho) {
        this.getKibetsuJohoHasu().setDgKibetsuJoho(dgKibetsuJoho);
    }

    @JsonIgnore
    public KibetsuHokenryoDiv getKibetsuHokenryo() {
        return this.getHasuHeijunkaJoho().getKibetsuHokenryo();
    }

    @JsonIgnore
    public void setKibetsuHokenryo(KibetsuHokenryoDiv KibetsuHokenryo) {
        this.getHasuHeijunkaJoho().setKibetsuHokenryo(KibetsuHokenryo);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getHasuHeijunkaJoho().getKibetsuHokenryo().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getHasuHeijunkaJoho().getKibetsuHokenryo().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public Heijunka6GatsuKeisanHohoDiv getHeijunka6GatsuKeisanHoho() {
        return this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setHeijunka6GatsuKeisanHoho(Heijunka6GatsuKeisanHohoDiv Heijunka6GatsuKeisanHoho) {
        this.getHasuHeijunkaJoho().setHeijunka6GatsuKeisanHoho(Heijunka6GatsuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunkaKeisanHoho() {
        return this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunkaKeisanHoho(DropDownList ddlHeijunkaKeisanHoho) {
        this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setDdlHeijunkaKeisanHoho(ddlHeijunkaKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRadGengakuHeijunKa() {
        return this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRadGengakuHeijunKa(RadioButton radGengakuHeijunKa) {
        this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setRadGengakuHeijunKa(radGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRadZogakuHeijunKa() {
        return this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRadZogakuHeijunKa(RadioButton radZogakuHeijunKa) {
        this.getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setRadZogakuHeijunKa(radZogakuHeijunKa);
    }

    @JsonIgnore
    public Heijunka8GatsuKeisanHohoDiv getHeijunka8GatsuKeisanHoho() {
        return this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setHeijunka8GatsuKeisanHoho(Heijunka8GatsuKeisanHohoDiv Heijunka8GatsuKeisanHoho) {
        this.getHasuHeijunkaJoho().setHeijunka8GatsuKeisanHoho(Heijunka8GatsuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunka8GatsuKeisanHoho() {
        return this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunka8GatsuKeisanHoho(DropDownList ddlHeijunka8GatsuKeisanHoho) {
        this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setDdlHeijunka8GatsuKeisanHoho(ddlHeijunka8GatsuKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuGengakuHeijunKa() {
        return this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuGengakuHeijunKa(RadioButton rad8GatsuGengakuHeijunKa) {
        this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setRad8GatsuGengakuHeijunKa(rad8GatsuGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuZogakuHeijunKa() {
        return this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuZogakuHeijunKa(RadioButton rad8GatsuZogakuHeijunKa) {
        this.getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setRad8GatsuZogakuHeijunKa(rad8GatsuZogakuHeijunKa);
    }

    @JsonIgnore
    public FuchoKirikaeKeisanHohoDiv getFuchoKirikaeKeisanHoho() {
        return this.getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho();
    }

    @JsonIgnore
    public void setFuchoKirikaeKeisanHoho(FuchoKirikaeKeisanHohoDiv FuchoKirikaeKeisanHoho) {
        this.getHasuHeijunkaJoho().setFuchoKirikaeKeisanHoho(FuchoKirikaeKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeKeisanHoho() {
        return this.getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeKeisanHoho(DropDownList ddlFuchoKirikaeKeisanHoho) {
        this.getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeKeisanHoho(ddlFuchoKirikaeKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeJufukuStKi() {
        return this.getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeJufukuStKi(DropDownList ddlFuchoKirikaeJufukuStKi) {
        this.getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeJufukuStKi(ddlFuchoKirikaeJufukuStKi);
    }

    // </editor-fold>
}
