package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("radChushutsuJoken")
    private RadioButton radChushutsuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * getradChushutsuJoken
     * @return radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public RadioButton getRadChushutsuJoken() {
        return radChushutsuJoken;
    }

    /*
     * setradChushutsuJoken
     * @param radChushutsuJoken radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.radChushutsuJoken = radChushutsuJoken;
    }

    // </editor-fold>
}
