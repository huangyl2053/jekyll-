/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistshotokujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報MybatisParameterのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShotokuJohoMybatisParameter implements IMyBatisParameter {

    private final ReportId 帳票ID;
    private final AtenaSelectBatchParameter 宛名抽出条件;
    private final long 出力順ID;
    private final RString 出力順;
    private final RString 出力項目ID;
    private final boolean 項目名付加;
    private final boolean 連番付加;
    private final boolean 日付編集;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 抽出期間From;
    private final YMDHMS 抽出期間To;
    private final RString 住民税減免前後表示区分;
    private final List<RString> 課税区分減免前s;
    private final List<RString> 課税区分減免後s;
    private final RString 年齢層抽出方法;
    private final Decimal 年齢範囲開始;
    private final Decimal 年齢範囲終了;
    private final RDate 生年月日範囲開始1;
    private final RDate 生年月日範囲終了1;
    private final FlexibleDate 生年月日範囲終了;
    private final FlexibleDate 生年月日範囲開始;
    private final LasdecCode 保険者コード;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタ
     *
     * @param 帳票ID ReportId
     * @param 宛名抽出条件 AtenaSelectBatchParameter
     * @param 出力順ID long
     * @param 出力項目ID RString
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付編集 boolean
     * @param 賦課年度 FlexibleYear
     * @param 抽出期間From YMDHMS
     * @param 抽出期間To YMDHMS
     * @param 住民税減免前後表示区分 RString
     * @param 課税区分減免前s List<RString>
     * @param 課税区分減免後s List<RString>
     * @param 出力順 RString
     * @param 年齢層抽出方法 RString
     * @param 年齢範囲開始 Decimal
     * @param 年齢範囲終了 Decimal
     * @param 生年月日範囲開始1 RDate
     * @param 生年月日範囲終了1 RDate
     * @param 生年月日範囲開始 FlexibleDate
     * @param 生年月日範囲終了 FlexibleDate
     * @param 保険者コード LasdecCode
     * @param shikibetsutaishoParam UaFt200FindShikibetsuTaishoParam
     */
    public HanyoListShotokuJohoMybatisParameter(ReportId 帳票ID, AtenaSelectBatchParameter 宛名抽出条件, long 出力順ID,
            RString 出力項目ID, boolean 項目名付加, boolean 連番付加, boolean 日付編集, FlexibleYear 賦課年度, YMDHMS 抽出期間From,
            YMDHMS 抽出期間To, RString 住民税減免前後表示区分, List<RString> 課税区分減免前s, List<RString> 課税区分減免後s, RString 出力順,
            RString 年齢層抽出方法, Decimal 年齢範囲開始, Decimal 年齢範囲終了, RDate 生年月日範囲開始1, RDate 生年月日範囲終了1,
            FlexibleDate 生年月日範囲開始, FlexibleDate 生年月日範囲終了, LasdecCode 保険者コード, UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam) {
        this.shikibetsutaishoParam = shikibetsutaishoParam;
        this.帳票ID = 帳票ID;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順ID = 出力順ID;
        this.出力項目ID = 出力項目ID;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付編集 = 日付編集;
        this.賦課年度 = 賦課年度;
        this.抽出期間From = 抽出期間From;
        this.抽出期間To = 抽出期間To;
        this.住民税減免前後表示区分 = 住民税減免前後表示区分;
        this.課税区分減免前s = 課税区分減免前s;
        this.課税区分減免後s = 課税区分減免後s;
        this.出力順 = 出力順;
        this.年齢層抽出方法 = 年齢層抽出方法;
        this.年齢範囲開始 = 年齢範囲開始;
        this.年齢範囲終了 = 年齢範囲終了;
        this.生年月日範囲開始1 = 生年月日範囲開始1;
        this.生年月日範囲終了1 = 生年月日範囲終了1;
        this.生年月日範囲開始 = 生年月日範囲開始;
        this.生年月日範囲終了 = 生年月日範囲終了;
        this.保険者コード = 保険者コード;
    }

}
