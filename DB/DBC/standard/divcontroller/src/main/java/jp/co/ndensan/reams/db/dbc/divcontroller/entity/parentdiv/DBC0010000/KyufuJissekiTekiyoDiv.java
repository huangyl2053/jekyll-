package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
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
 * KyufuJissekiTekiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiTekiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyo")
    private TextBoxMultiLine txtTekiyo;
    @JsonProperty("btnKyufuJissekiTekiyoClose")
    private Button btnKyufuJissekiTekiyoClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTekiyo")
    public TextBoxMultiLine getTxtTekiyo() {
        return txtTekiyo;
    }

    @JsonProperty("txtTekiyo")
    public void setTxtTekiyo(TextBoxMultiLine txtTekiyo) {
        this.txtTekiyo=txtTekiyo;
    }

    @JsonProperty("btnKyufuJissekiTekiyoClose")
    public Button getBtnKyufuJissekiTekiyoClose() {
        return btnKyufuJissekiTekiyoClose;
    }

    @JsonProperty("btnKyufuJissekiTekiyoClose")
    public void setBtnKyufuJissekiTekiyoClose(Button btnKyufuJissekiTekiyoClose) {
        this.btnKyufuJissekiTekiyoClose=btnKyufuJissekiTekiyoClose;
    }

}
