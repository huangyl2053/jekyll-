package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * KyufuJissekiMeisaiShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiMeisaiShukeiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiShukei")
    private KyufuJissekiShukeiDiv KyufuJissekiShukei;
    @JsonProperty("KyufuJissekiMeisai")
    private KyufuJissekiMeisaiDiv KyufuJissekiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuJissekiShukei")
    public KyufuJissekiShukeiDiv getKyufuJissekiShukei() {
        return KyufuJissekiShukei;
    }

    @JsonProperty("KyufuJissekiShukei")
    public void setKyufuJissekiShukei(KyufuJissekiShukeiDiv KyufuJissekiShukei) {
        this.KyufuJissekiShukei=KyufuJissekiShukei;
    }

    @JsonProperty("KyufuJissekiMeisai")
    public KyufuJissekiMeisaiDiv getKyufuJissekiMeisai() {
        return KyufuJissekiMeisai;
    }

    @JsonProperty("KyufuJissekiMeisai")
    public void setKyufuJissekiMeisai(KyufuJissekiMeisaiDiv KyufuJissekiMeisai) {
        this.KyufuJissekiMeisai=KyufuJissekiMeisai;
    }

}
