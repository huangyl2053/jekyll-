package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * txtChoteiJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class txtChoteiJiyuDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu1")
    private celChoteiJiyu1AttxtChoteiJiyu celChoteiJiyu1;
    @JsonProperty("celChoteiJiyu2")
    private celChoteiJiyu2AttxtChoteiJiyu celChoteiJiyu2;
    @JsonProperty("celChoteiJiyu3")
    private celChoteiJiyu3AttxtChoteiJiyu celChoteiJiyu3;
    @JsonProperty("celChoteiJiyu4")
    private celChoteiJiyu4AttxtChoteiJiyu celChoteiJiyu4;
    @JsonProperty("celChoteiJiyu5")
    private celChoteiJiyu5AttxtChoteiJiyu celChoteiJiyu5;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyu() {
        return this.celChoteiJiyu1.getLblChoteiJiyu();
    }

    @JsonIgnore
    public Label getLblChoteiJiyu1() {
        return this.celChoteiJiyu2.getLblChoteiJiyu1();
    }

    @JsonIgnore
    public Label getLblChoteiJiyu2() {
        return this.celChoteiJiyu3.getLblChoteiJiyu2();
    }

    @JsonIgnore
    public Label getLblChoteiJiyu3() {
        return this.celChoteiJiyu4.getLblChoteiJiyu3();
    }

    @JsonIgnore
    public Label getLblChoteiJiyu4() {
        return this.celChoteiJiyu5.getLblChoteiJiyu4();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu1")
    private celChoteiJiyu1AttxtChoteiJiyu getCelChoteiJiyu1() {
        return celChoteiJiyu1;
    }

    @JsonProperty("celChoteiJiyu1")
    private void setCelChoteiJiyu1(celChoteiJiyu1AttxtChoteiJiyu celChoteiJiyu1) {
        this.celChoteiJiyu1=celChoteiJiyu1;
    }

    @JsonProperty("celChoteiJiyu2")
    private celChoteiJiyu2AttxtChoteiJiyu getCelChoteiJiyu2() {
        return celChoteiJiyu2;
    }

    @JsonProperty("celChoteiJiyu2")
    private void setCelChoteiJiyu2(celChoteiJiyu2AttxtChoteiJiyu celChoteiJiyu2) {
        this.celChoteiJiyu2=celChoteiJiyu2;
    }

    @JsonProperty("celChoteiJiyu3")
    private celChoteiJiyu3AttxtChoteiJiyu getCelChoteiJiyu3() {
        return celChoteiJiyu3;
    }

    @JsonProperty("celChoteiJiyu3")
    private void setCelChoteiJiyu3(celChoteiJiyu3AttxtChoteiJiyu celChoteiJiyu3) {
        this.celChoteiJiyu3=celChoteiJiyu3;
    }

    @JsonProperty("celChoteiJiyu4")
    private celChoteiJiyu4AttxtChoteiJiyu getCelChoteiJiyu4() {
        return celChoteiJiyu4;
    }

    @JsonProperty("celChoteiJiyu4")
    private void setCelChoteiJiyu4(celChoteiJiyu4AttxtChoteiJiyu celChoteiJiyu4) {
        this.celChoteiJiyu4=celChoteiJiyu4;
    }

    @JsonProperty("celChoteiJiyu5")
    private celChoteiJiyu5AttxtChoteiJiyu getCelChoteiJiyu5() {
        return celChoteiJiyu5;
    }

    @JsonProperty("celChoteiJiyu5")
    private void setCelChoteiJiyu5(celChoteiJiyu5AttxtChoteiJiyu celChoteiJiyu5) {
        this.celChoteiJiyu5=celChoteiJiyu5;
    }

}
/**
 * celChoteiJiyu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu1AttxtChoteiJiyu extends TableCell {
    @JsonProperty("lblChoteiJiyu")
    private Label lblChoteiJiyu;

    @JsonProperty("lblChoteiJiyu")
    public Label getLblChoteiJiyu() {
        return lblChoteiJiyu;
    }

    @JsonProperty("lblChoteiJiyu")
    public void setLblChoteiJiyu(Label lblChoteiJiyu) {
        this.lblChoteiJiyu=lblChoteiJiyu;
    }

}
/**
 * celChoteiJiyu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu2AttxtChoteiJiyu extends TableCell {
    @JsonProperty("lblChoteiJiyu1")
    private Label lblChoteiJiyu1;

    @JsonProperty("lblChoteiJiyu1")
    public Label getLblChoteiJiyu1() {
        return lblChoteiJiyu1;
    }

    @JsonProperty("lblChoteiJiyu1")
    public void setLblChoteiJiyu1(Label lblChoteiJiyu1) {
        this.lblChoteiJiyu1=lblChoteiJiyu1;
    }

}
/**
 * celChoteiJiyu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu3AttxtChoteiJiyu extends TableCell {
    @JsonProperty("lblChoteiJiyu2")
    private Label lblChoteiJiyu2;

    @JsonProperty("lblChoteiJiyu2")
    public Label getLblChoteiJiyu2() {
        return lblChoteiJiyu2;
    }

    @JsonProperty("lblChoteiJiyu2")
    public void setLblChoteiJiyu2(Label lblChoteiJiyu2) {
        this.lblChoteiJiyu2=lblChoteiJiyu2;
    }

}
/**
 * celChoteiJiyu4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu4AttxtChoteiJiyu extends TableCell {
    @JsonProperty("lblChoteiJiyu3")
    private Label lblChoteiJiyu3;

    @JsonProperty("lblChoteiJiyu3")
    public Label getLblChoteiJiyu3() {
        return lblChoteiJiyu3;
    }

    @JsonProperty("lblChoteiJiyu3")
    public void setLblChoteiJiyu3(Label lblChoteiJiyu3) {
        this.lblChoteiJiyu3=lblChoteiJiyu3;
    }

}
/**
 * celChoteiJiyu5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu5AttxtChoteiJiyu extends TableCell {
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
