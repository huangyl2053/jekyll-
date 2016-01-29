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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoShikakuKihonShaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoShikakuKihonShaPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("UpLine")
    private HorizontalLine UpLine;
    @JsonProperty("txtServiceYM")
    private TextBoxDate txtServiceYM;
    @JsonProperty("txtKyufuritsu")
    private TextBox txtKyufuritsu;
    @JsonProperty("tabShinseiContents")
    private tabShinseiContentsDiv tabShinseiContents;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUpLine
     * @return UpLine
     */
    @JsonProperty("UpLine")
    public HorizontalLine getUpLine() {
        return UpLine;
    }

    /*
     * setUpLine
     * @param UpLine UpLine
     */
    @JsonProperty("UpLine")
    public void setUpLine(HorizontalLine UpLine) {
        this.UpLine = UpLine;
    }

    /*
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxDate getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxDate txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBox getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBox txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * gettabShinseiContents
     * @return tabShinseiContents
     */
    @JsonProperty("tabShinseiContents")
    public tabShinseiContentsDiv getTabShinseiContents() {
        return tabShinseiContents;
    }

    /*
     * settabShinseiContents
     * @param tabShinseiContents tabShinseiContents
     */
    @JsonProperty("tabShinseiContents")
    public void setTabShinseiContents(tabShinseiContentsDiv tabShinseiContents) {
        this.tabShinseiContents = tabShinseiContents;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabShinseiJyohoDiv getTabShinseiJyoho() {
        return this.getTabShinseiContents().getTabShinseiJyoho();
    }

    @JsonIgnore
    public void  setTabShinseiJyoho(tabShinseiJyohoDiv tabShinseiJyoho) {
        this.getTabShinseiContents().setTabShinseiJyoho(tabShinseiJyoho);
    }

    @JsonIgnore
    public TextBox getTxtJutakuOwner() {
        return this.getTabShinseiContents().getTabShinseiJyoho().getTxtJutakuOwner();
    }

    @JsonIgnore
    public void  setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.getTabShinseiContents().getTabShinseiJyoho().setTxtJutakuOwner(txtJutakuOwner);
    }

    @JsonIgnore
    public TextBox getTxtRelationWithHihokensha() {
        return this.getTabShinseiContents().getTabShinseiJyoho().getTxtRelationWithHihokensha();
    }

    @JsonIgnore
    public void  setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.getTabShinseiContents().getTabShinseiJyoho().setTxtRelationWithHihokensha(txtRelationWithHihokensha);
    }

    @JsonIgnore
    public ShinseishaInfoDiv getShinseishaInfo() {
        return this.getTabShinseiContents().getTabShinseiJyoho().getShinseishaInfo();
    }

    @JsonIgnore
    public void  setShinseishaInfo(ShinseishaInfoDiv ShinseishaInfo) {
        this.getTabShinseiContents().getTabShinseiJyoho().setShinseishaInfo(ShinseishaInfo);
    }

    @JsonIgnore
    public JutakuKaishuJizenShinseiReasonDiv getJutakuKaishuJizenShinseiReason() {
        return this.getTabShinseiContents().getTabShinseiJyoho().getJutakuKaishuJizenShinseiReason();
    }

    @JsonIgnore
    public void  setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason) {
        this.getTabShinseiContents().getTabShinseiJyoho().setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReason);
    }

    @JsonIgnore
    public tabKozaJyohoDiv getTabKozaJyoho() {
        return this.getTabShinseiContents().getTabKozaJyoho();
    }

    @JsonIgnore
    public void  setTabKozaJyoho(tabKozaJyohoDiv tabKozaJyoho) {
        this.getTabShinseiContents().setTabKozaJyoho(tabKozaJyoho);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdJutakuKaishuJizenShinseiKoza() {
        return this.getTabShinseiContents().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza();
    }

    @JsonIgnore
    public tabJutakuKaisyuJyohoDiv getTabJutakuKaisyuJyoho() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho();
    }

    @JsonIgnore
    public void  setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho) {
        this.getTabShinseiContents().setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyoho);
    }

    @JsonIgnore
    public TotalPanelDiv getTotalPanel() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel();
    }

    @JsonIgnore
    public void  setTotalPanel(TotalPanelDiv TotalPanel) {
        this.getTabShinseiContents().getTabJutakuKaisyuJyoho().setTotalPanel(TotalPanel);
    }

    @JsonIgnore
    public IJyutakugaisyunaiyoListDiv getCcdJutakuJizenShinseiDetail() {
        return this.getTabShinseiContents().getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail();
    }

    @JsonIgnore
    public tabShinsaKakkaDiv getTabShinsaKakka() {
        return this.getTabShinseiContents().getTabShinsaKakka();
    }

    @JsonIgnore
    public void  setTabShinsaKakka(tabShinsaKakkaDiv tabShinsaKakka) {
        this.getTabShinseiContents().setTabShinsaKakka(tabShinsaKakka);
    }

    @JsonIgnore
    public TextBoxDate getTxtJudgeYMD() {
        return this.getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD();
    }

    @JsonIgnore
    public void  setTxtJudgeYMD(TextBoxDate txtJudgeYMD) {
        this.getTabShinseiContents().getTabShinsaKakka().setTxtJudgeYMD(txtJudgeYMD);
    }

    @JsonIgnore
    public RadioButton getRadJudgeKubun() {
        return this.getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun();
    }

    @JsonIgnore
    public void  setRadJudgeKubun(RadioButton radJudgeKubun) {
        this.getTabShinseiContents().getTabShinsaKakka().setRadJudgeKubun(radJudgeKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninCondition() {
        return this.getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition();
    }

    @JsonIgnore
    public void  setTxtShoninCondition(TextBoxMultiLine txtShoninCondition) {
        this.getTabShinseiContents().getTabShinsaKakka().setTxtShoninCondition(txtShoninCondition);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushoninReason() {
        return this.getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason();
    }

    @JsonIgnore
    public void  setTxtFushoninReason(TextBoxMultiLine txtFushoninReason) {
        this.getTabShinseiContents().getTabShinsaKakka().setTxtFushoninReason(txtFushoninReason);
    }

    @JsonIgnore
    public JutakuKaishuJizenShoninKetteiTsuchishoDiv getJutakuKaishuJizenShoninKetteiTsuchisho() {
        return this.getTabShinseiContents().getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho();
    }

    @JsonIgnore
    public void  setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho) {
        this.getTabShinseiContents().getTabShinsaKakka().setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchisho);
    }

    // </editor-fold>
}
