/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsaiinjissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬集計表のバッチフロークラスパラメータです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaiinJissekiIchiranBatchParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String SHINSAKAI_KAISAIBI_FROM = "shinsakaikaisaibiFrom";
    private static final String SHINSAKAI_KAISAIBI_TO = "shinsakaikaisaibiTo";
    private static final String KEY_JOHO = "keyJoho";

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = SHINSAKAI_KAISAIBI_FROM, name = "審査会開催日FROM")
    private RString shinsakaikaisaibiFrom;
    @BatchParameter(key = SHINSAKAI_KAISAIBI_TO, name = "審査会開催日To")
    private RString shinsakaikaisaibiTo;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<ShinsaiinJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     */
    public ShinsaiinJissekiIchiranBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param shinsakaikaisaibiFrom 審査会開催日FROM
     * @param shinsakaikaisaibiTo 審査会開催日TO
     * @param keyJoho キー情報Entityリスト
     */
    public ShinsaiinJissekiIchiranBatchParameter(RString syohyoSyuturyoku,
            RString shinsakaikaisaibiFrom,
            RString shinsakaikaisaibiTo,
            List<ShinsaiinJissekiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.shinsakaikaisaibiFrom = shinsakaikaisaibiFrom;
        this.shinsakaikaisaibiTo = shinsakaikaisaibiTo;
        this.keyJoho = keyJoho;
    }

    /**
     * 介護認定審査会委員報酬集計表のProcessParameterを作成します
     *
     * @return 介護認定審査会委員報酬集計表のProcessParameter
     */
    public ShinsaiinJissekiIchiranProcessParamter toProcessParamter() {
        return new ShinsaiinJissekiIchiranProcessParamter(syohyoSyuturyoku,
                shinsakaikaisaibiFrom,
                shinsakaikaisaibiTo,
                keyJoho);
    }
}
