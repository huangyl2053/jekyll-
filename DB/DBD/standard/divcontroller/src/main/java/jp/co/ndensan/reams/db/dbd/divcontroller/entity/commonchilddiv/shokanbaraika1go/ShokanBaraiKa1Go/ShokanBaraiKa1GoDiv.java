package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go;
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
 * ShokanBaraiKa1Go のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanBaraiKa1GoDiv extends Panel implements IShokanBaraiKa1GoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TorokuJokyo")
    private TorokuJokyoDiv TorokuJokyo;
    @JsonProperty("linTorokuJokyo")
    private HorizontalLine linTorokuJokyo;
    @JsonProperty("UketsukeKetteibi")
    private UketsukeKetteibiDiv UketsukeKetteibi;
    @JsonProperty("TainoJokyo")
    private TainoJokyoDiv TainoJokyo;
    @JsonProperty("KakuteiTorikeshi")
    private KakuteiTorikeshiDiv KakuteiTorikeshi;
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
    @JsonProperty("shinkiKubun")
    private RString shinkiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTorokuJokyo
     * @return TorokuJokyo
     */
    @JsonProperty("TorokuJokyo")
    public TorokuJokyoDiv getTorokuJokyo() {
        return TorokuJokyo;
    }

    /*
     * setTorokuJokyo
     * @param TorokuJokyo TorokuJokyo
     */
    @JsonProperty("TorokuJokyo")
    public void setTorokuJokyo(TorokuJokyoDiv TorokuJokyo) {
        this.TorokuJokyo = TorokuJokyo;
    }

    /*
     * getlinTorokuJokyo
     * @return linTorokuJokyo
     */
    @JsonProperty("linTorokuJokyo")
    public HorizontalLine getLinTorokuJokyo() {
        return linTorokuJokyo;
    }

    /*
     * setlinTorokuJokyo
     * @param linTorokuJokyo linTorokuJokyo
     */
    @JsonProperty("linTorokuJokyo")
    public void setLinTorokuJokyo(HorizontalLine linTorokuJokyo) {
        this.linTorokuJokyo = linTorokuJokyo;
    }

    /*
     * getUketsukeKetteibi
     * @return UketsukeKetteibi
     */
    @JsonProperty("UketsukeKetteibi")
    public UketsukeKetteibiDiv getUketsukeKetteibi() {
        return UketsukeKetteibi;
    }

    /*
     * setUketsukeKetteibi
     * @param UketsukeKetteibi UketsukeKetteibi
     */
    @JsonProperty("UketsukeKetteibi")
    public void setUketsukeKetteibi(UketsukeKetteibiDiv UketsukeKetteibi) {
        this.UketsukeKetteibi = UketsukeKetteibi;
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
     * getKakuteiTorikeshi
     * @return KakuteiTorikeshi
     */
    @JsonProperty("KakuteiTorikeshi")
    public KakuteiTorikeshiDiv getKakuteiTorikeshi() {
        return KakuteiTorikeshi;
    }

    /*
     * setKakuteiTorikeshi
     * @param KakuteiTorikeshi KakuteiTorikeshi
     */
    @JsonProperty("KakuteiTorikeshi")
    public void setKakuteiTorikeshi(KakuteiTorikeshiDiv KakuteiTorikeshi) {
        this.KakuteiTorikeshi = KakuteiTorikeshi;
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
     * getshinkiKubun
     * @return shinkiKubun
     */
    @JsonProperty("shinkiKubun")
    public RString getShinkiKubun() {
        return shinkiKubun;
    }

    /*
     * setshinkiKubun
     * @param shinkiKubun shinkiKubun
     */
    @JsonProperty("shinkiKubun")
    public void setShinkiKubun(RString shinkiKubun) {
        this.shinkiKubun = shinkiKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTorokuJokyo() {
        return this.getTorokuJokyo().getTxtTorokuJokyo();
    }

    @JsonIgnore
    public void  setTxtTorokuJokyo(TextBox txtTorokuJokyo) {
        this.getTorokuJokyo().setTxtTorokuJokyo(txtTorokuJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoKikanKaishi() {
        return this.getTorokuJokyo().getTxtTekiyoKikanKaishi();
    }

    @JsonIgnore
    public void  setTxtTekiyoKikanKaishi(TextBoxFlexibleDate txtTekiyoKikanKaishi) {
        this.getTorokuJokyo().setTxtTekiyoKikanKaishi(txtTekiyoKikanKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoKikanShuryo() {
        return this.getTorokuJokyo().getTxtTekiyoKikanShuryo();
    }

    @JsonIgnore
    public void  setTxtTekiyoKikanShuryo(TextBoxFlexibleDate txtTekiyoKikanShuryo) {
        this.getTorokuJokyo().setTxtTekiyoKikanShuryo(txtTekiyoKikanShuryo);
    }

    @JsonIgnore
    public DropDownList getDdlShuryoJokyo() {
        return this.getTorokuJokyo().getDdlShuryoJokyo();
    }

    @JsonIgnore
    public void  setDdlShuryoJokyo(DropDownList ddlShuryoJokyo) {
        this.getTorokuJokyo().setDdlShuryoJokyo(ddlShuryoJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIraiJuriYMD() {
        return this.getUketsukeKetteibi().getTxtIraiJuriYMD();
    }

    @JsonIgnore
    public void  setTxtIraiJuriYMD(TextBoxFlexibleDate txtIraiJuriYMD) {
        this.getUketsukeKetteibi().setTxtIraiJuriYMD(txtIraiJuriYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokokuTorokuYMD() {
        return this.getUketsukeKetteibi().getTxtYokokuTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtYokokuTorokuYMD(TextBoxFlexibleDate txtYokokuTorokuYMD) {
        this.getUketsukeKetteibi().setTxtYokokuTorokuYMD(txtYokokuTorokuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBemmeishoTeishutsuKigenYMD() {
        return this.getUketsukeKetteibi().getTxtBemmeishoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtBemmeishoTeishutsuKigenYMD(TextBoxFlexibleDate txtBemmeishoTeishutsuKigenYMD) {
        this.getUketsukeKetteibi().setTxtBemmeishoTeishutsuKigenYMD(txtBemmeishoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYokokuTsuchiHakkoYMD() {
        return this.getUketsukeKetteibi().getTxtYokokuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtYokokuTsuchiHakkoYMD(TextBoxFlexibleDate txtYokokuTsuchiHakkoYMD) {
        this.getUketsukeKetteibi().setTxtYokokuTsuchiHakkoYMD(txtYokokuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBemmeiUketsukeYMD() {
        return this.getUketsukeKetteibi().getTxtBemmeiUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtBemmeiUketsukeYMD(TextBoxFlexibleDate txtBemmeiUketsukeYMD) {
        this.getUketsukeKetteibi().setTxtBemmeiUketsukeYMD(txtBemmeiUketsukeYMD);
    }

    @JsonIgnore
    public DropDownList getDdlBemmeiRiyu() {
        return this.getUketsukeKetteibi().getDdlBemmeiRiyu();
    }

    @JsonIgnore
    public void  setDdlBemmeiRiyu(DropDownList ddlBemmeiRiyu) {
        this.getUketsukeKetteibi().setDdlBemmeiRiyu(ddlBemmeiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBemmeiNaiyoKetteiYMD() {
        return this.getUketsukeKetteibi().getTxtBemmeiNaiyoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtBemmeiNaiyoKetteiYMD(TextBoxFlexibleDate txtBemmeiNaiyoKetteiYMD) {
        this.getUketsukeKetteibi().setTxtBemmeiNaiyoKetteiYMD(txtBemmeiNaiyoKetteiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlBemmeiShinsaKekka() {
        return this.getUketsukeKetteibi().getDdlBemmeiShinsaKekka();
    }

    @JsonIgnore
    public void  setDdlBemmeiShinsaKekka(DropDownList ddlBemmeiShinsaKekka) {
        this.getUketsukeKetteibi().setDdlBemmeiShinsaKekka(ddlBemmeiShinsaKekka);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoKetteiYMD() {
        return this.getUketsukeKetteibi().getTxtHenkoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoKetteiYMD(TextBoxFlexibleDate txtHenkoKetteiYMD) {
        this.getUketsukeKetteibi().setTxtHenkoKetteiYMD(txtHenkoKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHokenshoTeishutsuKigenYMD() {
        return this.getUketsukeKetteibi().getTxtHokenshoTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtHokenshoTeishutsuKigenYMD(TextBoxFlexibleDate txtHokenshoTeishutsuKigenYMD) {
        this.getUketsukeKetteibi().setTxtHokenshoTeishutsuKigenYMD(txtHokenshoTeishutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getUketsukeKetteibi().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoTsuchiHakkoYMD(TextBoxFlexibleDate txtHenkoTsuchiHakkoYMD) {
        this.getUketsukeKetteibi().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiUketsukeYMD() {
        return this.getUketsukeKetteibi().getTxtShinseiUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiUketsukeYMD(TextBoxFlexibleDate txtShinseiUketsukeYMD) {
        this.getUketsukeKetteibi().setTxtShinseiUketsukeYMD(txtShinseiUketsukeYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiRiyu() {
        return this.getUketsukeKetteibi().getDdlShinseiRiyu();
    }

    @JsonIgnore
    public void  setDdlShinseiRiyu(DropDownList ddlShinseiRiyu) {
        this.getUketsukeKetteibi().setDdlShinseiRiyu(ddlShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getUketsukeKetteibi().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getUketsukeKetteibi().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiNaiyoKetteiYMD() {
        return this.getUketsukeKetteibi().getTxtShinseiNaiyoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiNaiyoKetteiYMD(TextBoxFlexibleDate txtShinseiNaiyoKetteiYMD) {
        this.getUketsukeKetteibi().setTxtShinseiNaiyoKetteiYMD(txtShinseiNaiyoKetteiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiShinsaKekka() {
        return this.getUketsukeKetteibi().getDdlShinseiShinsaKekka();
    }

    @JsonIgnore
    public void  setDdlShinseiShinsaKekka(DropDownList ddlShinseiShinsaKekka) {
        this.getUketsukeKetteibi().setDdlShinseiShinsaKekka(ddlShinseiShinsaKekka);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getTainoJokyo().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void  setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getTainoJokyo().setBtnTainoJokyo(btnTainoJokyo);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getKakuteiTorikeshi().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getKakuteiTorikeshi().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getKakuteiTorikeshi().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getKakuteiTorikeshi().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
