package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護第三者行為届出テーブルの項目定義クラスです。
 */
public enum DbT3084DaisanshaKoiTodokede implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 第三者行為届出管理番号
     */
    todokedeKanriNo(10, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 届出年月日
     */
    todokedeYMD(2147483647, 0),
    /**
     * 届出人郵便番号
     */
    todokedenin_YubinNo(2147483647, 0),
    /**
     * 届出人住所
     */
    todokedenin_Jusho(100, 0),
    /**
     * 届出人氏名カナ
     */
    todokedenin_ShimeiKana(2147483647, 0),
    /**
     * 届出人氏名
     */
    todokedenin_Shimei(2147483647, 0),
    /**
     * 届出人電話番号
     */
    todokedenin_TelNo(2147483647, 0),
    /**
     * 届出人との続柄
     */
    todokedenin_Zokugara(20, 0),
    /**
     * 要介護状態区分
     */
    yokaigoJotaiKubun(2147483647, 0),
    /**
     * 認定有効期間開始年月日
     */
    ninteiYukoKaishiYMD(2147483647, 0),
    /**
     * 認定有効期間終了年月日
     */
    ninteiYukoShuryoYMD(2147483647, 0),
    /**
     * 加害者郵便番号
     */
    kagaisha_YubinNo(2147483647, 0),
    /**
     * 加害者住所
     */
    kagaisha_Jusho(100, 0),
    /**
     * 加害者氏名カナ
     */
    kagaisha_ShimeiKana(2147483647, 0),
    /**
     * 加害者氏名
     */
    kagansha_Shimei(2147483647, 0),
    /**
     * 加害者生年月日
     */
    kagaisha_UmareYMD(2147483647, 0),
    /**
     * 加害者電話番号
     */
    kagaisha_TelNo(2147483647, 0),
    /**
     * 加害者職業
     */
    kagaisha_Shokugyo(50, 0),
    /**
     * 使用者郵便番号
     * <br/>加害者の使用者
     */
    shiyosha_YubinNo(2147483647, 0),
    /**
     * 使用者住所
     */
    shiyosha_Jusho(100, 0),
    /**
     * 使用者氏名カナ
     */
    shiyosha_ShimeiKana(2147483647, 0),
    /**
     * 使用者氏名
     */
    shiyosha_Shimei(2147483647, 0),
    /**
     * 使用者生年月日
     */
    shiyosha_UmareYMD(2147483647, 0),
    /**
     * 使用者電話番号
     */
    shiyosha_TelNo(2147483647, 0),
    /**
     * 使用者職業
     */
    shiyosha_Shokugyo(50, 0),
    /**
     * 負傷年月日
     */
    fushoYMD(2147483647, 0),
    /**
     * 負傷時間
     */
    fushoTime(4, 0),
    /**
     * 負傷時の場所
     */
    fushoJi_Basho(100, 0),
    /**
     * 発病原因・負傷時状況
     */
    hasshoGeiin_FushoJiJokyo(500, 0),
    /**
     * 自賠責保険契約会社名
     */
    jibaisekiHoken_KeiyakuKaishaMei(2147483647, 0),
    /**
     * 自賠責保険証明書番号
     */
    jibaisekiHoken_ShomeishoNo(50, 0),
    /**
     * 自賠責保険契約者住所
     */
    jibaisekiHoken_KeiyakushaJusho(100, 0),
    /**
     * 所有者住所
     */
    shoyushaJusho(100, 0),
    /**
     * 所有者氏名
     */
    shoyushaShimei(2147483647, 0),
    /**
     * 登録番号
     * <br/>（車両番号）
     */
    torokuNo(50, 0),
    /**
     * 車台番号
     */
    shadaiNo(50, 0),
    /**
     * 任意保険対人保障有無
     */
    niniHoken_TaijinHoshoUmu(1, 0),
    /**
     * 任意保険対人保障保険契約会社名
     */
    niniHoken_TaijinHoshoKaishaMei(2147483647, 0),
    /**
     * 任意保険対人保障保険契約会社連絡先
     */
    niniHoken_TaijinHoshoKaishaTelNo(2147483647, 0),
    /**
     * 任意保険対人保障保険契約会社担当者
     */
    niniHoken_TaijinHoshoKaishaTantosha(2147483647, 0),
    /**
     * 示談成立有無
     */
    jidan_SeiritsuUmu(1, 0),
    /**
     * 示談成立年月日
     */
    jidan_SeiritsuYMD(2147483647, 0),
    /**
     * 損害賠償交渉経過
     */
    songaiBaishoKoshoKeika(100, 0),
    /**
     * 事故発生状況報告書有無
     */
    jikoHasseiJokyoHokokushoUmu(1, 0),
    /**
     * 念書兼同意書有無
     */
    nensho_DoishoUmu(1, 0),
    /**
     * 誓約書有無
     */
    seiyakushoUmu(1, 0),
    /**
     * 交通事故証明書有無
     */
    kotsuJikoShomeishoUmu(1, 0),
    /**
     * 人身事故証明書入手不能理由書有無
     */
    jinshinJikoShomeisho_NyushuFunoRiyushoUmu(1, 0),
    /**
     * 示談書写し有無
     */
    jidanshoUtsushiUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3084DaisanshaKoiTodokede(int maxLength, int scale) {
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
