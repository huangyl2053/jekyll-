package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KyodoJukyushaIdoRenrakuhyoTeisei のクラスファイル
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoTeiseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtTeiseiYMD")
    private TextBoxDate txtTeiseiYMD;
    @JsonProperty("radTeiseiKubunCode")
    private RadioButton radTeiseiKubunCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtTeiseiYMD
     * @return txtTeiseiYMD
     */
    @JsonProperty("txtTeiseiYMD")
    public TextBoxDate getTxtTeiseiYMD() {
        return txtTeiseiYMD;
    }

    /*
     * settxtTeiseiYMD
     * @param txtTeiseiYMD txtTeiseiYMD
     */
    @JsonProperty("txtTeiseiYMD")
    public void setTxtTeiseiYMD(TextBoxDate txtTeiseiYMD) {
        this.txtTeiseiYMD = txtTeiseiYMD;
    }

    /*
     * getradTeiseiKubunCode
     * @return radTeiseiKubunCode
     */
    @JsonProperty("radTeiseiKubunCode")
    public RadioButton getRadTeiseiKubunCode() {
        return radTeiseiKubunCode;
    }

    /*
     * setradTeiseiKubunCode
     * @param radTeiseiKubunCode radTeiseiKubunCode
     */
    @JsonProperty("radTeiseiKubunCode")
    public void setRadTeiseiKubunCode(RadioButton radTeiseiKubunCode) {
        this.radTeiseiKubunCode = radTeiseiKubunCode;
    }

    // </editor-fold>
}
