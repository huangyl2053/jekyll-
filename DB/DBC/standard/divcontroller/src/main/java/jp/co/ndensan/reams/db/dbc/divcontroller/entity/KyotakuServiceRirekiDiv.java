package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJikoTodokedeRirekiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * KyotakuServiceRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceRirekiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuJikoTodokedeRirekiList")
    private KyotakuJikoTodokedeRirekiListDiv KyotakuJikoTodokedeRirekiList;
    @JsonProperty("KyotakuJikoTodokedeMeisai")
    private KyotakuJikoTodokedeMeisaiDiv KyotakuJikoTodokedeMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuJikoTodokedeRirekiList")
    public KyotakuJikoTodokedeRirekiListDiv getKyotakuJikoTodokedeRirekiList() {
        return KyotakuJikoTodokedeRirekiList;
    }

    @JsonProperty("KyotakuJikoTodokedeRirekiList")
    public void setKyotakuJikoTodokedeRirekiList(KyotakuJikoTodokedeRirekiListDiv KyotakuJikoTodokedeRirekiList) {
        this.KyotakuJikoTodokedeRirekiList=KyotakuJikoTodokedeRirekiList;
    }

    @JsonProperty("KyotakuJikoTodokedeMeisai")
    public KyotakuJikoTodokedeMeisaiDiv getKyotakuJikoTodokedeMeisai() {
        return KyotakuJikoTodokedeMeisai;
    }

    @JsonProperty("KyotakuJikoTodokedeMeisai")
    public void setKyotakuJikoTodokedeMeisai(KyotakuJikoTodokedeMeisaiDiv KyotakuJikoTodokedeMeisai) {
        this.KyotakuJikoTodokedeMeisai=KyotakuJikoTodokedeMeisai;
    }

}
