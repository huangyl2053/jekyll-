package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査特記情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5010NinteiChosaTokkijikoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public final static String TABLE_NAME = "DbT5010NinteiChosaTokkijiko";
    @PrimaryKey
    private RString shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private RString ninteichosaTokkijikoNo;
    private RString ninteichosaTokkijiko;

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    public RString getNinteichosaTokkijikoNo() {
        return ninteichosaTokkijikoNo;
    }

    public void setNinteichosaTokkijikoNo(RString ninteichosaTokkijikoNo) {
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    public RString getNinteichosaTokkijiko() {
        return ninteichosaTokkijiko;
    }

    public void setNinteichosaTokkijiko(RString ninteichosaTokkijiko) {
        this.ninteichosaTokkijiko = ninteichosaTokkijiko;
    }
// </editor-fold>
}
