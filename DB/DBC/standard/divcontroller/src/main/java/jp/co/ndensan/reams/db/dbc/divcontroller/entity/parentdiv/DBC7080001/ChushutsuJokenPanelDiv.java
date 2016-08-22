package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001;
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
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuTaishoNengetu")
    private TextBoxDateRange txtKyufuTaishoNengetu;
    @JsonProperty("radMeisaigyoSyuturyokuUmu")
    private RadioButton radMeisaigyoSyuturyokuUmu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("ｃｃｄKyotakuSienJigyoshaBango")
    private ShisetsuJohoCommonChildDivDiv ｃｃｄKyotakuSienJigyoshaBango;
    @JsonProperty("ccdItakusakiSienJigyoshaBango")
    private ShisetsuJohoCommonChildDivDiv ccdItakusakiSienJigyoshaBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKyufuTaishoNengetu
     * @return txtKyufuTaishoNengetu
     */
    @JsonProperty("txtKyufuTaishoNengetu")
    public TextBoxDateRange getTxtKyufuTaishoNengetu() {
        return txtKyufuTaishoNengetu;
    }

    /*
     * settxtKyufuTaishoNengetu
     * @param txtKyufuTaishoNengetu txtKyufuTaishoNengetu
     */
    @JsonProperty("txtKyufuTaishoNengetu")
    public void setTxtKyufuTaishoNengetu(TextBoxDateRange txtKyufuTaishoNengetu) {
        this.txtKyufuTaishoNengetu = txtKyufuTaishoNengetu;
    }

    /*
     * getradMeisaigyoSyuturyokuUmu
     * @return radMeisaigyoSyuturyokuUmu
     */
    @JsonProperty("radMeisaigyoSyuturyokuUmu")
    public RadioButton getRadMeisaigyoSyuturyokuUmu() {
        return radMeisaigyoSyuturyokuUmu;
    }

    /*
     * setradMeisaigyoSyuturyokuUmu
     * @param radMeisaigyoSyuturyokuUmu radMeisaigyoSyuturyokuUmu
     */
    @JsonProperty("radMeisaigyoSyuturyokuUmu")
    public void setRadMeisaigyoSyuturyokuUmu(RadioButton radMeisaigyoSyuturyokuUmu) {
        this.radMeisaigyoSyuturyokuUmu = radMeisaigyoSyuturyokuUmu;
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
     * getｃｃｄKyotakuSienJigyoshaBango
     * @return ｃｃｄKyotakuSienJigyoshaBango
     */
    @JsonProperty("ｃｃｄKyotakuSienJigyoshaBango")
    public IShisetsuJohoCommonChildDiv getＣｃｄKyotakuSienJigyoshaBango() {
        return ｃｃｄKyotakuSienJigyoshaBango;
    }

    /*
     * getccdItakusakiSienJigyoshaBango
     * @return ccdItakusakiSienJigyoshaBango
     */
    @JsonProperty("ccdItakusakiSienJigyoshaBango")
    public IShisetsuJohoCommonChildDiv getCcdItakusakiSienJigyoshaBango() {
        return ccdItakusakiSienJigyoshaBango;
    }

    // </editor-fold>
}
