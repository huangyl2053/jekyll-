package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonReportPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyodoIdoRenrakuhyoTorokuPrint のクラスファイル
 *
 * @reamsid_L DBC-1950-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTorokuPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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

    // </editor-fold>
}
