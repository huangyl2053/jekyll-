/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 BodyEditorクラスです。
 *
 * @reamsid_L DBC-2660-040 lijian
 */
public class GassanHoseizumiJikofutangakuSofuchiranBodyEditor implements IGassanHoseizumiJikofutangakuSofuchiranEditor {

    private static final RString 接続文字 = new RString("～");
    private static final RString 対象年度 = new RString("年度");
    private static final RString 再送フラグ = new RString("1");
    private static final RString 再送要の場合 = new RString("※");
    private final SyuturyokuEntity 送付一覧表データ;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 送付一覧表データ SyuturyokuEntity
     * @param 連番 int
     */
    public GassanHoseizumiJikofutangakuSofuchiranBodyEditor(SyuturyokuEntity 送付一覧表データ, int 連番) {
        this.送付一覧表データ = 送付一覧表データ;
        this.連番 = 連番;
    }

    @Override
    public GassanHoseizumiJikofutangakuSofuchiranSource edit(GassanHoseizumiJikofutangakuSofuchiranSource source) {
        DbWT37K1KogakuGassanJikoFutanGakuTempEntity entity = 送付一覧表データ.get高額合算自己負担額一時Entity();
        source.list_1 = new RString(連番);
        if (entity.getTaishoNendo() != null) {
            source.list_2 = 送付一覧表データ.get高額合算自己負担額一時Entity().getTaishoNendo().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(対象年度);
        }
        if (entity.getHihokenshaNo() != null) {
            source.list_3 = entity.getHihokenshaNo().value();
        }
        source.list_4 = entity.getShikyuShinseishoSeiriNo();

        DbWT1001HihokenshaTempEntity tempEntity = 送付一覧表データ.get被保険者一時Entity();

        source.yubinNo = tempEntity.getYubinNo();
        source.choikiCode = tempEntity.getChoikiCode();
        source.gyoseikuCode = tempEntity.getGyoseikuCode();
        source.shimei50onKana = tempEntity.getShimei50onKana();
        if (tempEntity.getShichosonCode() != null) {
            source.shichosonCode = tempEntity.getShichosonCode().value();
        }
        if (tempEntity.getExShoHokenshaNo() != null) {
            source.exShoHokenshaNo = tempEntity.getExShoHokenshaNo().value();
        }

        source.list_5 = tempEntity.getMeisho();
        source.list_6 = entity.getShomeisho_UketoriYM().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        source.list_7 = get年月日(entity.getBatchHoseiJissiYMD());
        source.list_8 = get年月日(entity.getRealHoseiJissiYMD());
        source.list_9 = get年月日(entity.getShinseiYMD());
        source.list_10 = get期間(get年月日(entity.getHihokenshaKaishiYMD()), get年月日(entity.getHihokenshaShuryoYMD()));
        source.list_11 = get期間(get年月日(entity.getTaishoKeisanKaishiYMD()), get年月日(entity.getTaishoKeisanShuryoYMD()));
        source.list_12 = doカンマ編集(entity.getSumi_Gokei_JikoFutanGaku());
        source.list_13 = doカンマ編集(entity.getSumi_Gokei_70_74JikoFutanGaku());
        source.list_14 = doカンマ編集(entity.getSumi_Gokei_Under70KogakuShikyuGaku());

        if (tempEntity.getShikibetsuCode() != null) {
            source.shikibetsuCode = tempEntity.getShikibetsuCode().value();
        }

        if (再送フラグ.equals(entity.getSaisoFlag())) {
            source.list_15 = 再送要の場合;
        } else {
            source.list_15 = RString.EMPTY;
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.list_3));
        return source;
    }

    private RString get期間(RString s1, RString s2) {
        return new RString(new StringBuilder(s1).append(接続文字).append(s2).toString());
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }
}
