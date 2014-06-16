package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011;
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
 * KetteiKohiShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiKohiShukeiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbrCellKohiShukei")
    private tbrCellKohiShukeiAtKetteiKohiShukei tbrCellKohiShukei;
    @JsonProperty("tbrCellKohiKensu")
    private tbrCellKohiKensuAtKetteiKohiShukei tbrCellKohiKensu;
    @JsonProperty("tbrCellKohiTanisuHiyogaku")
    private tbrCellKohiTanisuHiyogakuAtKetteiKohiShukei tbrCellKohiTanisuHiyogaku;
    @JsonProperty("tbrCellKohiKyufuhi")
    private tbrCellKohiKyufuhiAtKetteiKohiShukei tbrCellKohiKyufuhi;
    @JsonProperty("tbrCellKohi11")
    private tbrCellKohi11AtKetteiKohiShukei tbrCellKohi11;
    @JsonProperty("tbrCellKohi12")
    private tbrCellKohi12AtKetteiKohiShukei tbrCellKohi12;
    @JsonProperty("tbrCellKohiKogakuServicehi")
    private tbrCellKohiKogakuServicehiAtKetteiKohiShukei tbrCellKohiKogakuServicehi;
    @JsonProperty("tbrCellKohi21")
    private tbrCellKohi21AtKetteiKohiShukei tbrCellKohi21;
    @JsonProperty("tbrCellKohi22")
    private tbrCellKohi22AtKetteiKohiShukei tbrCellKohi22;
    @JsonProperty("tbrCellKohiFutangaku")
    private tbrCellKohiFutangakuAtKetteiKohiShukei tbrCellKohiFutangaku;
    @JsonProperty("tbrCellKohi13")
    private tbrCellKohi13AtKetteiKohiShukei tbrCellKohi13;
    @JsonProperty("tbrCellKohi23")
    private tbrCellKohi23AtKetteiKohiShukei tbrCellKohi23;
    @JsonProperty("tbrCellKohiTokuteiNyushoshaKaigo")
    private tbrCellKohiTokuteiNyushoshaKaigoAtKetteiKohiShukei tbrCellKohiTokuteiNyushoshaKaigo;
    @JsonProperty("tbrCellKohi31")
    private tbrCellKohi31AtKetteiKohiShukei tbrCellKohi31;
    @JsonProperty("tbrCellKohi32")
    private tbrCellKohi32AtKetteiKohiShukei tbrCellKohi32;
    @JsonProperty("tbrCellKohi33")
    private tbrCellKohi33AtKetteiKohiShukei tbrCellKohi33;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKetteiKohiShukei() {
        return this.tbrCellKohiShukei.getLblKetteiKohiShukei();
    }

    @JsonIgnore
    public Label getLblKetteiKohiKensu() {
        return this.tbrCellKohiKensu.getLblKetteiKohiKensu();
    }

    @JsonIgnore
    public Label getLblKetteiKohiTanisuHiyogaku() {
        return this.tbrCellKohiTanisuHiyogaku.getLblKetteiKohiTanisuHiyogaku();
    }

    @JsonIgnore
    public Label getLblKetteiKohiKaigoKyufuhi() {
        return this.tbrCellKohiKyufuhi.getLblKetteiKohiKaigoKyufuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell11() {
        return this.tbrCellKohi11.getTxtKohiCell11();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell12() {
        return this.tbrCellKohi12.getTxtKohiCell12();
    }

    @JsonIgnore
    public Label getLblKetteiKohiKogakuServiceHi() {
        return this.tbrCellKohiKogakuServicehi.getLblKetteiKohiKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell21() {
        return this.tbrCellKohi21.getTxtKohiCell21();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell22() {
        return this.tbrCellKohi22.getTxtKohiCell22();
    }

    @JsonIgnore
    public Label getLblKetteiKohiFutangaku() {
        return this.tbrCellKohiFutangaku.getLblKetteiKohiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell13() {
        return this.tbrCellKohi13.getTxtKohiCell13();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell23() {
        return this.tbrCellKohi23.getTxtKohiCell23();
    }

    @JsonIgnore
    public Label getLblKetteiKohiTokuteiNyushosha() {
        return this.tbrCellKohiTokuteiNyushoshaKaigo.getLblKetteiKohiTokuteiNyushosha();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell31() {
        return this.tbrCellKohi31.getTxtKohiCell31();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell32() {
        return this.tbrCellKohi32.getTxtKohiCell32();
    }

    @JsonIgnore
    public TextBoxNum getTxtKohiCell33() {
        return this.tbrCellKohi33.getTxtKohiCell33();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tbrCellKohiShukei")
    private tbrCellKohiShukeiAtKetteiKohiShukei getTbrCellKohiShukei() {
        return tbrCellKohiShukei;
    }

    @JsonProperty("tbrCellKohiShukei")
    private void setTbrCellKohiShukei(tbrCellKohiShukeiAtKetteiKohiShukei tbrCellKohiShukei) {
        this.tbrCellKohiShukei=tbrCellKohiShukei;
    }

    @JsonProperty("tbrCellKohiKensu")
    private tbrCellKohiKensuAtKetteiKohiShukei getTbrCellKohiKensu() {
        return tbrCellKohiKensu;
    }

    @JsonProperty("tbrCellKohiKensu")
    private void setTbrCellKohiKensu(tbrCellKohiKensuAtKetteiKohiShukei tbrCellKohiKensu) {
        this.tbrCellKohiKensu=tbrCellKohiKensu;
    }

    @JsonProperty("tbrCellKohiTanisuHiyogaku")
    private tbrCellKohiTanisuHiyogakuAtKetteiKohiShukei getTbrCellKohiTanisuHiyogaku() {
        return tbrCellKohiTanisuHiyogaku;
    }

    @JsonProperty("tbrCellKohiTanisuHiyogaku")
    private void setTbrCellKohiTanisuHiyogaku(tbrCellKohiTanisuHiyogakuAtKetteiKohiShukei tbrCellKohiTanisuHiyogaku) {
        this.tbrCellKohiTanisuHiyogaku=tbrCellKohiTanisuHiyogaku;
    }

    @JsonProperty("tbrCellKohiKyufuhi")
    private tbrCellKohiKyufuhiAtKetteiKohiShukei getTbrCellKohiKyufuhi() {
        return tbrCellKohiKyufuhi;
    }

    @JsonProperty("tbrCellKohiKyufuhi")
    private void setTbrCellKohiKyufuhi(tbrCellKohiKyufuhiAtKetteiKohiShukei tbrCellKohiKyufuhi) {
        this.tbrCellKohiKyufuhi=tbrCellKohiKyufuhi;
    }

    @JsonProperty("tbrCellKohi11")
    private tbrCellKohi11AtKetteiKohiShukei getTbrCellKohi11() {
        return tbrCellKohi11;
    }

    @JsonProperty("tbrCellKohi11")
    private void setTbrCellKohi11(tbrCellKohi11AtKetteiKohiShukei tbrCellKohi11) {
        this.tbrCellKohi11=tbrCellKohi11;
    }

    @JsonProperty("tbrCellKohi12")
    private tbrCellKohi12AtKetteiKohiShukei getTbrCellKohi12() {
        return tbrCellKohi12;
    }

    @JsonProperty("tbrCellKohi12")
    private void setTbrCellKohi12(tbrCellKohi12AtKetteiKohiShukei tbrCellKohi12) {
        this.tbrCellKohi12=tbrCellKohi12;
    }

    @JsonProperty("tbrCellKohiKogakuServicehi")
    private tbrCellKohiKogakuServicehiAtKetteiKohiShukei getTbrCellKohiKogakuServicehi() {
        return tbrCellKohiKogakuServicehi;
    }

    @JsonProperty("tbrCellKohiKogakuServicehi")
    private void setTbrCellKohiKogakuServicehi(tbrCellKohiKogakuServicehiAtKetteiKohiShukei tbrCellKohiKogakuServicehi) {
        this.tbrCellKohiKogakuServicehi=tbrCellKohiKogakuServicehi;
    }

    @JsonProperty("tbrCellKohi21")
    private tbrCellKohi21AtKetteiKohiShukei getTbrCellKohi21() {
        return tbrCellKohi21;
    }

    @JsonProperty("tbrCellKohi21")
    private void setTbrCellKohi21(tbrCellKohi21AtKetteiKohiShukei tbrCellKohi21) {
        this.tbrCellKohi21=tbrCellKohi21;
    }

    @JsonProperty("tbrCellKohi22")
    private tbrCellKohi22AtKetteiKohiShukei getTbrCellKohi22() {
        return tbrCellKohi22;
    }

    @JsonProperty("tbrCellKohi22")
    private void setTbrCellKohi22(tbrCellKohi22AtKetteiKohiShukei tbrCellKohi22) {
        this.tbrCellKohi22=tbrCellKohi22;
    }

    @JsonProperty("tbrCellKohiFutangaku")
    private tbrCellKohiFutangakuAtKetteiKohiShukei getTbrCellKohiFutangaku() {
        return tbrCellKohiFutangaku;
    }

    @JsonProperty("tbrCellKohiFutangaku")
    private void setTbrCellKohiFutangaku(tbrCellKohiFutangakuAtKetteiKohiShukei tbrCellKohiFutangaku) {
        this.tbrCellKohiFutangaku=tbrCellKohiFutangaku;
    }

    @JsonProperty("tbrCellKohi13")
    private tbrCellKohi13AtKetteiKohiShukei getTbrCellKohi13() {
        return tbrCellKohi13;
    }

    @JsonProperty("tbrCellKohi13")
    private void setTbrCellKohi13(tbrCellKohi13AtKetteiKohiShukei tbrCellKohi13) {
        this.tbrCellKohi13=tbrCellKohi13;
    }

    @JsonProperty("tbrCellKohi23")
    private tbrCellKohi23AtKetteiKohiShukei getTbrCellKohi23() {
        return tbrCellKohi23;
    }

    @JsonProperty("tbrCellKohi23")
    private void setTbrCellKohi23(tbrCellKohi23AtKetteiKohiShukei tbrCellKohi23) {
        this.tbrCellKohi23=tbrCellKohi23;
    }

    @JsonProperty("tbrCellKohiTokuteiNyushoshaKaigo")
    private tbrCellKohiTokuteiNyushoshaKaigoAtKetteiKohiShukei getTbrCellKohiTokuteiNyushoshaKaigo() {
        return tbrCellKohiTokuteiNyushoshaKaigo;
    }

    @JsonProperty("tbrCellKohiTokuteiNyushoshaKaigo")
    private void setTbrCellKohiTokuteiNyushoshaKaigo(tbrCellKohiTokuteiNyushoshaKaigoAtKetteiKohiShukei tbrCellKohiTokuteiNyushoshaKaigo) {
        this.tbrCellKohiTokuteiNyushoshaKaigo=tbrCellKohiTokuteiNyushoshaKaigo;
    }

    @JsonProperty("tbrCellKohi31")
    private tbrCellKohi31AtKetteiKohiShukei getTbrCellKohi31() {
        return tbrCellKohi31;
    }

    @JsonProperty("tbrCellKohi31")
    private void setTbrCellKohi31(tbrCellKohi31AtKetteiKohiShukei tbrCellKohi31) {
        this.tbrCellKohi31=tbrCellKohi31;
    }

    @JsonProperty("tbrCellKohi32")
    private tbrCellKohi32AtKetteiKohiShukei getTbrCellKohi32() {
        return tbrCellKohi32;
    }

    @JsonProperty("tbrCellKohi32")
    private void setTbrCellKohi32(tbrCellKohi32AtKetteiKohiShukei tbrCellKohi32) {
        this.tbrCellKohi32=tbrCellKohi32;
    }

    @JsonProperty("tbrCellKohi33")
    private tbrCellKohi33AtKetteiKohiShukei getTbrCellKohi33() {
        return tbrCellKohi33;
    }

    @JsonProperty("tbrCellKohi33")
    private void setTbrCellKohi33(tbrCellKohi33AtKetteiKohiShukei tbrCellKohi33) {
        this.tbrCellKohi33=tbrCellKohi33;
    }

}
/**
 * tbrCellKohiShukei のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiShukeiAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiShukei")
    private Label lblKetteiKohiShukei;

    @JsonProperty("lblKetteiKohiShukei")
    public Label getLblKetteiKohiShukei() {
        return lblKetteiKohiShukei;
    }

    @JsonProperty("lblKetteiKohiShukei")
    public void setLblKetteiKohiShukei(Label lblKetteiKohiShukei) {
        this.lblKetteiKohiShukei=lblKetteiKohiShukei;
    }

}
/**
 * tbrCellKohiKensu のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiKensuAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiKensu")
    private Label lblKetteiKohiKensu;

    @JsonProperty("lblKetteiKohiKensu")
    public Label getLblKetteiKohiKensu() {
        return lblKetteiKohiKensu;
    }

    @JsonProperty("lblKetteiKohiKensu")
    public void setLblKetteiKohiKensu(Label lblKetteiKohiKensu) {
        this.lblKetteiKohiKensu=lblKetteiKohiKensu;
    }

}
/**
 * tbrCellKohiTanisuHiyogaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiTanisuHiyogakuAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiTanisuHiyogaku")
    private Label lblKetteiKohiTanisuHiyogaku;

    @JsonProperty("lblKetteiKohiTanisuHiyogaku")
    public Label getLblKetteiKohiTanisuHiyogaku() {
        return lblKetteiKohiTanisuHiyogaku;
    }

    @JsonProperty("lblKetteiKohiTanisuHiyogaku")
    public void setLblKetteiKohiTanisuHiyogaku(Label lblKetteiKohiTanisuHiyogaku) {
        this.lblKetteiKohiTanisuHiyogaku=lblKetteiKohiTanisuHiyogaku;
    }

}
/**
 * tbrCellKohiKyufuhi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiKyufuhiAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiKaigoKyufuhi")
    private Label lblKetteiKohiKaigoKyufuhi;

    @JsonProperty("lblKetteiKohiKaigoKyufuhi")
    public Label getLblKetteiKohiKaigoKyufuhi() {
        return lblKetteiKohiKaigoKyufuhi;
    }

    @JsonProperty("lblKetteiKohiKaigoKyufuhi")
    public void setLblKetteiKohiKaigoKyufuhi(Label lblKetteiKohiKaigoKyufuhi) {
        this.lblKetteiKohiKaigoKyufuhi=lblKetteiKohiKaigoKyufuhi;
    }

}
/**
 * tbrCellKohi11 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi11AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell11")
    private TextBoxNum txtKohiCell11;

    @JsonProperty("txtKohiCell11")
    public TextBoxNum getTxtKohiCell11() {
        return txtKohiCell11;
    }

    @JsonProperty("txtKohiCell11")
    public void setTxtKohiCell11(TextBoxNum txtKohiCell11) {
        this.txtKohiCell11=txtKohiCell11;
    }

}
/**
 * tbrCellKohi12 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi12AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell12")
    private TextBoxNum txtKohiCell12;

    @JsonProperty("txtKohiCell12")
    public TextBoxNum getTxtKohiCell12() {
        return txtKohiCell12;
    }

    @JsonProperty("txtKohiCell12")
    public void setTxtKohiCell12(TextBoxNum txtKohiCell12) {
        this.txtKohiCell12=txtKohiCell12;
    }

}
/**
 * tbrCellKohiKogakuServicehi のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiKogakuServicehiAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiKogakuServiceHi")
    private Label lblKetteiKohiKogakuServiceHi;

    @JsonProperty("lblKetteiKohiKogakuServiceHi")
    public Label getLblKetteiKohiKogakuServiceHi() {
        return lblKetteiKohiKogakuServiceHi;
    }

    @JsonProperty("lblKetteiKohiKogakuServiceHi")
    public void setLblKetteiKohiKogakuServiceHi(Label lblKetteiKohiKogakuServiceHi) {
        this.lblKetteiKohiKogakuServiceHi=lblKetteiKohiKogakuServiceHi;
    }

}
/**
 * tbrCellKohi21 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi21AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell21")
    private TextBoxNum txtKohiCell21;

    @JsonProperty("txtKohiCell21")
    public TextBoxNum getTxtKohiCell21() {
        return txtKohiCell21;
    }

    @JsonProperty("txtKohiCell21")
    public void setTxtKohiCell21(TextBoxNum txtKohiCell21) {
        this.txtKohiCell21=txtKohiCell21;
    }

}
/**
 * tbrCellKohi22 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi22AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell22")
    private TextBoxNum txtKohiCell22;

    @JsonProperty("txtKohiCell22")
    public TextBoxNum getTxtKohiCell22() {
        return txtKohiCell22;
    }

    @JsonProperty("txtKohiCell22")
    public void setTxtKohiCell22(TextBoxNum txtKohiCell22) {
        this.txtKohiCell22=txtKohiCell22;
    }

}
/**
 * tbrCellKohiFutangaku のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiFutangakuAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiFutangaku")
    private Label lblKetteiKohiFutangaku;

    @JsonProperty("lblKetteiKohiFutangaku")
    public Label getLblKetteiKohiFutangaku() {
        return lblKetteiKohiFutangaku;
    }

    @JsonProperty("lblKetteiKohiFutangaku")
    public void setLblKetteiKohiFutangaku(Label lblKetteiKohiFutangaku) {
        this.lblKetteiKohiFutangaku=lblKetteiKohiFutangaku;
    }

}
/**
 * tbrCellKohi13 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi13AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell13")
    private TextBoxNum txtKohiCell13;

    @JsonProperty("txtKohiCell13")
    public TextBoxNum getTxtKohiCell13() {
        return txtKohiCell13;
    }

    @JsonProperty("txtKohiCell13")
    public void setTxtKohiCell13(TextBoxNum txtKohiCell13) {
        this.txtKohiCell13=txtKohiCell13;
    }

}
/**
 * tbrCellKohi23 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi23AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell23")
    private TextBoxNum txtKohiCell23;

    @JsonProperty("txtKohiCell23")
    public TextBoxNum getTxtKohiCell23() {
        return txtKohiCell23;
    }

    @JsonProperty("txtKohiCell23")
    public void setTxtKohiCell23(TextBoxNum txtKohiCell23) {
        this.txtKohiCell23=txtKohiCell23;
    }

}
/**
 * tbrCellKohiTokuteiNyushoshaKaigo のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohiTokuteiNyushoshaKaigoAtKetteiKohiShukei extends TableCell {
    @JsonProperty("lblKetteiKohiTokuteiNyushosha")
    private Label lblKetteiKohiTokuteiNyushosha;

    @JsonProperty("lblKetteiKohiTokuteiNyushosha")
    public Label getLblKetteiKohiTokuteiNyushosha() {
        return lblKetteiKohiTokuteiNyushosha;
    }

    @JsonProperty("lblKetteiKohiTokuteiNyushosha")
    public void setLblKetteiKohiTokuteiNyushosha(Label lblKetteiKohiTokuteiNyushosha) {
        this.lblKetteiKohiTokuteiNyushosha=lblKetteiKohiTokuteiNyushosha;
    }

}
/**
 * tbrCellKohi31 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi31AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell31")
    private TextBoxNum txtKohiCell31;

    @JsonProperty("txtKohiCell31")
    public TextBoxNum getTxtKohiCell31() {
        return txtKohiCell31;
    }

    @JsonProperty("txtKohiCell31")
    public void setTxtKohiCell31(TextBoxNum txtKohiCell31) {
        this.txtKohiCell31=txtKohiCell31;
    }

}
/**
 * tbrCellKohi32 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi32AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell32")
    private TextBoxNum txtKohiCell32;

    @JsonProperty("txtKohiCell32")
    public TextBoxNum getTxtKohiCell32() {
        return txtKohiCell32;
    }

    @JsonProperty("txtKohiCell32")
    public void setTxtKohiCell32(TextBoxNum txtKohiCell32) {
        this.txtKohiCell32=txtKohiCell32;
    }

}
/**
 * tbrCellKohi33 のクラスファイル 
 * 
 * @author 自動生成
 */
class tbrCellKohi33AtKetteiKohiShukei extends TableCell {
    @JsonProperty("txtKohiCell33")
    private TextBoxNum txtKohiCell33;

    @JsonProperty("txtKohiCell33")
    public TextBoxNum getTxtKohiCell33() {
        return txtKohiCell33;
    }

    @JsonProperty("txtKohiCell33")
    public void setTxtKohiCell33(TextBoxNum txtKohiCell33) {
        this.txtKohiCell33=txtKohiCell33;
    }

}
