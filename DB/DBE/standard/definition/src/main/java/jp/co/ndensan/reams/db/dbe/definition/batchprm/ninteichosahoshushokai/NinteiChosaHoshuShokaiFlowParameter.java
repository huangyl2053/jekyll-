/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
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
    private static final String KANKEY_LIST = "コードリスト";
    private static final String KEY_ENTITY = "合計Entity";
    private static final long serialVersionUID = 1L;

    @BatchParameter(key = KUBUNCODE, name = "帳票出力区分")
    private RString 帳票出力区分;
    @BatchParameter(key = KANKEY_LIST, name = "キー情報Entityリスト")
    private List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト;
    @BatchParameter(key = KEY_ENTITY, name = "合計Entity")
    private NinteiChosaHoshuGoKeFlowBusiness 合計情報;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuShokaiFlowParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 RString
     * @param 合計情報 NinteiChosaHoshuGoKeFlowBusiness
     * @param 情報リスト List<NinteiChosaHoshuShokaiFlowBusiness>
     */
    public NinteiChosaHoshuShokaiFlowParameter(RString 帳票出力区分, NinteiChosaHoshuGoKeFlowBusiness 合計情報,
            List<NinteiChosaHoshuShokaiFlowBusiness> 情報リスト) {
        this.帳票出力区分 = 帳票出力区分;
        this.情報リスト = 情報リスト;
        this.合計情報 = 合計情報;

    }
}
