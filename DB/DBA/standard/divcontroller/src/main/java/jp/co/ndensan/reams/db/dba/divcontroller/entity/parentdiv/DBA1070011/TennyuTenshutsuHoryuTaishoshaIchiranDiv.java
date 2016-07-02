package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011;
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
 * TennyuTenshutsuHoryuTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TennyuTenshutsuHoryuTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabTennyuTenshutsuHoryuTaishosha")
    private tabTennyuTenshutsuHoryuTaishoshaDiv tabTennyuTenshutsuHoryuTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabTennyuTenshutsuHoryuTaishosha
     * @return tabTennyuTenshutsuHoryuTaishosha
     */
    @JsonProperty("tabTennyuTenshutsuHoryuTaishosha")
    public tabTennyuTenshutsuHoryuTaishoshaDiv getTabTennyuTenshutsuHoryuTaishosha() {
        return tabTennyuTenshutsuHoryuTaishosha;
    }

    /*
     * settabTennyuTenshutsuHoryuTaishosha
     * @param tabTennyuTenshutsuHoryuTaishosha tabTennyuTenshutsuHoryuTaishosha
     */
    @JsonProperty("tabTennyuTenshutsuHoryuTaishosha")
    public void setTabTennyuTenshutsuHoryuTaishosha(tabTennyuTenshutsuHoryuTaishoshaDiv tabTennyuTenshutsuHoryuTaishosha) {
        this.tabTennyuTenshutsuHoryuTaishosha = tabTennyuTenshutsuHoryuTaishosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplTenshutsuDiv getTplTenshutsu() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplTenshutsu();
    }

    @JsonIgnore
    public void  setTplTenshutsu(tplTenshutsuDiv tplTenshutsu) {
        this.getTabTennyuTenshutsuHoryuTaishosha().setTplTenshutsu(tplTenshutsu);
    }

    @JsonIgnore
    public DataGrid<dgTenshutsu_Row> getDgTenshutsu() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplTenshutsu().getDgTenshutsu();
    }

    @JsonIgnore
    public void  setDgTenshutsu(DataGrid<dgTenshutsu_Row> dgTenshutsu) {
        this.getTabTennyuTenshutsuHoryuTaishosha().getTplTenshutsu().setDgTenshutsu(dgTenshutsu);
    }

    @JsonIgnore
    public Button getBtnIkkatsuSoshitsu() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplTenshutsu().getBtnIkkatsuSoshitsu();
    }

    @JsonIgnore
    public void  setBtnIkkatsuSoshitsu(Button btnIkkatsuSoshitsu) {
        this.getTabTennyuTenshutsuHoryuTaishosha().getTplTenshutsu().setBtnIkkatsuSoshitsu(btnIkkatsuSoshitsu);
    }

    @JsonIgnore
    public tplTennyuDiv getTplTennyu() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplTennyu();
    }

    @JsonIgnore
    public void  setTplTennyu(tplTennyuDiv tplTennyu) {
        this.getTabTennyuTenshutsuHoryuTaishosha().setTplTennyu(tplTennyu);
    }

    @JsonIgnore
    public DataGrid<dgTennyu_Row> getDgTennyu() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplTennyu().getDgTennyu();
    }

    @JsonIgnore
    public void  setDgTennyu(DataGrid<dgTennyu_Row> dgTennyu) {
        this.getTabTennyuTenshutsuHoryuTaishosha().getTplTennyu().setDgTennyu(dgTennyu);
    }

    @JsonIgnore
    public tplKoikiDiv getTplKoiki() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplKoiki();
    }

    @JsonIgnore
    public void  setTplKoiki(tplKoikiDiv tplKoiki) {
        this.getTabTennyuTenshutsuHoryuTaishosha().setTplKoiki(tplKoiki);
    }

    @JsonIgnore
    public DataGrid<dgKoiki_Row> getDgKoiki() {
        return this.getTabTennyuTenshutsuHoryuTaishosha().getTplKoiki().getDgKoiki();
    }

    @JsonIgnore
    public void  setDgKoiki(DataGrid<dgKoiki_Row> dgKoiki) {
        this.getTabTennyuTenshutsuHoryuTaishosha().getTplKoiki().setDgKoiki(dgKoiki);
    }

    // </editor-fold>
}
