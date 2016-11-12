/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Teishotokusha1SaikeisanJisshiUmu;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
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
 * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 BodyEditorクラスです。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public class GassanShikyugakuKeisankekkaSofuIchiranBodyEditor implements IGassanShikyugakuKeisankekkaSofuIchiranEditor {

    private final RString 対象年度 = new RString("年度");
    private static final int LENGTH_TWENTY = 20;
    private static final int LENGTH_ZERO = 0;
    private static final RString 接続文字 = new RString("～");
    private final GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 送付一覧表データ GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity
     * @param 連番 int
     */
    public GassanShikyugakuKeisankekkaSofuIchiranBodyEditor(
            GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ,
            int 連番) {
        this.送付一覧表データ = 送付一覧表データ;
        this.連番 = 連番;
    }

    @Override
    public GassanShikyugakuKeisankekkaSofuIchiranSource edit(GassanShikyugakuKeisankekkaSofuIchiranSource source) {

        source.listUpper_1 = new RString(連番);
        DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity 高額合算Entity = 送付一覧表データ.get高額合算支給額計算結果一時();
        DbWT1001HihokenshaTempEntity tempEntity = 送付一覧表データ.get被保険者一時();
        source.listUpper_2 = 高額合算Entity.getShikyuShinseishoSeiriNo();

        if (tempEntity.getMeisho().length() <= LENGTH_TWENTY) {
            source.listUpper_3 = tempEntity.getMeisho();
        } else {
            source.listUpper_3 = tempEntity.getMeisho().substring(LENGTH_ZERO, LENGTH_TWENTY);
        }

        if (高額合算Entity.getTaishoNendo() != null) {
            source.listUpper_4 = 高額合算Entity.getTaishoNendo().wareki().fillType(FillType.BLANK).toDateString().concat(対象年度);
        }
        source.listUpper_5 = doカンマ編集(高額合算Entity.getSetaiFutanSogaku());
        source.listUpper_6 = doカンマ編集(高額合算Entity.getSetaiGassanGaku());
        if (高額合算Entity.getShotokuKubun() != null) {
            source.listUpper_7 = KaigoGassan_ShotokuKbn.toValue(高額合算Entity.getShotokuKubun()).get名称();
        }
        source.listUpper_8 = doカンマ編集(高額合算Entity.getSanteiKijunGaku());
        source.listUpper_9 = doカンマ編集(高額合算Entity.getSetaiShikyuSogaku());
        source.listUpper_10 = doカンマ編集(高額合算Entity.getHonninShikyugaku());
        if (高額合算Entity.getTeiShotoku_1_SaiKeisanUmu() != null) {
            source.listUpper_11 = KaigoGassan_Teishotokusha1SaikeisanJisshiUmu.toValue(高額合算Entity.getTeiShotoku_1_SaiKeisanUmu()).get名称();
        }
        if (高額合算Entity.getHihokenshaNo() != null) {
            source.listLower_1 = 高額合算Entity.getHihokenshaNo().value();
        }
        source.listLower_2 = get期間(get年月日(高額合算Entity.getTaishoKeisanKaishiYMD()), get年月日(高額合算Entity.getTaishoKeisanShuryoYMD()));
        source.listLower_3 = doカンマ編集(高額合算Entity.getOver70_SetaiGassanGaku());
        if (高額合算Entity.getOver70_ShotokuKubun() != null) {
            source.listLower_4 = KaigoGassan_Over70_ShotokuKbn.toValue(高額合算Entity.getOver70_ShotokuKubun()).get名称();
        }
        source.listLower_5 = doカンマ編集(高額合算Entity.getOver70_SanteiKijyunGaku());
        source.listLower_6 = doカンマ編集(高額合算Entity.getOver70_SetaiShikyuSogaku());
        source.listLower_7 = doカンマ編集(高額合算Entity.getOver70_honninShikyugaku());
        source.yubinNo = tempEntity.getYubinNo();
        source.choikiCode = tempEntity.getChoikiCode();
        source.gyoseikuCode = tempEntity.getGyoseikuCode();
        source.shimei50onKana = tempEntity.getShimei50onKana();
        source.shichosonCode = tempEntity.getShichosonCode();
        source.shoKisaiHokenshaNo = 高額合算Entity.getShoKisaiHokenshaNo().getColumnValue();
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.listLower_1));
        return source;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get年月日(FlexibleDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get期間(RString s1, RString s2) {
        return new RString(new StringBuilder(s1).append(接続文字).append(s2).toString());
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
