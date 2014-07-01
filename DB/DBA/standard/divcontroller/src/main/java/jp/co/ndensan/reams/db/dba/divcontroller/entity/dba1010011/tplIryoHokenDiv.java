package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.IryoHokenInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplIryoHoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIryoHokenDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddIryoHoken")
    private Button btnAddIryoHoken;
    @JsonProperty("IryoHokenRireki")
    private IryoHokenRirekiDiv IryoHokenRireki;
    @JsonProperty("IryoHokenInput")
    private IryoHokenInputDiv IryoHokenInput;
    @JsonProperty("btnUpdateIryoHoken")
    private Button btnUpdateIryoHoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddIryoHoken")
    public Button getBtnAddIryoHoken() {
        return btnAddIryoHoken;
    }

    @JsonProperty("btnAddIryoHoken")
    public void setBtnAddIryoHoken(Button btnAddIryoHoken) {
        this.btnAddIryoHoken=btnAddIryoHoken;
    }

    @JsonProperty("IryoHokenRireki")
    public IryoHokenRirekiDiv getIryoHokenRireki() {
        return IryoHokenRireki;
    }

    @JsonProperty("IryoHokenRireki")
    public void setIryoHokenRireki(IryoHokenRirekiDiv IryoHokenRireki) {
        this.IryoHokenRireki=IryoHokenRireki;
    }

    @JsonProperty("IryoHokenInput")
    public IryoHokenInputDiv getIryoHokenInput() {
        return IryoHokenInput;
    }

    @JsonProperty("IryoHokenInput")
    public void setIryoHokenInput(IryoHokenInputDiv IryoHokenInput) {
        this.IryoHokenInput=IryoHokenInput;
    }

    @JsonProperty("btnUpdateIryoHoken")
    public Button getBtnUpdateIryoHoken() {
        return btnUpdateIryoHoken;
    }

    @JsonProperty("btnUpdateIryoHoken")
    public void setBtnUpdateIryoHoken(Button btnUpdateIryoHoken) {
        this.btnUpdateIryoHoken=btnUpdateIryoHoken;
    }

}
