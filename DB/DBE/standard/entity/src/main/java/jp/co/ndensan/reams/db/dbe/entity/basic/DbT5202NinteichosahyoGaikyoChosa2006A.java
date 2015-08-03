package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（概況調査）2006Aテーブルの項目定義クラスです。
 */
public enum DbT5202NinteichosahyoGaikyoChosa2006A implements IColumnDefinition {
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
     * 認定調査・現在の状況コード
     * <br/>Enum（DBE：現在の状況コード）
     */
    genzainoJokyoCode(2147483647, 0),
    /**
     * 認定調査・サービス区分コード
     * <br/>Enum（DBE：現在のサービス区分コード）
     */
    serviceKubunCode(2147483647, 0),
    /**
     * サービスの状況01
     */
    serviceJokyo01(5, 0),
    /**
     * サービスの状況02
     */
    serviceJokyo02(5, 0),
    /**
     * サービスの状況03
     */
    serviceJokyo03(5, 0),
    /**
     * サービスの状況04
     */
    serviceJokyo04(5, 0),
    /**
     * サービスの状況05
     */
    serviceJokyo05(5, 0),
    /**
     * サービスの状況06
     */
    serviceJokyo06(5, 0),
    /**
     * サービスの状況07
     */
    serviceJokyo07(5, 0),
    /**
     * サービスの状況08
     */
    serviceJokyo08(5, 0),
    /**
     * サービスの状況09
     */
    serviceJokyo09(5, 0),
    /**
     * サービスの状況10
     */
    serviceJokyo10(5, 0),
    /**
     * サービスの状況11
     */
    serviceJokyo11(5, 0),
    /**
     * サービスの状況12
     */
    serviceJokyo12(5, 0),
    /**
     * サービスの状況13
     */
    serviceJokyo13(5, 0),
    /**
     * サービスの状況14
     */
    serviceJokyo14(5, 0),
    /**
     * サービスの状況15
     */
    serviceJokyo15(5, 0),
    /**
     * サービスの状況16
     */
    serviceJokyo16(5, 0),
    /**
     * サービスの状況17
     */
    serviceJokyo17(5, 0),
    /**
     * サービスの状況18
     */
    serviceJokyo18(5, 0),
    /**
     * サービスの状況19
     */
    serviceJokyo19(5, 0),
    /**
     * サービスの状況20
     */
    serviceJokyo20(5, 0),
    /**
     * サービスの状況21
     */
    serviceJokyo21(5, 0),
    /**
     * サービスの状況22
     */
    serviceJokyo22(5, 0),
    /**
     * サービスの状況23
     */
    serviceJokyo23(5, 0),
    /**
     * サービスの状況24
     */
    serviceJokyo24(5, 0),
    /**
     * サービスの状況25
     */
    serviceJokyo25(5, 0),
    /**
     * サービスの状況26
     */
    serviceJokyo26(5, 0),
    /**
     * サービスの状況27
     */
    serviceJokyo27(5, 0),
    /**
     * サービスの状況28
     */
    serviceJokyo28(5, 0),
    /**
     * サービスの状況29
     */
    serviceJokyo29(5, 0),
    /**
     * サービスの状況30
     */
    serviceJokyo30(5, 0),
    /**
     * サービスの状況フラグ01
     * <br/>Enum（DBE：住宅改修）参考です。
     */
    serviceJokyoFlag01(1, 0),
    /**
     * サービスの状況フラグ02
     */
    serviceJokyoFlag02(1, 0),
    /**
     * サービスの状況フラグ03
     */
    serviceJokyoFlag03(1, 0),
    /**
     * サービスの状況フラグ04
     */
    serviceJokyoFlag04(1, 0),
    /**
     * サービスの状況フラグ05
     */
    serviceJokyoFlag05(1, 0),
    /**
     * サービスの状況フラグ06
     */
    serviceJokyoFlag06(1, 0),
    /**
     * サービスの状況フラグ07
     */
    serviceJokyoFlag07(1, 0),
    /**
     * サービスの状況フラグ08
     */
    serviceJokyoFlag08(1, 0),
    /**
     * サービスの状況フラグ09
     */
    serviceJokyoFlag09(1, 0),
    /**
     * サービスの状況フラグ10
     */
    serviceJokyoFlag10(1, 0),
    /**
     * サービスの状況記入01
     * <br/>市町村特別給付
     */
    serviceJokyoKinyu01(2147483647, 0),
    /**
     * サービスの状況記入02
     * <br/>介護保険給付外の在宅サービス
     */
    serviceJokyoKinyu02(2147483647, 0),
    /**
     * サービスの状況記入03
     */
    serviceJokyoKinyu03(2147483647, 0),
    /**
     * サービスの状況記入04
     */
    serviceJokyoKinyu04(2147483647, 0),
    /**
     * サービスの状況記入05
     */
    serviceJokyoKinyu05(2147483647, 0),
    /**
     * サービスの状況記入06
     */
    serviceJokyoKinyu06(2147483647, 0),
    /**
     * サービスの状況記入07
     */
    serviceJokyoKinyu07(2147483647, 0),
    /**
     * サービスの状況記入08
     */
    serviceJokyoKinyu08(2147483647, 0),
    /**
     * サービスの状況記入09
     */
    serviceJokyoKinyu09(2147483647, 0),
    /**
     * サービスの状況記入10
     */
    serviceJokyoKinyu10(2147483647, 0),
    /**
     * サービスの状況イメージ共有ファイルID01
     * <br/>市町村特別給付
     */
    serviceJokyoImageSharedFileId01(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID02
     * <br/>介護保険給付外の在宅サービス
     */
    serviceJokyoImageSharedFileId02(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID03
     */
    serviceJokyoImageSharedFileId03(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID04
     */
    serviceJokyoImageSharedFileId04(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID05
     */
    serviceJokyoImageSharedFileId05(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID06
     */
    serviceJokyoImageSharedFileId06(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID07
     */
    serviceJokyoImageSharedFileId07(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID08
     */
    serviceJokyoImageSharedFileId08(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID09
     */
    serviceJokyoImageSharedFileId09(29, 0),
    /**
     * サービスの状況イメージ共有ファイルID10
     */
    serviceJokyoImageSharedFileId10(29, 0),
    /**
     * 施設利用01
     */
    shisetsuRiyo01(1, 0),
    /**
     * 施設利用02
     */
    shisetsuRiyo02(1, 0),
    /**
     * 施設利用03
     */
    shisetsuRiyo03(1, 0),
    /**
     * 施設利用04
     */
    shisetsuRiyo04(1, 0),
    /**
     * 施設利用05
     */
    shisetsuRiyo05(1, 0),
    /**
     * 施設利用06
     */
    shisetsuRiyo06(1, 0),
    /**
     * 施設利用07
     */
    shisetsuRiyo07(1, 0),
    /**
     * 施設利用08
     */
    shisetsuRiyo08(1, 0),
    /**
     * 施設利用09
     */
    shisetsuRiyo09(1, 0),
    /**
     * 施設利用10
     */
    shisetsuRiyo10(1, 0),
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

    private DbT5202NinteichosahyoGaikyoChosa2006A(int maxLength, int scale) {
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
