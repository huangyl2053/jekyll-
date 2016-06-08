/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 月別推移表ヘッダのEditorです。
 *
 * @reamsid_L DBB-0760-050 wangxiaodong
 */
public class TsukibetsuSuiihyoHeaderEditorImpl implements ITsukibetsuSuiihyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final TsukibetsuSuiihyoEntity item;

    /**
     * コンストラクタです。
     *
     * @param item 月別推移表ヘッダのITEM
     */
    public TsukibetsuSuiihyoHeaderEditorImpl(TsukibetsuSuiihyoEntity item) {
        this.item = item;
    }

    /**
     * 月別推移表ヘッダエディターです。
     *
     * @param source 月別推移表
     * @return TsukibetsuSuiihyoReportSource
     */
    @Override
    public TsukibetsuSuiihyoReportSource edit(TsukibetsuSuiihyoReportSource source) {
        return editHeader(source);
    }

    private TsukibetsuSuiihyoReportSource editHeader(TsukibetsuSuiihyoReportSource source) {
        source.printTimeStamp = get作成日時();
        source.gengo = item.get元号();
        source.nendo = item.get年度();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.choshuHouhouTitle = item.get徴収方法Title();
        return source;
    }

    private RString get作成日時() {
        RDateTime printdate = item.get発行日時();
        RStringBuilder 作成日時 = new RStringBuilder();
        作成日時.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        作成日時.append(RString.HALF_SPACE);
        作成日時.append(String.format("%02d", printdate.getHour()));
        作成日時.append(DATE_時);
        作成日時.append(String.format("%02d", printdate.getMinute()));
        作成日時.append(DATE_分);
        作成日時.append(String.format("%02d", printdate.getSecond()));
        作成日時.append(DATE_秒);
        return 作成日時.toRString();
    }
}
