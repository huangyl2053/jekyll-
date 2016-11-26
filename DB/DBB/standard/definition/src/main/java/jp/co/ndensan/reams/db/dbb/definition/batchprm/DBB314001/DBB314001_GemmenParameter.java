/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB314001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb314001.GemmenProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB314001_GemmenParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_CHOTEINENDO = "choteiNendo";
    private static final String KEY_FUKANENDO = "fukaNendo";
    private static final String KEY_SHINSEIYMD = "shinseiYMD";
    private static final String KEY_GEMMENJIYUCODE = "gemmenJiyuCode";
    private static final String KEY_GEMMENJIYU = "gemmenJiyu";
    private static final String KEY_KETTEIJIYU = "ketteiJiyu";
    private static final String KEY_KETTEIYMD = "ketteiYMD";
    private static final String KEY_SHINSEIJIYU = "shinseiJiyu";
    private static final String KEY_LIST町域コード = "list町域コード";
    private static final String KEY_LIST行政区コード = "list行政区コード";
    private static final String KEY_LIST地区1コード = "list地区1コード";
    private static final String KEY_LIST地区2コード = "list地区2コード";
    private static final String KEY_LIST地区3コード = "list地区3コード";

    @BatchParameter(key = KEY_CHOTEINENDO, name = "調定年度")
    private FlexibleYear choteiNendo;
    @BatchParameter(key = KEY_FUKANENDO, name = "賦課年度")
    private FlexibleYear fukaNendo;
    @BatchParameter(key = KEY_LIST町域コード, name = "list<町域コード>")
    private List<RString> list町域コード;
    @BatchParameter(key = KEY_LIST行政区コード, name = "list<行政区コード>")
    private List<RString> list行政区コード;
    @BatchParameter(key = KEY_LIST地区1コード, name = "list<地区1コード>")
    private List<RString> list地区1コード;
    @BatchParameter(key = KEY_LIST地区2コード, name = "list<地区2コード>")
    private List<RString> list地区2コード;
    @BatchParameter(key = KEY_LIST地区3コード, name = "list<地区3コード>")
    private List<RString> list地区3コード;
    @BatchParameter(key = KEY_SHINSEIYMD, name = "申請日")
    private FlexibleDate shinseiYMD;
    @BatchParameter(key = KEY_GEMMENJIYUCODE, name = "減免種類")
    private Code gemmenJiyuCode;
    @BatchParameter(key = KEY_GEMMENJIYU, name = "減免事由")
    private RString gemmenJiyu;
    @BatchParameter(key = KEY_SHINSEIJIYU, name = "申請理由")
    private RString shinseiJiyu;
    @BatchParameter(key = KEY_KETTEIYMD, name = "決定日")
    private FlexibleDate ketteiYMD;
    @BatchParameter(key = KEY_KETTEIJIYU, name = "決定理由")
    private RString ketteiJiyu;

    /**
     * toProcessParameter
     *
     * @return GemmenProcessParameter
     */
    public GemmenProcessParameter toProcessParameter() {
        return new GemmenProcessParameter(choteiNendo, fukaNendo, list町域コード, list行政区コード, list地区1コード,
                list地区2コード, list地区3コード, shinseiYMD, gemmenJiyuCode, gemmenJiyu, shinseiJiyu, ketteiYMD, ketteiJiyu);
    }
}
