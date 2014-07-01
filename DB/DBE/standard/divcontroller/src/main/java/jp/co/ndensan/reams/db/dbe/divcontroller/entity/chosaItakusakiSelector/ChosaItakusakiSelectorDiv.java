package jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosaItakusakiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.SelectedContentsDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaItakusakiSelector のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiSelectorDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaItakusaki")
    private ChosaItakusakiDiv ChosaItakusaki;
    @JsonProperty("SelectedContents")
    private SelectedContentsDiv SelectedContents;
    @JsonProperty("btnSelectAndClose")
    private Button btnSelectAndClose;
    @JsonProperty("btnNonSelectReturn")
    private Button btnNonSelectReturn;
    @JsonProperty("chosaItakusakiCode")
    private RString chosaItakusakiCode;
    @JsonProperty("chosaItakusakiName")
    private RString chosaItakusakiName;
    @JsonProperty("chosainCode")
    private RString chosainCode;
    @JsonProperty("chosainName")
    private RString chosainName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ChosaItakusaki")
    public ChosaItakusakiDiv getChosaItakusaki() {
        return ChosaItakusaki;
    }

    @JsonProperty("ChosaItakusaki")
    public void setChosaItakusaki(ChosaItakusakiDiv ChosaItakusaki) {
        this.ChosaItakusaki=ChosaItakusaki;
    }

    @JsonProperty("SelectedContents")
    public SelectedContentsDiv getSelectedContents() {
        return SelectedContents;
    }

    @JsonProperty("SelectedContents")
    public void setSelectedContents(SelectedContentsDiv SelectedContents) {
        this.SelectedContents=SelectedContents;
    }

    @JsonProperty("btnSelectAndClose")
    public Button getBtnSelectAndClose() {
        return btnSelectAndClose;
    }

    @JsonProperty("btnSelectAndClose")
    public void setBtnSelectAndClose(Button btnSelectAndClose) {
        this.btnSelectAndClose=btnSelectAndClose;
    }

    @JsonProperty("btnNonSelectReturn")
    public Button getBtnNonSelectReturn() {
        return btnNonSelectReturn;
    }

    @JsonProperty("btnNonSelectReturn")
    public void setBtnNonSelectReturn(Button btnNonSelectReturn) {
        this.btnNonSelectReturn=btnNonSelectReturn;
    }

    @JsonProperty("chosaItakusakiCode")
    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    @JsonProperty("chosaItakusakiCode")
    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.chosaItakusakiCode=chosaItakusakiCode;
    }

    @JsonProperty("chosaItakusakiName")
    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    @JsonProperty("chosaItakusakiName")
    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.chosaItakusakiName=chosaItakusakiName;
    }

    @JsonProperty("chosainCode")
    public RString getChosainCode() {
        return chosainCode;
    }

    @JsonProperty("chosainCode")
    public void setChosainCode(RString chosainCode) {
        this.chosainCode=chosainCode;
    }

    @JsonProperty("chosainName")
    public RString getChosainName() {
        return chosainName;
    }

    @JsonProperty("chosainName")
    public void setChosainName(RString chosainName) {
        this.chosainName=chosainName;
    }

}
