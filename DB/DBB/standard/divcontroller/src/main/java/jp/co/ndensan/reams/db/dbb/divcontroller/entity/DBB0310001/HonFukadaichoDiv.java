package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * HonFukadaicho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonFukadaichoDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Shuturyokujun5")
    private Shuturyokujun5Div Shuturyokujun5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Shuturyokujun5")
    public Shuturyokujun5Div getShuturyokujun5() {
        return Shuturyokujun5;
    }

    @JsonProperty("Shuturyokujun5")
    public void setShuturyokujun5(Shuturyokujun5Div Shuturyokujun5) {
        this.Shuturyokujun5=Shuturyokujun5;
    }

}
