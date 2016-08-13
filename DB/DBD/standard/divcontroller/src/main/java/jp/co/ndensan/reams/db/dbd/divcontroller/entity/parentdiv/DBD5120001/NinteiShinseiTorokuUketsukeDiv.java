package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinseiTorokuUketsuke のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiShinseiTorokuUketsukeDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenGuide")
    private ButtonDialog btnIryohokenGuide;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    private ButtonDialog btnNyuinAndShisetsuNyusho;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnTainoJokyo")
    private ButtonDialog btnTainoJokyo;
    @JsonProperty("tabShinseishaJoho")
    private tabShinseishaJohoDiv tabShinseishaJoho;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;
    @JsonProperty("hdnIryohokenJoho")
    private RString hdnIryohokenJoho;
    @JsonProperty("hdnRenrakusakiJoho")
    private RString hdnRenrakusakiJoho;
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    private RString hdnZenkaiRenrakusakiJoho;
    @JsonProperty("hdnRenrakusakiReadOnly")
    private RString hdnRenrakusakiReadOnly;
    @JsonProperty("hdnNyutaishoJoho")
    private RString hdnNyutaishoJoho;
    @JsonProperty("hdnChosaJokyo")
    private RString hdnChosaJokyo;
    @JsonProperty("hdnTainoJokyo")
    private RString hdnTainoJokyo;
    @JsonProperty("hdnRenban")
    private RString hdnRenban;
    @JsonProperty("hdnShichosonRenrakuJiko")
    private RString hdnShichosonRenrakuJiko;
    @JsonProperty("hdnShinsakaiIraiYMD")
    private RString hdnShinsakaiIraiYMD;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdn登録業務コード")
    private RString hdn登録業務コード;
    @JsonProperty("hdn登録グループコード")
    private RString hdn登録グループコード;
    @JsonProperty("hdnサンプル文書")
    private RString hdnサンプル文書;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
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
     * gethdnIryohokenJoho
     * @return hdnIryohokenJoho
     */
    @JsonProperty("hdnIryohokenJoho")
    public RString getHdnIryohokenJoho() {
        return hdnIryohokenJoho;
    }

    /*
     * sethdnIryohokenJoho
     * @param hdnIryohokenJoho hdnIryohokenJoho
     */
    @JsonProperty("hdnIryohokenJoho")
    public void setHdnIryohokenJoho(RString hdnIryohokenJoho) {
        this.hdnIryohokenJoho = hdnIryohokenJoho;
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
     * gethdnNyutaishoJoho
     * @return hdnNyutaishoJoho
     */
    @JsonProperty("hdnNyutaishoJoho")
    public RString getHdnNyutaishoJoho() {
        return hdnNyutaishoJoho;
    }

    /*
     * sethdnNyutaishoJoho
     * @param hdnNyutaishoJoho hdnNyutaishoJoho
     */
    @JsonProperty("hdnNyutaishoJoho")
    public void setHdnNyutaishoJoho(RString hdnNyutaishoJoho) {
        this.hdnNyutaishoJoho = hdnNyutaishoJoho;
    }

    /*
     * gethdnChosaJokyo
     * @return hdnChosaJokyo
     */
    @JsonProperty("hdnChosaJokyo")
    public RString getHdnChosaJokyo() {
        return hdnChosaJokyo;
    }

    /*
     * sethdnChosaJokyo
     * @param hdnChosaJokyo hdnChosaJokyo
     */
    @JsonProperty("hdnChosaJokyo")
    public void setHdnChosaJokyo(RString hdnChosaJokyo) {
        this.hdnChosaJokyo = hdnChosaJokyo;
    }

    /*
     * gethdnTainoJokyo
     * @return hdnTainoJokyo
     */
    @JsonProperty("hdnTainoJokyo")
    public RString getHdnTainoJokyo() {
        return hdnTainoJokyo;
    }

    /*
     * sethdnTainoJokyo
     * @param hdnTainoJokyo hdnTainoJokyo
     */
    @JsonProperty("hdnTainoJokyo")
    public void setHdnTainoJokyo(RString hdnTainoJokyo) {
        this.hdnTainoJokyo = hdnTainoJokyo;
    }

    /*
     * gethdnRenban
     * @return hdnRenban
     */
    @JsonProperty("hdnRenban")
    public RString getHdnRenban() {
        return hdnRenban;
    }

    /*
     * sethdnRenban
     * @param hdnRenban hdnRenban
     */
    @JsonProperty("hdnRenban")
    public void setHdnRenban(RString hdnRenban) {
        this.hdnRenban = hdnRenban;
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
     * gethdnShinsakaiIraiYMD
     * @return hdnShinsakaiIraiYMD
     */
    @JsonProperty("hdnShinsakaiIraiYMD")
    public RString getHdnShinsakaiIraiYMD() {
        return hdnShinsakaiIraiYMD;
    }

    /*
     * sethdnShinsakaiIraiYMD
     * @param hdnShinsakaiIraiYMD hdnShinsakaiIraiYMD
     */
    @JsonProperty("hdnShinsakaiIraiYMD")
    public void setHdnShinsakaiIraiYMD(RString hdnShinsakaiIraiYMD) {
        this.hdnShinsakaiIraiYMD = hdnShinsakaiIraiYMD;
    }

    /*
     * gethdnHihokenshaNo
     * @return hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    /*
     * sethdnHihokenshaNo
     * @param hdnHihokenshaNo hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo = hdnHihokenshaNo;
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
     * gethdn登録業務コード
     * @return hdn登録業務コード
     */
    @JsonProperty("hdn登録業務コード")
    public RString getHdn登録業務コード() {
        return hdn登録業務コード;
    }

    /*
     * sethdn登録業務コード
     * @param hdn登録業務コード hdn登録業務コード
     */
    @JsonProperty("hdn登録業務コード")
    public void setHdn登録業務コード(RString hdn登録業務コード) {
        this.hdn登録業務コード = hdn登録業務コード;
    }

    /*
     * gethdn登録グループコード
     * @return hdn登録グループコード
     */
    @JsonProperty("hdn登録グループコード")
    public RString getHdn登録グループコード() {
        return hdn登録グループコード;
    }

    /*
     * sethdn登録グループコード
     * @param hdn登録グループコード hdn登録グループコード
     */
    @JsonProperty("hdn登録グループコード")
    public void setHdn登録グループコード(RString hdn登録グループコード) {
        this.hdn登録グループコード = hdn登録グループコード;
    }

    /*
     * gethdnサンプル文書
     * @return hdnサンプル文書
     */
    @JsonProperty("hdnサンプル文書")
    public RString getHdnサンプル文書() {
        return hdnサンプル文書;
    }

    /*
     * sethdnサンプル文書
     * @param hdnサンプル文書 hdnサンプル文書
     */
    @JsonProperty("hdnサンプル文書")
    public void setHdnサンプル文書(RString hdnサンプル文書) {
        this.hdnサンプル文書 = hdnサンプル文書;
    }

    /*
     * [ ショートカットの作成 ]
     */
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
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput().getCcdChosaItakusakiAndChosainInput();
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
    public TextBoxFlexibleDate getTxtEnkiKetteiYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void setTxtEnkiKetteiYMD(TextBoxFlexibleDate txtEnkiKetteiYMD) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiMikomiKikanFrom() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiMikomiKikanFrom();
    }

    @JsonIgnore
    public void setTxtEnkiMikomiKikanFrom(TextBoxFlexibleDate txtEnkiMikomiKikanFrom) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiMikomiKikanFrom(txtEnkiMikomiKikanFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiMikomiKikanTo() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiMikomiKikanTo();
    }

    @JsonIgnore
    public void setTxtEnkiMikomiKikanTo(TextBoxFlexibleDate txtEnkiMikomiKikanTo) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiMikomiKikanTo(txtEnkiMikomiKikanTo);
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
    public TextBoxFlexibleDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtEnkiTsuchiHakkoYMD(TextBoxFlexibleDate txtEnkiTsuchiHakkoYMD) {
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
