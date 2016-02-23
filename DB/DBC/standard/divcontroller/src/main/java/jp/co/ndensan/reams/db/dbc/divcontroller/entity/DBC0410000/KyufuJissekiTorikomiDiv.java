package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000.KyufuJissekiTorikomiKakuninDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiTorikomiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriTaishoYM")
    private TextBoxDate txtShoriTaishoYM;
    @JsonProperty("txtSaiShoriKubun")
    private TextBox txtSaiShoriKubun;
    @JsonProperty("KyufuJissekiTorikomiKakunin")
    private KyufuJissekiTorikomiKakuninDiv KyufuJissekiTorikomiKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShoriTaishoYM")
    public TextBoxDate getTxtShoriTaishoYM() {
        return txtShoriTaishoYM;
    }

    @JsonProperty("txtShoriTaishoYM")
    public void setTxtShoriTaishoYM(TextBoxDate txtShoriTaishoYM) {
        this.txtShoriTaishoYM=txtShoriTaishoYM;
    }

    @JsonProperty("txtSaiShoriKubun")
    public TextBox getTxtSaiShoriKubun() {
        return txtSaiShoriKubun;
    }

    @JsonProperty("txtSaiShoriKubun")
    public void setTxtSaiShoriKubun(TextBox txtSaiShoriKubun) {
        this.txtSaiShoriKubun=txtSaiShoriKubun;
    }

    @JsonProperty("KyufuJissekiTorikomiKakunin")
    public KyufuJissekiTorikomiKakuninDiv getKyufuJissekiTorikomiKakunin() {
        return KyufuJissekiTorikomiKakunin;
    }

    @JsonProperty("KyufuJissekiTorikomiKakunin")
    public void setKyufuJissekiTorikomiKakunin(KyufuJissekiTorikomiKakuninDiv KyufuJissekiTorikomiKakunin) {
        this.KyufuJissekiTorikomiKakunin=KyufuJissekiTorikomiKakunin;
    }

}
