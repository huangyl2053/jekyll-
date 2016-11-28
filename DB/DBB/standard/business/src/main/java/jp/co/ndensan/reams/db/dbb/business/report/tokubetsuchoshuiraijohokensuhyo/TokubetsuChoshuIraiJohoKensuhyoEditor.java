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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

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
            source.shichosonCode = parameter.getEntity().get構成市町村コード();
            source.shichosonName = parameter.getEntity().get市町村名称();
            if (parameter.getEntity().getLeft件数() != null) {
                source.listLeftUpper_3 = new RString(parameter.getEntity().getLeft件数());
            }
            if (parameter.getEntity().getLeft金額1() != null) {
                source.listLeftUpper_4 = doカンマ編集(new Decimal(parameter.getEntity().getLeft金額1().toString()));
            }
            if (parameter.getEntity().getLeft金額2() != null) {
                source.listLeftLower_1 = doカンマ編集(new Decimal(parameter.getEntity().getLeft金額2().toString()));
            }
            if (parameter.getEntity().getLeft特別徴収義務者コード() != null) {
                source.listLeftUpper_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                        parameter.getEntity().getLeft特別徴収義務者コード());
                source.listLeftUpper_1 = parameter.getEntity().getLeft特別徴収義務者コード().getColumnValue();
            }
            if (parameter.getEntity().getRight件数() != null) {
                source.listRightUpper_3 = new RString(parameter.getEntity().getRight件数());
            }
            if (parameter.getEntity().getRight金額1() != null) {
                source.listRightUpper_4 = doカンマ編集(new Decimal(parameter.getEntity().getRight金額1().toString()));
            }
            if (parameter.getEntity().getRight金額2() != null) {
                source.listRightLower_1 = doカンマ編集(new Decimal(parameter.getEntity().getRight金額2().toString()));
            }
            if (parameter.getEntity().getRight特別徴収義務者コード() != null) {
                source.listRightUpper_2 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                        parameter.getEntity().getRight特別徴収義務者コード());
                source.listRightUpper_1 = parameter.getEntity().getRight特別徴収義務者コード().getColumnValue();
            }
        }
        source.gokeiKensu = parameter.get該当件数の件数の合計();
        if (parameter.get金額1の金額の合計() != null) {
            source.gokeiKingaku1 = doカンマ編集(new Decimal(parameter.get金額1の金額の合計().toString()));
        }
        if (parameter.get金額2の金額の合計() != null) {
            source.gokeiKingaku2 = doカンマ編集(new Decimal(parameter.get金額2の金額の合計().toString()));
        }
        pageBreakNullCheck(source);
        return source;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private void pageBreakNullCheck(TokubetsuChoshuIraiJohoKensuhyoSource source) {
        if (source.nenkinHokenshaName == null) {
            source.nenkinHokenshaName = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
    }
}
