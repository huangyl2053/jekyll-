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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTokusoShusei")
    private Button btnTokusoShusei;
    @JsonProperty("ShikakuTokuso")
    private ShikakuTokusoDiv ShikakuTokuso;
    @JsonProperty("linShikakuTokuso")
    private HorizontalLine linShikakuTokuso;
    @JsonProperty("ShikakuShosaiDialogs")
    private ShikakuShosaiDialogsDiv ShikakuShosaiDialogs;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTokusoShusei
     * @return btnTokusoShusei
     */
    @JsonProperty("btnTokusoShusei")
    public Button getBtnTokusoShusei() {
        return btnTokusoShusei;
    }

    /*
     * setbtnTokusoShusei
     * @param btnTokusoShusei btnTokusoShusei
     */
    @JsonProperty("btnTokusoShusei")
    public void setBtnTokusoShusei(Button btnTokusoShusei) {
        this.btnTokusoShusei = btnTokusoShusei;
    }

    /*
     * getShikakuTokuso
     * @return ShikakuTokuso
     */
    @JsonProperty("ShikakuTokuso")
    public ShikakuTokusoDiv getShikakuTokuso() {
        return ShikakuTokuso;
    }

    /*
     * setShikakuTokuso
     * @param ShikakuTokuso ShikakuTokuso
     */
    @JsonProperty("ShikakuTokuso")
    public void setShikakuTokuso(ShikakuTokusoDiv ShikakuTokuso) {
        this.ShikakuTokuso = ShikakuTokuso;
    }

    /*
     * getlinShikakuTokuso
     * @return linShikakuTokuso
     */
    @JsonProperty("linShikakuTokuso")
    public HorizontalLine getLinShikakuTokuso() {
        return linShikakuTokuso;
    }

    /*
     * setlinShikakuTokuso
     * @param linShikakuTokuso linShikakuTokuso
     */
    @JsonProperty("linShikakuTokuso")
    public void setLinShikakuTokuso(HorizontalLine linShikakuTokuso) {
        this.linShikakuTokuso = linShikakuTokuso;
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
    public tblShikakuShosaiDiv getTblShikakuShosai() {
        return this.getShikakuTokuso().getTblShikakuShosai();
    }

    @JsonIgnore
    public void  setTblShikakuShosai(tblShikakuShosaiDiv tblShikakuShosai) {
        this.getShikakuTokuso().setTblShikakuShosai(tblShikakuShosai);
    }

    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtShutokuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuJiyu() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlShutokuJiyu();
    }

    @JsonIgnore
    public Label getLblHihoKubun() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblHihoKubun();
    }

    @JsonIgnore
    public DropDownList getDdlHihoKubun() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlHihoKubun();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuShozaiHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlShutokuShozaiHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuShoriDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblShutokuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuShoriDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtShutokuShoriDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblSoshitsuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtSoshitsuDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuTodokedeDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuJiyu() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblSoshitsuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuJiyu() {
        return this.getShikakuTokuso().getTblShikakuShosai().getDdlSoshitsuJiyu();
    }

    @JsonIgnore
    public Label getLblSoshitsuShoriDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getLblSoshitsuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuShoriDate() {
        return this.getShikakuTokuso().getTblShikakuShosai().getTxtSoshitsuShoriDate();
    }

    @JsonIgnore
    public Button getBtnTokusoKakutei() {
        return this.getShikakuTokuso().getBtnTokusoKakutei();
    }

    @JsonIgnore
    public void  setBtnTokusoKakutei(Button btnTokusoKakutei) {
        this.getShikakuTokuso().setBtnTokusoKakutei(btnTokusoKakutei);
    }

    @JsonIgnore
    public Button getBtnTokusoTorikeshi() {
        return this.getShikakuTokuso().getBtnTokusoTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTokusoTorikeshi(Button btnTokusoTorikeshi) {
        this.getShikakuTokuso().setBtnTokusoTorikeshi(btnTokusoTorikeshi);
    }

    @JsonIgnore
    public IJushochiTokureiDialogButtonDiv getCcdJutokuDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdJutokuDialogButton();
    }

    @JsonIgnore
    public IShisetsuNyutaishoDialogButtonDiv getCcdShisetsuNyutaishoDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdShisetsuNyutaishoDialogButton();
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDialogButtonDiv getCcdShikakuHenkoDialogButton() {
        return this.getShikakuShosaiDialogs().getCcdShikakuHenkoDialogButton();
    }

    // </editor-fold>
}
