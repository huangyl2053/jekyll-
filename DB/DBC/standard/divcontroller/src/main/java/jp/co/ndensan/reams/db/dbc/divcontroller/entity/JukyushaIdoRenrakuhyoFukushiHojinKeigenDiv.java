package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * JukyushaIdoRenrakuhyoFukushiHojinKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeigenritsu")
    private TextBoxNum txtKeigenritsu;
    @JsonProperty("txtKeigenritsuTekiyoDateRange")
    private TextBoxDateRange txtKeigenritsuTekiyoDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKeigenritsu")
    public TextBoxNum getTxtKeigenritsu() {
        return txtKeigenritsu;
    }

    @JsonProperty("txtKeigenritsu")
    public void setTxtKeigenritsu(TextBoxNum txtKeigenritsu) {
        this.txtKeigenritsu=txtKeigenritsu;
    }

    @JsonProperty("txtKeigenritsuTekiyoDateRange")
    public TextBoxDateRange getTxtKeigenritsuTekiyoDateRange() {
        return txtKeigenritsuTekiyoDateRange;
    }

    @JsonProperty("txtKeigenritsuTekiyoDateRange")
    public void setTxtKeigenritsuTekiyoDateRange(TextBoxDateRange txtKeigenritsuTekiyoDateRange) {
        this.txtKeigenritsuTekiyoDateRange=txtKeigenritsuTekiyoDateRange;
    }

}
