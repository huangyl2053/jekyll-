package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.TokuchoIdoJohoSaiSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgTokuchoIdoJoho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tbldgTokuchoIdoJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokuchoIdoJohoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoIdoJohoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuchoIdoJoho")
    private DataGrid<dgTokuchoIdoJoho_Row> dgTokuchoIdoJoho;
    @JsonProperty("tbldgTokuchoIdoJoho")
    private tbldgTokuchoIdoJohoDiv tbldgTokuchoIdoJoho;
    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    private TokuchoIdoJohoSaiSakuseiDiv TokuchoIdoJohoSaiSakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTokuchoIdoJoho")
    public DataGrid<dgTokuchoIdoJoho_Row> getDgTokuchoIdoJoho() {
        return dgTokuchoIdoJoho;
    }

    @JsonProperty("dgTokuchoIdoJoho")
    public void setDgTokuchoIdoJoho(DataGrid<dgTokuchoIdoJoho_Row> dgTokuchoIdoJoho) {
        this.dgTokuchoIdoJoho=dgTokuchoIdoJoho;
    }

    @JsonProperty("tbldgTokuchoIdoJoho")
    public tbldgTokuchoIdoJohoDiv getTbldgTokuchoIdoJoho() {
        return tbldgTokuchoIdoJoho;
    }

    @JsonProperty("tbldgTokuchoIdoJoho")
    public void setTbldgTokuchoIdoJoho(tbldgTokuchoIdoJohoDiv tbldgTokuchoIdoJoho) {
        this.tbldgTokuchoIdoJoho=tbldgTokuchoIdoJoho;
    }

    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    public TokuchoIdoJohoSaiSakuseiDiv getTokuchoIdoJohoSaiSakusei() {
        return TokuchoIdoJohoSaiSakusei;
    }

    @JsonProperty("TokuchoIdoJohoSaiSakusei")
    public void setTokuchoIdoJohoSaiSakusei(TokuchoIdoJohoSaiSakuseiDiv TokuchoIdoJohoSaiSakusei) {
        this.TokuchoIdoJohoSaiSakusei=TokuchoIdoJohoSaiSakusei;
    }

}
