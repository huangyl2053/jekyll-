package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriJokyo のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class ShoriJokyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FuchoKarisanteiShoriNaiyo")
    private FuchoKarisanteiShoriNaiyoDiv FuchoKarisanteiShoriNaiyo;
    @JsonProperty("FuchoKarisanteiShoriKakunin")
    private FuchoKarisanteiShoriKakuninDiv FuchoKarisanteiShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFuchoKarisanteiShoriNaiyo
     * @return FuchoKarisanteiShoriNaiyo
     */
    @JsonProperty("FuchoKarisanteiShoriNaiyo")
    public FuchoKarisanteiShoriNaiyoDiv getFuchoKarisanteiShoriNaiyo() {
        return FuchoKarisanteiShoriNaiyo;
    }

    /*
     * setFuchoKarisanteiShoriNaiyo
     * @param FuchoKarisanteiShoriNaiyo FuchoKarisanteiShoriNaiyo
     */
    @JsonProperty("FuchoKarisanteiShoriNaiyo")
    public void setFuchoKarisanteiShoriNaiyo(FuchoKarisanteiShoriNaiyoDiv FuchoKarisanteiShoriNaiyo) {
        this.FuchoKarisanteiShoriNaiyo = FuchoKarisanteiShoriNaiyo;
    }

    /*
     * getFuchoKarisanteiShoriKakunin
     * @return FuchoKarisanteiShoriKakunin
     */
    @JsonProperty("FuchoKarisanteiShoriKakunin")
    public FuchoKarisanteiShoriKakuninDiv getFuchoKarisanteiShoriKakunin() {
        return FuchoKarisanteiShoriKakunin;
    }

    /*
     * setFuchoKarisanteiShoriKakunin
     * @param FuchoKarisanteiShoriKakunin FuchoKarisanteiShoriKakunin
     */
    @JsonProperty("FuchoKarisanteiShoriKakunin")
    public void setFuchoKarisanteiShoriKakunin(FuchoKarisanteiShoriKakuninDiv FuchoKarisanteiShoriKakunin) {
        this.FuchoKarisanteiShoriKakunin = FuchoKarisanteiShoriKakunin;
    }

    // </editor-fold>
}
