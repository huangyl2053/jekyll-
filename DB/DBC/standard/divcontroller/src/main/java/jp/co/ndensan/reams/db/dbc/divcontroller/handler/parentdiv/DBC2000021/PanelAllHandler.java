/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.service.core.panelall.HonsanteiIdoKanendo;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_新規のハンドラクラスです。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class PanelAllHandler {

    private final DBC2000021PanelAllDiv div;
    private static final RString NUM_3 = new RString("3");
    private static final RString NUM_4 = new RString("4");
    private static final RString NUM_5 = new RString("5");
    private static final RString NUM_0001 = new RString("0001");
    private static final RString NUM_0002 = new RString("0002");
    private static final RString NUM_0003 = new RString("0003");
    private static final RString 個人番号_利用有無名称 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無名称 = new RString("法人番号 利用有無");
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final RString 無し = new RString("無し");
    private static final RString 有し = new RString("有し");
    private static final RString 年次利用者負担割合判定を実行してください = new RString("年次利用者負担割合判定");
    private FlexibleYear 負担割合年度;
    private RString 年度y;
    private static final RString 新年度 = new RString("新年度");
    private static final RString 現年度 = new RString("現年度");
    private static final RString 過年度 = new RString("過年度");

    /**
     * コンストラクタです
     *
     * @param div DBC2000021PanelAllDiv
     */
    public PanelAllHandler(DBC2000021PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        RString 処理名 = ShoriName.年次利用者負担割合判定.get名称();
        RString 市町村コード = Association.getLasdecCode().getColumnValue();
        List<KeyValueDataSource> keyValues = new ArrayList<>();
        List<ShoriDateKanri> 処理日付管理情報 = HonsanteiIdoKanendo.createInstance().getNendo(
                SubGyomuCode.DBC介護給付, 市町村コード, 処理名);
        div.getDdlNendo().getDataSource().clear();
        if (処理日付管理情報 == null || 処理日付管理情報.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.未実行.getMessage().replace(年次利用者負担割合判定を実行してください.toString()));
        } else {
            for (ShoriDateKanri shoriDateKanri : 処理日付管理情報) {
                keyValues.add(new KeyValueDataSource(new RString(
                        Integer.toString(shoriDateKanri.toEntity().getNendo().getYearValue())),
                        shoriDateKanri.toEntity().getNendo().wareki().getYear()));
            }
            div.getDdlNendo().setDataSource(keyValues);
            div.getDdlNendo().setSelectedIndex(0);
            set基準日();
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));

    }

    /**
     * 基準日セットのメソッドです。
     */
    public void set基準日() {

        FlexibleYear 年度 = new FlexibleYear(div.getDdlNendo().getSelectedKey());
        RDate システム日付 = RDate.getNowDate();
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, システム日付,
                SubGyomuCode.DBC介護給付);
        RDate 年月日 = new RDate(((年度.toDateString()).concat(月日)).toString());
        if (システム日付.isBeforeOrEquals(年月日)) {
            負担割合年度 = new FlexibleYear(システム日付.getYear().minusYear(1).toDateString());
        } else {
            負担割合年度 = new FlexibleYear(システム日付.getYear().toDateString());
        }
        if (負担割合年度.isBefore(年度)) {
            年度y = 新年度;
        } else if (負担割合年度.equals(年度)) {
            年度y = 現年度;
        } else {
            年度y = 過年度;
        }
        if (年度y.equals(新年度)) {
            div.getTxtKijunbi().setValue(年月日.plusDay(1));

        } else if (年度y.equals(現年度)) {
            div.getTxtKijunbi().setValue(システム日付);
        } else {
            div.getTxtKijunbi().setValue(年月日);
        }
    }

    /**
     * is基準日は指定年度内判定のメソッドです。
     *
     * @return Boolean
     */
    public boolean is基準日は指定年度内() {

        RDate 年度 = new RDate((div.getDdlNendo().getSelectedValue().concat(DbBusinessConfig
                .get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(), SubGyomuCode.DBC介護給付)).toString()));
        if (!(年度.plusDay(1).isBeforeOrEquals(div.getTxtKijunbi().getValue()))
                || !(div.getTxtKijunbi().getValue().isBeforeOrEquals(年度.plusYear(1)))) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 新規判定を実行のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 年度 FlexibleYear
     * @param 基準日 FlexibleDate
     * @return RiyoshaFutanWariaiHanteiManagerResult
     */
    public RiyoshaFutanWariaiHanteiManagerResult hannTei(HihokenshaNo 被保険者番号, FlexibleYear 年度, FlexibleDate 基準日) {
        RiyoshaFutanWariaiHanteiManagerResult 判定結果
                = RiyoshaFutanWariaiHanteiManager.createInstance().futanWariaiHantei(被保険者番号, 年度, 基準日);
        if (NUM_5.equals(判定結果.get判定区分())) {
            throw new ApplicationException(DbcErrorMessages.基準日被保険者データなし.toString());
        } else if (NUM_4.equals(判定結果.get判定区分())) {
            throw new ApplicationException(DbcErrorMessages.基準日受給者_事業対象者データなし.toString());
        } else if (NUM_3.equals(判定結果.get判定区分())) {
            throw new ApplicationException(DbcErrorMessages.基準日負担割合変更なし.toString());
        }
        return 判定結果;
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code(NUM_0001), 個人番号_利用有無名称, 有し);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code(NUM_0002), 法人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code(NUM_0003), 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3);
    }

}
