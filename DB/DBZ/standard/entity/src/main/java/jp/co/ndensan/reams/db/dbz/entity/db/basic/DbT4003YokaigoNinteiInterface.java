package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定インターフェース情報テーブルの項目定義クラスです。
 */
public enum DbT4003YokaigoNinteiInterface implements IColumnDefinition {
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
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(4, 0),
    /**
     * 取込日時
     */
    torikomiTimestamp(2147483647, 0),
    /**
     * 取込区分
     */
    torikomiKubun(1, 0),
    /**
     * 申請種別コード
     */
    shinseiShubetsuCode(1, 0),
    /**
     * 取下区分コード
     */
    torisageKubunCode(1, 0),
    /**
     * 認定申請日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 医療機関コード
     */
    iryoKikanCode(10, 0),
    /**
     * 主治医コード
     */
    shujiiCode(8, 0),
    /**
     * 意見書依頼年月日
     */
    ikenshoIraiYMD(2147483647, 0),
    /**
     * 意見書取寄せ年月日
     */
    ikenshoToriyoseYMD(2147483647, 0),
    /**
     * 調査委託年月日
     */
    chosaItakuYMD(2147483647, 0),
    /**
     * 調査終了年月日
     */
    chosaShuryoYMD(2147483647, 0),
    /**
     * 調査委託先コード
     */
    chosaItakusakiCode(2147483647, 0),
    /**
     * 調査員コード
     */
    chosainCode(8, 0),
    /**
     * 一次判定日
     */
    ichijiHanteiYMD(2147483647, 0),
    /**
     * 一次判定結果
     */
    ichijiHanteiKekkaCode(2, 0),
    /**
     * 一次判定結果（認知症加算）
     */
    ichijiHanteiKekkaKasanCode(2, 0),
    /**
     * 審査会資料作成年月日
     */
    shinsakaiShiryoSakuseiYMD(2147483647, 0),
    /**
     * 審査会予定年月日
     */
    shinsakaiYoteiYMD(2147483647, 0),
    /**
     * 合議体番号
     */
    gogitaiNo(5, 0),
    /**
     * 二次判定日
     */
    nijiHanteiYMD(2147483647, 0),
    /**
     * 二次判定結果
     */
    nijiHanteiKekkaCode(2, 0),
    /**
     * 認定有効開始年月日
     */
    ninteiYukoKikanStart(2147483647, 0),
    /**
     * 認定有効終了年月日
     */
    ninteiYukoKikanEnd(2147483647, 0),
    /**
     * サービス変更理由コード
     */
    serviceHenkoRiyuCode(2, 0),
    /**
     * 特定疾病コード
     */
    tokuteiShippeiCode(2, 0),
    /**
     * 障害高齢者自立度
     */
    shogaiKoreiJiritsudo(1, 0),
    /**
     * 認知症高齢者自立度
     */
    ninchishoKoreiJiritsudo(1, 0),
    /**
     * 審査会意見
     */
    shinsakaiIken(400, 0),
    /**
     * 版番号
     */
    versionNo(3, 0),
    /**
     * 一次判定内容
     */
    ichijiHanteiNaiyo(2000, 0),
    /**
     * 一次判定内容２
     */
    ichijiHanteiNaiyo2(2000, 0),
    /**
     * 前回取込日時
     */
    zenTorikomiTimestamp(2147483647, 0),
    /**
     * 消し込みフラグ
     */
    keshikomiFlag(1, 0),
    /**
     * 消し込み日時
     */
    keshikomiTimestamp(2147483647, 0),
    /**
     * 予備項目１
     * <br/>未使用
     */
    yobiKomoku1(12, 0),
    /**
     * 予備項目２
     * <br/>未使用
     */
    yobiKomoku2(12, 0),
    /**
     * 予備項目３
     * <br/>未使用
     */
    yobiKomoku3(12, 0),
    /**
     * 予備項目４
     * <br/>未使用
     */
    yobiKomoku4(12, 0),
    /**
     * 予備項目５
     * <br/>未使用
     */
    yobiKomoku5(12, 0),
    /**
     * 予備区分１
     * <br/>未使用
     */
    yobiKubun1(4, 0),
    /**
     * 予備区分２
     * <br/>未使用
     */
    yobiKubun2(2, 0),
    /**
     * 予備区分３
     * <br/>未使用
     */
    yobiKubun3(2, 0),
    /**
     * 予備区分４
     * <br/>申請区分（法令）コード
     */
    yobiKubun4(1, 0),
    /**
     * 予備区分５
     * <br/>未使用
     */
    yobiKubun5(1, 0),
    /**
     * リザーブ
     * <br/>未使用
     */
    reserve(200, 0);

    private final int maxLength;
    private final int scale;

    private DbT4003YokaigoNinteiInterface(int maxLength, int scale) {
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
