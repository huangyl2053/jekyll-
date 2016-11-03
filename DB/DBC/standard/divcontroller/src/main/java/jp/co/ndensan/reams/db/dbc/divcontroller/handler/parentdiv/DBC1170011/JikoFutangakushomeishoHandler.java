/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1170011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.business.kogakugassan.KogakuGassanNendoKey;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoData;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFromData;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiJokyoKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeisho.JikoFutangakushomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011.JikoFutangakuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.jikofutangakushomeisho.JikoFutangakushomeishoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 自己負担額証明書作成のHandlerクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class JikoFutangakushomeishoHandler {

    private final JikoFutangakuShomeishoDiv div;
    private static final RString メニューID_DBCMN63001 = new RString("DBCMN63001");
    private static final RString メニューID_DBCMNN2001 = new RString("DBCMNN2001");
    private static final RString 自己負担額証明書作成 = new RString("自己負担額証明書作成");
    private static final RString 事業分_自己負担額証明書作成 = new RString("事業分・自己負担額証明書作成");
    private static final int 月_8 = 8;
    private static final int 月_12 = 12;
    private static final int 月_1 = 1;
    private static final int 月_7 = 7;
    private static final int 日_1 = 1;
    private static final int 日_31 = 31;
    private static final int 年_2 = 2;
    private JikoFutangakushomeishoManager 高額合算申請書 = JikoFutangakushomeishoManager.createInstance();

    /**
     * コンストラクタです。
     *
     * @param div ShomeishoSakuseiParameterDiv
     */
    public JikoFutangakushomeishoHandler(JikoFutangakuShomeishoDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param メニューID RString
     * @param システム日付 FlexibleDate
     * @param 年度毎キー 年度毎キー
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void onLoad(RString メニューID, FlexibleDate システム日付, Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー,
            HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getJikoFutanShomeishoSakusei().getCcdAtenaInfo().initialize(識別コード);
        div.getJikoFutanShomeishoSakusei().getCcdShikakuKihon().initialize(被保険者番号);

        if (0 < 年度毎キー.size()) {
            set対象年度DDL(システム日付, 年度毎キー);
            支給申請書整理番号DDL(年度毎キー);
        }

        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        KogakuGassanJikoFutanGaku 自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        JigyoKogakuGassanJikoFutanGaku 事業高額合算自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号_DBCMNN2001(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        if (メニューID_DBCMN63001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(自己負担額entity.get自己負担額証明書整理番号());
            div.getJikoFutanShomeishoSakuseiPrint().getTxtZenkaiHakkoDate().setValue(自己負担額entity.get自己負担額証明書作成年月日());
            div.getJikoFutanShomeishoSakusei().setTitle(自己負担額証明書作成);
        } else if (メニューID_DBCMNN2001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(事業高額合算自己負担額entity.get自己負担額証明書整理番号());
            div.getJikoFutanShomeishoSakusei().setTitle(事業分_自己負担額証明書作成);
            div.getJikoFutanShomeishoSakuseiPrint().getTxtZenkaiHakkoDate().setValue(事業高額合算自己負担額entity.get自己負担額証明書作成年月日());
        }
        div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().setValue(システム日付);
        div.getJikoFutanShomeishoSakuseiPrint().getCcdBunshoNo().initialize(new ReportId(new RString("DBC100050_JikoFutangakushomeisho")));

    }

    /**
     * get対象者データ
     *
     * @param 被保険者番号 HihokenshaNo
     * @return KogakuGassanShinseisho
     */
    public KogakuGassanShinseisho get対象者データ(HihokenshaNo 被保険者番号) {
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 申請状況区分 = KaigoGassan_ShinseiJokyoKbn.証明書交付申請書.getコード();
        RString 支給申請区分 = KaigoGassan_ShinseiKbn.取り下げ.getCode();
        return 高額合算申請書.get対象者データ(被保険者番号, 保険者番号, 申請状況区分, 支給申請区分);
    }

    private void set対象年度DDL(FlexibleDate システム日付, Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー) {
        int システム月 = システム日付.getMonthValue();
        int システム日 = システム日付.getDayValue();
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (FlexibleYear entry : 年度毎キー.keySet()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(entry.toDateString());
            dataSource.setValue(set平成年度(entry));
            dataList.add(dataSource);
        }
        div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().setDataSource(dataList);
        for (FlexibleYear entry : 年度毎キー.keySet()) {
            if (entry.equals(FlexibleDate.getNowDate().getYear())) {
                if ((月_8 <= システム月 && システム月 <= 月_12) && (日_1 <= システム日 && システム日 <= 日_31)) {
                    div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().setSelectedKey(FlexibleDate.getNowDate().getYear().minusYear(年_2).toDateString());
                } else if ((月_1 <= システム月 && システム月 <= 月_7) && (日_1 <= システム日 && システム日 <= 日_31)) {
                    div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().setSelectedKey(FlexibleDate.getNowDate().getYear().minusYear(1).toDateString());
                }
            }
        }
    }

    private void 支給申請書整理番号DDL(Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー) {
        List<KeyValueDataSource> dataList_支給申請書整理番号 = new ArrayList<>();
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        List<KogakuGassanNendoKey> 高額合算年度キーList = 年度毎キー.get(対象年度);
        for (KogakuGassanNendoKey kogakuGassanNendoKey : 高額合算年度キーList) {
            KeyValueDataSource dataSource_支給申請書整理番号 = new KeyValueDataSource();
            dataSource_支給申請書整理番号.setKey(kogakuGassanNendoKey.get支給申請書整理番号());
            dataSource_支給申請書整理番号.setValue(kogakuGassanNendoKey.get支給申請書整理番号());
            dataList_支給申請書整理番号.add(dataSource_支給申請書整理番号);
        }
        div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setDataSource(dataList_支給申請書整理番号);
        div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setSelectedKey(高額合算年度キーList.get(0).get支給申請書整理番号());
    }

    private RString set平成年度(FlexibleYear dateTime) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        return hakkoYMD.toRString();
    }

    /**
     * 対象年度DDLのonChangeメソッドです。
     *
     * @param メニューID RString
     * @param 年度毎キー 年度毎キー
     */
    public void onChange_taishoNendoDDLSelect(RString メニューID, Map<FlexibleYear, List<KogakuGassanNendoKey>> 年度毎キー) {
        List<KogakuGassanNendoKey> 高額合算年度キーList = 年度毎キー.get(new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey()));
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (KogakuGassanNendoKey kogakuGassanNendoKey : 高額合算年度キーList) {
            KeyValueDataSource dataSource_支給申請書整理番号 = new KeyValueDataSource();
            dataSource_支給申請書整理番号.setKey(kogakuGassanNendoKey.get支給申請書整理番号());
            dataSource_支給申請書整理番号.setValue(kogakuGassanNendoKey.get支給申請書整理番号());
            dataList.add(dataSource_支給申請書整理番号);
        }
        div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setDataSource(dataList);
        div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().setSelectedKey(高額合算年度キーList.get(0).get支給申請書整理番号());
        RString 被保険者番号 = div.getJikoFutanShomeishoSakusei().getCcdShikakuKihon().get被保険者番号();
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        KogakuGassanJikoFutanGaku 自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号(new HihokenshaNo(被保険者番号), 対象年度, 保険者番号, 支給申請書整理番号);
        JigyoKogakuGassanJikoFutanGaku 事業高額合算自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号_DBCMNN2001(new HihokenshaNo(被保険者番号), 対象年度, 保険者番号, 支給申請書整理番号);
        if (メニューID_DBCMN63001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(自己負担額entity.get自己負担額証明書整理番号());
        } else if (メニューID_DBCMNN2001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(事業高額合算自己負担額entity.get自己負担額証明書整理番号());
        }
    }

    /**
     * 対象年度DDLのonChangeメソッドです。
     *
     * @param メニューID RString
     */
    public void onChange_shikyuShinseishoSeiriNoDDLSelect(RString メニューID) {
        RString 被保険者番号 = div.getJikoFutanShomeishoSakusei().getCcdShikakuKihon().get被保険者番号();
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        KogakuGassanJikoFutanGaku 自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号(new HihokenshaNo(被保険者番号), 対象年度, 保険者番号, 支給申請書整理番号);
        JigyoKogakuGassanJikoFutanGaku 事業高額合算自己負担額entity = 高額合算申請書.get自己負担額証明書整理番号_DBCMNN2001(new HihokenshaNo(被保険者番号), 対象年度, 保険者番号, 支給申請書整理番号);
        if (メニューID_DBCMN63001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(自己負担額entity.get自己負担額証明書整理番号());
        } else if (メニューID_DBCMNN2001.equals(メニューID)) {
            div.getJikoFutanShomeishoSakuseiPrint().getTxtJikoFutangakuShomeishoSeiriNo().setValue(事業高額合算自己負担額entity.get自己負担額証明書整理番号());
        }
    }

    /**
     * get再計算区分
     *
     * @return KogakuGassanShinseisho 再計算
     */
    public KogakuGassanShinseisho get再計算区分() {
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 被保険者番号 = div.getJikoFutanShomeishoSakusei().getCcdShikakuKihon().get被保険者番号();
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        return 高額合算申請書.get再計算区分(new HihokenshaNo(被保険者番号), 保険者番号, 対象年度, 支給申請書整理番号);
    }

    /**
     * get高額合算データ
     *
     * @param 被保険者番号 HihokenshaNo
     * @param メニューID メニューID
     * @return JikoFutangakushomeishoData
     */
    public JikoFutangakushomeishoData get高額合算データ(HihokenshaNo 被保険者番号, RString メニューID) {
        FlexibleYear 対象年度 = new FlexibleYear(div.getJikoFutanShomeishoSakuseiPrint().getDdlTaishoNendo().getSelectedKey());
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 支給申請書整理番号 = div.getJikoFutanShomeishoSakuseiPrint().getDdlShikyuShinseishoSeiriNo().getSelectedKey();
        JikoFutangakushomeishoParameter parameter = new JikoFutangakushomeishoParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.set保険者番号(保険者番号);
        parameter.set対象年度(対象年度);
        parameter.set支給申請書整理番号(支給申請書整理番号);
        parameter.setメニューID(メニューID);
        JikoFutangakushomeishoData 高額合算データ = new JikoFutangakushomeishoData();
        KogakuGassanData kogakuGassanData = 高額合算申請書.get高額合算情報(parameter);
        RString 文書番号 = 高額合算申請書.get文書番号();
        RString タイトル = 高額合算申請書.getタイトル(メニューID);
        高額合算データ.set高額合算データ(kogakuGassanData);
        高額合算データ.set問合せ先情報(高額合算申請書.get問合せ先());
        高額合算データ.set文書番号(文書番号);
        高額合算データ.setタイトル(タイトル);
        高額合算データ.set宛先情報(高額合算申請書.get宛先帳票部品());
        return 高額合算データ;

    }

    /**
     * get高額合算データ2009
     *
     * @param data JikoFutangakushomeishoData
     * @return JikoFutangakushomeishoFromData
     */
    public JikoFutangakushomeishoFromData get高額合算データ2009(JikoFutangakushomeishoData data) {
        JikoFutangakushomeishoFromData fromData = new JikoFutangakushomeishoFromData();
        fromData.setタイトル(data.getタイトル());
        fromData.set保険者情報(data.get保険者情報());
        fromData.set備考(data.get備考());
        fromData.set問合せ先情報(data.get問合せ先情報());
        fromData.set宛先情報(data.get宛先情報());
        fromData.set文書番号(data.get文書番号());
        fromData.set認証者情報(data.get認証者情報());
        fromData.set通知文1(data.get通知文1());
        fromData.set通知文2(data.get通知文2());
        fromData.set高額合算データ(data.get高額合算データ());
        return fromData;
    }
}
