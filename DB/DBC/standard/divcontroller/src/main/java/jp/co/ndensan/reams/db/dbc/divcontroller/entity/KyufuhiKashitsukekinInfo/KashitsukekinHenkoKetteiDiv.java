package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
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
 * KashitsukekinHenkoKettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinHenkoKetteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoShoninKubun")
    private TextBox txtHenkoShoninKubun;
    @JsonProperty("txtHenkogoKigen")
    private TextBoxDate txtHenkogoKigen;
    @JsonProperty("txtHenkoKetteiYMD")
    private TextBoxDate txtHenkoKetteiYMD;
    @JsonProperty("txtHenkoFushoninRiyu")
    private TextBox txtHenkoFushoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHenkoShoninKubun")
    public TextBox getTxtHenkoShoninKubun() {
        return txtHenkoShoninKubun;
    }

    @JsonProperty("txtHenkoShoninKubun")
    public void setTxtHenkoShoninKubun(TextBox txtHenkoShoninKubun) {
        this.txtHenkoShoninKubun=txtHenkoShoninKubun;
    }

    @JsonProperty("txtHenkogoKigen")
    public TextBoxDate getTxtHenkogoKigen() {
        return txtHenkogoKigen;
    }

    @JsonProperty("txtHenkogoKigen")
    public void setTxtHenkogoKigen(TextBoxDate txtHenkogoKigen) {
        this.txtHenkogoKigen=txtHenkogoKigen;
    }

    @JsonProperty("txtHenkoKetteiYMD")
    public TextBoxDate getTxtHenkoKetteiYMD() {
        return txtHenkoKetteiYMD;
    }

    @JsonProperty("txtHenkoKetteiYMD")
    public void setTxtHenkoKetteiYMD(TextBoxDate txtHenkoKetteiYMD) {
        this.txtHenkoKetteiYMD=txtHenkoKetteiYMD;
    }

    @JsonProperty("txtHenkoFushoninRiyu")
    public TextBox getTxtHenkoFushoninRiyu() {
        return txtHenkoFushoninRiyu;
    }

    @JsonProperty("txtHenkoFushoninRiyu")
    public void setTxtHenkoFushoninRiyu(TextBox txtHenkoFushoninRiyu) {
        this.txtHenkoFushoninRiyu=txtHenkoFushoninRiyu;
    }

}
