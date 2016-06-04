package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * NonyuTsuchishoInfo のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NonyuTsuchishoInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoBusu")
    private TextBox txtHakkoBusu;
    @JsonProperty("radSokuhoTorikomiKubun")
    private RadioButton radSokuhoTorikomiKubun;
    @JsonProperty("TanpyoHakkoShoki")
    private TanpyoHakkoShokiDiv TanpyoHakkoShoki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoBusu
     * @return txtHakkoBusu
     */
    @JsonProperty("txtHakkoBusu")
    public TextBox getTxtHakkoBusu() {
        return txtHakkoBusu;
    }

    /*
     * settxtHakkoBusu
     * @param txtHakkoBusu txtHakkoBusu
     */
    @JsonProperty("txtHakkoBusu")
    public void setTxtHakkoBusu(TextBox txtHakkoBusu) {
        this.txtHakkoBusu = txtHakkoBusu;
    }

    /*
     * getradSokuhoTorikomiKubun
     * @return radSokuhoTorikomiKubun
     */
    @JsonProperty("radSokuhoTorikomiKubun")
    public RadioButton getRadSokuhoTorikomiKubun() {
        return radSokuhoTorikomiKubun;
    }

    /*
     * setradSokuhoTorikomiKubun
     * @param radSokuhoTorikomiKubun radSokuhoTorikomiKubun
     */
    @JsonProperty("radSokuhoTorikomiKubun")
    public void setRadSokuhoTorikomiKubun(RadioButton radSokuhoTorikomiKubun) {
        this.radSokuhoTorikomiKubun = radSokuhoTorikomiKubun;
    }

    /*
     * getTanpyoHakkoShoki
     * @return TanpyoHakkoShoki
     */
    @JsonProperty("TanpyoHakkoShoki")
    public TanpyoHakkoShokiDiv getTanpyoHakkoShoki() {
        return TanpyoHakkoShoki;
    }

    /*
     * setTanpyoHakkoShoki
     * @param TanpyoHakkoShoki TanpyoHakkoShoki
     */
    @JsonProperty("TanpyoHakkoShoki")
    public void setTanpyoHakkoShoki(TanpyoHakkoShokiDiv TanpyoHakkoShoki) {
        this.TanpyoHakkoShoki = TanpyoHakkoShoki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSokujiHakkoHoshiki() {
        return this.getTanpyoHakkoShoki().getRadSokujiHakkoHoshiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoHoshiki(RadioButton radSokujiHakkoHoshiki) {
        this.getTanpyoHakkoShoki().setRadSokujiHakkoHoshiki(radSokujiHakkoHoshiki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoKeishiki() {
        return this.getTanpyoHakkoShoki().getRadSokujiHakkoKeishiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoKeishiki(RadioButton radSokujiHakkoKeishiki) {
        this.getTanpyoHakkoShoki().setRadSokujiHakkoKeishiki(radSokujiHakkoKeishiki);
    }

    // </editor-fold>
}
