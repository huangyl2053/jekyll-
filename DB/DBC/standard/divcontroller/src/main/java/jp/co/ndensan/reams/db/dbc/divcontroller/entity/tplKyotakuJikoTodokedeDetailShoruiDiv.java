package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeShoruiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeShoruiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKyotakuJikoTodokedeDetailShorui のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKyotakuJikoTodokedeDetailShoruiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuJikoTodokedeShoruiList")
    private KyotakuJikoTodokedeShoruiListDiv KyotakuJikoTodokedeShoruiList;
    @JsonProperty("KyotakuJikoTodokedeShoruiMeisai")
    private KyotakuJikoTodokedeShoruiMeisaiDiv KyotakuJikoTodokedeShoruiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuJikoTodokedeShoruiList")
    public KyotakuJikoTodokedeShoruiListDiv getKyotakuJikoTodokedeShoruiList() {
        return KyotakuJikoTodokedeShoruiList;
    }

    @JsonProperty("KyotakuJikoTodokedeShoruiList")
    public void setKyotakuJikoTodokedeShoruiList(KyotakuJikoTodokedeShoruiListDiv KyotakuJikoTodokedeShoruiList) {
        this.KyotakuJikoTodokedeShoruiList=KyotakuJikoTodokedeShoruiList;
    }

    @JsonProperty("KyotakuJikoTodokedeShoruiMeisai")
    public KyotakuJikoTodokedeShoruiMeisaiDiv getKyotakuJikoTodokedeShoruiMeisai() {
        return KyotakuJikoTodokedeShoruiMeisai;
    }

    @JsonProperty("KyotakuJikoTodokedeShoruiMeisai")
    public void setKyotakuJikoTodokedeShoruiMeisai(KyotakuJikoTodokedeShoruiMeisaiDiv KyotakuJikoTodokedeShoruiMeisai) {
        this.KyotakuJikoTodokedeShoruiMeisai=KyotakuJikoTodokedeShoruiMeisai;
    }

}
