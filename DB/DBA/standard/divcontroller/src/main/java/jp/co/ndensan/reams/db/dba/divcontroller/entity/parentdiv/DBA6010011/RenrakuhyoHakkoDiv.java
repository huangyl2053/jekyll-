package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RenrakuhyoHakko のクラスファイル
 *
 * @author 自動生成
 */
public class RenrakuhyoHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdPrintContentsSetting")
    private PrintContentsSettingDiv ccdPrintContentsSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdPrintContentsSetting")
    public IPrintContentsSettingDiv getCcdPrintContentsSetting() {
        return ccdPrintContentsSetting;
    }

}
