package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RoreiFukushiNenkinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class RoreiFukushiNenkinJohoDiv extends Panel implements IRoreiFukushiNenkinJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgRoreiFukushiNenkinJoho")
    private DataGrid<dgRoreiFukushiNenkinJoho_Row> dgRoreiFukushiNenkinJoho;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgRoreiFukushiNenkinJoho
     * @return dgRoreiFukushiNenkinJoho
     */
    @JsonProperty("dgRoreiFukushiNenkinJoho")
    public DataGrid<dgRoreiFukushiNenkinJoho_Row> getDgRoreiFukushiNenkinJoho() {
        return dgRoreiFukushiNenkinJoho;
    }

    /*
     * setdgRoreiFukushiNenkinJoho
     * @param dgRoreiFukushiNenkinJoho dgRoreiFukushiNenkinJoho
     */
    @JsonProperty("dgRoreiFukushiNenkinJoho")
    public void setDgRoreiFukushiNenkinJoho(DataGrid<dgRoreiFukushiNenkinJoho_Row> dgRoreiFukushiNenkinJoho) {
        this.dgRoreiFukushiNenkinJoho = dgRoreiFukushiNenkinJoho;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
