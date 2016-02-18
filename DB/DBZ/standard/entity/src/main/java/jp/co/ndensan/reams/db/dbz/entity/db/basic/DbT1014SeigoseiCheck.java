package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 整合性チェック情報テーブルの項目定義クラスです。
 * <br/> 整合性チェックで不整合となった住登内情報と介護資格情報を管理する。
 */
public enum DbT1014SeigoseiCheck implements IColumnDefinition {
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
     * 対象外フラグ
     * <br/>True：対象外である
     */
    taishogaiFlag(1, 0),
    /**
     * 不整合理由コード
     * <br/>DBZ.Enum不整合理由
     */
    fuseigoRiyuCode(2, 0),
    /**
     * 登録日時
     */
    torokuTimestamp(2147483647, 0),
    /**
     * 履歴番号
     */
    rierkiNo(5, 0),
    /**
     * 異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 届出年月日
     */
    todokedeYMD(2147483647, 0),
    /**
     * 異動事由コード
     */
    idoJiyuCode(2, 0),
    /**
     * 処理事由コード
     */
    shoriJiyuCode(2, 0),
    /**
     * 処理年月日
     */
    shoriYMD(2147483647, 0),
    /**
     * 住民種別コード
     */
    juminShubetsuCode(1, 0),
    /**
     * 住民状態コード
     */
    juminJotaiCode(1, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 登録事由コード
     */
    torokuJiyuCode(2, 0),
    /**
     * 登録異動年月日
     */
    torokuIdoYMD(2147483647, 0),
    /**
     * 登録届出年月日
     */
    torokuTodokedeYMD(2147483647, 0),
    /**
     * 消除事由コード
     */
    shojoJiyuCode(2, 0),
    /**
     * 消除異動年月日
     */
    shojoIdoYMD(2147483647, 0),
    /**
     * 消除届出年月日
     */
    shojoTodokedeYMD(2147483647, 0),
    /**
     * 消除通知フラグ
     */
    shojoTsuchiFlag(1, 0),
    /**
     * 転出予定異動年月日
     */
    tenshutsuYoteiIdoYMD(2147483647, 0),
    /**
     * 転出確定異動年月日
     */
    tenshutsuKakuteiIdoYMD(2147483647, 0),
    /**
     * 転出確定通知年月日
     */
    tenshutsuKakuteiTsuchiYMD(2147483647, 0),
    /**
     * 台帳種別
     */
    daichoShubetsu(1, 0),
    /**
     * 資格異動日
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shikakuIdoYMD(2147483647, 0),
    /**
     * 資格異動枝番
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shikakuIdoEdaNo(4, 0),
    /**
     * 資格異動事由コード
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shikakuIdoJiyuCode(2, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 市町村コード
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shichosonCode(2147483647, 0),
    /**
     * 取得適用事由コード
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shutokuTekiyoJiyuCode(2, 0),
    /**
     * 取得適用年月日
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shutokuTekiyoYMD(2147483647, 0),
    /**
     * 取得適用届出年月日
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    shutokuTekiyoTodokedeYMD(2147483647, 0),
    /**
     * 喪失解除事由コード
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    soshitsuKaijoJiyuCode(2, 0),
    /**
     * 喪失解除年月日
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    soshitsuKaijoYMD(2147483647, 0),
    /**
     * 喪失解除届出年月日
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     */
    soshitsuKaijoTodokedeYMD(2147483647, 0),
    /**
     * 第１号取得年月日
     * <br/>被保台帳のみ
     */
    ichigoShutokuYMD(2147483647, 0),
    /**
     * 被保険者区分コード
     * <br/>被保台帳のみ
     */
    hihokenshaKubunCode(1, 0),
    /**
     * 資格変更事由コード
     * <br/>被保台帳のみ
     */
    shikakuHenkoJiyuCode(2, 0),
    /**
     * 資格変更年月日
     * <br/>被保台帳のみ
     */
    shikakuHenkoYMD(2147483647, 0),
    /**
     * 資格変更届出年月日
     * <br/>被保台帳のみ
     */
    shikakuHenkoTodokedeYMD(2147483647, 0),
    /**
     * 住特適用事由コード
     * <br/>被保台帳のみ
     */
    jutokuTekiyoJiyuCode(2, 0),
    /**
     * 住特適用年月日
     * <br/>被保台帳のみ
     */
    jutokuTekiyoYMD(2147483647, 0),
    /**
     * 住特適用届出年月日
     * <br/>被保台帳のみ
     */
    jutokuTekiyoTodokedeYMD(2147483647, 0),
    /**
     * 住特解除事由コード
     * <br/>被保台帳のみ
     */
    jutokuKaijoJiyuCode(2, 0),
    /**
     * 住特解除年月日
     * <br/>被保台帳のみ
     */
    jutokuKaijoYMD(2147483647, 0),
    /**
     * 住特解除届出年月日
     * <br/>被保台帳のみ
     */
    jutokuKaijoTodokedeYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1014SeigoseiCheck(int maxLength, int scale) {
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
