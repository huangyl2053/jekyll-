package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 年金特徴回付情報テーブルの項目定義クラスです。
 *
 * @reamsid_L DBZ-9999-022 yangchenbing
 */
public enum UeT0511NenkinTokuchoKaifuJoho implements IColumnDefinition {
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
     * 業務コード
     */
    gyomuCode(2147483647, 0),
    /**
     * 処理年度
     */
    shoriNendo(2147483647, 0),
    /**
     * 通知内容コード
     */
    tsuchiNaiyoCode(2, 0),
    /**
     * 処理対象年月
     */
    shoriTaishoYM(2147483647, 0),
    /**
     * 基礎年金番号
     */
    kisoNenkinNo(10, 0),
    /**
     * 年金コード
     */
    nenkinCode(4, 0),
    /**
     * 構成市町村コード
     */
    koseiCityCode(5, 0),
    /**
     * 連番
     */
    renban(10, 0),
    /**
     * 処理日時
     */
    shoriTimestamp(2147483647, 0),
    /**
     * 連携種別
     */
    renkeiShubetsu(3, 0),
    /**
     * 捕捉月
     */
    hosokuTsuki(2, 0),
    /**
     * 天引月
     */
    tenbikiTsuki(2, 0),
    /**
     * DT市町村コード
     */
    dtCityCode(5, 0),
    /**
     * DT特別徴収義務者コード
     */
    dtTokubetsuChoshuGimushaCode(2147483647, 0),
    /**
     * DT通知内容コード
     */
    dtTsuchiNaiyoCode(2, 0),
    /**
     * DT媒体コード
     */
    dtBaitaiCode(1, 0),
    /**
     * DT特別徴収制度コード
     */
    dtTokubetsuChoshuSeidoCode(1, 0),
    /**
     * DT作成年月日
     */
    dtSakuseiYMD(8, 0),
    /**
     * DT基礎年金番号
     */
    dtKisoNenkinNo(10, 0),
    /**
     * DT年金コード
     */
    dtNenkinCode(4, 0),
    /**
     * DT予備１
     */
    dtYobi1(3, 0),
    /**
     * DT生年月日
     */
    dtBirthDay(8, 0),
    /**
     * DT性別
     */
    dtSeibetsu(1, 0),
    /**
     * DTカナ氏名
     */
    dtKanaShimei(25, 0),
    /**
     * DTシフトコード１
     */
    dtShiftCode1(3, 0),
    /**
     * DT漢字氏名
     */
    dtKanjiShimei(50, 0),
    /**
     * DTシフトコード２
     */
    dtShiftCode2(3, 0),
    /**
     * DT郵便番号
     */
    dtYubinNo(7, 0),
    /**
     * DTカナ住所
     */
    dtKanaJusho(80, 0),
    /**
     * DTシフトコード３
     */
    dtShiftCode3(3, 0),
    /**
     * DT漢字住所
     */
    dtKanjiJusho(160, 0),
    /**
     * DTシフトコード４
     */
    dtShiftCode4(3, 0),
    /**
     * DT各種区分
     */
    dtKakushuKubun(2, 0),
    /**
     * DT処理結果
     */
    dtShoriKekka(2, 0),
    /**
     * DT後期移管コード
     */
    dtKokiIkanCode(1, 0),
    /**
     * DT各種年月日
     */
    dtKakushuYMD(8, 0),
    /**
     * DT各種金額欄１
     */
    dtKakushuKingaku1(11, 0),
    /**
     * DT各種金額欄２
     */
    dtKakushuKingaku2(11, 0),
    /**
     * DT各種金額欄３
     */
    dtKakushuKingaku3(11, 0),
    /**
     * DT予備２
     */
    dtYobi2(58, 0),
    /**
     * DT共済年金証書記号番号
     */
    dtKyosaiNenkinshoshoKigoNo(15, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(10, 0),
    /**
     * 国保世帯コード
     */
    kokuhoSetaiCode(2147483647, 0),
    /**
     * DT各種金額欄４
     */
    dtKakushuKingaku4(11, 0),
    /**
     * DT各種金額欄５
     */
    dtKakushuKingaku5(11, 0),
    /**
     * DT各種金額欄６
     */
    dtKakushuKingaku6(11, 0),
    /**
     * DT各種金額欄７
     */
    dtKakushuKingaku7(11, 0),
    /**
     * DT各種金額欄８
     */
    dtKakushuKingaku8(11, 0),
    /**
     * DT停止年月
     */
    dtTeishiYM(6, 0),
    /**
     * DT予備４住民税
     */
    dtYobi4Juminzei(15, 0),
    /**
     * DT個人番号
     */
    dtKojinNo(12, 0),
    /**
     * 国保予定喪失区分
     */
    kokuhoYoteiSoshitsuKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private UeT0511NenkinTokuchoKaifuJoho(int maxLength, int scale) {
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
