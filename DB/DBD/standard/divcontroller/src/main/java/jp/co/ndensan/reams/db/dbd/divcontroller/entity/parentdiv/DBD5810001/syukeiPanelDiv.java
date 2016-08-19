package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * syukeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class syukeiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("jyoukenPanel")
    private jyoukenPanelDiv jyoukenPanel;
    @JsonProperty("rdoshinsei")
    private RadioButton rdoshinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getjyoukenPanel
     * @return jyoukenPanel
     */
    @JsonProperty("jyoukenPanel")
    public jyoukenPanelDiv getJyoukenPanel() {
        return jyoukenPanel;
    }

    /*
     * setjyoukenPanel
     * @param jyoukenPanel jyoukenPanel
     */
    @JsonProperty("jyoukenPanel")
    public void setJyoukenPanel(jyoukenPanelDiv jyoukenPanel) {
        this.jyoukenPanel = jyoukenPanel;
    }

    /*
     * getrdoshinsei
     * @return rdoshinsei
     */
    @JsonProperty("rdoshinsei")
    public RadioButton getRdoshinsei() {
        return rdoshinsei;
    }

    /*
     * setrdoshinsei
     * @param rdoshinsei rdoshinsei
     */
    @JsonProperty("rdoshinsei")
    public void setRdoshinsei(RadioButton rdoshinsei) {
        this.rdoshinsei = rdoshinsei;
    }

    // </editor-fold>
}
