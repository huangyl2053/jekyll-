/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * DBE230004_主治医意見書作成依頼履歴一覧表のEditorクラスです。
 *
 * @reamsid_L DBE-1590-032 zuotao
 */
public class IkenshoirairirekiIchiranEditor implements IIkenshoirairirekiIchiranEditor {

    private final IkenshoirairirekiIchiran business;

    /**
     * コンストラクタです。
     *
     * @param business {@link IkenshoirairirekiIchiran}
     */
    protected IkenshoirairirekiIchiranEditor(IkenshoirairirekiIchiran business) {
        this.business = business;
    }

    /**
     * 委員用予備判定記入表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public IkenshoirairirekiIchiranReportSource edit(IkenshoirairirekiIchiranReportSource source) {
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

        source.listChokkinKubun_1 = business.get直近区分();
        source.listHihokenshaNo_1 = business.get被保険者番号().value();
        if (business.get被保険者氏名カナ() != null) {
            source.listHihokenshaKana_1 = business.get被保険者氏名カナ().value();
        }
        if (business.get被保険者氏名() != null) {
            source.listHihokenshaName_1 = business.get被保険者氏名().value();
        }
        if (business.get住所() != null) {
            source.listHihokenshaJusho_1 = business.get住所().value();
        }
        source.listIryokikanName_1 = business.get医療機関名称();
        source.listIshiName_1 = business.get主治医氏名();
        if (business.get主治医意見書作成依頼年月日() != null && !business.get主治医意見書作成依頼年月日().isEmpty()) {
            source.listIkenshoiraiYMD_1 = business.get主治医意見書作成依頼年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.listShinseiKubun_1 = business.get認定申請区分();
        source.listKeizokukubun_1 = business.get継続区分();
        return source;
    }
}
