package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * AtoFukaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class AtoFukaJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtAtoFukaKetasu")
    private TextBoxNum txtAtoFukaKetasu;
    @JsonProperty("txtAtoFukaCode")
    private TextBoxCode txtAtoFukaCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtAtoFukaKetasu
     * @return txtAtoFukaKetasu
     */
    @JsonProperty("txtAtoFukaKetasu")
    public TextBoxNum getTxtAtoFukaKetasu() {
        return txtAtoFukaKetasu;
    }

    /*
     * settxtAtoFukaKetasu
     * @param txtAtoFukaKetasu txtAtoFukaKetasu
     */
    @JsonProperty("txtAtoFukaKetasu")
    public void setTxtAtoFukaKetasu(TextBoxNum txtAtoFukaKetasu) {
        this.txtAtoFukaKetasu = txtAtoFukaKetasu;
    }

    /*
     * gettxtAtoFukaCode
     * @return txtAtoFukaCode
     */
    @JsonProperty("txtAtoFukaCode")
    public TextBoxCode getTxtAtoFukaCode() {
        return txtAtoFukaCode;
    }

    /*
     * settxtAtoFukaCode
     * @param txtAtoFukaCode txtAtoFukaCode
     */
    @JsonProperty("txtAtoFukaCode")
    public void setTxtAtoFukaCode(TextBoxCode txtAtoFukaCode) {
        this.txtAtoFukaCode = txtAtoFukaCode;
    }

    // </editor-fold>
}
