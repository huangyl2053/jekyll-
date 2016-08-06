package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiSashitome1Go のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiSashitome1GoDiv extends Panel implements IIchijiSashitome1GoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSashitomeToroku")
    private Button btnSashitomeToroku;
    @JsonProperty("btnKojoToroku")
    private Button btnKojoToroku;
    @JsonProperty("btnSashitomeOrKojoJokyoShokai")
    private Button btnSashitomeOrKojoJokyoShokai;
    @JsonProperty("dgSashitomeKojoIchiran")
    private DataGrid<dgSashitomeKojoIchiran_Row> dgSashitomeKojoIchiran;
    @JsonProperty("ShokanJoho")
    private ShokanJohoDiv ShokanJoho;
    @JsonProperty("IchijiSashitome1GoKakutei")
    private Button IchijiSashitome1GoKakutei;
    @JsonProperty("IchijiSashitome1GoTorikeshi")
    private Button IchijiSashitome1GoTorikeshi;
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    private RString key_ShiharaiHohoHenkoKanri;
    @JsonProperty("key_HihokenshaNo")
    private RString key_HihokenshaNo;
    @JsonProperty("key_MaxRirekiNo")
    private RString key_MaxRirekiNo;
    @JsonProperty("key_Button")
    private RString key_Button;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("kanriKubun")
    private RString kanriKubun;
    @JsonProperty("tainoHanteiKubun")
    private RString tainoHanteiKubun;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;
    @JsonProperty("tainoHanteiKekka")
    private RString tainoHanteiKekka;
    @JsonProperty("PTN")
    private RString PTN;
    @JsonProperty("button_Name")
    private RString button_Name;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSashitomeToroku
     * @return btnSashitomeToroku
     */
    @JsonProperty("btnSashitomeToroku")
    public Button getBtnSashitomeToroku() {
        return btnSashitomeToroku;
    }

    /*
     * setbtnSashitomeToroku
     * @param btnSashitomeToroku btnSashitomeToroku
     */
    @JsonProperty("btnSashitomeToroku")
    public void setBtnSashitomeToroku(Button btnSashitomeToroku) {
        this.btnSashitomeToroku = btnSashitomeToroku;
    }

    /*
     * getbtnKojoToroku
     * @return btnKojoToroku
     */
    @JsonProperty("btnKojoToroku")
    public Button getBtnKojoToroku() {
        return btnKojoToroku;
    }

    /*
     * setbtnKojoToroku
     * @param btnKojoToroku btnKojoToroku
     */
    @JsonProperty("btnKojoToroku")
    public void setBtnKojoToroku(Button btnKojoToroku) {
        this.btnKojoToroku = btnKojoToroku;
    }

    /*
     * getbtnSashitomeOrKojoJokyoShokai
     * @return btnSashitomeOrKojoJokyoShokai
     */
    @JsonProperty("btnSashitomeOrKojoJokyoShokai")
    public Button getBtnSashitomeOrKojoJokyoShokai() {
        return btnSashitomeOrKojoJokyoShokai;
    }

    /*
     * setbtnSashitomeOrKojoJokyoShokai
     * @param btnSashitomeOrKojoJokyoShokai btnSashitomeOrKojoJokyoShokai
     */
    @JsonProperty("btnSashitomeOrKojoJokyoShokai")
    public void setBtnSashitomeOrKojoJokyoShokai(Button btnSashitomeOrKojoJokyoShokai) {
        this.btnSashitomeOrKojoJokyoShokai = btnSashitomeOrKojoJokyoShokai;
    }

    /*
     * getdgSashitomeKojoIchiran
     * @return dgSashitomeKojoIchiran
     */
    @JsonProperty("dgSashitomeKojoIchiran")
    public DataGrid<dgSashitomeKojoIchiran_Row> getDgSashitomeKojoIchiran() {
        return dgSashitomeKojoIchiran;
    }

    /*
     * setdgSashitomeKojoIchiran
     * @param dgSashitomeKojoIchiran dgSashitomeKojoIchiran
     */
    @JsonProperty("dgSashitomeKojoIchiran")
    public void setDgSashitomeKojoIchiran(DataGrid<dgSashitomeKojoIchiran_Row> dgSashitomeKojoIchiran) {
        this.dgSashitomeKojoIchiran = dgSashitomeKojoIchiran;
    }

    /*
     * getShokanJoho
     * @return ShokanJoho
     */
    @JsonProperty("ShokanJoho")
    public ShokanJohoDiv getShokanJoho() {
        return ShokanJoho;
    }

    /*
     * setShokanJoho
     * @param ShokanJoho ShokanJoho
     */
    @JsonProperty("ShokanJoho")
    public void setShokanJoho(ShokanJohoDiv ShokanJoho) {
        this.ShokanJoho = ShokanJoho;
    }

    /*
     * getIchijiSashitome1GoKakutei
     * @return IchijiSashitome1GoKakutei
     */
    @JsonProperty("IchijiSashitome1GoKakutei")
    public Button getIchijiSashitome1GoKakutei() {
        return IchijiSashitome1GoKakutei;
    }

    /*
     * setIchijiSashitome1GoKakutei
     * @param IchijiSashitome1GoKakutei IchijiSashitome1GoKakutei
     */
    @JsonProperty("IchijiSashitome1GoKakutei")
    public void setIchijiSashitome1GoKakutei(Button IchijiSashitome1GoKakutei) {
        this.IchijiSashitome1GoKakutei = IchijiSashitome1GoKakutei;
    }

    /*
     * getIchijiSashitome1GoTorikeshi
     * @return IchijiSashitome1GoTorikeshi
     */
    @JsonProperty("IchijiSashitome1GoTorikeshi")
    public Button getIchijiSashitome1GoTorikeshi() {
        return IchijiSashitome1GoTorikeshi;
    }

    /*
     * setIchijiSashitome1GoTorikeshi
     * @param IchijiSashitome1GoTorikeshi IchijiSashitome1GoTorikeshi
     */
    @JsonProperty("IchijiSashitome1GoTorikeshi")
    public void setIchijiSashitome1GoTorikeshi(Button IchijiSashitome1GoTorikeshi) {
        this.IchijiSashitome1GoTorikeshi = IchijiSashitome1GoTorikeshi;
    }

    /*
     * getkey_ShiharaiHohoHenkoKanri
     * @return key_ShiharaiHohoHenkoKanri
     */
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    public RString getKey_ShiharaiHohoHenkoKanri() {
        return key_ShiharaiHohoHenkoKanri;
    }

    /*
     * setkey_ShiharaiHohoHenkoKanri
     * @param key_ShiharaiHohoHenkoKanri key_ShiharaiHohoHenkoKanri
     */
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    public void setKey_ShiharaiHohoHenkoKanri(RString key_ShiharaiHohoHenkoKanri) {
        this.key_ShiharaiHohoHenkoKanri = key_ShiharaiHohoHenkoKanri;
    }

    /*
     * getkey_HihokenshaNo
     * @return key_HihokenshaNo
     */
    @JsonProperty("key_HihokenshaNo")
    public RString getKey_HihokenshaNo() {
        return key_HihokenshaNo;
    }

    /*
     * setkey_HihokenshaNo
     * @param key_HihokenshaNo key_HihokenshaNo
     */
    @JsonProperty("key_HihokenshaNo")
    public void setKey_HihokenshaNo(RString key_HihokenshaNo) {
        this.key_HihokenshaNo = key_HihokenshaNo;
    }

    /*
     * getkey_MaxRirekiNo
     * @return key_MaxRirekiNo
     */
    @JsonProperty("key_MaxRirekiNo")
    public RString getKey_MaxRirekiNo() {
        return key_MaxRirekiNo;
    }

    /*
     * setkey_MaxRirekiNo
     * @param key_MaxRirekiNo key_MaxRirekiNo
     */
    @JsonProperty("key_MaxRirekiNo")
    public void setKey_MaxRirekiNo(RString key_MaxRirekiNo) {
        this.key_MaxRirekiNo = key_MaxRirekiNo;
    }

    /*
     * getkey_Button
     * @return key_Button
     */
    @JsonProperty("key_Button")
    public RString getKey_Button() {
        return key_Button;
    }

    /*
     * setkey_Button
     * @param key_Button key_Button
     */
    @JsonProperty("key_Button")
    public void setKey_Button(RString key_Button) {
        this.key_Button = key_Button;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getkanriKubun
     * @return kanriKubun
     */
    @JsonProperty("kanriKubun")
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /*
     * setkanriKubun
     * @param kanriKubun kanriKubun
     */
    @JsonProperty("kanriKubun")
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /*
     * gettainoHanteiKubun
     * @return tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public RString getTainoHanteiKubun() {
        return tainoHanteiKubun;
    }

    /*
     * settainoHanteiKubun
     * @param tainoHanteiKubun tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public void setTainoHanteiKubun(RString tainoHanteiKubun) {
        this.tainoHanteiKubun = tainoHanteiKubun;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * gettainoHanteiKekka
     * @return tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public RString getTainoHanteiKekka() {
        return tainoHanteiKekka;
    }

    /*
     * settainoHanteiKekka
     * @param tainoHanteiKekka tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public void setTainoHanteiKekka(RString tainoHanteiKekka) {
        this.tainoHanteiKekka = tainoHanteiKekka;
    }

    /*
     * getPTN
     * @return PTN
     */
    @JsonProperty("PTN")
    public RString getPTN() {
        return PTN;
    }

    /*
     * setPTN
     * @param PTN PTN
     */
    @JsonProperty("PTN")
    public void setPTN(RString PTN) {
        this.PTN = PTN;
    }

    /*
     * getbutton_Name
     * @return button_Name
     */
    @JsonProperty("button_Name")
    public RString getButton_Name() {
        return button_Name;
    }

    /*
     * setbutton_Name
     * @param button_Name button_Name
     */
    @JsonProperty("button_Name")
    public void setButton_Name(RString button_Name) {
        this.button_Name = button_Name;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShokanJoho() {
        return this.getShokanJoho().getLblShokanJoho();
    }

    @JsonIgnore
    public void  setLblShokanJoho(Label lblShokanJoho) {
        this.getShokanJoho().setLblShokanJoho(lblShokanJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagakuKingakuGokei() {
        return this.getShokanJoho().getTxtSagakuKingakuGokei();
    }

    @JsonIgnore
    public void  setTxtSagakuKingakuGokei(TextBoxNum txtSagakuKingakuGokei) {
        this.getShokanJoho().setTxtSagakuKingakuGokei(txtSagakuKingakuGokei);
    }

    @JsonIgnore
    public DataGrid<dgShokanJoho_Row> getDgShokanJoho() {
        return this.getShokanJoho().getDgShokanJoho();
    }

    @JsonIgnore
    public void  setDgShokanJoho(DataGrid<dgShokanJoho_Row> dgShokanJoho) {
        this.getShokanJoho().setDgShokanJoho(dgShokanJoho);
    }

    @JsonIgnore
    public SashitomeKojoJokyoDiv getSashitomeKojoJokyo() {
        return this.getShokanJoho().getSashitomeKojoJokyo();
    }

    @JsonIgnore
    public void  setSashitomeKojoJokyo(SashitomeKojoJokyoDiv SashitomeKojoJokyo) {
        this.getShokanJoho().setSashitomeKojoJokyo(SashitomeKojoJokyo);
    }

    @JsonIgnore
    public TextBox getTxtSashitomeTorokuKubun() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtSashitomeTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuKubun(TextBox txtSashitomeTorokuKubun) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtSashitomeTorokuKubun(txtSashitomeTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeTorokuYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtSashitomeTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuYMD(TextBoxFlexibleDate txtSashitomeTorokuYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtSashitomeTorokuYMD(txtSashitomeTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeTorokuTsuchiHakkoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtSashitomeTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtSashitomeTorokuTsuchiHakkoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtSashitomeTorokuTsuchiHakkoYMD(txtSashitomeTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeNofuKigenYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtSashitomeNofuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeNofuKigenYMD(TextBoxFlexibleDate txtSashitomeNofuKigenYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtSashitomeNofuKigenYMD(txtSashitomeNofuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSashitomeKaijoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtSashitomeKaijoYMD();
    }

    @JsonIgnore
    public void  setTxtSashitomeKaijoYMD(TextBoxFlexibleDate txtSashitomeKaijoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtSashitomeKaijoYMD(txtSashitomeKaijoYMD);
    }

    @JsonIgnore
    public TextBox getTxtKojoTorokuKubun() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtKojoTorokuKubun();
    }

    @JsonIgnore
    public void  setTxtKojoTorokuKubun(TextBox txtKojoTorokuKubun) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtKojoTorokuKubun(txtKojoTorokuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKojoKetteiYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtKojoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKojoKetteiYMD(TextBoxFlexibleDate txtKojoKetteiYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtKojoKetteiYMD(txtKojoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKojoTorokuTsuchiHakkoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtKojoTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtKojoTorokuTsuchiHakkoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtKojoTorokuTsuchiHakkoYMD(txtKojoTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHokenshoTeishutsuKigenYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getTxtHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtHokenshoTeishutsuKigenYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().setTxtHokenshoTeishutsuKigenYMD(txtHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public DropDownList getDdlTorokuKojoNo() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getDdlTorokuKojoNo();
    }

    @JsonIgnore
    public void  setDdlTorokuKojoNo(DropDownList ddlTorokuKojoNo) {
        this.getShokanJoho().getSashitomeKojoJokyo().setDdlTorokuKojoNo(ddlTorokuKojoNo);
    }

    @JsonIgnore
    public SashitomeTorokuDiv getSashitomeToroku() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku();
    }

    @JsonIgnore
    public void  setSashitomeToroku(SashitomeTorokuDiv SashitomeToroku) {
        this.getShokanJoho().getSashitomeKojoJokyo().setSashitomeToroku(SashitomeToroku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeTorokuYMD(txtShokaiSashitomeTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeNofuKigenYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeNofuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeNofuKigenYMD(TextBoxFlexibleDate txtShokaiSashitomeNofuKigenYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeNofuKigenYMD(txtShokaiSashitomeNofuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeTorokuTsuchiHakkoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().getTxtShokaiSashitomeTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiSashitomeTorokuTsuchiHakkoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getSashitomeToroku().setTxtShokaiSashitomeTorokuTsuchiHakkoYMD(txtShokaiSashitomeTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public SasitomeKaijoDiv getSasitomeKaijo() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSasitomeKaijo();
    }

    @JsonIgnore
    public void  setSasitomeKaijo(SasitomeKaijoDiv SasitomeKaijo) {
        this.getShokanJoho().getSashitomeKojoJokyo().setSasitomeKaijo(SasitomeKaijo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiSashitomeKaijoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getSasitomeKaijo().getTxtShokaiSashitomeKaijoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiSashitomeKaijoYMD(TextBoxFlexibleDate txtShokaiSashitomeKaijoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getSasitomeKaijo().setTxtShokaiSashitomeKaijoYMD(txtShokaiSashitomeKaijoYMD);
    }

    @JsonIgnore
    public KojoTorokuDiv getKojoToroku() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku();
    }

    @JsonIgnore
    public void  setKojoToroku(KojoTorokuDiv KojoToroku) {
        this.getShokanJoho().getSashitomeKojoJokyo().setKojoToroku(KojoToroku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoKetteiYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoKetteiYMD(TextBoxFlexibleDate txtShokaiKojoKetteiYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoKetteiYMD(txtShokaiKojoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiHokenshoTeishutsuKigenYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtShokaiHokenshoTeishutsuKigenYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiHokenshoTeishutsuKigenYMD(txtShokaiHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiKojoTorokuTsuchiHakkoYMD() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoTorokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoTorokuTsuchiHakkoYMD(TextBoxFlexibleDate txtShokaiKojoTorokuTsuchiHakkoYMD) {
        this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoTorokuTsuchiHakkoYMD(txtShokaiKojoTorokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtShokaiKojoNo() {
        return this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().getTxtShokaiKojoNo();
    }

    @JsonIgnore
    public void  setTxtShokaiKojoNo(TextBox txtShokaiKojoNo) {
        this.getShokanJoho().getSashitomeKojoJokyo().getKojoToroku().setTxtShokaiKojoNo(txtShokaiKojoNo);
    }

    @JsonIgnore
    public TainoJokyoDiv getTainoJokyo() {
        return this.getShokanJoho().getTainoJokyo();
    }

    @JsonIgnore
    public void  setTainoJokyo(TainoJokyoDiv TainoJokyo) {
        this.getShokanJoho().setTainoJokyo(TainoJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getShokanJoho().getTainoJokyo().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void  setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getShokanJoho().getTainoJokyo().setBtnTainoJokyo(btnTainoJokyo);
    }

    @JsonIgnore
    public Button getBtnSashitomeOrKojoJokyoShokaiClose() {
        return this.getShokanJoho().getBtnSashitomeOrKojoJokyoShokaiClose();
    }

    @JsonIgnore
    public void  setBtnSashitomeOrKojoJokyoShokaiClose(Button btnSashitomeOrKojoJokyoShokaiClose) {
        this.getShokanJoho().setBtnSashitomeOrKojoJokyoShokaiClose(btnSashitomeOrKojoJokyoShokaiClose);
    }

    @JsonIgnore
    public Button getBtnSashitomeOrKojoTorokuKakutei() {
        return this.getShokanJoho().getBtnSashitomeOrKojoTorokuKakutei();
    }

    @JsonIgnore
    public void  setBtnSashitomeOrKojoTorokuKakutei(Button btnSashitomeOrKojoTorokuKakutei) {
        this.getShokanJoho().setBtnSashitomeOrKojoTorokuKakutei(btnSashitomeOrKojoTorokuKakutei);
    }

    @JsonIgnore
    public Button getBtnSashitomeOrKojoTorokuTorikeshi() {
        return this.getShokanJoho().getBtnSashitomeOrKojoTorokuTorikeshi();
    }

    @JsonIgnore
    public void  setBtnSashitomeOrKojoTorokuTorikeshi(Button btnSashitomeOrKojoTorokuTorikeshi) {
        this.getShokanJoho().setBtnSashitomeOrKojoTorokuTorikeshi(btnSashitomeOrKojoTorokuTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
