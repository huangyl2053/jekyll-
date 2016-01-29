package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShinseiContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinseiContentsDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShinseiJyoho")
    private tabShinseiJyohoDiv tabShinseiJyoho;
    @JsonProperty("tabKozaJyoho")
    private tabKozaJyohoDiv tabKozaJyoho;
    @JsonProperty("tabJutakuKaisyuJyoho")
    private tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho;
    @JsonProperty("tabShinsaKakka")
    private tabShinsaKakkaDiv tabShinsaKakka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShinseiJyoho
     * @return tabShinseiJyoho
     */
    @JsonProperty("tabShinseiJyoho")
    public tabShinseiJyohoDiv getTabShinseiJyoho() {
        return tabShinseiJyoho;
    }

    /*
     * settabShinseiJyoho
     * @param tabShinseiJyoho tabShinseiJyoho
     */
    @JsonProperty("tabShinseiJyoho")
    public void setTabShinseiJyoho(tabShinseiJyohoDiv tabShinseiJyoho) {
        this.tabShinseiJyoho = tabShinseiJyoho;
    }

    /*
     * gettabKozaJyoho
     * @return tabKozaJyoho
     */
    @JsonProperty("tabKozaJyoho")
    public tabKozaJyohoDiv getTabKozaJyoho() {
        return tabKozaJyoho;
    }

    /*
     * settabKozaJyoho
     * @param tabKozaJyoho tabKozaJyoho
     */
    @JsonProperty("tabKozaJyoho")
    public void setTabKozaJyoho(tabKozaJyohoDiv tabKozaJyoho) {
        this.tabKozaJyoho = tabKozaJyoho;
    }

    /*
     * gettabJutakuKaisyuJyoho
     * @return tabJutakuKaisyuJyoho
     */
    @JsonProperty("tabJutakuKaisyuJyoho")
    public tabJutakuKaisyuJyohoDiv getTabJutakuKaisyuJyoho() {
        return tabJutakuKaisyuJyoho;
    }

    /*
     * settabJutakuKaisyuJyoho
     * @param tabJutakuKaisyuJyoho tabJutakuKaisyuJyoho
     */
    @JsonProperty("tabJutakuKaisyuJyoho")
    public void setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho) {
        this.tabJutakuKaisyuJyoho = tabJutakuKaisyuJyoho;
    }

    /*
     * gettabShinsaKakka
     * @return tabShinsaKakka
     */
    @JsonProperty("tabShinsaKakka")
    public tabShinsaKakkaDiv getTabShinsaKakka() {
        return tabShinsaKakka;
    }

    /*
     * settabShinsaKakka
     * @param tabShinsaKakka tabShinsaKakka
     */
    @JsonProperty("tabShinsaKakka")
    public void setTabShinsaKakka(tabShinsaKakkaDiv tabShinsaKakka) {
        this.tabShinsaKakka = tabShinsaKakka;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtJutakuOwner() {
        return this.getTabShinseiJyoho().getTxtJutakuOwner();
    }

    @JsonIgnore
    public void  setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.getTabShinseiJyoho().setTxtJutakuOwner(txtJutakuOwner);
    }

    @JsonIgnore
    public TextBox getTxtRelationWithHihokensha() {
        return this.getTabShinseiJyoho().getTxtRelationWithHihokensha();
    }

    @JsonIgnore
    public void  setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.getTabShinseiJyoho().setTxtRelationWithHihokensha(txtRelationWithHihokensha);
    }

    @JsonIgnore
    public ShinseishaInfoDiv getShinseishaInfo() {
        return this.getTabShinseiJyoho().getShinseishaInfo();
    }

    @JsonIgnore
    public void  setShinseishaInfo(ShinseishaInfoDiv ShinseishaInfo) {
        this.getTabShinseiJyoho().setShinseishaInfo(ShinseishaInfo);
    }

    @JsonIgnore
    public JutakuKaishuJizenShinseiReasonDiv getJutakuKaishuJizenShinseiReason() {
        return this.getTabShinseiJyoho().getJutakuKaishuJizenShinseiReason();
    }

    @JsonIgnore
    public void  setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason) {
        this.getTabShinseiJyoho().setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReason);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdJutakuKaishuJizenShinseiKoza() {
        return this.getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza();
    }

    @JsonIgnore
    public TotalPanelDiv getTotalPanel() {
        return this.getTabJutakuKaisyuJyoho().getTotalPanel();
    }

    @JsonIgnore
    public void  setTotalPanel(TotalPanelDiv TotalPanel) {
        this.getTabJutakuKaisyuJyoho().setTotalPanel(TotalPanel);
    }

    @JsonIgnore
    public IJyutakugaisyunaiyoListDiv getCcdJutakuJizenShinseiDetail() {
        return this.getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail();
    }

    @JsonIgnore
    public TextBoxDate getTxtJudgeYMD() {
        return this.getTabShinsaKakka().getTxtJudgeYMD();
    }

    @JsonIgnore
    public void  setTxtJudgeYMD(TextBoxDate txtJudgeYMD) {
        this.getTabShinsaKakka().setTxtJudgeYMD(txtJudgeYMD);
    }

    @JsonIgnore
    public RadioButton getRadJudgeKubun() {
        return this.getTabShinsaKakka().getRadJudgeKubun();
    }

    @JsonIgnore
    public void  setRadJudgeKubun(RadioButton radJudgeKubun) {
        this.getTabShinsaKakka().setRadJudgeKubun(radJudgeKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninCondition() {
        return this.getTabShinsaKakka().getTxtShoninCondition();
    }

    @JsonIgnore
    public void  setTxtShoninCondition(TextBoxMultiLine txtShoninCondition) {
        this.getTabShinsaKakka().setTxtShoninCondition(txtShoninCondition);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushoninReason() {
        return this.getTabShinsaKakka().getTxtFushoninReason();
    }

    @JsonIgnore
    public void  setTxtFushoninReason(TextBoxMultiLine txtFushoninReason) {
        this.getTabShinsaKakka().setTxtFushoninReason(txtFushoninReason);
    }

    @JsonIgnore
    public JutakuKaishuJizenShoninKetteiTsuchishoDiv getJutakuKaishuJizenShoninKetteiTsuchisho() {
        return this.getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho();
    }

    @JsonIgnore
    public void  setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho) {
        this.getTabShinsaKakka().setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchisho);
    }

    // </editor-fold>
}
