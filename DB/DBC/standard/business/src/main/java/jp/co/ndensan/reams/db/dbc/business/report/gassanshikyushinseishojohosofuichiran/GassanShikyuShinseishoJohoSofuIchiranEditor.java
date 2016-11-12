/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanKofuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKeitai;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のEditorクラスです。
 *
 * @reamsid_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranEditor implements IGassanShikyuShinseishoJohoSofuIchiranEditor {

    private final KogakugassanShikyushinseishoOutFileEntity entity;
    private final RString 図形 = new RString("～");
    private final RString 図形_2 = new RString("※");
    private final RString 再送 = new RString("1");
    private final YMDHMS システム日時;
    private final FlexibleYearMonth 処理年月;
    private final int 連番;
    private final boolean flag;
    private static final RString 年度 = new RString("年度");
    private static final RDate NOWDATE = RDate.getNowDate();
    private static final SubGyomuCode DBU介護統計報告 = SubGyomuCode.DBU介護統計報告;
    private static final RString 保険者情報_保険者番号 = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, NOWDATE, DBU介護統計報告);
    private static final RString 保険者情報_保険者名称 = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, NOWDATE, DBU介護統計報告);

    /**
     * コンストラクタです。
     *
     * @param entity KogakugassanShikyushinseishoOutFileEntity
     * @param システム日時 YMDHMS
     * @param 処理年月 FlexibleYearMonth
     * @param 連番 int
     * @param flag boolean
     */
    public GassanShikyuShinseishoJohoSofuIchiranEditor(
            KogakugassanShikyushinseishoOutFileEntity entity,
            YMDHMS システム日時,
            FlexibleYearMonth 処理年月,
            int 連番,
            boolean flag) {
        this.entity = entity;
        this.システム日時 = システム日時;
        this.処理年月 = 処理年月;
        this.連番 = 連番;
        this.flag = flag;
    }

    @Override
    public GassanShikyuShinseishoJohoSofuIchiranSource edit(GassanShikyuShinseishoJohoSofuIchiranSource source) {
        DbWT3711KogakuGassanShinseishoTempEntity 高額合算申請書一時Entity = entity.get高額合算申請書一時Entity();
        DbWT1001HihokenshaTempEntity 被保険者一時Entity = entity.get被保険者一時Entity();

        if (被保険者一時Entity.getShikibetsuCode() != null) {
            source.shikibetsuCode = 被保険者一時Entity.getShikibetsuCode().value();
        }
        RString 帳票作成年月日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成日時 = システム日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成日時);
        if (処理年月 != null) {
            source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.hokenshaNo = 保険者情報_保険者番号;
        source.hokenshaName = 保険者情報_保険者名称;
        source.list_1 = new RString(連番);
        同一申請情報の編集(source);
        if (高額合算申請書一時Entity.getHihokenshaNo() != null) {
            source.list_9 = 高額合算申請書一時Entity.getHihokenshaNo().value();
        }
        source.list_10 = 被保険者一時Entity.getMeisho();
        if (高額合算申請書一時Entity.getKanyuKaishiYMD() != null && 高額合算申請書一時Entity.getKanyuShuryoYMD() != null) {
            RString 加入期間開始年月日 = 高額合算申請書一時Entity.getKanyuKaishiYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 加入期間終了年月日 = 高額合算申請書一時Entity.getKanyuShuryoYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.list_11 = 加入期間開始年月日.concat(図形).concat(加入期間終了年月日);
        }

        if (高額合算申請書一時Entity.getShotokuKubun() != null) {
            source.list_12 = KaigoGassan_ShotokuKbn.toValue(高額合算申請書一時Entity.getShotokuKubun()).get名称();
        }
        if (高額合算申請書一時Entity.getOver70_ShotokuKubun() != null) {
            source.list_13 = KaigoGassan_Over70_ShotokuKbn.toValue(高額合算申請書一時Entity.getOver70_ShotokuKubun()).get名称();
        }
        if (高額合算申請書一時Entity.getShiharaiHohoKubun() != null) {
            source.list_14 = ShiharaiHohoKubun.toValue(高額合算申請書一時Entity.getShiharaiHohoKubun()).get名称();
        }

        if (再送.equals(高額合算申請書一時Entity.getSaiSofuFlag())) {
            source.list_15 = 図形_2;
        } else {
            source.list_15 = RString.EMPTY;
        }
        if (高額合算申請書一時Entity.isJufukuKubun()) {
            source.list_16 = 図形_2;
        } else {
            source.list_16 = RString.EMPTY;
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.list_9));
        return source;
    }

    private void 同一申請情報の編集(GassanShikyuShinseishoJohoSofuIchiranSource source) {
        DbWT3711KogakuGassanShinseishoTempEntity 高額合算申請書一時Entity = entity.get高額合算申請書一時Entity();
        if (flag) {
            if (高額合算申請書一時Entity.getTaishoNendo() != null && !高額合算申請書一時Entity.getTaishoNendo().isEmpty()) {
                source.list_2 = 高額合算申請書一時Entity.getTaishoNendo().wareki().fillType(FillType.BLANK).toDateString().concat(年度);
            }
            if (高額合算申請書一時Entity.getShikyuShinseiKubun() != null) {
                source.list_3 = KaigoGassan_ShinseiKbn.toValue(高額合算申請書一時Entity.getShikyuShinseiKubun()).get名称();
            }
            if (高額合算申請書一時Entity.getShinseiYMD() != null) {
                source.list_4 = 高額合算申請書一時Entity.getShinseiYMD().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
            source.list_5 = 高額合算申請書一時Entity.getShikyuShinseishoSeiriNo();
            if (高額合算申請書一時Entity.getShinseiDaihyoshaShimei() != null) {
                source.list_6 = 高額合算申請書一時Entity.getShinseiDaihyoshaShimei().value();
            }
            if (高額合算申請書一時Entity.getJikoFutanKofuUmu() != null) {
                source.list_7 = KaigoGassan_JikoFutanKofuUmu.toValue(高額合算申請書一時Entity.getJikoFutanKofuUmu()).get名称();
            }
            if (高額合算申請書一時Entity.getShikyuShinseiKeitai() != null) {
                source.list_8 = KaigoGassan_ShinseiKeitai.toValue(高額合算申請書一時Entity.getShikyuShinseiKeitai()).get名称();
            }
        }
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }
}
