package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SisetuNyutaisyoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SisetuNyutaisyoJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyusyoYYMMDD")
    private TextBoxDate NyusyoYYMMDD;
    @JsonProperty("DaityoSyubetu")
    private TextBox DaityoSyubetu;
    @JsonProperty("SisetuSyubetu")
    private TextBox SisetuSyubetu;
    @JsonProperty("TaisyoYYMMDD")
    private TextBoxDate TaisyoYYMMDD;
    @JsonProperty("NyusyoSisetuCode")
    private TextBox NyusyoSisetuCode;
    @JsonProperty("NyusyoSisetuMesyo")
    private TextBox NyusyoSisetuMesyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyusyoYYMMDD
     * @return NyusyoYYMMDD
     */
    @JsonProperty("NyusyoYYMMDD")
    public TextBoxDate getNyusyoYYMMDD() {
        return NyusyoYYMMDD;
    }

    /*
     * setNyusyoYYMMDD
     * @param NyusyoYYMMDD NyusyoYYMMDD
     */
    @JsonProperty("NyusyoYYMMDD")
    public void setNyusyoYYMMDD(TextBoxDate NyusyoYYMMDD) {
        this.NyusyoYYMMDD = NyusyoYYMMDD;
    }

    /*
     * getDaityoSyubetu
     * @return DaityoSyubetu
     */
    @JsonProperty("DaityoSyubetu")
    public TextBox getDaityoSyubetu() {
        return DaityoSyubetu;
    }

    /*
     * setDaityoSyubetu
     * @param DaityoSyubetu DaityoSyubetu
     */
    @JsonProperty("DaityoSyubetu")
    public void setDaityoSyubetu(TextBox DaityoSyubetu) {
        this.DaityoSyubetu = DaityoSyubetu;
    }

    /*
     * getSisetuSyubetu
     * @return SisetuSyubetu
     */
    @JsonProperty("SisetuSyubetu")
    public TextBox getSisetuSyubetu() {
        return SisetuSyubetu;
    }

    /*
     * setSisetuSyubetu
     * @param SisetuSyubetu SisetuSyubetu
     */
    @JsonProperty("SisetuSyubetu")
    public void setSisetuSyubetu(TextBox SisetuSyubetu) {
        this.SisetuSyubetu = SisetuSyubetu;
    }

    /*
     * getTaisyoYYMMDD
     * @return TaisyoYYMMDD
     */
    @JsonProperty("TaisyoYYMMDD")
    public TextBoxDate getTaisyoYYMMDD() {
        return TaisyoYYMMDD;
    }

    /*
     * setTaisyoYYMMDD
     * @param TaisyoYYMMDD TaisyoYYMMDD
     */
    @JsonProperty("TaisyoYYMMDD")
    public void setTaisyoYYMMDD(TextBoxDate TaisyoYYMMDD) {
        this.TaisyoYYMMDD = TaisyoYYMMDD;
    }

    /*
     * getNyusyoSisetuCode
     * @return NyusyoSisetuCode
     */
    @JsonProperty("NyusyoSisetuCode")
    public TextBox getNyusyoSisetuCode() {
        return NyusyoSisetuCode;
    }

    /*
     * setNyusyoSisetuCode
     * @param NyusyoSisetuCode NyusyoSisetuCode
     */
    @JsonProperty("NyusyoSisetuCode")
    public void setNyusyoSisetuCode(TextBox NyusyoSisetuCode) {
        this.NyusyoSisetuCode = NyusyoSisetuCode;
    }

    /*
     * getNyusyoSisetuMesyo
     * @return NyusyoSisetuMesyo
     */
    @JsonProperty("NyusyoSisetuMesyo")
    public TextBox getNyusyoSisetuMesyo() {
        return NyusyoSisetuMesyo;
    }

    /*
     * setNyusyoSisetuMesyo
     * @param NyusyoSisetuMesyo NyusyoSisetuMesyo
     */
    @JsonProperty("NyusyoSisetuMesyo")
    public void setNyusyoSisetuMesyo(TextBox NyusyoSisetuMesyo) {
        this.NyusyoSisetuMesyo = NyusyoSisetuMesyo;
    }

    // </editor-fold>
}
