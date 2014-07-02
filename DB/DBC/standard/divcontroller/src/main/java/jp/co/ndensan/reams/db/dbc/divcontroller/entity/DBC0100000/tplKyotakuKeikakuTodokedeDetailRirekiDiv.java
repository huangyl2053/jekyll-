package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeRirekiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKyotakuKeikakuTodokedeDetailRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKyotakuKeikakuTodokedeDetailRirekiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeRirekiList")
    private KyotakuKeikakuTodokedeRirekiListDiv KyotakuKeikakuTodokedeRirekiList;
    @JsonProperty("KyotakuKeikakuTodokedeMeisai")
    private KyotakuKeikakuTodokedeMeisaiDiv KyotakuKeikakuTodokedeMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuKeikakuTodokedeRirekiList")
    public KyotakuKeikakuTodokedeRirekiListDiv getKyotakuKeikakuTodokedeRirekiList() {
        return KyotakuKeikakuTodokedeRirekiList;
    }

    @JsonProperty("KyotakuKeikakuTodokedeRirekiList")
    public void setKyotakuKeikakuTodokedeRirekiList(KyotakuKeikakuTodokedeRirekiListDiv KyotakuKeikakuTodokedeRirekiList) {
        this.KyotakuKeikakuTodokedeRirekiList=KyotakuKeikakuTodokedeRirekiList;
    }

    @JsonProperty("KyotakuKeikakuTodokedeMeisai")
    public KyotakuKeikakuTodokedeMeisaiDiv getKyotakuKeikakuTodokedeMeisai() {
        return KyotakuKeikakuTodokedeMeisai;
    }

    @JsonProperty("KyotakuKeikakuTodokedeMeisai")
    public void setKyotakuKeikakuTodokedeMeisai(KyotakuKeikakuTodokedeMeisaiDiv KyotakuKeikakuTodokedeMeisai) {
        this.KyotakuKeikakuTodokedeMeisai=KyotakuKeikakuTodokedeMeisai;
    }

}
