package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplTenshutsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplTenshutsuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTenshutsu")
    private DataGrid<dgTenshutsu_Row> dgTenshutsu;
    @JsonProperty("btnIkkatsuSoshitsu")
    private Button btnIkkatsuSoshitsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTenshutsu
     * @return dgTenshutsu
     */
    @JsonProperty("dgTenshutsu")
    public DataGrid<dgTenshutsu_Row> getDgTenshutsu() {
        return dgTenshutsu;
    }

    /*
     * setdgTenshutsu
     * @param dgTenshutsu dgTenshutsu
     */
    @JsonProperty("dgTenshutsu")
    public void setDgTenshutsu(DataGrid<dgTenshutsu_Row> dgTenshutsu) {
        this.dgTenshutsu = dgTenshutsu;
    }

    /*
     * getbtnIkkatsuSoshitsu
     * @return btnIkkatsuSoshitsu
     */
    @JsonProperty("btnIkkatsuSoshitsu")
    public Button getBtnIkkatsuSoshitsu() {
        return btnIkkatsuSoshitsu;
    }

    /*
     * setbtnIkkatsuSoshitsu
     * @param btnIkkatsuSoshitsu btnIkkatsuSoshitsu
     */
    @JsonProperty("btnIkkatsuSoshitsu")
    public void setBtnIkkatsuSoshitsu(Button btnIkkatsuSoshitsu) {
        this.btnIkkatsuSoshitsu = btnIkkatsuSoshitsu;
    }

    // </editor-fold>
}
