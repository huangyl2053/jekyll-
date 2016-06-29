package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonsanteiFukaKeisanTotal のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiFukaKeisanTotalDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonsanteiFukaMenuSentaku")
    private HonsanteiFukaMenuSentakuDiv HonsanteiFukaMenuSentaku;
    @JsonProperty("HonsanteiFukaPankuzu")
    private HonsanteiFukaPankuzuDiv HonsanteiFukaPankuzu;
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("HonsanteiFukaKakunin")
    private HonsanteiFukaKakuninDiv HonsanteiFukaKakunin;
    @JsonProperty("HonsanteiChohyoHakko")
    private HonsanteiChohyoHakkoDiv HonsanteiChohyoHakko;
    @JsonProperty("HonsanteiChohyoHakko2")
    private HonsanteiChohyoHakko2Div HonsanteiChohyoHakko2;
    @JsonProperty("ShutsuryokuJunHonNotsu")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonNotsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonsanteiFukaMenuSentaku
     * @return HonsanteiFukaMenuSentaku
     */
    @JsonProperty("HonsanteiFukaMenuSentaku")
    public HonsanteiFukaMenuSentakuDiv getHonsanteiFukaMenuSentaku() {
        return HonsanteiFukaMenuSentaku;
    }

    /*
     * setHonsanteiFukaMenuSentaku
     * @param HonsanteiFukaMenuSentaku HonsanteiFukaMenuSentaku
     */
    @JsonProperty("HonsanteiFukaMenuSentaku")
    public void setHonsanteiFukaMenuSentaku(HonsanteiFukaMenuSentakuDiv HonsanteiFukaMenuSentaku) {
        this.HonsanteiFukaMenuSentaku = HonsanteiFukaMenuSentaku;
    }

    /*
     * getHonsanteiFukaPankuzu
     * @return HonsanteiFukaPankuzu
     */
    @JsonProperty("HonsanteiFukaPankuzu")
    public HonsanteiFukaPankuzuDiv getHonsanteiFukaPankuzu() {
        return HonsanteiFukaPankuzu;
    }

    /*
     * setHonsanteiFukaPankuzu
     * @param HonsanteiFukaPankuzu HonsanteiFukaPankuzu
     */
    @JsonProperty("HonsanteiFukaPankuzu")
    public void setHonsanteiFukaPankuzu(HonsanteiFukaPankuzuDiv HonsanteiFukaPankuzu) {
        this.HonsanteiFukaPankuzu = HonsanteiFukaPankuzu;
    }

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
     * getHonsanteiFukaKakunin
     * @return HonsanteiFukaKakunin
     */
    @JsonProperty("HonsanteiFukaKakunin")
    public HonsanteiFukaKakuninDiv getHonsanteiFukaKakunin() {
        return HonsanteiFukaKakunin;
    }

    /*
     * setHonsanteiFukaKakunin
     * @param HonsanteiFukaKakunin HonsanteiFukaKakunin
     */
    @JsonProperty("HonsanteiFukaKakunin")
    public void setHonsanteiFukaKakunin(HonsanteiFukaKakuninDiv HonsanteiFukaKakunin) {
        this.HonsanteiFukaKakunin = HonsanteiFukaKakunin;
    }

    /*
     * getHonsanteiChohyoHakko
     * @return HonsanteiChohyoHakko
     */
    @JsonProperty("HonsanteiChohyoHakko")
    public HonsanteiChohyoHakkoDiv getHonsanteiChohyoHakko() {
        return HonsanteiChohyoHakko;
    }

    /*
     * setHonsanteiChohyoHakko
     * @param HonsanteiChohyoHakko HonsanteiChohyoHakko
     */
    @JsonProperty("HonsanteiChohyoHakko")
    public void setHonsanteiChohyoHakko(HonsanteiChohyoHakkoDiv HonsanteiChohyoHakko) {
        this.HonsanteiChohyoHakko = HonsanteiChohyoHakko;
    }

    /*
     * getHonsanteiChohyoHakko2
     * @return HonsanteiChohyoHakko2
     */
    @JsonProperty("HonsanteiChohyoHakko2")
    public HonsanteiChohyoHakko2Div getHonsanteiChohyoHakko2() {
        return HonsanteiChohyoHakko2;
    }

    /*
     * setHonsanteiChohyoHakko2
     * @param HonsanteiChohyoHakko2 HonsanteiChohyoHakko2
     */
    @JsonProperty("HonsanteiChohyoHakko2")
    public void setHonsanteiChohyoHakko2(HonsanteiChohyoHakko2Div HonsanteiChohyoHakko2) {
        this.HonsanteiChohyoHakko2 = HonsanteiChohyoHakko2;
    }

    /*
     * getShutsuryokuJunHonNotsu
     * @return ShutsuryokuJunHonNotsu
     */
    @JsonProperty("ShutsuryokuJunHonNotsu")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunHonNotsu() {
        return ShutsuryokuJunHonNotsu;
    }

    // </editor-fold>
}
