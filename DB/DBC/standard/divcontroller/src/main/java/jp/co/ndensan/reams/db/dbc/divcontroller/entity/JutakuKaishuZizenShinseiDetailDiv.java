package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufugakuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuZizenShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuZizenShinseiDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiDetailInput")
    private JutakuKaishuShinseiDetailInputDiv JutakuKaishuJizenShinseiDetailInput;
    @JsonProperty("JutakuKaishuJizenShinseiKyufugakuSummary")
    private KyufugakuSummaryDiv JutakuKaishuJizenShinseiKyufugakuSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiDetailInput")
    public JutakuKaishuShinseiDetailInputDiv getJutakuKaishuJizenShinseiDetailInput() {
        return JutakuKaishuJizenShinseiDetailInput;
    }

    @JsonProperty("JutakuKaishuJizenShinseiDetailInput")
    public void setJutakuKaishuJizenShinseiDetailInput(JutakuKaishuShinseiDetailInputDiv JutakuKaishuJizenShinseiDetailInput) {
        this.JutakuKaishuJizenShinseiDetailInput=JutakuKaishuJizenShinseiDetailInput;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKyufugakuSummary")
    public KyufugakuSummaryDiv getJutakuKaishuJizenShinseiKyufugakuSummary() {
        return JutakuKaishuJizenShinseiKyufugakuSummary;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKyufugakuSummary")
    public void setJutakuKaishuJizenShinseiKyufugakuSummary(KyufugakuSummaryDiv JutakuKaishuJizenShinseiKyufugakuSummary) {
        this.JutakuKaishuJizenShinseiKyufugakuSummary=JutakuKaishuJizenShinseiKyufugakuSummary;
    }

}
