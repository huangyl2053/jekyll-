package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3017KyufujissekiKihonの項目定義クラスです
 *
 */
public enum DbT3017KyufujissekiKihon implements IColumnDefinition {
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
     * 交換情報識別番号
     */
    kokanShikibetsuNo(2147483647, 0),
    /**
     * 入力識別番号
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * レコード種別コード
     */
    recodeShubetsuCode(2, 0),
    /**
     * 給付実績情報作成区分コード
     * <br/>1:新規2:修正3:取消
     */
    kyufuSakuseiKubunCode(1, 0),
    /**
     * 証記載保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 給付実績区分コード
     * <br/>1:現物2:償還
     */
    kyufuJissekiKubunCode(1, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 公費１・負担者番号
     */
    kohi1FutanshaNo(8, 0),
    /**
     * 公費１・受給者番号
     */
    kohi1JukyushaNo(7, 0),
    /**
     * 公費２・負担者番号
     */
    kohi2FutanshaNo(8, 0),
    /**
     * 公費２・受給者番号
     */
    kohi2JukyushaNo(7, 0),
    /**
     * 公費３・負担者番号
     */
    kohi3FutanshaNo(8, 0),
    /**
     * 公費３・受給者番号
     */
    kohi3JukyushaNo(7, 0),
    /**
     * 生年月日
     */
    umareYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 要介護状態区分コード
     */
    yoKaigoJotaiKubunCode(2, 0),
    /**
     * 旧措置入所者特例コード
     */
    kyuSochiNyushoshaTokureiCode(1, 0),
    /**
     * 認定有効期間・開始年月日
     */
    ninteiYukoKaishiYMD(2147483647, 0),
    /**
     * 認定有功期間・終了年月日
     */
    ninteiYukoShuryoYMD(2147483647, 0),
    /**
     * 老人保健市町村番号
     */
    rojinHokenShichosonNo(8, 0),
    /**
     * 老人保健受給者番号
     */
    rojinhokenJukyushaNo(7, 0),
    /**
     * 保険者番号（後期）
     * <br/>サービス提供年月が平成２０年４月以降の場合
     */
    kokiHokenshaNo(8, 0),
    /**
     * 被保険者番号（後期）
     * <br/>サービス提供年月が平成２０年５月以降の場合
     */
    kokiHiHokenshaNo(8, 0),
    /**
     * 保険者番号（国保）
     * <br/>サービス提供年月が平成２０年６月以降の場合
     */
    kokuhoHokenshaNo(8, 0),
    /**
     * 被保険者証番号（国保）
     * <br/>サービス提供年月が平成２０年７月以降の場合
     */
    kokuhoHiHokenshashoNo(20, 0),
    /**
     * 個人番号（国保）
     * <br/>サービス提供年月が平成２０年８月以降の場合
     */
    kokuhoKojinNo(10, 0),
    /**
     * 居宅サービス計画作成区分コード
     */
    kyotakuServiceSakuseiKubunCode(1, 0),
    /**
     * 事業所番号(居宅介護支援事業所等)
     */
    kyotakuKaigoShienJigyoshoNo(2147483647, 0),
    /**
     * 開始年月日
     */
    kaishiYMD(2147483647, 0),
    /**
     * 中止年月日
     */
    chushiYMD(2147483647, 0),
    /**
     * 中止理由・入所（院）前の状況コード
     */
    chushiRiyuNyushomaeJyokyoCode(1, 0),
    /**
     * 入所（院）年月日
     */
    nyushoYMD(2147483647, 0),
    /**
     * 退所（院）年月日
     */
    taishoYMD(2147483647, 0),
    /**
     * 入所（院）実日数
     */
    nyushoJitsunissu(5, 0),
    /**
     * 外泊日数
     */
    gaihakuNissu(5, 0),
    /**
     * 退所（院）後の状態コード
     */
    taishogoJotaiCode(1, 0),
    /**
     * 保険給付率
     */
    hokenKyufuritsu(2147483647, 0),
    /**
     * 公費１給付率
     */
    kohi1Kyufuritsu(2147483647, 0),
    /**
     * 公費２給付率
     */
    kohi2Kyufuritsu(2147483647, 0),
    /**
     * 公費３給付率
     */
    kohi3Kyufuritsu(2147483647, 0),
    /**
     * 前・保険・サービス単位数
     */
    maeHokenServiceTanisu(10, 0),
    /**
     * 前・保険・請求額
     */
    maeHokenSeikyugaku(9, 0),
    /**
     * 前・保険・利用者負担額
     */
    maeHokenRiyoshaFutangaku(10, 0),
    /**
     * 前・保険・緊急時施設療養費請求額
     */
    maeHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    /**
     * 前・保険・特定診療費請求額
     */
    maeHokenTokuteiShinryohiSeikyugaku(9, 0),
    /**
     * 前・保険・特定入所者介護サービス費等請求額
     */
    maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 前・公費１・サービス単位数
     */
    maeKohi1ServiceTanisu(10, 0),
    /**
     * 前・公費１・請求額
     */
    maeKohi1Seikyugaku(10, 0),
    /**
     * 前・公費１・本人負担額
     */
    maeKohi1RiyoshaFutangaku(10, 0),
    /**
     * 前・公費１・緊急時施設療養費請求額
     */
    maeKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 前・公費１・特定診療費請求額
     */
    maeKohi1TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 前・公費１・特定入所者介護サービス費等請求額
     */
    maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 前・公費２・サービス単位数
     */
    maeKohi2ServiceTanisu(10, 0),
    /**
     * 前・公費２・請求額
     */
    maeKohi2Seikyugaku(10, 0),
    /**
     * 前・公費２・本人負担額
     */
    maeKohi2RiyoshaFutangaku(10, 0),
    /**
     * 前・公費２・緊急時施設療養費請求額
     */
    maeKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 前・公費２・特定診療費請求額
     */
    maeKohi2TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 前・公費２・特定入所者介護サービス費等請求額
     */
    maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 前・公費３・サービス単位数
     */
    maeKohi3ServiceTanisu(10, 0),
    /**
     * 前・公費３・請求額
     */
    maeKohi3Seikyugaku(10, 0),
    /**
     * 前・公費３・本人負担額
     */
    maeKohi3RiyoshaFutangaku(10, 0),
    /**
     * 前・公費３・緊急時施設療養費請求額
     */
    maeKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 前・公費３・特定診療費請求額
     */
    maeKohi3TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 前・公費３・特定入所者介護サービス費等請求額
     */
    maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 後・保険・サービス単位数
     */
    atoHokenServiceTanisu(10, 0),
    /**
     * 後・保険・請求額
     */
    atoHokenSeikyugaku(9, 0),
    /**
     * 後・保険・利用者負担額
     */
    atoHokenRiyoshaFutangaku(10, 0),
    /**
     * 後・緊急時施設療養費請求額
     */
    atoHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    /**
     * 後・保険・特定診療費請求額
     */
    atoHokenTokuteiShinryohiSeikyugaku(9, 0),
    /**
     * 後・保険・特定入所者介護サービス費等請求額
     */
    atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 後・公費１・サービス単位数
     */
    atoKohi1ServiceTanisu(10, 0),
    /**
     * 後・公費１・請求額
     */
    atoKohi1Seikyugaku(10, 0),
    /**
     * 後・公費１・本人負担額
     */
    atoKohi1RiyoshaFutangaku(10, 0),
    /**
     * 後・公費１・緊急時施設療養費請求額
     */
    atoKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 後・公費１・特定診療費請求額
     */
    atoKohi1TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 後・公費１・特定入所者介護サービス費等請求額
     */
    atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 後・公費２・サービス単位数
     */
    atoKohi2ServiceTanisu(10, 0),
    /**
     * 後・公費２・請求額
     */
    atoKohi2Seikyugaku(10, 0),
    /**
     * 後・公費２・利用者負担額
     */
    atoKohi2RiyoshaFutangaku(10, 0),
    /**
     * 後・公費２・緊急時施設療養費請求額
     */
    atoKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 後・公費２・特定診療費請求額
     */
    atoKohi2TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 後・公費２・特定入所者介護サービス費等請求額
     */
    atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 後・公費３・サービス単位数
     */
    atoKohi3ServiceTanisu(10, 0),
    /**
     * 後・公費３・請求額
     */
    atoKohi3Seikyugaku(10, 0),
    /**
     * 後・公費３・利用者負担額
     */
    atoKohi3RiyoshaFutangaku(10, 0),
    /**
     * 後・公費３・緊急時施設療養費請求額
     */
    atoKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * 後・公費３・特定診療費請求額
     */
    atoKohi3TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * 後・公費３・特定入所者介護サービス費等請求額
     */
    atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * 警告区分コード
     * <br/>１：警告なし　２：警告あり
     */
    keikaiKubunCode(1, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0),
    /**
     * 独自作成区分
     */
    dokujiSakuseiKubun(1, 0),
    /**
     * 保険者保有給付実績情報削除済フラグ
     */
    hokenshaHoyuKyufujissekiJohoSakujoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3017KyufujissekiKihon(int maxLength, int scale) {
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
