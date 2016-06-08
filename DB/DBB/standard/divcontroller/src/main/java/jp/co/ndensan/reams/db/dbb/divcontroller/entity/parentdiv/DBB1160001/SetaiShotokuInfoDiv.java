package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SetaiShotokuInfo のクラスファイル
 *
 * @reamsid_L DBB-1740-010 xuhao
 */
public class SetaiShotokuInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SetaiShotokuIchiran")
    private SetaiShotokuIchiranDiv SetaiShotokuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSetaiShotokuIchiran
     * @return SetaiShotokuIchiran
     */
    @JsonProperty("SetaiShotokuIchiran")
    public ISetaiShotokuIchiranDiv getSetaiShotokuIchiran() {
        return SetaiShotokuIchiran;
    }

    // </editor-fold>
}
