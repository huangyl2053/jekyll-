package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.EditShisetsuRerekiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShisetsuRereki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NyuinNyusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyuinNyushoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToAddShisetsu")
    private Button btnToAddShisetsu;
    @JsonProperty("btnToAddShisetsuWithCopying")
    private Button btnToAddShisetsuWithCopying;
    @JsonProperty("dgShisetsuRereki")
    private DataGrid<dgShisetsuRereki_Row> dgShisetsuRereki;
    @JsonProperty("EditShisetsuRereki")
    private EditShisetsuRerekiDiv EditShisetsuRereki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToAddShisetsu")
    public Button getBtnToAddShisetsu() {
        return btnToAddShisetsu;
    }

    @JsonProperty("btnToAddShisetsu")
    public void setBtnToAddShisetsu(Button btnToAddShisetsu) {
        this.btnToAddShisetsu=btnToAddShisetsu;
    }

    @JsonProperty("btnToAddShisetsuWithCopying")
    public Button getBtnToAddShisetsuWithCopying() {
        return btnToAddShisetsuWithCopying;
    }

    @JsonProperty("btnToAddShisetsuWithCopying")
    public void setBtnToAddShisetsuWithCopying(Button btnToAddShisetsuWithCopying) {
        this.btnToAddShisetsuWithCopying=btnToAddShisetsuWithCopying;
    }

    @JsonProperty("dgShisetsuRereki")
    public DataGrid<dgShisetsuRereki_Row> getDgShisetsuRereki() {
        return dgShisetsuRereki;
    }

    @JsonProperty("dgShisetsuRereki")
    public void setDgShisetsuRereki(DataGrid<dgShisetsuRereki_Row> dgShisetsuRereki) {
        this.dgShisetsuRereki=dgShisetsuRereki;
    }

    @JsonProperty("EditShisetsuRereki")
    public EditShisetsuRerekiDiv getEditShisetsuRereki() {
        return EditShisetsuRereki;
    }

    @JsonProperty("EditShisetsuRereki")
    public void setEditShisetsuRereki(EditShisetsuRerekiDiv EditShisetsuRereki) {
        this.EditShisetsuRereki=EditShisetsuRereki;
    }

}
