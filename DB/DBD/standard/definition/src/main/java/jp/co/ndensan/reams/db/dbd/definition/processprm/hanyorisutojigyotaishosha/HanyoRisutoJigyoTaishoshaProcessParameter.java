/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutojigyotaishosha;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(事業対象者)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-5080-030 mawy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoJigyoTaishoshaProcessParameter implements IBatchProcessParameter {

    private RString cyusyutsuhohokubun;
    private RString cyusyutsukomokukubun;
    private FlexibleDate kizyunnichi;
    private FlexibleDate hitsukehanifrom;
    private FlexibleDate hitsukehanito;
    private boolean isJigyotaishoshadatacyusyutsu;
    private RString soshitsukubun;
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
     * @param cyusyutsukomokukubun 抽出項目区分
     * @param kizyunnichi 基準日
     * @param hitsukehanifrom 日付範囲From
     * @param hitsukehanito 日付範囲To
     * @param isJigyotaishoshadatacyusyutsu 事業対象者データ抽出
     * @param soshitsukubun 喪失区分
     * @param isCsvkomokumeifuka CSV項目名付加
     * @param isCsvrenbanfuka CSV連番付加
     * @param isCsvhitsukesurasyuhensyu CSV日付スラッシュ編集
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param cyohyoid 帳票ID
     * @param syutsuryokujun 出力順
     * @param syutsuryokukomoku 出力項目
     */
    public HanyoRisutoJigyoTaishoshaProcessParameter(RString cyusyutsuhohokubun, RString cyusyutsukomokukubun,
            FlexibleDate kizyunnichi, FlexibleDate hitsukehanifrom, FlexibleDate hitsukehanito, boolean isJigyotaishoshadatacyusyutsu,
            RString soshitsukubun, boolean isCsvkomokumeifuka, boolean isCsvrenbanfuka, boolean isCsvhitsukesurasyuhensyu,
            AtenaSelectBatchParameter atenacyusyutsujyoken, RString cyohyoid, Long syutsuryokujun, RString syutsuryokukomoku) {
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.cyusyutsukomokukubun = cyusyutsukomokukubun;
        this.kizyunnichi = kizyunnichi;
        this.hitsukehanifrom = hitsukehanifrom;
        this.hitsukehanito = hitsukehanito;
        this.isJigyotaishoshadatacyusyutsu = isJigyotaishoshadatacyusyutsu;
        this.soshitsukubun = soshitsukubun;
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
     * @return HanyoRisutoKokiKoreishaMybatisParameter
     */
    public HanyoRisutoJigyoTaishoshaMybatisParameter toHanyoRisutoJigyoTaishoshaMybatisParameter(RString psmShikibetsuTaisho,
            RString psmAtesaki, RString syutsuryokujun) {
        return new HanyoRisutoJigyoTaishoshaMybatisParameter(cyusyutsuhohokubun,
                cyusyutsukomokukubun,
                kizyunnichi,
                hitsukehanifrom,
                hitsukehanito,
                isJigyotaishoshadatacyusyutsu,
                soshitsukubun,
                atenacyusyutsujyoken,
                syutsuryokujun,
                syutsuryokukomoku,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
