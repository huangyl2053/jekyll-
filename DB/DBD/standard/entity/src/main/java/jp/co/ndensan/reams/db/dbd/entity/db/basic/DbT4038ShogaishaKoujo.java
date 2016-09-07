package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 障がい書控除テーブルの項目定義クラスです。
 */
public enum DbT4038ShogaishaKoujo implements IColumnDefinition {
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
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * 決定区分
     */
    ketteiKubun(1, 0),
    /**
     * 非承認理由
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
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 基準日
     */
    kijunYMD(2147483647, 0),
    /**
     * 把握日
     */
    haakuYMD(2147483647, 0),
    /**
     * 申請事由
     */
    shinseiJiyu(200, 0),
    /**
     * 認定区分
     * <br/>DBDEnum.障がい者控除認定区分
     */
    ninteiKubun(1, 0),
    /**
     * 認定内容
     * <br/>'DBDEnum.障がい者控除認定内容
     */
    ninteiNaiyo(1, 0),
    /**
     * 給付率
     */
    kyufuritsu(2147483647, 0),
    /**
     * 認知症高齢者の日常生活自立度コード
     * <br/>DBZEnum.認知症高齢者自立度コード
     */
    ninchishoNichijoSeikatsuJiritsudoCode(2147483647, 0),
    /**
     * 障がい高齢者の日常生活自立度コード
     * <br/>DBZEnum.障害高齢者自立度コード
     */
    shogaiNichijoSeikatsuJiritsudoCode(2147483647, 0),
    /**
     * 障がい者手帳有無
     * <br/>false：障がい者手帳なし、true：障がい者手帳あり
     */
    shogaishaTechoUmu(1, 0),
    /**
     * 資格喪失事由コード
     */
    shikakuSoshitsuJiyuCode(2, 0),
    /**
     * 資格喪失年月日
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 認定証発行対象外フラグ
     * <br/>true：認定証一括発行対象外
     */
    ninteishoHakkoTaishogai(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4038ShogaishaKoujo(int maxLength, int scale) {
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
