package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShukeiYM5 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShukeiYM5Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShukeiNendo5")
    private TextBoxFlexibleDate txtShukeiNendo5;
    @JsonProperty("lblShukeiKikan5")
    private Label lblShukeiKikan5;
    @JsonProperty("txtShukeiFromYM5")
    private TextBoxFlexibleDate txtShukeiFromYM5;
    @JsonProperty("lblShukeiHani25")
    private Label lblShukeiHani25;
    @JsonProperty("txtShukeiToYM5")
    private TextBoxFlexibleDate txtShukeiToYM5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShukeiNendo5
     * @return txtShukeiNendo5
     */
    @JsonProperty("txtShukeiNendo5")
    public TextBoxFlexibleDate getTxtShukeiNendo5() {
        return txtShukeiNendo5;
    }

    /*
     * settxtShukeiNendo5
     * @param txtShukeiNendo5 txtShukeiNendo5
     */
    @JsonProperty("txtShukeiNendo5")
    public void setTxtShukeiNendo5(TextBoxFlexibleDate txtShukeiNendo5) {
        this.txtShukeiNendo5 = txtShukeiNendo5;
    }

    /*
     * getlblShukeiKikan5
     * @return lblShukeiKikan5
     */
    @JsonProperty("lblShukeiKikan5")
    public Label getLblShukeiKikan5() {
        return lblShukeiKikan5;
    }

    /*
     * setlblShukeiKikan5
     * @param lblShukeiKikan5 lblShukeiKikan5
     */
    @JsonProperty("lblShukeiKikan5")
    public void setLblShukeiKikan5(Label lblShukeiKikan5) {
        this.lblShukeiKikan5 = lblShukeiKikan5;
    }

    /*
     * gettxtShukeiFromYM5
     * @return txtShukeiFromYM5
     */
    @JsonProperty("txtShukeiFromYM5")
    public TextBoxFlexibleDate getTxtShukeiFromYM5() {
        return txtShukeiFromYM5;
    }

    /*
     * settxtShukeiFromYM5
     * @param txtShukeiFromYM5 txtShukeiFromYM5
     */
    @JsonProperty("txtShukeiFromYM5")
    public void setTxtShukeiFromYM5(TextBoxFlexibleDate txtShukeiFromYM5) {
        this.txtShukeiFromYM5 = txtShukeiFromYM5;
    }

    /*
     * getlblShukeiHani25
     * @return lblShukeiHani25
     */
    @JsonProperty("lblShukeiHani25")
    public Label getLblShukeiHani25() {
        return lblShukeiHani25;
    }

    /*
     * setlblShukeiHani25
     * @param lblShukeiHani25 lblShukeiHani25
     */
    @JsonProperty("lblShukeiHani25")
    public void setLblShukeiHani25(Label lblShukeiHani25) {
        this.lblShukeiHani25 = lblShukeiHani25;
    }

    /*
     * gettxtShukeiToYM5
     * @return txtShukeiToYM5
     */
    @JsonProperty("txtShukeiToYM5")
    public TextBoxFlexibleDate getTxtShukeiToYM5() {
        return txtShukeiToYM5;
    }

    /*
     * settxtShukeiToYM5
     * @param txtShukeiToYM5 txtShukeiToYM5
     */
    @JsonProperty("txtShukeiToYM5")
    public void setTxtShukeiToYM5(TextBoxFlexibleDate txtShukeiToYM5) {
        this.txtShukeiToYM5 = txtShukeiToYM5;
    }

    // </editor-fold>
}
