package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.IJushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.JushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.IShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.ShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.IShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.ShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblShikakuShosai")
    private tblShikakuShosaiDiv tblShikakuShosai;
    @JsonProperty("ShikakuShosaiDialogs")
    private ShikakuShosaiDialogsDiv ShikakuShosaiDialogs;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblShikakuShosai
     * @return tblShikakuShosai
     */
    @JsonProperty("tblShikakuShosai")
    public tblShikakuShosaiDiv getTblShikakuShosai() {
        return tblShikakuShosai;
    }

    /*
     * settblShikakuShosai
     * @param tblShikakuShosai tblShikakuShosai
     */
    @JsonProperty("tblShikakuShosai")
    public void setTblShikakuShosai(tblShikakuShosaiDiv tblShikakuShosai) {
        this.tblShikakuShosai = tblShikakuShosai;
    }

    /*
     * getShikakuShosaiDialogs
     * @return ShikakuShosaiDialogs
     */
    @JsonProperty("ShikakuShosaiDialogs")
    public ShikakuShosaiDialogsDiv getShikakuShosaiDialogs() {
        return ShikakuShosaiDialogs;
    }

    /*
     * setShikakuShosaiDialogs
     * @param ShikakuShosaiDialogs ShikakuShosaiDialogs
     */
    @JsonProperty("ShikakuShosaiDialogs")
    public void setShikakuShosaiDialogs(ShikakuShosaiDialogsDiv ShikakuShosaiDialogs) {
        this.ShikakuShosaiDialogs = ShikakuShosaiDialogs;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.getTblShikakuShosai().getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.getTblShikakuShosai().getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.getTblShikakuShosai().getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return this.getTblShikakuShosai().getTxtShutokuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.getTblShikakuShosai().getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuJiyu() {
        return this.getTblShikakuShosai().getDdlShutokuJiyu();
    }

    @JsonIgnore
    public Label getLblHihoKubun() {
        return this.getTblShikakuShosai().getLblHihoKubun();
    }

    @JsonIgnore
    public DropDownList getDdlHihoKubun() {
        return this.getTblShikakuShosai().getDdlHihoKubun();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.getTblShikakuShosai().getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuShozaiHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuShozaiHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.getTblShikakuShosai().getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.getTblShikakuShosai().getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuShoriDate() {
        return this.getTblShikakuShosai().getLblShutokuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuShoriDate() {
        return this.getTblShikakuShosai().getTxtShutokuShoriDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuDate() {
        return this.getTblShikakuShosai().getLblSoshitsuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return this.getTblShikakuShosai().getTxtSoshitsuDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuTodokedeDate() {
        return this.getTblShikakuShosai().getLblSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return this.getTblShikakuShosai().getTxtSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuJiyu() {
        return this.getTblShikakuShosai().getLblSoshitsuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuJiyu() {
        return this.getTblShikakuShosai().getDdlSoshitsuJiyu();
    }

    @JsonIgnore
    public Label getLblSoshitsuShoriDate() {
        return this.getTblShikakuShosai().getLblSoshitsuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuShoriDate() {
        return this.getTblShikakuShosai().getTxtSoshitsuShoriDate();
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDialogButtonDiv getCcdShikakuHenkoDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdShikakuHenkoDialogButton();
    }

    @JsonIgnore
    public IJushochiTokureiDialogButtonDiv getCcdJutokuDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdJutokuDialogButton();
    }

    @JsonIgnore
    public IShisetsuNyutaishoDialogButtonDiv getCcdShisetsuNyutaishoDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdShisetsuNyutaishoDialogButton();
    }

    // </editor-fold>
}
