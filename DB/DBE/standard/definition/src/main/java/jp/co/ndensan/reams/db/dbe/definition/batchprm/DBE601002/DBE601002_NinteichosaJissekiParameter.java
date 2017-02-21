package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601002;

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
public class DBE601002_NinteichosaJissekiParameter extends BatchParameterBase {

    private static final String BATCH_FLAG = "batchFlag";
    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String CHOSA_KIJUNBI_TO = "chosaKijunbiTo";
    private static final String CHOSA_KIJUNBI_FROM = "chosaKijunbiFrom";
    private static final String CHOSA_KIJUNBI_KUBUN = "chosaKijunbiKubun";
    private static final String HOKENSYA = "hokensya";
    private static final String SHOKISAI_HOKENSYA = "shokisaiHokensya";
    private static final String KEY_JOHO = "keyJoho";
    private static final String BREAK_POINT = "breakPoint";
    private static final long serialVersionUID = 8314555813503538349L;

    @BatchParameter(key = BATCH_FLAG, name = "バッチフラグ")
    private boolean batchFlag;
    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = CHOSA_KIJUNBI_TO, name = "基準日TO")
    private RString chosaKijunbiTo;
    @BatchParameter(key = CHOSA_KIJUNBI_FROM, name = "基準日FROM")
    private RString chosaKijunbiFrom;
    @BatchParameter(key = CHOSA_KIJUNBI_KUBUN, name = "基準日区分")
    private RString chosaKijunbiKubun;
    @BatchParameter(key = HOKENSYA, name = "保険者")
    private RString hokensya;
    @BatchParameter(key = SHOKISAI_HOKENSYA, name = "証記載保険者")
    private RString shokisaiHokensya;
    @BatchParameter(key = KEY_JOHO, name = "キー情報Entityリスト")
    private List<ChosahyoJissekiIchiranKey> keyJoho;
    @BatchParameter(key = BREAK_POINT, name = "改頁")
    private RString breakPoint;

    /**
     * コンストラクタです。
     */
    public DBE601002_NinteichosaJissekiParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param batchFlag
     * @param syohyoSyuturyoku 帳票出力区分
     * @param chosaKijunbiFrom 基準日FROM
     * @param chosaKijunbiTo 基準日TO
     * @param chosaKijunbiKubun 基準日区分
     * @param hokensya 保険者
     * @param shoKisaiHokensya 証記載保険者
     * @param keyJoho キー情報Entityリスト
     * @param breakPoint
     */
    public DBE601002_NinteichosaJissekiParameter(boolean batchFlag,
            RString syohyoSyuturyoku,
            RString chosaKijunbiFrom,
            RString chosaKijunbiTo,
            RString chosaKijunbiKubun,
            RString hokensya,
            RString shoKisaiHokensya,
            List<ChosahyoJissekiIchiranKey> keyJoho,
            RString breakPoint) {
        this.batchFlag = batchFlag;
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.chosaKijunbiFrom = chosaKijunbiFrom;
        this.chosaKijunbiTo = chosaKijunbiTo;
        this.chosaKijunbiKubun = chosaKijunbiKubun;
        this.hokensya = hokensya;
        this.shokisaiHokensya = shoKisaiHokensya;
        this.keyJoho = keyJoho;
        this.breakPoint = breakPoint;
    }

    /**
     * 帳票出力用認定調査実績集計表のProcessParameterを作成します
     *
     * @return 帳票出力用認定調査実績集計表のProcessParameter
     */
    public ChosahyoJissekiIchiranProcessParameter toProcessParamter() {
        return new ChosahyoJissekiIchiranProcessParameter(batchFlag,
                syohyoSyuturyoku,
                chosaKijunbiFrom,
                chosaKijunbiTo,
                chosaKijunbiKubun,
                hokensya,
                shokisaiHokensya,
                keyJoho,
                breakPoint);
    }
}
