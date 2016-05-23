package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * MainPanelBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class MainPanelBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FuchoKarisanteiFukaKakunin")
    private FuchoKarisanteiFukaKakuninDiv FuchoKarisanteiFukaKakunin;
    @JsonProperty("FuchoKarisanteiChohyoHakko2")
    private FuchoKarisanteiChohyoHakko2Div FuchoKarisanteiChohyoHakko2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFuchoKarisanteiFukaKakunin
     * @return FuchoKarisanteiFukaKakunin
     */
    @JsonProperty("FuchoKarisanteiFukaKakunin")
    public FuchoKarisanteiFukaKakuninDiv getFuchoKarisanteiFukaKakunin() {
        return FuchoKarisanteiFukaKakunin;
    }

    /*
     * setFuchoKarisanteiFukaKakunin
     * @param FuchoKarisanteiFukaKakunin FuchoKarisanteiFukaKakunin
     */
    @JsonProperty("FuchoKarisanteiFukaKakunin")
    public void setFuchoKarisanteiFukaKakunin(FuchoKarisanteiFukaKakuninDiv FuchoKarisanteiFukaKakunin) {
        this.FuchoKarisanteiFukaKakunin = FuchoKarisanteiFukaKakunin;
    }

    /*
     * getFuchoKarisanteiChohyoHakko2
     * @return FuchoKarisanteiChohyoHakko2
     */
    @JsonProperty("FuchoKarisanteiChohyoHakko2")
    public FuchoKarisanteiChohyoHakko2Div getFuchoKarisanteiChohyoHakko2() {
        return FuchoKarisanteiChohyoHakko2;
    }

    /*
     * setFuchoKarisanteiChohyoHakko2
     * @param FuchoKarisanteiChohyoHakko2 FuchoKarisanteiChohyoHakko2
     */
    @JsonProperty("FuchoKarisanteiChohyoHakko2")
    public void setFuchoKarisanteiChohyoHakko2(FuchoKarisanteiChohyoHakko2Div FuchoKarisanteiChohyoHakko2) {
        this.FuchoKarisanteiChohyoHakko2 = FuchoKarisanteiChohyoHakko2;
    }

    // </editor-fold>
}
