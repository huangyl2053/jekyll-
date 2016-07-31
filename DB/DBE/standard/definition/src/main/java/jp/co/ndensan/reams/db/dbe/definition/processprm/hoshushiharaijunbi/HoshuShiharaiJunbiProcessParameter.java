package jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbi.HoshuShiharaiJunbiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

    private FlexibleDate jissekidaterangefrom;
    private FlexibleDate jissekidaterangeto;
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
    public HoshuShiharaiJunbiProcessParameter(FlexibleDate jissekidaterangefrom,
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
     * Mybatisのパラメータを作成します。
     *
     * @return HoshuShiharaiJunbiMybatisParameter
     */
    public HoshuShiharaiJunbiMybatisParameter toHoshuShiharaiJunbiProcessParameter() {

        RString 報酬基準日 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書報酬基準日, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援);
        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援);
        return HoshuShiharaiJunbiMybatisParameter.creatParameter(
                jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                イメージ区分,
                報酬基準日,
                new RString("1").equals(報酬基準日));
    }
}
