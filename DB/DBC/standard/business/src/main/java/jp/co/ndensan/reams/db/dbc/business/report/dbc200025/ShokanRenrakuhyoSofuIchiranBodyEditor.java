/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.DbWT2111ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.ShokanRenrakuhyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表BodyEditor
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
public class ShokanRenrakuhyoSofuIchiranBodyEditor
        implements IShokanRenrakuhyoSofuIchiranEditor {

    private final ShokanRenrakuhyoSofuIchiranParameter parameter;
    private static final RString YES = new RString("●");
    private static final int NUM_6 = 6;
    private static final int NUM_15 = 15;
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです
     *
     * @param parameter ShokanRenrakuhyoSofuIchiranParameter
     */
    public ShokanRenrakuhyoSofuIchiranBodyEditor(
            ShokanRenrakuhyoSofuIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public ShokanRenrakuhyoSofuIchiranSource edit(
            ShokanRenrakuhyoSofuIchiranSource source) {
        if (null == parameter) {
            return source;
        }
        edit明細(source);
        return source;
    }

    private void edit明細(ShokanRenrakuhyoSofuIchiranSource source) {

        ShokanRenrakuhyoSofuIchiranEntity 償還連絡票一覧表データ = parameter.get償還連絡票一覧表データ();
        if (null == 償還連絡票一覧表データ) {
            return;
        }
        DbWT2111ShokanShinseiEntity 償還払支給申請Entity = 償還連絡票一覧表データ.get償還払支給申請Entity();
        DbWT1001HihokenshaEntity get被保険者一時TBL = 償還連絡票一覧表データ.get被保険者一時TBL();
        source.list_1 = 償還払支給申請Entity.get連番();
        source.list_2 = 償還払支給申請Entity.get整理番号();
        source.list_3 = doパターン54(償還払支給申請Entity.getサービス提供年月());
        source.list_4 = getColumnValue(償還払支給申請Entity.get証記載保険者番号());
        source.list_5 = getColumnValue(償還払支給申請Entity.get被保険者番号());
        source.list_6 = get被保険者一時TBL.getMeisho();
        if (null != get被保険者一時TBL.getMeisho()) {
            source.list_6 = get被保険者一時TBL.getMeisho().substringReturnAsPossible(NUM_0, NUM_15);
        }
        if (償還払支給申請Entity.is旧措置者フラグ()) {
            source.list_7 = YES;
        }
        if (null != 償還払支給申請Entity.getサービス提供年月() && null != 償還払支給申請Entity.get要介護認定状態区分コード()) {
            IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(償還払支給申請Entity.getサービス提供年月(),
                    償還払支給申請Entity.get要介護認定状態区分コード());
            if (null != 要介護状態区分) {
                source.list_8 = 要介護状態区分.getName();
            }
        }
        source.list_9 = getパターン4(償還払支給申請Entity.get認定有効期間開始年月日());
        source.list_10 = getパターン4(償還払支給申請Entity.get認定有効期間終了年月日());
        source.list_11 = get共通ポリシー金額1(償還払支給申請Entity.get保険給付額());
        source.list_12 = get共通ポリシー金額1(償還払支給申請Entity.get利用者負担額());
        source.list_13 = get共通ポリシー金額1(償還払支給申請Entity.get支払金額合計());
        if (null != 償還連絡票一覧表データ.get償還払請求基本Entity()) {
            source.list_14 = 償還連絡票一覧表データ.get償還払請求基本Entity().getYoshikiNo();
        }
        if (null != 償還連絡票一覧表データ.get識別番号管理Entity()) {
            if (null != 償還連絡票一覧表データ.get識別番号管理Entity().getRyakusho()) {
                source.list_15 = 償還連絡票一覧表データ.get識別番号管理Entity().getRyakusho().substringReturnAsPossible(NUM_0, NUM_6);
            }
        }
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

    private RString get共通ポリシー金額1(Decimal 金額) {
        if (null == 金額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }
}
