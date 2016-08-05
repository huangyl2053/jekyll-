package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC0140011KeikakuTodokeJohoList のクラスファイル 
 * 
 * @reamsid_L DBC-1960-010 wangxingpeng
 */
public class DBC0140011KeikakuTodokeJohoListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KeikakuTodokeJohoList")
    private KeikakuTodokeJohoListDiv KeikakuTodokeJohoList;
    @JsonProperty("printOrderCv")
    private ChohyoShutsuryokujunDiv printOrderCv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKeikakuTodokeJohoList
     * @return KeikakuTodokeJohoList
     */
    @JsonProperty("KeikakuTodokeJohoList")
    public KeikakuTodokeJohoListDiv getKeikakuTodokeJohoList() {
        return KeikakuTodokeJohoList;
    }

    /*
     * setKeikakuTodokeJohoList
     * @param KeikakuTodokeJohoList KeikakuTodokeJohoList
     */
    @JsonProperty("KeikakuTodokeJohoList")
    public void setKeikakuTodokeJohoList(KeikakuTodokeJohoListDiv KeikakuTodokeJohoList) {
        this.KeikakuTodokeJohoList = KeikakuTodokeJohoList;
    }

    /*
     * getprintOrderCv
     * @return printOrderCv
     */
    @JsonProperty("printOrderCv")
    public IChohyoShutsuryokujunDiv getPrintOrderCv() {
        return printOrderCv;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTbJukyuShinseibi() {
        return this.getKeikakuTodokeJohoList().getTbJukyuShinseibi();
    }

    @JsonIgnore
    public void  setTbJukyuShinseibi(TextBoxDateRange tbJukyuShinseibi) {
        this.getKeikakuTodokeJohoList().setTbJukyuShinseibi(tbJukyuShinseibi);
    }

    @JsonIgnore
    public DropDownList getDdlTaishousha() {
        return this.getKeikakuTodokeJohoList().getDdlTaishousha();
    }

    @JsonIgnore
    public void  setDdlTaishousha(DropDownList ddlTaishousha) {
        this.getKeikakuTodokeJohoList().setDdlTaishousha(ddlTaishousha);
    }

    @JsonIgnore
    public DropDownList getDdlTodokeJokyo() {
        return this.getKeikakuTodokeJohoList().getDdlTodokeJokyo();
    }

    @JsonIgnore
    public void  setDdlTodokeJokyo(DropDownList ddlTodokeJokyo) {
        this.getKeikakuTodokeJohoList().setDdlTodokeJokyo(ddlTodokeJokyo);
    }

    @JsonIgnore
    public TextBoxDate getTbKijunbi() {
        return this.getKeikakuTodokeJohoList().getTbKijunbi();
    }

    @JsonIgnore
    public void  setTbKijunbi(TextBoxDate tbKijunbi) {
        this.getKeikakuTodokeJohoList().setTbKijunbi(tbKijunbi);
    }

    // </editor-fold>
}
