package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.GenJushoNyuryokuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SofusakiNyuryokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SofusakiGenJushoShuseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofusakiGenJushoShuseiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SofusakiNyuryokuPanel")
    private SofusakiNyuryokuPanelDiv SofusakiNyuryokuPanel;
    @JsonProperty("GenJushoNyuryokuPanel")
    private GenJushoNyuryokuPanelDiv GenJushoNyuryokuPanel;
    @JsonProperty("btnShuseiHozon")
    private Button btnShuseiHozon;
    @JsonProperty("btnShuseiHaki")
    private Button btnShuseiHaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SofusakiNyuryokuPanel")
    public SofusakiNyuryokuPanelDiv getSofusakiNyuryokuPanel() {
        return SofusakiNyuryokuPanel;
    }

    @JsonProperty("SofusakiNyuryokuPanel")
    public void setSofusakiNyuryokuPanel(SofusakiNyuryokuPanelDiv SofusakiNyuryokuPanel) {
        this.SofusakiNyuryokuPanel=SofusakiNyuryokuPanel;
    }

    @JsonProperty("GenJushoNyuryokuPanel")
    public GenJushoNyuryokuPanelDiv getGenJushoNyuryokuPanel() {
        return GenJushoNyuryokuPanel;
    }

    @JsonProperty("GenJushoNyuryokuPanel")
    public void setGenJushoNyuryokuPanel(GenJushoNyuryokuPanelDiv GenJushoNyuryokuPanel) {
        this.GenJushoNyuryokuPanel=GenJushoNyuryokuPanel;
    }

    @JsonProperty("btnShuseiHozon")
    public Button getBtnShuseiHozon() {
        return btnShuseiHozon;
    }

    @JsonProperty("btnShuseiHozon")
    public void setBtnShuseiHozon(Button btnShuseiHozon) {
        this.btnShuseiHozon=btnShuseiHozon;
    }

    @JsonProperty("btnShuseiHaki")
    public Button getBtnShuseiHaki() {
        return btnShuseiHaki;
    }

    @JsonProperty("btnShuseiHaki")
    public void setBtnShuseiHaki(Button btnShuseiHaki) {
        this.btnShuseiHaki=btnShuseiHaki;
    }

}
