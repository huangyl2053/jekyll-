package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HeijunkaKeisan のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaKeisanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("HeijunkaKeisanHoho")
    private HeijunkaKeisanHohoDiv HeijunkaKeisanHoho;
    @JsonProperty("HeijunkaHenkoTsuchi")
    private HeijunkaHenkoTsuchiDiv HeijunkaHenkoTsuchi;
    @JsonProperty("TokuchoHeijunkaChohyoHakko")
    private TokuchoHeijunkaChohyoHakkoDiv TokuchoHeijunkaChohyoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriJokyo
     * @return ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public ShoriJokyoDiv getShoriJokyo() {
        return ShoriJokyo;
    }

    /*
     * setShoriJokyo
     * @param ShoriJokyo ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.ShoriJokyo = ShoriJokyo;
    }

    /*
     * getHeijunkaKeisanHoho
     * @return HeijunkaKeisanHoho
     */
    @JsonProperty("HeijunkaKeisanHoho")
    public HeijunkaKeisanHohoDiv getHeijunkaKeisanHoho() {
        return HeijunkaKeisanHoho;
    }

    /*
     * setHeijunkaKeisanHoho
     * @param HeijunkaKeisanHoho HeijunkaKeisanHoho
     */
    @JsonProperty("HeijunkaKeisanHoho")
    public void setHeijunkaKeisanHoho(HeijunkaKeisanHohoDiv HeijunkaKeisanHoho) {
        this.HeijunkaKeisanHoho = HeijunkaKeisanHoho;
    }

    /*
     * getHeijunkaHenkoTsuchi
     * @return HeijunkaHenkoTsuchi
     */
    @JsonProperty("HeijunkaHenkoTsuchi")
    public HeijunkaHenkoTsuchiDiv getHeijunkaHenkoTsuchi() {
        return HeijunkaHenkoTsuchi;
    }

    /*
     * setHeijunkaHenkoTsuchi
     * @param HeijunkaHenkoTsuchi HeijunkaHenkoTsuchi
     */
    @JsonProperty("HeijunkaHenkoTsuchi")
    public void setHeijunkaHenkoTsuchi(HeijunkaHenkoTsuchiDiv HeijunkaHenkoTsuchi) {
        this.HeijunkaHenkoTsuchi = HeijunkaHenkoTsuchi;
    }

    /*
     * getTokuchoHeijunkaChohyoHakko
     * @return TokuchoHeijunkaChohyoHakko
     */
    @JsonProperty("TokuchoHeijunkaChohyoHakko")
    public TokuchoHeijunkaChohyoHakkoDiv getTokuchoHeijunkaChohyoHakko() {
        return TokuchoHeijunkaChohyoHakko;
    }

    /*
     * setTokuchoHeijunkaChohyoHakko
     * @param TokuchoHeijunkaChohyoHakko TokuchoHeijunkaChohyoHakko
     */
    @JsonProperty("TokuchoHeijunkaChohyoHakko")
    public void setTokuchoHeijunkaChohyoHakko(TokuchoHeijunkaChohyoHakkoDiv TokuchoHeijunkaChohyoHakko) {
        this.TokuchoHeijunkaChohyoHakko = TokuchoHeijunkaChohyoHakko;
    }

    // </editor-fold>
}
