package jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi.HoshuShiharaiJunbiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 報酬支払い通知書請求書・確認書のバチパラメータクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HoshuShiharaiJunbiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = -3010965675691712156L;
    private static final String JISSEKIDATERANGE_FROM = "jissekidaterangefrom";
    private static final String JISSEKIDATERANGE_TO = "jissekidaterangeto";
    private static final String FURIKOMI_SHITEIDAY = "furikomishiteiday";
    private static final String CHK_CHOSA = "chkchosa";
    private static final String CHK_SHUJII = "chkshujii";
    private static final String CHK_SHINSAKAI = "chkshinsakai";

    @BatchParameter(key = JISSEKIDATERANGE_FROM, name = "実績期間From")
    private FlexibleDate jissekidaterangefrom;
    @BatchParameter(key = JISSEKIDATERANGE_TO, name = "実績期間To")
    private FlexibleDate jissekidaterangeto;
    @BatchParameter(key = FURIKOMI_SHITEIDAY, name = "振込指定日")
    private FlexibleDate furikomishiteiday;
    @BatchParameter(key = CHK_CHOSA, name = "認定調査報酬対象")
    private List<RString> chkchosa;
    @BatchParameter(key = CHK_SHUJII, name = "主治医意見書作成報酬対象")
    private List<RString> chkshujii;
    @BatchParameter(key = CHK_SHINSAKAI, name = "審査会委員報酬対象")
    private List<RString> chkshinsakai;

    /**
     * コンストラクタです。
     */
    public HoshuShiharaiJunbiBatchParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     * @param chkchosa 認定調査報酬対象
     * @param chkshujii 主治医意見書作成報酬対象
     * @param chkshinsakai 審査会委員報酬対象
     */
    public HoshuShiharaiJunbiBatchParameter(
            FlexibleDate jissekidaterangefrom,
            FlexibleDate jissekidaterangeto,
            FlexibleDate furikomishiteiday,
            List<RString> chkchosa,
            List<RString> chkshujii,
            List<RString> chkshinsakai) {
        this.jissekidaterangefrom = jissekidaterangefrom;
        this.jissekidaterangeto = jissekidaterangeto;
        this.furikomishiteiday = furikomishiteiday;
        this.chkchosa = chkchosa;
        this.chkshujii = chkshujii;
        this.chkshinsakai = chkshinsakai;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public HoshuShiharaiJunbiProcessParameter toHoshuShiharaiJunbiProcessParameter() {
        return new HoshuShiharaiJunbiProcessParameter(jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday,
                chkchosa,
                chkshujii,
                chkshinsakai);
    }
}
