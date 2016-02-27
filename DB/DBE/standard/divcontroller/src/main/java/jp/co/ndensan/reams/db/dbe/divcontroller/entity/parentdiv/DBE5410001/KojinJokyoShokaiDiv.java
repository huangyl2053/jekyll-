package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoninteishikakuinfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoninteishikakuinfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KojinJokyoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KojinJokyoShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnShinsakaiJoho")
    private ButtonDialog btnShinsakaiJoho;
    @JsonProperty("btnShujiiIkenshoSakuseiIraiShokai")
    private Button btnShujiiIkenshoSakuseiIraiShokai;
    @JsonProperty("btnNinteiChosaIraiShokai")
    private Button btnNinteiChosaIraiShokai;
    @JsonProperty("tblKanryoJisseki")
    private tblKanryoJissekiDiv tblKanryoJisseki;
    @JsonProperty("KojinShinchokuShosai")
    private KojinShinchokuShosaiDiv KojinShinchokuShosai;
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    private ShujiiIryokikaknAndShujiiInputDiv ShujiiIryokikaknAndShujiiInput;
    @JsonProperty("ChosaItakusakiAndChosainGuide")
    private ChosaItakusakiAndChosainGuideDiv ChosaItakusakiAndChosainGuide;
    @JsonProperty("ccdKaigoNinteiAtenInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenInfo;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("hdnHokenshaCode")
    private RString hdnHokenshaCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnRenrakusaki
     * @return btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public ButtonDialog getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    /*
     * setbtnRenrakusaki
     * @param btnRenrakusaki btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    /*
     * getbtnShichosonRenrakuJiko
     * @return btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return btnShichosonRenrakuJiko;
    }

    /*
     * setbtnShichosonRenrakuJiko
     * @param btnShichosonRenrakuJiko btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public void setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.btnShichosonRenrakuJiko = btnShichosonRenrakuJiko;
    }

    /*
     * getbtnShinsakaiJoho
     * @return btnShinsakaiJoho
     */
    @JsonProperty("btnShinsakaiJoho")
    public ButtonDialog getBtnShinsakaiJoho() {
        return btnShinsakaiJoho;
    }

    /*
     * setbtnShinsakaiJoho
     * @param btnShinsakaiJoho btnShinsakaiJoho
     */
    @JsonProperty("btnShinsakaiJoho")
    public void setBtnShinsakaiJoho(ButtonDialog btnShinsakaiJoho) {
        this.btnShinsakaiJoho = btnShinsakaiJoho;
    }

    /*
     * getbtnShujiiIkenshoSakuseiIraiShokai
     * @return btnShujiiIkenshoSakuseiIraiShokai
     */
    @JsonProperty("btnShujiiIkenshoSakuseiIraiShokai")
    public Button getBtnShujiiIkenshoSakuseiIraiShokai() {
        return btnShujiiIkenshoSakuseiIraiShokai;
    }

    /*
     * setbtnShujiiIkenshoSakuseiIraiShokai
     * @param btnShujiiIkenshoSakuseiIraiShokai btnShujiiIkenshoSakuseiIraiShokai
     */
    @JsonProperty("btnShujiiIkenshoSakuseiIraiShokai")
    public void setBtnShujiiIkenshoSakuseiIraiShokai(Button btnShujiiIkenshoSakuseiIraiShokai) {
        this.btnShujiiIkenshoSakuseiIraiShokai = btnShujiiIkenshoSakuseiIraiShokai;
    }

    /*
     * getbtnNinteiChosaIraiShokai
     * @return btnNinteiChosaIraiShokai
     */
    @JsonProperty("btnNinteiChosaIraiShokai")
    public Button getBtnNinteiChosaIraiShokai() {
        return btnNinteiChosaIraiShokai;
    }

    /*
     * setbtnNinteiChosaIraiShokai
     * @param btnNinteiChosaIraiShokai btnNinteiChosaIraiShokai
     */
    @JsonProperty("btnNinteiChosaIraiShokai")
    public void setBtnNinteiChosaIraiShokai(Button btnNinteiChosaIraiShokai) {
        this.btnNinteiChosaIraiShokai = btnNinteiChosaIraiShokai;
    }

    /*
     * gettblKanryoJisseki
     * @return tblKanryoJisseki
     */
    @JsonProperty("tblKanryoJisseki")
    public tblKanryoJissekiDiv getTblKanryoJisseki() {
        return tblKanryoJisseki;
    }

    /*
     * settblKanryoJisseki
     * @param tblKanryoJisseki tblKanryoJisseki
     */
    @JsonProperty("tblKanryoJisseki")
    public void setTblKanryoJisseki(tblKanryoJissekiDiv tblKanryoJisseki) {
        this.tblKanryoJisseki = tblKanryoJisseki;
    }

    /*
     * getKojinShinchokuShosai
     * @return KojinShinchokuShosai
     */
    @JsonProperty("KojinShinchokuShosai")
    public KojinShinchokuShosaiDiv getKojinShinchokuShosai() {
        return KojinShinchokuShosai;
    }

    /*
     * setKojinShinchokuShosai
     * @param KojinShinchokuShosai KojinShinchokuShosai
     */
    @JsonProperty("KojinShinchokuShosai")
    public void setKojinShinchokuShosai(KojinShinchokuShosaiDiv KojinShinchokuShosai) {
        this.KojinShinchokuShosai = KojinShinchokuShosai;
    }

    /*
     * getShujiiIryokikaknAndShujiiInput
     * @return ShujiiIryokikaknAndShujiiInput
     */
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    public ShujiiIryokikaknAndShujiiInputDiv getShujiiIryokikaknAndShujiiInput() {
        return ShujiiIryokikaknAndShujiiInput;
    }

    /*
     * setShujiiIryokikaknAndShujiiInput
     * @param ShujiiIryokikaknAndShujiiInput ShujiiIryokikaknAndShujiiInput
     */
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    public void setShujiiIryokikaknAndShujiiInput(ShujiiIryokikaknAndShujiiInputDiv ShujiiIryokikaknAndShujiiInput) {
        this.ShujiiIryokikaknAndShujiiInput = ShujiiIryokikaknAndShujiiInput;
    }

    /*
     * getChosaItakusakiAndChosainGuide
     * @return ChosaItakusakiAndChosainGuide
     */
    @JsonProperty("ChosaItakusakiAndChosainGuide")
    public ChosaItakusakiAndChosainGuideDiv getChosaItakusakiAndChosainGuide() {
        return ChosaItakusakiAndChosainGuide;
    }

    /*
     * setChosaItakusakiAndChosainGuide
     * @param ChosaItakusakiAndChosainGuide ChosaItakusakiAndChosainGuide
     */
    @JsonProperty("ChosaItakusakiAndChosainGuide")
    public void setChosaItakusakiAndChosainGuide(ChosaItakusakiAndChosainGuideDiv ChosaItakusakiAndChosainGuide) {
        this.ChosaItakusakiAndChosainGuide = ChosaItakusakiAndChosainGuide;
    }

    /*
     * getccdKaigoNinteiAtenInfo
     * @return ccdKaigoNinteiAtenInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenInfo() {
        return ccdKaigoNinteiAtenInfo;
    }

    /*
     * getccdKaigoNinteiShikakuInfo
     * @return ccdKaigoNinteiShikakuInfo
     */
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdKaigoNinteiShikakuInfo() {
        return ccdKaigoNinteiShikakuInfo;
    }

    /*
     * gethdnHokenshaCode
     * @return hdnHokenshaCode
     */
    @JsonProperty("hdnHokenshaCode")
    public RString getHdnHokenshaCode() {
        return hdnHokenshaCode;
    }

    /*
     * sethdnHokenshaCode
     * @param hdnHokenshaCode hdnHokenshaCode
     */
    @JsonProperty("hdnHokenshaCode")
    public void setHdnHokenshaCode(RString hdnHokenshaCode) {
        this.hdnHokenshaCode = hdnHokenshaCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChosaIrai() {
        return this.getTblKanryoJisseki().getLblChosaIrai();
    }

    @JsonIgnore
    public Label getLblChosahyoNyushu() {
        return this.getTblKanryoJisseki().getLblChosahyoNyushu();
    }

    @JsonIgnore
    public Label getLblIkenshoIrai() {
        return this.getTblKanryoJisseki().getLblIkenshoIrai();
    }

    @JsonIgnore
    public Label getIkenshoNyushu() {
        return this.getTblKanryoJisseki().getIkenshoNyushu();
    }

    @JsonIgnore
    public Label getLblIchijiHantei() {
        return this.getTblKanryoJisseki().getLblIchijiHantei();
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getTblKanryoJisseki().getLblMasking();
    }

    @JsonIgnore
    public Label getLblShinsakaiToroku() {
        return this.getTblKanryoJisseki().getLblShinsakaiToroku();
    }

    @JsonIgnore
    public Label getLblNijiHantei() {
        return this.getTblKanryoJisseki().getLblNijiHantei();
    }

    @JsonIgnore
    public Label getLblKanryoYotei() {
        return this.getTblKanryoJisseki().getLblKanryoYotei();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiYoteiDate() {
        return this.getTblKanryoJisseki().getTxtChosaIraiYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosahyoNyushuYoteiDate() {
        return this.getTblKanryoJisseki().getTxtChosahyoNyushuYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraiYoteiDate() {
        return this.getTblKanryoJisseki().getTxtIkenshoIraiYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoNyushuYoteiDate() {
        return this.getTblKanryoJisseki().getTxtIkenshoNyushuYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYoteiDate() {
        return this.getTblKanryoJisseki().getTxtIchijiHanteiYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingYoteiDate() {
        return this.getTblKanryoJisseki().getTxtMaskingYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiTorokuYoteiDate() {
        return this.getTblKanryoJisseki().getTxtShinsakaiTorokuYoteiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteiYoteiDate() {
        return this.getTblKanryoJisseki().getTxtNijiHanteiYoteiDate();
    }

    @JsonIgnore
    public Label getLblKanryoJisseki() {
        return this.getTblKanryoJisseki().getLblKanryoJisseki();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiJissekiDate() {
        return this.getTblKanryoJisseki().getTxtChosaIraiJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosahyoNyushuJissekiDate() {
        return this.getTblKanryoJisseki().getTxtChosahyoNyushuJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraiJissekiDate() {
        return this.getTblKanryoJisseki().getTxtIkenshoIraiJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoNyushuJissekiDate() {
        return this.getTblKanryoJisseki().getTxtIkenshoNyushuJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiJissekiDate() {
        return this.getTblKanryoJisseki().getTxtIchijiHanteiJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingJissekiDate() {
        return this.getTblKanryoJisseki().getTxtMaskingJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiTorokuJissekiDate() {
        return this.getTblKanryoJisseki().getTxtShinsakaiTorokuJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteiJissekiDate() {
        return this.getTblKanryoJisseki().getTxtNijiHanteiJissekiDate();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiShinseiDay() {
        return this.getKojinShinchokuShosai().getTxtNinteiShinseiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiDay(TextBoxDate txtNinteiShinseiDay) {
        this.getKojinShinchokuShosai().setTxtNinteiShinseiDay(txtNinteiShinseiDay);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShinseiji() {
        return this.getKojinShinchokuShosai().getTxtShinseiKubunShinseiji();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.getKojinShinchokuShosai().setTxtShinseiKubunShinseiji(txtShinseiKubunShinseiji);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunHorei() {
        return this.getKojinShinchokuShosai().getTxtShinseiKubunHorei();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.getKojinShinchokuShosai().setTxtShinseiKubunHorei(txtShinseiKubunHorei);
    }

    @JsonIgnore
    public TextBox getTxtNinteiKekka() {
        return this.getKojinShinchokuShosai().getTxtNinteiKekka();
    }

    @JsonIgnore
    public void  setTxtNinteiKekka(TextBox txtNinteiKekka) {
        this.getKojinShinchokuShosai().setTxtNinteiKekka(txtNinteiKekka);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoKikanFrom() {
        return this.getKojinShinchokuShosai().getTxtNinteiYukoKikanFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanFrom(TextBoxDate txtNinteiYukoKikanFrom) {
        this.getKojinShinchokuShosai().setTxtNinteiYukoKikanFrom(txtNinteiYukoKikanFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoKikanTo() {
        return this.getKojinShinchokuShosai().getTxtNinteiYukoKikanTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanTo(TextBoxDate txtNinteiYukoKikanTo) {
        this.getKojinShinchokuShosai().setTxtNinteiYukoKikanTo(txtNinteiYukoKikanTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtNinteiKikanMonth() {
        return this.getKojinShinchokuShosai().getTxtNinteiKikanMonth();
    }

    @JsonIgnore
    public void  setTxtNinteiKikanMonth(TextBoxNum txtNinteiKikanMonth) {
        this.getKojinShinchokuShosai().setTxtNinteiKikanMonth(txtNinteiKikanMonth);
    }

    @JsonIgnore
    public TextBox getTxtShinseiShubetsu() {
        return this.getKojinShinchokuShosai().getTxtShinseiShubetsu();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu(TextBox txtShinseiShubetsu) {
        this.getKojinShinchokuShosai().setTxtShinseiShubetsu(txtShinseiShubetsu);
    }

    @JsonIgnore
    public TextBox getTxtTokuteiShippei() {
        return this.getKojinShinchokuShosai().getTxtTokuteiShippei();
    }

    @JsonIgnore
    public void  setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.getKojinShinchokuShosai().setTxtTokuteiShippei(txtTokuteiShippei);
    }

    @JsonIgnore
    public TextBox getTxtJohoTeikyoDoi() {
        return this.getKojinShinchokuShosai().getTxtJohoTeikyoDoi();
    }

    @JsonIgnore
    public void  setTxtJohoTeikyoDoi(TextBox txtJohoTeikyoDoi) {
        this.getKojinShinchokuShosai().setTxtJohoTeikyoDoi(txtJohoTeikyoDoi);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHantei() {
        return this.getKojinShinchokuShosai().getTxtIchijiHantei();
    }

    @JsonIgnore
    public void  setTxtIchijiHantei(TextBox txtIchijiHantei) {
        this.getKojinShinchokuShosai().setTxtIchijiHantei(txtIchijiHantei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaisaiDay() {
        return this.getKojinShinchokuShosai().getTxtKaisaiDay();
    }

    @JsonIgnore
    public void  setTxtKaisaiDay(TextBoxDate txtKaisaiDay) {
        this.getKojinShinchokuShosai().setTxtKaisaiDay(txtKaisaiDay);
    }

    @JsonIgnore
    public TextBox getTxtShoriKubun() {
        return this.getKojinShinchokuShosai().getTxtShoriKubun();
    }

    @JsonIgnore
    public void  setTxtShoriKubun(TextBox txtShoriKubun) {
        this.getKojinShinchokuShosai().setTxtShoriKubun(txtShoriKubun);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShujiiIryokikaknAndShujiiInput().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getChosaItakusakiAndChosainGuide().getCcdChosaItakusakiAndChosainInput();
    }

    // </editor-fold>
}
