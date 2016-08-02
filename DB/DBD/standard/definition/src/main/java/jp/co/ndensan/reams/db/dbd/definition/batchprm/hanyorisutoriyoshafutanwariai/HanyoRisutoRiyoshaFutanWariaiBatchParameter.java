/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutoriyoshafutanwariai;

import jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 汎用リスト出力(利用者負担割合)_バッチ用のパラメータです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoRiyoshaFutanWariaiBatchParameter extends BatchParameterBase {

    private static final String CYUSYUTSUHOHOKUBUN = "cyusyutsuhohokubun";
    private static final String NENDO = "nendo";
    private static final String KIZYUNNICHI = "kizyunnichi";
    private static final String JIGYOTAISHOSHAFUTANICHIWARI = "jigyotaishoshafutanichiwari";
    private static final String JIGYOTAISHOSHAFUTANNIWARI = "jigyotaishoshafutanniwari";
    private static final String NENDOCHOKINDATACYUSYUTSU = "nendochokindatacyusyutsu";
    private static final String KOMOKUMEIFUKA = "komokumeifuka";
    private static final String RENBANFUKA = "renbanfuka";
    private static final String HITSUKESURASYUHENSYU = "hitsukesurasyuhensyu";
    private static final String ATENACYUSYUTSUJYOKEN = "atenacyusyutsujyoken";
    private static final String CYOHYOID = "cyohyoid";
    private static final String SYUTSURYOKUJUN = "syutsuryokujun";
    private static final String SYUTSURYOKUKOMOKU = "syutsuryokukomoku";

    @BatchParameter(key = CYUSYUTSUHOHOKUBUN, name = "抽出方法区分")
    private RString cyusyutsuhohokubun;
    @BatchParameter(key = NENDO, name = "年度")
    private FlexibleYear nendo;
    @BatchParameter(key = KIZYUNNICHI, name = "基準日")
    private FlexibleDate kizyunnichi;
    @BatchParameter(key = NENDOCHOKINDATACYUSYUTSU, name = "年度直近データ抽出")
    private boolean isNendochokindatacyusyutsu;
    @BatchParameter(key = JIGYOTAISHOSHAFUTANICHIWARI, name = "事業対象者負担１割")
    private boolean isJigyotaishoshafutanichiwari;
    @BatchParameter(key = JIGYOTAISHOSHAFUTANNIWARI, name = "事業対象者負担２割")
    private boolean isJigyotaishoshafutanniwari;
    @BatchParameter(key = KOMOKUMEIFUKA, name = "項目名付加")
    private boolean isCsvkomokumeifuka;
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean isCsvrenbanfuka;
    @BatchParameter(key = HITSUKESURASYUHENSYU, name = "日付スラッシュ付加")
    private boolean isCsvhitsukesurasyuhensyu;
    @BatchParameter(key = ATENACYUSYUTSUJYOKEN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    @BatchParameter(key = CYOHYOID, name = "帳票ID")
    private RString cyohyoid;
    @BatchParameter(key = SYUTSURYOKUJUN, name = "出力順")
    private Long syutsuryokujun;
    @BatchParameter(key = SYUTSURYOKUKOMOKU, name = "出力項目")
    private RString syutsuryokukomoku;

    /**
     * バーチのパラメータを作成します。
     *
     * @return HanyoRisutoRiyoshaFutanWariaiProcessParameter
     */
    public HanyoRisutoRiyoshaFutanWariaiProcessParameter toHanyoRisutoRiyoshaFutanWariaiProcessParameter() {
        return new HanyoRisutoRiyoshaFutanWariaiProcessParameter(
                cyusyutsuhohokubun,
                nendo,
                kizyunnichi,
                isJigyotaishoshafutanichiwari,
                isJigyotaishoshafutanniwari,
                isNendochokindatacyusyutsu,
                isCsvkomokumeifuka,
                isCsvrenbanfuka,
                isCsvhitsukesurasyuhensyu,
                atenacyusyutsujyoken,
                cyohyoid,
                syutsuryokujun,
                syutsuryokukomoku
        );
    }
}
