/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査依頼情報を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum DbT5006NinteichosaIraiJoho implements IColumnDefinition {

    shinseishoKanriNo(10, 0),
    ninteichosaIraiRirekiNo(10, 0),
    ninteichosaItakusakiCode(10, 0),
    chousainCode(10, 0),
    ninteichousaIraiKubunCode(10, 0),
    ninteichosaIraiKaisu(10, 0),
    ninteichosaIraiYMD(10, 0),
    ninteichosaKigenYMD(10, 0),
    iraishoShutsuryokuYMD(10, 0),
    chosahyoTouShutsuryokuYMD(10, 0),
    mobileDataShutsuryokuFlag(10, 0),
    ninteichosaTokusokuYMD(10, 0),
    ninteichosaTokusokuHoho(10, 0),
    ninteichosaTokusokuKaisu(10, 0),
    ninteichosaTokusokuMemo(10, 0);
    private final int maxLength;
    private final int scale;

    private DbT5006NinteichosaIraiJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長を返します。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 項目の小数点以下の桁数を返します。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
}
