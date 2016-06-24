package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KoikiShichosonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikiShichosonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShichosonJoho1")
    private ShichosonJoho1Div ShichosonJoho1;
    @JsonProperty("ShichosonJoho2")
    private ShichosonJoho2Div ShichosonJoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShichosonJoho1
     * @return ShichosonJoho1
     */
    @JsonProperty("ShichosonJoho1")
    public ShichosonJoho1Div getShichosonJoho1() {
        return ShichosonJoho1;
    }

    /*
     * setShichosonJoho1
     * @param ShichosonJoho1 ShichosonJoho1
     */
    @JsonProperty("ShichosonJoho1")
    public void setShichosonJoho1(ShichosonJoho1Div ShichosonJoho1) {
        this.ShichosonJoho1 = ShichosonJoho1;
    }

    /*
     * getShichosonJoho2
     * @return ShichosonJoho2
     */
    @JsonProperty("ShichosonJoho2")
    public ShichosonJoho2Div getShichosonJoho2() {
        return ShichosonJoho2;
    }

    /*
     * setShichosonJoho2
     * @param ShichosonJoho2 ShichosonJoho2
     */
    @JsonProperty("ShichosonJoho2")
    public void setShichosonJoho2(ShichosonJoho2Div ShichosonJoho2) {
        this.ShichosonJoho2 = ShichosonJoho2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtShichonoShikibetsuID() {
        return this.getShichosonJoho1().getTxtShichonoShikibetsuID();
    }

    @JsonIgnore
    public void  setTxtShichonoShikibetsuID(TextBoxCode txtShichonoShikibetsuID) {
        this.getShichosonJoho1().setTxtShichonoShikibetsuID(txtShichonoShikibetsuID);
    }

    @JsonIgnore
    public TextBoxCode getTxtKokuhorenShichosonNo() {
        return this.getShichosonJoho1().getTxtKokuhorenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtKokuhorenShichosonNo(TextBoxCode txtKokuhorenShichosonNo) {
        this.getShichosonJoho1().setTxtKokuhorenShichosonNo(txtKokuhorenShichosonNo);
    }

    @JsonIgnore
    public TextBox getTxtTodofukenName() {
        return this.getShichosonJoho1().getTxtTodofukenName();
    }

    @JsonIgnore
    public void  setTxtTodofukenName(TextBox txtTodofukenName) {
        this.getShichosonJoho1().setTxtTodofukenName(txtTodofukenName);
    }

    @JsonIgnore
    public TextBox getTxtShichosonName() {
        return this.getShichosonJoho1().getTxtShichosonName();
    }

    @JsonIgnore
    public void  setTxtShichosonName(TextBox txtShichosonName) {
        this.getShichosonJoho1().setTxtShichosonName(txtShichosonName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShichosonJoho1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShichosonJoho1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinShimei() {
        return this.getShichosonJoho1().getDdlGaikokujinShimei();
    }

    @JsonIgnore
    public void  setDdlGaikokujinShimei(DropDownList ddlGaikokujinShimei) {
        this.getShichosonJoho1().setDdlGaikokujinShimei(ddlGaikokujinShimei);
    }

    @JsonIgnore
    public DropDownList getDdlSaiyusenChikuCode() {
        return this.getShichosonJoho1().getDdlSaiyusenChikuCode();
    }

    @JsonIgnore
    public void  setDdlSaiyusenChikuCode(DropDownList ddlSaiyusenChikuCode) {
        this.getShichosonJoho1().setDdlSaiyusenChikuCode(ddlSaiyusenChikuCode);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKanyuYMD() {
        return this.getShichosonJoho1().getTxtKanyuYMD();
    }

    @JsonIgnore
    public void  setTxtKanyuYMD(TextBoxFlexibleDate txtKanyuYMD) {
        this.getShichosonJoho1().setTxtKanyuYMD(txtKanyuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuHikidashiHoho() {
        return this.getShichosonJoho1().getDdlShotokuHikidashiHoho();
    }

    @JsonIgnore
    public void  setDdlShotokuHikidashiHoho(DropDownList ddlShotokuHikidashiHoho) {
        this.getShichosonJoho1().setDdlShotokuHikidashiHoho(ddlShotokuHikidashiHoho);
    }

    @JsonIgnore
    public DropDownList getDdlTokuchoBunpai() {
        return this.getShichosonJoho1().getDdlTokuchoBunpai();
    }

    @JsonIgnore
    public void  setDdlTokuchoBunpai(DropDownList ddlTokuchoBunpai) {
        this.getShichosonJoho1().setDdlTokuchoBunpai(ddlTokuchoBunpai);
    }

    @JsonIgnore
    public TextBoxCode getTxtShokisaiHokenshaNo() {
        return this.getShichosonJoho2().getTxtShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaNo(TextBoxCode txtShokisaiHokenshaNo) {
        this.getShichosonJoho2().setTxtShokisaiHokenshaNo(txtShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShichosonCode() {
        return this.getShichosonJoho2().getTxtShichosonCode();
    }

    @JsonIgnore
    public void  setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.getShichosonJoho2().setTxtShichosonCode(txtShichosonCode);
    }

    @JsonIgnore
    public TextBox getTxtGunName() {
        return this.getShichosonJoho2().getTxtGunName();
    }

    @JsonIgnore
    public void  setTxtGunName(TextBox txtGunName) {
        this.getShichosonJoho2().setTxtGunName(txtGunName);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getShichosonJoho2().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getShichosonJoho2().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getShichosonJoho2().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getShichosonJoho2().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return this.getShichosonJoho2().getTxtRojinHokenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.getShichosonJoho2().setTxtRojinHokenShichosonNo(txtRojinHokenShichosonNo);
    }

    @JsonIgnore
    public DropDownList getDdlRojinHokenJukyushaNoTaikei() {
        return this.getShichosonJoho2().getDdlRojinHokenJukyushaNoTaikei();
    }

    @JsonIgnore
    public void  setDdlRojinHokenJukyushaNoTaikei(DropDownList ddlRojinHokenJukyushaNoTaikei) {
        this.getShichosonJoho2().setDdlRojinHokenJukyushaNoTaikei(ddlRojinHokenJukyushaNoTaikei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtDattaiYMD() {
        return this.getShichosonJoho2().getTxtDattaiYMD();
    }

    @JsonIgnore
    public void  setTxtDattaiYMD(TextBoxFlexibleDate txtDattaiYMD) {
        this.getShichosonJoho2().setTxtDattaiYMD(txtDattaiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlNofugakuDataRenkei() {
        return this.getShichosonJoho2().getDdlNofugakuDataRenkei();
    }

    @JsonIgnore
    public void  setDdlNofugakuDataRenkei(DropDownList ddlNofugakuDataRenkei) {
        this.getShichosonJoho2().setDdlNofugakuDataRenkei(ddlNofugakuDataRenkei);
    }

    @JsonIgnore
    public Space getBlank1() {
        return this.getShichosonJoho2().getBlank1();
    }

    @JsonIgnore
    public void  setBlank1(Space blank1) {
        this.getShichosonJoho2().setBlank1(blank1);
    }

    // </editor-fold>
}
