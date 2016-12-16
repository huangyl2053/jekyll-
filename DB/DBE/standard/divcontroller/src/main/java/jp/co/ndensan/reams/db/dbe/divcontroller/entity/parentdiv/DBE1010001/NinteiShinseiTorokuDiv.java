package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * NinteiShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("headPanel")
    private headPanelDiv headPanel;
    @JsonProperty("btnIryohokenGuide")
    private ButtonDialog btnIryohokenGuide;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    private ButtonDialog btnNyuinAndShisetsuNyusho;
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    private ButtonDialog btnJogaiShinsakaiIinGuide;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnTainoJokyo")
    private ButtonDialog btnTainoJokyo;
    @JsonProperty("tabShinseishaJoho")
    private tabShinseishaJohoDiv tabShinseishaJoho;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnRenrakusakiJoho")
    private RString hdnRenrakusakiJoho;
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    private RString hdnZenkaiRenrakusakiJoho;
    @JsonProperty("hdnShichosonRenrakuJiko")
    private RString hdnShichosonRenrakuJiko;
    @JsonProperty("hdnJogaiShinsainJoho")
    private RString hdnJogaiShinsainJoho;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;
    @JsonProperty("hdnRenrakuJikoToChosain")
    private RString hdnRenrakuJikoToChosain;
    @JsonProperty("hdnRenrakuJikoToShujii")
    private RString hdnRenrakuJikoToShujii;
    @JsonProperty("hdnShimeiKana")
    private RString hdnShimeiKana;
    @JsonProperty("hdnIryoHokenshaMeisho")
    private RString hdnIryoHokenshaMeisho;
    @JsonProperty("hdnIryoHokenKigoNo")
    private RString hdnIryoHokenKigoNo;
    @JsonProperty("hdnRenrakusakiReadOnly")
    private RString hdnRenrakusakiReadOnly;
    @JsonProperty("hdnSubGyomuCd")
    private RString hdnSubGyomuCd;
    @JsonProperty("hdnGroupCode")
    private RString hdnGroupCode;
    @JsonProperty("hdnJogaiMode")
    private RString hdnJogaiMode;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdnIryoMode")
    private RString hdnIryoMode;
    @JsonProperty("hdnKanriMode")
    private RString hdnKanriMode;
    @JsonProperty("hdnDisplayModeKey")
    private RString hdnDisplayModeKey;
    @JsonProperty("hdnKonkai")
    private RString hdnKonkai;
    @JsonProperty("hdnZenkai")
    private RString hdnZenkai;
    @JsonProperty("hdnGroupCd")
    private RString hdnGroupCd;
    @JsonProperty("hdnShishoCode")
    private RString hdnShishoCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getheadPanel
     * @return headPanel
     */
    @JsonProperty("headPanel")
    public headPanelDiv getHeadPanel() {
        return headPanel;
    }

    /*
     * setheadPanel
     * @param headPanel headPanel
     */
    @JsonProperty("headPanel")
    public void setHeadPanel(headPanelDiv headPanel) {
        this.headPanel = headPanel;
    }

    /*
     * getbtnIryohokenGuide
     * @return btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public ButtonDialog getBtnIryohokenGuide() {
        return btnIryohokenGuide;
    }

    /*
     * setbtnIryohokenGuide
     * @param btnIryohokenGuide btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.btnIryohokenGuide = btnIryohokenGuide;
    }

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
     * getbtnNyuinAndShisetsuNyusho
     * @return btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public ButtonDialog getBtnNyuinAndShisetsuNyusho() {
        return btnNyuinAndShisetsuNyusho;
    }

    /*
     * setbtnNyuinAndShisetsuNyusho
     * @param btnNyuinAndShisetsuNyusho btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public void setBtnNyuinAndShisetsuNyusho(ButtonDialog btnNyuinAndShisetsuNyusho) {
        this.btnNyuinAndShisetsuNyusho = btnNyuinAndShisetsuNyusho;
    }

    /*
     * getbtnJogaiShinsakaiIinGuide
     * @return btnJogaiShinsakaiIinGuide
     */
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    public ButtonDialog getBtnJogaiShinsakaiIinGuide() {
        return btnJogaiShinsakaiIinGuide;
    }

    /*
     * setbtnJogaiShinsakaiIinGuide
     * @param btnJogaiShinsakaiIinGuide btnJogaiShinsakaiIinGuide
     */
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    public void setBtnJogaiShinsakaiIinGuide(ButtonDialog btnJogaiShinsakaiIinGuide) {
        this.btnJogaiShinsakaiIinGuide = btnJogaiShinsakaiIinGuide;
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
     * getbtnChosaJokyo
     * @return btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    /*
     * setbtnChosaJokyo
     * @param btnChosaJokyo btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo = btnChosaJokyo;
    }

    /*
     * getbtnTainoJokyo
     * @return btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public ButtonDialog getBtnTainoJokyo() {
        return btnTainoJokyo;
    }

    /*
     * setbtnTainoJokyo
     * @param btnTainoJokyo btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.btnTainoJokyo = btnTainoJokyo;
    }

    /*
     * gettabShinseishaJoho
     * @return tabShinseishaJoho
     */
    @JsonProperty("tabShinseishaJoho")
    public tabShinseishaJohoDiv getTabShinseishaJoho() {
        return tabShinseishaJoho;
    }

    /*
     * settabShinseishaJoho
     * @param tabShinseishaJoho tabShinseishaJoho
     */
    @JsonProperty("tabShinseishaJoho")
    public void setTabShinseishaJoho(tabShinseishaJohoDiv tabShinseishaJoho) {
        this.tabShinseishaJoho = tabShinseishaJoho;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnRenrakusakiJoho
     * @return hdnRenrakusakiJoho
     */
    @JsonProperty("hdnRenrakusakiJoho")
    public RString getHdnRenrakusakiJoho() {
        return hdnRenrakusakiJoho;
    }

    /*
     * sethdnRenrakusakiJoho
     * @param hdnRenrakusakiJoho hdnRenrakusakiJoho
     */
    @JsonProperty("hdnRenrakusakiJoho")
    public void setHdnRenrakusakiJoho(RString hdnRenrakusakiJoho) {
        this.hdnRenrakusakiJoho = hdnRenrakusakiJoho;
    }

    /*
     * gethdnZenkaiRenrakusakiJoho
     * @return hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public RString getHdnZenkaiRenrakusakiJoho() {
        return hdnZenkaiRenrakusakiJoho;
    }

    /*
     * sethdnZenkaiRenrakusakiJoho
     * @param hdnZenkaiRenrakusakiJoho hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public void setHdnZenkaiRenrakusakiJoho(RString hdnZenkaiRenrakusakiJoho) {
        this.hdnZenkaiRenrakusakiJoho = hdnZenkaiRenrakusakiJoho;
    }

    /*
     * gethdnShichosonRenrakuJiko
     * @return hdnShichosonRenrakuJiko
     */
    @JsonProperty("hdnShichosonRenrakuJiko")
    public RString getHdnShichosonRenrakuJiko() {
        return hdnShichosonRenrakuJiko;
    }

    /*
     * sethdnShichosonRenrakuJiko
     * @param hdnShichosonRenrakuJiko hdnShichosonRenrakuJiko
     */
    @JsonProperty("hdnShichosonRenrakuJiko")
    public void setHdnShichosonRenrakuJiko(RString hdnShichosonRenrakuJiko) {
        this.hdnShichosonRenrakuJiko = hdnShichosonRenrakuJiko;
    }

    /*
     * gethdnJogaiShinsainJoho
     * @return hdnJogaiShinsainJoho
     */
    @JsonProperty("hdnJogaiShinsainJoho")
    public RString getHdnJogaiShinsainJoho() {
        return hdnJogaiShinsainJoho;
    }

    /*
     * sethdnJogaiShinsainJoho
     * @param hdnJogaiShinsainJoho hdnJogaiShinsainJoho
     */
    @JsonProperty("hdnJogaiShinsainJoho")
    public void setHdnJogaiShinsainJoho(RString hdnJogaiShinsainJoho) {
        this.hdnJogaiShinsainJoho = hdnJogaiShinsainJoho;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    /*
     * gethdnRenrakuJikoToChosain
     * @return hdnRenrakuJikoToChosain
     */
    @JsonProperty("hdnRenrakuJikoToChosain")
    public RString getHdnRenrakuJikoToChosain() {
        return hdnRenrakuJikoToChosain;
    }

    /*
     * sethdnRenrakuJikoToChosain
     * @param hdnRenrakuJikoToChosain hdnRenrakuJikoToChosain
     */
    @JsonProperty("hdnRenrakuJikoToChosain")
    public void setHdnRenrakuJikoToChosain(RString hdnRenrakuJikoToChosain) {
        this.hdnRenrakuJikoToChosain = hdnRenrakuJikoToChosain;
    }

    /*
     * gethdnRenrakuJikoToShujii
     * @return hdnRenrakuJikoToShujii
     */
    @JsonProperty("hdnRenrakuJikoToShujii")
    public RString getHdnRenrakuJikoToShujii() {
        return hdnRenrakuJikoToShujii;
    }

    /*
     * sethdnRenrakuJikoToShujii
     * @param hdnRenrakuJikoToShujii hdnRenrakuJikoToShujii
     */
    @JsonProperty("hdnRenrakuJikoToShujii")
    public void setHdnRenrakuJikoToShujii(RString hdnRenrakuJikoToShujii) {
        this.hdnRenrakuJikoToShujii = hdnRenrakuJikoToShujii;
    }

    /*
     * gethdnShimeiKana
     * @return hdnShimeiKana
     */
    @JsonProperty("hdnShimeiKana")
    public RString getHdnShimeiKana() {
        return hdnShimeiKana;
    }

    /*
     * sethdnShimeiKana
     * @param hdnShimeiKana hdnShimeiKana
     */
    @JsonProperty("hdnShimeiKana")
    public void setHdnShimeiKana(RString hdnShimeiKana) {
        this.hdnShimeiKana = hdnShimeiKana;
    }

    /*
     * gethdnIryoHokenshaMeisho
     * @return hdnIryoHokenshaMeisho
     */
    @JsonProperty("hdnIryoHokenshaMeisho")
    public RString getHdnIryoHokenshaMeisho() {
        return hdnIryoHokenshaMeisho;
    }

    /*
     * sethdnIryoHokenshaMeisho
     * @param hdnIryoHokenshaMeisho hdnIryoHokenshaMeisho
     */
    @JsonProperty("hdnIryoHokenshaMeisho")
    public void setHdnIryoHokenshaMeisho(RString hdnIryoHokenshaMeisho) {
        this.hdnIryoHokenshaMeisho = hdnIryoHokenshaMeisho;
    }

    /*
     * gethdnIryoHokenKigoNo
     * @return hdnIryoHokenKigoNo
     */
    @JsonProperty("hdnIryoHokenKigoNo")
    public RString getHdnIryoHokenKigoNo() {
        return hdnIryoHokenKigoNo;
    }

    /*
     * sethdnIryoHokenKigoNo
     * @param hdnIryoHokenKigoNo hdnIryoHokenKigoNo
     */
    @JsonProperty("hdnIryoHokenKigoNo")
    public void setHdnIryoHokenKigoNo(RString hdnIryoHokenKigoNo) {
        this.hdnIryoHokenKigoNo = hdnIryoHokenKigoNo;
    }

    /*
     * gethdnRenrakusakiReadOnly
     * @return hdnRenrakusakiReadOnly
     */
    @JsonProperty("hdnRenrakusakiReadOnly")
    public RString getHdnRenrakusakiReadOnly() {
        return hdnRenrakusakiReadOnly;
    }

    /*
     * sethdnRenrakusakiReadOnly
     * @param hdnRenrakusakiReadOnly hdnRenrakusakiReadOnly
     */
    @JsonProperty("hdnRenrakusakiReadOnly")
    public void setHdnRenrakusakiReadOnly(RString hdnRenrakusakiReadOnly) {
        this.hdnRenrakusakiReadOnly = hdnRenrakusakiReadOnly;
    }

    /*
     * gethdnSubGyomuCd
     * @return hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public RString getHdnSubGyomuCd() {
        return hdnSubGyomuCd;
    }

    /*
     * sethdnSubGyomuCd
     * @param hdnSubGyomuCd hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public void setHdnSubGyomuCd(RString hdnSubGyomuCd) {
        this.hdnSubGyomuCd = hdnSubGyomuCd;
    }

    /*
     * gethdnGroupCode
     * @return hdnGroupCode
     */
    @JsonProperty("hdnGroupCode")
    public RString getHdnGroupCode() {
        return hdnGroupCode;
    }

    /*
     * sethdnGroupCode
     * @param hdnGroupCode hdnGroupCode
     */
    @JsonProperty("hdnGroupCode")
    public void setHdnGroupCode(RString hdnGroupCode) {
        this.hdnGroupCode = hdnGroupCode;
    }

    /*
     * gethdnJogaiMode
     * @return hdnJogaiMode
     */
    @JsonProperty("hdnJogaiMode")
    public RString getHdnJogaiMode() {
        return hdnJogaiMode;
    }

    /*
     * sethdnJogaiMode
     * @param hdnJogaiMode hdnJogaiMode
     */
    @JsonProperty("hdnJogaiMode")
    public void setHdnJogaiMode(RString hdnJogaiMode) {
        this.hdnJogaiMode = hdnJogaiMode;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    /*
     * gethdnIryoMode
     * @return hdnIryoMode
     */
    @JsonProperty("hdnIryoMode")
    public RString getHdnIryoMode() {
        return hdnIryoMode;
    }

    /*
     * sethdnIryoMode
     * @param hdnIryoMode hdnIryoMode
     */
    @JsonProperty("hdnIryoMode")
    public void setHdnIryoMode(RString hdnIryoMode) {
        this.hdnIryoMode = hdnIryoMode;
    }

    /*
     * gethdnKanriMode
     * @return hdnKanriMode
     */
    @JsonProperty("hdnKanriMode")
    public RString getHdnKanriMode() {
        return hdnKanriMode;
    }

    /*
     * sethdnKanriMode
     * @param hdnKanriMode hdnKanriMode
     */
    @JsonProperty("hdnKanriMode")
    public void setHdnKanriMode(RString hdnKanriMode) {
        this.hdnKanriMode = hdnKanriMode;
    }

    /*
     * gethdnDisplayModeKey
     * @return hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public RString getHdnDisplayModeKey() {
        return hdnDisplayModeKey;
    }

    /*
     * sethdnDisplayModeKey
     * @param hdnDisplayModeKey hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public void setHdnDisplayModeKey(RString hdnDisplayModeKey) {
        this.hdnDisplayModeKey = hdnDisplayModeKey;
    }

    /*
     * gethdnKonkai
     * @return hdnKonkai
     */
    @JsonProperty("hdnKonkai")
    public RString getHdnKonkai() {
        return hdnKonkai;
    }

    /*
     * sethdnKonkai
     * @param hdnKonkai hdnKonkai
     */
    @JsonProperty("hdnKonkai")
    public void setHdnKonkai(RString hdnKonkai) {
        this.hdnKonkai = hdnKonkai;
    }

    /*
     * gethdnZenkai
     * @return hdnZenkai
     */
    @JsonProperty("hdnZenkai")
    public RString getHdnZenkai() {
        return hdnZenkai;
    }

    /*
     * sethdnZenkai
     * @param hdnZenkai hdnZenkai
     */
    @JsonProperty("hdnZenkai")
    public void setHdnZenkai(RString hdnZenkai) {
        this.hdnZenkai = hdnZenkai;
    }

    /*
     * gethdnGroupCd
     * @return hdnGroupCd
     */
    @JsonProperty("hdnGroupCd")
    public RString getHdnGroupCd() {
        return hdnGroupCd;
    }

    /*
     * sethdnGroupCd
     * @param hdnGroupCd hdnGroupCd
     */
    @JsonProperty("hdnGroupCd")
    public void setHdnGroupCd(RString hdnGroupCd) {
        this.hdnGroupCd = hdnGroupCd;
    }

    /*
     * gethdnShishoCode
     * @return hdnShishoCode
     */
    @JsonProperty("hdnShishoCode")
    public RString getHdnShishoCode() {
        return hdnShishoCode;
    }

    /*
     * sethdnShishoCode
     * @param hdnShishoCode hdnShishoCode
     */
    @JsonProperty("hdnShishoCode")
    public void setHdnShishoCode(RString hdnShishoCode) {
        this.hdnShishoCode = hdnShishoCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoNinteiAtenaInfoDiv getCcdAtenaInfo() {
        return this.getHeadPanel().getCcdAtenaInfo();
    }

    @JsonIgnore
    public IKaigoninteiShikakuInfoDiv getCcdShikakuInfo() {
        return this.getHeadPanel().getCcdShikakuInfo();
    }

    @JsonIgnore
    public tplShinseijohoDiv getTplShinseijoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho();
    }

    @JsonIgnore
    public void setTplShinseijoho(tplShinseijohoDiv tplShinseijoho) {
        this.getTabShinseishaJoho().setTplShinseijoho(tplShinseijoho);
    }

    @JsonIgnore
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan();
    }

    @JsonIgnore
    public void setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.getTabShinseishaJoho().getTplShinseijoho().setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikan);
    }

    @JsonIgnore
    public HomonSakiDiv getHomonSaki() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki();
    }

    @JsonIgnore
    public void setHomonSaki(HomonSakiDiv HomonSaki) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().setHomonSaki(HomonSaki);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().getTxtJusho();
    }

    @JsonIgnore
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getHomonSaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput();
    }

    @JsonIgnore
    public void setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChosainAndChosainInput(ChosainAndChosainInput);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChodsItakusakiAndChosainInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput().getCcdChodsItakusakiAndChosainInput();
    }

    @JsonIgnore
    public ShisetsuJohoDiv getShisetsuJoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho();
    }

    @JsonIgnore
    public void setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.getTabShinseishaJoho().getTplShinseijoho().setShisetsuJoho(ShisetsuJoho);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChkNinteiTsuchishoDoi();
    }

    @JsonIgnore
    public void setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChkNinteiTsuchishoDoi(chkNinteiTsuchishoDoi);
    }

    @JsonIgnore
    public CheckBoxList getChkJohoTeikyoDoi() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChkJohoTeikyoDoi();
    }

    @JsonIgnore
    public void setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChkJohoTeikyoDoi(chkJohoTeikyoDoi);
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdKaigoNinteiShinseiKihon();
    }

    @JsonIgnore
    public INinteiInputDiv getCcdNinteiInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdNinteiInput();
    }

    @JsonIgnore
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiSonotaJohoInput();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiTodokedesha();
    }

    @JsonIgnore
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdZenkaiNinteiKekkaJoho();
    }

    @JsonIgnore
    public tplEnkiDiv getTplEnki() {
        return this.getTabShinseishaJoho().getTplEnki();
    }

    @JsonIgnore
    public void setTplEnki(tplEnkiDiv tplEnki) {
        this.getTabShinseishaJoho().setTplEnki(tplEnki);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiMikomiKikan();
    }

    @JsonIgnore
    public void  setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiMikomiKikan(txtEnkiMikomiKikan);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getTabShinseishaJoho().getTplEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getTabShinseishaJoho().getTplEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getTabShinseishaJoho().getTplEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getTabShinseishaJoho().getTplEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    // </editor-fold>
}
