package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.IryoHokenRirekiDialog.IryoHokenRirekiRowData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.iryohokenkanyujokyo.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * IryoHokenRirekiDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class IryoHokenRirekiDialogButtonDiv extends Panel implements IIryoHokenRirekiDialogButtonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryoHokenRireki")
    private ButtonDialog btnIryoHokenRireki;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("lasdecCode")
    private RString lasdecCode;
    @JsonProperty("saveData")
    private RString saveData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryoHokenRireki
     * @return btnIryoHokenRireki
     */
    @JsonProperty("btnIryoHokenRireki")
    public ButtonDialog getBtnIryoHokenRireki() {
        return btnIryoHokenRireki;
    }

    /*
     * setbtnIryoHokenRireki
     * @param btnIryoHokenRireki btnIryoHokenRireki
     */
    @JsonProperty("btnIryoHokenRireki")
    public void setBtnIryoHokenRireki(ButtonDialog btnIryoHokenRireki) {
        this.btnIryoHokenRireki = btnIryoHokenRireki;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getgridData
     * @return gridData
     */
    @JsonProperty("gridData")
    public RString getGridData() {
        return gridData;
    }

    /*
     * setgridData
     * @param gridData gridData
     */
    @JsonProperty("gridData")
    public void setGridData(RString gridData) {
        this.gridData = gridData;
    }

    /*
     * getlasdecCode
     * @return lasdecCode
     */
    @JsonProperty("lasdecCode")
    public RString getLasdecCode() {
        return lasdecCode;
    }

    /*
     * setlasdecCode
     * @param lasdecCode lasdecCode
     */
    @JsonProperty("lasdecCode")
    public void setLasdecCode(RString lasdecCode) {
        this.lasdecCode = lasdecCode;
    }

    /*
     * getsaveData
     * @return saveData
     */
    @JsonProperty("saveData")
    public RString getSaveData() {
        return saveData;
    }

    /*
     * setsaveData
     * @param saveData saveData
     */
    @JsonProperty("saveData")
    public void setSaveData(RString saveData) {
        this.saveData = saveData;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode, IryoHokenRirekiState state) {
        this.setShikibetsuCode(shikibetsuCode.value());
        this.setHihokenshaNo(hihokenshaNo.value());
        this.setMode(state.getStateValue());

        LasdecCode dantaiCode = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        this.setLasdecCode(dantaiCode.value());
    }

    @Override
    public int save() {
        if (this.getGridData() == null || this.getGridData().isEmpty()) {
            return 0;
        }

        ArrayList<IryohokenKanyuJokyo> dataList = DataPassingConverter.deserialize(this.getSaveData(), ArrayList.class);
        return IryohokenKanyuJokyoManager.createInstance().saveAllIryoHokenJoho(dataList);
    }
}
