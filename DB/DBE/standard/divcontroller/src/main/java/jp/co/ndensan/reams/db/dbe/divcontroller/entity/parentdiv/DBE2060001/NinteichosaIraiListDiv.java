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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ninteichosakekkainput")
    private ninteichosakekkainputDiv ninteichosakekkainput;
    @JsonProperty("chosakekkaselect")
    private chosakekkaselectDiv chosakekkaselect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getninteichosakekkainput
     * @return ninteichosakekkainput
     */
    @JsonProperty("ninteichosakekkainput")
    public ninteichosakekkainputDiv getNinteichosakekkainput() {
        return ninteichosakekkainput;
    }

    /*
     * setninteichosakekkainput
     * @param ninteichosakekkainput ninteichosakekkainput
     */
    @JsonProperty("ninteichosakekkainput")
    public void setNinteichosakekkainput(ninteichosakekkainputDiv ninteichosakekkainput) {
        this.ninteichosakekkainput = ninteichosakekkainput;
    }

    /*
     * getchosakekkaselect
     * @return chosakekkaselect
     */
    @JsonProperty("chosakekkaselect")
    public chosakekkaselectDiv getChosakekkaselect() {
        return chosakekkaselect;
    }

    /*
     * setchosakekkaselect
     * @param chosakekkaselect chosakekkaselect
     */
    @JsonProperty("chosakekkaselect")
    public void setChosakekkaselect(chosakekkaselectDiv chosakekkaselect) {
        this.chosakekkaselect = chosakekkaselect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdTaskList() {
        return this.getNinteichosakekkainput().getCcdTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtnchosakekkaoutput() {
        return this.getChosakekkaselect().getBtnchosakekkaoutput();
    }

    @JsonIgnore
    public void  setBtnchosakekkaoutput(ButtonDownLoad btnchosakekkaoutput) {
        this.getChosakekkaselect().setBtnchosakekkaoutput(btnchosakekkaoutput);
    }

    @JsonIgnore
    public Button getBtncyosakekkainput() {
        return this.getChosakekkaselect().getBtncyosakekkainput();
    }

    @JsonIgnore
    public void  setBtncyosakekkainput(Button btncyosakekkainput) {
        this.getChosakekkaselect().setBtncyosakekkainput(btncyosakekkainput);
    }

    // </editor-fold>
}
