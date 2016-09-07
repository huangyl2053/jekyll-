package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * KetteiHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiHokenshaShukeiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private tbrCellHokenshaShukeiAtKetteiHokenshaShukei tbrCellHokenshaShukei;
    @JsonProperty("tbrCellHokenshaKensu")
    private tbrCellHokenshaKensuAtKetteiHokenshaShukei tbrCellHokenshaKensu;
    @JsonProperty("tbrCellHokenshaTanisuHiyogaku")
    private tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei tbrCellHokenshaTanisuHiyogaku;
    @JsonProperty("tbrCellHokenshaFutangaku")
    private tbrCellHokenshaFutangakuAtKetteiHokenshaShukei tbrCellHokenshaFutangaku;
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi;
    @JsonProperty("tbrCellHokensha11")
    private tbrCellHokensha11AtKetteiHokenshaShukei tbrCellHokensha11;
    @JsonProperty("tbrCellHokensha12")
    private tbrCellHokensha12AtKetteiHokenshaShukei tbrCellHokensha12;
    @JsonProperty("tbrCellHokensha13")
    private tbrCellHokensha13AtKetteiHokenshaShukei tbrCellHokensha13;
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi;
    @JsonProperty("tbrCellHokensha21")
    private tbrCellHokensha21AtKetteiHokenshaShukei tbrCellHokensha21;
    @JsonProperty("tbrCellHokensha22")
    private tbrCellHokensha22AtKetteiHokenshaShukei tbrCellHokensha22;
    @JsonProperty("tbrCellHokensha23")
    private tbrCellHokensha23AtKetteiHokenshaShukei tbrCellHokensha23;
    @JsonProperty("tbrCellHokenshaTokuteinyushoshaKaigo")
    private tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei tbrCellHokenshaTokuteinyushoshaKaigo;
    @JsonProperty("tbrCellHokensha31")
    private tbrCellHokensha31AtKetteiHokenshaShukei tbrCellHokensha31;
    @JsonProperty("tbrCellHokensha32")
    private tbrCellHokensha32AtKetteiHokenshaShukei tbrCellHokensha32;
    @JsonProperty("tbrCellHokensha33")
    private tbrCellHokensha33AtKetteiHokenshaShukei tbrCellHokensha33;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return this.tbrCellHokenshaShukei.getTxtKetteiHokenshaSakuseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlRirekiNo1() {
        return this.tbrCellHokenshaShukei.getDdlRirekiNo1();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKensu() {
        return this.tbrCellHokenshaKensu.getLblKetteihokenshaKensu();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return this.tbrCellHokenshaTanisuHiyogaku.getLblKetteihokenshaTanisuHiyogaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return this.tbrCellHokenshaFutangaku.getLblKetteihokenshaHokenshaFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.tbrCellHokenshaKyufuhi.getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell11() {
        return this.tbrCellHokensha11.getTxtHokenshaCell11();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell12() {
        return this.tbrCellHokensha12.getTxtHokenshaCell12();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell13() {
        return this.tbrCellHokensha13.getTxtHokenshaCell13();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.tbrCellHokenshaKogakuServicehi.getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell21() {
        return this.tbrCellHokensha21.getTxtHokenshaCell21();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell22() {
        return this.tbrCellHokensha22.getTxtHokenshaCell22();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell23() {
        return this.tbrCellHokensha23.getTxtHokenshaCell23();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTokuteiNyushoshaKaigo() {
        return this.tbrCellHokenshaTokuteinyushoshaKaigo.getLblKetteihokenshaTokuteiNyushoshaKaigo();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell31() {
        return this.tbrCellHokensha31.getTxtHokenshaCell31();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell32() {
        return this.tbrCellHokensha32.getTxtHokenshaCell32();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell33() {
        return this.tbrCellHokensha33.getTxtHokenshaCell33();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbrCellHokenshaShukei
     * @return tbrCellHokenshaShukei
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private tbrCellHokenshaShukeiAtKetteiHokenshaShukei getTbrCellHokenshaShukei() {
        return tbrCellHokenshaShukei;
    }

    /*
     * settbrCellHokenshaShukei
     * @param tbrCellHokenshaShukei tbrCellHokenshaShukei
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private void setTbrCellHokenshaShukei(tbrCellHokenshaShukeiAtKetteiHokenshaShukei tbrCellHokenshaShukei) {
        this.tbrCellHokenshaShukei = tbrCellHokenshaShukei;
    }

    /*
     * gettbrCellHokenshaKensu
     * @return tbrCellHokenshaKensu
     */
    @JsonProperty("tbrCellHokenshaKensu")
    private tbrCellHokenshaKensuAtKetteiHokenshaShukei getTbrCellHokenshaKensu() {
        return tbrCellHokenshaKensu;
    }

    /*
     * settbrCellHokenshaKensu
     * @param tbrCellHokenshaKensu tbrCellHokenshaKensu
     */
    @JsonProperty("tbrCellHokenshaKensu")
    private void setTbrCellHokenshaKensu(tbrCellHokenshaKensuAtKetteiHokenshaShukei tbrCellHokenshaKensu) {
        this.tbrCellHokenshaKensu = tbrCellHokenshaKensu;
    }

    /*
     * gettbrCellHokenshaTanisuHiyogaku
     * @return tbrCellHokenshaTanisuHiyogaku
     */
    @JsonProperty("tbrCellHokenshaTanisuHiyogaku")
    private tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei getTbrCellHokenshaTanisuHiyogaku() {
        return tbrCellHokenshaTanisuHiyogaku;
    }

    /*
     * settbrCellHokenshaTanisuHiyogaku
     * @param tbrCellHokenshaTanisuHiyogaku tbrCellHokenshaTanisuHiyogaku
     */
    @JsonProperty("tbrCellHokenshaTanisuHiyogaku")
    private void setTbrCellHokenshaTanisuHiyogaku(tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei tbrCellHokenshaTanisuHiyogaku) {
        this.tbrCellHokenshaTanisuHiyogaku = tbrCellHokenshaTanisuHiyogaku;
    }

    /*
     * gettbrCellHokenshaFutangaku
     * @return tbrCellHokenshaFutangaku
     */
    @JsonProperty("tbrCellHokenshaFutangaku")
    private tbrCellHokenshaFutangakuAtKetteiHokenshaShukei getTbrCellHokenshaFutangaku() {
        return tbrCellHokenshaFutangaku;
    }

    /*
     * settbrCellHokenshaFutangaku
     * @param tbrCellHokenshaFutangaku tbrCellHokenshaFutangaku
     */
    @JsonProperty("tbrCellHokenshaFutangaku")
    private void setTbrCellHokenshaFutangaku(tbrCellHokenshaFutangakuAtKetteiHokenshaShukei tbrCellHokenshaFutangaku) {
        this.tbrCellHokenshaFutangaku = tbrCellHokenshaFutangaku;
    }

    /*
     * gettbrCellHokenshaKyufuhi
     * @return tbrCellHokenshaKyufuhi
     */
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei getTbrCellHokenshaKyufuhi() {
        return tbrCellHokenshaKyufuhi;
    }

    /*
     * settbrCellHokenshaKyufuhi
     * @param tbrCellHokenshaKyufuhi tbrCellHokenshaKyufuhi
     */
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private void setTbrCellHokenshaKyufuhi(tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi) {
        this.tbrCellHokenshaKyufuhi = tbrCellHokenshaKyufuhi;
    }

    /*
     * gettbrCellHokensha11
     * @return tbrCellHokensha11
     */
    @JsonProperty("tbrCellHokensha11")
    private tbrCellHokensha11AtKetteiHokenshaShukei getTbrCellHokensha11() {
        return tbrCellHokensha11;
    }

    /*
     * settbrCellHokensha11
     * @param tbrCellHokensha11 tbrCellHokensha11
     */
    @JsonProperty("tbrCellHokensha11")
    private void setTbrCellHokensha11(tbrCellHokensha11AtKetteiHokenshaShukei tbrCellHokensha11) {
        this.tbrCellHokensha11 = tbrCellHokensha11;
    }

    /*
     * gettbrCellHokensha12
     * @return tbrCellHokensha12
     */
    @JsonProperty("tbrCellHokensha12")
    private tbrCellHokensha12AtKetteiHokenshaShukei getTbrCellHokensha12() {
        return tbrCellHokensha12;
    }

    /*
     * settbrCellHokensha12
     * @param tbrCellHokensha12 tbrCellHokensha12
     */
    @JsonProperty("tbrCellHokensha12")
    private void setTbrCellHokensha12(tbrCellHokensha12AtKetteiHokenshaShukei tbrCellHokensha12) {
        this.tbrCellHokensha12 = tbrCellHokensha12;
    }

    /*
     * gettbrCellHokensha13
     * @return tbrCellHokensha13
     */
    @JsonProperty("tbrCellHokensha13")
    private tbrCellHokensha13AtKetteiHokenshaShukei getTbrCellHokensha13() {
        return tbrCellHokensha13;
    }

    /*
     * settbrCellHokensha13
     * @param tbrCellHokensha13 tbrCellHokensha13
     */
    @JsonProperty("tbrCellHokensha13")
    private void setTbrCellHokensha13(tbrCellHokensha13AtKetteiHokenshaShukei tbrCellHokensha13) {
        this.tbrCellHokensha13 = tbrCellHokensha13;
    }

    /*
     * gettbrCellHokenshaKogakuServicehi
     * @return tbrCellHokenshaKogakuServicehi
     */
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei getTbrCellHokenshaKogakuServicehi() {
        return tbrCellHokenshaKogakuServicehi;
    }

    /*
     * settbrCellHokenshaKogakuServicehi
     * @param tbrCellHokenshaKogakuServicehi tbrCellHokenshaKogakuServicehi
     */
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private void setTbrCellHokenshaKogakuServicehi(tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi) {
        this.tbrCellHokenshaKogakuServicehi = tbrCellHokenshaKogakuServicehi;
    }

    /*
     * gettbrCellHokensha21
     * @return tbrCellHokensha21
     */
    @JsonProperty("tbrCellHokensha21")
    private tbrCellHokensha21AtKetteiHokenshaShukei getTbrCellHokensha21() {
        return tbrCellHokensha21;
    }

    /*
     * settbrCellHokensha21
     * @param tbrCellHokensha21 tbrCellHokensha21
     */
    @JsonProperty("tbrCellHokensha21")
    private void setTbrCellHokensha21(tbrCellHokensha21AtKetteiHokenshaShukei tbrCellHokensha21) {
        this.tbrCellHokensha21 = tbrCellHokensha21;
    }

    /*
     * gettbrCellHokensha22
     * @return tbrCellHokensha22
     */
    @JsonProperty("tbrCellHokensha22")
    private tbrCellHokensha22AtKetteiHokenshaShukei getTbrCellHokensha22() {
        return tbrCellHokensha22;
    }

    /*
     * settbrCellHokensha22
     * @param tbrCellHokensha22 tbrCellHokensha22
     */
    @JsonProperty("tbrCellHokensha22")
    private void setTbrCellHokensha22(tbrCellHokensha22AtKetteiHokenshaShukei tbrCellHokensha22) {
        this.tbrCellHokensha22 = tbrCellHokensha22;
    }

    /*
     * gettbrCellHokensha23
     * @return tbrCellHokensha23
     */
    @JsonProperty("tbrCellHokensha23")
    private tbrCellHokensha23AtKetteiHokenshaShukei getTbrCellHokensha23() {
        return tbrCellHokensha23;
    }

    /*
     * settbrCellHokensha23
     * @param tbrCellHokensha23 tbrCellHokensha23
     */
    @JsonProperty("tbrCellHokensha23")
    private void setTbrCellHokensha23(tbrCellHokensha23AtKetteiHokenshaShukei tbrCellHokensha23) {
        this.tbrCellHokensha23 = tbrCellHokensha23;
    }

    /*
     * gettbrCellHokenshaTokuteinyushoshaKaigo
     * @return tbrCellHokenshaTokuteinyushoshaKaigo
     */
    @JsonProperty("tbrCellHokenshaTokuteinyushoshaKaigo")
    private tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei getTbrCellHokenshaTokuteinyushoshaKaigo() {
        return tbrCellHokenshaTokuteinyushoshaKaigo;
    }

    /*
     * settbrCellHokenshaTokuteinyushoshaKaigo
     * @param tbrCellHokenshaTokuteinyushoshaKaigo tbrCellHokenshaTokuteinyushoshaKaigo
     */
    @JsonProperty("tbrCellHokenshaTokuteinyushoshaKaigo")
    private void setTbrCellHokenshaTokuteinyushoshaKaigo(tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei tbrCellHokenshaTokuteinyushoshaKaigo) {
        this.tbrCellHokenshaTokuteinyushoshaKaigo = tbrCellHokenshaTokuteinyushoshaKaigo;
    }

    /*
     * gettbrCellHokensha31
     * @return tbrCellHokensha31
     */
    @JsonProperty("tbrCellHokensha31")
    private tbrCellHokensha31AtKetteiHokenshaShukei getTbrCellHokensha31() {
        return tbrCellHokensha31;
    }

    /*
     * settbrCellHokensha31
     * @param tbrCellHokensha31 tbrCellHokensha31
     */
    @JsonProperty("tbrCellHokensha31")
    private void setTbrCellHokensha31(tbrCellHokensha31AtKetteiHokenshaShukei tbrCellHokensha31) {
        this.tbrCellHokensha31 = tbrCellHokensha31;
    }

    /*
     * gettbrCellHokensha32
     * @return tbrCellHokensha32
     */
    @JsonProperty("tbrCellHokensha32")
    private tbrCellHokensha32AtKetteiHokenshaShukei getTbrCellHokensha32() {
        return tbrCellHokensha32;
    }

    /*
     * settbrCellHokensha32
     * @param tbrCellHokensha32 tbrCellHokensha32
     */
    @JsonProperty("tbrCellHokensha32")
    private void setTbrCellHokensha32(tbrCellHokensha32AtKetteiHokenshaShukei tbrCellHokensha32) {
        this.tbrCellHokensha32 = tbrCellHokensha32;
    }

    /*
     * gettbrCellHokensha33
     * @return tbrCellHokensha33
     */
    @JsonProperty("tbrCellHokensha33")
    private tbrCellHokensha33AtKetteiHokenshaShukei getTbrCellHokensha33() {
        return tbrCellHokensha33;
    }

    /*
     * settbrCellHokensha33
     * @param tbrCellHokensha33 tbrCellHokensha33
     */
    @JsonProperty("tbrCellHokensha33")
    private void setTbrCellHokensha33(tbrCellHokensha33AtKetteiHokenshaShukei tbrCellHokensha33) {
        this.tbrCellHokensha33 = tbrCellHokensha33;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaShukeiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    private TextBoxDate txtKetteiHokenshaSakuseiYMD;
    @JsonProperty("ddlRirekiNo1")
    private DropDownList ddlRirekiNo1;

    /*
     * gettxtKetteiHokenshaSakuseiYMD
     * @return txtKetteiHokenshaSakuseiYMD
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return txtKetteiHokenshaSakuseiYMD;
    }

    /*
     * settxtKetteiHokenshaSakuseiYMD
     * @param txtKetteiHokenshaSakuseiYMD txtKetteiHokenshaSakuseiYMD
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public void setTxtKetteiHokenshaSakuseiYMD(TextBoxDate txtKetteiHokenshaSakuseiYMD) {
        this.txtKetteiHokenshaSakuseiYMD = txtKetteiHokenshaSakuseiYMD;
    }

    /*
     * getddlRirekiNo1
     * @return ddlRirekiNo1
     */
    @JsonProperty("ddlRirekiNo1")
    public DropDownList getDdlRirekiNo1() {
        return ddlRirekiNo1;
    }

    /*
     * setddlRirekiNo1
     * @param ddlRirekiNo1 ddlRirekiNo1
     */
    @JsonProperty("ddlRirekiNo1")
    public void setDdlRirekiNo1(DropDownList ddlRirekiNo1) {
        this.ddlRirekiNo1 = ddlRirekiNo1;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaKensu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKensuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKensu")
    private Label lblKetteihokenshaKensu;

    /*
     * getlblKetteihokenshaKensu
     * @return lblKetteihokenshaKensu
     */
    @JsonProperty("lblKetteihokenshaKensu")
    public Label getLblKetteihokenshaKensu() {
        return lblKetteihokenshaKensu;
    }

    /*
     * setlblKetteihokenshaKensu
     * @param lblKetteihokenshaKensu lblKetteihokenshaKensu
     */
    @JsonProperty("lblKetteihokenshaKensu")
    public void setLblKetteihokenshaKensu(Label lblKetteihokenshaKensu) {
        this.lblKetteihokenshaKensu = lblKetteihokenshaKensu;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaTanisuHiyogaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    private Label lblKetteihokenshaTanisuHiyogaku;

    /*
     * getlblKetteihokenshaTanisuHiyogaku
     * @return lblKetteihokenshaTanisuHiyogaku
     */
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return lblKetteihokenshaTanisuHiyogaku;
    }

    /*
     * setlblKetteihokenshaTanisuHiyogaku
     * @param lblKetteihokenshaTanisuHiyogaku lblKetteihokenshaTanisuHiyogaku
     */
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public void setLblKetteihokenshaTanisuHiyogaku(Label lblKetteihokenshaTanisuHiyogaku) {
        this.lblKetteihokenshaTanisuHiyogaku = lblKetteihokenshaTanisuHiyogaku;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaFutangakuAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    private Label lblKetteihokenshaHokenshaFutangaku;

    /*
     * getlblKetteihokenshaHokenshaFutangaku
     * @return lblKetteihokenshaHokenshaFutangaku
     */
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return lblKetteihokenshaHokenshaFutangaku;
    }

    /*
     * setlblKetteihokenshaHokenshaFutangaku
     * @param lblKetteihokenshaHokenshaFutangaku lblKetteihokenshaHokenshaFutangaku
     */
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public void setLblKetteihokenshaHokenshaFutangaku(Label lblKetteihokenshaHokenshaFutangaku) {
        this.lblKetteihokenshaHokenshaFutangaku = lblKetteihokenshaHokenshaFutangaku;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaKyufuhi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    private Label lblKetteihokenshaKaigokyuhuhi;

    /*
     * getlblKetteihokenshaKaigokyuhuhi
     * @return lblKetteihokenshaKaigokyuhuhi
     */
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return lblKetteihokenshaKaigokyuhuhi;
    }

    /*
     * setlblKetteihokenshaKaigokyuhuhi
     * @param lblKetteihokenshaKaigokyuhuhi lblKetteihokenshaKaigokyuhuhi
     */
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public void setLblKetteihokenshaKaigokyuhuhi(Label lblKetteihokenshaKaigokyuhuhi) {
        this.lblKetteihokenshaKaigokyuhuhi = lblKetteihokenshaKaigokyuhuhi;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha11 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha11AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell11")
    private TextBoxNum txtHokenshaCell11;

    /*
     * gettxtHokenshaCell11
     * @return txtHokenshaCell11
     */
    @JsonProperty("txtHokenshaCell11")
    public TextBoxNum getTxtHokenshaCell11() {
        return txtHokenshaCell11;
    }

    /*
     * settxtHokenshaCell11
     * @param txtHokenshaCell11 txtHokenshaCell11
     */
    @JsonProperty("txtHokenshaCell11")
    public void setTxtHokenshaCell11(TextBoxNum txtHokenshaCell11) {
        this.txtHokenshaCell11 = txtHokenshaCell11;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha12 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha12AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell12")
    private TextBoxNum txtHokenshaCell12;

    /*
     * gettxtHokenshaCell12
     * @return txtHokenshaCell12
     */
    @JsonProperty("txtHokenshaCell12")
    public TextBoxNum getTxtHokenshaCell12() {
        return txtHokenshaCell12;
    }

    /*
     * settxtHokenshaCell12
     * @param txtHokenshaCell12 txtHokenshaCell12
     */
    @JsonProperty("txtHokenshaCell12")
    public void setTxtHokenshaCell12(TextBoxNum txtHokenshaCell12) {
        this.txtHokenshaCell12 = txtHokenshaCell12;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha13 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha13AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell13")
    private TextBoxNum txtHokenshaCell13;

    /*
     * gettxtHokenshaCell13
     * @return txtHokenshaCell13
     */
    @JsonProperty("txtHokenshaCell13")
    public TextBoxNum getTxtHokenshaCell13() {
        return txtHokenshaCell13;
    }

    /*
     * settxtHokenshaCell13
     * @param txtHokenshaCell13 txtHokenshaCell13
     */
    @JsonProperty("txtHokenshaCell13")
    public void setTxtHokenshaCell13(TextBoxNum txtHokenshaCell13) {
        this.txtHokenshaCell13 = txtHokenshaCell13;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaKogakuServicehi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    private Label lblKetteihokenshaKogakuServiceHi;

    /*
     * getlblKetteihokenshaKogakuServiceHi
     * @return lblKetteihokenshaKogakuServiceHi
     */
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return lblKetteihokenshaKogakuServiceHi;
    }

    /*
     * setlblKetteihokenshaKogakuServiceHi
     * @param lblKetteihokenshaKogakuServiceHi lblKetteihokenshaKogakuServiceHi
     */
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public void setLblKetteihokenshaKogakuServiceHi(Label lblKetteihokenshaKogakuServiceHi) {
        this.lblKetteihokenshaKogakuServiceHi = lblKetteihokenshaKogakuServiceHi;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha21 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha21AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell21")
    private TextBoxNum txtHokenshaCell21;

    /*
     * gettxtHokenshaCell21
     * @return txtHokenshaCell21
     */
    @JsonProperty("txtHokenshaCell21")
    public TextBoxNum getTxtHokenshaCell21() {
        return txtHokenshaCell21;
    }

    /*
     * settxtHokenshaCell21
     * @param txtHokenshaCell21 txtHokenshaCell21
     */
    @JsonProperty("txtHokenshaCell21")
    public void setTxtHokenshaCell21(TextBoxNum txtHokenshaCell21) {
        this.txtHokenshaCell21 = txtHokenshaCell21;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha22 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha22AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell22")
    private TextBoxNum txtHokenshaCell22;

    /*
     * gettxtHokenshaCell22
     * @return txtHokenshaCell22
     */
    @JsonProperty("txtHokenshaCell22")
    public TextBoxNum getTxtHokenshaCell22() {
        return txtHokenshaCell22;
    }

    /*
     * settxtHokenshaCell22
     * @param txtHokenshaCell22 txtHokenshaCell22
     */
    @JsonProperty("txtHokenshaCell22")
    public void setTxtHokenshaCell22(TextBoxNum txtHokenshaCell22) {
        this.txtHokenshaCell22 = txtHokenshaCell22;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha23 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha23AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell23")
    private TextBoxNum txtHokenshaCell23;

    /*
     * gettxtHokenshaCell23
     * @return txtHokenshaCell23
     */
    @JsonProperty("txtHokenshaCell23")
    public TextBoxNum getTxtHokenshaCell23() {
        return txtHokenshaCell23;
    }

    /*
     * settxtHokenshaCell23
     * @param txtHokenshaCell23 txtHokenshaCell23
     */
    @JsonProperty("txtHokenshaCell23")
    public void setTxtHokenshaCell23(TextBoxNum txtHokenshaCell23) {
        this.txtHokenshaCell23 = txtHokenshaCell23;
    }

    // </editor-fold>
}
/**
 * tbrCellHokenshaTokuteinyushoshaKaigo のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    private Label lblKetteihokenshaTokuteiNyushoshaKaigo;

    /*
     * getlblKetteihokenshaTokuteiNyushoshaKaigo
     * @return lblKetteihokenshaTokuteiNyushoshaKaigo
     */
    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    public Label getLblKetteihokenshaTokuteiNyushoshaKaigo() {
        return lblKetteihokenshaTokuteiNyushoshaKaigo;
    }

    /*
     * setlblKetteihokenshaTokuteiNyushoshaKaigo
     * @param lblKetteihokenshaTokuteiNyushoshaKaigo lblKetteihokenshaTokuteiNyushoshaKaigo
     */
    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    public void setLblKetteihokenshaTokuteiNyushoshaKaigo(Label lblKetteihokenshaTokuteiNyushoshaKaigo) {
        this.lblKetteihokenshaTokuteiNyushoshaKaigo = lblKetteihokenshaTokuteiNyushoshaKaigo;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha31 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha31AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell31")
    private TextBoxNum txtHokenshaCell31;

    /*
     * gettxtHokenshaCell31
     * @return txtHokenshaCell31
     */
    @JsonProperty("txtHokenshaCell31")
    public TextBoxNum getTxtHokenshaCell31() {
        return txtHokenshaCell31;
    }

    /*
     * settxtHokenshaCell31
     * @param txtHokenshaCell31 txtHokenshaCell31
     */
    @JsonProperty("txtHokenshaCell31")
    public void setTxtHokenshaCell31(TextBoxNum txtHokenshaCell31) {
        this.txtHokenshaCell31 = txtHokenshaCell31;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha32 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha32AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell32")
    private TextBoxNum txtHokenshaCell32;

    /*
     * gettxtHokenshaCell32
     * @return txtHokenshaCell32
     */
    @JsonProperty("txtHokenshaCell32")
    public TextBoxNum getTxtHokenshaCell32() {
        return txtHokenshaCell32;
    }

    /*
     * settxtHokenshaCell32
     * @param txtHokenshaCell32 txtHokenshaCell32
     */
    @JsonProperty("txtHokenshaCell32")
    public void setTxtHokenshaCell32(TextBoxNum txtHokenshaCell32) {
        this.txtHokenshaCell32 = txtHokenshaCell32;
    }

    // </editor-fold>
}
/**
 * tbrCellHokensha33 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha33AtKetteiHokenshaShukei extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtHokenshaCell33")
    private TextBoxNum txtHokenshaCell33;

    /*
     * gettxtHokenshaCell33
     * @return txtHokenshaCell33
     */
    @JsonProperty("txtHokenshaCell33")
    public TextBoxNum getTxtHokenshaCell33() {
        return txtHokenshaCell33;
    }

    /*
     * settxtHokenshaCell33
     * @param txtHokenshaCell33 txtHokenshaCell33
     */
    @JsonProperty("txtHokenshaCell33")
    public void setTxtHokenshaCell33(TextBoxNum txtHokenshaCell33) {
        this.txtHokenshaCell33 = txtHokenshaCell33;
    }

    // </editor-fold>
}
