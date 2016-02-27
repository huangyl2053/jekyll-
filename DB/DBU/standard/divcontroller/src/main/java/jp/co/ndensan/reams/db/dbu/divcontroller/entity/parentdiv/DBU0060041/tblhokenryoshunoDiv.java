package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblhokenryoshuno のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblhokenryoshunoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellkubun")
    private cellkubunAttblhokenryoshuno cellkubun;
    @JsonProperty("cellchotei")
    private cellchoteiAttblhokenryoshuno cellchotei;
    @JsonProperty("cellshuno")
    private cellshunoAttblhokenryoshuno cellshuno;
    @JsonProperty("cellkampu")
    private cellkampuAttblhokenryoshuno cellkampu;
    @JsonProperty("cellfuno")
    private cellfunoAttblhokenryoshuno cellfuno;
    @JsonProperty("cellgemmengaku")
    private cellgemmengakuAttblhokenryoshuno cellgemmengaku;
    @JsonProperty("cellmino")
    private cellminoAttblhokenryoshuno cellmino;
    @JsonProperty("cellgennendo")
    private cellgennendoAttblhokenryoshuno cellgennendo;
    @JsonProperty("cellhokenryoshuno")
    private cellhokenryoshunoAttblhokenryoshuno cellhokenryoshuno;
    @JsonProperty("cellchotei1")
    private cellchotei1Attblhokenryoshuno cellchotei1;
    @JsonProperty("cellshuno1")
    private cellshuno1Attblhokenryoshuno cellshuno1;
    @JsonProperty("cellkampu1")
    private cellkampu1Attblhokenryoshuno cellkampu1;
    @JsonProperty("cellfuno1")
    private cellfuno1Attblhokenryoshuno cellfuno1;
    @JsonProperty("cellmino1")
    private cellmino1Attblhokenryoshuno cellmino1;
    @JsonProperty("cellgemmengaku1")
    private cellgemmengaku1Attblhokenryoshuno cellgemmengaku1;
    @JsonProperty("cellfutsuchoshu")
    private cellfutsuchoshuAttblhokenryoshuno cellfutsuchoshu;
    @JsonProperty("cellchotei2")
    private cellchotei2Attblhokenryoshuno cellchotei2;
    @JsonProperty("cellshuno2")
    private cellshuno2Attblhokenryoshuno cellshuno2;
    @JsonProperty("cellkampu2")
    private cellkampu2Attblhokenryoshuno cellkampu2;
    @JsonProperty("cellfuno2")
    private cellfuno2Attblhokenryoshuno cellfuno2;
    @JsonProperty("cellmino2")
    private cellmino2Attblhokenryoshuno cellmino2;
    @JsonProperty("cellgemmengaku2")
    private cellgemmengaku2Attblhokenryoshuno cellgemmengaku2;
    @JsonProperty("cellkei")
    private cellkeiAttblhokenryoshuno cellkei;
    @JsonProperty("cellchotei3")
    private cellchotei3Attblhokenryoshuno cellchotei3;
    @JsonProperty("cellshuno3")
    private cellshuno3Attblhokenryoshuno cellshuno3;
    @JsonProperty("cellkampu3")
    private cellkampu3Attblhokenryoshuno cellkampu3;
    @JsonProperty("cellfuno3")
    private cellfuno3Attblhokenryoshuno cellfuno3;
    @JsonProperty("cellmino3")
    private cellmino3Attblhokenryoshuno cellmino3;
    @JsonProperty("cellgemmengaku3")
    private cellgemmengaku3Attblhokenryoshuno cellgemmengaku3;
    @JsonProperty("celltaino")
    private celltainoAttblhokenryoshuno celltaino;
    @JsonProperty("celltatokubetsuchoshu")
    private celltatokubetsuchoshuAttblhokenryoshuno celltatokubetsuchoshu;
    @JsonProperty("cellchotei4")
    private cellchotei4Attblhokenryoshuno cellchotei4;
    @JsonProperty("cellshuno4")
    private cellshuno4Attblhokenryoshuno cellshuno4;
    @JsonProperty("cellkampu4")
    private cellkampu4Attblhokenryoshuno cellkampu4;
    @JsonProperty("cellfuno5")
    private cellfuno5Attblhokenryoshuno cellfuno5;
    @JsonProperty("cellmino4")
    private cellmino4Attblhokenryoshuno cellmino4;
    @JsonProperty("cellgemmengaku4")
    private cellgemmengaku4Attblhokenryoshuno cellgemmengaku4;
    @JsonProperty("cellgokei")
    private cellgokeiAttblhokenryoshuno cellgokei;
    @JsonProperty("celltokute")
    private celltokuteAttblhokenryoshuno celltokute;
    @JsonProperty("cellchotei5")
    private cellchotei5Attblhokenryoshuno cellchotei5;
    @JsonProperty("cellshuno5")
    private cellshuno5Attblhokenryoshuno cellshuno5;
    @JsonProperty("cellkampu5")
    private cellkampu5Attblhokenryoshuno cellkampu5;
    @JsonProperty("cellfuno6")
    private cellfuno6Attblhokenryoshuno cellfuno6;
    @JsonProperty("cellmino5")
    private cellmino5Attblhokenryoshuno cellmino5;
    @JsonProperty("cellgemmengaku5")
    private cellgemmengaku5Attblhokenryoshuno cellgemmengaku5;
    @JsonProperty("cellgokeifutsuchoshu")
    private cellgokeifutsuchoshuAttblhokenryoshuno cellgokeifutsuchoshu;
    @JsonProperty("cellchotei6")
    private cellchotei6Attblhokenryoshuno cellchotei6;
    @JsonProperty("cellshuno6")
    private cellshuno6Attblhokenryoshuno cellshuno6;
    @JsonProperty("cellkampu6")
    private cellkampu6Attblhokenryoshuno cellkampu6;
    @JsonProperty("cellfuno8")
    private cellfuno8Attblhokenryoshuno cellfuno8;
    @JsonProperty("cellmino6")
    private cellmino6Attblhokenryoshuno cellmino6;
    @JsonProperty("cellgemmengaku6")
    private cellgemmengaku6Attblhokenryoshuno cellgemmengaku6;
    @JsonProperty("cellgokeii")
    private cellgokeiiAttblhokenryoshuno cellgokeii;
    @JsonProperty("cellchotei7")
    private cellchotei7Attblhokenryoshuno cellchotei7;
    @JsonProperty("cellshuno7")
    private cellshuno7Attblhokenryoshuno cellshuno7;
    @JsonProperty("cellkampu8")
    private cellkampu8Attblhokenryoshuno cellkampu8;
    @JsonProperty("cellkampu7")
    private cellkampu7Attblhokenryoshuno cellkampu7;
    @JsonProperty("cellmino7")
    private cellmino7Attblhokenryoshuno cellmino7;
    @JsonProperty("cellgemmengaku7")
    private cellgemmengaku7Attblhokenryoshuno cellgemmengaku7;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblkubun() {
        return this.cellkubun.getLblkubun();
    }

    @JsonIgnore
    public Label getLblchotei() {
        return this.cellchotei.getLblchotei();
    }

    @JsonIgnore
    public Label getLblshuno() {
        return this.cellshuno.getLblshuno();
    }

    @JsonIgnore
    public Label getLblkampu() {
        return this.cellkampu.getLblkampu();
    }

    @JsonIgnore
    public Label getLblfuno() {
        return this.cellfuno.getLblfuno();
    }

    @JsonIgnore
    public Label getLblmino() {
        return this.cellgemmengaku.getLblmino();
    }

    @JsonIgnore
    public Label getLblgemmengaku() {
        return this.cellmino.getLblgemmengaku();
    }

    @JsonIgnore
    public Label getLblgennendo() {
        return this.cellgennendo.getLblgennendo();
    }

    @JsonIgnore
    public Label getLbltokubetsuchoshu() {
        return this.cellhokenryoshuno.getLbltokubetsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei1() {
        return this.cellchotei1.getTxtchotei1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno1() {
        return this.cellshuno1.getTxtShuno1();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu1() {
        return this.cellkampu1.getTxtKampu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku1() {
        return this.cellgemmengaku1.getTxtgemmengaku1();
    }

    @JsonIgnore
    public Label getLblfutsuchoshu() {
        return this.cellfutsuchoshu.getLblfutsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei2() {
        return this.cellchotei2.getTxtchotei2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno2() {
        return this.cellshuno2.getTxtShuno2();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu2() {
        return this.cellkampu2.getTxtKampu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno2() {
        return this.cellfuno2.getTxtfuno2();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino2() {
        return this.cellmino2.getTxtmino2();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku2() {
        return this.cellgemmengaku2.getTxtgemmengaku2();
    }

    @JsonIgnore
    public Label getLblkei() {
        return this.cellkei.getLblkei();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei3() {
        return this.cellchotei3.getTxtchotei3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno3() {
        return this.cellshuno3.getTxtShuno3();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu3() {
        return this.cellkampu3.getTxtKampu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno3() {
        return this.cellfuno3.getTxtfuno3();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino3() {
        return this.cellmino3.getTxtmino3();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku3() {
        return this.cellgemmengaku3.getTxtgemmengaku3();
    }

    @JsonIgnore
    public Label getLbltaino() {
        return this.celltaino.getLbltaino();
    }

    @JsonIgnore
    public Label getLbltatokubetsuchoshu() {
        return this.celltatokubetsuchoshu.getLbltatokubetsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei4() {
        return this.cellchotei4.getTxtchotei4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno4() {
        return this.cellshuno4.getTxtShuno4();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu4() {
        return this.cellkampu4.getTxtKampu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno4() {
        return this.cellfuno5.getTxtfuno4();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino4() {
        return this.cellmino4.getTxtmino4();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku4() {
        return this.cellgemmengaku4.getTxtgemmengaku4();
    }

    @JsonIgnore
    public Label getLblgokei() {
        return this.cellgokei.getLblgokei();
    }

    @JsonIgnore
    public Label getLbltokute() {
        return this.celltokute.getLbltokute();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei5() {
        return this.cellchotei5.getTxtchotei5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno5() {
        return this.cellshuno5.getTxtShuno5();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu5() {
        return this.cellkampu5.getTxtKampu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku5() {
        return this.cellgemmengaku5.getTxtgemmengaku5();
    }

    @JsonIgnore
    public Label getLblgokeifutsuchoshu() {
        return this.cellgokeifutsuchoshu.getLblgokeifutsuchoshu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei6() {
        return this.cellchotei6.getTxtchotei6();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno6() {
        return this.cellshuno6.getTxtShuno6();
    }

    @JsonIgnore
    public TextBoxNum getTxtxtKampu6() {
        return this.cellkampu6.getTxtxtKampu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno5() {
        return this.cellfuno8.getTxtfuno5();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino6() {
        return this.cellmino6.getTxtmino6();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku6() {
        return this.cellgemmengaku6.getTxtgemmengaku6();
    }

    @JsonIgnore
    public Label getLblgokeii() {
        return this.cellgokeii.getLblgokeii();
    }

    @JsonIgnore
    public TextBoxNum getTxtchotei7() {
        return this.cellchotei7.getTxtchotei7();
    }

    @JsonIgnore
    public TextBoxNum getTxtShuno7() {
        return this.cellshuno7.getTxtShuno7();
    }

    @JsonIgnore
    public TextBoxNum getTxtKampu7() {
        return this.cellkampu8.getTxtKampu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuno6() {
        return this.cellkampu7.getTxtfuno6();
    }

    @JsonIgnore
    public TextBoxNum getTxtmino7() {
        return this.cellmino7.getTxtmino7();
    }

    @JsonIgnore
    public TextBoxNum getTxtgemmengaku7() {
        return this.cellgemmengaku7.getTxtgemmengaku7();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcellkubun
     * @return cellkubun
     */
    @JsonProperty("cellkubun")
    private cellkubunAttblhokenryoshuno getCellkubun() {
        return cellkubun;
    }

    /*
     * setcellkubun
     * @param cellkubun cellkubun
     */
    @JsonProperty("cellkubun")
    private void setCellkubun(cellkubunAttblhokenryoshuno cellkubun) {
        this.cellkubun = cellkubun;
    }

    /*
     * getcellchotei
     * @return cellchotei
     */
    @JsonProperty("cellchotei")
    private cellchoteiAttblhokenryoshuno getCellchotei() {
        return cellchotei;
    }

    /*
     * setcellchotei
     * @param cellchotei cellchotei
     */
    @JsonProperty("cellchotei")
    private void setCellchotei(cellchoteiAttblhokenryoshuno cellchotei) {
        this.cellchotei = cellchotei;
    }

    /*
     * getcellshuno
     * @return cellshuno
     */
    @JsonProperty("cellshuno")
    private cellshunoAttblhokenryoshuno getCellshuno() {
        return cellshuno;
    }

    /*
     * setcellshuno
     * @param cellshuno cellshuno
     */
    @JsonProperty("cellshuno")
    private void setCellshuno(cellshunoAttblhokenryoshuno cellshuno) {
        this.cellshuno = cellshuno;
    }

    /*
     * getcellkampu
     * @return cellkampu
     */
    @JsonProperty("cellkampu")
    private cellkampuAttblhokenryoshuno getCellkampu() {
        return cellkampu;
    }

    /*
     * setcellkampu
     * @param cellkampu cellkampu
     */
    @JsonProperty("cellkampu")
    private void setCellkampu(cellkampuAttblhokenryoshuno cellkampu) {
        this.cellkampu = cellkampu;
    }

    /*
     * getcellfuno
     * @return cellfuno
     */
    @JsonProperty("cellfuno")
    private cellfunoAttblhokenryoshuno getCellfuno() {
        return cellfuno;
    }

    /*
     * setcellfuno
     * @param cellfuno cellfuno
     */
    @JsonProperty("cellfuno")
    private void setCellfuno(cellfunoAttblhokenryoshuno cellfuno) {
        this.cellfuno = cellfuno;
    }

    /*
     * getcellgemmengaku
     * @return cellgemmengaku
     */
    @JsonProperty("cellgemmengaku")
    private cellgemmengakuAttblhokenryoshuno getCellgemmengaku() {
        return cellgemmengaku;
    }

    /*
     * setcellgemmengaku
     * @param cellgemmengaku cellgemmengaku
     */
    @JsonProperty("cellgemmengaku")
    private void setCellgemmengaku(cellgemmengakuAttblhokenryoshuno cellgemmengaku) {
        this.cellgemmengaku = cellgemmengaku;
    }

    /*
     * getcellmino
     * @return cellmino
     */
    @JsonProperty("cellmino")
    private cellminoAttblhokenryoshuno getCellmino() {
        return cellmino;
    }

    /*
     * setcellmino
     * @param cellmino cellmino
     */
    @JsonProperty("cellmino")
    private void setCellmino(cellminoAttblhokenryoshuno cellmino) {
        this.cellmino = cellmino;
    }

    /*
     * getcellgennendo
     * @return cellgennendo
     */
    @JsonProperty("cellgennendo")
    private cellgennendoAttblhokenryoshuno getCellgennendo() {
        return cellgennendo;
    }

    /*
     * setcellgennendo
     * @param cellgennendo cellgennendo
     */
    @JsonProperty("cellgennendo")
    private void setCellgennendo(cellgennendoAttblhokenryoshuno cellgennendo) {
        this.cellgennendo = cellgennendo;
    }

    /*
     * getcellhokenryoshuno
     * @return cellhokenryoshuno
     */
    @JsonProperty("cellhokenryoshuno")
    private cellhokenryoshunoAttblhokenryoshuno getCellhokenryoshuno() {
        return cellhokenryoshuno;
    }

    /*
     * setcellhokenryoshuno
     * @param cellhokenryoshuno cellhokenryoshuno
     */
    @JsonProperty("cellhokenryoshuno")
    private void setCellhokenryoshuno(cellhokenryoshunoAttblhokenryoshuno cellhokenryoshuno) {
        this.cellhokenryoshuno = cellhokenryoshuno;
    }

    /*
     * getcellchotei1
     * @return cellchotei1
     */
    @JsonProperty("cellchotei1")
    private cellchotei1Attblhokenryoshuno getCellchotei1() {
        return cellchotei1;
    }

    /*
     * setcellchotei1
     * @param cellchotei1 cellchotei1
     */
    @JsonProperty("cellchotei1")
    private void setCellchotei1(cellchotei1Attblhokenryoshuno cellchotei1) {
        this.cellchotei1 = cellchotei1;
    }

    /*
     * getcellshuno1
     * @return cellshuno1
     */
    @JsonProperty("cellshuno1")
    private cellshuno1Attblhokenryoshuno getCellshuno1() {
        return cellshuno1;
    }

    /*
     * setcellshuno1
     * @param cellshuno1 cellshuno1
     */
    @JsonProperty("cellshuno1")
    private void setCellshuno1(cellshuno1Attblhokenryoshuno cellshuno1) {
        this.cellshuno1 = cellshuno1;
    }

    /*
     * getcellkampu1
     * @return cellkampu1
     */
    @JsonProperty("cellkampu1")
    private cellkampu1Attblhokenryoshuno getCellkampu1() {
        return cellkampu1;
    }

    /*
     * setcellkampu1
     * @param cellkampu1 cellkampu1
     */
    @JsonProperty("cellkampu1")
    private void setCellkampu1(cellkampu1Attblhokenryoshuno cellkampu1) {
        this.cellkampu1 = cellkampu1;
    }

    /*
     * getcellfuno1
     * @return cellfuno1
     */
    @JsonProperty("cellfuno1")
    private cellfuno1Attblhokenryoshuno getCellfuno1() {
        return cellfuno1;
    }

    /*
     * setcellfuno1
     * @param cellfuno1 cellfuno1
     */
    @JsonProperty("cellfuno1")
    private void setCellfuno1(cellfuno1Attblhokenryoshuno cellfuno1) {
        this.cellfuno1 = cellfuno1;
    }

    /*
     * getcellmino1
     * @return cellmino1
     */
    @JsonProperty("cellmino1")
    private cellmino1Attblhokenryoshuno getCellmino1() {
        return cellmino1;
    }

    /*
     * setcellmino1
     * @param cellmino1 cellmino1
     */
    @JsonProperty("cellmino1")
    private void setCellmino1(cellmino1Attblhokenryoshuno cellmino1) {
        this.cellmino1 = cellmino1;
    }

    /*
     * getcellgemmengaku1
     * @return cellgemmengaku1
     */
    @JsonProperty("cellgemmengaku1")
    private cellgemmengaku1Attblhokenryoshuno getCellgemmengaku1() {
        return cellgemmengaku1;
    }

    /*
     * setcellgemmengaku1
     * @param cellgemmengaku1 cellgemmengaku1
     */
    @JsonProperty("cellgemmengaku1")
    private void setCellgemmengaku1(cellgemmengaku1Attblhokenryoshuno cellgemmengaku1) {
        this.cellgemmengaku1 = cellgemmengaku1;
    }

    /*
     * getcellfutsuchoshu
     * @return cellfutsuchoshu
     */
    @JsonProperty("cellfutsuchoshu")
    private cellfutsuchoshuAttblhokenryoshuno getCellfutsuchoshu() {
        return cellfutsuchoshu;
    }

    /*
     * setcellfutsuchoshu
     * @param cellfutsuchoshu cellfutsuchoshu
     */
    @JsonProperty("cellfutsuchoshu")
    private void setCellfutsuchoshu(cellfutsuchoshuAttblhokenryoshuno cellfutsuchoshu) {
        this.cellfutsuchoshu = cellfutsuchoshu;
    }

    /*
     * getcellchotei2
     * @return cellchotei2
     */
    @JsonProperty("cellchotei2")
    private cellchotei2Attblhokenryoshuno getCellchotei2() {
        return cellchotei2;
    }

    /*
     * setcellchotei2
     * @param cellchotei2 cellchotei2
     */
    @JsonProperty("cellchotei2")
    private void setCellchotei2(cellchotei2Attblhokenryoshuno cellchotei2) {
        this.cellchotei2 = cellchotei2;
    }

    /*
     * getcellshuno2
     * @return cellshuno2
     */
    @JsonProperty("cellshuno2")
    private cellshuno2Attblhokenryoshuno getCellshuno2() {
        return cellshuno2;
    }

    /*
     * setcellshuno2
     * @param cellshuno2 cellshuno2
     */
    @JsonProperty("cellshuno2")
    private void setCellshuno2(cellshuno2Attblhokenryoshuno cellshuno2) {
        this.cellshuno2 = cellshuno2;
    }

    /*
     * getcellkampu2
     * @return cellkampu2
     */
    @JsonProperty("cellkampu2")
    private cellkampu2Attblhokenryoshuno getCellkampu2() {
        return cellkampu2;
    }

    /*
     * setcellkampu2
     * @param cellkampu2 cellkampu2
     */
    @JsonProperty("cellkampu2")
    private void setCellkampu2(cellkampu2Attblhokenryoshuno cellkampu2) {
        this.cellkampu2 = cellkampu2;
    }

    /*
     * getcellfuno2
     * @return cellfuno2
     */
    @JsonProperty("cellfuno2")
    private cellfuno2Attblhokenryoshuno getCellfuno2() {
        return cellfuno2;
    }

    /*
     * setcellfuno2
     * @param cellfuno2 cellfuno2
     */
    @JsonProperty("cellfuno2")
    private void setCellfuno2(cellfuno2Attblhokenryoshuno cellfuno2) {
        this.cellfuno2 = cellfuno2;
    }

    /*
     * getcellmino2
     * @return cellmino2
     */
    @JsonProperty("cellmino2")
    private cellmino2Attblhokenryoshuno getCellmino2() {
        return cellmino2;
    }

    /*
     * setcellmino2
     * @param cellmino2 cellmino2
     */
    @JsonProperty("cellmino2")
    private void setCellmino2(cellmino2Attblhokenryoshuno cellmino2) {
        this.cellmino2 = cellmino2;
    }

    /*
     * getcellgemmengaku2
     * @return cellgemmengaku2
     */
    @JsonProperty("cellgemmengaku2")
    private cellgemmengaku2Attblhokenryoshuno getCellgemmengaku2() {
        return cellgemmengaku2;
    }

    /*
     * setcellgemmengaku2
     * @param cellgemmengaku2 cellgemmengaku2
     */
    @JsonProperty("cellgemmengaku2")
    private void setCellgemmengaku2(cellgemmengaku2Attblhokenryoshuno cellgemmengaku2) {
        this.cellgemmengaku2 = cellgemmengaku2;
    }

    /*
     * getcellkei
     * @return cellkei
     */
    @JsonProperty("cellkei")
    private cellkeiAttblhokenryoshuno getCellkei() {
        return cellkei;
    }

    /*
     * setcellkei
     * @param cellkei cellkei
     */
    @JsonProperty("cellkei")
    private void setCellkei(cellkeiAttblhokenryoshuno cellkei) {
        this.cellkei = cellkei;
    }

    /*
     * getcellchotei3
     * @return cellchotei3
     */
    @JsonProperty("cellchotei3")
    private cellchotei3Attblhokenryoshuno getCellchotei3() {
        return cellchotei3;
    }

    /*
     * setcellchotei3
     * @param cellchotei3 cellchotei3
     */
    @JsonProperty("cellchotei3")
    private void setCellchotei3(cellchotei3Attblhokenryoshuno cellchotei3) {
        this.cellchotei3 = cellchotei3;
    }

    /*
     * getcellshuno3
     * @return cellshuno3
     */
    @JsonProperty("cellshuno3")
    private cellshuno3Attblhokenryoshuno getCellshuno3() {
        return cellshuno3;
    }

    /*
     * setcellshuno3
     * @param cellshuno3 cellshuno3
     */
    @JsonProperty("cellshuno3")
    private void setCellshuno3(cellshuno3Attblhokenryoshuno cellshuno3) {
        this.cellshuno3 = cellshuno3;
    }

    /*
     * getcellkampu3
     * @return cellkampu3
     */
    @JsonProperty("cellkampu3")
    private cellkampu3Attblhokenryoshuno getCellkampu3() {
        return cellkampu3;
    }

    /*
     * setcellkampu3
     * @param cellkampu3 cellkampu3
     */
    @JsonProperty("cellkampu3")
    private void setCellkampu3(cellkampu3Attblhokenryoshuno cellkampu3) {
        this.cellkampu3 = cellkampu3;
    }

    /*
     * getcellfuno3
     * @return cellfuno3
     */
    @JsonProperty("cellfuno3")
    private cellfuno3Attblhokenryoshuno getCellfuno3() {
        return cellfuno3;
    }

    /*
     * setcellfuno3
     * @param cellfuno3 cellfuno3
     */
    @JsonProperty("cellfuno3")
    private void setCellfuno3(cellfuno3Attblhokenryoshuno cellfuno3) {
        this.cellfuno3 = cellfuno3;
    }

    /*
     * getcellmino3
     * @return cellmino3
     */
    @JsonProperty("cellmino3")
    private cellmino3Attblhokenryoshuno getCellmino3() {
        return cellmino3;
    }

    /*
     * setcellmino3
     * @param cellmino3 cellmino3
     */
    @JsonProperty("cellmino3")
    private void setCellmino3(cellmino3Attblhokenryoshuno cellmino3) {
        this.cellmino3 = cellmino3;
    }

    /*
     * getcellgemmengaku3
     * @return cellgemmengaku3
     */
    @JsonProperty("cellgemmengaku3")
    private cellgemmengaku3Attblhokenryoshuno getCellgemmengaku3() {
        return cellgemmengaku3;
    }

    /*
     * setcellgemmengaku3
     * @param cellgemmengaku3 cellgemmengaku3
     */
    @JsonProperty("cellgemmengaku3")
    private void setCellgemmengaku3(cellgemmengaku3Attblhokenryoshuno cellgemmengaku3) {
        this.cellgemmengaku3 = cellgemmengaku3;
    }

    /*
     * getcelltaino
     * @return celltaino
     */
    @JsonProperty("celltaino")
    private celltainoAttblhokenryoshuno getCelltaino() {
        return celltaino;
    }

    /*
     * setcelltaino
     * @param celltaino celltaino
     */
    @JsonProperty("celltaino")
    private void setCelltaino(celltainoAttblhokenryoshuno celltaino) {
        this.celltaino = celltaino;
    }

    /*
     * getcelltatokubetsuchoshu
     * @return celltatokubetsuchoshu
     */
    @JsonProperty("celltatokubetsuchoshu")
    private celltatokubetsuchoshuAttblhokenryoshuno getCelltatokubetsuchoshu() {
        return celltatokubetsuchoshu;
    }

    /*
     * setcelltatokubetsuchoshu
     * @param celltatokubetsuchoshu celltatokubetsuchoshu
     */
    @JsonProperty("celltatokubetsuchoshu")
    private void setCelltatokubetsuchoshu(celltatokubetsuchoshuAttblhokenryoshuno celltatokubetsuchoshu) {
        this.celltatokubetsuchoshu = celltatokubetsuchoshu;
    }

    /*
     * getcellchotei4
     * @return cellchotei4
     */
    @JsonProperty("cellchotei4")
    private cellchotei4Attblhokenryoshuno getCellchotei4() {
        return cellchotei4;
    }

    /*
     * setcellchotei4
     * @param cellchotei4 cellchotei4
     */
    @JsonProperty("cellchotei4")
    private void setCellchotei4(cellchotei4Attblhokenryoshuno cellchotei4) {
        this.cellchotei4 = cellchotei4;
    }

    /*
     * getcellshuno4
     * @return cellshuno4
     */
    @JsonProperty("cellshuno4")
    private cellshuno4Attblhokenryoshuno getCellshuno4() {
        return cellshuno4;
    }

    /*
     * setcellshuno4
     * @param cellshuno4 cellshuno4
     */
    @JsonProperty("cellshuno4")
    private void setCellshuno4(cellshuno4Attblhokenryoshuno cellshuno4) {
        this.cellshuno4 = cellshuno4;
    }

    /*
     * getcellkampu4
     * @return cellkampu4
     */
    @JsonProperty("cellkampu4")
    private cellkampu4Attblhokenryoshuno getCellkampu4() {
        return cellkampu4;
    }

    /*
     * setcellkampu4
     * @param cellkampu4 cellkampu4
     */
    @JsonProperty("cellkampu4")
    private void setCellkampu4(cellkampu4Attblhokenryoshuno cellkampu4) {
        this.cellkampu4 = cellkampu4;
    }

    /*
     * getcellfuno5
     * @return cellfuno5
     */
    @JsonProperty("cellfuno5")
    private cellfuno5Attblhokenryoshuno getCellfuno5() {
        return cellfuno5;
    }

    /*
     * setcellfuno5
     * @param cellfuno5 cellfuno5
     */
    @JsonProperty("cellfuno5")
    private void setCellfuno5(cellfuno5Attblhokenryoshuno cellfuno5) {
        this.cellfuno5 = cellfuno5;
    }

    /*
     * getcellmino4
     * @return cellmino4
     */
    @JsonProperty("cellmino4")
    private cellmino4Attblhokenryoshuno getCellmino4() {
        return cellmino4;
    }

    /*
     * setcellmino4
     * @param cellmino4 cellmino4
     */
    @JsonProperty("cellmino4")
    private void setCellmino4(cellmino4Attblhokenryoshuno cellmino4) {
        this.cellmino4 = cellmino4;
    }

    /*
     * getcellgemmengaku4
     * @return cellgemmengaku4
     */
    @JsonProperty("cellgemmengaku4")
    private cellgemmengaku4Attblhokenryoshuno getCellgemmengaku4() {
        return cellgemmengaku4;
    }

    /*
     * setcellgemmengaku4
     * @param cellgemmengaku4 cellgemmengaku4
     */
    @JsonProperty("cellgemmengaku4")
    private void setCellgemmengaku4(cellgemmengaku4Attblhokenryoshuno cellgemmengaku4) {
        this.cellgemmengaku4 = cellgemmengaku4;
    }

    /*
     * getcellgokei
     * @return cellgokei
     */
    @JsonProperty("cellgokei")
    private cellgokeiAttblhokenryoshuno getCellgokei() {
        return cellgokei;
    }

    /*
     * setcellgokei
     * @param cellgokei cellgokei
     */
    @JsonProperty("cellgokei")
    private void setCellgokei(cellgokeiAttblhokenryoshuno cellgokei) {
        this.cellgokei = cellgokei;
    }

    /*
     * getcelltokute
     * @return celltokute
     */
    @JsonProperty("celltokute")
    private celltokuteAttblhokenryoshuno getCelltokute() {
        return celltokute;
    }

    /*
     * setcelltokute
     * @param celltokute celltokute
     */
    @JsonProperty("celltokute")
    private void setCelltokute(celltokuteAttblhokenryoshuno celltokute) {
        this.celltokute = celltokute;
    }

    /*
     * getcellchotei5
     * @return cellchotei5
     */
    @JsonProperty("cellchotei5")
    private cellchotei5Attblhokenryoshuno getCellchotei5() {
        return cellchotei5;
    }

    /*
     * setcellchotei5
     * @param cellchotei5 cellchotei5
     */
    @JsonProperty("cellchotei5")
    private void setCellchotei5(cellchotei5Attblhokenryoshuno cellchotei5) {
        this.cellchotei5 = cellchotei5;
    }

    /*
     * getcellshuno5
     * @return cellshuno5
     */
    @JsonProperty("cellshuno5")
    private cellshuno5Attblhokenryoshuno getCellshuno5() {
        return cellshuno5;
    }

    /*
     * setcellshuno5
     * @param cellshuno5 cellshuno5
     */
    @JsonProperty("cellshuno5")
    private void setCellshuno5(cellshuno5Attblhokenryoshuno cellshuno5) {
        this.cellshuno5 = cellshuno5;
    }

    /*
     * getcellkampu5
     * @return cellkampu5
     */
    @JsonProperty("cellkampu5")
    private cellkampu5Attblhokenryoshuno getCellkampu5() {
        return cellkampu5;
    }

    /*
     * setcellkampu5
     * @param cellkampu5 cellkampu5
     */
    @JsonProperty("cellkampu5")
    private void setCellkampu5(cellkampu5Attblhokenryoshuno cellkampu5) {
        this.cellkampu5 = cellkampu5;
    }

    /*
     * getcellfuno6
     * @return cellfuno6
     */
    @JsonProperty("cellfuno6")
    private cellfuno6Attblhokenryoshuno getCellfuno6() {
        return cellfuno6;
    }

    /*
     * setcellfuno6
     * @param cellfuno6 cellfuno6
     */
    @JsonProperty("cellfuno6")
    private void setCellfuno6(cellfuno6Attblhokenryoshuno cellfuno6) {
        this.cellfuno6 = cellfuno6;
    }

    /*
     * getcellmino5
     * @return cellmino5
     */
    @JsonProperty("cellmino5")
    private cellmino5Attblhokenryoshuno getCellmino5() {
        return cellmino5;
    }

    /*
     * setcellmino5
     * @param cellmino5 cellmino5
     */
    @JsonProperty("cellmino5")
    private void setCellmino5(cellmino5Attblhokenryoshuno cellmino5) {
        this.cellmino5 = cellmino5;
    }

    /*
     * getcellgemmengaku5
     * @return cellgemmengaku5
     */
    @JsonProperty("cellgemmengaku5")
    private cellgemmengaku5Attblhokenryoshuno getCellgemmengaku5() {
        return cellgemmengaku5;
    }

    /*
     * setcellgemmengaku5
     * @param cellgemmengaku5 cellgemmengaku5
     */
    @JsonProperty("cellgemmengaku5")
    private void setCellgemmengaku5(cellgemmengaku5Attblhokenryoshuno cellgemmengaku5) {
        this.cellgemmengaku5 = cellgemmengaku5;
    }

    /*
     * getcellgokeifutsuchoshu
     * @return cellgokeifutsuchoshu
     */
    @JsonProperty("cellgokeifutsuchoshu")
    private cellgokeifutsuchoshuAttblhokenryoshuno getCellgokeifutsuchoshu() {
        return cellgokeifutsuchoshu;
    }

    /*
     * setcellgokeifutsuchoshu
     * @param cellgokeifutsuchoshu cellgokeifutsuchoshu
     */
    @JsonProperty("cellgokeifutsuchoshu")
    private void setCellgokeifutsuchoshu(cellgokeifutsuchoshuAttblhokenryoshuno cellgokeifutsuchoshu) {
        this.cellgokeifutsuchoshu = cellgokeifutsuchoshu;
    }

    /*
     * getcellchotei6
     * @return cellchotei6
     */
    @JsonProperty("cellchotei6")
    private cellchotei6Attblhokenryoshuno getCellchotei6() {
        return cellchotei6;
    }

    /*
     * setcellchotei6
     * @param cellchotei6 cellchotei6
     */
    @JsonProperty("cellchotei6")
    private void setCellchotei6(cellchotei6Attblhokenryoshuno cellchotei6) {
        this.cellchotei6 = cellchotei6;
    }

    /*
     * getcellshuno6
     * @return cellshuno6
     */
    @JsonProperty("cellshuno6")
    private cellshuno6Attblhokenryoshuno getCellshuno6() {
        return cellshuno6;
    }

    /*
     * setcellshuno6
     * @param cellshuno6 cellshuno6
     */
    @JsonProperty("cellshuno6")
    private void setCellshuno6(cellshuno6Attblhokenryoshuno cellshuno6) {
        this.cellshuno6 = cellshuno6;
    }

    /*
     * getcellkampu6
     * @return cellkampu6
     */
    @JsonProperty("cellkampu6")
    private cellkampu6Attblhokenryoshuno getCellkampu6() {
        return cellkampu6;
    }

    /*
     * setcellkampu6
     * @param cellkampu6 cellkampu6
     */
    @JsonProperty("cellkampu6")
    private void setCellkampu6(cellkampu6Attblhokenryoshuno cellkampu6) {
        this.cellkampu6 = cellkampu6;
    }

    /*
     * getcellfuno8
     * @return cellfuno8
     */
    @JsonProperty("cellfuno8")
    private cellfuno8Attblhokenryoshuno getCellfuno8() {
        return cellfuno8;
    }

    /*
     * setcellfuno8
     * @param cellfuno8 cellfuno8
     */
    @JsonProperty("cellfuno8")
    private void setCellfuno8(cellfuno8Attblhokenryoshuno cellfuno8) {
        this.cellfuno8 = cellfuno8;
    }

    /*
     * getcellmino6
     * @return cellmino6
     */
    @JsonProperty("cellmino6")
    private cellmino6Attblhokenryoshuno getCellmino6() {
        return cellmino6;
    }

    /*
     * setcellmino6
     * @param cellmino6 cellmino6
     */
    @JsonProperty("cellmino6")
    private void setCellmino6(cellmino6Attblhokenryoshuno cellmino6) {
        this.cellmino6 = cellmino6;
    }

    /*
     * getcellgemmengaku6
     * @return cellgemmengaku6
     */
    @JsonProperty("cellgemmengaku6")
    private cellgemmengaku6Attblhokenryoshuno getCellgemmengaku6() {
        return cellgemmengaku6;
    }

    /*
     * setcellgemmengaku6
     * @param cellgemmengaku6 cellgemmengaku6
     */
    @JsonProperty("cellgemmengaku6")
    private void setCellgemmengaku6(cellgemmengaku6Attblhokenryoshuno cellgemmengaku6) {
        this.cellgemmengaku6 = cellgemmengaku6;
    }

    /*
     * getcellgokeii
     * @return cellgokeii
     */
    @JsonProperty("cellgokeii")
    private cellgokeiiAttblhokenryoshuno getCellgokeii() {
        return cellgokeii;
    }

    /*
     * setcellgokeii
     * @param cellgokeii cellgokeii
     */
    @JsonProperty("cellgokeii")
    private void setCellgokeii(cellgokeiiAttblhokenryoshuno cellgokeii) {
        this.cellgokeii = cellgokeii;
    }

    /*
     * getcellchotei7
     * @return cellchotei7
     */
    @JsonProperty("cellchotei7")
    private cellchotei7Attblhokenryoshuno getCellchotei7() {
        return cellchotei7;
    }

    /*
     * setcellchotei7
     * @param cellchotei7 cellchotei7
     */
    @JsonProperty("cellchotei7")
    private void setCellchotei7(cellchotei7Attblhokenryoshuno cellchotei7) {
        this.cellchotei7 = cellchotei7;
    }

    /*
     * getcellshuno7
     * @return cellshuno7
     */
    @JsonProperty("cellshuno7")
    private cellshuno7Attblhokenryoshuno getCellshuno7() {
        return cellshuno7;
    }

    /*
     * setcellshuno7
     * @param cellshuno7 cellshuno7
     */
    @JsonProperty("cellshuno7")
    private void setCellshuno7(cellshuno7Attblhokenryoshuno cellshuno7) {
        this.cellshuno7 = cellshuno7;
    }

    /*
     * getcellkampu8
     * @return cellkampu8
     */
    @JsonProperty("cellkampu8")
    private cellkampu8Attblhokenryoshuno getCellkampu8() {
        return cellkampu8;
    }

    /*
     * setcellkampu8
     * @param cellkampu8 cellkampu8
     */
    @JsonProperty("cellkampu8")
    private void setCellkampu8(cellkampu8Attblhokenryoshuno cellkampu8) {
        this.cellkampu8 = cellkampu8;
    }

    /*
     * getcellkampu7
     * @return cellkampu7
     */
    @JsonProperty("cellkampu7")
    private cellkampu7Attblhokenryoshuno getCellkampu7() {
        return cellkampu7;
    }

    /*
     * setcellkampu7
     * @param cellkampu7 cellkampu7
     */
    @JsonProperty("cellkampu7")
    private void setCellkampu7(cellkampu7Attblhokenryoshuno cellkampu7) {
        this.cellkampu7 = cellkampu7;
    }

    /*
     * getcellmino7
     * @return cellmino7
     */
    @JsonProperty("cellmino7")
    private cellmino7Attblhokenryoshuno getCellmino7() {
        return cellmino7;
    }

    /*
     * setcellmino7
     * @param cellmino7 cellmino7
     */
    @JsonProperty("cellmino7")
    private void setCellmino7(cellmino7Attblhokenryoshuno cellmino7) {
        this.cellmino7 = cellmino7;
    }

    /*
     * getcellgemmengaku7
     * @return cellgemmengaku7
     */
    @JsonProperty("cellgemmengaku7")
    private cellgemmengaku7Attblhokenryoshuno getCellgemmengaku7() {
        return cellgemmengaku7;
    }

    /*
     * setcellgemmengaku7
     * @param cellgemmengaku7 cellgemmengaku7
     */
    @JsonProperty("cellgemmengaku7")
    private void setCellgemmengaku7(cellgemmengaku7Attblhokenryoshuno cellgemmengaku7) {
        this.cellgemmengaku7 = cellgemmengaku7;
    }

    // </editor-fold>
}
/**
 * cellkubun のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkubunAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkubun")
    private Label lblkubun;

    /*
     * getlblkubun
     * @return lblkubun
     */
    @JsonProperty("lblkubun")
    public Label getLblkubun() {
        return lblkubun;
    }

    /*
     * setlblkubun
     * @param lblkubun lblkubun
     */
    @JsonProperty("lblkubun")
    public void setLblkubun(Label lblkubun) {
        this.lblkubun = lblkubun;
    }

    // </editor-fold>
}
/**
 * cellchotei のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchoteiAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblchotei")
    private Label lblchotei;

    /*
     * getlblchotei
     * @return lblchotei
     */
    @JsonProperty("lblchotei")
    public Label getLblchotei() {
        return lblchotei;
    }

    /*
     * setlblchotei
     * @param lblchotei lblchotei
     */
    @JsonProperty("lblchotei")
    public void setLblchotei(Label lblchotei) {
        this.lblchotei = lblchotei;
    }

    // </editor-fold>
}
/**
 * cellshuno のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshunoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblshuno")
    private Label lblshuno;

    /*
     * getlblshuno
     * @return lblshuno
     */
    @JsonProperty("lblshuno")
    public Label getLblshuno() {
        return lblshuno;
    }

    /*
     * setlblshuno
     * @param lblshuno lblshuno
     */
    @JsonProperty("lblshuno")
    public void setLblshuno(Label lblshuno) {
        this.lblshuno = lblshuno;
    }

    // </editor-fold>
}
/**
 * cellkampu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampuAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkampu")
    private Label lblkampu;

    /*
     * getlblkampu
     * @return lblkampu
     */
    @JsonProperty("lblkampu")
    public Label getLblkampu() {
        return lblkampu;
    }

    /*
     * setlblkampu
     * @param lblkampu lblkampu
     */
    @JsonProperty("lblkampu")
    public void setLblkampu(Label lblkampu) {
        this.lblkampu = lblkampu;
    }

    // </editor-fold>
}
/**
 * cellfuno のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfunoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblfuno")
    private Label lblfuno;

    /*
     * getlblfuno
     * @return lblfuno
     */
    @JsonProperty("lblfuno")
    public Label getLblfuno() {
        return lblfuno;
    }

    /*
     * setlblfuno
     * @param lblfuno lblfuno
     */
    @JsonProperty("lblfuno")
    public void setLblfuno(Label lblfuno) {
        this.lblfuno = lblfuno;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengakuAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblmino")
    private Label lblmino;

    /*
     * getlblmino
     * @return lblmino
     */
    @JsonProperty("lblmino")
    public Label getLblmino() {
        return lblmino;
    }

    /*
     * setlblmino
     * @param lblmino lblmino
     */
    @JsonProperty("lblmino")
    public void setLblmino(Label lblmino) {
        this.lblmino = lblmino;
    }

    // </editor-fold>
}
/**
 * cellmino のクラスファイル 
 * 
 * @author 自動生成
 */
class cellminoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgemmengaku")
    private Label lblgemmengaku;

    /*
     * getlblgemmengaku
     * @return lblgemmengaku
     */
    @JsonProperty("lblgemmengaku")
    public Label getLblgemmengaku() {
        return lblgemmengaku;
    }

    /*
     * setlblgemmengaku
     * @param lblgemmengaku lblgemmengaku
     */
    @JsonProperty("lblgemmengaku")
    public void setLblgemmengaku(Label lblgemmengaku) {
        this.lblgemmengaku = lblgemmengaku;
    }

    // </editor-fold>
}
/**
 * cellgennendo のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgennendoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgennendo")
    private Label lblgennendo;

    /*
     * getlblgennendo
     * @return lblgennendo
     */
    @JsonProperty("lblgennendo")
    public Label getLblgennendo() {
        return lblgennendo;
    }

    /*
     * setlblgennendo
     * @param lblgennendo lblgennendo
     */
    @JsonProperty("lblgennendo")
    public void setLblgennendo(Label lblgennendo) {
        this.lblgennendo = lblgennendo;
    }

    // </editor-fold>
}
/**
 * cellhokenryoshuno のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenryoshunoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltokubetsuchoshu")
    private Label lbltokubetsuchoshu;

    /*
     * getlbltokubetsuchoshu
     * @return lbltokubetsuchoshu
     */
    @JsonProperty("lbltokubetsuchoshu")
    public Label getLbltokubetsuchoshu() {
        return lbltokubetsuchoshu;
    }

    /*
     * setlbltokubetsuchoshu
     * @param lbltokubetsuchoshu lbltokubetsuchoshu
     */
    @JsonProperty("lbltokubetsuchoshu")
    public void setLbltokubetsuchoshu(Label lbltokubetsuchoshu) {
        this.lbltokubetsuchoshu = lbltokubetsuchoshu;
    }

    // </editor-fold>
}
/**
 * cellchotei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei1")
    private TextBoxNum txtchotei1;

    /*
     * gettxtchotei1
     * @return txtchotei1
     */
    @JsonProperty("txtchotei1")
    public TextBoxNum getTxtchotei1() {
        return txtchotei1;
    }

    /*
     * settxtchotei1
     * @param txtchotei1 txtchotei1
     */
    @JsonProperty("txtchotei1")
    public void setTxtchotei1(TextBoxNum txtchotei1) {
        this.txtchotei1 = txtchotei1;
    }

    // </editor-fold>
}
/**
 * cellshuno1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno1")
    private TextBoxNum txtShuno1;

    /*
     * gettxtShuno1
     * @return txtShuno1
     */
    @JsonProperty("txtShuno1")
    public TextBoxNum getTxtShuno1() {
        return txtShuno1;
    }

    /*
     * settxtShuno1
     * @param txtShuno1 txtShuno1
     */
    @JsonProperty("txtShuno1")
    public void setTxtShuno1(TextBoxNum txtShuno1) {
        this.txtShuno1 = txtShuno1;
    }

    // </editor-fold>
}
/**
 * cellkampu1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu1")
    private TextBoxNum txtKampu1;

    /*
     * gettxtKampu1
     * @return txtKampu1
     */
    @JsonProperty("txtKampu1")
    public TextBoxNum getTxtKampu1() {
        return txtKampu1;
    }

    /*
     * settxtKampu1
     * @param txtKampu1 txtKampu1
     */
    @JsonProperty("txtKampu1")
    public void setTxtKampu1(TextBoxNum txtKampu1) {
        this.txtKampu1 = txtKampu1;
    }

    // </editor-fold>
}
/**
 * cellfuno1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellmino1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellgemmengaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku1Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku1")
    private TextBoxNum txtgemmengaku1;

    /*
     * gettxtgemmengaku1
     * @return txtgemmengaku1
     */
    @JsonProperty("txtgemmengaku1")
    public TextBoxNum getTxtgemmengaku1() {
        return txtgemmengaku1;
    }

    /*
     * settxtgemmengaku1
     * @param txtgemmengaku1 txtgemmengaku1
     */
    @JsonProperty("txtgemmengaku1")
    public void setTxtgemmengaku1(TextBoxNum txtgemmengaku1) {
        this.txtgemmengaku1 = txtgemmengaku1;
    }

    // </editor-fold>
}
/**
 * cellfutsuchoshu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfutsuchoshuAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblfutsuchoshu")
    private Label lblfutsuchoshu;

    /*
     * getlblfutsuchoshu
     * @return lblfutsuchoshu
     */
    @JsonProperty("lblfutsuchoshu")
    public Label getLblfutsuchoshu() {
        return lblfutsuchoshu;
    }

    /*
     * setlblfutsuchoshu
     * @param lblfutsuchoshu lblfutsuchoshu
     */
    @JsonProperty("lblfutsuchoshu")
    public void setLblfutsuchoshu(Label lblfutsuchoshu) {
        this.lblfutsuchoshu = lblfutsuchoshu;
    }

    // </editor-fold>
}
/**
 * cellchotei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei2")
    private TextBoxNum txtchotei2;

    /*
     * gettxtchotei2
     * @return txtchotei2
     */
    @JsonProperty("txtchotei2")
    public TextBoxNum getTxtchotei2() {
        return txtchotei2;
    }

    /*
     * settxtchotei2
     * @param txtchotei2 txtchotei2
     */
    @JsonProperty("txtchotei2")
    public void setTxtchotei2(TextBoxNum txtchotei2) {
        this.txtchotei2 = txtchotei2;
    }

    // </editor-fold>
}
/**
 * cellshuno2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno2")
    private TextBoxNum txtShuno2;

    /*
     * gettxtShuno2
     * @return txtShuno2
     */
    @JsonProperty("txtShuno2")
    public TextBoxNum getTxtShuno2() {
        return txtShuno2;
    }

    /*
     * settxtShuno2
     * @param txtShuno2 txtShuno2
     */
    @JsonProperty("txtShuno2")
    public void setTxtShuno2(TextBoxNum txtShuno2) {
        this.txtShuno2 = txtShuno2;
    }

    // </editor-fold>
}
/**
 * cellkampu2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu2")
    private TextBoxNum txtKampu2;

    /*
     * gettxtKampu2
     * @return txtKampu2
     */
    @JsonProperty("txtKampu2")
    public TextBoxNum getTxtKampu2() {
        return txtKampu2;
    }

    /*
     * settxtKampu2
     * @param txtKampu2 txtKampu2
     */
    @JsonProperty("txtKampu2")
    public void setTxtKampu2(TextBoxNum txtKampu2) {
        this.txtKampu2 = txtKampu2;
    }

    // </editor-fold>
}
/**
 * cellfuno2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtfuno2")
    private TextBoxNum txtfuno2;

    /*
     * gettxtfuno2
     * @return txtfuno2
     */
    @JsonProperty("txtfuno2")
    public TextBoxNum getTxtfuno2() {
        return txtfuno2;
    }

    /*
     * settxtfuno2
     * @param txtfuno2 txtfuno2
     */
    @JsonProperty("txtfuno2")
    public void setTxtfuno2(TextBoxNum txtfuno2) {
        this.txtfuno2 = txtfuno2;
    }

    // </editor-fold>
}
/**
 * cellmino2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtmino2")
    private TextBoxNum txtmino2;

    /*
     * gettxtmino2
     * @return txtmino2
     */
    @JsonProperty("txtmino2")
    public TextBoxNum getTxtmino2() {
        return txtmino2;
    }

    /*
     * settxtmino2
     * @param txtmino2 txtmino2
     */
    @JsonProperty("txtmino2")
    public void setTxtmino2(TextBoxNum txtmino2) {
        this.txtmino2 = txtmino2;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku2Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku2")
    private TextBoxNum txtgemmengaku2;

    /*
     * gettxtgemmengaku2
     * @return txtgemmengaku2
     */
    @JsonProperty("txtgemmengaku2")
    public TextBoxNum getTxtgemmengaku2() {
        return txtgemmengaku2;
    }

    /*
     * settxtgemmengaku2
     * @param txtgemmengaku2 txtgemmengaku2
     */
    @JsonProperty("txtgemmengaku2")
    public void setTxtgemmengaku2(TextBoxNum txtgemmengaku2) {
        this.txtgemmengaku2 = txtgemmengaku2;
    }

    // </editor-fold>
}
/**
 * cellkei のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkeiAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkei")
    private Label lblkei;

    /*
     * getlblkei
     * @return lblkei
     */
    @JsonProperty("lblkei")
    public Label getLblkei() {
        return lblkei;
    }

    /*
     * setlblkei
     * @param lblkei lblkei
     */
    @JsonProperty("lblkei")
    public void setLblkei(Label lblkei) {
        this.lblkei = lblkei;
    }

    // </editor-fold>
}
/**
 * cellchotei3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei3")
    private TextBoxNum txtchotei3;

    /*
     * gettxtchotei3
     * @return txtchotei3
     */
    @JsonProperty("txtchotei3")
    public TextBoxNum getTxtchotei3() {
        return txtchotei3;
    }

    /*
     * settxtchotei3
     * @param txtchotei3 txtchotei3
     */
    @JsonProperty("txtchotei3")
    public void setTxtchotei3(TextBoxNum txtchotei3) {
        this.txtchotei3 = txtchotei3;
    }

    // </editor-fold>
}
/**
 * cellshuno3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno3")
    private TextBoxNum txtShuno3;

    /*
     * gettxtShuno3
     * @return txtShuno3
     */
    @JsonProperty("txtShuno3")
    public TextBoxNum getTxtShuno3() {
        return txtShuno3;
    }

    /*
     * settxtShuno3
     * @param txtShuno3 txtShuno3
     */
    @JsonProperty("txtShuno3")
    public void setTxtShuno3(TextBoxNum txtShuno3) {
        this.txtShuno3 = txtShuno3;
    }

    // </editor-fold>
}
/**
 * cellkampu3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu3")
    private TextBoxNum txtKampu3;

    /*
     * gettxtKampu3
     * @return txtKampu3
     */
    @JsonProperty("txtKampu3")
    public TextBoxNum getTxtKampu3() {
        return txtKampu3;
    }

    /*
     * settxtKampu3
     * @param txtKampu3 txtKampu3
     */
    @JsonProperty("txtKampu3")
    public void setTxtKampu3(TextBoxNum txtKampu3) {
        this.txtKampu3 = txtKampu3;
    }

    // </editor-fold>
}
/**
 * cellfuno3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtfuno3")
    private TextBoxNum txtfuno3;

    /*
     * gettxtfuno3
     * @return txtfuno3
     */
    @JsonProperty("txtfuno3")
    public TextBoxNum getTxtfuno3() {
        return txtfuno3;
    }

    /*
     * settxtfuno3
     * @param txtfuno3 txtfuno3
     */
    @JsonProperty("txtfuno3")
    public void setTxtfuno3(TextBoxNum txtfuno3) {
        this.txtfuno3 = txtfuno3;
    }

    // </editor-fold>
}
/**
 * cellmino3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtmino3")
    private TextBoxNum txtmino3;

    /*
     * gettxtmino3
     * @return txtmino3
     */
    @JsonProperty("txtmino3")
    public TextBoxNum getTxtmino3() {
        return txtmino3;
    }

    /*
     * settxtmino3
     * @param txtmino3 txtmino3
     */
    @JsonProperty("txtmino3")
    public void setTxtmino3(TextBoxNum txtmino3) {
        this.txtmino3 = txtmino3;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku3Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku3")
    private TextBoxNum txtgemmengaku3;

    /*
     * gettxtgemmengaku3
     * @return txtgemmengaku3
     */
    @JsonProperty("txtgemmengaku3")
    public TextBoxNum getTxtgemmengaku3() {
        return txtgemmengaku3;
    }

    /*
     * settxtgemmengaku3
     * @param txtgemmengaku3 txtgemmengaku3
     */
    @JsonProperty("txtgemmengaku3")
    public void setTxtgemmengaku3(TextBoxNum txtgemmengaku3) {
        this.txtgemmengaku3 = txtgemmengaku3;
    }

    // </editor-fold>
}
/**
 * celltaino のクラスファイル 
 * 
 * @author 自動生成
 */
class celltainoAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltaino")
    private Label lbltaino;

    /*
     * getlbltaino
     * @return lbltaino
     */
    @JsonProperty("lbltaino")
    public Label getLbltaino() {
        return lbltaino;
    }

    /*
     * setlbltaino
     * @param lbltaino lbltaino
     */
    @JsonProperty("lbltaino")
    public void setLbltaino(Label lbltaino) {
        this.lbltaino = lbltaino;
    }

    // </editor-fold>
}
/**
 * celltatokubetsuchoshu のクラスファイル 
 * 
 * @author 自動生成
 */
class celltatokubetsuchoshuAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltatokubetsuchoshu")
    private Label lbltatokubetsuchoshu;

    /*
     * getlbltatokubetsuchoshu
     * @return lbltatokubetsuchoshu
     */
    @JsonProperty("lbltatokubetsuchoshu")
    public Label getLbltatokubetsuchoshu() {
        return lbltatokubetsuchoshu;
    }

    /*
     * setlbltatokubetsuchoshu
     * @param lbltatokubetsuchoshu lbltatokubetsuchoshu
     */
    @JsonProperty("lbltatokubetsuchoshu")
    public void setLbltatokubetsuchoshu(Label lbltatokubetsuchoshu) {
        this.lbltatokubetsuchoshu = lbltatokubetsuchoshu;
    }

    // </editor-fold>
}
/**
 * cellchotei4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei4Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei4")
    private TextBoxNum txtchotei4;

    /*
     * gettxtchotei4
     * @return txtchotei4
     */
    @JsonProperty("txtchotei4")
    public TextBoxNum getTxtchotei4() {
        return txtchotei4;
    }

    /*
     * settxtchotei4
     * @param txtchotei4 txtchotei4
     */
    @JsonProperty("txtchotei4")
    public void setTxtchotei4(TextBoxNum txtchotei4) {
        this.txtchotei4 = txtchotei4;
    }

    // </editor-fold>
}
/**
 * cellshuno4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno4Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno4")
    private TextBoxNum txtShuno4;

    /*
     * gettxtShuno4
     * @return txtShuno4
     */
    @JsonProperty("txtShuno4")
    public TextBoxNum getTxtShuno4() {
        return txtShuno4;
    }

    /*
     * settxtShuno4
     * @param txtShuno4 txtShuno4
     */
    @JsonProperty("txtShuno4")
    public void setTxtShuno4(TextBoxNum txtShuno4) {
        this.txtShuno4 = txtShuno4;
    }

    // </editor-fold>
}
/**
 * cellkampu4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu4Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu4")
    private TextBoxNum txtKampu4;

    /*
     * gettxtKampu4
     * @return txtKampu4
     */
    @JsonProperty("txtKampu4")
    public TextBoxNum getTxtKampu4() {
        return txtKampu4;
    }

    /*
     * settxtKampu4
     * @param txtKampu4 txtKampu4
     */
    @JsonProperty("txtKampu4")
    public void setTxtKampu4(TextBoxNum txtKampu4) {
        this.txtKampu4 = txtKampu4;
    }

    // </editor-fold>
}
/**
 * cellfuno5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtfuno4")
    private TextBoxNum txtfuno4;

    /*
     * gettxtfuno4
     * @return txtfuno4
     */
    @JsonProperty("txtfuno4")
    public TextBoxNum getTxtfuno4() {
        return txtfuno4;
    }

    /*
     * settxtfuno4
     * @param txtfuno4 txtfuno4
     */
    @JsonProperty("txtfuno4")
    public void setTxtfuno4(TextBoxNum txtfuno4) {
        this.txtfuno4 = txtfuno4;
    }

    // </editor-fold>
}
/**
 * cellmino4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino4Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtmino4")
    private TextBoxNum txtmino4;

    /*
     * gettxtmino4
     * @return txtmino4
     */
    @JsonProperty("txtmino4")
    public TextBoxNum getTxtmino4() {
        return txtmino4;
    }

    /*
     * settxtmino4
     * @param txtmino4 txtmino4
     */
    @JsonProperty("txtmino4")
    public void setTxtmino4(TextBoxNum txtmino4) {
        this.txtmino4 = txtmino4;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku4Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku4")
    private TextBoxNum txtgemmengaku4;

    /*
     * gettxtgemmengaku4
     * @return txtgemmengaku4
     */
    @JsonProperty("txtgemmengaku4")
    public TextBoxNum getTxtgemmengaku4() {
        return txtgemmengaku4;
    }

    /*
     * settxtgemmengaku4
     * @param txtgemmengaku4 txtgemmengaku4
     */
    @JsonProperty("txtgemmengaku4")
    public void setTxtgemmengaku4(TextBoxNum txtgemmengaku4) {
        this.txtgemmengaku4 = txtgemmengaku4;
    }

    // </editor-fold>
}
/**
 * cellgokei のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgokeiAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgokei")
    private Label lblgokei;

    /*
     * getlblgokei
     * @return lblgokei
     */
    @JsonProperty("lblgokei")
    public Label getLblgokei() {
        return lblgokei;
    }

    /*
     * setlblgokei
     * @param lblgokei lblgokei
     */
    @JsonProperty("lblgokei")
    public void setLblgokei(Label lblgokei) {
        this.lblgokei = lblgokei;
    }

    // </editor-fold>
}
/**
 * celltokute のクラスファイル 
 * 
 * @author 自動生成
 */
class celltokuteAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltokute")
    private Label lbltokute;

    /*
     * getlbltokute
     * @return lbltokute
     */
    @JsonProperty("lbltokute")
    public Label getLbltokute() {
        return lbltokute;
    }

    /*
     * setlbltokute
     * @param lbltokute lbltokute
     */
    @JsonProperty("lbltokute")
    public void setLbltokute(Label lbltokute) {
        this.lbltokute = lbltokute;
    }

    // </editor-fold>
}
/**
 * cellchotei5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei5")
    private TextBoxNum txtchotei5;

    /*
     * gettxtchotei5
     * @return txtchotei5
     */
    @JsonProperty("txtchotei5")
    public TextBoxNum getTxtchotei5() {
        return txtchotei5;
    }

    /*
     * settxtchotei5
     * @param txtchotei5 txtchotei5
     */
    @JsonProperty("txtchotei5")
    public void setTxtchotei5(TextBoxNum txtchotei5) {
        this.txtchotei5 = txtchotei5;
    }

    // </editor-fold>
}
/**
 * cellshuno5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno5")
    private TextBoxNum txtShuno5;

    /*
     * gettxtShuno5
     * @return txtShuno5
     */
    @JsonProperty("txtShuno5")
    public TextBoxNum getTxtShuno5() {
        return txtShuno5;
    }

    /*
     * settxtShuno5
     * @param txtShuno5 txtShuno5
     */
    @JsonProperty("txtShuno5")
    public void setTxtShuno5(TextBoxNum txtShuno5) {
        this.txtShuno5 = txtShuno5;
    }

    // </editor-fold>
}
/**
 * cellkampu5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu5")
    private TextBoxNum txtKampu5;

    /*
     * gettxtKampu5
     * @return txtKampu5
     */
    @JsonProperty("txtKampu5")
    public TextBoxNum getTxtKampu5() {
        return txtKampu5;
    }

    /*
     * settxtKampu5
     * @param txtKampu5 txtKampu5
     */
    @JsonProperty("txtKampu5")
    public void setTxtKampu5(TextBoxNum txtKampu5) {
        this.txtKampu5 = txtKampu5;
    }

    // </editor-fold>
}
/**
 * cellfuno6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellmino5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellgemmengaku5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku5Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku5")
    private TextBoxNum txtgemmengaku5;

    /*
     * gettxtgemmengaku5
     * @return txtgemmengaku5
     */
    @JsonProperty("txtgemmengaku5")
    public TextBoxNum getTxtgemmengaku5() {
        return txtgemmengaku5;
    }

    /*
     * settxtgemmengaku5
     * @param txtgemmengaku5 txtgemmengaku5
     */
    @JsonProperty("txtgemmengaku5")
    public void setTxtgemmengaku5(TextBoxNum txtgemmengaku5) {
        this.txtgemmengaku5 = txtgemmengaku5;
    }

    // </editor-fold>
}
/**
 * cellgokeifutsuchoshu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgokeifutsuchoshuAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgokeifutsuchoshu")
    private Label lblgokeifutsuchoshu;

    /*
     * getlblgokeifutsuchoshu
     * @return lblgokeifutsuchoshu
     */
    @JsonProperty("lblgokeifutsuchoshu")
    public Label getLblgokeifutsuchoshu() {
        return lblgokeifutsuchoshu;
    }

    /*
     * setlblgokeifutsuchoshu
     * @param lblgokeifutsuchoshu lblgokeifutsuchoshu
     */
    @JsonProperty("lblgokeifutsuchoshu")
    public void setLblgokeifutsuchoshu(Label lblgokeifutsuchoshu) {
        this.lblgokeifutsuchoshu = lblgokeifutsuchoshu;
    }

    // </editor-fold>
}
/**
 * cellchotei6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei6")
    private TextBoxNum txtchotei6;

    /*
     * gettxtchotei6
     * @return txtchotei6
     */
    @JsonProperty("txtchotei6")
    public TextBoxNum getTxtchotei6() {
        return txtchotei6;
    }

    /*
     * settxtchotei6
     * @param txtchotei6 txtchotei6
     */
    @JsonProperty("txtchotei6")
    public void setTxtchotei6(TextBoxNum txtchotei6) {
        this.txtchotei6 = txtchotei6;
    }

    // </editor-fold>
}
/**
 * cellshuno6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno6")
    private TextBoxNum txtShuno6;

    /*
     * gettxtShuno6
     * @return txtShuno6
     */
    @JsonProperty("txtShuno6")
    public TextBoxNum getTxtShuno6() {
        return txtShuno6;
    }

    /*
     * settxtShuno6
     * @param txtShuno6 txtShuno6
     */
    @JsonProperty("txtShuno6")
    public void setTxtShuno6(TextBoxNum txtShuno6) {
        this.txtShuno6 = txtShuno6;
    }

    // </editor-fold>
}
/**
 * cellkampu6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtxtKampu6")
    private TextBoxNum txtxtKampu6;

    /*
     * gettxtxtKampu6
     * @return txtxtKampu6
     */
    @JsonProperty("txtxtKampu6")
    public TextBoxNum getTxtxtKampu6() {
        return txtxtKampu6;
    }

    /*
     * settxtxtKampu6
     * @param txtxtKampu6 txtxtKampu6
     */
    @JsonProperty("txtxtKampu6")
    public void setTxtxtKampu6(TextBoxNum txtxtKampu6) {
        this.txtxtKampu6 = txtxtKampu6;
    }

    // </editor-fold>
}
/**
 * cellfuno8 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellfuno8Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtfuno5")
    private TextBoxNum txtfuno5;

    /*
     * gettxtfuno5
     * @return txtfuno5
     */
    @JsonProperty("txtfuno5")
    public TextBoxNum getTxtfuno5() {
        return txtfuno5;
    }

    /*
     * settxtfuno5
     * @param txtfuno5 txtfuno5
     */
    @JsonProperty("txtfuno5")
    public void setTxtfuno5(TextBoxNum txtfuno5) {
        this.txtfuno5 = txtfuno5;
    }

    // </editor-fold>
}
/**
 * cellmino6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtmino6")
    private TextBoxNum txtmino6;

    /*
     * gettxtmino6
     * @return txtmino6
     */
    @JsonProperty("txtmino6")
    public TextBoxNum getTxtmino6() {
        return txtmino6;
    }

    /*
     * settxtmino6
     * @param txtmino6 txtmino6
     */
    @JsonProperty("txtmino6")
    public void setTxtmino6(TextBoxNum txtmino6) {
        this.txtmino6 = txtmino6;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku6Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku6")
    private TextBoxNum txtgemmengaku6;

    /*
     * gettxtgemmengaku6
     * @return txtgemmengaku6
     */
    @JsonProperty("txtgemmengaku6")
    public TextBoxNum getTxtgemmengaku6() {
        return txtgemmengaku6;
    }

    /*
     * settxtgemmengaku6
     * @param txtgemmengaku6 txtgemmengaku6
     */
    @JsonProperty("txtgemmengaku6")
    public void setTxtgemmengaku6(TextBoxNum txtgemmengaku6) {
        this.txtgemmengaku6 = txtgemmengaku6;
    }

    // </editor-fold>
}
/**
 * cellgokeii のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgokeiiAttblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblgokeii")
    private Label lblgokeii;

    /*
     * getlblgokeii
     * @return lblgokeii
     */
    @JsonProperty("lblgokeii")
    public Label getLblgokeii() {
        return lblgokeii;
    }

    /*
     * setlblgokeii
     * @param lblgokeii lblgokeii
     */
    @JsonProperty("lblgokeii")
    public void setLblgokeii(Label lblgokeii) {
        this.lblgokeii = lblgokeii;
    }

    // </editor-fold>
}
/**
 * cellchotei7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellchotei7Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtchotei7")
    private TextBoxNum txtchotei7;

    /*
     * gettxtchotei7
     * @return txtchotei7
     */
    @JsonProperty("txtchotei7")
    public TextBoxNum getTxtchotei7() {
        return txtchotei7;
    }

    /*
     * settxtchotei7
     * @param txtchotei7 txtchotei7
     */
    @JsonProperty("txtchotei7")
    public void setTxtchotei7(TextBoxNum txtchotei7) {
        this.txtchotei7 = txtchotei7;
    }

    // </editor-fold>
}
/**
 * cellshuno7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshuno7Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtShuno7")
    private TextBoxNum txtShuno7;

    /*
     * gettxtShuno7
     * @return txtShuno7
     */
    @JsonProperty("txtShuno7")
    public TextBoxNum getTxtShuno7() {
        return txtShuno7;
    }

    /*
     * settxtShuno7
     * @param txtShuno7 txtShuno7
     */
    @JsonProperty("txtShuno7")
    public void setTxtShuno7(TextBoxNum txtShuno7) {
        this.txtShuno7 = txtShuno7;
    }

    // </editor-fold>
}
/**
 * cellkampu8 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu8Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtKampu7")
    private TextBoxNum txtKampu7;

    /*
     * gettxtKampu7
     * @return txtKampu7
     */
    @JsonProperty("txtKampu7")
    public TextBoxNum getTxtKampu7() {
        return txtKampu7;
    }

    /*
     * settxtKampu7
     * @param txtKampu7 txtKampu7
     */
    @JsonProperty("txtKampu7")
    public void setTxtKampu7(TextBoxNum txtKampu7) {
        this.txtKampu7 = txtKampu7;
    }

    // </editor-fold>
}
/**
 * cellkampu7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkampu7Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtfuno6")
    private TextBoxNum txtfuno6;

    /*
     * gettxtfuno6
     * @return txtfuno6
     */
    @JsonProperty("txtfuno6")
    public TextBoxNum getTxtfuno6() {
        return txtfuno6;
    }

    /*
     * settxtfuno6
     * @param txtfuno6 txtfuno6
     */
    @JsonProperty("txtfuno6")
    public void setTxtfuno6(TextBoxNum txtfuno6) {
        this.txtfuno6 = txtfuno6;
    }

    // </editor-fold>
}
/**
 * cellmino7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellmino7Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtmino7")
    private TextBoxNum txtmino7;

    /*
     * gettxtmino7
     * @return txtmino7
     */
    @JsonProperty("txtmino7")
    public TextBoxNum getTxtmino7() {
        return txtmino7;
    }

    /*
     * settxtmino7
     * @param txtmino7 txtmino7
     */
    @JsonProperty("txtmino7")
    public void setTxtmino7(TextBoxNum txtmino7) {
        this.txtmino7 = txtmino7;
    }

    // </editor-fold>
}
/**
 * cellgemmengaku7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellgemmengaku7Attblhokenryoshuno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtgemmengaku7")
    private TextBoxNum txtgemmengaku7;

    /*
     * gettxtgemmengaku7
     * @return txtgemmengaku7
     */
    @JsonProperty("txtgemmengaku7")
    public TextBoxNum getTxtgemmengaku7() {
        return txtgemmengaku7;
    }

    /*
     * settxtgemmengaku7
     * @param txtgemmengaku7 txtgemmengaku7
     */
    @JsonProperty("txtgemmengaku7")
    public void setTxtgemmengaku7(TextBoxNum txtgemmengaku7) {
        this.txtgemmengaku7 = txtgemmengaku7;
    }

    // </editor-fold>
}
