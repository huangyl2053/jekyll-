package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaDetailTabDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaDetailPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDetailPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaDetailTab")
    private HihokenshaDetailTabDiv HihokenshaDetailTab;
    @JsonProperty("btnBackShosaiInfo")
    private Button btnBackShosaiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaDetailTab")
    public HihokenshaDetailTabDiv getHihokenshaDetailTab() {
        return HihokenshaDetailTab;
    }

    @JsonProperty("HihokenshaDetailTab")
    public void setHihokenshaDetailTab(HihokenshaDetailTabDiv HihokenshaDetailTab) {
        this.HihokenshaDetailTab=HihokenshaDetailTab;
    }

    @JsonProperty("btnBackShosaiInfo")
    public Button getBtnBackShosaiInfo() {
        return btnBackShosaiInfo;
    }

    @JsonProperty("btnBackShosaiInfo")
    public void setBtnBackShosaiInfo(Button btnBackShosaiInfo) {
        this.btnBackShosaiInfo=btnBackShosaiInfo;
    }

}
