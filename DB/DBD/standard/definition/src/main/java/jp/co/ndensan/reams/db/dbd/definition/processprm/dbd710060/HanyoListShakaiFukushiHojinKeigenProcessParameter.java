/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd710060;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(社会福祉法人軽減)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListShakaiFukushiHojinKeigenProcessParameter implements IBatchProcessParameter {

    private RString hyoudai;
    private RString cyusyutsuhohokubun;
    private RString cyusyutsukomokukubun;
    private FlexibleYear nendo;
    private FlexibleDate kizyunnichi;
    private FlexibleDate hitsukehanifrom;
    private FlexibleDate hitsukehanito;
    private boolean isNendochokindatacyusyutsu;
    private boolean isChokindatacyusyutsu;
    private boolean isShinseishadatacyushutsu;
    private boolean isJigyotaisyoshadatacyushutsu;
    private RString kyusochisha;
    private RString hobetsukubun;
    private RString kyakasha;
    private RString soshitsukubun;
    private boolean shiteinyushoshakyusochisha;
    private boolean shiteinyushoshafutankeigensha;
    private boolean shiteinyushoshasonota;
    private boolean shiteinyushoshadaiichidankai;
    private boolean shiteinyushoshadainidankai;
    private boolean shiteinyushoshadaisandankai;
    private boolean shiteinyushoshakazeisou;
    private boolean isJigyotaishoshafutanichiwari;
    private boolean isJigyotaishoshafutanniwari;
    private boolean isCsvkomokumeifuka;
    private boolean isCsvrenbanfuka;
    private boolean isCsvhitsukesurasyuhensyu;
    private boolean isChizubunpuzusakusei;
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    private RString cyohyoid;
    private RString cyohyomei;
    private RString syutsuryokujunparameter;
    private RString syutsuryokukomoku;
    private RString dounyudantaicode;
    private RString shichosonmei;
    private RString jobno;
    private RString syutsuryokupagesu;
    private RString csvsyutsuryokuumu;
    private RString csvfilename;
    private RString syutsuryokujyoken;

    /**
     * コンストラクタです。
     *
     * @param hyoudai 表題
     * @param cyusyutsuhohokubun 抽出方法区分
     * @param cyusyutsukomokukubun 抽出項目区分
     * @param nendo 年度
     * @param kizyunnichi 基準日
     * @param hitsukehanifrom 日付範囲From
     * @param hitsukehanito 日付範囲To
     * @param nendochokindatacyusyutsu 年度直近データ抽出
     * @param chokindatacyusyutsu 直近データ抽出
     * @param soshitsukubun 喪失区分
     * @param csvkomokumeifuka 項目名付加
     * @param csvrenbanfuka 連番付加
     * @param csvhitsukesurasyuhensyu 日付スラッシュ付加
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param cyohyoid 帳票ID
     * @param syutsuryokukomoku 出力項目
     * @param kyakasha 却下者
     * @param hobetsukubun 法別区分
     * @param kyusochisha 旧措置者
     * @param jigyotaisyoshadatacyushutsu 事業対象者データ抽出
     * @param shinseishadatacyushutsu 申請者データ抽出
     * @param shiteinyushoshakyusochisha 特定入所者旧措置者
     * @param shiteinyushoshafutankeigensha 特定入所者負担軽減者
     * @param shiteinyushoshasonota 特定入所者その他
     * @param shiteinyushoshadaiichidankai 特定入所者第一段階
     * @param shiteinyushoshadainidankai 特定入所者第二段階
     * @param shiteinyushoshadaisandankai 特定入所者第三段階
     * @param shiteinyushoshakazeisou 特定入所者課税層
     * @param jigyotaishoshafutanichiwari 事業対象者負担１割
     * @param jigyotaishoshafutanniwari 事業対象者負担２割
     * @param cyohyomei 項目名付加
     * @param syutsuryokujunparameter 出力順パラメータ
     * @param dounyudantaicode 導入団体コード
     * @param shichosonmei 市町村名
     * @param jobno ジョブ番号
     * @param syutsuryokupagesu 出力ページ数
     * @param csvsyutsuryokuumu CSV出力有無
     * @param csvfilename CSVファイル名
     * @param syutsuryokujyoken 出力条件
     */
    public HanyoListShakaiFukushiHojinKeigenProcessParameter(RString hyoudai, RString cyusyutsuhohokubun,
            RString cyusyutsukomokukubun, FlexibleYear nendo, FlexibleDate kizyunnichi, FlexibleDate hitsukehanifrom,
            FlexibleDate hitsukehanito, boolean nendochokindatacyusyutsu, boolean chokindatacyusyutsu,
            RString soshitsukubun, boolean csvkomokumeifuka, boolean csvrenbanfuka, boolean csvhitsukesurasyuhensyu,
            AtenaSelectBatchParameter atenacyusyutsujyoken, RString cyohyoid, RString syutsuryokukomoku,
            RString kyakasha, RString hobetsukubun, RString kyusochisha, boolean jigyotaisyoshadatacyushutsu,
            boolean shinseishadatacyushutsu, boolean shiteinyushoshakyusochisha, boolean shiteinyushoshafutankeigensha,
            boolean shiteinyushoshasonota, boolean shiteinyushoshadaiichidankai, boolean shiteinyushoshadainidankai,
            boolean shiteinyushoshadaisandankai, boolean shiteinyushoshakazeisou, boolean jigyotaishoshafutanichiwari,
            boolean jigyotaishoshafutanniwari, RString cyohyomei, RString syutsuryokujunparameter, RString dounyudantaicode,
            RString shichosonmei, RString jobno, RString syutsuryokupagesu, RString csvsyutsuryokuumu, RString csvfilename,
            RString syutsuryokujyoken) {
        this.hyoudai = hyoudai;
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.cyusyutsukomokukubun = cyusyutsukomokukubun;
        this.nendo = nendo;
        this.kizyunnichi = kizyunnichi;
        this.hitsukehanifrom = hitsukehanifrom;
        this.hitsukehanito = hitsukehanito;
        this.isNendochokindatacyusyutsu = nendochokindatacyusyutsu;
        this.isChokindatacyusyutsu = chokindatacyusyutsu;
        this.soshitsukubun = soshitsukubun;
        this.isCsvkomokumeifuka = csvkomokumeifuka;
        this.isCsvrenbanfuka = csvrenbanfuka;
        this.isCsvhitsukesurasyuhensyu = csvhitsukesurasyuhensyu;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.cyohyoid = cyohyoid;
        this.syutsuryokukomoku = syutsuryokukomoku;
        this.kyakasha = kyakasha;
        this.hobetsukubun = hobetsukubun;
        this.kyusochisha = kyusochisha;
        this.isJigyotaisyoshadatacyushutsu = jigyotaisyoshadatacyushutsu;
        this.isShinseishadatacyushutsu = shinseishadatacyushutsu;
        this.shiteinyushoshakyusochisha = shiteinyushoshakyusochisha;
        this.shiteinyushoshafutankeigensha = shiteinyushoshafutankeigensha;
        this.shiteinyushoshasonota = shiteinyushoshasonota;
        this.shiteinyushoshadaiichidankai = shiteinyushoshadaiichidankai;
        this.shiteinyushoshadainidankai = shiteinyushoshadainidankai;
        this.shiteinyushoshadaisandankai = shiteinyushoshadaisandankai;
        this.shiteinyushoshakazeisou = shiteinyushoshakazeisou;
        this.isJigyotaishoshafutanichiwari = jigyotaishoshafutanichiwari;
        this.isJigyotaishoshafutanniwari = jigyotaishoshafutanniwari;
        this.cyohyomei = cyohyomei;
        this.syutsuryokujunparameter = syutsuryokujunparameter;
        this.dounyudantaicode = dounyudantaicode;
        this.shichosonmei = shichosonmei;
        this.jobno = jobno;
        this.syutsuryokupagesu = syutsuryokupagesu;
        this.csvsyutsuryokuumu = csvsyutsuryokuumu;
        this.csvfilename = csvfilename;
        this.syutsuryokujyoken = syutsuryokujyoken;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @return HanyoRisutoRiyoshaFutanWariaiMybatisParameter
     */
    public ShakaiFukushiHojinKeigenMybatisParameter toHanyoRisutoShakaiFukushiHoujinKeigenMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        return new ShakaiFukushiHojinKeigenMybatisParameter(
                cyusyutsuhohokubun,
                cyusyutsukomokukubun,
                kizyunnichi,
                hitsukehanifrom,
                hitsukehanito,
                isChokindatacyusyutsu,
                soshitsukubun,
                kyakasha,
                atenacyusyutsujyoken,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
