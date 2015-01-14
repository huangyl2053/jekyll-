package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
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
 * tblChoteiJiyuHon2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyuHon2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu41")
    private celChoteiJiyu41AttblChoteiJiyuHon2 celChoteiJiyu41;
    @JsonProperty("celChoteiJiyu42")
    private celChoteiJiyu42AttblChoteiJiyuHon2 celChoteiJiyu42;
    @JsonProperty("celChoteiJiyu43")
    private celChoteiJiyu43AttblChoteiJiyuHon2 celChoteiJiyu43;
    @JsonProperty("celChoteiJiyu44")
    private celChoteiJiyu44AttblChoteiJiyuHon2 celChoteiJiyu44;
    @JsonProperty("celChoteiJiyu45")
    private celChoteiJiyu45AttblChoteiJiyuHon2 celChoteiJiyu45;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyuHon2() {
        return this.celChoteiJiyu41.getLblChoteiJiyuHon2();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon21() {
        return this.celChoteiJiyu42.getTxtChoteiJiyuHon21();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon22() {
        return this.celChoteiJiyu43.getTxtChoteiJiyuHon22();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon23() {
        return this.celChoteiJiyu44.getTxtChoteiJiyuHon23();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon24() {
        return this.celChoteiJiyu45.getTxtChoteiJiyuHon24();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu41")
    private celChoteiJiyu41AttblChoteiJiyuHon2 getCelChoteiJiyu41() {
        return celChoteiJiyu41;
    }

    @JsonProperty("celChoteiJiyu41")
    private void setCelChoteiJiyu41(celChoteiJiyu41AttblChoteiJiyuHon2 celChoteiJiyu41) {
        this.celChoteiJiyu41=celChoteiJiyu41;
    }

    @JsonProperty("celChoteiJiyu42")
    private celChoteiJiyu42AttblChoteiJiyuHon2 getCelChoteiJiyu42() {
        return celChoteiJiyu42;
    }

    @JsonProperty("celChoteiJiyu42")
    private void setCelChoteiJiyu42(celChoteiJiyu42AttblChoteiJiyuHon2 celChoteiJiyu42) {
        this.celChoteiJiyu42=celChoteiJiyu42;
    }

    @JsonProperty("celChoteiJiyu43")
    private celChoteiJiyu43AttblChoteiJiyuHon2 getCelChoteiJiyu43() {
        return celChoteiJiyu43;
    }

    @JsonProperty("celChoteiJiyu43")
    private void setCelChoteiJiyu43(celChoteiJiyu43AttblChoteiJiyuHon2 celChoteiJiyu43) {
        this.celChoteiJiyu43=celChoteiJiyu43;
    }

    @JsonProperty("celChoteiJiyu44")
    private celChoteiJiyu44AttblChoteiJiyuHon2 getCelChoteiJiyu44() {
        return celChoteiJiyu44;
    }

    @JsonProperty("celChoteiJiyu44")
    private void setCelChoteiJiyu44(celChoteiJiyu44AttblChoteiJiyuHon2 celChoteiJiyu44) {
        this.celChoteiJiyu44=celChoteiJiyu44;
    }

    @JsonProperty("celChoteiJiyu45")
    private celChoteiJiyu45AttblChoteiJiyuHon2 getCelChoteiJiyu45() {
        return celChoteiJiyu45;
    }

    @JsonProperty("celChoteiJiyu45")
    private void setCelChoteiJiyu45(celChoteiJiyu45AttblChoteiJiyuHon2 celChoteiJiyu45) {
        this.celChoteiJiyu45=celChoteiJiyu45;
    }

}
/**
 * celChoteiJiyu41 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu41AttblChoteiJiyuHon2 extends TableCell {
    @JsonProperty("lblChoteiJiyuHon2")
    private Label lblChoteiJiyuHon2;

    @JsonProperty("lblChoteiJiyuHon2")
    public Label getLblChoteiJiyuHon2() {
        return lblChoteiJiyuHon2;
    }

    @JsonProperty("lblChoteiJiyuHon2")
    public void setLblChoteiJiyuHon2(Label lblChoteiJiyuHon2) {
        this.lblChoteiJiyuHon2=lblChoteiJiyuHon2;
    }

}
/**
 * celChoteiJiyu42 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu42AttblChoteiJiyuHon2 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon21")
    private TextBox txtChoteiJiyuHon21;

    @JsonProperty("txtChoteiJiyuHon21")
    public TextBox getTxtChoteiJiyuHon21() {
        return txtChoteiJiyuHon21;
    }

    @JsonProperty("txtChoteiJiyuHon21")
    public void setTxtChoteiJiyuHon21(TextBox txtChoteiJiyuHon21) {
        this.txtChoteiJiyuHon21=txtChoteiJiyuHon21;
    }

}
/**
 * celChoteiJiyu43 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu43AttblChoteiJiyuHon2 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon22")
    private TextBox txtChoteiJiyuHon22;

    @JsonProperty("txtChoteiJiyuHon22")
    public TextBox getTxtChoteiJiyuHon22() {
        return txtChoteiJiyuHon22;
    }

    @JsonProperty("txtChoteiJiyuHon22")
    public void setTxtChoteiJiyuHon22(TextBox txtChoteiJiyuHon22) {
        this.txtChoteiJiyuHon22=txtChoteiJiyuHon22;
    }

}
/**
 * celChoteiJiyu44 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu44AttblChoteiJiyuHon2 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon23")
    private TextBox txtChoteiJiyuHon23;

    @JsonProperty("txtChoteiJiyuHon23")
    public TextBox getTxtChoteiJiyuHon23() {
        return txtChoteiJiyuHon23;
    }

    @JsonProperty("txtChoteiJiyuHon23")
    public void setTxtChoteiJiyuHon23(TextBox txtChoteiJiyuHon23) {
        this.txtChoteiJiyuHon23=txtChoteiJiyuHon23;
    }

}
/**
 * celChoteiJiyu45 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu45AttblChoteiJiyuHon2 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon24")
    private TextBox txtChoteiJiyuHon24;

    @JsonProperty("txtChoteiJiyuHon24")
    public TextBox getTxtChoteiJiyuHon24() {
        return txtChoteiJiyuHon24;
    }

    @JsonProperty("txtChoteiJiyuHon24")
    public void setTxtChoteiJiyuHon24(TextBox txtChoteiJiyuHon24) {
        this.txtChoteiJiyuHon24=txtChoteiJiyuHon24;
    }

}
