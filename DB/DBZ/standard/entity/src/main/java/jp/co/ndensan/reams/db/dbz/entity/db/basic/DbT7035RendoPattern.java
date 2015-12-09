package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 連動パターンテーブルの項目定義クラスです。
 */
public enum DbT7035RendoPattern implements IColumnDefinition {
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
     * 送信元市町村コード
     */
    motoShichosonCode(2147483647, 0),
    /**
     * 送信先市町村コード
     */
    sakiShichosonCode(2147483647, 0),
    /**
     * 種別
     */
    shubetsu(2, 0),
    /**
     * 有効開始年月日
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * 有効終了年月日
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * 連動形態コード
     */
    rendoKeitaiCode(2, 0),
    /**
     * 送信元フォーマットバージョン
     */
    motoFormatVersion(20, 0),
    /**
     * 送信元エンコーディング
     */
    motoEncodeKeitai(20, 0),
    /**
     * 送信先フォーマットバージョン
     */
    sakiFormatVersion(20, 0),
    /**
     * 送信先エンコーディング
     */
    sakiEncodeKeitai(20, 0),
    /**
     * コード変換区分
     */
    codeHenkanKubun(1, 0),
    /**
     * 外字変換区分
     */
    gaijiHenkanKubun(1, 0),
    /**
     * 全件連動区分
     */
    zenkenRendoKubun(1, 0),
    /**
     * 連携区分
     */
    rendoKubun(1, 0),
    /**
     * 連携ファイル名
     * <br/>連携するファイル名称を拡張子付きで定義する。
     * <br/>編集書式：
     * <br/> @日時@　・・・ 年月日時分秒（14桁）
     * <br/> @市町村コード@　・・・　市町村コード（6桁）
     */
    renkeiFileName(128, 0);

    private final int maxLength;
    private final int scale;

    private DbT7035RendoPattern(int maxLength, int scale) {
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
