package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * TyuusyutuJyoukenn のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class TyuusyutuJyoukennDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSiharaihouhou")
    private RadioButton radSiharaihouhou;
    @JsonProperty("txtItakusya")
    private TextBox txtItakusya;
    @JsonProperty("txtItakusyaCode")
    private TextBoxCode txtItakusyaCode;
    @JsonProperty("txtTorihikiKinyukikan")
    private TextBox txtTorihikiKinyukikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSiharaihouhou
     * @return radSiharaihouhou
     */
    @JsonProperty("radSiharaihouhou")
    public RadioButton getRadSiharaihouhou() {
        return radSiharaihouhou;
    }

    /*
     * setradSiharaihouhou
     * @param radSiharaihouhou radSiharaihouhou
     */
    @JsonProperty("radSiharaihouhou")
    public void setRadSiharaihouhou(RadioButton radSiharaihouhou) {
        this.radSiharaihouhou = radSiharaihouhou;
    }

    /*
     * gettxtItakusya
     * @return txtItakusya
     */
    @JsonProperty("txtItakusya")
    public TextBox getTxtItakusya() {
        return txtItakusya;
    }

    /*
     * settxtItakusya
     * @param txtItakusya txtItakusya
     */
    @JsonProperty("txtItakusya")
    public void setTxtItakusya(TextBox txtItakusya) {
        this.txtItakusya = txtItakusya;
    }

    /*
     * gettxtItakusyaCode
     * @return txtItakusyaCode
     */
    @JsonProperty("txtItakusyaCode")
    public TextBoxCode getTxtItakusyaCode() {
        return txtItakusyaCode;
    }

    /*
     * settxtItakusyaCode
     * @param txtItakusyaCode txtItakusyaCode
     */
    @JsonProperty("txtItakusyaCode")
    public void setTxtItakusyaCode(TextBoxCode txtItakusyaCode) {
        this.txtItakusyaCode = txtItakusyaCode;
    }

    /*
     * gettxtTorihikiKinyukikan
     * @return txtTorihikiKinyukikan
     */
    @JsonProperty("txtTorihikiKinyukikan")
    public TextBox getTxtTorihikiKinyukikan() {
        return txtTorihikiKinyukikan;
    }

    /*
     * settxtTorihikiKinyukikan
     * @param txtTorihikiKinyukikan txtTorihikiKinyukikan
     */
    @JsonProperty("txtTorihikiKinyukikan")
    public void setTxtTorihikiKinyukikan(TextBox txtTorihikiKinyukikan) {
        this.txtTorihikiKinyukikan = txtTorihikiKinyukikan;
    }

    // </editor-fold>
}
