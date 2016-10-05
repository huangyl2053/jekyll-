package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7170001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBC-3101-010 qinzhen
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSikyuKubun")
    private RadioButton radSikyuKubun;
    @JsonProperty("radSiharaiHohoKubun")
    private RadioButton radSiharaiHohoKubun;
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("txtKetteiJohoUketoriNengetsu")
    private TextBoxDateRange txtKetteiJohoUketoriNengetsu;
    @JsonProperty("ccdKinyuKikan")
    private KinyuKikanInputDiv ccdKinyuKikan;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSikyuKubun
     * @return radSikyuKubun
     */
    @JsonProperty("radSikyuKubun")
    public RadioButton getRadSikyuKubun() {
        return radSikyuKubun;
    }

    /*
     * setradSikyuKubun
     * @param radSikyuKubun radSikyuKubun
     */
    @JsonProperty("radSikyuKubun")
    public void setRadSikyuKubun(RadioButton radSikyuKubun) {
        this.radSikyuKubun = radSikyuKubun;
    }

    /*
     * getradSiharaiHohoKubun
     * @return radSiharaiHohoKubun
     */
    @JsonProperty("radSiharaiHohoKubun")
    public RadioButton getRadSiharaiHohoKubun() {
        return radSiharaiHohoKubun;
    }

    /*
     * setradSiharaiHohoKubun
     * @param radSiharaiHohoKubun radSiharaiHohoKubun
     */
    @JsonProperty("radSiharaiHohoKubun")
    public void setRadSiharaiHohoKubun(RadioButton radSiharaiHohoKubun) {
        this.radSiharaiHohoKubun = radSiharaiHohoKubun;
    }

    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * gettxtKetteiJohoUketoriNengetsu
     * @return txtKetteiJohoUketoriNengetsu
     */
    @JsonProperty("txtKetteiJohoUketoriNengetsu")
    public TextBoxDateRange getTxtKetteiJohoUketoriNengetsu() {
        return txtKetteiJohoUketoriNengetsu;
    }

    /*
     * settxtKetteiJohoUketoriNengetsu
     * @param txtKetteiJohoUketoriNengetsu txtKetteiJohoUketoriNengetsu
     */
    @JsonProperty("txtKetteiJohoUketoriNengetsu")
    public void setTxtKetteiJohoUketoriNengetsu(TextBoxDateRange txtKetteiJohoUketoriNengetsu) {
        this.txtKetteiJohoUketoriNengetsu = txtKetteiJohoUketoriNengetsu;
    }

    /*
     * getccdKinyuKikan
     * @return ccdKinyuKikan
     */
    @JsonProperty("ccdKinyuKikan")
    public IKinyuKikanInputDiv getCcdKinyuKikan() {
        return ccdKinyuKikan;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
