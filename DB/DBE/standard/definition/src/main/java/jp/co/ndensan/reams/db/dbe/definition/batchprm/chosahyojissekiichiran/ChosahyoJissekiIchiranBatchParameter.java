package jp.co.ndensan.reams.db.dbe.definition.batchprm.chosahyojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyojissekiichiran.ChosahyoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.processprm.chosahyojissekiichiran.ChosahyoJissekiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoJissekiIchiranBatchParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String CHOSA_JISSHIBI_TO = "chosajisshibiTo";
    private static final String CHOSA_JISSHIBI_FROM = "chosajisshibiFrom";
    private static final String HOKENSYA = "hokensya";
    private static final String KEY_JOHO = "keyJoho";
    private static final long serialVersionUID = 8314555813503538349L;

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = CHOSA_JISSHIBI_TO, name = "調査実施日FROM")
    private RString chosajisshibiTo;
    @BatchParameter(key = CHOSA_JISSHIBI_FROM, name = "調査実施日TO")
    private RString chosajisshibiFrom;
    @BatchParameter(key = HOKENSYA, name = "保険者")
    private RString hokensya;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<ChosahyoJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     */
    public ChosahyoJissekiIchiranBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param chosajisshibiFrom 調査実施日FROM
     * @param chosajisshibiTo 調査実施日TO
     * @param hokensya 保険者
     * @param keyJoho キー情報Entityリスト
     */
    public ChosahyoJissekiIchiranBatchParameter(RString syohyoSyuturyoku,
            RString chosajisshibiFrom,
            RString chosajisshibiTo,
            RString hokensya,
            List<ChosahyoJissekiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.chosajisshibiFrom = chosajisshibiFrom;
        this.chosajisshibiTo = chosajisshibiTo;
        this.hokensya = hokensya;
        this.keyJoho = keyJoho;
    }

    /**
     * 帳票出力用認定調査実績集計表のProcessParameterを作成します
     *
     * @return 帳票出力用認定調査実績集計表のProcessParameter
     */
    public ChosahyoJissekiIchiranProcessParameter toProcessParamter() {
        return new ChosahyoJissekiIchiranProcessParameter(syohyoSyuturyoku,
                chosajisshibiFrom,
                chosajisshibiTo,
                hokensya,
                keyJoho);
    }
}
