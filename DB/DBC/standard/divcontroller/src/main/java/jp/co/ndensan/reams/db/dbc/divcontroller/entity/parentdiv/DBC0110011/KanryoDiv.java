package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kanryo のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KanryoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKanryoNotice")
    private Label lblKanryoNotice;
    @JsonProperty("btnToShikakushaSho")
    private Button btnToShikakushaSho;
    @JsonProperty("btnToHihokenshaSho")
    private Button btnToHihokenshaSho;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKanryoNotice
     * @return lblKanryoNotice
     */
    @JsonProperty("lblKanryoNotice")
    public Label getLblKanryoNotice() {
        return lblKanryoNotice;
    }

    /*
     * setlblKanryoNotice
     * @param lblKanryoNotice lblKanryoNotice
     */
    @JsonProperty("lblKanryoNotice")
    public void setLblKanryoNotice(Label lblKanryoNotice) {
        this.lblKanryoNotice = lblKanryoNotice;
    }

    /*
     * getbtnToShikakushaSho
     * @return btnToShikakushaSho
     */
    @JsonProperty("btnToShikakushaSho")
    public Button getBtnToShikakushaSho() {
        return btnToShikakushaSho;
    }

    /*
     * setbtnToShikakushaSho
     * @param btnToShikakushaSho btnToShikakushaSho
     */
    @JsonProperty("btnToShikakushaSho")
    public void setBtnToShikakushaSho(Button btnToShikakushaSho) {
        this.btnToShikakushaSho = btnToShikakushaSho;
    }

    /*
     * getbtnToHihokenshaSho
     * @return btnToHihokenshaSho
     */
    @JsonProperty("btnToHihokenshaSho")
    public Button getBtnToHihokenshaSho() {
        return btnToHihokenshaSho;
    }

    /*
     * setbtnToHihokenshaSho
     * @param btnToHihokenshaSho btnToHihokenshaSho
     */
    @JsonProperty("btnToHihokenshaSho")
    public void setBtnToHihokenshaSho(Button btnToHihokenshaSho) {
        this.btnToHihokenshaSho = btnToHihokenshaSho;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    // </editor-fold>
}
