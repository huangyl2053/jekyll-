package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定主治医意見書情報テーブルの項目定義クラスです。
 */
public enum DbT5302ShujiiIkenshoJoho implements IColumnDefinition {
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
     * 主治医意見書作成依頼履歴番号
     * <br/>主治医意見書作成依頼情報
     */
    ikenshoIraiRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     */
    koroshoIfShikibetsuCode(3, 0),
    /**
     * 主治医意見書依頼区分
     * <br/>Enum（DBE：主治医意見書依頼区分）
     */
    ikenshoIraiKubun(1, 0),
    /**
     * 主治医医療機関コード
     * <br/>主治医医療機関情報
     */
    shujiiIryoKikanCode(10, 0),
    /**
     * 主治医コード
     * <br/>主治医情報
     */
    shujiiCode(8, 0),
    /**
     * 主治医意見書受領年月日
     */
    ikenshoJuryoYMD(2147483647, 0),
    /**
     * 主治医意見書記入年月日
     */
    ikenshoKinyuYMD(2147483647, 0),
    /**
     * 意見書作成回数区分
     * <br/>Enum（DBE：意見書作成回数区分）初回/2回目以上
     */
    ikenshoSakuseiKaisuKubun(2147483647, 0),
    /**
     * 在宅／施設区分
     * <br/>Enum（DBE：在宅/施設区分）在宅/施設
     */
    zaitakuShisetsuKubun(2147483647, 0),
    /**
     * 意見書同意フラグ
     * <br/>Enum（DBE：意見書同意フラグ）
     */
    ikenshoDoiFlag(1, 0),
    /**
     * 最終診療日
     */
    saishuShinryoYMD(2147483647, 0),
    /**
     * 他科受診の有無
     * <br/>Enum（DBE：他科受診の有無）
     */
    existTakaJushinFlag(1, 0),
    /**
     * 内科受診の有無
     * <br/>Enum（DBE：内科受診の有無）
     */
    existNaikaJushinFlag(1, 0),
    /**
     * 精神科受診の有無
     * <br/>Enum（DBE：精神科受診の有無）
     */
    existSeishinkaJushinFlag(1, 0),
    /**
     * 外科受診の有無
     * <br/>Enum（DBE：外科受診の有無）
     */
    existGekaJushinFlag(1, 0),
    /**
     * 整形外科受診の有無
     * <br/>Enum（DBE：整形外科受診の有無）
     */
    existSeikeigekaJushinFlag(1, 0),
    /**
     * 脳神経外科の有無
     * <br/>Enum（DBE：脳神経外科受診の有無）
     */
    existNoshinkeigekaJushinFlag(1, 0),
    /**
     * 皮膚科受診の有無
     * <br/>Enum（DBE：皮膚科受診の有無）
     */
    existHifukaJushinFlag(1, 0),
    /**
     * 泌尿器科受診の有無
     * <br/>Enum（DBE：泌尿器科受診の有無）
     */
    existHinyokikaJushinFlag(1, 0),
    /**
     * 婦人科受診の有無
     * <br/>Enum（DBE：婦人科受診の有無）
     */
    existFujinkaJushinFlag(1, 0),
    /**
     * 耳鼻咽喉科受診の有無
     * <br/>Enum（DBE：耳鼻咽喉科受診の有無）
     */
    existJibiinkokaJushinFlag(1, 0),
    /**
     * リハビリテーション科受診の有無
     * <br/>Enum（DBE：リハビリテーション科受診の有無）
     */
    existRehabilitationkaJushinFlag(1, 0),
    /**
     * 歯科受診の有無
     * <br/>Enum（DBE：歯科受診の有無）
     */
    existShikaJushinFlag(1, 0),
    /**
     * 眼科の有無
     * <br/>Enum（DBE：眼科受診の有無）
     */
    existGankaJushinFlag(1, 0),
    /**
     * その他受診科の有無
     * <br/>Enum（DBE：その他受診科の有無）
     */
    existSonotaJushinkaFlag(1, 0),
    /**
     * その他受診科名
     */
    sonotaJushinKaMei(40, 0),
    /**
     * 意見書・診断名1
     */
    shindamMei1(40, 0),
    /**
     * 意見書・発症年月日1
     */
    hasshoYMD1(30, 0),
    /**
     * 意見書・診断名2
     */
    shindamMei2(40, 0),
    /**
     * 意見書・発症年月日2
     */
    hasshoYMD2(30, 0),
    /**
     * 意見書・診断名3
     */
    shindamMei3(40, 0),
    /**
     * 意見書・発症年月日3
     */
    hasshoYMD3(30, 0),
    /**
     * 意見書・症状としての安定性
     * <br/>Enum（DBE：意見書・症状としての安定性）
     */
    anteisei(1, 0),
    /**
     * 意見書・症状としての安定性　不安定状況
     */
    fuanteiJokyo(2147483647, 0),
    /**
     * 治療内容
     */
    chiryoNaiyo(2147483647, 0),
    /**
     * 特記事項
     */
    tokkiJiko(2147483647, 0),
    /**
     * 認定審査会後の二次判定結果の連絡確認フラグ
     */
    nijiHanteiKekkaRenrakuFlag(1, 0),
    /**
     * 意見書メモ
     * <br/>広域対応
     */
    ikenshoMemo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5302ShujiiIkenshoJoho(int maxLength, int scale) {
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
