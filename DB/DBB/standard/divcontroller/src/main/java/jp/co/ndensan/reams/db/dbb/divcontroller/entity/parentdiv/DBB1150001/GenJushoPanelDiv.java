package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GenJushoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenJushoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdZenkokuJushoInput3")
    private ZenkokuJushoInputDiv ccdZenkokuJushoInput3;
    @JsonProperty("txtGenJusho")
    private TextBox txtGenJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdZenkokuJushoInput3
     * @return ccdZenkokuJushoInput3
     */
    @JsonProperty("ccdZenkokuJushoInput3")
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput3() {
        return ccdZenkokuJushoInput3;
    }

    /*
     * gettxtGenJusho
     * @return txtGenJusho
     */
    @JsonProperty("txtGenJusho")
    public TextBox getTxtGenJusho() {
        return txtGenJusho;
    }

    /*
     * settxtGenJusho
     * @param txtGenJusho txtGenJusho
     */
    @JsonProperty("txtGenJusho")
    public void setTxtGenJusho(TextBox txtGenJusho) {
        this.txtGenJusho = txtGenJusho;
    }

    // </editor-fold>
}
