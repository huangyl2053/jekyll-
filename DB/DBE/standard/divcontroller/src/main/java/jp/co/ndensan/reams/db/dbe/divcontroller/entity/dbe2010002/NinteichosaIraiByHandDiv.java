package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ninteichosaIraiListForByHandCom.NinteichosaIraiListForByHandCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.tblChosaIraiWaritsukeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiByHand のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiByHandDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblChosaIraiWaritsuke")
    private tblChosaIraiWaritsukeDiv tblChosaIraiWaritsuke;
    @JsonProperty("comNinteichosaIraiListGod")
    private NinteichosaIraiListForByHandCom comNinteichosaIraiListGod;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblChosaIraiWaritsuke")
    public tblChosaIraiWaritsukeDiv getTblChosaIraiWaritsuke() {
        return tblChosaIraiWaritsuke;
    }

    @JsonProperty("tblChosaIraiWaritsuke")
    public void setTblChosaIraiWaritsuke(tblChosaIraiWaritsukeDiv tblChosaIraiWaritsuke) {
        this.tblChosaIraiWaritsuke=tblChosaIraiWaritsuke;
    }

    @JsonProperty("comNinteichosaIraiListGod")
    public NinteichosaIraiListForByHandCom getComNinteichosaIraiListGod() {
        return comNinteichosaIraiListGod;
    }

    @JsonProperty("comNinteichosaIraiListGod")
    public void setComNinteichosaIraiListGod(NinteichosaIraiListForByHandCom comNinteichosaIraiListGod) {
        this.comNinteichosaIraiListGod=comNinteichosaIraiListGod;
    }

}
