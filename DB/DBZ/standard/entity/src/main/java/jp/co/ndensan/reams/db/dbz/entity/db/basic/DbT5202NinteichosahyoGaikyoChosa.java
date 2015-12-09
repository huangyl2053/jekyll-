package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（概況調査）（子）テーブルの項目定義クラスです。
 */
public enum DbT5202NinteichosahyoGaikyoChosa implements IColumnDefinition {
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 認定調査依頼履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 認定調査依頼区分コード
     * <br/>Enum（DBE：認定調査依頼区分コード）
     */
    ninteichousaIraiKubunCode(2147483647, 0),
    /**
     * 認定調査回数
     */
    ninteichosaIraiKaisu(5, 0),
    /**
     * 認定調査実施年月日
     */
    ninteichosaJisshiYMD(2147483647, 0),
    /**
     * 認定調査受領年月日
     */
    ninteichosaJuryoYMD(2147483647, 0),
    /**
     * 調査委託区分コード
     * <br/>Enum（DBE：調査委託区分）
     */
    chosaItakuKubunCode(2147483647, 0),
    /**
     * 認定調査区分コード
     * <br/>Enum（DBE：調査区分）
     */
    ninteiChosaKubunCode(2147483647, 0),
    /**
     * 認定調査委託先コード
     * <br/>認定調査委託先情報
     */
    chosaItakusakiCode(2147483647, 0),
    /**
     * 認定調査員コード
     * <br/>認定調査員情報
     */
    chosainCode(8, 0),
    /**
     * 認定調査実施場所コード
     * <br/>Enum（DBE：調査実施場所コード）
     */
    chosaJisshiBashoCode(2147483647, 0),
    /**
     * 認定調査実施場所名称
     */
    chosaJisshiBashoMeisho(32, 0),
    /**
     * 実施場所イメージ共有ファイルID
     */
    jisshiBashoImageSharedFileId(29, 0),
    /**
     * 認定調査・サービス区分コード
     * <br/>Enum（DBE：現在のサービス区分コード）
     */
    serviceKubunCode(2147483647, 0),
    /**
     * 利用施設名
     */
    riyoShisetsuShimei(80, 0),
    /**
     * 利用施設住所
     */
    riyoShisetsuJusho(2147483647, 0),
    /**
     * 利用施設電話番号
     */
    riyoShisetsuTelNo(2147483647, 0),
    /**
     * 利用施設郵便番号
     */
    riyoShisetsuYubinNo(2147483647, 0),
    /**
     * 利用施設名イメージ共有ファイルID
     */
    riyoShisetsuNameImageSharedFileId(29, 0),
    /**
     * 利用施設住所イメージ共有ファイルID
     */
    riyoShisetsuJushoImageSharedFileId(29, 0),
    /**
     * 利用施設電話番号イメージ共有ファイルID
     */
    riyoShisetsuTelNoImageSharedFileId(29, 0),
    /**
     * 特記
     */
    tokki(2147483647, 0),
    /**
     * 特記イメージ共有ファイルID
     */
    tokkiImageSharedFileId(29, 0),
    /**
     * 認定調査特記事項受付年月日
     */
    tokkijikoUketsukeYMD(2147483647, 0),
    /**
     * 認定調査特記事項受領年月日
     */
    tokkijikoJuryoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5202NinteichosahyoGaikyoChosa(int maxLength, int scale) {
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
