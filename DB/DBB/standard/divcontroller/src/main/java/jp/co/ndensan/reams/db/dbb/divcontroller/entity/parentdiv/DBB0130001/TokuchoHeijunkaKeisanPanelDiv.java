package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TokuchoHeijunkaKeisanPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoHeijunkaKeisanPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HeijunkaAugustKeisan")
    private HeijunkaAugustKeisanDiv HeijunkaAugustKeisan;
    @JsonProperty("Heijunka8KeisanHohoPanel")
    private Heijunka8KeisanHohoPanelDiv Heijunka8KeisanHohoPanel;
    @JsonProperty("TokuchoHeijunkaPanel")
    private TokuchoHeijunkaPanelDiv TokuchoHeijunkaPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeijunkaAugustKeisan
     * @return HeijunkaAugustKeisan
     */
    @JsonProperty("HeijunkaAugustKeisan")
    public HeijunkaAugustKeisanDiv getHeijunkaAugustKeisan() {
        return HeijunkaAugustKeisan;
    }

    /*
     * setHeijunkaAugustKeisan
     * @param HeijunkaAugustKeisan HeijunkaAugustKeisan
     */
    @JsonProperty("HeijunkaAugustKeisan")
    public void setHeijunkaAugustKeisan(HeijunkaAugustKeisanDiv HeijunkaAugustKeisan) {
        this.HeijunkaAugustKeisan = HeijunkaAugustKeisan;
    }

    /*
     * getHeijunka8KeisanHohoPanel
     * @return Heijunka8KeisanHohoPanel
     */
    @JsonProperty("Heijunka8KeisanHohoPanel")
    public Heijunka8KeisanHohoPanelDiv getHeijunka8KeisanHohoPanel() {
        return Heijunka8KeisanHohoPanel;
    }

    /*
     * setHeijunka8KeisanHohoPanel
     * @param Heijunka8KeisanHohoPanel Heijunka8KeisanHohoPanel
     */
    @JsonProperty("Heijunka8KeisanHohoPanel")
    public void setHeijunka8KeisanHohoPanel(Heijunka8KeisanHohoPanelDiv Heijunka8KeisanHohoPanel) {
        this.Heijunka8KeisanHohoPanel = Heijunka8KeisanHohoPanel;
    }

    /*
     * getTokuchoHeijunkaPanel
     * @return TokuchoHeijunkaPanel
     */
    @JsonProperty("TokuchoHeijunkaPanel")
    public TokuchoHeijunkaPanelDiv getTokuchoHeijunkaPanel() {
        return TokuchoHeijunkaPanel;
    }

    /*
     * setTokuchoHeijunkaPanel
     * @param TokuchoHeijunkaPanel TokuchoHeijunkaPanel
     */
    @JsonProperty("TokuchoHeijunkaPanel")
    public void setTokuchoHeijunkaPanel(TokuchoHeijunkaPanelDiv TokuchoHeijunkaPanel) {
        this.TokuchoHeijunkaPanel = TokuchoHeijunkaPanel;
    }

    // </editor-fold>
}
