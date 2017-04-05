package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
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
 * SeikatsuHogoJohoCommonDiv のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuHogoJohoCommonDivDiv extends Panel implements ISeikatsuHogoJohoCommonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-16_09-04-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlSeikatsuHogoJoho")
    private pnlSeikatsuHogoJohoDiv pnlSeikatsuHogoJoho;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("gyomuCode")
    private RString gyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlSeikatsuHogoJoho
     * @return pnlSeikatsuHogoJoho
     */
    @JsonProperty("pnlSeikatsuHogoJoho")
    public pnlSeikatsuHogoJohoDiv getPnlSeikatsuHogoJoho() {
        return pnlSeikatsuHogoJoho;
    }

    /*
     * setpnlSeikatsuHogoJoho
     * @param pnlSeikatsuHogoJoho pnlSeikatsuHogoJoho
     */
    @JsonProperty("pnlSeikatsuHogoJoho")
    public void setPnlSeikatsuHogoJoho(pnlSeikatsuHogoJohoDiv pnlSeikatsuHogoJoho) {
        this.pnlSeikatsuHogoJoho = pnlSeikatsuHogoJoho;
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
     * getgyomuCode
     * @return gyomuCode
     */
    @JsonProperty("gyomuCode")
    public RString getGyomuCode() {
        return gyomuCode;
    }

    /*
     * setgyomuCode
     * @param gyomuCode gyomuCode
     */
    @JsonProperty("gyomuCode")
    public void setGyomuCode(RString gyomuCode) {
        this.gyomuCode = gyomuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public panelSeikatsuHogoIchiranDiv getPanelSeikatsuHogoIchiran() {
        return this.getPnlSeikatsuHogoJoho().getPanelSeikatsuHogoIchiran();
    }

    @JsonIgnore
    public void  setPanelSeikatsuHogoIchiran(panelSeikatsuHogoIchiranDiv panelSeikatsuHogoIchiran) {
        this.getPnlSeikatsuHogoJoho().setPanelSeikatsuHogoIchiran(panelSeikatsuHogoIchiran);
    }

    @JsonIgnore
    public DataGrid<dgRirekiIchiran_Row> getDgRirekiIchiran() {
        return this.getPnlSeikatsuHogoJoho().getPanelSeikatsuHogoIchiran().getDgRirekiIchiran();
    }

    @JsonIgnore
    public void  setDgRirekiIchiran(DataGrid<dgRirekiIchiran_Row> dgRirekiIchiran) {
        this.getPnlSeikatsuHogoJoho().getPanelSeikatsuHogoIchiran().setDgRirekiIchiran(dgRirekiIchiran);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPnlSeikatsuHogoJoho().getPanelSeikatsuHogoIchiran().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPnlSeikatsuHogoJoho().getPanelSeikatsuHogoIchiran().setBtnClose(btnClose);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
