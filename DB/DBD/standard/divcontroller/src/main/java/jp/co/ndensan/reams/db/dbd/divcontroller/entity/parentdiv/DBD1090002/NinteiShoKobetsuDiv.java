package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NinteiShoKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShoKobetsuDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtKetteiTsuchiHakkoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiTsuchiHakkoYMD
     * @return txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtKetteiTsuchiHakkoYMD() {
        return txtKetteiTsuchiHakkoYMD;
    }

    /*
     * settxtKetteiTsuchiHakkoYMD
     * @param txtKetteiTsuchiHakkoYMD txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchiHakkoYMD) {
        this.txtKetteiTsuchiHakkoYMD = txtKetteiTsuchiHakkoYMD;
    }

    // </editor-fold>
}
