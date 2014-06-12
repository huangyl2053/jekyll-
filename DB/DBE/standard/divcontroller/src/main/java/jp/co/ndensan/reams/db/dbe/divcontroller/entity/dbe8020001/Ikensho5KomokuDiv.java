package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Ikensho5Komoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class Ikensho5KomokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblIkensho5Komoku")
    private Label lblIkensho5Komoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblIkensho5Komoku")
    public Label getLblIkensho5Komoku() {
        return lblIkensho5Komoku;
    }

    @JsonProperty("lblIkensho5Komoku")
    public void setLblIkensho5Komoku(Label lblIkensho5Komoku) {
        this.lblIkensho5Komoku=lblIkensho5Komoku;
    }

}
