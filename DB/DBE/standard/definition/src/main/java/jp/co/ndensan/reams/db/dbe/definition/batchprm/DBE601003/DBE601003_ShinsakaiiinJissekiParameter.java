/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601003;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class DBE601003_ShinsakaiiinJissekiParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String SHINSAKAI_JISSHIBI_FROM = "shinsakaijisshibiFrom";
    private static final String SHINSAKAI_JISSHIBI_TO = "shinsakaijisshibiTo";
    private static final String KEY_JOHO = "keyJoho";
    private static final long serialVersionUID = 8362309102168284770L;

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = SHINSAKAI_JISSHIBI_FROM, name = "審査会実施日FROM")
    private FlexibleDate shinsakaijisshibiFrom;
    @BatchParameter(key = SHINSAKAI_JISSHIBI_TO, name = "審査会実施日To")
    private FlexibleDate shinsakaijisshibiTo;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<ShinsaiinJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     */
    public DBE601003_ShinsakaiiinJissekiParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param shinsakaijisshibiFrom 審査会開催日FROM
     * @param shinsakaijisshibiTo 審査会開催日TO
     * @param keyJoho キー情報Entityリスト
     */
    public DBE601003_ShinsakaiiinJissekiParameter(RString syohyoSyuturyoku,
            FlexibleDate shinsakaijisshibiFrom,
            FlexibleDate shinsakaijisshibiTo,
            List<ShinsaiinJissekiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.shinsakaijisshibiFrom = shinsakaijisshibiFrom;
        this.shinsakaijisshibiTo = shinsakaijisshibiTo;
        this.keyJoho = keyJoho;
    }

    /**
     * 介護認定審査会委員報酬集計表のProcessParameterを作成します
     *
     * @return 介護認定審査会委員報酬集計表のProcessParameter
     */
    public ShinsaiinJissekiIchiranProcessParamter toProcessParamter() {
        return new ShinsaiinJissekiIchiranProcessParamter(syohyoSyuturyoku,
                shinsakaijisshibiFrom,
                shinsakaijisshibiTo,
                keyJoho);
    }

}
