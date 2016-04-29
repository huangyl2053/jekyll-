package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaKihonInfo のクラスファイル
 *
 * @reamsid_L DBB-1740-010 xuhao
 */
public class AtenaKihonInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoFukaKihon")
    private KaigoFukaKihonDiv KaigoFukaKihon;
    @JsonProperty("KaigoAtenaInfo")
    private KaigoAtenaInfoDiv KaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoFukaKihon
     * @return KaigoFukaKihon
     */
    @JsonProperty("KaigoFukaKihon")
    public IKaigoFukaKihonDiv getKaigoFukaKihon() {
        return KaigoFukaKihon;
    }

    /*
     * getKaigoAtenaInfo
     * @return KaigoAtenaInfo
     */
    @JsonProperty("KaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return KaigoAtenaInfo;
    }

    // </editor-fold>
}
