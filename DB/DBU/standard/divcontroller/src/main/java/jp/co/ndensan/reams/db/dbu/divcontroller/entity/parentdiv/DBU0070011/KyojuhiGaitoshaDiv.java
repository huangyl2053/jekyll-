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
 * KyojuhiGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyojuhiGaitoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyojuhiGaitosha")
    private tblKyojuhiGaitoshaDiv tblKyojuhiGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKyojuhiGaitosha
     * @return tblKyojuhiGaitosha
     */
    @JsonProperty("tblKyojuhiGaitosha")
    public tblKyojuhiGaitoshaDiv getTblKyojuhiGaitosha() {
        return tblKyojuhiGaitosha;
    }

    /*
     * settblKyojuhiGaitosha
     * @param tblKyojuhiGaitosha tblKyojuhiGaitosha
     */
    @JsonProperty("tblKyojuhiGaitosha")
    public void setTblKyojuhiGaitosha(tblKyojuhiGaitoshaDiv tblKyojuhiGaitosha) {
        this.tblKyojuhiGaitosha = tblKyojuhiGaitosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblYunittokoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getLblYunittokoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getLblYunitjunkoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getLblTokuyoGaitosha();
    }

    @JsonIgnore
    public Label getLblTashoGaitosha() {
        return this.getTblKyojuhiGaitosha().getLblTashoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaiichiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaiichiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaiichiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaiichiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDainiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiJunKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoIchiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoIchiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTashoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoIchiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaisanKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiJunKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoNiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoNiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTashoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoNiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtKijunHiyogakuKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaisanJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoSanTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaininoSanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaisanTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtKijunHiyogakuJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtDaisanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsuGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtKijunHiyogakuTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyoGaitosha() {
        return this.getTblKyojuhiGaitosha().getTxtKijunHiyogakuTokuyoGaitosha();
    }

    // </editor-fold>
}
