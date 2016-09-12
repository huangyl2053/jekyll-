package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0041011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.IKyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyodoIdoRenrakuhyoHenkoDetail のクラスファイル
 *
 * @reamsid_L DBC-2990-010 chenaoqi
 */
public class KyodoIdoRenrakuhyoHenkoDetailDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoDetailInfo")
    private KyodoJukyushaIdoRenrakuhyoDiv KyodoIdoRenrakuhyoHenkoDetailInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyodoIdoRenrakuhyoHenkoDetailInfo
     * @return KyodoIdoRenrakuhyoHenkoDetailInfo
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoDetailInfo")
    public IKyodoJukyushaIdoRenrakuhyoDiv getKyodoIdoRenrakuhyoHenkoDetailInfo() {
        return KyodoIdoRenrakuhyoHenkoDetailInfo;
    }

    // </editor-fold>
}
