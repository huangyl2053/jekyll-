package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabZennendoizenMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabZennendoizenMeisaiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplZennendoizen")
    private tplZennendoizenDiv tplZennendoizen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplZennendoizen
     * @return tplZennendoizen
     */
    @JsonProperty("tplZennendoizen")
    public tplZennendoizenDiv getTplZennendoizen() {
        return tplZennendoizen;
    }

    /*
     * settplZennendoizen
     * @param tplZennendoizen tplZennendoizen
     */
    @JsonProperty("tplZennendoizen")
    public void setTplZennendoizen(tplZennendoizenDiv tplZennendoizen) {
        this.tplZennendoizen = tplZennendoizen;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTplZennendoizen().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsainyuseisan() {
        return this.getTplZennendoizen().getLblsainyuseisan();
    }

    @JsonIgnore
    public Label getSpc1() {
        return this.getTplZennendoizen().getSpc1();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTplZennendoizen().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTplZennendoizen().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainkakyufuhifukin() {
        return this.getTplZennendoizen().getLblsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkakyufuhifukin() {
        return this.getTplZennendoizen().getTxtsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkakyufuhifukin() {
        return this.getTplZennendoizen().getTxtsaitkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTplZennendoizen().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchoseikofukin() {
        return this.getTplZennendoizen().getTxtsainchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchoseikofukin() {
        return this.getTplZennendoizen().getTxtsaitchoseikofukin();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTplZennendoizen().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkin() {
        return this.getTplZennendoizen().getTxtsainchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkin() {
        return this.getTplZennendoizen().getTxtsaitchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofuki() {
        return this.getTplZennendoizen().getLblshiharaikikinkofuki();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTplZennendoizen().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkaigokyufuhikokin() {
        return this.getTplZennendoizen().getTxtsainkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkaigokyufuhikokin() {
        return this.getTplZennendoizen().getTxtsaitkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblsainchiikishienkofukin() {
        return this.getTplZennendoizen().getLblsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkofukin() {
        return this.getTplZennendoizen().getTxtsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkofukin() {
        return this.getTplZennendoizen().getTxtsaitchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLbltodofukenkin() {
        return this.getTplZennendoizen().getLbltodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofukenki() {
        return this.getTplZennendoizen().getLbltodofukenki();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaintodofukenfutankin() {
        return this.getTplZennendoizen().getTxtsaintodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaittodofukenfutankin() {
        return this.getTplZennendoizen().getTxtsaittodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblchiikishienjigyokofukin() {
        return this.getTplZennendoizen().getLblchiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienjkin() {
        return this.getTplZennendoizen().getTxtsainchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienjkin() {
        return this.getTplZennendoizen().getTxtsaitchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblsainyukin() {
        return this.getTplZennendoizen().getLblsainyukin();
    }

    @JsonIgnore
    public Label getLblsainippankaiekikin() {
        return this.getTplZennendoizen().getLblsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainippankaiekikin() {
        return this.getTplZennendoizen().getTxtsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitippankaiekikin() {
        return this.getTplZennendoizen().getTxtsaitippankaiekikin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTplZennendoizen().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohigokei() {
        return this.getTplZennendoizen().getTxtshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTplZennendoizen().getTxtsaishutsugokei();
    }

    // </editor-fold>
}
