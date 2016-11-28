/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.ShokanRenrakuhyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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
        setPageBreakEmpty(source);
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), source.list_5);
        return source;
    }

    private void setPageBreakEmpty(ShokanRenrakuhyoSofuIchiranSource source) {
        if (source.hokenshaNo == null) {
            source.hokenshaNo = RString.EMPTY;
        }
        if (source.yubinNo == null) {
            source.yubinNo = RString.EMPTY;
        }
        if (source.choikiCode == null) {
            source.choikiCode = RString.EMPTY;
        }
        if (source.gyoseikuCode == null) {
            source.gyoseikuCode = RString.EMPTY;
        }
        if (source.shimei50onKana == null) {
            source.shimei50onKana = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
        if (source.list_5 == null) {
            source.list_5 = RString.EMPTY;
        }
        if (source.list_3 == null) {
            source.list_3 = RString.EMPTY;
        }
        if (source.list_2 == null) {
            source.list_2 = RString.EMPTY;
        }
        if (source.shinseiYMD == null) {
            source.shinseiYMD = RString.EMPTY;
        }
        if (source.jigyoshaNo == null) {
            source.jigyoshaNo = RString.EMPTY;
        }
        if (source.list_14 == null) {
            source.list_14 = RString.EMPTY;
        }
    }

    private void edit明細(ShokanRenrakuhyoSofuIchiranSource source) {

        ShokanRenrakuhyoSofuIchiranEntity 償還連絡票一覧表データ = parameter.get償還連絡票一覧表データ();
        if (null == 償還連絡票一覧表データ) {
            return;
        }
        DbWT2111ShokanShinseiTempEntity 償還払支給申請Entity = 償還連絡票一覧表データ.get償還払支給申請一時TBL();
        DbWT1001HihokenshaTempEntity get被保険者一時TBL = 償還連絡票一覧表データ.get被保険者一時TBL();
        set償還払支給申請(source, 償還払支給申請Entity);
        if (null != get被保険者一時TBL) {
            source.list_6 = get被保険者一時TBL.getMeisho();
            source.shikibetsuCode = getColumnValue(get被保険者一時TBL.getShikibetsuCode());
            if (null != get被保険者一時TBL.getMeisho()) {
                source.list_6 = get被保険者一時TBL.getMeisho().substringReturnAsPossible(NUM_0, NUM_15);
            }
        }
        source.list_14 = 償還連絡票一覧表データ.get基本_様式番号();

        if (null != 償還連絡票一覧表データ.get識別番号_略称()) {
            source.list_15 = 償還連絡票一覧表データ.get識別番号_略称().substringReturnAsPossible(NUM_0, NUM_6);
        }
        source.yubinNo = get被保険者一時TBL == null ? RString.EMPTY : get被保険者一時TBL.getYubinNo();
        source.choikiCode = get被保険者一時TBL == null ? RString.EMPTY : get被保険者一時TBL.getChoikiCode();
        source.gyoseikuCode = get被保険者一時TBL == null ? RString.EMPTY : get被保険者一時TBL.getGyoseikuCode();
        source.shimei50onKana = get被保険者一時TBL == null ? RString.EMPTY : get被保険者一時TBL.getShimei50onKana();
        source.shichosonCode = get被保険者一時TBL == null ? RString.EMPTY : getColumnValue(get被保険者一時TBL.getShichosonCode());
        source.shinseiYMD = new RString(償還払支給申請Entity.getShinseiYMD().toString());
        source.jigyoshaNo = getColumnValue(償還連絡票一覧表データ.get基本_事業者番号());

    }

    private void set償還払支給申請(ShokanRenrakuhyoSofuIchiranSource source, DbWT2111ShokanShinseiTempEntity 償還払支給申請Entity) {
        if (null == 償還払支給申請Entity) {
            return;
        }
        source.list_1 = new RString(parameter.get連番());
        source.list_2 = 償還払支給申請Entity.getSeiriNo();
        source.list_3 = doパターン54(償還払支給申請Entity.getServiceTeikyoYM());
        source.list_4 = getColumnValue(償還払支給申請Entity.getShoKisaiHokenshaNo());
        source.list_5 = getColumnValue(償還払支給申請Entity.getHiHokenshaNo());
        if (償還払支給申請Entity.isKyuSochishaFlag()) {
            source.list_7 = YES;
        }
        if (null != 償還払支給申請Entity.getServiceTeikyoYM() && null != 償還払支給申請Entity.getYokaigoJotaiKubunCode()
                && !償還払支給申請Entity.getYokaigoJotaiKubunCode().isEmpty()) {
            IYokaigoJotaiKubun 要介護状態区分 = YokaigoJotaiKubunSupport.toValue(償還払支給申請Entity.getServiceTeikyoYM(),
                    償還払支給申請Entity.getYokaigoJotaiKubunCode());
            if (null != 要介護状態区分) {
                source.list_8 = 要介護状態区分.getName();
            }
        }
        source.list_9 = getパターン4(償還払支給申請Entity.getNinteiYukoKikanKaishiYMD());
        source.list_10 = getパターン4(償還払支給申請Entity.getNinteiYukoKikanShuryoYMD());
        source.list_11 = get共通ポリシー金額1(償還払支給申請Entity.getHokenKyufugaku());
        source.list_12 = get共通ポリシー金額1(償還払支給申請Entity.getRiyoshaFutangaku());
        source.list_13 = get共通ポリシー金額1(償還払支給申請Entity.getShiharaiKingakuTotal());
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
