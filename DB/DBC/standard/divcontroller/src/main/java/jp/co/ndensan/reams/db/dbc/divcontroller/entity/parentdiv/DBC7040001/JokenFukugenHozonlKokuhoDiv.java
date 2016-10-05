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
 * JokenFukugenHozonlKokuho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenFukugenHozonlKokuhoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKokuhoBatchParameterSave")
    private ButtonBatchParameterSave btnKokuhoBatchParameterSave;
    @JsonProperty("btnKokuhoBatchParameterRestore")
    private ButtonBatchParameterRestore btnKokuhoBatchParameterRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKokuhoBatchParameterSave
     * @return btnKokuhoBatchParameterSave
     */
    @JsonProperty("btnKokuhoBatchParameterSave")
    public ButtonBatchParameterSave getBtnKokuhoBatchParameterSave() {
        return btnKokuhoBatchParameterSave;
    }

    /*
     * setbtnKokuhoBatchParameterSave
     * @param btnKokuhoBatchParameterSave btnKokuhoBatchParameterSave
     */
    @JsonProperty("btnKokuhoBatchParameterSave")
    public void setBtnKokuhoBatchParameterSave(ButtonBatchParameterSave btnKokuhoBatchParameterSave) {
        this.btnKokuhoBatchParameterSave = btnKokuhoBatchParameterSave;
    }

    /*
     * getbtnKokuhoBatchParameterRestore
     * @return btnKokuhoBatchParameterRestore
     */
    @JsonProperty("btnKokuhoBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnKokuhoBatchParameterRestore() {
        return btnKokuhoBatchParameterRestore;
    }

    /*
     * setbtnKokuhoBatchParameterRestore
     * @param btnKokuhoBatchParameterRestore btnKokuhoBatchParameterRestore
     */
    @JsonProperty("btnKokuhoBatchParameterRestore")
    public void setBtnKokuhoBatchParameterRestore(ButtonBatchParameterRestore btnKokuhoBatchParameterRestore) {
        this.btnKokuhoBatchParameterRestore = btnKokuhoBatchParameterRestore;
    }

    // </editor-fold>
}
