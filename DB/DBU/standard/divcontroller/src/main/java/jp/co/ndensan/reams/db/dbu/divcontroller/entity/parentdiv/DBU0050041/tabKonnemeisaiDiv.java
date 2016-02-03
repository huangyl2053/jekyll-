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
 * tabKonnemeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKonnemeisaiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabKonnedo")
    private tabKonnedoDiv tabKonnedo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabKonnedo
     * @return tabKonnedo
     */
    @JsonProperty("tabKonnedo")
    public tabKonnedoDiv getTabKonnedo() {
        return tabKonnedo;
    }

    /*
     * settabKonnedo
     * @param tabKonnedo tabKonnedo
     */
    @JsonProperty("tabKonnedo")
    public void setTabKonnedo(tabKonnedoDiv tabKonnedo) {
        this.tabKonnedo = tabKonnedo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblkosaishu() {
        return this.getTabKonnedo().getLblkosaishu();
    }

    @JsonIgnore
    public Label getLblkosainyuseisan() {
        return this.getTabKonnedo().getLblkosainyuseisan();
    }

    @JsonIgnore
    public Label getSpc11() {
        return this.getTabKonnedo().getSpc11();
    }

    @JsonIgnore
    public Label getLblkosaishutsu() {
        return this.getTabKonnedo().getLblkosaishutsu();
    }

    @JsonIgnore
    public Label getLblkokamoku() {
        return this.getTabKonnedo().getLblkokamoku();
    }

    @JsonIgnore
    public Label getLblkosainkakyufuhifukin() {
        return this.getTabKonnedo().getLblkosainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkakyufuhifukin() {
        return this.getTabKonnedo().getTxtsainkkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkakyufuhifukin() {
        return this.getTabKonnedo().getTxtsaitkkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkokaigohokenryo() {
        return this.getTabKonnedo().getLblkokaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchoseikofukin() {
        return this.getTabKonnedo().getTxtsainkchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchoseikofukin() {
        return this.getTabKonnedo().getTxtsaitkchoseikofukin();
    }

    @JsonIgnore
    public Label getLblkofuntannintei() {
        return this.getTabKonnedo().getLblkofuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkin() {
        return this.getTabKonnedo().getTxtsainkchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkin() {
        return this.getTabKonnedo().getTxtsaitkchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofukin() {
        return this.getTabKonnedo().getLblshiharaikikinkofukin();
    }

    @JsonIgnore
    public Label getLblfkountansonota() {
        return this.getTabKonnedo().getLblfkountansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkaigokyufuhikokin() {
        return this.getTabKonnedo().getTxtsainkkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkaigokyufuhikokin() {
        return this.getTabKonnedo().getTxtsaitkkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblkosainchiikishienkofukin() {
        return this.getTabKonnedo().getLblkosainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkofukin() {
        return this.getTabKonnedo().getTxtsainkchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkofukin() {
        return this.getTabKonnedo().getTxtsaitkchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblkotodofukenkin() {
        return this.getTabKonnedo().getLblkotodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofutankenkin() {
        return this.getTabKonnedo().getLbltodofutankenkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainktodofukenfutankin() {
        return this.getTabKonnedo().getTxtsainktodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitktodofukenfutankin() {
        return this.getTabKonnedo().getTxtsaitktodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkochiikishienjigyokofukin() {
        return this.getTabKonnedo().getLblkochiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienjkin() {
        return this.getTabKonnedo().getTxtsainkchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienjkin() {
        return this.getTabKonnedo().getTxtsaitkchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblkosainyukin() {
        return this.getTabKonnedo().getLblkosainyukin();
    }

    @JsonIgnore
    public Label getLblkosainippankaiekikin() {
        return this.getTabKonnedo().getLblkosainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkippankaiekikin() {
        return this.getTabKonnedo().getTxtsainkippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkippankaiekikin() {
        return this.getTabKonnedo().getTxtsaitkippankaiekikin();
    }

    @JsonIgnore
    public Label getLblkoshiryooyobitesuryo() {
        return this.getTabKonnedo().getLblkoshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkoshiyohigokei() {
        return this.getTabKonnedo().getTxtkoshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaishutsugokei() {
        return this.getTabKonnedo().getTxtkosaishutsugokei();
    }

    // </editor-fold>
}
