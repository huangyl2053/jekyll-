package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT4001JukyushaDaichoの項目定義クラスです
 *
 */
public enum DbT4001JukyushaDaicho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(6, 0),
    hihokenshaNo(10, 0),
    shinseishoKanriNo(10, 0),
    shoriTimeStamp(2147483647, 0),
    shishoCode(9, 0),
    ShikibetsuCode(2147483647, 0),
    chikuCode(2147483647, 0),
    soshitsuYMD(2147483647, 0),
    nigouTokuteiShippeiCode(2147483647, 0),
    chokkinIdoYMD(2147483647, 0),
    chokkinIdoJiyuCode(2147483647, 0),
    shikyuGendoTanisu(10, 0),
    shikyuGendoKaishiYMD(2147483647, 0),
    shikyuGendoShuryoYMD(2147483647, 0),
    tankiSikyuGendoNissu(10, 0),
    tankiShikyuGendoKaishiYMD(2147483647, 0),
    tankiShikyuGendoShuryoYMD(2147483647, 0),
    jidoWariateJogaishaKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4001JukyushaDaicho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
