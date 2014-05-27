package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKyotakuJikoTodokedeDetailRirekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKyotakuJikoTodokedeDetailShoruiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKyotakuServiceJikoSakuseiTodokede のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKyotakuServiceJikoSakuseiTodokedeDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKyotakuJikoTodokedeDetailRireki")
    private tplKyotakuJikoTodokedeDetailRirekiDiv tplKyotakuJikoTodokedeDetailRireki;
    @JsonProperty("tplKyotakuJikoTodokedeDetailShorui")
    private tplKyotakuJikoTodokedeDetailShoruiDiv tplKyotakuJikoTodokedeDetailShorui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplKyotakuJikoTodokedeDetailRireki")
    public tplKyotakuJikoTodokedeDetailRirekiDiv getTplKyotakuJikoTodokedeDetailRireki() {
        return tplKyotakuJikoTodokedeDetailRireki;
    }

    @JsonProperty("tplKyotakuJikoTodokedeDetailRireki")
    public void setTplKyotakuJikoTodokedeDetailRireki(tplKyotakuJikoTodokedeDetailRirekiDiv tplKyotakuJikoTodokedeDetailRireki) {
        this.tplKyotakuJikoTodokedeDetailRireki=tplKyotakuJikoTodokedeDetailRireki;
    }

    @JsonProperty("tplKyotakuJikoTodokedeDetailShorui")
    public tplKyotakuJikoTodokedeDetailShoruiDiv getTplKyotakuJikoTodokedeDetailShorui() {
        return tplKyotakuJikoTodokedeDetailShorui;
    }

    @JsonProperty("tplKyotakuJikoTodokedeDetailShorui")
    public void setTplKyotakuJikoTodokedeDetailShorui(tplKyotakuJikoTodokedeDetailShoruiDiv tplKyotakuJikoTodokedeDetailShorui) {
        this.tplKyotakuJikoTodokedeDetailShorui=tplKyotakuJikoTodokedeDetailShorui;
    }

}
