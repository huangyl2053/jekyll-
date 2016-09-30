/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.kogakuservicehitaishoshaichiransokyubun;

import java.util.List;
import java.util.Map;
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
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private static final RString KEY_並び順の１件目 = new RString("KEY_並び順の１件目");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param entity 給付管理票送付一覧表
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    protected KogakuServicehiTaishoshaIchiranSokyubunEditor(
            KogakuServicehiTaishoshaIchiranSokyubunEntity entity, Map<RString, RString> 出力順Map, List<RString> 改頁リスト) {
        this.entity = entity;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        
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
        source.shutsuryokujun1 = get並び順(KEY_並び順の１件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の５件目);
        source.kaipage1 = get改頁(INDEX_0);
        source.kaipage2 = get改頁(INDEX_1);
        source.kaipage3 = get改頁(INDEX_2);
        source.kaipage4 = get改頁(INDEX_3);
        source.kaipage5 = get改頁(INDEX_4);
        
        source.listTaishosha_1 = entity.get連番();
        source.listTaishosha_2 = entity.get被保険者番号();
        source.listTaishosha_3 = パターン54(entity.getサービス提供年月());
        source.listTaishosha_4 = entity.get被保険者名();
        source.listTaishosha_5 = entity.get世帯コード(); // QA確認中
        source.listTaishosha_6 = new RString("単");
        source.listTaishosha_7 = toRString(entity.get利用者負担額());
        source.listTaishosha_8 =  new RString("※");
        source.listTaishosha_9 = toRString(entity.get支給_予定_金額());
        source.listTaishosha_10 = entity.get備考();
        source.listTaishosha_11 = entity.getマスタの状況();
        source.shikibetuCode = entity.get識別コード();
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), entity.get被保険者番号());
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString get改頁(int index) {
        return index < 改頁リスト.size() ? 改頁リスト.get(index) : RString.EMPTY;
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
