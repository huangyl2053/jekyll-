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
 * JokenFukugenHozonlKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenFukugenHozonlKihonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKihonBatchParameterSave")
    private ButtonBatchParameterSave btnKihonBatchParameterSave;
    @JsonProperty("btnKihonBatchParameterRestore")
    private ButtonBatchParameterRestore btnKihonBatchParameterRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKihonBatchParameterSave
     * @return btnKihonBatchParameterSave
     */
    @JsonProperty("btnKihonBatchParameterSave")
    public ButtonBatchParameterSave getBtnKihonBatchParameterSave() {
        return btnKihonBatchParameterSave;
    }

    /*
     * setbtnKihonBatchParameterSave
     * @param btnKihonBatchParameterSave btnKihonBatchParameterSave
     */
    @JsonProperty("btnKihonBatchParameterSave")
    public void setBtnKihonBatchParameterSave(ButtonBatchParameterSave btnKihonBatchParameterSave) {
        this.btnKihonBatchParameterSave = btnKihonBatchParameterSave;
    }

    /*
     * getbtnKihonBatchParameterRestore
     * @return btnKihonBatchParameterRestore
     */
    @JsonProperty("btnKihonBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnKihonBatchParameterRestore() {
        return btnKihonBatchParameterRestore;
    }

    /*
     * setbtnKihonBatchParameterRestore
     * @param btnKihonBatchParameterRestore btnKihonBatchParameterRestore
     */
    @JsonProperty("btnKihonBatchParameterRestore")
    public void setBtnKihonBatchParameterRestore(ButtonBatchParameterRestore btnKihonBatchParameterRestore) {
        this.btnKihonBatchParameterRestore = btnKihonBatchParameterRestore;
    }

    // </editor-fold>
}
