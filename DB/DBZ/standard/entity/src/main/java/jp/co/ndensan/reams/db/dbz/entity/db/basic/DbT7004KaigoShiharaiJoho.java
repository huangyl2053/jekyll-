package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7004KaigoShiharaiJohoの項目定義クラスです
 *
 */
public enum DbT7004KaigoShiharaiJoho implements IColumnDefinition {
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
     * 識別コード
     * <br/>口座ＤＢ上の識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 科目コード
     * <br/>支払単位の科目：高額サ・福祉用具・住宅改修など
     */
    kamokuCode(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 支払方法区分
     * <br/>窓口・口座
     */
    shiharaiHohoKubun(1, 0),
    /**
     * 窓口支払場所コード
     * <br/>各市町村の窓口
     */
    madoguchiShiharaiBashoCode(2147483647, 0),
    /**
     * 窓口支払開始年月日時分
     */
    madoguchiShiharaiKaishiYMDHM(2147483647, 0),
    /**
     * 窓口支払終了年月日時分
     */
    madoguchiShiharaiShuryoYMDHM(2147483647, 0),
    /**
     * 振込予定年月日
     */
    furikomiYoteiYMD(2147483647, 0),
    /**
     * 支払金額
     */
    shiharaiKingaku(10, 0),
    /**
     * 種別コード
     */
    syubetsuCode(2147483647, 0),
    /**
     * 用途区分コード
     */
    yotoKubunCode(2147483647, 0),
    /**
     * 認証日１
     */
    ninshoYMD1(2147483647, 0),
    /**
     * 認証者コード１
     */
    ninshoshaCode1(2147483647, 0),
    /**
     * 認証日２
     */
    ninshoYMD2(2147483647, 0),
    /**
     * 認証者コード２
     */
    ninshoshaCode2(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7004KaigoShiharaiJoho(int maxLength, int scale) {
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
