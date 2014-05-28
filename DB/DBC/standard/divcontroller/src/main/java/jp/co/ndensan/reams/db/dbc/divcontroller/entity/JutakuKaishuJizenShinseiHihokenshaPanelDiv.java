package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KariKaigoCommonPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KariKihonPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinseiHihokenshaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiHihokenshaPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KariKihonPanel")
    private KariKihonPanelDiv KariKihonPanel;
    @JsonProperty("KariKaigoCommonPanel")
    private KariKaigoCommonPanelDiv KariKaigoCommonPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KariKihonPanel")
    public KariKihonPanelDiv getKariKihonPanel() {
        return KariKihonPanel;
    }

    @JsonProperty("KariKihonPanel")
    public void setKariKihonPanel(KariKihonPanelDiv KariKihonPanel) {
        this.KariKihonPanel=KariKihonPanel;
    }

    @JsonProperty("KariKaigoCommonPanel")
    public KariKaigoCommonPanelDiv getKariKaigoCommonPanel() {
        return KariKaigoCommonPanel;
    }

    @JsonProperty("KariKaigoCommonPanel")
    public void setKariKaigoCommonPanel(KariKaigoCommonPanelDiv KariKaigoCommonPanel) {
        this.KariKaigoCommonPanel=KariKaigoCommonPanel;
    }

}
