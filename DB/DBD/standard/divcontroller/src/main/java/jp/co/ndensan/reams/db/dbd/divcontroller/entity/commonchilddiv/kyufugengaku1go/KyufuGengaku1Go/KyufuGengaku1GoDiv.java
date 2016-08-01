package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go;
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
 * KyufuGengaku1Go のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuGengaku1GoDiv extends Panel implements IKyufuGengaku1GoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuJokyo")
    private TextBox txtTorokuJokyo;
    @JsonProperty("txtKyufugakuGengakuKikan")
    private TextBoxNum txtKyufugakuGengakuKikan;
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    private TextBoxFlexibleDate txtGengakuTekiyoKikanKaishiYMD;
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    private TextBoxFlexibleDate txtGengakuTekiyoKikanShuryoYMD;
    @JsonProperty("txtChoshukenShometsuKikan")
    private TextBoxNum txtChoshukenShometsuKikan;
    @JsonProperty("txtNofuzumiKikan")
    private TextBoxNum txtNofuzumiKikan;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("GengakuTorokuOrMenjoShinsei")
    private GengakuTorokuOrMenjoShinseiDiv GengakuTorokuOrMenjoShinsei;
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
     * gettxtTorokuJokyo
     * @return txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public TextBox getTxtTorokuJokyo() {
        return txtTorokuJokyo;
    }

    /*
     * settxtTorokuJokyo
     * @param txtTorokuJokyo txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public void setTxtTorokuJokyo(TextBox txtTorokuJokyo) {
        this.txtTorokuJokyo = txtTorokuJokyo;
    }

    /*
     * gettxtKyufugakuGengakuKikan
     * @return txtKyufugakuGengakuKikan
     */
    @JsonProperty("txtKyufugakuGengakuKikan")
    public TextBoxNum getTxtKyufugakuGengakuKikan() {
        return txtKyufugakuGengakuKikan;
    }

    /*
     * settxtKyufugakuGengakuKikan
     * @param txtKyufugakuGengakuKikan txtKyufugakuGengakuKikan
     */
    @JsonProperty("txtKyufugakuGengakuKikan")
    public void setTxtKyufugakuGengakuKikan(TextBoxNum txtKyufugakuGengakuKikan) {
        this.txtKyufugakuGengakuKikan = txtKyufugakuGengakuKikan;
    }

    /*
     * gettxtGengakuTekiyoKikanKaishiYMD
     * @return txtGengakuTekiyoKikanKaishiYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanKaishiYMD() {
        return txtGengakuTekiyoKikanKaishiYMD;
    }

    /*
     * settxtGengakuTekiyoKikanKaishiYMD
     * @param txtGengakuTekiyoKikanKaishiYMD txtGengakuTekiyoKikanKaishiYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    public void setTxtGengakuTekiyoKikanKaishiYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanKaishiYMD) {
        this.txtGengakuTekiyoKikanKaishiYMD = txtGengakuTekiyoKikanKaishiYMD;
    }

    /*
     * gettxtGengakuTekiyoKikanShuryoYMD
     * @return txtGengakuTekiyoKikanShuryoYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanShuryoYMD() {
        return txtGengakuTekiyoKikanShuryoYMD;
    }

    /*
     * settxtGengakuTekiyoKikanShuryoYMD
     * @param txtGengakuTekiyoKikanShuryoYMD txtGengakuTekiyoKikanShuryoYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    public void setTxtGengakuTekiyoKikanShuryoYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanShuryoYMD) {
        this.txtGengakuTekiyoKikanShuryoYMD = txtGengakuTekiyoKikanShuryoYMD;
    }

    /*
     * gettxtChoshukenShometsuKikan
     * @return txtChoshukenShometsuKikan
     */
    @JsonProperty("txtChoshukenShometsuKikan")
    public TextBoxNum getTxtChoshukenShometsuKikan() {
        return txtChoshukenShometsuKikan;
    }

    /*
     * settxtChoshukenShometsuKikan
     * @param txtChoshukenShometsuKikan txtChoshukenShometsuKikan
     */
    @JsonProperty("txtChoshukenShometsuKikan")
    public void setTxtChoshukenShometsuKikan(TextBoxNum txtChoshukenShometsuKikan) {
        this.txtChoshukenShometsuKikan = txtChoshukenShometsuKikan;
    }

    /*
     * gettxtNofuzumiKikan
     * @return txtNofuzumiKikan
     */
    @JsonProperty("txtNofuzumiKikan")
    public TextBoxNum getTxtNofuzumiKikan() {
        return txtNofuzumiKikan;
    }

    /*
     * settxtNofuzumiKikan
     * @param txtNofuzumiKikan txtNofuzumiKikan
     */
    @JsonProperty("txtNofuzumiKikan")
    public void setTxtNofuzumiKikan(TextBoxNum txtNofuzumiKikan) {
        this.txtNofuzumiKikan = txtNofuzumiKikan;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getGengakuTorokuOrMenjoShinsei
     * @return GengakuTorokuOrMenjoShinsei
     */
    @JsonProperty("GengakuTorokuOrMenjoShinsei")
    public GengakuTorokuOrMenjoShinseiDiv getGengakuTorokuOrMenjoShinsei() {
        return GengakuTorokuOrMenjoShinsei;
    }

    /*
     * setGengakuTorokuOrMenjoShinsei
     * @param GengakuTorokuOrMenjoShinsei GengakuTorokuOrMenjoShinsei
     */
    @JsonProperty("GengakuTorokuOrMenjoShinsei")
    public void setGengakuTorokuOrMenjoShinsei(GengakuTorokuOrMenjoShinseiDiv GengakuTorokuOrMenjoShinsei) {
        this.GengakuTorokuOrMenjoShinsei = GengakuTorokuOrMenjoShinsei;
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
    public TextBoxFlexibleDate getTxtGengakuKetteiYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtGengakuKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtGengakuKetteiYMD(TextBoxFlexibleDate txtGengakuKetteiYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtGengakuKetteiYMD(txtGengakuKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiKikanKaishiYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtZenkaiKikanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiKikanKaishiYMD(TextBoxFlexibleDate txtZenkaiKikanKaishiYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtZenkaiKikanKaishiYMD(txtZenkaiKikanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiKikanShuryoYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtZenkaiKikanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiKikanShuryoYMD(TextBoxFlexibleDate txtZenkaiKikanShuryoYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtZenkaiKikanShuryoYMD(txtZenkaiKikanShuryoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKyufuGengakuTsuchiHakkoYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtKyufuGengakuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtKyufuGengakuTsuchiHakkoYMD(TextBoxFlexibleDate txtKyufuGengakuTsuchiHakkoYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtKyufuGengakuTsuchiHakkoYMD(txtKyufuGengakuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKikanKaishiYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtKonkaiKikanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtKonkaiKikanKaishiYMD(TextBoxFlexibleDate txtKonkaiKikanKaishiYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtKonkaiKikanKaishiYMD(txtKonkaiKikanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKikanShuryoYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtKonkaiKikanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtKonkaiKikanShuryoYMD(TextBoxFlexibleDate txtKonkaiKikanShuryoYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtKonkaiKikanShuryoYMD(txtKonkaiKikanShuryoYMD);
    }

    @JsonIgnore
    public DropDownList getDdlMenjoShinseiJokyo() {
        return this.getGengakuTorokuOrMenjoShinsei().getDdlMenjoShinseiJokyo();
    }

    @JsonIgnore
    public void  setDdlMenjoShinseiJokyo(DropDownList ddlMenjoShinseiJokyo) {
        this.getGengakuTorokuOrMenjoShinsei().setDdlMenjoShinseiJokyo(ddlMenjoShinseiJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtMenjoShinseiUketsukeYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtMenjoShinseiUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtMenjoShinseiUketsukeYMD(TextBoxFlexibleDate txtMenjoShinseiUketsukeYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtMenjoShinseiUketsukeYMD(txtMenjoShinseiUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtMenjoShinseiYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtMenjoShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtMenjoShinseiYMD(TextBoxFlexibleDate txtMenjoShinseiYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtMenjoShinseiYMD(txtMenjoShinseiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlIMenjoShinseiRiyu() {
        return this.getGengakuTorokuOrMenjoShinsei().getDdlIMenjoShinseiRiyu();
    }

    @JsonIgnore
    public void  setDdlIMenjoShinseiRiyu(DropDownList ddlIMenjoShinseiRiyu) {
        this.getGengakuTorokuOrMenjoShinsei().setDdlIMenjoShinseiRiyu(ddlIMenjoShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtMenjoNaiyoKetteiYMD() {
        return this.getGengakuTorokuOrMenjoShinsei().getTxtMenjoNaiyoKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtMenjoNaiyoKetteiYMD(TextBoxFlexibleDate txtMenjoNaiyoKetteiYMD) {
        this.getGengakuTorokuOrMenjoShinsei().setTxtMenjoNaiyoKetteiYMD(txtMenjoNaiyoKetteiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlMenjoShinseiShinsaKekka() {
        return this.getGengakuTorokuOrMenjoShinsei().getDdlMenjoShinseiShinsaKekka();
    }

    @JsonIgnore
    public void  setDdlMenjoShinseiShinsaKekka(DropDownList ddlMenjoShinseiShinsaKekka) {
        this.getGengakuTorokuOrMenjoShinsei().setDdlMenjoShinseiShinsaKekka(ddlMenjoShinseiShinsaKekka);
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
