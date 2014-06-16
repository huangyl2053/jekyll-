package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
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
 * CheckBoxesForShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class CheckBoxesForShujiiIkenshoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShujiiIkenshoIrai")
    private CheckBoxList chkShujiiIkenshoIrai;
    @JsonProperty("chkShujiiIkenshoJuryo")
    private CheckBoxList chkShujiiIkenshoJuryo;
    @JsonProperty("lblPadding1")
    private Label lblPadding1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkShujiiIkenshoIrai")
    public CheckBoxList getChkShujiiIkenshoIrai() {
        return chkShujiiIkenshoIrai;
    }

    @JsonProperty("chkShujiiIkenshoIrai")
    public void setChkShujiiIkenshoIrai(CheckBoxList chkShujiiIkenshoIrai) {
        this.chkShujiiIkenshoIrai=chkShujiiIkenshoIrai;
    }

    @JsonProperty("chkShujiiIkenshoJuryo")
    public CheckBoxList getChkShujiiIkenshoJuryo() {
        return chkShujiiIkenshoJuryo;
    }

    @JsonProperty("chkShujiiIkenshoJuryo")
    public void setChkShujiiIkenshoJuryo(CheckBoxList chkShujiiIkenshoJuryo) {
        this.chkShujiiIkenshoJuryo=chkShujiiIkenshoJuryo;
    }

    @JsonProperty("lblPadding1")
    public Label getLblPadding1() {
        return lblPadding1;
    }

    @JsonProperty("lblPadding1")
    public void setLblPadding1(Label lblPadding1) {
        this.lblPadding1=lblPadding1;
    }

}
