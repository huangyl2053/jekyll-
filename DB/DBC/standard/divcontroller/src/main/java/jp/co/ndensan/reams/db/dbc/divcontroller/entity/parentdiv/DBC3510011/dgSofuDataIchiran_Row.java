package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 14:14:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSofuDataIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSofuDataIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString shoriFlag;
    private RString fileName;

    public dgSofuDataIchiran_Row() {
        super();
        this.shoriFlag = RString.EMPTY;
        this.fileName = RString.EMPTY;
        this.setOriginalData("shoriFlag", shoriFlag);
        this.setOriginalData("fileName", fileName);
    }

    public dgSofuDataIchiran_Row(RString shoriFlag, RString fileName) {
        super();
        this.setOriginalData("shoriFlag", shoriFlag);
        this.setOriginalData("fileName", fileName);
        this.shoriFlag = shoriFlag;
        this.fileName = fileName;
    }

    public RString getShoriFlag() {
        return shoriFlag;
    }

    public RString getFileName() {
        return fileName;
    }

    public void setShoriFlag(RString shoriFlag) {
        this.setOriginalData("shoriFlag", shoriFlag);
        this.shoriFlag = shoriFlag;
    }

    public void setFileName(RString fileName) {
        this.setOriginalData("fileName", fileName);
        this.fileName = fileName;
    }

    // </editor-fold>
}
