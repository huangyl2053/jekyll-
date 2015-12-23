package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;
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

/**
 * IryohokenRirekiCommonChildDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohokenRirekiCommonChildDivDiv extends Panel implements IIryohokenRirekiCommonChildDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("plIryohokenRireki")
    private plIryohokenRirekiDiv plIryohokenRireki;
    @JsonProperty("モード")
    private RString モード;
    @JsonProperty("識別コード")
    private RString 識別コード;
    @JsonProperty("市町村コード")
    private RString 市町村コード;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getplIryohokenRireki
     * @return plIryohokenRireki
     */
    @JsonProperty("plIryohokenRireki")
    public plIryohokenRirekiDiv getPlIryohokenRireki() {
        return plIryohokenRireki;
    }

    /*
     * setplIryohokenRireki
     * @param plIryohokenRireki plIryohokenRireki
     */
    @JsonProperty("plIryohokenRireki")
    public void setPlIryohokenRireki(plIryohokenRirekiDiv plIryohokenRireki) {
        this.plIryohokenRireki = plIryohokenRireki;
    }

    /*
     * getモード
     * @return モード
     */
    @JsonProperty("モード")
    public RString getモード() {
        return モード;
    }

    /*
     * setモード
     * @param モード モード
     */
    @JsonProperty("モード")
    public void setモード(RString モード) {
        this.モード = モード;
    }

    /*
     * get識別コード
     * @return 識別コード
     */
    @JsonProperty("識別コード")
    public RString get識別コード() {
        return 識別コード;
    }

    /*
     * set識別コード
     * @param 識別コード 識別コード
     */
    @JsonProperty("識別コード")
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /*
     * get市町村コード
     * @return 市町村コード
     */
    @JsonProperty("市町村コード")
    public RString get市町村コード() {
        return 市町村コード;
    }

    /*
     * set市町村コード
     * @param 市町村コード 市町村コード
     */
    @JsonProperty("市町村コード")
    public void set市町村コード(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnIryohokenTsuika() {
        return this.getPlIryohokenRireki().getBtnIryohokenTsuika();
    }

    @JsonIgnore
    public void  setBtnIryohokenTsuika(Button btnIryohokenTsuika) {
        this.getPlIryohokenRireki().setBtnIryohokenTsuika(btnIryohokenTsuika);
    }

    @JsonIgnore
    public DataGrid<dgIryohokenIchiran_Row> getDgIryohokenIchiran() {
        return this.getPlIryohokenRireki().getDgIryohokenIchiran();
    }

    @JsonIgnore
    public void  setDgIryohokenIchiran(DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran) {
        this.getPlIryohokenRireki().setDgIryohokenIchiran(dgIryohokenIchiran);
    }

    @JsonIgnore
    public pnlIryohokenJohoDiv getPnlIryohokenJoho() {
        return this.getPlIryohokenRireki().getPnlIryohokenJoho();
    }

    @JsonIgnore
    public void  setPnlIryohokenJoho(pnlIryohokenJohoDiv pnlIryohokenJoho) {
        this.getPlIryohokenRireki().setPnlIryohokenJoho(pnlIryohokenJoho);
    }

    @JsonIgnore
    public Button getBtnIryohokenKakute() {
        return this.getPlIryohokenRireki().getBtnIryohokenKakute();
    }

    @JsonIgnore
    public void  setBtnIryohokenKakute(Button btnIryohokenKakute) {
        this.getPlIryohokenRireki().setBtnIryohokenKakute(btnIryohokenKakute);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPlIryohokenRireki().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPlIryohokenRireki().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
