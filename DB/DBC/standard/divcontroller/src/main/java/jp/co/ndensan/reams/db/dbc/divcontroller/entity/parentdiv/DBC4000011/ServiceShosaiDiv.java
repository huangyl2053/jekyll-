package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
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
 * ServiceShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceMeisho")
    private TextBox txtServiceMeisho;
    @JsonProperty("txtServiceNameRyaku")
    private TextBox txtServiceNameRyaku;
    @JsonProperty("txtTeikyoKikanYM")
    private TextBoxDateRange txtTeikyoKikanYM;
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("txtTani")
    private TextBoxNum txtTani;
    @JsonProperty("ddlTanisuShikibetsu")
    private DropDownList ddlTanisuShikibetsu;
    @JsonProperty("ddlIdouJiyuCode")
    private DropDownList ddlIdouJiyuCode;
    @JsonProperty("RiyoshaFutan")
    private RiyoshaFutanDiv RiyoshaFutan;
    @JsonProperty("JisshiKubun")
    private JisshiKubunDiv JisshiKubun;
    @JsonProperty("spc02")
    private Space spc02;
    @JsonProperty("KakushuKubun")
    private KakushuKubunDiv KakushuKubun;
    @JsonProperty("hdnServiceShuruiCode")
    private RString hdnServiceShuruiCode;
    @JsonProperty("hdnServiceKomokuCode")
    private RString hdnServiceKomokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceMeisho
     * @return txtServiceMeisho
     */
    @JsonProperty("txtServiceMeisho")
    public TextBox getTxtServiceMeisho() {
        return txtServiceMeisho;
    }

    /*
     * settxtServiceMeisho
     * @param txtServiceMeisho txtServiceMeisho
     */
    @JsonProperty("txtServiceMeisho")
    public void setTxtServiceMeisho(TextBox txtServiceMeisho) {
        this.txtServiceMeisho = txtServiceMeisho;
    }

    /*
     * gettxtServiceNameRyaku
     * @return txtServiceNameRyaku
     */
    @JsonProperty("txtServiceNameRyaku")
    public TextBox getTxtServiceNameRyaku() {
        return txtServiceNameRyaku;
    }

    /*
     * settxtServiceNameRyaku
     * @param txtServiceNameRyaku txtServiceNameRyaku
     */
    @JsonProperty("txtServiceNameRyaku")
    public void setTxtServiceNameRyaku(TextBox txtServiceNameRyaku) {
        this.txtServiceNameRyaku = txtServiceNameRyaku;
    }

    /*
     * gettxtTeikyoKikanYM
     * @return txtTeikyoKikanYM
     */
    @JsonProperty("txtTeikyoKikanYM")
    public TextBoxDateRange getTxtTeikyoKikanYM() {
        return txtTeikyoKikanYM;
    }

    /*
     * settxtTeikyoKikanYM
     * @param txtTeikyoKikanYM txtTeikyoKikanYM
     */
    @JsonProperty("txtTeikyoKikanYM")
    public void setTxtTeikyoKikanYM(TextBoxDateRange txtTeikyoKikanYM) {
        this.txtTeikyoKikanYM = txtTeikyoKikanYM;
    }

    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * gettxtTani
     * @return txtTani
     */
    @JsonProperty("txtTani")
    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    /*
     * settxtTani
     * @param txtTani txtTani
     */
    @JsonProperty("txtTani")
    public void setTxtTani(TextBoxNum txtTani) {
        this.txtTani = txtTani;
    }

    /*
     * getddlTanisuShikibetsu
     * @return ddlTanisuShikibetsu
     */
    @JsonProperty("ddlTanisuShikibetsu")
    public DropDownList getDdlTanisuShikibetsu() {
        return ddlTanisuShikibetsu;
    }

    /*
     * setddlTanisuShikibetsu
     * @param ddlTanisuShikibetsu ddlTanisuShikibetsu
     */
    @JsonProperty("ddlTanisuShikibetsu")
    public void setDdlTanisuShikibetsu(DropDownList ddlTanisuShikibetsu) {
        this.ddlTanisuShikibetsu = ddlTanisuShikibetsu;
    }

    /*
     * getddlIdouJiyuCode
     * @return ddlIdouJiyuCode
     */
    @JsonProperty("ddlIdouJiyuCode")
    public DropDownList getDdlIdouJiyuCode() {
        return ddlIdouJiyuCode;
    }

    /*
     * setddlIdouJiyuCode
     * @param ddlIdouJiyuCode ddlIdouJiyuCode
     */
    @JsonProperty("ddlIdouJiyuCode")
    public void setDdlIdouJiyuCode(DropDownList ddlIdouJiyuCode) {
        this.ddlIdouJiyuCode = ddlIdouJiyuCode;
    }

    /*
     * getRiyoshaFutan
     * @return RiyoshaFutan
     */
    @JsonProperty("RiyoshaFutan")
    public RiyoshaFutanDiv getRiyoshaFutan() {
        return RiyoshaFutan;
    }

    /*
     * setRiyoshaFutan
     * @param RiyoshaFutan RiyoshaFutan
     */
    @JsonProperty("RiyoshaFutan")
    public void setRiyoshaFutan(RiyoshaFutanDiv RiyoshaFutan) {
        this.RiyoshaFutan = RiyoshaFutan;
    }

    /*
     * getJisshiKubun
     * @return JisshiKubun
     */
    @JsonProperty("JisshiKubun")
    public JisshiKubunDiv getJisshiKubun() {
        return JisshiKubun;
    }

    /*
     * setJisshiKubun
     * @param JisshiKubun JisshiKubun
     */
    @JsonProperty("JisshiKubun")
    public void setJisshiKubun(JisshiKubunDiv JisshiKubun) {
        this.JisshiKubun = JisshiKubun;
    }

    /*
     * getspc02
     * @return spc02
     */
    @JsonProperty("spc02")
    public Space getSpc02() {
        return spc02;
    }

    /*
     * setspc02
     * @param spc02 spc02
     */
    @JsonProperty("spc02")
    public void setSpc02(Space spc02) {
        this.spc02 = spc02;
    }

    /*
     * getKakushuKubun
     * @return KakushuKubun
     */
    @JsonProperty("KakushuKubun")
    public KakushuKubunDiv getKakushuKubun() {
        return KakushuKubun;
    }

    /*
     * setKakushuKubun
     * @param KakushuKubun KakushuKubun
     */
    @JsonProperty("KakushuKubun")
    public void setKakushuKubun(KakushuKubunDiv KakushuKubun) {
        this.KakushuKubun = KakushuKubun;
    }

    /*
     * gethdnServiceShuruiCode
     * @return hdnServiceShuruiCode
     */
    @JsonProperty("hdnServiceShuruiCode")
    public RString getHdnServiceShuruiCode() {
        return hdnServiceShuruiCode;
    }

    /*
     * sethdnServiceShuruiCode
     * @param hdnServiceShuruiCode hdnServiceShuruiCode
     */
    @JsonProperty("hdnServiceShuruiCode")
    public void setHdnServiceShuruiCode(RString hdnServiceShuruiCode) {
        this.hdnServiceShuruiCode = hdnServiceShuruiCode;
    }

    /*
     * gethdnServiceKomokuCode
     * @return hdnServiceKomokuCode
     */
    @JsonProperty("hdnServiceKomokuCode")
    public RString getHdnServiceKomokuCode() {
        return hdnServiceKomokuCode;
    }

    /*
     * sethdnServiceKomokuCode
     * @param hdnServiceKomokuCode hdnServiceKomokuCode
     */
    @JsonProperty("hdnServiceKomokuCode")
    public void setHdnServiceKomokuCode(RString hdnServiceKomokuCode) {
        this.hdnServiceKomokuCode = hdnServiceKomokuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RiyoshaFutanLeftDiv getRiyoshaFutanLeft() {
        return this.getRiyoshaFutan().getRiyoshaFutanLeft();
    }

    @JsonIgnore
    public void  setRiyoshaFutanLeft(RiyoshaFutanLeftDiv RiyoshaFutanLeft) {
        this.getRiyoshaFutan().setRiyoshaFutanLeft(RiyoshaFutanLeft);
    }

    @JsonIgnore
    public SegmentedControl getSegTeiritsuOrTeigaku() {
        return this.getRiyoshaFutan().getRiyoshaFutanLeft().getSegTeiritsuOrTeigaku();
    }

    @JsonIgnore
    public void  setSegTeiritsuOrTeigaku(SegmentedControl segTeiritsuOrTeigaku) {
        this.getRiyoshaFutan().getRiyoshaFutanLeft().setSegTeiritsuOrTeigaku(segTeiritsuOrTeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getRiyoshaFutan().getRiyoshaFutanLeft().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getRiyoshaFutan().getRiyoshaFutanLeft().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangaku() {
        return this.getRiyoshaFutan().getRiyoshaFutanLeft().getTxtRiyoshaFutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.getRiyoshaFutan().getRiyoshaFutanLeft().setTxtRiyoshaFutangaku(txtRiyoshaFutangaku);
    }

    @JsonIgnore
    public RiyoshaFutanRightDiv getRiyoshaFutanRight() {
        return this.getRiyoshaFutan().getRiyoshaFutanRight();
    }

    @JsonIgnore
    public void  setRiyoshaFutanRight(RiyoshaFutanRightDiv RiyoshaFutanRight) {
        this.getRiyoshaFutan().setRiyoshaFutanRight(RiyoshaFutanRight);
    }

    @JsonIgnore
    public DropDownList getDdlTanisuSanteiTaniCode() {
        return this.getRiyoshaFutan().getRiyoshaFutanRight().getDdlTanisuSanteiTaniCode();
    }

    @JsonIgnore
    public void  setDdlTanisuSanteiTaniCode(DropDownList ddlTanisuSanteiTaniCode) {
        this.getRiyoshaFutan().getRiyoshaFutanRight().setDdlTanisuSanteiTaniCode(ddlTanisuSanteiTaniCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeigenNissuKaisu() {
        return this.getRiyoshaFutan().getRiyoshaFutanRight().getTxtSeigenNissuKaisu();
    }

    @JsonIgnore
    public void  setTxtSeigenNissuKaisu(TextBoxNum txtSeigenNissuKaisu) {
        this.getRiyoshaFutan().getRiyoshaFutanRight().setTxtSeigenNissuKaisu(txtSeigenNissuKaisu);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKaisuSeigenKikanKubun() {
        return this.getRiyoshaFutan().getRiyoshaFutanRight().getDdlSanteiKaisuSeigenKikanKubun();
    }

    @JsonIgnore
    public void  setDdlSanteiKaisuSeigenKikanKubun(DropDownList ddlSanteiKaisuSeigenKikanKubun) {
        this.getRiyoshaFutan().getRiyoshaFutanRight().setDdlSanteiKaisuSeigenKikanKubun(ddlSanteiKaisuSeigenKikanKubun);
    }

    @JsonIgnore
    public SegmentedControl getSegTaishoJigyoJishiKubun() {
        return this.getJisshiKubun().getSegTaishoJigyoJishiKubun();
    }

    @JsonIgnore
    public void  setSegTaishoJigyoJishiKubun(SegmentedControl segTaishoJigyoJishiKubun) {
        this.getJisshiKubun().setSegTaishoJigyoJishiKubun(segTaishoJigyoJishiKubun);
    }

    @JsonIgnore
    public SegmentedControl getSegYoshien1() {
        return this.getJisshiKubun().getSegYoshien1();
    }

    @JsonIgnore
    public void  setSegYoshien1(SegmentedControl segYoshien1) {
        this.getJisshiKubun().setSegYoshien1(segYoshien1);
    }

    @JsonIgnore
    public SegmentedControl getSegYoshien2() {
        return this.getJisshiKubun().getSegYoshien2();
    }

    @JsonIgnore
    public void  setSegYoshien2(SegmentedControl segYoshien2) {
        this.getJisshiKubun().setSegYoshien2(segYoshien2);
    }

    @JsonIgnore
    public SegmentedControl getSegNijiYobosha() {
        return this.getJisshiKubun().getSegNijiYobosha();
    }

    @JsonIgnore
    public void  setSegNijiYobosha(SegmentedControl segNijiYobosha) {
        this.getJisshiKubun().setSegNijiYobosha(segNijiYobosha);
    }

    @JsonIgnore
    public CheckBoxList getChkGendogakuTaishogai() {
        return this.getKakushuKubun().getChkGendogakuTaishogai();
    }

    @JsonIgnore
    public void  setChkGendogakuTaishogai(CheckBoxList chkGendogakuTaishogai) {
        this.getKakushuKubun().setChkGendogakuTaishogai(chkGendogakuTaishogai);
    }

    @JsonIgnore
    public CheckBoxList getChkGaibuService() {
        return this.getKakushuKubun().getChkGaibuService();
    }

    @JsonIgnore
    public void  setChkGaibuService(CheckBoxList chkGaibuService) {
        this.getKakushuKubun().setChkGaibuService(chkGaibuService);
    }

    @JsonIgnore
    public CheckBoxList getChkTokubetsuChiikiKasn() {
        return this.getKakushuKubun().getChkTokubetsuChiikiKasn();
    }

    @JsonIgnore
    public void  setChkTokubetsuChiikiKasn(CheckBoxList chkTokubetsuChiikiKasn) {
        this.getKakushuKubun().setChkTokubetsuChiikiKasn(chkTokubetsuChiikiKasn);
    }

    // </editor-fold>
}
