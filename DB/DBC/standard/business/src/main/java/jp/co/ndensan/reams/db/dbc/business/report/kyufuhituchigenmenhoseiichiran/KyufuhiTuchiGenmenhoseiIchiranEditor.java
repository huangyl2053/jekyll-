/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * DBC200043_給付費通知減免補正一覧表 Editorクラスです。
 *
 * @reamsid_L DBC-2270-040 dongyabin
 */
public class KyufuhiTuchiGenmenhoseiIchiranEditor implements IKyufuhiTuchiGenmenhoseiIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final KyufuhiTuchiGenmenhoseiIchiranEntity data;

    /**
     * コンストラクタです。
     *
     * @param data 給付費通知減免補正一覧表パラメータ
     */
    public KyufuhiTuchiGenmenhoseiIchiranEditor(KyufuhiTuchiGenmenhoseiIchiranEntity data) {
        this.data = data;
    }

    /**
     * DBC200043_給付費通知減免補正一覧表の項目編集です
     *
     * @param source KyufuhiTuchiGenmenhoseiIchiranSource
     * @return KyufuhiTuchiGenmenhoseiIchiranSource
     */
    @Override
    public KyufuhiTuchiGenmenhoseiIchiranReportSource edit(KyufuhiTuchiGenmenhoseiIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = new RString("給付費通知減免補正一覧表");
        source.hokenshaNo = data.get保険者コード();
        source.hokenshaName = data.get保険者名();
        source.kaipage1 = data.get改ページ条件1();
        source.kaipage2 = data.get改ページ条件2();
        source.kaipage3 = data.get改ページ条件3();
        source.kaipage4 = data.get改ページ条件4();
        source.kaipage5 = data.get改ページ条件5();
        source.shutsuryokujun1 = data.get出力順1();
        source.shutsuryokujun2 = data.get出力順2();
        source.shutsuryokujun3 = data.get出力順3();
        source.shutsuryokujun4 = data.get出力順4();
        source.shutsuryokujun5 = data.get出力順5();
        source.list_1 = data.get被保険者番号();
        source.list_2 = data.get被保険者名();
        source.list_3 = data.get年月();
        source.list_4 = data.getサービス事業者コード();
        source.list_5 = data.getサービス事業者();
        source.list_6 = data.getサービス種類コード();
        source.list_7 = data.getサービス種類();
        source.list_8 = kinngakuFormat(data.get利用者負担額());
        source.list_9 = kinngakuFormat(data.getサービス費用());
        return source;
    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        return printTimeStampSb.toRString();
    }

    private RString kinngakuFormat(RString date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(date.toString()), 0);
    }

}
