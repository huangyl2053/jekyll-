/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsaHanteiJokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoEditorImpl implements IShinsaHanteiJokyoEditor {

    private final ShinsaHanteiJokyoEntity itemEntity;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param itemEntity {@link ShinsaHanteiJokyoEntity}
     */
    protected ShinsaHanteiJokyoEditorImpl(ShinsaHanteiJokyoEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    /**
     * 介護認定審査会判定状況表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShinsaHanteiJokyoReportSource edit(ShinsaHanteiJokyoReportSource source) {
        return editSource(source);
    }

    private ShinsaHanteiJokyoReportSource editSource(ShinsaHanteiJokyoReportSource source) {
        source.title = itemEntity.getタイトル();
        source.gogitaiName = itemEntity.get合議体名称();
        source.kaisaiKaishiYMD = RString.isNullOrEmpty(itemEntity.get開催開始年月日())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(itemEntity.get開催開始年月日()));
        source.kaisaiShuryoYMD = RString.isNullOrEmpty(itemEntity.get開催終了年月日())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(itemEntity.get開催終了年月日()));
        source.kaisaiCount = itemEntity.get開催回数();
        source.hokenshaNo = itemEntity.get保険者番号();
        source.printTimeStamp = getNowDate();
        source.hokenshaName = itemEntity.get保険者番号();
        source.listHanteiKensu_1 = itemEntity.get変更者();
        source.listHanteiKensu_2 = itemEntity.get軽度();
        source.listHanteiKensu_3 = itemEntity.get重度();
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
    }

    private RString getNowDate() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(DATE_作成);
        return printTimeStamp.toRString();
    }
}
