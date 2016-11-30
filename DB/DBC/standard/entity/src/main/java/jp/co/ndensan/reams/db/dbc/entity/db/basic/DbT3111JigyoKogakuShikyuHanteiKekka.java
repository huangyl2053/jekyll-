package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額介護サービス費支給判定結果テーブルの項目定義クラスです。
 */
public enum DbT3111JigyoKogakuShikyuHanteiKekka implements IColumnDefinition {
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
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 本人支払額
     */
    honninShiharaiGaku(6, 0),
    /**
     * 支給区分コード
     * <br/>1:支給,2:不支給
     */
    shiharaiKubunCode(1, 0),
    /**
     * 支給金額
     */
    shiharaiKingaku(6, 0),
    /**
     * 不支給理由
     */
    fushikyuRiyu(80, 0),
    /**
     * 審査方法区分
     */
    shinsaHohoKubun(1, 0),
    /**
     * 判定結果送付年月
     */
    hanteiKekkaSofuYM(2147483647, 0),
    /**
     * 再送付フラグ
     * <br/>True:する,False:しない
     */
    saiSofuFlag(1, 0),
    /**
     * 判定結果送付不要フラグ
     * <br/>True:送付不要,False:送付必要
     */
    hanteiKekkaSofuFuyoFlag(1, 0),
    /**
     * 審査結果反映区分
     * <br/>0:審査結果未反映,1:審査結果反映済,2:審査結果不要
     */
    shinsaKekkaHaneiKubun(1, 0),
    /**
     * 決定通知書作成年月日
     */
    ketteiTsuchishoSakuseiYMD(2147483647, 0),
    /**
     * 振込明細書作成年月日
     */
    furikomiMeisaishoSakuseiYMD(2147483647, 0),
    /**
     * 決定通知リアル発行区分
     */
    ketteiTsuchiHakkoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3111JigyoKogakuShikyuHanteiKekka(int maxLength, int scale) {
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
