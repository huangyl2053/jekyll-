package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceJikoSakuseiSummarySub2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceJikoSakuseiSummarySub2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub2")
    private tblKyotakuServiceJikoSakuseiSummarySub2Div tblKyotakuServiceJikoSakuseiSummarySub2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub2")
    public tblKyotakuServiceJikoSakuseiSummarySub2Div getTblKyotakuServiceJikoSakuseiSummarySub2() {
        return tblKyotakuServiceJikoSakuseiSummarySub2;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub2")
    public void setTblKyotakuServiceJikoSakuseiSummarySub2(tblKyotakuServiceJikoSakuseiSummarySub2Div tblKyotakuServiceJikoSakuseiSummarySub2) {
        this.tblKyotakuServiceJikoSakuseiSummarySub2=tblKyotakuServiceJikoSakuseiSummarySub2;
    }

}
