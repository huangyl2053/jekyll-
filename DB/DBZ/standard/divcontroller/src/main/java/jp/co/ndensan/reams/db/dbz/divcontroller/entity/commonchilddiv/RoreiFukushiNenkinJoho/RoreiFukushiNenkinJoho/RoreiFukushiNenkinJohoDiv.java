package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * RoreiFukushiNenkinJoho のクラスファイル
 *
 * @reamsid_L DBD-3560-090 wangjie2
 */
public class RoreiFukushiNenkinJohoDiv extends Panel implements IRoreiFukushiNenkinJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

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

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initializa(HihokenshaNo 被保険者番号) {
        getHandler(this).initializa(被保険者番号);
    }

    private RoreiFukushiNenkinJohoHandler getHandler(RoreiFukushiNenkinJohoDiv div) {
        return new RoreiFukushiNenkinJohoHandler(div);
    }

}
