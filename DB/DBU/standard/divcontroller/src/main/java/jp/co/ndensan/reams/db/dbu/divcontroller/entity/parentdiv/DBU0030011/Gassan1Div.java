package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Gassan1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Gassan1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cblGassan1")
    private CheckBoxList cblGassan1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcblGassan1
     * @return cblGassan1
     */
    @JsonProperty("cblGassan1")
    public CheckBoxList getCblGassan1() {
        return cblGassan1;
    }

    /*
     * setcblGassan1
     * @param cblGassan1 cblGassan1
     */
    @JsonProperty("cblGassan1")
    public void setCblGassan1(CheckBoxList cblGassan1) {
        this.cblGassan1 = cblGassan1;
    }

    // </editor-fold>
}
