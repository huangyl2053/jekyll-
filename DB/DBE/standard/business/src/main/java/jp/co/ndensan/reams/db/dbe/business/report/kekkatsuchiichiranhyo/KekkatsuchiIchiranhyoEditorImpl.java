/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定結果通知一覧表のEditorです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
public class KekkatsuchiIchiranhyoEditorImpl implements IKekkatsuchiIchiranhyoEditor {

    private static final RString TITLE = new RString("要介護認定結果通知一覧表");
    private static final RString カラ = new RString("～");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final KekkatsuchiIchiranhyoEntity entity;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link KekkatsuchiIchiranhyoEntity}
     * @param index 連番
     */
    protected KekkatsuchiIchiranhyoEditorImpl(KekkatsuchiIchiranhyoEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    /**
     * 要介護認定結果通知一覧表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public KekkatsuchiIchiranhyoReportSource edit(KekkatsuchiIchiranhyoReportSource source) {
        return editSource(source);
    }

    private KekkatsuchiIchiranhyoReportSource editSource(KekkatsuchiIchiranhyoReportSource source) {
        source.title = TITLE;
        source.shichosonName = entity.getShichosonName();
        source.shinsakaiNo = entity.getShinsakaiNo();
        source.shinsakaiKaisaiYMD = entity.getShinsakaiKaisaiYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getShinsakaiKaisaiYMD()));
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(entity.getPrintTimeStamp().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(作成);
        source.printTimeStamp = printTimeStamp.toRString();
        source.listKekkatsuchitaisho_1 = new RString(String.valueOf(index));
        source.listKekkatsuchitaisho_2 = entity.getHokenshaName();
        source.listKekkatsuchitaisho_3 = entity.getShinseiYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getShinseiYMD()));
        source.listKekkatsuchitaisho_4 = entity.getHihokenshaNo();
        source.shikibetuCode = new ShikibetsuCode(RString.EMPTY);
        source.hishokenshaNo = new ExpandedInformation(Code.EMPTY, new RString("被保険者番号"), entity.getHihokenshaNo());
        source.listKekkatsuchitaisho_5 = entity.getHihokenshaName();
        source.listKekkatsuchitaisho_6 = entity.getHihokenshaKana();
        source.listKekkatsuchitaisho_7 = entity.getSeinengappiYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getSeinengappiYMD()));
        source.listKekkatsuchitaisho_8 = entity.getSeibetsu();
        source.listKekkatsuchitaisho_9 = entity.getNijiHanteiKekka();
        source.listKekkatsuchitaisho_10 = entity.getNinteiYukoKikan();
        RStringBuilder builder = new RStringBuilder();
        builder.append(entity.getNinteiYukokaishiYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getNinteiYukokaishiYMD())));
        builder.append(カラ);
        builder.append(entity.getNinteiYukoshurouYMD() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getNinteiYukoshurouYMD())));
        source.listKekkatsuchitaisho_11 = builder.toRString();
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString());
    }
}
