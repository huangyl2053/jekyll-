package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * HasuHeijunkaJoho のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class HasuHeijunkaJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KibetsuHokenryo")
    private KibetsuHokenryoDiv KibetsuHokenryo;
    @JsonProperty("Heijunka6GatsuKeisanHoho")
    private Heijunka6GatsuKeisanHohoDiv Heijunka6GatsuKeisanHoho;
    @JsonProperty("Heijunka8GatsuKeisanHoho")
    private Heijunka8GatsuKeisanHohoDiv Heijunka8GatsuKeisanHoho;
    @JsonProperty("FuchoKirikaeKeisanHoho")
    private FuchoKirikaeKeisanHohoDiv FuchoKirikaeKeisanHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKibetsuHokenryo
     * @return KibetsuHokenryo
     */
    @JsonProperty("KibetsuHokenryo")
    public KibetsuHokenryoDiv getKibetsuHokenryo() {
        return KibetsuHokenryo;
    }

    /*
     * setKibetsuHokenryo
     * @param KibetsuHokenryo KibetsuHokenryo
     */
    @JsonProperty("KibetsuHokenryo")
    public void setKibetsuHokenryo(KibetsuHokenryoDiv KibetsuHokenryo) {
        this.KibetsuHokenryo = KibetsuHokenryo;
    }

    /*
     * getHeijunka6GatsuKeisanHoho
     * @return Heijunka6GatsuKeisanHoho
     */
    @JsonProperty("Heijunka6GatsuKeisanHoho")
    public Heijunka6GatsuKeisanHohoDiv getHeijunka6GatsuKeisanHoho() {
        return Heijunka6GatsuKeisanHoho;
    }

    /*
     * setHeijunka6GatsuKeisanHoho
     * @param Heijunka6GatsuKeisanHoho Heijunka6GatsuKeisanHoho
     */
    @JsonProperty("Heijunka6GatsuKeisanHoho")
    public void setHeijunka6GatsuKeisanHoho(Heijunka6GatsuKeisanHohoDiv Heijunka6GatsuKeisanHoho) {
        this.Heijunka6GatsuKeisanHoho = Heijunka6GatsuKeisanHoho;
    }

    /*
     * getHeijunka8GatsuKeisanHoho
     * @return Heijunka8GatsuKeisanHoho
     */
    @JsonProperty("Heijunka8GatsuKeisanHoho")
    public Heijunka8GatsuKeisanHohoDiv getHeijunka8GatsuKeisanHoho() {
        return Heijunka8GatsuKeisanHoho;
    }

    /*
     * setHeijunka8GatsuKeisanHoho
     * @param Heijunka8GatsuKeisanHoho Heijunka8GatsuKeisanHoho
     */
    @JsonProperty("Heijunka8GatsuKeisanHoho")
    public void setHeijunka8GatsuKeisanHoho(Heijunka8GatsuKeisanHohoDiv Heijunka8GatsuKeisanHoho) {
        this.Heijunka8GatsuKeisanHoho = Heijunka8GatsuKeisanHoho;
    }

    /*
     * getFuchoKirikaeKeisanHoho
     * @return FuchoKirikaeKeisanHoho
     */
    @JsonProperty("FuchoKirikaeKeisanHoho")
    public FuchoKirikaeKeisanHohoDiv getFuchoKirikaeKeisanHoho() {
        return FuchoKirikaeKeisanHoho;
    }

    /*
     * setFuchoKirikaeKeisanHoho
     * @param FuchoKirikaeKeisanHoho FuchoKirikaeKeisanHoho
     */
    @JsonProperty("FuchoKirikaeKeisanHoho")
    public void setFuchoKirikaeKeisanHoho(FuchoKirikaeKeisanHohoDiv FuchoKirikaeKeisanHoho) {
        this.FuchoKirikaeKeisanHoho = FuchoKirikaeKeisanHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getKibetsuHokenryo().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getKibetsuHokenryo().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunkaKeisanHoho() {
        return this.getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunkaKeisanHoho(DropDownList ddlHeijunkaKeisanHoho) {
        this.getHeijunka6GatsuKeisanHoho().setDdlHeijunkaKeisanHoho(ddlHeijunkaKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRadGengakuHeijunKa() {
        return this.getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRadGengakuHeijunKa(RadioButton radGengakuHeijunKa) {
        this.getHeijunka6GatsuKeisanHoho().setRadGengakuHeijunKa(radGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRadZogakuHeijunKa() {
        return this.getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRadZogakuHeijunKa(RadioButton radZogakuHeijunKa) {
        this.getHeijunka6GatsuKeisanHoho().setRadZogakuHeijunKa(radZogakuHeijunKa);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunka8GatsuKeisanHoho() {
        return this.getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunka8GatsuKeisanHoho(DropDownList ddlHeijunka8GatsuKeisanHoho) {
        this.getHeijunka8GatsuKeisanHoho().setDdlHeijunka8GatsuKeisanHoho(ddlHeijunka8GatsuKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuGengakuHeijunKa() {
        return this.getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuGengakuHeijunKa(RadioButton rad8GatsuGengakuHeijunKa) {
        this.getHeijunka8GatsuKeisanHoho().setRad8GatsuGengakuHeijunKa(rad8GatsuGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuZogakuHeijunKa() {
        return this.getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuZogakuHeijunKa(RadioButton rad8GatsuZogakuHeijunKa) {
        this.getHeijunka8GatsuKeisanHoho().setRad8GatsuZogakuHeijunKa(rad8GatsuZogakuHeijunKa);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeKeisanHoho() {
        return this.getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeKeisanHoho(DropDownList ddlFuchoKirikaeKeisanHoho) {
        this.getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeKeisanHoho(ddlFuchoKirikaeKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeJufukuStKi() {
        return this.getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeJufukuStKi(DropDownList ddlFuchoKirikaeJufukuStKi) {
        this.getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeJufukuStKi(ddlFuchoKirikaeJufukuStKi);
    }

    // </editor-fold>
}
