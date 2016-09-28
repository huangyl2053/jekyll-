package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiyoboJohoTaishoshaTorokuPanel のクラスファイル
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiyoboJohoTaishoshaTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("sokouUpdate")
    private sokouUpdateDiv sokouUpdate;
    @JsonProperty("KihonnInfo")
    private KihonnInfoDiv KihonnInfo;
    @JsonProperty("Soukoinfo")
    private SoukoinfoDiv Soukoinfo;
    @JsonProperty("operateState")
    private RString operateState;
    @JsonProperty("被保険者番号")
    private RString 被保険者番号;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getsokouUpdate
     * @return sokouUpdate
     */
    @JsonProperty("sokouUpdate")
    public sokouUpdateDiv getSokouUpdate() {
        return sokouUpdate;
    }

    /*
     * setsokouUpdate
     * @param sokouUpdate sokouUpdate
     */
    @JsonProperty("sokouUpdate")
    public void setSokouUpdate(sokouUpdateDiv sokouUpdate) {
        this.sokouUpdate = sokouUpdate;
    }

    /*
     * getKihonnInfo
     * @return KihonnInfo
     */
    @JsonProperty("KihonnInfo")
    public KihonnInfoDiv getKihonnInfo() {
        return KihonnInfo;
    }

    /*
     * setKihonnInfo
     * @param KihonnInfo KihonnInfo
     */
    @JsonProperty("KihonnInfo")
    public void setKihonnInfo(KihonnInfoDiv KihonnInfo) {
        this.KihonnInfo = KihonnInfo;
    }

    /*
     * getSoukoinfo
     * @return Soukoinfo
     */
    @JsonProperty("Soukoinfo")
    public SoukoinfoDiv getSoukoinfo() {
        return Soukoinfo;
    }

    /*
     * setSoukoinfo
     * @param Soukoinfo Soukoinfo
     */
    @JsonProperty("Soukoinfo")
    public void setSoukoinfo(SoukoinfoDiv Soukoinfo) {
        this.Soukoinfo = Soukoinfo;
    }

    /*
     * getoperateState
     * @return operateState
     */
    @JsonProperty("operateState")
    public RString getOperateState() {
        return operateState;
    }

    /*
     * setoperateState
     * @param operateState operateState
     */
    @JsonProperty("operateState")
    public void setOperateState(RString operateState) {
        this.operateState = operateState;
    }

    /*
     * get被保険者番号
     * @return 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /*
     * set被保険者番号
     * @param 被保険者番号 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaiigoShikakCommonChildDiv2() {
        return this.getSokouUpdate().getKaiigoShikakCommonChildDiv2();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv1() {
        return this.getSokouUpdate().getKaigoAtenaInfoChildDiv1();
    }

    // </editor-fold>
}
