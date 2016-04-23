/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 計算後情報作成ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KeisangoJohoSakuseiMybitisParamter implements IMyBatisParameter {

    private final RString choteiNendo;
    private final RString fukaNendo;
    private final RString choteiNichiji;
    private final RString chohyoBunruiID;
    private final RString psmTotalShunyu;
    private final YMDHMS systemDate;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param chohyoBunruiID 帳票分類ID
     * @param psmTotalShunyu 収入情報取得PSM
     * @param systemDate システム日時
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KeisangoJohoSakuseiMybitisParamter(
            RString 調定年度,
            RString 賦課年度,
            RString 調定日時,
            RString 帳票分類ID,
            RString 収入情報取得PSM,
            YMDHMS システム日時) {
        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.choteiNichiji = 調定日時;
        this.chohyoBunruiID = 帳票分類ID;
        this.psmTotalShunyu = 収入情報取得PSM;
        this.systemDate = システム日時;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param chohyoBunruiID 帳票分類ID
     * @param psmTotalShunyu 収入情報取得PSM
     * @param systemDate システム日時
     *
     * @return KeisangoJohoSakuseiMybitisParamter
     */
    public static KeisangoJohoSakuseiMybitisParamter createSelectByKeyParam(RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString chohyoBunruiID,
            RString psmTotalShunyu,
            YMDHMS systemDate) {
        return new KeisangoJohoSakuseiMybitisParamter(choteiNendo,
                fukaNendo,
                choteiNichiji,
                chohyoBunruiID,
                psmTotalShunyu,
                systemDate);
    }
}
