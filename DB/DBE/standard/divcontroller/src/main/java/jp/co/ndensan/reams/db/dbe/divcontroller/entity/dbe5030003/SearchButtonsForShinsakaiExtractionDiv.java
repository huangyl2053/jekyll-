package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003;
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
 * SearchButtonsForShinsakaiExtraction のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchButtonsForShinsakaiExtractionDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToClearConditon")
    private Button btnToClearConditon;
    @JsonProperty("btnToExtract")
    private Button btnToExtract;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToClearConditon")
    public Button getBtnToClearConditon() {
        return btnToClearConditon;
    }

    @JsonProperty("btnToClearConditon")
    public void setBtnToClearConditon(Button btnToClearConditon) {
        this.btnToClearConditon=btnToClearConditon;
    }

    @JsonProperty("btnToExtract")
    public Button getBtnToExtract() {
        return btnToExtract;
    }

    @JsonProperty("btnToExtract")
    public void setBtnToExtract(Button btnToExtract) {
        this.btnToExtract=btnToExtract;
    }

}
