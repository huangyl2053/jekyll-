package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseishaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseishaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseishaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    private YoguKonyuhiShikyuShinseishaDiv YoguKonyuhiShikyuShinseisha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("txtUketsukeYMD")
    public TextBoxDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.txtUketsukeYMD=txtUketsukeYMD;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    public YoguKonyuhiShikyuShinseishaDiv getYoguKonyuhiShikyuShinseisha() {
        return YoguKonyuhiShikyuShinseisha;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    public void setYoguKonyuhiShikyuShinseisha(YoguKonyuhiShikyuShinseishaDiv YoguKonyuhiShikyuShinseisha) {
        this.YoguKonyuhiShikyuShinseisha=YoguKonyuhiShikyuShinseisha;
    }

}
