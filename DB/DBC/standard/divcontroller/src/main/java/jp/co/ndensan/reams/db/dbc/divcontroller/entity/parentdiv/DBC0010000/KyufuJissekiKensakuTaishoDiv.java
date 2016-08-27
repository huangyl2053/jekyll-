package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiKensakuTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKensakuTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaisho1")
    private RadioButton radTaisho1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaisho1
     * @return radTaisho1
     */
    @JsonProperty("radTaisho1")
    public RadioButton getRadTaisho1() {
        return radTaisho1;
    }

    /*
     * setradTaisho1
     * @param radTaisho1 radTaisho1
     */
    @JsonProperty("radTaisho1")
    public void setRadTaisho1(RadioButton radTaisho1) {
        this.radTaisho1 = radTaisho1;
    }

    // </editor-fold>
}
