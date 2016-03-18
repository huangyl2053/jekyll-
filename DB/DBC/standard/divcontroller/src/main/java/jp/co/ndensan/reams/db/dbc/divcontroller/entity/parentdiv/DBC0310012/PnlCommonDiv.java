package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlCommon のクラスファイル
 *
 * @author 自動生成
 */
public class PnlCommonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hlLine2")
    private HorizontalLine hlLine2;
    @JsonProperty("PnlDetail")
    private PnlDetailDiv PnlDetail;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdAtena")
    private KaigoAtenaInfoDiv ccdAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethlLine2
     * @return hlLine2
     */
    @JsonProperty("hlLine2")
    public HorizontalLine getHlLine2() {
        return hlLine2;
    }

    /*
     * sethlLine2
     * @param hlLine2 hlLine2
     */
    @JsonProperty("hlLine2")
    public void setHlLine2(HorizontalLine hlLine2) {
        this.hlLine2 = hlLine2;
    }

    /*
     * getPnlDetail
     * @return PnlDetail
     */
    @JsonProperty("PnlDetail")
    public PnlDetailDiv getPnlDetail() {
        return PnlDetail;
    }

    /*
     * setPnlDetail
     * @param PnlDetail PnlDetail
     */
    @JsonProperty("PnlDetail")
    public void setPnlDetail(PnlDetailDiv PnlDetail) {
        this.PnlDetail = PnlDetail;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdAtena
     * @return ccdAtena
     */
    @JsonProperty("ccdAtena")
    public IKaigoAtenaInfoDiv getCcdAtena() {
        return ccdAtena;
    }

    // </editor-fold>
}
