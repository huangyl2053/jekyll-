package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukoKisambiTokushuToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukoKisambiTokushuTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShunoJokyo")
    private ShunoJokyoDiv ShunoJokyo;
    @JsonProperty("JikoKisambi")
    private JikoKisambiDiv JikoKisambi;
    @JsonProperty("ccdShikakuKihon")
    private KaigoShikakuKihonDiv ccdShikakuKihon;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("hdnShoKisaiHokenshaNo")
    private RString hdnShoKisaiHokenshaNo;
    @JsonProperty("hdnChoteiNendo")
    private RString hdnChoteiNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShunoJokyo
     * @return ShunoJokyo
     */
    @JsonProperty("ShunoJokyo")
    public ShunoJokyoDiv getShunoJokyo() {
        return ShunoJokyo;
    }

    /*
     * setShunoJokyo
     * @param ShunoJokyo ShunoJokyo
     */
    @JsonProperty("ShunoJokyo")
    public void setShunoJokyo(ShunoJokyoDiv ShunoJokyo) {
        this.ShunoJokyo = ShunoJokyo;
    }

    /*
     * getJikoKisambi
     * @return JikoKisambi
     */
    @JsonProperty("JikoKisambi")
    public JikoKisambiDiv getJikoKisambi() {
        return JikoKisambi;
    }

    /*
     * setJikoKisambi
     * @param JikoKisambi JikoKisambi
     */
    @JsonProperty("JikoKisambi")
    public void setJikoKisambi(JikoKisambiDiv JikoKisambi) {
        this.JikoKisambi = JikoKisambi;
    }

    /*
     * getccdShikakuKihon
     * @return ccdShikakuKihon
     */
    @JsonProperty("ccdShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return ccdShikakuKihon;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * gethdnShoKisaiHokenshaNo
     * @return hdnShoKisaiHokenshaNo
     */
    @JsonProperty("hdnShoKisaiHokenshaNo")
    public RString getHdnShoKisaiHokenshaNo() {
        return hdnShoKisaiHokenshaNo;
    }

    /*
     * sethdnShoKisaiHokenshaNo
     * @param hdnShoKisaiHokenshaNo hdnShoKisaiHokenshaNo
     */
    @JsonProperty("hdnShoKisaiHokenshaNo")
    public void setHdnShoKisaiHokenshaNo(RString hdnShoKisaiHokenshaNo) {
        this.hdnShoKisaiHokenshaNo = hdnShoKisaiHokenshaNo;
    }

    /*
     * gethdnChoteiNendo
     * @return hdnChoteiNendo
     */
    @JsonProperty("hdnChoteiNendo")
    public RString getHdnChoteiNendo() {
        return hdnChoteiNendo;
    }

    /*
     * sethdnChoteiNendo
     * @param hdnChoteiNendo hdnChoteiNendo
     */
    @JsonProperty("hdnChoteiNendo")
    public void setHdnChoteiNendo(RString hdnChoteiNendo) {
        this.hdnChoteiNendo = hdnChoteiNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtTainoHanteiKijunDate() {
        return this.getShunoJokyo().getTxtTainoHanteiKijunDate();
    }

    @JsonIgnore
    public void  setTxtTainoHanteiKijunDate(TextBoxFlexibleDate txtTainoHanteiKijunDate) {
        this.getShunoJokyo().setTxtTainoHanteiKijunDate(txtTainoHanteiKijunDate);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getShunoJokyo().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getShunoJokyo().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgShunoJokyo_Row> getDgShunoJokyo() {
        return this.getShunoJokyo().getDgShunoJokyo();
    }

    @JsonIgnore
    public void  setDgShunoJokyo(DataGrid<dgShunoJokyo_Row> dgShunoJokyo) {
        this.getShunoJokyo().setDgShunoJokyo(dgShunoJokyo);
    }

    @JsonIgnore
    public CheckBoxList getChkZengyoHyoji() {
        return this.getJikoKisambi().getChkZengyoHyoji();
    }

    @JsonIgnore
    public void  setChkZengyoHyoji(CheckBoxList chkZengyoHyoji) {
        this.getJikoKisambi().setChkZengyoHyoji(chkZengyoHyoji);
    }

    @JsonIgnore
    public Label getLblHokenryoTitle() {
        return this.getJikoKisambi().getLblHokenryoTitle();
    }

    @JsonIgnore
    public void  setLblHokenryoTitle(Label lblHokenryoTitle) {
        this.getJikoKisambi().setLblHokenryoTitle(lblHokenryoTitle);
    }

    @JsonIgnore
    public DataGrid<dgJikoKisambi_Row> getDgJikoKisambi() {
        return this.getJikoKisambi().getDgJikoKisambi();
    }

    @JsonIgnore
    public void  setDgJikoKisambi(DataGrid<dgJikoKisambi_Row> dgJikoKisambi) {
        this.getJikoKisambi().setDgJikoKisambi(dgJikoKisambi);
    }

    @JsonIgnore
    public JikoKisaibiFukushaDiv getJikoKisaibiFukusha() {
        return this.getJikoKisambi().getJikoKisaibiFukusha();
    }

    @JsonIgnore
    public void  setJikoKisaibiFukusha(JikoKisaibiFukushaDiv JikoKisaibiFukusha) {
        this.getJikoKisambi().setJikoKisaibiFukusha(JikoKisaibiFukusha);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokushuJikoKisambi() {
        return this.getJikoKisambi().getJikoKisaibiFukusha().getTxtTokushuJikoKisambi();
    }

    @JsonIgnore
    public void  setTxtTokushuJikoKisambi(TextBoxFlexibleDate txtTokushuJikoKisambi) {
        this.getJikoKisambi().getJikoKisaibiFukusha().setTxtTokushuJikoKisambi(txtTokushuJikoKisambi);
    }

    @JsonIgnore
    public DropDownList getDdlFukushaJikoKisambiJiyu() {
        return this.getJikoKisambi().getJikoKisaibiFukusha().getDdlFukushaJikoKisambiJiyu();
    }

    @JsonIgnore
    public void  setDdlFukushaJikoKisambiJiyu(DropDownList ddlFukushaJikoKisambiJiyu) {
        this.getJikoKisambi().getJikoKisaibiFukusha().setDdlFukushaJikoKisambiJiyu(ddlFukushaJikoKisambiJiyu);
    }

    @JsonIgnore
    public Button getBtnIkkatsuFukusha() {
        return this.getJikoKisambi().getJikoKisaibiFukusha().getBtnIkkatsuFukusha();
    }

    @JsonIgnore
    public void  setBtnIkkatsuFukusha(Button btnIkkatsuFukusha) {
        this.getJikoKisambi().getJikoKisaibiFukusha().setBtnIkkatsuFukusha(btnIkkatsuFukusha);
    }

    @JsonIgnore
    public tblHanreiDiv getTblHanrei() {
        return this.getJikoKisambi().getTblHanrei();
    }

    @JsonIgnore
    public void  setTblHanrei(tblHanreiDiv tblHanrei) {
        this.getJikoKisambi().setTblHanrei(tblHanrei);
    }

    @JsonIgnore
    public tblColorKannoDiv getTblColorKanno() {
        return this.getJikoKisambi().getTblHanrei().getTblColorKanno();
    }

    @JsonIgnore
    public Label getLblDummyKanno() {
        return this.getJikoKisambi().getTblHanrei().getTblColorKanno().getLblDummyKanno();
    }

    @JsonIgnore
    public Label getLblKanno() {
        return this.getJikoKisambi().getTblHanrei().getLblKanno();
    }

    @JsonIgnore
    public tblColorMinoDiv getTblColorMino() {
        return this.getJikoKisambi().getTblHanrei().getTblColorMino();
    }

    @JsonIgnore
    public Label getLblDummyMino() {
        return this.getJikoKisambi().getTblHanrei().getTblColorMino().getLblDummyMino();
    }

    @JsonIgnore
    public Label getLblMino() {
        return this.getJikoKisambi().getTblHanrei().getLblMino();
    }

    @JsonIgnore
    public tblColorJikoDiv getTblColorJiko() {
        return this.getJikoKisambi().getTblHanrei().getTblColorJiko();
    }

    @JsonIgnore
    public Label getLblDummyJiko() {
        return this.getJikoKisambi().getTblHanrei().getTblColorJiko().getLblDummyJiko();
    }

    @JsonIgnore
    public Label getLblJiko() {
        return this.getJikoKisambi().getTblHanrei().getLblJiko();
    }

    @JsonIgnore
    public tblColorKanoDiv getTblColorKano() {
        return this.getJikoKisambi().getTblHanrei().getTblColorKano();
    }

    @JsonIgnore
    public Label getLblDummyKano() {
        return this.getJikoKisambi().getTblHanrei().getTblColorKano().getLblDummyKano();
    }

    @JsonIgnore
    public Label getLblKano() {
        return this.getJikoKisambi().getTblHanrei().getLblKano();
    }

    @JsonIgnore
    public tblColorJikoTaishoGaiDiv getTblColorJikoTaishoGai() {
        return this.getJikoKisambi().getTblHanrei().getTblColorJikoTaishoGai();
    }

    @JsonIgnore
    public Label getLblDummyJikoTaishoGai() {
        return this.getJikoKisambi().getTblHanrei().getTblColorJikoTaishoGai().getLblDummyJikoTaishoGai();
    }

    @JsonIgnore
    public Label getLblJikoTaishoGai() {
        return this.getJikoKisambi().getTblHanrei().getLblJikoTaishoGai();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getJikoKisambi().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getJikoKisambi().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getJikoKisambi().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getJikoKisambi().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getJikoKisambi().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getJikoKisambi().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
