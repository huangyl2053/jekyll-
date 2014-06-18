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
 * CheckBoxesForNinteichosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class CheckBoxesForNinteichosaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteichosaIrai")
    private CheckBoxList chkNinteichosaIrai;
    @JsonProperty("chkNinteichosaJisshi")
    private CheckBoxList chkNinteichosaJisshi;
    @JsonProperty("chkNinteichosaTokki")
    private CheckBoxList chkNinteichosaTokki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkNinteichosaIrai")
    public CheckBoxList getChkNinteichosaIrai() {
        return chkNinteichosaIrai;
    }

    @JsonProperty("chkNinteichosaIrai")
    public void setChkNinteichosaIrai(CheckBoxList chkNinteichosaIrai) {
        this.chkNinteichosaIrai=chkNinteichosaIrai;
    }

    @JsonProperty("chkNinteichosaJisshi")
    public CheckBoxList getChkNinteichosaJisshi() {
        return chkNinteichosaJisshi;
    }

    @JsonProperty("chkNinteichosaJisshi")
    public void setChkNinteichosaJisshi(CheckBoxList chkNinteichosaJisshi) {
        this.chkNinteichosaJisshi=chkNinteichosaJisshi;
    }

    @JsonProperty("chkNinteichosaTokki")
    public CheckBoxList getChkNinteichosaTokki() {
        return chkNinteichosaTokki;
    }

    @JsonProperty("chkNinteichosaTokki")
    public void setChkNinteichosaTokki(CheckBoxList chkNinteichosaTokki) {
        this.chkNinteichosaTokki=chkNinteichosaTokki;
    }

}
