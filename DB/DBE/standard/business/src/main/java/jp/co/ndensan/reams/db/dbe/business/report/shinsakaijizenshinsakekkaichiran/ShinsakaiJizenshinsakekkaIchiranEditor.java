/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事前審査結果一覧表Editorクラスです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranEditor implements IShinsakaiJizenshinsakekkaIchiranEditor {

    private final ShinsakaiJizenshinsakekkaIchiranEntity entity;
    private static final RString 事前審査結果集計表 = new RString("事前審査結果集計表");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param entity item {@link ShinsakaiJizenshinsakekkaIchiranEntity}
     */
    protected ShinsakaiJizenshinsakekkaIchiranEditor(ShinsakaiJizenshinsakekkaIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public ShinsakaiJizenshinsakekkaIchiranReportSource edit(ShinsakaiJizenshinsakekkaIchiranReportSource source) {
        source.title = 事前審査結果集計表;
        source.printTimeStamp = get作成年月日時();
        source.gogitaiNo = entity.get合議体番号();
        source.shinsakaiNo = entity.get介護認定審査会開催番号();
        source.shinsakaiKaisaiYMD = entity.get介護認定審査会開催予定年月日();
        source.cityName = DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        source.listShinsain_1 = entity.get審査員1();
        source.listShinsain_2 = entity.get審査員2();
        source.listShinsain_3 = entity.get審査員3();
        source.listShinsain_4 = entity.get審査員4();
        source.listShinsain_5 = entity.get審査員5();
        source.listShukeihyo_1 = entity.getNo();
        source.listShukeihyo_2 = entity.get特定疾病();
        source.listShukeihyo_3 = entity.get被保険者番号();
        source.listShukeihyo_4 = entity.get前回介護度();
        source.listShukeihyo_5 = entity.getメモ1();
        source.listShukeihyo_6 = entity.get判定1();
        source.listShukeihyo_7 = entity.get期間1();
        source.listShukeihyo_8 = entity.getメモ2();
        source.listShukeihyo_9 = entity.get判定2();
        source.listShukeihyo_10 = entity.get期間2();
        source.listShukeihyo_11 = entity.getメモ3();
        source.listShukeihyo_12 = entity.get判定3();
        source.listShukeihyo_13 = entity.get期間3();
        source.listShukeihyo_14 = entity.getメモ4();
        source.listShukeihyo_15 = entity.get判定4();
        source.listShukeihyo_16 = entity.get期間4();
        source.listShukeihyo_17 = entity.getメモ5();
        source.listShukeihyo_18 = entity.get判定5();
        source.listShukeihyo_19 = entity.get期間5();
        source.listShukeihyo_20 = entity.getNo();
        source.listShukeihyo_21 = entity.get一次判定();
        source.listShukeihyo_22 = entity.get二次判定();
        source.listShukeihyo_23 = entity.get区分();
        source.listShukeihyo_24 = entity.get有効期間();
        source.listShukeihyo_25 = entity.get有効期間開始年月日();
        source.listShukeihyo_26 = entity.get有効期間終了年月日();
        source.listShukeihyo_27 = entity.get一次判定の変更理由();
        source.itchiKensu = entity.get一致件数();
        source.shinsaKensu = entity.get審査件数();
        return editSource(source);
    }

    private ShinsakaiJizenshinsakekkaIchiranReportSource editSource(ShinsakaiJizenshinsakekkaIchiranReportSource source) {

        return source;
    }

    /**
     * 年月日時の作成
     *
     * @return 作成年月日時
     */
    private RString get作成年月日時() {
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
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
    }
}
