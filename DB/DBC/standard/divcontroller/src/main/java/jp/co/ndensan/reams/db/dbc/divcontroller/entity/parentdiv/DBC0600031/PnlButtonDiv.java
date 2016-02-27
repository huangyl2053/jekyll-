package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlButtonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinseJoho")
    private Button btnShinseJoho;
    @JsonProperty("btnKetteiJoho")
    private Button btnKetteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShinseJoho
     * @return btnShinseJoho
     */
    @JsonProperty("btnShinseJoho")
    public Button getBtnShinseJoho() {
        return btnShinseJoho;
    }

    /*
     * setbtnShinseJoho
     * @param btnShinseJoho btnShinseJoho
     */
    @JsonProperty("btnShinseJoho")
    public void setBtnShinseJoho(Button btnShinseJoho) {
        this.btnShinseJoho = btnShinseJoho;
    }

    /*
     * getbtnKetteiJoho
     * @return btnKetteiJoho
     */
    @JsonProperty("btnKetteiJoho")
    public Button getBtnKetteiJoho() {
        return btnKetteiJoho;
    }

    /*
     * setbtnKetteiJoho
     * @param btnKetteiJoho btnKetteiJoho
     */
    @JsonProperty("btnKetteiJoho")
    public void setBtnKetteiJoho(Button btnKetteiJoho) {
        this.btnKetteiJoho = btnKetteiJoho;
    }

    // </editor-fold>
}
