package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
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
 * KubunGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KubunGendoGakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    private TextBoxNum txtKubunShikyuGendoKijunGaku;
    @JsonProperty("txtYukoFromYMD")
    private TextBoxDate txtYukoFromYMD;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtYukoToYMD")
    private TextBoxDate txtYukoToYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public void setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.txtKubunShikyuGendoKijunGaku=txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("txtYukoFromYMD")
    public TextBoxDate getTxtYukoFromYMD() {
        return txtYukoFromYMD;
    }

    @JsonProperty("txtYukoFromYMD")
    public void setTxtYukoFromYMD(TextBoxDate txtYukoFromYMD) {
        this.txtYukoFromYMD=txtYukoFromYMD;
    }

    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara=lblKara;
    }

    @JsonProperty("txtYukoToYMD")
    public TextBoxDate getTxtYukoToYMD() {
        return txtYukoToYMD;
    }

    @JsonProperty("txtYukoToYMD")
    public void setTxtYukoToYMD(TextBoxDate txtYukoToYMD) {
        this.txtYukoToYMD=txtYukoToYMD;
    }

}
