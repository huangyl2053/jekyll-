package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbi;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;

/**
 * 報酬支払い通知書請求書・確認書のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class HoshuShiharaiJunbiMybatisParameter implements IMyBatisParameter {

    private final RDateTime jissekidaterangefrom;
    private final RDateTime jissekidaterangeto;
    private final FlexibleDate furikomishiteiday;

    /**
     * コンストラクタです。
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     */
    protected HoshuShiharaiJunbiMybatisParameter(RDateTime jissekidaterangefrom,
            RDateTime jissekidaterangeto,
            FlexibleDate furikomishiteiday
    ) {
        this.jissekidaterangefrom = jissekidaterangefrom;
        this.jissekidaterangeto = jissekidaterangeto;
        this.furikomishiteiday = furikomishiteiday;
    }

    /**
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     * @return HoshuShiharaiJunbiMybatisParameter
     */
    public static HoshuShiharaiJunbiMybatisParameter creatParameter(RDateTime jissekidaterangefrom,
            RDateTime jissekidaterangeto,
            FlexibleDate furikomishiteiday) {
        return new HoshuShiharaiJunbiMybatisParameter(
                jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday);
    }
}
