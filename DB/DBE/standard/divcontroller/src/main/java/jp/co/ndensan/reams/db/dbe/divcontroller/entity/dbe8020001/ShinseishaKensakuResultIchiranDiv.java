package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.dgKensakuKekka_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseishaKensakuResultIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaKensakuResultIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKensakuKekka")
    private DataGrid<dgKensakuKekka_Row> dgKensakuKekka;
    @JsonProperty("btnReShinseishaKensaku")
    private Button btnReShinseishaKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKensakuKekka")
    public DataGrid<dgKensakuKekka_Row> getDgKensakuKekka() {
        return dgKensakuKekka;
    }

    @JsonProperty("dgKensakuKekka")
    public void setDgKensakuKekka(DataGrid<dgKensakuKekka_Row> dgKensakuKekka) {
        this.dgKensakuKekka=dgKensakuKekka;
    }

    @JsonProperty("btnReShinseishaKensaku")
    public Button getBtnReShinseishaKensaku() {
        return btnReShinseishaKensaku;
    }

    @JsonProperty("btnReShinseishaKensaku")
    public void setBtnReShinseishaKensaku(Button btnReShinseishaKensaku) {
        this.btnReShinseishaKensaku=btnReShinseishaKensaku;
    }

}
