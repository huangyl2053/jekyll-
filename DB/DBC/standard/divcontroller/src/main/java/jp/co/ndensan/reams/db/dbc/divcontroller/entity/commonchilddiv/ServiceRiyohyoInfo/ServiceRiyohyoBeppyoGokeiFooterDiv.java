package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceRiyohyoBeppyoGokeiFooter のクラスファイル
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoBeppyoGokeiFooterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBeppyoGokeiKakutei")
    private Button btnBeppyoGokeiKakutei;
    @JsonProperty("btnCancelGokeiInput")
    private Button btnCancelGokeiInput;
    @JsonProperty("btnCalcGokei")
    private Button btnCalcGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBeppyoGokeiKakutei
     * @return btnBeppyoGokeiKakutei
     */
    @JsonProperty("btnBeppyoGokeiKakutei")
    public Button getBtnBeppyoGokeiKakutei() {
        return btnBeppyoGokeiKakutei;
    }

    /*
     * setbtnBeppyoGokeiKakutei
     * @param btnBeppyoGokeiKakutei btnBeppyoGokeiKakutei
     */
    @JsonProperty("btnBeppyoGokeiKakutei")
    public void setBtnBeppyoGokeiKakutei(Button btnBeppyoGokeiKakutei) {
        this.btnBeppyoGokeiKakutei = btnBeppyoGokeiKakutei;
    }

    /*
     * getbtnCancelGokeiInput
     * @return btnCancelGokeiInput
     */
    @JsonProperty("btnCancelGokeiInput")
    public Button getBtnCancelGokeiInput() {
        return btnCancelGokeiInput;
    }

    /*
     * setbtnCancelGokeiInput
     * @param btnCancelGokeiInput btnCancelGokeiInput
     */
    @JsonProperty("btnCancelGokeiInput")
    public void setBtnCancelGokeiInput(Button btnCancelGokeiInput) {
        this.btnCancelGokeiInput = btnCancelGokeiInput;
    }

    /*
     * getbtnCalcGokei
     * @return btnCalcGokei
     */
    @JsonProperty("btnCalcGokei")
    public Button getBtnCalcGokei() {
        return btnCalcGokei;
    }

    /*
     * setbtnCalcGokei
     * @param btnCalcGokei btnCalcGokei
     */
    @JsonProperty("btnCalcGokei")
    public void setBtnCalcGokei(Button btnCalcGokei) {
        this.btnCalcGokei = btnCalcGokei;
    }

    // </editor-fold>
}
