package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;
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
 * ShinsaKaiKekkaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaKaiKekkaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("shinsakaikanryo")
    private shinsakaikanryoDiv shinsakaikanryo;
    @JsonProperty("shinsakaikanryoselect")
    private shinsakaikanryoselectDiv shinsakaikanryoselect;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getshinsakaikanryo
     * @return shinsakaikanryo
     */
    @JsonProperty("shinsakaikanryo")
    public shinsakaikanryoDiv getShinsakaikanryo() {
        return shinsakaikanryo;
    }

    /*
     * setshinsakaikanryo
     * @param shinsakaikanryo shinsakaikanryo
     */
    @JsonProperty("shinsakaikanryo")
    public void setShinsakaikanryo(shinsakaikanryoDiv shinsakaikanryo) {
        this.shinsakaikanryo = shinsakaikanryo;
    }

    /*
     * getshinsakaikanryoselect
     * @return shinsakaikanryoselect
     */
    @JsonProperty("shinsakaikanryoselect")
    public shinsakaikanryoselectDiv getShinsakaikanryoselect() {
        return shinsakaikanryoselect;
    }

    /*
     * setshinsakaikanryoselect
     * @param shinsakaikanryoselect shinsakaikanryoselect
     */
    @JsonProperty("shinsakaikanryoselect")
    public void setShinsakaikanryoselect(shinsakaikanryoselectDiv shinsakaikanryoselect) {
        this.shinsakaikanryoselect = shinsakaikanryoselect;
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
        return this.getShinsakaikanryo().getCcdTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getShinsakaikanryooutput() {
        return this.getShinsakaikanryoselect().getShinsakaikanryooutput();
    }

    @JsonIgnore
    public void  setShinsakaikanryooutput(ButtonDownLoad shinsakaikanryooutput) {
        this.getShinsakaikanryoselect().setShinsakaikanryooutput(shinsakaikanryooutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
