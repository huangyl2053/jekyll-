/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者台帳異動チェックリストのEditorです。
 *
 * @reamsid_L DBD-1770-040 donghj
 */
public class JukyushaIdoCheckListEditor implements IJukyushaIdoCheckListEditor {

    private final JukyushaIdoCheckListItem item;
    private final UpperEntity upperEntity;
    private final LowerEntity lowerEntity;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JukyushaIdoCheckListItem}
     * @param upperEntity {@link UpperEntity}
     * @param lowerEntity {@link LowerEntity}
     */
    public JukyushaIdoCheckListEditor(JukyushaIdoCheckListItem item, UpperEntity upperEntity, LowerEntity lowerEntity) {
        this.item = item;
        this.upperEntity = upperEntity;
        this.lowerEntity = lowerEntity;
    }

    /**
     * 受給者台帳異動チェックリストeditです。
     *
     * @param source JukyushaIdoCheckListReportSource
     * @return JukyushaIdoCheckListReportSource
     */
    @Override
    public JukyushaIdoCheckListReportSource edit(JukyushaIdoCheckListReportSource source) {
        return edit項目(source);
    }

    private JukyushaIdoCheckListReportSource edit項目(JukyushaIdoCheckListReportSource source) {
        edit印刷日時(source);
        edit保険者番号(source);
        edit保険者名称(source);
        edit出力順(source);
        edit改頁(source);
        edit被保険者番号(source);
        edit識別コード(source);
        edit住所(source);
        editフリガナ(source);
        edit生年月日(source);
        edit異動区分(source);
//        TODO edit処理種別(source);
        edit受給申請日(source);
        edit認定日(source);
        edit認定有効開始日(source);
        edit喪失年月日(source);
        edit異動事由(source);
        edit有効無効(source);
        edit住所コード(source);
        edit行政区コード(source);
        edit行政区(source);
        edit氏名(source);
        edit年齢(source);
        edit受給申請事由(source);
        edit要介護度(source);
        edit認定有効終了日(source);
        edit旧措置者(source);
        edit処理内容(source);
//    TODO    edit備考(source);
        return source;
    }

    private void edit印刷日時(JukyushaIdoCheckListReportSource source) {
        source.printTimeStamp = get印刷日時();
    }

    private void edit保険者番号(JukyushaIdoCheckListReportSource source) {
        source.hokenshaNo = upperEntity.get保険者番号().getColumnValue();
    }

    private void edit保険者名称(JukyushaIdoCheckListReportSource source) {
        source.hokenshaName = upperEntity.get保険者名称();
    }

    private void edit出力順(JukyushaIdoCheckListReportSource source) {
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();

    }

    private void edit改頁(JukyushaIdoCheckListReportSource source) {
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
    }

    private void edit被保険者番号(JukyushaIdoCheckListReportSource source) {
        source.listUpper_1 = upperEntity.get被保険者番号().getColumnValue();
    }

    private void edit識別コード(JukyushaIdoCheckListReportSource source) {
        source.listUpper_2 = upperEntity.get識別コード().getColumnValue();

    }

    private void edit住所(JukyushaIdoCheckListReportSource source) {
        source.listUpper_3 = upperEntity.get住所().getColumnValue();
    }

    private void editフリガナ(JukyushaIdoCheckListReportSource source) {
        source.listUpper_4 = upperEntity.getフリガナ().getColumnValue();
    }

    private void edit生年月日(JukyushaIdoCheckListReportSource source) {
        source.listUpper_5 = new RString(upperEntity.get生年月日().toString());
    }

    private void edit異動区分(JukyushaIdoCheckListReportSource source) {
        source.listUpper_6 = upperEntity.get異動区分();
    }

//    TODO QA 项目位定义 private void edit処理種別(JukyushaIdoCheckListReportSource source) {
//    }
    private void edit受給申請日(JukyushaIdoCheckListReportSource source) {
        source.listUpper_8 = new RString(upperEntity.get受給申請日().toString());
    }

    private void edit認定日(JukyushaIdoCheckListReportSource source) {
        source.listUpper_9 = new RString(upperEntity.get認定日().toString());
    }

    private void edit認定有効開始日(JukyushaIdoCheckListReportSource source) {
        source.listUpper_10 = new RString(upperEntity.get認定有効開始日().toString());
    }

    private void edit喪失年月日(JukyushaIdoCheckListReportSource source) {
        source.listUpper_11 = new RString(upperEntity.get喪失年月日().toString());
    }

    private void edit異動事由(JukyushaIdoCheckListReportSource source) {
        source.listUpper_12 = upperEntity.get異動事由();
    }

    private void edit有効無効(JukyushaIdoCheckListReportSource source) {
        source.listUpper_13 = upperEntity.get有効無効();
    }

    private void edit住所コード(JukyushaIdoCheckListReportSource source) {
        source.listLower_1 = lowerEntity.get住所コード().getColumnValue();
    }

    private void edit行政区コード(JukyushaIdoCheckListReportSource source) {
        source.listLower_2 = lowerEntity.get行政区コード().getColumnValue();
    }

    private void edit行政区(JukyushaIdoCheckListReportSource source) {
        source.listLower_3 = lowerEntity.get行政区();
    }

    private void edit氏名(JukyushaIdoCheckListReportSource source) {
        source.listLower_4 = lowerEntity.get氏名().getColumnValue();
    }

    private void edit年齢(JukyushaIdoCheckListReportSource source) {
        source.listLower_5 = new RString(lowerEntity.get年齢());
    }

    private void edit受給申請事由(JukyushaIdoCheckListReportSource source) {
        source.listLower_6 = lowerEntity.get受給申請事由();
    }

    private void edit要介護度(JukyushaIdoCheckListReportSource source) {
        source.listLower_7 = lowerEntity.get要介護度();
    }

    private void edit認定有効終了日(JukyushaIdoCheckListReportSource source) {
        source.listLower_8 = new RString(lowerEntity.get認定有効終了日().toString());
    }

    private void edit旧措置者(JukyushaIdoCheckListReportSource source) {
        source.listLower_9 = lowerEntity.get旧措置者();
    }

    private void edit処理内容(JukyushaIdoCheckListReportSource source) {
        source.listLower_10 = lowerEntity.get処理内容();
    }

//    TODO QA 项目位定义 private void edit備考(JukyushaIdoCheckListReportSource source) {
//    }
    private RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        RString 時分秒 = datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(時分秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

}
