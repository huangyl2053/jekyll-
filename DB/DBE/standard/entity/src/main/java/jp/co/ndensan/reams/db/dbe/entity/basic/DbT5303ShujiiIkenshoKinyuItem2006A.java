package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定主治医意見書記入項目2006Aテーブルの項目定義クラスです。
 */
public enum DbT5303ShujiiIkenshoKinyuItem2006A implements IColumnDefinition {
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
     * 主治医意見書作成依頼履歴番号
     * <br/>主治医意見書作成依頼情報
     */
    ikenshoIraiRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 意見書・診断名1
     */
    shindamMei1(40, 0),
    /**
     * 意見書・発症年月日1
     */
    hasshoYMD1(2147483647, 0),
    /**
     * 意見書・診断名2
     */
    shindamMei2(40, 0),
    /**
     * 意見書・発症年月日2
     */
    hasshoYMD2(2147483647, 0),
    /**
     * 意見書・診断名3
     */
    shindamMei3(40, 0),
    /**
     * 意見書・発症年月日3
     */
    hasshoYMD3(2147483647, 0),
    /**
     * 意見書・症状としての安定性
     * <br/>Enum（DBE：意見書・症状としての安定性）
     */
    anteisei(1, 0),
    /**
     * 記入項目01
     */
    kinyuItem01(2147483647, 0),
    /**
     * 記入項目02
     */
    kinyuItem02(2147483647, 0),
    /**
     * 記入項目03
     */
    kinyuItem03(2147483647, 0),
    /**
     * 記入項目04
     */
    kinyuItem04(2147483647, 0),
    /**
     * 記入項目05
     */
    kinyuItem05(2147483647, 0),
    /**
     * 記入項目06
     */
    kinyuItem06(2147483647, 0),
    /**
     * 記入項目07
     */
    kinyuItem07(2147483647, 0),
    /**
     * 記入項目08
     */
    kinyuItem08(2147483647, 0),
    /**
     * 記入項目09
     */
    kinyuItem09(2147483647, 0),
    /**
     * 記入項目10
     */
    kinyuItem10(2147483647, 0),
    /**
     * 記入項目11
     */
    kinyuItem11(2147483647, 0),
    /**
     * 記入項目12
     */
    kinyuItem12(2147483647, 0),
    /**
     * 記入項目13
     */
    kinyuItem13(2147483647, 0),
    /**
     * 記入項目14
     */
    kinyuItem14(2147483647, 0),
    /**
     * 記入項目15
     */
    kinyuItem15(2147483647, 0),
    /**
     * 記入項目16
     */
    kinyuItem16(2147483647, 0),
    /**
     * 記入項目17
     */
    kinyuItem17(2147483647, 0),
    /**
     * 記入項目18
     */
    kinyuItem18(2147483647, 0),
    /**
     * 記入項目19
     */
    kinyuItem19(2147483647, 0),
    /**
     * 記入項目10
     */
    kinyuItem20(2147483647, 0),
    /**
     * 記入項目21
     */
    kinyuItem21(2147483647, 0),
    /**
     * 記入項目22
     */
    kinyuItem22(2147483647, 0),
    /**
     * 記入項目23
     */
    kinyuItem23(2147483647, 0),
    /**
     * 記入項目24
     */
    kinyuItem24(2147483647, 0),
    /**
     * 記入項目25
     */
    kinyuItem25(2147483647, 0),
    /**
     * 記入項目26
     */
    kinyuItem26(2147483647, 0),
    /**
     * 記入項目27
     */
    kinyuItem27(2147483647, 0),
    /**
     * 記入項目28
     */
    kinyuItem28(2147483647, 0),
    /**
     * 記入項目29
     */
    kinyuItem29(2147483647, 0),
    /**
     * 記入項目30
     */
    kinyuItem30(2147483647, 0),
    /**
     * 特記事項
     */
    tokkiJiko(2147483647, 0),
    /**
     * 記入項目01イメージ共有ファイルID
     */
    kinyuItem01ImageSharedFileId(29, 0),
    /**
     * 記入項目02イメージ共有ファイルID
     */
    kinyuItem02ImageSharedFileId(29, 0),
    /**
     * 記入項目03イメージ共有ファイルID
     */
    kinyuItem03ImageSharedFileId(29, 0),
    /**
     * 記入項目04イメージ共有ファイルID
     */
    kinyuItem04ImageSharedFileId(29, 0),
    /**
     * 記入項目05イメージ共有ファイルID
     */
    kinyuItem05ImageSharedFileId(29, 0),
    /**
     * 記入項目06イメージ共有ファイルID
     */
    kinyuItem06ImageSharedFileId(29, 0),
    /**
     * 記入項目07イメージ共有ファイルID
     */
    kinyuItem07ImageSharedFileId(29, 0),
    /**
     * 記入項目08イメージ共有ファイルID
     */
    kinyuItem08ImageSharedFileId(29, 0),
    /**
     * 記入項目09イメージ共有ファイルID
     */
    kinyuItem09ImageSharedFileId(29, 0),
    /**
     * 記入項目10イメージ共有ファイルID
     */
    kinyuItem10ImageSharedFileId(29, 0),
    /**
     * 記入項目11イメージ共有ファイルID
     */
    kinyuItem11ImageSharedFileId(29, 0),
    /**
     * 記入項目12イメージ共有ファイルID
     */
    kinyuItem12ImageSharedFileId(29, 0),
    /**
     * 記入項目13イメージ共有ファイルID
     */
    kinyuItem13ImageSharedFileId(29, 0),
    /**
     * 記入項目14イメージ共有ファイルID
     */
    kinyuItem14ImageSharedFileId(29, 0),
    /**
     * 記入項目15イメージ共有ファイルID
     */
    kinyuItem15ImageSharedFileId(29, 0),
    /**
     * 記入項目16イメージ共有ファイルID
     */
    kinyuItem16ImageSharedFileId(29, 0),
    /**
     * 記入項目17イメージ共有ファイルID
     */
    kinyuItem17ImageSharedFileId(29, 0),
    /**
     * 記入項目18イメージ共有ファイルID
     */
    kinyuItem18ImageSharedFileId(29, 0),
    /**
     * 記入項目19イメージ共有ファイルID
     */
    kinyuItem19ImageSharedFileId(29, 0),
    /**
     * 記入項目20イメージ共有ファイルID
     */
    kinyuItem20ImageSharedFileId(29, 0),
    /**
     * 記入項目21イメージ共有ファイルID
     */
    kinyuItem21ImageSharedFileId(29, 0),
    /**
     * 記入項目22イメージ共有ファイルID
     */
    kinyuItem22ImageSharedFileId(29, 0),
    /**
     * 記入項目23イメージ共有ファイルID
     */
    kinyuItem23ImageSharedFileId(29, 0),
    /**
     * 記入項目24イメージ共有ファイルID
     */
    kinyuItem24ImageSharedFileId(29, 0),
    /**
     * 記入項目25イメージ共有ファイルID
     */
    kinyuItem25ImageSharedFileId(29, 0),
    /**
     * 記入項目26イメージ共有ファイルID
     */
    kinyuItem26ImageSharedFileId(29, 0),
    /**
     * 記入項目27イメージ共有ファイルID
     */
    kinyuItem27ImageSharedFileId(29, 0),
    /**
     * 記入項目28イメージ共有ファイルID
     */
    kinyuItem28ImageSharedFileId(29, 0),
    /**
     * 記入項目29イメージ共有ファイルID
     */
    kinyuItem29ImageSharedFileId(29, 0),
    /**
     * 記入項目30イメージ共有ファイルID
     */
    kinyuItem30ImageSharedFileId(29, 0),
    /**
     * 特記事項イメージ共有ファイルID
     */
    tokkiJikoImageSharedFileId(29, 0);

    private final int maxLength;
    private final int scale;

    private DbT5303ShujiiIkenshoKinyuItem2006A(int maxLength, int scale) {
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
