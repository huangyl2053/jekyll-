package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * TainocolorKanno のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorKannoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WhiteCell")
    private WhiteCellAtTainocolorKanno WhiteCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyWhite() {
        return this.WhiteCell.getLblDummyWhite();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("WhiteCell")
    private WhiteCellAtTainocolorKanno getWhiteCell() {
        return WhiteCell;
    }

    @JsonProperty("WhiteCell")
    private void setWhiteCell(WhiteCellAtTainocolorKanno WhiteCell) {
        this.WhiteCell=WhiteCell;
    }

}
/**
 * WhiteCell のクラスファイル 
 * 
 * @author 自動生成
 */
class WhiteCellAtTainocolorKanno extends TableCell {
    @JsonProperty("lblDummyWhite")
    private Label lblDummyWhite;

    @JsonProperty("lblDummyWhite")
    public Label getLblDummyWhite() {
        return lblDummyWhite;
    }

    @JsonProperty("lblDummyWhite")
    public void setLblDummyWhite(Label lblDummyWhite) {
        this.lblDummyWhite=lblDummyWhite;
    }

}
