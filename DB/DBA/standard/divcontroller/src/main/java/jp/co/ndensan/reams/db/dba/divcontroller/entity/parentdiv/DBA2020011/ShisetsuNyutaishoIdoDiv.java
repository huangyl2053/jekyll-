package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoIdo のクラスファイル
 *
 * @reamsid_L DBA-0360-040 wangxiaodong
 */
public class ShisetsuNyutaishoIdoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("ShisetsuNyutaishoRireki")
    private ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki;
    @JsonProperty("KaigoKanryoMessageOya")
    private KaigoKanryoMessageOyaDiv KaigoKanryoMessageOya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getShisetsuNyutaishoRireki
     * @return ShisetsuNyutaishoRireki
     */
    @JsonProperty("ShisetsuNyutaishoRireki")
    public ShisetsuNyutaishoRirekiDiv getShisetsuNyutaishoRireki() {
        return ShisetsuNyutaishoRireki;
    }

    /*
     * setShisetsuNyutaishoRireki
     * @param ShisetsuNyutaishoRireki ShisetsuNyutaishoRireki
     */
    @JsonProperty("ShisetsuNyutaishoRireki")
    public void setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki) {
        this.ShisetsuNyutaishoRireki = ShisetsuNyutaishoRireki;
    }

    /*
     * getKaigoKanryoMessageOya
     * @return KaigoKanryoMessageOya
     */
    @JsonProperty("KaigoKanryoMessageOya")
    public KaigoKanryoMessageOyaDiv getKaigoKanryoMessageOya() {
        return KaigoKanryoMessageOya;
    }

    /*
     * setKaigoKanryoMessageOya
     * @param KaigoKanryoMessageOya KaigoKanryoMessageOya
     */
    @JsonProperty("KaigoKanryoMessageOya")
    public void setKaigoKanryoMessageOya(KaigoKanryoMessageOyaDiv KaigoKanryoMessageOya) {
        this.KaigoKanryoMessageOya = KaigoKanryoMessageOya;
    }

    // </editor-fold>
}
