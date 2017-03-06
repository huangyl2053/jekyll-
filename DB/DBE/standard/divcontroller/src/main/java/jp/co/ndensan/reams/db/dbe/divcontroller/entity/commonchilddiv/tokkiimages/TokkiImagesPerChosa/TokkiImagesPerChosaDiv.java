package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.TokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

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

    @JsonProperty("TokkiJikoSelecting")
    private TokkiJikoSelectingDiv TokkiJikoSelecting;
    @JsonProperty("repTokkiJikos")
    private ControlRepeater<TokkiImagesPerKomokuDiv> repTokkiJikos;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("hdnOperation")
    private RString hdnOperation;
    @JsonProperty("hdnSharedFileID")
    private RString hdnSharedFileID;
    @JsonProperty("hdnShinseishoKanriNoValue")
    private RString hdnShinseishoKanriNoValue;
    @JsonProperty("hdnChosaIraiRirekiNo")
    private RString hdnChosaIraiRirekiNo;
    @JsonProperty("directoryPath")
    private RString directoryPath;
    @JsonProperty("sharedFileNameValue")
    private RString sharedFileNameValue;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokkiJikoSelecting
     * @return TokkiJikoSelecting
     */
    @JsonProperty("TokkiJikoSelecting")
    public TokkiJikoSelectingDiv getTokkiJikoSelecting() {
        return TokkiJikoSelecting;
    }

    /*
     * setTokkiJikoSelecting
     * @param TokkiJikoSelecting TokkiJikoSelecting
     */
    @JsonProperty("TokkiJikoSelecting")
    public void setTokkiJikoSelecting(TokkiJikoSelectingDiv TokkiJikoSelecting) {
        this.TokkiJikoSelecting = TokkiJikoSelecting;
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

    /*
     * gethdnOperation
     * @return hdnOperation
     */
    @JsonProperty("hdnOperation")
    public RString getHdnOperation() {
        return hdnOperation;
    }

    /*
     * sethdnOperation
     * @param hdnOperation hdnOperation
     */
    @JsonProperty("hdnOperation")
    public void setHdnOperation(RString hdnOperation) {
        this.hdnOperation = hdnOperation;
    }

    /*
     * gethdnSharedFileID
     * @return hdnSharedFileID
     */
    @JsonProperty("hdnSharedFileID")
    public RString getHdnSharedFileID() {
        return hdnSharedFileID;
    }

    /*
     * sethdnSharedFileID
     * @param hdnSharedFileID hdnSharedFileID
     */
    @JsonProperty("hdnSharedFileID")
    public void setHdnSharedFileID(RString hdnSharedFileID) {
        this.hdnSharedFileID = hdnSharedFileID;
    }

    /*
     * gethdnShinseishoKanriNoValue
     * @return hdnShinseishoKanriNoValue
     */
    @JsonProperty("hdnShinseishoKanriNoValue")
    public RString getHdnShinseishoKanriNoValue() {
        return hdnShinseishoKanriNoValue;
    }

    /*
     * sethdnShinseishoKanriNoValue
     * @param hdnShinseishoKanriNoValue hdnShinseishoKanriNoValue
     */
    @JsonProperty("hdnShinseishoKanriNoValue")
    public void setHdnShinseishoKanriNoValue(RString hdnShinseishoKanriNoValue) {
        this.hdnShinseishoKanriNoValue = hdnShinseishoKanriNoValue;
    }

    /*
     * gethdnChosaIraiRirekiNo
     * @return hdnChosaIraiRirekiNo
     */
    @JsonProperty("hdnChosaIraiRirekiNo")
    public RString getHdnChosaIraiRirekiNo() {
        return hdnChosaIraiRirekiNo;
    }

    /*
     * sethdnChosaIraiRirekiNo
     * @param hdnChosaIraiRirekiNo hdnChosaIraiRirekiNo
     */
    @JsonProperty("hdnChosaIraiRirekiNo")
    public void setHdnChosaIraiRirekiNo(RString hdnChosaIraiRirekiNo) {
        this.hdnChosaIraiRirekiNo = hdnChosaIraiRirekiNo;
    }

    /*
     * getdirectoryPath
     * @return directoryPath
     */
    @JsonProperty("directoryPath")
    public RString getDirectoryPath() {
        return directoryPath;
    }

    /*
     * setdirectoryPath
     * @param directoryPath directoryPath
     */
    @JsonProperty("directoryPath")
    public void setDirectoryPath(RString directoryPath) {
        this.directoryPath = directoryPath;
    }

    /*
     * getsharedFileNameValue
     * @return sharedFileNameValue
     */
    @JsonProperty("sharedFileNameValue")
    public RString getSharedFileNameValue() {
        return sharedFileNameValue;
    }

    /*
     * setsharedFileNameValue
     * @param sharedFileNameValue sharedFileNameValue
     */
    @JsonProperty("sharedFileNameValue")
    public void setSharedFileNameValue(RString sharedFileNameValue) {
        this.sharedFileNameValue = sharedFileNameValue;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTokkiJikoNos() {
        return this.getTokkiJikoSelecting().getDdlTokkiJikoNos();
    }

    @JsonIgnore
    public void setDdlTokkiJikoNos(DropDownList ddlTokkiJikoNos) {
        this.getTokkiJikoSelecting().setDdlTokkiJikoNos(ddlTokkiJikoNos);
    }

    @JsonIgnore
    public Button getBtnToDisplay() {
        return this.getTokkiJikoSelecting().getBtnToDisplay();
    }

    @JsonIgnore
    public void setBtnToDisplay(Button btnToDisplay) {
        this.getTokkiJikoSelecting().setBtnToDisplay(btnToDisplay);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    //
    @Override
    public void initialize(RString directortyPath) {
        newHandler(this).initialize(directoryPath);
    }

    @Override
    public void refresh(RString directortyPath) {
        newHandler(this).refresh(directoryPath);
    }

    public TokkiImagesPerChosaDiv() {
    }

    @Override
    public FilesystemName getSharedFileName() {
        return newHandler(this).createOrFindSharedFileName();
    }

    @Override
    public ReadOnlySharedFileEntryDescriptor getSharedFileEntryDescriptor() {
        return new ReadOnlySharedFileEntryDescriptor(getSharedFileName(), getSharedFileID());
    }

    @Override
    @CheckForNull
    public ITokkiImagesPerKomokuDiv getEditing() {
        if (getOperation().is修正()) {
            List<ITokkiImagesPerKomokuDiv> list = getRepTokkiJikos().getRepeateData();
            return list.isEmpty() ? null : list.get(0);
        }
        return null;
    }

    @Override
    public void renderSelectedTokkiJiko() {
        newHandler(this).renderSelectedTokkiJiko();
    }

    @Override
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return new ShinseishoKanriNo(DataPassingConverter.deserialize(this.hdnShinseishoKanriNoValue, RString.class));
    }

    @Override
    public int getNinteichosaIraiRirekiNo() {
        return DataPassingConverter.deserialize(this.hdnChosaIraiRirekiNo, Integer.class);
    }

    @Override
    public Operation getOperation() {
        return DataPassingConverter.deserialize(this.hdnOperation, Operation.class);
    }

    @Override
    public RDateTime getSharedFileID() {
        if (RString.isNullOrEmpty(this.hdnSharedFileID)) {
            RDateTime rt = newHandler(this).findSharedFileID();
            this.hdnSharedFileID = DataPassingConverter.serialize(rt);
            return rt;
        }
        return DataPassingConverter.deserialize(this.hdnSharedFileID, RDateTime.class);
    }

    private static TokkiImagesPerChosaDivHandler newHandler(TokkiImagesPerChosaDiv div) {
        return new TokkiImagesPerChosaDivHandler(div);
    }

}
