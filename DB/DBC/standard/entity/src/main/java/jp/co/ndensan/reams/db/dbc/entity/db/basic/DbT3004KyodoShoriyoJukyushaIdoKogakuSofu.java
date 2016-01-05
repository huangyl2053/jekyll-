package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 共同処理用受給者異動高額送付テーブルの項目定義クラスです。
 */
public enum DbT3004KyodoShoriyoJukyushaIdoKogakuSofu implements IColumnDefinition {
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
     * 異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 異動区分コード
     * <br/>1:新規,2:変更,3:終了
     */
    idoKubunCode(1, 0),
    /**
     * 受給者異動事由
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     */
    jukyushaIdoJiyu(2, 0),
    /**
     * 証記載保険者番号
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 世帯集約番号
     * <br/>世帯主被保険者番号（世帯集約番号）
     */
    setaiShuyakuNo(2147483647, 0),
    /**
     * 世帯所得区分コード
     * <br/>1:低所得者等以外,2:市町村民税世帯非課税者等,3:生活保護
     */
    setaiShotokuKubunCode(1, 0),
    /**
     * 所得区分コード
     * <br/>1:低所得者等以外,2:市町村民税非課税者等,3:生活保護
     */
    shotokuKubunCode(1, 0),
    /**
     * 老齢福祉年金受給有フラグ
     * <br/>1:受給無し,2:受給有り
     */
    roureiFukushiNenkinJukyuAriFlag(1, 0),
    /**
     * 利用者負担第２段階有フラグ
     * <br/>1:該当無し,2:該当有り
     */
    riyoshaFutan2DankaiAriFlag(1, 0),
    /**
     * 支給申請書出力有フラグ
     * <br/>1:出力無し,2:出力有り
     */
    shikyuShinseishoOutputAriFlag(1, 0),
    /**
     * 訂正連絡票フラグ
     * <br/>異動or訂正 訂正ならtrue
     */
    teiseiRenrakuhyoFlag(1, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofu(int maxLength, int scale) {
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
