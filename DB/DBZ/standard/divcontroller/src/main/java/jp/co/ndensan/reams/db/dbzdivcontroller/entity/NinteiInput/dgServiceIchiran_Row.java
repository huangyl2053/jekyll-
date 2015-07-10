package jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 16 18:18:31 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">

    private RString code;
    private RString serviceName;

    public dgServiceIchiran_Row() {
        super();
        this.code = RString.EMPTY;
        this.serviceName = RString.EMPTY;
    }

    public dgServiceIchiran_Row(RString code, RString serviceName) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("serviceName", serviceName);
        this.code = code;
        this.serviceName = serviceName;
    }

    public RString getCode() {
        return code;
    }

    public RString getServiceName() {
        return serviceName;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setServiceName(RString serviceName) {
        this.setOriginalData("serviceName", serviceName);
        this.serviceName = serviceName;
    }

    // </editor-fold>
}