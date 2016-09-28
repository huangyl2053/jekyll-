package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SaisinsaMoshitateJohoChushutsu")
    private SaisinsaMoshitateJohoChushutsuDiv SaisinsaMoshitateJohoChushutsu;
    @JsonProperty("SaisinsaKekkaJohoChushutsu")
    private SaisinsaKekkaJohoChushutsuDiv SaisinsaKekkaJohoChushutsu;
    @JsonProperty("SaisinsaJohoChushutsu")
    private SaisinsaJohoChushutsuDiv SaisinsaJohoChushutsu;
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
     * getSaisinsaMoshitateJohoChushutsu
     * @return SaisinsaMoshitateJohoChushutsu
     */
    @JsonProperty("SaisinsaMoshitateJohoChushutsu")
    public SaisinsaMoshitateJohoChushutsuDiv getSaisinsaMoshitateJohoChushutsu() {
        return SaisinsaMoshitateJohoChushutsu;
    }

    /*
     * setSaisinsaMoshitateJohoChushutsu
     * @param SaisinsaMoshitateJohoChushutsu SaisinsaMoshitateJohoChushutsu
     */
    @JsonProperty("SaisinsaMoshitateJohoChushutsu")
    public void setSaisinsaMoshitateJohoChushutsu(SaisinsaMoshitateJohoChushutsuDiv SaisinsaMoshitateJohoChushutsu) {
        this.SaisinsaMoshitateJohoChushutsu = SaisinsaMoshitateJohoChushutsu;
    }

    /*
     * getSaisinsaKekkaJohoChushutsu
     * @return SaisinsaKekkaJohoChushutsu
     */
    @JsonProperty("SaisinsaKekkaJohoChushutsu")
    public SaisinsaKekkaJohoChushutsuDiv getSaisinsaKekkaJohoChushutsu() {
        return SaisinsaKekkaJohoChushutsu;
    }

    /*
     * setSaisinsaKekkaJohoChushutsu
     * @param SaisinsaKekkaJohoChushutsu SaisinsaKekkaJohoChushutsu
     */
    @JsonProperty("SaisinsaKekkaJohoChushutsu")
    public void setSaisinsaKekkaJohoChushutsu(SaisinsaKekkaJohoChushutsuDiv SaisinsaKekkaJohoChushutsu) {
        this.SaisinsaKekkaJohoChushutsu = SaisinsaKekkaJohoChushutsu;
    }

    /*
     * getSaisinsaJohoChushutsu
     * @return SaisinsaJohoChushutsu
     */
    @JsonProperty("SaisinsaJohoChushutsu")
    public SaisinsaJohoChushutsuDiv getSaisinsaJohoChushutsu() {
        return SaisinsaJohoChushutsu;
    }

    /*
     * setSaisinsaJohoChushutsu
     * @param SaisinsaJohoChushutsu SaisinsaJohoChushutsu
     */
    @JsonProperty("SaisinsaJohoChushutsu")
    public void setSaisinsaJohoChushutsu(SaisinsaJohoChushutsuDiv SaisinsaJohoChushutsu) {
        this.SaisinsaJohoChushutsu = SaisinsaJohoChushutsu;
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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtKokuhorenSofuNengetu() {
        return this.getSaisinsaMoshitateJohoChushutsu().getTxtKokuhorenSofuNengetu();
    }

    @JsonIgnore
    public void  setTxtKokuhorenSofuNengetu(TextBoxDateRange txtKokuhorenSofuNengetu) {
        this.getSaisinsaMoshitateJohoChushutsu().setTxtKokuhorenSofuNengetu(txtKokuhorenSofuNengetu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhorenToriatukaiNengetu() {
        return this.getSaisinsaKekkaJohoChushutsu().getTxtKokuhorenToriatukaiNengetu();
    }

    @JsonIgnore
    public void  setTxtKokuhorenToriatukaiNengetu(TextBoxDateRange txtKokuhorenToriatukaiNengetu) {
        this.getSaisinsaKekkaJohoChushutsu().setTxtKokuhorenToriatukaiNengetu(txtKokuhorenToriatukaiNengetu);
    }

    @JsonIgnore
    public CheckBoxList getChkHokenshaKubun() {
        return this.getSaisinsaKekkaJohoChushutsu().getChkHokenshaKubun();
    }

    @JsonIgnore
    public void  setChkHokenshaKubun(CheckBoxList chkHokenshaKubun) {
        this.getSaisinsaKekkaJohoChushutsu().setChkHokenshaKubun(chkHokenshaKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSabisuTeikyoNengetu() {
        return this.getSaisinsaJohoChushutsu().getTxtSabisuTeikyoNengetu();
    }

    @JsonIgnore
    public void  setTxtSabisuTeikyoNengetu(TextBoxDateRange txtSabisuTeikyoNengetu) {
        this.getSaisinsaJohoChushutsu().setTxtSabisuTeikyoNengetu(txtSabisuTeikyoNengetu);
    }

    // </editor-fold>
}
