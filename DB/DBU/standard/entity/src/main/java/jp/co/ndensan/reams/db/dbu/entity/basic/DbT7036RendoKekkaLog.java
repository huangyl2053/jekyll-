package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 連動結果ログテーブルの項目定義クラスです。
 */
public enum DbT7036RendoKekkaLog implements IColumnDefinition {
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
     * 処理番号
     */
    shoriNo(18, 0),
    /**
     * 種別
     */
    shubetsu(2, 0),
    /**
     * 処理ＩＤ
     */
    shoriID(9, 0),
    /**
     * 送信元市町村コード
     */
    motoShichosonCode(2147483647, 0),
    /**
     * 送信先市町村コード
     */
    sakiShichosonCode(2147483647, 0),
    /**
     * 結果区分
     */
    kekkaKubun(1, 0),
    /**
     * 確認区分
     */
    kakuninKubun(1, 0),
    /**
     * 処理開始時刻
     */
    ShoriKaishiTimestamp(2147483647, 0),
    /**
     * 処理終了時刻
     */
    shoriShuryoTimestamp(2147483647, 0),
    /**
     * ログファイル名
     */
    logFileMei(64, 0),
    /**
     * 表示用条件
     */
    hyojiJoken(120, 0),
    /**
     * メッセージ
     */
    messeage(200, 0),
    /**
     * 連動形態
     */
    rendoKeitai(2, 0),
    /**
     * UL・受信結果区分
     */
    upLoad_JushinKekkaKubun(1, 0),
    /**
     * UL・文字コード変換結果区分
     */
    upLoad_MojiCodeHenkanKekkaKubun(1, 0),
    /**
     * UL・処理１結果区分
     */
    upLoad_Shori1KekkaKubun(1, 0),
    /**
     * UL・処理２結果区分
     */
    upLoad_Shori2kekkaKubun(1, 0),
    /**
     * UL・処理３結果区分
     */
    upLoad_Shori3KekkaKubun(1, 0),
    /**
     * DL・処理１結果区分
     */
    downLoad_Shori1KekkaKubun(1, 0),
    /**
     * DL・コード変換結果区分
     */
    downLoad_CodeHenkanKekkaKubun(1, 0),
    /**
     * DL・文字コード変換結果区分
     */
    downLoad_MojiCodeHenkanKekkaKubun(1, 0),
    /**
     * DL・送信１結果区分
     */
    downLoad_Soshin1KekkaKubun(1, 0),
    /**
     * DL・処理２結果区分
     */
    downLoad_shori2KekkaKubun(1, 0),
    /**
     * DL・受信１結果区分
     */
    downLoad_Jushon1KekkaKubun(1, 0),
    /**
     * 処理メッセージ１
     */
    shoriMessage1(100, 0),
    /**
     * 処理メッセージ２
     */
    shoriMessage2(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT7036RendoKekkaLog(int maxLength, int scale) {
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
