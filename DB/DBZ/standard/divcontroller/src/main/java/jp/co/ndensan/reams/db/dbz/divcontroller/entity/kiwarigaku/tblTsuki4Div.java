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
 * tblTsuki4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTsuki4Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTsukiGokei")
    private celTsukiGokeiAttblTsuki4 celTsukiGokei;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTsukiGokei() {
        return this.celTsukiGokei.getLblTsukiGokei();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTsukiGokei")
    private celTsukiGokeiAttblTsuki4 getCelTsukiGokei() {
        return celTsukiGokei;
    }

    @JsonProperty("celTsukiGokei")
    private void setCelTsukiGokei(celTsukiGokeiAttblTsuki4 celTsukiGokei) {
        this.celTsukiGokei=celTsukiGokei;
    }

}
/**
 * celTsukiGokei のクラスファイル 
 * 
 * @author 自動生成
 */
class celTsukiGokeiAttblTsuki4 extends TableCell {
    @JsonProperty("lblTsukiGokei")
    private Label lblTsukiGokei;

    @JsonProperty("lblTsukiGokei")
    public Label getLblTsukiGokei() {
        return lblTsukiGokei;
    }

    @JsonProperty("lblTsukiGokei")
    public void setLblTsukiGokei(Label lblTsukiGokei) {
        this.lblTsukiGokei=lblTsukiGokei;
    }

}
