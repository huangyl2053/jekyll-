package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyodoIdoRenrakuhyoHenkoPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoIdoRenrakuhyoHenkoPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkRensakuhyoHakko")
    private CheckBoxList chkRensakuhyoHakko;
    @JsonProperty("btnReportPublish")
    private ButtonReportPublish btnReportPublish;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("radTeiseiKomokuHantei")
    private RadioButton radTeiseiKomokuHantei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkRensakuhyoHakko
     * @return chkRensakuhyoHakko
     */
    @JsonProperty("chkRensakuhyoHakko")
    public CheckBoxList getChkRensakuhyoHakko() {
        return chkRensakuhyoHakko;
    }

    /*
     * setchkRensakuhyoHakko
     * @param chkRensakuhyoHakko chkRensakuhyoHakko
     */
    @JsonProperty("chkRensakuhyoHakko")
    public void setChkRensakuhyoHakko(CheckBoxList chkRensakuhyoHakko) {
        this.chkRensakuhyoHakko = chkRensakuhyoHakko;
    }

    /*
     * getbtnReportPublish
     * @return btnReportPublish
     */
    @JsonProperty("btnReportPublish")
    public ButtonReportPublish getBtnReportPublish() {
        return btnReportPublish;
    }

    /*
     * setbtnReportPublish
     * @param btnReportPublish btnReportPublish
     */
    @JsonProperty("btnReportPublish")
    public void setBtnReportPublish(ButtonReportPublish btnReportPublish) {
        this.btnReportPublish = btnReportPublish;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * getradTeiseiKomokuHantei
     * @return radTeiseiKomokuHantei
     */
    @JsonProperty("radTeiseiKomokuHantei")
    public RadioButton getRadTeiseiKomokuHantei() {
        return radTeiseiKomokuHantei;
    }

    /*
     * setradTeiseiKomokuHantei
     * @param radTeiseiKomokuHantei radTeiseiKomokuHantei
     */
    @JsonProperty("radTeiseiKomokuHantei")
    public void setRadTeiseiKomokuHantei(RadioButton radTeiseiKomokuHantei) {
        this.radTeiseiKomokuHantei = radTeiseiKomokuHantei;
    }

    // </editor-fold>
}
