package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.tblKyojuhiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Kyojuhi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyojuhiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyojuhi")
    private tblKyojuhiDiv tblKyojuhi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyojuhi")
    public tblKyojuhiDiv getTblKyojuhi() {
        return tblKyojuhi;
    }

    @JsonProperty("tblKyojuhi")
    public void setTblKyojuhi(tblKyojuhiDiv tblKyojuhi) {
        this.tblKyojuhi=tblKyojuhi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblRiyoshafutan() {
        return this.getTblKyojuhi().getLblRiyoshafutan();
    }

    @JsonIgnore
    public Label getLblYunittokoshitsu() {
        return this.getTblKyojuhi().getLblYunittokoshitsu();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsu() {
        return this.getTblKyojuhi().getLblYunitjunkoshitsu();
    }

    @JsonIgnore
    public Label getLblJuraikoshitsu() {
        return this.getTblKyojuhi().getLblJuraikoshitsu();
    }

    @JsonIgnore
    public Label getLblTasho() {
        return this.getTblKyojuhi().getLblTasho();
    }

    @JsonIgnore
    public Label getLblTokuyo() {
        return this.getTblKyojuhi().getLblTokuyo();
    }

    @JsonIgnore
    public Label getLblRokenryoyo() {
        return this.getTblKyojuhi().getLblRokenryoyo();
    }

    @JsonIgnore
    public Label getLblDaiichidankai() {
        return this.getTblKyojuhi().getLblDaiichidankai();
    }

    @JsonIgnore
    public TextBox getTxtIchikoGaku() {
        return this.getTblKyojuhi().getTxtIchikoGaku();
    }

    @JsonIgnore
    public TextBox getTxtIchijunkoGaku() {
        return this.getTblKyojuhi().getTxtIchijunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtTokuyoGaku() {
        return this.getTblKyojuhi().getTxtTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtRokenryoyoGaku() {
        return this.getTblKyojuhi().getTxtRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtTashoGaku() {
        return this.getTblKyojuhi().getTxtTashoGaku();
    }

    @JsonIgnore
    public Label getLblDainidankai() {
        return this.getTblKyojuhi().getLblDainidankai();
    }

    @JsonIgnore
    public TextBox getTxtNikoGaku() {
        return this.getTblKyojuhi().getTxtNikoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNijunkoGaku() {
        return this.getTblKyojuhi().getTxtNijunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiTokuyoGaku() {
        return this.getTblKyojuhi().getTxtNiTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiRokenryoyoGaku() {
        return this.getTblKyojuhi().getTxtNiRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtNiTashoGaku() {
        return this.getTblKyojuhi().getTxtNiTashoGaku();
    }

    @JsonIgnore
    public Label getLblDaisandankai() {
        return this.getTblKyojuhi().getLblDaisandankai();
    }

    @JsonIgnore
    public TextBox getTxtSankoGaku() {
        return this.getTblKyojuhi().getTxtSankoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanjunkoGaku() {
        return this.getTblKyojuhi().getTxtSanjunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanTokuyoGaku() {
        return this.getTblKyojuhi().getTxtSanTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanRokenryoyoGaku() {
        return this.getTblKyojuhi().getTxtSanRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtSanTashoGaku() {
        return this.getTblKyojuhi().getTxtSanTashoGaku();
    }

    @JsonIgnore
    public Label getLblKijunhi() {
        return this.getTblKyojuhi().getLblKijunhi();
    }

    @JsonIgnore
    public TextBox getTxtKijukoGaku() {
        return this.getTblKyojuhi().getTxtKijukoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijujunkoGaku() {
        return this.getTblKyojuhi().getTxtKijujunkoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuTokuyoGaku() {
        return this.getTblKyojuhi().getTxtKijuTokuyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuRokenryoyoGaku() {
        return this.getTblKyojuhi().getTxtKijuRokenryoyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijuTashoGaku() {
        return this.getTblKyojuhi().getTxtKijuTashoGaku();
    }

    @JsonIgnore
    public Label getDaiyondankai() {
        return this.getTblKyojuhi().getDaiyondankai();
    }

    @JsonIgnore
    public Label getLblFugengakunashi() {
        return this.getTblKyojuhi().getLblFugengakunashi();
    }

}
