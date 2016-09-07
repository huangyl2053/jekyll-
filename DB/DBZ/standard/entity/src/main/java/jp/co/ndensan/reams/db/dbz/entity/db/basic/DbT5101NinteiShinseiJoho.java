package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定申請情報テーブルの項目定義クラスです。
 */
public enum DbT5101NinteiShinseiJoho implements IColumnDefinition {
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
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）年によって異なる認定調査項目を特定するためのコード。
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(6, 0),
    /**
     * 申請年度
     */
    shinseiNendo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(10, 0),
    /**
     * 認定申請年月日
     * <br/>更新対象
     */
    ninteiShinseiYMD(2147483647, 0),
    /**
     * 認定申請枝番コード
     */
    ninteiShinseiEdabanCode(2147483647, 0),
    /**
     * 認定申請区分（法令）コード
     * <br/>Enum（DBD：申請区分（法令）コード）新規申請・更新申請・区分変更申請・職権
     */
    ninteiShinseiHoreiKubunCode(2147483647, 0),
    /**
     * 認定申請区分（申請時）コード
     * <br/>Enum（DBD：申請区分（申請時）コード）新規・更新・区分変更・転入申請・資格喪失（死亡）・新規（事前）・更新（事前）
     */
    ninteiShinseiShinseijiKubunCode(2147483647, 0),
    /**
     * 取下区分コード
     * <br/>Enum（DBE：取下区分コード）NCI 1:認定申請有効、2:却下、3:取り下げ、4:区分変更却下
     */
    torisageKubunCode(2147483647, 0),
    /**
     * 被保険者区分コード
     * <br/>Enum（DBE：被保険者区分コード）1:第1号被保険者、2:第2号被保険者、その他8生活保護)
     */
    hihokenshaKubunCode(1, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 年齢
     * <br/>申請日時点の年齢
     */
    age(5, 0),
    /**
     * 性別
     * <br/>Enum（DBZ：性別コード）
     */
    seibetsu(2147483647, 0),
    /**
     * 被保険者氏名カナ
     */
    hihokenshaKana(2147483647, 0),
    /**
     * 被保険者氏名
     */
    hihokenshaName(2147483647, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * 支所コード
     */
    shishoCode(9, 0),
    /**
     * 識別コード
     * <br/>住基
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 地区コード
     */
    chikuCode(2147483647, 0),
    /**
     * みなし２号等対象フラグ
     * <br/>Enum（DBE：みなし2号等対象フラグ）
     */
    minashiNigoEtcTaishoFlag(1, 0),
    /**
     * 広域内転居区分
     * <br/>Enum（DBE：広域内転居区分）0：対象外、1:申請中の転居、2:申請終了
     */
    koikinaiTenkyoKubun(2147483647, 0),
    /**
     * 認定申請有効区分
     * <br/>Enum（DBD：認定申請有効区分）
     */
    ninteiShinseiYukoKubunCode(2147483647, 0),
    /**
     * 要介護申請・要支援申請の区分
     * <br/>Enum（DBD：要介護申請・要支援申請の区分）
     */
    shienShinseiKubun(1, 0),
    /**
     * 認定申請理由
     */
    ninteiShinseiRiyu(2147483647, 0),
    /**
     * 申請サービス削除の理由
     */
    shinseiServiceDeleteRiyu(2147483647, 0),
    /**
     * 前回要介護状態区分コード
     * <br/>Enum（DBZ：要介護状態区分コード09など）
     */
    zenYokaigoKubunCode(2147483647, 0),
    /**
     * 前回認定年月日
     */
    zenkaiNinteiYMD(2147483647, 0),
    /**
     * 前回認定有効期間（開始）
     */
    zenkaiYukoKikanStart(2147483647, 0),
    /**
     * 前回認定有効期間（終了）
     */
    zenkaiYukoKikanEnd(2147483647, 0),
    /**
     * ２号医療保険者名
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     */
    nigoIryoHokenshaName(2147483647, 0),
    /**
     * ２号医療保険記号番号
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     */
    nigoIryoHokenKigoBango(30, 0),
    /**
     * ２号特定疾病コード
     * <br/>Enum（DBZ：特定疾病コード）
     */
    nigoTokuteiShippeiCode(2147483647, 0),
    /**
     * 自動割当除外者区分
     * <br/>Enum（DBE：自動割当除外者区分）
     */
    jidoWariateJogaishaKubun(1, 0),
    /**
     * 情報提供への同意有無
     * <br/>Enum（DBD：情報提供への同意有無）
     */
    johoteikyoDoiFlag(1, 0),
    /**
     * 情報提供資料出力年月日
     */
    johoteikyoSiryoOutputYMD(2147483647, 0),
    /**
     * 調査区分
     * <br/>Enum（DBE：調査区分）
     */
    chosaKubun(2147483647, 0),
    /**
     * 認定調査委託先コード
     * <br/>依頼情報の生成によってupdateされていく。認定調査委託先情報
     */
    ninteiChosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     * <br/>依頼情報の生成によってupdateされていく。認定調査員情報
     */
    ninteiChosainCode(8, 0),
    /**
     * 調査員への連絡事項
     */
    renrakuJikoToChosain(2147483647, 0),
    /**
     * 主治医医療機関コード
     * <br/>申請書の主治医の医療機関に相当する介護独自の医療機関コード。依頼情報の生成によってupdateされていく。主治医医療機関情報
     */
    shujiiIryokikanCode(10, 0),
    /**
     * 主治医コード
     * <br/>申請書の主治医に相当する介護独自の医師コード。依頼情報の生成によってupdateされていく。主治医情報
     */
    shujiiCode(8, 0),
    /**
     * 指定医フラグ
     */
    shiteiiFlag(1, 0),
    /**
     * 意見書データ種別
     * <br/>Enum（DBE：意見書データ種別）
     */
    ikenshoDataShubetsu(2147483647, 0),
    /**
     * 主治医への連絡事項
     */
    renrakuJikoToShujii(2147483647, 0),
    /**
     * 認定延期通知発行しないことに対する同意有無
     * <br/>Enum（DBE：認定延期通知発行しないことに対する同意有無）
     */
    enkitsuchiNashiDoiFlag(1, 0),
    /**
     * 施設入所の有無
     * <br/>Enum（DBE：施設入所の有無）
     */
    shisetsuNyushoFlag(1, 0),
    /**
     * 入所施設コード
     * <br/>介護事業者の事業者番号または、医療機関コード
     */
    nyushoShisetsuCode(2147483647, 0),
    /**
     * 家庭訪問の有無
     * <br/>Enum（DBE：家庭訪問の有無）
     */
    kateiHomonFlag(1, 0),
    /**
     * 訪問調査先郵便番号
     */
    homonChosasakiYubinNo(2147483647, 0),
    /**
     * 訪問調査先住所
     */
    homonChosasakiJusho(2147483647, 0),
    /**
     * 訪問調査先名称
     */
    homonChosasakiName(2147483647, 0),
    /**
     * 訪問調査先電話番号
     */
    homonChosasakiTelNo(2147483647, 0),
    /**
     * 市町村連絡事項
     * <br/>広域運用時、市町村から広域連合に伝えたい事務連絡事項を登録する
     */
    shichosonRenrakuJiko(2147483647, 0),
    /**
     * 処理状態区分
     * <br/>旧「処理区分」
     */
    shoriJotaiKubun(2147483647, 0),
    /**
     * 取下年月日
     */
    torisageYMD(2147483647, 0),
    /**
     * 取下理由
     */
    torisageRiyu(2147483647, 0),
    /**
     * 却下年月日
     */
    kyakkaYMD(2147483647, 0),
    /**
     * 却下理由
     */
    kyakkaRiyu(2147483647, 0),
    /**
     * 延期決定年月日
     */
    enkiKetteiYMD(2147483647, 0),
    /**
     * 延期理由
     */
    enkiRiyu(2147483647, 0),
    /**
     * 延期通知発行年月日
     */
    enkiTsuchiHakkoYMD(2147483647, 0),
    /**
     * 延期通知発行回数
     */
    enkiTsuchiHakkoKaisu(5, 0),
    /**
     * 延期見込期間開始年月日
     */
    enkiMikomiKaishiYMD(2147483647, 0),
    /**
     * 延期見込期間終了年月日
     */
    enkiMikomiShuryoYMD(2147483647, 0),
    /**
     * 審査継続区分
     * <br/>Enum（DBE：審査継続区分）
     */
    shinsaKeizokuFlag(1, 0),
    /**
     * 介護認定審査会優先振分区分コード
     * <br/>Enum（DBE：介護認定審査会優先振分区分コード）
     */
    shinsakaiYusenWaritsukeKubunCode(2147483647, 0),
    /**
     * 更新通知発行年月日
     */
    koshinTsuchiHakkoYMD(2147483647, 0),
    /**
     * 更新通知発行完了年月日
     */
    koshinTsuchiHakkoKanryoYMD(2147483647, 0),
    /**
     * 認定申請情報登録年月日
     */
    ninteiShinseiJohoTorokuYMD(2147483647, 0),
    /**
     * 再調査依頼回数
     */
    saiChosaIraiKaisu(5, 0),
    /**
     * 再作成依頼回数
     */
    saiSakuseiIraiKaisu(5, 0),
    /**
     * ＩＦ送付年月日
     */
    ifSofuYMD(2147483647, 0),
    /**
     * 論理削除フラグ
     * <br/>True：論理削除　False：論理未削除
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5101NinteiShinseiJoho(int maxLength, int scale) {
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
