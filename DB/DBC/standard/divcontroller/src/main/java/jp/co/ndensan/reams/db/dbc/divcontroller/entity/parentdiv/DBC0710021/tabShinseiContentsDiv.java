package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShinseiContents のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class tabShinseiContentsDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShinseiJyoho")
    private tabShinseiJyohoDiv tabShinseiJyoho;
    @JsonProperty("tabKozaJyoho")
    private tabKozaJyohoDiv tabKozaJyoho;
    @JsonProperty("tabJutakuKaisyuJyoho")
    private tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShinseiJyoho
     * @return tabShinseiJyoho
     */
    @JsonProperty("tabShinseiJyoho")
    public tabShinseiJyohoDiv getTabShinseiJyoho() {
        return tabShinseiJyoho;
    }

    /*
     * settabShinseiJyoho
     * @param tabShinseiJyoho tabShinseiJyoho
     */
    @JsonProperty("tabShinseiJyoho")
    public void setTabShinseiJyoho(tabShinseiJyohoDiv tabShinseiJyoho) {
        this.tabShinseiJyoho = tabShinseiJyoho;
    }

    /*
     * gettabKozaJyoho
     * @return tabKozaJyoho
     */
    @JsonProperty("tabKozaJyoho")
    public tabKozaJyohoDiv getTabKozaJyoho() {
        return tabKozaJyoho;
    }

    /*
     * settabKozaJyoho
     * @param tabKozaJyoho tabKozaJyoho
     */
    @JsonProperty("tabKozaJyoho")
    public void setTabKozaJyoho(tabKozaJyohoDiv tabKozaJyoho) {
        this.tabKozaJyoho = tabKozaJyoho;
    }

    /*
     * gettabJutakuKaisyuJyoho
     * @return tabJutakuKaisyuJyoho
     */
    @JsonProperty("tabJutakuKaisyuJyoho")
    public tabJutakuKaisyuJyohoDiv getTabJutakuKaisyuJyoho() {
        return tabJutakuKaisyuJyoho;
    }

    /*
     * settabJutakuKaisyuJyoho
     * @param tabJutakuKaisyuJyoho tabJutakuKaisyuJyoho
     */
    @JsonProperty("tabJutakuKaisyuJyoho")
    public void setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho) {
        this.tabJutakuKaisyuJyoho = tabJutakuKaisyuJyoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JutakuKaishuShinseiContentsDiv getJutakuKaishuShinseiContents() {
        return this.getTabShinseiJyoho().getJutakuKaishuShinseiContents();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiContents(JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents) {
        this.getTabShinseiJyoho().setJutakuKaishuShinseiContents(JutakuKaishuShinseiContents);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getTabKozaJyoho().getCcdShiharaiHohoJyoho();
    }

    @JsonIgnore
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return this.getTabJutakuKaisyuJyoho().getJutakuKaishuShinseiResetInfo();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.getTabJutakuKaisyuJyoho().setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfo);
    }

    @JsonIgnore
    public IJyutakugaisyunaiyoListDiv getCcdJutakugaisyunaiyoList() {
        return this.getTabJutakuKaisyuJyoho().getCcdJutakugaisyunaiyoList();
    }

    // </editor-fold>
}
