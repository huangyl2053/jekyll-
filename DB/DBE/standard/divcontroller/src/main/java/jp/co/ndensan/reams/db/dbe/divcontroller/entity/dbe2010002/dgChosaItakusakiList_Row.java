package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 26 16:42:12 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaItakusakiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaItakusakiList_Row extends DataRow {

    private RString chosaItakusakiNo;
    private RString chosaItakusakiName;
    private RString waritsukeTeiin;
    private RString waritsukeNum;
    private RString waritsukeChiku;

    public dgChosaItakusakiList_Row() {
        super();
    }

    public dgChosaItakusakiList_Row(RString chosaItakusakiNo, RString chosaItakusakiName, RString waritsukeTeiin, RString waritsukeNum, RString waritsukeChiku) {
        super();
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.setOriginalData("waritsukeChiku", waritsukeChiku);
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
        this.waritsukeTeiin = waritsukeTeiin;
        this.waritsukeNum = waritsukeNum;
        this.waritsukeChiku = waritsukeChiku;
    }

    public RString getChosaItakusakiNo() {
        return chosaItakusakiNo;
    }

    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    public RString getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    public RString getWaritsukeNum() {
        return waritsukeNum;
    }

    public RString getWaritsukeChiku() {
        return waritsukeChiku;
    }

    public void setChosaItakusakiNo(RString chosaItakusakiNo) {
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.chosaItakusakiNo = chosaItakusakiNo;
    }

    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiName = chosaItakusakiName;
    }

    public void setWaritsukeTeiin(RString waritsukeTeiin) {
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.waritsukeTeiin = waritsukeTeiin;
    }

    public void setWaritsukeNum(RString waritsukeNum) {
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.waritsukeNum = waritsukeNum;
    }

    public void setWaritsukeChiku(RString waritsukeChiku) {
        this.setOriginalData("waritsukeChiku", waritsukeChiku);
        this.waritsukeChiku = waritsukeChiku;
    }

}