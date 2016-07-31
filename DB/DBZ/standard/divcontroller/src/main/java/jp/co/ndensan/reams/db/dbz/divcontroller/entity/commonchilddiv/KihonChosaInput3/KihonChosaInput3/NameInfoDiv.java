package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NameInfo のクラスファイル
 *
 * @author 自動生成
 */
public class NameInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnNameInfo")
    private ButtonDialog btnNameInfo;
    @JsonProperty("radNameInfo")
    private RadioButton radNameInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnNameInfo
     * @return btnNameInfo
     */
    @JsonProperty("btnNameInfo")
    public ButtonDialog getBtnNameInfo() {
        return btnNameInfo;
    }

    /*
     * setbtnNameInfo
     * @param btnNameInfo btnNameInfo
     */
    @JsonProperty("btnNameInfo")
    public void setBtnNameInfo(ButtonDialog btnNameInfo) {
        this.btnNameInfo = btnNameInfo;
    }

    /*
     * getradNameInfo
     * @return radNameInfo
     */
    @JsonProperty("radNameInfo")
    public RadioButton getRadNameInfo() {
        return radNameInfo;
    }

    /*
     * setradNameInfo
     * @param radNameInfo radNameInfo
     */
    @JsonProperty("radNameInfo")
    public void setRadNameInfo(RadioButton radNameInfo) {
        this.radNameInfo = radNameInfo;
    }

    // </editor-fold>
}
