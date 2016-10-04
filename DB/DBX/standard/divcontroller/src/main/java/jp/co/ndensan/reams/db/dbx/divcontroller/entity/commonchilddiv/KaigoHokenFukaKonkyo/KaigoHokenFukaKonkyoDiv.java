package jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KaigoHokenFukaKonkyo のクラスファイルです。
 *
 * @reamsid_L DBB-5723-010 xuxin
 */
public class KaigoHokenFukaKonkyoDiv extends Panel implements IKaigoHokenFukaKonkyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChoteiNendo")
    private DropDownList ddlChoteiNendo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("ddlTsuchishoNo")
    private DropDownList ddlTsuchishoNo;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBox txtShikibetsuCode;
    @JsonProperty("btnAfter")
    private Button btnAfter;
    @JsonProperty("btnBefore")
    private Button btnBefore;
    @JsonProperty("txtRirekiNo")
    private TextBox txtRirekiNo;
    @JsonProperty("tblFukaKonkyo")
    private tblFukaKonkyoDiv tblFukaKonkyo;
    @JsonProperty("spcKikan")
    private Space spcKikan;
    @JsonProperty("tblKikan")
    private tblKikanDiv tblKikan;
    @JsonProperty("txtChoteiJiyu1")
    private TextBox txtChoteiJiyu1;
    @JsonProperty("txtChoteiJiyu2")
    private TextBox txtChoteiJiyu2;
    @JsonProperty("txtChoteiJiyu3")
    private TextBox txtChoteiJiyu3;
    @JsonProperty("txtChoteiJiyu4")
    private TextBox txtChoteiJiyu4;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("識別コード")
    private RString 識別コード;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChoteiNendo
     * @return ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public DropDownList getDdlChoteiNendo() {
        return ddlChoteiNendo;
    }

    /*
     * setddlChoteiNendo
     * @param ddlChoteiNendo ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.ddlChoteiNendo = ddlChoteiNendo;
    }

    /*
     * getddlFukaNendo
     * @return ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    /*
     * setddlFukaNendo
     * @param ddlFukaNendo ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo = ddlFukaNendo;
    }

    /*
     * getddlTsuchishoNo
     * @return ddlTsuchishoNo
     */
    @JsonProperty("ddlTsuchishoNo")
    public DropDownList getDdlTsuchishoNo() {
        return ddlTsuchishoNo;
    }

    /*
     * setddlTsuchishoNo
     * @param ddlTsuchishoNo ddlTsuchishoNo
     */
    @JsonProperty("ddlTsuchishoNo")
    public void setDdlTsuchishoNo(DropDownList ddlTsuchishoNo) {
        this.ddlTsuchishoNo = ddlTsuchishoNo;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBox getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * getbtnAfter
     * @return btnAfter
     */
    @JsonProperty("btnAfter")
    public Button getBtnAfter() {
        return btnAfter;
    }

    /*
     * setbtnAfter
     * @param btnAfter btnAfter
     */
    @JsonProperty("btnAfter")
    public void setBtnAfter(Button btnAfter) {
        this.btnAfter = btnAfter;
    }

    /*
     * getbtnBefore
     * @return btnBefore
     */
    @JsonProperty("btnBefore")
    public Button getBtnBefore() {
        return btnBefore;
    }

    /*
     * setbtnBefore
     * @param btnBefore btnBefore
     */
    @JsonProperty("btnBefore")
    public void setBtnBefore(Button btnBefore) {
        this.btnBefore = btnBefore;
    }

    /*
     * gettxtRirekiNo
     * @return txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public TextBox getTxtRirekiNo() {
        return txtRirekiNo;
    }

    /*
     * settxtRirekiNo
     * @param txtRirekiNo txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public void setTxtRirekiNo(TextBox txtRirekiNo) {
        this.txtRirekiNo = txtRirekiNo;
    }

    /*
     * gettblFukaKonkyo
     * @return tblFukaKonkyo
     */
    @JsonProperty("tblFukaKonkyo")
    public tblFukaKonkyoDiv getTblFukaKonkyo() {
        return tblFukaKonkyo;
    }

    /*
     * settblFukaKonkyo
     * @param tblFukaKonkyo tblFukaKonkyo
     */
    @JsonProperty("tblFukaKonkyo")
    public void setTblFukaKonkyo(tblFukaKonkyoDiv tblFukaKonkyo) {
        this.tblFukaKonkyo = tblFukaKonkyo;
    }

    /*
     * getspcKikan
     * @return spcKikan
     */
    @JsonProperty("spcKikan")
    public Space getSpcKikan() {
        return spcKikan;
    }

    /*
     * setspcKikan
     * @param spcKikan spcKikan
     */
    @JsonProperty("spcKikan")
    public void setSpcKikan(Space spcKikan) {
        this.spcKikan = spcKikan;
    }

    /*
     * gettblKikan
     * @return tblKikan
     */
    @JsonProperty("tblKikan")
    public tblKikanDiv getTblKikan() {
        return tblKikan;
    }

    /*
     * settblKikan
     * @param tblKikan tblKikan
     */
    @JsonProperty("tblKikan")
    public void setTblKikan(tblKikanDiv tblKikan) {
        this.tblKikan = tblKikan;
    }

    /*
     * gettxtChoteiJiyu1
     * @return txtChoteiJiyu1
     */
    @JsonProperty("txtChoteiJiyu1")
    public TextBox getTxtChoteiJiyu1() {
        return txtChoteiJiyu1;
    }

    /*
     * settxtChoteiJiyu1
     * @param txtChoteiJiyu1 txtChoteiJiyu1
     */
    @JsonProperty("txtChoteiJiyu1")
    public void setTxtChoteiJiyu1(TextBox txtChoteiJiyu1) {
        this.txtChoteiJiyu1 = txtChoteiJiyu1;
    }

    /*
     * gettxtChoteiJiyu2
     * @return txtChoteiJiyu2
     */
    @JsonProperty("txtChoteiJiyu2")
    public TextBox getTxtChoteiJiyu2() {
        return txtChoteiJiyu2;
    }

    /*
     * settxtChoteiJiyu2
     * @param txtChoteiJiyu2 txtChoteiJiyu2
     */
    @JsonProperty("txtChoteiJiyu2")
    public void setTxtChoteiJiyu2(TextBox txtChoteiJiyu2) {
        this.txtChoteiJiyu2 = txtChoteiJiyu2;
    }

    /*
     * gettxtChoteiJiyu3
     * @return txtChoteiJiyu3
     */
    @JsonProperty("txtChoteiJiyu3")
    public TextBox getTxtChoteiJiyu3() {
        return txtChoteiJiyu3;
    }

    /*
     * settxtChoteiJiyu3
     * @param txtChoteiJiyu3 txtChoteiJiyu3
     */
    @JsonProperty("txtChoteiJiyu3")
    public void setTxtChoteiJiyu3(TextBox txtChoteiJiyu3) {
        this.txtChoteiJiyu3 = txtChoteiJiyu3;
    }

    /*
     * gettxtChoteiJiyu4
     * @return txtChoteiJiyu4
     */
    @JsonProperty("txtChoteiJiyu4")
    public TextBox getTxtChoteiJiyu4() {
        return txtChoteiJiyu4;
    }

    /*
     * settxtChoteiJiyu4
     * @param txtChoteiJiyu4 txtChoteiJiyu4
     */
    @JsonProperty("txtChoteiJiyu4")
    public void setTxtChoteiJiyu4(TextBox txtChoteiJiyu4) {
        this.txtChoteiJiyu4 = txtChoteiJiyu4;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * get識別コード
     * @return 識別コード
     */
    @JsonProperty("識別コード")
    public RString get識別コード() {
        return 識別コード;
    }

    /*
     * set識別コード
     * @param 識別コード 識別コード
     */
    @JsonProperty("識別コード")
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFukaKijunbi() {
        return this.getTblFukaKonkyo().getLblFukaKijunbi();
    }

    @JsonIgnore
    public Label getLblFukaKijunbiData() {
        return this.getTblFukaKonkyo().getLblFukaKijunbiData();
    }

    @JsonIgnore
    public Label getLblMaenendoHokenryoDankai() {
        return this.getTblFukaKonkyo().getLblMaenendoHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHonninKazei() {
        return this.getTblFukaKonkyo().getLblHonninKazei();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData1() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData1();
    }

    @JsonIgnore
    public Label getLblKarisanteiKeisanjoHokenryogaku() {
        return this.getTblFukaKonkyo().getLblKarisanteiKeisanjoHokenryogaku();
    }

    @JsonIgnore
    public Label getLblKeisanjoNenkanHokenryogaku() {
        return this.getTblFukaKonkyo().getLblKeisanjoNenkanHokenryogaku();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData6() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData6();
    }

    @JsonIgnore
    public Label getLblShikakuShutokubi() {
        return this.getTblFukaKonkyo().getLblShikakuShutokubi();
    }

    @JsonIgnore
    public Label getLblShikakuShutokubiData() {
        return this.getTblFukaKonkyo().getLblShikakuShutokubiData();
    }

    @JsonIgnore
    public Label getLblZennendoHokenryoRitsu() {
        return this.getTblFukaKonkyo().getLblZennendoHokenryoRitsu();
    }

    @JsonIgnore
    public Label getLblSetaiKazei() {
        return this.getTblFukaKonkyo().getLblSetaiKazei();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData2() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData2();
    }

    @JsonIgnore
    public Label getLblGenmengaku() {
        return this.getTblFukaKonkyo().getLblGenmengaku();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData7() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData7();
    }

    @JsonIgnore
    public Label getLblSoshitsubi() {
        return this.getTblFukaKonkyo().getLblSoshitsubi();
    }

    @JsonIgnore
    public Label getLblSoshitsubiData() {
        return this.getTblFukaKonkyo().getLblSoshitsubiData();
    }

    @JsonIgnore
    public Label getLblZennendoNengakuHokenryo() {
        return this.getTblFukaKonkyo().getLblZennendoNengakuHokenryo();
    }

    @JsonIgnore
    public Label getLblGokeiShotokuKingaku() {
        return this.getTblFukaKonkyo().getLblGokeiShotokuKingaku();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData3() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData3();
    }

    @JsonIgnore
    public Label getLblKarisanteiHokenryogaku() {
        return this.getTblFukaKonkyo().getLblKarisanteiHokenryogaku();
    }

    @JsonIgnore
    public Label getLblKakuteiNenkanHokenryogaku() {
        return this.getTblFukaKonkyo().getLblKakuteiNenkanHokenryogaku();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData8() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData8();
    }

    @JsonIgnore
    public Label getLblSeihoKaishibi() {
        return this.getTblFukaKonkyo().getLblSeihoKaishibi();
    }

    @JsonIgnore
    public Label getLblSeihoKaishibiData() {
        return this.getTblFukaKonkyo().getLblSeihoKaishibiData();
    }

    @JsonIgnore
    public Label getLblNenkinShunyugaku() {
        return this.getTblFukaKonkyo().getLblNenkinShunyugaku();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData4() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData4();
    }

    @JsonIgnore
    public Label getLblSeihoShuryobi() {
        return this.getTblFukaKonkyo().getLblSeihoShuryobi();
    }

    @JsonIgnore
    public Label getLblSeihoShuryobiData() {
        return this.getTblFukaKonkyo().getLblSeihoShuryobiData();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai() {
        return this.getTblFukaKonkyo().getLblHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblFukaKonkyoData5() {
        return this.getTblFukaKonkyo().getLblFukaKonkyoData5();
    }

    @JsonIgnore
    public Label getLblronenKaishibi() {
        return this.getTblFukaKonkyo().getLblronenKaishibi();
    }

    @JsonIgnore
    public Label getLblronenKaishibiData() {
        return this.getTblFukaKonkyo().getLblronenKaishibiData();
    }

    @JsonIgnore
    public Label getLblRonenShuryobi() {
        return this.getTblFukaKonkyo().getLblRonenShuryobi();
    }

    @JsonIgnore
    public Label getLblRonenShuryobiData() {
        return this.getTblFukaKonkyo().getLblRonenShuryobiData();
    }

    @JsonIgnore
    public Label getLblKikan() {
        return this.getTblKikan().getLblKikan();
    }

    @JsonIgnore
    public Label getLblGessu() {
        return this.getTblKikan().getLblGessu();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiKubun() {
        return this.getTblKikan().getLblHokenryoDankaiKubun();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu() {
        return this.getTblKikan().getLblHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsugaku() {
        return this.getTblKikan().getLblHokenryoSanshutsugaku();
    }

    @JsonIgnore
    public Label getLblKikanData1() {
        return this.getTblKikan().getLblKikanData1();
    }

    @JsonIgnore
    public Label getLblGessuData1() {
        return this.getTblKikan().getLblGessuData1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiKubunData1() {
        return this.getTblKikan().getLblHokenryoDankaiKubunData1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuData1() {
        return this.getTblKikan().getLblHokenryoritsuData1();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsugakuData1() {
        return this.getTblKikan().getLblHokenryoSanshutsugakuData1();
    }

    @JsonIgnore
    public Label getLblKikanData2() {
        return this.getTblKikan().getLblKikanData2();
    }

    @JsonIgnore
    public Label getLblGessuData2() {
        return this.getTblKikan().getLblGessuData2();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiKubunData2() {
        return this.getTblKikan().getLblHokenryoDankaiKubunData2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuData2() {
        return this.getTblKikan().getLblHokenryoritsuData2();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsugakuData2() {
        return this.getTblKikan().getLblHokenryoSanshutsugakuData2();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
