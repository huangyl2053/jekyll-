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
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuIchiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のEditorクラスです。
 *
 * @author DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranEditor implements IGassanShikyuShinseishoJohoSofuIchiranEditor {

    private final KogakugassanShikyushinseishoOutFileEntity entity;
    private final RString 図形 = new RString("～");
    private final RString 図形_2 = new RString("※");
    private final RString 再送 = new RString("1");
    private final YMDHMS システム日時;
    private final FlexibleYearMonth 処理年月;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity KogakugassanShikyushinseishoOutFileEntity
     * @param システム日時 YMDHMS
     * @param 処理年月 FlexibleYearMonth
     * @param 連番 int
     */
    public GassanShikyuShinseishoJohoSofuIchiranEditor(
            KogakugassanShikyushinseishoOutFileEntity entity,
            YMDHMS システム日時,
            FlexibleYearMonth 処理年月,
            int 連番) {
        this.entity = entity;
        this.システム日時 = システム日時;
        this.処理年月 = 処理年月;
        this.連番 = 連番;
    }

    @Override
    public GassanShikyuShinseishoJohoSofuIchiranSource edit(GassanShikyuShinseishoJohoSofuIchiranSource source) {
        DbWT3711KogakuGassanShinseishoTempEntity 高額合算申請書一時Entity = entity.get高額合算申請書一時Entity();
        DbWT1001HihokenshaTempEntity 被保険者一時Entity = entity.get被保険者一時Entity();

        if (被保険者一時Entity.getShikibetsuCode() != null) {
            source.shikibetsuCode = 被保険者一時Entity.getShikibetsuCode().value();
        }

        if (システム日時 != null) {
            RString 帳票作成年月日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成日時 = システム日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成日時);
        }
        if (処理年月 != null) {
            source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.hokenshaNo = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.list_1 = new RString(連番);
        if (!高額合算申請書一時Entity.getShikyuShinseishoSeiriNo().equals(new RString(高額合算申請書一時Entity.getRirekiNo().toString()))) {
            source.list_2 = 高額合算申請書一時Entity.getTaishoNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            if (高額合算申請書一時Entity.getShikyuShinseiKubun() != null) {
                source.list_3 = KaigoGassan_ShinseiKbn.toValue(高額合算申請書一時Entity.getShikyuShinseiKubun()).get名称();
            }
            source.list_4 = new RString(高額合算申請書一時Entity.getShinseiYMD().toString());
            source.list_5 = 高額合算申請書一時Entity.getShikyuShinseishoSeiriNo();
            source.list_6 = new RString(高額合算申請書一時Entity.getShinseiDaihyoshaShimei().toString());
            if (高額合算申請書一時Entity.getJikoFutanKofuUmu() != null) {
                source.list_7 = KaigoGassan_JikoFutanKofuUmu.toValue(高額合算申請書一時Entity.getJikoFutanKofuUmu()).get名称();
            }
            if (高額合算申請書一時Entity.getShikyuShinseiKeitai() != null) {
                source.list_8 = KaigoGassan_ShinseiKeitai.toValue(高額合算申請書一時Entity.getShikyuShinseiKeitai()).get名称();
            }
        }
        source.list_9 = new RString(高額合算申請書一時Entity.getHihokenshaNo().toString());
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
            source.list_15 = KokuhorenDataSaisoFlag.再送要.get名称();
        } else {
            source.list_15 = RString.EMPTY;
        }
        if (高額合算申請書一時Entity.isJufukuKubun()) {
            source.list_16 = 図形_2;
        } else {
            source.list_16 = RString.EMPTY;
        }
        return source;
    }

}
