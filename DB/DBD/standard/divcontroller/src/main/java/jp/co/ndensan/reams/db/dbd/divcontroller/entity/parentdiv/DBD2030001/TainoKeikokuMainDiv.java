package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TainoKeikokuMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoKeikokuMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TainoKeikokuInitial")
    private TainoKeikokuInitialDiv TainoKeikokuInitial;
    @JsonProperty("TainoKeikoku")
    private TainoKeikokuDiv TainoKeikoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTainoKeikokuInitial
     * @return TainoKeikokuInitial
     */
    @JsonProperty("TainoKeikokuInitial")
    public TainoKeikokuInitialDiv getTainoKeikokuInitial() {
        return TainoKeikokuInitial;
    }

    /*
     * setTainoKeikokuInitial
     * @param TainoKeikokuInitial TainoKeikokuInitial
     */
    @JsonProperty("TainoKeikokuInitial")
    public void setTainoKeikokuInitial(TainoKeikokuInitialDiv TainoKeikokuInitial) {
        this.TainoKeikokuInitial = TainoKeikokuInitial;
    }

    /*
     * getTainoKeikoku
     * @return TainoKeikoku
     */
    @JsonProperty("TainoKeikoku")
    public TainoKeikokuDiv getTainoKeikoku() {
        return TainoKeikoku;
    }

    /*
     * setTainoKeikoku
     * @param TainoKeikoku TainoKeikoku
     */
    @JsonProperty("TainoKeikoku")
    public void setTainoKeikoku(TainoKeikokuDiv TainoKeikoku) {
        this.TainoKeikoku = TainoKeikoku;
    }

    // </editor-fold>
}
