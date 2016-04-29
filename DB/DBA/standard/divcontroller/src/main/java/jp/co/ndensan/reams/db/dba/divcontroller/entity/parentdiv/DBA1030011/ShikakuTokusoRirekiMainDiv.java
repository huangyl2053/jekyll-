package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuTokusoRirekiMain のクラスファイル
 *
 */
public class ShikakuTokusoRirekiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShikakuTokusoRireki")
    private ShikakuTokusoRirekiDiv ccdShikakuTokusoRireki;
    @JsonProperty("ShikakuSoshitsuInput")
    private ShikakuSoshitsuInputDiv ShikakuSoshitsuInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShikakuTokusoRireki
     * @return ccdShikakuTokusoRireki
     */
    @JsonProperty("ccdShikakuTokusoRireki")
    public IShikakuTokusoRirekiDiv getCcdShikakuTokusoRireki() {
        return ccdShikakuTokusoRireki;
    }

    /*
     * getShikakuSoshitsuInput
     * @return ShikakuSoshitsuInput
     */
    @JsonProperty("ShikakuSoshitsuInput")
    public ShikakuSoshitsuInputDiv getShikakuSoshitsuInput() {
        return ShikakuSoshitsuInput;
    }

    /*
     * setShikakuSoshitsuInput
     * @param ShikakuSoshitsuInput ShikakuSoshitsuInput
     */
    @JsonProperty("ShikakuSoshitsuInput")
    public void setShikakuSoshitsuInput(ShikakuSoshitsuInputDiv ShikakuSoshitsuInput) {
        this.ShikakuSoshitsuInput = ShikakuSoshitsuInput;
    }

    // </editor-fold>
}
