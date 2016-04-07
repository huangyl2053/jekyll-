package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.INinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KensakuJoken のクラスファイル
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class KensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNijihanteDateRange")
    private TextBoxDateRange txtNijihanteDateRange;
    @JsonProperty("radDataShutsuryokuUmu")
    private RadioButton radDataShutsuryokuUmu;
    @JsonProperty("txtHyojiDataLimit")
    private TextBox txtHyojiDataLimit;
    @JsonProperty("btnHyoji")
    private Button btnHyoji;
    @JsonProperty("ccdShinseishaFinder")
    private NinteiShinseishaFinderDiv ccdShinseishaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNijihanteDateRange
     * @return txtNijihanteDateRange
     */
    @JsonProperty("txtNijihanteDateRange")
    public TextBoxDateRange getTxtNijihanteDateRange() {
        return txtNijihanteDateRange;
    }

    /*
     * settxtNijihanteDateRange
     * @param txtNijihanteDateRange txtNijihanteDateRange
     */
    @JsonProperty("txtNijihanteDateRange")
    public void setTxtNijihanteDateRange(TextBoxDateRange txtNijihanteDateRange) {
        this.txtNijihanteDateRange = txtNijihanteDateRange;
    }

    /*
     * getradDataShutsuryokuUmu
     * @return radDataShutsuryokuUmu
     */
    @JsonProperty("radDataShutsuryokuUmu")
    public RadioButton getRadDataShutsuryokuUmu() {
        return radDataShutsuryokuUmu;
    }

    /*
     * setradDataShutsuryokuUmu
     * @param radDataShutsuryokuUmu radDataShutsuryokuUmu
     */
    @JsonProperty("radDataShutsuryokuUmu")
    public void setRadDataShutsuryokuUmu(RadioButton radDataShutsuryokuUmu) {
        this.radDataShutsuryokuUmu = radDataShutsuryokuUmu;
    }

    /*
     * gettxtHyojiDataLimit
     * @return txtHyojiDataLimit
     */
    @JsonProperty("txtHyojiDataLimit")
    public TextBox getTxtHyojiDataLimit() {
        return txtHyojiDataLimit;
    }

    /*
     * settxtHyojiDataLimit
     * @param txtHyojiDataLimit txtHyojiDataLimit
     */
    @JsonProperty("txtHyojiDataLimit")
    public void setTxtHyojiDataLimit(TextBox txtHyojiDataLimit) {
        this.txtHyojiDataLimit = txtHyojiDataLimit;
    }

    /*
     * getbtnHyoji
     * @return btnHyoji
     */
    @JsonProperty("btnHyoji")
    public Button getBtnHyoji() {
        return btnHyoji;
    }

    /*
     * setbtnHyoji
     * @param btnHyoji btnHyoji
     */
    @JsonProperty("btnHyoji")
    public void setBtnHyoji(Button btnHyoji) {
        this.btnHyoji = btnHyoji;
    }

    /*
     * getccdShinseishaFinder
     * @return ccdShinseishaFinder
     */
    @JsonProperty("ccdShinseishaFinder")
    public INinteiShinseishaFinderDiv getCcdShinseishaFinder() {
        return ccdShinseishaFinder;
    }

    // </editor-fold>
}
