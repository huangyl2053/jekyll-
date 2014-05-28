package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeShoruiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuKeikakuTodokedeShoruiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKyotakuKeikakuTodokedeDetailShorui のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKyotakuKeikakuTodokedeDetailShoruiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeShoruiList")
    private KyotakuKeikakuTodokedeShoruiListDiv KyotakuKeikakuTodokedeShoruiList;
    @JsonProperty("KyotakuKeikakuTodokedeShoruiMeisai")
    private KyotakuKeikakuTodokedeShoruiMeisaiDiv KyotakuKeikakuTodokedeShoruiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeShoruiList")
    public KyotakuKeikakuTodokedeShoruiListDiv getKyotakuKeikakuTodokedeShoruiList() {
        return KyotakuKeikakuTodokedeShoruiList;
    }

    @JsonProperty("KyotakuKeikakuTodokedeShoruiList")
    public void setKyotakuKeikakuTodokedeShoruiList(KyotakuKeikakuTodokedeShoruiListDiv KyotakuKeikakuTodokedeShoruiList) {
        this.KyotakuKeikakuTodokedeShoruiList=KyotakuKeikakuTodokedeShoruiList;
    }

    @JsonProperty("KyotakuKeikakuTodokedeShoruiMeisai")
    public KyotakuKeikakuTodokedeShoruiMeisaiDiv getKyotakuKeikakuTodokedeShoruiMeisai() {
        return KyotakuKeikakuTodokedeShoruiMeisai;
    }

    @JsonProperty("KyotakuKeikakuTodokedeShoruiMeisai")
    public void setKyotakuKeikakuTodokedeShoruiMeisai(KyotakuKeikakuTodokedeShoruiMeisaiDiv KyotakuKeikakuTodokedeShoruiMeisai) {
        this.KyotakuKeikakuTodokedeShoruiMeisai=KyotakuKeikakuTodokedeShoruiMeisai;
    }

}
