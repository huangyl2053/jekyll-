package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo;
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
 * TainocolorKano のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorKanoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("GreenCell1")
    private GreenCell1AtTainocolorKano GreenCell1;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.GreenCell1.getLblDummyGreen();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("GreenCell1")
    private GreenCell1AtTainocolorKano getGreenCell1() {
        return GreenCell1;
    }

    @JsonProperty("GreenCell1")
    private void setGreenCell1(GreenCell1AtTainocolorKano GreenCell1) {
        this.GreenCell1=GreenCell1;
    }

}
/**
 * GreenCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class GreenCell1AtTainocolorKano extends TableCell {
    @JsonProperty("lblDummyGreen")
    private Label lblDummyGreen;

    @JsonProperty("lblDummyGreen")
    public Label getLblDummyGreen() {
        return lblDummyGreen;
    }

    @JsonProperty("lblDummyGreen")
    public void setLblDummyGreen(Label lblDummyGreen) {
        this.lblDummyGreen=lblDummyGreen;
    }

}
