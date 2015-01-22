package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA7010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA7010011.dgAddressSel_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * AtenaAddSel のクラスファイル 
 * 
 * @author 自動生成
 */
public class AtenaAddSelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKautei")
    private Button btnKautei;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("dgAddressSel")
    private DataGrid<dgAddressSel_Row> dgAddressSel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnKautei")
    public Button getBtnKautei() {
        return btnKautei;
    }

    @JsonProperty("btnKautei")
    public void setBtnKautei(Button btnKautei) {
        this.btnKautei=btnKautei;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    @JsonProperty("dgAddressSel")
    public DataGrid<dgAddressSel_Row> getDgAddressSel() {
        return dgAddressSel;
    }

    @JsonProperty("dgAddressSel")
    public void setDgAddressSel(DataGrid<dgAddressSel_Row> dgAddressSel) {
        this.dgAddressSel=dgAddressSel;
    }

}
