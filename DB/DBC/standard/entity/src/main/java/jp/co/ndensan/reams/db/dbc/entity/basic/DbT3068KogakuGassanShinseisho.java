package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額合算申請書テーブルの項目定義クラスです。
 */
public enum DbT3068KogakuGassanShinseisho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 保険者番号
     * <br/>証記載保険者番号では無い
     */
    hokenshaNo(2147483647, 0),
    /**
     * 整理番号
     * <br/>年度単位で”000001”からの連番
     */
    seiriNo(6, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申請状況区分
     */
    shinseiJokyoKubun(1, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 支給申請書整理番号
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 国保支給申請書整理番号
     */
    kokuhoShikyuShinseishoSeiriNo(17, 0),
    /**
     * 支給申請区分
     */
    shikyuShinseiKubun(1, 0),
    /**
     * 対象計算期間開始年月日
     */
    taishoKeisanKaishiYMD(2147483647, 0),
    /**
     * 対象計算期間終了年月日
     */
    taishoKeisanShuryoYMD(2147483647, 0),
    /**
     * 支給申請形態
     */
    shikyuShinseiKeitai(1, 0),
    /**
     * 自己負担額証明書交付申請の有無
     */
    jikoFutanKofuUmu(1, 0),
    /**
     * 申請代表者氏名
     */
    shinseiDaihyoshaShimei(2147483647, 0),
    /**
     * 申請代表者郵便番号
     */
    shinseiDaihyoshaYubinNo(2147483647, 0),
    /**
     * 申請代表者住所
     */
    shinseiDaihyoshaJusho(100, 0),
    /**
     * 申請代表者電話番号
     */
    shinseiDaihyoshaTelNo(2147483647, 0),
    /**
     * 所得区分
     */
    shotokuKubun(1, 0),
    /**
     * 70歳以上の者に係る所得区分
     */
    over70_ShotokuKubun(1, 0),
    /**
     * 資格喪失年月日
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 資格喪失事由
     */
    shikakuSoshitsuJiyu(1, 0),
    /**
     * 加入期間開始年月日
     */
    kanyuKaishiYMD(2147483647, 0),
    /**
     * 加入期間終了年月日
     */
    kanyuShuryoYMD(2147483647, 0),
    /**
     * 国保保険者番号
     */
    kokuho_HokenshaNo(8, 0),
    /**
     * 国保保険者名称
     */
    kokuho_HokenshaMeisho(20, 0),
    /**
     * 国保被保険者証記号
     */
    kokuho_HihokenshaShoKigo(20, 0),
    /**
     * 国保被保険者証番号
     */
    kokuho_HihokenshaShoNo(20, 0),
    /**
     * 国保世帯番号
     */
    kokuho_SetaiNo(11, 0),
    /**
     * 国保続柄
     */
    kokuho_Zokugara(1, 0),
    /**
     * 国保加入期間開始年月日
     */
    kokuho_KanyuKaishiYMD(2147483647, 0),
    /**
     * 国保加入期間終了年月日
     */
    kokuho_KanyuShuryoYMD(2147483647, 0),
    /**
     * 後期保険者番号
     */
    koki_HokenshaNo(8, 0),
    /**
     * 後期広域連合名称
     */
    koki_KoikiRengoMeisho(20, 0),
    /**
     * 後期被保険者番号
     */
    koki_HihokenshaNo(8, 0),
    /**
     * 後期加入期間開始年月日
     */
    koki_KanyuKaishiYMD(2147483647, 0),
    /**
     * 後期加入期間終了年月日
     */
    koki_KanyuShuryoYMD(2147483647, 0),
    /**
     * 支払方法区分
     */
    shiharaiHohoKubun(1, 0),
    /**
     * 支払場所
     */
    shiharaiBasho(64, 0),
    /**
     * 支払期間開始年月日
     */
    shiharaiKaishiYMD(2147483647, 0),
    /**
     * 支払期間終了年月日
     */
    shiharaiShuryoYMD(2147483647, 0),
    /**
     * 閉庁内容
     */
    heichoNaiyo(50, 0),
    /**
     * 支払期間開始時間
     */
    shiharaiKaishiTime(8, 0),
    /**
     * 支払期間終了時間
     */
    shiharaiShuryoTime(8, 0),
    /**
     * 口座ID
     * <br/>口座テーブルとのリンクキー
     */
    kozaID(19, 0),
    /**
     * 備考
     */
    biko(250, 0),
    /**
     * 支給申請書情報送付年月
     */
    shikyuShinseisho_SofuYM(2147483647, 0),
    /**
     * 再送フラグ
     */
    saiSofuFlag(1, 0),
    /**
     * 自己負担額計算年月
     */
    jikoFutan_KeisanYM(2147483647, 0),
    /**
     * 再計算区分
     */
    saiKeisanKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3068KogakuGassanShinseisho(int maxLength, int scale) {
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
