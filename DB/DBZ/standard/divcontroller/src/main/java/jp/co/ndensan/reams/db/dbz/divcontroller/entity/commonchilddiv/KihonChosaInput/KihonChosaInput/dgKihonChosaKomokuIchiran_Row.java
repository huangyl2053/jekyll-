package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jan 23 17:39:56 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKihonChosaKomokuIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKihonChosaKomokuIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString tokkiAri;
    private RString gun;
    private RString naiyo;
    private RString zenkai;
    private TextBoxNum nyuryoku;

    public dgKihonChosaKomokuIchiran_Row() {
        super();
        this.tokkiAri = RString.EMPTY;
        this.gun = RString.EMPTY;
        this.naiyo = RString.EMPTY;
        this.zenkai = RString.EMPTY;
        this.nyuryoku = new TextBoxNum();
        this.setOriginalData("tokkiAri", tokkiAri);
        this.setOriginalData("gun", gun);
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("zenkai", zenkai);
        this.setOriginalData("nyuryoku", nyuryoku);
    }

    public dgKihonChosaKomokuIchiran_Row(RString tokkiAri, RString gun, RString naiyo, RString zenkai, TextBoxNum nyuryoku) {
        super();
        this.setOriginalData("tokkiAri", tokkiAri);
        this.setOriginalData("gun", gun);
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("zenkai", zenkai);
        this.setOriginalData("nyuryoku", nyuryoku);
        this.tokkiAri = tokkiAri;
        this.gun = gun;
        this.naiyo = naiyo;
        this.zenkai = zenkai;
        this.nyuryoku = nyuryoku;
    }

    public RString getTokkiAri() {
        return tokkiAri;
    }

    public RString getGun() {
        return gun;
    }

    public RString getNaiyo() {
        return naiyo;
    }

    public RString getZenkai() {
        return zenkai;
    }

    public TextBoxNum getNyuryoku() {
        return nyuryoku;
    }

    public void setTokkiAri(RString tokkiAri) {
        this.setOriginalData("tokkiAri", tokkiAri);
        this.tokkiAri = tokkiAri;
    }

    public void setGun(RString gun) {
        this.setOriginalData("gun", gun);
        this.gun = gun;
    }

    public void setNaiyo(RString naiyo) {
        this.setOriginalData("naiyo", naiyo);
        this.naiyo = naiyo;
    }

    public void setZenkai(RString zenkai) {
        this.setOriginalData("zenkai", zenkai);
        this.zenkai = zenkai;
    }

    public void setNyuryoku(TextBoxNum nyuryoku) {
        this.setOriginalData("nyuryoku", nyuryoku);
        this.nyuryoku = nyuryoku;
    }

    // </editor-fold>
}
