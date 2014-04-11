package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShuseiSetaiInListPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SofusakiGenJushoShuseiPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuShokaihyoShuseiNyuryokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuShokaihyoShuseiNyuryokuPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShuseiSetaiInListPanel")
    private ShuseiSetaiInListPanelDiv ShuseiSetaiInListPanel;
    @JsonProperty("SofusakiGenJushoShuseiPanel")
    private SofusakiGenJushoShuseiPanelDiv SofusakiGenJushoShuseiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShuseiSetaiInListPanel")
    public ShuseiSetaiInListPanelDiv getShuseiSetaiInListPanel() {
        return ShuseiSetaiInListPanel;
    }

    @JsonProperty("ShuseiSetaiInListPanel")
    public void setShuseiSetaiInListPanel(ShuseiSetaiInListPanelDiv ShuseiSetaiInListPanel) {
        this.ShuseiSetaiInListPanel=ShuseiSetaiInListPanel;
    }

    @JsonProperty("SofusakiGenJushoShuseiPanel")
    public SofusakiGenJushoShuseiPanelDiv getSofusakiGenJushoShuseiPanel() {
        return SofusakiGenJushoShuseiPanel;
    }

    @JsonProperty("SofusakiGenJushoShuseiPanel")
    public void setSofusakiGenJushoShuseiPanel(SofusakiGenJushoShuseiPanelDiv SofusakiGenJushoShuseiPanel) {
        this.SofusakiGenJushoShuseiPanel=SofusakiGenJushoShuseiPanel;
    }

}
