package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.RohukuNenkinInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.dgRohukuNenkinRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * RohukuNenkin のクラスファイル 
 * 
 * @author 自動生成
 */
public class RohukuNenkinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddRofukuNenkin")
    private Button btnAddRofukuNenkin;
    @JsonProperty("dgRohukuNenkinRireki")
    private DataGrid<dgRohukuNenkinRireki_Row> dgRohukuNenkinRireki;
    @JsonProperty("RohukuNenkinInput")
    private RohukuNenkinInputDiv RohukuNenkinInput;
    @JsonProperty("btnUpdateRofukuNenkin")
    private Button btnUpdateRofukuNenkin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddRofukuNenkin")
    public Button getBtnAddRofukuNenkin() {
        return btnAddRofukuNenkin;
    }

    @JsonProperty("btnAddRofukuNenkin")
    public void setBtnAddRofukuNenkin(Button btnAddRofukuNenkin) {
        this.btnAddRofukuNenkin=btnAddRofukuNenkin;
    }

    @JsonProperty("dgRohukuNenkinRireki")
    public DataGrid<dgRohukuNenkinRireki_Row> getDgRohukuNenkinRireki() {
        return dgRohukuNenkinRireki;
    }

    @JsonProperty("dgRohukuNenkinRireki")
    public void setDgRohukuNenkinRireki(DataGrid<dgRohukuNenkinRireki_Row> dgRohukuNenkinRireki) {
        this.dgRohukuNenkinRireki=dgRohukuNenkinRireki;
    }

    @JsonProperty("RohukuNenkinInput")
    public RohukuNenkinInputDiv getRohukuNenkinInput() {
        return RohukuNenkinInput;
    }

    @JsonProperty("RohukuNenkinInput")
    public void setRohukuNenkinInput(RohukuNenkinInputDiv RohukuNenkinInput) {
        this.RohukuNenkinInput=RohukuNenkinInput;
    }

    @JsonProperty("btnUpdateRofukuNenkin")
    public Button getBtnUpdateRofukuNenkin() {
        return btnUpdateRofukuNenkin;
    }

    @JsonProperty("btnUpdateRofukuNenkin")
    public void setBtnUpdateRofukuNenkin(Button btnUpdateRofukuNenkin) {
        this.btnUpdateRofukuNenkin=btnUpdateRofukuNenkin;
    }

}
