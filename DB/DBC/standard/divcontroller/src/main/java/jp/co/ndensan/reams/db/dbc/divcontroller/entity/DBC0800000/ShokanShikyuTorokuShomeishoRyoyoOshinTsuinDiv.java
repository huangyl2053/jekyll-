package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
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
 * ShokanShikyuTorokuShomeishoRyoyoOshinTsuin のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblRyoyohiOshin")
    private Label lblRyoyohiOshin;
    @JsonProperty("txtRyoyohiOshinNissu")
    private TextBoxNum txtRyoyohiOshinNissu;
    @JsonProperty("txtRyoyohiOshinKikanName")
    private TextBox txtRyoyohiOshinKikanName;
    @JsonProperty("lblRyoyohiTsuin")
    private Label lblRyoyohiTsuin;
    @JsonProperty("txtRyoyohiTsuinNissu")
    private TextBoxNum txtRyoyohiTsuinNissu;
    @JsonProperty("txtRyoyohiTsuinKikanName")
    private TextBox txtRyoyohiTsuinKikanName;
    @JsonProperty("txtRyoyohiTekiyo")
    private TextBox txtRyoyohiTekiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblRyoyohiOshin")
    public Label getLblRyoyohiOshin() {
        return lblRyoyohiOshin;
    }

    @JsonProperty("lblRyoyohiOshin")
    public void setLblRyoyohiOshin(Label lblRyoyohiOshin) {
        this.lblRyoyohiOshin=lblRyoyohiOshin;
    }

    @JsonProperty("txtRyoyohiOshinNissu")
    public TextBoxNum getTxtRyoyohiOshinNissu() {
        return txtRyoyohiOshinNissu;
    }

    @JsonProperty("txtRyoyohiOshinNissu")
    public void setTxtRyoyohiOshinNissu(TextBoxNum txtRyoyohiOshinNissu) {
        this.txtRyoyohiOshinNissu=txtRyoyohiOshinNissu;
    }

    @JsonProperty("txtRyoyohiOshinKikanName")
    public TextBox getTxtRyoyohiOshinKikanName() {
        return txtRyoyohiOshinKikanName;
    }

    @JsonProperty("txtRyoyohiOshinKikanName")
    public void setTxtRyoyohiOshinKikanName(TextBox txtRyoyohiOshinKikanName) {
        this.txtRyoyohiOshinKikanName=txtRyoyohiOshinKikanName;
    }

    @JsonProperty("lblRyoyohiTsuin")
    public Label getLblRyoyohiTsuin() {
        return lblRyoyohiTsuin;
    }

    @JsonProperty("lblRyoyohiTsuin")
    public void setLblRyoyohiTsuin(Label lblRyoyohiTsuin) {
        this.lblRyoyohiTsuin=lblRyoyohiTsuin;
    }

    @JsonProperty("txtRyoyohiTsuinNissu")
    public TextBoxNum getTxtRyoyohiTsuinNissu() {
        return txtRyoyohiTsuinNissu;
    }

    @JsonProperty("txtRyoyohiTsuinNissu")
    public void setTxtRyoyohiTsuinNissu(TextBoxNum txtRyoyohiTsuinNissu) {
        this.txtRyoyohiTsuinNissu=txtRyoyohiTsuinNissu;
    }

    @JsonProperty("txtRyoyohiTsuinKikanName")
    public TextBox getTxtRyoyohiTsuinKikanName() {
        return txtRyoyohiTsuinKikanName;
    }

    @JsonProperty("txtRyoyohiTsuinKikanName")
    public void setTxtRyoyohiTsuinKikanName(TextBox txtRyoyohiTsuinKikanName) {
        this.txtRyoyohiTsuinKikanName=txtRyoyohiTsuinKikanName;
    }

    @JsonProperty("txtRyoyohiTekiyo")
    public TextBox getTxtRyoyohiTekiyo() {
        return txtRyoyohiTekiyo;
    }

    @JsonProperty("txtRyoyohiTekiyo")
    public void setTxtRyoyohiTekiyo(TextBox txtRyoyohiTekiyo) {
        this.txtRyoyohiTekiyo=txtRyoyohiTekiyo;
    }

}
