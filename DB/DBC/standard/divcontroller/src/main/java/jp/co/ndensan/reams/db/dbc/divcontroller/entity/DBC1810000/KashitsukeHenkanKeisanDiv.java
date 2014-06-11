package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000;
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
 * KashitsukeHenkanKeisan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanKeisanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtEntaiNissu")
    private TextBoxNum txtEntaiNissu;
    @JsonProperty("txtRisokugaku")
    private TextBoxNum txtRisokugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtEntaiNissu")
    public TextBoxNum getTxtEntaiNissu() {
        return txtEntaiNissu;
    }

    @JsonProperty("txtEntaiNissu")
    public void setTxtEntaiNissu(TextBoxNum txtEntaiNissu) {
        this.txtEntaiNissu=txtEntaiNissu;
    }

    @JsonProperty("txtRisokugaku")
    public TextBoxNum getTxtRisokugaku() {
        return txtRisokugaku;
    }

    @JsonProperty("txtRisokugaku")
    public void setTxtRisokugaku(TextBoxNum txtRisokugaku) {
        this.txtRisokugaku=txtRisokugaku;
    }

}
