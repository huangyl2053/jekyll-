package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiDetail.KogakuServicehiDetailDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuServicehiInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuServicehiInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuNushiJuminJoho")
    private KogakuNushiJuminJohoDiv KogakuNushiJuminJoho;
    @JsonProperty("btnShowSeteiJoho")
    private Button btnShowSeteiJoho;
    @JsonProperty("btnShowTwo")
    private Button btnShowTwo;
    @JsonProperty("KogakuServiceDetail")
    private KogakuServicehiDetailDiv KogakuServiceDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KogakuNushiJuminJoho")
    public KogakuNushiJuminJohoDiv getKogakuNushiJuminJoho() {
        return KogakuNushiJuminJoho;
    }

    @JsonProperty("KogakuNushiJuminJoho")
    public void setKogakuNushiJuminJoho(KogakuNushiJuminJohoDiv KogakuNushiJuminJoho) {
        this.KogakuNushiJuminJoho=KogakuNushiJuminJoho;
    }

    @JsonProperty("btnShowSeteiJoho")
    public Button getBtnShowSeteiJoho() {
        return btnShowSeteiJoho;
    }

    @JsonProperty("btnShowSeteiJoho")
    public void setBtnShowSeteiJoho(Button btnShowSeteiJoho) {
        this.btnShowSeteiJoho=btnShowSeteiJoho;
    }

    @JsonProperty("btnShowTwo")
    public Button getBtnShowTwo() {
        return btnShowTwo;
    }

    @JsonProperty("btnShowTwo")
    public void setBtnShowTwo(Button btnShowTwo) {
        this.btnShowTwo=btnShowTwo;
    }

    @JsonProperty("KogakuServiceDetail")
    public KogakuServicehiDetailDiv getKogakuServiceDetail() {
        return KogakuServiceDetail;
    }

    @JsonProperty("KogakuServiceDetail")
    public void setKogakuServiceDetail(KogakuServicehiDetailDiv KogakuServiceDetail) {
        this.KogakuServiceDetail=KogakuServiceDetail;
    }

}
