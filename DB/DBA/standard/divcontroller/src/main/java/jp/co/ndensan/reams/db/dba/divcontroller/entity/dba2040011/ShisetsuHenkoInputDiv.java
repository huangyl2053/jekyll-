package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011;
/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.AfterShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.BeforeShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.ShisetsuHenkoTekiyoJiyuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuHenkoInput のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuHenkoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShisetsuHenkoTekiyoJiyuInput")
    private ShisetsuHenkoTekiyoJiyuInputDiv ShisetsuHenkoTekiyoJiyuInput;
    @JsonProperty("BeforeShisetsuJohoInput")
    private BeforeShisetsuJohoInputDiv BeforeShisetsuJohoInput;
    @JsonProperty("AfterShisetsuJohoInput")
    private AfterShisetsuJohoInputDiv AfterShisetsuJohoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShisetsuHenkoTekiyoJiyuInput")
    public ShisetsuHenkoTekiyoJiyuInputDiv getShisetsuHenkoTekiyoJiyuInput() {
        return ShisetsuHenkoTekiyoJiyuInput;
    }

    @JsonProperty("ShisetsuHenkoTekiyoJiyuInput")
    public void setShisetsuHenkoTekiyoJiyuInput(ShisetsuHenkoTekiyoJiyuInputDiv ShisetsuHenkoTekiyoJiyuInput) {
        this.ShisetsuHenkoTekiyoJiyuInput = ShisetsuHenkoTekiyoJiyuInput;
    }

    @JsonProperty("BeforeShisetsuJohoInput")
    public BeforeShisetsuJohoInputDiv getBeforeShisetsuJohoInput() {
        return BeforeShisetsuJohoInput;
    }

    @JsonProperty("BeforeShisetsuJohoInput")
    public void setBeforeShisetsuJohoInput(BeforeShisetsuJohoInputDiv BeforeShisetsuJohoInput) {
        this.BeforeShisetsuJohoInput = BeforeShisetsuJohoInput;
    }

    @JsonProperty("AfterShisetsuJohoInput")
    public AfterShisetsuJohoInputDiv getAfterShisetsuJohoInput() {
        return AfterShisetsuJohoInput;
    }

    @JsonProperty("AfterShisetsuJohoInput")
    public void setAfterShisetsuJohoInput(AfterShisetsuJohoInputDiv AfterShisetsuJohoInput) {
        this.AfterShisetsuJohoInput = AfterShisetsuJohoInput;
    }

}
