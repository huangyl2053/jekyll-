package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * SogoShokaiSaishinsaKohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiSaishinsaKohiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishinsaKohiJukyushaNo")
    private TextBoxCode txtSaishinsaKohiJukyushaNo;
    @JsonProperty("txtSaishinsaKohiJukyushaName")
    private TextBox txtSaishinsaKohiJukyushaName;
    @JsonProperty("txtSaishinsaKohiHokenshaNo")
    private TextBoxCode txtSaishinsaKohiHokenshaNo;
    @JsonProperty("txtSaishinsaKohiKekka")
    private TextBox txtSaishinsaKohiKekka;
    @JsonProperty("txtSaishinsaKohiToshoTanisu")
    private TextBoxNum txtSaishinsaKohiToshoTanisu;
    @JsonProperty("txtSaishinsaKohiGenshinTanisu")
    private TextBoxNum txtSaishinsaKohiGenshinTanisu;
    @JsonProperty("txtSaishinsaKohiMoshitateTanisu")
    private TextBoxNum txtSaishinsaKohiMoshitateTanisu;
    @JsonProperty("txtSaishinsaKohiKetteiTanisu")
    private TextBoxNum txtSaishinsaKohiKetteiTanisu;
    @JsonProperty("txtSaishinsaKohiChoseiTanisu")
    private TextBoxNum txtSaishinsaKohiChoseiTanisu;
    @JsonProperty("txtSaishinsaKohiFutangaku")
    private TextBoxNum txtSaishinsaKohiFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSaishinsaKohiJukyushaNo")
    public TextBoxCode getTxtSaishinsaKohiJukyushaNo() {
        return txtSaishinsaKohiJukyushaNo;
    }

    @JsonProperty("txtSaishinsaKohiJukyushaNo")
    public void setTxtSaishinsaKohiJukyushaNo(TextBoxCode txtSaishinsaKohiJukyushaNo) {
        this.txtSaishinsaKohiJukyushaNo=txtSaishinsaKohiJukyushaNo;
    }

    @JsonProperty("txtSaishinsaKohiJukyushaName")
    public TextBox getTxtSaishinsaKohiJukyushaName() {
        return txtSaishinsaKohiJukyushaName;
    }

    @JsonProperty("txtSaishinsaKohiJukyushaName")
    public void setTxtSaishinsaKohiJukyushaName(TextBox txtSaishinsaKohiJukyushaName) {
        this.txtSaishinsaKohiJukyushaName=txtSaishinsaKohiJukyushaName;
    }

    @JsonProperty("txtSaishinsaKohiHokenshaNo")
    public TextBoxCode getTxtSaishinsaKohiHokenshaNo() {
        return txtSaishinsaKohiHokenshaNo;
    }

    @JsonProperty("txtSaishinsaKohiHokenshaNo")
    public void setTxtSaishinsaKohiHokenshaNo(TextBoxCode txtSaishinsaKohiHokenshaNo) {
        this.txtSaishinsaKohiHokenshaNo=txtSaishinsaKohiHokenshaNo;
    }

    @JsonProperty("txtSaishinsaKohiKekka")
    public TextBox getTxtSaishinsaKohiKekka() {
        return txtSaishinsaKohiKekka;
    }

    @JsonProperty("txtSaishinsaKohiKekka")
    public void setTxtSaishinsaKohiKekka(TextBox txtSaishinsaKohiKekka) {
        this.txtSaishinsaKohiKekka=txtSaishinsaKohiKekka;
    }

    @JsonProperty("txtSaishinsaKohiToshoTanisu")
    public TextBoxNum getTxtSaishinsaKohiToshoTanisu() {
        return txtSaishinsaKohiToshoTanisu;
    }

    @JsonProperty("txtSaishinsaKohiToshoTanisu")
    public void setTxtSaishinsaKohiToshoTanisu(TextBoxNum txtSaishinsaKohiToshoTanisu) {
        this.txtSaishinsaKohiToshoTanisu=txtSaishinsaKohiToshoTanisu;
    }

    @JsonProperty("txtSaishinsaKohiGenshinTanisu")
    public TextBoxNum getTxtSaishinsaKohiGenshinTanisu() {
        return txtSaishinsaKohiGenshinTanisu;
    }

    @JsonProperty("txtSaishinsaKohiGenshinTanisu")
    public void setTxtSaishinsaKohiGenshinTanisu(TextBoxNum txtSaishinsaKohiGenshinTanisu) {
        this.txtSaishinsaKohiGenshinTanisu=txtSaishinsaKohiGenshinTanisu;
    }

    @JsonProperty("txtSaishinsaKohiMoshitateTanisu")
    public TextBoxNum getTxtSaishinsaKohiMoshitateTanisu() {
        return txtSaishinsaKohiMoshitateTanisu;
    }

    @JsonProperty("txtSaishinsaKohiMoshitateTanisu")
    public void setTxtSaishinsaKohiMoshitateTanisu(TextBoxNum txtSaishinsaKohiMoshitateTanisu) {
        this.txtSaishinsaKohiMoshitateTanisu=txtSaishinsaKohiMoshitateTanisu;
    }

    @JsonProperty("txtSaishinsaKohiKetteiTanisu")
    public TextBoxNum getTxtSaishinsaKohiKetteiTanisu() {
        return txtSaishinsaKohiKetteiTanisu;
    }

    @JsonProperty("txtSaishinsaKohiKetteiTanisu")
    public void setTxtSaishinsaKohiKetteiTanisu(TextBoxNum txtSaishinsaKohiKetteiTanisu) {
        this.txtSaishinsaKohiKetteiTanisu=txtSaishinsaKohiKetteiTanisu;
    }

    @JsonProperty("txtSaishinsaKohiChoseiTanisu")
    public TextBoxNum getTxtSaishinsaKohiChoseiTanisu() {
        return txtSaishinsaKohiChoseiTanisu;
    }

    @JsonProperty("txtSaishinsaKohiChoseiTanisu")
    public void setTxtSaishinsaKohiChoseiTanisu(TextBoxNum txtSaishinsaKohiChoseiTanisu) {
        this.txtSaishinsaKohiChoseiTanisu=txtSaishinsaKohiChoseiTanisu;
    }

    @JsonProperty("txtSaishinsaKohiFutangaku")
    public TextBoxNum getTxtSaishinsaKohiFutangaku() {
        return txtSaishinsaKohiFutangaku;
    }

    @JsonProperty("txtSaishinsaKohiFutangaku")
    public void setTxtSaishinsaKohiFutangaku(TextBoxNum txtSaishinsaKohiFutangaku) {
        this.txtSaishinsaKohiFutangaku=txtSaishinsaKohiFutangaku;
    }

}
