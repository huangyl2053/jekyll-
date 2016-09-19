/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のEditor
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
public class TokubetsuChoshuIraiJohoKensuhyoEditor implements ITokubetsuChoshuIraiJohoKensuhyoEditor {

    private final TokubetsuChoshuIraiJohoKensuhyoParameter parameter;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです。
     *
     * @param parameter TokubetsuChoshuIraiJohoKensuhyoParameter
     */
    protected TokubetsuChoshuIraiJohoKensuhyoEditor(TokubetsuChoshuIraiJohoKensuhyoParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public TokubetsuChoshuIraiJohoKensuhyoSource edit(TokubetsuChoshuIraiJohoKensuhyoSource source) {
        RString 作成日 = parameter.get作成日時().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.get作成日時().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        RDate 基準日 = RDate.getNowDate();
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBU介護統計報告);
        source.hokenshaNo = 保険者番号;
        source.hokenshaName = 保険者名称;
        if (parameter.getEntity() != null) {
            source.nenkinHokenshaName = parameter.getEntity().get年金保険者名称();
            if (parameter.getEntity().get構成市町村コード() != null) {
                source.shichosonCode = parameter.getEntity().get構成市町村コード().getColumnValue();
            }
            source.shichosonName = parameter.getEntity().get市町村名称();
            source.listLeftUpper_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    parameter.getEntity().getLeft特別徴収義務者コード());
            source.listLeftUpper_3 = new RString(parameter.getEntity().getLeft件数());
            source.listLeftUpper_4 = parameter.getEntity().getLeft金額1();
            source.listLeftLower_1 = parameter.getEntity().getLeft金額2();
            if (parameter.getEntity().getLeft特別徴収義務者コード() != null) {
                source.listLeftUpper_1 = parameter.getEntity().getLeft特別徴収義務者コード().getColumnValue();
            }
            source.listRightUpper_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    parameter.getEntity().getRight特別徴収義務者コード());
            source.listRightUpper_3 = new RString(parameter.getEntity().getRight件数());
            source.listRightUpper_4 = parameter.getEntity().getRight金額1();
            source.listRightLower_1 = parameter.getEntity().getRight金額2();
            if (parameter.getEntity().getRight特別徴収義務者コード() != null) {
                source.listRightUpper_1 = parameter.getEntity().getRight特別徴収義務者コード().getColumnValue();
            }
        }
        source.gokeiKensu = parameter.get該当件数の件数の合計();
        source.gokeiKingaku1 = parameter.get金額1の金額の合計();
        source.gokeiKingaku2 = parameter.get金額2の金額の合計();
        return source;
    }
}
