package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
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
 * YoshikiYonnosanMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiYonnosanMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokokuYM")
    private TextBoxDate txtHokokuYM;
    @JsonProperty("txtShukeiYM")
    private TextBoxDate txtShukeiYM;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("ddlShicyoson")
    private DropDownList ddlShicyoson;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("tblYoshikiyonnosan")
    private tblYoshikiyonnosanDiv tblYoshikiyonnosan;

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
    public TextBoxDate getTxtHokokuYM() {
        return txtHokokuYM;
    }

    /*
     * settxtHokokuYM
     * @param txtHokokuYM txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public void setTxtHokokuYM(TextBoxDate txtHokokuYM) {
        this.txtHokokuYM = txtHokokuYM;
    }

    /*
     * gettxtShukeiYM
     * @return txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public TextBoxDate getTxtShukeiYM() {
        return txtShukeiYM;
    }

    /*
     * settxtShukeiYM
     * @param txtShukeiYM txtShukeiYM
     */
    @JsonProperty("txtShukeiYM")
    public void setTxtShukeiYM(TextBoxDate txtShukeiYM) {
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
     * gettblYoshikiyonnosan
     * @return tblYoshikiyonnosan
     */
    @JsonProperty("tblYoshikiyonnosan")
    public tblYoshikiyonnosanDiv getTblYoshikiyonnosan() {
        return tblYoshikiyonnosan;
    }

    /*
     * settblYoshikiyonnosan
     * @param tblYoshikiyonnosan tblYoshikiyonnosan
     */
    @JsonProperty("tblYoshikiyonnosan")
    public void setTblYoshikiyonnosan(tblYoshikiyonnosanDiv tblYoshikiyonnosan) {
        this.tblYoshikiyonnosan = tblYoshikiyonnosan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabZennendoizenMeisaiDiv getTabZennendoizenMeisai() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai();
    }

    @JsonIgnore
    public void  setTabZennendoizenMeisai(tabZennendoizenMeisaiDiv tabZennendoizenMeisai) {
        this.getTblYoshikiyonnosan().setTabZennendoizenMeisai(tabZennendoizenMeisai);
    }

    @JsonIgnore
    public tplZennendoizenDiv getTplZennendoizen() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen();
    }

    @JsonIgnore
    public void  setTplZennendoizen(tplZennendoizenDiv tplZennendoizen) {
        this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().setTplZennendoizen(tplZennendoizen);
    }

    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsainyuseisan() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyuseisan();
    }

    @JsonIgnore
    public Label getSpc1() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getSpc1();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchoseikofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchoseikofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchoseikofukin();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofuki() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblshiharaikikinkofuki();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkaigokyufuhikokin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkaigokyufuhikokin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblsainchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLbltodofukenkin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLbltodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofukenki() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLbltodofukenki();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaintodofukenfutankin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaintodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaittodofukenfutankin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaittodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblchiikishienjigyokofukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblchiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienjkin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienjkin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblsainyukin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyukin();
    }

    @JsonIgnore
    public Label getLblsainippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitippankaiekikin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohigokei() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTblYoshikiyonnosan().getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaishutsugokei();
    }

    @JsonIgnore
    public tabKonnemeisaiDiv getTabKonnemeisai() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai();
    }

    @JsonIgnore
    public void  setTabKonnemeisai(tabKonnemeisaiDiv tabKonnemeisai) {
        this.getTblYoshikiyonnosan().setTabKonnemeisai(tabKonnemeisai);
    }

    @JsonIgnore
    public tplKonnedoDiv getTplKonnedo() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo();
    }

    @JsonIgnore
    public void  setTplKonnedo(tplKonnedoDiv tplKonnedo) {
        this.getTblYoshikiyonnosan().getTabKonnemeisai().setTplKonnedo(tplKonnedo);
    }

    @JsonIgnore
    public Label getLblkosaishu() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosaishu();
    }

    @JsonIgnore
    public Label getLblkosainyuseisan() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosainyuseisan();
    }

    @JsonIgnore
    public Label getSpc11() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getSpc11();
    }

    @JsonIgnore
    public Label getLblkosaishutsu() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosaishutsu();
    }

    @JsonIgnore
    public Label getLblkokamoku() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkokamoku();
    }

    @JsonIgnore
    public Label getLblkosainkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkakyufuhifukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkokaigohokenryo() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkokaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchoseikofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchoseikofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkchoseikofukin();
    }

    @JsonIgnore
    public Label getLblkofuntannintei() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkofuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblshiharaikikinkofukin();
    }

    @JsonIgnore
    public Label getLblfkountansonota() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblfkountansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkaigokyufuhikokin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkaigokyufuhikokin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblkosainchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblkotodofukenkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkotodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofutankenkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLbltodofutankenkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainktodofukenfutankin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainktodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitktodofukenfutankin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitktodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkochiikishienjigyokofukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkochiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienjkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienjkin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblkosainyukin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosainyukin();
    }

    @JsonIgnore
    public Label getLblkosainippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkosainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsainkippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkippankaiekikin() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtsaitkippankaiekikin();
    }

    @JsonIgnore
    public Label getLblkoshiryooyobitesuryo() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getLblkoshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkoshiyohigokei() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtkoshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaishutsugokei() {
        return this.getTblYoshikiyonnosan().getTabKonnemeisai().getTplKonnedo().getTxtkosaishutsugokei();
    }

    @JsonIgnore
    public tabJisshitsushiharaimeisaiDiv getTabJisshitsushiharaimeisai() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai();
    }

    @JsonIgnore
    public void  setTabJisshitsushiharaimeisai(tabJisshitsushiharaimeisaiDiv tabJisshitsushiharaimeisai) {
        this.getTblYoshikiyonnosan().setTabJisshitsushiharaimeisai(tabJisshitsushiharaimeisai);
    }

    @JsonIgnore
    public tplJisshitsushiharaiDiv getTplJisshitsushiharai() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai();
    }

    @JsonIgnore
    public void  setTplJisshitsushiharai(tplJisshitsushiharaiDiv tplJisshitsushiharai) {
        this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().setTplJisshitsushiharai(tplJisshitsushiharai);
    }

    @JsonIgnore
    public Label getLblshitsusainyugokei() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyugokei() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusainyugokei();
    }

    @JsonIgnore
    public Label getLblshitsusaishutsugokei() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusaishutsugokei() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusaishutsugokei();
    }

    @JsonIgnore
    public Label getLblshitsusainyusaishutsusa() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyusaishutsusa() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public Label getLblshitsuseisangozangaku() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsuseisangozangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsuseisangozangaku() {
        return this.getTblYoshikiyonnosan().getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsuseisangozangaku();
    }

    // </editor-fold>
}
