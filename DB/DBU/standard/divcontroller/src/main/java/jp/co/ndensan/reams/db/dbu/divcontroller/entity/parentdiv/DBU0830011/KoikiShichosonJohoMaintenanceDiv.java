package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.IKaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KoikiShichosonJohoMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikiShichosonJohoMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KoikiShichosonJoho")
    private KoikiShichosonJohoDiv KoikiShichosonJoho;
    @JsonProperty("ChohyoJusho")
    private ChohyoJushoDiv ChohyoJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKoikiShichosonJoho
     * @return KoikiShichosonJoho
     */
    @JsonProperty("KoikiShichosonJoho")
    public KoikiShichosonJohoDiv getKoikiShichosonJoho() {
        return KoikiShichosonJoho;
    }

    /*
     * setKoikiShichosonJoho
     * @param KoikiShichosonJoho KoikiShichosonJoho
     */
    @JsonProperty("KoikiShichosonJoho")
    public void setKoikiShichosonJoho(KoikiShichosonJohoDiv KoikiShichosonJoho) {
        this.KoikiShichosonJoho = KoikiShichosonJoho;
    }

    /*
     * getChohyoJusho
     * @return ChohyoJusho
     */
    @JsonProperty("ChohyoJusho")
    public ChohyoJushoDiv getChohyoJusho() {
        return ChohyoJusho;
    }

    /*
     * setChohyoJusho
     * @param ChohyoJusho ChohyoJusho
     */
    @JsonProperty("ChohyoJusho")
    public void setChohyoJusho(ChohyoJushoDiv ChohyoJusho) {
        this.ChohyoJusho = ChohyoJusho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShichosonJoho1Div getShichosonJoho1() {
        return this.getKoikiShichosonJoho().getShichosonJoho1();
    }

    @JsonIgnore
    public void  setShichosonJoho1(ShichosonJoho1Div ShichosonJoho1) {
        this.getKoikiShichosonJoho().setShichosonJoho1(ShichosonJoho1);
    }

    @JsonIgnore
    public TextBoxCode getTxtShichonoShikibetsuID() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtShichonoShikibetsuID();
    }

    @JsonIgnore
    public void  setTxtShichonoShikibetsuID(TextBoxCode txtShichonoShikibetsuID) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtShichonoShikibetsuID(txtShichonoShikibetsuID);
    }

    @JsonIgnore
    public TextBoxCode getTxtKokuhorenShichosonNo() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtKokuhorenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtKokuhorenShichosonNo(TextBoxCode txtKokuhorenShichosonNo) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtKokuhorenShichosonNo(txtKokuhorenShichosonNo);
    }

    @JsonIgnore
    public TextBox getTxtTodofukenName() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtTodofukenName();
    }

    @JsonIgnore
    public void  setTxtTodofukenName(TextBox txtTodofukenName) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtTodofukenName(txtTodofukenName);
    }

    @JsonIgnore
    public TextBox getTxtShichosonName() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtShichosonName();
    }

    @JsonIgnore
    public void  setTxtShichosonName(TextBox txtShichosonName) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtShichosonName(txtShichosonName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinShimei() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getDdlGaikokujinShimei();
    }

    @JsonIgnore
    public void  setDdlGaikokujinShimei(DropDownList ddlGaikokujinShimei) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setDdlGaikokujinShimei(ddlGaikokujinShimei);
    }

    @JsonIgnore
    public DropDownList getDdlSaiyusenChikuCode() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getDdlSaiyusenChikuCode();
    }

    @JsonIgnore
    public void  setDdlSaiyusenChikuCode(DropDownList ddlSaiyusenChikuCode) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setDdlSaiyusenChikuCode(ddlSaiyusenChikuCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKanyuYMD() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getTxtKanyuYMD();
    }

    @JsonIgnore
    public void  setTxtKanyuYMD(TextBoxFlexibleDate txtKanyuYMD) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setTxtKanyuYMD(txtKanyuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuHikidashiHoho() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getDdlShotokuHikidashiHoho();
    }

    @JsonIgnore
    public void  setDdlShotokuHikidashiHoho(DropDownList ddlShotokuHikidashiHoho) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setDdlShotokuHikidashiHoho(ddlShotokuHikidashiHoho);
    }

    @JsonIgnore
    public DropDownList getDdlTokuchoBunpai() {
        return this.getKoikiShichosonJoho().getShichosonJoho1().getDdlTokuchoBunpai();
    }

    @JsonIgnore
    public void  setDdlTokuchoBunpai(DropDownList ddlTokuchoBunpai) {
        this.getKoikiShichosonJoho().getShichosonJoho1().setDdlTokuchoBunpai(ddlTokuchoBunpai);
    }

    @JsonIgnore
    public ShichosonJoho2Div getShichosonJoho2() {
        return this.getKoikiShichosonJoho().getShichosonJoho2();
    }

    @JsonIgnore
    public void  setShichosonJoho2(ShichosonJoho2Div ShichosonJoho2) {
        this.getKoikiShichosonJoho().setShichosonJoho2(ShichosonJoho2);
    }

    @JsonIgnore
    public TextBoxCode getTxtShokisaiHokenshaNo() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaNo(TextBoxCode txtShokisaiHokenshaNo) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtShokisaiHokenshaNo(txtShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShichosonCode() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtShichosonCode();
    }

    @JsonIgnore
    public void  setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtShichosonCode(txtShichosonCode);
    }

    @JsonIgnore
    public TextBox getTxtGunName() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtGunName();
    }

    @JsonIgnore
    public void  setTxtGunName(TextBox txtGunName) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtGunName(txtGunName);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtRojinHokenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtRojinHokenShichosonNo(txtRojinHokenShichosonNo);
    }

    @JsonIgnore
    public DropDownList getDdlRojinHokenJukyushaNoTaikei() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getDdlRojinHokenJukyushaNoTaikei();
    }

    @JsonIgnore
    public void  setDdlRojinHokenJukyushaNoTaikei(DropDownList ddlRojinHokenJukyushaNoTaikei) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setDdlRojinHokenJukyushaNoTaikei(ddlRojinHokenJukyushaNoTaikei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtDattaiYMD() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getTxtDattaiYMD();
    }

    @JsonIgnore
    public void  setTxtDattaiYMD(TextBoxFlexibleDate txtDattaiYMD) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setTxtDattaiYMD(txtDattaiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlNofugakuDataRenkei() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getDdlNofugakuDataRenkei();
    }

    @JsonIgnore
    public void  setDdlNofugakuDataRenkei(DropDownList ddlNofugakuDataRenkei) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setDdlNofugakuDataRenkei(ddlNofugakuDataRenkei);
    }

    @JsonIgnore
    public Space getBlank1() {
        return this.getKoikiShichosonJoho().getShichosonJoho2().getBlank1();
    }

    @JsonIgnore
    public void  setBlank1(Space blank1) {
        this.getKoikiShichosonJoho().getShichosonJoho2().setBlank1(blank1);
    }

    @JsonIgnore
    public IKaigoAtesakiJushoSetteiDiv getCcdKaigoAtesakiJushoSettei() {
        return this.getChohyoJusho().getCcdKaigoAtesakiJushoSettei();
    }

    // </editor-fold>
}
