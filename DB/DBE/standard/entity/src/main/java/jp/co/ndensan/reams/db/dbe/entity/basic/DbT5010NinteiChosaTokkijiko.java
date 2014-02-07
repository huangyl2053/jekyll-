package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査特記情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5010NinteiChosaTokkijiko implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    shinseishoKanriNo(10, 0),
    ninteichosaRirekiNo(5, 0),
    ninteichosaTokkijikoNo(3, 0),
    ninteichosaTokkijiko(512, 0);
    private final int maxLength;
    private final int scale;

    private DbT5010NinteiChosaTokkijiko(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getScale() {
        return scale;
    }
// </editor-fold>
}
