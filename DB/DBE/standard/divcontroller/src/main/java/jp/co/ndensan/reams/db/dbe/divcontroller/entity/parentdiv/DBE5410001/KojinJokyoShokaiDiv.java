package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KojinJokyoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KojinJokyoShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-20_05-03-35">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnChosaKekkaInfoGaikyo")
    private ButtonDialog btnChosaKekkaInfoGaikyo;
    @JsonProperty("btnChosaKekkaInfoKihon")
    private ButtonDialog btnChosaKekkaInfoKihon;
    @JsonProperty("btnShujiiIkenshoShokai")
    private ButtonDialog btnShujiiIkenshoShokai;
    @JsonProperty("btnOtherFile")
    private ButtonDialog btnOtherFile;
    @JsonProperty("btnShinsakaiJoho")
    private ButtonDialog btnShinsakaiJoho;
    @JsonProperty("tblKanryoJisseki")
    private tblKanryoJissekiDiv tblKanryoJisseki;
    @JsonProperty("KojinShinchokuShosai")
    private KojinShinchokuShosaiDiv KojinShinchokuShosai;
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    private ShujiiIryokikaknAndShujiiInputDiv ShujiiIryokikaknAndShujiiInput;
    @JsonProperty("ChosaItakusakiAndChosainGuide")
    private ChosaItakusakiAndChosainGuideDiv ChosaItakusakiAndChosainGuide;
    @JsonProperty("ShinseiTorisage")
    private ShinseiTorisageDiv ShinseiTorisage;
    @JsonProperty("btnShinseiInfoshokai")
    private Button btnShinseiInfoshokai;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;
    @JsonProperty("hdnHokenshaCode")
    private RString hdnHokenshaCode;
    @JsonProperty("NinteiShinseiBusinessCollection")
    private RString NinteiShinseiBusinessCollection;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnRenrakusakiJoho")
    private RString hdnRenrakusakiJoho;
    @JsonProperty("hdnRenrakusakiReadOnly")
    private RString hdnRenrakusakiReadOnly;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;
    @JsonProperty("hdnShokisaiHokenshaNo")
    private RString hdnShokisaiHokenshaNo;
    @JsonProperty("hdnNinteiChosaRirekiNo")
    private RString hdnNinteiChosaRirekiNo;
    @JsonProperty("hdnNinteiChosaTokkijikoNo")
    private RString hdnNinteiChosaTokkijikoNo;
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    private RString hdnGaikyoChosaTextImageKubun;
    @JsonProperty("hdnShinsakaiKaisaiNo")
    private RString hdnShinsakaiKaisaiNo;
    @JsonProperty("hdnIkenshoIraiRirekiNo")
    private RString hdnIkenshoIraiRirekiNo;
    @JsonProperty("hdnHanteiModeType")
    private RString hdnHanteiModeType;
    @JsonProperty("hdnHanteiArgument")
    private RString hdnHanteiArgument;
    @JsonProperty("hdnIchijiHanteiKekka")
    private RString hdnIchijiHanteiKekka;
    @JsonProperty("hdnImageLocalCopyPath")
    private RString hdnImageLocalCopyPath;
    @JsonProperty("hdnShujiiIryoKikanCode")
    private RString hdnShujiiIryoKikanCode;
    @JsonProperty("hdnShujiiIryoKikanName")
    private RString hdnShujiiIryoKikanName;
    @JsonProperty("hdnShujiiCode")
    private RString hdnShujiiCode;
    @JsonProperty("hdnShujiiName")
    private RString hdnShujiiName;
    @JsonProperty("hdnChosaItakusakiCode")
    private RString hdnChosaItakusakiCode;
    @JsonProperty("hdnChosaItakusakiName")
    private RString hdnChosaItakusakiName;
    @JsonProperty("hdnNinteiChosainCode")
    private RString hdnNinteiChosainCode;
    @JsonProperty("hdnNinteiChosainName")
    private RString hdnNinteiChosainName;
    @JsonProperty("hdnNinteiShinseibi")
    private RString hdnNinteiShinseibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
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
     * getbtnChosaKekkaInfoGaikyo
     * @return btnChosaKekkaInfoGaikyo
     */
    @JsonProperty("btnChosaKekkaInfoGaikyo")
    public ButtonDialog getBtnChosaKekkaInfoGaikyo() {
        return btnChosaKekkaInfoGaikyo;
    }

    /*
     * setbtnChosaKekkaInfoGaikyo
     * @param btnChosaKekkaInfoGaikyo btnChosaKekkaInfoGaikyo
     */
    @JsonProperty("btnChosaKekkaInfoGaikyo")
    public void setBtnChosaKekkaInfoGaikyo(ButtonDialog btnChosaKekkaInfoGaikyo) {
        this.btnChosaKekkaInfoGaikyo = btnChosaKekkaInfoGaikyo;
    }

    /*
     * getbtnChosaKekkaInfoKihon
     * @return btnChosaKekkaInfoKihon
     */
    @JsonProperty("btnChosaKekkaInfoKihon")
    public ButtonDialog getBtnChosaKekkaInfoKihon() {
        return btnChosaKekkaInfoKihon;
    }

    /*
     * setbtnChosaKekkaInfoKihon
     * @param btnChosaKekkaInfoKihon btnChosaKekkaInfoKihon
     */
    @JsonProperty("btnChosaKekkaInfoKihon")
    public void setBtnChosaKekkaInfoKihon(ButtonDialog btnChosaKekkaInfoKihon) {
        this.btnChosaKekkaInfoKihon = btnChosaKekkaInfoKihon;
    }

    /*
     * getbtnShujiiIkenshoShokai
     * @return btnShujiiIkenshoShokai
     */
    @JsonProperty("btnShujiiIkenshoShokai")
    public ButtonDialog getBtnShujiiIkenshoShokai() {
        return btnShujiiIkenshoShokai;
    }

    /*
     * setbtnShujiiIkenshoShokai
     * @param btnShujiiIkenshoShokai btnShujiiIkenshoShokai
     */
    @JsonProperty("btnShujiiIkenshoShokai")
    public void setBtnShujiiIkenshoShokai(ButtonDialog btnShujiiIkenshoShokai) {
        this.btnShujiiIkenshoShokai = btnShujiiIkenshoShokai;
    }

    /*
     * getbtnOtherFile
     * @return btnOtherFile
     */
    @JsonProperty("btnOtherFile")
    public ButtonDialog getBtnOtherFile() {
        return btnOtherFile;
    }

    /*
     * setbtnOtherFile
     * @param btnOtherFile btnOtherFile
     */
    @JsonProperty("btnOtherFile")
    public void setBtnOtherFile(ButtonDialog btnOtherFile) {
        this.btnOtherFile = btnOtherFile;
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
     * getShinseiTorisage
     * @return ShinseiTorisage
     */
    @JsonProperty("ShinseiTorisage")
    public ShinseiTorisageDiv getShinseiTorisage() {
        return ShinseiTorisage;
    }

    /*
     * setShinseiTorisage
     * @param ShinseiTorisage ShinseiTorisage
     */
    @JsonProperty("ShinseiTorisage")
    public void setShinseiTorisage(ShinseiTorisageDiv ShinseiTorisage) {
        this.ShinseiTorisage = ShinseiTorisage;
    }

    /*
     * getbtnShinseiInfoshokai
     * @return btnShinseiInfoshokai
     */
    @JsonProperty("btnShinseiInfoshokai")
    public Button getBtnShinseiInfoshokai() {
        return btnShinseiInfoshokai;
    }

    /*
     * setbtnShinseiInfoshokai
     * @param btnShinseiInfoshokai btnShinseiInfoshokai
     */
    @JsonProperty("btnShinseiInfoshokai")
    public void setBtnShinseiInfoshokai(Button btnShinseiInfoshokai) {
        this.btnShinseiInfoshokai = btnShinseiInfoshokai;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
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
     * getNinteiShinseiBusinessCollection
     * @return NinteiShinseiBusinessCollection
     */
    @JsonProperty("NinteiShinseiBusinessCollection")
    public RString getNinteiShinseiBusinessCollection() {
        return NinteiShinseiBusinessCollection;
    }

    /*
     * setNinteiShinseiBusinessCollection
     * @param NinteiShinseiBusinessCollection NinteiShinseiBusinessCollection
     */
    @JsonProperty("NinteiShinseiBusinessCollection")
    public void setNinteiShinseiBusinessCollection(RString NinteiShinseiBusinessCollection) {
        this.NinteiShinseiBusinessCollection = NinteiShinseiBusinessCollection;
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
     * gethdnShokisaiHokenshaNo
     * @return hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public RString getHdnShokisaiHokenshaNo() {
        return hdnShokisaiHokenshaNo;
    }

    /*
     * sethdnShokisaiHokenshaNo
     * @param hdnShokisaiHokenshaNo hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public void setHdnShokisaiHokenshaNo(RString hdnShokisaiHokenshaNo) {
        this.hdnShokisaiHokenshaNo = hdnShokisaiHokenshaNo;
    }

    /*
     * gethdnNinteiChosaRirekiNo
     * @return hdnNinteiChosaRirekiNo
     */
    @JsonProperty("hdnNinteiChosaRirekiNo")
    public RString getHdnNinteiChosaRirekiNo() {
        return hdnNinteiChosaRirekiNo;
    }

    /*
     * sethdnNinteiChosaRirekiNo
     * @param hdnNinteiChosaRirekiNo hdnNinteiChosaRirekiNo
     */
    @JsonProperty("hdnNinteiChosaRirekiNo")
    public void setHdnNinteiChosaRirekiNo(RString hdnNinteiChosaRirekiNo) {
        this.hdnNinteiChosaRirekiNo = hdnNinteiChosaRirekiNo;
    }

    /*
     * gethdnNinteiChosaTokkijikoNo
     * @return hdnNinteiChosaTokkijikoNo
     */
    @JsonProperty("hdnNinteiChosaTokkijikoNo")
    public RString getHdnNinteiChosaTokkijikoNo() {
        return hdnNinteiChosaTokkijikoNo;
    }

    /*
     * sethdnNinteiChosaTokkijikoNo
     * @param hdnNinteiChosaTokkijikoNo hdnNinteiChosaTokkijikoNo
     */
    @JsonProperty("hdnNinteiChosaTokkijikoNo")
    public void setHdnNinteiChosaTokkijikoNo(RString hdnNinteiChosaTokkijikoNo) {
        this.hdnNinteiChosaTokkijikoNo = hdnNinteiChosaTokkijikoNo;
    }

    /*
     * gethdnGaikyoChosaTextImageKubun
     * @return hdnGaikyoChosaTextImageKubun
     */
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    public RString getHdnGaikyoChosaTextImageKubun() {
        return hdnGaikyoChosaTextImageKubun;
    }

    /*
     * sethdnGaikyoChosaTextImageKubun
     * @param hdnGaikyoChosaTextImageKubun hdnGaikyoChosaTextImageKubun
     */
    @JsonProperty("hdnGaikyoChosaTextImageKubun")
    public void setHdnGaikyoChosaTextImageKubun(RString hdnGaikyoChosaTextImageKubun) {
        this.hdnGaikyoChosaTextImageKubun = hdnGaikyoChosaTextImageKubun;
    }

    /*
     * gethdnShinsakaiKaisaiNo
     * @return hdnShinsakaiKaisaiNo
     */
    @JsonProperty("hdnShinsakaiKaisaiNo")
    public RString getHdnShinsakaiKaisaiNo() {
        return hdnShinsakaiKaisaiNo;
    }

    /*
     * sethdnShinsakaiKaisaiNo
     * @param hdnShinsakaiKaisaiNo hdnShinsakaiKaisaiNo
     */
    @JsonProperty("hdnShinsakaiKaisaiNo")
    public void setHdnShinsakaiKaisaiNo(RString hdnShinsakaiKaisaiNo) {
        this.hdnShinsakaiKaisaiNo = hdnShinsakaiKaisaiNo;
    }

    /*
     * gethdnIkenshoIraiRirekiNo
     * @return hdnIkenshoIraiRirekiNo
     */
    @JsonProperty("hdnIkenshoIraiRirekiNo")
    public RString getHdnIkenshoIraiRirekiNo() {
        return hdnIkenshoIraiRirekiNo;
    }

    /*
     * sethdnIkenshoIraiRirekiNo
     * @param hdnIkenshoIraiRirekiNo hdnIkenshoIraiRirekiNo
     */
    @JsonProperty("hdnIkenshoIraiRirekiNo")
    public void setHdnIkenshoIraiRirekiNo(RString hdnIkenshoIraiRirekiNo) {
        this.hdnIkenshoIraiRirekiNo = hdnIkenshoIraiRirekiNo;
    }

    /*
     * gethdnHanteiModeType
     * @return hdnHanteiModeType
     */
    @JsonProperty("hdnHanteiModeType")
    public RString getHdnHanteiModeType() {
        return hdnHanteiModeType;
    }

    /*
     * sethdnHanteiModeType
     * @param hdnHanteiModeType hdnHanteiModeType
     */
    @JsonProperty("hdnHanteiModeType")
    public void setHdnHanteiModeType(RString hdnHanteiModeType) {
        this.hdnHanteiModeType = hdnHanteiModeType;
    }

    /*
     * gethdnHanteiArgument
     * @return hdnHanteiArgument
     */
    @JsonProperty("hdnHanteiArgument")
    public RString getHdnHanteiArgument() {
        return hdnHanteiArgument;
    }

    /*
     * sethdnHanteiArgument
     * @param hdnHanteiArgument hdnHanteiArgument
     */
    @JsonProperty("hdnHanteiArgument")
    public void setHdnHanteiArgument(RString hdnHanteiArgument) {
        this.hdnHanteiArgument = hdnHanteiArgument;
    }

    /*
     * gethdnIchijiHanteiKekka
     * @return hdnIchijiHanteiKekka
     */
    @JsonProperty("hdnIchijiHanteiKekka")
    public RString getHdnIchijiHanteiKekka() {
        return hdnIchijiHanteiKekka;
    }

    /*
     * sethdnIchijiHanteiKekka
     * @param hdnIchijiHanteiKekka hdnIchijiHanteiKekka
     */
    @JsonProperty("hdnIchijiHanteiKekka")
    public void setHdnIchijiHanteiKekka(RString hdnIchijiHanteiKekka) {
        this.hdnIchijiHanteiKekka = hdnIchijiHanteiKekka;
    }

    /*
     * gethdnImageLocalCopyPath
     * @return hdnImageLocalCopyPath
     */
    @JsonProperty("hdnImageLocalCopyPath")
    public RString getHdnImageLocalCopyPath() {
        return hdnImageLocalCopyPath;
    }

    /*
     * sethdnImageLocalCopyPath
     * @param hdnImageLocalCopyPath hdnImageLocalCopyPath
     */
    @JsonProperty("hdnImageLocalCopyPath")
    public void setHdnImageLocalCopyPath(RString hdnImageLocalCopyPath) {
        this.hdnImageLocalCopyPath = hdnImageLocalCopyPath;
    }

    /*
     * gethdnShujiiIryoKikanCode
     * @return hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public RString getHdnShujiiIryoKikanCode() {
        return hdnShujiiIryoKikanCode;
    }

    /*
     * sethdnShujiiIryoKikanCode
     * @param hdnShujiiIryoKikanCode hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public void setHdnShujiiIryoKikanCode(RString hdnShujiiIryoKikanCode) {
        this.hdnShujiiIryoKikanCode = hdnShujiiIryoKikanCode;
    }

    /*
     * gethdnShujiiIryoKikanName
     * @return hdnShujiiIryoKikanName
     */
    @JsonProperty("hdnShujiiIryoKikanName")
    public RString getHdnShujiiIryoKikanName() {
        return hdnShujiiIryoKikanName;
    }

    /*
     * sethdnShujiiIryoKikanName
     * @param hdnShujiiIryoKikanName hdnShujiiIryoKikanName
     */
    @JsonProperty("hdnShujiiIryoKikanName")
    public void setHdnShujiiIryoKikanName(RString hdnShujiiIryoKikanName) {
        this.hdnShujiiIryoKikanName = hdnShujiiIryoKikanName;
    }

    /*
     * gethdnShujiiCode
     * @return hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public RString getHdnShujiiCode() {
        return hdnShujiiCode;
    }

    /*
     * sethdnShujiiCode
     * @param hdnShujiiCode hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public void setHdnShujiiCode(RString hdnShujiiCode) {
        this.hdnShujiiCode = hdnShujiiCode;
    }

    /*
     * gethdnShujiiName
     * @return hdnShujiiName
     */
    @JsonProperty("hdnShujiiName")
    public RString getHdnShujiiName() {
        return hdnShujiiName;
    }

    /*
     * sethdnShujiiName
     * @param hdnShujiiName hdnShujiiName
     */
    @JsonProperty("hdnShujiiName")
    public void setHdnShujiiName(RString hdnShujiiName) {
        this.hdnShujiiName = hdnShujiiName;
    }

    /*
     * gethdnChosaItakusakiCode
     * @return hdnChosaItakusakiCode
     */
    @JsonProperty("hdnChosaItakusakiCode")
    public RString getHdnChosaItakusakiCode() {
        return hdnChosaItakusakiCode;
    }

    /*
     * sethdnChosaItakusakiCode
     * @param hdnChosaItakusakiCode hdnChosaItakusakiCode
     */
    @JsonProperty("hdnChosaItakusakiCode")
    public void setHdnChosaItakusakiCode(RString hdnChosaItakusakiCode) {
        this.hdnChosaItakusakiCode = hdnChosaItakusakiCode;
    }

    /*
     * gethdnChosaItakusakiName
     * @return hdnChosaItakusakiName
     */
    @JsonProperty("hdnChosaItakusakiName")
    public RString getHdnChosaItakusakiName() {
        return hdnChosaItakusakiName;
    }

    /*
     * sethdnChosaItakusakiName
     * @param hdnChosaItakusakiName hdnChosaItakusakiName
     */
    @JsonProperty("hdnChosaItakusakiName")
    public void setHdnChosaItakusakiName(RString hdnChosaItakusakiName) {
        this.hdnChosaItakusakiName = hdnChosaItakusakiName;
    }

    /*
     * gethdnNinteiChosainCode
     * @return hdnNinteiChosainCode
     */
    @JsonProperty("hdnNinteiChosainCode")
    public RString getHdnNinteiChosainCode() {
        return hdnNinteiChosainCode;
    }

    /*
     * sethdnNinteiChosainCode
     * @param hdnNinteiChosainCode hdnNinteiChosainCode
     */
    @JsonProperty("hdnNinteiChosainCode")
    public void setHdnNinteiChosainCode(RString hdnNinteiChosainCode) {
        this.hdnNinteiChosainCode = hdnNinteiChosainCode;
    }

    /*
     * gethdnNinteiChosainName
     * @return hdnNinteiChosainName
     */
    @JsonProperty("hdnNinteiChosainName")
    public RString getHdnNinteiChosainName() {
        return hdnNinteiChosainName;
    }

    /*
     * sethdnNinteiChosainName
     * @param hdnNinteiChosainName hdnNinteiChosainName
     */
    @JsonProperty("hdnNinteiChosainName")
    public void setHdnNinteiChosainName(RString hdnNinteiChosainName) {
        this.hdnNinteiChosainName = hdnNinteiChosainName;
    }

    /*
     * gethdnNinteiShinseibi
     * @return hdnNinteiShinseibi
     */
    @JsonProperty("hdnNinteiShinseibi")
    public RString getHdnNinteiShinseibi() {
        return hdnNinteiShinseibi;
    }

    /*
     * sethdnNinteiShinseibi
     * @param hdnNinteiShinseibi hdnNinteiShinseibi
     */
    @JsonProperty("hdnNinteiShinseibi")
    public void setHdnNinteiShinseibi(RString hdnNinteiShinseibi) {
        this.hdnNinteiShinseibi = hdnNinteiShinseibi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNinteiShinsakai() {
        return this.getTblKanryoJisseki().getLblNinteiShinsakai();
    }

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
    public Label getLblCenterSoshin() {
        return this.getTblKanryoJisseki().getLblCenterSoshin();
    }

    @JsonIgnore
    public Label getLblKanryoYotei() {
        return this.getTblKanryoJisseki().getLblKanryoYotei();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiShinsakaiYoteiDate() {
        return this.getTblKanryoJisseki().getTxtNinteiShinsakaiYoteiDate();
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
    public TextBoxDate getTxtCenterSoshinYoteiDate() {
        return this.getTblKanryoJisseki().getTxtCenterSoshinYoteiDate();
    }

    @JsonIgnore
    public Label getLblKanryoJisseki() {
        return this.getTblKanryoJisseki().getLblKanryoJisseki();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiShinsakaiJissekiDate() {
        return this.getTblKanryoJisseki().getTxtNinteiShinsakaiJissekiDate();
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
    public TextBoxDate getTxtCenterSoshinJissekiDate() {
        return this.getTblKanryoJisseki().getTxtCenterSoshinJissekiDate();
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
    public TextBox getTxtShinseiShubetsu() {
        return this.getKojinShinchokuShosai().getTxtShinseiShubetsu();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu(TextBox txtShinseiShubetsu) {
        this.getKojinShinchokuShosai().setTxtShinseiShubetsu(txtShinseiShubetsu);
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
    public TextBox getTxtIchijiHantei() {
        return this.getKojinShinchokuShosai().getTxtIchijiHantei();
    }

    @JsonIgnore
    public void  setTxtIchijiHantei(TextBox txtIchijiHantei) {
        this.getKojinShinchokuShosai().setTxtIchijiHantei(txtIchijiHantei);
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYMD() {
        return this.getKojinShinchokuShosai().getTxtIchijiHanteiYMD();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiYMD(TextBoxDate txtIchijiHanteiYMD) {
        this.getKojinShinchokuShosai().setTxtIchijiHanteiYMD(txtIchijiHanteiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtIchijiHanteiKeikokuCode() {
        return this.getKojinShinchokuShosai().getTxtIchijiHanteiKeikokuCode();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiKeikokuCode(TextBoxCode txtIchijiHanteiKeikokuCode) {
        this.getKojinShinchokuShosai().setTxtIchijiHanteiKeikokuCode(txtIchijiHanteiKeikokuCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchijiHanteiShokai() {
        return this.getKojinShinchokuShosai().getBtnIchijiHanteiShokai();
    }

    @JsonIgnore
    public void  setBtnIchijiHanteiShokai(ButtonDialog btnIchijiHanteiShokai) {
        this.getKojinShinchokuShosai().setBtnIchijiHanteiShokai(btnIchijiHanteiShokai);
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
    public TextBoxDate getTxtNijiHanteiYMD() {
        return this.getKojinShinchokuShosai().getTxtNijiHanteiYMD();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiYMD(TextBoxDate txtNijiHanteiYMD) {
        this.getKojinShinchokuShosai().setTxtNijiHanteiYMD(txtNijiHanteiYMD);
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
    public TextBox getTxtShoriKubun() {
        return this.getKojinShinchokuShosai().getTxtShoriKubun();
    }

    @JsonIgnore
    public void  setTxtShoriKubun(TextBox txtShoriKubun) {
        this.getKojinShinchokuShosai().setTxtShoriKubun(txtShoriKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiIryoKikanCode(txtShujiiIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanName() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiIryoKikanName(txtShujiiIryoKikanName);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public CheckBoxList getChkShiteii() {
        return this.getShujiiIryokikaknAndShujiiInput().getChkShiteii();
    }

    @JsonIgnore
    public void  setChkShiteii(CheckBoxList chkShiteii) {
        this.getShujiiIryokikaknAndShujiiInput().setChkShiteii(chkShiteii);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIkenshoIraiDate() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtIkenshoIraiDate();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiDate(TextBoxFlexibleDate txtIkenshoIraiDate) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtIkenshoIraiDate(txtIkenshoIraiDate);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiIkenshoSakuseiIraiShokai() {
        return this.getShujiiIryokikaknAndShujiiInput().getBtnShujiiIkenshoSakuseiIraiShokai();
    }

    @JsonIgnore
    public void  setBtnShujiiIkenshoSakuseiIraiShokai(ButtonDialog btnShujiiIkenshoSakuseiIraiShokai) {
        this.getShujiiIryokikaknAndShujiiInput().setBtnShujiiIkenshoSakuseiIraiShokai(btnShujiiIkenshoSakuseiIraiShokai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaItakusakiCode() {
        return this.getChosaItakusakiAndChosainGuide().getTxtChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.getChosaItakusakiAndChosainGuide().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiName() {
        return this.getChosaItakusakiAndChosainGuide().getTxtChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.getChosaItakusakiAndChosainGuide().setTxtChosaItakusakiName(txtChosaItakusakiName);
    }

    @JsonIgnore
    public TextBoxCode getTxtNinteiChosainCode() {
        return this.getChosaItakusakiAndChosainGuide().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.getChosaItakusakiAndChosainGuide().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getChosaItakusakiAndChosainGuide().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getChosaItakusakiAndChosainGuide().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtChosaIraiDate() {
        return this.getChosaItakusakiAndChosainGuide().getTxtChosaIraiDate();
    }

    @JsonIgnore
    public void  setTxtChosaIraiDate(TextBoxFlexibleDate txtChosaIraiDate) {
        this.getChosaItakusakiAndChosainGuide().setTxtChosaIraiDate(txtChosaIraiDate);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosaIraiShokai() {
        return this.getChosaItakusakiAndChosainGuide().getBtnNinteiChosaIraiShokai();
    }

    @JsonIgnore
    public void  setBtnNinteiChosaIraiShokai(ButtonDialog btnNinteiChosaIraiShokai) {
        this.getChosaItakusakiAndChosainGuide().setBtnNinteiChosaIraiShokai(btnNinteiChosaIraiShokai);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyuCode() {
        return this.getShinseiTorisage().getTxtTorisageJiyuCode();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyuCode(TextBox txtTorisageJiyuCode) {
        this.getShinseiTorisage().setTxtTorisageJiyuCode(txtTorisageJiyuCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTorisageDate() {
        return this.getShinseiTorisage().getTxtTorisageDate();
    }

    @JsonIgnore
    public void  setTxtTorisageDate(TextBoxFlexibleDate txtTorisageDate) {
        this.getShinseiTorisage().setTxtTorisageDate(txtTorisageDate);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyu() {
        return this.getShinseiTorisage().getTxtTorisageJiyu();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.getShinseiTorisage().setTxtTorisageJiyu(txtTorisageJiyu);
    }

    // </editor-fold>
}
