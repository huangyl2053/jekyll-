package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBC-3094-010 qinzhen
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhorenToriatukaiNengetu")
    private TextBoxDateRange txtKokuhorenToriatukaiNengetu;
    @JsonProperty("radHokenshaKubun")
    private RadioButton radHokenshaKubun;
    @JsonProperty("txtSabisuTeikyoNengetu")
    private TextBoxDateRange txtSabisuTeikyoNengetu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("ccdJigyoshaBango")
    private ShisetsuJohoCommonChildDivDiv ccdJigyoshaBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokuhorenToriatukaiNengetu
     * @return txtKokuhorenToriatukaiNengetu
     */
    @JsonProperty("txtKokuhorenToriatukaiNengetu")
    public TextBoxDateRange getTxtKokuhorenToriatukaiNengetu() {
        return txtKokuhorenToriatukaiNengetu;
    }

    /*
     * settxtKokuhorenToriatukaiNengetu
     * @param txtKokuhorenToriatukaiNengetu txtKokuhorenToriatukaiNengetu
     */
    @JsonProperty("txtKokuhorenToriatukaiNengetu")
    public void setTxtKokuhorenToriatukaiNengetu(TextBoxDateRange txtKokuhorenToriatukaiNengetu) {
        this.txtKokuhorenToriatukaiNengetu = txtKokuhorenToriatukaiNengetu;
    }

    /*
     * getradHokenshaKubun
     * @return radHokenshaKubun
     */
    @JsonProperty("radHokenshaKubun")
    public RadioButton getRadHokenshaKubun() {
        return radHokenshaKubun;
    }

    /*
     * setradHokenshaKubun
     * @param radHokenshaKubun radHokenshaKubun
     */
    @JsonProperty("radHokenshaKubun")
    public void setRadHokenshaKubun(RadioButton radHokenshaKubun) {
        this.radHokenshaKubun = radHokenshaKubun;
    }

    /*
     * gettxtSabisuTeikyoNengetu
     * @return txtSabisuTeikyoNengetu
     */
    @JsonProperty("txtSabisuTeikyoNengetu")
    public TextBoxDateRange getTxtSabisuTeikyoNengetu() {
        return txtSabisuTeikyoNengetu;
    }

    /*
     * settxtSabisuTeikyoNengetu
     * @param txtSabisuTeikyoNengetu txtSabisuTeikyoNengetu
     */
    @JsonProperty("txtSabisuTeikyoNengetu")
    public void setTxtSabisuTeikyoNengetu(TextBoxDateRange txtSabisuTeikyoNengetu) {
        this.txtSabisuTeikyoNengetu = txtSabisuTeikyoNengetu;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * getccdJigyoshaBango
     * @return ccdJigyoshaBango
     */
    @JsonProperty("ccdJigyoshaBango")
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaBango() {
        return ccdJigyoshaBango;
    }

    // </editor-fold>
}
