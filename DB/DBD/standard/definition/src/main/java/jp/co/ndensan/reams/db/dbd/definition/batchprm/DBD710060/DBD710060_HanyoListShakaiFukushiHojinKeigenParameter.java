/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710060;

import jp.co.ndensan.reams.db.dbd.definition.processprm.DBD710060.HanyoListShakaiFukushiHojinKeigenProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 汎用リスト出力(社会福祉法人軽減)_バッチ用のパラメータです。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD710060_HanyoListShakaiFukushiHojinKeigenParameter extends BatchParameterBase {

    private static final String HYOUDAI = "hyoudai";
    private static final String CYUSYUTSUHOHOKUBUN = "cyusyutsuhohokubun";
    private static final String CYUSYUTSUKOMOKUKUBUN = "cyusyutsukomokukubun";
    private static final String NENDO = "nendo";
    private static final String KIZYUNNICHI = "kizyunnichi";
    private static final String HITSUKEHANIFROM = "hitsukehanifrom";
    private static final String HITSUKEHANITO = "hitsukehanito";
    private static final String NENDOCHOKINDATACYUSYUTSU = "nendochokindatacyusyutsu";
    private static final String CHOKINDATACYUSYUTSU = "chokindatacyusyutsu";
    private static final String SOSHITSUKUBUN = "soshitsukubun";
    private static final String KOMOKUMEIFUKA = "komokumeifuka";
    private static final String RENBANFUKA = "renbanfuka";
    private static final String HITSUKESURASYUHENSYU = "hitsukesurasyuhensyu";
    private static final String ATENACYUSYUTSUJYOKEN = "atenacyusyutsujyoken";
    private static final String CYOHYOID = "cyohyoid";
    private static final String SYUTSURYOKUKOMOKU = "syutsuryokukomoku";
    private static final String KYAKASHA = "kyakasha";
    private static final String HOBETSUKUBUN = "hobetsukubun";
    private static final String KYUSOCHISHA = "kyusochisha";
    private static final String JIGYOTAISYOSHADATACYUSHUTSU = "jigyotaisyoshadatacyushutsu";
    private static final String SHINSEISHADATACYUSHUTSU = "shinseishadatacyushutsu";
    private static final String SHITEINYUSHOSHAKYUSOCHISHA = "shiteinyushoshakyusochisha";
    private static final String SHITEINYUSHOSHAFUTANKEIGENSHA = "shiteinyushoshafutankeigensha";
    private static final String SHITEINYUSHOSHASONOTA = "shiteinyushoshasonota";
    private static final String SHITEINYUSHOSHADAIICHIDANKAI = "shiteinyushoshadaiichidankai";
    private static final String SHITEINYUSHOSHADAINIDANKAI = "shiteinyushoshadainidankai";
    private static final String SHITEINYUSHOSHADAISANDANKAI = "shiteinyushoshadaisandankai";
    private static final String SHITEINYUSHOSHAKAZEISOU = "shiteinyushoshakazeisou";
    private static final String JIGYOTAISHOSHAFUTANICHIWARI = "jigyotaishoshafutanichiwari";
    private static final String JIGYOTAISHOSHAFUTANNIWARI = "jigyotaishoshafutanniwari";
    private static final String CYOHYOMEI = "cyohyomei";
    private static final String SYUTSURYOKUJUNPARAMETER = "syutsuryokujunparameter";
    private static final String DOUNYUDANTAICODE = "dounyudantaicode";
    private static final String SHICHOSONMEI = "shichosonmei";
    private static final String JOBNO = "jobno";
    private static final String SYUTSURYOKUPAGESU = "syutsuryokupagesu";
    private static final String CSVSYUTSURYOKUUMU = "csvsyutsuryokuumu";
    private static final String CSVFILENAME = "csvfilename";
    private static final String SYUTSURYOKUJYOKEN = "syutsuryokujyoken";

    @BatchParameter(key = HYOUDAI, name = "表題")
    private RString hyoudai;
    @BatchParameter(key = CYUSYUTSUHOHOKUBUN, name = "抽出方法区分")
    private RString cyusyutsuhohokubun;
    @BatchParameter(key = CYUSYUTSUKOMOKUKUBUN, name = "抽出項目区分")
    private RString cyusyutsukomokukubun;
    @BatchParameter(key = NENDO, name = "年度")
    private FlexibleYear nendo;
    @BatchParameter(key = KIZYUNNICHI, name = "基準日")
    private FlexibleDate kizyunnichi;
    @BatchParameter(key = HITSUKEHANIFROM, name = "日付範囲From")
    private FlexibleDate hitsukehanifrom;
    @BatchParameter(key = HITSUKEHANITO, name = "日付範囲To")
    private FlexibleDate hitsukehanito;
    @BatchParameter(key = NENDOCHOKINDATACYUSYUTSU, name = "年度直近データ抽出")
    private boolean isNendochokindatacyusyutsu;
    @BatchParameter(key = CHOKINDATACYUSYUTSU, name = "直近データ抽出")
    private boolean isChokindatacyusyutsu;
    @BatchParameter(key = SHINSEISHADATACYUSHUTSU, name = "申請者データ抽出")
    private boolean isShinseishadatacyushutsu;
    @BatchParameter(key = JIGYOTAISYOSHADATACYUSHUTSU, name = "事業対象者データ抽出")
    private boolean isJigyotaisyoshadatacyushutsu;
    @BatchParameter(key = KYUSOCHISHA, name = "旧措置者")
    private RString kyusochisha;
    @BatchParameter(key = HOBETSUKUBUN, name = "法別区分")
    private RString hobetsukubun;
    @BatchParameter(key = KYAKASHA, name = "却下者")
    private RString kyakasha;
    @BatchParameter(key = SOSHITSUKUBUN, name = "喪失区分")
    private RString soshitsukubun;
    @BatchParameter(key = SHITEINYUSHOSHAKYUSOCHISHA, name = "特定入所者旧措置者")
    private boolean shiteinyushoshakyusochisha;
    @BatchParameter(key = SHITEINYUSHOSHAFUTANKEIGENSHA, name = "特定入所者負担軽減者")
    private boolean shiteinyushoshafutankeigensha;
    @BatchParameter(key = SHITEINYUSHOSHASONOTA, name = "特定入所者その他")
    private boolean shiteinyushoshasonota;
    @BatchParameter(key = SHITEINYUSHOSHADAIICHIDANKAI, name = "特定入所者第一段階")
    private boolean shiteinyushoshadaiichidankai;
    @BatchParameter(key = SHITEINYUSHOSHADAINIDANKAI, name = "特定入所者第二段階")
    private boolean shiteinyushoshadainidankai;
    @BatchParameter(key = SHITEINYUSHOSHADAISANDANKAI, name = "特定入所者第三段階")
    private boolean shiteinyushoshadaisandankai;
    @BatchParameter(key = SHITEINYUSHOSHAKAZEISOU, name = "特定入所者課税層")
    private boolean shiteinyushoshakazeisou;
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
    @BatchParameter(key = HITSUKESURASYUHENSYU, name = "地図分布図作成")
    private boolean isChizubunpuzusakusei;
    @BatchParameter(key = ATENACYUSYUTSUJYOKEN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    @BatchParameter(key = CYOHYOID, name = "帳票ID")
    private RString cyohyoid;
    @BatchParameter(key = CYOHYOMEI, name = "帳票名")
    private RString cyohyomei;
    @BatchParameter(key = SYUTSURYOKUJUNPARAMETER, name = "出力順パラメータ")
    private RString syutsuryokujunparameter;
    @BatchParameter(key = SYUTSURYOKUKOMOKU, name = "出力項目")
    private RString syutsuryokukomoku;
    @BatchParameter(key = DOUNYUDANTAICODE, name = "導入団体コード")
    private RString dounyudantaicode;
    @BatchParameter(key = SHICHOSONMEI, name = "市町村名")
    private RString shichosonmei;
    @BatchParameter(key = JOBNO, name = "ジョブ番号")
    private RString jobno;
    @BatchParameter(key = SYUTSURYOKUPAGESU, name = "出力ページ数")
    private RString syutsuryokupagesu;
    @BatchParameter(key = CSVSYUTSURYOKUUMU, name = "CSV出力有無")
    private RString csvsyutsuryokuumu;
    @BatchParameter(key = CSVFILENAME, name = "CSVファイル名")
    private RString csvfilename;
    @BatchParameter(key = SYUTSURYOKUJYOKEN, name = "出力条件")
    private RString syutsuryokujyoken;

    /**
     * バーチのパラメータを作成します。
     *
     * @return HanyoRisutoJyukyusyaDaichoProcessParameter
     */
    public HanyoListShakaiFukushiHojinKeigenProcessParameter toHanyoRisutoShakaiFukushiHoujinKeigenProcessParameter() {
        return new HanyoListShakaiFukushiHojinKeigenProcessParameter(
                hyoudai,
                cyusyutsuhohokubun,
                cyusyutsukomokukubun,
                nendo,
                kizyunnichi,
                hitsukehanifrom,
                hitsukehanito,
                isNendochokindatacyusyutsu,
                isChokindatacyusyutsu,
                soshitsukubun,
                isCsvkomokumeifuka,
                isCsvrenbanfuka,
                isCsvhitsukesurasyuhensyu,
                atenacyusyutsujyoken,
                cyohyoid,
                syutsuryokukomoku,
                kyakasha,
                hobetsukubun,
                kyusochisha,
                isJigyotaisyoshadatacyushutsu,
                isShinseishadatacyushutsu,
                shiteinyushoshakyusochisha,
                shiteinyushoshafutankeigensha,
                shiteinyushoshasonota,
                shiteinyushoshadaiichidankai,
                shiteinyushoshadainidankai,
                shiteinyushoshadaisandankai,
                shiteinyushoshakazeisou,
                isJigyotaishoshafutanichiwari,
                isJigyotaishoshafutanniwari,
                cyohyomei,
                syutsuryokujunparameter,
                dounyudantaicode,
                shichosonmei,
                jobno,
                syutsuryokupagesu,
                csvsyutsuryokuumu,
                csvfilename,
                syutsuryokujyoken
        );
    }

}
