/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表のEditorです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 *
 */
public class KyufuhiTuchiHakkoIchiranEditor implements IKyufuhiTuchiHakkoIchiranEditor {

    private final KyufuhiTuchiHakkoIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTuchiHakkoIchiranEntity}
     */
    protected KyufuhiTuchiHakkoIchiranEditor(KyufuhiTuchiHakkoIchiranEntity item) {
        this.item = item;
    }

    @Override
    public KyufuhiTuchiHakkoIchiranReportSource edit(KyufuhiTuchiHakkoIchiranReportSource source) {
        return editSource(source);
    }

    private KyufuhiTuchiHakkoIchiranReportSource editSource(KyufuhiTuchiHakkoIchiranReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();
        source.hokenshaNo = item.get保険者コード();
        source.hokenshaName = item.get保険者名();
        source.shutsuryokujun1 = item.get出力順1();
        source.shutsuryokujun2 = item.get出力順2();
        source.shutsuryokujun3 = item.get出力順3();
        source.shutsuryokujun4 = item.get出力順4();
        source.shutsuryokujun5 = item.get出力順5();
        source.kaipage1 = item.get改ページ条件1();
        source.kaipage2 = item.get改ページ条件2();
        source.kaipage3 = item.get改ページ条件3();
        source.kaipage4 = item.get改ページ条件4();
        source.kaipage5 = item.get改ページ条件5();
        source.listCenter_1 = item.get帳票連番();
        source.listCenter_2 = item.get被保険者番号();
        source.listCenter_3 = item.get証記載保険者();
        RStringBuilder iraiDateTime1 = new RStringBuilder();
        if (!RString.isNullOrEmpty(item.get年月())) {
            iraiDateTime1.append(new RDate(item.get年月().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).
                    fillType(FillType.BLANK).toDateString());
        }
        source.listCenter_4 = iraiDateTime1.toRString();
        source.listCenter_5 = item.getサービス事業者コード();
        source.listCenter_6 = item.getサービス事業者();
        source.listCenter_7 = item.getサービス種類コード();
        source.listCenter_8 = item.getサービス項目コード();
        source.listCenter_9 = item.getサービス名称();
        source.listCenter_10 = item.get日数_回数();
        source.listCenter_11 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(item.get利用者負担額_円().toString()), 0);
        source.listCenter_12 = DecimalFormatter.
                toコンマ区切りRString(new Decimal(item.getサービス費用_円().toString()), 0);
        source.listCenter_13 = item.get要介護度();
        source.listCenter_14 = item.get資格喪失日();
        source.listCenter_15 = item.get喪失事由();
        source.listCenter_16 = item.get補正有無();
        source.listHihokenshaNo_1 = item.get被保険者氏名();
        return source;
    }
}
