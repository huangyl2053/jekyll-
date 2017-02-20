package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DataTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class DataTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTorikomiNaiyo")
    private RadioButton radTorikomiNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTorikomiNaiyo
     * @return radTorikomiNaiyo
     */
    @JsonProperty("radTorikomiNaiyo")
    public RadioButton getRadTorikomiNaiyo() {
        return radTorikomiNaiyo;
    }

    /*
     * setradTorikomiNaiyo
     * @param radTorikomiNaiyo radTorikomiNaiyo
     */
    @JsonProperty("radTorikomiNaiyo")
    public void setRadTorikomiNaiyo(RadioButton radTorikomiNaiyo) {
        this.radTorikomiNaiyo = radTorikomiNaiyo;
    }

    // </editor-fold>
}
