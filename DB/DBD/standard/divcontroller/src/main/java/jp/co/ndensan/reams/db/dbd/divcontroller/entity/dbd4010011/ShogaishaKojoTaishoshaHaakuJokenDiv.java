package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4010011;
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
 * ShogaishaKojoTaishoshaHaakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaHaakuJokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("chkJogaiJoken")
    private CheckBoxList chkJogaiJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD=txtKijunYMD;
    }

    @JsonProperty("chkJogaiJoken")
    public CheckBoxList getChkJogaiJoken() {
        return chkJogaiJoken;
    }

    @JsonProperty("chkJogaiJoken")
    public void setChkJogaiJoken(CheckBoxList chkJogaiJoken) {
        this.chkJogaiJoken=chkJogaiJoken;
    }

}
