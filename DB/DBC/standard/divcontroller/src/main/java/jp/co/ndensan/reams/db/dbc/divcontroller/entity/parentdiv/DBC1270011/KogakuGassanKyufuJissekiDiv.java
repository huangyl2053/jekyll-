package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011;
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
 * KogakuGassanKyufuJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanKyufuJissekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("KogakuGassanKyufuJissekiList")
    private KogakuGassanKyufuJissekiListDiv KogakuGassanKyufuJissekiList;
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    private KogakuGassanKyufuJissekiDetailDiv KogakuGassanKyufuJissekiDetail;
    @JsonProperty("KogakuGassanKyufuJissekiKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanKyufuJissekiKaigoKihon;
    @JsonProperty("KogakuGassanKyufuJissekiKihon")
    private KaigoAtenaInfoDiv KogakuGassanKyufuJissekiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getKogakuGassanKyufuJissekiList
     * @return KogakuGassanKyufuJissekiList
     */
    @JsonProperty("KogakuGassanKyufuJissekiList")
    public KogakuGassanKyufuJissekiListDiv getKogakuGassanKyufuJissekiList() {
        return KogakuGassanKyufuJissekiList;
    }

    /*
     * setKogakuGassanKyufuJissekiList
     * @param KogakuGassanKyufuJissekiList KogakuGassanKyufuJissekiList
     */
    @JsonProperty("KogakuGassanKyufuJissekiList")
    public void setKogakuGassanKyufuJissekiList(KogakuGassanKyufuJissekiListDiv KogakuGassanKyufuJissekiList) {
        this.KogakuGassanKyufuJissekiList = KogakuGassanKyufuJissekiList;
    }

    /*
     * getKogakuGassanKyufuJissekiDetail
     * @return KogakuGassanKyufuJissekiDetail
     */
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    public KogakuGassanKyufuJissekiDetailDiv getKogakuGassanKyufuJissekiDetail() {
        return KogakuGassanKyufuJissekiDetail;
    }

    /*
     * setKogakuGassanKyufuJissekiDetail
     * @param KogakuGassanKyufuJissekiDetail KogakuGassanKyufuJissekiDetail
     */
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    public void setKogakuGassanKyufuJissekiDetail(KogakuGassanKyufuJissekiDetailDiv KogakuGassanKyufuJissekiDetail) {
        this.KogakuGassanKyufuJissekiDetail = KogakuGassanKyufuJissekiDetail;
    }

    /*
     * getKogakuGassanKyufuJissekiKaigoKihon
     * @return KogakuGassanKyufuJissekiKaigoKihon
     */
    @JsonProperty("KogakuGassanKyufuJissekiKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanKyufuJissekiKaigoKihon() {
        return KogakuGassanKyufuJissekiKaigoKihon;
    }

    /*
     * getKogakuGassanKyufuJissekiKihon
     * @return KogakuGassanKyufuJissekiKihon
     */
    @JsonProperty("KogakuGassanKyufuJissekiKihon")
    public IKaigoAtenaInfoDiv getKogakuGassanKyufuJissekiKihon() {
        return KogakuGassanKyufuJissekiKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkRirekiHyoji() {
        return this.getKogakuGassanKyufuJissekiList().getChkRirekiHyoji();
    }

    @JsonIgnore
    public void  setChkRirekiHyoji(CheckBoxList chkRirekiHyoji) {
        this.getKogakuGassanKyufuJissekiList().setChkRirekiHyoji(chkRirekiHyoji);
    }

    @JsonIgnore
    public DataGrid<dgRireki_Row> getDgRireki() {
        return this.getKogakuGassanKyufuJissekiList().getDgRireki();
    }

    @JsonIgnore
    public void  setDgRireki(DataGrid<dgRireki_Row> dgRireki) {
        this.getKogakuGassanKyufuJissekiList().setDgRireki(dgRireki);
    }

    @JsonIgnore
    public TextBox getTxtKokanShikibetsu() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtKokanShikibetsu();
    }

    @JsonIgnore
    public void  setTxtKokanShikibetsu(TextBox txtKokanShikibetsu) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtKokanShikibetsu(txtKokanShikibetsu);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseishoSeiriNO() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtShikyuShinseishoSeiriNO();
    }

    @JsonIgnore
    public void  setTxtShikyuShinseishoSeiriNO(TextBox txtShikyuShinseishoSeiriNO) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtShikyuShinseishoSeiriNO(txtShikyuShinseishoSeiriNO);
    }

    @JsonIgnore
    public TextBox getTxtJikofutangakuShomeishoSeiriNO() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtJikofutangakuShomeishoSeiriNO();
    }

    @JsonIgnore
    public void  setTxtJikofutangakuShomeishoSeiriNO(TextBox txtJikofutangakuShomeishoSeiriNO) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtJikofutangakuShomeishoSeiriNO(txtJikofutangakuShomeishoSeiriNO);
    }

    @JsonIgnore
    public TextBox getTxtSakuseiKBN() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtSakuseiKBN();
    }

    @JsonIgnore
    public void  setTxtSakuseiKBN(TextBox txtSakuseiKBN) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtSakuseiKBN(txtSakuseiKBN);
    }

    @JsonIgnore
    public TextBox getTxtHokeshaNO() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtHokeshaNO();
    }

    @JsonIgnore
    public void  setTxtHokeshaNO(TextBox txtHokeshaNO) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtHokeshaNO(txtHokeshaNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtJikofutangaku();
    }

    @JsonIgnore
    public void  setTxtJikofutangaku(TextBoxNum txtJikofutangaku) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtJikofutangaku(txtJikofutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyugaku() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtShikyugaku();
    }

    @JsonIgnore
    public void  setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtShikyugaku(txtShikyugaku);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getKogakuGassanKyufuJissekiDetail().getLinLine2();
    }

    @JsonIgnore
    public void  setLinLine2(HorizontalLine linLine2) {
        this.getKogakuGassanKyufuJissekiDetail().setLinLine2(linLine2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoriYMD() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtShoriYMD();
    }

    @JsonIgnore
    public void  setTxtShoriYMD(TextBoxDate txtShoriYMD) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtShoriYMD(txtShoriYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYMD() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtUketoriYMD();
    }

    @JsonIgnore
    public void  setTxtUketoriYMD(TextBoxDate txtUketoriYMD) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtUketoriYMD(txtUketoriYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtSoufuYMD() {
        return this.getKogakuGassanKyufuJissekiDetail().getTxtSoufuYMD();
    }

    @JsonIgnore
    public void  setTxtSoufuYMD(TextBoxDate txtSoufuYMD) {
        this.getKogakuGassanKyufuJissekiDetail().setTxtSoufuYMD(txtSoufuYMD);
    }

    @JsonIgnore
    public HorizontalLine getLinLine3() {
        return this.getKogakuGassanKyufuJissekiDetail().getLinLine3();
    }

    @JsonIgnore
    public void  setLinLine3(HorizontalLine linLine3) {
        this.getKogakuGassanKyufuJissekiDetail().setLinLine3(linLine3);
    }

    @JsonIgnore
    public Button getBtnKyufujissekiNiModoru() {
        return this.getKogakuGassanKyufuJissekiDetail().getBtnKyufujissekiNiModoru();
    }

    @JsonIgnore
    public void  setBtnKyufujissekiNiModoru(Button btnKyufujissekiNiModoru) {
        this.getKogakuGassanKyufuJissekiDetail().setBtnKyufujissekiNiModoru(btnKyufujissekiNiModoru);
    }

    // </editor-fold>
}
