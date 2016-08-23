/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 資格取得者不整合リストのEditorです。
 *
 * @reamsid_L DBU-4020-040 lishengli
 */
public class ShikakushutokushaFuseigoIchiranhyoEditorImpl implements IShikakushutokushaFuseigoIchiranhyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final ShikakushutokushaFuseigoIchiranhyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShikakushutokushaFuseigoIchiranhyoEntity}
     */
    protected ShikakushutokushaFuseigoIchiranhyoEditorImpl(ShikakushutokushaFuseigoIchiranhyoEntity item) {
        this.item = item;
    }

    /**
     * 資格取得者不整合リストを編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShikakushutokushaFuseigoIchiranhyoReportSource edit(ShikakushutokushaFuseigoIchiranhyoReportSource source) {
        return editSource(source);
    }

    private ShikakushutokushaFuseigoIchiranhyoReportSource editSource(ShikakushutokushaFuseigoIchiranhyoReportSource source) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = RDate.getNowDateTime();
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
        printTimeStampSb.append(作成);
        source.printTimeStamp = item.getタイトル();
        source.title = item.getタイトル();
        source.shichosonCode = item.get市町村コード();
        source.shichosonName = item.get市町村名称();
        source.listHihokensha_1 = item.get被保険者番号();
        source.listHihokensha_2 = item.get識別コード();
        source.listHihokensha_3 = get生年月日(item.get生年月日());
        source.listHihokensha_4 = item.get市町村コード();
        source.listHihokensha_5 = item.get資格区分();
        source.listHihokensha_6 = item.get住特();
        source.listHihokensha_7 = item.get不整合情報();
        source.listGenJusho_1 = item.get現住所();
        source.listMaeJusho_1 = item.get前住所();
        source.listShimei_1 = item.getﾌﾘｶﾞﾅ();
        source.listShimeiKana_1 = item.get氏名();
        return source;
    }

    private RString get生年月日(FlexibleDate 生年月日) {
        if (生年月日 != null && 生年月日.isEmpty()) {
            return 生年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }
}
