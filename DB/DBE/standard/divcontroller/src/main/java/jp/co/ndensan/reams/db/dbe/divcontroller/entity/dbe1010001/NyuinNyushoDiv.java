package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.ShisetsuRerekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NyuinNyusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyuinNyushoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNyuinNyusho")
    private Label lblNyuinNyusho;
    @JsonProperty("radNyuinNyusho")
    private RadioButton radNyuinNyusho;
    @JsonProperty("ShisetsuRereki")
    private ShisetsuRerekiDiv ShisetsuRereki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblNyuinNyusho")
    public Label getLblNyuinNyusho() {
        return lblNyuinNyusho;
    }

    @JsonProperty("lblNyuinNyusho")
    public void setLblNyuinNyusho(Label lblNyuinNyusho) {
        this.lblNyuinNyusho=lblNyuinNyusho;
    }

    @JsonProperty("radNyuinNyusho")
    public RadioButton getRadNyuinNyusho() {
        return radNyuinNyusho;
    }

    @JsonProperty("radNyuinNyusho")
    public void setRadNyuinNyusho(RadioButton radNyuinNyusho) {
        this.radNyuinNyusho=radNyuinNyusho;
    }

    @JsonProperty("ShisetsuRereki")
    public ShisetsuRerekiDiv getShisetsuRereki() {
        return ShisetsuRereki;
    }

    @JsonProperty("ShisetsuRereki")
    public void setShisetsuRereki(ShisetsuRerekiDiv ShisetsuRereki) {
        this.ShisetsuRereki=ShisetsuRereki;
    }

}
