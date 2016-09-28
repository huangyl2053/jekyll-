package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JokenFukugenHozonlShokan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenFukugenHozonlShokanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShokanBatchParameterSave")
    private ButtonBatchParameterSave btnShokanBatchParameterSave;
    @JsonProperty("btnShokanBatchParameterRestore")
    private ButtonBatchParameterRestore btnShokanBatchParameterRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShokanBatchParameterSave
     * @return btnShokanBatchParameterSave
     */
    @JsonProperty("btnShokanBatchParameterSave")
    public ButtonBatchParameterSave getBtnShokanBatchParameterSave() {
        return btnShokanBatchParameterSave;
    }

    /*
     * setbtnShokanBatchParameterSave
     * @param btnShokanBatchParameterSave btnShokanBatchParameterSave
     */
    @JsonProperty("btnShokanBatchParameterSave")
    public void setBtnShokanBatchParameterSave(ButtonBatchParameterSave btnShokanBatchParameterSave) {
        this.btnShokanBatchParameterSave = btnShokanBatchParameterSave;
    }

    /*
     * getbtnShokanBatchParameterRestore
     * @return btnShokanBatchParameterRestore
     */
    @JsonProperty("btnShokanBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnShokanBatchParameterRestore() {
        return btnShokanBatchParameterRestore;
    }

    /*
     * setbtnShokanBatchParameterRestore
     * @param btnShokanBatchParameterRestore btnShokanBatchParameterRestore
     */
    @JsonProperty("btnShokanBatchParameterRestore")
    public void setBtnShokanBatchParameterRestore(ButtonBatchParameterRestore btnShokanBatchParameterRestore) {
        this.btnShokanBatchParameterRestore = btnShokanBatchParameterRestore;
    }

    // </editor-fold>
}
