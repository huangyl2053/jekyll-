package jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護賦課テーブルの項目定義クラスです。
 */
public enum DbT2002Fuka implements IColumnDefinition {
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
     * 調定年度
     */
    choteiNendo(2147483647, 0),
    /**
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 世帯員数
     */
    setaiInsu(5, 0),
    /**
     * 資格取得日
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * 資格取得事由
     */
    shikakuShutokuJiyu(2, 0),
    /**
     * 資格喪失日
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 資格喪失事由
     */
    shikakuSoshitsuJiyu(2, 0),
    /**
     * 生活保護扶助種類
     */
    seihofujoShurui(2, 0),
    /**
     * 生保開始日
     */
    seihoKaishiYMD(2147483647, 0),
    /**
     * 生保廃止日
     */
    seihoHaishiYMD(2147483647, 0),
    /**
     * 老年開始日
     */
    ronenKaishiYMD(2147483647, 0),
    /**
     * 老年廃止日
     */
    ronenHaishiYMD(2147483647, 0),
    /**
     * 賦課期日
     */
    fukaYMD(2147483647, 0),
    /**
     * 課税区分
     */
    kazeiKubun(1, 0),
    /**
     * 世帯課税区分
     */
    setaikazeiKubun(1, 0),
    /**
     * 合計所得金額
     * <br/>マイナスの場合はゼロで管理
     */
    gokeiShotokuGaku(12, 0),
    /**
     * 公的年金収入額
     */
    nenkinShunyuGaku(12, 0),
    /**
     * 保険料段階
     * <br/>システムで管理する保険料段階
     */
    hokenryoDankai(3, 0),
    /**
     * 保険料算定段階1
     * <br/>内部コードで管理
     */
    hokenryoDankai1(3, 0),
    /**
     * 算定年額保険料1
     */
    nengakuHokenryo1(7, 0),
    /**
     * 月割開始年月1
     */
    tsukiwariStartYM1(2147483647, 0),
    /**
     * 月割終了年月1
     */
    tsukiwariEndYM1(2147483647, 0),
    /**
     * 保険料算定段階2
     * <br/>内部コードで管理
     */
    hokenryoDankai2(3, 0),
    /**
     * 算定年額保険料2
     */
    nengakuHokenryo2(7, 0),
    /**
     * 月割開始年月2
     */
    tsukiwariStartYM2(2147483647, 0),
    /**
     * 月割終了年月2
     */
    tsukiwariEndYM2(2147483647, 0),
    /**
     * 調定日時
     */
    choteiTimestamp(2147483647, 0),
    /**
     * 調定事由1
     */
    choteiJiyu1(2, 0),
    /**
     * 調定事由2
     */
    choteiJiyu2(2, 0),
    /**
     * 調定事由3
     */
    choteiJiyu3(2, 0),
    /**
     * 調定事由4
     */
    choteiJiyu4(2, 0),
    /**
     * 更正月
     */
    koseiM(2, 0),
    /**
     * 減免前介護保険料（年額）
     */
    gemmenMaeHokenryo(7, 0),
    /**
     * 減免額
     */
    gemmenGaku(7, 0),
    /**
     * 確定介護保険料（年額）
     */
    kakuteiHokenryo(7, 0),
    /**
     * 保険料段階（仮算定時）
     * <br/>内部コードで管理
     */
    hokenryoDankaiKarisanntei(3, 0),
    /**
     * 徴収方法履歴番号
     */
    choshuHohoRirekiNo(5, 0),
    /**
     * 異動基準日時
     */
    idoKijunTimestamp(2147483647, 0),
    /**
     * 口座区分
     * <br/>1：該当　0:非該当
     */
    kozaKubun(1, 0),
    /**
     * 境界層区分
     * <br/>1：該当　0:非該当
     */
    kyokaisoKubun(1, 0),
    /**
     * 職権区分
     * <br/>1：該当　0:非該当
     */
    shokkenKubun(1, 0),
    /**
     * 賦課市町村コード
     */
    fukaShichosonCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2002Fuka(int maxLength, int scale) {
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
