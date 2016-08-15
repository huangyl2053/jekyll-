package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenFukaRirekiAll のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenFukaRirekiAllDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdFukaRirekiAll")
    private FukaRirekiAllDiv ccdFukaRirekiAll;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdFukaRirekiAll
     * @return ccdFukaRirekiAll
     */
    @JsonProperty("ccdFukaRirekiAll")
    public IFukaRirekiAllDiv getCcdFukaRirekiAll() {
        return ccdFukaRirekiAll;
    }

    // </editor-fold>
}
