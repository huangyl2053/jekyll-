package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011;
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
 * tblKyojuhi のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyojuhiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celRiyoshafutan")
    private celRiyoshafutanAttblKyojuhi celRiyoshafutan;
    @JsonProperty("celYunittokoshitsu")
    private celYunittokoshitsuAttblKyojuhi celYunittokoshitsu;
    @JsonProperty("celYunitjunkoshitsu")
    private celYunitjunkoshitsuAttblKyojuhi celYunitjunkoshitsu;
    @JsonProperty("celJuraikoshitsu")
    private celJuraikoshitsuAttblKyojuhi celJuraikoshitsu;
    @JsonProperty("celTasho")
    private celTashoAttblKyojuhi celTasho;
    @JsonProperty("cellTokuyo")
    private cellTokuyoAttblKyojuhi cellTokuyo;
    @JsonProperty("celRokenryoyo")
    private celRokenryoyoAttblKyojuhi celRokenryoyo;
    @JsonProperty("celDaiichidankai")
    private celDaiichidankaiAttblKyojuhi celDaiichidankai;
    @JsonProperty("celIchikoGaku")
    private celIchikoGakuAttblKyojuhi celIchikoGaku;
    @JsonProperty("celIchijunkoGaku")
    private celIchijunkoGakuAttblKyojuhi celIchijunkoGaku;
    @JsonProperty("celTokuyoGaku")
    private celTokuyoGakuAttblKyojuhi celTokuyoGaku;
    @JsonProperty("celRokenryoyoGaku")
    private celRokenryoyoGakuAttblKyojuhi celRokenryoyoGaku;
    @JsonProperty("celTashoGaku")
    private celTashoGakuAttblKyojuhi celTashoGaku;
    @JsonProperty("celDainidankai")
    private celDainidankaiAttblKyojuhi celDainidankai;
    @JsonProperty("celNikoGaku")
    private celNikoGakuAttblKyojuhi celNikoGaku;
    @JsonProperty("celNijunkoGaku")
    private celNijunkoGakuAttblKyojuhi celNijunkoGaku;
    @JsonProperty("celNiTokuyoGaku")
    private celNiTokuyoGakuAttblKyojuhi celNiTokuyoGaku;
    @JsonProperty("celNiRokenryoyoGaku")
    private celNiRokenryoyoGakuAttblKyojuhi celNiRokenryoyoGaku;
    @JsonProperty("celNiTashoGaku")
    private celNiTashoGakuAttblKyojuhi celNiTashoGaku;
    @JsonProperty("celDaisandankai")
    private celDaisandankaiAttblKyojuhi celDaisandankai;
    @JsonProperty("celSankoGaku")
    private celSankoGakuAttblKyojuhi celSankoGaku;
    @JsonProperty("celSanjunkoGaku")
    private celSanjunkoGakuAttblKyojuhi celSanjunkoGaku;
    @JsonProperty("celSanTokuyoGaku")
    private celSanTokuyoGakuAttblKyojuhi celSanTokuyoGaku;
    @JsonProperty("celSanRokenryoyoGaku")
    private celSanRokenryoyoGakuAttblKyojuhi celSanRokenryoyoGaku;
    @JsonProperty("celSanTashoGaku")
    private celSanTashoGakuAttblKyojuhi celSanTashoGaku;
    @JsonProperty("celKijunhi")
    private celKijunhiAttblKyojuhi celKijunhi;
    @JsonProperty("celKijukoGaku")
    private celKijukoGakuAttblKyojuhi celKijukoGaku;
    @JsonProperty("celKijujunkoGaku")
    private celKijujunkoGakuAttblKyojuhi celKijujunkoGaku;
    @JsonProperty("celKijuTokuyoGaku")
    private celKijuTokuyoGakuAttblKyojuhi celKijuTokuyoGaku;
    @JsonProperty("celKijuRokenryoyoGaku")
    private celKijuRokenryoyoGakuAttblKyojuhi celKijuRokenryoyoGaku;
    @JsonProperty("celKijuTashoGaku")
    private celKijuTashoGakuAttblKyojuhi celKijuTashoGaku;
    @JsonProperty("celDaiyondankai")
    private celDaiyondankaiAttblKyojuhi celDaiyondankai;
    @JsonProperty("celFugengakunashi")
    private celFugengakunashiAttblKyojuhi celFugengakunashi;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblRiyoshafutan() {
        return this.celRiyoshafutan.getLblRiyoshafutan();
    }

    @JsonIgnore
    public Label getLblYunittokoshitsu() {
        return this.celYunittokoshitsu.getLblYunittokoshitsu();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsu() {
        return this.celYunitjunkoshitsu.getLblYunitjunkoshitsu();
    }

    @JsonIgnore
    public Label getLblJuraikoshitsu() {
        return this.celJuraikoshitsu.getLblJuraikoshitsu();
    }

    @JsonIgnore
    public Label getLblTasho() {
        return this.celTasho.getLblTasho();
    }

    @JsonIgnore
    public Label getLblTokuyo() {
        return this.cellTokuyo.getLblTokuyo();
    }

    @JsonIgnore
    public Label getLblRokenryoyo() {
        return this.celRokenryoyo.getLblRokenryoyo();
    }

    @JsonIgnore
    public Label getLblDaiichidankai() {
        return this.celDaiichidankai.getLblDaiichidankai();
    }

    @JsonIgnore
    public TextBox getTxtIchikoGaku() {
        return this.celIchikoGaku.getTxtIchikoGaku();
    }

    @JsonIgnore
    public TextBox getTxtIchijunkoGaku() {
        return this.celIchijunkoGaku.getTxtIchijunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtTokuyoGaku() {
        return this.celTokuyoGaku.getTxtTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtRokenryoyoGaku() {
        return this.celRokenryoyoGaku.getTxtRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtTashoGaku() {
        return this.celTashoGaku.getTxtTashoGaku();
    }

    @JsonIgnore
    public Label getLblDainidankai() {
        return this.celDainidankai.getLblDainidankai();
    }

    @JsonIgnore
    public TextBox getTxtNikoGaku() {
        return this.celNikoGaku.getTxtNikoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNijunkoGaku() {
        return this.celNijunkoGaku.getTxtNijunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiTokuyoGaku() {
        return this.celNiTokuyoGaku.getTxtNiTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiRokenryoyoGaku() {
        return this.celNiRokenryoyoGaku.getTxtNiRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiTashoGaku() {
        return this.celNiTashoGaku.getTxtNiTashoGaku();
    }

    @JsonIgnore
    public Label getLblDaisandankai() {
        return this.celDaisandankai.getLblDaisandankai();
    }

    @JsonIgnore
    public TextBox getTxtSankoGaku() {
        return this.celSankoGaku.getTxtSankoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanjunkoGaku() {
        return this.celSanjunkoGaku.getTxtSanjunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanTokuyoGaku() {
        return this.celSanTokuyoGaku.getTxtSanTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanRokenryoyoGaku() {
        return this.celSanRokenryoyoGaku.getTxtSanRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanTashoGaku() {
        return this.celSanTashoGaku.getTxtSanTashoGaku();
    }

    @JsonIgnore
    public Label getLblKijunhi() {
        return this.celKijunhi.getLblKijunhi();
    }

    @JsonIgnore
    public TextBox getTxtKijukoGaku() {
        return this.celKijukoGaku.getTxtKijukoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijujunkoGaku() {
        return this.celKijujunkoGaku.getTxtKijujunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuTokuyoGaku() {
        return this.celKijuTokuyoGaku.getTxtKijuTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuRokenryoyoGaku() {
        return this.celKijuRokenryoyoGaku.getTxtKijuRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuTashoGaku() {
        return this.celKijuTashoGaku.getTxtKijuTashoGaku();
    }

    @JsonIgnore
    public Label getDaiyondankai() {
        return this.celDaiyondankai.getDaiyondankai();
    }

    @JsonIgnore
    public Label getLblFugengakunashi() {
        return this.celFugengakunashi.getLblFugengakunashi();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celRiyoshafutan")
    private celRiyoshafutanAttblKyojuhi getCelRiyoshafutan() {
        return celRiyoshafutan;
    }

    @JsonProperty("celRiyoshafutan")
    private void setCelRiyoshafutan(celRiyoshafutanAttblKyojuhi celRiyoshafutan) {
        this.celRiyoshafutan=celRiyoshafutan;
    }

    @JsonProperty("celYunittokoshitsu")
    private celYunittokoshitsuAttblKyojuhi getCelYunittokoshitsu() {
        return celYunittokoshitsu;
    }

    @JsonProperty("celYunittokoshitsu")
    private void setCelYunittokoshitsu(celYunittokoshitsuAttblKyojuhi celYunittokoshitsu) {
        this.celYunittokoshitsu=celYunittokoshitsu;
    }

    @JsonProperty("celYunitjunkoshitsu")
    private celYunitjunkoshitsuAttblKyojuhi getCelYunitjunkoshitsu() {
        return celYunitjunkoshitsu;
    }

    @JsonProperty("celYunitjunkoshitsu")
    private void setCelYunitjunkoshitsu(celYunitjunkoshitsuAttblKyojuhi celYunitjunkoshitsu) {
        this.celYunitjunkoshitsu=celYunitjunkoshitsu;
    }

    @JsonProperty("celJuraikoshitsu")
    private celJuraikoshitsuAttblKyojuhi getCelJuraikoshitsu() {
        return celJuraikoshitsu;
    }

    @JsonProperty("celJuraikoshitsu")
    private void setCelJuraikoshitsu(celJuraikoshitsuAttblKyojuhi celJuraikoshitsu) {
        this.celJuraikoshitsu=celJuraikoshitsu;
    }

    @JsonProperty("celTasho")
    private celTashoAttblKyojuhi getCelTasho() {
        return celTasho;
    }

    @JsonProperty("celTasho")
    private void setCelTasho(celTashoAttblKyojuhi celTasho) {
        this.celTasho=celTasho;
    }

    @JsonProperty("cellTokuyo")
    private cellTokuyoAttblKyojuhi getCellTokuyo() {
        return cellTokuyo;
    }

    @JsonProperty("cellTokuyo")
    private void setCellTokuyo(cellTokuyoAttblKyojuhi cellTokuyo) {
        this.cellTokuyo=cellTokuyo;
    }

    @JsonProperty("celRokenryoyo")
    private celRokenryoyoAttblKyojuhi getCelRokenryoyo() {
        return celRokenryoyo;
    }

    @JsonProperty("celRokenryoyo")
    private void setCelRokenryoyo(celRokenryoyoAttblKyojuhi celRokenryoyo) {
        this.celRokenryoyo=celRokenryoyo;
    }

    @JsonProperty("celDaiichidankai")
    private celDaiichidankaiAttblKyojuhi getCelDaiichidankai() {
        return celDaiichidankai;
    }

    @JsonProperty("celDaiichidankai")
    private void setCelDaiichidankai(celDaiichidankaiAttblKyojuhi celDaiichidankai) {
        this.celDaiichidankai=celDaiichidankai;
    }

    @JsonProperty("celIchikoGaku")
    private celIchikoGakuAttblKyojuhi getCelIchikoGaku() {
        return celIchikoGaku;
    }

    @JsonProperty("celIchikoGaku")
    private void setCelIchikoGaku(celIchikoGakuAttblKyojuhi celIchikoGaku) {
        this.celIchikoGaku=celIchikoGaku;
    }

    @JsonProperty("celIchijunkoGaku")
    private celIchijunkoGakuAttblKyojuhi getCelIchijunkoGaku() {
        return celIchijunkoGaku;
    }

    @JsonProperty("celIchijunkoGaku")
    private void setCelIchijunkoGaku(celIchijunkoGakuAttblKyojuhi celIchijunkoGaku) {
        this.celIchijunkoGaku=celIchijunkoGaku;
    }

    @JsonProperty("celTokuyoGaku")
    private celTokuyoGakuAttblKyojuhi getCelTokuyoGaku() {
        return celTokuyoGaku;
    }

    @JsonProperty("celTokuyoGaku")
    private void setCelTokuyoGaku(celTokuyoGakuAttblKyojuhi celTokuyoGaku) {
        this.celTokuyoGaku=celTokuyoGaku;
    }

    @JsonProperty("celRokenryoyoGaku")
    private celRokenryoyoGakuAttblKyojuhi getCelRokenryoyoGaku() {
        return celRokenryoyoGaku;
    }

    @JsonProperty("celRokenryoyoGaku")
    private void setCelRokenryoyoGaku(celRokenryoyoGakuAttblKyojuhi celRokenryoyoGaku) {
        this.celRokenryoyoGaku=celRokenryoyoGaku;
    }

    @JsonProperty("celTashoGaku")
    private celTashoGakuAttblKyojuhi getCelTashoGaku() {
        return celTashoGaku;
    }

    @JsonProperty("celTashoGaku")
    private void setCelTashoGaku(celTashoGakuAttblKyojuhi celTashoGaku) {
        this.celTashoGaku=celTashoGaku;
    }

    @JsonProperty("celDainidankai")
    private celDainidankaiAttblKyojuhi getCelDainidankai() {
        return celDainidankai;
    }

    @JsonProperty("celDainidankai")
    private void setCelDainidankai(celDainidankaiAttblKyojuhi celDainidankai) {
        this.celDainidankai=celDainidankai;
    }

    @JsonProperty("celNikoGaku")
    private celNikoGakuAttblKyojuhi getCelNikoGaku() {
        return celNikoGaku;
    }

    @JsonProperty("celNikoGaku")
    private void setCelNikoGaku(celNikoGakuAttblKyojuhi celNikoGaku) {
        this.celNikoGaku=celNikoGaku;
    }

    @JsonProperty("celNijunkoGaku")
    private celNijunkoGakuAttblKyojuhi getCelNijunkoGaku() {
        return celNijunkoGaku;
    }

    @JsonProperty("celNijunkoGaku")
    private void setCelNijunkoGaku(celNijunkoGakuAttblKyojuhi celNijunkoGaku) {
        this.celNijunkoGaku=celNijunkoGaku;
    }

    @JsonProperty("celNiTokuyoGaku")
    private celNiTokuyoGakuAttblKyojuhi getCelNiTokuyoGaku() {
        return celNiTokuyoGaku;
    }

    @JsonProperty("celNiTokuyoGaku")
    private void setCelNiTokuyoGaku(celNiTokuyoGakuAttblKyojuhi celNiTokuyoGaku) {
        this.celNiTokuyoGaku=celNiTokuyoGaku;
    }

    @JsonProperty("celNiRokenryoyoGaku")
    private celNiRokenryoyoGakuAttblKyojuhi getCelNiRokenryoyoGaku() {
        return celNiRokenryoyoGaku;
    }

    @JsonProperty("celNiRokenryoyoGaku")
    private void setCelNiRokenryoyoGaku(celNiRokenryoyoGakuAttblKyojuhi celNiRokenryoyoGaku) {
        this.celNiRokenryoyoGaku=celNiRokenryoyoGaku;
    }

    @JsonProperty("celNiTashoGaku")
    private celNiTashoGakuAttblKyojuhi getCelNiTashoGaku() {
        return celNiTashoGaku;
    }

    @JsonProperty("celNiTashoGaku")
    private void setCelNiTashoGaku(celNiTashoGakuAttblKyojuhi celNiTashoGaku) {
        this.celNiTashoGaku=celNiTashoGaku;
    }

    @JsonProperty("celDaisandankai")
    private celDaisandankaiAttblKyojuhi getCelDaisandankai() {
        return celDaisandankai;
    }

    @JsonProperty("celDaisandankai")
    private void setCelDaisandankai(celDaisandankaiAttblKyojuhi celDaisandankai) {
        this.celDaisandankai=celDaisandankai;
    }

    @JsonProperty("celSankoGaku")
    private celSankoGakuAttblKyojuhi getCelSankoGaku() {
        return celSankoGaku;
    }

    @JsonProperty("celSankoGaku")
    private void setCelSankoGaku(celSankoGakuAttblKyojuhi celSankoGaku) {
        this.celSankoGaku=celSankoGaku;
    }

    @JsonProperty("celSanjunkoGaku")
    private celSanjunkoGakuAttblKyojuhi getCelSanjunkoGaku() {
        return celSanjunkoGaku;
    }

    @JsonProperty("celSanjunkoGaku")
    private void setCelSanjunkoGaku(celSanjunkoGakuAttblKyojuhi celSanjunkoGaku) {
        this.celSanjunkoGaku=celSanjunkoGaku;
    }

    @JsonProperty("celSanTokuyoGaku")
    private celSanTokuyoGakuAttblKyojuhi getCelSanTokuyoGaku() {
        return celSanTokuyoGaku;
    }

    @JsonProperty("celSanTokuyoGaku")
    private void setCelSanTokuyoGaku(celSanTokuyoGakuAttblKyojuhi celSanTokuyoGaku) {
        this.celSanTokuyoGaku=celSanTokuyoGaku;
    }

    @JsonProperty("celSanRokenryoyoGaku")
    private celSanRokenryoyoGakuAttblKyojuhi getCelSanRokenryoyoGaku() {
        return celSanRokenryoyoGaku;
    }

    @JsonProperty("celSanRokenryoyoGaku")
    private void setCelSanRokenryoyoGaku(celSanRokenryoyoGakuAttblKyojuhi celSanRokenryoyoGaku) {
        this.celSanRokenryoyoGaku=celSanRokenryoyoGaku;
    }

    @JsonProperty("celSanTashoGaku")
    private celSanTashoGakuAttblKyojuhi getCelSanTashoGaku() {
        return celSanTashoGaku;
    }

    @JsonProperty("celSanTashoGaku")
    private void setCelSanTashoGaku(celSanTashoGakuAttblKyojuhi celSanTashoGaku) {
        this.celSanTashoGaku=celSanTashoGaku;
    }

    @JsonProperty("celKijunhi")
    private celKijunhiAttblKyojuhi getCelKijunhi() {
        return celKijunhi;
    }

    @JsonProperty("celKijunhi")
    private void setCelKijunhi(celKijunhiAttblKyojuhi celKijunhi) {
        this.celKijunhi=celKijunhi;
    }

    @JsonProperty("celKijukoGaku")
    private celKijukoGakuAttblKyojuhi getCelKijukoGaku() {
        return celKijukoGaku;
    }

    @JsonProperty("celKijukoGaku")
    private void setCelKijukoGaku(celKijukoGakuAttblKyojuhi celKijukoGaku) {
        this.celKijukoGaku=celKijukoGaku;
    }

    @JsonProperty("celKijujunkoGaku")
    private celKijujunkoGakuAttblKyojuhi getCelKijujunkoGaku() {
        return celKijujunkoGaku;
    }

    @JsonProperty("celKijujunkoGaku")
    private void setCelKijujunkoGaku(celKijujunkoGakuAttblKyojuhi celKijujunkoGaku) {
        this.celKijujunkoGaku=celKijujunkoGaku;
    }

    @JsonProperty("celKijuTokuyoGaku")
    private celKijuTokuyoGakuAttblKyojuhi getCelKijuTokuyoGaku() {
        return celKijuTokuyoGaku;
    }

    @JsonProperty("celKijuTokuyoGaku")
    private void setCelKijuTokuyoGaku(celKijuTokuyoGakuAttblKyojuhi celKijuTokuyoGaku) {
        this.celKijuTokuyoGaku=celKijuTokuyoGaku;
    }

    @JsonProperty("celKijuRokenryoyoGaku")
    private celKijuRokenryoyoGakuAttblKyojuhi getCelKijuRokenryoyoGaku() {
        return celKijuRokenryoyoGaku;
    }

    @JsonProperty("celKijuRokenryoyoGaku")
    private void setCelKijuRokenryoyoGaku(celKijuRokenryoyoGakuAttblKyojuhi celKijuRokenryoyoGaku) {
        this.celKijuRokenryoyoGaku=celKijuRokenryoyoGaku;
    }

    @JsonProperty("celKijuTashoGaku")
    private celKijuTashoGakuAttblKyojuhi getCelKijuTashoGaku() {
        return celKijuTashoGaku;
    }

    @JsonProperty("celKijuTashoGaku")
    private void setCelKijuTashoGaku(celKijuTashoGakuAttblKyojuhi celKijuTashoGaku) {
        this.celKijuTashoGaku=celKijuTashoGaku;
    }

    @JsonProperty("celDaiyondankai")
    private celDaiyondankaiAttblKyojuhi getCelDaiyondankai() {
        return celDaiyondankai;
    }

    @JsonProperty("celDaiyondankai")
    private void setCelDaiyondankai(celDaiyondankaiAttblKyojuhi celDaiyondankai) {
        this.celDaiyondankai=celDaiyondankai;
    }

    @JsonProperty("celFugengakunashi")
    private celFugengakunashiAttblKyojuhi getCelFugengakunashi() {
        return celFugengakunashi;
    }

    @JsonProperty("celFugengakunashi")
    private void setCelFugengakunashi(celFugengakunashiAttblKyojuhi celFugengakunashi) {
        this.celFugengakunashi=celFugengakunashi;
    }

}
/**
 * celRiyoshafutan のクラスファイル 
 * 
 * @author 自動生成
 */
class celRiyoshafutanAttblKyojuhi extends TableCell {
    @JsonProperty("lblRiyoshafutan")
    private Label lblRiyoshafutan;

    @JsonProperty("lblRiyoshafutan")
    public Label getLblRiyoshafutan() {
        return lblRiyoshafutan;
    }

    @JsonProperty("lblRiyoshafutan")
    public void setLblRiyoshafutan(Label lblRiyoshafutan) {
        this.lblRiyoshafutan=lblRiyoshafutan;
    }

}
/**
 * celYunittokoshitsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celYunittokoshitsuAttblKyojuhi extends TableCell {
    @JsonProperty("lblYunittokoshitsu")
    private Label lblYunittokoshitsu;

    @JsonProperty("lblYunittokoshitsu")
    public Label getLblYunittokoshitsu() {
        return lblYunittokoshitsu;
    }

    @JsonProperty("lblYunittokoshitsu")
    public void setLblYunittokoshitsu(Label lblYunittokoshitsu) {
        this.lblYunittokoshitsu=lblYunittokoshitsu;
    }

}
/**
 * celYunitjunkoshitsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celYunitjunkoshitsuAttblKyojuhi extends TableCell {
    @JsonProperty("lblYunitjunkoshitsu")
    private Label lblYunitjunkoshitsu;

    @JsonProperty("lblYunitjunkoshitsu")
    public Label getLblYunitjunkoshitsu() {
        return lblYunitjunkoshitsu;
    }

    @JsonProperty("lblYunitjunkoshitsu")
    public void setLblYunitjunkoshitsu(Label lblYunitjunkoshitsu) {
        this.lblYunitjunkoshitsu=lblYunitjunkoshitsu;
    }

}
/**
 * celJuraikoshitsu のクラスファイル 
 * 
 * @author 自動生成
 */
class celJuraikoshitsuAttblKyojuhi extends TableCell {
    @JsonProperty("lblJuraikoshitsu")
    private Label lblJuraikoshitsu;

    @JsonProperty("lblJuraikoshitsu")
    public Label getLblJuraikoshitsu() {
        return lblJuraikoshitsu;
    }

    @JsonProperty("lblJuraikoshitsu")
    public void setLblJuraikoshitsu(Label lblJuraikoshitsu) {
        this.lblJuraikoshitsu=lblJuraikoshitsu;
    }

}
/**
 * celTasho のクラスファイル 
 * 
 * @author 自動生成
 */
class celTashoAttblKyojuhi extends TableCell {
    @JsonProperty("lblTasho")
    private Label lblTasho;

    @JsonProperty("lblTasho")
    public Label getLblTasho() {
        return lblTasho;
    }

    @JsonProperty("lblTasho")
    public void setLblTasho(Label lblTasho) {
        this.lblTasho=lblTasho;
    }

}
/**
 * cellTokuyo のクラスファイル 
 * 
 * @author 自動生成
 */
class cellTokuyoAttblKyojuhi extends TableCell {
    @JsonProperty("lblTokuyo")
    private Label lblTokuyo;

    @JsonProperty("lblTokuyo")
    public Label getLblTokuyo() {
        return lblTokuyo;
    }

    @JsonProperty("lblTokuyo")
    public void setLblTokuyo(Label lblTokuyo) {
        this.lblTokuyo=lblTokuyo;
    }

}
/**
 * celRokenryoyo のクラスファイル 
 * 
 * @author 自動生成
 */
class celRokenryoyoAttblKyojuhi extends TableCell {
    @JsonProperty("lblRokenryoyo")
    private Label lblRokenryoyo;

    @JsonProperty("lblRokenryoyo")
    public Label getLblRokenryoyo() {
        return lblRokenryoyo;
    }

    @JsonProperty("lblRokenryoyo")
    public void setLblRokenryoyo(Label lblRokenryoyo) {
        this.lblRokenryoyo=lblRokenryoyo;
    }

}
/**
 * celDaiichidankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celDaiichidankaiAttblKyojuhi extends TableCell {
    @JsonProperty("lblDaiichidankai")
    private Label lblDaiichidankai;

    @JsonProperty("lblDaiichidankai")
    public Label getLblDaiichidankai() {
        return lblDaiichidankai;
    }

    @JsonProperty("lblDaiichidankai")
    public void setLblDaiichidankai(Label lblDaiichidankai) {
        this.lblDaiichidankai=lblDaiichidankai;
    }

}
/**
 * celIchikoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celIchikoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtIchikoGaku")
    private TextBox txtIchikoGaku;

    @JsonProperty("txtIchikoGaku")
    public TextBox getTxtIchikoGaku() {
        return txtIchikoGaku;
    }

    @JsonProperty("txtIchikoGaku")
    public void setTxtIchikoGaku(TextBox txtIchikoGaku) {
        this.txtIchikoGaku=txtIchikoGaku;
    }

}
/**
 * celIchijunkoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celIchijunkoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtIchijunkoGaku")
    private TextBox txtIchijunkoGaku;

    @JsonProperty("txtIchijunkoGaku")
    public TextBox getTxtIchijunkoGaku() {
        return txtIchijunkoGaku;
    }

    @JsonProperty("txtIchijunkoGaku")
    public void setTxtIchijunkoGaku(TextBox txtIchijunkoGaku) {
        this.txtIchijunkoGaku=txtIchijunkoGaku;
    }

}
/**
 * celTokuyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celTokuyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtTokuyoGaku")
    private TextBox txtTokuyoGaku;

    @JsonProperty("txtTokuyoGaku")
    public TextBox getTxtTokuyoGaku() {
        return txtTokuyoGaku;
    }

    @JsonProperty("txtTokuyoGaku")
    public void setTxtTokuyoGaku(TextBox txtTokuyoGaku) {
        this.txtTokuyoGaku=txtTokuyoGaku;
    }

}
/**
 * celRokenryoyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celRokenryoyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtRokenryoyoGaku")
    private TextBox txtRokenryoyoGaku;

    @JsonProperty("txtRokenryoyoGaku")
    public TextBox getTxtRokenryoyoGaku() {
        return txtRokenryoyoGaku;
    }

    @JsonProperty("txtRokenryoyoGaku")
    public void setTxtRokenryoyoGaku(TextBox txtRokenryoyoGaku) {
        this.txtRokenryoyoGaku=txtRokenryoyoGaku;
    }

}
/**
 * celTashoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celTashoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtTashoGaku")
    private TextBox txtTashoGaku;

    @JsonProperty("txtTashoGaku")
    public TextBox getTxtTashoGaku() {
        return txtTashoGaku;
    }

    @JsonProperty("txtTashoGaku")
    public void setTxtTashoGaku(TextBox txtTashoGaku) {
        this.txtTashoGaku=txtTashoGaku;
    }

}
/**
 * celDainidankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celDainidankaiAttblKyojuhi extends TableCell {
    @JsonProperty("lblDainidankai")
    private Label lblDainidankai;

    @JsonProperty("lblDainidankai")
    public Label getLblDainidankai() {
        return lblDainidankai;
    }

    @JsonProperty("lblDainidankai")
    public void setLblDainidankai(Label lblDainidankai) {
        this.lblDainidankai=lblDainidankai;
    }

}
/**
 * celNikoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNikoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtNikoGaku")
    private TextBox txtNikoGaku;

    @JsonProperty("txtNikoGaku")
    public TextBox getTxtNikoGaku() {
        return txtNikoGaku;
    }

    @JsonProperty("txtNikoGaku")
    public void setTxtNikoGaku(TextBox txtNikoGaku) {
        this.txtNikoGaku=txtNikoGaku;
    }

}
/**
 * celNijunkoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNijunkoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtNijunkoGaku")
    private TextBox txtNijunkoGaku;

    @JsonProperty("txtNijunkoGaku")
    public TextBox getTxtNijunkoGaku() {
        return txtNijunkoGaku;
    }

    @JsonProperty("txtNijunkoGaku")
    public void setTxtNijunkoGaku(TextBox txtNijunkoGaku) {
        this.txtNijunkoGaku=txtNijunkoGaku;
    }

}
/**
 * celNiTokuyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNiTokuyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtNiTokuyoGaku")
    private TextBox txtNiTokuyoGaku;

    @JsonProperty("txtNiTokuyoGaku")
    public TextBox getTxtNiTokuyoGaku() {
        return txtNiTokuyoGaku;
    }

    @JsonProperty("txtNiTokuyoGaku")
    public void setTxtNiTokuyoGaku(TextBox txtNiTokuyoGaku) {
        this.txtNiTokuyoGaku=txtNiTokuyoGaku;
    }

}
/**
 * celNiRokenryoyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNiRokenryoyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtNiRokenryoyoGaku")
    private TextBox txtNiRokenryoyoGaku;

    @JsonProperty("txtNiRokenryoyoGaku")
    public TextBox getTxtNiRokenryoyoGaku() {
        return txtNiRokenryoyoGaku;
    }

    @JsonProperty("txtNiRokenryoyoGaku")
    public void setTxtNiRokenryoyoGaku(TextBox txtNiRokenryoyoGaku) {
        this.txtNiRokenryoyoGaku=txtNiRokenryoyoGaku;
    }

}
/**
 * celNiTashoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNiTashoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtNiTashoGaku")
    private TextBox txtNiTashoGaku;

    @JsonProperty("txtNiTashoGaku")
    public TextBox getTxtNiTashoGaku() {
        return txtNiTashoGaku;
    }

    @JsonProperty("txtNiTashoGaku")
    public void setTxtNiTashoGaku(TextBox txtNiTashoGaku) {
        this.txtNiTashoGaku=txtNiTashoGaku;
    }

}
/**
 * celDaisandankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celDaisandankaiAttblKyojuhi extends TableCell {
    @JsonProperty("lblDaisandankai")
    private Label lblDaisandankai;

    @JsonProperty("lblDaisandankai")
    public Label getLblDaisandankai() {
        return lblDaisandankai;
    }

    @JsonProperty("lblDaisandankai")
    public void setLblDaisandankai(Label lblDaisandankai) {
        this.lblDaisandankai=lblDaisandankai;
    }

}
/**
 * celSankoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celSankoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtSankoGaku")
    private TextBox txtSankoGaku;

    @JsonProperty("txtSankoGaku")
    public TextBox getTxtSankoGaku() {
        return txtSankoGaku;
    }

    @JsonProperty("txtSankoGaku")
    public void setTxtSankoGaku(TextBox txtSankoGaku) {
        this.txtSankoGaku=txtSankoGaku;
    }

}
/**
 * celSanjunkoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celSanjunkoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtSanjunkoGaku")
    private TextBox txtSanjunkoGaku;

    @JsonProperty("txtSanjunkoGaku")
    public TextBox getTxtSanjunkoGaku() {
        return txtSanjunkoGaku;
    }

    @JsonProperty("txtSanjunkoGaku")
    public void setTxtSanjunkoGaku(TextBox txtSanjunkoGaku) {
        this.txtSanjunkoGaku=txtSanjunkoGaku;
    }

}
/**
 * celSanTokuyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celSanTokuyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtSanTokuyoGaku")
    private TextBox txtSanTokuyoGaku;

    @JsonProperty("txtSanTokuyoGaku")
    public TextBox getTxtSanTokuyoGaku() {
        return txtSanTokuyoGaku;
    }

    @JsonProperty("txtSanTokuyoGaku")
    public void setTxtSanTokuyoGaku(TextBox txtSanTokuyoGaku) {
        this.txtSanTokuyoGaku=txtSanTokuyoGaku;
    }

}
/**
 * celSanRokenryoyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celSanRokenryoyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtSanRokenryoyoGaku")
    private TextBox txtSanRokenryoyoGaku;

    @JsonProperty("txtSanRokenryoyoGaku")
    public TextBox getTxtSanRokenryoyoGaku() {
        return txtSanRokenryoyoGaku;
    }

    @JsonProperty("txtSanRokenryoyoGaku")
    public void setTxtSanRokenryoyoGaku(TextBox txtSanRokenryoyoGaku) {
        this.txtSanRokenryoyoGaku=txtSanRokenryoyoGaku;
    }

}
/**
 * celSanTashoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celSanTashoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtSanTashoGaku")
    private TextBox txtSanTashoGaku;

    @JsonProperty("txtSanTashoGaku")
    public TextBox getTxtSanTashoGaku() {
        return txtSanTashoGaku;
    }

    @JsonProperty("txtSanTashoGaku")
    public void setTxtSanTashoGaku(TextBox txtSanTashoGaku) {
        this.txtSanTashoGaku=txtSanTashoGaku;
    }

}
/**
 * celKijunhi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijunhiAttblKyojuhi extends TableCell {
    @JsonProperty("lblKijunhi")
    private Label lblKijunhi;

    @JsonProperty("lblKijunhi")
    public Label getLblKijunhi() {
        return lblKijunhi;
    }

    @JsonProperty("lblKijunhi")
    public void setLblKijunhi(Label lblKijunhi) {
        this.lblKijunhi=lblKijunhi;
    }

}
/**
 * celKijukoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijukoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtKijukoGaku")
    private TextBox txtKijukoGaku;

    @JsonProperty("txtKijukoGaku")
    public TextBox getTxtKijukoGaku() {
        return txtKijukoGaku;
    }

    @JsonProperty("txtKijukoGaku")
    public void setTxtKijukoGaku(TextBox txtKijukoGaku) {
        this.txtKijukoGaku=txtKijukoGaku;
    }

}
/**
 * celKijujunkoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijujunkoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtKijujunkoGaku")
    private TextBox txtKijujunkoGaku;

    @JsonProperty("txtKijujunkoGaku")
    public TextBox getTxtKijujunkoGaku() {
        return txtKijujunkoGaku;
    }

    @JsonProperty("txtKijujunkoGaku")
    public void setTxtKijujunkoGaku(TextBox txtKijujunkoGaku) {
        this.txtKijujunkoGaku=txtKijujunkoGaku;
    }

}
/**
 * celKijuTokuyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijuTokuyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtKijuTokuyoGaku")
    private TextBox txtKijuTokuyoGaku;

    @JsonProperty("txtKijuTokuyoGaku")
    public TextBox getTxtKijuTokuyoGaku() {
        return txtKijuTokuyoGaku;
    }

    @JsonProperty("txtKijuTokuyoGaku")
    public void setTxtKijuTokuyoGaku(TextBox txtKijuTokuyoGaku) {
        this.txtKijuTokuyoGaku=txtKijuTokuyoGaku;
    }

}
/**
 * celKijuRokenryoyoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijuRokenryoyoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtKijuRokenryoyoGaku")
    private TextBox txtKijuRokenryoyoGaku;

    @JsonProperty("txtKijuRokenryoyoGaku")
    public TextBox getTxtKijuRokenryoyoGaku() {
        return txtKijuRokenryoyoGaku;
    }

    @JsonProperty("txtKijuRokenryoyoGaku")
    public void setTxtKijuRokenryoyoGaku(TextBox txtKijuRokenryoyoGaku) {
        this.txtKijuRokenryoyoGaku=txtKijuRokenryoyoGaku;
    }

}
/**
 * celKijuTashoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKijuTashoGakuAttblKyojuhi extends TableCell {
    @JsonProperty("txtKijuTashoGaku")
    private TextBox txtKijuTashoGaku;

    @JsonProperty("txtKijuTashoGaku")
    public TextBox getTxtKijuTashoGaku() {
        return txtKijuTashoGaku;
    }

    @JsonProperty("txtKijuTashoGaku")
    public void setTxtKijuTashoGaku(TextBox txtKijuTashoGaku) {
        this.txtKijuTashoGaku=txtKijuTashoGaku;
    }

}
/**
 * celDaiyondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celDaiyondankaiAttblKyojuhi extends TableCell {
    @JsonProperty("Daiyondankai")
    private Label Daiyondankai;

    @JsonProperty("Daiyondankai")
    public Label getDaiyondankai() {
        return Daiyondankai;
    }

    @JsonProperty("Daiyondankai")
    public void setDaiyondankai(Label Daiyondankai) {
        this.Daiyondankai=Daiyondankai;
    }

}
/**
 * celFugengakunashi のクラスファイル 
 * 
 * @author 自動生成
 */
class celFugengakunashiAttblKyojuhi extends TableCell {
    @JsonProperty("lblFugengakunashi")
    private Label lblFugengakunashi;

    @JsonProperty("lblFugengakunashi")
    public Label getLblFugengakunashi() {
        return lblFugengakunashi;
    }

    @JsonProperty("lblFugengakunashi")
    public void setLblFugengakunashi(Label lblFugengakunashi) {
        this.lblFugengakunashi=lblFugengakunashi;
    }

}
