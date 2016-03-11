package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * YokaigoNinteiShinsakaiIchiranList のクラスファイル
 *
 * @author 自動生成
 */
public class YokaigoNinteiShinsakaiIchiranListDiv extends Panel implements IYokaigoNinteiShinsakaiIchiranListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HyojiJoken")
    private HyojiJokenDiv HyojiJoken;
    @JsonProperty("dgShinsakaiIchiran")
    private DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHyojiJoken
     * @return HyojiJoken
     */
    @JsonProperty("HyojiJoken")
    public HyojiJokenDiv getHyojiJoken() {
        return HyojiJoken;
    }

    /*
     * setHyojiJoken
     * @param HyojiJoken HyojiJoken
     */
    @JsonProperty("HyojiJoken")
    public void setHyojiJoken(HyojiJokenDiv HyojiJoken) {
        this.HyojiJoken = HyojiJoken;
    }

    /*
     * getdgShinsakaiIchiran
     * @return dgShinsakaiIchiran
     */
    @JsonProperty("dgShinsakaiIchiran")
    public DataGrid<dgShinsakaiIchiran_Row> getDgShinsakaiIchiran() {
        return dgShinsakaiIchiran;
    }

    /*
     * setdgShinsakaiIchiran
     * @param dgShinsakaiIchiran dgShinsakaiIchiran
     */
    @JsonProperty("dgShinsakaiIchiran")
    public void setDgShinsakaiIchiran(DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran) {
        this.dgShinsakaiIchiran = dgShinsakaiIchiran;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum GridDisplayMode implements ICommonChildDivMode {

        KaisaiYoteiToroku("KaisaiYoteiToroku"),
        TaishoshaWaritsuke("TaishoshaWaritsuke"),
        ShinsakaiShiryoSakusei("ShinsakaiShiryoSakusei"),
        ShinsaKekkaToroku("ShinsaKekkaToroku"),
        JizenKekkaToroku("JizenKekkaToroku"),
        DataShutsuryoku("DataShutsuryoku"),
        HanteiKekka("HanteiKekka");

        private final String name;

        private GridDisplayMode(final String name) {
            this.name = name;
        }

        public static GridDisplayMode getEnum(String str) {
            GridDisplayMode[] enumArray = GridDisplayMode.values();

            for (GridDisplayMode enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public GridDisplayMode getMode_GridDisplayMode() {
        return (GridDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, GridDisplayMode.class);
    }

    public void setMode_GridDisplayMode(GridDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, GridDisplayMode.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtHyojiKikanFrom() {
        return this.getHyojiJoken().getTxtHyojiKikanFrom();
    }

    @JsonIgnore
    public void setTxtHyojiKikanFrom(TextBoxDate txtHyojiKikanFrom) {
        this.getHyojiJoken().setTxtHyojiKikanFrom(txtHyojiKikanFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtHyojiKikanTo() {
        return this.getHyojiJoken().getTxtHyojiKikanTo();
    }

    @JsonIgnore
    public void setTxtHyojiKikanTo(TextBoxDate txtHyojiKikanTo) {
        this.getHyojiJoken().setTxtHyojiKikanTo(txtHyojiKikanTo);
    }

    @JsonIgnore
    public RadioButton getRadHyojiJokenWaritsukeMikanryo() {
        return this.getHyojiJoken().getRadHyojiJokenWaritsukeMikanryo();
    }

    @JsonIgnore
    public void setRadHyojiJokenWaritsukeMikanryo(RadioButton radHyojiJokenWaritsukeMikanryo) {
        this.getHyojiJoken().setRadHyojiJokenWaritsukeMikanryo(radHyojiJokenWaritsukeMikanryo);
    }

    @JsonIgnore
    public RadioButton getRadHyojiJokenWaritsukeKanryo() {
        return this.getHyojiJoken().getRadHyojiJokenWaritsukeKanryo();
    }

    @JsonIgnore
    public void setRadHyojiJokenWaritsukeKanryo(RadioButton radHyojiJokenWaritsukeKanryo) {
        this.getHyojiJoken().setRadHyojiJokenWaritsukeKanryo(radHyojiJokenWaritsukeKanryo);
    }

    @JsonIgnore
    public RadioButton getRadHyojiJokenShinsakaiMikanryo() {
        return this.getHyojiJoken().getRadHyojiJokenShinsakaiMikanryo();
    }

    @JsonIgnore
    public void setRadHyojiJokenShinsakaiMikanryo(RadioButton radHyojiJokenShinsakaiMikanryo) {
        this.getHyojiJoken().setRadHyojiJokenShinsakaiMikanryo(radHyojiJokenShinsakaiMikanryo);
    }

    @JsonIgnore
    public RadioButton getRadHyojiJokenShinsakaiKanryo() {
        return this.getHyojiJoken().getRadHyojiJokenShinsakaiKanryo();
    }

    @JsonIgnore
    public void setRadHyojiJokenShinsakaiKanryo(RadioButton radHyojiJokenShinsakaiKanryo) {
        this.getHyojiJoken().setRadHyojiJokenShinsakaiKanryo(radHyojiJokenShinsakaiKanryo);
    }

    @JsonIgnore
    public RadioButton getRadDammyShinsakai() {
        return this.getHyojiJoken().getRadDammyShinsakai();
    }

    @JsonIgnore
    public void setRadDammyShinsakai(RadioButton radDammyShinsakai) {
        this.getHyojiJoken().setRadDammyShinsakai(radDammyShinsakai);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getHyojiJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getHyojiJoken().setBtnKensaku(btnKensaku);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
