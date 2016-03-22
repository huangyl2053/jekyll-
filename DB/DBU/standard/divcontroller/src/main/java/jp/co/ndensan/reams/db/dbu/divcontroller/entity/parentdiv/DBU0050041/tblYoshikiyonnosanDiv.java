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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    public tplZennendoizenDiv getTplZennendoizen() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen();
    }

    @JsonIgnore
    public void  setTplZennendoizen(tplZennendoizenDiv tplZennendoizen) {
        this.getTabZennendoizenMeisai().setTplZennendoizen(tplZennendoizen);
    }

    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsainyuseisan() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyuseisan();
    }

    @JsonIgnore
    public Label getSpc1() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getSpc1();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkakyufuhifukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchoseikofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchoseikofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchoseikofukin();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofuki() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblshiharaikikinkofuki();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkaigokyufuhikokin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkaigokyufuhikokin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblsainchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLbltodofukenkin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLbltodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofukenki() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLbltodofukenki();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaintodofukenfutankin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaintodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaittodofukenfutankin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaittodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblchiikishienjigyokofukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblchiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienjkin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienjkin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblsainyukin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainyukin();
    }

    @JsonIgnore
    public Label getLblsainippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitippankaiekikin() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaitippankaiekikin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohigokei() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTabZennendoizenMeisai().getTplZennendoizen().getTxtsaishutsugokei();
    }

    @JsonIgnore
    public tplKonnedoDiv getTplKonnedo() {
        return this.getTabKonnemeisai().getTplKonnedo();
    }

    @JsonIgnore
    public void  setTplKonnedo(tplKonnedoDiv tplKonnedo) {
        this.getTabKonnemeisai().setTplKonnedo(tplKonnedo);
    }

    @JsonIgnore
    public Label getLblkosaishu() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosaishu();
    }

    @JsonIgnore
    public Label getLblkosainyuseisan() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosainyuseisan();
    }

    @JsonIgnore
    public Label getSpc11() {
        return this.getTabKonnemeisai().getTplKonnedo().getSpc11();
    }

    @JsonIgnore
    public Label getLblkosaishutsu() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosaishutsu();
    }

    @JsonIgnore
    public Label getLblkokamoku() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkokamoku();
    }

    @JsonIgnore
    public Label getLblkosainkakyufuhifukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkakyufuhifukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkakyufuhifukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkokaigohokenryo() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkokaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchoseikofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchoseikofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkchoseikofukin();
    }

    @JsonIgnore
    public Label getLblkofuntannintei() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkofuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblshiharaikikinkofukin();
    }

    @JsonIgnore
    public Label getLblfkountansonota() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblfkountansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkaigokyufuhikokin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkaigokyufuhikokin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblkosainchiikishienkofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblkotodofukenkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkotodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofutankenkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLbltodofutankenkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainktodofukenfutankin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainktodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitktodofukenfutankin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitktodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkochiikishienjigyokofukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkochiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienjkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienjkin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblkosainyukin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosainyukin();
    }

    @JsonIgnore
    public Label getLblkosainippankaiekikin() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkosainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkippankaiekikin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsainkippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkippankaiekikin() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtsaitkippankaiekikin();
    }

    @JsonIgnore
    public Label getLblkoshiryooyobitesuryo() {
        return this.getTabKonnemeisai().getTplKonnedo().getLblkoshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkoshiyohigokei() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtkoshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaishutsugokei() {
        return this.getTabKonnemeisai().getTplKonnedo().getTxtkosaishutsugokei();
    }

    @JsonIgnore
    public tplJisshitsushiharaiDiv getTplJisshitsushiharai() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai();
    }

    @JsonIgnore
    public void  setTplJisshitsushiharai(tplJisshitsushiharaiDiv tplJisshitsushiharai) {
        this.getTabJisshitsushiharaimeisai().setTplJisshitsushiharai(tplJisshitsushiharai);
    }

    @JsonIgnore
    public Label getLblshitsusainyugokei() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyugokei() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusainyugokei();
    }

    @JsonIgnore
    public Label getLblshitsusaishutsugokei() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusaishutsugokei() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusaishutsugokei();
    }

    @JsonIgnore
    public Label getLblshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public Label getLblshitsuseisangozangaku() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getLblshitsuseisangozangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsuseisangozangaku() {
        return this.getTabJisshitsushiharaimeisai().getTplJisshitsushiharai().getTxtshitsuseisangozangaku();
    }

    // </editor-fold>
}
