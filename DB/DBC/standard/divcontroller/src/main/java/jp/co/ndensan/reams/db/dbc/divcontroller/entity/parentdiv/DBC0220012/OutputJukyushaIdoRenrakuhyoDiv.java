package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * OutputJukyushaIdoRenrakuhyo のクラスファイル
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public class OutputJukyushaIdoRenrakuhyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    private CheckBoxList chkJukyushaTeiseiRearakuhyoHakkou;
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    private CheckBoxList chkJukyushaIdoRenrakuhyo;
    @JsonProperty("btnHakkou")
    private Button btnHakkou;
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoPrintSetting")
    private PrintContentsSettingDiv JukyushaIdoRenrakuhyoHenkoPrintSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkJukyushaTeiseiRearakuhyoHakkou
     * @return chkJukyushaTeiseiRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    public CheckBoxList getChkJukyushaTeiseiRearakuhyoHakkou() {
        return chkJukyushaTeiseiRearakuhyoHakkou;
    }

    /*
     * setchkJukyushaTeiseiRearakuhyoHakkou
     * @param chkJukyushaTeiseiRearakuhyoHakkou chkJukyushaTeiseiRearakuhyoHakkou
     */
    @JsonProperty("chkJukyushaTeiseiRearakuhyoHakkou")
    public void setChkJukyushaTeiseiRearakuhyoHakkou(CheckBoxList chkJukyushaTeiseiRearakuhyoHakkou) {
        this.chkJukyushaTeiseiRearakuhyoHakkou = chkJukyushaTeiseiRearakuhyoHakkou;
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
     * getbtnHakkou
     * @return btnHakkou
     */
    @JsonProperty("btnHakkou")
    public Button getBtnHakkou() {
        return btnHakkou;
    }

    /*
     * setbtnHakkou
     * @param btnHakkou btnHakkou
     */
    @JsonProperty("btnHakkou")
    public void setBtnHakkou(Button btnHakkou) {
        this.btnHakkou = btnHakkou;
    }

    /*
     * getJukyushaIdoRenrakuhyoHenkoPrintSetting
     * @return JukyushaIdoRenrakuhyoHenkoPrintSetting
     */
    @JsonProperty("JukyushaIdoRenrakuhyoHenkoPrintSetting")
    public IPrintContentsSettingDiv getJukyushaIdoRenrakuhyoHenkoPrintSetting() {
        return JukyushaIdoRenrakuhyoHenkoPrintSetting;
    }

    // </editor-fold>
}
