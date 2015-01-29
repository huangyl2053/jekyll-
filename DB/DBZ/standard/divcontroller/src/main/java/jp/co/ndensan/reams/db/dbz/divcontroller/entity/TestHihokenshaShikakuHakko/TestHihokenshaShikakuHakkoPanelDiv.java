package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestHihokenshaShikakuHakko;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IHihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TestHihokenshaShikakuHakkoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class TestHihokenshaShikakuHakkoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtHihokenshaCode")
    private TextBoxCode txtHihokenshaCode;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("radCurrent")
    private RadioButton radCurrent;
    @JsonProperty("btnLoad")
    private Button btnLoad;
    @JsonProperty("line0")
    private HorizontalLine line0;
    @JsonProperty("ccdHihokenshaShikakuHakko")
    private HihokenshaShikakuHakkoDiv ccdHihokenshaShikakuHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaCode")
    public TextBoxCode getTxtHihokenshaCode() {
        return txtHihokenshaCode;
    }

    @JsonProperty("txtHihokenshaCode")
    public void setTxtHihokenshaCode(TextBoxCode txtHihokenshaCode) {
        this.txtHihokenshaCode = txtHihokenshaCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    @JsonProperty("radCurrent")
    public RadioButton getRadCurrent() {
        return radCurrent;
    }

    @JsonProperty("radCurrent")
    public void setRadCurrent(RadioButton radCurrent) {
        this.radCurrent = radCurrent;
    }

    @JsonProperty("btnLoad")
    public Button getBtnLoad() {
        return btnLoad;
    }

    @JsonProperty("btnLoad")
    public void setBtnLoad(Button btnLoad) {
        this.btnLoad = btnLoad;
    }

    @JsonProperty("line0")
    public HorizontalLine getLine0() {
        return line0;
    }

    @JsonProperty("line0")
    public void setLine0(HorizontalLine line0) {
        this.line0 = line0;
    }

    @JsonProperty("ccdHihokenshaShikakuHakko")
    public HihokenshaShikakuHakkoDiv getCcdHihokenshaShikakuHakko() {
        return ccdHihokenshaShikakuHakko;
    }

}
