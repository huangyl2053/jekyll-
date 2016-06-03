package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlButton のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class PnlButtonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnDetailJoho")
    private Button btnDetailJoho;
    @JsonProperty("btnKetteiJoho")
    private Button btnKetteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnDetailJoho
     * @return btnDetailJoho
     */
    @JsonProperty("btnDetailJoho")
    public Button getBtnDetailJoho() {
        return btnDetailJoho;
    }

    /*
     * setbtnDetailJoho
     * @param btnDetailJoho btnDetailJoho
     */
    @JsonProperty("btnDetailJoho")
    public void setBtnDetailJoho(Button btnDetailJoho) {
        this.btnDetailJoho = btnDetailJoho;
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
