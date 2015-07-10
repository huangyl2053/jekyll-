package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku;
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
 * tblKiwariGaku4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKiwariGaku4Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTokuchoKiGokei")
    private celTokuchoKiGokeiAttblKiwariGaku4 celTokuchoKiGokei;
    @JsonProperty("celTokuchoKibetsuGakuGokei")
    private celTokuchoKibetsuGakuGokeiAttblKiwariGaku4 celTokuchoKibetsuGakuGokei;
    @JsonProperty("celTokuchoNofuGakuGokei")
    private celTokuchoNofuGakuGokeiAttblKiwariGaku4 celTokuchoNofuGakuGokei;
    @JsonProperty("celFuchoKiGokei")
    private celFuchoKiGokeiAttblKiwariGaku4 celFuchoKiGokei;
    @JsonProperty("celFuchoKibetsuGakuGokei")
    private celFuchoKibetsuGakuGokeiAttblKiwariGaku4 celFuchoKibetsuGakuGokei;
    @JsonProperty("celFuchoNofuGakuGokei")
    private celFuchoNofuGakuGokeiAttblKiwariGaku4 celFuchoNofuGakuGokei;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTokuchoKiGokei() {
        return this.celTokuchoKiGokei.getLblTokuchoKiGokei();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGakuGokei() {
        return this.celTokuchoKibetsuGakuGokei.getLblTokuKibetsuGakuGokei();
    }

    @JsonIgnore
    public Label getLblTokuNofuGakuGokei() {
        return this.celTokuchoNofuGakuGokei.getLblTokuNofuGakuGokei();
    }

    @JsonIgnore
    public Label getLblFuchoKiGokei() {
        return this.celFuchoKiGokei.getLblFuchoKiGokei();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGakuGokei() {
        return this.celFuchoKibetsuGakuGokei.getLblFuchoKibetsuGakuGokei();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGakuGokei() {
        return this.celFuchoNofuGakuGokei.getLblFuchoNofuGakuGokei();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTokuchoKiGokei")
    private celTokuchoKiGokeiAttblKiwariGaku4 getCelTokuchoKiGokei() {
        return celTokuchoKiGokei;
    }

    @JsonProperty("celTokuchoKiGokei")
    private void setCelTokuchoKiGokei(celTokuchoKiGokeiAttblKiwariGaku4 celTokuchoKiGokei) {
        this.celTokuchoKiGokei=celTokuchoKiGokei;
    }

    @JsonProperty("celTokuchoKibetsuGakuGokei")
    private celTokuchoKibetsuGakuGokeiAttblKiwariGaku4 getCelTokuchoKibetsuGakuGokei() {
        return celTokuchoKibetsuGakuGokei;
    }

    @JsonProperty("celTokuchoKibetsuGakuGokei")
    private void setCelTokuchoKibetsuGakuGokei(celTokuchoKibetsuGakuGokeiAttblKiwariGaku4 celTokuchoKibetsuGakuGokei) {
        this.celTokuchoKibetsuGakuGokei=celTokuchoKibetsuGakuGokei;
    }

    @JsonProperty("celTokuchoNofuGakuGokei")
    private celTokuchoNofuGakuGokeiAttblKiwariGaku4 getCelTokuchoNofuGakuGokei() {
        return celTokuchoNofuGakuGokei;
    }

    @JsonProperty("celTokuchoNofuGakuGokei")
    private void setCelTokuchoNofuGakuGokei(celTokuchoNofuGakuGokeiAttblKiwariGaku4 celTokuchoNofuGakuGokei) {
        this.celTokuchoNofuGakuGokei=celTokuchoNofuGakuGokei;
    }

    @JsonProperty("celFuchoKiGokei")
    private celFuchoKiGokeiAttblKiwariGaku4 getCelFuchoKiGokei() {
        return celFuchoKiGokei;
    }

    @JsonProperty("celFuchoKiGokei")
    private void setCelFuchoKiGokei(celFuchoKiGokeiAttblKiwariGaku4 celFuchoKiGokei) {
        this.celFuchoKiGokei=celFuchoKiGokei;
    }

    @JsonProperty("celFuchoKibetsuGakuGokei")
    private celFuchoKibetsuGakuGokeiAttblKiwariGaku4 getCelFuchoKibetsuGakuGokei() {
        return celFuchoKibetsuGakuGokei;
    }

    @JsonProperty("celFuchoKibetsuGakuGokei")
    private void setCelFuchoKibetsuGakuGokei(celFuchoKibetsuGakuGokeiAttblKiwariGaku4 celFuchoKibetsuGakuGokei) {
        this.celFuchoKibetsuGakuGokei=celFuchoKibetsuGakuGokei;
    }

    @JsonProperty("celFuchoNofuGakuGokei")
    private celFuchoNofuGakuGokeiAttblKiwariGaku4 getCelFuchoNofuGakuGokei() {
        return celFuchoNofuGakuGokei;
    }

    @JsonProperty("celFuchoNofuGakuGokei")
    private void setCelFuchoNofuGakuGokei(celFuchoNofuGakuGokeiAttblKiwariGaku4 celFuchoNofuGakuGokei) {
        this.celFuchoNofuGakuGokei=celFuchoNofuGakuGokei;
    }

}
/**
 * celTokuchoKiGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKiGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblTokuchoKiGokei")
    private Label lblTokuchoKiGokei;

    @JsonProperty("lblTokuchoKiGokei")
    public Label getLblTokuchoKiGokei() {
        return lblTokuchoKiGokei;
    }

    @JsonProperty("lblTokuchoKiGokei")
    public void setLblTokuchoKiGokei(Label lblTokuchoKiGokei) {
        this.lblTokuchoKiGokei=lblTokuchoKiGokei;
    }

}
/**
 * celTokuchoKibetsuGakuGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoKibetsuGakuGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblTokuKibetsuGakuGokei")
    private Label lblTokuKibetsuGakuGokei;

    @JsonProperty("lblTokuKibetsuGakuGokei")
    public Label getLblTokuKibetsuGakuGokei() {
        return lblTokuKibetsuGakuGokei;
    }

    @JsonProperty("lblTokuKibetsuGakuGokei")
    public void setLblTokuKibetsuGakuGokei(Label lblTokuKibetsuGakuGokei) {
        this.lblTokuKibetsuGakuGokei=lblTokuKibetsuGakuGokei;
    }

}
/**
 * celTokuchoNofuGakuGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuchoNofuGakuGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblTokuNofuGakuGokei")
    private Label lblTokuNofuGakuGokei;

    @JsonProperty("lblTokuNofuGakuGokei")
    public Label getLblTokuNofuGakuGokei() {
        return lblTokuNofuGakuGokei;
    }

    @JsonProperty("lblTokuNofuGakuGokei")
    public void setLblTokuNofuGakuGokei(Label lblTokuNofuGakuGokei) {
        this.lblTokuNofuGakuGokei=lblTokuNofuGakuGokei;
    }

}
/**
 * celFuchoKiGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKiGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblFuchoKiGokei")
    private Label lblFuchoKiGokei;

    @JsonProperty("lblFuchoKiGokei")
    public Label getLblFuchoKiGokei() {
        return lblFuchoKiGokei;
    }

    @JsonProperty("lblFuchoKiGokei")
    public void setLblFuchoKiGokei(Label lblFuchoKiGokei) {
        this.lblFuchoKiGokei=lblFuchoKiGokei;
    }

}
/**
 * celFuchoKibetsuGakuGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoKibetsuGakuGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblFuchoKibetsuGakuGokei")
    private Label lblFuchoKibetsuGakuGokei;

    @JsonProperty("lblFuchoKibetsuGakuGokei")
    public Label getLblFuchoKibetsuGakuGokei() {
        return lblFuchoKibetsuGakuGokei;
    }

    @JsonProperty("lblFuchoKibetsuGakuGokei")
    public void setLblFuchoKibetsuGakuGokei(Label lblFuchoKibetsuGakuGokei) {
        this.lblFuchoKibetsuGakuGokei=lblFuchoKibetsuGakuGokei;
    }

}
/**
 * celFuchoNofuGakuGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celFuchoNofuGakuGokeiAttblKiwariGaku4 extends TableCell {
    @JsonProperty("lblFuchoNofuGakuGokei")
    private Label lblFuchoNofuGakuGokei;

    @JsonProperty("lblFuchoNofuGakuGokei")
    public Label getLblFuchoNofuGakuGokei() {
        return lblFuchoNofuGakuGokei;
    }

    @JsonProperty("lblFuchoNofuGakuGokei")
    public void setLblFuchoNofuGakuGokei(Label lblFuchoNofuGakuGokei) {
        this.lblFuchoNofuGakuGokei=lblFuchoNofuGakuGokei;
    }

}
