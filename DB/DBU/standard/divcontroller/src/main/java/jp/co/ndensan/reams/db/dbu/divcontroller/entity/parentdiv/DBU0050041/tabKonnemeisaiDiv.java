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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKonnedo")
    private tplKonnedoDiv tplKonnedo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplKonnedo
     * @return tplKonnedo
     */
    @JsonProperty("tplKonnedo")
    public tplKonnedoDiv getTplKonnedo() {
        return tplKonnedo;
    }

    /*
     * settplKonnedo
     * @param tplKonnedo tplKonnedo
     */
    @JsonProperty("tplKonnedo")
    public void setTplKonnedo(tplKonnedoDiv tplKonnedo) {
        this.tplKonnedo = tplKonnedo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblkosaishu() {
        return this.getTplKonnedo().getLblkosaishu();
    }

    @JsonIgnore
    public Label getLblkosainyuseisan() {
        return this.getTplKonnedo().getLblkosainyuseisan();
    }

    @JsonIgnore
    public Label getSpc11() {
        return this.getTplKonnedo().getSpc11();
    }

    @JsonIgnore
    public Label getLblkosaishutsu() {
        return this.getTplKonnedo().getLblkosaishutsu();
    }

    @JsonIgnore
    public Label getLblkokamoku() {
        return this.getTplKonnedo().getLblkokamoku();
    }

    @JsonIgnore
    public Label getLblkosainkakyufuhifukin() {
        return this.getTplKonnedo().getLblkosainkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkakyufuhifukin() {
        return this.getTplKonnedo().getTxtsainkkakyufuhifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkakyufuhifukin() {
        return this.getTplKonnedo().getTxtsaitkkakyufuhifukin();
    }

    @JsonIgnore
    public Label getLblkokaigohokenryo() {
        return this.getTplKonnedo().getLblkokaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchoseikofukin() {
        return this.getTplKonnedo().getTxtsainkchoseikofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchoseikofukin() {
        return this.getTplKonnedo().getTxtsaitkchoseikofukin();
    }

    @JsonIgnore
    public Label getLblkofuntannintei() {
        return this.getTplKonnedo().getLblkofuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkin() {
        return this.getTplKonnedo().getTxtsainkchiikishienkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkin() {
        return this.getTplKonnedo().getTxtsaitkchiikishienkin();
    }

    @JsonIgnore
    public Label getLblshiharaikikinkofukin() {
        return this.getTplKonnedo().getLblshiharaikikinkofukin();
    }

    @JsonIgnore
    public Label getLblfkountansonota() {
        return this.getTplKonnedo().getLblfkountansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkkaigokyufuhikokin() {
        return this.getTplKonnedo().getTxtsainkkaigokyufuhikokin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkkaigokyufuhikokin() {
        return this.getTplKonnedo().getTxtsaitkkaigokyufuhikokin();
    }

    @JsonIgnore
    public Label getLblkosainchiikishienkofukin() {
        return this.getTplKonnedo().getLblkosainchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienkofukin() {
        return this.getTplKonnedo().getTxtsainkchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienkofukin() {
        return this.getTplKonnedo().getTxtsaitkchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblkotodofukenkin() {
        return this.getTplKonnedo().getLblkotodofukenkin();
    }

    @JsonIgnore
    public Label getLbltodofutankenkin() {
        return this.getTplKonnedo().getLbltodofutankenkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainktodofukenfutankin() {
        return this.getTplKonnedo().getTxtsainktodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitktodofukenfutankin() {
        return this.getTplKonnedo().getTxtsaitktodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkochiikishienjigyokofukin() {
        return this.getTplKonnedo().getLblkochiikishienjigyokofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkchiikishienjkin() {
        return this.getTplKonnedo().getTxtsainkchiikishienjkin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkchiikishienjkin() {
        return this.getTplKonnedo().getTxtsaitkchiikishienjkin();
    }

    @JsonIgnore
    public Label getLblkosainyukin() {
        return this.getTplKonnedo().getLblkosainyukin();
    }

    @JsonIgnore
    public Label getLblkosainippankaiekikin() {
        return this.getTplKonnedo().getLblkosainippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainkippankaiekikin() {
        return this.getTplKonnedo().getTxtsainkippankaiekikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaitkippankaiekikin() {
        return this.getTplKonnedo().getTxtsaitkippankaiekikin();
    }

    @JsonIgnore
    public Label getLblkoshiryooyobitesuryo() {
        return this.getTplKonnedo().getLblkoshiryooyobitesuryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkoshiyohigokei() {
        return this.getTplKonnedo().getTxtkoshiyohigokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaishutsugokei() {
        return this.getTplKonnedo().getTxtkosaishutsugokei();
    }

    // </editor-fold>
}
