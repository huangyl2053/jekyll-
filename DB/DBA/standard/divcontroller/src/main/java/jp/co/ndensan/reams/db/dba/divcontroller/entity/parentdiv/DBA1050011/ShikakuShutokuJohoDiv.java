package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IIryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.IRofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.RofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdIryoHokenDialogButton")
    private IryoHokenRirekiDialogButtonDiv ccdIryoHokenDialogButton;
    @JsonProperty("ccdRofukuNenkinDialogButton")
    private RofukuNenkinDialogButtonDiv ccdRofukuNenkinDialogButton;
    @JsonProperty("linShikakuTokuso")
    private HorizontalLine linShikakuTokuso;
    @JsonProperty("ccdShikakuTokusoRireki")
    private ShikakuTokusoRirekiDiv ccdShikakuTokusoRireki;
    @JsonProperty("shikakuInputMode")
    private RString shikakuInputMode;
    @JsonProperty("iryoHokenInputMode")
    private RString iryoHokenInputMode;
    @JsonProperty("shikakuSelectRow")
    private RString shikakuSelectRow;
    @JsonProperty("iryoHokenSelectRow")
    private RString iryoHokenSelectRow;
    @JsonProperty("dateOfBirth")
    private RString dateOfBirth;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdIryoHokenDialogButton
     * @return ccdIryoHokenDialogButton
     */
    @JsonProperty("ccdIryoHokenDialogButton")
    public IIryoHokenRirekiDialogButtonDiv getCcdIryoHokenDialogButton() {
        return ccdIryoHokenDialogButton;
    }

    /*
     * getccdRofukuNenkinDialogButton
     * @return ccdRofukuNenkinDialogButton
     */
    @JsonProperty("ccdRofukuNenkinDialogButton")
    public IRofukuNenkinDialogButtonDiv getCcdRofukuNenkinDialogButton() {
        return ccdRofukuNenkinDialogButton;
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
     * getccdShikakuTokusoRireki
     * @return ccdShikakuTokusoRireki
     */
    @JsonProperty("ccdShikakuTokusoRireki")
    public IShikakuTokusoRirekiDiv getCcdShikakuTokusoRireki() {
        return ccdShikakuTokusoRireki;
    }

    /*
     * getshikakuInputMode
     * @return shikakuInputMode
     */
    @JsonProperty("shikakuInputMode")
    public RString getShikakuInputMode() {
        return shikakuInputMode;
    }

    /*
     * setshikakuInputMode
     * @param shikakuInputMode shikakuInputMode
     */
    @JsonProperty("shikakuInputMode")
    public void setShikakuInputMode(RString shikakuInputMode) {
        this.shikakuInputMode = shikakuInputMode;
    }

    /*
     * getiryoHokenInputMode
     * @return iryoHokenInputMode
     */
    @JsonProperty("iryoHokenInputMode")
    public RString getIryoHokenInputMode() {
        return iryoHokenInputMode;
    }

    /*
     * setiryoHokenInputMode
     * @param iryoHokenInputMode iryoHokenInputMode
     */
    @JsonProperty("iryoHokenInputMode")
    public void setIryoHokenInputMode(RString iryoHokenInputMode) {
        this.iryoHokenInputMode = iryoHokenInputMode;
    }

    /*
     * getshikakuSelectRow
     * @return shikakuSelectRow
     */
    @JsonProperty("shikakuSelectRow")
    public RString getShikakuSelectRow() {
        return shikakuSelectRow;
    }

    /*
     * setshikakuSelectRow
     * @param shikakuSelectRow shikakuSelectRow
     */
    @JsonProperty("shikakuSelectRow")
    public void setShikakuSelectRow(RString shikakuSelectRow) {
        this.shikakuSelectRow = shikakuSelectRow;
    }

    /*
     * getiryoHokenSelectRow
     * @return iryoHokenSelectRow
     */
    @JsonProperty("iryoHokenSelectRow")
    public RString getIryoHokenSelectRow() {
        return iryoHokenSelectRow;
    }

    /*
     * setiryoHokenSelectRow
     * @param iryoHokenSelectRow iryoHokenSelectRow
     */
    @JsonProperty("iryoHokenSelectRow")
    public void setIryoHokenSelectRow(RString iryoHokenSelectRow) {
        this.iryoHokenSelectRow = iryoHokenSelectRow;
    }

    /*
     * getdateOfBirth
     * @return dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public RString getDateOfBirth() {
        return dateOfBirth;
    }

    /*
     * setdateOfBirth
     * @param dateOfBirth dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(RString dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // </editor-fold>
}
