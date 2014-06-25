package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoChoteiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoZengoSentakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * InjiNaiyoSettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class InjiNaiyoSetteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    private KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu;
    @JsonProperty("KobetsuHakkoZengoSentaku")
    private KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public KobetsuHakkoChoteiJiyuDiv getKobetsuHakkoChoteiJiyu() {
        return KobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public void setKobetsuHakkoChoteiJiyu(KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu) {
        this.KobetsuHakkoChoteiJiyu=KobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("KobetsuHakkoZengoSentaku")
    public KobetsuHakkoZengoSentakuDiv getKobetsuHakkoZengoSentaku() {
        return KobetsuHakkoZengoSentaku;
    }

    @JsonProperty("KobetsuHakkoZengoSentaku")
    public void setKobetsuHakkoZengoSentaku(KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku) {
        this.KobetsuHakkoZengoSentaku=KobetsuHakkoZengoSentaku;
    }

}
