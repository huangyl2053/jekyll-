package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.dgKoiki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.dgTennyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.dgTenshutsu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tabHoryuTaishoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplKoikiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplTennyuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplTenshutsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TennyuTensyutsuHoryuTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class TennyuTensyutsuHoryuTaishoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabHoryuTaishosha")
    private tabHoryuTaishoshaDiv tabHoryuTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabHoryuTaishosha")
    public tabHoryuTaishoshaDiv getTabHoryuTaishosha() {
        return tabHoryuTaishosha;
    }

    @JsonProperty("tabHoryuTaishosha")
    public void setTabHoryuTaishosha(tabHoryuTaishoshaDiv tabHoryuTaishosha) {
        this.tabHoryuTaishosha=tabHoryuTaishosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplTenshutsuDiv getTplTenshutsu() {
        return this.getTabHoryuTaishosha().getTplTenshutsu();
    }

    @JsonIgnore
    public void  setTplTenshutsu(tplTenshutsuDiv tplTenshutsu) {
        this.getTabHoryuTaishosha().setTplTenshutsu(tplTenshutsu);
    }

    @JsonIgnore
    public DataGrid<dgTenshutsu_Row> getDgTenshutsu() {
        return this.getTabHoryuTaishosha().getTplTenshutsu().getDgTenshutsu();
    }

    @JsonIgnore
    public void  setDgTenshutsu(DataGrid<dgTenshutsu_Row> dgTenshutsu) {
        this.getTabHoryuTaishosha().getTplTenshutsu().setDgTenshutsu(dgTenshutsu);
    }

    @JsonIgnore
    public tplTennyuDiv getTplTennyu() {
        return this.getTabHoryuTaishosha().getTplTennyu();
    }

    @JsonIgnore
    public void  setTplTennyu(tplTennyuDiv tplTennyu) {
        this.getTabHoryuTaishosha().setTplTennyu(tplTennyu);
    }

    @JsonIgnore
    public DataGrid<dgTennyu_Row> getDgTennyu() {
        return this.getTabHoryuTaishosha().getTplTennyu().getDgTennyu();
    }

    @JsonIgnore
    public void  setDgTennyu(DataGrid<dgTennyu_Row> dgTennyu) {
        this.getTabHoryuTaishosha().getTplTennyu().setDgTennyu(dgTennyu);
    }

    @JsonIgnore
    public tplKoikiDiv getTplKoiki() {
        return this.getTabHoryuTaishosha().getTplKoiki();
    }

    @JsonIgnore
    public void  setTplKoiki(tplKoikiDiv tplKoiki) {
        this.getTabHoryuTaishosha().setTplKoiki(tplKoiki);
    }

    @JsonIgnore
    public DataGrid<dgKoiki_Row> getDgKoiki() {
        return this.getTabHoryuTaishosha().getTplKoiki().getDgKoiki();
    }

    @JsonIgnore
    public void  setDgKoiki(DataGrid<dgKoiki_Row> dgKoiki) {
        this.getTabHoryuTaishosha().getTplKoiki().setDgKoiki(dgKoiki);
    }

}
