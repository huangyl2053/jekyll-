package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * TanpyoHakkoShoki のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class TanpyoHakkoShokiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSokujiHakkoHoshiki")
    private RadioButton radSokujiHakkoHoshiki;
    @JsonProperty("radSokujiHakkoKeishiki")
    private RadioButton radSokujiHakkoKeishiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSokujiHakkoHoshiki
     * @return radSokujiHakkoHoshiki
     */
    @JsonProperty("radSokujiHakkoHoshiki")
    public RadioButton getRadSokujiHakkoHoshiki() {
        return radSokujiHakkoHoshiki;
    }

    /*
     * setradSokujiHakkoHoshiki
     * @param radSokujiHakkoHoshiki radSokujiHakkoHoshiki
     */
    @JsonProperty("radSokujiHakkoHoshiki")
    public void setRadSokujiHakkoHoshiki(RadioButton radSokujiHakkoHoshiki) {
        this.radSokujiHakkoHoshiki = radSokujiHakkoHoshiki;
    }

    /*
     * getradSokujiHakkoKeishiki
     * @return radSokujiHakkoKeishiki
     */
    @JsonProperty("radSokujiHakkoKeishiki")
    public RadioButton getRadSokujiHakkoKeishiki() {
        return radSokujiHakkoKeishiki;
    }

    /*
     * setradSokujiHakkoKeishiki
     * @param radSokujiHakkoKeishiki radSokujiHakkoKeishiki
     */
    @JsonProperty("radSokujiHakkoKeishiki")
    public void setRadSokujiHakkoKeishiki(RadioButton radSokujiHakkoKeishiki) {
        this.radSokujiHakkoKeishiki = radSokujiHakkoKeishiki;
    }

    // </editor-fold>
}
