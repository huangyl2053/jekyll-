package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabContainerDetail のクラスファイル
 *
 * @reamsid_L DBA-0170-010 linghuhang
 */
public class tabContainerDetailDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabPnlJyusyoti")
    private tabPnlJyusyotiDiv tabPnlJyusyoti;
    @JsonProperty("tabPnlShikaku")
    private tabPnlShikakuDiv tabPnlShikaku;
    @JsonProperty("tabPnlShisetu")
    private tabPnlShisetuDiv tabPnlShisetu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabPnlJyusyoti
     * @return tabPnlJyusyoti
     */
    @JsonProperty("tabPnlJyusyoti")
    public tabPnlJyusyotiDiv getTabPnlJyusyoti() {
        return tabPnlJyusyoti;
    }

    /*
     * settabPnlJyusyoti
     * @param tabPnlJyusyoti tabPnlJyusyoti
     */
    @JsonProperty("tabPnlJyusyoti")
    public void setTabPnlJyusyoti(tabPnlJyusyotiDiv tabPnlJyusyoti) {
        this.tabPnlJyusyoti = tabPnlJyusyoti;
    }

    /*
     * gettabPnlShikaku
     * @return tabPnlShikaku
     */
    @JsonProperty("tabPnlShikaku")
    public tabPnlShikakuDiv getTabPnlShikaku() {
        return tabPnlShikaku;
    }

    /*
     * settabPnlShikaku
     * @param tabPnlShikaku tabPnlShikaku
     */
    @JsonProperty("tabPnlShikaku")
    public void setTabPnlShikaku(tabPnlShikakuDiv tabPnlShikaku) {
        this.tabPnlShikaku = tabPnlShikaku;
    }

    /*
     * gettabPnlShisetu
     * @return tabPnlShisetu
     */
    @JsonProperty("tabPnlShisetu")
    public tabPnlShisetuDiv getTabPnlShisetu() {
        return tabPnlShisetu;
    }

    /*
     * settabPnlShisetu
     * @param tabPnlShisetu tabPnlShisetu
     */
    @JsonProperty("tabPnlShisetu")
    public void setTabPnlShisetu(tabPnlShisetuDiv tabPnlShisetu) {
        this.tabPnlShisetu = tabPnlShisetu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IJushochiTokureiRirekiListDiv getCcdJyusyotiTokure() {
        return this.getTabPnlJyusyoti().getCcdJyusyotiTokure();
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDiv getCcdShikakuKanrenIdo() {
        return this.getTabPnlShikaku().getCcdShikakuKanrenIdo();
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetuNyutaisyo() {
        return this.getTabPnlShisetu().getCcdShisetuNyutaisyo();
    }

    // </editor-fold>
}
