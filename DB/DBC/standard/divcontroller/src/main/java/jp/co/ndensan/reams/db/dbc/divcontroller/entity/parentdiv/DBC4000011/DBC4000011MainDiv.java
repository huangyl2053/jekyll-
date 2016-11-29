package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC4000011Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC4000011MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ServiceNaiyoIchiran")
    private ServiceNaiyoIchiranDiv ServiceNaiyoIchiran;
    @JsonProperty("ServiceShosai")
    private ServiceShosaiDiv ServiceShosai;
    @JsonProperty("ccdKanryoMsg")
    private KaigoKanryoMessageDiv ccdKanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getServiceNaiyoIchiran
     * @return ServiceNaiyoIchiran
     */
    @JsonProperty("ServiceNaiyoIchiran")
    public ServiceNaiyoIchiranDiv getServiceNaiyoIchiran() {
        return ServiceNaiyoIchiran;
    }

    /*
     * setServiceNaiyoIchiran
     * @param ServiceNaiyoIchiran ServiceNaiyoIchiran
     */
    @JsonProperty("ServiceNaiyoIchiran")
    public void setServiceNaiyoIchiran(ServiceNaiyoIchiranDiv ServiceNaiyoIchiran) {
        this.ServiceNaiyoIchiran = ServiceNaiyoIchiran;
    }

    /*
     * getServiceShosai
     * @return ServiceShosai
     */
    @JsonProperty("ServiceShosai")
    public ServiceShosaiDiv getServiceShosai() {
        return ServiceShosai;
    }

    /*
     * setServiceShosai
     * @param ServiceShosai ServiceShosai
     */
    @JsonProperty("ServiceShosai")
    public void setServiceShosai(ServiceShosaiDiv ServiceShosai) {
        this.ServiceShosai = ServiceShosai;
    }

    /*
     * getccdKanryoMsg
     * @return ccdKanryoMsg
     */
    @JsonProperty("ccdKanryoMsg")
    public IKaigoKanryoMessageDiv getCcdKanryoMsg() {
        return ccdKanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnSearch() {
        return this.getKensakuJoken().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getKensakuJoken().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCdInput() {
        return this.getKensakuJoken().getCcdServiceCdInput();
    }

    @JsonIgnore
    public Button getBtnTsuika() {
        return this.getServiceNaiyoIchiran().getBtnTsuika();
    }

    @JsonIgnore
    public void  setBtnTsuika(Button btnTsuika) {
        this.getServiceNaiyoIchiran().setBtnTsuika(btnTsuika);
    }

    @JsonIgnore
    public DataGrid<dgService_Row> getDgService() {
        return this.getServiceNaiyoIchiran().getDgService();
    }

    @JsonIgnore
    public void  setDgService(DataGrid<dgService_Row> dgService) {
        this.getServiceNaiyoIchiran().setDgService(dgService);
    }

    @JsonIgnore
    public TextBox getTxtServiceMeisho() {
        return this.getServiceShosai().getTxtServiceMeisho();
    }

    @JsonIgnore
    public void  setTxtServiceMeisho(TextBox txtServiceMeisho) {
        this.getServiceShosai().setTxtServiceMeisho(txtServiceMeisho);
    }

    @JsonIgnore
    public TextBox getTxtServiceNameRyaku() {
        return this.getServiceShosai().getTxtServiceNameRyaku();
    }

    @JsonIgnore
    public void  setTxtServiceNameRyaku(TextBox txtServiceNameRyaku) {
        this.getServiceShosai().setTxtServiceNameRyaku(txtServiceNameRyaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTeikyoKikanYM() {
        return this.getServiceShosai().getTxtTeikyoKikanYM();
    }

    @JsonIgnore
    public void  setTxtTeikyoKikanYM(TextBoxDateRange txtTeikyoKikanYM) {
        this.getServiceShosai().setTxtTeikyoKikanYM(txtTeikyoKikanYM);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getServiceShosai().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getServiceShosai().setSpc01(spc01);
    }

    @JsonIgnore
    public TextBoxNum getTxtTani() {
        return this.getServiceShosai().getTxtTani();
    }

    @JsonIgnore
    public void  setTxtTani(TextBoxNum txtTani) {
        this.getServiceShosai().setTxtTani(txtTani);
    }

    @JsonIgnore
    public DropDownList getDdlTanisuShikibetsu() {
        return this.getServiceShosai().getDdlTanisuShikibetsu();
    }

    @JsonIgnore
    public void  setDdlTanisuShikibetsu(DropDownList ddlTanisuShikibetsu) {
        this.getServiceShosai().setDdlTanisuShikibetsu(ddlTanisuShikibetsu);
    }

    @JsonIgnore
    public DropDownList getDdlIdouJiyuCode() {
        return this.getServiceShosai().getDdlIdouJiyuCode();
    }

    @JsonIgnore
    public void  setDdlIdouJiyuCode(DropDownList ddlIdouJiyuCode) {
        this.getServiceShosai().setDdlIdouJiyuCode(ddlIdouJiyuCode);
    }

    @JsonIgnore
    public RiyoshaFutanDiv getRiyoshaFutan() {
        return this.getServiceShosai().getRiyoshaFutan();
    }

    @JsonIgnore
    public void  setRiyoshaFutan(RiyoshaFutanDiv RiyoshaFutan) {
        this.getServiceShosai().setRiyoshaFutan(RiyoshaFutan);
    }

    @JsonIgnore
    public RiyoshaFutanLeftDiv getRiyoshaFutanLeft() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft();
    }

    @JsonIgnore
    public void  setRiyoshaFutanLeft(RiyoshaFutanLeftDiv RiyoshaFutanLeft) {
        this.getServiceShosai().getRiyoshaFutan().setRiyoshaFutanLeft(RiyoshaFutanLeft);
    }

    @JsonIgnore
    public SegmentedControl getSegTeiritsuOrTeigaku() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().getSegTeiritsuOrTeigaku();
    }

    @JsonIgnore
    public void  setSegTeiritsuOrTeigaku(SegmentedControl segTeiritsuOrTeigaku) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().setSegTeiritsuOrTeigaku(segTeiritsuOrTeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangaku() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().getTxtRiyoshaFutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanLeft().setTxtRiyoshaFutangaku(txtRiyoshaFutangaku);
    }

    @JsonIgnore
    public RiyoshaFutanRightDiv getRiyoshaFutanRight() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight();
    }

    @JsonIgnore
    public void  setRiyoshaFutanRight(RiyoshaFutanRightDiv RiyoshaFutanRight) {
        this.getServiceShosai().getRiyoshaFutan().setRiyoshaFutanRight(RiyoshaFutanRight);
    }

    @JsonIgnore
    public DropDownList getDdlTanisuSanteiTaniCode() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().getDdlTanisuSanteiTaniCode();
    }

    @JsonIgnore
    public void  setDdlTanisuSanteiTaniCode(DropDownList ddlTanisuSanteiTaniCode) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().setDdlTanisuSanteiTaniCode(ddlTanisuSanteiTaniCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeigenNissuKaisu() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().getTxtSeigenNissuKaisu();
    }

    @JsonIgnore
    public void  setTxtSeigenNissuKaisu(TextBoxNum txtSeigenNissuKaisu) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().setTxtSeigenNissuKaisu(txtSeigenNissuKaisu);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKaisuSeigenKikanKubun() {
        return this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().getDdlSanteiKaisuSeigenKikanKubun();
    }

    @JsonIgnore
    public void  setDdlSanteiKaisuSeigenKikanKubun(DropDownList ddlSanteiKaisuSeigenKikanKubun) {
        this.getServiceShosai().getRiyoshaFutan().getRiyoshaFutanRight().setDdlSanteiKaisuSeigenKikanKubun(ddlSanteiKaisuSeigenKikanKubun);
    }

    @JsonIgnore
    public JisshiKubunDiv getJisshiKubun() {
        return this.getServiceShosai().getJisshiKubun();
    }

    @JsonIgnore
    public void  setJisshiKubun(JisshiKubunDiv JisshiKubun) {
        this.getServiceShosai().setJisshiKubun(JisshiKubun);
    }

    @JsonIgnore
    public SegmentedControl getSegTaishoJigyoJishiKubun() {
        return this.getServiceShosai().getJisshiKubun().getSegTaishoJigyoJishiKubun();
    }

    @JsonIgnore
    public void  setSegTaishoJigyoJishiKubun(SegmentedControl segTaishoJigyoJishiKubun) {
        this.getServiceShosai().getJisshiKubun().setSegTaishoJigyoJishiKubun(segTaishoJigyoJishiKubun);
    }

    @JsonIgnore
    public SegmentedControl getSegYoshien1() {
        return this.getServiceShosai().getJisshiKubun().getSegYoshien1();
    }

    @JsonIgnore
    public void  setSegYoshien1(SegmentedControl segYoshien1) {
        this.getServiceShosai().getJisshiKubun().setSegYoshien1(segYoshien1);
    }

    @JsonIgnore
    public SegmentedControl getSegYoshien2() {
        return this.getServiceShosai().getJisshiKubun().getSegYoshien2();
    }

    @JsonIgnore
    public void  setSegYoshien2(SegmentedControl segYoshien2) {
        this.getServiceShosai().getJisshiKubun().setSegYoshien2(segYoshien2);
    }

    @JsonIgnore
    public SegmentedControl getSegNijiYobosha() {
        return this.getServiceShosai().getJisshiKubun().getSegNijiYobosha();
    }

    @JsonIgnore
    public void  setSegNijiYobosha(SegmentedControl segNijiYobosha) {
        this.getServiceShosai().getJisshiKubun().setSegNijiYobosha(segNijiYobosha);
    }

    @JsonIgnore
    public Space getSpc02() {
        return this.getServiceShosai().getSpc02();
    }

    @JsonIgnore
    public void  setSpc02(Space spc02) {
        this.getServiceShosai().setSpc02(spc02);
    }

    @JsonIgnore
    public KakushuKubunDiv getKakushuKubun() {
        return this.getServiceShosai().getKakushuKubun();
    }

    @JsonIgnore
    public void  setKakushuKubun(KakushuKubunDiv KakushuKubun) {
        this.getServiceShosai().setKakushuKubun(KakushuKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkGendogakuTaishogai() {
        return this.getServiceShosai().getKakushuKubun().getChkGendogakuTaishogai();
    }

    @JsonIgnore
    public void  setChkGendogakuTaishogai(CheckBoxList chkGendogakuTaishogai) {
        this.getServiceShosai().getKakushuKubun().setChkGendogakuTaishogai(chkGendogakuTaishogai);
    }

    @JsonIgnore
    public CheckBoxList getChkGaibuService() {
        return this.getServiceShosai().getKakushuKubun().getChkGaibuService();
    }

    @JsonIgnore
    public void  setChkGaibuService(CheckBoxList chkGaibuService) {
        this.getServiceShosai().getKakushuKubun().setChkGaibuService(chkGaibuService);
    }

    @JsonIgnore
    public CheckBoxList getChkTokubetsuChiikiKasn() {
        return this.getServiceShosai().getKakushuKubun().getChkTokubetsuChiikiKasn();
    }

    @JsonIgnore
    public void  setChkTokubetsuChiikiKasn(CheckBoxList chkTokubetsuChiikiKasn) {
        this.getServiceShosai().getKakushuKubun().setChkTokubetsuChiikiKasn(chkTokubetsuChiikiKasn);
    }

    // </editor-fold>
}
