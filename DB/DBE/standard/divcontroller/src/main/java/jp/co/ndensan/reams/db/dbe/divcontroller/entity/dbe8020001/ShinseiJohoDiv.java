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
 * ShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiEdaban")
    private TextBox txtShinseiEdaban;
    @JsonProperty("txtShinseiKbnHorei")
    private TextBox txtShinseiKbnHorei;
    @JsonProperty("txtYokaigoYoshienShinseiKbn")
    private TextBox txtYokaigoYoshienShinseiKbn;
    @JsonProperty("txtKyakkabi")
    private TextBoxDate txtKyakkabi;
    @JsonProperty("txtShoriKbn")
    private TextBox txtShoriKbn;
    @JsonProperty("txtShoribi")
    private TextBoxDate txtShoribi;
    @JsonProperty("txtShoriRiyu")
    private TextBox txtShoriRiyu;
    @JsonProperty("txtEnkiTsuchiHakkoKaisu")
    private TextBox txtEnkiTsuchiHakkoKaisu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiEdaban")
    public TextBox getTxtShinseiEdaban() {
        return txtShinseiEdaban;
    }

    @JsonProperty("txtShinseiEdaban")
    public void setTxtShinseiEdaban(TextBox txtShinseiEdaban) {
        this.txtShinseiEdaban=txtShinseiEdaban;
    }

    @JsonProperty("txtShinseiKbnHorei")
    public TextBox getTxtShinseiKbnHorei() {
        return txtShinseiKbnHorei;
    }

    @JsonProperty("txtShinseiKbnHorei")
    public void setTxtShinseiKbnHorei(TextBox txtShinseiKbnHorei) {
        this.txtShinseiKbnHorei=txtShinseiKbnHorei;
    }

    @JsonProperty("txtYokaigoYoshienShinseiKbn")
    public TextBox getTxtYokaigoYoshienShinseiKbn() {
        return txtYokaigoYoshienShinseiKbn;
    }

    @JsonProperty("txtYokaigoYoshienShinseiKbn")
    public void setTxtYokaigoYoshienShinseiKbn(TextBox txtYokaigoYoshienShinseiKbn) {
        this.txtYokaigoYoshienShinseiKbn=txtYokaigoYoshienShinseiKbn;
    }

    @JsonProperty("txtKyakkabi")
    public TextBoxDate getTxtKyakkabi() {
        return txtKyakkabi;
    }

    @JsonProperty("txtKyakkabi")
    public void setTxtKyakkabi(TextBoxDate txtKyakkabi) {
        this.txtKyakkabi=txtKyakkabi;
    }

    @JsonProperty("txtShoriKbn")
    public TextBox getTxtShoriKbn() {
        return txtShoriKbn;
    }

    @JsonProperty("txtShoriKbn")
    public void setTxtShoriKbn(TextBox txtShoriKbn) {
        this.txtShoriKbn=txtShoriKbn;
    }

    @JsonProperty("txtShoribi")
    public TextBoxDate getTxtShoribi() {
        return txtShoribi;
    }

    @JsonProperty("txtShoribi")
    public void setTxtShoribi(TextBoxDate txtShoribi) {
        this.txtShoribi=txtShoribi;
    }

    @JsonProperty("txtShoriRiyu")
    public TextBox getTxtShoriRiyu() {
        return txtShoriRiyu;
    }

    @JsonProperty("txtShoriRiyu")
    public void setTxtShoriRiyu(TextBox txtShoriRiyu) {
        this.txtShoriRiyu=txtShoriRiyu;
    }

    @JsonProperty("txtEnkiTsuchiHakkoKaisu")
    public TextBox getTxtEnkiTsuchiHakkoKaisu() {
        return txtEnkiTsuchiHakkoKaisu;
    }

    @JsonProperty("txtEnkiTsuchiHakkoKaisu")
    public void setTxtEnkiTsuchiHakkoKaisu(TextBox txtEnkiTsuchiHakkoKaisu) {
        this.txtEnkiTsuchiHakkoKaisu=txtEnkiTsuchiHakkoKaisu;
    }

}
