package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * SogoShokaiKyufuSeigenHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKyufuSeigenHenkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeigenHenkoYokokuTorokuYMD")
    private TextBoxDate txtSeigenHenkoYokokuTorokuYMD;
    @JsonProperty("txtSeigenHenkoKetteiYMD")
    private TextBoxDate txtSeigenHenkoKetteiYMD;
    @JsonProperty("txtSeigenHenkoSashitomeSyuryoYMD")
    private TextBoxDate txtSeigenHenkoSashitomeSyuryoYMD;
    @JsonProperty("txtSeigenHenkoTekiyoShuryoYMD")
    private TextBoxDate txtSeigenHenkoTekiyoShuryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSeigenHenkoYokokuTorokuYMD")
    public TextBoxDate getTxtSeigenHenkoYokokuTorokuYMD() {
        return txtSeigenHenkoYokokuTorokuYMD;
    }

    @JsonProperty("txtSeigenHenkoYokokuTorokuYMD")
    public void setTxtSeigenHenkoYokokuTorokuYMD(TextBoxDate txtSeigenHenkoYokokuTorokuYMD) {
        this.txtSeigenHenkoYokokuTorokuYMD=txtSeigenHenkoYokokuTorokuYMD;
    }

    @JsonProperty("txtSeigenHenkoKetteiYMD")
    public TextBoxDate getTxtSeigenHenkoKetteiYMD() {
        return txtSeigenHenkoKetteiYMD;
    }

    @JsonProperty("txtSeigenHenkoKetteiYMD")
    public void setTxtSeigenHenkoKetteiYMD(TextBoxDate txtSeigenHenkoKetteiYMD) {
        this.txtSeigenHenkoKetteiYMD=txtSeigenHenkoKetteiYMD;
    }

    @JsonProperty("txtSeigenHenkoSashitomeSyuryoYMD")
    public TextBoxDate getTxtSeigenHenkoSashitomeSyuryoYMD() {
        return txtSeigenHenkoSashitomeSyuryoYMD;
    }

    @JsonProperty("txtSeigenHenkoSashitomeSyuryoYMD")
    public void setTxtSeigenHenkoSashitomeSyuryoYMD(TextBoxDate txtSeigenHenkoSashitomeSyuryoYMD) {
        this.txtSeigenHenkoSashitomeSyuryoYMD=txtSeigenHenkoSashitomeSyuryoYMD;
    }

    @JsonProperty("txtSeigenHenkoTekiyoShuryoYMD")
    public TextBoxDate getTxtSeigenHenkoTekiyoShuryoYMD() {
        return txtSeigenHenkoTekiyoShuryoYMD;
    }

    @JsonProperty("txtSeigenHenkoTekiyoShuryoYMD")
    public void setTxtSeigenHenkoTekiyoShuryoYMD(TextBoxDate txtSeigenHenkoTekiyoShuryoYMD) {
        this.txtSeigenHenkoTekiyoShuryoYMD=txtSeigenHenkoTekiyoShuryoYMD;
    }

}
