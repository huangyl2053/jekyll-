package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShisetsuNyutaisho のクラスファイル
 *
 */
public class tplShisetsuNyutaishoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShisetsuNyutaishoRireki")
    private ShisetsuNyutaishoRirekiKanriDiv ccdShisetsuNyutaishoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShisetsuNyutaishoRireki
     * @return ccdShisetsuNyutaishoRireki
     */
    @JsonProperty("ccdShisetsuNyutaishoRireki")
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRireki() {
        return ccdShisetsuNyutaishoRireki;
    }

    // </editor-fold>
}
