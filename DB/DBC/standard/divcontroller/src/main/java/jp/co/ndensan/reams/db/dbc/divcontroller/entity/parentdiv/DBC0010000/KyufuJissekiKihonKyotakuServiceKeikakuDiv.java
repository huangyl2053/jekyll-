package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiKihonKyotakuServiceKeikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonKyotakuServiceKeikakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun")
    private TextBox txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun;
    @JsonProperty("txtKyufuJissekiKihonJigyoshoNo")
    private TextBox txtKyufuJissekiKihonJigyoshoNo;
    @JsonProperty("txtKyufuJissekiKihonJigyoshoName")
    private TextBox txtKyufuJissekiKihonJigyoshoName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun")
    public TextBox getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun() {
        return txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun")
    public void setTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun(TextBox txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun) {
        this.txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun=txtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonJigyoshoNo")
    public TextBox getTxtKyufuJissekiKihonJigyoshoNo() {
        return txtKyufuJissekiKihonJigyoshoNo;
    }

    @JsonProperty("txtKyufuJissekiKihonJigyoshoNo")
    public void setTxtKyufuJissekiKihonJigyoshoNo(TextBox txtKyufuJissekiKihonJigyoshoNo) {
        this.txtKyufuJissekiKihonJigyoshoNo=txtKyufuJissekiKihonJigyoshoNo;
    }

    @JsonProperty("txtKyufuJissekiKihonJigyoshoName")
    public TextBox getTxtKyufuJissekiKihonJigyoshoName() {
        return txtKyufuJissekiKihonJigyoshoName;
    }

    @JsonProperty("txtKyufuJissekiKihonJigyoshoName")
    public void setTxtKyufuJissekiKihonJigyoshoName(TextBox txtKyufuJissekiKihonJigyoshoName) {
        this.txtKyufuJissekiKihonJigyoshoName=txtKyufuJissekiKihonJigyoshoName;
    }

}
