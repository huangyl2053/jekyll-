/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistshotokujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報MybatisParameterのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShotokuJohoMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final ReportId 帳票ID;
    private final AtenaSelectBatchParameter 宛名抽出条件;
    private final long 出力順ID;
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
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public HanyoListShotokuJohoMybatisParameter(ReportId 帳票ID, AtenaSelectBatchParameter 宛名抽出条件, long 出力順ID,
            RString 出力項目ID, boolean 項目名付加, boolean 連番付加, boolean 日付編集, FlexibleYear 賦課年度, YMDHMS 抽出期間From,
            YMDHMS 抽出期間To, RString 住民税減免前後表示区分, List<RString> 課税区分減免前s, List<RString> 課税区分減免後s,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
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
    }

}
