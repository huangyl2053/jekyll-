package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 合併市町村テーブルの項目定義クラスです。
 */
public enum DbT7056GappeiShichoson implements IColumnDefinition {
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
     * 合併年月日
     */
    gappeiYMD(2147483647, 0),
    /**
     * 地域番号
     */
    chiikiNo(2, 0),
    /**
     * 旧市町村コード
     */
    kyuShichosonCode(2147483647, 0),
    /**
     * 運用開始年月日
     */
    unyoKaishiYMD(2147483647, 0),
    /**
     * 運用終了年月日
     */
    unyoShuryoYMD(2147483647, 0),
    /**
     * 旧保険者番号
     */
    kyuHokenshaNo(2147483647, 0),
    /**
     * 旧市町村名称
     */
    kyuShichosonMeisho(10, 0),
    /**
     * 都道府県名称
     */
    todofukenMeisho(4, 0),
    /**
     * 郡名称
     */
    gunMeisho(8, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * 老人保健市町村番号
     */
    rojinhokenShichosonNo(8, 0),
    /**
     * 老人保健受給者番号体系
     * <br/>1:住民コード 2:医療給付サブシステム 3:市町村独自
     */
    rokenJukyushaNoTaikei(1, 0),
    /**
     * 表示有無
     * <br/>1:表示対象とする 0:表示対象としない
     */
    hyojiUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7056GappeiShichoson(int maxLength, int scale) {
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
