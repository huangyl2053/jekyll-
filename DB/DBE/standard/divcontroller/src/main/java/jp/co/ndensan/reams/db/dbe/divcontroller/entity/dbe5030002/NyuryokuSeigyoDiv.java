package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002;
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
 * NyuryokuSeigyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyuryokuSeigyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnNext")
    private Button btnNext;
    @JsonProperty("btnBackIchiran")
    private Button btnBackIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku=btnToroku;
    }

    @JsonProperty("btnNext")
    public Button getBtnNext() {
        return btnNext;
    }

    @JsonProperty("btnNext")
    public void setBtnNext(Button btnNext) {
        this.btnNext=btnNext;
    }

    @JsonProperty("btnBackIchiran")
    public Button getBtnBackIchiran() {
        return btnBackIchiran;
    }

    @JsonProperty("btnBackIchiran")
    public void setBtnBackIchiran(Button btnBackIchiran) {
        this.btnBackIchiran=btnBackIchiran;
    }

}
