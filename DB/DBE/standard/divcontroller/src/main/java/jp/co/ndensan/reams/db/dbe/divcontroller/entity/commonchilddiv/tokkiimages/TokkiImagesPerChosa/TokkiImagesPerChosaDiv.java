package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.TokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TokkiImagesPerChosa のクラスファイル
 *
 * @author 自動生成
 */
public class TokkiImagesPerChosaDiv extends Panel implements ITokkiImagesPerChosaDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ddlTokkiJikoNos")
    private DropDownList ddlTokkiJikoNos;
    @JsonProperty("btnToDisplay")
    private Button btnToDisplay;
    @JsonProperty("repTokkiJikos")
    private ControlRepeater<TokkiImagesPerKomokuDiv> repTokkiJikos;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnSave")
    private Button btnSave;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTokkiJikoNos
     * @return ddlTokkiJikoNos
     */
    @JsonProperty("ddlTokkiJikoNos")
    public DropDownList getDdlTokkiJikoNos() {
        return ddlTokkiJikoNos;
    }

    /*
     * setddlTokkiJikoNos
     * @param ddlTokkiJikoNos ddlTokkiJikoNos
     */
    @JsonProperty("ddlTokkiJikoNos")
    public void setDdlTokkiJikoNos(DropDownList ddlTokkiJikoNos) {
        this.ddlTokkiJikoNos = ddlTokkiJikoNos;
    }

    /*
     * getbtnToDisplay
     * @return btnToDisplay
     */
    @JsonProperty("btnToDisplay")
    public Button getBtnToDisplay() {
        return btnToDisplay;
    }

    /*
     * setbtnToDisplay
     * @param btnToDisplay btnToDisplay
     */
    @JsonProperty("btnToDisplay")
    public void setBtnToDisplay(Button btnToDisplay) {
        this.btnToDisplay = btnToDisplay;
    }

    /*
     * getrepTokkiJikos
     * @return repTokkiJikos
     */
    @JsonIgnore
    public ControlRepeater<ITokkiImagesPerKomokuDiv> getRepTokkiJikos() {
        return ControlRepeater.class.cast(repTokkiJikos);
    }

    /*
     * setrepTokkiJikos
     * @param repTokkiJikos repTokkiJikos
     */
    @JsonIgnore
    public void setRepTokkiJikos(ControlRepeater<ITokkiImagesPerKomokuDiv> repTokkiJikos) {
        this.repTokkiJikos = ControlRepeater.class.cast(repTokkiJikos);
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    //
    @Override
    public void initialize(RString directortyPath) {

    }

    //TODO
    public RString getDirectoryPath() {
        return RString.EMPTY;
    }

    @Override
    public ReadOnlySharedFileEntryDescriptor getSharedFileEntryDescriptor() {
        return new ReadOnlySharedFileEntryDescriptor(getSharedFileName(), getSharedFileID());
    }

    @Override
    @CheckForNull
    public ITokkiImagesPerKomokuDiv getEditting() {
        if (getOperation().is修正()) {
            return getRepTokkiJikos().getRepeateData().get(0);
        }
        return null;
    }

    @Override
    public void haveSelfDisplaySelectedTokkiJiko() {

    }

    public ShinseishoKanriNo getShinseishoKanriNo() {
        //TODO
        throw new UnsupportedOperationException();
    }

    public int getNinteichosaIraiRirekiNo() {
        //TODO
        throw new UnsupportedOperationException();
    }

    //TODO
    public Operation getOperation() {
        return Operation.修正;
    }

    //TODO
    public FilesystemName getSharedFileName() {
        return null;
    }

    //TODO
    public RDateTime getSharedFileID() {
        return RDateTime.MIN;
    }

}
