package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoRenrakusakiInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jul 18 17:59:28 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRenrakusaki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRenrakusaki_Row extends DataRow {

    private RString shimei;
    private RString tel;
    private RString keitaiNo;
    private RString shimeiKana;
    private RString yubinNo;
    private RString jusho;
    private RString zokugara;
    private RString renrakusakiKbnNo;

    public dgRenrakusaki_Row() {
        super();
        this.shimei = RString.EMPTY;
        this.tel = RString.EMPTY;
        this.keitaiNo = RString.EMPTY;
        this.shimeiKana = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.zokugara = RString.EMPTY;
        this.renrakusakiKbnNo = RString.EMPTY;
    }

    public dgRenrakusaki_Row(RString shimei, RString tel, RString keitaiNo, RString shimeiKana, RString yubinNo, RString jusho, RString zokugara, RString renrakusakiKbnNo) {
        super();
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("tel", tel);
        this.setOriginalData("keitaiNo", keitaiNo);
        this.setOriginalData("shimeiKana", shimeiKana);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("renrakusakiKbnNo", renrakusakiKbnNo);
        this.shimei = shimei;
        this.tel = tel;
        this.keitaiNo = keitaiNo;
        this.shimeiKana = shimeiKana;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.zokugara = zokugara;
        this.renrakusakiKbnNo = renrakusakiKbnNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getTel() {
        return tel;
    }

    public RString getKeitaiNo() {
        return keitaiNo;
    }

    public RString getShimeiKana() {
        return shimeiKana;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getZokugara() {
        return zokugara;
    }

    public RString getRenrakusakiKbnNo() {
        return renrakusakiKbnNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setTel(RString tel) {
        this.setOriginalData("tel", tel);
        this.tel = tel;
    }

    public void setKeitaiNo(RString keitaiNo) {
        this.setOriginalData("keitaiNo", keitaiNo);
        this.keitaiNo = keitaiNo;
    }

    public void setShimeiKana(RString shimeiKana) {
        this.setOriginalData("shimeiKana", shimeiKana);
        this.shimeiKana = shimeiKana;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setZokugara(RString zokugara) {
        this.setOriginalData("zokugara", zokugara);
        this.zokugara = zokugara;
    }

    public void setRenrakusakiKbnNo(RString renrakusakiKbnNo) {
        this.setOriginalData("renrakusakiKbnNo", renrakusakiKbnNo);
        this.renrakusakiKbnNo = renrakusakiKbnNo;
    }

}