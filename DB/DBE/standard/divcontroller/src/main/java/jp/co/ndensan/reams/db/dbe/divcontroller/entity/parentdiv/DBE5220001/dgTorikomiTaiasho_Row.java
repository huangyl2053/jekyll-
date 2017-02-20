package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Feb 20 14:02:36 JST 2017 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">

    private RString importingFileName;
    private TextBoxNum dataNum;
    private RString fileName;
    private RString csvName;

    public dgTorikomiTaiasho_Row() {
        super();
        this.importingFileName = RString.EMPTY;
        this.dataNum = new TextBoxNum();
        this.fileName = RString.EMPTY;
        this.csvName = RString.EMPTY;
        this.setOriginalData("importingFileName", importingFileName);
        this.setOriginalData("dataNum", dataNum);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("csvName", csvName);
    }

    public dgTorikomiTaiasho_Row(RString importingFileName, TextBoxNum dataNum, RString fileName, RString csvName) {
        super();
        this.setOriginalData("importingFileName", importingFileName);
        this.setOriginalData("dataNum", dataNum);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("csvName", csvName);
        this.importingFileName = importingFileName;
        this.dataNum = dataNum;
        this.fileName = fileName;
        this.csvName = csvName;
    }

    public RString getImportingFileName() {
        return importingFileName;
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

    public void setImportingFileName(RString importingFileName) {
        this.setOriginalData("importingFileName", importingFileName);
        this.importingFileName = importingFileName;
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
