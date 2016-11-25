/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のMybatisParameter
 *
 * @reamsid_L DBB-1670-030 surun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final List<RString> list町域コード;
    private final List<RString> list行政区コード;
    private final List<RString> list地区1コード;
    private final List<RString> list地区2コード;
    private final List<RString> list地区3コード;
    private final boolean has抽出条件;
    private final FlexibleDate shinseiYMD;
    private final Code gemmenJiyuCode;
    private final RString shinseiJiyu;
    private final FlexibleDate ketteiYMD;
    private final RString gemmenJiyu;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタ
     *
     * @param choteiNendo FlexibleYear
     * @param fukaNendo FlexibleYear
     * @param list町域コード List<RString>
     * @param list行政区コード List<RString>
     * @param list地区1コード List<RString>
     * @param list地区2コード List<RString>
     * @param list地区3コード List<RString>
     * @param shinseiYMD FlexibleDate
     * @param gemmenJiyuCode Code
     * @param shinseiJiyu RString
     * @param ketteiYMD FlexibleDate
     * @param gemmenJiyu RString
     * @param shikibetsutaishoParam UaFt200FindShikibetsuTaishoParam
     */
    public GemmenMybatisParameter(FlexibleYear choteiNendo, FlexibleYear fukaNendo, List<RString> list町域コード,
            List<RString> list行政区コード, List<RString> list地区1コード, List<RString> list地区2コード, List<RString> list地区3コード,
            FlexibleDate shinseiYMD, Code gemmenJiyuCode, RString shinseiJiyu, FlexibleDate ketteiYMD, RString gemmenJiyu,
            UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.list町域コード = list町域コード;
        this.list行政区コード = list行政区コード;
        this.list地区1コード = list地区1コード;
        this.list地区2コード = list地区2コード;
        this.list地区3コード = list地区3コード;
        this.has抽出条件 = null != list町域コード
                || null != list行政区コード
                || null != list地区1コード
                || null != list地区2コード
                || null != list地区3コード;
        this.shinseiYMD = shinseiYMD;
        this.gemmenJiyuCode = gemmenJiyuCode;
        this.shinseiJiyu = shinseiJiyu;
        this.ketteiYMD = ketteiYMD;
        this.gemmenJiyu = gemmenJiyu;
        this.shikibetsutaishoParam = shikibetsutaishoParam;
    }

}
