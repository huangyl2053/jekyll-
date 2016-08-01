package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 28 11:26:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTorikomiTaisho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTorikomiTaisho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString fileFormat;
    private RString meisho;
    private RString total;
    private RString fileName;

    public dgTorikomiTaisho_Row() {
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

    public dgTorikomiTaisho_Row(RString fileFormat, RString meisho, RString total, RString fileName) {
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
