package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護保険負担限度額認定テーブルの項目定義クラスです。
 */
public enum DbT4018KaigoHokenFutanGendogakuNintei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     */
    rirekiNo(5, 0),
    /**
     * 旧措置者区分
     * <br/>DBDEnum.旧措置区分
     * <br/>"":空白
     * <br/> 1:旧措置者
     * <br/> 2:旧措置者実質的負担軽減者
     */
    kyusochishaKubun(1, 0),
    /**
     * 申請理由区分
     * <br/>DBDEnum.申請理由区分 
     * <br/>01:世帯非課税８０万以下 
     * <br/>02:世帯非課税８０万超 　
     * <br/>03:生保 
     * <br/>04:世帯非課税 
     * <br/>05:老齢 
     * <br/>06:特例減額措置 
     * <br/>99:その他
     */
    shinseiRiyuKubun(2, 0),
    /**
     * 利用者負担段階
     * <br/>DBDEnum.利用者負担段階
     * <br/>1:第一段階
     * <br/>2:第二段階
     * <br/>3:第三段階
     * <br/>4:課税層第三段階
     */
    riyoshaFutanDankai(1, 0),
    /**
     * 境界層該当者区分
     * <br/>trueの場合、境界層該当者
     */
    kyokaisoGaitoshaKubun(1, 0),
    /**
     * 激変緩和措置対象者区分
     * <br/>trueの場合、激変緩和対象者
     */
    gekihenKanwaSochiTaishoshaKubun(1, 0),
    /**
     * 居室種別
     * <br/>DBDEnum.居室種別
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
    juraiTypeKoshitsu_Tokuyo(5, 0),
    /**
     * 従来型個室（老健・療養等）
     */
    juraiTypeKoshitsu_Roken_Ryoyo(5, 0),
    /**
     * 多床室
     */
    tashoshitsu(5, 0),
    /**
     * 配偶者の有無
     * <br/>trueの場合、配偶者あり。
     */
    haigushaUmuFlag(1, 0),
    /**
     * 配偶者氏名
     */
    haigushaShimei(2147483647, 0),
    /**
     * 配偶者氏名カナ
     */
    haigushaShimeiKana(2147483647, 0),
    /**
     * 配偶者生年月日
     */
    haigushaSeinenGappiYMD(2147483647, 0),
    /**
     * 配偶者住所
     */
    haigushaJusho(2147483647, 0),
    /**
     * 配偶者連絡先
     */
    haigushaRenrakusaki(15, 0),
    /**
     * 配偶者住所２
     * <br/>1月1日時点の住所
     */
    haigushaJusho2(2147483647, 0),
    /**
     * 配偶者課税区分
     * <br/>1:課税、2:非課税
     */
    haigushaKazeiKubun(1, 0),
    /**
     * 配偶者識別コード
     */
    haigushaShikibetsuCd(2147483647, 0),
    /**
     * 預貯金申告区分
     * <br/>預貯金、有価証券等の金額の合計が1000万円（夫婦は2000万円）かどうかの区分。
     * <br/>DBDEnum.預貯金申告区分
     * <br/>0:超過
     * <br/>1:以下
     */
    yochokinShinkokuKubun(1, 0),
    /**
     * 預貯金額
     */
    yochokinGaku(15, 0),
    /**
     * 有価証券評価概算額
     */
    yukashoukenGaisangaku(15, 0),
    /**
     * その他金額
     */
    sonotaKingaku(15, 0),
    /**
     * 一括認定バッチ処理日時
     * <br/>バッチによる一括認定時に、バッチの処理日時を設定
     */
    ninteiBatchExecutedTimestamp(2147483647, 0),
    /**
     * 遺族年金受給フラグ
     * <br/>tureの場合、申告有り。
     */
    izokuNenkinJukyuFlag(1, 0),
    /**
     * 障害年金受給フラグ
     * <br/>tureの場合、申告有り。
     */
    shogaiNenkinJukyuFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4018KaigoHokenFutanGendogakuNintei(int maxLength, int scale) {
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
