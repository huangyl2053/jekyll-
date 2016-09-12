package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * tplKozaMongoRyoshuHizukei のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class tplKozaMongoRyoshuHizukeiDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KozaMongon")
    private KozaMongonDiv KozaMongon;
    @JsonProperty("ShutsuryokuHoho")
    private ShutsuryokuHohoDiv ShutsuryokuHoho;
    @JsonProperty("NokigenOCR")
    private NokigenOCRDiv NokigenOCR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKozaMongon
     * @return KozaMongon
     */
    @JsonProperty("KozaMongon")
    public KozaMongonDiv getKozaMongon() {
        return KozaMongon;
    }

    /*
     * setKozaMongon
     * @param KozaMongon KozaMongon
     */
    @JsonProperty("KozaMongon")
    public void setKozaMongon(KozaMongonDiv KozaMongon) {
        this.KozaMongon = KozaMongon;
    }

    /*
     * getShutsuryokuHoho
     * @return ShutsuryokuHoho
     */
    @JsonProperty("ShutsuryokuHoho")
    public ShutsuryokuHohoDiv getShutsuryokuHoho() {
        return ShutsuryokuHoho;
    }

    /*
     * setShutsuryokuHoho
     * @param ShutsuryokuHoho ShutsuryokuHoho
     */
    @JsonProperty("ShutsuryokuHoho")
    public void setShutsuryokuHoho(ShutsuryokuHohoDiv ShutsuryokuHoho) {
        this.ShutsuryokuHoho = ShutsuryokuHoho;
    }

    /*
     * getNokigenOCR
     * @return NokigenOCR
     */
    @JsonProperty("NokigenOCR")
    public NokigenOCRDiv getNokigenOCR() {
        return NokigenOCR;
    }

    /*
     * setNokigenOCR
     * @param NokigenOCR NokigenOCR
     */
    @JsonProperty("NokigenOCR")
    public void setNokigenOCR(NokigenOCRDiv NokigenOCR) {
        this.NokigenOCR = NokigenOCR;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoNofugaku() {
        return this.getKozaMongon().getDdlKozaMongonRyoshushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoNofugaku(DropDownList ddlKozaMongonRyoshushoNofugaku) {
        this.getKozaMongon().setDdlKozaMongonRyoshushoNofugaku(ddlKozaMongonRyoshushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoNofugaku() {
        return this.getKozaMongon().getDdlKozaMongonNofushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoNofugaku(DropDownList ddlKozaMongonNofushoNofugaku) {
        this.getKozaMongon().setDdlKozaMongonNofushoNofugaku(ddlKozaMongonNofushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoRyoshuin() {
        return this.getKozaMongon().getDdlKozaMongonRyoshushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoRyoshuin(DropDownList ddlKozaMongonRyoshushoRyoshuin) {
        this.getKozaMongon().setDdlKozaMongonRyoshushoRyoshuin(ddlKozaMongonRyoshushoRyoshuin);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoRyoshuin() {
        return this.getKozaMongon().getDdlKozaMongonNofushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoRyoshuin(DropDownList ddlKozaMongonNofushoRyoshuin) {
        this.getKozaMongon().setDdlKozaMongonNofushoRyoshuin(ddlKozaMongonNofushoRyoshuin);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn() {
        return this.getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn) {
        this.getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoNofushoRyoshuHiduke() {
        return this.getShutsuryokuHoho().getDdlShutsuryokuHohoNofushoRyoshuHiduke();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoNofushoRyoshuHiduke(DropDownList ddlShutsuryokuHohoNofushoRyoshuHiduke) {
        this.getShutsuryokuHoho().setDdlShutsuryokuHohoNofushoRyoshuHiduke(ddlShutsuryokuHohoNofushoRyoshuHiduke);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi() {
        return this.getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi) {
        this.getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShutsuryokuHoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getShutsuryokuHoho().setLin1(lin1);
    }

    @JsonIgnore
    public DropDownList getDdlNofushoShichosonNameUmu() {
        return this.getShutsuryokuHoho().getDdlNofushoShichosonNameUmu();
    }

    @JsonIgnore
    public void setDdlNofushoShichosonNameUmu(DropDownList ddlNofushoShichosonNameUmu) {
        this.getShutsuryokuHoho().setDdlNofushoShichosonNameUmu(ddlNofushoShichosonNameUmu);
    }

    @JsonIgnore
    public TextBox getTxtNofushoShichosonName() {
        return this.getShutsuryokuHoho().getTxtNofushoShichosonName();
    }

    @JsonIgnore
    public void setTxtNofushoShichosonName(TextBox txtNofushoShichosonName) {
        this.getShutsuryokuHoho().setTxtNofushoShichosonName(txtNofushoShichosonName);
    }

    @JsonIgnore
    public DropDownList getDdlNokigenShutsuryokuHoho() {
        return this.getNokigenOCR().getDdlNokigenShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlNokigenShutsuryokuHoho(DropDownList ddlNokigenShutsuryokuHoho) {
        this.getNokigenOCR().setDdlNokigenShutsuryokuHoho(ddlNokigenShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlOCRShutsuryokuHoho() {
        return this.getNokigenOCR().getDdlOCRShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlOCRShutsuryokuHoho(DropDownList ddlOCRShutsuryokuHoho) {
        this.getNokigenOCR().setDdlOCRShutsuryokuHoho(ddlOCRShutsuryokuHoho);
    }

    // </editor-fold>
}
