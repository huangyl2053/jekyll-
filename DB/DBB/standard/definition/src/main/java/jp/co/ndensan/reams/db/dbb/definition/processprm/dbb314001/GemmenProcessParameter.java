/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb314001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のProcessParameter
 *
 * @reamsid_L DBB-1670-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenProcessParameter implements IBatchProcessParameter {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private List<RString> list町域コード;
    private List<RString> list行政区コード;
    private List<RString> list地区1コード;
    private List<RString> list地区2コード;
    private List<RString> list地区3コード;
    private FlexibleDate shinseiYMD;
    private Code gemmenJiyuCode;
    private RString gemmenJiyu;
    private RString shinseiJiyu;
    private FlexibleDate ketteiYMD;
    private RString ketteiJiyu;
    private UaFt200FindShikibetsuTaishoParam 宛名検索条件;

    /**
     * コンストラクタ
     *
     * @param 宛名検索条件 UaFt200FindShikibetsuTaishoParam
     */
    public GemmenProcessParameter(UaFt200FindShikibetsuTaishoParam 宛名検索条件) {
        this.宛名検索条件 = 宛名検索条件;
    }

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
     * @param gemmenJiyu RString
     * @param shinseiJiyu RString
     * @param ketteiYMD FlexibleDate
     * @param ketteiJiyu RString
     */
    public GemmenProcessParameter(FlexibleYear choteiNendo, FlexibleYear fukaNendo, List<RString> list町域コード,
            List<RString> list行政区コード, List<RString> list地区1コード, List<RString> list地区2コード, List<RString> list地区3コード,
            FlexibleDate shinseiYMD, Code gemmenJiyuCode, RString gemmenJiyu, RString shinseiJiyu, FlexibleDate ketteiYMD, RString ketteiJiyu) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.list町域コード = list町域コード;
        this.list行政区コード = list行政区コード;
        this.list地区1コード = list地区1コード;
        this.list地区2コード = list地区2コード;
        this.list地区3コード = list地区3コード;
        this.shinseiYMD = shinseiYMD;
        this.gemmenJiyuCode = gemmenJiyuCode;
        this.gemmenJiyu = gemmenJiyu;
        this.shinseiJiyu = shinseiJiyu;
        this.ketteiYMD = ketteiYMD;
        this.ketteiJiyu = ketteiJiyu;
    }

    /**
     * toMybatisParameter
     *
     * @return GemmenMybatisParameter
     */
    public GemmenMybatisParameter toMybatisParameter() {
        return new GemmenMybatisParameter(choteiNendo, fukaNendo, list町域コード, list行政区コード, list地区1コード,
                list地区2コード, list地区3コード, shinseiYMD, gemmenJiyuCode, shinseiJiyu, ketteiYMD, ketteiJiyu, 宛名検索条件);
    }

}
