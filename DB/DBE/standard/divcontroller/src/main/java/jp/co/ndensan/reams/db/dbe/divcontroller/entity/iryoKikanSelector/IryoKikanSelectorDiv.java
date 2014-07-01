package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.IryoKikanDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector.SelectedContentsDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IryoKikanSelector のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoKikanSelectorDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IryoKikan")
    private IryoKikanDiv IryoKikan;
    @JsonProperty("SelectedContents")
    private SelectedContentsDiv SelectedContents;
    @JsonProperty("btnSelectAndClose")
    private Button btnSelectAndClose;
    @JsonProperty("btnNonSelectReturn")
    private Button btnNonSelectReturn;
    @JsonProperty("iryoKikanCode")
    private RString iryoKikanCode;
    @JsonProperty("iryoKikanName")
    private RString iryoKikanName;
    @JsonProperty("ishiCode")
    private RString ishiCode;
    @JsonProperty("ishiName")
    private RString ishiName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("IryoKikan")
    public IryoKikanDiv getIryoKikan() {
        return IryoKikan;
    }

    @JsonProperty("IryoKikan")
    public void setIryoKikan(IryoKikanDiv IryoKikan) {
        this.IryoKikan=IryoKikan;
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

    @JsonProperty("iryoKikanCode")
    public RString getIryoKikanCode() {
        return iryoKikanCode;
    }

    @JsonProperty("iryoKikanCode")
    public void setIryoKikanCode(RString iryoKikanCode) {
        this.iryoKikanCode=iryoKikanCode;
    }

    @JsonProperty("iryoKikanName")
    public RString getIryoKikanName() {
        return iryoKikanName;
    }

    @JsonProperty("iryoKikanName")
    public void setIryoKikanName(RString iryoKikanName) {
        this.iryoKikanName=iryoKikanName;
    }

    @JsonProperty("ishiCode")
    public RString getIshiCode() {
        return ishiCode;
    }

    @JsonProperty("ishiCode")
    public void setIshiCode(RString ishiCode) {
        this.ishiCode=ishiCode;
    }

    @JsonProperty("ishiName")
    public RString getIshiName() {
        return ishiName;
    }

    @JsonProperty("ishiName")
    public void setIshiName(RString ishiName) {
        this.ishiName=ishiName;
    }

}
