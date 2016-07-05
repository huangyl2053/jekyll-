package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001;
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
 * GetsureiShori のクラスファイル 
 * 
 * @author 自動生成
 */
public class GetsureiShoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    private CenterSoshinTaishoshaIchiranDiv CenterSoshinTaishoshaIchiran;
    @JsonProperty("ShoriSelect")
    private ShoriSelectDiv ShoriSelect;
    @JsonProperty("ccdKanryoMessege")
    private KanryoMessageDiv ccdKanryoMessege;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCenterSoshinTaishoshaIchiran
     * @return CenterSoshinTaishoshaIchiran
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    public CenterSoshinTaishoshaIchiranDiv getCenterSoshinTaishoshaIchiran() {
        return CenterSoshinTaishoshaIchiran;
    }

    /*
     * setCenterSoshinTaishoshaIchiran
     * @param CenterSoshinTaishoshaIchiran CenterSoshinTaishoshaIchiran
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    public void setCenterSoshinTaishoshaIchiran(CenterSoshinTaishoshaIchiranDiv CenterSoshinTaishoshaIchiran) {
        this.CenterSoshinTaishoshaIchiran = CenterSoshinTaishoshaIchiran;
    }

    /*
     * getShoriSelect
     * @return ShoriSelect
     */
    @JsonProperty("ShoriSelect")
    public ShoriSelectDiv getShoriSelect() {
        return ShoriSelect;
    }

    /*
     * setShoriSelect
     * @param ShoriSelect ShoriSelect
     */
    @JsonProperty("ShoriSelect")
    public void setShoriSelect(ShoriSelectDiv ShoriSelect) {
        this.ShoriSelect = ShoriSelect;
    }

    /*
     * getccdKanryoMessege
     * @return ccdKanryoMessege
     */
    @JsonProperty("ccdKanryoMessege")
    public IKanryoMessageDiv getCcdKanryoMessege() {
        return ccdKanryoMessege;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdNinteiTaskList() {
        return this.getCenterSoshinTaishoshaIchiran().getCcdNinteiTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getShoriSelect().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getShoriSelect().setBtndataoutput(btndataoutput);
    }

    // </editor-fold>
}
