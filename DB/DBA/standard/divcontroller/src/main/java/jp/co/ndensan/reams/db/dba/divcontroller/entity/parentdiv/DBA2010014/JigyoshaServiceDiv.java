package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * JigyoshaService のクラスファイル 
 * 
 */
public class JigyoshaServiceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JigyoshaServiceKihon")
    private JigyoshaServiceKihonDiv JigyoshaServiceKihon;
    @JsonProperty("JigyoshaServiceShosai")
    private JigyoshaServiceShosaiDiv JigyoshaServiceShosai;
    @JsonProperty("hokenshaNo")
    private RString hokenshaNo;
    @JsonProperty("hokenshaMeisho")
    private RString hokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJigyoshaServiceKihon
     * @return JigyoshaServiceKihon
     */
    @JsonProperty("JigyoshaServiceKihon")
    public JigyoshaServiceKihonDiv getJigyoshaServiceKihon() {
        return JigyoshaServiceKihon;
    }

    /*
     * setJigyoshaServiceKihon
     * @param JigyoshaServiceKihon JigyoshaServiceKihon
     */
    @JsonProperty("JigyoshaServiceKihon")
    public void setJigyoshaServiceKihon(JigyoshaServiceKihonDiv JigyoshaServiceKihon) {
        this.JigyoshaServiceKihon = JigyoshaServiceKihon;
    }

    /*
     * getJigyoshaServiceShosai
     * @return JigyoshaServiceShosai
     */
    @JsonProperty("JigyoshaServiceShosai")
    public JigyoshaServiceShosaiDiv getJigyoshaServiceShosai() {
        return JigyoshaServiceShosai;
    }

    /*
     * setJigyoshaServiceShosai
     * @param JigyoshaServiceShosai JigyoshaServiceShosai
     */
    @JsonProperty("JigyoshaServiceShosai")
    public void setJigyoshaServiceShosai(JigyoshaServiceShosaiDiv JigyoshaServiceShosai) {
        this.JigyoshaServiceShosai = JigyoshaServiceShosai;
    }

    /*
     * gethokenshaNo
     * @return hokenshaNo
     */
    @JsonProperty("hokenshaNo")
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /*
     * sethokenshaNo
     * @param hokenshaNo hokenshaNo
     */
    @JsonProperty("hokenshaNo")
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /*
     * gethokenshaMeisho
     * @return hokenshaMeisho
     */
    @JsonProperty("hokenshaMeisho")
    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    /*
     * sethokenshaMeisho
     * @param hokenshaMeisho hokenshaMeisho
     */
    @JsonProperty("hokenshaMeisho")
    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.hokenshaMeisho = hokenshaMeisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSogoRehaShisetsuUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadSogoRehaShisetsuUmu();
    }

    @JsonIgnore
    public void  setRadSogoRehaShisetsuUmu(RadioButton radSogoRehaShisetsuUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadSogoRehaShisetsuUmu(radSogoRehaShisetsuUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadRigakuRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIUmu(RadioButton radRigakuRyohoIIUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadRigakuRyohoIIUmu(radRigakuRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIIUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadRigakuRyohoIIIUmu();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIIUmu(RadioButton radRigakuRyohoIIIUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadRigakuRyohoIIIUmu(radRigakuRyohoIIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadSagyoRyohoIIUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadSagyoRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadSagyoRyohoIIUmu(RadioButton radSagyoRyohoIIUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadSagyoRyohoIIUmu(radSagyoRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadSeisinkaSagyouRyohoUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadSeisinkaSagyouRyohoUmu();
    }

    @JsonIgnore
    public void  setRadSeisinkaSagyouRyohoUmu(RadioButton radSeisinkaSagyouRyohoUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadSeisinkaSagyouRyohoUmu(radSeisinkaSagyouRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadSonotaUmu() {
        return this.getJigyoshaServiceShosai().getRihabiri().getRadSonotaUmu();
    }

    @JsonIgnore
    public void  setRadSonotaUmu(RadioButton radSonotaUmu) {
        this.getJigyoshaServiceShosai().getRihabiri().setRadSonotaUmu(radSonotaUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSogoRehaShisetsuUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuSogoRehaShisetsuUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSogoRehaShisetsuUmu(RadioButton radKobetsuSogoRehaShisetsuUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuSogoRehaShisetsuUmu(radKobetsuSogoRehaShisetsuUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIIUmu1() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuRigakuRyohoIIUmu1();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIIUmu1(RadioButton radKobetsuRigakuRyohoIIUmu1) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuRigakuRyohoIIUmu1(radKobetsuRigakuRyohoIIUmu1);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIIIUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuRigakuRyohoIIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIIIUmu(RadioButton radKobetsuRigakuRyohoIIIUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuRigakuRyohoIIIUmu(radKobetsuRigakuRyohoIIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSagyoRyohoIIUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuSagyoRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSagyoRyohoIIUmu(RadioButton radKobetsuSagyoRyohoIIUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuSagyoRyohoIIUmu(radKobetsuSagyoRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoIUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuGengoChokakuRyohoIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoIUmu(RadioButton radKobetsuGengoChokakuRyohoIUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuGengoChokakuRyohoIUmu(radKobetsuGengoChokakuRyohoIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoIIUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri1().getRadKobetsuGengoChokakuRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoIIUmu(RadioButton radKobetsuGengoChokakuRyohoIIUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri1().setRadKobetsuGengoChokakuRyohoIIUmu(radKobetsuGengoChokakuRyohoIIUmu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoShienSemmoninSenjuJokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getKaigoShienSenmonin().getTxtKaigoShienSemmoninSenjuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoShienSemmoninSenjuJokinshaNinsu(TextBoxNum txtKaigoShienSemmoninSenjuJokinshaNinsu) {
        this.getJigyoshaServiceShosai().getKaigoShienSenmonin().setTxtKaigoShienSemmoninSenjuJokinshaNinsu(txtKaigoShienSemmoninSenjuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninSenjuHijokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getKaigoShienSenmonin().getTxtKaigoSienSemmoninSenjuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninSenjuHijokinshaNinsu(TextBoxNum txtKaigoSienSemmoninSenjuHijokinshaNinsu) {
        this.getJigyoshaServiceShosai().getKaigoShienSenmonin().setTxtKaigoSienSemmoninSenjuHijokinshaNinsu(txtKaigoSienSemmoninSenjuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninKemmuJokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getKaigoShienSenmonin().getTxtKaigoSienSemmoninKemmuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninKemmuJokinshaNinsu(TextBoxNum txtKaigoSienSemmoninKemmuJokinshaNinsu) {
        this.getJigyoshaServiceShosai().getKaigoShienSenmonin().setTxtKaigoSienSemmoninKemmuJokinshaNinsu(txtKaigoSienSemmoninKemmuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninKemmuHijokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getKaigoShienSenmonin().getTxtKaigoSienSemmoninKemmuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninKemmuHijokinshaNinsu(TextBoxNum txtKaigoSienSemmoninKemmuHijokinshaNinsu) {
        this.getJigyoshaServiceShosai().getKaigoShienSenmonin().setTxtKaigoSienSemmoninKemmuHijokinshaNinsu(txtKaigoSienSemmoninKemmuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoSenjuJokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getHomonKaigoIn().getTxtHomonkaigoSenjuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoSenjuJokinshaNinsu(TextBoxNum txtHomonkaigoSenjuJokinshaNinsu) {
        this.getJigyoshaServiceShosai().getHomonKaigoIn().setTxtHomonkaigoSenjuJokinshaNinsu(txtHomonkaigoSenjuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoSenjuHijokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getHomonKaigoIn().getTxtHomonkaigoSenjuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoSenjuHijokinshaNinsu(TextBoxNum txtHomonkaigoSenjuHijokinshaNinsu) {
        this.getJigyoshaServiceShosai().getHomonKaigoIn().setTxtHomonkaigoSenjuHijokinshaNinsu(txtHomonkaigoSenjuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoKemmuJokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getHomonKaigoIn().getTxtHomonkaigoKemmuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoKemmuJokinshaNinsu(TextBoxNum txtHomonkaigoKemmuJokinshaNinsu) {
        this.getJigyoshaServiceShosai().getHomonKaigoIn().setTxtHomonkaigoKemmuJokinshaNinsu(txtHomonkaigoKemmuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoKemmuHijokinshaNinsu() {
        return this.getJigyoshaServiceShosai().getHomonKaigoIn().getTxtHomonkaigoKemmuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoKemmuHijokinshaNinsu(TextBoxNum txtHomonkaigoKemmuHijokinshaNinsu) {
        this.getJigyoshaServiceShosai().getHomonKaigoIn().setTxtHomonkaigoKemmuHijokinshaNinsu(txtHomonkaigoKemmuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoJokinKanzangoNinsu() {
        return this.getJigyoshaServiceShosai().getHomonKaigoIn().getTxtHomonkaigoJokinKanzangoNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoJokinKanzangoNinsu(TextBoxNum txtHomonkaigoJokinKanzangoNinsu) {
        this.getJigyoshaServiceShosai().getHomonKaigoIn().setTxtHomonkaigoJokinKanzangoNinsu(txtHomonkaigoJokinKanzangoNinsu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri2().getRadKobetsuRigakuRyohoIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIUmu(RadioButton radKobetsuRigakuRyohoIUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri2().setRadKobetsuRigakuRyohoIUmu(radKobetsuRigakuRyohoIUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIUmu2() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri2().getRadRigakuRyohoIIUmu2();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIUmu2(RadioButton radRigakuRyohoIIUmu2) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri2().setRadRigakuRyohoIIUmu2(radRigakuRyohoIIUmu2);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSagyoRyohoUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri2().getRadKobetsuSagyoRyohoUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSagyoRyohoUmu(RadioButton radKobetsuSagyoRyohoUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri2().setRadKobetsuSagyoRyohoUmu(radKobetsuSagyoRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri2().getRadKobetsuGengoChokakuRyohoUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoUmu(RadioButton radKobetsuGengoChokakuRyohoUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri2().setRadKobetsuGengoChokakuRyohoUmu(radKobetsuGengoChokakuRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSonotaUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri2().getRadKobetsuSonotaUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSonotaUmu(RadioButton radKobetsuSonotaUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri2().setRadKobetsuSonotaUmu(radKobetsuSonotaUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRehaShidoKanriUmu() {
        return this.getJigyoshaServiceShosai().getKobetsuRihabiri3().getRadKobetsuRehaShidoKanriUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRehaShidoKanriUmu(RadioButton radKobetsuRehaShidoKanriUmu) {
        this.getJigyoshaServiceShosai().getKobetsuRihabiri3().setRadKobetsuRehaShidoKanriUmu(radKobetsuRehaShidoKanriUmu);
    }

    @JsonIgnore
    public RadioButton getRadChuSankanChiikiShokiboJigyoshoKasanChiiki() {
        return this.getJigyoshaServiceShosai().getChusankanChiiki().getRadChuSankanChiikiShokiboJigyoshoKasanChiiki();
    }

    @JsonIgnore
    public void  setRadChuSankanChiikiShokiboJigyoshoKasanChiiki(RadioButton radChuSankanChiikiShokiboJigyoshoKasanChiiki) {
        this.getJigyoshaServiceShosai().getChusankanChiiki().setRadChuSankanChiikiShokiboJigyoshoKasanChiiki(radChuSankanChiikiShokiboJigyoshoKasanChiiki);
    }

    @JsonIgnore
    public RadioButton getRadChuSankanChiikiShokiboJigyoshoKasanKibo() {
        return this.getJigyoshaServiceShosai().getChusankanChiiki().getRadChuSankanChiikiShokiboJigyoshoKasanKibo();
    }

    @JsonIgnore
    public void  setRadChuSankanChiikiShokiboJigyoshoKasanKibo(RadioButton radChuSankanChiikiShokiboJigyoshoKasanKibo) {
        this.getJigyoshaServiceShosai().getChusankanChiiki().setRadChuSankanChiikiShokiboJigyoshoKasanKibo(radChuSankanChiikiShokiboJigyoshoKasanKibo);
    }

    // </editor-fold>
}
