package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NinteiChosaJokyo のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaJokyoDiv extends Panel implements INinteiChosaJokyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("HomonChosasaki")
    private HomonChosasakiDiv HomonChosasaki;
    @JsonProperty("ShujiiAndShujiIryoKikan")
    private ShujiiAndShujiIryoKikanDiv ShujiiAndShujiIryoKikan;
    @JsonProperty("IchijiHantei")
    private IchijiHanteiDiv IchijiHantei;
    @JsonProperty("KaigoNinteiShinsakai")
    private KaigoNinteiShinsakaiDiv KaigoNinteiShinsakai;
    @JsonProperty("EnkiTsuchi")
    private EnkiTsuchiDiv EnkiTsuchi;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnAllClear")
    private Button btnAllClear;
    @JsonProperty("hdnDisplayModeKey")
    private RString hdnDisplayModeKey;
    @JsonProperty("hdnSerializedBusiness_Konkai")
    private RString hdnSerializedBusiness_Konkai;
    @JsonProperty("hdnSerializedBusiness_Zenkai")
    private RString hdnSerializedBusiness_Zenkai;
    @JsonProperty("hdnChosaDataPass")
    private RString hdnChosaDataPass;
    @JsonProperty("hdnShujiiDataPass")
    private RString hdnShujiiDataPass;
    @JsonProperty("hdnSubGyomuCd")
    private RString hdnSubGyomuCd;
    @JsonProperty("hdnInput")
    private RString hdnInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getHomonChosasaki
     * @return HomonChosasaki
     */
    @JsonProperty("HomonChosasaki")
    public HomonChosasakiDiv getHomonChosasaki() {
        return HomonChosasaki;
    }

    /*
     * setHomonChosasaki
     * @param HomonChosasaki HomonChosasaki
     */
    @JsonProperty("HomonChosasaki")
    public void setHomonChosasaki(HomonChosasakiDiv HomonChosasaki) {
        this.HomonChosasaki = HomonChosasaki;
    }

    /*
     * getShujiiAndShujiIryoKikan
     * @return ShujiiAndShujiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiIryoKikan")
    public ShujiiAndShujiIryoKikanDiv getShujiiAndShujiIryoKikan() {
        return ShujiiAndShujiIryoKikan;
    }

    /*
     * setShujiiAndShujiIryoKikan
     * @param ShujiiAndShujiIryoKikan ShujiiAndShujiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiIryoKikan")
    public void setShujiiAndShujiIryoKikan(ShujiiAndShujiIryoKikanDiv ShujiiAndShujiIryoKikan) {
        this.ShujiiAndShujiIryoKikan = ShujiiAndShujiIryoKikan;
    }

    /*
     * getIchijiHantei
     * @return IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public IchijiHanteiDiv getIchijiHantei() {
        return IchijiHantei;
    }

    /*
     * setIchijiHantei
     * @param IchijiHantei IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.IchijiHantei = IchijiHantei;
    }

    /*
     * getKaigoNinteiShinsakai
     * @return KaigoNinteiShinsakai
     */
    @JsonProperty("KaigoNinteiShinsakai")
    public KaigoNinteiShinsakaiDiv getKaigoNinteiShinsakai() {
        return KaigoNinteiShinsakai;
    }

    /*
     * setKaigoNinteiShinsakai
     * @param KaigoNinteiShinsakai KaigoNinteiShinsakai
     */
    @JsonProperty("KaigoNinteiShinsakai")
    public void setKaigoNinteiShinsakai(KaigoNinteiShinsakaiDiv KaigoNinteiShinsakai) {
        this.KaigoNinteiShinsakai = KaigoNinteiShinsakai;
    }

    /*
     * getEnkiTsuchi
     * @return EnkiTsuchi
     */
    @JsonProperty("EnkiTsuchi")
    public EnkiTsuchiDiv getEnkiTsuchi() {
        return EnkiTsuchi;
    }

    /*
     * setEnkiTsuchi
     * @param EnkiTsuchi EnkiTsuchi
     */
    @JsonProperty("EnkiTsuchi")
    public void setEnkiTsuchi(EnkiTsuchiDiv EnkiTsuchi) {
        this.EnkiTsuchi = EnkiTsuchi;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnAllClear
     * @return btnAllClear
     */
    @JsonProperty("btnAllClear")
    public Button getBtnAllClear() {
        return btnAllClear;
    }

    /*
     * setbtnAllClear
     * @param btnAllClear btnAllClear
     */
    @JsonProperty("btnAllClear")
    public void setBtnAllClear(Button btnAllClear) {
        this.btnAllClear = btnAllClear;
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
     * gethdnSerializedBusiness_Konkai
     * @return hdnSerializedBusiness_Konkai
     */
    @JsonProperty("hdnSerializedBusiness_Konkai")
    public RString getHdnSerializedBusiness_Konkai() {
        return hdnSerializedBusiness_Konkai;
    }

    /*
     * sethdnSerializedBusiness_Konkai
     * @param hdnSerializedBusiness_Konkai hdnSerializedBusiness_Konkai
     */
    @JsonProperty("hdnSerializedBusiness_Konkai")
    public void setHdnSerializedBusiness_Konkai(RString hdnSerializedBusiness_Konkai) {
        this.hdnSerializedBusiness_Konkai = hdnSerializedBusiness_Konkai;
    }

    /*
     * gethdnSerializedBusiness_Zenkai
     * @return hdnSerializedBusiness_Zenkai
     */
    @JsonProperty("hdnSerializedBusiness_Zenkai")
    public RString getHdnSerializedBusiness_Zenkai() {
        return hdnSerializedBusiness_Zenkai;
    }

    /*
     * sethdnSerializedBusiness_Zenkai
     * @param hdnSerializedBusiness_Zenkai hdnSerializedBusiness_Zenkai
     */
    @JsonProperty("hdnSerializedBusiness_Zenkai")
    public void setHdnSerializedBusiness_Zenkai(RString hdnSerializedBusiness_Zenkai) {
        this.hdnSerializedBusiness_Zenkai = hdnSerializedBusiness_Zenkai;
    }

    /*
     * gethdnChosaDataPass
     * @return hdnChosaDataPass
     */
    @JsonProperty("hdnChosaDataPass")
    public RString getHdnChosaDataPass() {
        return hdnChosaDataPass;
    }

    /*
     * sethdnChosaDataPass
     * @param hdnChosaDataPass hdnChosaDataPass
     */
    @JsonProperty("hdnChosaDataPass")
    public void setHdnChosaDataPass(RString hdnChosaDataPass) {
        this.hdnChosaDataPass = hdnChosaDataPass;
    }

    /*
     * gethdnShujiiDataPass
     * @return hdnShujiiDataPass
     */
    @JsonProperty("hdnShujiiDataPass")
    public RString getHdnShujiiDataPass() {
        return hdnShujiiDataPass;
    }

    /*
     * sethdnShujiiDataPass
     * @param hdnShujiiDataPass hdnShujiiDataPass
     */
    @JsonProperty("hdnShujiiDataPass")
    public void setHdnShujiiDataPass(RString hdnShujiiDataPass) {
        this.hdnShujiiDataPass = hdnShujiiDataPass;
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
     * gethdnInput
     * @return hdnInput
     */
    @JsonProperty("hdnInput")
    public RString getHdnInput() {
        return hdnInput;
    }

    /*
     * sethdnInput
     * @param hdnInput hdnInput
     */
    @JsonProperty("hdnInput")
    public void setHdnInput(RString hdnInput) {
        this.hdnInput = hdnInput;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayType implements ICommonChildDivMode {

        input("input"),
        shokai("shokai");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) { 
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode( this.modes, DisplayType.class );
    }

    public void setMode_DisplayType( DisplayType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayType.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtNinteiChosainCode() {
        return this.getNinteiChosa().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.getNinteiChosa().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosainGuide() {
        return this.getNinteiChosa().getBtnChosainGuide();
    }

    @JsonIgnore
    public void  setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.getNinteiChosa().setBtnChosainGuide(btnChosainGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getNinteiChosa().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getNinteiChosa().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return this.getNinteiChosa().getTxtNinteiChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.getNinteiChosa().setTxtNinteiChosaItakusakiCode(txtNinteiChosaItakusakiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnItakusakiGuide() {
        return this.getNinteiChosa().getBtnItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnItakusakiGuide(ButtonDialog btnItakusakiGuide) {
        this.getNinteiChosa().setBtnItakusakiGuide(btnItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getNinteiChosa().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getNinteiChosa().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public Button getBtnChosainJohoClear() {
        return this.getNinteiChosa().getBtnChosainJohoClear();
    }

    @JsonIgnore
    public void  setBtnChosainJohoClear(Button btnChosainJohoClear) {
        this.getNinteiChosa().setBtnChosainJohoClear(btnChosainJohoClear);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtNinteiChosaYubinNo() {
        return this.getNinteiChosa().getTxtNinteiChosaYubinNo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYubinNo(TextBoxYubinNo txtNinteiChosaYubinNo) {
        this.getNinteiChosa().setTxtNinteiChosaYubinNo(txtNinteiChosaYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtNinteiChosaJusho() {
        return this.getNinteiChosa().getTxtNinteiChosaJusho();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJusho(TextBoxJusho txtNinteiChosaJusho) {
        this.getNinteiChosa().setTxtNinteiChosaJusho(txtNinteiChosaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtNinteiChosaTelNo() {
        return this.getNinteiChosa().getTxtNinteiChosaTelNo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaTelNo(TextBoxTelNo txtNinteiChosaTelNo) {
        this.getNinteiChosa().setTxtNinteiChosaTelNo(txtNinteiChosaTelNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaIraiDate() {
        return this.getNinteiChosa().getTxtNinteiChosaIraiDate();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIraiDate(TextBoxFlexibleDate txtNinteiChosaIraiDate) {
        this.getNinteiChosa().setTxtNinteiChosaIraiDate(txtNinteiChosaIraiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaJisshiYoteiDate() {
        return this.getNinteiChosa().getTxtNinteiChosaJisshiYoteiDate();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJisshiYoteiDate(TextBoxFlexibleDate txtNinteiChosaJisshiYoteiDate) {
        this.getNinteiChosa().setTxtNinteiChosaJisshiYoteiDate(txtNinteiChosaJisshiYoteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaJisshiDate() {
        return this.getNinteiChosa().getTxtNinteiChosaJisshiDate();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJisshiDate(TextBoxFlexibleDate txtNinteiChosaJisshiDate) {
        this.getNinteiChosa().setTxtNinteiChosaJisshiDate(txtNinteiChosaJisshiDate);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusakiKubun() {
        return this.getNinteiChosa().getDdlNinteiChosaItakusakiKubun();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaItakusakiKubun(DropDownList ddlNinteiChosaItakusakiKubun) {
        this.getNinteiChosa().setDdlNinteiChosaItakusakiKubun(ddlNinteiChosaItakusakiKubun);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getHomonChosasaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getHomonChosasaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public Button getBtnZenKaiFukusha() {
        return this.getHomonChosasaki().getBtnZenKaiFukusha();
    }

    @JsonIgnore
    public void  setBtnZenKaiFukusha(Button btnZenKaiFukusha) {
        this.getHomonChosasaki().setBtnZenKaiFukusha(btnZenKaiFukusha);
    }

    @JsonIgnore
    public Button getBtnHonninJushoFukusha() {
        return this.getHomonChosasaki().getBtnHonninJushoFukusha();
    }

    @JsonIgnore
    public void  setBtnHonninJushoFukusha(Button btnHonninJushoFukusha) {
        this.getHomonChosasaki().setBtnHonninJushoFukusha(btnHonninJushoFukusha);
    }

    @JsonIgnore
    public Button getBtnNyushoShisetsuFukusha() {
        return this.getHomonChosasaki().getBtnNyushoShisetsuFukusha();
    }

    @JsonIgnore
    public void  setBtnNyushoShisetsuFukusha(Button btnNyushoShisetsuFukusha) {
        this.getHomonChosasaki().setBtnNyushoShisetsuFukusha(btnNyushoShisetsuFukusha);
    }

    @JsonIgnore
    public Button getBtnHomonChosaClear() {
        return this.getHomonChosasaki().getBtnHomonChosaClear();
    }

    @JsonIgnore
    public void  setBtnHomonChosaClear(Button btnHomonChosaClear) {
        this.getHomonChosasaki().setBtnHomonChosaClear(btnHomonChosaClear);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtChosasakiYubinNo() {
        return this.getHomonChosasaki().getTxtChosasakiYubinNo();
    }

    @JsonIgnore
    public void  setTxtChosasakiYubinNo(TextBoxYubinNo txtChosasakiYubinNo) {
        this.getHomonChosasaki().setTxtChosasakiYubinNo(txtChosasakiYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtChosasakiJusho() {
        return this.getHomonChosasaki().getTxtChosasakiJusho();
    }

    @JsonIgnore
    public void  setTxtChosasakiJusho(TextBoxJusho txtChosasakiJusho) {
        this.getHomonChosasaki().setTxtChosasakiJusho(txtChosasakiJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtChosasakiTelNo() {
        return this.getHomonChosasaki().getTxtChosasakiTelNo();
    }

    @JsonIgnore
    public void  setTxtChosasakiTelNo(TextBoxTelNo txtChosasakiTelNo) {
        this.getHomonChosasaki().setTxtChosasakiTelNo(txtChosasakiTelNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiGuide() {
        return this.getShujiiAndShujiIryoKikan().getBtnShujiiGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.getShujiiAndShujiIryoKikan().setBtnShujiiGuide(btnShujiiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanCode(txtShujiiIryoKikanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIryoKikanGuide() {
        return this.getShujiiAndShujiIryoKikan().getBtnIryoKikanGuide();
    }

    @JsonIgnore
    public void  setBtnIryoKikanGuide(ButtonDialog btnIryoKikanGuide) {
        this.getShujiiAndShujiIryoKikan().setBtnIryoKikanGuide(btnIryoKikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanName() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanName(txtShujiiIryoKikanName);
    }

    @JsonIgnore
    public Button getBtnShujiiJohoClear() {
        return this.getShujiiAndShujiIryoKikan().getBtnShujiiJohoClear();
    }

    @JsonIgnore
    public void  setBtnShujiiJohoClear(Button btnShujiiJohoClear) {
        this.getShujiiAndShujiIryoKikan().setBtnShujiiJohoClear(btnShujiiJohoClear);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShujiiIryoKikanYubinNo() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanYubinNo();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanYubinNo(TextBoxYubinNo txtShujiiIryoKikanYubinNo) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanYubinNo(txtShujiiIryoKikanYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShujiiIryoKikanJusho() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanJusho();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanJusho(TextBoxJusho txtShujiiIryoKikanJusho) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanJusho(txtShujiiIryoKikanJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanTelNo() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanTelNo();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanTelNo(TextBoxTelNo txtShujiiIryoKikanTelNo) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanTelNo(txtShujiiIryoKikanTelNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShujiiIryoKikanIraiDate() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanIraiDate();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanIraiDate(TextBoxFlexibleDate txtShujiiIryoKikanIraiDate) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanIraiDate(txtShujiiIryoKikanIraiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShujiiIryoKikanNyushuYoteiDate() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanNyushuYoteiDate();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanNyushuYoteiDate(TextBoxFlexibleDate txtShujiiIryoKikanNyushuYoteiDate) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanNyushuYoteiDate(txtShujiiIryoKikanNyushuYoteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShujiiIryoKikanNyushuDate() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanNyushuDate();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanNyushuDate(TextBoxFlexibleDate txtShujiiIryoKikanNyushuDate) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanNyushuDate(txtShujiiIryoKikanNyushuDate);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiKubun() {
        return this.getShujiiAndShujiIryoKikan().getChkShujiiKubun();
    }

    @JsonIgnore
    public void  setChkShujiiKubun(CheckBoxList chkShujiiKubun) {
        this.getShujiiAndShujiIryoKikan().setChkShujiiKubun(chkShujiiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlYokaigodo() {
        return this.getIchijiHantei().getDdlYokaigodo();
    }

    @JsonIgnore
    public void  setDdlYokaigodo(DropDownList ddlYokaigodo) {
        this.getIchijiHantei().setDdlYokaigodo(ddlYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtIchijiHanteiDate() {
        return this.getIchijiHantei().getTxtIchijiHanteiDate();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDate(TextBoxFlexibleDate txtIchijiHanteiDate) {
        this.getIchijiHantei().setTxtIchijiHanteiDate(txtIchijiHanteiDate);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKasangoYokaigodo() {
        return this.getIchijiHantei().getDdlNinchishoKasangoYokaigodo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKasangoYokaigodo(DropDownList ddlNinchishoKasangoYokaigodo) {
        this.getIchijiHantei().setDdlNinchishoKasangoYokaigodo(ddlNinchishoKasangoYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinsakaiShiryoSakuseiDate() {
        return this.getKaigoNinteiShinsakai().getTxtShinsakaiShiryoSakuseiDate();
    }

    @JsonIgnore
    public void  setTxtShinsakaiShiryoSakuseiDate(TextBoxFlexibleDate txtShinsakaiShiryoSakuseiDate) {
        this.getKaigoNinteiShinsakai().setTxtShinsakaiShiryoSakuseiDate(txtShinsakaiShiryoSakuseiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinsakaiKaisaiYoteiDate() {
        return this.getKaigoNinteiShinsakai().getTxtShinsakaiKaisaiYoteiDate();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiYoteiDate(TextBoxFlexibleDate txtShinsakaiKaisaiYoteiDate) {
        this.getKaigoNinteiShinsakai().setTxtShinsakaiKaisaiYoteiDate(txtShinsakaiKaisaiYoteiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHanteiDate() {
        return this.getKaigoNinteiShinsakai().getTxtNijiHanteiDate();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDate(TextBoxFlexibleDate txtNijiHanteiDate) {
        this.getKaigoNinteiShinsakai().setTxtNijiHanteiDate(txtNijiHanteiDate);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHanteiKekka() {
        return this.getKaigoNinteiShinsakai().getDdlNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.getKaigoNinteiShinsakai().setDdlNijiHanteiKekka(ddlNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtNijiHanteiYukoKikan() {
        return this.getKaigoNinteiShinsakai().getTxtNijiHanteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiYukoKikan(TextBox txtNijiHanteiYukoKikan) {
        this.getKaigoNinteiShinsakai().setTxtNijiHanteiYukoKikan(txtNijiHanteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKikanFrom() {
        return this.getKaigoNinteiShinsakai().getTxtNinteiYukoKikanFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanFrom(TextBoxFlexibleDate txtNinteiYukoKikanFrom) {
        this.getKaigoNinteiShinsakai().setTxtNinteiYukoKikanFrom(txtNinteiYukoKikanFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoKikanTo() {
        return this.getKaigoNinteiShinsakai().getTxtNinteiYukoKikanTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanTo(TextBoxFlexibleDate txtNinteiYukoKikanTo) {
        this.getKaigoNinteiShinsakai().setTxtNinteiYukoKikanTo(txtNinteiYukoKikanTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiTsuchiHakkoDay() {
        return this.getEnkiTsuchi().getTxtEnkiTsuchiHakkoDay();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoDay(TextBoxFlexibleDate txtEnkiTsuchiHakkoDay) {
        this.getEnkiTsuchi().setTxtEnkiTsuchiHakkoDay(txtEnkiTsuchiHakkoDay);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchiHakkoCount() {
        return this.getEnkiTsuchi().getTxtEnkiTsuchiHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoCount(TextBoxNum txtEnkiTsuchiHakkoCount) {
        this.getEnkiTsuchi().setTxtEnkiTsuchiHakkoCount(txtEnkiTsuchiHakkoCount);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
