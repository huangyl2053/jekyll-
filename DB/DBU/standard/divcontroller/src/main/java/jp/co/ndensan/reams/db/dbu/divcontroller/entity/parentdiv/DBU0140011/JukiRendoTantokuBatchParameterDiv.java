package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JukiRendoTantokuBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukiRendoTantokuBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdUploadPanel")
    private UploadPanel ccdUploadPanel;
    @JsonProperty("SouShinFileInfo")
    private SouShinFileInfoDiv SouShinFileInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdUploadPanel
     * @return ccdUploadPanel
     */
    @JsonProperty("ccdUploadPanel")
    public UploadPanel getCcdUploadPanel() {
        return ccdUploadPanel;
    }

    /*
     * setccdUploadPanel
     * @param ccdUploadPanel ccdUploadPanel
     */
    @JsonProperty("ccdUploadPanel")
    public void setCcdUploadPanel(UploadPanel ccdUploadPanel) {
        this.ccdUploadPanel = ccdUploadPanel;
    }

    /*
     * getSouShinFileInfo
     * @return SouShinFileInfo
     */
    @JsonProperty("SouShinFileInfo")
    public SouShinFileInfoDiv getSouShinFileInfo() {
        return SouShinFileInfo;
    }

    /*
     * setSouShinFileInfo
     * @param SouShinFileInfo SouShinFileInfo
     */
    @JsonProperty("SouShinFileInfo")
    public void setSouShinFileInfo(SouShinFileInfoDiv SouShinFileInfo) {
        this.SouShinFileInfo = SouShinFileInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnTorikomi() {
        return this.getSouShinFileInfo().getBtnTorikomi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKensu() {
        return this.getSouShinFileInfo().getTxtKensu();
    }

    @JsonIgnore
    public Label getLblTani() {
        return this.getSouShinFileInfo().getLblTani();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD() {
        return this.getSouShinFileInfo().getTxtSakuseiYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime() {
        return this.getSouShinFileInfo().getTxtSakuseiTime();
    }

    @JsonIgnore
    public Label getLblKuran() {
        return this.getSouShinFileInfo().getLblKuran();
    }

    // </editor-fold>
}
