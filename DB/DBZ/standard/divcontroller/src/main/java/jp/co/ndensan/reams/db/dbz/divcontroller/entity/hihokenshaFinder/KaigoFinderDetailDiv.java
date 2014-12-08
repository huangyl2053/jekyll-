package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder;
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
 * KaigoFinderDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoFinderDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHihokenshaJotai")
    private Label lblHihokenshaJotai;
    @JsonProperty("chkHihokenshaDaicho")
    private CheckBoxList chkHihokenshaDaicho;
    @JsonProperty("chkJukyushaDaicho")
    private CheckBoxList chkJukyushaDaicho;
    @JsonProperty("chkJushochiTokureisha")
    private CheckBoxList chkJushochiTokureisha;
    @JsonProperty("radMinashiNigo")
    private RadioButton radMinashiNigo;
    @JsonProperty("chkMinashiNigo")
    private CheckBoxList chkMinashiNigo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHihokenshaJotai")
    public Label getLblHihokenshaJotai() {
        return lblHihokenshaJotai;
    }

    @JsonProperty("lblHihokenshaJotai")
    public void setLblHihokenshaJotai(Label lblHihokenshaJotai) {
        this.lblHihokenshaJotai=lblHihokenshaJotai;
    }

    @JsonProperty("chkHihokenshaDaicho")
    public CheckBoxList getChkHihokenshaDaicho() {
        return chkHihokenshaDaicho;
    }

    @JsonProperty("chkHihokenshaDaicho")
    public void setChkHihokenshaDaicho(CheckBoxList chkHihokenshaDaicho) {
        this.chkHihokenshaDaicho=chkHihokenshaDaicho;
    }

    @JsonProperty("chkJukyushaDaicho")
    public CheckBoxList getChkJukyushaDaicho() {
        return chkJukyushaDaicho;
    }

    @JsonProperty("chkJukyushaDaicho")
    public void setChkJukyushaDaicho(CheckBoxList chkJukyushaDaicho) {
        this.chkJukyushaDaicho=chkJukyushaDaicho;
    }

    @JsonProperty("chkJushochiTokureisha")
    public CheckBoxList getChkJushochiTokureisha() {
        return chkJushochiTokureisha;
    }

    @JsonProperty("chkJushochiTokureisha")
    public void setChkJushochiTokureisha(CheckBoxList chkJushochiTokureisha) {
        this.chkJushochiTokureisha=chkJushochiTokureisha;
    }

    @JsonProperty("radMinashiNigo")
    public RadioButton getRadMinashiNigo() {
        return radMinashiNigo;
    }

    @JsonProperty("radMinashiNigo")
    public void setRadMinashiNigo(RadioButton radMinashiNigo) {
        this.radMinashiNigo=radMinashiNigo;
    }

    @JsonProperty("chkMinashiNigo")
    public CheckBoxList getChkMinashiNigo() {
        return chkMinashiNigo;
    }

    @JsonProperty("chkMinashiNigo")
    public void setChkMinashiNigo(CheckBoxList chkMinashiNigo) {
        this.chkMinashiNigo=chkMinashiNigo;
    }

}
