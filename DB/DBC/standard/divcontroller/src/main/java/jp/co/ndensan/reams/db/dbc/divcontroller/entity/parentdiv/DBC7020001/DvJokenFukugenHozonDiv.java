package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvJokenFukugenHozon のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvJokenFukugenHozonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKogakuParamSave")
    private ButtonBatchParameterSave btnKogakuParamSave;
    @JsonProperty("btnKogakuParamRestore")
    private ButtonBatchParameterRestore btnKogakuParamRestore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKogakuParamSave
     * @return btnKogakuParamSave
     */
    @JsonProperty("btnKogakuParamSave")
    public ButtonBatchParameterSave getBtnKogakuParamSave() {
        return btnKogakuParamSave;
    }

    /*
     * setbtnKogakuParamSave
     * @param btnKogakuParamSave btnKogakuParamSave
     */
    @JsonProperty("btnKogakuParamSave")
    public void setBtnKogakuParamSave(ButtonBatchParameterSave btnKogakuParamSave) {
        this.btnKogakuParamSave = btnKogakuParamSave;
    }

    /*
     * getbtnKogakuParamRestore
     * @return btnKogakuParamRestore
     */
    @JsonProperty("btnKogakuParamRestore")
    public ButtonBatchParameterRestore getBtnKogakuParamRestore() {
        return btnKogakuParamRestore;
    }

    /*
     * setbtnKogakuParamRestore
     * @param btnKogakuParamRestore btnKogakuParamRestore
     */
    @JsonProperty("btnKogakuParamRestore")
    public void setBtnKogakuParamRestore(ButtonBatchParameterRestore btnKogakuParamRestore) {
        this.btnKogakuParamRestore = btnKogakuParamRestore;
    }

    // </editor-fold>
}
