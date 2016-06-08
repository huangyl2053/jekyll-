package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.dgFuchoKanendo_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabSokujiKousei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabSokujiKouseiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujiKoseiTab1")
    private SokujiKoseiTab1Div SokujiKoseiTab1;
    @JsonProperty("SokujiKoseiTab2")
    private SokujiKoseiTab2Div SokujiKoseiTab2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKoseiTab1")
    public SokujiKoseiTab1Div getSokujiKoseiTab1() {
        return SokujiKoseiTab1;
    }

    @JsonProperty("SokujiKoseiTab1")
    public void setSokujiKoseiTab1(SokujiKoseiTab1Div SokujiKoseiTab1) {
        this.SokujiKoseiTab1=SokujiKoseiTab1;
    }

    @JsonProperty("SokujiKoseiTab2")
    public SokujiKoseiTab2Div getSokujiKoseiTab2() {
        return SokujiKoseiTab2;
    }

    @JsonProperty("SokujiKoseiTab2")
    public void setSokujiKoseiTab2(SokujiKoseiTab2Div SokujiKoseiTab2) {
        this.SokujiKoseiTab2=SokujiKoseiTab2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SokujikouseiFukakonkyoDiv getSokujikouseiFukakonkyo() {
        return this.getSokujiKoseiTab1().getSokujikouseiFukakonkyo();
    }

    @JsonIgnore
    public void  setSokujikouseiFukakonkyo(SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo) {
        this.getSokujiKoseiTab1().setSokujikouseiFukakonkyo(SokujikouseiFukakonkyo);
    }

    @JsonIgnore
    public SokujikouseiKiwarigakuDiv getSokujikouseiKiwarigaku() {
        return this.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();
    }

    @JsonIgnore
    public void  setSokujikouseiKiwarigaku(SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku) {
        this.getSokujiKoseiTab1().setSokujikouseiKiwarigaku(SokujikouseiKiwarigaku);
    }

    @JsonIgnore
    public DataGrid<dgFuchoKanendo_Row> getDgFuchoKanendo() {
        return this.getSokujiKoseiTab1().getDgFuchoKanendo();
    }

    @JsonIgnore
    public void  setDgFuchoKanendo(DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo) {
        this.getSokujiKoseiTab1().setDgFuchoKanendo(dgFuchoKanendo);
    }

    @JsonIgnore
    public SokujikouseiSanteinoKisoDiv getSokujikouseiSanteinoKiso() {
        return this.getSokujiKoseiTab2().getSokujikouseiSanteinoKiso();
    }

    @JsonIgnore
    public void  setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso) {
        this.getSokujiKoseiTab2().setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKiso);
    }

    @JsonIgnore
    public SokujikouseiJiyuDiv getSokujikouseiJiyu() {
        return this.getSokujiKoseiTab2().getSokujikouseiJiyu();
    }

    @JsonIgnore
    public void  setSokujikouseiJiyu(SokujikouseiJiyuDiv SokujikouseiJiyu) {
        this.getSokujiKoseiTab2().setSokujikouseiJiyu(SokujikouseiJiyu);
    }

    // </editor-fold>
}
