package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SetaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SetaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSetaiShotokuIchiran")
    private SetaiShotokuIchiranDiv ccdSetaiShotokuIchiran;
    @JsonProperty("paraState")
    private RString paraState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSetaiShotokuIchiran
     * @return ccdSetaiShotokuIchiran
     */
    @JsonProperty("ccdSetaiShotokuIchiran")
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return ccdSetaiShotokuIchiran;
    }

    /*
     * getparaState
     * @return paraState
     */
    @JsonProperty("paraState")
    public RString getParaState() {
        return paraState;
    }

    /*
     * setparaState
     * @param paraState paraState
     */
    @JsonProperty("paraState")
    public void setParaState(RString paraState) {
        this.paraState = paraState;
    }

    // </editor-fold>
}
