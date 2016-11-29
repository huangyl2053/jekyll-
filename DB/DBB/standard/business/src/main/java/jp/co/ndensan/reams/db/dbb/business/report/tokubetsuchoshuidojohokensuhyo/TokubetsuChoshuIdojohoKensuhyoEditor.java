/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Report
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoEditor implements ITokubetsuChoshuIdojohoKensuhyoEditor {

    private final TokubetsuChoshuIdojohoKensuhyoParameter parameter;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString EIGHT = new RString("8");
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final RString 月開始 = new RString("月開始");
    private static final RString 年度 = new RString("年度");
    private static final RString 特徴追加依頼 = new RString("特徴追加依頼");

    /**
     * TokubetsuChoshuIdojohoKensuhyoEditor
     *
     *
     * @param parameter TokubetsuChoshuIdojohoKensuhyoParameter
     */
    public TokubetsuChoshuIdojohoKensuhyoEditor(TokubetsuChoshuIdojohoKensuhyoParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public TokubetsuChoshuIdojohoKensuhyoSource edit(TokubetsuChoshuIdojohoKensuhyoSource source) {

        RString 作成日 = parameter.get作成日時().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.get作成日時().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.testShori = RString.EMPTY;
        source.nenkinHokenshaName = parameter.get特徴異動件数Entity().get年金保険者名称();
        source.nengetsu = (null == parameter.get賦課年度() || parameter.get賦課年度().isEmpty())
                ? RString.EMPTY
                : parameter.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                fillType(FillType.BLANK).toDateString().concat(年度).
                concat(parameter.get処理対象月()).concat(月開始);
        source.shichosonCode = parameter.get特徴異動件数Entity().get構成市町村コード();
        source.shichosonName = parameter.get特徴異動件数Entity().get市町村名称();
        RDate システム日時 = RDate.getNowDate();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, システム日時, SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, システム日時, SubGyomuCode.DBU介護統計報告);
        if (!RString.isNullOrEmpty(parameter.get処理対象月()) && EIGHT != parameter.get処理対象月()
                && (Integer.parseInt(parameter.get処理対象月().toString())) % TWO == ZERO) {
            source.tsukairaiTitleLeft = 特徴追加依頼;
            source.tsukairaiTitleRight = 特徴追加依頼;
        } else {
            source.tsukairaiTitleLeft = RString.EMPTY;
            source.tsukairaiTitleRight = RString.EMPTY;
        }

        source.list1_1 = parameter.get特徴異動件数Entity().get資格件数Left();
        source.list2_1 = parameter.get特徴異動件数Entity().get特別徴収義務者コードLeft();
        source.list2_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                new Code(parameter.get特徴異動件数Entity().get特別徴収義務者コードLeft()));
        source.list2_3 = parameter.get特徴異動件数Entity().get件数Left();
        source.list2_4 = parameter.get特徴異動件数Entity().get仮徴収額変更件数Left();
        source.list3_1 = parameter.get特徴異動件数Entity().get住所地特例件数Left();
        source.list4_1 = parameter.get特徴異動件数Entity().get追加依頼件数Left();

        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get資格件数Right())) {
            source.list1_2 = RString.EMPTY;
        } else {
            source.list1_2 = parameter.get特徴異動件数Entity().get資格件数Right();
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get特別徴収義務者コードRight())) {
            source.list2_5 = RString.EMPTY;
        } else {
            source.list2_5 = parameter.get特徴異動件数Entity().get特別徴収義務者コードRight();
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get件数Right())) {
            source.list2_7 = RString.EMPTY;
        } else {
            source.list2_7 = parameter.get特徴異動件数Entity().get件数Right();
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get特別徴収義務者コードRight())) {
            source.list2_6 = RString.EMPTY;
        } else {
            source.list2_6 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(parameter.get特徴異動件数Entity().get特別徴収義務者コードRight()));
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get仮徴収額変更件数Right())) {
            source.list2_8 = RString.EMPTY;
        } else {
            source.list2_8 = parameter.get特徴異動件数Entity().get仮徴収額変更件数Right();
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get住所地特例件数Right())) {
            source.list3_2 = RString.EMPTY;
        } else {
            source.list3_2 = parameter.get特徴異動件数Entity().get住所地特例件数Right();
        }
        if (RString.isNullOrEmpty(parameter.get特徴異動件数Entity().get追加依頼件数Right())) {
            source.list4_2 = RString.EMPTY;
        } else {
            source.list4_2 = parameter.get特徴異動件数Entity().get追加依頼件数Right();
        }

        source.baitaiNo = RString.EMPTY;
        source.shurokuKensu = RString.EMPTY;
        source.gokeiKensu = parameter.get該当件数の件数の合計();
        source.gokeiSoshituKensu = parameter.get資格喪失の件数の合計();
        source.gokeiKariSanShutsuGakuHenkoKensu = parameter.get仮徴収額変更の件数の合計();
        source.gokeijushochiTokureiKensu = parameter.get住所地特例の件数の合計();
        source.gokeiTsukairaiKensu = parameter.get特徴追加依頼の件数の合計();
        pageBreakNullCheck(source);
        return source;

    }

    private void pageBreakNullCheck(TokubetsuChoshuIdojohoKensuhyoSource source) {
        if (source.nenkinHokenshaName == null) {
            source.nenkinHokenshaName = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
    }
}
