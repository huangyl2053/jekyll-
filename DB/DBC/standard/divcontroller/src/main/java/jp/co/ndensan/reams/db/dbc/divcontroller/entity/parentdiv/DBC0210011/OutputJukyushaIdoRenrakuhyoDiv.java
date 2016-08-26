package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonReportPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * OutputJukyushaIdoRenrakuhyo のクラスファイル
 *
 * @author 自動生成
 */
public class OutputJukyushaIdoRenrakuhyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkJukyushaIdoRearakuhyoHakkou")
    private CheckBoxList chkJukyushaIdoRearakuhyoHakkou;
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    private CheckBoxList chkJukyushaIdoRenrakuhyo;
    @JsonProperty("OutputJukyushaIdoRenrakuhyoSetting")
    private PrintContentsSettingDiv OutputJukyushaIdoRenrakuhyoSetting;
    @JsonProperty("btnHakkou")
    private ButtonReportPublish btnHakkou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkJukyushaIdoRearakuhyoHakkou
     * @return chkJukyushaIdoRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaIdoRearakuhyoHakkou")
    public CheckBoxList getChkJukyushaIdoRearakuhyoHakkou() {
        return chkJukyushaIdoRearakuhyoHakkou;
    }

    /*
     * setchkJukyushaIdoRearakuhyoHakkou
     * @param chkJukyushaIdoRearakuhyoHakkou chkJukyushaIdoRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaIdoRearakuhyoHakkou")
    public void setChkJukyushaIdoRearakuhyoHakkou(CheckBoxList chkJukyushaIdoRearakuhyoHakkou) {
        this.chkJukyushaIdoRearakuhyoHakkou = chkJukyushaIdoRearakuhyoHakkou;
    }

    /*
     * getchkJukyushaIdoRenrakuhyo
     * @return chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public CheckBoxList getChkJukyushaIdoRenrakuhyo() {
        return chkJukyushaIdoRenrakuhyo;
    }

    /*
     * setchkJukyushaIdoRenrakuhyo
     * @param chkJukyushaIdoRenrakuhyo chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public void setChkJukyushaIdoRenrakuhyo(CheckBoxList chkJukyushaIdoRenrakuhyo) {
        this.chkJukyushaIdoRenrakuhyo = chkJukyushaIdoRenrakuhyo;
    }

    /*
     * getOutputJukyushaIdoRenrakuhyoSetting
     * @return OutputJukyushaIdoRenrakuhyoSetting
     */
    @JsonProperty("OutputJukyushaIdoRenrakuhyoSetting")
    public IPrintContentsSettingDiv getOutputJukyushaIdoRenrakuhyoSetting() {
        return OutputJukyushaIdoRenrakuhyoSetting;
    }

    /*
     * getbtnHakkou
     * @return btnHakkou
     */
    @JsonProperty("btnHakkou")
    public ButtonReportPublish getBtnHakkou() {
        return btnHakkou;
    }

    /*
     * setbtnHakkou
     * @param btnHakkou btnHakkou
     */
    @JsonProperty("btnHakkou")
    public void setBtnHakkou(ButtonReportPublish btnHakkou) {
        this.btnHakkou = btnHakkou;
    }

    // </editor-fold>
}
