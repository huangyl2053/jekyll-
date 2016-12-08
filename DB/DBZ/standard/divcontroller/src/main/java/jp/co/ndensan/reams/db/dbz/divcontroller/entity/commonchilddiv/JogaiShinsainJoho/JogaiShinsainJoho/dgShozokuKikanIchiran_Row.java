package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 08 15:15:11 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShozokuKikanIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShozokuKikanIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">

    private RString hokensha;
    private RString code;
    private RString shozokuKikanName;

    public dgShozokuKikanIchiran_Row() {
        super();
        this.hokensha = RString.EMPTY;
        this.code = RString.EMPTY;
        this.shozokuKikanName = RString.EMPTY;
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("code", code);
        this.setOriginalData("shozokuKikanName", shozokuKikanName);
    }

    public dgShozokuKikanIchiran_Row(RString hokensha, RString code, RString shozokuKikanName) {
        super();
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("code", code);
        this.setOriginalData("shozokuKikanName", shozokuKikanName);
        this.hokensha = hokensha;
        this.code = code;
        this.shozokuKikanName = shozokuKikanName;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getCode() {
        return code;
    }

    public RString getShozokuKikanName() {
        return shozokuKikanName;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setShozokuKikanName(RString shozokuKikanName) {
        this.setOriginalData("shozokuKikanName", shozokuKikanName);
        this.shozokuKikanName = shozokuKikanName;
    }

    // </editor-fold>
}
