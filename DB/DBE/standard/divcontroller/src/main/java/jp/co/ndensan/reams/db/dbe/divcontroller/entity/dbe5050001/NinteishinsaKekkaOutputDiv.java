package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001.ShinsaKekkaJohoSakuseiTishoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001.ShinsaKekkaSyutsuryokuJokenNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteishinsaKekkaOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteishinsaKekkaOutputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsaKekkaSyutsuryokuJokenNyuryoku")
    private ShinsaKekkaSyutsuryokuJokenNyuryokuDiv ShinsaKekkaSyutsuryokuJokenNyuryoku;
    @JsonProperty("ShinsaKekkaJohoSakuseiTishosha")
    private ShinsaKekkaJohoSakuseiTishoshaDiv ShinsaKekkaJohoSakuseiTishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinsaKekkaSyutsuryokuJokenNyuryoku")
    public ShinsaKekkaSyutsuryokuJokenNyuryokuDiv getShinsaKekkaSyutsuryokuJokenNyuryoku() {
        return ShinsaKekkaSyutsuryokuJokenNyuryoku;
    }

    @JsonProperty("ShinsaKekkaSyutsuryokuJokenNyuryoku")
    public void setShinsaKekkaSyutsuryokuJokenNyuryoku(ShinsaKekkaSyutsuryokuJokenNyuryokuDiv ShinsaKekkaSyutsuryokuJokenNyuryoku) {
        this.ShinsaKekkaSyutsuryokuJokenNyuryoku=ShinsaKekkaSyutsuryokuJokenNyuryoku;
    }

    @JsonProperty("ShinsaKekkaJohoSakuseiTishosha")
    public ShinsaKekkaJohoSakuseiTishoshaDiv getShinsaKekkaJohoSakuseiTishosha() {
        return ShinsaKekkaJohoSakuseiTishosha;
    }

    @JsonProperty("ShinsaKekkaJohoSakuseiTishosha")
    public void setShinsaKekkaJohoSakuseiTishosha(ShinsaKekkaJohoSakuseiTishoshaDiv ShinsaKekkaJohoSakuseiTishosha) {
        this.ShinsaKekkaJohoSakuseiTishosha=ShinsaKekkaJohoSakuseiTishosha;
    }

}
