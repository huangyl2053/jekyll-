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
 * ShokanJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShokanJoho")
    private Label lblShokanJoho;
    @JsonProperty("txtSagakuKingakuGokei")
    private TextBoxNum txtSagakuKingakuGokei;
    @JsonProperty("dgShokanJoho")
    private DataGrid<dgShokanJoho_Row> dgShokanJoho;
    @JsonProperty("SashitomeKojoJokyo")
    private SashitomeKojoJokyoDiv SashitomeKojoJokyo;
    @JsonProperty("TainoJokyo")
    private TainoJokyoDiv TainoJokyo;
    @JsonProperty("btnSashitomeOrKojoJokyoShokaiClose")
    private Button btnSashitomeOrKojoJokyoShokaiClose;
    @JsonProperty("btnSashitomeOrKojoTorokuKakutei")
    private Button btnSashitomeOrKojoTorokuKakutei;
    @JsonProperty("btnSashitomeOrKojoTorokuTorikeshi")
    private Button btnSashitomeOrKojoTorokuTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShokanJoho
     * @return lblShokanJoho
     */
    @JsonProperty("lblShokanJoho")
    public Label getLblShokanJoho() {
        return lblShokanJoho;
    }

    /*
     * setlblShokanJoho
     * @param lblShokanJoho lblShokanJoho
     */
    @JsonProperty("lblShokanJoho")
    public void setLblShokanJoho(Label lblShokanJoho) {
        this.lblShokanJoho = lblShokanJoho;
    }

    /*
     * gettxtSagakuKingakuGokei
     * @return txtSagakuKingakuGokei
     */
    @JsonProperty("txtSagakuKingakuGokei")
    public TextBoxNum getTxtSagakuKingakuGokei() {
        return txtSagakuKingakuGokei;
    }

    /*
     * settxtSagakuKingakuGokei
     * @param txtSagakuKingakuGokei txtSagakuKingakuGokei
     */
    @JsonProperty("txtSagakuKingakuGokei")
    public void setTxtSagakuKingakuGokei(TextBoxNum txtSagakuKingakuGokei) {
        this.txtSagakuKingakuGokei = txtSagakuKingakuGokei;
    }

    /*
     * getdgShokanJoho
     * @return dgShokanJoho
     */
    @JsonProperty("dgShokanJoho")
    public DataGrid<dgShokanJoho_Row> getDgShokanJoho() {
        return dgShokanJoho;
    }

    /*
     * setdgShokanJoho
     * @param dgShokanJoho dgShokanJoho
     */
    @JsonProperty("dgShokanJoho")
    public void setDgShokanJoho(DataGrid<dgShokanJoho_Row> dgShokanJoho) {
        this.dgShokanJoho = dgShokanJoho;
    }

    /*
     * getSashitomeKojoJokyo
     * @return SashitomeKojoJokyo
     */
    @JsonProperty("SashitomeKojoJokyo")
    public SashitomeKojoJokyoDiv getSashitomeKojoJokyo() {
        return SashitomeKojoJokyo;
    }

    /*
     * setSashitomeKojoJokyo
     * @param SashitomeKojoJokyo SashitomeKojoJokyo
     */
    @JsonProperty("SashitomeKojoJokyo")
    public void setSashitomeKojoJokyo(SashitomeKojoJokyoDiv SashitomeKojoJokyo) {
        this.SashitomeKojoJokyo = SashitomeKojoJokyo;
    }

    /*
     * getTainoJokyo
     * @return TainoJokyo
     */
    @JsonProperty("TainoJokyo")
    public TainoJokyoDiv getTainoJokyo() {
        return TainoJokyo;
    }

    /*
     * setTainoJokyo
     * @param TainoJokyo TainoJokyo
     */
    @JsonProperty("TainoJokyo")
    public void setTainoJokyo(TainoJokyoDiv TainoJokyo) {
        this.TainoJokyo = TainoJokyo;
    }

    /*
     * getbtnSashitomeOrKojoJokyoShokaiClose
     * @return btnSashitomeOrKojoJokyoShokaiClose
     */
    @JsonProperty("btnSashitomeOrKojoJokyoShokaiClose")
    public Button getBtnSashitomeOrKojoJokyoShokaiClose() {
        return btnSashitomeOrKojoJokyoShokaiClose;
    }

    /*
     * setbtnSashitomeOrKojoJokyoShokaiClose
     * @param btnSashitomeOrKojoJokyoShokaiClose btnSashitomeOrKojoJokyoShokaiClose
     */
    @JsonProperty("btnSashitomeOrKojoJokyoShokaiClose")
    public void setBtnSashitomeOrKojoJokyoShokaiClose(Button btnSashitomeOrKojoJokyoShokaiClose) {
        this.btnSashitomeOrKojoJokyoShokaiClose = btnSashitomeOrKojoJokyoShokaiClose;
    }

    /*
     * getbtnSashitomeOrKojoTorokuKakutei
     * @return btnSashitomeOrKojoTorokuKakutei
     */
    @JsonProperty("btnSashitomeOrKojoTorokuKakutei")
    public Button getBtnSashitomeOrKojoTorokuKakutei() {
        return btnSashitomeOrKojoTorokuKakutei;
    }

    /*
     * setbtnSashitomeOrKojoTorokuKakutei
     * @param btnSashitomeOrKojoTorokuKakutei btnSashitomeOrKojoTorokuKakutei
     */
    @JsonProperty("btnSashitomeOrKojoTorokuKakutei")
    public void setBtnSashitomeOrKojoTorokuKakutei(Button btnSashitomeOrKojoTorokuKakutei) {
        this.btnSashitomeOrKojoTorokuKakutei = btnSashitomeOrKojoTorokuKakutei;
    }

    /*
     * getbtnSashitomeOrKojoTorokuTorikeshi
     * @return btnSashitomeOrKojoTorokuTorikeshi
     */
    @JsonProperty("btnSashitomeOrKojoTorokuTorikeshi")
    public Button getBtnSashitomeOrKojoTorokuTorikeshi() {
        return btnSashitomeOrKojoTorokuTorikeshi;
    }

    /*
     * setbtnSashitomeOrKojoTorokuTorikeshi
     * @param btnSashitomeOrKojoTorokuTorikeshi btnSashitomeOrKojoTorokuTorikeshi
     */
    @JsonProperty("btnSashitomeOrKojoTorokuTorikeshi")
    public void setBtnSashitomeOrKojoTorokuTorikeshi(Button btnSashitomeOrKojoTorokuTorikeshi) {
        this.btnSashitomeOrKojoTorokuTorikeshi = btnSashitomeOrKojoTorokuTorikeshi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSashitomeTorokuKubun() {
        return this.getSashitomeKojoJokyo().getTxtSashitomeTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuKubun(TextBox txtSashitomeTorokuKubun) {
        this.getSashitomeKojoJokyo().setTxtSashitomeTorokuKubun(txtSashitomeTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeTorokuYMD() {
        return this.getSashitomeKojoJokyo().getTxtSashitomeTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuYMD(TextBoxFlexibleDate txtSashitomeTorokuYMD) {
        this.getSashitomeKojoJokyo().setTxtSashitomeTorokuYMD(txtSashitomeTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeTorokuTsuchiHakkoYMD() {
        return this.getSashitomeKojoJokyo().getTxtSashitomeTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtSashitomeTorokuTsuchiHakkoYMD) {
        this.getSashitomeKojoJokyo().setTxtSashitomeTorokuTsuchiHakkoYMD(txtSashitomeTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeNofuKigenYMD() {
        return this.getSashitomeKojoJokyo().getTxtSashitomeNofuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeNofuKigenYMD(TextBoxFlexibleDate txtSashitomeNofuKigenYMD) {
        this.getSashitomeKojoJokyo().setTxtSashitomeNofuKigenYMD(txtSashitomeNofuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeKaijoYMD() {
        return this.getSashitomeKojoJokyo().getTxtSashitomeKaijoYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeKaijoYMD(TextBoxFlexibleDate txtSashitomeKaijoYMD) {
        this.getSashitomeKojoJokyo().setTxtSashitomeKaijoYMD(txtSashitomeKaijoYMD);
    }

    @JsonIgnore
    public TextBox getTxtKojoTorokuKubun() {
        return this.getSashitomeKojoJokyo().getTxtKojoTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtKojoTorokuKubun(TextBox txtKojoTorokuKubun) {
        this.getSashitomeKojoJokyo().setTxtKojoTorokuKubun(txtKojoTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKojoKetteiYMD() {
        return this.getSashitomeKojoJokyo().getTxtKojoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKojoKetteiYMD(TextBoxFlexibleDate txtKojoKetteiYMD) {
        this.getSashitomeKojoJokyo().setTxtKojoKetteiYMD(txtKojoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKojoTorokuTsuchiHakkoYMD() {
        return this.getSashitomeKojoJokyo().getTxtKojoTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtKojoTorokuTsuchiHakkoYMD) {
        this.getSashitomeKojoJokyo().setTxtKojoTorokuTsuchiHakkoYMD(txtKojoTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHokenshoTeishutsuKigenYMD() {
        return this.getSashitomeKojoJokyo().getTxtHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtHokenshoTeishutsuKigenYMD) {
        this.getSashitomeKojoJokyo().setTxtHokenshoTeishutsuKigenYMD(txtHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public DropDownList getDdlTorokuKojoNo() {
        return this.getSashitomeKojoJokyo().getDdlTorokuKojoNo();
    }

    @JsonIgnore
    public void  setDdlTorokuKojoNo(DropDownList ddlTorokuKojoNo) {
        this.getSashitomeKojoJokyo().setDdlTorokuKojoNo(ddlTorokuKojoNo);
    }

    @JsonIgnore
    public SashitomeTorokuDiv getSashitomeToroku() {
        return this.getSashitomeKojoJokyo().getSashitomeToroku();
    }

    @JsonIgnore
    public void  setSashitomeToroku(SashitomeTorokuDiv SashitomeToroku) {
        this.getSashitomeKojoJokyo().setSashitomeToroku(SashitomeToroku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuYMD() {
        return this.getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuYMD) {
        this.getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeTorokuYMD(txtShokaiSashitomeTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeNofuKigenYMD() {
        return this.getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeNofuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeNofuKigenYMD(TextBoxFlexibleDate txtShokaiSashitomeNofuKigenYMD) {
        this.getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeNofuKigenYMD(txtShokaiSashitomeNofuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuTsuchiHakkoYMD() {
        return this.getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuTsuchiHakkoYMD) {
        this.getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(txtShokaiSashitomeTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public SasitomeKaijoDiv getSasitomeKaijo() {
        return this.getSashitomeKojoJokyo().getSasitomeKaijo();
    }

    @JsonIgnore
    public void  setSasitomeKaijo(SasitomeKaijoDiv SasitomeKaijo) {
        this.getSashitomeKojoJokyo().setSasitomeKaijo(SasitomeKaijo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeKaijoYMD() {
        return this.getSashitomeKojoJokyo().getSasitomeKaijo().getTxtShokaiSashitomeKaijoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeKaijoYMD(TextBoxFlexibleDate txtShokaiSashitomeKaijoYMD) {
        this.getSashitomeKojoJokyo().getSasitomeKaijo().setTxtShokaiSashitomeKaijoYMD(txtShokaiSashitomeKaijoYMD);
    }

    @JsonIgnore
    public KojoTorokuDiv getKojoToroku() {
        return this.getSashitomeKojoJokyo().getKojoToroku();
    }

    @JsonIgnore
    public void  setKojoToroku(KojoTorokuDiv KojoToroku) {
        this.getSashitomeKojoJokyo().setKojoToroku(KojoToroku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoKetteiYMD() {
        return this.getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoKetteiYMD(TextBoxFlexibleDate txtShokaiKojoKetteiYMD) {
        this.getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoKetteiYMD(txtShokaiKojoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiHokenshoTeishutsuKigenYMD() {
        return this.getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtShokaiHokenshoTeishutsuKigenYMD) {
        this.getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiHokenshoTeishutsuKigenYMD(txtShokaiHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoTorokuTsuchiHakkoYMD() {
        return this.getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiKojoTorokuTsuchiHakkoYMD) {
        this.getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoTorokuTsuchiHakkoYMD(txtShokaiKojoTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtShokaiKojoNo() {
        return this.getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoNo();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoNo(TextBox txtShokaiKojoNo) {
        this.getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoNo(txtShokaiKojoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getTainoJokyo().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void  setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getTainoJokyo().setBtnTainoJokyo(btnTainoJokyo);
    }

    // </editor-fold>
}
