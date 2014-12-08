package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2010011.CommonShisetsuSearchDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2010011.KaigoHokenShisetsuSearchDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2010011.OtherTokureiShisetsuSearchDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShisetsuSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShisetsuShurui")
    private RadioButton radShisetsuShurui;
    @JsonProperty("CommonShisetsuSearch")
    private CommonShisetsuSearchDiv CommonShisetsuSearch;
    @JsonProperty("KaigoHokenShisetsuSearch")
    private KaigoHokenShisetsuSearchDiv KaigoHokenShisetsuSearch;
    @JsonProperty("OtherTokureiShisetsuSearch")
    private OtherTokureiShisetsuSearchDiv OtherTokureiShisetsuSearch;
    @JsonProperty("chkOutputKyushiHaishi")
    private CheckBoxList chkOutputKyushiHaishi;
    @JsonProperty("chkOutputShisetsuRireki")
    private CheckBoxList chkOutputShisetsuRireki;
    @JsonProperty("txtMaxNum")
    private TextBoxNum txtMaxNum;
    @JsonProperty("btnSearchShisetsu")
    private Button btnSearchShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShisetsuShurui")
    public RadioButton getRadShisetsuShurui() {
        return radShisetsuShurui;
    }

    @JsonProperty("radShisetsuShurui")
    public void setRadShisetsuShurui(RadioButton radShisetsuShurui) {
        this.radShisetsuShurui=radShisetsuShurui;
    }

    @JsonProperty("CommonShisetsuSearch")
    public CommonShisetsuSearchDiv getCommonShisetsuSearch() {
        return CommonShisetsuSearch;
    }

    @JsonProperty("CommonShisetsuSearch")
    public void setCommonShisetsuSearch(CommonShisetsuSearchDiv CommonShisetsuSearch) {
        this.CommonShisetsuSearch=CommonShisetsuSearch;
    }

    @JsonProperty("KaigoHokenShisetsuSearch")
    public KaigoHokenShisetsuSearchDiv getKaigoHokenShisetsuSearch() {
        return KaigoHokenShisetsuSearch;
    }

    @JsonProperty("KaigoHokenShisetsuSearch")
    public void setKaigoHokenShisetsuSearch(KaigoHokenShisetsuSearchDiv KaigoHokenShisetsuSearch) {
        this.KaigoHokenShisetsuSearch=KaigoHokenShisetsuSearch;
    }

    @JsonProperty("OtherTokureiShisetsuSearch")
    public OtherTokureiShisetsuSearchDiv getOtherTokureiShisetsuSearch() {
        return OtherTokureiShisetsuSearch;
    }

    @JsonProperty("OtherTokureiShisetsuSearch")
    public void setOtherTokureiShisetsuSearch(OtherTokureiShisetsuSearchDiv OtherTokureiShisetsuSearch) {
        this.OtherTokureiShisetsuSearch=OtherTokureiShisetsuSearch;
    }

    @JsonProperty("chkOutputKyushiHaishi")
    public CheckBoxList getChkOutputKyushiHaishi() {
        return chkOutputKyushiHaishi;
    }

    @JsonProperty("chkOutputKyushiHaishi")
    public void setChkOutputKyushiHaishi(CheckBoxList chkOutputKyushiHaishi) {
        this.chkOutputKyushiHaishi=chkOutputKyushiHaishi;
    }

    @JsonProperty("chkOutputShisetsuRireki")
    public CheckBoxList getChkOutputShisetsuRireki() {
        return chkOutputShisetsuRireki;
    }

    @JsonProperty("chkOutputShisetsuRireki")
    public void setChkOutputShisetsuRireki(CheckBoxList chkOutputShisetsuRireki) {
        this.chkOutputShisetsuRireki=chkOutputShisetsuRireki;
    }

    @JsonProperty("txtMaxNum")
    public TextBoxNum getTxtMaxNum() {
        return txtMaxNum;
    }

    @JsonProperty("txtMaxNum")
    public void setTxtMaxNum(TextBoxNum txtMaxNum) {
        this.txtMaxNum=txtMaxNum;
    }

    @JsonProperty("btnSearchShisetsu")
    public Button getBtnSearchShisetsu() {
        return btnSearchShisetsu;
    }

    @JsonProperty("btnSearchShisetsu")
    public void setBtnSearchShisetsu(Button btnSearchShisetsu) {
        this.btnSearchShisetsu=btnSearchShisetsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtSearchJigyoshaNo() {
        return this.getCommonShisetsuSearch().getTxtSearchJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtSearchJigyoshaNo(TextBoxCode txtSearchJigyoshaNo) {
        this.getCommonShisetsuSearch().setTxtSearchJigyoshaNo(txtSearchJigyoshaNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSearchJigyoshaKaishiDate() {
        return this.getCommonShisetsuSearch().getTxtSearchJigyoshaKaishiDate();
    }

    @JsonIgnore
    public void  setTxtSearchJigyoshaKaishiDate(TextBoxFlexibleDate txtSearchJigyoshaKaishiDate) {
        this.getCommonShisetsuSearch().setTxtSearchJigyoshaKaishiDate(txtSearchJigyoshaKaishiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSearchJigyoshaHaishiDate() {
        return this.getCommonShisetsuSearch().getTxtSearchJigyoshaHaishiDate();
    }

    @JsonIgnore
    public void  setTxtSearchJigyoshaHaishiDate(TextBoxFlexibleDate txtSearchJigyoshaHaishiDate) {
        this.getCommonShisetsuSearch().setTxtSearchJigyoshaHaishiDate(txtSearchJigyoshaHaishiDate);
    }

    @JsonIgnore
    public TextBox getTxtSearchJigyoshaMeiOrKanaMeisho() {
        return this.getCommonShisetsuSearch().getTxtSearchJigyoshaMeiOrKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtSearchJigyoshaMeiOrKanaMeisho(TextBox txtSearchJigyoshaMeiOrKanaMeisho) {
        this.getCommonShisetsuSearch().setTxtSearchJigyoshaMeiOrKanaMeisho(txtSearchJigyoshaMeiOrKanaMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlSearchMeishoMatchCondition() {
        return this.getCommonShisetsuSearch().getDdlSearchMeishoMatchCondition();
    }

    @JsonIgnore
    public void  setDdlSearchMeishoMatchCondition(DropDownList ddlSearchMeishoMatchCondition) {
        this.getCommonShisetsuSearch().setDdlSearchMeishoMatchCondition(ddlSearchMeishoMatchCondition);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtSearchYubinNo() {
        return this.getCommonShisetsuSearch().getTxtSearchYubinNo();
    }

    @JsonIgnore
    public void  setTxtSearchYubinNo(TextBoxYubinNo txtSearchYubinNo) {
        this.getCommonShisetsuSearch().setTxtSearchYubinNo(txtSearchYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtSearchJusho() {
        return this.getCommonShisetsuSearch().getTxtSearchJusho();
    }

    @JsonIgnore
    public void  setTxtSearchJusho(TextBox txtSearchJusho) {
        this.getCommonShisetsuSearch().setTxtSearchJusho(txtSearchJusho);
    }

    @JsonIgnore
    public DropDownList getDdlSearchKenCode() {
        return this.getKaigoHokenShisetsuSearch().getDdlSearchKenCode();
    }

    @JsonIgnore
    public void  setDdlSearchKenCode(DropDownList ddlSearchKenCode) {
        this.getKaigoHokenShisetsuSearch().setDdlSearchKenCode(ddlSearchKenCode);
    }

    @JsonIgnore
    public DropDownList getDdlSearchJigyoshaKubun() {
        return this.getKaigoHokenShisetsuSearch().getDdlSearchJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlSearchJigyoshaKubun(DropDownList ddlSearchJigyoshaKubun) {
        this.getKaigoHokenShisetsuSearch().setDdlSearchJigyoshaKubun(ddlSearchJigyoshaKubun);
    }

    @JsonIgnore
    public DropDownList getDdlSearchToshiCode() {
        return this.getKaigoHokenShisetsuSearch().getDdlSearchToshiCode();
    }

    @JsonIgnore
    public void  setDdlSearchToshiCode(DropDownList ddlSearchToshiCode) {
        this.getKaigoHokenShisetsuSearch().setDdlSearchToshiCode(ddlSearchToshiCode);
    }

    @JsonIgnore
    public DropDownList getDdlSearchServiceType() {
        return this.getKaigoHokenShisetsuSearch().getDdlSearchServiceType();
    }

    @JsonIgnore
    public void  setDdlSearchServiceType(DropDownList ddlSearchServiceType) {
        this.getKaigoHokenShisetsuSearch().setDdlSearchServiceType(ddlSearchServiceType);
    }

    @JsonIgnore
    public RadioButton getRadKannaiKangaiKubun() {
        return this.getOtherTokureiShisetsuSearch().getRadKannaiKangaiKubun();
    }

    @JsonIgnore
    public void  setRadKannaiKangaiKubun(RadioButton radKannaiKangaiKubun) {
        this.getOtherTokureiShisetsuSearch().setRadKannaiKangaiKubun(radKannaiKangaiKubun);
    }

}
