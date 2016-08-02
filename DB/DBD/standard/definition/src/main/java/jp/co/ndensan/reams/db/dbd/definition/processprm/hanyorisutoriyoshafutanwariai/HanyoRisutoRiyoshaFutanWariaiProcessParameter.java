/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutoriyoshafutanwariai;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(利用者負担割合)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoRiyoshaFutanWariaiProcessParameter implements IBatchProcessParameter {

    private RString cyusyutsuhohokubun;
    private FlexibleYear nendo;
    private FlexibleDate kizyunnichi;
    private boolean isJigyotaishoshafutanichiwari;
    private boolean isJigyotaishoshafutanniwari;
    private boolean isNendochokindatacyusyutsu;
    private boolean isCsvkomokumeifuka;
    private boolean isCsvrenbanfuka;
    private boolean isCsvhitsukesurasyuhensyu;
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    private RString cyohyoid;
    private Long syutsuryokujun;
    private RString syutsuryokukomoku;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsuhohokubun 抽出方法区分
     * @param nendo 年度
     * @param kizyunnichi 基準日
     * @param isJigyotaishoshafutanichiwari 事業対象者負担１割
     * @param isJigyotaishoshafutanniwari 事業対象者負担２割
     * @param isNendochokindatacyusyutsu 年度直近データ抽出
     * @param isCsvkomokumeifuka CSV項目名付加
     * @param isCsvrenbanfuka CSV連番付加
     * @param isCsvhitsukesurasyuhensyu CSV日付スラッシュ編集
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param cyohyoid 帳票ID
     * @param syutsuryokujun 出力順
     * @param syutsuryokukomoku 出力項目
     */
    public HanyoRisutoRiyoshaFutanWariaiProcessParameter(RString cyusyutsuhohokubun, FlexibleYear nendo,
            FlexibleDate kizyunnichi, boolean isJigyotaishoshafutanichiwari, boolean isJigyotaishoshafutanniwari,
            boolean isNendochokindatacyusyutsu, boolean isCsvkomokumeifuka, boolean isCsvrenbanfuka, boolean isCsvhitsukesurasyuhensyu,
            AtenaSelectBatchParameter atenacyusyutsujyoken, RString cyohyoid, Long syutsuryokujun, RString syutsuryokukomoku) {
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.nendo = nendo;
        this.kizyunnichi = kizyunnichi;
        this.isJigyotaishoshafutanichiwari = isJigyotaishoshafutanichiwari;
        this.isJigyotaishoshafutanniwari = isJigyotaishoshafutanniwari;
        this.isNendochokindatacyusyutsu = isNendochokindatacyusyutsu;
        this.isCsvkomokumeifuka = isCsvkomokumeifuka;
        this.isCsvrenbanfuka = isCsvrenbanfuka;
        this.isCsvhitsukesurasyuhensyu = isCsvhitsukesurasyuhensyu;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.cyohyoid = cyohyoid;
        this.syutsuryokujun = syutsuryokujun;
        this.syutsuryokukomoku = syutsuryokukomoku;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @param syutsuryokujun 出力順
     * @return HanyoRisutoRiyoshaFutanWariaiMybatisParameter
     */
    public HanyoRisutoRiyoshaFutanWariaiMybatisParameter toHanyoRisutoRiyoshaFutanWariaiMybatisParameter(RString psmShikibetsuTaisho,
            RString psmAtesaki, RString syutsuryokujun) {
        return new HanyoRisutoRiyoshaFutanWariaiMybatisParameter(
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
                syutsuryokujun,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
