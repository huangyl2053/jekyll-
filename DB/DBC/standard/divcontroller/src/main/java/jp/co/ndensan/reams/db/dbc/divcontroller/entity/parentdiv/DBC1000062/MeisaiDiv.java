package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * Meisai のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class MeisaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShowShotokuJokyo")
    private ButtonDialog btnShowShotokuJokyo;
    @JsonProperty("btnShowZennendo")
    private ButtonDialog btnShowZennendo;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("btnAddMeisai")
    private ButtonDialog btnAddMeisai;
    @JsonProperty("lblTotalShunyu")
    private Label lblTotalShunyu;
    @JsonProperty("txtTotalShunyu")
    private TextBoxNum txtTotalShunyu;
    @JsonProperty("btnCalcTotalShunyu")
    private Button btnCalcTotalShunyu;
    @JsonProperty("dgMeisai")
    private DataGrid<dgMeisai_Row> dgMeisai;
    @JsonProperty("btnMeisaiKautei")
    private Button btnMeisaiKautei;
    @JsonProperty("btnMeisaiCancel")
    private Button btnMeisaiCancel;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("lblDescription")
    private Label lblDescription;
    @JsonProperty("hdnModeAdd")
    private RString hdnModeAdd;
    @JsonProperty("hdnModeReference")
    private RString hdnModeReference;
    @JsonProperty("hdnSelectJuminCode")
    private RString hdnSelectJuminCode;
    @JsonProperty("hdnButtonSaiSanshutsuFlag")
    private RString hdnButtonSaiSanshutsuFlag;
    @JsonProperty("hdnHenkomaeStaiCode")
    private RString hdnHenkomaeStaiCode;
    @JsonProperty("hdnHenkomaeShoriNendo")
    private RString hdnHenkomaeShoriNendo;
    @JsonProperty("hdnHenkomaeSetaiinHaakuKijunYMD")
    private RString hdnHenkomaeSetaiinHaakuKijunYMD;
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    private RString hdnDaialogSelectSetaiinJoho;
    @JsonProperty("hdnGyomuCode")
    private RString hdnGyomuCode;
    @JsonProperty("hdnShikibetuCode")
    private RString hdnShikibetuCode;
    @JsonProperty("hdnShikibetsuTaishoKubun")
    private RString hdnShikibetsuTaishoKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShowShotokuJokyo
     * @return btnShowShotokuJokyo
     */
    @JsonProperty("btnShowShotokuJokyo")
    public ButtonDialog getBtnShowShotokuJokyo() {
        return btnShowShotokuJokyo;
    }

    /*
     * setbtnShowShotokuJokyo
     * @param btnShowShotokuJokyo btnShowShotokuJokyo
     */
    @JsonProperty("btnShowShotokuJokyo")
    public void setBtnShowShotokuJokyo(ButtonDialog btnShowShotokuJokyo) {
        this.btnShowShotokuJokyo = btnShowShotokuJokyo;
    }

    /*
     * getbtnShowZennendo
     * @return btnShowZennendo
     */
    @JsonProperty("btnShowZennendo")
    public ButtonDialog getBtnShowZennendo() {
        return btnShowZennendo;
    }

    /*
     * setbtnShowZennendo
     * @param btnShowZennendo btnShowZennendo
     */
    @JsonProperty("btnShowZennendo")
    public void setBtnShowZennendo(ButtonDialog btnShowZennendo) {
        this.btnShowZennendo = btnShowZennendo;
    }

    /*
     * getSetaiJoho
     * @return SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public SetaiJohoDiv getSetaiJoho() {
        return SetaiJoho;
    }

    /*
     * setSetaiJoho
     * @param SetaiJoho SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.SetaiJoho = SetaiJoho;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getbtnAddMeisai
     * @return btnAddMeisai
     */
    @JsonProperty("btnAddMeisai")
    public ButtonDialog getBtnAddMeisai() {
        return btnAddMeisai;
    }

    /*
     * setbtnAddMeisai
     * @param btnAddMeisai btnAddMeisai
     */
    @JsonProperty("btnAddMeisai")
    public void setBtnAddMeisai(ButtonDialog btnAddMeisai) {
        this.btnAddMeisai = btnAddMeisai;
    }

    /*
     * getlblTotalShunyu
     * @return lblTotalShunyu
     */
    @JsonProperty("lblTotalShunyu")
    public Label getLblTotalShunyu() {
        return lblTotalShunyu;
    }

    /*
     * setlblTotalShunyu
     * @param lblTotalShunyu lblTotalShunyu
     */
    @JsonProperty("lblTotalShunyu")
    public void setLblTotalShunyu(Label lblTotalShunyu) {
        this.lblTotalShunyu = lblTotalShunyu;
    }

    /*
     * gettxtTotalShunyu
     * @return txtTotalShunyu
     */
    @JsonProperty("txtTotalShunyu")
    public TextBoxNum getTxtTotalShunyu() {
        return txtTotalShunyu;
    }

    /*
     * settxtTotalShunyu
     * @param txtTotalShunyu txtTotalShunyu
     */
    @JsonProperty("txtTotalShunyu")
    public void setTxtTotalShunyu(TextBoxNum txtTotalShunyu) {
        this.txtTotalShunyu = txtTotalShunyu;
    }

    /*
     * getbtnCalcTotalShunyu
     * @return btnCalcTotalShunyu
     */
    @JsonProperty("btnCalcTotalShunyu")
    public Button getBtnCalcTotalShunyu() {
        return btnCalcTotalShunyu;
    }

    /*
     * setbtnCalcTotalShunyu
     * @param btnCalcTotalShunyu btnCalcTotalShunyu
     */
    @JsonProperty("btnCalcTotalShunyu")
    public void setBtnCalcTotalShunyu(Button btnCalcTotalShunyu) {
        this.btnCalcTotalShunyu = btnCalcTotalShunyu;
    }

    /*
     * getdgMeisai
     * @return dgMeisai
     */
    @JsonProperty("dgMeisai")
    public DataGrid<dgMeisai_Row> getDgMeisai() {
        return dgMeisai;
    }

    /*
     * setdgMeisai
     * @param dgMeisai dgMeisai
     */
    @JsonProperty("dgMeisai")
    public void setDgMeisai(DataGrid<dgMeisai_Row> dgMeisai) {
        this.dgMeisai = dgMeisai;
    }

    /*
     * getbtnMeisaiKautei
     * @return btnMeisaiKautei
     */
    @JsonProperty("btnMeisaiKautei")
    public Button getBtnMeisaiKautei() {
        return btnMeisaiKautei;
    }

    /*
     * setbtnMeisaiKautei
     * @param btnMeisaiKautei btnMeisaiKautei
     */
    @JsonProperty("btnMeisaiKautei")
    public void setBtnMeisaiKautei(Button btnMeisaiKautei) {
        this.btnMeisaiKautei = btnMeisaiKautei;
    }

    /*
     * getbtnMeisaiCancel
     * @return btnMeisaiCancel
     */
    @JsonProperty("btnMeisaiCancel")
    public Button getBtnMeisaiCancel() {
        return btnMeisaiCancel;
    }

    /*
     * setbtnMeisaiCancel
     * @param btnMeisaiCancel btnMeisaiCancel
     */
    @JsonProperty("btnMeisaiCancel")
    public void setBtnMeisaiCancel(Button btnMeisaiCancel) {
        this.btnMeisaiCancel = btnMeisaiCancel;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getlblDescription
     * @return lblDescription
     */
    @JsonProperty("lblDescription")
    public Label getLblDescription() {
        return lblDescription;
    }

    /*
     * setlblDescription
     * @param lblDescription lblDescription
     */
    @JsonProperty("lblDescription")
    public void setLblDescription(Label lblDescription) {
        this.lblDescription = lblDescription;
    }

    /*
     * gethdnModeAdd
     * @return hdnModeAdd
     */
    @JsonProperty("hdnModeAdd")
    public RString getHdnModeAdd() {
        return hdnModeAdd;
    }

    /*
     * sethdnModeAdd
     * @param hdnModeAdd hdnModeAdd
     */
    @JsonProperty("hdnModeAdd")
    public void setHdnModeAdd(RString hdnModeAdd) {
        this.hdnModeAdd = hdnModeAdd;
    }

    /*
     * gethdnModeReference
     * @return hdnModeReference
     */
    @JsonProperty("hdnModeReference")
    public RString getHdnModeReference() {
        return hdnModeReference;
    }

    /*
     * sethdnModeReference
     * @param hdnModeReference hdnModeReference
     */
    @JsonProperty("hdnModeReference")
    public void setHdnModeReference(RString hdnModeReference) {
        this.hdnModeReference = hdnModeReference;
    }

    /*
     * gethdnSelectJuminCode
     * @return hdnSelectJuminCode
     */
    @JsonProperty("hdnSelectJuminCode")
    public RString getHdnSelectJuminCode() {
        return hdnSelectJuminCode;
    }

    /*
     * sethdnSelectJuminCode
     * @param hdnSelectJuminCode hdnSelectJuminCode
     */
    @JsonProperty("hdnSelectJuminCode")
    public void setHdnSelectJuminCode(RString hdnSelectJuminCode) {
        this.hdnSelectJuminCode = hdnSelectJuminCode;
    }

    /*
     * gethdnButtonSaiSanshutsuFlag
     * @return hdnButtonSaiSanshutsuFlag
     */
    @JsonProperty("hdnButtonSaiSanshutsuFlag")
    public RString getHdnButtonSaiSanshutsuFlag() {
        return hdnButtonSaiSanshutsuFlag;
    }

    /*
     * sethdnButtonSaiSanshutsuFlag
     * @param hdnButtonSaiSanshutsuFlag hdnButtonSaiSanshutsuFlag
     */
    @JsonProperty("hdnButtonSaiSanshutsuFlag")
    public void setHdnButtonSaiSanshutsuFlag(RString hdnButtonSaiSanshutsuFlag) {
        this.hdnButtonSaiSanshutsuFlag = hdnButtonSaiSanshutsuFlag;
    }

    /*
     * gethdnHenkomaeStaiCode
     * @return hdnHenkomaeStaiCode
     */
    @JsonProperty("hdnHenkomaeStaiCode")
    public RString getHdnHenkomaeStaiCode() {
        return hdnHenkomaeStaiCode;
    }

    /*
     * sethdnHenkomaeStaiCode
     * @param hdnHenkomaeStaiCode hdnHenkomaeStaiCode
     */
    @JsonProperty("hdnHenkomaeStaiCode")
    public void setHdnHenkomaeStaiCode(RString hdnHenkomaeStaiCode) {
        this.hdnHenkomaeStaiCode = hdnHenkomaeStaiCode;
    }

    /*
     * gethdnHenkomaeShoriNendo
     * @return hdnHenkomaeShoriNendo
     */
    @JsonProperty("hdnHenkomaeShoriNendo")
    public RString getHdnHenkomaeShoriNendo() {
        return hdnHenkomaeShoriNendo;
    }

    /*
     * sethdnHenkomaeShoriNendo
     * @param hdnHenkomaeShoriNendo hdnHenkomaeShoriNendo
     */
    @JsonProperty("hdnHenkomaeShoriNendo")
    public void setHdnHenkomaeShoriNendo(RString hdnHenkomaeShoriNendo) {
        this.hdnHenkomaeShoriNendo = hdnHenkomaeShoriNendo;
    }

    /*
     * gethdnHenkomaeSetaiinHaakuKijunYMD
     * @return hdnHenkomaeSetaiinHaakuKijunYMD
     */
    @JsonProperty("hdnHenkomaeSetaiinHaakuKijunYMD")
    public RString getHdnHenkomaeSetaiinHaakuKijunYMD() {
        return hdnHenkomaeSetaiinHaakuKijunYMD;
    }

    /*
     * sethdnHenkomaeSetaiinHaakuKijunYMD
     * @param hdnHenkomaeSetaiinHaakuKijunYMD hdnHenkomaeSetaiinHaakuKijunYMD
     */
    @JsonProperty("hdnHenkomaeSetaiinHaakuKijunYMD")
    public void setHdnHenkomaeSetaiinHaakuKijunYMD(RString hdnHenkomaeSetaiinHaakuKijunYMD) {
        this.hdnHenkomaeSetaiinHaakuKijunYMD = hdnHenkomaeSetaiinHaakuKijunYMD;
    }

    /*
     * gethdnDaialogSelectSetaiinJoho
     * @return hdnDaialogSelectSetaiinJoho
     */
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    public RString getHdnDaialogSelectSetaiinJoho() {
        return hdnDaialogSelectSetaiinJoho;
    }

    /*
     * sethdnDaialogSelectSetaiinJoho
     * @param hdnDaialogSelectSetaiinJoho hdnDaialogSelectSetaiinJoho
     */
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    public void setHdnDaialogSelectSetaiinJoho(RString hdnDaialogSelectSetaiinJoho) {
        this.hdnDaialogSelectSetaiinJoho = hdnDaialogSelectSetaiinJoho;
    }

    /*
     * gethdnGyomuCode
     * @return hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public RString getHdnGyomuCode() {
        return hdnGyomuCode;
    }

    /*
     * sethdnGyomuCode
     * @param hdnGyomuCode hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public void setHdnGyomuCode(RString hdnGyomuCode) {
        this.hdnGyomuCode = hdnGyomuCode;
    }

    /*
     * gethdnShikibetuCode
     * @return hdnShikibetuCode
     */
    @JsonProperty("hdnShikibetuCode")
    public RString getHdnShikibetuCode() {
        return hdnShikibetuCode;
    }

    /*
     * sethdnShikibetuCode
     * @param hdnShikibetuCode hdnShikibetuCode
     */
    @JsonProperty("hdnShikibetuCode")
    public void setHdnShikibetuCode(RString hdnShikibetuCode) {
        this.hdnShikibetuCode = hdnShikibetuCode;
    }

    /*
     * gethdnShikibetsuTaishoKubun
     * @return hdnShikibetsuTaishoKubun
     */
    @JsonProperty("hdnShikibetsuTaishoKubun")
    public RString getHdnShikibetsuTaishoKubun() {
        return hdnShikibetsuTaishoKubun;
    }

    /*
     * sethdnShikibetsuTaishoKubun
     * @param hdnShikibetsuTaishoKubun hdnShikibetsuTaishoKubun
     */
    @JsonProperty("hdnShikibetsuTaishoKubun")
    public void setHdnShikibetsuTaishoKubun(RString hdnShikibetsuTaishoKubun) {
        this.hdnShikibetsuTaishoKubun = hdnShikibetsuTaishoKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtSetaiCode() {
        return this.getSetaiJoho().getTxtSetaiCode();
    }

    @JsonIgnore
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.getSetaiJoho().setTxtSetaiCode(txtSetaiCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShoriNendo() {
        return this.getSetaiJoho().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxFlexibleDate txtShoriNendo) {
        this.getSetaiJoho().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSetaiinHaakuKijunYMD() {
        return this.getSetaiJoho().getTxtSetaiinHaakuKijunYMD();
    }

    @JsonIgnore
    public void setTxtSetaiinHaakuKijunYMD(TextBoxFlexibleDate txtSetaiinHaakuKijunYMD) {
        this.getSetaiJoho().setTxtSetaiinHaakuKijunYMD(txtSetaiinHaakuKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getSetaiJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getSetaiJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseishoSakuseiYMD() {
        return this.getSetaiJoho().getTxtShinseishoSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseishoSakuseiYMD(TextBoxFlexibleDate txtShinseishoSakuseiYMD) {
        this.getSetaiJoho().setTxtShinseishoSakuseiYMD(txtShinseishoSakuseiYMD);
    }

    @JsonIgnore
    public SetaiJoho2Div getSetaiJoho2() {
        return this.getSetaiJoho().getSetaiJoho2();
    }

    @JsonIgnore
    public void setSetaiJoho2(SetaiJoho2Div SetaiJoho2) {
        this.getSetaiJoho().setSetaiJoho2(SetaiJoho2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazei() {
        return this.getSetaiJoho().getSetaiJoho2().getTxtSetaiKazei();
    }

    @JsonIgnore
    public void setTxtSetaiKazei(TextBox txtSetaiKazei) {
        this.getSetaiJoho().getSetaiJoho2().setTxtSetaiKazei(txtSetaiKazei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStartYM() {
        return this.getSetaiJoho().getSetaiJoho2().getTxtTekiyoStartYM();
    }

    @JsonIgnore
    public void setTxtTekiyoStartYM(TextBoxFlexibleDate txtTekiyoStartYM) {
        this.getSetaiJoho().getSetaiJoho2().setTxtTekiyoStartYM(txtTekiyoStartYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoEndYM() {
        return this.getSetaiJoho().getSetaiJoho2().getTxtTekiyoEndYM();
    }

    @JsonIgnore
    public void setTxtTekiyoEndYM(TextBoxFlexibleDate txtTekiyoEndYM) {
        this.getSetaiJoho().getSetaiJoho2().setTxtTekiyoEndYM(txtTekiyoEndYM);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKijunGaku() {
        return this.getSetaiJoho().getSetaiJoho2().getDdlSanteiKijunGaku();
    }

    @JsonIgnore
    public void setDdlSanteiKijunGaku(DropDownList ddlSanteiKijunGaku) {
        this.getSetaiJoho().getSetaiJoho2().setDdlSanteiKijunGaku(ddlSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getSetaiJoho().getSetaiJoho2().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getSetaiJoho().getSetaiJoho2().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiTsuchishoHakkoYMD() {
        return this.getSetaiJoho().getSetaiJoho2().getTxtKetteiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchishoHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchishoHakkoYMD) {
        this.getSetaiJoho().getSetaiJoho2().setTxtKetteiTsuchishoHakkoYMD(txtKetteiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public FuyoKojoDiv getFuyoKojo() {
        return this.getSetaiJoho().getFuyoKojo();
    }

    @JsonIgnore
    public void setFuyoKojo(FuyoKojoDiv FuyoKojo) {
        this.getSetaiJoho().setFuyoKojo(FuyoKojo);
    }

    @JsonIgnore
    public ButtonPanelDiv getButtonPanel() {
        return this.getSetaiJoho().getFuyoKojo().getButtonPanel();
    }

    @JsonIgnore
    public void setButtonPanel(ButtonPanelDiv ButtonPanel) {
        this.getSetaiJoho().getFuyoKojo().setButtonPanel(ButtonPanel);
    }

    @JsonIgnore
    public Button getBtnSetaiSaiSanshutsu() {
        return this.getSetaiJoho().getFuyoKojo().getButtonPanel().getBtnSetaiSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnSetaiSaiSanshutsu(Button btnSetaiSaiSanshutsu) {
        this.getSetaiJoho().getFuyoKojo().getButtonPanel().setBtnSetaiSaiSanshutsu(btnSetaiSaiSanshutsu);
    }

    @JsonIgnore
    public Button getBtnKojoSaiSanshutsu() {
        return this.getSetaiJoho().getFuyoKojo().getButtonPanel().getBtnKojoSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnKojoSaiSanshutsu(Button btnKojoSaiSanshutsu) {
        this.getSetaiJoho().getFuyoKojo().getButtonPanel().setBtnKojoSaiSanshutsu(btnKojoSaiSanshutsu);
    }

    @JsonIgnore
    public Label getLblKojoTaisho() {
        return this.getSetaiJoho().getFuyoKojo().getLblKojoTaisho();
    }

    @JsonIgnore
    public void setLblKojoTaisho(Label lblKojoTaisho) {
        this.getSetaiJoho().getFuyoKojo().setLblKojoTaisho(lblKojoTaisho);
    }

    @JsonIgnore
    public ZennenKojoTaishoDiv getZennenKojoTaisho() {
        return this.getSetaiJoho().getFuyoKojo().getZennenKojoTaisho();
    }

    @JsonIgnore
    public void setZennenKojoTaisho(ZennenKojoTaishoDiv ZennenKojoTaisho) {
        this.getSetaiJoho().getFuyoKojo().setZennenKojoTaisho(ZennenKojoTaisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder16() {
        return this.getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().getTxtUnder16();
    }

    @JsonIgnore
    public void setTxtUnder16(TextBoxNum txtUnder16) {
        this.getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().setTxtUnder16(txtUnder16);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver16() {
        return this.getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().getTxtOver16();
    }

    @JsonIgnore
    public void setTxtOver16(TextBoxNum txtOver16) {
        this.getSetaiJoho().getFuyoKojo().getZennenKojoTaisho().setTxtOver16(txtOver16);
    }

    // </editor-fold>
}
