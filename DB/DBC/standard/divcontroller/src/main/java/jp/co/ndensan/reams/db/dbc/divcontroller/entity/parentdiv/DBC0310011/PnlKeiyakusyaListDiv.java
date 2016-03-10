package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlKeiyakusyaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlKeiyakusyaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKeyakusya")
    private DataGrid<dgKeyakusya_Row> dgKeyakusya;
    @JsonProperty("btnSearchAgain")
    private Button btnSearchAgain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKeyakusya
     * @return dgKeyakusya
     */
    @JsonProperty("dgKeyakusya")
    public DataGrid<dgKeyakusya_Row> getDgKeyakusya() {
        return dgKeyakusya;
    }

    /*
     * setdgKeyakusya
     * @param dgKeyakusya dgKeyakusya
     */
    @JsonProperty("dgKeyakusya")
    public void setDgKeyakusya(DataGrid<dgKeyakusya_Row> dgKeyakusya) {
        this.dgKeyakusya = dgKeyakusya;
    }

    /*
     * getbtnSearchAgain
     * @return btnSearchAgain
     */
    @JsonProperty("btnSearchAgain")
    public Button getBtnSearchAgain() {
        return btnSearchAgain;
    }

    /*
     * setbtnSearchAgain
     * @param btnSearchAgain btnSearchAgain
     */
    @JsonProperty("btnSearchAgain")
    public void setBtnSearchAgain(Button btnSearchAgain) {
        this.btnSearchAgain = btnSearchAgain;
    }

    // </editor-fold>
}
