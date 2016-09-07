package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JokenFukugenHozon のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenFukugenHozonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnParamSave")
    private ButtonBatchParameterSave btnParamSave;
    @JsonProperty("btnParamRestore")
    private ButtonBatchParameterRestore btnParamRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnParamSave
     * @return btnParamSave
     */
    @JsonProperty("btnParamSave")
    public ButtonBatchParameterSave getBtnParamSave() {
        return btnParamSave;
    }

    /*
     * setbtnParamSave
     * @param btnParamSave btnParamSave
     */
    @JsonProperty("btnParamSave")
    public void setBtnParamSave(ButtonBatchParameterSave btnParamSave) {
        this.btnParamSave = btnParamSave;
    }

    /*
     * getbtnParamRestore
     * @return btnParamRestore
     */
    @JsonProperty("btnParamRestore")
    public ButtonBatchParameterRestore getBtnParamRestore() {
        return btnParamRestore;
    }

    /*
     * setbtnParamRestore
     * @param btnParamRestore btnParamRestore
     */
    @JsonProperty("btnParamRestore")
    public void setBtnParamRestore(ButtonBatchParameterRestore btnParamRestore) {
        this.btnParamRestore = btnParamRestore;
    }

    // </editor-fold>
}
