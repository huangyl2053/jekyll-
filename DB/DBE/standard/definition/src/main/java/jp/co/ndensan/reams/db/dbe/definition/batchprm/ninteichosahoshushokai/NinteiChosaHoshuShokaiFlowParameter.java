/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬照会のbatch用パラメータクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaHoshuShokaiFlowParameter extends BatchParameterBase {

    private static final String KUBUNCODE = "帳票出力区分";
    private static final String IRAIRIREKI_STARTYMD = "調査依頼日開始";
    private static final String IRAIRIREKI_ENDYMD = "調査依頼日終了";
    private static final String CHOSAKIKANKEY_LIST = "委託先コードリスト";
    private static final String CHOSAKIKEY_LIST = "調査員コードリスト";
    private static final String KANRIKEY_LIST = "管理番号リスト";
    private static final String RIREKIKEY_LIST = "履歴番号リスト";
    private static final long serialVersionUID = 1L;

    @BatchParameter(key = KUBUNCODE, name = "帳票出力区分")
    private RString 帳票出力区分;
    @BatchParameter(key = IRAIRIREKI_STARTYMD, name = "調査依頼日開始")
    private FlexibleDate 調査依頼日開始;
    @BatchParameter(key = IRAIRIREKI_ENDYMD, name = "調査依頼日終了")
    private FlexibleDate 調査依頼日終了;
    @BatchParameter(key = CHOSAKIKANKEY_LIST, name = "キー情報Entityリスト")
    private List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuShokaiFlowParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 RString
     * @param 調査依頼日開始 FlexibleDate
     * @param 調査依頼日終了 FlexibleDate
     * @param 情報リスト List<NinteiChosaHoshuShokaiFlowBusiness>
     */
    public NinteiChosaHoshuShokaiFlowParameter(RString 帳票出力区分, FlexibleDate 調査依頼日開始, FlexibleDate 調査依頼日終了,
            List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト) {
        this.帳票出力区分 = 帳票出力区分;
        this.調査依頼日終了 = 調査依頼日終了;
        this.調査依頼日開始 = 調査依頼日開始;
        this.情報リスト = 情報リスト;

    }
}
