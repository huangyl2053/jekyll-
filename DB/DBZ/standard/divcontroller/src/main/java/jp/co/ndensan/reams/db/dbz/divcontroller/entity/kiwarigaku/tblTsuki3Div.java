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
 * tblTsuki3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTsuki3Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTsuki14")
    private celTsuki14AttblTsuki3 celTsuki14;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTsuki14() {
        return this.celTsuki14.getLblTsuki14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTsuki14")
    private celTsuki14AttblTsuki3 getCelTsuki14() {
        return celTsuki14;
    }

    @JsonProperty("celTsuki14")
    private void setCelTsuki14(celTsuki14AttblTsuki3 celTsuki14) {
        this.celTsuki14=celTsuki14;
    }

}
/**
 * celTsuki14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTsuki14AttblTsuki3 extends TableCell {
    @JsonProperty("lblTsuki14")
    private Label lblTsuki14;

    @JsonProperty("lblTsuki14")
    public Label getLblTsuki14() {
        return lblTsuki14;
    }

    @JsonProperty("lblTsuki14")
    public void setLblTsuki14(Label lblTsuki14) {
        this.lblTsuki14=lblTsuki14;
    }

}
