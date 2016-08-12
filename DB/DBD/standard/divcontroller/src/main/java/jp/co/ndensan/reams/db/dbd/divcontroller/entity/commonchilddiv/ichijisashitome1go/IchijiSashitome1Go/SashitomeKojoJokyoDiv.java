package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;
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
 * SashitomeKojoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SashitomeKojoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSashitomeTorokuKubun")
    private TextBox txtSashitomeTorokuKubun;
    @JsonProperty("txtSashitomeTorokuYMD")
    private TextBoxFlexibleDate txtSashitomeTorokuYMD;
    @JsonProperty("txtSashitomeTorokuTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtSashitomeTorokuTsuchiHakkoYMD;
    @JsonProperty("txtSashitomeNofuKigenYMD")
    private TextBoxFlexibleDate txtSashitomeNofuKigenYMD;
    @JsonProperty("txtSashitomeKaijoYMD")
    private TextBoxFlexibleDate txtSashitomeKaijoYMD;
    @JsonProperty("txtKojoTorokuKubun")
    private TextBox txtKojoTorokuKubun;
    @JsonProperty("txtKojoKetteiYMD")
    private TextBoxFlexibleDate txtKojoKetteiYMD;
    @JsonProperty("txtKojoTorokuTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtKojoTorokuTsuchiHakkoYMD;
    @JsonProperty("txtHokenshoTeishutsuKigenYMD")
    private TextBoxFlexibleDate txtHokenshoTeishutsuKigenYMD;
    @JsonProperty("ddlTorokuKojoNo")
    private DropDownList ddlTorokuKojoNo;
    @JsonProperty("SashitomeToroku")
    private SashitomeTorokuDiv SashitomeToroku;
    @JsonProperty("SasitomeKaijo")
    private SasitomeKaijoDiv SasitomeKaijo;
    @JsonProperty("KojoToroku")
    private KojoTorokuDiv KojoToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSashitomeTorokuKubun
     * @return txtSashitomeTorokuKubun
     */
    @JsonProperty("txtSashitomeTorokuKubun")
    public TextBox getTxtSashitomeTorokuKubun() {
        return txtSashitomeTorokuKubun;
    }

    /*
     * settxtSashitomeTorokuKubun
     * @param txtSashitomeTorokuKubun txtSashitomeTorokuKubun
     */
    @JsonProperty("txtSashitomeTorokuKubun")
    public void setTxtSashitomeTorokuKubun(TextBox txtSashitomeTorokuKubun) {
        this.txtSashitomeTorokuKubun = txtSashitomeTorokuKubun;
    }

    /*
     * gettxtSashitomeTorokuYMD
     * @return txtSashitomeTorokuYMD
     */
    @JsonProperty("txtSashitomeTorokuYMD")
    public TextBoxFlexibleDate getTxtSashitomeTorokuYMD() {
        return txtSashitomeTorokuYMD;
    }

    /*
     * settxtSashitomeTorokuYMD
     * @param txtSashitomeTorokuYMD txtSashitomeTorokuYMD
     */
    @JsonProperty("txtSashitomeTorokuYMD")
    public void setTxtSashitomeTorokuYMD(TextBoxFlexibleDate txtSashitomeTorokuYMD) {
        this.txtSashitomeTorokuYMD = txtSashitomeTorokuYMD;
    }

    /*
     * gettxtSashitomeTorokuTsuchiHakkoYMD
     * @return txtSashitomeTorokuTsuchiHakkoYMD
     */
    @JsonProperty("txtSashitomeTorokuTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtSashitomeTorokuTsuchiHakkoYMD() {
        return txtSashitomeTorokuTsuchiHakkoYMD;
    }

    /*
     * settxtSashitomeTorokuTsuchiHakkoYMD
     * @param txtSashitomeTorokuTsuchiHakkoYMD txtSashitomeTorokuTsuchiHakkoYMD
     */
    @JsonProperty("txtSashitomeTorokuTsuchiHakkoYMD")
    public void setTxtSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtSashitomeTorokuTsuchiHakkoYMD) {
        this.txtSashitomeTorokuTsuchiHakkoYMD = txtSashitomeTorokuTsuchiHakkoYMD;
    }

    /*
     * gettxtSashitomeNofuKigenYMD
     * @return txtSashitomeNofuKigenYMD
     */
    @JsonProperty("txtSashitomeNofuKigenYMD")
    public TextBoxFlexibleDate getTxtSashitomeNofuKigenYMD() {
        return txtSashitomeNofuKigenYMD;
    }

    /*
     * settxtSashitomeNofuKigenYMD
     * @param txtSashitomeNofuKigenYMD txtSashitomeNofuKigenYMD
     */
    @JsonProperty("txtSashitomeNofuKigenYMD")
    public void setTxtSashitomeNofuKigenYMD(TextBoxFlexibleDate txtSashitomeNofuKigenYMD) {
        this.txtSashitomeNofuKigenYMD = txtSashitomeNofuKigenYMD;
    }

    /*
     * gettxtSashitomeKaijoYMD
     * @return txtSashitomeKaijoYMD
     */
    @JsonProperty("txtSashitomeKaijoYMD")
    public TextBoxFlexibleDate getTxtSashitomeKaijoYMD() {
        return txtSashitomeKaijoYMD;
    }

    /*
     * settxtSashitomeKaijoYMD
     * @param txtSashitomeKaijoYMD txtSashitomeKaijoYMD
     */
    @JsonProperty("txtSashitomeKaijoYMD")
    public void setTxtSashitomeKaijoYMD(TextBoxFlexibleDate txtSashitomeKaijoYMD) {
        this.txtSashitomeKaijoYMD = txtSashitomeKaijoYMD;
    }

    /*
     * gettxtKojoTorokuKubun
     * @return txtKojoTorokuKubun
     */
    @JsonProperty("txtKojoTorokuKubun")
    public TextBox getTxtKojoTorokuKubun() {
        return txtKojoTorokuKubun;
    }

    /*
     * settxtKojoTorokuKubun
     * @param txtKojoTorokuKubun txtKojoTorokuKubun
     */
    @JsonProperty("txtKojoTorokuKubun")
    public void setTxtKojoTorokuKubun(TextBox txtKojoTorokuKubun) {
        this.txtKojoTorokuKubun = txtKojoTorokuKubun;
    }

    /*
     * gettxtKojoKetteiYMD
     * @return txtKojoKetteiYMD
     */
    @JsonProperty("txtKojoKetteiYMD")
    public TextBoxFlexibleDate getTxtKojoKetteiYMD() {
        return txtKojoKetteiYMD;
    }

    /*
     * settxtKojoKetteiYMD
     * @param txtKojoKetteiYMD txtKojoKetteiYMD
     */
    @JsonProperty("txtKojoKetteiYMD")
    public void setTxtKojoKetteiYMD(TextBoxFlexibleDate txtKojoKetteiYMD) {
        this.txtKojoKetteiYMD = txtKojoKetteiYMD;
    }

    /*
     * gettxtKojoTorokuTsuchiHakkoYMD
     * @return txtKojoTorokuTsuchiHakkoYMD
     */
    @JsonProperty("txtKojoTorokuTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtKojoTorokuTsuchiHakkoYMD() {
        return txtKojoTorokuTsuchiHakkoYMD;
    }

    /*
     * settxtKojoTorokuTsuchiHakkoYMD
     * @param txtKojoTorokuTsuchiHakkoYMD txtKojoTorokuTsuchiHakkoYMD
     */
    @JsonProperty("txtKojoTorokuTsuchiHakkoYMD")
    public void setTxtKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtKojoTorokuTsuchiHakkoYMD) {
        this.txtKojoTorokuTsuchiHakkoYMD = txtKojoTorokuTsuchiHakkoYMD;
    }

    /*
     * gettxtHokenshoTeishutsuKigenYMD
     * @return txtHokenshoTeishutsuKigenYMD
     */
    @JsonProperty("txtHokenshoTeishutsuKigenYMD")
    public TextBoxFlexibleDate getTxtHokenshoTeishutsuKigenYMD() {
        return txtHokenshoTeishutsuKigenYMD;
    }

    /*
     * settxtHokenshoTeishutsuKigenYMD
     * @param txtHokenshoTeishutsuKigenYMD txtHokenshoTeishutsuKigenYMD
     */
    @JsonProperty("txtHokenshoTeishutsuKigenYMD")
    public void setTxtHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtHokenshoTeishutsuKigenYMD) {
        this.txtHokenshoTeishutsuKigenYMD = txtHokenshoTeishutsuKigenYMD;
    }

    /*
     * getddlTorokuKojoNo
     * @return ddlTorokuKojoNo
     */
    @JsonProperty("ddlTorokuKojoNo")
    public DropDownList getDdlTorokuKojoNo() {
        return ddlTorokuKojoNo;
    }

    /*
     * setddlTorokuKojoNo
     * @param ddlTorokuKojoNo ddlTorokuKojoNo
     */
    @JsonProperty("ddlTorokuKojoNo")
    public void setDdlTorokuKojoNo(DropDownList ddlTorokuKojoNo) {
        this.ddlTorokuKojoNo = ddlTorokuKojoNo;
    }

    /*
     * getSashitomeToroku
     * @return SashitomeToroku
     */
    @JsonProperty("SashitomeToroku")
    public SashitomeTorokuDiv getSashitomeToroku() {
        return SashitomeToroku;
    }

    /*
     * setSashitomeToroku
     * @param SashitomeToroku SashitomeToroku
     */
    @JsonProperty("SashitomeToroku")
    public void setSashitomeToroku(SashitomeTorokuDiv SashitomeToroku) {
        this.SashitomeToroku = SashitomeToroku;
    }

    /*
     * getSasitomeKaijo
     * @return SasitomeKaijo
     */
    @JsonProperty("SasitomeKaijo")
    public SasitomeKaijoDiv getSasitomeKaijo() {
        return SasitomeKaijo;
    }

    /*
     * setSasitomeKaijo
     * @param SasitomeKaijo SasitomeKaijo
     */
    @JsonProperty("SasitomeKaijo")
    public void setSasitomeKaijo(SasitomeKaijoDiv SasitomeKaijo) {
        this.SasitomeKaijo = SasitomeKaijo;
    }

    /*
     * getKojoToroku
     * @return KojoToroku
     */
    @JsonProperty("KojoToroku")
    public KojoTorokuDiv getKojoToroku() {
        return KojoToroku;
    }

    /*
     * setKojoToroku
     * @param KojoToroku KojoToroku
     */
    @JsonProperty("KojoToroku")
    public void setKojoToroku(KojoTorokuDiv KojoToroku) {
        this.KojoToroku = KojoToroku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuYMD() {
        return this.getSashitomeToroku().getTxtShokaiSashitomeTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuYMD) {
        this.getSashitomeToroku().setTxtShokaiSashitomeTorokuYMD(txtShokaiSashitomeTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeNofuKigenYMD() {
        return this.getSashitomeToroku().getTxtShokaiSashitomeNofuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeNofuKigenYMD(TextBoxFlexibleDate txtShokaiSashitomeNofuKigenYMD) {
        this.getSashitomeToroku().setTxtShokaiSashitomeNofuKigenYMD(txtShokaiSashitomeNofuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuTsuchiHakkoYMD() {
        return this.getSashitomeToroku().getTxtShokaiSashitomeTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuTsuchiHakkoYMD) {
        this.getSashitomeToroku().setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(txtShokaiSashitomeTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeKaijoYMD() {
        return this.getSasitomeKaijo().getTxtShokaiSashitomeKaijoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeKaijoYMD(TextBoxFlexibleDate txtShokaiSashitomeKaijoYMD) {
        this.getSasitomeKaijo().setTxtShokaiSashitomeKaijoYMD(txtShokaiSashitomeKaijoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoKetteiYMD() {
        return this.getKojoToroku().getTxtShokaiKojoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoKetteiYMD(TextBoxFlexibleDate txtShokaiKojoKetteiYMD) {
        this.getKojoToroku().setTxtShokaiKojoKetteiYMD(txtShokaiKojoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiHokenshoTeishutsuKigenYMD() {
        return this.getKojoToroku().getTxtShokaiHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtShokaiHokenshoTeishutsuKigenYMD) {
        this.getKojoToroku().setTxtShokaiHokenshoTeishutsuKigenYMD(txtShokaiHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoTorokuTsuchiHakkoYMD() {
        return this.getKojoToroku().getTxtShokaiKojoTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiKojoTorokuTsuchiHakkoYMD) {
        this.getKojoToroku().setTxtShokaiKojoTorokuTsuchiHakkoYMD(txtShokaiKojoTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtShokaiKojoNo() {
        return this.getKojoToroku().getTxtShokaiKojoNo();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoNo(TextBox txtShokaiKojoNo) {
        this.getKojoToroku().setTxtShokaiKojoNo(txtShokaiKojoNo);
    }

    // </editor-fold>
}
