package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SokujiKoseiTab1 のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiKoseiTab1Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujikouseiFukakonkyo")
    private SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo;
    @JsonProperty("GemmenGakuInput")
    private GemmenGakuInputDiv GemmenGakuInput;
    @JsonProperty("SokujikouseiKiwarigaku")
    private SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku;
    @JsonProperty("dgFuchoKanendo")
    private DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSokujikouseiFukakonkyo
     * @return SokujikouseiFukakonkyo
     */
    @JsonProperty("SokujikouseiFukakonkyo")
    public SokujikouseiFukakonkyoDiv getSokujikouseiFukakonkyo() {
        return SokujikouseiFukakonkyo;
    }

    /*
     * setSokujikouseiFukakonkyo
     * @param SokujikouseiFukakonkyo SokujikouseiFukakonkyo
     */
    @JsonProperty("SokujikouseiFukakonkyo")
    public void setSokujikouseiFukakonkyo(SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo) {
        this.SokujikouseiFukakonkyo = SokujikouseiFukakonkyo;
    }

    /*
     * getGemmenGakuInput
     * @return GemmenGakuInput
     */
    @JsonProperty("GemmenGakuInput")
    public GemmenGakuInputDiv getGemmenGakuInput() {
        return GemmenGakuInput;
    }

    /*
     * setGemmenGakuInput
     * @param GemmenGakuInput GemmenGakuInput
     */
    @JsonProperty("GemmenGakuInput")
    public void setGemmenGakuInput(GemmenGakuInputDiv GemmenGakuInput) {
        this.GemmenGakuInput = GemmenGakuInput;
    }

    /*
     * getSokujikouseiKiwarigaku
     * @return SokujikouseiKiwarigaku
     */
    @JsonProperty("SokujikouseiKiwarigaku")
    public SokujikouseiKiwarigakuDiv getSokujikouseiKiwarigaku() {
        return SokujikouseiKiwarigaku;
    }

    /*
     * setSokujikouseiKiwarigaku
     * @param SokujikouseiKiwarigaku SokujikouseiKiwarigaku
     */
    @JsonProperty("SokujikouseiKiwarigaku")
    public void setSokujikouseiKiwarigaku(SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku) {
        this.SokujikouseiKiwarigaku = SokujikouseiKiwarigaku;
    }

    /*
     * getdgFuchoKanendo
     * @return dgFuchoKanendo
     */
    @JsonProperty("dgFuchoKanendo")
    public DataGrid<dgFuchoKanendo_Row> getDgFuchoKanendo() {
        return dgFuchoKanendo;
    }

    /*
     * setdgFuchoKanendo
     * @param dgFuchoKanendo dgFuchoKanendo
     */
    @JsonProperty("dgFuchoKanendo")
    public void setDgFuchoKanendo(DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo) {
        this.dgFuchoKanendo = dgFuchoKanendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuInput() {
        return this.getGemmenGakuInput().getTxtGemmenGakuInput();
    }

    @JsonIgnore
    public void setTxtGemmenGakuInput(TextBoxNum txtGemmenGakuInput) {
        this.getGemmenGakuInput().setTxtGemmenGakuInput(txtGemmenGakuInput);
    }

    @JsonIgnore
    public Button getBtnApplyGemmenGaku() {
        return this.getGemmenGakuInput().getBtnApplyGemmenGaku();
    }

    @JsonIgnore
    public void setBtnApplyGemmenGaku(Button btnApplyGemmenGaku) {
        this.getGemmenGakuInput().setBtnApplyGemmenGaku(btnApplyGemmenGaku);
    }

    // </editor-fold>
}
