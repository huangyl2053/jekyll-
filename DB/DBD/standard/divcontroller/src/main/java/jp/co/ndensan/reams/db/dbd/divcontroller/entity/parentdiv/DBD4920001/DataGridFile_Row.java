package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Oct 13 17:43:56 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * DataGridFile_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class DataGridFile_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString fileFormat;
    private RString meisho;
    private RString total;
    private RString fileName;

    public DataGridFile_Row() {
        super();
        this.fileFormat = RString.EMPTY;
        this.meisho = RString.EMPTY;
        this.total = RString.EMPTY;
        this.fileName = RString.EMPTY;
        this.setOriginalData("fileFormat", fileFormat);
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("total", total);
        this.setOriginalData("fileName", fileName);
    }

    public DataGridFile_Row(RString fileFormat, RString meisho, RString total, RString fileName) {
        super();
        this.setOriginalData("fileFormat", fileFormat);
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("total", total);
        this.setOriginalData("fileName", fileName);
        this.fileFormat = fileFormat;
        this.meisho = meisho;
        this.total = total;
        this.fileName = fileName;
    }

    public RString getFileFormat() {
        return fileFormat;
    }

    public RString getMeisho() {
        return meisho;
    }

    public RString getTotal() {
        return total;
    }

    public RString getFileName() {
        return fileName;
    }

    public void setFileFormat(RString fileFormat) {
        this.setOriginalData("fileFormat", fileFormat);
        this.fileFormat = fileFormat;
    }

    public void setMeisho(RString meisho) {
        this.setOriginalData("meisho", meisho);
        this.meisho = meisho;
    }

    public void setTotal(RString total) {
        this.setOriginalData("total", total);
        this.total = total;
    }

    public void setFileName(RString fileName) {
        this.setOriginalData("fileName", fileName);
        this.fileName = fileName;
    }

    // </editor-fold>
}
