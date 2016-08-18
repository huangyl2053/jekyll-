package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShutsuryokuTaisho のクラスファイル
 *
 * @reamsid_L DBC-0430-011 zhengshenlei
 */
public class ShutsuryokuTaishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiDate")
    private TextBoxFlexibleDate txtSakuseiDate;
    @JsonProperty("chkShutsuryokuTaisho")
    private CheckBoxList chkShutsuryokuTaisho;
    @JsonProperty("radKinyoKikanmeiHyoji")
    private RadioButton radKinyoKikanmeiHyoji;
    @JsonProperty("txtShinseishoTeishutsuKigen")
    private TextBoxFlexibleDate txtShinseishoTeishutsuKigen;
    @JsonProperty("chkHakkoIchiranhyoHakko")
    private CheckBoxList chkHakkoIchiranhyoHakko;
    @JsonProperty("ccdBunshoNo")
    private BunshoBangoInputDiv ccdBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiDate
     * @return txtSakuseiDate
     */
    @JsonProperty("txtSakuseiDate")
    public TextBoxFlexibleDate getTxtSakuseiDate() {
        return txtSakuseiDate;
    }

    /*
     * settxtSakuseiDate
     * @param txtSakuseiDate txtSakuseiDate
     */
    @JsonProperty("txtSakuseiDate")
    public void setTxtSakuseiDate(TextBoxFlexibleDate txtSakuseiDate) {
        this.txtSakuseiDate = txtSakuseiDate;
    }

    /*
     * getchkShutsuryokuTaisho
     * @return chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public CheckBoxList getChkShutsuryokuTaisho() {
        return chkShutsuryokuTaisho;
    }

    /*
     * setchkShutsuryokuTaisho
     * @param chkShutsuryokuTaisho chkShutsuryokuTaisho
     */
    @JsonProperty("chkShutsuryokuTaisho")
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.chkShutsuryokuTaisho = chkShutsuryokuTaisho;
    }

    /*
     * getradKinyoKikanmeiHyoji
     * @return radKinyoKikanmeiHyoji
     */
    @JsonProperty("radKinyoKikanmeiHyoji")
    public RadioButton getRadKinyoKikanmeiHyoji() {
        return radKinyoKikanmeiHyoji;
    }

    /*
     * setradKinyoKikanmeiHyoji
     * @param radKinyoKikanmeiHyoji radKinyoKikanmeiHyoji
     */
    @JsonProperty("radKinyoKikanmeiHyoji")
    public void setRadKinyoKikanmeiHyoji(RadioButton radKinyoKikanmeiHyoji) {
        this.radKinyoKikanmeiHyoji = radKinyoKikanmeiHyoji;
    }

    /*
     * gettxtShinseishoTeishutsuKigen
     * @return txtShinseishoTeishutsuKigen
     */
    @JsonProperty("txtShinseishoTeishutsuKigen")
    public TextBoxFlexibleDate getTxtShinseishoTeishutsuKigen() {
        return txtShinseishoTeishutsuKigen;
    }

    /*
     * settxtShinseishoTeishutsuKigen
     * @param txtShinseishoTeishutsuKigen txtShinseishoTeishutsuKigen
     */
    @JsonProperty("txtShinseishoTeishutsuKigen")
    public void setTxtShinseishoTeishutsuKigen(TextBoxFlexibleDate txtShinseishoTeishutsuKigen) {
        this.txtShinseishoTeishutsuKigen = txtShinseishoTeishutsuKigen;
    }

    /*
     * getchkHakkoIchiranhyoHakko
     * @return chkHakkoIchiranhyoHakko
     */
    @JsonProperty("chkHakkoIchiranhyoHakko")
    public CheckBoxList getChkHakkoIchiranhyoHakko() {
        return chkHakkoIchiranhyoHakko;
    }

    /*
     * setchkHakkoIchiranhyoHakko
     * @param chkHakkoIchiranhyoHakko chkHakkoIchiranhyoHakko
     */
    @JsonProperty("chkHakkoIchiranhyoHakko")
    public void setChkHakkoIchiranhyoHakko(CheckBoxList chkHakkoIchiranhyoHakko) {
        this.chkHakkoIchiranhyoHakko = chkHakkoIchiranhyoHakko;
    }

    /*
     * getccdBunshoNo
     * @return ccdBunshoNo
     */
    @JsonProperty("ccdBunshoNo")
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return ccdBunshoNo;
    }

    // </editor-fold>
}
