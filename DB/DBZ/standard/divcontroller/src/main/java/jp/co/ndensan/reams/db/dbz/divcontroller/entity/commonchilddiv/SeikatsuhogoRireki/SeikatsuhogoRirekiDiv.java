package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuhogoRireki のクラスファイル
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public class SeikatsuhogoRirekiDiv extends Panel implements ISeikatsuhogoRirekiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnRirekiAdd")
    private ButtonDialog btnRirekiAdd;
    @JsonProperty("dgSeikatsuhogoRireki")
    private DataGrid<dgSeikatsuhogoRireki_Row> dgSeikatsuhogoRireki;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;
    @JsonProperty("state")
    private RString state;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnRirekiAdd
     * @return btnRirekiAdd
     */
    @JsonProperty("btnRirekiAdd")
    public ButtonDialog getBtnRirekiAdd() {
        return btnRirekiAdd;
    }

    /*
     * setbtnRirekiAdd
     * @param btnRirekiAdd btnRirekiAdd
     */
    @JsonProperty("btnRirekiAdd")
    public void setBtnRirekiAdd(ButtonDialog btnRirekiAdd) {
        this.btnRirekiAdd = btnRirekiAdd;
    }

    /*
     * getdgSeikatsuhogoRireki
     * @return dgSeikatsuhogoRireki
     */
    @JsonProperty("dgSeikatsuhogoRireki")
    public DataGrid<dgSeikatsuhogoRireki_Row> getDgSeikatsuhogoRireki() {
        return dgSeikatsuhogoRireki;
    }

    /*
     * setdgSeikatsuhogoRireki
     * @param dgSeikatsuhogoRireki dgSeikatsuhogoRireki
     */
    @JsonProperty("dgSeikatsuhogoRireki")
    public void setDgSeikatsuhogoRireki(DataGrid<dgSeikatsuhogoRireki_Row> dgSeikatsuhogoRireki) {
        this.dgSeikatsuhogoRireki = dgSeikatsuhogoRireki;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 生活保護履歴画面の初期化処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 業務コード GyomuCode
     * @param 表示モード RString
     */
    @Override
    public void initialize(ShikibetsuCode 識別コード, GyomuCode 業務コード, RString 表示モード) {
        getHandler().initialize(識別コード, 業務コード, 表示モード);
    }

    private SeikatsuhogoRirekiHandler getHandler() {
        return new SeikatsuhogoRirekiHandler(this);
    }
}
