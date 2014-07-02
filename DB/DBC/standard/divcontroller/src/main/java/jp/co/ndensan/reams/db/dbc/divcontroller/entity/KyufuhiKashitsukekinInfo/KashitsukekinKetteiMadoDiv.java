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
 * KashitsukekinKetteiMado のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKetteiMadoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBox txtShiharaiBasho;
    @JsonProperty("txtKaishiYMD")
    private TextBoxDate txtKaishiYMD;
    @JsonProperty("txtKaishiH")
    private TextBoxNum txtKaishiH;
    @JsonProperty("txtKaishiM")
    private TextBoxNum txtKaishiM;
    @JsonProperty("txtShuryoYMD")
    private TextBoxDate txtShuryoYMD;
    @JsonProperty("txtShuryoH")
    private TextBoxNum txtShuryoH;
    @JsonProperty("txtShuryoM")
    private TextBoxNum txtShuryoM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBox getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBox txtShiharaiBasho) {
        this.txtShiharaiBasho=txtShiharaiBasho;
    }

    @JsonProperty("txtKaishiYMD")
    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    @JsonProperty("txtKaishiYMD")
    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.txtKaishiYMD=txtKaishiYMD;
    }

    @JsonProperty("txtKaishiH")
    public TextBoxNum getTxtKaishiH() {
        return txtKaishiH;
    }

    @JsonProperty("txtKaishiH")
    public void setTxtKaishiH(TextBoxNum txtKaishiH) {
        this.txtKaishiH=txtKaishiH;
    }

    @JsonProperty("txtKaishiM")
    public TextBoxNum getTxtKaishiM() {
        return txtKaishiM;
    }

    @JsonProperty("txtKaishiM")
    public void setTxtKaishiM(TextBoxNum txtKaishiM) {
        this.txtKaishiM=txtKaishiM;
    }

    @JsonProperty("txtShuryoYMD")
    public TextBoxDate getTxtShuryoYMD() {
        return txtShuryoYMD;
    }

    @JsonProperty("txtShuryoYMD")
    public void setTxtShuryoYMD(TextBoxDate txtShuryoYMD) {
        this.txtShuryoYMD=txtShuryoYMD;
    }

    @JsonProperty("txtShuryoH")
    public TextBoxNum getTxtShuryoH() {
        return txtShuryoH;
    }

    @JsonProperty("txtShuryoH")
    public void setTxtShuryoH(TextBoxNum txtShuryoH) {
        this.txtShuryoH=txtShuryoH;
    }

    @JsonProperty("txtShuryoM")
    public TextBoxNum getTxtShuryoM() {
        return txtShuryoM;
    }

    @JsonProperty("txtShuryoM")
    public void setTxtShuryoM(TextBoxNum txtShuryoM) {
        this.txtShuryoM=txtShuryoM;
    }

}
