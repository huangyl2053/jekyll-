package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.IKogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabKogakuServicehiDetail のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class tabKogakuServicehiDetailDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShinseisha")
    private tplShinseishaDiv tplShinseisha;
    @JsonProperty("tplKoza")
    private tplKozaDiv tplKoza;
    @JsonProperty("tplJudgementResult")
    private tplJudgementResultDiv tplJudgementResult;
    @JsonProperty("tplKetteiJoho")
    private tplKetteiJohoDiv tplKetteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplShinseisha
     * @return tplShinseisha
     */
    @JsonProperty("tplShinseisha")
    public tplShinseishaDiv getTplShinseisha() {
        return tplShinseisha;
    }

    /*
     * settplShinseisha
     * @param tplShinseisha tplShinseisha
     */
    @JsonProperty("tplShinseisha")
    public void setTplShinseisha(tplShinseishaDiv tplShinseisha) {
        this.tplShinseisha = tplShinseisha;
    }

    /*
     * gettplKoza
     * @return tplKoza
     */
    @JsonProperty("tplKoza")
    public tplKozaDiv getTplKoza() {
        return tplKoza;
    }

    /*
     * settplKoza
     * @param tplKoza tplKoza
     */
    @JsonProperty("tplKoza")
    public void setTplKoza(tplKozaDiv tplKoza) {
        this.tplKoza = tplKoza;
    }

    /*
     * gettplJudgementResult
     * @return tplJudgementResult
     */
    @JsonProperty("tplJudgementResult")
    public tplJudgementResultDiv getTplJudgementResult() {
        return tplJudgementResult;
    }

    /*
     * settplJudgementResult
     * @param tplJudgementResult tplJudgementResult
     */
    @JsonProperty("tplJudgementResult")
    public void setTplJudgementResult(tplJudgementResultDiv tplJudgementResult) {
        this.tplJudgementResult = tplJudgementResult;
    }

    /*
     * gettplKetteiJoho
     * @return tplKetteiJoho
     */
    @JsonProperty("tplKetteiJoho")
    public tplKetteiJohoDiv getTplKetteiJoho() {
        return tplKetteiJoho;
    }

    /*
     * settplKetteiJoho
     * @param tplKetteiJoho tplKetteiJoho
     */
    @JsonProperty("tplKetteiJoho")
    public void setTplKetteiJoho(tplKetteiJohoDiv tplKetteiJoho) {
        this.tplKetteiJoho = tplKetteiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTplShinseisha().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTplShinseisha().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public RadioButton getRdbShinseisyaKubun() {
        return this.getTplShinseisha().getRdbShinseisyaKubun();
    }

    @JsonIgnore
    public void  setRdbShinseisyaKubun(RadioButton rdbShinseisyaKubun) {
        this.getTplShinseisha().setRdbShinseisyaKubun(rdbShinseisyaKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtHokenJyaBango() {
        return this.getTplShinseisha().getTxtHokenJyaBango();
    }

    @JsonIgnore
    public void  setTxtHokenJyaBango(TextBoxCode txtHokenJyaBango) {
        this.getTplShinseisha().setTxtHokenJyaBango(txtHokenJyaBango);
    }

    @JsonIgnore
    public CheckBoxList getChkKokuhorenSaiso() {
        return this.getTplShinseisha().getChkKokuhorenSaiso();
    }

    @JsonIgnore
    public void  setChkKokuhorenSaiso(CheckBoxList chkKokuhorenSaiso) {
        this.getTplShinseisha().setChkKokuhorenSaiso(chkKokuhorenSaiso);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getTplShinseisha().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getTplShinseisha().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeiKana() {
        return this.getTplShinseisha().getTxtShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.getTplShinseisha().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTplShinseisha().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTplShinseisha().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTplShinseisha().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTplShinseisha().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return this.getTplShinseisha().getTxtShiharaiTotalAmount();
    }

    @JsonIgnore
    public void  setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.getTplShinseisha().setTxtShiharaiTotalAmount(txtShiharaiTotalAmount);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKotei() {
        return this.getTplShinseisha().getTxtKotei();
    }

    @JsonIgnore
    public void  setTxtKotei(TextBoxMultiLine txtKotei) {
        this.getTplShinseisha().setTxtKotei(txtKotei);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getTplKoza().getCcdShiharaiHohoJyoho();
    }

    @JsonIgnore
    public IKogakuKyufuTaishoListDiv getCcdKogakuKyufuTaishoList() {
        return this.getTplJudgementResult().getCcdKogakuKyufuTaishoList();
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getTplJudgementResult().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getTplJudgementResult().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninShiharaiGaku() {
        return this.getTplJudgementResult().getTxtHonninShiharaiGaku();
    }

    @JsonIgnore
    public void  setTxtHonninShiharaiGaku(TextBoxNum txtHonninShiharaiGaku) {
        this.getTplJudgementResult().setTxtHonninShiharaiGaku(txtHonninShiharaiGaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTplJudgementResult().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTplJudgementResult().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public RadioButton getRdbShikyuKubun() {
        return this.getTplJudgementResult().getRdbShikyuKubun();
    }

    @JsonIgnore
    public void  setRdbShikyuKubun(RadioButton rdbShikyuKubun) {
        this.getTplJudgementResult().setRdbShikyuKubun(rdbShikyuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbShinsaHohoKubun() {
        return this.getTplJudgementResult().getRdbShinsaHohoKubun();
    }

    @JsonIgnore
    public void  setRdbShinsaHohoKubun(RadioButton rdbShinsaHohoKubun) {
        this.getTplJudgementResult().setRdbShinsaHohoKubun(rdbShinsaHohoKubun);
    }

    @JsonIgnore
    public TextBox getTxtSetaiSyuyakuBango() {
        return this.getTplJudgementResult().getTxtSetaiSyuyakuBango();
    }

    @JsonIgnore
    public void  setTxtSetaiSyuyakuBango(TextBox txtSetaiSyuyakuBango) {
        this.getTplJudgementResult().setTxtSetaiSyuyakuBango(txtSetaiSyuyakuBango);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuKingaku() {
        return this.getTplJudgementResult().getTxtShikyuKingaku();
    }

    @JsonIgnore
    public void  setTxtShikyuKingaku(TextBoxNum txtShikyuKingaku) {
        this.getTplJudgementResult().setTxtShikyuKingaku(txtShikyuKingaku);
    }

    @JsonIgnore
    public RadioButton getRdbKogakuJidoSyokanTaisyo() {
        return this.getTplJudgementResult().getRdbKogakuJidoSyokanTaisyo();
    }

    @JsonIgnore
    public void  setRdbKogakuJidoSyokanTaisyo(RadioButton rdbKogakuJidoSyokanTaisyo) {
        this.getTplJudgementResult().setRdbKogakuJidoSyokanTaisyo(rdbKogakuJidoSyokanTaisyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShikyusinaiRiyu() {
        return this.getTplJudgementResult().getTxtShikyusinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtShikyusinaiRiyu(TextBoxMultiLine txtShikyusinaiRiyu) {
        this.getTplJudgementResult().setTxtShikyusinaiRiyu(txtShikyusinaiRiyu);
    }

    @JsonIgnore
    public KokuhorenKetteiJohoPanel1Div getKokuhorenKetteiJohoPanel1() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1();
    }

    @JsonIgnore
    public void  setKokuhorenKetteiJohoPanel1(KokuhorenKetteiJohoPanel1Div KokuhorenKetteiJohoPanel1) {
        this.getTplKetteiJoho().setKokuhorenKetteiJohoPanel1(KokuhorenKetteiJohoPanel1);
    }

    @JsonIgnore
    public TextBoxCode getTxtTsuchiBango() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtTsuchiBango();
    }

    @JsonIgnore
    public void  setTxtTsuchiBango(TextBoxCode txtTsuchiBango) {
        this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtTsuchiBango(txtTsuchiBango);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYM() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtKetteiYM();
    }

    @JsonIgnore
    public void  setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtKetteiYM(txtKetteiYM);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingakuGokei() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtShiharaiKingakuGokei();
    }

    @JsonIgnore
    public void  setTxtShiharaiKingakuGokei(TextBoxNum txtShiharaiKingakuGokei) {
        this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtShiharaiKingakuGokei(txtShiharaiKingakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().getTxtKogakuShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.getTplKetteiJoho().getKokuhorenKetteiJohoPanel1().setTxtKogakuShikyuGaku(txtKogakuShikyuGaku);
    }

    @JsonIgnore
    public SakuseiPanelDiv getSakuseiPanel() {
        return this.getTplKetteiJoho().getSakuseiPanel();
    }

    @JsonIgnore
    public void  setSakuseiPanel(SakuseiPanelDiv SakuseiPanel) {
        this.getTplKetteiJoho().setSakuseiPanel(SakuseiPanel);
    }

    @JsonIgnore
    public KokuhorenKetteiJohoPanel2Div getKokuhorenKetteiJohoPanel2() {
        return this.getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2();
    }

    @JsonIgnore
    public void  setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2Div KokuhorenKetteiJohoPanel2) {
        this.getTplKetteiJoho().getSakuseiPanel().setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.getTplKetteiJoho().getSakuseiPanel().getKokuhorenKetteiJohoPanel2().setTxtSakuseiYMD1(txtSakuseiYMD1);
    }

    @JsonIgnore
    public FurikomiMeisaiJohoPanelDiv getFurikomiMeisaiJohoPanel() {
        return this.getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel();
    }

    @JsonIgnore
    public void  setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanelDiv FurikomiMeisaiJohoPanel) {
        this.getTplKetteiJoho().getSakuseiPanel().setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.getTplKetteiJoho().getSakuseiPanel().getFurikomiMeisaiJohoPanel().setTxtSakuseiYMD2(txtSakuseiYMD2);
    }

    @JsonIgnore
    public KokuhorenSoufuJohoPanelDiv getKokuhorenSoufuJohoPanel() {
        return this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel();
    }

    @JsonIgnore
    public void  setKokuhorenSoufuJohoPanel(KokuhorenSoufuJohoPanelDiv KokuhorenSoufuJohoPanel) {
        this.getTplKetteiJoho().setKokuhorenSoufuJohoPanel(KokuhorenSoufuJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoUketoriYM() {
        return this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtTaisyoUketoriYM();
    }

    @JsonIgnore
    public void  setTxtTaisyoUketoriYM(TextBoxDate txtTaisyoUketoriYM) {
        this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtTaisyoUketoriYM(txtTaisyoUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKekkaSoufuYM() {
        return this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtKekkaSoufuYM();
    }

    @JsonIgnore
    public void  setTxtKekkaSoufuYM(TextBoxDate txtKekkaSoufuYM) {
        this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtKekkaSoufuYM(txtKekkaSoufuYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiSyaUketoriYM() {
        return this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().getTxtKetteiSyaUketoriYM();
    }

    @JsonIgnore
    public void  setTxtKetteiSyaUketoriYM(TextBoxDate txtKetteiSyaUketoriYM) {
        this.getTplKetteiJoho().getKokuhorenSoufuJohoPanel().setTxtKetteiSyaUketoriYM(txtKetteiSyaUketoriYM);
    }

    // </editor-fold>
}
