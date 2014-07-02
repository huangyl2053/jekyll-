package jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuShinseiDetailInputDiv;
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
    @JsonProperty("JutakuJizenShinseiDetailInput")
    private JutakuKaishuShinseiDetailInputDiv JutakuJizenShinseiDetailInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuJizenShinseiDetailInput")
    public JutakuKaishuShinseiDetailInputDiv getJutakuJizenShinseiDetailInput() {
        return JutakuJizenShinseiDetailInput;
    }

    @JsonProperty("JutakuJizenShinseiDetailInput")
    public void setJutakuJizenShinseiDetailInput(JutakuKaishuShinseiDetailInputDiv JutakuJizenShinseiDetailInput) {
        this.JutakuJizenShinseiDetailInput=JutakuJizenShinseiDetailInput;
    }

}
