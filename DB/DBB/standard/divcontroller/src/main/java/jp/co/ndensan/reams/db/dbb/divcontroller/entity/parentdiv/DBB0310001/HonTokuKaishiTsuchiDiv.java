package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonTokuKaishiTsuchi のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonTokuKaishiTsuchiDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD;
    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    private Label lblTokuKaishiTsuchiDaikou;
    @JsonProperty("radTokuKaishiTsuchiTaisho")
    private RadioButton radTokuKaishiTsuchiTaisho;
    @JsonProperty("ShutsuryokuJunHonTokuKaishiTsuchi")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonTokuKaishiTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTokuKaishiTsuchiHakkoYMD
     * @return txtTokuKaishiTsuchiHakkoYMD
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD() {
        return txtTokuKaishiTsuchiHakkoYMD;
    }

    /*
     * settxtTokuKaishiTsuchiHakkoYMD
     * @param txtTokuKaishiTsuchiHakkoYMD txtTokuKaishiTsuchiHakkoYMD
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public void setTxtTokuKaishiTsuchiHakkoYMD(TextBoxDate txtTokuKaishiTsuchiHakkoYMD) {
        this.txtTokuKaishiTsuchiHakkoYMD = txtTokuKaishiTsuchiHakkoYMD;
    }

    /*
     * getlblTokuKaishiTsuchiDaikou
     * @return lblTokuKaishiTsuchiDaikou
     */
    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    public Label getLblTokuKaishiTsuchiDaikou() {
        return lblTokuKaishiTsuchiDaikou;
    }

    /*
     * setlblTokuKaishiTsuchiDaikou
     * @param lblTokuKaishiTsuchiDaikou lblTokuKaishiTsuchiDaikou
     */
    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    public void setLblTokuKaishiTsuchiDaikou(Label lblTokuKaishiTsuchiDaikou) {
        this.lblTokuKaishiTsuchiDaikou = lblTokuKaishiTsuchiDaikou;
    }

    /*
     * getradTokuKaishiTsuchiTaisho
     * @return radTokuKaishiTsuchiTaisho
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho")
    public RadioButton getRadTokuKaishiTsuchiTaisho() {
        return radTokuKaishiTsuchiTaisho;
    }

    /*
     * setradTokuKaishiTsuchiTaisho
     * @param radTokuKaishiTsuchiTaisho radTokuKaishiTsuchiTaisho
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho")
    public void setRadTokuKaishiTsuchiTaisho(RadioButton radTokuKaishiTsuchiTaisho) {
        this.radTokuKaishiTsuchiTaisho = radTokuKaishiTsuchiTaisho;
    }

    /*
     * getShutsuryokuJunHonTokuKaishiTsuchi
     * @return ShutsuryokuJunHonTokuKaishiTsuchi
     */
    @JsonProperty("ShutsuryokuJunHonTokuKaishiTsuchi")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunHonTokuKaishiTsuchi() {
        return ShutsuryokuJunHonTokuKaishiTsuchi;
    }

    // </editor-fold>
}
