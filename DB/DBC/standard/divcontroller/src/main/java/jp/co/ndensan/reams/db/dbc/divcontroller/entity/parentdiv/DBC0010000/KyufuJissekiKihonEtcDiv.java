package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKohiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiKihonEtc のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonEtcDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiKihonKohi")
    private KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi;
    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    private TextBox txtKyufuJissekiKihonShinsaYM;
    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    private TextBox txtKyufuJissekiKihonKeikokuKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuJissekiKihonKohi")
    public KyufuJissekiKihonKohiDiv getKyufuJissekiKihonKohi() {
        return KyufuJissekiKihonKohi;
    }

    @JsonProperty("KyufuJissekiKihonKohi")
    public void setKyufuJissekiKihonKohi(KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi) {
        this.KyufuJissekiKihonKohi=KyufuJissekiKihonKohi;
    }

    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public TextBox getTxtKyufuJissekiKihonShinsaYM() {
        return txtKyufuJissekiKihonShinsaYM;
    }

    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public void setTxtKyufuJissekiKihonShinsaYM(TextBox txtKyufuJissekiKihonShinsaYM) {
        this.txtKyufuJissekiKihonShinsaYM=txtKyufuJissekiKihonShinsaYM;
    }

    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public TextBox getTxtKyufuJissekiKihonKeikokuKubun() {
        return txtKyufuJissekiKihonKeikokuKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public void setTxtKyufuJissekiKihonKeikokuKubun(TextBox txtKyufuJissekiKihonKeikokuKubun) {
        this.txtKyufuJissekiKihonKeikokuKubun=txtKyufuJissekiKihonKeikokuKubun;
    }

}
