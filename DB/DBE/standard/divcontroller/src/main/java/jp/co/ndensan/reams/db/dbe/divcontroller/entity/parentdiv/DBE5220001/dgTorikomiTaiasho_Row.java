package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 27 11:40:56 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgTorikomiTaiasho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTorikomiTaiasho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">

    private RString meisho;
    private TextBoxNum dataNum;
    private RString fileName;
    private RString csvName;

    public dgTorikomiTaiasho_Row() {
        super();
        this.meisho = RString.EMPTY;
        this.dataNum = new TextBoxNum();
        this.fileName = RString.EMPTY;
        this.csvName = RString.EMPTY;
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("dataNum", dataNum);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("csvName", csvName);
    }

    public dgTorikomiTaiasho_Row(RString meisho, TextBoxNum dataNum, RString fileName, RString csvName) {
        super();
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("dataNum", dataNum);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("csvName", csvName);
        this.meisho = meisho;
        this.dataNum = dataNum;
        this.fileName = fileName;
        this.csvName = csvName;
    }

    public RString getMeisho() {
        return meisho;
    }

    public TextBoxNum getDataNum() {
        return dataNum;
    }

    public RString getFileName() {
        return fileName;
    }

    public RString getCsvName() {
        return csvName;
    }

    public void setMeisho(RString meisho) {
        this.setOriginalData("meisho", meisho);
        this.meisho = meisho;
    }

    public void setDataNum(TextBoxNum dataNum) {
        this.setOriginalData("dataNum", dataNum);
        this.dataNum = dataNum;
    }

    public void setFileName(RString fileName) {
        this.setOriginalData("fileName", fileName);
        this.fileName = fileName;
    }

    public void setCsvName(RString csvName) {
        this.setOriginalData("csvName", csvName);
        this.csvName = csvName;
    }

    // </editor-fold>
}
