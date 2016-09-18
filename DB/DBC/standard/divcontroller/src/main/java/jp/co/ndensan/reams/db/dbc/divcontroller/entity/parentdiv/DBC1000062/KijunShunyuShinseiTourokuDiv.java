package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KijunShunyuShinseiTouroku のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class KijunShunyuShinseiTourokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Ichiran")
    private IchiranDiv Ichiran;
    @JsonProperty("Meisai")
    private MeisaiDiv Meisai;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;
    @JsonProperty("hdnRowId")
    private RString hdnRowId;
    @JsonProperty("hdnRirekiNo")
    private RString hdnRirekiNo;
    @JsonProperty("hdnFlag1")
    private RString hdnFlag1;
    @JsonProperty("hdnFlag2")
    private RString hdnFlag2;
    @JsonProperty("hdnFlag3")
    private RString hdnFlag3;
    @JsonProperty("hdnFlag4")
    private RString hdnFlag4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIchiran
     * @return Ichiran
     */
    @JsonProperty("Ichiran")
    public IchiranDiv getIchiran() {
        return Ichiran;
    }

    /*
     * setIchiran
     * @param Ichiran Ichiran
     */
    @JsonProperty("Ichiran")
    public void setIchiran(IchiranDiv Ichiran) {
        this.Ichiran = Ichiran;
    }

    /*
     * getMeisai
     * @return Meisai
     */
    @JsonProperty("Meisai")
    public MeisaiDiv getMeisai() {
        return Meisai;
    }

    /*
     * setMeisai
     * @param Meisai Meisai
     */
    @JsonProperty("Meisai")
    public void setMeisai(MeisaiDiv Meisai) {
        this.Meisai = Meisai;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    /*
     * gethdnRowId
     * @return hdnRowId
     */
    @JsonProperty("hdnRowId")
    public RString getHdnRowId() {
        return hdnRowId;
    }

    /*
     * sethdnRowId
     * @param hdnRowId hdnRowId
     */
    @JsonProperty("hdnRowId")
    public void setHdnRowId(RString hdnRowId) {
        this.hdnRowId = hdnRowId;
    }

    /*
     * gethdnRirekiNo
     * @return hdnRirekiNo
     */
    @JsonProperty("hdnRirekiNo")
    public RString getHdnRirekiNo() {
        return hdnRirekiNo;
    }

    /*
     * sethdnRirekiNo
     * @param hdnRirekiNo hdnRirekiNo
     */
    @JsonProperty("hdnRirekiNo")
    public void setHdnRirekiNo(RString hdnRirekiNo) {
        this.hdnRirekiNo = hdnRirekiNo;
    }

    /*
     * gethdnFlag1
     * @return hdnFlag1
     */
    @JsonProperty("hdnFlag1")
    public RString getHdnFlag1() {
        return hdnFlag1;
    }

    /*
     * sethdnFlag1
     * @param hdnFlag1 hdnFlag1
     */
    @JsonProperty("hdnFlag1")
    public void setHdnFlag1(RString hdnFlag1) {
        this.hdnFlag1 = hdnFlag1;
    }

    /*
     * gethdnFlag2
     * @return hdnFlag2
     */
    @JsonProperty("hdnFlag2")
    public RString getHdnFlag2() {
        return hdnFlag2;
    }

    /*
     * sethdnFlag2
     * @param hdnFlag2 hdnFlag2
     */
    @JsonProperty("hdnFlag2")
    public void setHdnFlag2(RString hdnFlag2) {
        this.hdnFlag2 = hdnFlag2;
    }

    /*
     * gethdnFlag3
     * @return hdnFlag3
     */
    @JsonProperty("hdnFlag3")
    public RString getHdnFlag3() {
        return hdnFlag3;
    }

    /*
     * sethdnFlag3
     * @param hdnFlag3 hdnFlag3
     */
    @JsonProperty("hdnFlag3")
    public void setHdnFlag3(RString hdnFlag3) {
        this.hdnFlag3 = hdnFlag3;
    }

    /*
     * gethdnFlag4
     * @return hdnFlag4
     */
    @JsonProperty("hdnFlag4")
    public RString getHdnFlag4() {
        return hdnFlag4;
    }

    /*
     * sethdnFlag4
     * @param hdnFlag4 hdnFlag4
     */
    @JsonProperty("hdnFlag4")
    public void setHdnFlag4(RString hdnFlag4) {
        this.hdnFlag4 = hdnFlag4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getIchiran().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getIchiran().setLin1(lin1);
    }

    @JsonIgnore
    public Button getBtnAddIchiran() {
        return this.getIchiran().getBtnAddIchiran();
    }

    @JsonIgnore
    public void setBtnAddIchiran(Button btnAddIchiran) {
        this.getIchiran().setBtnAddIchiran(btnAddIchiran);
    }

    @JsonIgnore
    public DataGrid<dgIchiran_Row> getDgIchiran() {
        return this.getIchiran().getDgIchiran();
    }

    @JsonIgnore
    public void setDgIchiran(DataGrid<dgIchiran_Row> dgIchiran) {
        this.getIchiran().setDgIchiran(dgIchiran);
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getIchiran().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public ButtonDialog getBtnShowShotokuJokyo() {
        return this.getMeisai().getBtnShowShotokuJokyo();
    }

    @JsonIgnore
    public void setBtnShowShotokuJokyo(ButtonDialog btnShowShotokuJokyo) {
        this.getMeisai().setBtnShowShotokuJokyo(btnShowShotokuJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShowZennendo() {
        return this.getMeisai().getBtnShowZennendo();
    }

    @JsonIgnore
    public void setBtnShowZennendo(ButtonDialog btnShowZennendo) {
        this.getMeisai().setBtnShowZennendo(btnShowZennendo);
    }

    @JsonIgnore
    public SetaiJohoDiv getSetaiJoho() {
        return this.getMeisai().getSetaiJoho();
    }

    @JsonIgnore
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.getMeisai().setSetaiJoho(SetaiJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtSetaiCode() {
        return this.getMeisai().getSetaiJoho().getTxtSetaiCode();
    }

    @JsonIgnore
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.getMeisai().getSetaiJoho().setTxtSetaiCode(txtSetaiCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShoriNendo() {
        return this.getMeisai().getSetaiJoho().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxFlexibleDate txtShoriNendo) {
        this.getMeisai().getSetaiJoho().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSetaiinHaakuKijunYMD() {
        return this.getMeisai().getSetaiJoho().getTxtSetaiinHaakuKijunYMD();
    }

    @JsonIgnore
    public void setTxtSetaiinHaakuKijunYMD(TextBoxFlexibleDate txtSetaiinHaakuKijunYMD) {
        this.getMeisai().getSetaiJoho().setTxtSetaiinHaakuKijunYMD(txtSetaiinHaakuKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getMeisai().getSetaiJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getMeisai().getSetaiJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseishoSakuseiYMD() {
        return this.getMeisai().getSetaiJoho().getTxtShinseishoSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseishoSakuseiYMD(TextBoxFlexibleDate txtShinseishoSakuseiYMD) {
        this.getMeisai().getSetaiJoho().setTxtShinseishoSakuseiYMD(txtShinseishoSakuseiYMD);
    }

    @JsonIgnore
    public SetaiJoho2Div getSetaiJoho2() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2();
    }

    @JsonIgnore
    public void setSetaiJoho2(SetaiJoho2Div SetaiJoho2) {
        this.getMeisai().getSetaiJoho().setSetaiJoho2(SetaiJoho2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazei() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getTxtSetaiKazei();
    }

    @JsonIgnore
    public void setTxtSetaiKazei(TextBox txtSetaiKazei) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setTxtSetaiKazei(txtSetaiKazei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStartYM() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getTxtTekiyoStartYM();
    }

    @JsonIgnore
    public void setTxtTekiyoStartYM(TextBoxFlexibleDate txtTekiyoStartYM) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setTxtTekiyoStartYM(txtTekiyoStartYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoEndYM() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getTxtTekiyoEndYM();
    }

    @JsonIgnore
    public void setTxtTekiyoEndYM(TextBoxFlexibleDate txtTekiyoEndYM) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setTxtTekiyoEndYM(txtTekiyoEndYM);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKijunGaku() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getDdlSanteiKijunGaku();
    }

    @JsonIgnore
    public void setDdlSanteiKijunGaku(DropDownList ddlSanteiKijunGaku) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setDdlSanteiKijunGaku(ddlSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiTsuchishoHakkoYMD() {
        return this.getMeisai().getSetaiJoho().getSetaiJoho2().getTxtKetteiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchishoHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchishoHakkoYMD) {
        this.getMeisai().getSetaiJoho().getSetaiJoho2().setTxtKetteiTsuchishoHakkoYMD(txtKetteiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public FuyoKojoDiv getFuyoKojo() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo();
    }

    @JsonIgnore
    public void setFuyoKojo(FuyoKojoDiv FuyoKojo) {
        this.getMeisai().getSetaiJoho().setFuyoKojo(FuyoKojo);
    }

    @JsonIgnore
    public ButtonPanelDiv getButtonPanel() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getButtonPanel();
    }

    @JsonIgnore
    public void setButtonPanel(ButtonPanelDiv ButtonPanel) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().setButtonPanel(ButtonPanel);
    }

    @JsonIgnore
    public Button getBtnSetaiSaiSanshutsu() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getButtonPanel().getBtnSetaiSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnSetaiSaiSanshutsu(Button btnSetaiSaiSanshutsu) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().getButtonPanel().setBtnSetaiSaiSanshutsu(btnSetaiSaiSanshutsu);
    }

    @JsonIgnore
    public Button getBtnKojoSaiSanshutsu() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getButtonPanel().getBtnKojoSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnKojoSaiSanshutsu(Button btnKojoSaiSanshutsu) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().getButtonPanel().setBtnKojoSaiSanshutsu(btnKojoSaiSanshutsu);
    }

    @JsonIgnore
    public Label getLblKojoTaisho() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getLblKojoTaisho();
    }

    @JsonIgnore
    public void setLblKojoTaisho(Label lblKojoTaisho) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().setLblKojoTaisho(lblKojoTaisho);
    }

    @JsonIgnore
    public ZennenKojoTaishoDiv getZennenKojoTaisho() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getZennenKojoTaisho();
    }

    @JsonIgnore
    public void setZennenKojoTaisho(ZennenKojoTaishoDiv ZennenKojoTaisho) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().setZennenKojoTaisho(ZennenKojoTaisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder16() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().getTxtUnder16();
    }

    @JsonIgnore
    public void setTxtUnder16(TextBoxNum txtUnder16) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().setTxtUnder16(txtUnder16);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver16() {
        return this.getMeisai().getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().getTxtOver16();
    }

    @JsonIgnore
    public void setTxtOver16(TextBoxNum txtOver16) {
        this.getMeisai().getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().setTxtOver16(txtOver16);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getMeisai().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getMeisai().setLin2(lin2);
    }

    @JsonIgnore
    public ButtonDialog getBtnAddMeisai() {
        return this.getMeisai().getBtnAddMeisai();
    }

    @JsonIgnore
    public void setBtnAddMeisai(ButtonDialog btnAddMeisai) {
        this.getMeisai().setBtnAddMeisai(btnAddMeisai);
    }

    @JsonIgnore
    public Label getLblTotalShunyu() {
        return this.getMeisai().getLblTotalShunyu();
    }

    @JsonIgnore
    public void setLblTotalShunyu(Label lblTotalShunyu) {
        this.getMeisai().setLblTotalShunyu(lblTotalShunyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalShunyu() {
        return this.getMeisai().getTxtTotalShunyu();
    }

    @JsonIgnore
    public void setTxtTotalShunyu(TextBoxNum txtTotalShunyu) {
        this.getMeisai().setTxtTotalShunyu(txtTotalShunyu);
    }

    @JsonIgnore
    public Button getBtnCalcTotalShunyu() {
        return this.getMeisai().getBtnCalcTotalShunyu();
    }

    @JsonIgnore
    public void setBtnCalcTotalShunyu(Button btnCalcTotalShunyu) {
        this.getMeisai().setBtnCalcTotalShunyu(btnCalcTotalShunyu);
    }

    @JsonIgnore
    public DataGrid<dgMeisai_Row> getDgMeisai() {
        return this.getMeisai().getDgMeisai();
    }

    @JsonIgnore
    public void setDgMeisai(DataGrid<dgMeisai_Row> dgMeisai) {
        this.getMeisai().setDgMeisai(dgMeisai);
    }

    @JsonIgnore
    public Button getBtnMeisaiKautei() {
        return this.getMeisai().getBtnMeisaiKautei();
    }

    @JsonIgnore
    public void setBtnMeisaiKautei(Button btnMeisaiKautei) {
        this.getMeisai().setBtnMeisaiKautei(btnMeisaiKautei);
    }

    @JsonIgnore
    public Button getBtnMeisaiCancel() {
        return this.getMeisai().getBtnMeisaiCancel();
    }

    @JsonIgnore
    public void setBtnMeisaiCancel(Button btnMeisaiCancel) {
        this.getMeisai().setBtnMeisaiCancel(btnMeisaiCancel);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getMeisai().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getMeisai().setLin3(lin3);
    }

    @JsonIgnore
    public Label getLblDescription() {
        return this.getMeisai().getLblDescription();
    }

    @JsonIgnore
    public void setLblDescription(Label lblDescription) {
        this.getMeisai().setLblDescription(lblDescription);
    }

    // </editor-fold>
}
