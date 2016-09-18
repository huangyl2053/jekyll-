/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo.TokuChoYidoKensu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Report
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoEditor implements ITokubetsuChoshuIdojohoKensuhyoEditor {

    private final TokuChoYidoKensu 特徴異動件数Entity;
    private final YMDHMS 作成日時;
    private final FlexibleYear 賦課年度;
    private final RString 処理対象月;
    private static final RString EIGHT = new RString("8");
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int TEN = 10;
    private static final RString 月開始 = new RString("月開始");
    private static final RString 特徴追加依頼 = new RString("特徴追加依頼");

    /**
     * TokubetsuChoshuIdojohoKensuhyoEditor
     *
     * @param 特徴異動件数Entity TokubetsuChoshuIdojohoKensuhyoEntity
     * @param 作成日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param 処理対象月 RString
     */
    public TokubetsuChoshuIdojohoKensuhyoEditor(TokuChoYidoKensu 特徴異動件数Entity,
            YMDHMS 作成日時,
            FlexibleYear 賦課年度,
            RString 処理対象月) {
        this.特徴異動件数Entity = 特徴異動件数Entity;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.処理対象月 = 処理対象月;

    }

    @Override
    public TokubetsuChoshuIdojohoKensuhyoSource edit(TokubetsuChoshuIdojohoKensuhyoSource source) {

        source.printTimeStamp = (null == 作成日時 || 作成日時.isEmpty()) ? RString.EMPTY : 作成日時.toDateString();
//        総ページ数 帳票基盤で自動で取得 source.pageCount=;
        source.testShori = RString.EMPTY;
//        TODO 年金保険者名称 ビジネス設計 source.nenkinHokenshaName=特徴異動件数Entity.get(0).get特別徴収義務者コード().getColumnValue();
        source.nengetsu = (null == 賦課年度 || 賦課年度.isEmpty())
                ? RString.EMPTY
                : 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().
                concat(処理対象月).concat(月開始);
        source.shichosonCode = 特徴異動件数Entity.get構成市町村コード().getColumnValue();
//        TODO      市町村名称 ビジネス設計
        RDate システム日時 = RDate.getNowDate();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, システム日時, SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, システム日時, SubGyomuCode.DBU介護統計報告);
        if (!処理対象月.isNullOrEmpty() && EIGHT != 処理対象月 && (処理対象月.hashCode()) % TWO == ZERO) {
            source.tsukairaiTitleLeft = 特徴追加依頼;
            source.tsukairaiTitleRight = 特徴追加依頼;
        } else {
            source.tsukairaiTitleLeft = RString.EMPTY;
            source.tsukairaiTitleRight = RString.EMPTY;
        }
        if (特徴異動件数Entity.get件数() < TEN) {
            source.list1_1 = new RString(特徴異動件数Entity.get資格件数());
            source.list2_1 = 特徴異動件数Entity.get特別徴収義務者コード().getColumnValue();
            source.list2_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特徴異動件数Entity.get特別徴収義務者コード().getColumnValue()));
            source.list2_3 = new RString(特徴異動件数Entity.get件数());
            source.list2_4 = new RString(特徴異動件数Entity.get仮徴収額変更件数());
            source.list3_1 = new RString(特徴異動件数Entity.get住所地特例件数());
            source.list4_1 = new RString(特徴異動件数Entity.get追加依頼件数());

        } else {
            source.list1_2 = new RString(特徴異動件数Entity.get資格件数());
            source.list2_5 = 特徴異動件数Entity.get特別徴収義務者コード().getColumnValue();
            source.list2_6 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特徴異動件数Entity.get特別徴収義務者コード().getColumnValue()));
            source.list2_7 = new RString(特徴異動件数Entity.get件数());
            source.list2_8 = new RString(特徴異動件数Entity.get仮徴収額変更件数());
            source.list3_2 = new RString(特徴異動件数Entity.get住所地特例件数());
            source.list4_2 = new RString(特徴異動件数Entity.get追加依頼件数());
        }

        source.baitaiNo = RString.EMPTY;
        source.shurokuKensu = RString.EMPTY;
        source.gokeiKensu = new RString(特徴異動件数Entity.get件数());
        source.gokeiSoshituKensu = new RString(特徴異動件数Entity.get資格件数());
        source.gokeiKariSanShutsuGakuHenkoKensu = new RString(特徴異動件数Entity.get仮徴収額変更件数());
        source.gokeijushochiTokureiKensu = new RString(特徴異動件数Entity.get住所地特例件数());
        source.gokeiTsukairaiKensu = new RString(特徴異動件数Entity.get追加依頼件数());
        return source;

    }

}
