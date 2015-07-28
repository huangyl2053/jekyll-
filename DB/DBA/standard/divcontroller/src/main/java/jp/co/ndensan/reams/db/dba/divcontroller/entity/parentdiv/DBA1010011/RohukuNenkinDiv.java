package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RohukuNenkin のクラスファイル 
 * 
 * @author 自動生成
 */
public class RohukuNenkinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("RofukuNenkinInput")
    private RofukuNenkinInputDiv RofukuNenkinInput;
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

    @JsonProperty("RofukuNenkinInput")
    public RofukuNenkinInputDiv getRofukuNenkinInput() {
        return RofukuNenkinInput;
    }

    @JsonProperty("RofukuNenkinInput")
    public void setRofukuNenkinInput(RofukuNenkinInputDiv RofukuNenkinInput) {
        this.RofukuNenkinInput=RofukuNenkinInput;
    }

    @JsonProperty("btnUpdateRofukuNenkin")
    public Button getBtnUpdateRofukuNenkin() {
        return btnUpdateRofukuNenkin;
    }

    @JsonProperty("btnUpdateRofukuNenkin")
    public void setBtnUpdateRofukuNenkin(Button btnUpdateRofukuNenkin) {
        this.btnUpdateRofukuNenkin=btnUpdateRofukuNenkin;
    }

    // </editor-fold>
}
