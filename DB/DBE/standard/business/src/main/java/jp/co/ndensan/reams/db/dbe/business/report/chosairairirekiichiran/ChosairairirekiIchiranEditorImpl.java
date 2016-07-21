/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
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
 * 認定調査依頼履歴一覧表のEditorです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
public class ChosairairirekiIchiranEditorImpl implements IChosairairirekiIchiranEditor {

    private final ChosairairirekiIchiranBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link ChosairairirekiIchiranBusiness}
     */
    protected ChosairairirekiIchiranEditorImpl(ChosairairirekiIchiranBusiness business) {
        this.business = business;
    }

    /**
     * 認定調査依頼履歴一覧表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ChosairairirekiIchiranReportSource edit(ChosairairirekiIchiranReportSource source) {
        source.printTimeStamp = get処理時間();
        source.listChokkinKubun_1 = business.get直近区分();
        source.listHihokenshaNo_1 = business.get被保険者番号();
        source.listHihokenshaKana_1 = business.get氏名カナ();
        source.listHihokenshaJusho_1 = business.get住所();
        source.listChosakikanName_1 = business.get調査機関名();
        source.listChosairaiYMD_1 = business.get認定調査依頼日();
        source.listShinseiKubun_1 = business.get申請区分();
        source.listHihokenshaName_1 = business.get氏名();
        source.listChosainName_1 = business.get調査員名();
        return source;
    }

    private RString get処理時間() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }
}
