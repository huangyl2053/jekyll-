package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Oct 20 19:48:01 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSofuDataIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSofuDataIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private RString shoriFlag;
    private RString fileName;
    private RString fileId;

    public dgSofuDataIchiran_Row() {
        super();
        this.shoriFlag = RString.EMPTY;
        this.fileName = RString.EMPTY;
        this.fileId = RString.EMPTY;
        this.setOriginalData("shoriFlag", shoriFlag);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("fileId", fileId);
    }

    public dgSofuDataIchiran_Row(RString shoriFlag, RString fileName, RString fileId) {
        super();
        this.setOriginalData("shoriFlag", shoriFlag);
        this.setOriginalData("fileName", fileName);
        this.setOriginalData("fileId", fileId);
        this.shoriFlag = shoriFlag;
        this.fileName = fileName;
        this.fileId = fileId;
    }

    public RString getShoriFlag() {
        return shoriFlag;
    }

    public RString getFileName() {
        return fileName;
    }

    public RString getFileId() {
        return fileId;
    }

    public void setShoriFlag(RString shoriFlag) {
        this.setOriginalData("shoriFlag", shoriFlag);
        this.shoriFlag = shoriFlag;
    }

    public void setFileName(RString fileName) {
        this.setOriginalData("fileName", fileName);
        this.fileName = fileName;
    }

    public void setFileId(RString fileId) {
        this.setOriginalData("fileId", fileId);
        this.fileId = fileId;
    }

    // </editor-fold>
}
