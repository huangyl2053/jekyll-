package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton;
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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * JushochiTokureiDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class JushochiTokureiDialogButtonDiv extends Panel implements IJushochiTokureiDialogButtonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnJushochiTokureiDialog")
    private ButtonDialog btnJushochiTokureiDialog;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("hihoData")
    private RString hihoData;
    @JsonProperty("shutokuDate")
    private RString shutokuDate;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnJushochiTokureiDialog
     * @return btnJushochiTokureiDialog
     */
    @JsonProperty("btnJushochiTokureiDialog")
    public ButtonDialog getBtnJushochiTokureiDialog() {
        return btnJushochiTokureiDialog;
    }

    /*
     * setbtnJushochiTokureiDialog
     * @param btnJushochiTokureiDialog btnJushochiTokureiDialog
     */
    @JsonProperty("btnJushochiTokureiDialog")
    public void setBtnJushochiTokureiDialog(ButtonDialog btnJushochiTokureiDialog) {
        this.btnJushochiTokureiDialog = btnJushochiTokureiDialog;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(IItemList<HihokenshaDaicho> hihoData, HihokenshaNo hihoNo, FlexibleDate shutokuDate, JushochiTokureiState state) {
        this.setMode(state.getStateValue());
        this.setHihokenshaNo(hihoNo.getColumnValue());

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
