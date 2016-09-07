package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuPanel2 のクラスファイル
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class ChushutsuPanel2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdAtenaJoken")
    private HanyoListAtenaSelectDiv ccdAtenaJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdAtenaJoken
     * @return ccdAtenaJoken
     */
    @JsonProperty("ccdAtenaJoken")
    public IHanyoListAtenaSelectDiv getCcdAtenaJoken() {
        return ccdAtenaJoken;
    }

    // </editor-fold>
}
