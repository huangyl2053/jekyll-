package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * SokujiKoseiTab1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiKoseiTab1Div extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujikouseiFukakonkyo")
    private SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo;
    @JsonProperty("SokujikouseiKiwarigaku")
    private SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku;
    @JsonProperty("dgFuchoKanendo")
    private DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujikouseiFukakonkyo")
    public SokujikouseiFukakonkyoDiv getSokujikouseiFukakonkyo() {
        return SokujikouseiFukakonkyo;
    }

    @JsonProperty("SokujikouseiFukakonkyo")
    public void setSokujikouseiFukakonkyo(SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo) {
        this.SokujikouseiFukakonkyo=SokujikouseiFukakonkyo;
    }

    @JsonProperty("SokujikouseiKiwarigaku")
    public SokujikouseiKiwarigakuDiv getSokujikouseiKiwarigaku() {
        return SokujikouseiKiwarigaku;
    }

    @JsonProperty("SokujikouseiKiwarigaku")
    public void setSokujikouseiKiwarigaku(SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku) {
        this.SokujikouseiKiwarigaku=SokujikouseiKiwarigaku;
    }

    @JsonProperty("dgFuchoKanendo")
    public DataGrid<dgFuchoKanendo_Row> getDgFuchoKanendo() {
        return dgFuchoKanendo;
    }

    @JsonProperty("dgFuchoKanendo")
    public void setDgFuchoKanendo(DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo) {
        this.dgFuchoKanendo=dgFuchoKanendo;
    }

    // </editor-fold>
}
