package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonKetteTsuchi のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonKetteTsuchiDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD")
    private TextBoxDate txtKetteTsuchiHakkoYMD;
    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    private Button btnKetteiTsuchiYousikiSettei;
    @JsonProperty("txtKetteTsuchiBunshoNo")
    private TextBox txtKetteTsuchiBunshoNo;
    @JsonProperty("ShutsuryokuJunHonKetteTsuchi")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonKetteTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteTsuchiHakkoYMD
     * @return txtKetteTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD")
    public TextBoxDate getTxtKetteTsuchiHakkoYMD() {
        return txtKetteTsuchiHakkoYMD;
    }

    /*
     * settxtKetteTsuchiHakkoYMD
     * @param txtKetteTsuchiHakkoYMD txtKetteTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD")
    public void setTxtKetteTsuchiHakkoYMD(TextBoxDate txtKetteTsuchiHakkoYMD) {
        this.txtKetteTsuchiHakkoYMD = txtKetteTsuchiHakkoYMD;
    }

    /*
     * getbtnKetteiTsuchiYousikiSettei
     * @return btnKetteiTsuchiYousikiSettei
     */
    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    public Button getBtnKetteiTsuchiYousikiSettei() {
        return btnKetteiTsuchiYousikiSettei;
    }

    /*
     * setbtnKetteiTsuchiYousikiSettei
     * @param btnKetteiTsuchiYousikiSettei btnKetteiTsuchiYousikiSettei
     */
    @JsonProperty("btnKetteiTsuchiYousikiSettei")
    public void setBtnKetteiTsuchiYousikiSettei(Button btnKetteiTsuchiYousikiSettei) {
        this.btnKetteiTsuchiYousikiSettei = btnKetteiTsuchiYousikiSettei;
    }

    /*
     * gettxtKetteTsuchiBunshoNo
     * @return txtKetteTsuchiBunshoNo
     */
    @JsonProperty("txtKetteTsuchiBunshoNo")
    public TextBox getTxtKetteTsuchiBunshoNo() {
        return txtKetteTsuchiBunshoNo;
    }

    /*
     * settxtKetteTsuchiBunshoNo
     * @param txtKetteTsuchiBunshoNo txtKetteTsuchiBunshoNo
     */
    @JsonProperty("txtKetteTsuchiBunshoNo")
    public void setTxtKetteTsuchiBunshoNo(TextBox txtKetteTsuchiBunshoNo) {
        this.txtKetteTsuchiBunshoNo = txtKetteTsuchiBunshoNo;
    }

    /*
     * getShutsuryokuJunHonKetteTsuchi
     * @return ShutsuryokuJunHonKetteTsuchi
     */
    @JsonProperty("ShutsuryokuJunHonKetteTsuchi")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunHonKetteTsuchi() {
        return ShutsuryokuJunHonKetteTsuchi;
    }

    // </editor-fold>
}
