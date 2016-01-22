package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShisetsugaigosabisujukyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShisetsugaigosabisujukyuDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tablitakuyobosabisujukyusuInput")
    private tablitakuyobosabisujukyusuInputDiv tablitakuyobosabisujukyusuInput;
    @JsonProperty("tabChiikimitchakuyobosabisujukyuInput")
    private tabChiikimitchakuyobosabisujukyuInputDiv tabChiikimitchakuyobosabisujukyuInput;
    @JsonProperty("tabHisetsugaigosabisujukyuInput")
    private tabHisetsugaigosabisujukyuInputDiv tabHisetsugaigosabisujukyuInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettablitakuyobosabisujukyusuInput
     * @return tablitakuyobosabisujukyusuInput
     */
    @JsonProperty("tablitakuyobosabisujukyusuInput")
    public tablitakuyobosabisujukyusuInputDiv getTablitakuyobosabisujukyusuInput() {
        return tablitakuyobosabisujukyusuInput;
    }

    /*
     * settablitakuyobosabisujukyusuInput
     * @param tablitakuyobosabisujukyusuInput tablitakuyobosabisujukyusuInput
     */
    @JsonProperty("tablitakuyobosabisujukyusuInput")
    public void setTablitakuyobosabisujukyusuInput(tablitakuyobosabisujukyusuInputDiv tablitakuyobosabisujukyusuInput) {
        this.tablitakuyobosabisujukyusuInput = tablitakuyobosabisujukyusuInput;
    }

    /*
     * gettabChiikimitchakuyobosabisujukyuInput
     * @return tabChiikimitchakuyobosabisujukyuInput
     */
    @JsonProperty("tabChiikimitchakuyobosabisujukyuInput")
    public tabChiikimitchakuyobosabisujukyuInputDiv getTabChiikimitchakuyobosabisujukyuInput() {
        return tabChiikimitchakuyobosabisujukyuInput;
    }

    /*
     * settabChiikimitchakuyobosabisujukyuInput
     * @param tabChiikimitchakuyobosabisujukyuInput tabChiikimitchakuyobosabisujukyuInput
     */
    @JsonProperty("tabChiikimitchakuyobosabisujukyuInput")
    public void setTabChiikimitchakuyobosabisujukyuInput(tabChiikimitchakuyobosabisujukyuInputDiv tabChiikimitchakuyobosabisujukyuInput) {
        this.tabChiikimitchakuyobosabisujukyuInput = tabChiikimitchakuyobosabisujukyuInput;
    }

    /*
     * gettabHisetsugaigosabisujukyuInput
     * @return tabHisetsugaigosabisujukyuInput
     */
    @JsonProperty("tabHisetsugaigosabisujukyuInput")
    public tabHisetsugaigosabisujukyuInputDiv getTabHisetsugaigosabisujukyuInput() {
        return tabHisetsugaigosabisujukyuInput;
    }

    /*
     * settabHisetsugaigosabisujukyuInput
     * @param tabHisetsugaigosabisujukyuInput tabHisetsugaigosabisujukyuInput
     */
    @JsonProperty("tabHisetsugaigosabisujukyuInput")
    public void setTabHisetsugaigosabisujukyuInput(tabHisetsugaigosabisujukyuInputDiv tabHisetsugaigosabisujukyuInput) {
        this.tabHisetsugaigosabisujukyuInput = tabHisetsugaigosabisujukyuInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgItakuyobosabisujukyusu_Row> getDgItakuyobosabisujukyusu() {
        return this.getTablitakuyobosabisujukyusuInput().getDgItakuyobosabisujukyusu();
    }

    @JsonIgnore
    public void  setDgItakuyobosabisujukyusu(DataGrid<dgItakuyobosabisujukyusu_Row> dgItakuyobosabisujukyusu) {
        this.getTablitakuyobosabisujukyusuInput().setDgItakuyobosabisujukyusu(dgItakuyobosabisujukyusu);
    }

    @JsonIgnore
    public DataGrid<dgChiikimitchakuyobosabisujukyu_Row> getDgChiikimitchakuyobosabisujukyu() {
        return this.getTabChiikimitchakuyobosabisujukyuInput().getDgChiikimitchakuyobosabisujukyu();
    }

    @JsonIgnore
    public void  setDgChiikimitchakuyobosabisujukyu(DataGrid<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchakuyobosabisujukyu) {
        this.getTabChiikimitchakuyobosabisujukyuInput().setDgChiikimitchakuyobosabisujukyu(dgChiikimitchakuyobosabisujukyu);
    }

    @JsonIgnore
    public DataGrid<dgHisetsugaigosabisujukyu_Row> getDgHisetsugaigosabisujukyu() {
        return this.getTabHisetsugaigosabisujukyuInput().getDgHisetsugaigosabisujukyu();
    }

    @JsonIgnore
    public void  setDgHisetsugaigosabisujukyu(DataGrid<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigosabisujukyu) {
        this.getTabHisetsugaigosabisujukyuInput().setDgHisetsugaigosabisujukyu(dgHisetsugaigosabisujukyu);
    }

    // </editor-fold>
}
