/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushatotsugoiraiout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushatotsugoiraiout.JukyushaTotsugoIraiOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNF1003_536_受給者突合依頼情報作成Process用パラメータクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JukyushaTotsugoIraiOutProcessParameter implements IBatchProcessParameter {

    private RString chuushutuKubun;
    private FlexibleDate ninteiNengetu;
    private FlexibleDate taishouKaishiNengetu;
    private FlexibleDate taishouShuuryouNengetu;

    /**
     * コンストラクタです。
     *
     * @param chuushutuKubun 抽出区分
     * @param ninteiNengetu 認定年月
     * @param taishouKaishiNengetu 対象開始年月
     * @param taishouShuuryouNengetu 対象終了年月
     */
    public JukyushaTotsugoIraiOutProcessParameter(RString chuushutuKubun,
            FlexibleDate ninteiNengetu,
            FlexibleDate taishouKaishiNengetu,
            FlexibleDate taishouShuuryouNengetu) {
        this.chuushutuKubun = chuushutuKubun;
        this.ninteiNengetu = ninteiNengetu;
        this.taishouKaishiNengetu = taishouKaishiNengetu;
        this.taishouShuuryouNengetu = taishouShuuryouNengetu;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return JukyushaTotsugoIraiOutMybatisParameter
     */
    public JukyushaTotsugoIraiOutMybatisParameter toJukyushaTotsugoIraiOutMybatisParameter() {
        return JukyushaTotsugoIraiOutMybatisParameter.createParam(chuushutuKubun,
                ninteiNengetu,
                taishouKaishiNengetu,
                taishouShuuryouNengetu);
    }
}
