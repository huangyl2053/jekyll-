/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;
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
 * @reamsid_L DBD-1770-030 donghj
 */
public class JukyushaIdoCheckListEditor implements IJukyushaIdoCheckListEditor {

    private final JyukyushaDaichoIdoCheckListEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link JyukyushaDaichoIdoCheckListEntity}
     */
    public JukyushaIdoCheckListEditor(JyukyushaDaichoIdoCheckListEntity entity) {
        this.entity = entity;
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
        return source;
    }

    private void edit印刷日時(JukyushaIdoCheckListReportSource source) {
        source.printTimeStamp = get印刷日時();
    }

    private void edit保険者番号(JukyushaIdoCheckListReportSource source) {
        source.hokenshaNo = entity.get保険者番号().getColumnValue();
    }

    private void edit保険者名称(JukyushaIdoCheckListReportSource source) {
        source.hokenshaName = entity.get保険者名称();
    }

    private void edit出力順1(JukyushaIdoCheckListReportSource source) {
    }

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
