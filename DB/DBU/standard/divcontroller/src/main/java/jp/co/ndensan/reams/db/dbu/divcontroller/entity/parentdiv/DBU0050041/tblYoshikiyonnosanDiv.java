package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tblYoshikiyonnosan のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblYoshikiyonnosanDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabZennendoizenMeisai")
    private tabZennendoizenMeisaiDiv tabZennendoizenMeisai;
    @JsonProperty("tabKonnemeisai")
    private tabKonnemeisaiDiv tabKonnemeisai;
    @JsonProperty("tabJisshitsushiharaimeisai")
    private tabJisshitsushiharaimeisaiDiv tabJisshitsushiharaimeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabZennendoizenMeisai
     * @return tabZennendoizenMeisai
     */
    @JsonProperty("tabZennendoizenMeisai")
    public tabZennendoizenMeisaiDiv getTabZennendoizenMeisai() {
        return tabZennendoizenMeisai;
    }

    /*
     * settabZennendoizenMeisai
     * @param tabZennendoizenMeisai tabZennendoizenMeisai
     */
    @JsonProperty("tabZennendoizenMeisai")
    public void setTabZennendoizenMeisai(tabZennendoizenMeisaiDiv tabZennendoizenMeisai) {
        this.tabZennendoizenMeisai = tabZennendoizenMeisai;
    }

    /*
     * gettabKonnemeisai
     * @return tabKonnemeisai
     */
    @JsonProperty("tabKonnemeisai")
    public tabKonnemeisaiDiv getTabKonnemeisai() {
        return tabKonnemeisai;
    }

    /*
     * settabKonnemeisai
     * @param tabKonnemeisai tabKonnemeisai
     */
    @JsonProperty("tabKonnemeisai")
    public void setTabKonnemeisai(tabKonnemeisaiDiv tabKonnemeisai) {
        this.tabKonnemeisai = tabKonnemeisai;
    }

    /*
     * gettabJisshitsushiharaimeisai
     * @return tabJisshitsushiharaimeisai
     */
    @JsonProperty("tabJisshitsushiharaimeisai")
    public tabJisshitsushiharaimeisaiDiv getTabJisshitsushiharaimeisai() {
        return tabJisshitsushiharaimeisai;
    }

    /*
     * settabJisshitsushiharaimeisai
     * @param tabJisshitsushiharaimeisai tabJisshitsushiharaimeisai
     */
    @JsonProperty("tabJisshitsushiharaimeisai")
    public void setTabJisshitsushiharaimeisai(tabJisshitsushiharaimeisaiDiv tabJisshitsushiharaimeisai) {
        this.tabJisshitsushiharaimeisai = tabJisshitsushiharaimeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblZennendoizenDiv getTblZennendoizen() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen();
    }

    @JsonIgnore
    public void  setTblZennendoizen(tblZennendoizenDiv tblZennendoizen) {
        this.getTabZennendoizenMeisai().setTblZennendoizen(tblZennendoizen);
    }

    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsainyuseisan() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainyuseisan();
    }

    @JsonIgnore
    public Label getSpc1() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getSpc1();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchoseikofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchoseikofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitchoseikofukin();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofuki() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblshiharaikikinkofuki();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkaigokyufuhikokin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkaigokyufuhikokin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblsainchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLbltodofukenkin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLbltodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofukenki() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLbltodofukenki();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaintodofukenfutankin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaintodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaittodofukenfutankin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaittodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblchiikishienjigyokofukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblchiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienjkin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienjkin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblsainyukin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainyukin();
    }

    @JsonIgnore
    public Label getLblsainippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaitippankaiekikin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohigokei() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTabZennendoizenMeisai().getTblZennendoizen().getTxtsaishutsugokei();
    }

    @JsonIgnore
    public tabKonnedoDiv getTabKonnedo() {
        return this.getTabKonnemeisai().getTabKonnedo();
    }

    @JsonIgnore
    public void  setTabKonnedo(tabKonnedoDiv tabKonnedo) {
        this.getTabKonnemeisai().setTabKonnedo(tabKonnedo);
    }

    @JsonIgnore
    public Label getLblkosaishu() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosaishu();
    }

    @JsonIgnore
    public Label getLblkosainyuseisan() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosainyuseisan();
    }

    @JsonIgnore
    public Label getSpc11() {
        return this.getTabKonnemeisai().getTabKonnedo().getSpc11();
    }

    @JsonIgnore
    public Label getLblkosaishutsu() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosaishutsu();
    }

    @JsonIgnore
    public Label getLblkokamoku() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkokamoku();
    }

    @JsonIgnore
    public Label getLblkosainkakyufuhifukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkakyufuhifukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkakyufuhifukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkokaigohokenryo() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkokaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchoseikofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchoseikofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkchoseikofukin();
    }

    @JsonIgnore
    public Label getLblkofuntannintei() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkofuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblshiharaikikinkofukin();
    }

    @JsonIgnore
    public Label getLblfkountansonota() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblfkountansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkaigokyufuhikokin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkaigokyufuhikokin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblkosainchiikishienkofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblkotodofukenkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkotodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofutankenkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLbltodofutankenkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainktodofukenfutankin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainktodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitktodofukenfutankin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitktodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkochiikishienjigyokofukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkochiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienjkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienjkin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblkosainyukin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosainyukin();
    }

    @JsonIgnore
    public Label getLblkosainippankaiekikin() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkosainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkippankaiekikin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsainkippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkippankaiekikin() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtsaitkippankaiekikin();
    }

    @JsonIgnore
    public Label getLblkoshiryooyobitesuryo() {
        return this.getTabKonnemeisai().getTabKonnedo().getLblkoshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkoshiyohigokei() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtkoshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaishutsugokei() {
        return this.getTabKonnemeisai().getTabKonnedo().getTxtkosaishutsugokei();
    }

    @JsonIgnore
    public tabJisshitsushiharaiDiv getTabJisshitsushiharai() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai();
    }

    @JsonIgnore
    public void  setTabJisshitsushiharai(tabJisshitsushiharaiDiv tabJisshitsushiharai) {
        this.getTabJisshitsushiharaimeisai().setTabJisshitsushiharai(tabJisshitsushiharai);
    }

    @JsonIgnore
    public Label getLblshitsusainyugokei() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getLblshitsusainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyugokei() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getTxtshitsusainyugokei();
    }

    @JsonIgnore
    public Label getLblshitsusaishutsugokei() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getLblshitsusaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusaishutsugokei() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getTxtshitsusaishutsugokei();
    }

    @JsonIgnore
    public Label getLblshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getLblshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getTxtshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public Label getLblshitsuseisangozangaku() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getLblshitsuseisangozangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsuseisangozangaku() {
        return this.getTabJisshitsushiharaimeisai().getTabJisshitsushiharai().getTxtshitsuseisangozangaku();
    }

    // </editor-fold>
}
