package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1006KyokaisoGaitoshaの項目定義クラスです
 *
 */
public enum DbT1006KyokaisoGaitosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * 境界層措置決定年月日
     */
    kyokaisoSochiKetteiYMD(2147483647, 0),
    /**
     * 給付額減額記載解除フラグ
     */
    kyuufugakuGengakuKisaiKiajoFlag(1, 0),
    /**
     * 標準負担額額該当フラグ
     */
    hyojunFutanGengakuGaitoFlag(1, 0),
    /**
     * 標準負担軽減後負担額
     */
    hyojunFutanKeigengoFutangaku(10, 0),
    /**
     * 居住費等負担額減額該当フラグ
     */
    kyojuhinadoFutangakugengakuGaitoFlag(1, 0),
    /**
     * 居住費軽減後居室種類コード
     */
    kyojuhiKeigengoKyoshitsuShuruiCode(2, 0),
    /**
     * 居住費軽減後負担額
     */
    kyojuhiKeigengoHutangaku(10, 0),
    /**
     * 食費負担額減額該当フラグ
     */
    shokuhiKeigengoHutangakuGaitoFlag(1, 0),
    /**
     * 食費軽減後負担額
     */
    shokuhiKeigengoHutangaku(10, 0),
    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    kogakuServicehiJogengakuGengakuGaitoFlag(1, 0),
    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額
     */
    kogakuServicehiJogengakuGengakugoJogengaku(10, 0),
    /**
     * 保険料納付減額フラグ
     */
    hokenryoNofuGengakuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1006KyokaisoGaitosha(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
