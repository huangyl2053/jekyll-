package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 口座テーブルの項目定義クラスです。
 * <br/> 振替口座、振込口座の情報を管理するDB。
     * <br/>振替口座：識別コード、科目コード、種別単位で管理。
     * <br/>振込口座：識別コード、業務コード、サブ業務コード、科目コード、種別単位で管理。
 */
public enum UrT0715Koza implements IColumnDefinition {
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
     * 口座ID
     */
    kozaId(19, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 業務コード
     * <br/>収納(還付)/国保/福祉/児童手当　等から選択する
     */
    gyomuCode(2147483647, 0),
    /**
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 科目コード
     * <br/>＜サブ業務：URZ、種別：0369＞
     * <br/>給付種別　等
     * <br/>収納の場合：収納科目DBの科目コード
     * <br/>収納以外の場合：振込口座管理する場合で業務内に区分がある場合は、業務内区分コードをセット
     */
    kamokuCode(2147483647, 0),
    /**
     * 業務固有キー
     * <br/>使用業務で任意の固有キーを設定可能
     */
    gyomuKoyuKey(20, 0),
    /**
     * 用途区分
     * <br/>＜サブ業務：URZ、種別：0087＞
     * <br/>0：振替口座
     * <br/>1：振込口座
     * <br/>2：納税組合
     */
    yotoKubun(2147483647, 0),
    /**
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    kinyuKikanShitenCode(2147483647, 0),
    /**
     * 預金種別
     * <br/>1:普通預金
     * <br/>2:当座預金
     * <br/>3:納税準備預金
     * <br/>4:貯蓄預金
     * <br/>9:その他
     */
    yokinShubetsu(1, 0),
    /**
     * 口座番号
     */
    kozaNo(2147483647, 0),
    /**
     * 通帳記号
     */
    tsuchoKigo(2147483647, 0),
    /**
     * 通帳番号
     */
    tsuchoNo(2147483647, 0),
    /**
     * 口座名義人識別コード
     * <br/>口座名義人に識別コードが付与されている場合に任意で登録管理する
     */
    kozaMeigininShikibetsuCode(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人漢字
     */
    kozaMeigininKanji(2147483647, 0),
    /**
     * 開始年月日
     */
    kaishiYMD(2147483647, 0),
    /**
     * 終了年月日
     */
    shuryoYMD(2147483647, 0),
    /**
     * 検索用名義人
     */
    kensakuyoMeiginin(2147483647, 0),
    /**
     * 口座表示区分
     * <br/>業務の方針に従い表示するか、個別の表示設定を行うかを指定する。0：個別設定なし、1：マスクしない、2：表示しない
     */
    kozaHyojiKubun(1, 0),
    /**
     * 名寄区分
     * <br/>複数の期別を保有する識別対象が口座振替を合算するかどうかの区分。(true:合算する、false:合算しない)。委託者にも名寄区分を持つが優先順位としては、口座の名寄せ区分＞(振込)委託者の名寄区分　とする。
     */
    nayoseKubun(1, 0),
    /**
     * 領収済通知書発行要否
     * <br/>true：発行する、false：発行しない
     * <br/>領収済通知書を送付するか否かを指定する。
     */
    zumitsuHakkoYohi(1, 0),
    /**
     * 口座振替開始通知書発行済
     * <br/>true：発行済、false：未発行
     * <br/>口座振替開始通知書を送付済か否かを設定する。
     */
    kozaFurikaeKaishiTsuchiHakkozumi(1, 0),
    /**
     * 口座登録番号
     */
    kozaTorokuNo(2147483647, 0),
    /**
     * 口座登録区分コード
     * <br/>共通コード＜サブ業務：URZ、種別：0113＞
     * <br/>0：仮登録
     * <br/>1：本登録
     */
    kozaTorokuKubunCode(2147483647, 0),
    /**
     * 口座開始受付年月日
     */
    kozaKaishiUketsukeYMD(2147483647, 0),
    /**
     * 口座終了受付年月日
     */
    kozaShuryoUketsukeYMD(2147483647, 0),
    /**
     * 口座登録年月日
     */
    kozaTorokuYMD(2147483647, 0),
    /**
     * 店番
     */
    temban(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private UrT0715Koza(int maxLength, int scale) {
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
