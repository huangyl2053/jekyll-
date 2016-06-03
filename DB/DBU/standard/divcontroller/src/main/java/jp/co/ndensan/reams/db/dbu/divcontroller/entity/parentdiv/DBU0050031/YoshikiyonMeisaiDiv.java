package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiyonMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiyonMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txthokokuYM")
    private TextBoxFlexibleDate txthokokuYM;
    @JsonProperty("txtShukeiY")
    private TextBoxFlexibleDate txtShukeiY;
    @JsonProperty("txtHihokenshabango")
    private TextBoxCode txtHihokenshabango;
    @JsonProperty("txthihokenshamei")
    private TextBox txthihokenshamei;
    @JsonProperty("ddlShicyoson")
    private DropDownList ddlShicyoson;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("tblTokukaikeijokyo")
    private tblTokukaikeijokyoDiv tblTokukaikeijokyo;
    @JsonProperty("txtsainyushutsusa")
    private TextBoxNum txtsainyushutsusa;
    @JsonProperty("txtuchikikinkurigaku")
    private TextBoxNum txtuchikikinkurigaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxthokokuYM
     * @return txthokokuYM
     */
    @JsonProperty("txthokokuYM")
    public TextBoxFlexibleDate getTxthokokuYM() {
        return txthokokuYM;
    }

    /*
     * settxthokokuYM
     * @param txthokokuYM txthokokuYM
     */
    @JsonProperty("txthokokuYM")
    public void setTxthokokuYM(TextBoxFlexibleDate txthokokuYM) {
        this.txthokokuYM = txthokokuYM;
    }

    /*
     * gettxtShukeiY
     * @return txtShukeiY
     */
    @JsonProperty("txtShukeiY")
    public TextBoxFlexibleDate getTxtShukeiY() {
        return txtShukeiY;
    }

    /*
     * settxtShukeiY
     * @param txtShukeiY txtShukeiY
     */
    @JsonProperty("txtShukeiY")
    public void setTxtShukeiY(TextBoxFlexibleDate txtShukeiY) {
        this.txtShukeiY = txtShukeiY;
    }

    /*
     * gettxtHihokenshabango
     * @return txtHihokenshabango
     */
    @JsonProperty("txtHihokenshabango")
    public TextBoxCode getTxtHihokenshabango() {
        return txtHihokenshabango;
    }

    /*
     * settxtHihokenshabango
     * @param txtHihokenshabango txtHihokenshabango
     */
    @JsonProperty("txtHihokenshabango")
    public void setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.txtHihokenshabango = txtHihokenshabango;
    }

    /*
     * gettxthihokenshamei
     * @return txthihokenshamei
     */
    @JsonProperty("txthihokenshamei")
    public TextBox getTxthihokenshamei() {
        return txthihokenshamei;
    }

    /*
     * settxthihokenshamei
     * @param txthihokenshamei txthihokenshamei
     */
    @JsonProperty("txthihokenshamei")
    public void setTxthihokenshamei(TextBox txthihokenshamei) {
        this.txthihokenshamei = txthihokenshamei;
    }

    /*
     * getddlShicyoson
     * @return ddlShicyoson
     */
    @JsonProperty("ddlShicyoson")
    public DropDownList getDdlShicyoson() {
        return ddlShicyoson;
    }

    /*
     * setddlShicyoson
     * @param ddlShicyoson ddlShicyoson
     */
    @JsonProperty("ddlShicyoson")
    public void setDdlShicyoson(DropDownList ddlShicyoson) {
        this.ddlShicyoson = ddlShicyoson;
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
     * gettblTokukaikeijokyo
     * @return tblTokukaikeijokyo
     */
    @JsonProperty("tblTokukaikeijokyo")
    public tblTokukaikeijokyoDiv getTblTokukaikeijokyo() {
        return tblTokukaikeijokyo;
    }

    /*
     * settblTokukaikeijokyo
     * @param tblTokukaikeijokyo tblTokukaikeijokyo
     */
    @JsonProperty("tblTokukaikeijokyo")
    public void setTblTokukaikeijokyo(tblTokukaikeijokyoDiv tblTokukaikeijokyo) {
        this.tblTokukaikeijokyo = tblTokukaikeijokyo;
    }

    /*
     * gettxtsainyushutsusa
     * @return txtsainyushutsusa
     */
    @JsonProperty("txtsainyushutsusa")
    public TextBoxNum getTxtsainyushutsusa() {
        return txtsainyushutsusa;
    }

    /*
     * settxtsainyushutsusa
     * @param txtsainyushutsusa txtsainyushutsusa
     */
    @JsonProperty("txtsainyushutsusa")
    public void setTxtsainyushutsusa(TextBoxNum txtsainyushutsusa) {
        this.txtsainyushutsusa = txtsainyushutsusa;
    }

    /*
     * gettxtuchikikinkurigaku
     * @return txtuchikikinkurigaku
     */
    @JsonProperty("txtuchikikinkurigaku")
    public TextBoxNum getTxtuchikikinkurigaku() {
        return txtuchikikinkurigaku;
    }

    /*
     * settxtuchikikinkurigaku
     * @param txtuchikikinkurigaku txtuchikikinkurigaku
     */
    @JsonProperty("txtuchikikinkurigaku")
    public void setTxtuchikikinkurigaku(TextBoxNum txtuchikikinkurigaku) {
        this.txtuchikikinkurigaku = txtuchikikinkurigaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTblTokukaikeijokyo().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTblTokukaikeijokyo().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTblTokukaikeijokyo().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainyukessan() {
        return this.getTblTokukaikeijokyo().getLblsainyukessan();
    }

    @JsonIgnore
    public Label getLblsaishutsukamoku() {
        return this.getTblTokukaikeijokyo().getLblsaishutsukamoku();
    }

    @JsonIgnore
    public Label getLblsaishutsukessan() {
        return this.getTblTokukaikeijokyo().getLblsaishutsukessan();
    }

    @JsonIgnore
    public Label getLblhokenryo() {
        return this.getTblTokukaikeijokyo().getLblhokenryo();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTblTokukaikeijokyo().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigoshunyu() {
        return this.getTblTokukaikeijokyo().getTxtkaigoshunyu();
    }

    @JsonIgnore
    public Label getLblsaishutsusomu() {
        return this.getTblTokukaikeijokyo().getLblsaishutsusomu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsomu() {
        return this.getTblTokukaikeijokyo().getTxtsomu();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTblTokukaikeijokyo().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtyoboshunyu() {
        return this.getTblTokukaikeijokyo().getTxtyoboshunyu();
    }

    @JsonIgnore
    public Label getLblsaishutsuhokenkyufu() {
        return this.getTblTokukaikeijokyo().getLblsaishutsuhokenkyufu();
    }

    @JsonIgnore
    public Label getLblitakusabisu() {
        return this.getTblTokukaikeijokyo().getLblitakusabisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtitakusabisu() {
        return this.getTblTokukaikeijokyo().getTxtitakusabisu();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTblTokukaikeijokyo().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxttokuteinyushoshunyu() {
        return this.getTblTokukaikeijokyo().getTxttokuteinyushoshunyu();
    }

    @JsonIgnore
    public Label getLblmitchaku() {
        return this.getTblTokukaikeijokyo().getLblmitchaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtmitchaku() {
        return this.getTblTokukaikeijokyo().getTxtmitchaku();
    }

    @JsonIgnore
    public Label getLblshiyooy() {
        return this.getTblTokukaikeijokyo().getLblshiyooy();
    }

    @JsonIgnore
    public TextBoxNum getTxtjiki() {
        return this.getTblTokukaikeijokyo().getTxtjiki();
    }

    @JsonIgnore
    public Label getLblitakugaigoshien() {
        return this.getTblTokukaikeijokyo().getLblitakugaigoshien();
    }

    @JsonIgnore
    public TextBoxNum getTxtitakugaigoshien() {
        return this.getTblTokukaikeijokyo().getTxtitakugaigoshien();
    }

    @JsonIgnore
    public Label getLbltesu() {
        return this.getTblTokukaikeijokyo().getLbltesu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsotashunyu() {
        return this.getTblTokukaikeijokyo().getTxtsotashunyu();
    }

    @JsonIgnore
    public Label getLbljigyosota() {
        return this.getTblTokukaikeijokyo().getLbljigyosota();
    }

    @JsonIgnore
    public TextBoxNum getTxtjigyosota() {
        return this.getTblTokukaikeijokyo().getTxtjigyosota();
    }

    @JsonIgnore
    public Label getLblbuntankinobutakin() {
        return this.getTblTokukaikeijokyo().getLblbuntankinobutakin();
    }

    @JsonIgnore
    public Label getLblbuntankin() {
        return this.getTblTokukaikeijokyo().getLblbuntankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtbuntankin() {
        return this.getTblTokukaikeijokyo().getTxtbuntankin();
    }

    @JsonIgnore
    public Label getLblshisetsuseibi() {
        return this.getTblTokukaikeijokyo().getLblshisetsuseibi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshisetsuseibi() {
        return this.getTblTokukaikeijokyo().getTxtshisetsuseibi();
    }

    @JsonIgnore
    public Label getLblchosei() {
        return this.getTblTokukaikeijokyo().getLblchosei();
    }

    @JsonIgnore
    public TextBoxNum getTxtfutankin() {
        return this.getTblTokukaikeijokyo().getTxtfutankin();
    }

    @JsonIgnore
    public Label getLblkikinsekin() {
        return this.getTblTokukaikeijokyo().getLblkikinsekin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkikinsekin() {
        return this.getTblTokukaikeijokyo().getTxtkikinsekin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTblTokukaikeijokyo().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public Label getLblshiyohi() {
        return this.getTblTokukaikeijokyo().getLblshiyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohi() {
        return this.getTblTokukaikeijokyo().getTxtshiyohi();
    }

    @JsonIgnore
    public Label getLblkosai() {
        return this.getTblTokukaikeijokyo().getLblkosai();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosai() {
        return this.getTblTokukaikeijokyo().getTxtkosai();
    }

    @JsonIgnore
    public Label getLbesuryo() {
        return this.getTblTokukaikeijokyo().getLbesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxttesuryo() {
        return this.getTblTokukaikeijokyo().getTxttesuryo();
    }

    @JsonIgnore
    public Label getLblyobihi() {
        return this.getTblTokukaikeijokyo().getLblyobihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobih() {
        return this.getTblTokukaikeijokyo().getTxtyobih();
    }

    @JsonIgnore
    public Label getLblkokko() {
        return this.getTblTokukaikeijokyo().getLblkokko();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokko() {
        return this.getTblTokukaikeijokyo().getTxtkokko();
    }

    @JsonIgnore
    public Label getLblshoshishutsukin() {
        return this.getTblTokukaikeijokyo().getLblshoshishutsukin();
    }

    @JsonIgnore
    public Label getLblshoshishutsu() {
        return this.getTblTokukaikeijokyo().getLblshoshishutsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshishutsu() {
        return this.getTblTokukaikeijokyo().getTxtshoshishutsu();
    }

    @JsonIgnore
    public Label getLbltodofuken() {
        return this.getTblTokukaikeijokyo().getLbltodofuken();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofuken() {
        return this.getTblTokukaikeijokyo().getTxttodofuken();
    }

    @JsonIgnore
    public Label getLblhokenkanjokuridasu() {
        return this.getTblTokukaikeijokyo().getLblhokenkanjokuridasu();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenkanjokuridasu() {
        return this.getTblTokukaikeijokyo().getTxthokenkanjokuridasu();
    }

    @JsonIgnore
    public Label getLblzaisannyu() {
        return this.getTblTokukaikeijokyo().getLblzaisannyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisannyu() {
        return this.getTblTokukaikeijokyo().getTxtzaisannyu();
    }

    @JsonIgnore
    public Label getLblshosonota() {
        return this.getTblTokukaikeijokyo().getLblshosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtshosonota() {
        return this.getTblTokukaikeijokyo().getTxtshosonota();
    }

    @JsonIgnore
    public Label getLblkifukin() {
        return this.getTblTokukaikeijokyo().getLblkifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkifukin() {
        return this.getTblTokukaikeijokyo().getTxtkifukin();
    }

    @JsonIgnore
    public Label getLblshohi() {
        return this.getTblTokukaikeijokyo().getLblshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshohi() {
        return this.getTblTokukaikeijokyo().getTxtshohi();
    }

    @JsonIgnore
    public Label getLblkurikin() {
        return this.getTblTokukaikeijokyo().getLblkurikin();
    }

    @JsonIgnore
    public Label getLblhokenkanjokirijigyo() {
        return this.getTblTokukaikeijokyo().getLblhokenkanjokirijigyo();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenkanjokirijigyo() {
        return this.getTblTokukaikeijokyo().getTxthokenkanjokirijigyo();
    }

    @JsonIgnore
    public Label getLblchiikishienyobo() {
        return this.getTblTokukaikeijokyo().getLblchiikishienyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienyobo() {
        return this.getTblTokukaikeijokyo().getTxtchiikishienyobo();
    }

    @JsonIgnore
    public Label getLblkurikosu() {
        return this.getTblTokukaikeijokyo().getLblkurikosu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurikosu() {
        return this.getTblTokukaikeijokyo().getTxtkurikosu();
    }

    @JsonIgnore
    public Label getLblshichoson() {
        return this.getTblTokukaikeijokyo().getLblshichoson();
    }

    @JsonIgnore
    public TextBoxNum getTxtshichoson() {
        return this.getTblTokukaikeijokyo().getTxtshichoson();
    }

    @JsonIgnore
    public Label getLblshonyu() {
        return this.getTblTokukaikeijokyo().getLblshonyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshonyu() {
        return this.getTblTokukaikeijokyo().getTxtshonyu();
    }

    @JsonIgnore
    public Label getLblsainyugokei() {
        return this.getTblTokukaikeijokyo().getLblsainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyugokei() {
        return this.getTblTokukaikeijokyo().getTxtsainyugokei();
    }

    @JsonIgnore
    public Label getLblsaishutsugokei() {
        return this.getTblTokukaikeijokyo().getLblsaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTblTokukaikeijokyo().getTxtsaishutsugokei();
    }

    // </editor-fold>
}
