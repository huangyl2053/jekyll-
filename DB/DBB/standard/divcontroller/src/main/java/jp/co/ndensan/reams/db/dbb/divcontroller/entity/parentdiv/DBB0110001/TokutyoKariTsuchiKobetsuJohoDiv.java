package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TokutyoKariTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 *
 */
public class TokutyoKariTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    private Label lblTokuKaishiTsuchi;
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD2;
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    private RadioButton radTokuKaishiTsuchiTaisho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTokuKaishiTsuchi
     * @return lblTokuKaishiTsuchi
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public Label getLblTokuKaishiTsuchi() {
        return lblTokuKaishiTsuchi;
    }

    /*
     * setlblTokuKaishiTsuchi
     * @param lblTokuKaishiTsuchi lblTokuKaishiTsuchi
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.lblTokuKaishiTsuchi = lblTokuKaishiTsuchi;
    }

    /*
     * gettxtTokuKaishiTsuchiHakkoYMD2
     * @return txtTokuKaishiTsuchiHakkoYMD2
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD2() {
        return txtTokuKaishiTsuchiHakkoYMD2;
    }

    /*
     * settxtTokuKaishiTsuchiHakkoYMD2
     * @param txtTokuKaishiTsuchiHakkoYMD2 txtTokuKaishiTsuchiHakkoYMD2
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    public void setTxtTokuKaishiTsuchiHakkoYMD2(TextBoxDate txtTokuKaishiTsuchiHakkoYMD2) {
        this.txtTokuKaishiTsuchiHakkoYMD2 = txtTokuKaishiTsuchiHakkoYMD2;
    }

    /*
     * getradTokuKaishiTsuchiTaisho2
     * @return radTokuKaishiTsuchiTaisho2
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public RadioButton getRadTokuKaishiTsuchiTaisho2() {
        return radTokuKaishiTsuchiTaisho2;
    }

    /*
     * setradTokuKaishiTsuchiTaisho2
     * @param radTokuKaishiTsuchiTaisho2 radTokuKaishiTsuchiTaisho2
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public void setRadTokuKaishiTsuchiTaisho2(RadioButton radTokuKaishiTsuchiTaisho2) {
        this.radTokuKaishiTsuchiTaisho2 = radTokuKaishiTsuchiTaisho2;
    }

    // </editor-fold>
}
