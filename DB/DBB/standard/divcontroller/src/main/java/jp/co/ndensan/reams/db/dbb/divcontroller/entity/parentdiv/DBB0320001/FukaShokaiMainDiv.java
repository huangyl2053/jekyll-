package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku.IKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaShokaiMain のクラスファイル
 *
 * @author 自動生成
 */
public class FukaShokaiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DBB0320001KihonJoho")
    private DBB0320001KihonJohoDiv DBB0320001KihonJoho;
    @JsonProperty("FukaShokaiControl")
    private FukaShokaiControlDiv FukaShokaiControl;
    @JsonProperty("FukaRirekiAllPanel")
    private FukaRirekiAllPanelDiv FukaRirekiAllPanel;
    @JsonProperty("FukaRirekiPanel")
    private FukaRirekiPanelDiv FukaRirekiPanel;
    @JsonProperty("FukakonkyoAndKiwari")
    private FukakonkyoAndKiwariDiv FukakonkyoAndKiwari;
    @JsonProperty("hdnMode")
    private RString hdnMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDBB0320001KihonJoho
     * @return DBB0320001KihonJoho
     */
    @JsonProperty("DBB0320001KihonJoho")
    public DBB0320001KihonJohoDiv getDBB0320001KihonJoho() {
        return DBB0320001KihonJoho;
    }

    /*
     * setDBB0320001KihonJoho
     * @param DBB0320001KihonJoho DBB0320001KihonJoho
     */
    @JsonProperty("DBB0320001KihonJoho")
    public void setDBB0320001KihonJoho(DBB0320001KihonJohoDiv DBB0320001KihonJoho) {
        this.DBB0320001KihonJoho = DBB0320001KihonJoho;
    }

    /*
     * getFukaShokaiControl
     * @return FukaShokaiControl
     */
    @JsonProperty("FukaShokaiControl")
    public FukaShokaiControlDiv getFukaShokaiControl() {
        return FukaShokaiControl;
    }

    /*
     * setFukaShokaiControl
     * @param FukaShokaiControl FukaShokaiControl
     */
    @JsonProperty("FukaShokaiControl")
    public void setFukaShokaiControl(FukaShokaiControlDiv FukaShokaiControl) {
        this.FukaShokaiControl = FukaShokaiControl;
    }

    /*
     * getFukaRirekiAllPanel
     * @return FukaRirekiAllPanel
     */
    @JsonProperty("FukaRirekiAllPanel")
    public FukaRirekiAllPanelDiv getFukaRirekiAllPanel() {
        return FukaRirekiAllPanel;
    }

    /*
     * setFukaRirekiAllPanel
     * @param FukaRirekiAllPanel FukaRirekiAllPanel
     */
    @JsonProperty("FukaRirekiAllPanel")
    public void setFukaRirekiAllPanel(FukaRirekiAllPanelDiv FukaRirekiAllPanel) {
        this.FukaRirekiAllPanel = FukaRirekiAllPanel;
    }

    /*
     * getFukaRirekiPanel
     * @return FukaRirekiPanel
     */
    @JsonProperty("FukaRirekiPanel")
    public FukaRirekiPanelDiv getFukaRirekiPanel() {
        return FukaRirekiPanel;
    }

    /*
     * setFukaRirekiPanel
     * @param FukaRirekiPanel FukaRirekiPanel
     */
    @JsonProperty("FukaRirekiPanel")
    public void setFukaRirekiPanel(FukaRirekiPanelDiv FukaRirekiPanel) {
        this.FukaRirekiPanel = FukaRirekiPanel;
    }

    /*
     * getFukakonkyoAndKiwari
     * @return FukakonkyoAndKiwari
     */
    @JsonProperty("FukakonkyoAndKiwari")
    public FukakonkyoAndKiwariDiv getFukakonkyoAndKiwari() {
        return FukakonkyoAndKiwari;
    }

    /*
     * setFukakonkyoAndKiwari
     * @param FukakonkyoAndKiwari FukakonkyoAndKiwari
     */
    @JsonProperty("FukakonkyoAndKiwari")
    public void setFukakonkyoAndKiwari(FukakonkyoAndKiwariDiv FukakonkyoAndKiwari) {
        this.FukakonkyoAndKiwari = FukakonkyoAndKiwari;
    }

    /*
     * gethdnMode
     * @return hdnMode
     */
    @JsonProperty("hdnMode")
    public RString getHdnMode() {
        return hdnMode;
    }

    /*
     * sethdnMode
     * @param hdnMode hdnMode
     */
    @JsonProperty("hdnMode")
    public void setHdnMode(RString hdnMode) {
        this.hdnMode = hdnMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoFukaKihonDiv getCcdKaigoFukaKihon() {
        return this.getDBB0320001KihonJoho().getCcdKaigoFukaKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getDBB0320001KihonJoho().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return this.getFukaShokaiControl().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.getFukaShokaiControl().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtFukaNendo() {
        return this.getFukaShokaiControl().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxFlexibleYear txtFukaNendo) {
        this.getFukaShokaiControl().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public TextBox getTxtKoseiM() {
        return this.getFukaShokaiControl().getTxtKoseiM();
    }

    @JsonIgnore
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.getFukaShokaiControl().setTxtKoseiM(txtKoseiM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKoseiYMD() {
        return this.getFukaShokaiControl().getTxtKoseiYMD();
    }

    @JsonIgnore
    public void setTxtKoseiYMD(TextBoxFlexibleDate txtKoseiYMD) {
        this.getFukaShokaiControl().setTxtKoseiYMD(txtKoseiYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtKoseiTime() {
        return this.getFukaShokaiControl().getTxtKoseiTime();
    }

    @JsonIgnore
    public void setTxtKoseiTime(TextBoxTime txtKoseiTime) {
        this.getFukaShokaiControl().setTxtKoseiTime(txtKoseiTime);
    }

    @JsonIgnore
    public Button getBtnRirekiHyoji() {
        return this.getFukaShokaiControl().getBtnRirekiHyoji();
    }

    @JsonIgnore
    public void setBtnRirekiHyoji(Button btnRirekiHyoji) {
        this.getFukaShokaiControl().setBtnRirekiHyoji(btnRirekiHyoji);
    }

    @JsonIgnore
    public Button getBtnFukakonkyoKiwari() {
        return this.getFukaShokaiControl().getBtnFukakonkyoKiwari();
    }

    @JsonIgnore
    public void setBtnFukakonkyoKiwari(Button btnFukakonkyoKiwari) {
        this.getFukaShokaiControl().setBtnFukakonkyoKiwari(btnFukakonkyoKiwari);
    }

    @JsonIgnore
    public Button getBtnSetaiinShotoku() {
        return this.getFukaShokaiControl().getBtnSetaiinShotoku();
    }

    @JsonIgnore
    public void setBtnSetaiinShotoku(Button btnSetaiinShotoku) {
        this.getFukaShokaiControl().setBtnSetaiinShotoku(btnSetaiinShotoku);
    }

    @JsonIgnore
    public Button getBtnTokucho() {
        return this.getFukaShokaiControl().getBtnTokucho();
    }

    @JsonIgnore
    public void setBtnTokucho(Button btnTokucho) {
        this.getFukaShokaiControl().setBtnTokucho(btnTokucho);
    }

    @JsonIgnore
    public Button getBtnGemmen() {
        return this.getFukaShokaiControl().getBtnGemmen();
    }

    @JsonIgnore
    public void setBtnGemmen(Button btnGemmen) {
        this.getFukaShokaiControl().setBtnGemmen(btnGemmen);
    }

    @JsonIgnore
    public IFukaRirekiAllDiv getCcdFukaRirekiAll() {
        return this.getFukaRirekiAllPanel().getCcdFukaRirekiAll();
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtFukaNendoFukaRireki() {
        return this.getFukaRirekiPanel().getTxtFukaNendoFukaRireki();
    }

    @JsonIgnore
    public void setTxtFukaNendoFukaRireki(TextBoxFlexibleYear txtFukaNendoFukaRireki) {
        this.getFukaRirekiPanel().setTxtFukaNendoFukaRireki(txtFukaNendoFukaRireki);
    }

    @JsonIgnore
    public DataGrid<dgFukaRirekiFukaRireki_Row> getDgFukaRirekiFukaRireki() {
        return this.getFukaRirekiPanel().getDgFukaRirekiFukaRireki();
    }

    @JsonIgnore
    public void setDgFukaRirekiFukaRireki(DataGrid<dgFukaRirekiFukaRireki_Row> dgFukaRirekiFukaRireki) {
        this.getFukaRirekiPanel().setDgFukaRirekiFukaRireki(dgFukaRirekiFukaRireki);
    }

    @JsonIgnore
    public tblFukaKonkyoDiv getTblFukaKonkyo() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo();
    }

    @JsonIgnore
    public void setTblFukaKonkyo(tblFukaKonkyoDiv tblFukaKonkyo) {
        this.getFukakonkyoAndKiwari().setTblFukaKonkyo(tblFukaKonkyo);
    }

    @JsonIgnore
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai();
    }

    @JsonIgnore
    public Label getLblFukakonkyoMidashi() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyoMidashi();
    }

    @JsonIgnore
    public Label getLblFukakonkyo11() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo11();
    }

    @JsonIgnore
    public Label getLblFukakijunYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakijunYMD();
    }

    @JsonIgnore
    public Label getLblHonninKazei() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankai() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHonninKazeiValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankaiValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo12() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo12();
    }

    @JsonIgnore
    public Label getLblShikakuShutokuYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuShutokuYMD();
    }

    @JsonIgnore
    public Label getLblSetaiKazei() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsu() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblSetaiKazeiValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsuValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsuValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo13() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo13();
    }

    @JsonIgnore
    public Label getLblShikakuSoshitsuYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public Label getLblShotokuSum() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSum();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryo() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryo();
    }

    @JsonIgnore
    public Label getLblShotokuSumValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSumValue();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryoValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryoValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo14() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo14();
    }

    @JsonIgnore
    public Label getLblSeihoKaishiYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoKaishiYMD();
    }

    @JsonIgnore
    public Label getLblNenkinShunyu() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyu();
    }

    @JsonIgnore
    public Label getLblNenkinShunyuValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyuValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo15() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo15();
    }

    @JsonIgnore
    public Label getLblSeihoShuryoYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoShuryoYMD();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiValue() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo16() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo16();
    }

    @JsonIgnore
    public Label getLblRonenKaishiYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenKaishiYMD();
    }

    @JsonIgnore
    public Label getLbldamy1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLbldamy1();
    }

    @JsonIgnore
    public Label getLblFukakonkyo17() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo17();
    }

    @JsonIgnore
    public Label getLblRonenShuryoYMD() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenShuryoYMD();
    }

    @JsonIgnore
    public Label getLblDamy() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getLblDamy();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiKeisanjoHokenryoGaku() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtZanteiKeisanjoHokenryoGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGemmenGaku() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtZanteiGemmenGaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiHokenryoGaku() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtZanteiHokenryoGaku();
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigaku() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getCcdKiwarigaku();
    }

    @JsonIgnore
    public KikanDiv getKikan() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan();
    }

    @JsonIgnore
    public tblKikan1Div getTblKikan1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1();
    }

    @JsonIgnore
    public void setTblKikan1(tblKikan1Div tblKikan1) {
        this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().setTblKikan1(tblKikan1);
    }

    @JsonIgnore
    public Label getLblKikan() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblKikan();
    }

    @JsonIgnore
    public Label getLblTsukiSu() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblTsukiSu();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblHokenryoSansyutsu();
    }

    @JsonIgnore
    public Label getLblKikan1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblKikan1();
    }

    @JsonIgnore
    public Label getLblTsukiSu1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblTsukiSu1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblHokenryoDankai1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblHokenryoritsu1();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan1().getLblHokenryoSansyutsu1();
    }

    @JsonIgnore
    public tblKikan2Div getTblKikan2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2();
    }

    @JsonIgnore
    public void setTblKikan2(tblKikan2Div tblKikan2) {
        this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().setTblKikan2(tblKikan2);
    }

    @JsonIgnore
    public Label getLblKikan2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2().getLblKikan2();
    }

    @JsonIgnore
    public Label getLblTsukiSu2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2().getLblTsukiSu2();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2().getLblHokenryoDankai2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2().getLblHokenryoritsu2();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getKikan().getTblKikan2().getLblHokenryoSansyutsu2();
    }

    @JsonIgnore
    public FukakonkyoNengakuDiv getFukakonkyoNengaku() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getFukakonkyoNengaku();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu1() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu1();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu2() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu2();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu3() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu3();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu4() {
        return this.getFukakonkyoAndKiwari().getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu4();
    }

    // </editor-fold>
}
