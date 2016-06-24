package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * HihokenshaShitei のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class HihokenshaShiteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHihokenshaShitei")
    private RadioButton radHihokenshaShitei;
    @JsonProperty("HihokenshaKensakuJoken")
    private HihokenshaKensakuJokenDiv HihokenshaKensakuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHihokenshaShitei
     * @return radHihokenshaShitei
     */
    @JsonProperty("radHihokenshaShitei")
    public RadioButton getRadHihokenshaShitei() {
        return radHihokenshaShitei;
    }

    /*
     * setradHihokenshaShitei
     * @param radHihokenshaShitei radHihokenshaShitei
     */
    @JsonProperty("radHihokenshaShitei")
    public void setRadHihokenshaShitei(RadioButton radHihokenshaShitei) {
        this.radHihokenshaShitei = radHihokenshaShitei;
    }

    /*
     * getHihokenshaKensakuJoken
     * @return HihokenshaKensakuJoken
     */
    @JsonProperty("HihokenshaKensakuJoken")
    public HihokenshaKensakuJokenDiv getHihokenshaKensakuJoken() {
        return HihokenshaKensakuJoken;
    }

    /*
     * setHihokenshaKensakuJoken
     * @param HihokenshaKensakuJoken HihokenshaKensakuJoken
     */
    @JsonProperty("HihokenshaKensakuJoken")
    public void setHihokenshaKensakuJoken(HihokenshaKensakuJokenDiv HihokenshaKensakuJoken) {
        this.HihokenshaKensakuJoken = HihokenshaKensakuJoken;
    }

    // </editor-fold>
}
