package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsugaigosabisujukyuMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsugaigosabisujukyuMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShisetsugaigosabisujukyu")
    private tabShisetsugaigosabisujukyuDiv tabShisetsugaigosabisujukyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShisetsugaigosabisujukyu
     * @return tabShisetsugaigosabisujukyu
     */
    @JsonProperty("tabShisetsugaigosabisujukyu")
    public tabShisetsugaigosabisujukyuDiv getTabShisetsugaigosabisujukyu() {
        return tabShisetsugaigosabisujukyu;
    }

    /*
     * settabShisetsugaigosabisujukyu
     * @param tabShisetsugaigosabisujukyu tabShisetsugaigosabisujukyu
     */
    @JsonProperty("tabShisetsugaigosabisujukyu")
    public void setTabShisetsugaigosabisujukyu(tabShisetsugaigosabisujukyuDiv tabShisetsugaigosabisujukyu) {
        this.tabShisetsugaigosabisujukyu = tabShisetsugaigosabisujukyu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tablitakuyobosabisujukyusuInputDiv getTablitakuyobosabisujukyusuInput() {
        return this.getTabShisetsugaigosabisujukyu().getTablitakuyobosabisujukyusuInput();
    }

    @JsonIgnore
    public void  setTablitakuyobosabisujukyusuInput(tablitakuyobosabisujukyusuInputDiv tablitakuyobosabisujukyusuInput) {
        this.getTabShisetsugaigosabisujukyu().setTablitakuyobosabisujukyusuInput(tablitakuyobosabisujukyusuInput);
    }

    @JsonIgnore
    public DataGrid<dgItakuyobosabisujukyusu_Row> getDgItakuyobosabisujukyusu() {
        return this.getTabShisetsugaigosabisujukyu().getTablitakuyobosabisujukyusuInput().getDgItakuyobosabisujukyusu();
    }

    @JsonIgnore
    public void  setDgItakuyobosabisujukyusu(DataGrid<dgItakuyobosabisujukyusu_Row> dgItakuyobosabisujukyusu) {
        this.getTabShisetsugaigosabisujukyu().getTablitakuyobosabisujukyusuInput().setDgItakuyobosabisujukyusu(dgItakuyobosabisujukyusu);
    }

    @JsonIgnore
    public tabChiikimitchakuyobosabisujukyuInputDiv getTabChiikimitchakuyobosabisujukyuInput() {
        return this.getTabShisetsugaigosabisujukyu().getTabChiikimitchakuyobosabisujukyuInput();
    }

    @JsonIgnore
    public void  setTabChiikimitchakuyobosabisujukyuInput(tabChiikimitchakuyobosabisujukyuInputDiv tabChiikimitchakuyobosabisujukyuInput) {
        this.getTabShisetsugaigosabisujukyu().setTabChiikimitchakuyobosabisujukyuInput(tabChiikimitchakuyobosabisujukyuInput);
    }

    @JsonIgnore
    public DataGrid<dgChiikimitchakuyobosabisujukyu_Row> getDgChiikimitchakuyobosabisujukyu() {
        return this.getTabShisetsugaigosabisujukyu().getTabChiikimitchakuyobosabisujukyuInput().getDgChiikimitchakuyobosabisujukyu();
    }

    @JsonIgnore
    public void  setDgChiikimitchakuyobosabisujukyu(DataGrid<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchakuyobosabisujukyu) {
        this.getTabShisetsugaigosabisujukyu().getTabChiikimitchakuyobosabisujukyuInput().setDgChiikimitchakuyobosabisujukyu(dgChiikimitchakuyobosabisujukyu);
    }

    @JsonIgnore
    public tabHisetsugaigosabisujukyuInputDiv getTabHisetsugaigosabisujukyuInput() {
        return this.getTabShisetsugaigosabisujukyu().getTabHisetsugaigosabisujukyuInput();
    }

    @JsonIgnore
    public void  setTabHisetsugaigosabisujukyuInput(tabHisetsugaigosabisujukyuInputDiv tabHisetsugaigosabisujukyuInput) {
        this.getTabShisetsugaigosabisujukyu().setTabHisetsugaigosabisujukyuInput(tabHisetsugaigosabisujukyuInput);
    }

    @JsonIgnore
    public DataGrid<dgHisetsugaigosabisujukyu_Row> getDgHisetsugaigosabisujukyu() {
        return this.getTabShisetsugaigosabisujukyu().getTabHisetsugaigosabisujukyuInput().getDgHisetsugaigosabisujukyu();
    }

    @JsonIgnore
    public void  setDgHisetsugaigosabisujukyu(DataGrid<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigosabisujukyu) {
        this.getTabShisetsugaigosabisujukyu().getTabHisetsugaigosabisujukyuInput().setDgHisetsugaigosabisujukyu(dgHisetsugaigosabisujukyu);
    }

    // </editor-fold>
}
