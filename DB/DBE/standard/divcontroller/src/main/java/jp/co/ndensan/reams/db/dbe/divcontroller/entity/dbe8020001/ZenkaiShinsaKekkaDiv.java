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
 * ZenkaiShinsaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkaiShinsaKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiShinsakaiHanteibi")
    private TextBoxDate txtZenkaiShinsakaiHanteibi;
    @JsonProperty("txtZenkaiYokaigoJotaiKbn")
    private TextBox txtZenkaiYokaigoJotaiKbn;
    @JsonProperty("txtZenkaiHenkoRiyu")
    private TextBox txtZenkaiHenkoRiyu;
    @JsonProperty("txtZenkaiShinsakaiIkenShurui")
    private TextBox txtZenkaiShinsakaiIkenShurui;
    @JsonProperty("txtZenkaiShinsakaiIken")
    private TextBox txtZenkaiShinsakaiIken;
    @JsonProperty("txtZenkaiShinsakaiMemo")
    private TextBox txtZenkaiShinsakaiMemo;
    @JsonProperty("txtZenkaiYokaigoJyotaizorei")
    private TextBox txtZenkaiYokaigoJyotaizorei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtZenkaiShinsakaiHanteibi")
    public TextBoxDate getTxtZenkaiShinsakaiHanteibi() {
        return txtZenkaiShinsakaiHanteibi;
    }

    @JsonProperty("txtZenkaiShinsakaiHanteibi")
    public void setTxtZenkaiShinsakaiHanteibi(TextBoxDate txtZenkaiShinsakaiHanteibi) {
        this.txtZenkaiShinsakaiHanteibi=txtZenkaiShinsakaiHanteibi;
    }

    @JsonProperty("txtZenkaiYokaigoJotaiKbn")
    public TextBox getTxtZenkaiYokaigoJotaiKbn() {
        return txtZenkaiYokaigoJotaiKbn;
    }

    @JsonProperty("txtZenkaiYokaigoJotaiKbn")
    public void setTxtZenkaiYokaigoJotaiKbn(TextBox txtZenkaiYokaigoJotaiKbn) {
        this.txtZenkaiYokaigoJotaiKbn=txtZenkaiYokaigoJotaiKbn;
    }

    @JsonProperty("txtZenkaiHenkoRiyu")
    public TextBox getTxtZenkaiHenkoRiyu() {
        return txtZenkaiHenkoRiyu;
    }

    @JsonProperty("txtZenkaiHenkoRiyu")
    public void setTxtZenkaiHenkoRiyu(TextBox txtZenkaiHenkoRiyu) {
        this.txtZenkaiHenkoRiyu=txtZenkaiHenkoRiyu;
    }

    @JsonProperty("txtZenkaiShinsakaiIkenShurui")
    public TextBox getTxtZenkaiShinsakaiIkenShurui() {
        return txtZenkaiShinsakaiIkenShurui;
    }

    @JsonProperty("txtZenkaiShinsakaiIkenShurui")
    public void setTxtZenkaiShinsakaiIkenShurui(TextBox txtZenkaiShinsakaiIkenShurui) {
        this.txtZenkaiShinsakaiIkenShurui=txtZenkaiShinsakaiIkenShurui;
    }

    @JsonProperty("txtZenkaiShinsakaiIken")
    public TextBox getTxtZenkaiShinsakaiIken() {
        return txtZenkaiShinsakaiIken;
    }

    @JsonProperty("txtZenkaiShinsakaiIken")
    public void setTxtZenkaiShinsakaiIken(TextBox txtZenkaiShinsakaiIken) {
        this.txtZenkaiShinsakaiIken=txtZenkaiShinsakaiIken;
    }

    @JsonProperty("txtZenkaiShinsakaiMemo")
    public TextBox getTxtZenkaiShinsakaiMemo() {
        return txtZenkaiShinsakaiMemo;
    }

    @JsonProperty("txtZenkaiShinsakaiMemo")
    public void setTxtZenkaiShinsakaiMemo(TextBox txtZenkaiShinsakaiMemo) {
        this.txtZenkaiShinsakaiMemo=txtZenkaiShinsakaiMemo;
    }

    @JsonProperty("txtZenkaiYokaigoJyotaizorei")
    public TextBox getTxtZenkaiYokaigoJyotaizorei() {
        return txtZenkaiYokaigoJyotaizorei;
    }

    @JsonProperty("txtZenkaiYokaigoJyotaizorei")
    public void setTxtZenkaiYokaigoJyotaizorei(TextBox txtZenkaiYokaigoJyotaizorei) {
        this.txtZenkaiYokaigoJyotaizorei=txtZenkaiYokaigoJyotaizorei;
    }

}
