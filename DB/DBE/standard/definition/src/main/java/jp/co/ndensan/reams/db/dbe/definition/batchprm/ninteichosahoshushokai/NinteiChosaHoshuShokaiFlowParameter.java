/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬照会のbatch用パラメータクラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaHoshuShokaiFlowParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KUBUNCODE = "帳票出力区分";
    private static final String START_DAY = "調査依頼日開始";
    private static final String END_DAY = "調査依頼日終了";
    private static final String KEY_ENTITY = "キー情報Entityリスト";
    private static final long serialVersionUID = 1L;

    @BatchParameter(key = KUBUNCODE, name = "帳票出力区分")
    private RString 帳票出力区分;
    @BatchParameter(key = KEY_ENTITY, name = "キー情報Entityリスト")
    private List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト;
    @BatchParameter(key = START_DAY, name = "調査依頼日開始")
    private FlexibleDate 調査依頼日開始;
    @BatchParameter(key = END_DAY, name = "調査依頼日終了")
    private FlexibleDate 調査依頼日終了;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuShokaiFlowParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 RString
     * @param 情報リスト List<NinteiChosaHoshuShokaiFlowBusiness>
     * @param 調査依頼日開始 調査依頼日開始
     * @param 調査依頼日終了 調査依頼日終了
     */
    public NinteiChosaHoshuShokaiFlowParameter(RString 帳票出力区分, List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト,
            FlexibleDate 調査依頼日開始, FlexibleDate 調査依頼日終了) {
        this.帳票出力区分 = 帳票出力区分;
        this.情報リスト = 情報リスト;
        this.調査依頼日開始 = 調査依頼日開始;
        this.調査依頼日終了 = 調査依頼日終了;
    }

    /**
     * 認定調査報酬照会のProcessParameterを作成します。
     *
     * @return 認定調査報酬照会のProcessParameter
     */
    public NinteiChosaHoshuShokaiProcessParameter toProcessParamter() {
        return new NinteiChosaHoshuShokaiProcessParameter(帳票出力区分, 調査依頼日開始, 調査依頼日終了, 情報リスト);
    }
}
