package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KogakuGassanShikyuKetteiTsuchishoSakuseiPrint のクラスファイル
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoYMD")
    private TextBoxDate txtHakkoYMD;
    @JsonProperty("txtShiharaiYoteiYMD")
    private TextBoxDate txtShiharaiYoteiYMD;
    @JsonProperty("radKetteibiIkkatsuKoshinKBN")
    private RadioButton radKetteibiIkkatsuKoshinKBN;
    @JsonProperty("txtKetteiymd")
    private TextBoxDate txtKetteiymd;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    /*
     * gettxtShiharaiYoteiYMD
     * @return txtShiharaiYoteiYMD
     */
    @JsonProperty("txtShiharaiYoteiYMD")
    public TextBoxDate getTxtShiharaiYoteiYMD() {
        return txtShiharaiYoteiYMD;
    }

    /*
     * settxtShiharaiYoteiYMD
     * @param txtShiharaiYoteiYMD txtShiharaiYoteiYMD
     */
    @JsonProperty("txtShiharaiYoteiYMD")
    public void setTxtShiharaiYoteiYMD(TextBoxDate txtShiharaiYoteiYMD) {
        this.txtShiharaiYoteiYMD = txtShiharaiYoteiYMD;
    }

    /*
     * getradKetteibiIkkatsuKoshinKBN
     * @return radKetteibiIkkatsuKoshinKBN
     */
    @JsonProperty("radKetteibiIkkatsuKoshinKBN")
    public RadioButton getRadKetteibiIkkatsuKoshinKBN() {
        return radKetteibiIkkatsuKoshinKBN;
    }

    /*
     * setradKetteibiIkkatsuKoshinKBN
     * @param radKetteibiIkkatsuKoshinKBN radKetteibiIkkatsuKoshinKBN
     */
    @JsonProperty("radKetteibiIkkatsuKoshinKBN")
    public void setRadKetteibiIkkatsuKoshinKBN(RadioButton radKetteibiIkkatsuKoshinKBN) {
        this.radKetteibiIkkatsuKoshinKBN = radKetteibiIkkatsuKoshinKBN;
    }

    /*
     * gettxtKetteiymd
     * @return txtKetteiymd
     */
    @JsonProperty("txtKetteiymd")
    public TextBoxDate getTxtKetteiymd() {
        return txtKetteiymd;
    }

    /*
     * settxtKetteiymd
     * @param txtKetteiymd txtKetteiymd
     */
    @JsonProperty("txtKetteiymd")
    public void setTxtKetteiymd(TextBoxDate txtKetteiymd) {
        this.txtKetteiymd = txtKetteiymd;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * getccdBunshoBangoInput
     * @return ccdBunshoBangoInput
     */
    @JsonProperty("ccdBunshoBangoInput")
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return ccdBunshoBangoInput;
    }

    // </editor-fold>
}
