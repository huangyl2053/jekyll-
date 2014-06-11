package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
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
 * OperationForShinsakaiIinList のクラスファイル 
 * 
 * @author 自動生成
 */
public class OperationForShinsakaiIinListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToAddShinsakaiIin")
    private ButtonDialog btnToAddShinsakaiIin;
    @JsonProperty("btnToDeliteShinsakaiIin")
    private Button btnToDeliteShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToAddShinsakaiIin")
    public ButtonDialog getBtnToAddShinsakaiIin() {
        return btnToAddShinsakaiIin;
    }

    @JsonProperty("btnToAddShinsakaiIin")
    public void setBtnToAddShinsakaiIin(ButtonDialog btnToAddShinsakaiIin) {
        this.btnToAddShinsakaiIin=btnToAddShinsakaiIin;
    }

    @JsonProperty("btnToDeliteShinsakaiIin")
    public Button getBtnToDeliteShinsakaiIin() {
        return btnToDeliteShinsakaiIin;
    }

    @JsonProperty("btnToDeliteShinsakaiIin")
    public void setBtnToDeliteShinsakaiIin(Button btnToDeliteShinsakaiIin) {
        this.btnToDeliteShinsakaiIin=btnToDeliteShinsakaiIin;
    }

}
