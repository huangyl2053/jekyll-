package jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran.IkenshoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojissekiichiran.IkenshoJissekiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成実績集計表_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJissekiIchiranBatchParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String IKENSHO_KINYUBI_TO = "ikenshoKinyubiTo";
    private static final String IKENSHO_KINYUBI_FROM = "ikenshoKinyubiFrom";
    private static final String HOKENSYA = "hokensya";
    private static final String KEY_JOHO = "keyJoho";
    private static final long serialVersionUID = 8314555813503538349L;

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = IKENSHO_KINYUBI_TO, name = "意見書記入日FROM")
    private RString ikenshoKinyubiTo;
    @BatchParameter(key = IKENSHO_KINYUBI_FROM, name = "意見書記入日TO")
    private RString ikenshoKinyubiFrom;
    @BatchParameter(key = HOKENSYA, name = "保険者")
    private RString hokensya;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<IkenshoJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     */
    public IkenshoJissekiIchiranBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param ikenshoKinyubiFrom 意見書記入日FROM
     * @param ikenshoKinyubiTo 意見書記入日TO
     * @param hokensya 保険者
     * @param keyJoho キー情報Entityリスト
     */
    public IkenshoJissekiIchiranBatchParameter(RString syohyoSyuturyoku,
            RString ikenshoKinyubiFrom,
            RString ikenshoKinyubiTo,
            RString hokensya,
            List<IkenshoJissekiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.ikenshoKinyubiFrom = ikenshoKinyubiFrom;
        this.ikenshoKinyubiTo = ikenshoKinyubiTo;
        this.hokensya = hokensya;
        this.keyJoho = keyJoho;
    }

    /**
     * 主治医意見書作成実績集計表のProcessParameterを作成します
     *
     * @return 主治医意見書作成実績集計表のProcessParameter
     */
    public IkenshoJissekiIchiranProcessParameter toProcessParamter() {
        return new IkenshoJissekiIchiranProcessParameter(syohyoSyuturyoku,
                ikenshoKinyubiFrom,
                ikenshoKinyubiTo,
                hokensya,
                keyJoho);
    }
}
