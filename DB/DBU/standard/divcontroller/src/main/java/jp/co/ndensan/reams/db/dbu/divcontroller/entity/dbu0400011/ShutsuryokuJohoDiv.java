package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011;
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
 * ShutsuryokuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("chkTest")
    private CheckBoxList chkTest;
    @JsonProperty("lblTestHosoku")
    private Label lblTestHosoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("chkTest")
    public CheckBoxList getChkTest() {
        return chkTest;
    }

    @JsonProperty("chkTest")
    public void setChkTest(CheckBoxList chkTest) {
        this.chkTest=chkTest;
    }

    @JsonProperty("lblTestHosoku")
    public Label getLblTestHosoku() {
        return lblTestHosoku;
    }

    @JsonProperty("lblTestHosoku")
    public void setLblTestHosoku(Label lblTestHosoku) {
        this.lblTestHosoku=lblTestHosoku;
    }

}
