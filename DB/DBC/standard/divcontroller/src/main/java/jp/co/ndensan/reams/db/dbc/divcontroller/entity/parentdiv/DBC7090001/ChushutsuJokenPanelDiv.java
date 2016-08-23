package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001;
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
 * @reamsid_L DBC-3095-010 qinzhen
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhorenSofuNengetu")
    private TextBoxDateRange txtKokuhorenSofuNengetu;
    @JsonProperty("radKagoMoshitateKyufuKubun")
    private RadioButton radKagoMoshitateKyufuKubun;
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
     * gettxtKokuhorenSofuNengetu
     * @return txtKokuhorenSofuNengetu
     */
    @JsonProperty("txtKokuhorenSofuNengetu")
    public TextBoxDateRange getTxtKokuhorenSofuNengetu() {
        return txtKokuhorenSofuNengetu;
    }

    /*
     * settxtKokuhorenSofuNengetu
     * @param txtKokuhorenSofuNengetu txtKokuhorenSofuNengetu
     */
    @JsonProperty("txtKokuhorenSofuNengetu")
    public void setTxtKokuhorenSofuNengetu(TextBoxDateRange txtKokuhorenSofuNengetu) {
        this.txtKokuhorenSofuNengetu = txtKokuhorenSofuNengetu;
    }

    /*
     * getradKagoMoshitateKyufuKubun
     * @return radKagoMoshitateKyufuKubun
     */
    @JsonProperty("radKagoMoshitateKyufuKubun")
    public RadioButton getRadKagoMoshitateKyufuKubun() {
        return radKagoMoshitateKyufuKubun;
    }

    /*
     * setradKagoMoshitateKyufuKubun
     * @param radKagoMoshitateKyufuKubun radKagoMoshitateKyufuKubun
     */
    @JsonProperty("radKagoMoshitateKyufuKubun")
    public void setRadKagoMoshitateKyufuKubun(RadioButton radKagoMoshitateKyufuKubun) {
        this.radKagoMoshitateKyufuKubun = radKagoMoshitateKyufuKubun;
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
