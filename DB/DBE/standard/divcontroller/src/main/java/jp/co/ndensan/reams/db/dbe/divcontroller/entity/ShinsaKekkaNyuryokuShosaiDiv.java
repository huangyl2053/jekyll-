package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiChosaKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tabChosaKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsaKekkaNyuryokuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaKekkaNyuryokuShosaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsaTaishoshaShosai")
    private ShinsaTaishoshaShosaiDiv ShinsaTaishoshaShosai;
    @JsonProperty("btnBackIchiran")
    private Button btnBackIchiran;
    @JsonProperty("tabChosaKekka")
    private tabChosaKekkaDiv tabChosaKekka;
    @JsonProperty("NinteiChosaKekka")
    private NinteiChosaKekkaDiv NinteiChosaKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinsaTaishoshaShosai")
    public ShinsaTaishoshaShosaiDiv getShinsaTaishoshaShosai() {
        return ShinsaTaishoshaShosai;
    }

    @JsonProperty("ShinsaTaishoshaShosai")
    public void setShinsaTaishoshaShosai(ShinsaTaishoshaShosaiDiv ShinsaTaishoshaShosai) {
        this.ShinsaTaishoshaShosai=ShinsaTaishoshaShosai;
    }

    @JsonProperty("btnBackIchiran")
    public Button getBtnBackIchiran() {
        return btnBackIchiran;
    }

    @JsonProperty("btnBackIchiran")
    public void setBtnBackIchiran(Button btnBackIchiran) {
        this.btnBackIchiran=btnBackIchiran;
    }

    @JsonProperty("tabChosaKekka")
    public tabChosaKekkaDiv getTabChosaKekka() {
        return tabChosaKekka;
    }

    @JsonProperty("tabChosaKekka")
    public void setTabChosaKekka(tabChosaKekkaDiv tabChosaKekka) {
        this.tabChosaKekka=tabChosaKekka;
    }

    @JsonProperty("NinteiChosaKekka")
    public NinteiChosaKekkaDiv getNinteiChosaKekka() {
        return NinteiChosaKekka;
    }

    @JsonProperty("NinteiChosaKekka")
    public void setNinteiChosaKekka(NinteiChosaKekkaDiv NinteiChosaKekka) {
        this.NinteiChosaKekka=NinteiChosaKekka;
    }

}
