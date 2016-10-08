package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton;
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
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * ShikakuHenkoRirekiDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuHenkoRirekiDialogButtonDiv extends Panel implements IShikakuHenkoRirekiDialogButtonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShikakuHenkoRirekiDialog")
    private ButtonDialog btnShikakuHenkoRirekiDialog;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("hihoData")
    private RString hihoData;
    @JsonProperty("shutokuDate")
    private RString shutokuDate;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShikakuHenkoRirekiDialog
     * @return btnShikakuHenkoRirekiDialog
     */
    @JsonProperty("btnShikakuHenkoRirekiDialog")
    public ButtonDialog getBtnShikakuHenkoRirekiDialog() {
        return btnShikakuHenkoRirekiDialog;
    }

    /*
     * setbtnShikakuHenkoRirekiDialog
     * @param btnShikakuHenkoRirekiDialog btnShikakuHenkoRirekiDialog
     */
    @JsonProperty("btnShikakuHenkoRirekiDialog")
    public void setBtnShikakuHenkoRirekiDialog(ButtonDialog btnShikakuHenkoRirekiDialog) {
        this.btnShikakuHenkoRirekiDialog = btnShikakuHenkoRirekiDialog;
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
     * gethihoData
     * @return hihoData
     */
    @JsonProperty("hihoData")
    public RString getHihoData() {
        return hihoData;
    }

    /*
     * sethihoData
     * @param hihoData hihoData
     */
    @JsonProperty("hihoData")
    public void setHihoData(RString hihoData) {
        this.hihoData = hihoData;
    }

    /*
     * getshutokuDate
     * @return shutokuDate
     */
    @JsonProperty("shutokuDate")
    public RString getShutokuDate() {
        return shutokuDate;
    }

    /*
     * setshutokuDate
     * @param shutokuDate shutokuDate
     */
    @JsonProperty("shutokuDate")
    public void setShutokuDate(RString shutokuDate) {
        this.shutokuDate = shutokuDate;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(IItemList<HihokenshaDaicho> hihoData, ShikibetsuCode shikibetsuCode,
            FlexibleDate shutokuDate, ShikakuHenkoState state) {
        this.setMode(state.getStateValue());
        this.setShikibetsuCode(shikibetsuCode.getColumnValue());

        FlexibleDate settingShutokuDate = FlexibleDate.EMPTY;
        if (shutokuDate != null) {
            settingShutokuDate = shutokuDate;
        }
        this.setShutokuDate(new RString(settingShutokuDate.toString()));

        ArrayList<HihokenshaDaicho> serialList = new ArrayList<>();
        for (HihokenshaDaicho daicho : hihoData) {
            serialList.add(daicho);
        }
        this.setHihoData(DataPassingConverter.serialize(serialList));
    }

    @Override
    public IItemList<HihokenshaDaicho> get修正後被保険者データ() {
        ArrayList serialHihoData = DataPassingConverter.deserialize(this.getHihoData(), ArrayList.class);
        return ItemList.of(serialHihoData);
    }
}
