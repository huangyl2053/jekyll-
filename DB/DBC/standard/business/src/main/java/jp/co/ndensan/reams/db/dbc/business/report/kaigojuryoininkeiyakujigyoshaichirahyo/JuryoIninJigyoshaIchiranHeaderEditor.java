/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受領委任契約事業者一覧表Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranHeaderEditor implements IJuryoIninJigyoshaIchiranEditor {

    private final Map<RString, RString> 出力順Map;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final RDateTime 処理日時;
    private final List<RString> 改頁項目;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    private static final RString KEY_並び順の1件目 = new RString("KEY_並び順の1件目");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");

    private static final RString SAKUSEI = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 出力順Map Map<RString, RString>
     * @param 処理日時 RDateTime
     * @param 改頁項目 List<RString>
     */
    protected JuryoIninJigyoshaIchiranHeaderEditor(
            LasdecCode 市町村コード,
            RString 市町村名称,
            RDateTime 処理日時,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁項目
    ) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.処理日時 = 処理日時;
        this.出力順Map = 出力順Map;
        this.改頁項目 = 改頁項目;

    }

    @Override
    public JuryoIninJigyoshaIchiranSource edit(
            JuryoIninJigyoshaIchiranSource source) {
        RString 作成日 = 処理日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 処理日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.hokenshaNo = new RString(市町村コード.toString());
        source.hokenshaName = 市町村名称;
        source.shutsuryokujun1 = get並び順(KEY_並び順の1件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の５件目);
        switch (改頁項目.size()) {
            case 1:
                source.kaipage1 = 改頁項目.get(INT_0);
                break;
            case 2:
                source.kaipage2 = 改頁項目.get(INT_1);
                break;
            case INT_3:
                source.kaipage3 = 改頁項目.get(INT_2);
                break;
            case INT_4:
                source.kaipage4 = 改頁項目.get(INT_3);
                break;
            case INT_5:
                source.kaipage5 = 改頁項目.get(INT_4);
                break;
            default:
                break;
        }
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }
}
