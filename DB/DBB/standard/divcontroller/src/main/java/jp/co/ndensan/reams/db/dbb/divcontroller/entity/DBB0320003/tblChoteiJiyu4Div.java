package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblChoteiJiyu4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyu4Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu41")
    private celChoteiJiyu41AttblChoteiJiyu4 celChoteiJiyu41;
    @JsonProperty("celChoteiJiyu42")
    private celChoteiJiyu42AttblChoteiJiyu4 celChoteiJiyu42;
    @JsonProperty("celChoteiJiyu43")
    private celChoteiJiyu43AttblChoteiJiyu4 celChoteiJiyu43;
    @JsonProperty("celChoteiJiyu44")
    private celChoteiJiyu44AttblChoteiJiyu4 celChoteiJiyu44;
    @JsonProperty("celChoteiJiyu45")
    private celChoteiJiyu45AttblChoteiJiyu4 celChoteiJiyu45;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyu4() {
        return this.celChoteiJiyu41.getLblChoteiJiyu4();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu41() {
        return this.celChoteiJiyu42.getTxtChoteiJiyu41();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu42() {
        return this.celChoteiJiyu43.getTxtChoteiJiyu42();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu43() {
        return this.celChoteiJiyu44.getTxtChoteiJiyu43();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu44() {
        return this.celChoteiJiyu45.getTxtChoteiJiyu44();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu41")
    private celChoteiJiyu41AttblChoteiJiyu4 getCelChoteiJiyu41() {
        return celChoteiJiyu41;
    }

    @JsonProperty("celChoteiJiyu41")
    private void setCelChoteiJiyu41(celChoteiJiyu41AttblChoteiJiyu4 celChoteiJiyu41) {
        this.celChoteiJiyu41=celChoteiJiyu41;
    }

    @JsonProperty("celChoteiJiyu42")
    private celChoteiJiyu42AttblChoteiJiyu4 getCelChoteiJiyu42() {
        return celChoteiJiyu42;
    }

    @JsonProperty("celChoteiJiyu42")
    private void setCelChoteiJiyu42(celChoteiJiyu42AttblChoteiJiyu4 celChoteiJiyu42) {
        this.celChoteiJiyu42=celChoteiJiyu42;
    }

    @JsonProperty("celChoteiJiyu43")
    private celChoteiJiyu43AttblChoteiJiyu4 getCelChoteiJiyu43() {
        return celChoteiJiyu43;
    }

    @JsonProperty("celChoteiJiyu43")
    private void setCelChoteiJiyu43(celChoteiJiyu43AttblChoteiJiyu4 celChoteiJiyu43) {
        this.celChoteiJiyu43=celChoteiJiyu43;
    }

    @JsonProperty("celChoteiJiyu44")
    private celChoteiJiyu44AttblChoteiJiyu4 getCelChoteiJiyu44() {
        return celChoteiJiyu44;
    }

    @JsonProperty("celChoteiJiyu44")
    private void setCelChoteiJiyu44(celChoteiJiyu44AttblChoteiJiyu4 celChoteiJiyu44) {
        this.celChoteiJiyu44=celChoteiJiyu44;
    }

    @JsonProperty("celChoteiJiyu45")
    private celChoteiJiyu45AttblChoteiJiyu4 getCelChoteiJiyu45() {
        return celChoteiJiyu45;
    }

    @JsonProperty("celChoteiJiyu45")
    private void setCelChoteiJiyu45(celChoteiJiyu45AttblChoteiJiyu4 celChoteiJiyu45) {
        this.celChoteiJiyu45=celChoteiJiyu45;
    }

}
/**
 * celChoteiJiyu41 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu41AttblChoteiJiyu4 extends TableCell {
    @JsonProperty("lblChoteiJiyu4")
    private Label lblChoteiJiyu4;

    @JsonProperty("lblChoteiJiyu4")
    public Label getLblChoteiJiyu4() {
        return lblChoteiJiyu4;
    }

    @JsonProperty("lblChoteiJiyu4")
    public void setLblChoteiJiyu4(Label lblChoteiJiyu4) {
        this.lblChoteiJiyu4=lblChoteiJiyu4;
    }

}
/**
 * celChoteiJiyu42 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu42AttblChoteiJiyu4 extends TableCell {
    @JsonProperty("txtChoteiJiyu41")
    private TextBox txtChoteiJiyu41;

    @JsonProperty("txtChoteiJiyu41")
    public TextBox getTxtChoteiJiyu41() {
        return txtChoteiJiyu41;
    }

    @JsonProperty("txtChoteiJiyu41")
    public void setTxtChoteiJiyu41(TextBox txtChoteiJiyu41) {
        this.txtChoteiJiyu41=txtChoteiJiyu41;
    }

}
/**
 * celChoteiJiyu43 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu43AttblChoteiJiyu4 extends TableCell {
    @JsonProperty("txtChoteiJiyu42")
    private TextBox txtChoteiJiyu42;

    @JsonProperty("txtChoteiJiyu42")
    public TextBox getTxtChoteiJiyu42() {
        return txtChoteiJiyu42;
    }

    @JsonProperty("txtChoteiJiyu42")
    public void setTxtChoteiJiyu42(TextBox txtChoteiJiyu42) {
        this.txtChoteiJiyu42=txtChoteiJiyu42;
    }

}
/**
 * celChoteiJiyu44 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu44AttblChoteiJiyu4 extends TableCell {
    @JsonProperty("txtChoteiJiyu43")
    private TextBox txtChoteiJiyu43;

    @JsonProperty("txtChoteiJiyu43")
    public TextBox getTxtChoteiJiyu43() {
        return txtChoteiJiyu43;
    }

    @JsonProperty("txtChoteiJiyu43")
    public void setTxtChoteiJiyu43(TextBox txtChoteiJiyu43) {
        this.txtChoteiJiyu43=txtChoteiJiyu43;
    }

}
/**
 * celChoteiJiyu45 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu45AttblChoteiJiyu4 extends TableCell {
    @JsonProperty("txtChoteiJiyu44")
    private TextBox txtChoteiJiyu44;

    @JsonProperty("txtChoteiJiyu44")
    public TextBox getTxtChoteiJiyu44() {
        return txtChoteiJiyu44;
    }

    @JsonProperty("txtChoteiJiyu44")
    public void setTxtChoteiJiyu44(TextBox txtChoteiJiyu44) {
        this.txtChoteiJiyu44=txtChoteiJiyu44;
    }

}
