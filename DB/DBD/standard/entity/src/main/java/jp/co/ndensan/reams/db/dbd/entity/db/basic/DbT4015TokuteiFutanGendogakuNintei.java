package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特定負担限度額認定テーブルの項目定義クラスです。
 */
public enum DbT4015TokuteiFutanGendogakuNintei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * shinseiYMD
     */
    shinseiYMD(2147483647, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * tekiyoKaishiYMD
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * tekiyoShuryoYMD
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * ketteiKubun
     */
    ketteiKubun(1, 0),
    /**
     * hiShoninRiyu
     */
    hiShoninRiyu(200, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 旧措置者区分
     * <br/>・空白
     * <br/>・旧措置
     * <br/>・負担軽減
     */
    kyuSochishaKubun(1, 0),
    /**
     * 申請理由区分
     * <br/>世帯非課税８０万以下
     * <br/>世帯非課税８０万超　
     * <br/>生保、
     * <br/>世帯非課税
     * <br/>老齢
     * <br/>特例減額措置
     * <br/>その他
     */
    shinseiRiyuKubun(1, 0),
    /**
     * 利用者負担段階
     * <br/>・第一段階
     * <br/>・第二段階
     * <br/>・第三段階
     * <br/>・課税層第三段階
     */
    riyoshaFutanDankai(1, 0),
    /**
     * 特例減額措置区分
     * <br/>1：該当者
     * <br/>0：非該当者
     */
    tokureiGengakuSochiKubun(1, 0),
    /**
     * 境界層該当者区分
     * <br/>1：該当者
     * <br/>0：非該当者
     */
    kyokaisoGaitoshaKubun(1, 0),
    /**
     * 激変緩和措置対象者区分
     * <br/>1：激変緩和対象者
     * <br/>0：激変緩和対象者以外
     */
    gekihenkanwaSochiTaishoshaKubun(1, 0),
    /**
     * 居室種別
     * <br/>1：ユニット型個室
     * <br/>2：ユニット型準個室
     * <br/>3：従来型個室
     * <br/>4：多床室
     * <br/>5：従来型個室（老健）
     */
    kyoshitsuShubetsu(1, 0),
    /**
     * 食費負担限度額
     */
    shokuhiFutanGendogaku(5, 0),
    /**
     * ユニット型個室
     */
    unitTypeKoshitsu(5, 0),
    /**
     * ユニット型準個室
     */
    unitTypeJunKoshitsu(5, 0),
    /**
     * 従来型個室（特養等）
     */
    juraiTypeKoshitsuTokuyo(5, 0),
    /**
     * 従来型個室（老健・療養等）
     */
    juraiTypeKoshitsuRoken_Ryoyo(5, 0),
    /**
     * 多床室
     */
    tashoshitsu(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT4015TokuteiFutanGendogakuNintei(int maxLength, int scale) {
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
