package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TsuchiShori のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsuchiShoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlTsuchishohakko")
    private pnlTsuchishohakkoDiv pnlTsuchishohakko;
    @JsonProperty("shoriselect")
    private shoriselectDiv shoriselect;
    @JsonProperty("ccdKanryoMessege")
    private KanryoMessageDiv ccdKanryoMessege;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlTsuchishohakko
     * @return pnlTsuchishohakko
     */
    @JsonProperty("pnlTsuchishohakko")
    public pnlTsuchishohakkoDiv getPnlTsuchishohakko() {
        return pnlTsuchishohakko;
    }

    /*
     * setpnlTsuchishohakko
     * @param pnlTsuchishohakko pnlTsuchishohakko
     */
    @JsonProperty("pnlTsuchishohakko")
    public void setPnlTsuchishohakko(pnlTsuchishohakkoDiv pnlTsuchishohakko) {
        this.pnlTsuchishohakko = pnlTsuchishohakko;
    }

    /*
     * getshoriselect
     * @return shoriselect
     */
    @JsonProperty("shoriselect")
    public shoriselectDiv getShoriselect() {
        return shoriselect;
    }

    /*
     * setshoriselect
     * @param shoriselect shoriselect
     */
    @JsonProperty("shoriselect")
    public void setShoriselect(shoriselectDiv shoriselect) {
        this.shoriselect = shoriselect;
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
    public DataGrid<dgtsuchishohakko_Row> getDgtsuchishohakko() {
        return this.getPnlTsuchishohakko().getDgtsuchishohakko();
    }

    @JsonIgnore
    public void  setDgtsuchishohakko(DataGrid<dgtsuchishohakko_Row> dgtsuchishohakko) {
        this.getPnlTsuchishohakko().setDgtsuchishohakko(dgtsuchishohakko);
    }

    @JsonIgnore
    public ButtonDownLoad getBtncsvoutput() {
        return this.getShoriselect().getBtncsvoutput();
    }

    @JsonIgnore
    public void  setBtncsvoutput(ButtonDownLoad btncsvoutput) {
        this.getShoriselect().setBtncsvoutput(btncsvoutput);
    }

    // </editor-fold>
}
