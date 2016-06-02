package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KarisanteiIdoFukaPanel のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KarisanteiIdoFukaBatchParameter")
    private KarisanteiIdoFukaBatchParameterDiv KarisanteiIdoFukaBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKarisanteiIdoFukaBatchParameter
     * @return KarisanteiIdoFukaBatchParameter
     */
    @JsonProperty("KarisanteiIdoFukaBatchParameter")
    public KarisanteiIdoFukaBatchParameterDiv getKarisanteiIdoFukaBatchParameter() {
        return KarisanteiIdoFukaBatchParameter;
    }

    /*
     * setKarisanteiIdoFukaBatchParameter
     * @param KarisanteiIdoFukaBatchParameter KarisanteiIdoFukaBatchParameter
     */
    @JsonProperty("KarisanteiIdoFukaBatchParameter")
    public void setKarisanteiIdoFukaBatchParameter(KarisanteiIdoFukaBatchParameterDiv KarisanteiIdoFukaBatchParameter) {
        this.KarisanteiIdoFukaBatchParameter = KarisanteiIdoFukaBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShoriJokyoDiv getShoriJokyo() {
        return this.getKarisanteiIdoFukaBatchParameter().getShoriJokyo();
    }

    @JsonIgnore
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.getKarisanteiIdoFukaBatchParameter().setShoriJokyo(ShoriJokyo);
    }

    @JsonIgnore
    public KarisanteiIdoFukaKanriInfoDiv getKarisanteiIdoFukaKanriInfo() {
        return this.getKarisanteiIdoFukaBatchParameter().getKarisanteiIdoFukaKanriInfo();
    }

    @JsonIgnore
    public void setKarisanteiIdoFukaKanriInfo(KarisanteiIdoFukaKanriInfoDiv KarisanteiIdoFukaKanriInfo) {
        this.getKarisanteiIdoFukaBatchParameter().setKarisanteiIdoFukaKanriInfo(KarisanteiIdoFukaKanriInfo);
    }

    @JsonIgnore
    public KarisanteiIdoFukaChohyoHakkoDiv getKarisanteiIdoFukaChohyoHakko() {
        return this.getKarisanteiIdoFukaBatchParameter().getKarisanteiIdoFukaChohyoHakko();
    }

    @JsonIgnore
    public void setKarisanteiIdoFukaChohyoHakko(KarisanteiIdoFukaChohyoHakkoDiv KarisanteiIdoFukaChohyoHakko) {
        this.getKarisanteiIdoFukaBatchParameter().setKarisanteiIdoFukaChohyoHakko(KarisanteiIdoFukaChohyoHakko);
    }

    // </editor-fold>
}
