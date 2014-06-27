package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
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
 * ButtonsForNinteichosaIraiListBottom のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForNinteichosaIraiListBottomDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToPublishIraisho")
    private Button btnToPublishIraisho;
    @JsonProperty("btnToOutputData")
    private Button btnToOutputData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToPublishIraisho")
    public Button getBtnToPublishIraisho() {
        return btnToPublishIraisho;
    }

    @JsonProperty("btnToPublishIraisho")
    public void setBtnToPublishIraisho(Button btnToPublishIraisho) {
        this.btnToPublishIraisho=btnToPublishIraisho;
    }

    @JsonProperty("btnToOutputData")
    public Button getBtnToOutputData() {
        return btnToOutputData;
    }

    @JsonProperty("btnToOutputData")
    public void setBtnToOutputData(Button btnToOutputData) {
        this.btnToOutputData=btnToOutputData;
    }

}
