package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBU0600051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelAtena のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelAtenaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelJuuminKoyuuJoho")
    private panelJuuminKoyuuJohoDiv panelJuuminKoyuuJoho;
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
     * getpanelJuuminKoyuuJoho
     * @return panelJuuminKoyuuJoho
     */
    @JsonProperty("panelJuuminKoyuuJoho")
    public panelJuuminKoyuuJohoDiv getPanelJuuminKoyuuJoho() {
        return panelJuuminKoyuuJoho;
    }

    /*
     * setpanelJuuminKoyuuJoho
     * @param panelJuuminKoyuuJoho panelJuuminKoyuuJoho
     */
    @JsonProperty("panelJuuminKoyuuJoho")
    public void setPanelJuuminKoyuuJoho(panelJuuminKoyuuJohoDiv panelJuuminKoyuuJoho) {
        this.panelJuuminKoyuuJoho = panelJuuminKoyuuJoho;
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
    public Button getBtnShikakuInfo() {
        return this.getPanelJuuminKoyuuJoho().getBtnShikakuInfo();
    }

    @JsonIgnore
    public void  setBtnShikakuInfo(Button btnShikakuInfo) {
        this.getPanelJuuminKoyuuJoho().setBtnShikakuInfo(btnShikakuInfo);
    }

    @JsonIgnore
    public Button getBtnJukyuInfo() {
        return this.getPanelJuuminKoyuuJoho().getBtnJukyuInfo();
    }

    @JsonIgnore
    public void  setBtnJukyuInfo(Button btnJukyuInfo) {
        this.getPanelJuuminKoyuuJoho().setBtnJukyuInfo(btnJukyuInfo);
    }

    @JsonIgnore
    public Button getBtnKyufuInfo() {
        return this.getPanelJuuminKoyuuJoho().getBtnKyufuInfo();
    }

    @JsonIgnore
    public void  setBtnKyufuInfo(Button btnKyufuInfo) {
        this.getPanelJuuminKoyuuJoho().setBtnKyufuInfo(btnKyufuInfo);
    }

    @JsonIgnore
    public Button getBtnFukaInfo() {
        return this.getPanelJuuminKoyuuJoho().getBtnFukaInfo();
    }

    @JsonIgnore
    public void  setBtnFukaInfo(Button btnFukaInfo) {
        this.getPanelJuuminKoyuuJoho().setBtnFukaInfo(btnFukaInfo);
    }

    @JsonIgnore
    public Button getBtnJuminInfo() {
        return this.getPanelJuuminKoyuuJoho().getBtnJuminInfo();
    }

    @JsonIgnore
    public void  setBtnJuminInfo(Button btnJuminInfo) {
        this.getPanelJuuminKoyuuJoho().setBtnJuminInfo(btnJuminInfo);
    }

    @JsonIgnore
    public panelRoureiHukuNenkinJukyuushaJohoDiv getPanelRoureiHukuNenkinJukyuushaJoho() {
        return this.getPanelJuuminKoyuuJoho().getPanelRoureiHukuNenkinJukyuushaJoho();
    }

    @JsonIgnore
    public void  setPanelRoureiHukuNenkinJukyuushaJoho(panelRoureiHukuNenkinJukyuushaJohoDiv panelRoureiHukuNenkinJukyuushaJoho) {
        this.getPanelJuuminKoyuuJoho().setPanelRoureiHukuNenkinJukyuushaJoho(panelRoureiHukuNenkinJukyuushaJoho);
    }

    @JsonIgnore
    public TextBox getTxtRoureiJyukyuKaishibi() {
        return this.getPanelJuuminKoyuuJoho().getPanelRoureiHukuNenkinJukyuushaJoho().getTxtRoureiJyukyuKaishibi();
    }

    @JsonIgnore
    public void  setTxtRoureiJyukyuKaishibi(TextBox txtRoureiJyukyuKaishibi) {
        this.getPanelJuuminKoyuuJoho().getPanelRoureiHukuNenkinJukyuushaJoho().setTxtRoureiJyukyuKaishibi(txtRoureiJyukyuKaishibi);
    }

    @JsonIgnore
    public TextBox getTxtRoureiJukyuuHaishibi() {
        return this.getPanelJuuminKoyuuJoho().getPanelRoureiHukuNenkinJukyuushaJoho().getTxtRoureiJukyuuHaishibi();
    }

    @JsonIgnore
    public void  setTxtRoureiJukyuuHaishibi(TextBox txtRoureiJukyuuHaishibi) {
        this.getPanelJuuminKoyuuJoho().getPanelRoureiHukuNenkinJukyuushaJoho().setTxtRoureiJukyuuHaishibi(txtRoureiJukyuuHaishibi);
    }

    @JsonIgnore
    public panelSeikatuHogoJukyuushaJohoDiv getPanelSeikatuHogoJukyuushaJoho() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho();
    }

    @JsonIgnore
    public void  setPanelSeikatuHogoJukyuushaJoho(panelSeikatuHogoJukyuushaJohoDiv panelSeikatuHogoJukyuushaJoho) {
        this.getPanelJuuminKoyuuJoho().setPanelSeikatuHogoJukyuushaJoho(panelSeikatuHogoJukyuushaJoho);
    }

    @JsonIgnore
    public TextBox getTxtSeikatuHogoJyukyuKaishibi() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().getTxtSeikatuHogoJyukyuKaishibi();
    }

    @JsonIgnore
    public void  setTxtSeikatuHogoJyukyuKaishibi(TextBox txtSeikatuHogoJyukyuKaishibi) {
        this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().setTxtSeikatuHogoJyukyuKaishibi(txtSeikatuHogoJyukyuKaishibi);
    }

    @JsonIgnore
    public TextBox getTxtSeikatuHogoJukyuuHaishibi() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().getTxtSeikatuHogoJukyuuHaishibi();
    }

    @JsonIgnore
    public void  setTxtSeikatuHogoJukyuuHaishibi(TextBox txtSeikatuHogoJukyuuHaishibi) {
        this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().setTxtSeikatuHogoJukyuuHaishibi(txtSeikatuHogoJukyuuHaishibi);
    }

    @JsonIgnore
    public TextBox getTxtHujoShubetu() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().getTxtHujoShubetu();
    }

    @JsonIgnore
    public void  setTxtHujoShubetu(TextBox txtHujoShubetu) {
        this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().setTxtHujoShubetu(txtHujoShubetu);
    }

    @JsonIgnore
    public TextBox getTxtSeikatuHogoJyukyuTeishiKaishibi() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().getTxtSeikatuHogoJyukyuTeishiKaishibi();
    }

    @JsonIgnore
    public void  setTxtSeikatuHogoJyukyuTeishiKaishibi(TextBox txtSeikatuHogoJyukyuTeishiKaishibi) {
        this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().setTxtSeikatuHogoJyukyuTeishiKaishibi(txtSeikatuHogoJyukyuTeishiKaishibi);
    }

    @JsonIgnore
    public TextBox getTxtSeikatuHogoJukyuuHaishiSyuryobi() {
        return this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().getTxtSeikatuHogoJukyuuHaishiSyuryobi();
    }

    @JsonIgnore
    public void  setTxtSeikatuHogoJukyuuHaishiSyuryobi(TextBox txtSeikatuHogoJukyuuHaishiSyuryobi) {
        this.getPanelJuuminKoyuuJoho().getPanelSeikatuHogoJukyuushaJoho().setTxtSeikatuHogoJukyuuHaishiSyuryobi(txtSeikatuHogoJukyuuHaishiSyuryobi);
    }

    @JsonIgnore
    public panelKyoukaiSouKanriJohoDiv getPanelKyoukaiSouKanriJoho() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho();
    }

    @JsonIgnore
    public void  setPanelKyoukaiSouKanriJoho(panelKyoukaiSouKanriJohoDiv panelKyoukaiSouKanriJoho) {
        this.getPanelJuuminKoyuuJoho().setPanelKyoukaiSouKanriJoho(panelKyoukaiSouKanriJoho);
    }

    @JsonIgnore
    public RadioButton getRadKyuhuGengakuKisaiKaijo() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRadKyuhuGengakuKisaiKaijo();
    }

    @JsonIgnore
    public void  setRadKyuhuGengakuKisaiKaijo(RadioButton radKyuhuGengakuKisaiKaijo) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRadKyuhuGengakuKisaiKaijo(radKyuhuGengakuKisaiKaijo);
    }

    @JsonIgnore
    public RadioButton getRadHyoujunHutanGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRadHyoujunHutanGengaku();
    }

    @JsonIgnore
    public void  setRadHyoujunHutanGengaku(RadioButton radHyoujunHutanGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRadHyoujunHutanGengaku(radHyoujunHutanGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyoujunHutanGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getTxtHyoujunHutanGengaku();
    }

    @JsonIgnore
    public void  setTxtHyoujunHutanGengaku(TextBoxNum txtHyoujunHutanGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setTxtHyoujunHutanGengaku(txtHyoujunHutanGengaku);
    }

    @JsonIgnore
    public RadioButton getRadKyojuuHinadoHutanGakuGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRadKyojuuHinadoHutanGakuGengaku();
    }

    @JsonIgnore
    public void  setRadKyojuuHinadoHutanGakuGengaku(RadioButton radKyojuuHinadoHutanGakuGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRadKyojuuHinadoHutanGakuGengaku(radKyojuuHinadoHutanGakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getKyojuuHinadoShurui() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getKyojuuHinadoShurui();
    }

    @JsonIgnore
    public void  setKyojuuHinadoShurui(TextBoxNum KyojuuHinadoShurui) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setKyojuuHinadoShurui(KyojuuHinadoShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyojuuHinadoHutanGakuGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getTxtKyojuuHinadoHutanGakuGengaku();
    }

    @JsonIgnore
    public void  setTxtKyojuuHinadoHutanGakuGengaku(TextBoxNum txtKyojuuHinadoHutanGakuGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setTxtKyojuuHinadoHutanGakuGengaku(txtKyojuuHinadoHutanGakuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadShokuhiHutanGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRadShokuhiHutanGengaku();
    }

    @JsonIgnore
    public void  setRadShokuhiHutanGengaku(RadioButton radShokuhiHutanGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRadShokuhiHutanGengaku(radShokuhiHutanGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiHutanGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getTxtShokuhiHutanGengaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiHutanGengaku(TextBoxNum txtShokuhiHutanGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setTxtShokuhiHutanGengaku(txtShokuhiHutanGengaku);
    }

    @JsonIgnore
    public RadioButton getRadKougakuSabisuhiJougengakuGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRadKougakuSabisuhiJougengakuGengaku();
    }

    @JsonIgnore
    public void  setRadKougakuSabisuhiJougengakuGengaku(RadioButton radKougakuSabisuhiJougengakuGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRadKougakuSabisuhiJougengakuGengaku(radKougakuSabisuhiJougengakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtJougengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getTxtJougengaku();
    }

    @JsonIgnore
    public void  setTxtJougengaku(TextBoxNum txtJougengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setTxtJougengaku(txtJougengaku);
    }

    @JsonIgnore
    public RadioButton getRdoHokenryouNouhugakuGengaku() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getRdoHokenryouNouhugakuGengaku();
    }

    @JsonIgnore
    public void  setRdoHokenryouNouhugakuGengaku(RadioButton rdoHokenryouNouhugakuGengaku) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setRdoHokenryouNouhugakuGengaku(rdoHokenryouNouhugakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtTekiyouSuruShotokuDankai() {
        return this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().getTxtTekiyouSuruShotokuDankai();
    }

    @JsonIgnore
    public void  setTxtTekiyouSuruShotokuDankai(TextBoxNum txtTekiyouSuruShotokuDankai) {
        this.getPanelJuuminKoyuuJoho().getPanelKyoukaiSouKanriJoho().setTxtTekiyouSuruShotokuDankai(txtTekiyouSuruShotokuDankai);
    }

    // </editor-fold>
}
