package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
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
 * GnegakuKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class GnegakuKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKeisanShiki")
    private Label lblKeisanShiki;
    @JsonProperty("GenGakuKikan2")
    private GenGakuKikan2Div GenGakuKikan2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKeisanShiki
     * @return lblKeisanShiki
     */
    @JsonProperty("lblKeisanShiki")
    public Label getLblKeisanShiki() {
        return lblKeisanShiki;
    }

    /*
     * setlblKeisanShiki
     * @param lblKeisanShiki lblKeisanShiki
     */
    @JsonProperty("lblKeisanShiki")
    public void setLblKeisanShiki(Label lblKeisanShiki) {
        this.lblKeisanShiki = lblKeisanShiki;
    }

    /*
     * getGenGakuKikan2
     * @return GenGakuKikan2
     */
    @JsonProperty("GenGakuKikan2")
    public GenGakuKikan2Div getGenGakuKikan2() {
        return GenGakuKikan2;
    }

    /*
     * setGenGakuKikan2
     * @param GenGakuKikan2 GenGakuKikan2
     */
    @JsonProperty("GenGakuKikan2")
    public void setGenGakuKikan2(GenGakuKikan2Div GenGakuKikan2) {
        this.GenGakuKikan2 = GenGakuKikan2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblGenGakuKikan() {
        return this.getGenGakuKikan2().getLblGenGakuKikan();
    }

    @JsonIgnore
    public void  setLblGenGakuKikan(Label lblGenGakuKikan) {
        this.getGenGakuKikan2().setLblGenGakuKikan(lblGenGakuKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenGakuKikan() {
        return this.getGenGakuKikan2().getTxtGenGakuKikan();
    }

    @JsonIgnore
    public void  setTxtGenGakuKikan(TextBoxNum txtGenGakuKikan) {
        this.getGenGakuKikan2().setTxtGenGakuKikan(txtGenGakuKikan);
    }

    // </editor-fold>
}
