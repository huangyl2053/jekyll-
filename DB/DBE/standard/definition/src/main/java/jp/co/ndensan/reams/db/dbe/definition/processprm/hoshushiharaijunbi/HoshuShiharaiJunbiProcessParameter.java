package jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbi.HoshuShiharaiJunbiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 報酬支払い通知書請求書・確認書クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HoshuShiharaiJunbiProcessParameter implements IBatchProcessParameter {

    private RDateTime jissekidaterangefrom;
    private RDateTime jissekidaterangeto;
    private FlexibleDate furikomishiteiday;
    private List<RString> chkchosa;
    private List<RString> chkshujii;
    private List<RString> chkshinsakai;

    /**
     * コンストラクタ作成です。
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     * @param chkchosa 認定調査報酬対象
     * @param chkshujii 主治医意見書作成報酬対象
     * @param chkshinsakai 審査会委員報酬対象
     */
    public HoshuShiharaiJunbiProcessParameter(RDateTime jissekidaterangefrom,
            RDateTime jissekidaterangeto,
            FlexibleDate furikomishiteiday,
            List<RString> chkchosa,
            List<RString> chkshujii,
            List<RString> chkshinsakai
    ) {
        this.jissekidaterangefrom = jissekidaterangefrom;
        this.jissekidaterangeto = jissekidaterangeto;
        this.furikomishiteiday = furikomishiteiday;
        this.chkchosa = chkchosa;
        this.chkshujii = chkshujii;
        this.chkshinsakai = chkshinsakai;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return HoshuShiharaiJunbiMybatisParameter
     */
    public HoshuShiharaiJunbiMybatisParameter toHoshuShiharaiJunbiProcessParameter() {
        return HoshuShiharaiJunbiMybatisParameter.creatParameter(
                jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday
        );
    }
}
