package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplHihokenshaRireki のクラスファイル
 *
 * @author 自動生成
 */
public class tplHihokenshaRirekiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShikakuTokusoRireki")
    private ShikakuTokusoRirekiDiv ShikakuTokusoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShikakuTokusoRireki")
    public ShikakuTokusoRirekiDiv getShikakuTokusoRireki() {
        return ShikakuTokusoRireki;
    }

    @JsonProperty("ShikakuTokusoRireki")
    public void setShikakuTokusoRireki(ShikakuTokusoRirekiDiv ShikakuTokusoRireki) {
        this.ShikakuTokusoRireki = ShikakuTokusoRireki;
    }

}
