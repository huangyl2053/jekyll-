package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011;
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
 * tabTennyuTenshutsuHoryuTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabTennyuTenshutsuHoryuTaishoshaDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    /*
     * gettplTenshutsu
     * @return tplTenshutsu
     */
    @JsonProperty("tplTenshutsu")
    public tplTenshutsuDiv getTplTenshutsu() {
        return tplTenshutsu;
    }

    /*
     * settplTenshutsu
     * @param tplTenshutsu tplTenshutsu
     */
    @JsonProperty("tplTenshutsu")
    public void setTplTenshutsu(tplTenshutsuDiv tplTenshutsu) {
        this.tplTenshutsu = tplTenshutsu;
    }

    /*
     * gettplTennyu
     * @return tplTennyu
     */
    @JsonProperty("tplTennyu")
    public tplTennyuDiv getTplTennyu() {
        return tplTennyu;
    }

    /*
     * settplTennyu
     * @param tplTennyu tplTennyu
     */
    @JsonProperty("tplTennyu")
    public void setTplTennyu(tplTennyuDiv tplTennyu) {
        this.tplTennyu = tplTennyu;
    }

    /*
     * gettplKoiki
     * @return tplKoiki
     */
    @JsonProperty("tplKoiki")
    public tplKoikiDiv getTplKoiki() {
        return tplKoiki;
    }

    /*
     * settplKoiki
     * @param tplKoiki tplKoiki
     */
    @JsonProperty("tplKoiki")
    public void setTplKoiki(tplKoikiDiv tplKoiki) {
        this.tplKoiki = tplKoiki;
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
    public Button getBtnIkkatsuSoshitsu() {
        return this.getTplTenshutsu().getBtnIkkatsuSoshitsu();
    }

    @JsonIgnore
    public void  setBtnIkkatsuSoshitsu(Button btnIkkatsuSoshitsu) {
        this.getTplTenshutsu().setBtnIkkatsuSoshitsu(btnIkkatsuSoshitsu);
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

    // </editor-fold>
}
