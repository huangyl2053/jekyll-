package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go;
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
 * IchijiSashitome2Go のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiSashitome2GoDiv extends Panel implements IIchijiSashitome2GoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-10_12-10-23">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TorokuJokyo")
    private TorokuJokyoDiv TorokuJokyo;
    @JsonProperty("linTorokuTorokuJokyo")
    private HorizontalLine linTorokuTorokuJokyo;
    @JsonProperty("txtNigoYokokushaTorokuYokokuTorokubi")
    private TextBoxDate txtNigoYokokushaTorokuYokokuTorokubi;
    @JsonProperty("txtBemmeishoTeishutsuKigenYMD")
    private TextBoxDate txtBemmeishoTeishutsuKigenYMD;
    @JsonProperty("txtYokokuTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtYokokuTsuchiHakkoYMD;
    @JsonProperty("txtNigoBenmeishoJuriBenmeishoUketsukebi")
    private TextBoxDate txtNigoBenmeishoJuriBenmeishoUketsukebi;
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiRiyu")
    private DropDownList ddlNigoBenmeishoJuriBenmeiRiyu;
    @JsonProperty("txtBemmeiNaiyoKetteiYMD")
    private TextBoxDate txtBemmeiNaiyoKetteiYMD;
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiShinsakekka")
    private DropDownList ddlNigoBenmeishoJuriBenmeiShinsakekka;
    @JsonProperty("txtSashitomeKetteiYMD")
    private TextBoxDate txtSashitomeKetteiYMD;
    @JsonProperty("txtHokenshaTeishutsuKigenYMD")
    private TextBoxDate txtHokenshaTeishutsuKigenYMD;
    @JsonProperty("txtSashitomeTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtSashitomeTsuchiHakkoYMD;
    @JsonProperty("txtIraiUketsukeYMD")
    private TextBoxDate txtIraiUketsukeYMD;
    @JsonProperty("ddlIraiRiyu")
    private DropDownList ddlIraiRiyu;
    @JsonProperty("txtNigoYokokushaTorokuIraiJuribi")
    private TextBoxDate txtNigoYokokushaTorokuIraiJuribi;
    @JsonProperty("txtIraiYMD")
    private TextBoxDate txtIraiYMD;
    @JsonProperty("txtIraiNaiyoKetteiYMD")
    private TextBoxDate txtIraiNaiyoKetteiYMD;
    @JsonProperty("ddlIraiShinsaKekka")
    private DropDownList ddlIraiShinsaKekka;
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
     * getlinTorokuTorokuJokyo
     * @return linTorokuTorokuJokyo
     */
    @JsonProperty("linTorokuTorokuJokyo")
    public HorizontalLine getLinTorokuTorokuJokyo() {
        return linTorokuTorokuJokyo;
    }

    /*
     * setlinTorokuTorokuJokyo
     * @param linTorokuTorokuJokyo linTorokuTorokuJokyo
     */
    @JsonProperty("linTorokuTorokuJokyo")
    public void setLinTorokuTorokuJokyo(HorizontalLine linTorokuTorokuJokyo) {
        this.linTorokuTorokuJokyo = linTorokuTorokuJokyo;
    }

    /*
     * gettxtNigoYokokushaTorokuYokokuTorokubi
     * @return txtNigoYokokushaTorokuYokokuTorokubi
     */
    @JsonProperty("txtNigoYokokushaTorokuYokokuTorokubi")
    public TextBoxDate getTxtNigoYokokushaTorokuYokokuTorokubi() {
        return txtNigoYokokushaTorokuYokokuTorokubi;
    }

    /*
     * settxtNigoYokokushaTorokuYokokuTorokubi
     * @param txtNigoYokokushaTorokuYokokuTorokubi txtNigoYokokushaTorokuYokokuTorokubi
     */
    @JsonProperty("txtNigoYokokushaTorokuYokokuTorokubi")
    public void setTxtNigoYokokushaTorokuYokokuTorokubi(TextBoxDate txtNigoYokokushaTorokuYokokuTorokubi) {
        this.txtNigoYokokushaTorokuYokokuTorokubi = txtNigoYokokushaTorokuYokokuTorokubi;
    }

    /*
     * gettxtBemmeishoTeishutsuKigenYMD
     * @return txtBemmeishoTeishutsuKigenYMD
     */
    @JsonProperty("txtBemmeishoTeishutsuKigenYMD")
    public TextBoxDate getTxtBemmeishoTeishutsuKigenYMD() {
        return txtBemmeishoTeishutsuKigenYMD;
    }

    /*
     * settxtBemmeishoTeishutsuKigenYMD
     * @param txtBemmeishoTeishutsuKigenYMD txtBemmeishoTeishutsuKigenYMD
     */
    @JsonProperty("txtBemmeishoTeishutsuKigenYMD")
    public void setTxtBemmeishoTeishutsuKigenYMD(TextBoxDate txtBemmeishoTeishutsuKigenYMD) {
        this.txtBemmeishoTeishutsuKigenYMD = txtBemmeishoTeishutsuKigenYMD;
    }

    /*
     * gettxtYokokuTsuchiHakkoYMD
     * @return txtYokokuTsuchiHakkoYMD
     */
    @JsonProperty("txtYokokuTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtYokokuTsuchiHakkoYMD() {
        return txtYokokuTsuchiHakkoYMD;
    }

    /*
     * settxtYokokuTsuchiHakkoYMD
     * @param txtYokokuTsuchiHakkoYMD txtYokokuTsuchiHakkoYMD
     */
    @JsonProperty("txtYokokuTsuchiHakkoYMD")
    public void setTxtYokokuTsuchiHakkoYMD(TextBoxFlexibleDate txtYokokuTsuchiHakkoYMD) {
        this.txtYokokuTsuchiHakkoYMD = txtYokokuTsuchiHakkoYMD;
    }

    /*
     * gettxtNigoBenmeishoJuriBenmeishoUketsukebi
     * @return txtNigoBenmeishoJuriBenmeishoUketsukebi
     */
    @JsonProperty("txtNigoBenmeishoJuriBenmeishoUketsukebi")
    public TextBoxDate getTxtNigoBenmeishoJuriBenmeishoUketsukebi() {
        return txtNigoBenmeishoJuriBenmeishoUketsukebi;
    }

    /*
     * settxtNigoBenmeishoJuriBenmeishoUketsukebi
     * @param txtNigoBenmeishoJuriBenmeishoUketsukebi txtNigoBenmeishoJuriBenmeishoUketsukebi
     */
    @JsonProperty("txtNigoBenmeishoJuriBenmeishoUketsukebi")
    public void setTxtNigoBenmeishoJuriBenmeishoUketsukebi(TextBoxDate txtNigoBenmeishoJuriBenmeishoUketsukebi) {
        this.txtNigoBenmeishoJuriBenmeishoUketsukebi = txtNigoBenmeishoJuriBenmeishoUketsukebi;
    }

    /*
     * getddlNigoBenmeishoJuriBenmeiRiyu
     * @return ddlNigoBenmeishoJuriBenmeiRiyu
     */
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiRiyu")
    public DropDownList getDdlNigoBenmeishoJuriBenmeiRiyu() {
        return ddlNigoBenmeishoJuriBenmeiRiyu;
    }

    /*
     * setddlNigoBenmeishoJuriBenmeiRiyu
     * @param ddlNigoBenmeishoJuriBenmeiRiyu ddlNigoBenmeishoJuriBenmeiRiyu
     */
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiRiyu")
    public void setDdlNigoBenmeishoJuriBenmeiRiyu(DropDownList ddlNigoBenmeishoJuriBenmeiRiyu) {
        this.ddlNigoBenmeishoJuriBenmeiRiyu = ddlNigoBenmeishoJuriBenmeiRiyu;
    }

    /*
     * gettxtBemmeiNaiyoKetteiYMD
     * @return txtBemmeiNaiyoKetteiYMD
     */
    @JsonProperty("txtBemmeiNaiyoKetteiYMD")
    public TextBoxDate getTxtBemmeiNaiyoKetteiYMD() {
        return txtBemmeiNaiyoKetteiYMD;
    }

    /*
     * settxtBemmeiNaiyoKetteiYMD
     * @param txtBemmeiNaiyoKetteiYMD txtBemmeiNaiyoKetteiYMD
     */
    @JsonProperty("txtBemmeiNaiyoKetteiYMD")
    public void setTxtBemmeiNaiyoKetteiYMD(TextBoxDate txtBemmeiNaiyoKetteiYMD) {
        this.txtBemmeiNaiyoKetteiYMD = txtBemmeiNaiyoKetteiYMD;
    }

    /*
     * getddlNigoBenmeishoJuriBenmeiShinsakekka
     * @return ddlNigoBenmeishoJuriBenmeiShinsakekka
     */
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiShinsakekka")
    public DropDownList getDdlNigoBenmeishoJuriBenmeiShinsakekka() {
        return ddlNigoBenmeishoJuriBenmeiShinsakekka;
    }

    /*
     * setddlNigoBenmeishoJuriBenmeiShinsakekka
     * @param ddlNigoBenmeishoJuriBenmeiShinsakekka ddlNigoBenmeishoJuriBenmeiShinsakekka
     */
    @JsonProperty("ddlNigoBenmeishoJuriBenmeiShinsakekka")
    public void setDdlNigoBenmeishoJuriBenmeiShinsakekka(DropDownList ddlNigoBenmeishoJuriBenmeiShinsakekka) {
        this.ddlNigoBenmeishoJuriBenmeiShinsakekka = ddlNigoBenmeishoJuriBenmeiShinsakekka;
    }

    /*
     * gettxtSashitomeKetteiYMD
     * @return txtSashitomeKetteiYMD
     */
    @JsonProperty("txtSashitomeKetteiYMD")
    public TextBoxDate getTxtSashitomeKetteiYMD() {
        return txtSashitomeKetteiYMD;
    }

    /*
     * settxtSashitomeKetteiYMD
     * @param txtSashitomeKetteiYMD txtSashitomeKetteiYMD
     */
    @JsonProperty("txtSashitomeKetteiYMD")
    public void setTxtSashitomeKetteiYMD(TextBoxDate txtSashitomeKetteiYMD) {
        this.txtSashitomeKetteiYMD = txtSashitomeKetteiYMD;
    }

    /*
     * gettxtHokenshaTeishutsuKigenYMD
     * @return txtHokenshaTeishutsuKigenYMD
     */
    @JsonProperty("txtHokenshaTeishutsuKigenYMD")
    public TextBoxDate getTxtHokenshaTeishutsuKigenYMD() {
        return txtHokenshaTeishutsuKigenYMD;
    }

    /*
     * settxtHokenshaTeishutsuKigenYMD
     * @param txtHokenshaTeishutsuKigenYMD txtHokenshaTeishutsuKigenYMD
     */
    @JsonProperty("txtHokenshaTeishutsuKigenYMD")
    public void setTxtHokenshaTeishutsuKigenYMD(TextBoxDate txtHokenshaTeishutsuKigenYMD) {
        this.txtHokenshaTeishutsuKigenYMD = txtHokenshaTeishutsuKigenYMD;
    }

    /*
     * gettxtSashitomeTsuchiHakkoYMD
     * @return txtSashitomeTsuchiHakkoYMD
     */
    @JsonProperty("txtSashitomeTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtSashitomeTsuchiHakkoYMD() {
        return txtSashitomeTsuchiHakkoYMD;
    }

    /*
     * settxtSashitomeTsuchiHakkoYMD
     * @param txtSashitomeTsuchiHakkoYMD txtSashitomeTsuchiHakkoYMD
     */
    @JsonProperty("txtSashitomeTsuchiHakkoYMD")
    public void setTxtSashitomeTsuchiHakkoYMD(TextBoxFlexibleDate txtSashitomeTsuchiHakkoYMD) {
        this.txtSashitomeTsuchiHakkoYMD = txtSashitomeTsuchiHakkoYMD;
    }

    /*
     * gettxtIraiUketsukeYMD
     * @return txtIraiUketsukeYMD
     */
    @JsonProperty("txtIraiUketsukeYMD")
    public TextBoxDate getTxtIraiUketsukeYMD() {
        return txtIraiUketsukeYMD;
    }

    /*
     * settxtIraiUketsukeYMD
     * @param txtIraiUketsukeYMD txtIraiUketsukeYMD
     */
    @JsonProperty("txtIraiUketsukeYMD")
    public void setTxtIraiUketsukeYMD(TextBoxDate txtIraiUketsukeYMD) {
        this.txtIraiUketsukeYMD = txtIraiUketsukeYMD;
    }

    /*
     * getddlIraiRiyu
     * @return ddlIraiRiyu
     */
    @JsonProperty("ddlIraiRiyu")
    public DropDownList getDdlIraiRiyu() {
        return ddlIraiRiyu;
    }

    /*
     * setddlIraiRiyu
     * @param ddlIraiRiyu ddlIraiRiyu
     */
    @JsonProperty("ddlIraiRiyu")
    public void setDdlIraiRiyu(DropDownList ddlIraiRiyu) {
        this.ddlIraiRiyu = ddlIraiRiyu;
    }

    /*
     * gettxtNigoYokokushaTorokuIraiJuribi
     * @return txtNigoYokokushaTorokuIraiJuribi
     */
    @JsonProperty("txtNigoYokokushaTorokuIraiJuribi")
    public TextBoxDate getTxtNigoYokokushaTorokuIraiJuribi() {
        return txtNigoYokokushaTorokuIraiJuribi;
    }

    /*
     * settxtNigoYokokushaTorokuIraiJuribi
     * @param txtNigoYokokushaTorokuIraiJuribi txtNigoYokokushaTorokuIraiJuribi
     */
    @JsonProperty("txtNigoYokokushaTorokuIraiJuribi")
    public void setTxtNigoYokokushaTorokuIraiJuribi(TextBoxDate txtNigoYokokushaTorokuIraiJuribi) {
        this.txtNigoYokokushaTorokuIraiJuribi = txtNigoYokokushaTorokuIraiJuribi;
    }

    /*
     * gettxtIraiYMD
     * @return txtIraiYMD
     */
    @JsonProperty("txtIraiYMD")
    public TextBoxDate getTxtIraiYMD() {
        return txtIraiYMD;
    }

    /*
     * settxtIraiYMD
     * @param txtIraiYMD txtIraiYMD
     */
    @JsonProperty("txtIraiYMD")
    public void setTxtIraiYMD(TextBoxDate txtIraiYMD) {
        this.txtIraiYMD = txtIraiYMD;
    }

    /*
     * gettxtIraiNaiyoKetteiYMD
     * @return txtIraiNaiyoKetteiYMD
     */
    @JsonProperty("txtIraiNaiyoKetteiYMD")
    public TextBoxDate getTxtIraiNaiyoKetteiYMD() {
        return txtIraiNaiyoKetteiYMD;
    }

    /*
     * settxtIraiNaiyoKetteiYMD
     * @param txtIraiNaiyoKetteiYMD txtIraiNaiyoKetteiYMD
     */
    @JsonProperty("txtIraiNaiyoKetteiYMD")
    public void setTxtIraiNaiyoKetteiYMD(TextBoxDate txtIraiNaiyoKetteiYMD) {
        this.txtIraiNaiyoKetteiYMD = txtIraiNaiyoKetteiYMD;
    }

    /*
     * getddlIraiShinsaKekka
     * @return ddlIraiShinsaKekka
     */
    @JsonProperty("ddlIraiShinsaKekka")
    public DropDownList getDdlIraiShinsaKekka() {
        return ddlIraiShinsaKekka;
    }

    /*
     * setddlIraiShinsaKekka
     * @param ddlIraiShinsaKekka ddlIraiShinsaKekka
     */
    @JsonProperty("ddlIraiShinsaKekka")
    public void setDdlIraiShinsaKekka(DropDownList ddlIraiShinsaKekka) {
        this.ddlIraiShinsaKekka = ddlIraiShinsaKekka;
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
    public TextBoxDate getTxtTekiyoKaishi() {
        return this.getTorokuJokyo().getTxtTekiyoKaishi();
    }

    @JsonIgnore
    public void  setTxtTekiyoKaishi(TextBoxDate txtTekiyoKaishi) {
        this.getTorokuJokyo().setTxtTekiyoKaishi(txtTekiyoKaishi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoShuryo() {
        return this.getTorokuJokyo().getTxtTekiyoShuryo();
    }

    @JsonIgnore
    public void  setTxtTekiyoShuryo(TextBoxDate txtTekiyoShuryo) {
        this.getTorokuJokyo().setTxtTekiyoShuryo(txtTekiyoShuryo);
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
