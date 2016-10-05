/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110810;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushatotsugoiraiout.JukyushaTotsugoIraiOutProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNF1003_536_受給者突合依頼情報作成クラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC110810_JukyushaTotsugoIraiOutParameter extends BatchParameterBase {

    private static final String CHUUSHUTUKUBUN = "chuushutuKubun";
    private static final String NINTEINENGETU = "ninteiNengetu";
    private static final String TAISHOUKAISHINENGETU = "taishouKaishiNengetu";
    private static final String TAISHOUSHUUROUNENGETU = "taishouShuuryouNengetu";

    @BatchParameter(key = CHUUSHUTUKUBUN, name = "抽出区分")
    private RString chuushutuKubun;
    @BatchParameter(key = NINTEINENGETU, name = "認定年月")
    private FlexibleDate ninteiNengetu;
    @BatchParameter(key = TAISHOUKAISHINENGETU, name = "対象開始年月")
    private FlexibleDate taishouKaishiNengetu;
    @BatchParameter(key = TAISHOUSHUUROUNENGETU, name = "対象終了年月")
    private FlexibleDate taishouShuuryouNengetu;

    /**
     * コンストラクタです。
     */
    public DBC110810_JukyushaTotsugoIraiOutParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param chuushutuKubun 抽出区分
     * @param ninteiNengetu 認定年月
     * @param taishouKaishiNengetu 対象開始年月
     * @param taishouShuuryouNengetu 対象終了年月
     */
    public DBC110810_JukyushaTotsugoIraiOutParameter(RString chuushutuKubun,
            FlexibleDate ninteiNengetu,
            FlexibleDate taishouKaishiNengetu,
            FlexibleDate taishouShuuryouNengetu) {
        this.chuushutuKubun = chuushutuKubun;
        this.ninteiNengetu = ninteiNengetu;
        this.taishouKaishiNengetu = taishouKaishiNengetu;
        this.taishouShuuryouNengetu = taishouShuuryouNengetu;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return JIzenShinsakekkaProcessParameter
     */
    public JukyushaTotsugoIraiOutProcessParameter toJukyushaTotsugoIraiOutProcessParameter() {
        return new JukyushaTotsugoIraiOutProcessParameter(chuushutuKubun,
                ninteiNengetu,
                taishouKaishiNengetu,
                taishouShuuryouNengetu);
    }

}
