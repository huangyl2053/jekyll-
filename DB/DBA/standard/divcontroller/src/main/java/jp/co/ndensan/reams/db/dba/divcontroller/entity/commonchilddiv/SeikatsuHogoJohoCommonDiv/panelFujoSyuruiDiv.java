package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelFujoSyurui のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelFujoSyuruiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkboxFujoSyurui")
    private CheckBoxList chkboxFujoSyurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkboxFujoSyurui
     * @return chkboxFujoSyurui
     */
    @JsonProperty("chkboxFujoSyurui")
    public CheckBoxList getChkboxFujoSyurui() {
        return chkboxFujoSyurui;
    }

    /*
     * setchkboxFujoSyurui
     * @param chkboxFujoSyurui chkboxFujoSyurui
     */
    @JsonProperty("chkboxFujoSyurui")
    public void setChkboxFujoSyurui(CheckBoxList chkboxFujoSyurui) {
        this.chkboxFujoSyurui = chkboxFujoSyurui;
    }

    // </editor-fold>
}
