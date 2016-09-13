/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200031;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表HeaderEditor
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
public class GassanJikofutangakuHoseiIchiranHeaderEditor
        implements IGassanJikofutangakuHoseiIchiranEditor {

    private final GassanJikofutangakuHoseiIchiranParameter parameter;

    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param parameter GassanJikofutangakuHoseiIchiranParameter
     */
    public GassanJikofutangakuHoseiIchiranHeaderEditor(GassanJikofutangakuHoseiIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public GassanJikofutangakuHoseiIchiranSource edit(
            GassanJikofutangakuHoseiIchiranSource source) {
        if (null == parameter) {
            return source;
        }
        RDateTime 作成日時 = parameter.get作成日時();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.hokenshaNo = parameter.get市町村コード();
        source.hokenshaName = parameter.get市町村名称();
        source.shutsuryokujun1 = parameter.get出力順1();
        source.shutsuryokujun2 = parameter.get出力順2();
        source.shutsuryokujun3 = parameter.get出力順3();
        source.shutsuryokujun4 = parameter.get出力順4();
        source.shutsuryokujun5 = parameter.get出力順5();

        source.kaipage1 = parameter.get改頁1();
        source.kaipage2 = parameter.get改頁2();
        source.kaipage3 = parameter.get改頁3();
        source.kaipage4 = parameter.get改頁4();
        source.kaipage5 = parameter.get改頁5();
        return source;
    }
}
