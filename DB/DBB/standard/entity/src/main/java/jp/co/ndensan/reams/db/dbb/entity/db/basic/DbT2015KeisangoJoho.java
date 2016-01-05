package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 計算後情報テーブルの項目定義クラスです。
 * <br/> バッチの賦課計算処理で作成された賦課マスタ、徴収方法マスタをもとに最新履歴、1つ前履歴で１レコードづつの形に変換して管理する。
 */
public enum DbT2015KeisangoJoho implements IColumnDefinition {
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
     * 調定年度
     */
    choteiNendo(2147483647, 0),
    /**
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(2147483647, 0),
    /**
     * 更正前後区分
     * <br/>1：更正前、2：更正後
     */
    koseiZengoKubun(1, 0),
    /**
     * 作成処理名
     */
    sakuseiShoriName(128, 0),
    /**
     * 賦課履歴番号
     */
    fukaRirekiNo(5, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 世帯員数
     */
    setaiInsu(5, 0),
    /**
     * 資格取得日
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * 資格取得事由
     */
    shikakuShutokuJiyu(2, 0),
    /**
     * 資格喪失日
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 資格喪失事由
     */
    shikakuSoshitsuJiyu(2, 0),
    /**
     * 生活保護扶助種類
     */
    seihofujoShurui(2, 0),
    /**
     * 生保開始日
     */
    seihoKaishiYMD(2147483647, 0),
    /**
     * 生保廃止日
     */
    seihoHaishiYMD(2147483647, 0),
    /**
     * 老齢開始日
     */
    ronenKaishiYMD(2147483647, 0),
    /**
     * 老齢廃止日
     */
    ronenHaishiYMD(2147483647, 0),
    /**
     * 賦課期日
     */
    fukaYMD(2147483647, 0),
    /**
     * 課税区分
     */
    kazeiKubun(1, 0),
    /**
     * 世帯課税区分
     */
    setaikazeiKubun(1, 0),
    /**
     * 合計所得金額
     */
    gokeiShotokuGaku(12, 0),
    /**
     * 公的年金収入額
     */
    nenkinShunyuGaku(12, 0),
    /**
     * 保険料段階
     */
    hokenryoDankai(3, 0),
    /**
     * 保険料算定段階1
     */
    hokenryoDankai1(3, 0),
    /**
     * 算定年額保険料1
     */
    nengakuHokenryo1(7, 0),
    /**
     * 月割開始年月1
     */
    tsukiwariStartYM1(2147483647, 0),
    /**
     * 月割終了年月1
     */
    tsukiwariEndYM1(2147483647, 0),
    /**
     * 保険料算定段階2
     */
    hokenryoDankai2(3, 0),
    /**
     * 算定年額保険料2
     */
    nengakuHokenryo2(7, 0),
    /**
     * 月割開始年月2
     */
    tsukiwariStartYM2(2147483647, 0),
    /**
     * 月割終了年月2
     */
    tsukiwariEndYM2(2147483647, 0),
    /**
     * 調定日時
     */
    choteiNichiji(2147483647, 0),
    /**
     * 調定事由1
     */
    choteiJiyu1(2, 0),
    /**
     * 調定事由2
     */
    choteiJiyu2(2, 0),
    /**
     * 調定事由3
     */
    choteiJiyu3(2, 0),
    /**
     * 調定事由4
     */
    choteiJiyu4(2, 0),
    /**
     * 更正月
     */
    koseiM(2, 0),
    /**
     * 減免前介護保険料（年額）
     */
    gemmenMaeHokenryo(7, 0),
    /**
     * 減免額
     */
    gemmenGaku(7, 0),
    /**
     * 確定介護保険料（年額）
     */
    kakuteiHokenryo(7, 0),
    /**
     * 保険料段階（仮算定時）
     */
    hokenryoDankaiKarisanntei(3, 0),
    /**
     * 徴収方法履歴番号
     */
    choshuHohoRirekiNo(5, 0),
    /**
     * 異動基準日時
     */
    idoKijunNichiji(2147483647, 0),
    /**
     * 口座区分
     */
    kozaKubun(1, 0),
    /**
     * 境界層区分
     */
    kyokaisoKubun(1, 0),
    /**
     * 職権区分
     */
    shokkenKubun(1, 0),
    /**
     * 賦課市町村コード
     */
    fukaShichosonCode(2147483647, 0),
    /**
     * 特徴歳出還付額
     */
    tkSaishutsuKampuGaku(7, 0),
    /**
     * 普徴歳出還付額
     */
    fuSaishutsuKampuGaku(7, 0),
    /**
     * 特徴期別金額01
     */
    tkKibetsuGaku01(7, 0),
    /**
     * 特徴期別金額02
     */
    tkKibetsuGaku02(7, 0),
    /**
     * 特徴期別金額03
     */
    tkKibetsuGaku03(7, 0),
    /**
     * 特徴期別金額04
     */
    tkKibetsuGaku04(7, 0),
    /**
     * 特徴期別金額05
     */
    tkKibetsuGaku05(7, 0),
    /**
     * 特徴期別金額06
     */
    tkKibetsuGaku06(7, 0),
    /**
     * 普徴期別金額01
     */
    fuKibetsuGaku01(7, 0),
    /**
     * 普徴期別金額02
     */
    fuKibetsuGaku02(7, 0),
    /**
     * 普徴期別金額03
     */
    fuKibetsuGaku03(7, 0),
    /**
     * 普徴期別金額04
     */
    fuKibetsuGaku04(7, 0),
    /**
     * 普徴期別金額05
     */
    fuKibetsuGaku05(7, 0),
    /**
     * 普徴期別金額06
     */
    fuKibetsuGaku06(7, 0),
    /**
     * 普徴期別金額07
     */
    fuKibetsuGaku07(7, 0),
    /**
     * 普徴期別金額08
     */
    fuKibetsuGaku08(7, 0),
    /**
     * 普徴期別金額09
     */
    fuKibetsuGaku09(7, 0),
    /**
     * 普徴期別金額10
     */
    fuKibetsuGaku10(7, 0),
    /**
     * 普徴期別金額11
     */
    fuKibetsuGaku11(7, 0),
    /**
     * 普徴期別金額12
     */
    fuKibetsuGaku12(7, 0),
    /**
     * 普徴期別金額13
     */
    fuKibetsuGaku13(7, 0),
    /**
     * 普徴期別金額14
     */
    fuKibetsuGaku14(7, 0),
    /**
     * 徴収方法4月
     */
    choshuHoho4gatsu(1, 0),
    /**
     * 徴収方法5月
     */
    choshuHoho5gatsu(1, 0),
    /**
     * 徴収方法6月
     */
    choshuHoho6gatsu(1, 0),
    /**
     * 徴収方法7月
     */
    choshuHoho7gatsu(1, 0),
    /**
     * 徴収方法8月
     */
    choshuHoho8gatsu(1, 0),
    /**
     * 徴収方法9月
     */
    choshuHoho9gatsu(1, 0),
    /**
     * 徴収方法10月
     */
    choshuHoho10gatsu(1, 0),
    /**
     * 徴収方法11月
     */
    choshuHoho11gatsu(1, 0),
    /**
     * 徴収方法12月
     */
    choshuHoho12gatsu(1, 0),
    /**
     * 徴収方法1月
     */
    choshuHoho1gatsu(1, 0),
    /**
     * 徴収方法2月
     */
    choshuHoho2gatsu(1, 0),
    /**
     * 徴収方法3月
     */
    choshuHoho3gatsu(1, 0),
    /**
     * 徴収方法翌4月
     */
    choshuHohoYoku4gatsu(1, 0),
    /**
     * 徴収方法翌5月
     */
    choshuHohoYoku5gatsu(1, 0),
    /**
     * 徴収方法翌6月
     */
    choshuHohoYoku6gatsu(1, 0),
    /**
     * 徴収方法翌7月
     */
    choshuHohoYoku7gatsu(1, 0),
    /**
     * 徴収方法翌8月
     */
    choshuHohoYoku8gatsu(1, 0),
    /**
     * 徴収方法翌9月
     */
    choshuHohoYoku9gatsu(1, 0),
    /**
     * 仮徴収・基礎年金番号
     */
    kariNenkinNo(10, 0),
    /**
     * 仮徴収・年金コード
     */
    kariNenkinCode(4, 0),
    /**
     * 仮徴収・捕捉月
     */
    kariHosokuM(2, 0),
    /**
     * 本徴収・基礎年金番号
     */
    honNenkinNo(10, 0),
    /**
     * 本徴収・年金コード
     */
    honNenkinCode(4, 0),
    /**
     * 本徴収・捕捉月
     */
    honHosokuM(2, 0),
    /**
     * 翌年度仮徴収・基礎年金番号
     */
    yokunendoKariNenkinNo(10, 0),
    /**
     * 翌年度仮徴収・年金コード
     */
    yokunendoKariNenkinCode(4, 0),
    /**
     * 翌年度仮徴収・捕捉月
     */
    yokunendoKariHosokuM(2, 0),
    /**
     * 依頼情報送付済みフラグ
     */
    iraiSohuzumiFlag(1, 0),
    /**
     * 追加依頼情報送付済みフラグ
     */
    tsuikaIraiSohuzumiFlag(1, 0),
    /**
     * 特別徴収停止日時
     */
    tokuchoTeishiNichiji(2147483647, 0),
    /**
     * 特別徴収停止事由コード
     */
    tokuchoTeishiJiyuCode(2, 0),
    /**
     * 特徴収入額01
     */
    tkShunyuGaku01(7, 0),
    /**
     * 特徴収入額02
     */
    tkShunyuGaku02(7, 0),
    /**
     * 特徴収入額03
     */
    tkShunyuGaku03(7, 0),
    /**
     * 特徴収入額04
     */
    tkShunyuGaku04(7, 0),
    /**
     * 特徴収入額05
     */
    tkShunyuGaku05(7, 0),
    /**
     * 特徴収入額06
     */
    tkShunyuGaku06(7, 0),
    /**
     * 普徴収入額01
     */
    fuShunyuGaku01(7, 0),
    /**
     * 普徴収入額02
     */
    fuShunyuGaku02(7, 0),
    /**
     * 普徴収入額03
     */
    fuShunyuGaku03(7, 0),
    /**
     * 普徴収入額04
     */
    fuShunyuGaku04(7, 0),
    /**
     * 普徴収入額05
     */
    fuShunyuGaku05(7, 0),
    /**
     * 普徴収入額06
     */
    fuShunyuGaku06(7, 0),
    /**
     * 普徴収入額07
     */
    fuShunyuGaku07(7, 0),
    /**
     * 普徴収入額08
     */
    fuShunyuGaku08(7, 0),
    /**
     * 普徴収入額09
     */
    fuShunyuGaku09(7, 0),
    /**
     * 普徴収入額10
     */
    fuShunyuGaku10(7, 0),
    /**
     * 普徴収入額11
     */
    fuShunyuGaku11(7, 0),
    /**
     * 普徴収入額12
     */
    fuShunyuGaku12(7, 0),
    /**
     * 普徴収入額13
     */
    fuShunyuGaku13(7, 0),
    /**
     * 普徴収入額14
     */
    fuShunyuGaku14(7, 0);

    private final int maxLength;
    private final int scale;

    private DbT2015KeisangoJoho(int maxLength, int scale) {
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
