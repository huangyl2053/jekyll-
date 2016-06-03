package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;
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
 * NinteichosaKekkaNyushu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaKekkaNyushuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiList")
    private NinteichosaIraiListDiv NinteichosaIraiList;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteichosaIraiList
     * @return NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public NinteichosaIraiListDiv getNinteichosaIraiList() {
        return NinteichosaIraiList;
    }

    /*
     * setNinteichosaIraiList
     * @param NinteichosaIraiList NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public void setNinteichosaIraiList(NinteichosaIraiListDiv NinteichosaIraiList) {
        this.NinteichosaIraiList = NinteichosaIraiList;
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
    public ninteichosakekkainputDiv getNinteichosakekkainput() {
        return this.getNinteichosaIraiList().getNinteichosakekkainput();
    }

    @JsonIgnore
    public void  setNinteichosakekkainput(ninteichosakekkainputDiv ninteichosakekkainput) {
        this.getNinteichosaIraiList().setNinteichosakekkainput(ninteichosakekkainput);
    }

    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdTaskList() {
        return this.getNinteichosaIraiList().getNinteichosakekkainput().getCcdTaskList();
    }

    @JsonIgnore
    public chosakekkaselectDiv getChosakekkaselect() {
        return this.getNinteichosaIraiList().getChosakekkaselect();
    }

    @JsonIgnore
    public void  setChosakekkaselect(chosakekkaselectDiv chosakekkaselect) {
        this.getNinteichosaIraiList().setChosakekkaselect(chosakekkaselect);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnchosakekkaoutput() {
        return this.getNinteichosaIraiList().getChosakekkaselect().getBtnchosakekkaoutput();
    }

    @JsonIgnore
    public void  setBtnchosakekkaoutput(ButtonDownLoad btnchosakekkaoutput) {
        this.getNinteichosaIraiList().getChosakekkaselect().setBtnchosakekkaoutput(btnchosakekkaoutput);
    }

    @JsonIgnore
    public Button getBtncyosakekkainput() {
        return this.getNinteichosaIraiList().getChosakekkaselect().getBtncyosakekkainput();
    }

    @JsonIgnore
    public void  setBtncyosakekkainput(Button btncyosakekkainput) {
        this.getNinteichosaIraiList().getChosakekkaselect().setBtncyosakekkainput(btncyosakekkainput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
