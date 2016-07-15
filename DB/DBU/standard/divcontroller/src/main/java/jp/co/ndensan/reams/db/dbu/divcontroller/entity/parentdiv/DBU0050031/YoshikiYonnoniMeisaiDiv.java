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
 * YoshikiYonnoniMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiYonnoniMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokokuYM")
    private TextBoxFlexibleDate txtHokokuYM;
    @JsonProperty("txtShukeiYM")
    private TextBoxFlexibleDate txtShukeiYM;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("ddlShicyoson")
    private DropDownList ddlShicyoson;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("tplTokukaikeijokyo")
    private tplTokukaikeijokyoDiv tplTokukaikeijokyo;
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
     * gettxtHokokuYM
     * @return txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public TextBoxFlexibleDate getTxtHokokuYM() {
        return txtHokokuYM;
    }

    /*
     * settxtHokokuYM
     * @param txtHokokuYM txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public void setTxtHokokuYM(TextBoxFlexibleDate txtHokokuYM) {
        this.txtHokokuYM = txtHokokuYM;
    }

    /*
     * gettxtShukeiYM
     * @return txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public TextBoxFlexibleDate getTxtShukeiYM() {
        return txtShukeiYM;
    }

    /*
     * settxtShukeiYM
     * @param txtShukeiYM txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public void setTxtShukeiYM(TextBoxFlexibleDate txtShukeiYM) {
        this.txtShukeiYM = txtShukeiYM;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
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
     * gettplTokukaikeijokyo
     * @return tplTokukaikeijokyo
     */
    @JsonProperty("tplTokukaikeijokyo")
    public tplTokukaikeijokyoDiv getTplTokukaikeijokyo() {
        return tplTokukaikeijokyo;
    }

    /*
     * settplTokukaikeijokyo
     * @param tplTokukaikeijokyo tplTokukaikeijokyo
     */
    @JsonProperty("tplTokukaikeijokyo")
    public void setTplTokukaikeijokyo(tplTokukaikeijokyoDiv tplTokukaikeijokyo) {
        this.tplTokukaikeijokyo = tplTokukaikeijokyo;
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
        return this.getTplTokukaikeijokyo().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTplTokukaikeijokyo().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTplTokukaikeijokyo().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainyukessan() {
        return this.getTplTokukaikeijokyo().getLblsainyukessan();
    }

    @JsonIgnore
    public Label getLblsaishutsukamoku() {
        return this.getTplTokukaikeijokyo().getLblsaishutsukamoku();
    }

    @JsonIgnore
    public Label getLblsaishutsukessan() {
        return this.getTplTokukaikeijokyo().getLblsaishutsukessan();
    }

    @JsonIgnore
    public Label getLblhokenryo() {
        return this.getTplTokukaikeijokyo().getLblhokenryo();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTplTokukaikeijokyo().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigoshunyu() {
        return this.getTplTokukaikeijokyo().getTxtkaigoshunyu();
    }

    @JsonIgnore
    public Label getLblsaishutsusomu() {
        return this.getTplTokukaikeijokyo().getLblsaishutsusomu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsomu() {
        return this.getTplTokukaikeijokyo().getTxtsomu();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTplTokukaikeijokyo().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtyoboshunyu() {
        return this.getTplTokukaikeijokyo().getTxtyoboshunyu();
    }

    @JsonIgnore
    public Label getLblsaishutsuhokenkyufu() {
        return this.getTplTokukaikeijokyo().getLblsaishutsuhokenkyufu();
    }

    @JsonIgnore
    public Label getLblitakusabisu() {
        return this.getTplTokukaikeijokyo().getLblitakusabisu();
    }

    @JsonIgnore
    public TextBoxNum getTxtitakusabisu() {
        return this.getTplTokukaikeijokyo().getTxtitakusabisu();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTplTokukaikeijokyo().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxttokuteinyushoshunyu() {
        return this.getTplTokukaikeijokyo().getTxttokuteinyushoshunyu();
    }

    @JsonIgnore
    public Label getLblmitchaku() {
        return this.getTplTokukaikeijokyo().getLblmitchaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtmitchaku() {
        return this.getTplTokukaikeijokyo().getTxtmitchaku();
    }

    @JsonIgnore
    public Label getLblshiyooy() {
        return this.getTplTokukaikeijokyo().getLblshiyooy();
    }

    @JsonIgnore
    public TextBoxNum getTxtjiki() {
        return this.getTplTokukaikeijokyo().getTxtjiki();
    }

    @JsonIgnore
    public Label getLblitakugaigoshien() {
        return this.getTplTokukaikeijokyo().getLblitakugaigoshien();
    }

    @JsonIgnore
    public TextBoxNum getTxtitakugaigoshien() {
        return this.getTplTokukaikeijokyo().getTxtitakugaigoshien();
    }

    @JsonIgnore
    public Label getLbltesu() {
        return this.getTplTokukaikeijokyo().getLbltesu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsotashunyu() {
        return this.getTplTokukaikeijokyo().getTxtsotashunyu();
    }

    @JsonIgnore
    public Label getLbljigyosota() {
        return this.getTplTokukaikeijokyo().getLbljigyosota();
    }

    @JsonIgnore
    public TextBoxNum getTxtjigyosota() {
        return this.getTplTokukaikeijokyo().getTxtjigyosota();
    }

    @JsonIgnore
    public Label getLblbuntankinobutakin() {
        return this.getTplTokukaikeijokyo().getLblbuntankinobutakin();
    }

    @JsonIgnore
    public Label getLblbuntankin() {
        return this.getTplTokukaikeijokyo().getLblbuntankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtbuntankin() {
        return this.getTplTokukaikeijokyo().getTxtbuntankin();
    }

    @JsonIgnore
    public Label getLblshisetsuseibi() {
        return this.getTplTokukaikeijokyo().getLblshisetsuseibi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshisetsuseibi() {
        return this.getTplTokukaikeijokyo().getTxtshisetsuseibi();
    }

    @JsonIgnore
    public Label getLblchosei() {
        return this.getTplTokukaikeijokyo().getLblchosei();
    }

    @JsonIgnore
    public TextBoxNum getTxtfutankin() {
        return this.getTplTokukaikeijokyo().getTxtfutankin();
    }

    @JsonIgnore
    public Label getLblkikinsekin() {
        return this.getTplTokukaikeijokyo().getLblkikinsekin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkikinsekin() {
        return this.getTplTokukaikeijokyo().getTxtkikinsekin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTplTokukaikeijokyo().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public Label getLblshiyohi() {
        return this.getTplTokukaikeijokyo().getLblshiyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohi() {
        return this.getTplTokukaikeijokyo().getTxtshiyohi();
    }

    @JsonIgnore
    public Label getLblkosai() {
        return this.getTplTokukaikeijokyo().getLblkosai();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosai() {
        return this.getTplTokukaikeijokyo().getTxtkosai();
    }

    @JsonIgnore
    public Label getLbesuryo() {
        return this.getTplTokukaikeijokyo().getLbesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxttesuryo() {
        return this.getTplTokukaikeijokyo().getTxttesuryo();
    }

    @JsonIgnore
    public Label getLblyobihi() {
        return this.getTplTokukaikeijokyo().getLblyobihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobih() {
        return this.getTplTokukaikeijokyo().getTxtyobih();
    }

    @JsonIgnore
    public Label getLblkokko() {
        return this.getTplTokukaikeijokyo().getLblkokko();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokko() {
        return this.getTplTokukaikeijokyo().getTxtkokko();
    }

    @JsonIgnore
    public Label getLblshoshishutsukin() {
        return this.getTplTokukaikeijokyo().getLblshoshishutsukin();
    }

    @JsonIgnore
    public Label getLblshoshishutsu() {
        return this.getTplTokukaikeijokyo().getLblshoshishutsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshishutsu() {
        return this.getTplTokukaikeijokyo().getTxtshoshishutsu();
    }

    @JsonIgnore
    public Label getLbltodofuken() {
        return this.getTplTokukaikeijokyo().getLbltodofuken();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofuken() {
        return this.getTplTokukaikeijokyo().getTxttodofuken();
    }

    @JsonIgnore
    public Label getLblhokenkanjokuridasu() {
        return this.getTplTokukaikeijokyo().getLblhokenkanjokuridasu();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenkanjokuridasu() {
        return this.getTplTokukaikeijokyo().getTxthokenkanjokuridasu();
    }

    @JsonIgnore
    public Label getLblzaisannyu() {
        return this.getTplTokukaikeijokyo().getLblzaisannyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisannyu() {
        return this.getTplTokukaikeijokyo().getTxtzaisannyu();
    }

    @JsonIgnore
    public Label getLblshosonota() {
        return this.getTplTokukaikeijokyo().getLblshosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtshosonota() {
        return this.getTplTokukaikeijokyo().getTxtshosonota();
    }

    @JsonIgnore
    public Label getLblkifukin() {
        return this.getTplTokukaikeijokyo().getLblkifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkifukin() {
        return this.getTplTokukaikeijokyo().getTxtkifukin();
    }

    @JsonIgnore
    public Label getLblshohi() {
        return this.getTplTokukaikeijokyo().getLblshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtshohi() {
        return this.getTplTokukaikeijokyo().getTxtshohi();
    }

    @JsonIgnore
    public Label getLblkurikin() {
        return this.getTplTokukaikeijokyo().getLblkurikin();
    }

    @JsonIgnore
    public Label getLblhokenkanjokirijigyo() {
        return this.getTplTokukaikeijokyo().getLblhokenkanjokirijigyo();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenkanjokirijigyo() {
        return this.getTplTokukaikeijokyo().getTxthokenkanjokirijigyo();
    }

    @JsonIgnore
    public Label getLblchiikishienyobo() {
        return this.getTplTokukaikeijokyo().getLblchiikishienyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienyobo() {
        return this.getTplTokukaikeijokyo().getTxtchiikishienyobo();
    }

    @JsonIgnore
    public Label getLblkurikosu() {
        return this.getTplTokukaikeijokyo().getLblkurikosu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurikosu() {
        return this.getTplTokukaikeijokyo().getTxtkurikosu();
    }

    @JsonIgnore
    public Label getLblshichoson() {
        return this.getTplTokukaikeijokyo().getLblshichoson();
    }

    @JsonIgnore
    public TextBoxNum getTxtshichoson() {
        return this.getTplTokukaikeijokyo().getTxtshichoson();
    }

    @JsonIgnore
    public Label getLblshonyu() {
        return this.getTplTokukaikeijokyo().getLblshonyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshonyu() {
        return this.getTplTokukaikeijokyo().getTxtshonyu();
    }

    @JsonIgnore
    public Label getLblsainyugokei() {
        return this.getTplTokukaikeijokyo().getLblsainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyugokei() {
        return this.getTplTokukaikeijokyo().getTxtsainyugokei();
    }

    @JsonIgnore
    public Label getLblsaishutsugokei() {
        return this.getTplTokukaikeijokyo().getLblsaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTplTokukaikeijokyo().getTxtsaishutsugokei();
    }

    // </editor-fold>
}
