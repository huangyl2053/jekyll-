package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBZJuryoininDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.URKozaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PaymentMethod のクラスファイル 
 * 
 * @author 自動生成
 */
public class PaymentMethodDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radPayMethod")
    private RadioButton radPayMethod;
    @JsonProperty("URKoza")
    private URKozaDiv URKoza;
    @JsonProperty("DBZJuryoinin")
    private DBZJuryoininDiv DBZJuryoinin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radPayMethod")
    public RadioButton getRadPayMethod() {
        return radPayMethod;
    }

    @JsonProperty("radPayMethod")
    public void setRadPayMethod(RadioButton radPayMethod) {
        this.radPayMethod=radPayMethod;
    }

    @JsonProperty("URKoza")
    public URKozaDiv getURKoza() {
        return URKoza;
    }

    @JsonProperty("URKoza")
    public void setURKoza(URKozaDiv URKoza) {
        this.URKoza=URKoza;
    }

    @JsonProperty("DBZJuryoinin")
    public DBZJuryoininDiv getDBZJuryoinin() {
        return DBZJuryoinin;
    }

    @JsonProperty("DBZJuryoinin")
    public void setDBZJuryoinin(DBZJuryoininDiv DBZJuryoinin) {
        this.DBZJuryoinin=DBZJuryoinin;
    }

}
