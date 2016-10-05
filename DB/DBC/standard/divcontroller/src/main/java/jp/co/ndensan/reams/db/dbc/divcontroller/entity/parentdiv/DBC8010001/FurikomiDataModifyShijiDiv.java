package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FurikomiDataModifyShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class FurikomiDataModifyShijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    private TextBoxDate txtWrongFurikomiShiteiYMD;
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    private TextBoxDate txtCorrectFurikomiShiteiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtWrongFurikomiShiteiYMD
     * @return txtWrongFurikomiShiteiYMD
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    public TextBoxDate getTxtWrongFurikomiShiteiYMD() {
        return txtWrongFurikomiShiteiYMD;
    }

    /*
     * settxtWrongFurikomiShiteiYMD
     * @param txtWrongFurikomiShiteiYMD txtWrongFurikomiShiteiYMD
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    public void setTxtWrongFurikomiShiteiYMD(TextBoxDate txtWrongFurikomiShiteiYMD) {
        this.txtWrongFurikomiShiteiYMD = txtWrongFurikomiShiteiYMD;
    }

    /*
     * gettxtCorrectFurikomiShiteiYMD
     * @return txtCorrectFurikomiShiteiYMD
     */
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    public TextBoxDate getTxtCorrectFurikomiShiteiYMD() {
        return txtCorrectFurikomiShiteiYMD;
    }

    /*
     * settxtCorrectFurikomiShiteiYMD
     * @param txtCorrectFurikomiShiteiYMD txtCorrectFurikomiShiteiYMD
     */
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    public void setTxtCorrectFurikomiShiteiYMD(TextBoxDate txtCorrectFurikomiShiteiYMD) {
        this.txtCorrectFurikomiShiteiYMD = txtCorrectFurikomiShiteiYMD;
    }

    // </editor-fold>
}
