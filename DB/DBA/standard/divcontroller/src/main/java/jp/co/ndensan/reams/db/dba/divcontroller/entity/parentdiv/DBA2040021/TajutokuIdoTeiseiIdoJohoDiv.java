package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.ITaJushochiTokureishaKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.TaJushochiTokureishaKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TajutokuIdoTeiseiIdoJoho のクラスファイル
 *
 * @reamsid_L DBA-0401-030 duanzhanli
 */
public class TajutokuIdoTeiseiIdoJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShisetsuIdoJoho")
    private ShisetsuIdoJohoDiv ShisetsuIdoJoho;
    @JsonProperty("ccdTaJushochiTokureishaKanri")
    private TaJushochiTokureishaKanriDiv ccdTaJushochiTokureishaKanri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShisetsuIdoJoho
     * @return ShisetsuIdoJoho
     */
    @JsonProperty("ShisetsuIdoJoho")
    public ShisetsuIdoJohoDiv getShisetsuIdoJoho() {
        return ShisetsuIdoJoho;
    }

    /*
     * setShisetsuIdoJoho
     * @param ShisetsuIdoJoho ShisetsuIdoJoho
     */
    @JsonProperty("ShisetsuIdoJoho")
    public void setShisetsuIdoJoho(ShisetsuIdoJohoDiv ShisetsuIdoJoho) {
        this.ShisetsuIdoJoho = ShisetsuIdoJoho;
    }

    /*
     * getccdTaJushochiTokureishaKanri
     * @return ccdTaJushochiTokureishaKanri
     */
    @JsonProperty("ccdTaJushochiTokureishaKanri")
    public ITaJushochiTokureishaKanriDiv getCcdTaJushochiTokureishaKanri() {
        return ccdTaJushochiTokureishaKanri;
    }

    // </editor-fold>
}
