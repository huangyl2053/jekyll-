package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601001;

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
public class DBE601001_IkenshoSakuseiJIssekiParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String IKENSHO_KIJUNBI_TO = "ikenshoKijunbiTo";
    private static final String IKENSHO_KIJUNBI_FROM = "ikenshoKijunbiFrom";
    private static final String IKENSHO_SHUKEI = "ikenshoKijunbiKubun";
    private static final String HOKENSYA = "hokensya";
    private static final String SHOKISAI_HOKENSYA = "shokisaiHokensya";
    private static final String KEY_JOHO = "keyJoho";
    private static final long serialVersionUID = 8314555813503538349L;

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = IKENSHO_KIJUNBI_TO, name = "基準日FROM")
    private RString ikenshoKijunbiTo;
    @BatchParameter(key = IKENSHO_KIJUNBI_FROM, name = "基準日TO")
    private RString ikenshoKijunbiFrom;
    @BatchParameter(key = IKENSHO_SHUKEI, name = "基準日")
    private RString ikenshoKijunbiKubun;
    @BatchParameter(key = HOKENSYA, name = "保険者")
    private RString hokensya;
    @BatchParameter(key = SHOKISAI_HOKENSYA, name = "証記載保険者")
    private RString shokisaiHokensya;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<IkenshoJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     */
    public DBE601001_IkenshoSakuseiJIssekiParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param ikenshoKinyubiFrom 意見書記入日FROM
     * @param ikenshoKinyubiTo 意見書記入日TO
     * @param hokensya 保険者
     * @param shokisaiHokensya 証記載保険者
     * @param keyJoho キー情報Entityリスト
     */
    public DBE601001_IkenshoSakuseiJIssekiParameter(RString syohyoSyuturyoku,
            RString ikenshoKinyubiFrom,
            RString ikenshoKinyubiTo,
            RString hokensya,
            RString shokisaiHokensya,
            List<IkenshoJissekiIchiranKey> keyJoho) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.ikenshoKijunbiFrom = ikenshoKinyubiFrom;
        this.ikenshoKijunbiTo = ikenshoKinyubiTo;
        this.shokisaiHokensya = shokisaiHokensya;
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
                ikenshoKijunbiFrom,
                ikenshoKijunbiTo,
                ikenshoKijunbiKubun,
                shokisaiHokensya,
                hokensya,
                keyJoho);
    }
}
