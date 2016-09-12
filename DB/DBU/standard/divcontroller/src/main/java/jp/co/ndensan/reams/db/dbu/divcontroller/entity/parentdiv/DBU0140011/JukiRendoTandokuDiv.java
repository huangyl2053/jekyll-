package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukiRendoTandoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukiRendoTandokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukiRendoTantokuBatchParameter")
    private JukiRendoTantokuBatchParameterDiv JukiRendoTantokuBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJukiRendoTantokuBatchParameter
     * @return JukiRendoTantokuBatchParameter
     */
    @JsonProperty("JukiRendoTantokuBatchParameter")
    public JukiRendoTantokuBatchParameterDiv getJukiRendoTantokuBatchParameter() {
        return JukiRendoTantokuBatchParameter;
    }

    /*
     * setJukiRendoTantokuBatchParameter
     * @param JukiRendoTantokuBatchParameter JukiRendoTantokuBatchParameter
     */
    @JsonProperty("JukiRendoTantokuBatchParameter")
    public void setJukiRendoTantokuBatchParameter(JukiRendoTantokuBatchParameterDiv JukiRendoTantokuBatchParameter) {
        this.JukiRendoTantokuBatchParameter = JukiRendoTantokuBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getCcdUploadPanel() {
        return this.getJukiRendoTantokuBatchParameter().getCcdUploadPanel();
    }

    @JsonIgnore
    public void  setCcdUploadPanel(UploadPanel ccdUploadPanel) {
        this.getJukiRendoTantokuBatchParameter().setCcdUploadPanel(ccdUploadPanel);
    }

    @JsonIgnore
    public SouShinFileInfoDiv getSouShinFileInfo() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo();
    }

    @JsonIgnore
    public void  setSouShinFileInfo(SouShinFileInfoDiv SouShinFileInfo) {
        this.getJukiRendoTantokuBatchParameter().setSouShinFileInfo(SouShinFileInfo);
    }

    @JsonIgnore
    public Button getBtnTorikomi() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getBtnTorikomi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKensu() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getTxtKensu();
    }

    @JsonIgnore
    public Label getLblTani() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getLblTani();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getTxtSakuseiYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtSakuseiTime() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getTxtSakuseiTime();
    }

    @JsonIgnore
    public Label getLblKuran() {
        return this.getJukiRendoTantokuBatchParameter().getSouShinFileInfo().getLblKuran();
    }

    // </editor-fold>
}
