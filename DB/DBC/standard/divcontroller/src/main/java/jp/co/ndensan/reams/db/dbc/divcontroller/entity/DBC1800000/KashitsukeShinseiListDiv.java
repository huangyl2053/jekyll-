package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinList.KyufuhiKashitsukekinListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukeShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukeShinseiListInfo")
    private KyufuhiKashitsukekinListDiv KashitsukeShinseiListInfo;
    @JsonProperty("KashitsukeShinseisho")
    private KashitsukeShinseishoDiv KashitsukeShinseisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukeShinseiListInfo")
    public KyufuhiKashitsukekinListDiv getKashitsukeShinseiListInfo() {
        return KashitsukeShinseiListInfo;
    }

    @JsonProperty("KashitsukeShinseiListInfo")
    public void setKashitsukeShinseiListInfo(KyufuhiKashitsukekinListDiv KashitsukeShinseiListInfo) {
        this.KashitsukeShinseiListInfo=KashitsukeShinseiListInfo;
    }

    @JsonProperty("KashitsukeShinseisho")
    public KashitsukeShinseishoDiv getKashitsukeShinseisho() {
        return KashitsukeShinseisho;
    }

    @JsonProperty("KashitsukeShinseisho")
    public void setKashitsukeShinseisho(KashitsukeShinseishoDiv KashitsukeShinseisho) {
        this.KashitsukeShinseisho=KashitsukeShinseisho;
    }

}
