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
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplKoikiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplTennyuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011.tplTenshutsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabHoryuTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHoryuTaishoshaDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplTenshutsu")
    private tplTenshutsuDiv tplTenshutsu;
    @JsonProperty("tplTennyu")
    private tplTennyuDiv tplTennyu;
    @JsonProperty("tplKoiki")
    private tplKoikiDiv tplKoiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplTenshutsu")
    public tplTenshutsuDiv getTplTenshutsu() {
        return tplTenshutsu;
    }

    @JsonProperty("tplTenshutsu")
    public void setTplTenshutsu(tplTenshutsuDiv tplTenshutsu) {
        this.tplTenshutsu=tplTenshutsu;
    }

    @JsonProperty("tplTennyu")
    public tplTennyuDiv getTplTennyu() {
        return tplTennyu;
    }

    @JsonProperty("tplTennyu")
    public void setTplTennyu(tplTennyuDiv tplTennyu) {
        this.tplTennyu=tplTennyu;
    }

    @JsonProperty("tplKoiki")
    public tplKoikiDiv getTplKoiki() {
        return tplKoiki;
    }

    @JsonProperty("tplKoiki")
    public void setTplKoiki(tplKoikiDiv tplKoiki) {
        this.tplKoiki=tplKoiki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgTenshutsu_Row> getDgTenshutsu() {
        return this.getTplTenshutsu().getDgTenshutsu();
    }

    @JsonIgnore
    public void  setDgTenshutsu(DataGrid<dgTenshutsu_Row> dgTenshutsu) {
        this.getTplTenshutsu().setDgTenshutsu(dgTenshutsu);
    }

    @JsonIgnore
    public DataGrid<dgTennyu_Row> getDgTennyu() {
        return this.getTplTennyu().getDgTennyu();
    }

    @JsonIgnore
    public void  setDgTennyu(DataGrid<dgTennyu_Row> dgTennyu) {
        this.getTplTennyu().setDgTennyu(dgTennyu);
    }

    @JsonIgnore
    public DataGrid<dgKoiki_Row> getDgKoiki() {
        return this.getTplKoiki().getDgKoiki();
    }

    @JsonIgnore
    public void  setDgKoiki(DataGrid<dgKoiki_Row> dgKoiki) {
        this.getTplKoiki().setDgKoiki(dgKoiki);
    }

}
