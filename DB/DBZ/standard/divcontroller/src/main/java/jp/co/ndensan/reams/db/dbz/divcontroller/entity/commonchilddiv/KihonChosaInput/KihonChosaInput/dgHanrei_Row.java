package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jan 23 17:39:56 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHanrei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHanrei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString hanreiNo;
    private RString hanreiNaiyo;

    public dgHanrei_Row() {
        super();
        this.hanreiNo = RString.EMPTY;
        this.hanreiNaiyo = RString.EMPTY;
        this.setOriginalData("hanreiNo", hanreiNo);
        this.setOriginalData("hanreiNaiyo", hanreiNaiyo);
    }

    public dgHanrei_Row(RString hanreiNo, RString hanreiNaiyo) {
        super();
        this.setOriginalData("hanreiNo", hanreiNo);
        this.setOriginalData("hanreiNaiyo", hanreiNaiyo);
        this.hanreiNo = hanreiNo;
        this.hanreiNaiyo = hanreiNaiyo;
    }

    public RString getHanreiNo() {
        return hanreiNo;
    }

    public RString getHanreiNaiyo() {
        return hanreiNaiyo;
    }

    public void setHanreiNo(RString hanreiNo) {
        this.setOriginalData("hanreiNo", hanreiNo);
        this.hanreiNo = hanreiNo;
    }

    public void setHanreiNaiyo(RString hanreiNaiyo) {
        this.setOriginalData("hanreiNaiyo", hanreiNaiyo);
        this.hanreiNaiyo = hanreiNaiyo;
    }

    // </editor-fold>
}
