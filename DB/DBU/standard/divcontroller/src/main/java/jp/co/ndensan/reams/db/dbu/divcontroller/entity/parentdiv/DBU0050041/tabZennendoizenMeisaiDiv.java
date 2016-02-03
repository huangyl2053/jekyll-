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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblZennendoizen")
    private tblZennendoizenDiv tblZennendoizen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblZennendoizen
     * @return tblZennendoizen
     */
    @JsonProperty("tblZennendoizen")
    public tblZennendoizenDiv getTblZennendoizen() {
        return tblZennendoizen;
    }

    /*
     * settblZennendoizen
     * @param tblZennendoizen tblZennendoizen
     */
    @JsonProperty("tblZennendoizen")
    public void setTblZennendoizen(tblZennendoizenDiv tblZennendoizen) {
        this.tblZennendoizen = tblZennendoizen;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblsainyu() {
        return this.getTblZennendoizen().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsainyuseisan() {
        return this.getTblZennendoizen().getLblsainyuseisan();
    }

    @JsonIgnore
    public Label getSpc1() {
        return this.getTblZennendoizen().getSpc1();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getTblZennendoizen().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getTblZennendoizen().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainkakyufuhifukin() {
        return this.getTblZennendoizen().getLblsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkakyufuhifukin() {
        return this.getTblZennendoizen().getTxtsainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkakyufuhifukin() {
        return this.getTblZennendoizen().getTxtsaitkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getTblZennendoizen().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchoseikofukin() {
        return this.getTblZennendoizen().getTxtsainchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchoseikofukin() {
        return this.getTblZennendoizen().getTxtsaitchoseikofukin();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getTblZennendoizen().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkin() {
        return this.getTblZennendoizen().getTxtsainchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkin() {
        return this.getTblZennendoizen().getTxtsaitchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofuki() {
        return this.getTblZennendoizen().getLblshiharaikikinkofuki();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getTblZennendoizen().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkaigokyufuhikokin() {
        return this.getTblZennendoizen().getTxtsainkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkaigokyufuhikokin() {
        return this.getTblZennendoizen().getTxtsaitkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblsainchiikishienkofukin() {
        return this.getTblZennendoizen().getLblsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienkofukin() {
        return this.getTblZennendoizen().getTxtsainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienkofukin() {
        return this.getTblZennendoizen().getTxtsaitchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLbltodofukenkin() {
        return this.getTblZennendoizen().getLbltodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofukenki() {
        return this.getTblZennendoizen().getLbltodofukenki();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaintodofukenfutankin() {
        return this.getTblZennendoizen().getTxtsaintodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaittodofukenfutankin() {
        return this.getTblZennendoizen().getTxtsaittodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblchiikishienjigyokofukin() {
        return this.getTblZennendoizen().getLblchiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainchiikishienjkin() {
        return this.getTblZennendoizen().getTxtsainchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitchiikishienjkin() {
        return this.getTblZennendoizen().getTxtsaitchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblsainyukin() {
        return this.getTblZennendoizen().getLblsainyukin();
    }

    @JsonIgnore
    public Label getLblsainippankaiekikin() {
        return this.getTblZennendoizen().getLblsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainippankaiekikin() {
        return this.getTblZennendoizen().getTxtsainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitippankaiekikin() {
        return this.getTblZennendoizen().getTxtsaitippankaiekikin();
    }

    @JsonIgnore
    public Label getLblshiryooyobitesuryo() {
        return this.getTblZennendoizen().getLblshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyohigokei() {
        return this.getTblZennendoizen().getTxtshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugokei() {
        return this.getTblZennendoizen().getTxtsaishutsugokei();
    }

    // </editor-fold>
}
