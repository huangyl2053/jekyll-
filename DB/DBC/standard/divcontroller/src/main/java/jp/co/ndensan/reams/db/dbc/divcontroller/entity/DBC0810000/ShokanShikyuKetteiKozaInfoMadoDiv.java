package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
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
 * ShokanShikyuKetteiKozaInfoMado のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiKozaInfoMadoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiShiharaiBasho")
    private TextBox txtShinseiShiharaiBasho;
    @JsonProperty("txtShinseiKaishiYMD")
    private TextBoxDate txtShinseiKaishiYMD;
    @JsonProperty("txtShinseiKaishiH")
    private TextBoxNum txtShinseiKaishiH;
    @JsonProperty("txtShinseiKaishiM")
    private TextBoxNum txtShinseiKaishiM;
    @JsonProperty("txtShinseiShuryoYMD")
    private TextBoxDate txtShinseiShuryoYMD;
    @JsonProperty("txtShinseiShuryoH")
    private TextBoxNum txtShinseiShuryoH;
    @JsonProperty("txtShinseiShuryoM")
    private TextBoxNum txtShinseiShuryoM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiShiharaiBasho")
    public TextBox getTxtShinseiShiharaiBasho() {
        return txtShinseiShiharaiBasho;
    }

    @JsonProperty("txtShinseiShiharaiBasho")
    public void setTxtShinseiShiharaiBasho(TextBox txtShinseiShiharaiBasho) {
        this.txtShinseiShiharaiBasho=txtShinseiShiharaiBasho;
    }

    @JsonProperty("txtShinseiKaishiYMD")
    public TextBoxDate getTxtShinseiKaishiYMD() {
        return txtShinseiKaishiYMD;
    }

    @JsonProperty("txtShinseiKaishiYMD")
    public void setTxtShinseiKaishiYMD(TextBoxDate txtShinseiKaishiYMD) {
        this.txtShinseiKaishiYMD=txtShinseiKaishiYMD;
    }

    @JsonProperty("txtShinseiKaishiH")
    public TextBoxNum getTxtShinseiKaishiH() {
        return txtShinseiKaishiH;
    }

    @JsonProperty("txtShinseiKaishiH")
    public void setTxtShinseiKaishiH(TextBoxNum txtShinseiKaishiH) {
        this.txtShinseiKaishiH=txtShinseiKaishiH;
    }

    @JsonProperty("txtShinseiKaishiM")
    public TextBoxNum getTxtShinseiKaishiM() {
        return txtShinseiKaishiM;
    }

    @JsonProperty("txtShinseiKaishiM")
    public void setTxtShinseiKaishiM(TextBoxNum txtShinseiKaishiM) {
        this.txtShinseiKaishiM=txtShinseiKaishiM;
    }

    @JsonProperty("txtShinseiShuryoYMD")
    public TextBoxDate getTxtShinseiShuryoYMD() {
        return txtShinseiShuryoYMD;
    }

    @JsonProperty("txtShinseiShuryoYMD")
    public void setTxtShinseiShuryoYMD(TextBoxDate txtShinseiShuryoYMD) {
        this.txtShinseiShuryoYMD=txtShinseiShuryoYMD;
    }

    @JsonProperty("txtShinseiShuryoH")
    public TextBoxNum getTxtShinseiShuryoH() {
        return txtShinseiShuryoH;
    }

    @JsonProperty("txtShinseiShuryoH")
    public void setTxtShinseiShuryoH(TextBoxNum txtShinseiShuryoH) {
        this.txtShinseiShuryoH=txtShinseiShuryoH;
    }

    @JsonProperty("txtShinseiShuryoM")
    public TextBoxNum getTxtShinseiShuryoM() {
        return txtShinseiShuryoM;
    }

    @JsonProperty("txtShinseiShuryoM")
    public void setTxtShinseiShuryoM(TextBoxNum txtShinseiShuryoM) {
        this.txtShinseiShuryoM=txtShinseiShuryoM;
    }

}
