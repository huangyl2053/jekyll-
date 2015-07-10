package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblJigyoshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShienJigyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShienJigyoshaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShienJigyosha")
    private Label lblShienJigyosha;
    @JsonProperty("tblJigyosha")
    private tblJigyoshaDiv tblJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShienJigyosha")
    public Label getLblShienJigyosha() {
        return lblShienJigyosha;
    }

    @JsonProperty("lblShienJigyosha")
    public void setLblShienJigyosha(Label lblShienJigyosha) {
        this.lblShienJigyosha=lblShienJigyosha;
    }

    @JsonProperty("tblJigyosha")
    public tblJigyoshaDiv getTblJigyosha() {
        return tblJigyosha;
    }

    @JsonProperty("tblJigyosha")
    public void setTblJigyosha(tblJigyoshaDiv tblJigyosha) {
        this.tblJigyosha=tblJigyosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblJigyosha() {
        return this.getTblJigyosha().getLblJigyosha();
    }

    @JsonIgnore
    public Label getLblTodokedeDate() {
        return this.getTblJigyosha().getLblTodokedeDate();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.getTblJigyosha().getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate1() {
        return this.getTblJigyosha().getTxtTodokedeDate1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.getTblJigyosha().getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate2() {
        return this.getTblJigyosha().getTxtTodokedeDate2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.getTblJigyosha().getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate3() {
        return this.getTblJigyosha().getTxtTodokedeDate3();
    }

}
