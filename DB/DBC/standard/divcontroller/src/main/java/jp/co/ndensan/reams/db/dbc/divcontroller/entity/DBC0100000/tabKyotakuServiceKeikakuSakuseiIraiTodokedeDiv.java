package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.tplKyotakuKeikakuTodokedeDetailRirekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.tplKyotakuKeikakuTodokedeDetailShoruiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKyotakuServiceKeikakuSakuseiIraiTodokede のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKyotakuServiceKeikakuSakuseiIraiTodokedeDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKyotakuKeikakuTodokedeDetailRireki")
    private tplKyotakuKeikakuTodokedeDetailRirekiDiv tplKyotakuKeikakuTodokedeDetailRireki;
    @JsonProperty("tplKyotakuKeikakuTodokedeDetailShorui")
    private tplKyotakuKeikakuTodokedeDetailShoruiDiv tplKyotakuKeikakuTodokedeDetailShorui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplKyotakuKeikakuTodokedeDetailRireki")
    public tplKyotakuKeikakuTodokedeDetailRirekiDiv getTplKyotakuKeikakuTodokedeDetailRireki() {
        return tplKyotakuKeikakuTodokedeDetailRireki;
    }

    @JsonProperty("tplKyotakuKeikakuTodokedeDetailRireki")
    public void setTplKyotakuKeikakuTodokedeDetailRireki(tplKyotakuKeikakuTodokedeDetailRirekiDiv tplKyotakuKeikakuTodokedeDetailRireki) {
        this.tplKyotakuKeikakuTodokedeDetailRireki=tplKyotakuKeikakuTodokedeDetailRireki;
    }

    @JsonProperty("tplKyotakuKeikakuTodokedeDetailShorui")
    public tplKyotakuKeikakuTodokedeDetailShoruiDiv getTplKyotakuKeikakuTodokedeDetailShorui() {
        return tplKyotakuKeikakuTodokedeDetailShorui;
    }

    @JsonProperty("tplKyotakuKeikakuTodokedeDetailShorui")
    public void setTplKyotakuKeikakuTodokedeDetailShorui(tplKyotakuKeikakuTodokedeDetailShoruiDiv tplKyotakuKeikakuTodokedeDetailShorui) {
        this.tplKyotakuKeikakuTodokedeDetailShorui=tplKyotakuKeikakuTodokedeDetailShorui;
    }

}
