package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.NinteiChosaKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tabChosaKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tblSaiIchijiHanteiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tblShinsaTaishoshaShosaiDiv;
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
    @JsonProperty("tblShinsaTaishoshaShosai")
    private tblShinsaTaishoshaShosaiDiv tblShinsaTaishoshaShosai;
    @JsonProperty("tblSaiIchijiHanteiKekka")
    private tblSaiIchijiHanteiKekkaDiv tblSaiIchijiHanteiKekka;
    @JsonProperty("btnBackIchiran")
    private Button btnBackIchiran;
    @JsonProperty("NinteiChosaKekka")
    private NinteiChosaKekkaDiv NinteiChosaKekka;
    @JsonProperty("tabChosaKekka")
    private tabChosaKekkaDiv tabChosaKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblShinsaTaishoshaShosai")
    public tblShinsaTaishoshaShosaiDiv getTblShinsaTaishoshaShosai() {
        return tblShinsaTaishoshaShosai;
    }

    @JsonProperty("tblShinsaTaishoshaShosai")
    public void setTblShinsaTaishoshaShosai(tblShinsaTaishoshaShosaiDiv tblShinsaTaishoshaShosai) {
        this.tblShinsaTaishoshaShosai=tblShinsaTaishoshaShosai;
    }

    @JsonProperty("tblSaiIchijiHanteiKekka")
    public tblSaiIchijiHanteiKekkaDiv getTblSaiIchijiHanteiKekka() {
        return tblSaiIchijiHanteiKekka;
    }

    @JsonProperty("tblSaiIchijiHanteiKekka")
    public void setTblSaiIchijiHanteiKekka(tblSaiIchijiHanteiKekkaDiv tblSaiIchijiHanteiKekka) {
        this.tblSaiIchijiHanteiKekka=tblSaiIchijiHanteiKekka;
    }

    @JsonProperty("btnBackIchiran")
    public Button getBtnBackIchiran() {
        return btnBackIchiran;
    }

    @JsonProperty("btnBackIchiran")
    public void setBtnBackIchiran(Button btnBackIchiran) {
        this.btnBackIchiran=btnBackIchiran;
    }

    @JsonProperty("NinteiChosaKekka")
    public NinteiChosaKekkaDiv getNinteiChosaKekka() {
        return NinteiChosaKekka;
    }

    @JsonProperty("NinteiChosaKekka")
    public void setNinteiChosaKekka(NinteiChosaKekkaDiv NinteiChosaKekka) {
        this.NinteiChosaKekka=NinteiChosaKekka;
    }

    @JsonProperty("tabChosaKekka")
    public tabChosaKekkaDiv getTabChosaKekka() {
        return tabChosaKekka;
    }

    @JsonProperty("tabChosaKekka")
    public void setTabChosaKekka(tabChosaKekkaDiv tabChosaKekka) {
        this.tabChosaKekka=tabChosaKekka;
    }

}
