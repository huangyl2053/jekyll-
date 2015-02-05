package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.ShikakuHenkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplHenkoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuHenko")
    private ShikakuHenkoDiv ShikakuHenko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShikakuHenko")
    public ShikakuHenkoDiv getShikakuHenko() {
        return ShikakuHenko;
    }

    @JsonProperty("ShikakuHenko")
    public void setShikakuHenko(ShikakuHenkoDiv ShikakuHenko) {
        this.ShikakuHenko=ShikakuHenko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShikakuHenkoRirekiDiv getCcdShikakuHenkoRireki() {
        return this.getShikakuHenko().getCcdShikakuHenkoRireki();
    }

}
