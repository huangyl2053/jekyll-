package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.IYokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.YokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("shinsakaitorokuichiran")
    private shinsakaitorokuichiranDiv shinsakaitorokuichiran;
    @JsonProperty("shinsakaitorokukanryoselect")
    private shinsakaitorokukanryoselectDiv shinsakaitorokukanryoselect;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getshinsakaitorokuichiran
     * @return shinsakaitorokuichiran
     */
    @JsonProperty("shinsakaitorokuichiran")
    public shinsakaitorokuichiranDiv getShinsakaitorokuichiran() {
        return shinsakaitorokuichiran;
    }

    /*
     * setshinsakaitorokuichiran
     * @param shinsakaitorokuichiran shinsakaitorokuichiran
     */
    @JsonProperty("shinsakaitorokuichiran")
    public void setShinsakaitorokuichiran(shinsakaitorokuichiranDiv shinsakaitorokuichiran) {
        this.shinsakaitorokuichiran = shinsakaitorokuichiran;
    }

    /*
     * getshinsakaitorokukanryoselect
     * @return shinsakaitorokukanryoselect
     */
    @JsonProperty("shinsakaitorokukanryoselect")
    public shinsakaitorokukanryoselectDiv getShinsakaitorokukanryoselect() {
        return shinsakaitorokukanryoselect;
    }

    /*
     * setshinsakaitorokukanryoselect
     * @param shinsakaitorokukanryoselect shinsakaitorokukanryoselect
     */
    @JsonProperty("shinsakaitorokukanryoselect")
    public void setShinsakaitorokukanryoselect(shinsakaitorokukanryoselectDiv shinsakaitorokukanryoselect) {
        this.shinsakaitorokukanryoselect = shinsakaitorokukanryoselect;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdTaskList() {
        return this.getShinsakaitorokuichiran().getCcdTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtnshinsakekkakanryooutput() {
        return this.getShinsakaitorokukanryoselect().getBtnshinsakekkakanryooutput();
    }

    @JsonIgnore
    public void  setBtnshinsakekkakanryooutput(ButtonDownLoad btnshinsakekkakanryooutput) {
        this.getShinsakaitorokukanryoselect().setBtnshinsakekkakanryooutput(btnshinsakekkakanryooutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
