package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 不服審査申立情報テーブルの項目定義クラスです。
 * <br/> 不服申立情報を管理する
 */
public enum DbT7001FufukuMoshitate implements IColumnDefinition {
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
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 原処分被保険者番号
     */
    genshobunsHihokennshaNo(2147483647, 0),
    /**
     * 審査請求届出日
     */
    shinsaSeikyuTodokedeYMD(2147483647, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 審査請求人郵便番号
     */
    shinsaSeikyuninYubinNo(2147483647, 0),
    /**
     * 審査請求人住所
     */
    shinsaSeikyuninJusho(2147483647, 0),
    /**
     * 審査請求人氏名
     */
    shinsaSeikyuninShimei(2147483647, 0),
    /**
     * 審査請求人電話番号
     */
    shinsaSeikyuninTelNo(2147483647, 0),
    /**
     * 被保険者との関係コード
     */
    hihokenshaTonoKankeiCode(1, 0),
    /**
     * 被保険者との関係
     */
    hihokenshaTonoKankei(20, 0),
    /**
     * 代理人郵便番号
     */
    dairininYubinNo(2147483647, 0),
    /**
     * 代理人住所
     */
    dairininJusho(2147483647, 0),
    /**
     * 代理人氏名
     */
    dairininShimei(2147483647, 0),
    /**
     * 代理人電話番号
     */
    dairininTelNo(2147483647, 0),
    /**
     * 処分庁
     */
    shobunCho(80, 0),
    /**
     * 処分日
     */
    shobunYMD(2147483647, 0),
    /**
     * 処分種類コード
     */
    shobunShuruiCode(2, 0),
    /**
     * 処分があったことを知った日
     */
    shobunKakuninYMD(2147483647, 0),
    /**
     * 審査請求の理由
     */
    shinsaSeikyuRiyu(2147483647, 0),
    /**
     * 処分庁教示の有無及び教示の内容
     */
    shobunChoKyojiNaiyo(2147483647, 0),
    /**
     * 添付書類等
     */
    tempuShoruiTo(1, 0),
    /**
     * 審査請求取下日
     */
    shinsaSeikyuTorisageYMD(2147483647, 0),
    /**
     * 弁明書登録フラグ
     */
    bemmeishoTorokuFlag(1, 0),
    /**
     * 弁明書作成日
     */
    bemmeishoSakuseiYMD(2147483647, 0),
    /**
     * 裁決日
     */
    saiketsuYMD(2147483647, 0),
    /**
     * 裁決結果
     */
    saiketsuKekka(2147483647, 0),
    /**
     * 裁決理由
     */
    saiketsuRiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7001FufukuMoshitate(int maxLength, int scale) {
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
