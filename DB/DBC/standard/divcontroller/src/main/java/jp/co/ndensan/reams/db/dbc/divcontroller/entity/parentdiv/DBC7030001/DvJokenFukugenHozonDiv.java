package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
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
 * DvJokenFukugenHozon のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvJokenFukugenHozonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShokanParamSave")
    private ButtonBatchParameterSave btnShokanParamSave;
    @JsonProperty("btnShokanParamRestore")
    private ButtonBatchParameterRestore btnShokanParamRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShokanParamSave
     * @return btnShokanParamSave
     */
    @JsonProperty("btnShokanParamSave")
    public ButtonBatchParameterSave getBtnShokanParamSave() {
        return btnShokanParamSave;
    }

    /*
     * setbtnShokanParamSave
     * @param btnShokanParamSave btnShokanParamSave
     */
    @JsonProperty("btnShokanParamSave")
    public void setBtnShokanParamSave(ButtonBatchParameterSave btnShokanParamSave) {
        this.btnShokanParamSave = btnShokanParamSave;
    }

    /*
     * getbtnShokanParamRestore
     * @return btnShokanParamRestore
     */
    @JsonProperty("btnShokanParamRestore")
    public ButtonBatchParameterRestore getBtnShokanParamRestore() {
        return btnShokanParamRestore;
    }

    /*
     * setbtnShokanParamRestore
     * @param btnShokanParamRestore btnShokanParamRestore
     */
    @JsonProperty("btnShokanParamRestore")
    public void setBtnShokanParamRestore(ButtonBatchParameterRestore btnShokanParamRestore) {
        this.btnShokanParamRestore = btnShokanParamRestore;
    }

    // </editor-fold>
}
