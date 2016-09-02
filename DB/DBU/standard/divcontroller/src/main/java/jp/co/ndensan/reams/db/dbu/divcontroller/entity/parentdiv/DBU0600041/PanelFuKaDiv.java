package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * PanelFuKa のクラスファイル
 *
 * @author 自動生成
 */
public class PanelFuKaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelFukaJoho")
    private panelFukaJohoDiv panelFukaJoho;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoatenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoatenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelFukaJoho
     * @return panelFukaJoho
     */
    @JsonProperty("panelFukaJoho")
    public panelFukaJohoDiv getPanelFukaJoho() {
        return panelFukaJoho;
    }

    /*
     * setpanelFukaJoho
     * @param panelFukaJoho panelFukaJoho
     */
    @JsonProperty("panelFukaJoho")
    public void setPanelFukaJoho(panelFukaJohoDiv panelFukaJoho) {
        this.panelFukaJoho = panelFukaJoho;
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
     * getccdKaigoatenaInfo
     * @return ccdKaigoatenaInfo
     */
    @JsonProperty("ccdKaigoatenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoatenaInfo() {
        return ccdKaigoatenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtChouteiNendo() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTxtChouteiNendo();
    }

    @JsonIgnore
    public void setTxtChouteiNendo(TextBoxDate txtChouteiNendo) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setTxtChouteiNendo(txtChouteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaNendo() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public DropDownList getDdlTuutishoBango() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getDdlTuutishoBango();
    }

    @JsonIgnore
    public void setDdlTuutishoBango(DropDownList ddlTuutishoBango) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setDdlTuutishoBango(ddlTuutishoBango);
    }

    @JsonIgnore
    public TextBox getTxtNekinBango() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTxtNekinBango();
    }

    @JsonIgnore
    public void setTxtNekinBango(TextBox txtNekinBango) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setTxtNekinBango(txtNekinBango);
    }

    @JsonIgnore
    public TextBox getTxtNekinKodo() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTxtNekinKodo();
    }

    @JsonIgnore
    public void setTxtNekinKodo(TextBox txtNekinKodo) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setTxtNekinKodo(txtNekinKodo);
    }

    @JsonIgnore
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai();
    }

    @JsonIgnore
    public void setTblFukakonkyoMeisai(tblFukakonkyoMeisaiDiv tblFukakonkyoMeisai) {
        this.getPanelFukaJoho().getPanelFukaKonkyo().setTblFukakonkyoMeisai(tblFukakonkyoMeisai);
    }

    @JsonIgnore
    public Label getLblFukakonkyoMidashi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyoMidashi();
    }

    @JsonIgnore
    public Label getLblFukaKijunBi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblFukaKijunBi();
    }

    @JsonIgnore
    public Label getLblFukakijunYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakijunYMD();
    }

    @JsonIgnore
    public Label getLblHonninKazei() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankai() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHonninKazeiValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankaiValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblShikakuSyutokubi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuSyutokubi();
    }

    @JsonIgnore
    public Label getLblShikakuShutokuYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuShutokuYMD();
    }

    @JsonIgnore
    public Label getLblSetaiKazei() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsu() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblSetaiKazeiValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsuValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsuValue();
    }

    @JsonIgnore
    public Label getLblSoushitubi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSoushitubi();
    }

    @JsonIgnore
    public Label getLblShikakuSoshitsuYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public Label getLblShotokuSum() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSum();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryo() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryo();
    }

    @JsonIgnore
    public Label getLblShotokuSumValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSumValue();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryoValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryoValue();
    }

    @JsonIgnore
    public Label getLblSeihoKaishibi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoKaishibi();
    }

    @JsonIgnore
    public Label getLblSeihoKaishiYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoKaishiYMD();
    }

    @JsonIgnore
    public Label getLblNenkinShunyu() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyu();
    }

    @JsonIgnore
    public Label getLblNenkinShunyuValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyuValue();
    }

    @JsonIgnore
    public Label getLblSeihoSyuryobi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoSyuryobi();
    }

    @JsonIgnore
    public Label getLblSeihoShuryoYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoShuryoYMD();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiValue() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblRounenKaishibi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblRounenKaishibi();
    }

    @JsonIgnore
    public Label getLblRonenKaishiYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenKaishiYMD();
    }

    @JsonIgnore
    public Label getLblRounenSyuryobi() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblRounenSyuryobi();
    }

    @JsonIgnore
    public Label getLblRonenShuryoYMD() {
        return this.getPanelFukaJoho().getPanelFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenShuryoYMD();
    }

    @JsonIgnore
    public tblKiwarigakuDiv getTblKiwarigaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku();
    }

    @JsonIgnore
    public void setTblKiwarigaku(tblKiwarigakuDiv tblKiwarigaku) {
        this.getPanelFukaJoho().getPanelKiwarigaku().setTblKiwarigaku(tblKiwarigaku);
    }

    @JsonIgnore
    public Label getLblTokubetuCyousyuu() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuCyousyuu();
    }

    @JsonIgnore
    public Label getLblFutuCyousyu() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutuCyousyu();
    }

    @JsonIgnore
    public Label getLblGatu() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu();
    }

    @JsonIgnore
    public Label getLblTokubetuKi() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku();
    }

    @JsonIgnore
    public Label getLblFutsuKi() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku();
    }

    @JsonIgnore
    public Label getLblGatu4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu4();
    }

    @JsonIgnore
    public Label getLblTokubetuKi1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi1();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku4();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku4();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku4();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku4();
    }

    @JsonIgnore
    public Label getLblGatu5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu5();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku5();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku5();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku5();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku5();
    }

    @JsonIgnore
    public Label getLblGatu6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu6();
    }

    @JsonIgnore
    public Label getLblTokubetuKi2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi2();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku6();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku6();
    }

    @JsonIgnore
    public Label getLblFutsuKi1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi1();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku6();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku6();
    }

    @JsonIgnore
    public Label getLblGatu7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu7();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku7();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku7();
    }

    @JsonIgnore
    public Label getLblFutsuKi2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi2();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku7();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku7();
    }

    @JsonIgnore
    public Label getLblGatu8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu8();
    }

    @JsonIgnore
    public Label getLblTokubetuKi3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi3();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku8();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku8();
    }

    @JsonIgnore
    public Label getLblFutsuKi3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi3();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku8();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku8();
    }

    @JsonIgnore
    public Label getLblGatu9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu9();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku9();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku9();
    }

    @JsonIgnore
    public Label getLblFutsuKi4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi4();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku9();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku9();
    }

    @JsonIgnore
    public Label getLblGatu10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu10();
    }

    @JsonIgnore
    public Label getLblTokubetuKi4() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi4();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku10();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku10();
    }

    @JsonIgnore
    public Label getLblFutsuKi5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi5();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku10();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku10();
    }

    @JsonIgnore
    public Label getLblGatu11() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu11();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku11() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku11();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku11() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku11();
    }

    @JsonIgnore
    public Label getLblFutsuKi6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi6();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku11() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku11();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku11() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku11();
    }

    @JsonIgnore
    public Label getLblGatu12() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu12();
    }

    @JsonIgnore
    public Label getLblTokubetuKi5() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi5();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku12() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku12();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku12() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku12();
    }

    @JsonIgnore
    public Label getLblFutsuKi7() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi7();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku12() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku12();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku12() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku12();
    }

    @JsonIgnore
    public Label getLblGatu1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu1();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku1();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku1();
    }

    @JsonIgnore
    public Label getLblFutsuKi8() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi8();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku1();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku1() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku1();
    }

    @JsonIgnore
    public Label getLblGatu2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu2();
    }

    @JsonIgnore
    public Label getLblTokubetuKi6() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKi6();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku2();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku2();
    }

    @JsonIgnore
    public Label getLblFutsuKi9() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi9();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku2();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku2() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku2();
    }

    @JsonIgnore
    public Label getLblGatu3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu3();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku3();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku3();
    }

    @JsonIgnore
    public Label getLblFutsuKi10() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKi10();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku3();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku3() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku3();
    }

    @JsonIgnore
    public Label getLblGatu41() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu41();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku41() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku41();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku41() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku41();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku41() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku41();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku41() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku41();
    }

    @JsonIgnore
    public Label getLblGatu51() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGatu51();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku51() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugaku51();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku51() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugaku51();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku51() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugaku51();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku51() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugaku51();
    }

    @JsonIgnore
    public Label getLblGoukei() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGoukei();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugakuGoukei() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuKibetugakuGoukei();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugakuGoukei() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblTokubetuNouhugakuGoukei();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugakuGoukei() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuKibetugakuGoukei();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugakuGoukei() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblFutsuNouhugakuGoukei();
    }

    @JsonIgnore
    public Label getLblKeisanjouNenkanHokenryouGaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKeisanjouNenkanHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKariSanteiKeisanjouHokenryouGaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKariSanteiKeisanjouHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKeisanjouNenkanHokenryouGakuValue() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKeisanjouNenkanHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblKariSanteiKeisanjouHokenryouGakuValue() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKariSanteiKeisanjouHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblGenmenGaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGenmenGaku();
    }

    @JsonIgnore
    public Label getLblGenmenGakuValue() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblGenmenGakuValue();
    }

    @JsonIgnore
    public Label getLblKakuteiNenkanHokenryouGaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKakuteiNenkanHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKariSanteiHokenryouGaku() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKariSanteiHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKakuteiNenkanHokenryouGakuValue() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKakuteiNenkanHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblKariSanteiHokenryouGakuValue() {
        return this.getPanelFukaJoho().getPanelKiwarigaku().getTblKiwarigaku().getLblKariSanteiHokenryouGakuValue();
    }

    @JsonIgnore
    public tblKikan1Div getTblKikan1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1();
    }

    @JsonIgnore
    public void setTblKikan1(tblKikan1Div tblKikan1) {
        this.getPanelFukaJoho().getKikan().setTblKikan1(tblKikan1);
    }

    @JsonIgnore
    public Label getLblKikan() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblKikan();
    }

    @JsonIgnore
    public Label getLblTsukiSu() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblTsukiSu();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoSansyutsu();
    }

    @JsonIgnore
    public Label getLblKikan1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblKikan1();
    }

    @JsonIgnore
    public Label getLblTsukiSu1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblTsukiSu1();
    }

    @JsonIgnore
    public Label getLblShotokuDankai1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblShotokuDankai1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoritsu1();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu1() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoSansyutsu1();
    }

    @JsonIgnore
    public Label getLblKikan2() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblKikan2();
    }

    @JsonIgnore
    public Label getLblTsukiSu2() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblTsukiSu2();
    }

    @JsonIgnore
    public Label getLblShotokuDankai2() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblShotokuDankai2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu2() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoritsu2();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu2() {
        return this.getPanelFukaJoho().getKikan().getTblKikan1().getLblHokenryoSansyutsu2();
    }

    // </editor-fold>
}
