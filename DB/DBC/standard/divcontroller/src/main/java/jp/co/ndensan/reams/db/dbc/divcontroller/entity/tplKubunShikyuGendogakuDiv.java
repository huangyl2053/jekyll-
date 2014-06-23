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
 * tplKubunShikyuGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKubunShikyuGendogakuDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel11")
    private cel11AttplKubunShikyuGendogaku cel11;
    @JsonProperty("cel12")
    private cel12AttplKubunShikyuGendogaku cel12;
    @JsonProperty("cel22")
    private cel22AttplKubunShikyuGendogaku cel22;
    @JsonProperty("cel23")
    private cel23AttplKubunShikyuGendogaku cel23;
    @JsonProperty("cel31")
    private cel31AttplKubunShikyuGendogaku cel31;
    @JsonProperty("cel32")
    private cel32AttplKubunShikyuGendogaku cel32;
    @JsonProperty("cel33")
    private cel33AttplKubunShikyuGendogaku cel33;
    @JsonProperty("cel17")
    private cel17AttplKubunShikyuGendogaku cel17;
    @JsonProperty("cel18")
    private cel18AttplKubunShikyuGendogaku cel18;
    @JsonProperty("cel24")
    private cel24AttplKubunShikyuGendogaku cel24;
    @JsonProperty("cel25")
    private cel25AttplKubunShikyuGendogaku cel25;
    @JsonProperty("cel26")
    private cel26AttplKubunShikyuGendogaku cel26;
    @JsonProperty("cel28")
    private cel28AttplKubunShikyuGendogaku cel28;
    @JsonProperty("cel29")
    private cel29AttplKubunShikyuGendogaku cel29;
    @JsonProperty("cel34")
    private cel34AttplKubunShikyuGendogaku cel34;
    @JsonProperty("cel35")
    private cel35AttplKubunShikyuGendogaku cel35;
    @JsonProperty("cel36")
    private cel36AttplKubunShikyuGendogaku cel36;
    @JsonProperty("cel37")
    private cel37AttplKubunShikyuGendogaku cel37;
    @JsonProperty("cel38")
    private cel38AttplKubunShikyuGendogaku cel38;
    @JsonProperty("cel39")
    private cel39AttplKubunShikyuGendogaku cel39;
    @JsonProperty("cel41")
    private cel41AttplKubunShikyuGendogaku cel41;
    @JsonProperty("cel42")
    private cel42AttplKubunShikyuGendogaku cel42;
    @JsonProperty("cel43")
    private cel43AttplKubunShikyuGendogaku cel43;
    @JsonProperty("cel44")
    private cel44AttplKubunShikyuGendogaku cel44;
    @JsonProperty("cel45")
    private cel45AttplKubunShikyuGendogaku cel45;
    @JsonProperty("cel46")
    private cel46AttplKubunShikyuGendogaku cel46;
    @JsonProperty("cel47")
    private cel47AttplKubunShikyuGendogaku cel47;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKubun() {
        return this.cel11.getLblKubun();
    }

    @JsonIgnore
    public Label getLblKyotakuKaigo() {
        return this.cel12.getLblKyotakuKaigo();
    }

    @JsonIgnore
    public Label getLblYokaigo1() {
        return this.cel22.getLblYokaigo1();
    }

    @JsonIgnore
    public Label getLblYokaigo2() {
        return this.cel23.getLblYokaigo2();
    }

    @JsonIgnore
    public Label getLblShikyuGendoKijungaku() {
        return this.cel31.getLblShikyuGendoKijungaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo1() {
        return this.cel32.getTxtShikyuGendoKijungakuYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo2() {
        return this.cel33.getTxtShikyuGendoKijungakuYokaigo2();
    }

    @JsonIgnore
    public Label getLblKyotakuShien() {
        return this.cel17.getLblKyotakuShien();
    }

    @JsonIgnore
    public Label getLblKaigoYobo() {
        return this.cel18.getLblKaigoYobo();
    }

    @JsonIgnore
    public Label getLblYokaigo3() {
        return this.cel24.getLblYokaigo3();
    }

    @JsonIgnore
    public Label getLblYokaigo4() {
        return this.cel25.getLblYokaigo4();
    }

    @JsonIgnore
    public Label getLblYokaigo5() {
        return this.cel26.getLblYokaigo5();
    }

    @JsonIgnore
    public Label getLblYoshien1() {
        return this.cel28.getLblYoshien1();
    }

    @JsonIgnore
    public Label getLblYoshien2() {
        return this.cel29.getLblYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo3() {
        return this.cel34.getTxtShikyuGendoKijungakuYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo4() {
        return this.cel35.getTxtShikyuGendoKijungakuYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo5() {
        return this.cel36.getTxtShikyuGendoKijungakuYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuKyotakuShien() {
        return this.cel37.getTxtShikyuGendoKijungakuKyotakuShien();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYoshien1() {
        return this.cel38.getTxtShikyuGendoKijungakuYoshien1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoKijungakuYoshien2() {
        return this.cel39.getTxtShikyuGendoKijungakuYoshien2();
    }

    @JsonIgnore
    public Label getLblKyuTankiNyusho() {
        return this.cel41.getLblKyuTankiNyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoYokaigo1() {
        return this.cel42.getTxtKyuTankiNyushoYokaigo1();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoYokaigo2() {
        return this.cel43.getTxtKyuTankiNyushoYokaigo2();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoYokaigo3() {
        return this.cel44.getTxtKyuTankiNyushoYokaigo3();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoYokaigo4() {
        return this.cel45.getTxtKyuTankiNyushoYokaigo4();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoYokaigo5() {
        return this.cel46.getTxtKyuTankiNyushoYokaigo5();
    }

    @JsonIgnore
    public TextBoxNum getTxtKyuTankiNyushoKyotakuShien() {
        return this.cel47.getTxtKyuTankiNyushoKyotakuShien();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cel11")
    private cel11AttplKubunShikyuGendogaku getCel11() {
        return cel11;
    }

    @JsonProperty("cel11")
    private void setCel11(cel11AttplKubunShikyuGendogaku cel11) {
        this.cel11=cel11;
    }

    @JsonProperty("cel12")
    private cel12AttplKubunShikyuGendogaku getCel12() {
        return cel12;
    }

    @JsonProperty("cel12")
    private void setCel12(cel12AttplKubunShikyuGendogaku cel12) {
        this.cel12=cel12;
    }

    @JsonProperty("cel22")
    private cel22AttplKubunShikyuGendogaku getCel22() {
        return cel22;
    }

    @JsonProperty("cel22")
    private void setCel22(cel22AttplKubunShikyuGendogaku cel22) {
        this.cel22=cel22;
    }

    @JsonProperty("cel23")
    private cel23AttplKubunShikyuGendogaku getCel23() {
        return cel23;
    }

    @JsonProperty("cel23")
    private void setCel23(cel23AttplKubunShikyuGendogaku cel23) {
        this.cel23=cel23;
    }

    @JsonProperty("cel31")
    private cel31AttplKubunShikyuGendogaku getCel31() {
        return cel31;
    }

    @JsonProperty("cel31")
    private void setCel31(cel31AttplKubunShikyuGendogaku cel31) {
        this.cel31=cel31;
    }

    @JsonProperty("cel32")
    private cel32AttplKubunShikyuGendogaku getCel32() {
        return cel32;
    }

    @JsonProperty("cel32")
    private void setCel32(cel32AttplKubunShikyuGendogaku cel32) {
        this.cel32=cel32;
    }

    @JsonProperty("cel33")
    private cel33AttplKubunShikyuGendogaku getCel33() {
        return cel33;
    }

    @JsonProperty("cel33")
    private void setCel33(cel33AttplKubunShikyuGendogaku cel33) {
        this.cel33=cel33;
    }

    @JsonProperty("cel17")
    private cel17AttplKubunShikyuGendogaku getCel17() {
        return cel17;
    }

    @JsonProperty("cel17")
    private void setCel17(cel17AttplKubunShikyuGendogaku cel17) {
        this.cel17=cel17;
    }

    @JsonProperty("cel18")
    private cel18AttplKubunShikyuGendogaku getCel18() {
        return cel18;
    }

    @JsonProperty("cel18")
    private void setCel18(cel18AttplKubunShikyuGendogaku cel18) {
        this.cel18=cel18;
    }

    @JsonProperty("cel24")
    private cel24AttplKubunShikyuGendogaku getCel24() {
        return cel24;
    }

    @JsonProperty("cel24")
    private void setCel24(cel24AttplKubunShikyuGendogaku cel24) {
        this.cel24=cel24;
    }

    @JsonProperty("cel25")
    private cel25AttplKubunShikyuGendogaku getCel25() {
        return cel25;
    }

    @JsonProperty("cel25")
    private void setCel25(cel25AttplKubunShikyuGendogaku cel25) {
        this.cel25=cel25;
    }

    @JsonProperty("cel26")
    private cel26AttplKubunShikyuGendogaku getCel26() {
        return cel26;
    }

    @JsonProperty("cel26")
    private void setCel26(cel26AttplKubunShikyuGendogaku cel26) {
        this.cel26=cel26;
    }

    @JsonProperty("cel28")
    private cel28AttplKubunShikyuGendogaku getCel28() {
        return cel28;
    }

    @JsonProperty("cel28")
    private void setCel28(cel28AttplKubunShikyuGendogaku cel28) {
        this.cel28=cel28;
    }

    @JsonProperty("cel29")
    private cel29AttplKubunShikyuGendogaku getCel29() {
        return cel29;
    }

    @JsonProperty("cel29")
    private void setCel29(cel29AttplKubunShikyuGendogaku cel29) {
        this.cel29=cel29;
    }

    @JsonProperty("cel34")
    private cel34AttplKubunShikyuGendogaku getCel34() {
        return cel34;
    }

    @JsonProperty("cel34")
    private void setCel34(cel34AttplKubunShikyuGendogaku cel34) {
        this.cel34=cel34;
    }

    @JsonProperty("cel35")
    private cel35AttplKubunShikyuGendogaku getCel35() {
        return cel35;
    }

    @JsonProperty("cel35")
    private void setCel35(cel35AttplKubunShikyuGendogaku cel35) {
        this.cel35=cel35;
    }

    @JsonProperty("cel36")
    private cel36AttplKubunShikyuGendogaku getCel36() {
        return cel36;
    }

    @JsonProperty("cel36")
    private void setCel36(cel36AttplKubunShikyuGendogaku cel36) {
        this.cel36=cel36;
    }

    @JsonProperty("cel37")
    private cel37AttplKubunShikyuGendogaku getCel37() {
        return cel37;
    }

    @JsonProperty("cel37")
    private void setCel37(cel37AttplKubunShikyuGendogaku cel37) {
        this.cel37=cel37;
    }

    @JsonProperty("cel38")
    private cel38AttplKubunShikyuGendogaku getCel38() {
        return cel38;
    }

    @JsonProperty("cel38")
    private void setCel38(cel38AttplKubunShikyuGendogaku cel38) {
        this.cel38=cel38;
    }

    @JsonProperty("cel39")
    private cel39AttplKubunShikyuGendogaku getCel39() {
        return cel39;
    }

    @JsonProperty("cel39")
    private void setCel39(cel39AttplKubunShikyuGendogaku cel39) {
        this.cel39=cel39;
    }

    @JsonProperty("cel41")
    private cel41AttplKubunShikyuGendogaku getCel41() {
        return cel41;
    }

    @JsonProperty("cel41")
    private void setCel41(cel41AttplKubunShikyuGendogaku cel41) {
        this.cel41=cel41;
    }

    @JsonProperty("cel42")
    private cel42AttplKubunShikyuGendogaku getCel42() {
        return cel42;
    }

    @JsonProperty("cel42")
    private void setCel42(cel42AttplKubunShikyuGendogaku cel42) {
        this.cel42=cel42;
    }

    @JsonProperty("cel43")
    private cel43AttplKubunShikyuGendogaku getCel43() {
        return cel43;
    }

    @JsonProperty("cel43")
    private void setCel43(cel43AttplKubunShikyuGendogaku cel43) {
        this.cel43=cel43;
    }

    @JsonProperty("cel44")
    private cel44AttplKubunShikyuGendogaku getCel44() {
        return cel44;
    }

    @JsonProperty("cel44")
    private void setCel44(cel44AttplKubunShikyuGendogaku cel44) {
        this.cel44=cel44;
    }

    @JsonProperty("cel45")
    private cel45AttplKubunShikyuGendogaku getCel45() {
        return cel45;
    }

    @JsonProperty("cel45")
    private void setCel45(cel45AttplKubunShikyuGendogaku cel45) {
        this.cel45=cel45;
    }

    @JsonProperty("cel46")
    private cel46AttplKubunShikyuGendogaku getCel46() {
        return cel46;
    }

    @JsonProperty("cel46")
    private void setCel46(cel46AttplKubunShikyuGendogaku cel46) {
        this.cel46=cel46;
    }

    @JsonProperty("cel47")
    private cel47AttplKubunShikyuGendogaku getCel47() {
        return cel47;
    }

    @JsonProperty("cel47")
    private void setCel47(cel47AttplKubunShikyuGendogaku cel47) {
        this.cel47=cel47;
    }

}
/**
 * cel11 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel11AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblKubun")
    private Label lblKubun;

    @JsonProperty("lblKubun")
    public Label getLblKubun() {
        return lblKubun;
    }

    @JsonProperty("lblKubun")
    public void setLblKubun(Label lblKubun) {
        this.lblKubun=lblKubun;
    }

}
/**
 * cel12 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel12AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblKyotakuKaigo")
    private Label lblKyotakuKaigo;

    @JsonProperty("lblKyotakuKaigo")
    public Label getLblKyotakuKaigo() {
        return lblKyotakuKaigo;
    }

    @JsonProperty("lblKyotakuKaigo")
    public void setLblKyotakuKaigo(Label lblKyotakuKaigo) {
        this.lblKyotakuKaigo=lblKyotakuKaigo;
    }

}
/**
 * cel22 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel22AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYokaigo1")
    private Label lblYokaigo1;

    @JsonProperty("lblYokaigo1")
    public Label getLblYokaigo1() {
        return lblYokaigo1;
    }

    @JsonProperty("lblYokaigo1")
    public void setLblYokaigo1(Label lblYokaigo1) {
        this.lblYokaigo1=lblYokaigo1;
    }

}
/**
 * cel23 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel23AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYokaigo2")
    private Label lblYokaigo2;

    @JsonProperty("lblYokaigo2")
    public Label getLblYokaigo2() {
        return lblYokaigo2;
    }

    @JsonProperty("lblYokaigo2")
    public void setLblYokaigo2(Label lblYokaigo2) {
        this.lblYokaigo2=lblYokaigo2;
    }

}
/**
 * cel31 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel31AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblShikyuGendoKijungaku")
    private Label lblShikyuGendoKijungaku;

    @JsonProperty("lblShikyuGendoKijungaku")
    public Label getLblShikyuGendoKijungaku() {
        return lblShikyuGendoKijungaku;
    }

    @JsonProperty("lblShikyuGendoKijungaku")
    public void setLblShikyuGendoKijungaku(Label lblShikyuGendoKijungaku) {
        this.lblShikyuGendoKijungaku=lblShikyuGendoKijungaku;
    }

}
/**
 * cel32 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel32AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYokaigo1")
    private TextBoxNum txtShikyuGendoKijungakuYokaigo1;

    @JsonProperty("txtShikyuGendoKijungakuYokaigo1")
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo1() {
        return txtShikyuGendoKijungakuYokaigo1;
    }

    @JsonProperty("txtShikyuGendoKijungakuYokaigo1")
    public void setTxtShikyuGendoKijungakuYokaigo1(TextBoxNum txtShikyuGendoKijungakuYokaigo1) {
        this.txtShikyuGendoKijungakuYokaigo1=txtShikyuGendoKijungakuYokaigo1;
    }

}
/**
 * cel33 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel33AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYokaigo2")
    private TextBoxNum txtShikyuGendoKijungakuYokaigo2;

    @JsonProperty("txtShikyuGendoKijungakuYokaigo2")
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo2() {
        return txtShikyuGendoKijungakuYokaigo2;
    }

    @JsonProperty("txtShikyuGendoKijungakuYokaigo2")
    public void setTxtShikyuGendoKijungakuYokaigo2(TextBoxNum txtShikyuGendoKijungakuYokaigo2) {
        this.txtShikyuGendoKijungakuYokaigo2=txtShikyuGendoKijungakuYokaigo2;
    }

}
/**
 * cel17 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel17AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblKyotakuShien")
    private Label lblKyotakuShien;

    @JsonProperty("lblKyotakuShien")
    public Label getLblKyotakuShien() {
        return lblKyotakuShien;
    }

    @JsonProperty("lblKyotakuShien")
    public void setLblKyotakuShien(Label lblKyotakuShien) {
        this.lblKyotakuShien=lblKyotakuShien;
    }

}
/**
 * cel18 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel18AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblKaigoYobo")
    private Label lblKaigoYobo;

    @JsonProperty("lblKaigoYobo")
    public Label getLblKaigoYobo() {
        return lblKaigoYobo;
    }

    @JsonProperty("lblKaigoYobo")
    public void setLblKaigoYobo(Label lblKaigoYobo) {
        this.lblKaigoYobo=lblKaigoYobo;
    }

}
/**
 * cel24 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel24AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYokaigo3")
    private Label lblYokaigo3;

    @JsonProperty("lblYokaigo3")
    public Label getLblYokaigo3() {
        return lblYokaigo3;
    }

    @JsonProperty("lblYokaigo3")
    public void setLblYokaigo3(Label lblYokaigo3) {
        this.lblYokaigo3=lblYokaigo3;
    }

}
/**
 * cel25 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel25AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYokaigo4")
    private Label lblYokaigo4;

    @JsonProperty("lblYokaigo4")
    public Label getLblYokaigo4() {
        return lblYokaigo4;
    }

    @JsonProperty("lblYokaigo4")
    public void setLblYokaigo4(Label lblYokaigo4) {
        this.lblYokaigo4=lblYokaigo4;
    }

}
/**
 * cel26 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel26AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYokaigo5")
    private Label lblYokaigo5;

    @JsonProperty("lblYokaigo5")
    public Label getLblYokaigo5() {
        return lblYokaigo5;
    }

    @JsonProperty("lblYokaigo5")
    public void setLblYokaigo5(Label lblYokaigo5) {
        this.lblYokaigo5=lblYokaigo5;
    }

}
/**
 * cel28 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel28AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYoshien1")
    private Label lblYoshien1;

    @JsonProperty("lblYoshien1")
    public Label getLblYoshien1() {
        return lblYoshien1;
    }

    @JsonProperty("lblYoshien1")
    public void setLblYoshien1(Label lblYoshien1) {
        this.lblYoshien1=lblYoshien1;
    }

}
/**
 * cel29 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel29AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblYoshien2")
    private Label lblYoshien2;

    @JsonProperty("lblYoshien2")
    public Label getLblYoshien2() {
        return lblYoshien2;
    }

    @JsonProperty("lblYoshien2")
    public void setLblYoshien2(Label lblYoshien2) {
        this.lblYoshien2=lblYoshien2;
    }

}
/**
 * cel34 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel34AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYokaigo3")
    private TextBoxNum txtShikyuGendoKijungakuYokaigo3;

    @JsonProperty("txtShikyuGendoKijungakuYokaigo3")
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo3() {
        return txtShikyuGendoKijungakuYokaigo3;
    }

    @JsonProperty("txtShikyuGendoKijungakuYokaigo3")
    public void setTxtShikyuGendoKijungakuYokaigo3(TextBoxNum txtShikyuGendoKijungakuYokaigo3) {
        this.txtShikyuGendoKijungakuYokaigo3=txtShikyuGendoKijungakuYokaigo3;
    }

}
/**
 * cel35 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel35AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYokaigo4")
    private TextBoxNum txtShikyuGendoKijungakuYokaigo4;

    @JsonProperty("txtShikyuGendoKijungakuYokaigo4")
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo4() {
        return txtShikyuGendoKijungakuYokaigo4;
    }

    @JsonProperty("txtShikyuGendoKijungakuYokaigo4")
    public void setTxtShikyuGendoKijungakuYokaigo4(TextBoxNum txtShikyuGendoKijungakuYokaigo4) {
        this.txtShikyuGendoKijungakuYokaigo4=txtShikyuGendoKijungakuYokaigo4;
    }

}
/**
 * cel36 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel36AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYokaigo5")
    private TextBoxNum txtShikyuGendoKijungakuYokaigo5;

    @JsonProperty("txtShikyuGendoKijungakuYokaigo5")
    public TextBoxNum getTxtShikyuGendoKijungakuYokaigo5() {
        return txtShikyuGendoKijungakuYokaigo5;
    }

    @JsonProperty("txtShikyuGendoKijungakuYokaigo5")
    public void setTxtShikyuGendoKijungakuYokaigo5(TextBoxNum txtShikyuGendoKijungakuYokaigo5) {
        this.txtShikyuGendoKijungakuYokaigo5=txtShikyuGendoKijungakuYokaigo5;
    }

}
/**
 * cel37 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel37AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuKyotakuShien")
    private TextBoxNum txtShikyuGendoKijungakuKyotakuShien;

    @JsonProperty("txtShikyuGendoKijungakuKyotakuShien")
    public TextBoxNum getTxtShikyuGendoKijungakuKyotakuShien() {
        return txtShikyuGendoKijungakuKyotakuShien;
    }

    @JsonProperty("txtShikyuGendoKijungakuKyotakuShien")
    public void setTxtShikyuGendoKijungakuKyotakuShien(TextBoxNum txtShikyuGendoKijungakuKyotakuShien) {
        this.txtShikyuGendoKijungakuKyotakuShien=txtShikyuGendoKijungakuKyotakuShien;
    }

}
/**
 * cel38 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel38AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYoshien1")
    private TextBoxNum txtShikyuGendoKijungakuYoshien1;

    @JsonProperty("txtShikyuGendoKijungakuYoshien1")
    public TextBoxNum getTxtShikyuGendoKijungakuYoshien1() {
        return txtShikyuGendoKijungakuYoshien1;
    }

    @JsonProperty("txtShikyuGendoKijungakuYoshien1")
    public void setTxtShikyuGendoKijungakuYoshien1(TextBoxNum txtShikyuGendoKijungakuYoshien1) {
        this.txtShikyuGendoKijungakuYoshien1=txtShikyuGendoKijungakuYoshien1;
    }

}
/**
 * cel39 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel39AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtShikyuGendoKijungakuYoshien2")
    private TextBoxNum txtShikyuGendoKijungakuYoshien2;

    @JsonProperty("txtShikyuGendoKijungakuYoshien2")
    public TextBoxNum getTxtShikyuGendoKijungakuYoshien2() {
        return txtShikyuGendoKijungakuYoshien2;
    }

    @JsonProperty("txtShikyuGendoKijungakuYoshien2")
    public void setTxtShikyuGendoKijungakuYoshien2(TextBoxNum txtShikyuGendoKijungakuYoshien2) {
        this.txtShikyuGendoKijungakuYoshien2=txtShikyuGendoKijungakuYoshien2;
    }

}
/**
 * cel41 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel41AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("lblKyuTankiNyusho")
    private Label lblKyuTankiNyusho;

    @JsonProperty("lblKyuTankiNyusho")
    public Label getLblKyuTankiNyusho() {
        return lblKyuTankiNyusho;
    }

    @JsonProperty("lblKyuTankiNyusho")
    public void setLblKyuTankiNyusho(Label lblKyuTankiNyusho) {
        this.lblKyuTankiNyusho=lblKyuTankiNyusho;
    }

}
/**
 * cel42 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel42AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoYokaigo1")
    private TextBoxNum txtKyuTankiNyushoYokaigo1;

    @JsonProperty("txtKyuTankiNyushoYokaigo1")
    public TextBoxNum getTxtKyuTankiNyushoYokaigo1() {
        return txtKyuTankiNyushoYokaigo1;
    }

    @JsonProperty("txtKyuTankiNyushoYokaigo1")
    public void setTxtKyuTankiNyushoYokaigo1(TextBoxNum txtKyuTankiNyushoYokaigo1) {
        this.txtKyuTankiNyushoYokaigo1=txtKyuTankiNyushoYokaigo1;
    }

}
/**
 * cel43 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel43AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoYokaigo2")
    private TextBoxNum txtKyuTankiNyushoYokaigo2;

    @JsonProperty("txtKyuTankiNyushoYokaigo2")
    public TextBoxNum getTxtKyuTankiNyushoYokaigo2() {
        return txtKyuTankiNyushoYokaigo2;
    }

    @JsonProperty("txtKyuTankiNyushoYokaigo2")
    public void setTxtKyuTankiNyushoYokaigo2(TextBoxNum txtKyuTankiNyushoYokaigo2) {
        this.txtKyuTankiNyushoYokaigo2=txtKyuTankiNyushoYokaigo2;
    }

}
/**
 * cel44 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel44AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoYokaigo3")
    private TextBoxNum txtKyuTankiNyushoYokaigo3;

    @JsonProperty("txtKyuTankiNyushoYokaigo3")
    public TextBoxNum getTxtKyuTankiNyushoYokaigo3() {
        return txtKyuTankiNyushoYokaigo3;
    }

    @JsonProperty("txtKyuTankiNyushoYokaigo3")
    public void setTxtKyuTankiNyushoYokaigo3(TextBoxNum txtKyuTankiNyushoYokaigo3) {
        this.txtKyuTankiNyushoYokaigo3=txtKyuTankiNyushoYokaigo3;
    }

}
/**
 * cel45 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel45AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoYokaigo4")
    private TextBoxNum txtKyuTankiNyushoYokaigo4;

    @JsonProperty("txtKyuTankiNyushoYokaigo4")
    public TextBoxNum getTxtKyuTankiNyushoYokaigo4() {
        return txtKyuTankiNyushoYokaigo4;
    }

    @JsonProperty("txtKyuTankiNyushoYokaigo4")
    public void setTxtKyuTankiNyushoYokaigo4(TextBoxNum txtKyuTankiNyushoYokaigo4) {
        this.txtKyuTankiNyushoYokaigo4=txtKyuTankiNyushoYokaigo4;
    }

}
/**
 * cel46 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel46AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoYokaigo5")
    private TextBoxNum txtKyuTankiNyushoYokaigo5;

    @JsonProperty("txtKyuTankiNyushoYokaigo5")
    public TextBoxNum getTxtKyuTankiNyushoYokaigo5() {
        return txtKyuTankiNyushoYokaigo5;
    }

    @JsonProperty("txtKyuTankiNyushoYokaigo5")
    public void setTxtKyuTankiNyushoYokaigo5(TextBoxNum txtKyuTankiNyushoYokaigo5) {
        this.txtKyuTankiNyushoYokaigo5=txtKyuTankiNyushoYokaigo5;
    }

}
/**
 * cel47 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel47AttplKubunShikyuGendogaku extends TableCell {
    @JsonProperty("txtKyuTankiNyushoKyotakuShien")
    private TextBoxNum txtKyuTankiNyushoKyotakuShien;

    @JsonProperty("txtKyuTankiNyushoKyotakuShien")
    public TextBoxNum getTxtKyuTankiNyushoKyotakuShien() {
        return txtKyuTankiNyushoKyotakuShien;
    }

    @JsonProperty("txtKyuTankiNyushoKyotakuShien")
    public void setTxtKyuTankiNyushoKyotakuShien(TextBoxNum txtKyuTankiNyushoKyotakuShien) {
        this.txtKyuTankiNyushoKyotakuShien=txtKyuTankiNyushoKyotakuShien;
    }

}
