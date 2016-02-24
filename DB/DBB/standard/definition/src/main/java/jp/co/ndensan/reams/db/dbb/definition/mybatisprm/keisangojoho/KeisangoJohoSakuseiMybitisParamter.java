/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 計算後情報作成ですためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KeisangoJohoSakuseiMybitisParamter implements IMyBatisParameter {

    private final RString choteiNendo;
    private final RString fukaNendo;
    private final RString choteiNichiji;
    private final RString sakuseiShoriName;
    private final RString chohyoBunruiID;
    private final RString psmTotalShunyu;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param sakuseiShoriName 作成処理名
     * @param chohyoBunruiID 帳票分類ID
     * @param psmTotalShunyu 収入情報取得PSM
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KeisangoJohoSakuseiMybitisParamter(
            RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString sakuseiShoriName,
            RString chohyoBunruiID,
            RString psmTotalShunyu) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.choteiNichiji = choteiNichiji;
        this.sakuseiShoriName = sakuseiShoriName;
        this.chohyoBunruiID = chohyoBunruiID;
        this.psmTotalShunyu = psmTotalShunyu;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param sakuseiShoriName 作成処理名
     * @param chohyoBunruiID 帳票分類ID
     * @param psmTotalShunyu 収入情報取得PSM
     *
     * @return KeisangoJohoSakuseiMybitisParamter
     */
    public static KeisangoJohoSakuseiMybitisParamter createSelectByKeyParam(RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString sakuseiShoriName,
            RString chohyoBunruiID,
            RString psmTotalShunyu) {
        return new KeisangoJohoSakuseiMybitisParamter(choteiNendo,
                fukaNendo,
                choteiNichiji,
                sakuseiShoriName,
                chohyoBunruiID,
                psmTotalShunyu);
    }
}
