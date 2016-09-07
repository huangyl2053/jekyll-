package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuseigenRirekiList のクラスファイル
 *
 * @reamsid_L DBC-4350-050 liuxiaoyu
 */
public class KyufuseigenRirekiListDiv extends Panel implements IKyufuseigenRirekiListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlKyufuseigen")
    private pnlKyufuseigenDiv pnlKyufuseigen;
    @JsonProperty("HihokenshaNo")
    private RString HihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlKyufuseigen
     * @return pnlKyufuseigen
     */
    @JsonProperty("pnlKyufuseigen")
    public pnlKyufuseigenDiv getPnlKyufuseigen() {
        return pnlKyufuseigen;
    }

    /*
     * setpnlKyufuseigen
     * @param pnlKyufuseigen pnlKyufuseigen
     */
    @JsonProperty("pnlKyufuseigen")
    public void setPnlKyufuseigen(pnlKyufuseigenDiv pnlKyufuseigen) {
        this.pnlKyufuseigen = pnlKyufuseigen;
    }

    /*
     * getHihokenshaNo
     * @return HihokenshaNo
     */
    @JsonProperty("HihokenshaNo")
    public RString getHihokenshaNo() {
        return HihokenshaNo;
    }

    /*
     * setHihokenshaNo
     * @param HihokenshaNo HihokenshaNo
     */
    @JsonProperty("HihokenshaNo")
    public void setHihokenshaNo(RString HihokenshaNo) {
        this.HihokenshaNo = HihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnClose() {
        return this.getPnlKyufuseigen().getPnlButton().getBtnClose();
    }

    @JsonIgnore
    public void setBtnClose(Button btnClose) {
        this.getPnlKyufuseigen().getPnlButton().setBtnClose(btnClose);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
