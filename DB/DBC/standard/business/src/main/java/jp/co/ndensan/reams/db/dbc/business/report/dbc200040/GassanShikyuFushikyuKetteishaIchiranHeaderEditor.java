/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteiTsuchiIchiran;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額合算支給決定者一覧表HeaderEditor
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
public class GassanShikyuFushikyuKetteishaIchiranHeaderEditor
        implements IGassanShikyuFushikyuKetteishaIchiranEditor {

    private final KogakugassanShikyuKetteiTsuchiIchiran entity;
    private final YMDHMS 作成日時;
    private final GassanShikyuFushikyuKetteishaIchiranParameter paramter;

    private static final RString 日付選択区分_1 = new RString("1");
    private static final RString 日付選択区分_2 = new RString("2");
    private static final RString 日付選択区分_3 = new RString("3");
    private static final RString 接続符 = new RString("～");

    private static final RString SAKUSEI = new RString("作成");
    private static final RString 受取年月 = new RString("受取年月：");
    private static final RString 申請年月日 = new RString("申請年月日：");
    private static final RString 決定年月日 = new RString("決定年月日：");

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanShikyuKetteiTsuchiIchiran
     * @param 作成日時 YMDHMS
     * @param paramter GassanShikyuFushikyuKetteishaIchiranParameter
     */
    public GassanShikyuFushikyuKetteishaIchiranHeaderEditor(
            KogakugassanShikyuKetteiTsuchiIchiran entity, YMDHMS 作成日時, GassanShikyuFushikyuKetteishaIchiranParameter paramter) {
        this.entity = entity;
        this.作成日時 = 作成日時;
        this.paramter = paramter;
    }

    @Override
    public GassanShikyuFushikyuKetteishaIchiranSource edit(
            GassanShikyuFushikyuKetteishaIchiranSource source) {
        if (null == entity) {
            return source;
        }
        RString 作成日 = 作成日時.getRDateTime().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        if (paramter.get市町村コード() != null) {
            source.hokenshaNo = paramter.get市町村コード().value();
        }
        source.hokenshaName = paramter.get市町村名称();
        source.shutsuryokujun1 = entity.get出力順1();
        source.shutsuryokujun2 = entity.get出力順2();
        source.shutsuryokujun3 = entity.get出力順3();
        source.shutsuryokujun4 = entity.get出力順4();
        source.shutsuryokujun5 = entity.get出力順5();
        source.kaipage1 = entity.get改頁1();
        source.kaipage2 = entity.get改頁2();
        source.kaipage3 = entity.get改頁3();
        source.kaipage4 = entity.get改頁4();
        source.kaipage5 = entity.get改頁5();
        if (日付選択区分_1.equals(paramter.get日付選択区分())) {
            source.chushutsuJoken = 受取年月.concat(paramter.get受取年月().toDateString());
        } else if (日付選択区分_2.equals(paramter.get日付選択区分())) {
            source.chushutsuJoken = 申請年月日.concat(getパターン4(paramter.get申請開始年月日())).
                    concat(接続符).concat(getパターン4(paramter.get申請終了年月日()));
        } else if (日付選択区分_3.equals(paramter.get日付選択区分())) {
            source.chushutsuJoken = 決定年月日.concat(getパターン4(paramter.get決定開始年月日())).
                    concat(接続符).concat(getパターン4(paramter.get決定終了年月日()));
        }
        return source;
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

}
