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
 * tblKiwariGaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKiwariGaku3Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTokuchoKi14")
    private celTokuchoKi14AttblKiwariGaku3 celTokuchoKi14;
    @JsonProperty("celTokuchoKibetsuGaku14")
    private celTokuchoKibetsuGaku14AttblKiwariGaku3 celTokuchoKibetsuGaku14;
    @JsonProperty("celTokuchoNofuGaku14")
    private celTokuchoNofuGaku14AttblKiwariGaku3 celTokuchoNofuGaku14;
    @JsonProperty("celFuchoKi14")
    private celFuchoKi14AttblKiwariGaku3 celFuchoKi14;
    @JsonProperty("celFuchoKibetsuGaku14")
    private celFuchoKibetsuGaku14AttblKiwariGaku3 celFuchoKibetsuGaku14;
    @JsonProperty("celFuchoNofuGaku14")
    private celFuchoNofuGaku14AttblKiwariGaku3 celFuchoNofuGaku14;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTokuchoKi14() {
        return this.celTokuchoKi14.getLblTokuchoKi14();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku14() {
        return this.celTokuchoKibetsuGaku14.getLblTokuKibetsuGaku14();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku14() {
        return this.celTokuchoNofuGaku14.getLblTokuNofuGaku14();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.celFuchoKi14.getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku14() {
        return this.celFuchoKibetsuGaku14.getLblFuchoKibetsuGaku14();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku14() {
        return this.celFuchoNofuGaku14.getLblFuchoNofuGaku14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTokuchoKi14")
    private celTokuchoKi14AttblKiwariGaku3 getCelTokuchoKi14() {
        return celTokuchoKi14;
    }

    @JsonProperty("celTokuchoKi14")
    private void setCelTokuchoKi14(celTokuchoKi14AttblKiwariGaku3 celTokuchoKi14) {
        this.celTokuchoKi14=celTokuchoKi14;
    }

    @JsonProperty("celTokuchoKibetsuGaku14")
    private celTokuchoKibetsuGaku14AttblKiwariGaku3 getCelTokuchoKibetsuGaku14() {
        return celTokuchoKibetsuGaku14;
    }

    @JsonProperty("celTokuchoKibetsuGaku14")
    private void setCelTokuchoKibetsuGaku14(celTokuchoKibetsuGaku14AttblKiwariGaku3 celTokuchoKibetsuGaku14) {
        this.celTokuchoKibetsuGaku14=celTokuchoKibetsuGaku14;
    }

    @JsonProperty("celTokuchoNofuGaku14")
    private celTokuchoNofuGaku14AttblKiwariGaku3 getCelTokuchoNofuGaku14() {
        return celTokuchoNofuGaku14;
    }

    @JsonProperty("celTokuchoNofuGaku14")
    private void setCelTokuchoNofuGaku14(celTokuchoNofuGaku14AttblKiwariGaku3 celTokuchoNofuGaku14) {
        this.celTokuchoNofuGaku14=celTokuchoNofuGaku14;
    }

    @JsonProperty("celFuchoKi14")
    private celFuchoKi14AttblKiwariGaku3 getCelFuchoKi14() {
        return celFuchoKi14;
    }

    @JsonProperty("celFuchoKi14")
    private void setCelFuchoKi14(celFuchoKi14AttblKiwariGaku3 celFuchoKi14) {
        this.celFuchoKi14=celFuchoKi14;
    }

    @JsonProperty("celFuchoKibetsuGaku14")
    private celFuchoKibetsuGaku14AttblKiwariGaku3 getCelFuchoKibetsuGaku14() {
        return celFuchoKibetsuGaku14;
    }

    @JsonProperty("celFuchoKibetsuGaku14")
    private void setCelFuchoKibetsuGaku14(celFuchoKibetsuGaku14AttblKiwariGaku3 celFuchoKibetsuGaku14) {
        this.celFuchoKibetsuGaku14=celFuchoKibetsuGaku14;
    }

    @JsonProperty("celFuchoNofuGaku14")
    private celFuchoNofuGaku14AttblKiwariGaku3 getCelFuchoNofuGaku14() {
        return celFuchoNofuGaku14;
    }

    @JsonProperty("celFuchoNofuGaku14")
    private void setCelFuchoNofuGaku14(celFuchoNofuGaku14AttblKiwariGaku3 celFuchoNofuGaku14) {
        this.celFuchoNofuGaku14=celFuchoNofuGaku14;
    }

}
/**
 * celTokuchoKi14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKi14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblTokuchoKi14")
    private Label lblTokuchoKi14;

    @JsonProperty("lblTokuchoKi14")
    public Label getLblTokuchoKi14() {
        return lblTokuchoKi14;
    }

    @JsonProperty("lblTokuchoKi14")
    public void setLblTokuchoKi14(Label lblTokuchoKi14) {
        this.lblTokuchoKi14=lblTokuchoKi14;
    }

}
/**
 * celTokuchoKibetsuGaku14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKibetsuGaku14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblTokuKibetsuGaku14")
    private Label lblTokuKibetsuGaku14;

    @JsonProperty("lblTokuKibetsuGaku14")
    public Label getLblTokuKibetsuGaku14() {
        return lblTokuKibetsuGaku14;
    }

    @JsonProperty("lblTokuKibetsuGaku14")
    public void setLblTokuKibetsuGaku14(Label lblTokuKibetsuGaku14) {
        this.lblTokuKibetsuGaku14=lblTokuKibetsuGaku14;
    }

}
/**
 * celTokuchoNofuGaku14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoNofuGaku14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblTokuNofuGaku14")
    private Label lblTokuNofuGaku14;

    @JsonProperty("lblTokuNofuGaku14")
    public Label getLblTokuNofuGaku14() {
        return lblTokuNofuGaku14;
    }

    @JsonProperty("lblTokuNofuGaku14")
    public void setLblTokuNofuGaku14(Label lblTokuNofuGaku14) {
        this.lblTokuNofuGaku14=lblTokuNofuGaku14;
    }

}
/**
 * celFuchoKi14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKi14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblFuchoKi14")
    private Label lblFuchoKi14;

    @JsonProperty("lblFuchoKi14")
    public Label getLblFuchoKi14() {
        return lblFuchoKi14;
    }

    @JsonProperty("lblFuchoKi14")
    public void setLblFuchoKi14(Label lblFuchoKi14) {
        this.lblFuchoKi14=lblFuchoKi14;
    }

}
/**
 * celFuchoKibetsuGaku14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKibetsuGaku14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblFuchoKibetsuGaku14")
    private Label lblFuchoKibetsuGaku14;

    @JsonProperty("lblFuchoKibetsuGaku14")
    public Label getLblFuchoKibetsuGaku14() {
        return lblFuchoKibetsuGaku14;
    }

    @JsonProperty("lblFuchoKibetsuGaku14")
    public void setLblFuchoKibetsuGaku14(Label lblFuchoKibetsuGaku14) {
        this.lblFuchoKibetsuGaku14=lblFuchoKibetsuGaku14;
    }

}
/**
 * celFuchoNofuGaku14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoNofuGaku14AttblKiwariGaku3 extends TableCell {
    @JsonProperty("lblFuchoNofuGaku14")
    private Label lblFuchoNofuGaku14;

    @JsonProperty("lblFuchoNofuGaku14")
    public Label getLblFuchoNofuGaku14() {
        return lblFuchoNofuGaku14;
    }

    @JsonProperty("lblFuchoNofuGaku14")
    public void setLblFuchoNofuGaku14(Label lblFuchoNofuGaku14) {
        this.lblFuchoNofuGaku14=lblFuchoNofuGaku14;
    }

}
