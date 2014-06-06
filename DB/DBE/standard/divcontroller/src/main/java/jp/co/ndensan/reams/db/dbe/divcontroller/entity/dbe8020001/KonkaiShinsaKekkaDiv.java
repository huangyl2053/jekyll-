package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
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
 * KonkaiShinsaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class KonkaiShinsaKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigoJotaiKbn")
    private TextBox txtYokaigoJotaiKbn;
    @JsonProperty("txtHenkoRiyu")
    private TextBox txtHenkoRiyu;
    @JsonProperty("txtShinsakaiIkenShurui")
    private TextBox txtShinsakaiIkenShurui;
    @JsonProperty("txtShinsakaiIken")
    private TextBox txtShinsakaiIken;
    @JsonProperty("txtShinsakaiMemo")
    private TextBox txtShinsakaiMemo;
    @JsonProperty("txtYokaigoJyotaizorei")
    private TextBox txtYokaigoJyotaizorei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtYokaigoJotaiKbn")
    public TextBox getTxtYokaigoJotaiKbn() {
        return txtYokaigoJotaiKbn;
    }

    @JsonProperty("txtYokaigoJotaiKbn")
    public void setTxtYokaigoJotaiKbn(TextBox txtYokaigoJotaiKbn) {
        this.txtYokaigoJotaiKbn=txtYokaigoJotaiKbn;
    }

    @JsonProperty("txtHenkoRiyu")
    public TextBox getTxtHenkoRiyu() {
        return txtHenkoRiyu;
    }

    @JsonProperty("txtHenkoRiyu")
    public void setTxtHenkoRiyu(TextBox txtHenkoRiyu) {
        this.txtHenkoRiyu=txtHenkoRiyu;
    }

    @JsonProperty("txtShinsakaiIkenShurui")
    public TextBox getTxtShinsakaiIkenShurui() {
        return txtShinsakaiIkenShurui;
    }

    @JsonProperty("txtShinsakaiIkenShurui")
    public void setTxtShinsakaiIkenShurui(TextBox txtShinsakaiIkenShurui) {
        this.txtShinsakaiIkenShurui=txtShinsakaiIkenShurui;
    }

    @JsonProperty("txtShinsakaiIken")
    public TextBox getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBox txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiMemo")
    public TextBox getTxtShinsakaiMemo() {
        return txtShinsakaiMemo;
    }

    @JsonProperty("txtShinsakaiMemo")
    public void setTxtShinsakaiMemo(TextBox txtShinsakaiMemo) {
        this.txtShinsakaiMemo=txtShinsakaiMemo;
    }

    @JsonProperty("txtYokaigoJyotaizorei")
    public TextBox getTxtYokaigoJyotaizorei() {
        return txtYokaigoJyotaizorei;
    }

    @JsonProperty("txtYokaigoJyotaizorei")
    public void setTxtYokaigoJyotaizorei(TextBox txtYokaigoJyotaizorei) {
        this.txtYokaigoJyotaizorei=txtYokaigoJyotaizorei;
    }

}
