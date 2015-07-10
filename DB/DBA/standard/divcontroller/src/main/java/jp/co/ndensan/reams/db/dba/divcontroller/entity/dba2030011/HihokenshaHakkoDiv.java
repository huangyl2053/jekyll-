package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.IHihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaHakko のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("radPrintPosition")
    private RadioButton radPrintPosition;
    @JsonProperty("ccdHihokenshaShikakuHakko")
    private HihokenshaShikakuHakkoDiv ccdHihokenshaShikakuHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radPrintPosition")
    public RadioButton getRadPrintPosition() {
        return radPrintPosition;
    }

    @JsonProperty("radPrintPosition")
    public void setRadPrintPosition(RadioButton radPrintPosition) {
        this.radPrintPosition = radPrintPosition;
    }

    @JsonProperty("ccdHihokenshaShikakuHakko")
    public IHihokenshaShikakuHakkoDiv getCcdHihokenshaShikakuHakko() {
        return ccdHihokenshaShikakuHakko;
    }

}
