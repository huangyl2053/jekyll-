package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 識別番号管理テーブルの項目定義クラスです。
 * <br/> 識別番号を管理するテーブルです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public enum DbT3118ShikibetsuNoKanri implements IColumnDefinition {
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
     * 識別番号
     */
    shikibetsuNo(4, 0),
    /**
     * 適用開始年月
     */
    tekiyoKaishiYM(2147483647, 0),
    /**
     * 適用終了年月
     */
    tekiyoShuryoYM(2147483647, 0),
    /**
     * 名称
     */
    meisho(200, 0),
    /**
     * 略称
     */
    ryakusho(60, 0),
    /**
     * 名称２
     */
    meisho2(20, 0),
    /**
     * 識別番号区分
     * <br/>1：交換情報識別番号、2：入力識別番号
     */
    shikibetsuNoKubon(1, 0),
    /**
     * 給付実績区分
     * <br/>1：現物、2：償還、0：区分なし
     */
    kyufujissekiKubun(1, 0),
    /**
     * 給付分類区分
     * <br/>1：介護給付、2：予防給付、3：介護給付+予防給付、4：総合事業（経過措置）、5：総合事業、0：区分なし
     */
    kyufuBunruiKubun(1, 0),
    /**
     * 選択可能サービス種類コード01
     */
    sentakuKanoShuruiCode01(2, 0),
    /**
     * 選択可能サービス種類コード02
     */
    sentakuKanoShuruiCode02(2, 0),
    /**
     * 選択可能サービス種類コード03
     */
    sentakuKanoShuruiCode03(2, 0),
    /**
     * 選択可能サービス種類コード04
     */
    sentakuKanoShuruiCode04(2, 0),
    /**
     * 選択可能サービス種類コード05
     */
    sentakuKanoShuruiCode05(2, 0),
    /**
     * 選択可能サービス種類コード06
     */
    sentakuKanoShuruiCode06(2, 0),
    /**
     * 選択可能サービス種類コード07
     */
    sentakuKanoShuruiCode07(2, 0),
    /**
     * 選択可能サービス種類コード08
     */
    sentakuKanoShuruiCode08(2, 0),
    /**
     * 選択可能サービス種類コード09
     */
    sentakuKanoShuruiCode09(2, 0),
    /**
     * 選択可能サービス種類コード10
     */
    sentakuKanoShuruiCode10(2, 0),
    /**
     * 選択可能サービス種類コード11
     */
    sentakuKanoShuruiCode11(2, 0),
    /**
     * 選択可能サービス種類コード12
     */
    sentakuKanoShuruiCode12(2, 0),
    /**
     * 選択可能サービス種類コード13
     */
    sentakuKanoShuruiCode13(2, 0),
    /**
     * 選択可能サービス種類コード14
     */
    sentakuKanoShuruiCode14(2, 0),
    /**
     * 選択可能サービス種類コード15
     */
    sentakuKanoShuruiCode15(2, 0),
    /**
     * 選択可能サービス種類コード16
     */
    sentakuKanoShuruiCode16(2, 0),
    /**
     * 選択可能サービス種類コード17
     */
    sentakuKanoShuruiCode17(2, 0),
    /**
     * 選択可能サービス種類コード18
     */
    sentakuKanoShuruiCode18(2, 0),
    /**
     * 選択可能サービス種類コード19
     */
    sentakuKanoShuruiCode19(2, 0),
    /**
     * 選択可能サービス種類コード20
     */
    sentakuKanoShuruiCode20(2, 0),
    /**
     * 社福選択可能種類コード01
     */
    shafukuSentakuKanoShuruiCode01(2, 0),
    /**
     * 社福選択可能種類コード02
     */
    shafukuSentakuKanoShuruiCode02(2, 0),
    /**
     * 社福選択可能種類コード03
     */
    shafukuSentakuKanoShuruiCode03(2, 0),
    /**
     * 社福選択可能種類コード04
     */
    shafukuSentakuKanoShuruiCode04(2, 0),
    /**
     * 社福選択可能種類コード05
     */
    shafukuSentakuKanoShuruiCode05(2, 0),
    /**
     * 社福選択可能種類コード06
     */
    shafukuSentakuKanoShuruiCode06(2, 0),
    /**
     * 社福選択可能種類コード07
     */
    shafukuSentakuKanoShuruiCode07(2, 0),
    /**
     * 社福選択可能種類コード08
     */
    shafukuSentakuKanoShuruiCode08(2, 0),
    /**
     * 社福選択可能種類コード09
     */
    shafukuSentakuKanoShuruiCode09(2, 0),
    /**
     * 社福選択可能種類コード10
     */
    shafukuSentakuKanoShuruiCode10(2, 0),
    /**
     * 基本設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    kihonSetteiKubun(1, 0),
    /**
     * 明細設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    meisaiSetteiKubun(1, 0),
    /**
     * 緊急時施設療養設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    kinkyuShisetsuRyoyoSetteiKubun(1, 0),
    /**
     * 特定診療費設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    tokuteiShinryoSetteiKubun(1, 0),
    /**
     * 食事費用設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    shokujiHiyosetteiKubun(1, 0),
    /**
     * 居宅計画費設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    kyotakuKeikakuSetteiKubun(1, 0),
    /**
     * 福祉用具購入費設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    fukushoyouguKonyuSetteiKubun(1, 0),
    /**
     * 住宅改修費設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    jutakukaishuSetteiKubun(1, 0),
    /**
     * 高額介護サービス費設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    kogakuKaigoSetteiKubun(1, 0),
    /**
     * 特定診療特別療養設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    tokuteishinryoTokubetsuryoyoSetteiKubun(1, 0),
    /**
     * 特定入所者設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    tokuteinyushoshaSetteiKubun(1, 0),
    /**
     * 社会福祉法人軽減設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    shakaifukushiKeigenSetteiKubun(1, 0),
    /**
     * ケアマネジメント設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    careManagementSetteiKubun(1, 0),
    /**
     * 特定疾患施設療養設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    tokuteiShikkanSetteiKubun(1, 0),
    /**
     * 明細住所地特例設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    meisaiJushochitokureiSetteiKubun(1, 0),
    /**
     * 集計設定区分
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     */
    shukeiSetteiKubun(1, 0),
    /**
     * 表示順
     */
    hyoujiJun(5, 0),
    /**
     * 過誤申立様式番号
     * <br/>過誤申立事由（様式）コードを設定する
     */
    kagoMoshitateYoshikiNo(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT3118ShikibetsuNoKanri(int maxLength, int scale) {
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
