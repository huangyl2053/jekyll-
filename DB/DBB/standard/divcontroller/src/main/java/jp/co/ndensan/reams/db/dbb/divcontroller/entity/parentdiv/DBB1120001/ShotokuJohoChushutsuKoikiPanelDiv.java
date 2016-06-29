package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokuJohoChushutsuKoikiPanel のクラスファイル
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNendoKoiki")
    private TextBoxDate txtShoriNendoKoiki;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("dgShichosonIchiran")
    private DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran;
    @JsonProperty("ShotokuJohoIchiranKoiki")
    private ShotokuJohoIchiranKoikiDiv ShotokuJohoIchiranKoiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNendoKoiki
     * @return txtShoriNendoKoiki
     */
    @JsonProperty("txtShoriNendoKoiki")
    public TextBoxDate getTxtShoriNendoKoiki() {
        return txtShoriNendoKoiki;
    }

    /*
     * settxtShoriNendoKoiki
     * @param txtShoriNendoKoiki txtShoriNendoKoiki
     */
    @JsonProperty("txtShoriNendoKoiki")
    public void setTxtShoriNendoKoiki(TextBoxDate txtShoriNendoKoiki) {
        this.txtShoriNendoKoiki = txtShoriNendoKoiki;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getdgShichosonIchiran
     * @return dgShichosonIchiran
     */
    @JsonProperty("dgShichosonIchiran")
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return dgShichosonIchiran;
    }

    /*
     * setdgShichosonIchiran
     * @param dgShichosonIchiran dgShichosonIchiran
     */
    @JsonProperty("dgShichosonIchiran")
    public void setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.dgShichosonIchiran = dgShichosonIchiran;
    }

    /*
     * getShotokuJohoIchiranKoiki
     * @return ShotokuJohoIchiranKoiki
     */
    @JsonProperty("ShotokuJohoIchiranKoiki")
    public ShotokuJohoIchiranKoikiDiv getShotokuJohoIchiranKoiki() {
        return ShotokuJohoIchiranKoiki;
    }

    /*
     * setShotokuJohoIchiranKoiki
     * @param ShotokuJohoIchiranKoiki ShotokuJohoIchiranKoiki
     */
    @JsonProperty("ShotokuJohoIchiranKoiki")
    public void setShotokuJohoIchiranKoiki(ShotokuJohoIchiranKoikiDiv ShotokuJohoIchiranKoiki) {
        this.ShotokuJohoIchiranKoiki = ShotokuJohoIchiranKoiki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujunKoiki() {
        return this.getShotokuJohoIchiranKoiki().getCcdChohyoShutsuryokujunKoiki();
    }

    // </editor-fold>
}
