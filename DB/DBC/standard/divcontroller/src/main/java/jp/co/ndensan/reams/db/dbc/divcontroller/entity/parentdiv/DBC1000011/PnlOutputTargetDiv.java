package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlOutputTarget のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlOutputTargetDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkOutputTargetKubun")
    private CheckBoxList chkOutputTargetKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkOutputTargetKubun
     * @return chkOutputTargetKubun
     */
    @JsonProperty("chkOutputTargetKubun")
    public CheckBoxList getChkOutputTargetKubun() {
        return chkOutputTargetKubun;
    }

    /*
     * setchkOutputTargetKubun
     * @param chkOutputTargetKubun chkOutputTargetKubun
     */
    @JsonProperty("chkOutputTargetKubun")
    public void setChkOutputTargetKubun(CheckBoxList chkOutputTargetKubun) {
        this.chkOutputTargetKubun = chkOutputTargetKubun;
    }

    // </editor-fold>
}
