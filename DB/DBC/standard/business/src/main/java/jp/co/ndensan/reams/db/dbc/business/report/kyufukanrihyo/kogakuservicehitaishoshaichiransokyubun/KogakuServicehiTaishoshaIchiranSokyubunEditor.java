/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.kogakuservicehitaishoshaichiransokyubun;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分）のEditorです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
public class KogakuServicehiTaishoshaIchiranSokyubunEditor implements IKogakuServicehiTaishoshaIchiranSokyubunEditor {

    private final KogakuServicehiTaishoshaIchiranSokyubunEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 給付管理票送付一覧表
     */
    protected KogakuServicehiTaishoshaIchiranSokyubunEditor(
            KogakuServicehiTaishoshaIchiranSokyubunEntity entity) {
        this.entity = entity;

    }

    @Override
    public KogakuServicehiTaishoshaIchiranSokyubunReportSource edit(KogakuServicehiTaishoshaIchiranSokyubunReportSource source) {
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(entity.getシステムの時間().getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append("△");
        hakkoYMD.append(entity.getシステムの時間().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        hakkoYMD.append("△");
        source.printTimeStamp = new RString(hakkoYMD.toString());

        source.hokenshaNo = entity.get市町村コード();
        source.hokenshaName = entity.get市町村名();
        source.shutsuryokujun1 = entity.get並び順1();
        source.shutsuryokujun2 = entity.get並び順2();
        source.shutsuryokujun3 = entity.get並び順3();
        source.shutsuryokujun4 = entity.get並び順4();
        source.shutsuryokujun5 = entity.get並び順5();
        source.kaipage1 = entity.get改頁1();
        source.kaipage2 = entity.get改頁2();
        source.kaipage3 = entity.get改頁3();
        source.kaipage4 = entity.get改頁4();
        source.kaipage5 = entity.get改頁5();
        source.listTaishosha_1 = entity.get連番();
        source.listTaishosha_2 = entity.get被保険者番号();
        source.listTaishosha_3 = パターン54(entity.getサービス提供年月());
        source.listTaishosha_4 = entity.get被保険者名();
        source.listTaishosha_5 = entity.get世帯コード();
        source.listTaishosha_6 = new RString("単");
        source.listTaishosha_7 = toRString(entity.get利用者負担額());
        source.listTaishosha_8 = new RString("※");
        source.listTaishosha_9 = toRString(entity.get支給_予定_金額());
        source.listTaishosha_10 = entity.get備考();
        source.listTaishosha_11 = entity.getマスタの状況();
        source.shikibetuCode = entity.get識別コード();
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(entity.get被保険者番号()));
        return source;
    }

    private RString toRString(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toRString(金額, 0);
        }
        return RString.EMPTY;
    }

    private RString パターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
