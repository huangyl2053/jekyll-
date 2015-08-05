package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1013KyokaisoSochiShinseiの項目定義クラスです
 *
 */
public enum DbT1013KyokaisoSochiShinsei implements IColumnDefinition {
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
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 申請・廃止区分
     * <br/>1:申請、2:廃止
     */
    shinsei_HaishiKubun(1, 0),
    /**
     * 申請・廃止年月日
     */
    shinsei_HaishiYMD(2147483647, 0),
    /**
     * 保護不要根拠減額金額
     */
    hogoHuyoKonkyoGengakuKingaku(10, 0),
    /**
     * 境界層証明書交付年月日
     */
    kyokaisoShomeishoKofuYMD(2147483647, 0),
    /**
     * 給付額減額取消・減額自己負担月額
     */
    kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(10, 0),
    /**
     * 居住費軽減・減額自己負担月額
     */
    kyojuhiKeigen_GengakuJikofutanGetsugaku(10, 0),
    /**
     * 居住費軽減・負担限度額段階コード
     */
    kyojuhiKeigen_FutangendogakuDankaiCode(2, 0),
    /**
     * 食費軽減・減額自己負担月額
     */
    shokuhiKeigen_GengakuJikofutanGetsugaku(10, 0),
    /**
     * 食費軽減・負担限度額段階コード
     */
    shokuhiKeigen_FutangendogakuDankaiCode(2, 0),
    /**
     * 利用者負担世帯合算額・減額自己負担月額
     */
    riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(10, 0),
    /**
     * 保険料減額・減額自己負担月額
     */
    hokenryoGengaku_GengakuJikofutanGetsugaku(10, 0),
    /**
     * 減額自己負担月額合計額
     */
    gengakuJikofutanGetsugakuGokeigaku(10, 0),
    /**
     * 境界層措置決定年月日
     */
    kyukaisoSochiKetteiYMD(2147483647, 0),
    /**
     * 措置該当・非該当区分
     * <br/>1:該当、2:非該当
     */
    sochiGaito_HigaitoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1013KyokaisoSochiShinsei(int maxLength, int scale) {
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
