/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd710040;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 汎用リスト出力(利用者負担額減免)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListRiyoshaFutanGakuGengakuProcessParameter implements IBatchProcessParameter {

    private RString hyoudai;
    private RString detasyubetsumesyo;
    private RString syutsuryoku;
    private RString cyusyutsuhohokubun;
    private RString cyusyutsukomokukubun;
    private FlexibleDate kizyunnichi;
    private FlexibleDate hitsukehanifrom;
    private FlexibleDate hitsukehanito;
    private boolean isChokindatacyusyutsu;
    private boolean isShinseishadatacyushutsu;
    private RString kyusochisha;
    private RString kyakasha;
    private RString soshitsukubun;
    private boolean isCsvkomokumeifuka;
    private boolean isCsvrenbanfuka;
    private boolean isCsvhitsukesurasyuhensyu;
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    private RString cyohyoid;
    private RString syutsuryokujunparameter;
    private RString syutsuryokukomoku;

    /**
     * コンストラクタです。
     *
     * @param hyoudai 表題
     * @param detasyubetsumesyo データ種別名
     * @param syutsuryoku 出力方法
     * @param cyusyutsuhohokubun 抽出方法区分
     * @param cyusyutsukomokukubun 抽出項目区分
     * @param kizyunnichi 基準日
     * @param hitsukehanifrom 日付範囲From
     * @param hitsukehanito 日付範囲To
     * @param chokindatacyusyutsu 直近データ抽出
     * @param shinseishadatacyushutsu 申請者データ抽出
     * @param kyusochisha 旧措置者
     * @param kyakasha 却下者
     * @param soshitsukubun 喪失区分
     * @param csvkomokumeifuka 項目名付加
     * @param csvrenbanfuka 連番付加
     * @param csvhitsukesurasyuhensyu 日付スラッシュ付加
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param cyohyoid 帳票ID
     * @param syutsuryokukomoku 出力項目
     * @param syutsuryokujunparameter 出力順パラメータ
     */
    public HanyoListRiyoshaFutanGakuGengakuProcessParameter(RString hyoudai, RString detasyubetsumesyo,
            RString syutsuryoku, RString cyusyutsuhohokubun, RString cyusyutsukomokukubun,
            FlexibleDate kizyunnichi, FlexibleDate hitsukehanifrom, FlexibleDate hitsukehanito,
            boolean chokindatacyusyutsu, boolean shinseishadatacyushutsu, RString kyusochisha,
            RString kyakasha, RString soshitsukubun, boolean csvkomokumeifuka, boolean csvrenbanfuka,
            boolean csvhitsukesurasyuhensyu, AtenaSelectBatchParameter atenacyusyutsujyoken,
            RString cyohyoid, RString syutsuryokujunparameter, RString syutsuryokukomoku) {
        this.hyoudai = hyoudai;
        this.detasyubetsumesyo = detasyubetsumesyo;
        this.syutsuryoku = syutsuryoku;
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.cyusyutsukomokukubun = cyusyutsukomokukubun;
        this.kizyunnichi = kizyunnichi;
        this.hitsukehanifrom = hitsukehanifrom;
        this.hitsukehanito = hitsukehanito;
        this.isChokindatacyusyutsu = chokindatacyusyutsu;
        this.isShinseishadatacyushutsu = shinseishadatacyushutsu;
        this.kyusochisha = kyusochisha;
        this.kyakasha = kyakasha;
        this.soshitsukubun = soshitsukubun;
        this.isCsvkomokumeifuka = csvkomokumeifuka;
        this.isCsvrenbanfuka = csvrenbanfuka;
        this.isCsvhitsukesurasyuhensyu = csvhitsukesurasyuhensyu;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.cyohyoid = cyohyoid;
        this.syutsuryokujunparameter = syutsuryokujunparameter;
        this.syutsuryokukomoku = syutsuryokukomoku;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @param 出力順 出力順
     * @return RiyoshaFutanGakuGengakuMybatisParameter
     */
    public RiyoshaFutanGakuGengakuMybatisParameter toTokubetsuChiikiKasanGemmenMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順) {
        return new RiyoshaFutanGakuGengakuMybatisParameter(
                cyusyutsuhohokubun,
                cyusyutsukomokukubun,
                kizyunnichi,
                hitsukehanifrom,
                hitsukehanito,
                isChokindatacyusyutsu,
                isShinseishadatacyushutsu,
                kyusochisha,
                soshitsukubun,
                kyakasha,
                atenacyusyutsujyoken,
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順);
    }
}
