/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.DbWT2111ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表Editor
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
public class ShokanRenrakuhyoSofuIchiranHeaderEditor
        implements IShokanRenrakuhyoSofuIchiranEditor {

    private final ShokanRenrakuhyoSofuIchiranParameter parameter;
    private final Map<RString, RString> 出力順Map;

    private static final RString SAKUSEI = new RString("作成");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    /**
     * コンストラクタです
     *
     * @param parameter ShokanRenrakuhyoSofuIchiranParameter
     */
    public ShokanRenrakuhyoSofuIchiranHeaderEditor(ShokanRenrakuhyoSofuIchiranParameter parameter) {
        this.parameter = parameter;
        this.出力順Map = parameter.get出力順Map();
    }

    @Override
    public ShokanRenrakuhyoSofuIchiranSource edit(
            ShokanRenrakuhyoSofuIchiranSource source) {
        if (null == parameter) {
            return source;
        }
        source.chohyoTitle = parameter.get帳票タイトル();
        RDateTime 作成日時 = parameter.get作成日時();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        if (null != parameter.get償還連絡票一覧表データ()) {
            DbWT2111ShokanShinseiEntity 償還払支給申請Entity = parameter.get償還連絡票一覧表データ().get償還払支給申請Entity();
            if (null != 償還払支給申請Entity) {
                source.hokenshaNo = getColumnValue(償還払支給申請Entity.get保険者番号());
                source.hokenshaName = 償還払支給申請Entity.get保険者名();
            }
        }
        source.sofuYM = doパターン54(parameter.get処理年月());
        source.shutsuryokujun1 = get並び順(KEY_並び順の２件目);
        source.shutsuryokujun2 = get並び順(KEY_並び順の３件目);
        source.shutsuryokujun3 = get並び順(KEY_並び順の４件目);
        source.shutsuryokujun4 = get並び順(KEY_並び順の５件目);
        source.shutsuryokujun5 = get並び順(KEY_並び順の６件目);

        source.kaipage1 = get並び順(KEY_並び順の２件目);
        source.kaipage2 = get並び順(KEY_並び順の３件目);
        source.kaipage3 = get並び順(KEY_並び順の４件目);
        source.kaipage4 = get並び順(KEY_並び順の５件目);
        source.kaipage5 = get並び順(KEY_並び順の６件目);
        return source;
    }

    private RString get並び順(RString 並び順Key) {
        if (null == 出力順Map) {
            return RString.EMPTY;
        }
        return 出力順Map.containsKey(並び順Key) ? 出力順Map.get(並び順Key) : RString.EMPTY;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
