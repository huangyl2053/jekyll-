package jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku;
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
 * tblKiwariGaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKiwariGaku2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTokuchoKi13")
    private celTokuchoKi13AttblKiwariGaku2 celTokuchoKi13;
    @JsonProperty("celTokuchoKibetsuGaku13")
    private celTokuchoKibetsuGaku13AttblKiwariGaku2 celTokuchoKibetsuGaku13;
    @JsonProperty("celTokuchoNofuGaku13")
    private celTokuchoNofuGaku13AttblKiwariGaku2 celTokuchoNofuGaku13;
    @JsonProperty("celFuchoKi13")
    private celFuchoKi13AttblKiwariGaku2 celFuchoKi13;
    @JsonProperty("celFuchoKibetsuGaku13")
    private celFuchoKibetsuGaku13AttblKiwariGaku2 celFuchoKibetsuGaku13;
    @JsonProperty("celFuchoNofuGaku13")
    private celFuchoNofuGaku13AttblKiwariGaku2 celFuchoNofuGaku13;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTokuchoKi13() {
        return this.celTokuchoKi13.getLblTokuchoKi13();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku13() {
        return this.celTokuchoKibetsuGaku13.getLblTokuKibetsuGaku13();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku13() {
        return this.celTokuchoNofuGaku13.getLblTokuNofuGaku13();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.celFuchoKi13.getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku13() {
        return this.celFuchoKibetsuGaku13.getLblFuchoKibetsuGaku13();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku13() {
        return this.celFuchoNofuGaku13.getLblFuchoNofuGaku13();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTokuchoKi13")
    private celTokuchoKi13AttblKiwariGaku2 getCelTokuchoKi13() {
        return celTokuchoKi13;
    }

    @JsonProperty("celTokuchoKi13")
    private void setCelTokuchoKi13(celTokuchoKi13AttblKiwariGaku2 celTokuchoKi13) {
        this.celTokuchoKi13=celTokuchoKi13;
    }

    @JsonProperty("celTokuchoKibetsuGaku13")
    private celTokuchoKibetsuGaku13AttblKiwariGaku2 getCelTokuchoKibetsuGaku13() {
        return celTokuchoKibetsuGaku13;
    }

    @JsonProperty("celTokuchoKibetsuGaku13")
    private void setCelTokuchoKibetsuGaku13(celTokuchoKibetsuGaku13AttblKiwariGaku2 celTokuchoKibetsuGaku13) {
        this.celTokuchoKibetsuGaku13=celTokuchoKibetsuGaku13;
    }

    @JsonProperty("celTokuchoNofuGaku13")
    private celTokuchoNofuGaku13AttblKiwariGaku2 getCelTokuchoNofuGaku13() {
        return celTokuchoNofuGaku13;
    }

    @JsonProperty("celTokuchoNofuGaku13")
    private void setCelTokuchoNofuGaku13(celTokuchoNofuGaku13AttblKiwariGaku2 celTokuchoNofuGaku13) {
        this.celTokuchoNofuGaku13=celTokuchoNofuGaku13;
    }

    @JsonProperty("celFuchoKi13")
    private celFuchoKi13AttblKiwariGaku2 getCelFuchoKi13() {
        return celFuchoKi13;
    }

    @JsonProperty("celFuchoKi13")
    private void setCelFuchoKi13(celFuchoKi13AttblKiwariGaku2 celFuchoKi13) {
        this.celFuchoKi13=celFuchoKi13;
    }

    @JsonProperty("celFuchoKibetsuGaku13")
    private celFuchoKibetsuGaku13AttblKiwariGaku2 getCelFuchoKibetsuGaku13() {
        return celFuchoKibetsuGaku13;
    }

    @JsonProperty("celFuchoKibetsuGaku13")
    private void setCelFuchoKibetsuGaku13(celFuchoKibetsuGaku13AttblKiwariGaku2 celFuchoKibetsuGaku13) {
        this.celFuchoKibetsuGaku13=celFuchoKibetsuGaku13;
    }

    @JsonProperty("celFuchoNofuGaku13")
    private celFuchoNofuGaku13AttblKiwariGaku2 getCelFuchoNofuGaku13() {
        return celFuchoNofuGaku13;
    }

    @JsonProperty("celFuchoNofuGaku13")
    private void setCelFuchoNofuGaku13(celFuchoNofuGaku13AttblKiwariGaku2 celFuchoNofuGaku13) {
        this.celFuchoNofuGaku13=celFuchoNofuGaku13;
    }

}
/**
 * celTokuchoKi13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKi13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblTokuchoKi13")
    private Label lblTokuchoKi13;

    @JsonProperty("lblTokuchoKi13")
    public Label getLblTokuchoKi13() {
        return lblTokuchoKi13;
    }

    @JsonProperty("lblTokuchoKi13")
    public void setLblTokuchoKi13(Label lblTokuchoKi13) {
        this.lblTokuchoKi13=lblTokuchoKi13;
    }

}
/**
 * celTokuchoKibetsuGaku13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKibetsuGaku13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblTokuKibetsuGaku13")
    private Label lblTokuKibetsuGaku13;

    @JsonProperty("lblTokuKibetsuGaku13")
    public Label getLblTokuKibetsuGaku13() {
        return lblTokuKibetsuGaku13;
    }

    @JsonProperty("lblTokuKibetsuGaku13")
    public void setLblTokuKibetsuGaku13(Label lblTokuKibetsuGaku13) {
        this.lblTokuKibetsuGaku13=lblTokuKibetsuGaku13;
    }

}
/**
 * celTokuchoNofuGaku13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoNofuGaku13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblTokuNofuGaku13")
    private Label lblTokuNofuGaku13;

    @JsonProperty("lblTokuNofuGaku13")
    public Label getLblTokuNofuGaku13() {
        return lblTokuNofuGaku13;
    }

    @JsonProperty("lblTokuNofuGaku13")
    public void setLblTokuNofuGaku13(Label lblTokuNofuGaku13) {
        this.lblTokuNofuGaku13=lblTokuNofuGaku13;
    }

}
/**
 * celFuchoKi13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKi13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblFuchoKi13")
    private Label lblFuchoKi13;

    @JsonProperty("lblFuchoKi13")
    public Label getLblFuchoKi13() {
        return lblFuchoKi13;
    }

    @JsonProperty("lblFuchoKi13")
    public void setLblFuchoKi13(Label lblFuchoKi13) {
        this.lblFuchoKi13=lblFuchoKi13;
    }

}
/**
 * celFuchoKibetsuGaku13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKibetsuGaku13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblFuchoKibetsuGaku13")
    private Label lblFuchoKibetsuGaku13;

    @JsonProperty("lblFuchoKibetsuGaku13")
    public Label getLblFuchoKibetsuGaku13() {
        return lblFuchoKibetsuGaku13;
    }

    @JsonProperty("lblFuchoKibetsuGaku13")
    public void setLblFuchoKibetsuGaku13(Label lblFuchoKibetsuGaku13) {
        this.lblFuchoKibetsuGaku13=lblFuchoKibetsuGaku13;
    }

}
/**
 * celFuchoNofuGaku13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoNofuGaku13AttblKiwariGaku2 extends TableCell {
    @JsonProperty("lblFuchoNofuGaku13")
    private Label lblFuchoNofuGaku13;

    @JsonProperty("lblFuchoNofuGaku13")
    public Label getLblFuchoNofuGaku13() {
        return lblFuchoNofuGaku13;
    }

    @JsonProperty("lblFuchoNofuGaku13")
    public void setLblFuchoNofuGaku13(Label lblFuchoNofuGaku13) {
        this.lblFuchoNofuGaku13=lblFuchoNofuGaku13;
    }

}
