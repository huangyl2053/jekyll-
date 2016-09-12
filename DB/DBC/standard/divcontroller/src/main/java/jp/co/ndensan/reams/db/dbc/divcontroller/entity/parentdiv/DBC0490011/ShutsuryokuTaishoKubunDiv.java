package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaishoKubun のクラスファイル
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShutsuryokuTaishoKubunDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShutsuryokuTaishoKubun")
    private CheckBoxList chkShutsuryokuTaishoKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShutsuryokuTaishoKubun
     * @return chkShutsuryokuTaishoKubun
     */
    @JsonProperty("chkShutsuryokuTaishoKubun")
    public CheckBoxList getChkShutsuryokuTaishoKubun() {
        return chkShutsuryokuTaishoKubun;
    }

    /*
     * setchkShutsuryokuTaishoKubun
     * @param chkShutsuryokuTaishoKubun chkShutsuryokuTaishoKubun
     */
    @JsonProperty("chkShutsuryokuTaishoKubun")
    public void setChkShutsuryokuTaishoKubun(CheckBoxList chkShutsuryokuTaishoKubun) {
        this.chkShutsuryokuTaishoKubun = chkShutsuryokuTaishoKubun;
    }

    // </editor-fold>
}
