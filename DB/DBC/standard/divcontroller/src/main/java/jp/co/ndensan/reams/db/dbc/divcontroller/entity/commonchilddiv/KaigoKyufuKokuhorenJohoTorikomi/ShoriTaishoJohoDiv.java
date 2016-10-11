package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriTaishoJoho のクラスファイル
 *
 * @reamsid_L DBC-0980-290 wangkanglei
 */
public class ShoriTaishoJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShoriTaishoJoho")
    private Label lblShoriTaishoJoho;
    @JsonProperty("chkTsuJobun")
    private CheckBoxList chkTsuJobun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShoriTaishoJoho
     * @return lblShoriTaishoJoho
     */
    @JsonProperty("lblShoriTaishoJoho")
    public Label getLblShoriTaishoJoho() {
        return lblShoriTaishoJoho;
    }

    /*
     * setlblShoriTaishoJoho
     * @param lblShoriTaishoJoho lblShoriTaishoJoho
     */
    @JsonProperty("lblShoriTaishoJoho")
    public void setLblShoriTaishoJoho(Label lblShoriTaishoJoho) {
        this.lblShoriTaishoJoho = lblShoriTaishoJoho;
    }

    /*
     * getchkTsuJobun
     * @return chkTsuJobun
     */
    @JsonProperty("chkTsuJobun")
    public CheckBoxList getChkTsuJobun() {
        return chkTsuJobun;
    }

    /*
     * setchkTsuJobun
     * @param chkTsuJobun chkTsuJobun
     */
    @JsonProperty("chkTsuJobun")
    public void setChkTsuJobun(CheckBoxList chkTsuJobun) {
        this.chkTsuJobun = chkTsuJobun;
    }

    // </editor-fold>
}
