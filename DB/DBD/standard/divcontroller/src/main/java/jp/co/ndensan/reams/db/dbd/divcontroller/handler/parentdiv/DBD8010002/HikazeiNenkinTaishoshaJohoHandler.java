/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.hikazeinenkintaishoshaJoho.HikazeiNenkinTaishoshaJohoBusiness;
import jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode.SyoriJyoutaiCode;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgTanitsuTaishoShoriItchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 非課税年金対象者情報取込画面のHandlerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJohoHandler {

    private final HikazeiNenkinTaishoshaJohoDiv div;

    private final FlexibleYear 調定年度_2015 = new FlexibleYear("2015");
    private final FlexibleYear 平成28年度 = new FlexibleYear("2016");
    private static final RString DBDMN81002 = new RString("DBDMN81002");
    private final RString 月 = new RString("月");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private final RString 年次 = new RString("年次");
    private final RString 月次 = new RString("月次");
    private final RString 対象ファイル_Z51 = new RString("Z51*****.DTA");
    private final RString 対象ファイル_Z52 = new RString("Z52*****.DTA");
    private final RString 広域保険者 = new RString("1");
    private final RString 単一保険者 = new RString("2");

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_12 = 12;

    /**
     * コンストラクタです。
     *
     * @param div 非課税年金対象者情報取込のコントロールdiv
     */
    public HikazeiNenkinTaishoshaJohoHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onLoad(HikazeiNenkinTaishoshaJohoDiv div) {

        FlexibleYear 調定年度 = new FlexibleYear(get日付関連_調定年度());

        if (調定年度.isBeforeOrEquals(調定年度_2015)) {
            throw new ApplicationException(DbdErrorMessages.調定年度が_2016_以前.getMessage());
        }

        if (DBDMN81002.equals(ResponseHolder.getMenuID())) {
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900002.getReportId());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900003.getReportId());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900004.getReportId());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900005.getReportId());

            FlexibleYear 平成年度 = 平成28年度;
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            while (調定年度.isBeforeOrEquals(平成年度)) {
                dataSource.add(new KeyValueDataSource(new RString(平成年度.getYearValue()), 平成年度.wareki().eraType(EraType.KANJI).toDateString()));
                平成年度 = 平成年度.minusYear(1);
            }
            div.getDdlShoriNendo().setDataSource(dataSource);
            div.getDdlShoriNendo().setSelectedKey(dataSource.get(INT_0).getKey());

            this.onChange_ddlShoriNendo(div);
        } else {
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900006.getReportId());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900007.getReportId());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900004.getReportId());
        }

    }

    /**
     * 年度DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onChange_ddlShoriNendo(HikazeiNenkinTaishoshaJohoDiv div) {

        if (単一保険者.equals(広域と市町村判断())) {
            単一年度DDLの選択処理();
        } else {
            広域年度DDLの選択処理();
        }
    }

    /**
     * 月DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onChange_ddlTuki(HikazeiNenkinTaishoshaJohoDiv div) {

    }

    private void 単一年度DDLの選択処理() {

        List<HikazeiNenkinTaishoshaJohoBusiness> 対象処理List = new ArrayList<>();

        HikazeiNenkinTaishoshaJohoBusiness 対象処理年次 = new HikazeiNenkinTaishoshaJohoBusiness();
        RString 年次の月 = get月(-1);
        RString 年次の月コード = get月コード(-1, true, RSTRING_0);

        SearchResult<ShoriDateKanri> 年次処理情報List = get処理日付管理マスタ情報for単一();

        ShoriDateKanri 年次処理情報 = getShoriDateKanriFor単一(年次の月コード, RSTRING_0, 年次処理情報List);

        対象処理年次.set月(年次の月);
        対象処理年次.set月コード(年次の月コード);
        対象処理年次.set処理コード(RSTRING_0);
        対象処理年次.set処理(年次);
        対象処理年次.set対象ファイル(対象ファイル_Z51);
        if (年次処理情報 == null) {
            対象処理年次.set処理日時(RString.EMPTY);
            対象処理年次.set処理状態コード(RSTRING_1);
            対象処理年次.set処理状態(SyoriJyoutaiCode.toValue(RSTRING_1).get名称());
        } else {
            対象処理年次.set処理日時(年次処理情報.get基準日時().toDateString());
            対象処理年次.set処理状態コード(年次処理情報.get処理枝番());
            対象処理年次.set処理状態(SyoriJyoutaiCode.toValue(年次処理情報.get処理枝番()).get名称());
        }
        対象処理List.add(対象処理年次);

        for (int i = 1; i <= INT_12; i++) {
            HikazeiNenkinTaishoshaJohoBusiness 対象処理 = new HikazeiNenkinTaishoshaJohoBusiness();
            RString 月次の月 = get月(i);
            RString 月次の月コード = get月コード(i, true, RSTRING_0);

            ShoriDateKanri 月次処理情報 = getShoriDateKanriFor単一(月次の月コード, RSTRING_1, 年次処理情報List);
            対象処理.set月(月次の月);
            対象処理.set月コード(月次の月コード);
            対象処理.set処理コード(RSTRING_1);
            対象処理.set処理(月次);
            対象処理.set対象ファイル(対象ファイル_Z52);
            if (月次処理情報 == null) {
                対象処理.set処理日時(RString.EMPTY);
                対象処理.set処理状態コード(RSTRING_1);
                対象処理.set処理状態(SyoriJyoutaiCode.toValue(RSTRING_1).get名称());
            } else {
                対象処理.set処理日時(年次処理情報.get基準日時().toDateString());
                対象処理.set処理状態コード(年次処理情報.get処理枝番());
                対象処理.set処理状態(SyoriJyoutaiCode.toValue(年次処理情報.get処理枝番()).get名称());
            }

            対象処理List.add(対象処理);
        }

        List<dgTanitsuTaishoShoriItchiran_Row> rowList = new ArrayList<>();
        for (HikazeiNenkinTaishoshaJohoBusiness 対象処理 : 対象処理List) {

            dgTanitsuTaishoShoriItchiran_Row row = new dgTanitsuTaishoShoriItchiran_Row();
            row.setTxtTuki(対象処理.get月());
            row.setTxtShori(対象処理.get処理());
            row.setTxtTaishoFuairu(対象処理.get対象ファイル());
            row.setTxtShoriJotai(対象処理.get処理状態());
            row.setTxtShoriNichiji(対象処理.get処理日時());

            rowList.add(row);
        }

        div.getDgTanitsuTaishoShoriItchiran().setDataSource(rowList);
    }

    private void 広域年度DDLの選択処理() {

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(get月コード(-1, false, RSTRING_0), get月(-1)));
        for (int i = 1; i <= INT_12; i++) {
            dataSource.add(new KeyValueDataSource(get月コード(i, false, RSTRING_1), get月(i)));
        }

        div.getDdlTuki().setDataSource(dataSource);

        SearchResult<ShoriDateKanri> 処理日付管理マスタList = get処理日付管理マスタ情報for広域();
        if (処理日付管理マスタList == null || 処理日付管理マスタList.totalCount() == 0) {
            div.getDdlTuki().setSelectedKey(dataSource.get(INT_0).getKey());
        } else {
            for (int i = 0; i < dataSource.size(); i++) {
                if (処理日付管理マスタList.records().get(INT_0).get年度内連番().equals(dataSource.get(i).getKey())
                        && (i <= dataSource.size() - 2)) {
                    div.getDdlTuki().setSelectedKey(dataSource.get(i + 1).getKey());
                    break;
                } else {
                    div.getDdlTuki().setSelectedKey(dataSource.get(INT_0).getKey());
                    break;
                }
            }
        }

        this.onChange_ddlTuki(div);
    }

    private RString get日付関連_調定年度() {
        return DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }

    private RString get月(int 計算用月) {

        RString 年度終了月 = get月次処理年度終了月();
        int 変数月 = Integer.parseInt(年度終了月.toString()) + 計算用月;
        if (変数月 == 0) {
            変数月 = INT_12;
        } else if (変数月 > INT_12) {
            変数月 = 変数月 - INT_12;
        }

        return new RString(変数月).concat(月);
    }

    private RString get月コード(int 計算用月, boolean 三桁コード, RString 年次月次) {

        RString 年度終了月 = get月次処理年度終了月();

        int 変数月 = Integer.parseInt(年度終了月.toString()) + 計算用月;
        RString 当年翌年 = RSTRING_0;
        if (変数月 == 0) {
            変数月 = INT_12;
        } else if (変数月 > INT_12) {
            変数月 = 変数月 - INT_12;
            当年翌年 = RSTRING_1;
        }

        if (三桁コード) {
            return 当年翌年.concat(new RString(変数月).padZeroToLeft(INT_2));
        } else {
            return 年次月次.concat(当年翌年.concat(new RString(変数月).padZeroToLeft(INT_2)));
        }
    }

    private RString get月次処理年度終了月() {
        return DbBusinessConfig.get(
                ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
    }

    private SearchResult<ShoriDateKanri> get処理日付管理マスタ情報for単一() {

        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        return manager.get非課税年金対象者情報for単一(
                SubGyomuCode.DBD介護受給,
                ShoriName.非課税年金対象者情報取込.get名称(),
                new FlexibleYear(div.getDdlShoriNendo().getSelectedKey()));

    }

    private ShoriDateKanri getShoriDateKanriFor単一(RString 月コード, RString 処理コード, SearchResult<ShoriDateKanri> resultList) {

        if (resultList == null || resultList.totalCount() == 0) {
            return null;
        }
        for (ShoriDateKanri shoriDateKanri : resultList.records()) {
            if (月コード.equals(shoriDateKanri.get年度内連番().substring(INT_0))
                    && 処理コード.equals(shoriDateKanri.get年度内連番().substring(INT_1, INT_4))) {
                return shoriDateKanri;
            }
        }
        return null;
    }

    private SearchResult<ShoriDateKanri> get処理日付管理マスタ情報for広域() {

        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        return manager.get非課税年金対象者情報for広域(
                SubGyomuCode.DBD介護受給,
                ShoriName.非課税年金対象者情報取込.get名称(),
                new FlexibleYear(div.getDdlShoriNendo().getSelectedKey()),
                SyoriJyoutaiCode.処理済.getコード());

    }

    /**
     * 広域と市町村判断の処理します。
     *
     * @return 広域保険者または単一保険者
     */
    private RString 広域と市町村判断() {
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (介護導入形態 != null) {
            DonyuKeitaiCode 導入形態コード = 介護導入形態.get導入形態コード();
            if (導入形態コード != null) {
                return 広域と単一判断(導入形態コード);
            }
        }
        return RString.EMPTY;
    }

    private RString 広域と単一判断(DonyuKeitaiCode 導入形態コード) {
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getCode())) {
            return 広域保険者;
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getCode())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getCode())) {
            return 単一保険者;
        }
        return RString.EMPTY;
    }
}
