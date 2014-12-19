package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1006KyokaisoGaitoshaの項目定義クラスです
 *
 */
public enum DbT1006KyokaisoGaitosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    kyokaisoSochiKetteiYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    tekiyoKaishiYMD(2147483647, 0),
    tekiyoShuryoYMD(2147483647, 0),
    kyuufugakuGengakuKisaiKiajoFlag(1, 0),
    hyojunFutanGengakuGaitoFlag(1, 0),
    hyojunFutanKeigengoFutangaku(10, 0),
    kyojuhinadoFutangakugengakuGaitoFlag(1, 0),
    kyojuhiKeigengoKyoshitsuShuruiCode(2, 0),
    kyojuhiKeigengoHutangaku(10, 0),
    shokuhiKeigengoHutangakuGaitoFlag(1, 0),
    shokuhiKeigengoHutangaku(10, 0),
    kogakuServicehiJogengakuGengakuGaitoFlag(1, 0),
    kogakuServicehiJogengakuGengakugoJogengaku(10, 0),
    hokenryoNofuGengakuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1006KyokaisoGaitosha(int maxLength, int scale) {
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
