package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.CheckBoxesForNinteichosaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Ninteichosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CheckBoxesForNinteichosa")
    private CheckBoxesForNinteichosaDiv CheckBoxesForNinteichosa;
    @JsonProperty("txtOCRPaperID")
    private TextBoxCode txtOCRPaperID;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CheckBoxesForNinteichosa")
    public CheckBoxesForNinteichosaDiv getCheckBoxesForNinteichosa() {
        return CheckBoxesForNinteichosa;
    }

    @JsonProperty("CheckBoxesForNinteichosa")
    public void setCheckBoxesForNinteichosa(CheckBoxesForNinteichosaDiv CheckBoxesForNinteichosa) {
        this.CheckBoxesForNinteichosa=CheckBoxesForNinteichosa;
    }

    @JsonProperty("txtOCRPaperID")
    public TextBoxCode getTxtOCRPaperID() {
        return txtOCRPaperID;
    }

    @JsonProperty("txtOCRPaperID")
    public void setTxtOCRPaperID(TextBoxCode txtOCRPaperID) {
        this.txtOCRPaperID=txtOCRPaperID;
    }

}
