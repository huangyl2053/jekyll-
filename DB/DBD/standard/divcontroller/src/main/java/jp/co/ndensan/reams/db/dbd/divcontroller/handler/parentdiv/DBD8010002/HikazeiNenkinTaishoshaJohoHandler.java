/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.hikazeinenkintaishoshaJoho.HikazeiNenkinTaishoshaJohoBusiness;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100201.HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203.SokyuHikazeiNenkinBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode.SyoriJyoutaiCode;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.DBD8010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgKoikiTaishoShoriItiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgShoriSettei_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgTanitsuTaishoShoriItchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanriBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
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
    private final RString 年度 = new RString("年度");
    private final RString 月次 = new RString("月次");
    private final RString 対象ファイル_Z51 = new RString("Z51*****.DTA");
    private final RString 対象ファイル_Z52 = new RString("Z52*****.DTA");
    private final RString 広域保険者 = new RString("1");
    private final RString 単一保険者 = new RString("2");
    private static final RString Z5100000 = new RString("Z5100000_");
    private static final RString Z5200000 = new RString("Z5200000_");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");

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
     * @return 取込対象市町村コードリスト
     */
    public List<RString> onLoad(HikazeiNenkinTaishoshaJohoDiv div) {

        FlexibleYear 調定年度 = new FlexibleYear(get日付関連_調定年度());

        if (調定年度.isBeforeOrEquals(調定年度_2015)) {
            throw new ApplicationException(DbdErrorMessages.調定年度が_2016_以前.getMessage());
        }

        if (DBDMN81002.equals(ResponseHolder.getMenuID())) {
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900002.getReportId());
            div.getCcdChohyoSyuturyokuJun2().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900003.getReportId());
            div.getCcdChohyoSyuturyokuJun3().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900004.getReportId());
            div.getCcdChohyoSyuturyokuJun4().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900005.getReportId());

            FlexibleYear 平成年度 = 平成28年度;
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            while (調定年度.isBeforeOrEquals(平成年度)) {
                dataSource.add(new KeyValueDataSource(
                        new RString(平成年度.getYearValue()), 平成年度.wareki().eraType(EraType.KANJI).toDateString().concat(年度)));
                平成年度 = 平成年度.minusYear(1);
            }
            div.getDdlShoriNendo().setDataSource(dataSource);
            div.getDdlShoriNendo().setSelectedKey(dataSource.get(INT_0).getKey());

            return this.onChange_ddlShoriNendo(div);
        } else {
            div.setHdnState(DBD8010002StateName.遡及非課税年金対象者同定.getName());
            div.getCcdChohyoSyuturyokuJun1().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900006.getReportId());
            div.getCcdChohyoSyuturyokuJun2().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900007.getReportId());
            div.getCcdChohyoSyuturyokuJun3().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD900004.getReportId());
            return new ArrayList<>();
        }

    }

    /**
     * 年度DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return 取込対象市町村コードリスト
     */
    public List<RString> onChange_ddlShoriNendo(HikazeiNenkinTaishoshaJohoDiv div) {

        if (単一保険者.equals(広域と市町村判断())) {
            単一年度DDLの選択処理();
            div.setHdnState(DBD8010002StateName.非課税年金対象者情報_単一用.getName());
            return new ArrayList<>();
        } else {
            div.setHdnState(DBD8010002StateName.非課税年金対象者情報_広域用.getName());
            return 広域年度DDLの選択処理();
        }
    }

    /**
     * 月DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return 取込対象市町村コードリスト
     */
    public List<RString> onChange_ddlTuki(HikazeiNenkinTaishoshaJohoDiv div) {

        SearchResult<ShoriDateKanri> 年次処理情報List = get処理日付管理マスタ情報for月DDL();

        if (RSTRING_0.equals(div.getDdlTuki().getSelectedKey().substring(INT_0))) {
            div.getTxtTaishoFuairu().setValue(対象ファイル_Z51);
        } else if (RSTRING_1.equals(div.getDdlTuki().getSelectedKey().substring(INT_0))) {
            div.getTxtTaishoFuairu().setValue(対象ファイル_Z52);
        }

        if (年次処理情報List == null || 年次処理情報List.totalCount() == 0) {
            div.getTxtShoriJotai().setValue(SyoriJyoutaiCode.未処理.get名称());
            div.getTxtShoriNichiji().setValue(RString.EMPTY);
        } else {
            for (ShoriDateKanri shoriDateKanri : 年次処理情報List.records()) {
                if (div.getDdlTuki().getSelectedKey().equals(shoriDateKanri.get年度内連番())) {
                    div.getTxtShoriJotai().setValue(SyoriJyoutaiCode.toValue(shoriDateKanri.get処理枝番()).get名称());
                    div.getTxtShoriNichiji().setValue(shoriDateKanri.get基準日時().toDateString());
                    break;
                }
                div.getTxtShoriJotai().setValue(SyoriJyoutaiCode.未処理.get名称());
                div.getTxtShoriNichiji().setValue(RString.EMPTY);
            }
        }

        return this.get対象市町村Grid();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onClick_btnShoriSettei(HikazeiNenkinTaishoshaJohoDiv div) {

        div.getShoriSettei().setHdnShoriNendo(div.getDdlShoriNendo().getSelectedKey());
        div.getShoriSettei().getTxtShoriSetteiNendo().setValue(div.getDdlShoriNendo().getSelectedValue());

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

        List<dgShoriSettei_Row> rowList = new ArrayList<>();
        for (HikazeiNenkinTaishoshaJohoBusiness 対象処理 : 対象処理List) {

            dgShoriSettei_Row row = new dgShoriSettei_Row();
            row.setTxtTuki(対象処理.get月());
            row.setHdnTuki(対象処理.get月コード());
            row.setTxtShori(対象処理.get処理());
            row.setHdnShori(対象処理.get処理コード());
            row.setHdnSyokiShoriJotai(対象処理.get処理状態コード());
            row.getTxtShoriJotai().setDataSource(set処理状態List(対象処理.get処理状態コード()));
            row.getTxtShoriJotai().setSelectedKey(対象処理.get処理状態コード());
            row.setTxtShoriNitchiji(対象処理.get処理日時());

            rowList.add(row);
        }

        div.getDgShoriSettei().setDataSource(rowList);

    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onClick_btnBatchRegister(HikazeiNenkinTaishoshaJohoDiv div) {

        if (div.getCcdChohyoSyuturyokuJun1().get出力順ID() != null) {
            long 出力順ID = div.getCcdChohyoSyuturyokuJun1().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBD介護受給,
                    div.getCcdChohyoSyuturyokuJun1().get帳票ID(),
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
        }

        if (div.getCcdChohyoSyuturyokuJun2().get出力順ID() != null) {
            long 出力順ID = div.getCcdChohyoSyuturyokuJun2().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBD介護受給,
                    div.getCcdChohyoSyuturyokuJun2().get帳票ID(),
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
        }

        if (div.getCcdChohyoSyuturyokuJun3().get出力順ID() != null) {
            long 出力順ID = div.getCcdChohyoSyuturyokuJun3().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBD介護受給,
                    div.getCcdChohyoSyuturyokuJun3().get帳票ID(),
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
        }
        if (!DBDMN81002.equals(ResponseHolder.getMenuID())) {
            return;
        }
        if (div.getCcdChohyoSyuturyokuJun1().get出力順ID() != null) {
            long 出力順ID = div.getCcdChohyoSyuturyokuJun1().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBD介護受給,
                    div.getCcdChohyoSyuturyokuJun1().get帳票ID(),
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
        }

    }

    /**
     * 非課税年金対象者情報取込のパラメータ作成処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @param 構成市町村コードリスト List<RString>
     * @return HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter
     */
    public HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter createDBD301010BatchParamter(
            HikazeiNenkinTaishoshaJohoDiv div,
            List<RString> 構成市町村コードリスト) {

        HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter parameter = new HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter();

        parameter.set処理年度(new FlexibleYear(div.getDdlShoriNendo().getSelectedKey()));
        parameter.set処理区分(div.getDdlTuki().getSelectedKey().substring(INT_0));
        parameter.set対象月(div.getDdlTuki().getSelectedKey().substring(INT_1, INT_4));
        parameter.setテスト処理(div.getHeddaeria().getChkTesutoShoriTorikomi().isAllSelected() ? RSTRING_1 : RSTRING_0);
        if (KEY0.equals(div.getChohyoShutsuryokuUmu().getRadSonotaChohyo().getSelectedKey())) {
            parameter.set出力区分(RSTRING_1);
        } else if (KEY1.equals(div.getChohyoShutsuryokuUmu().getRadSonotaChohyo().getSelectedKey())) {
            parameter.set出力区分(RSTRING_0);
        }
        parameter.set処理状態(div.getTxtShoriJotai().getText());
        parameter.set構成市町村コードリスト(構成市町村コードリスト);
        parameter.set処理日時(new YMDHMS(div.getTxtShoriNichiji().getValue()));
        parameter.set出力順ID1(div.getCcdChohyoSyuturyokuJun1().get出力順ID());
        parameter.set出力順ID2(div.getCcdChohyoSyuturyokuJun2().get出力順ID());
        parameter.set出力順ID3(div.getCcdChohyoSyuturyokuJun3().get出力順ID());
        parameter.set出力順ID4(div.getCcdChohyoSyuturyokuJun4().get出力順ID());

        return parameter;
    }

    /**
     * 遡及非課税年金対象者同定のパラメータ作成処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return SokyuHikazeiNenkinBatchParameter
     */
    public SokyuHikazeiNenkinBatchParameter createDBD301020BatchParamter(
            HikazeiNenkinTaishoshaJohoDiv div) {

        SokyuHikazeiNenkinBatchParameter parameter = new SokyuHikazeiNenkinBatchParameter();

        parameter.set処理年度(new FlexibleYear(new RString("9999")));
        parameter.set処理区分(new RString("9"));
        //parameter.set対象月(new RString("999"));
        parameter.setテスト処理(div.getHeddaeria().getChkTesutoShoriTorikomi().isAllSelected() ? RSTRING_1 : RSTRING_0);
        parameter.set出力順ID1(div.getCcdChohyoSyuturyokuJun1().get出力順ID());
        parameter.set出力順ID2(div.getCcdChohyoSyuturyokuJun2().get出力順ID());
        parameter.set出力順ID3(div.getCcdChohyoSyuturyokuJun3().get出力順ID());

        return parameter;
    }

    /**
     * 「保存する」ボタンのクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onClick_btnUpdate(HikazeiNenkinTaishoshaJohoDiv div) {

        List<dgShoriSettei_Row> rowList = div.getDgShoriSettei().getDataSource();
        for (dgShoriSettei_Row row : rowList) {
            if (!row.getHdnSyokiShoriJotai().equals(row.getTxtShoriJotai().getSelectedKey())) {
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);

                ShoriDateKanri shoriDateKanri = new ShoriDateKanri(
                        SubGyomuCode.DBD介護受給,
                        new LasdecCode(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)),
                        ShoriName.非課税年金対象者情報取込.get名称(),
                        row.getTxtShoriJotai().getSelectedKey(),
                        new FlexibleYear(div.getShoriSettei().getHdnShoriNendo()),
                        row.getHdnShori().concat(row.getHdnTuki()));

                ShoriDateKanriBuilder builder = shoriDateKanri.createBuilderForEdit();
                ShoriDateKanri newShoriDateKanri = builder.build();
                ShoriDateKanriManager manager = new ShoriDateKanriManager();
                manager.save処理日付管理マスタ(newShoriDateKanri);
            }
        }
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

    private List<RString> 広域年度DDLの選択処理() {

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

        return this.onChange_ddlTuki(div);
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

    private SearchResult<ShoriDateKanri> get処理日付管理マスタ情報for月DDL() {

        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        return manager.get非課税年金対象者情報for月DDL(
                SubGyomuCode.DBD介護受給,
                ShoriName.非課税年金対象者情報取込.get名称(),
                new FlexibleYear(div.getDdlShoriNendo().getSelectedKey()),
                div.getDdlTuki().getSelectedKey());
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

    private List<RString> get対象市町村Grid() {
        List<KoseiShichosonMaster> 市町村情報リスト = KoseiShichosonJohoFinder.createInstance().get現市町村情報();

        List<dgKoikiTaishoShoriItiran_Row> 対象市町村Grid = new ArrayList<>();
        List<RString> 取込対象市町村コードリスト = new ArrayList<>();

        for (KoseiShichosonMaster master : 市町村情報リスト) {
            dgKoikiTaishoShoriItiran_Row row = new dgKoikiTaishoShoriItiran_Row();
            row.setHdnShichosonCode(master.get市町村コード().code市町村RString());
            row.setTxtShichoson(master.get市町村名称());

            RString 年次月次 = RString.EMPTY;
            if (RSTRING_0.equals(div.getDdlTuki().getSelectedKey().substring(INT_0))) {
                年次月次 = Z5100000;
            } else if (RSTRING_1.equals(div.getDdlTuki().getSelectedKey().substring(INT_0))) {
                年次月次 = Z5200000;
            }
            List<UzT0885SharedFileEntryEntity> result = SharedFile.searchSharedFile(
                    年次月次.concat(div.getDdlShoriNendo().getSelectedKey()).
                    concat(div.getDdlTuki().getSelectedKey()).concat(new RString("_")).
                    concat(master.get市町村コード().code市町村RString()).concat(new RString(".DTA")));

            if (result == null || result.isEmpty()) {
                this.setチェックボックスfor共有フォルダ無(master.get市町村コード(), row);
            } else {
                取込対象市町村コードリスト.add(master.get市町村コード().code市町村RString());
                row.setTxtTorikomi(Boolean.TRUE);
            }
            対象市町村Grid.add(row);
        }

        div.getDgKoikiTaishoShoriItiran().setDataSource(対象市町村Grid);

        return 取込対象市町村コードリスト;
    }

    private void setチェックボックスfor共有フォルダ無(LasdecCode 市町村コード, dgKoikiTaishoShoriItiran_Row row) {

        SearchResult<ShoriDateKanri> result = get処理日付管理マスタ情報forチェック(市町村コード);

        if (result == null || result.totalCount() == 0) {
            row.setTxtTorikomi(Boolean.FALSE);
        } else {
            for (ShoriDateKanri shoriDateKanri : result.records()) {
                if (SyoriJyoutaiCode.処理なし.getコード().equals(shoriDateKanri.get処理枝番())) {
                    row.setTxtTorikomi(Boolean.TRUE);
                    break;
                }
                row.setTxtTorikomi(Boolean.FALSE);
            }
        }
    }

    private SearchResult<ShoriDateKanri> get処理日付管理マスタ情報forチェック(LasdecCode 市町村コード) {

        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        return manager.get非課税年金対象者情報forチェック(
                SubGyomuCode.DBD介護受給,
                ShoriName.非課税年金対象者情報取込.get名称(),
                new FlexibleYear(div.getDdlShoriNendo().getSelectedKey()),
                市町村コード,
                div.getDdlTuki().getSelectedKey());
    }

    private List<KeyValueDataSource> set処理状態List(RString 処理状態) {

        List<KeyValueDataSource> dataSource = new ArrayList<>();

        if (SyoriJyoutaiCode.未処理.getコード().equals(処理状態)) {
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.未処理.getコード(), SyoriJyoutaiCode.未処理.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.処理なし.getコード(), SyoriJyoutaiCode.処理なし.get名称()));
        } else if (SyoriJyoutaiCode.処理済.getコード().equals(処理状態)) {
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.処理済.getコード(), SyoriJyoutaiCode.処理済.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.再処理前.getコード(), SyoriJyoutaiCode.再処理前.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.追加取込前.getコード(), SyoriJyoutaiCode.追加取込前.get名称()));
        } else if (SyoriJyoutaiCode.再処理前.getコード().equals(処理状態)) {
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.再処理前.getコード(), SyoriJyoutaiCode.再処理前.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.処理済.getコード(), SyoriJyoutaiCode.処理済.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.追加取込前.getコード(), SyoriJyoutaiCode.追加取込前.get名称()));
        } else if (SyoriJyoutaiCode.処理なし.getコード().equals(処理状態)) {
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.処理なし.getコード(), SyoriJyoutaiCode.処理なし.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.未処理.getコード(), SyoriJyoutaiCode.未処理.get名称()));
        } else if (SyoriJyoutaiCode.追加取込前.getコード().equals(処理状態)) {
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.追加取込前.getコード(), SyoriJyoutaiCode.追加取込前.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.処理済.getコード(), SyoriJyoutaiCode.処理済.get名称()));
            dataSource.add(new KeyValueDataSource(SyoriJyoutaiCode.再処理前.getコード(), SyoriJyoutaiCode.再処理前.get名称()));
        }

        return dataSource;
    }

}
