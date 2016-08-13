package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinseishoIkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishoIkkatsuHakkoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("GenmenShinseiHaakuList")
    private GenmenShinseiHaakuListDiv GenmenShinseiHaakuList;
    @JsonProperty("SetaiShotokuIchiranPanel")
    private SetaiShotokuIchiranPanelDiv SetaiShotokuIchiranPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getGenmenShinseiHaakuList
     * @return GenmenShinseiHaakuList
     */
    @JsonProperty("GenmenShinseiHaakuList")
    public GenmenShinseiHaakuListDiv getGenmenShinseiHaakuList() {
        return GenmenShinseiHaakuList;
    }

    /*
     * setGenmenShinseiHaakuList
     * @param GenmenShinseiHaakuList GenmenShinseiHaakuList
     */
    @JsonProperty("GenmenShinseiHaakuList")
    public void setGenmenShinseiHaakuList(GenmenShinseiHaakuListDiv GenmenShinseiHaakuList) {
        this.GenmenShinseiHaakuList = GenmenShinseiHaakuList;
    }

    /*
     * getSetaiShotokuIchiranPanel
     * @return SetaiShotokuIchiranPanel
     */
    @JsonProperty("SetaiShotokuIchiranPanel")
    public SetaiShotokuIchiranPanelDiv getSetaiShotokuIchiranPanel() {
        return SetaiShotokuIchiranPanel;
    }

    /*
     * setSetaiShotokuIchiranPanel
     * @param SetaiShotokuIchiranPanel SetaiShotokuIchiranPanel
     */
    @JsonProperty("SetaiShotokuIchiranPanel")
    public void setSetaiShotokuIchiranPanel(SetaiShotokuIchiranPanelDiv SetaiShotokuIchiranPanel) {
        this.SetaiShotokuIchiranPanel = SetaiShotokuIchiranPanel;
    }

    // </editor-fold>
}
