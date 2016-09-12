package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanKyufuJissekiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanKyufuJissekiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokanShikibetsu")
    private TextBox txtKokanShikibetsu;
    @JsonProperty("txtShikyuShinseishoSeiriNO")
    private TextBox txtShikyuShinseishoSeiriNO;
    @JsonProperty("txtJikofutangakuShomeishoSeiriNO")
    private TextBox txtJikofutangakuShomeishoSeiriNO;
    @JsonProperty("txtSakuseiKBN")
    private TextBox txtSakuseiKBN;
    @JsonProperty("txtHokeshaNO")
    private TextBox txtHokeshaNO;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("txtJikofutangaku")
    private TextBoxNum txtJikofutangaku;
    @JsonProperty("txtShikyugaku")
    private TextBoxNum txtShikyugaku;
    @JsonProperty("linLine2")
    private HorizontalLine linLine2;
    @JsonProperty("txtShoriYMD")
    private TextBoxDate txtShoriYMD;
    @JsonProperty("txtUketoriYMD")
    private TextBoxDate txtUketoriYMD;
    @JsonProperty("txtSoufuYMD")
    private TextBoxDate txtSoufuYMD;
    @JsonProperty("linLine3")
    private HorizontalLine linLine3;
    @JsonProperty("btnKyufujissekiNiModoru")
    private Button btnKyufujissekiNiModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokanShikibetsu
     * @return txtKokanShikibetsu
     */
    @JsonProperty("txtKokanShikibetsu")
    public TextBox getTxtKokanShikibetsu() {
        return txtKokanShikibetsu;
    }

    /*
     * settxtKokanShikibetsu
     * @param txtKokanShikibetsu txtKokanShikibetsu
     */
    @JsonProperty("txtKokanShikibetsu")
    public void setTxtKokanShikibetsu(TextBox txtKokanShikibetsu) {
        this.txtKokanShikibetsu = txtKokanShikibetsu;
    }

    /*
     * gettxtShikyuShinseishoSeiriNO
     * @return txtShikyuShinseishoSeiriNO
     */
    @JsonProperty("txtShikyuShinseishoSeiriNO")
    public TextBox getTxtShikyuShinseishoSeiriNO() {
        return txtShikyuShinseishoSeiriNO;
    }

    /*
     * settxtShikyuShinseishoSeiriNO
     * @param txtShikyuShinseishoSeiriNO txtShikyuShinseishoSeiriNO
     */
    @JsonProperty("txtShikyuShinseishoSeiriNO")
    public void setTxtShikyuShinseishoSeiriNO(TextBox txtShikyuShinseishoSeiriNO) {
        this.txtShikyuShinseishoSeiriNO = txtShikyuShinseishoSeiriNO;
    }

    /*
     * gettxtJikofutangakuShomeishoSeiriNO
     * @return txtJikofutangakuShomeishoSeiriNO
     */
    @JsonProperty("txtJikofutangakuShomeishoSeiriNO")
    public TextBox getTxtJikofutangakuShomeishoSeiriNO() {
        return txtJikofutangakuShomeishoSeiriNO;
    }

    /*
     * settxtJikofutangakuShomeishoSeiriNO
     * @param txtJikofutangakuShomeishoSeiriNO txtJikofutangakuShomeishoSeiriNO
     */
    @JsonProperty("txtJikofutangakuShomeishoSeiriNO")
    public void setTxtJikofutangakuShomeishoSeiriNO(TextBox txtJikofutangakuShomeishoSeiriNO) {
        this.txtJikofutangakuShomeishoSeiriNO = txtJikofutangakuShomeishoSeiriNO;
    }

    /*
     * gettxtSakuseiKBN
     * @return txtSakuseiKBN
     */
    @JsonProperty("txtSakuseiKBN")
    public TextBox getTxtSakuseiKBN() {
        return txtSakuseiKBN;
    }

    /*
     * settxtSakuseiKBN
     * @param txtSakuseiKBN txtSakuseiKBN
     */
    @JsonProperty("txtSakuseiKBN")
    public void setTxtSakuseiKBN(TextBox txtSakuseiKBN) {
        this.txtSakuseiKBN = txtSakuseiKBN;
    }

    /*
     * gettxtHokeshaNO
     * @return txtHokeshaNO
     */
    @JsonProperty("txtHokeshaNO")
    public TextBox getTxtHokeshaNO() {
        return txtHokeshaNO;
    }

    /*
     * settxtHokeshaNO
     * @param txtHokeshaNO txtHokeshaNO
     */
    @JsonProperty("txtHokeshaNO")
    public void setTxtHokeshaNO(TextBox txtHokeshaNO) {
        this.txtHokeshaNO = txtHokeshaNO;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtJikofutangaku
     * @return txtJikofutangaku
     */
    @JsonProperty("txtJikofutangaku")
    public TextBoxNum getTxtJikofutangaku() {
        return txtJikofutangaku;
    }

    /*
     * settxtJikofutangaku
     * @param txtJikofutangaku txtJikofutangaku
     */
    @JsonProperty("txtJikofutangaku")
    public void setTxtJikofutangaku(TextBoxNum txtJikofutangaku) {
        this.txtJikofutangaku = txtJikofutangaku;
    }

    /*
     * gettxtShikyugaku
     * @return txtShikyugaku
     */
    @JsonProperty("txtShikyugaku")
    public TextBoxNum getTxtShikyugaku() {
        return txtShikyugaku;
    }

    /*
     * settxtShikyugaku
     * @param txtShikyugaku txtShikyugaku
     */
    @JsonProperty("txtShikyugaku")
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.txtShikyugaku = txtShikyugaku;
    }

    /*
     * getlinLine2
     * @return linLine2
     */
    @JsonProperty("linLine2")
    public HorizontalLine getLinLine2() {
        return linLine2;
    }

    /*
     * setlinLine2
     * @param linLine2 linLine2
     */
    @JsonProperty("linLine2")
    public void setLinLine2(HorizontalLine linLine2) {
        this.linLine2 = linLine2;
    }

    /*
     * gettxtShoriYMD
     * @return txtShoriYMD
     */
    @JsonProperty("txtShoriYMD")
    public TextBoxDate getTxtShoriYMD() {
        return txtShoriYMD;
    }

    /*
     * settxtShoriYMD
     * @param txtShoriYMD txtShoriYMD
     */
    @JsonProperty("txtShoriYMD")
    public void setTxtShoriYMD(TextBoxDate txtShoriYMD) {
        this.txtShoriYMD = txtShoriYMD;
    }

    /*
     * gettxtUketoriYMD
     * @return txtUketoriYMD
     */
    @JsonProperty("txtUketoriYMD")
    public TextBoxDate getTxtUketoriYMD() {
        return txtUketoriYMD;
    }

    /*
     * settxtUketoriYMD
     * @param txtUketoriYMD txtUketoriYMD
     */
    @JsonProperty("txtUketoriYMD")
    public void setTxtUketoriYMD(TextBoxDate txtUketoriYMD) {
        this.txtUketoriYMD = txtUketoriYMD;
    }

    /*
     * gettxtSoufuYMD
     * @return txtSoufuYMD
     */
    @JsonProperty("txtSoufuYMD")
    public TextBoxDate getTxtSoufuYMD() {
        return txtSoufuYMD;
    }

    /*
     * settxtSoufuYMD
     * @param txtSoufuYMD txtSoufuYMD
     */
    @JsonProperty("txtSoufuYMD")
    public void setTxtSoufuYMD(TextBoxDate txtSoufuYMD) {
        this.txtSoufuYMD = txtSoufuYMD;
    }

    /*
     * getlinLine3
     * @return linLine3
     */
    @JsonProperty("linLine3")
    public HorizontalLine getLinLine3() {
        return linLine3;
    }

    /*
     * setlinLine3
     * @param linLine3 linLine3
     */
    @JsonProperty("linLine3")
    public void setLinLine3(HorizontalLine linLine3) {
        this.linLine3 = linLine3;
    }

    /*
     * getbtnKyufujissekiNiModoru
     * @return btnKyufujissekiNiModoru
     */
    @JsonProperty("btnKyufujissekiNiModoru")
    public Button getBtnKyufujissekiNiModoru() {
        return btnKyufujissekiNiModoru;
    }

    /*
     * setbtnKyufujissekiNiModoru
     * @param btnKyufujissekiNiModoru btnKyufujissekiNiModoru
     */
    @JsonProperty("btnKyufujissekiNiModoru")
    public void setBtnKyufujissekiNiModoru(Button btnKyufujissekiNiModoru) {
        this.btnKyufujissekiNiModoru = btnKyufujissekiNiModoru;
    }

    // </editor-fold>
}
