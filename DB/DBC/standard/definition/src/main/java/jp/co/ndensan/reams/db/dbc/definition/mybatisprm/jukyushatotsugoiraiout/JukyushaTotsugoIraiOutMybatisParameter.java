/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushatotsugoiraiout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBCMNF1003_536_受給者突合依頼情報作成Mybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JukyushaTotsugoIraiOutMybatisParameter implements IMyBatisParameter {

    private final RString chuushutuKubun;
    private final FlexibleDate ninteiNengetu;
    private final FlexibleDate taishouKaishiNengetu;
    private final FlexibleDate taishouShuuryouNengetu;

    /**
     * コンストラクタです。
     *
     * @param chuushutuKubun 抽出区分
     * @param ninteiNengetu 認定年月
     * @param taishouKaishiNengetu 対象開始年月
     * @param taishouShuuryouNengetu 対象終了年月
     */
    protected JukyushaTotsugoIraiOutMybatisParameter(RString chuushutuKubun,
            FlexibleDate ninteiNengetu,
            FlexibleDate taishouKaishiNengetu,
            FlexibleDate taishouShuuryouNengetu) {
        this.chuushutuKubun = chuushutuKubun;
        this.ninteiNengetu = ninteiNengetu;
        this.taishouKaishiNengetu = taishouKaishiNengetu;
        this.taishouShuuryouNengetu = taishouShuuryouNengetu;
    }

    /**
     * @param chuushutuKubun 抽出区分
     * @param ninteiNengetu 認定年月
     * @param taishouKaishiNengetu 対象開始年月
     * @param taishouShuuryouNengetu 対象終了年月
     * @return JukyushaTotsugoIraiOutMybatisParameter
     */
    public static JukyushaTotsugoIraiOutMybatisParameter createParam(RString chuushutuKubun,
            FlexibleDate ninteiNengetu,
            FlexibleDate taishouKaishiNengetu,
            FlexibleDate taishouShuuryouNengetu) {
        return new JukyushaTotsugoIraiOutMybatisParameter(chuushutuKubun,
                ninteiNengetu,
                taishouKaishiNengetu,
                taishouShuuryouNengetu);
    }
}
