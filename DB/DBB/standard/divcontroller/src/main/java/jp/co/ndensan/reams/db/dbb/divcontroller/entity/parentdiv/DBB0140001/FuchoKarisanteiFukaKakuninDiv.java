package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuchoKarisanteiFukaKakunin のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("FuchoKarisanteiKanrijoho")
    private FuchoKarisanteiKanrijohoDiv FuchoKarisanteiKanrijoho;

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
     * getFuchoKarisanteiKanrijoho
     * @return FuchoKarisanteiKanrijoho
     */
    @JsonProperty("FuchoKarisanteiKanrijoho")
    public FuchoKarisanteiKanrijohoDiv getFuchoKarisanteiKanrijoho() {
        return FuchoKarisanteiKanrijoho;
    }

    /*
     * setFuchoKarisanteiKanrijoho
     * @param FuchoKarisanteiKanrijoho FuchoKarisanteiKanrijoho
     */
    @JsonProperty("FuchoKarisanteiKanrijoho")
    public void setFuchoKarisanteiKanrijoho(FuchoKarisanteiKanrijohoDiv FuchoKarisanteiKanrijoho) {
        this.FuchoKarisanteiKanrijoho = FuchoKarisanteiKanrijoho;
    }

    // </editor-fold>
}
