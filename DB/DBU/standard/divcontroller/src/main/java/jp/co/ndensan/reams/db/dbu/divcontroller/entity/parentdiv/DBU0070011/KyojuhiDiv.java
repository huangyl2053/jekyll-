package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kyojuhi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyojuhiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    /*
     * gettblKyojuhi
     * @return tblKyojuhi
     */
    @JsonProperty("tblKyojuhi")
    public tblKyojuhiDiv getTblKyojuhi() {
        return tblKyojuhi;
    }

    /*
     * settblKyojuhi
     * @param tblKyojuhi tblKyojuhi
     */
    @JsonProperty("tblKyojuhi")
    public void setTblKyojuhi(tblKyojuhiDiv tblKyojuhi) {
        this.tblKyojuhi = tblKyojuhi;
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
    public TextBox getTxtDaiichiKoshitsu() {
        return this.getTblKyojuhi().getTxtDaiichiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyo() {
        return this.getTblKyojuhi().getTxtDaiichiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsu() {
        return this.getTblKyojuhi().getTxtDaiichiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDainidankai() {
        return this.getTblKyojuhi().getLblDainidankai();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsu() {
        return this.getTblKyojuhi().getTxtDainiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDainiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiTokuyo() {
        return this.getTblKyojuhi().getTxtDainiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDainiRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDainiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDainiTashoshitsu() {
        return this.getTblKyojuhi().getTxtDainiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaisandankai() {
        return this.getTblKyojuhi().getLblDaisandankai();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsu() {
        return this.getTblKyojuhi().getTxtDaisanKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDaisanJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyo() {
        return this.getTblKyojuhi().getTxtDaisanTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaisanRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsu() {
        return this.getTblKyojuhi().getTxtDaisanTashoshitsu();
    }

    @JsonIgnore
    public Label getLblKijunhiyoGaku() {
        return this.getTblKyojuhi().getLblKijunhiyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsu() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsu() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyo() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsu() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaiyondankai() {
        return this.getTblKyojuhi().getLblDaiyondankai();
    }

    @JsonIgnore
    public Label getLblFutanGengakuNashi() {
        return this.getTblKyojuhi().getLblFutanGengakuNashi();
    }

    // </editor-fold>
}
