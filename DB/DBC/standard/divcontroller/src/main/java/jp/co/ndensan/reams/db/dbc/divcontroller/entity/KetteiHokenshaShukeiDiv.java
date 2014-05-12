package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KetteiHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiHokenshaShukeiDiv extends TablePanel {
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
    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi;
    @JsonProperty("tbrCellHokensha11")
    private tbrCellHokensha11AtKetteiHokenshaShukei tbrCellHokensha11;
    @JsonProperty("tbrCellHokensha12")
    private tbrCellHokensha12AtKetteiHokenshaShukei tbrCellHokensha12;
    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi;
    @JsonProperty("tbrCellHokensha21")
    private tbrCellHokensha21AtKetteiHokenshaShukei tbrCellHokensha21;
    @JsonProperty("tbrCellHokensha22")
    private tbrCellHokensha22AtKetteiHokenshaShukei tbrCellHokensha22;
    @JsonProperty("tbrCellHokenshaFutangaku")
    private tbrCellHokenshaFutangakuAtKetteiHokenshaShukei tbrCellHokenshaFutangaku;
    @JsonProperty("tbrCellHokensha13")
    private tbrCellHokensha13AtKetteiHokenshaShukei tbrCellHokensha13;
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
    @JsonProperty("tbrCellHokenshaYoboShienSogojigyohi")
    private tbrCellHokenshaYoboShienSogojigyohiAtKetteiHokenshaShukei tbrCellHokenshaYoboShienSogojigyohi;
    @JsonProperty("tbrCellHokensha41")
    private tbrCellHokensha41AtKetteiHokenshaShukei tbrCellHokensha41;
    @JsonProperty("tbrCellHokensha42")
    private tbrCellHokensha42AtKetteiHokenshaShukei tbrCellHokensha42;
    @JsonProperty("tbrCellHokensha43")
    private tbrCellHokensha43AtKetteiHokenshaShukei tbrCellHokensha43;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKetteiHokenshaShukei() {
        return this.tbrCellHokenshaShukei.getLblKetteiHokenshaShukei();
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
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return this.tbrCellHokenshaFutangaku.getLblKetteihokenshaHokenshaFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell13() {
        return this.tbrCellHokensha13.getTxtHokenshaCell13();
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

    @JsonIgnore
    public Label getLblKetteihokenshaYoboSeikatsuShienJigyohi() {
        return this.tbrCellHokenshaYoboShienSogojigyohi.getLblKetteihokenshaYoboSeikatsuShienJigyohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell41() {
        return this.tbrCellHokensha41.getTxtHokenshaCell41();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell42() {
        return this.tbrCellHokensha42.getTxtHokenshaCell42();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell43() {
        return this.tbrCellHokensha43.getTxtHokenshaCell43();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tbrCellHokenshaShukei")
    private tbrCellHokenshaShukeiAtKetteiHokenshaShukei getTbrCellHokenshaShukei() {
        return tbrCellHokenshaShukei;
    }

    @JsonProperty("tbrCellHokenshaShukei")
    private void setTbrCellHokenshaShukei(tbrCellHokenshaShukeiAtKetteiHokenshaShukei tbrCellHokenshaShukei) {
        this.tbrCellHokenshaShukei=tbrCellHokenshaShukei;
    }

    @JsonProperty("tbrCellHokenshaKensu")
    private tbrCellHokenshaKensuAtKetteiHokenshaShukei getTbrCellHokenshaKensu() {
        return tbrCellHokenshaKensu;
    }

    @JsonProperty("tbrCellHokenshaKensu")
    private void setTbrCellHokenshaKensu(tbrCellHokenshaKensuAtKetteiHokenshaShukei tbrCellHokenshaKensu) {
        this.tbrCellHokenshaKensu=tbrCellHokenshaKensu;
    }

    @JsonProperty("tbrCellHokenshaTanisuHiyogaku")
    private tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei getTbrCellHokenshaTanisuHiyogaku() {
        return tbrCellHokenshaTanisuHiyogaku;
    }

    @JsonProperty("tbrCellHokenshaTanisuHiyogaku")
    private void setTbrCellHokenshaTanisuHiyogaku(tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei tbrCellHokenshaTanisuHiyogaku) {
        this.tbrCellHokenshaTanisuHiyogaku=tbrCellHokenshaTanisuHiyogaku;
    }

    @JsonProperty("tbrCellHokenshaKyufuhi")
    private tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei getTbrCellHokenshaKyufuhi() {
        return tbrCellHokenshaKyufuhi;
    }

    @JsonProperty("tbrCellHokenshaKyufuhi")
    private void setTbrCellHokenshaKyufuhi(tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei tbrCellHokenshaKyufuhi) {
        this.tbrCellHokenshaKyufuhi=tbrCellHokenshaKyufuhi;
    }

    @JsonProperty("tbrCellHokensha11")
    private tbrCellHokensha11AtKetteiHokenshaShukei getTbrCellHokensha11() {
        return tbrCellHokensha11;
    }

    @JsonProperty("tbrCellHokensha11")
    private void setTbrCellHokensha11(tbrCellHokensha11AtKetteiHokenshaShukei tbrCellHokensha11) {
        this.tbrCellHokensha11=tbrCellHokensha11;
    }

    @JsonProperty("tbrCellHokensha12")
    private tbrCellHokensha12AtKetteiHokenshaShukei getTbrCellHokensha12() {
        return tbrCellHokensha12;
    }

    @JsonProperty("tbrCellHokensha12")
    private void setTbrCellHokensha12(tbrCellHokensha12AtKetteiHokenshaShukei tbrCellHokensha12) {
        this.tbrCellHokensha12=tbrCellHokensha12;
    }

    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei getTbrCellHokenshaKogakuServicehi() {
        return tbrCellHokenshaKogakuServicehi;
    }

    @JsonProperty("tbrCellHokenshaKogakuServicehi")
    private void setTbrCellHokenshaKogakuServicehi(tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei tbrCellHokenshaKogakuServicehi) {
        this.tbrCellHokenshaKogakuServicehi=tbrCellHokenshaKogakuServicehi;
    }

    @JsonProperty("tbrCellHokensha21")
    private tbrCellHokensha21AtKetteiHokenshaShukei getTbrCellHokensha21() {
        return tbrCellHokensha21;
    }

    @JsonProperty("tbrCellHokensha21")
    private void setTbrCellHokensha21(tbrCellHokensha21AtKetteiHokenshaShukei tbrCellHokensha21) {
        this.tbrCellHokensha21=tbrCellHokensha21;
    }

    @JsonProperty("tbrCellHokensha22")
    private tbrCellHokensha22AtKetteiHokenshaShukei getTbrCellHokensha22() {
        return tbrCellHokensha22;
    }

    @JsonProperty("tbrCellHokensha22")
    private void setTbrCellHokensha22(tbrCellHokensha22AtKetteiHokenshaShukei tbrCellHokensha22) {
        this.tbrCellHokensha22=tbrCellHokensha22;
    }

    @JsonProperty("tbrCellHokenshaFutangaku")
    private tbrCellHokenshaFutangakuAtKetteiHokenshaShukei getTbrCellHokenshaFutangaku() {
        return tbrCellHokenshaFutangaku;
    }

    @JsonProperty("tbrCellHokenshaFutangaku")
    private void setTbrCellHokenshaFutangaku(tbrCellHokenshaFutangakuAtKetteiHokenshaShukei tbrCellHokenshaFutangaku) {
        this.tbrCellHokenshaFutangaku=tbrCellHokenshaFutangaku;
    }

    @JsonProperty("tbrCellHokensha13")
    private tbrCellHokensha13AtKetteiHokenshaShukei getTbrCellHokensha13() {
        return tbrCellHokensha13;
    }

    @JsonProperty("tbrCellHokensha13")
    private void setTbrCellHokensha13(tbrCellHokensha13AtKetteiHokenshaShukei tbrCellHokensha13) {
        this.tbrCellHokensha13=tbrCellHokensha13;
    }

    @JsonProperty("tbrCellHokensha23")
    private tbrCellHokensha23AtKetteiHokenshaShukei getTbrCellHokensha23() {
        return tbrCellHokensha23;
    }

    @JsonProperty("tbrCellHokensha23")
    private void setTbrCellHokensha23(tbrCellHokensha23AtKetteiHokenshaShukei tbrCellHokensha23) {
        this.tbrCellHokensha23=tbrCellHokensha23;
    }

    @JsonProperty("tbrCellHokenshaTokuteinyushoshaKaigo")
    private tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei getTbrCellHokenshaTokuteinyushoshaKaigo() {
        return tbrCellHokenshaTokuteinyushoshaKaigo;
    }

    @JsonProperty("tbrCellHokenshaTokuteinyushoshaKaigo")
    private void setTbrCellHokenshaTokuteinyushoshaKaigo(tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei tbrCellHokenshaTokuteinyushoshaKaigo) {
        this.tbrCellHokenshaTokuteinyushoshaKaigo=tbrCellHokenshaTokuteinyushoshaKaigo;
    }

    @JsonProperty("tbrCellHokensha31")
    private tbrCellHokensha31AtKetteiHokenshaShukei getTbrCellHokensha31() {
        return tbrCellHokensha31;
    }

    @JsonProperty("tbrCellHokensha31")
    private void setTbrCellHokensha31(tbrCellHokensha31AtKetteiHokenshaShukei tbrCellHokensha31) {
        this.tbrCellHokensha31=tbrCellHokensha31;
    }

    @JsonProperty("tbrCellHokensha32")
    private tbrCellHokensha32AtKetteiHokenshaShukei getTbrCellHokensha32() {
        return tbrCellHokensha32;
    }

    @JsonProperty("tbrCellHokensha32")
    private void setTbrCellHokensha32(tbrCellHokensha32AtKetteiHokenshaShukei tbrCellHokensha32) {
        this.tbrCellHokensha32=tbrCellHokensha32;
    }

    @JsonProperty("tbrCellHokensha33")
    private tbrCellHokensha33AtKetteiHokenshaShukei getTbrCellHokensha33() {
        return tbrCellHokensha33;
    }

    @JsonProperty("tbrCellHokensha33")
    private void setTbrCellHokensha33(tbrCellHokensha33AtKetteiHokenshaShukei tbrCellHokensha33) {
        this.tbrCellHokensha33=tbrCellHokensha33;
    }

    @JsonProperty("tbrCellHokenshaYoboShienSogojigyohi")
    private tbrCellHokenshaYoboShienSogojigyohiAtKetteiHokenshaShukei getTbrCellHokenshaYoboShienSogojigyohi() {
        return tbrCellHokenshaYoboShienSogojigyohi;
    }

    @JsonProperty("tbrCellHokenshaYoboShienSogojigyohi")
    private void setTbrCellHokenshaYoboShienSogojigyohi(tbrCellHokenshaYoboShienSogojigyohiAtKetteiHokenshaShukei tbrCellHokenshaYoboShienSogojigyohi) {
        this.tbrCellHokenshaYoboShienSogojigyohi=tbrCellHokenshaYoboShienSogojigyohi;
    }

    @JsonProperty("tbrCellHokensha41")
    private tbrCellHokensha41AtKetteiHokenshaShukei getTbrCellHokensha41() {
        return tbrCellHokensha41;
    }

    @JsonProperty("tbrCellHokensha41")
    private void setTbrCellHokensha41(tbrCellHokensha41AtKetteiHokenshaShukei tbrCellHokensha41) {
        this.tbrCellHokensha41=tbrCellHokensha41;
    }

    @JsonProperty("tbrCellHokensha42")
    private tbrCellHokensha42AtKetteiHokenshaShukei getTbrCellHokensha42() {
        return tbrCellHokensha42;
    }

    @JsonProperty("tbrCellHokensha42")
    private void setTbrCellHokensha42(tbrCellHokensha42AtKetteiHokenshaShukei tbrCellHokensha42) {
        this.tbrCellHokensha42=tbrCellHokensha42;
    }

    @JsonProperty("tbrCellHokensha43")
    private tbrCellHokensha43AtKetteiHokenshaShukei getTbrCellHokensha43() {
        return tbrCellHokensha43;
    }

    @JsonProperty("tbrCellHokensha43")
    private void setTbrCellHokensha43(tbrCellHokensha43AtKetteiHokenshaShukei tbrCellHokensha43) {
        this.tbrCellHokensha43=tbrCellHokensha43;
    }

}
/**
 * tbrCellHokenshaShukei のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaShukeiAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteiHokenshaShukei")
    private Label lblKetteiHokenshaShukei;

    @JsonProperty("lblKetteiHokenshaShukei")
    public Label getLblKetteiHokenshaShukei() {
        return lblKetteiHokenshaShukei;
    }

    @JsonProperty("lblKetteiHokenshaShukei")
    public void setLblKetteiHokenshaShukei(Label lblKetteiHokenshaShukei) {
        this.lblKetteiHokenshaShukei=lblKetteiHokenshaShukei;
    }

}
/**
 * tbrCellHokenshaKensu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKensuAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaKensu")
    private Label lblKetteihokenshaKensu;

    @JsonProperty("lblKetteihokenshaKensu")
    public Label getLblKetteihokenshaKensu() {
        return lblKetteihokenshaKensu;
    }

    @JsonProperty("lblKetteihokenshaKensu")
    public void setLblKetteihokenshaKensu(Label lblKetteihokenshaKensu) {
        this.lblKetteihokenshaKensu=lblKetteihokenshaKensu;
    }

}
/**
 * tbrCellHokenshaTanisuHiyogaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaTanisuHiyogakuAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    private Label lblKetteihokenshaTanisuHiyogaku;

    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return lblKetteihokenshaTanisuHiyogaku;
    }

    @JsonProperty("lblKetteihokenshaTanisuHiyogaku")
    public void setLblKetteihokenshaTanisuHiyogaku(Label lblKetteihokenshaTanisuHiyogaku) {
        this.lblKetteihokenshaTanisuHiyogaku=lblKetteihokenshaTanisuHiyogaku;
    }

}
/**
 * tbrCellHokenshaKyufuhi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKyufuhiAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    private Label lblKetteihokenshaKaigokyuhuhi;

    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return lblKetteihokenshaKaigokyuhuhi;
    }

    @JsonProperty("lblKetteihokenshaKaigokyuhuhi")
    public void setLblKetteihokenshaKaigokyuhuhi(Label lblKetteihokenshaKaigokyuhuhi) {
        this.lblKetteihokenshaKaigokyuhuhi=lblKetteihokenshaKaigokyuhuhi;
    }

}
/**
 * tbrCellHokensha11 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha11AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell11")
    private TextBoxNum txtHokenshaCell11;

    @JsonProperty("txtHokenshaCell11")
    public TextBoxNum getTxtHokenshaCell11() {
        return txtHokenshaCell11;
    }

    @JsonProperty("txtHokenshaCell11")
    public void setTxtHokenshaCell11(TextBoxNum txtHokenshaCell11) {
        this.txtHokenshaCell11=txtHokenshaCell11;
    }

}
/**
 * tbrCellHokensha12 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha12AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell12")
    private TextBoxNum txtHokenshaCell12;

    @JsonProperty("txtHokenshaCell12")
    public TextBoxNum getTxtHokenshaCell12() {
        return txtHokenshaCell12;
    }

    @JsonProperty("txtHokenshaCell12")
    public void setTxtHokenshaCell12(TextBoxNum txtHokenshaCell12) {
        this.txtHokenshaCell12=txtHokenshaCell12;
    }

}
/**
 * tbrCellHokenshaKogakuServicehi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaKogakuServicehiAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    private Label lblKetteihokenshaKogakuServiceHi;

    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return lblKetteihokenshaKogakuServiceHi;
    }

    @JsonProperty("lblKetteihokenshaKogakuServiceHi")
    public void setLblKetteihokenshaKogakuServiceHi(Label lblKetteihokenshaKogakuServiceHi) {
        this.lblKetteihokenshaKogakuServiceHi=lblKetteihokenshaKogakuServiceHi;
    }

}
/**
 * tbrCellHokensha21 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha21AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell21")
    private TextBoxNum txtHokenshaCell21;

    @JsonProperty("txtHokenshaCell21")
    public TextBoxNum getTxtHokenshaCell21() {
        return txtHokenshaCell21;
    }

    @JsonProperty("txtHokenshaCell21")
    public void setTxtHokenshaCell21(TextBoxNum txtHokenshaCell21) {
        this.txtHokenshaCell21=txtHokenshaCell21;
    }

}
/**
 * tbrCellHokensha22 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha22AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell22")
    private TextBoxNum txtHokenshaCell22;

    @JsonProperty("txtHokenshaCell22")
    public TextBoxNum getTxtHokenshaCell22() {
        return txtHokenshaCell22;
    }

    @JsonProperty("txtHokenshaCell22")
    public void setTxtHokenshaCell22(TextBoxNum txtHokenshaCell22) {
        this.txtHokenshaCell22=txtHokenshaCell22;
    }

}
/**
 * tbrCellHokenshaFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaFutangakuAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    private Label lblKetteihokenshaHokenshaFutangaku;

    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return lblKetteihokenshaHokenshaFutangaku;
    }

    @JsonProperty("lblKetteihokenshaHokenshaFutangaku")
    public void setLblKetteihokenshaHokenshaFutangaku(Label lblKetteihokenshaHokenshaFutangaku) {
        this.lblKetteihokenshaHokenshaFutangaku=lblKetteihokenshaHokenshaFutangaku;
    }

}
/**
 * tbrCellHokensha13 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha13AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell13")
    private TextBoxNum txtHokenshaCell13;

    @JsonProperty("txtHokenshaCell13")
    public TextBoxNum getTxtHokenshaCell13() {
        return txtHokenshaCell13;
    }

    @JsonProperty("txtHokenshaCell13")
    public void setTxtHokenshaCell13(TextBoxNum txtHokenshaCell13) {
        this.txtHokenshaCell13=txtHokenshaCell13;
    }

}
/**
 * tbrCellHokensha23 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha23AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell23")
    private TextBoxNum txtHokenshaCell23;

    @JsonProperty("txtHokenshaCell23")
    public TextBoxNum getTxtHokenshaCell23() {
        return txtHokenshaCell23;
    }

    @JsonProperty("txtHokenshaCell23")
    public void setTxtHokenshaCell23(TextBoxNum txtHokenshaCell23) {
        this.txtHokenshaCell23=txtHokenshaCell23;
    }

}
/**
 * tbrCellHokenshaTokuteinyushoshaKaigo のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaTokuteinyushoshaKaigoAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    private Label lblKetteihokenshaTokuteiNyushoshaKaigo;

    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    public Label getLblKetteihokenshaTokuteiNyushoshaKaigo() {
        return lblKetteihokenshaTokuteiNyushoshaKaigo;
    }

    @JsonProperty("lblKetteihokenshaTokuteiNyushoshaKaigo")
    public void setLblKetteihokenshaTokuteiNyushoshaKaigo(Label lblKetteihokenshaTokuteiNyushoshaKaigo) {
        this.lblKetteihokenshaTokuteiNyushoshaKaigo=lblKetteihokenshaTokuteiNyushoshaKaigo;
    }

}
/**
 * tbrCellHokensha31 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha31AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell31")
    private TextBoxNum txtHokenshaCell31;

    @JsonProperty("txtHokenshaCell31")
    public TextBoxNum getTxtHokenshaCell31() {
        return txtHokenshaCell31;
    }

    @JsonProperty("txtHokenshaCell31")
    public void setTxtHokenshaCell31(TextBoxNum txtHokenshaCell31) {
        this.txtHokenshaCell31=txtHokenshaCell31;
    }

}
/**
 * tbrCellHokensha32 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha32AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell32")
    private TextBoxNum txtHokenshaCell32;

    @JsonProperty("txtHokenshaCell32")
    public TextBoxNum getTxtHokenshaCell32() {
        return txtHokenshaCell32;
    }

    @JsonProperty("txtHokenshaCell32")
    public void setTxtHokenshaCell32(TextBoxNum txtHokenshaCell32) {
        this.txtHokenshaCell32=txtHokenshaCell32;
    }

}
/**
 * tbrCellHokensha33 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha33AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell33")
    private TextBoxNum txtHokenshaCell33;

    @JsonProperty("txtHokenshaCell33")
    public TextBoxNum getTxtHokenshaCell33() {
        return txtHokenshaCell33;
    }

    @JsonProperty("txtHokenshaCell33")
    public void setTxtHokenshaCell33(TextBoxNum txtHokenshaCell33) {
        this.txtHokenshaCell33=txtHokenshaCell33;
    }

}
/**
 * tbrCellHokenshaYoboShienSogojigyohi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokenshaYoboShienSogojigyohiAtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("lblKetteihokenshaYoboSeikatsuShienJigyohi")
    private Label lblKetteihokenshaYoboSeikatsuShienJigyohi;

    @JsonProperty("lblKetteihokenshaYoboSeikatsuShienJigyohi")
    public Label getLblKetteihokenshaYoboSeikatsuShienJigyohi() {
        return lblKetteihokenshaYoboSeikatsuShienJigyohi;
    }

    @JsonProperty("lblKetteihokenshaYoboSeikatsuShienJigyohi")
    public void setLblKetteihokenshaYoboSeikatsuShienJigyohi(Label lblKetteihokenshaYoboSeikatsuShienJigyohi) {
        this.lblKetteihokenshaYoboSeikatsuShienJigyohi=lblKetteihokenshaYoboSeikatsuShienJigyohi;
    }

}
/**
 * tbrCellHokensha41 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha41AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell41")
    private TextBoxNum txtHokenshaCell41;

    @JsonProperty("txtHokenshaCell41")
    public TextBoxNum getTxtHokenshaCell41() {
        return txtHokenshaCell41;
    }

    @JsonProperty("txtHokenshaCell41")
    public void setTxtHokenshaCell41(TextBoxNum txtHokenshaCell41) {
        this.txtHokenshaCell41=txtHokenshaCell41;
    }

}
/**
 * tbrCellHokensha42 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha42AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell42")
    private TextBoxNum txtHokenshaCell42;

    @JsonProperty("txtHokenshaCell42")
    public TextBoxNum getTxtHokenshaCell42() {
        return txtHokenshaCell42;
    }

    @JsonProperty("txtHokenshaCell42")
    public void setTxtHokenshaCell42(TextBoxNum txtHokenshaCell42) {
        this.txtHokenshaCell42=txtHokenshaCell42;
    }

}
/**
 * tbrCellHokensha43 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellHokensha43AtKetteiHokenshaShukei extends TableCell {
    @JsonProperty("txtHokenshaCell43")
    private TextBoxNum txtHokenshaCell43;

    @JsonProperty("txtHokenshaCell43")
    public TextBoxNum getTxtHokenshaCell43() {
        return txtHokenshaCell43;
    }

    @JsonProperty("txtHokenshaCell43")
    public void setTxtHokenshaCell43(TextBoxNum txtHokenshaCell43) {
        this.txtHokenshaCell43=txtHokenshaCell43;
    }

}
