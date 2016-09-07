package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JokenFukugenHozonl のクラスファイル
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class JokenFukugenHozonlDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBatchParameterSave")
    private ButtonBatchParameterSave btnBatchParameterSave;
    @JsonProperty("btnBatchParameterRestore")
    private ButtonBatchParameterRestore btnBatchParameterRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBatchParameterSave
     * @return btnBatchParameterSave
     */
    @JsonProperty("btnBatchParameterSave")
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return btnBatchParameterSave;
    }

    /*
     * setbtnBatchParameterSave
     * @param btnBatchParameterSave btnBatchParameterSave
     */
    @JsonProperty("btnBatchParameterSave")
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.btnBatchParameterSave = btnBatchParameterSave;
    }

    /*
     * getbtnBatchParameterRestore
     * @return btnBatchParameterRestore
     */
    @JsonProperty("btnBatchParameterRestore")
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return btnBatchParameterRestore;
    }

    /*
     * setbtnBatchParameterRestore
     * @param btnBatchParameterRestore btnBatchParameterRestore
     */
    @JsonProperty("btnBatchParameterRestore")
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.btnBatchParameterRestore = btnBatchParameterRestore;
    }

    // </editor-fold>
}
