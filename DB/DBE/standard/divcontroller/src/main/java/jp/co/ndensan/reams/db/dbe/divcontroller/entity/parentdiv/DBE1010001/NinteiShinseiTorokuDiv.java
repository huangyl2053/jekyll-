package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("headPanel")
    private headPanelDiv headPanel;
    @JsonProperty("pnlNinteiShinseiDetail")
    private pnlNinteiShinseiDetailDiv pnlNinteiShinseiDetail;
    @JsonProperty("pnlKanryoMessage")
    private pnlKanryoMessageDiv pnlKanryoMessage;
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
    @JsonProperty("hdnTeikeibun")
    private RString hdnTeikeibun;
    @JsonProperty("hdnTorisageTeikeibun")
    private RString hdnTorisageTeikeibun;

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
     * getpnlNinteiShinseiDetail
     * @return pnlNinteiShinseiDetail
     */
    @JsonProperty("pnlNinteiShinseiDetail")
    public pnlNinteiShinseiDetailDiv getPnlNinteiShinseiDetail() {
        return pnlNinteiShinseiDetail;
    }

    /*
     * setpnlNinteiShinseiDetail
     * @param pnlNinteiShinseiDetail pnlNinteiShinseiDetail
     */
    @JsonProperty("pnlNinteiShinseiDetail")
    public void setPnlNinteiShinseiDetail(pnlNinteiShinseiDetailDiv pnlNinteiShinseiDetail) {
        this.pnlNinteiShinseiDetail = pnlNinteiShinseiDetail;
    }

    /*
     * getpnlKanryoMessage
     * @return pnlKanryoMessage
     */
    @JsonProperty("pnlKanryoMessage")
    public pnlKanryoMessageDiv getPnlKanryoMessage() {
        return pnlKanryoMessage;
    }

    /*
     * setpnlKanryoMessage
     * @param pnlKanryoMessage pnlKanryoMessage
     */
    @JsonProperty("pnlKanryoMessage")
    public void setPnlKanryoMessage(pnlKanryoMessageDiv pnlKanryoMessage) {
        this.pnlKanryoMessage = pnlKanryoMessage;
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
     * gethdnTeikeibun
     * @return hdnTeikeibun
     */
    @JsonProperty("hdnTeikeibun")
    public RString getHdnTeikeibun() {
        return hdnTeikeibun;
    }

    /*
     * sethdnTeikeibun
     * @param hdnTeikeibun hdnTeikeibun
     */
    @JsonProperty("hdnTeikeibun")
    public void setHdnTeikeibun(RString hdnTeikeibun) {
        this.hdnTeikeibun = hdnTeikeibun;
    }

    /*
     * gethdnTorisageTeikeibun
     * @return hdnTorisageTeikeibun
     */
    @JsonProperty("hdnTorisageTeikeibun")
    public RString getHdnTorisageTeikeibun() {
        return hdnTorisageTeikeibun;
    }

    /*
     * sethdnTorisageTeikeibun
     * @param hdnTorisageTeikeibun hdnTorisageTeikeibun
     */
    @JsonProperty("hdnTorisageTeikeibun")
    public void setHdnTorisageTeikeibun(RString hdnTorisageTeikeibun) {
        this.hdnTorisageTeikeibun = hdnTorisageTeikeibun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public AtenaInfoTorokuDiv getAtenaInfoToroku() {
        return this.getHeadPanel().getAtenaInfoToroku();
    }

    @JsonIgnore
    public void  setAtenaInfoToroku(AtenaInfoTorokuDiv AtenaInfoToroku) {
        this.getHeadPanel().setAtenaInfoToroku(AtenaInfoToroku);
    }

    @JsonIgnore
    public IKaigoninteiShikakuInfoDiv getCcdShikakuInfo() {
        return this.getHeadPanel().getCcdShikakuInfo();
    }

    @JsonIgnore
    public ButtonDialog getBtnIryohokenGuide() {
        return this.getPnlNinteiShinseiDetail().getBtnIryohokenGuide();
    }

    @JsonIgnore
    public void  setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.getPnlNinteiShinseiDetail().setBtnIryohokenGuide(btnIryohokenGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnRenrakusaki() {
        return this.getPnlNinteiShinseiDetail().getBtnRenrakusaki();
    }

    @JsonIgnore
    public void  setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.getPnlNinteiShinseiDetail().setBtnRenrakusaki(btnRenrakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNyuinAndShisetsuNyusho() {
        return this.getPnlNinteiShinseiDetail().getBtnNyuinAndShisetsuNyusho();
    }

    @JsonIgnore
    public void  setBtnNyuinAndShisetsuNyusho(ButtonDialog btnNyuinAndShisetsuNyusho) {
        this.getPnlNinteiShinseiDetail().setBtnNyuinAndShisetsuNyusho(btnNyuinAndShisetsuNyusho);
    }

    @JsonIgnore
    public ButtonDialog getBtnJogaiShinsakaiIinGuide() {
        return this.getPnlNinteiShinseiDetail().getBtnJogaiShinsakaiIinGuide();
    }

    @JsonIgnore
    public void  setBtnJogaiShinsakaiIinGuide(ButtonDialog btnJogaiShinsakaiIinGuide) {
        this.getPnlNinteiShinseiDetail().setBtnJogaiShinsakaiIinGuide(btnJogaiShinsakaiIinGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return this.getPnlNinteiShinseiDetail().getBtnShichosonRenrakuJiko();
    }

    @JsonIgnore
    public void  setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.getPnlNinteiShinseiDetail().setBtnShichosonRenrakuJiko(btnShichosonRenrakuJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaJokyo() {
        return this.getPnlNinteiShinseiDetail().getBtnChosaJokyo();
    }

    @JsonIgnore
    public void  setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.getPnlNinteiShinseiDetail().setBtnChosaJokyo(btnChosaJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getPnlNinteiShinseiDetail().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void  setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getPnlNinteiShinseiDetail().setBtnTainoJokyo(btnTainoJokyo);
    }

    @JsonIgnore
    public tabShinseishaJohoDiv getTabShinseishaJoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho();
    }

    @JsonIgnore
    public void  setTabShinseishaJoho(tabShinseishaJohoDiv tabShinseishaJoho) {
        this.getPnlNinteiShinseiDetail().setTabShinseishaJoho(tabShinseishaJoho);
    }

    @JsonIgnore
    public tplShinseijohoDiv getTplShinseijoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho();
    }

    @JsonIgnore
    public void  setTplShinseijoho(tplShinseijohoDiv tplShinseijoho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().setTplShinseijoho(tplShinseijoho);
    }

    @JsonIgnore
    public RadioButton getRadMode() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getRadMode();
    }

    @JsonIgnore
    public void  setRadMode(RadioButton radMode) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setRadMode(radMode);
    }

    @JsonIgnore
    public ServiceDelDiv getServiceDel() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getServiceDel();
    }

    @JsonIgnore
    public void  setServiceDel(ServiceDelDiv ServiceDel) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setServiceDel(ServiceDel);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceDelTeikeibunGuide() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getServiceDel().getBtnServiceDelTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnServiceDelTeikeibunGuide(ButtonDialog btnServiceDelTeikeibunGuide) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getServiceDel().setBtnServiceDelTeikeibunGuide(btnServiceDelTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceDeleteRiyu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getServiceDel().getTxtServiceDeleteRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceDeleteRiyu(TextBoxMultiLine txtServiceDeleteRiyu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getServiceDel().setTxtServiceDeleteRiyu(txtServiceDeleteRiyu);
    }

    @JsonIgnore
    public SinseiTorisageDiv getSinseiTorisage() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage();
    }

    @JsonIgnore
    public void  setSinseiTorisage(SinseiTorisageDiv SinseiTorisage) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setSinseiTorisage(SinseiTorisage);
    }

    @JsonIgnore
    public DropDownList getDdlTorisageJiyu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getDdlTorisageJiyu();
    }

    @JsonIgnore
    public void  setDdlTorisageJiyu(DropDownList ddlTorisageJiyu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setDdlTorisageJiyu(ddlTorisageJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorisageDate() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getTxtTorisageDate();
    }

    @JsonIgnore
    public void  setTxtTorisageDate(TextBoxDate txtTorisageDate) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setTxtTorisageDate(txtTorisageDate);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getTxtTorisageJiyu();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setTxtTorisageJiyu(txtTorisageJiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnTorisageTeikeibun() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getBtnTorisageTeikeibun();
    }

    @JsonIgnore
    public void  setBtnTorisageTeikeibun(ButtonDialog btnTorisageTeikeibun) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setBtnTorisageTeikeibun(btnTorisageTeikeibun);
    }

    @JsonIgnore
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan();
    }

    @JsonIgnore
    public void  setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikan);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput();
    }

    @JsonIgnore
    public void  setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setChosainAndChosainInput(ChosainAndChosainInput);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChodsItakusakiAndChosainInput() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput().getCcdChodsItakusakiAndChosainInput();
    }

    @JsonIgnore
    public HomonSakiDiv getHomonSaki() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki();
    }

    @JsonIgnore
    public void  setHomonSaki(HomonSakiDiv HomonSaki) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setHomonSaki(HomonSaki);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ShisetsuJohoDiv getShisetsuJoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho();
    }

    @JsonIgnore
    public void  setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setShisetsuJoho(ShisetsuJoho);
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho().getTxtNyushoShisetsu();
    }

    @JsonIgnore
    public void  setTxtNyushoShisetsu(TextBox txtNyushoShisetsu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho().setTxtNyushoShisetsu(txtNyushoShisetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getChkNinteiTsuchishoDoi();
    }

    @JsonIgnore
    public void  setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setChkNinteiTsuchishoDoi(chkNinteiTsuchishoDoi);
    }

    @JsonIgnore
    public CheckBoxList getChkJohoTeikyoDoi() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getChkJohoTeikyoDoi();
    }

    @JsonIgnore
    public void  setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setChkJohoTeikyoDoi(chkJohoTeikyoDoi);
    }

    @JsonIgnore
    public DropDownList getDdlShinsakaiYusenKubun() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getDdlShinsakaiYusenKubun();
    }

    @JsonIgnore
    public void  setDdlShinsakaiYusenKubun(DropDownList ddlShinsakaiYusenKubun) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setDdlShinsakaiYusenKubun(ddlShinsakaiYusenKubun);
    }

    @JsonIgnore
    public DropDownList getDdlWariateKubun() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getDdlWariateKubun();
    }

    @JsonIgnore
    public void  setDdlWariateKubun(DropDownList ddlWariateKubun) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().setDdlWariateKubun(ddlWariateKubun);
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getCcdKaigoNinteiShinseiKihon();
    }

    @JsonIgnore
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getCcdZenkaiNinteiKekkaJoho();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiTodokedesha();
    }

    @JsonIgnore
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiSonotaJohoInput();
    }

    @JsonIgnore
    public INinteiInputDiv getCcdNinteiInput() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseijoho().getCcdNinteiInput();
    }

    @JsonIgnore
    public tplEnkiDiv getTplEnki() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki();
    }

    @JsonIgnore
    public void  setTplEnki(tplEnkiDiv tplEnki) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().setTplEnki(tplEnki);
    }

    @JsonIgnore
    public pnlEnkiDiv getPnlEnki() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki();
    }

    @JsonIgnore
    public void  setPnlEnki(pnlEnkiDiv pnlEnki) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().setPnlEnki(pnlEnki);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getTxtEnkiMikomiKikan();
    }

    @JsonIgnore
    public void  setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setTxtEnkiMikomiKikan(txtEnkiMikomiKikan);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void  setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void  setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void  setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplEnki().getPnlEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    @JsonIgnore
    public tplShinseishaJohoDiv getTplShinseishaJoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho();
    }

    @JsonIgnore
    public void  setTplShinseishaJoho(tplShinseishaJohoDiv tplShinseishaJoho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().setTplShinseishaJoho(tplShinseishaJoho);
    }

    @JsonIgnore
    public pnlShinseishaJohoDiv getPnlShinseishaJoho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho();
    }

    @JsonIgnore
    public void  setPnlShinseishaJoho(pnlShinseishaJohoDiv pnlShinseishaJoho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().setPnlShinseishaJoho(pnlShinseishaJoho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtJohoAtenaMeisho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoAtenaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaMeisho(TextBoxAtenaMeisho txtJohoAtenaMeisho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoAtenaMeisho(txtJohoAtenaMeisho);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtJohoAtenaKanaMeisho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoAtenaKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaKanaMeisho(TextBoxAtenaKanaMeisho txtJohoAtenaKanaMeisho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoAtenaKanaMeisho(txtJohoAtenaKanaMeisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtJohoBirthday() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoBirthday();
    }

    @JsonIgnore
    public void  setTxtJohoBirthday(TextBoxDate txtJohoBirthday) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoBirthday(txtJohoBirthday);
    }

    @JsonIgnore
    public RadioButton getRadJohoSeibetsu() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getRadJohoSeibetsu();
    }

    @JsonIgnore
    public void  setRadJohoSeibetsu(RadioButton radJohoSeibetsu) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setRadJohoSeibetsu(radJohoSeibetsu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJohoYubinNo() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoYubinNo();
    }

    @JsonIgnore
    public void  setTxtJohoYubinNo(TextBoxYubinNo txtJohoYubinNo) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoYubinNo(txtJohoYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJohoJusho() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoJusho();
    }

    @JsonIgnore
    public void  setTxtJohoJusho(TextBoxJusho txtJohoJusho) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoJusho(txtJohoJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJohoTelNo() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoTelNo();
    }

    @JsonIgnore
    public void  setTxtJohoTelNo(TextBoxTelNo txtJohoTelNo) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoTelNo(txtJohoTelNo);
    }

    @JsonIgnore
    public TextBox getTxtJohoNenrei() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getTxtJohoNenrei();
    }

    @JsonIgnore
    public void  setTxtJohoNenrei(TextBox txtJohoNenrei) {
        this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().setTxtJohoNenrei(txtJohoNenrei);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShozokuShichoson() {
        return this.getPnlNinteiShinseiDetail().getTabShinseishaJoho().getTplShinseishaJoho().getPnlShinseishaJoho().getCcdShozokuShichoson();
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return this.getPnlKanryoMessage().getCcdKanryoMessage();
    }

    // </editor-fold>
}
