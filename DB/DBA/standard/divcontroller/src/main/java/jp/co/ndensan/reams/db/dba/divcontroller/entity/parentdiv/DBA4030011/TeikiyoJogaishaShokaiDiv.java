package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.ITekiyoJogaiRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TeikiyoJogaishaShokai のクラスファイル
 *
 * @reamsid_L DBA-0412-030 lishengli
 */
public class TeikiyoJogaishaShokaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("TeikiyoJogaishaJoho")
    private TeikiyoJogaishaJohoDiv TeikiyoJogaishaJoho;
    @JsonProperty("ShisetsuJoho")
    private ShisetsuJohoDiv ShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikakuKihonJoho
     * @return ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public ShikakuKihonJohoDiv getShikakuKihonJoho() {
        return ShikakuKihonJoho;
    }

    /*
     * setShikakuKihonJoho
     * @param ShikakuKihonJoho ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public void setShikakuKihonJoho(ShikakuKihonJohoDiv ShikakuKihonJoho) {
        this.ShikakuKihonJoho = ShikakuKihonJoho;
    }

    /*
     * getTeikiyoJogaishaJoho
     * @return TeikiyoJogaishaJoho
     */
    @JsonProperty("TeikiyoJogaishaJoho")
    public TeikiyoJogaishaJohoDiv getTeikiyoJogaishaJoho() {
        return TeikiyoJogaishaJoho;
    }

    /*
     * setTeikiyoJogaishaJoho
     * @param TeikiyoJogaishaJoho TeikiyoJogaishaJoho
     */
    @JsonProperty("TeikiyoJogaishaJoho")
    public void setTeikiyoJogaishaJoho(TeikiyoJogaishaJohoDiv TeikiyoJogaishaJoho) {
        this.TeikiyoJogaishaJoho = TeikiyoJogaishaJoho;
    }

    /*
     * getShisetsuJoho
     * @return ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public ShisetsuJohoDiv getShisetsuJoho() {
        return ShisetsuJoho;
    }

    /*
     * setShisetsuJoho
     * @param ShisetsuJoho ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public void setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.ShisetsuJoho = ShisetsuJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdShikakuJoho() {
        return this.getShikakuKihonJoho().getCcdShikakuJoho();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getShikakuKihonJoho().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public ITekiyoJogaiRirekiDiv getCcdTekiyoJogaiRireki() {
        return this.getTeikiyoJogaishaJoho().getCcdTekiyoJogaiRireki();
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyuTaishoRireki() {
        return this.getShisetsuJoho().getCcdShisetsuNyuTaishoRireki();
    }

    // </editor-fold>
}
