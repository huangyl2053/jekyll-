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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
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
    public Icon getIcoDaiichiKoshitsu() {
        return this.getTblKyojuhi().getIcoDaiichiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsu() {
        return this.getTblKyojuhi().getTxtDaiichiKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaiichiJunKoshitsu() {
        return this.getTblKyojuhi().getIcoDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaiichiTokuyo() {
        return this.getTblKyojuhi().getIcoDaiichiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyo() {
        return this.getTblKyojuhi().getTxtDaiichiTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDaiichiRokenRyoyogata() {
        return this.getTblKyojuhi().getIcoDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDaiichiTashoshitsu() {
        return this.getTblKyojuhi().getIcoDaiichiTashoshitsu();
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
    public Icon getIcoDainiKoshitsu() {
        return this.getTblKyojuhi().getIcoDainiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsu() {
        return this.getTblKyojuhi().getTxtDainiKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDainiJunKoshitsu() {
        return this.getTblKyojuhi().getIcoDainiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDainiJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDainiTokuyo() {
        return this.getTblKyojuhi().getIcoDainiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDainiTokuyo() {
        return this.getTblKyojuhi().getTxtDainiTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDainiRokenRyoyogata() {
        return this.getTblKyojuhi().getIcoDainiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDainiRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDainiRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDainiTashoshitsu() {
        return this.getTblKyojuhi().getIcoDainiTashoshitsu();
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
    public Icon getIcoDaisanKoshitsu() {
        return this.getTblKyojuhi().getIcoDaisanKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsu() {
        return this.getTblKyojuhi().getTxtDaisanKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaisanJunKoshitsu() {
        return this.getTblKyojuhi().getIcoDaisanJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsu() {
        return this.getTblKyojuhi().getTxtDaisanJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaisanTokuyo() {
        return this.getTblKyojuhi().getIcoDaisanTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyo() {
        return this.getTblKyojuhi().getTxtDaisanTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDaisanRokenRyoyogata() {
        return this.getTblKyojuhi().getIcoDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaisanRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDaisanTashoshitsu() {
        return this.getTblKyojuhi().getIcoDaisanTashoshitsu();
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
    public Icon getIcoKijunHiyogakuKoshitsu() {
        return this.getTblKyojuhi().getIcoKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsu() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuJunKoshitsu() {
        return this.getTblKyojuhi().getIcoKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsu() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuTokuyo() {
        return this.getTblKyojuhi().getIcoKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyo() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuRokenRyoyogata() {
        return this.getTblKyojuhi().getIcoKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuRokenRyoyogata() {
        return this.getTblKyojuhi().getTxtKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuTashoshitsu() {
        return this.getTblKyojuhi().getIcoKijunHiyogakuTashoshitsu();
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
