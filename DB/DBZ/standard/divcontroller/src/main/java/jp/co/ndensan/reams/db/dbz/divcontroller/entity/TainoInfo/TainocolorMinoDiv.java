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
 * TainocolorMino のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorMinoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RedCell")
    private RedCellAtTainocolorMino RedCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyRed() {
        return this.RedCell.getLblDummyRed();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("RedCell")
    private RedCellAtTainocolorMino getRedCell() {
        return RedCell;
    }

    @JsonProperty("RedCell")
    private void setRedCell(RedCellAtTainocolorMino RedCell) {
        this.RedCell=RedCell;
    }

}
/**
 * RedCell のクラスファイル 
 * 
 * @author 自動生成
 */
class RedCellAtTainocolorMino extends TableCell {
    @JsonProperty("lblDummyRed")
    private Label lblDummyRed;

    @JsonProperty("lblDummyRed")
    public Label getLblDummyRed() {
        return lblDummyRed;
    }

    @JsonProperty("lblDummyRed")
    public void setLblDummyRed(Label lblDummyRed) {
        this.lblDummyRed=lblDummyRed;
    }

}
