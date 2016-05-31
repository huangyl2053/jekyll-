package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokutyoKariSanteiFuka のクラスファイル
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFukaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("TokutyoKariSanteiKanriInfo")
    private TokutyoKariSanteiKanriInfoDiv TokutyoKariSanteiKanriInfo;
    @JsonProperty("TokutyoKariSanteiFukaChohyoHakko")
    private TokutyoKariSanteiFukaChohyoHakkoDiv TokutyoKariSanteiFukaChohyoHakko;

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
     * getTokutyoKariSanteiKanriInfo
     * @return TokutyoKariSanteiKanriInfo
     */
    @JsonProperty("TokutyoKariSanteiKanriInfo")
    public TokutyoKariSanteiKanriInfoDiv getTokutyoKariSanteiKanriInfo() {
        return TokutyoKariSanteiKanriInfo;
    }

    /*
     * setTokutyoKariSanteiKanriInfo
     * @param TokutyoKariSanteiKanriInfo TokutyoKariSanteiKanriInfo
     */
    @JsonProperty("TokutyoKariSanteiKanriInfo")
    public void setTokutyoKariSanteiKanriInfo(TokutyoKariSanteiKanriInfoDiv TokutyoKariSanteiKanriInfo) {
        this.TokutyoKariSanteiKanriInfo = TokutyoKariSanteiKanriInfo;
    }

    /*
     * getTokutyoKariSanteiFukaChohyoHakko
     * @return TokutyoKariSanteiFukaChohyoHakko
     */
    @JsonProperty("TokutyoKariSanteiFukaChohyoHakko")
    public TokutyoKariSanteiFukaChohyoHakkoDiv getTokutyoKariSanteiFukaChohyoHakko() {
        return TokutyoKariSanteiFukaChohyoHakko;
    }

    /*
     * setTokutyoKariSanteiFukaChohyoHakko
     * @param TokutyoKariSanteiFukaChohyoHakko TokutyoKariSanteiFukaChohyoHakko
     */
    @JsonProperty("TokutyoKariSanteiFukaChohyoHakko")
    public void setTokutyoKariSanteiFukaChohyoHakko(TokutyoKariSanteiFukaChohyoHakkoDiv TokutyoKariSanteiFukaChohyoHakko) {
        this.TokutyoKariSanteiFukaChohyoHakko = TokutyoKariSanteiFukaChohyoHakko;
    }

    // </editor-fold>
}
