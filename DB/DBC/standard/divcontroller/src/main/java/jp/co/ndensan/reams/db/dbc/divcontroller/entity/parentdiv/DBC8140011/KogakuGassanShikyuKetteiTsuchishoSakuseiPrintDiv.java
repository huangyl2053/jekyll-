package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KogakuGassanShikyuKetteiTsuchishoSakuseiPrint のクラスファイル
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public class KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkouYMD")
    private TextBoxDate txtHakkouYMD;
    @JsonProperty("txtZenkaiHakkoYMD")
    private TextBoxDate txtZenkaiHakkoYMD;
    @JsonProperty("txtShiharaiYoteiYMD")
    private TextBoxDate txtShiharaiYoteiYMD;
    @JsonProperty("ccdBunshoNO")
    private BunshoBangoInputDiv ccdBunshoNO;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkouYMD
     * @return txtHakkouYMD
     */
    @JsonProperty("txtHakkouYMD")
    public TextBoxDate getTxtHakkouYMD() {
        return txtHakkouYMD;
    }

    /*
     * settxtHakkouYMD
     * @param txtHakkouYMD txtHakkouYMD
     */
    @JsonProperty("txtHakkouYMD")
    public void setTxtHakkouYMD(TextBoxDate txtHakkouYMD) {
        this.txtHakkouYMD = txtHakkouYMD;
    }

    /*
     * gettxtZenkaiHakkoYMD
     * @return txtZenkaiHakkoYMD
     */
    @JsonProperty("txtZenkaiHakkoYMD")
    public TextBoxDate getTxtZenkaiHakkoYMD() {
        return txtZenkaiHakkoYMD;
    }

    /*
     * settxtZenkaiHakkoYMD
     * @param txtZenkaiHakkoYMD txtZenkaiHakkoYMD
     */
    @JsonProperty("txtZenkaiHakkoYMD")
    public void setTxtZenkaiHakkoYMD(TextBoxDate txtZenkaiHakkoYMD) {
        this.txtZenkaiHakkoYMD = txtZenkaiHakkoYMD;
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
     * getccdBunshoNO
     * @return ccdBunshoNO
     */
    @JsonProperty("ccdBunshoNO")
    public IBunshoBangoInputDiv getCcdBunshoNO() {
        return ccdBunshoNO;
    }

    // </editor-fold>
}
