package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受給者台帳テーブルの項目定義クラスです。
 */
public enum DbT4001JukyushaDaicho implements IColumnDefinition {
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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(4, 0),
    /**
     * 枝番
     */
    edaban(2, 0),
    /**
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 申請状況区分
     * <br/>0：申請中、１：認定完了
     */
    shinseiJokyoKubun(1, 0),
    /**
     * 支所コード
     */
    shishoCode(9, 0),
    /**
     * 直近フラグ
     * <br/>True:直近情報、False:履歴情報
     */
    chokkinFlag(1, 0),
    /**
     * 識別コード
     * <br/>旧「住民コード」
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 受給申請事由
     * <br/>1：初回申請、2：再申請（有効期限内）、3：再申請（有効期限外）、4：要介護度変更申請、5：指定サービス種類変更申請、6：申請（法施行前）、7：追加（申請なしの追加（転入））
     */
    jukyuShinseiJiyu(2147483647, 0),
    /**
     * 申請理由
     */
    shinseiRiyu(2147483647, 0),
    /**
     * （届出者）申請者関係コード
     */
    shinseishaKankeiCode(2147483647, 0),
    /**
     * （届出者）本人との関係
     */
    homninKankei(10, 0),
    /**
     * 受給申請年月日
     */
    jukyuShinseiYMD(2147483647, 0),
    /**
     * ２号特定疾病コード
     */
    nigoTokuteiShippeiCode(2147483647, 0),
    /**
     * 審査会依頼年月日
     */
    shinsakaiIraiYMD(2147483647, 0),
    /**
     * 要介護認定状態区分コード
     */
    yokaigoJotaiKubunCode(2147483647, 0),
    /**
     * 認定有効期間開始年月日
     */
    ninteiYukoKikanKaishiYMD(2147483647, 0),
    /**
     * 認定有効期間終了年月日
     */
    ninteiYukoKikanShuryoYMD(2147483647, 0),
    /**
     * 認定年月日
     * <br/>認定年月日、却下年月日
     */
    ninteiYMD(2147483647, 0),
    /**
     * 指定サービス種類01
     */
    shiteiServiceShurui01(2147483647, 0),
    /**
     * 指定サービス種類02
     */
    shiteiServiceShurui02(2147483647, 0),
    /**
     * 指定サービス種類03
     */
    shiteiServiceShurui03(2147483647, 0),
    /**
     * 指定サービス種類04
     */
    shiteiServiceShurui04(2147483647, 0),
    /**
     * 指定サービス種類05
     */
    shiteiServiceShurui05(2147483647, 0),
    /**
     * 指定サービス種類06
     */
    shiteiServiceShurui06(2147483647, 0),
    /**
     * 指定サービス種類07
     */
    shiteiServiceShurui07(2147483647, 0),
    /**
     * 指定サービス種類08
     */
    shiteiServiceShurui08(2147483647, 0),
    /**
     * 指定サービス種類09
     */
    shiteiServiceShurui09(2147483647, 0),
    /**
     * 指定サービス種類10
     */
    shiteiServiceShurui10(2147483647, 0),
    /**
     * 指定サービス種類11
     */
    shiteiServiceShurui11(2147483647, 0),
    /**
     * 指定サービス種類12
     */
    shiteiServiceShurui12(2147483647, 0),
    /**
     * 指定サービス種類13
     */
    shiteiServiceShurui13(2147483647, 0),
    /**
     * 指定サービス種類14
     */
    shiteiServiceShurui14(2147483647, 0),
    /**
     * 指定サービス種類15
     */
    shiteiServiceShurui15(2147483647, 0),
    /**
     * 指定サービス種類16
     */
    shiteiServiceShurui16(2147483647, 0),
    /**
     * 指定サービス種類17
     */
    shiteiServiceShurui17(2147483647, 0),
    /**
     * 指定サービス種類18
     */
    shiteiServiceShurui18(2147483647, 0),
    /**
     * 指定サービス種類19
     */
    shiteiServiceShurui19(2147483647, 0),
    /**
     * 指定サービス種類20
     */
    shiteiServiceShurui20(2147483647, 0),
    /**
     * 指定サービス種類21
     */
    shiteiServiceShurui21(2147483647, 0),
    /**
     * 指定サービス種類22
     */
    shiteiServiceShurui22(2147483647, 0),
    /**
     * 指定サービス種類23
     */
    shiteiServiceShurui23(2147483647, 0),
    /**
     * 指定サービス種類24
     */
    shiteiServiceShurui24(2147483647, 0),
    /**
     * 指定サービス種類25
     */
    shiteiServiceShurui25(2147483647, 0),
    /**
     * 指定サービス種類26
     */
    shiteiServiceShurui26(2147483647, 0),
    /**
     * 指定サービス種類27
     */
    shiteiServiceShurui27(2147483647, 0),
    /**
     * 指定サービス種類28
     */
    shiteiServiceShurui28(2147483647, 0),
    /**
     * 指定サービス種類29
     */
    shiteiServiceShurui29(2147483647, 0),
    /**
     * 指定サービス種類30
     */
    shiteiServiceShurui30(2147483647, 0),
    /**
     * 喪失年月日
     * <br/>職権取消での喪失日
     */
    soshitsuYMD(2147483647, 0),
    /**
     * 直近異動年月日
     * <br/>直近の異動年月日
     */
    chokkinIdoYMD(2147483647, 0),
    /**
     * 直近異動事由コード
     * <br/>00：未登録
     * <br/>01：追加（認定）
     * <br/>02：要介護度変更申請認定
     * <br/>03：要介護度変更申請却下
     * <br/>04：サービス種類変更申請認定
     * <br/>05：サービス種類変更申請却下
     * <br/>06：削除
     * <br/>07：修正
     * <br/>08：受給申請却下
     * <br/>09：削除回復
     * <br/>10：職権記載
     * <br/>11：職権修正
     * <br/>12：職権取消
     * <br/>20：履歴修正
     */
    chokkinIdoJiyuCode(2147483647, 0),
    /**
     * 有効無効区分
     * <br/>0：申請中、1：有効、2：無効
     */
    yukoMukoKubun(2147483647, 0),
    /**
     * データ区分
     */
    dataKubun(2147483647, 0),
    /**
     * 同一連番
     */
    remban(4, 0),
    /**
     * 異動理由
     * <br/>認定理由、却下理由、職権理由
     */
    idoRiyu(2147483647, 0),
    /**
     * 申請書区分
     * <br/>旧「認定支援申請区分」　0：要介護申請、1：要支援申請
     */
    shinseishoKubun(2147483647, 0),
    /**
     * 削除事由コード
     */
    sakujoJiyuCode(2147483647, 0),
    /**
     * 要支援者認定申請区分
     * <br/>True:要支援者の要介護認定申請、False:それ以外
     */
    yoshienshaNinteiShinseiFlag(1, 0),
    /**
     * 支給限度単位数
     */
    shikyuGendoTanisu(131089, 0),
    /**
     * 支給限度有効開始年月日
     */
    shikyuGendoKaishiYMD(2147483647, 0),
    /**
     * 支給限度有効終了年月日
     */
    shikyuGendoShuryoYMD(2147483647, 0),
    /**
     * 短期入所支給限度日数
     */
    tankiSikyuGendoNissu(10, 0),
    /**
     * 短期入所支給限度開始年月日
     */
    tankiShikyuGendoKaishiYMD(2147483647, 0),
    /**
     * 短期入所支給限度終了年月日
     */
    tankiShikyuGendoShuryoYMD(2147483647, 0),
    /**
     * 当初認定有効開始年月日
     */
    toshoNinteiYukoKaishiYMD(2147483647, 0),
    /**
     * 当初認定有効終了年月日
     */
    toshoNinteiYukoShuryoYMD(2147483647, 0),
    /**
     * 受給資格証明書発行年月日１
     */
    jukyuShikakuShomeishoHakkoYMD1(2147483647, 0),
    /**
     * 受給資格証明書発行年月日２
     */
    jukyuShikakuShomeishoHakkoYMD2(2147483647, 0),
    /**
     * 診断命令書発行年月日
     */
    shindanMeireishoHakkoYMD(2147483647, 0),
    /**
     * ２号申請受理通知書発行年月日
     */
    nigoShinseiJuriTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 認定結果通知書発行年月日
     */
    ninteiKekkaTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 区分変更通知書発行年月日
     */
    kubunHenkoTsuchishoHakkoYMD(2147483647, 0),
    /**
     * サービス変更通知書発行年月日
     */
    serviceHenkoTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 認定却下通知書発行年月日
     */
    ninteiKyakkaTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 認定取消通知書発行年月日
     */
    ninteiTorikeshiTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 資格取得前申請フラグ
     */
    shikakuShutokuMaeShinseiFlag(1, 0),
    /**
     * 旧措置者フラグ
     */
    kyuSochishaFlag(1, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4001JukyushaDaicho(int maxLength, int scale) {
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
