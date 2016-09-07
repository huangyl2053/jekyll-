package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaiishoIF のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaiishoIFDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNewFileName")
    private TextBox txtNewFileName;
    @JsonProperty("radIfShubetsu")
    private RadioButton radIfShubetsu;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNewFileName
     * @return txtNewFileName
     */
    @JsonProperty("txtNewFileName")
    public TextBox getTxtNewFileName() {
        return txtNewFileName;
    }

    /*
     * settxtNewFileName
     * @param txtNewFileName txtNewFileName
     */
    @JsonProperty("txtNewFileName")
    public void setTxtNewFileName(TextBox txtNewFileName) {
        this.txtNewFileName = txtNewFileName;
    }

    /*
     * getradIfShubetsu
     * @return radIfShubetsu
     */
    @JsonProperty("radIfShubetsu")
    public RadioButton getRadIfShubetsu() {
        return radIfShubetsu;
    }

    /*
     * setradIfShubetsu
     * @param radIfShubetsu radIfShubetsu
     */
    @JsonProperty("radIfShubetsu")
    public void setRadIfShubetsu(RadioButton radIfShubetsu) {
        this.radIfShubetsu = radIfShubetsu;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    // </editor-fold>
}
