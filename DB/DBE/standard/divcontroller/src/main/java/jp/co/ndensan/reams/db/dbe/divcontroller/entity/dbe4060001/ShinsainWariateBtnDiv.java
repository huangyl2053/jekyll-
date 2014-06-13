package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
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
 * ShinsainWariateBtn のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsainWariateBtnDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnWaritsukeShinsain")
    private Button btnWaritsukeShinsain;
    @JsonProperty("btnKaijoShinsain")
    private Button btnKaijoShinsain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnWaritsukeShinsain")
    public Button getBtnWaritsukeShinsain() {
        return btnWaritsukeShinsain;
    }

    @JsonProperty("btnWaritsukeShinsain")
    public void setBtnWaritsukeShinsain(Button btnWaritsukeShinsain) {
        this.btnWaritsukeShinsain=btnWaritsukeShinsain;
    }

    @JsonProperty("btnKaijoShinsain")
    public Button getBtnKaijoShinsain() {
        return btnKaijoShinsain;
    }

    @JsonProperty("btnKaijoShinsain")
    public void setBtnKaijoShinsain(Button btnKaijoShinsain) {
        this.btnKaijoShinsain=btnKaijoShinsain;
    }

}
