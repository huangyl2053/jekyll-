/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shikyugendogakuedit;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaGendoGakuKanri;
import jp.co.ndensan.reams.db.dbz.business.core.basic.TankiNyushoShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;

/**
 * 支給限度額編集クラスです。
 *
 * @reamsid_L DBD-3000-010 wangjie2
 */
public class ShikyuGendogakuEdit {

    private List<JukyushaDaicho> 受給者台帳Entityリスト = new ArrayList<>();
    private FlexibleDate 一本化施行日 = FlexibleDate.EMPTY;
    private List<JukyushaGendoGakuKanri> 受給者限度額Entityリスト = new ArrayList<>();
    private List<TankiNyushoShikyuGendoGaku> 短期入所系支給限度額Entityリスト = new ArrayList<>();
    private List<TankiNyushoShikyuGendoGaku> 訪問通所系限度額Entityリスト = new ArrayList<>();
    private List<GendoGakuEntity> 短期入所限度額Entityリスト = new ArrayList<>();
    private List<GendoGakuEntity> 訪問通所限度額Entityリスト = new ArrayList<>();
    private final Code 有効無効区分_有効 = new Code("1");
    private final Code 有効無効区分_無効 = new Code("2");
    private final Code 自立 = new Code("10");
    private final Code 要支援１ = new Code("20");
    private final Code 要支援 = new Code("30");
    private final Code 要支援２ = new Code("40");
    private final Code 要介護１ = new Code("50");
    private final Code 要介護２ = new Code("60");
    private final Code 要介護３ = new Code("70");
    private final Code 要介護４ = new Code("80");
    private final Code 要介護５ = new Code("90");
    private final RString 識別区分 = new RString("1");
    private final RString 新体系 = new RString("999");
    private final RString 新体系管理区分_1 = new RString("1");
    private final RString 新体系拡大適用有無_1 = new RString("1");
    private static final int INT_12 = 12;
    private static final int INT_28 = 28;
    private static final int INT_31 = 31;
    private static final Decimal DECIMAL_2 = new Decimal("2");
    private static final Decimal DECIMAL_6 = new Decimal("6");
    private static final Decimal DECIMAL_7 = new Decimal("7");
    private static final Decimal DECIMAL_14 = new Decimal("14");
    private static final Decimal DECIMAL_21 = new Decimal("21");
    private static final Decimal DECIMAL_42 = new Decimal("42");

    /**
     * 支給限度額を算出し全受給者台帳データに支給限度額の再設定を行います。
     *
     * @param 一本化日 一本化施行日
     * @param 受給者台帳リスト 受給者台帳リスト
     * @param 受給者限度額リスト 受給者限度額リスト
     * @param 短期入所系支給限度額リスト 短期入所系支給限度額リスト
     * @param 訪問通所系限度額リスト 訪問通所系限度額リスト
     * @return 編集後受給者台帳Entityリスト
     */
    public List<JukyushaDaicho> setShikyuGendoGaku(
            FlexibleDate 一本化日,
            List<JukyushaDaicho> 受給者台帳リスト,
            List<JukyushaGendoGakuKanri> 受給者限度額リスト,
            List<TankiNyushoShikyuGendoGaku> 短期入所系支給限度額リスト,
            List<TankiNyushoShikyuGendoGaku> 訪問通所系限度額リスト) {
        this.一本化施行日 = 一本化日;
        this.受給者台帳Entityリスト = 受給者台帳リスト;
        this.受給者限度額Entityリスト = 受給者限度額リスト;
        this.短期入所系支給限度額Entityリスト = 訪問通所系限度額リスト;
        this.訪問通所系限度額Entityリスト = 訪問通所系限度額リスト;
        if (makeShikyuGendoList()) {
            for (int index = 0; index < 受給者台帳Entityリスト.size(); index++) {
                if (有効無効区分_有効.equals(受給者台帳Entityリスト.get(index).get有効無効区分())) {
                    支給限度額の編集(index);
                } else if (有効無効区分_無効.equals(受給者台帳Entityリスト.get(index).get有効無効区分())) {
                    受給者台帳Entityリスト修正(受給者台帳Entityリスト, index);
                }
            }
        } else {
            for (int index = 0; index < 受給者台帳Entityリスト.size(); index++) {
                受給者台帳Entityリスト修正(受給者台帳Entityリスト, index);
            }
        }
        return 受給者台帳Entityリスト;
    }

    private void 支給限度額の編集(int index) {
        JukyushaDaicho 編集された受給者台帳 = editShikyuGendoGaku(受給者台帳Entityリスト.get(index));
        if (index == 受給者台帳Entityリスト.size() - 1) {
            受給者台帳Entityリスト.remove(index);
            受給者台帳Entityリスト.add(editShikyuGendoGaku(編集された受給者台帳));
        } else {
            受給者台帳Entityリスト.remove(index);
            受給者台帳Entityリスト.add(index, editShikyuGendoGaku(編集された受給者台帳));
        }
    }

    private JukyushaDaicho editShikyuGendoGaku(JukyushaDaicho 受給者台帳Entity) {
        int 訪問通所限度額IDX = get限度額IDX(受給者台帳Entity.get認定有効期間開始年月日(), 訪問通所限度額Entityリスト);
        if (訪問通所限度額IDX < 0) {
            throw new ApplicationException(new ErrorMessage("DBDE", "支給限度額の設定でエラーが発生しました。"));
        }
        GendoGakuEntity 訪問通所限度額 = 訪問通所限度額Entityリスト.get(訪問通所限度額IDX);
        FlexibleDate 訪問通所支給適用開始日ＷＫ = FlexibleDate.EMPTY;
        FlexibleDate 訪問通所支給適用終了日ＷＫ = FlexibleDate.EMPTY;
        if (!getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.非該当).equals(訪問通所限度額.get要介護区分())) {
            TankiNyushoShikyuGendoGaku 訪問通所系支給限度額 = get系支給限度額(訪問通所限度額, 訪問通所系限度額Entityリスト);
            if (訪問通所系支給限度額 != null) {
                訪問通所支給適用開始日ＷＫ = new FlexibleDate(訪問通所限度額.get適用開始年月().toDateString().concat("01"));
                訪問通所支給適用終了日ＷＫ = getFlexibleDateFromFlexibleYearMonthBy末日(訪問通所限度額.get適用終了年月());
                //TODO 訪問通所支給限度基準額ＷＫに対象限度額データの限度額を設定
            }
        }
        FlexibleDate 短期入所適用開始日ＷＫ = FlexibleDate.EMPTY;
        FlexibleDate 短期入所適用終了日ＷＫ = FlexibleDate.EMPTY;
        Decimal 短期入所基準額ＷＫ = Decimal.ZERO;
        if (!一本化施行日.getYearMonth().isBefore(受給者台帳Entity.get認定有効期間開始年月日().getYearMonth())) {
            int 短期入所限度額IDX = get限度額IDX(受給者台帳Entity.get認定有効期間開始年月日(), 短期入所限度額Entityリスト);
            if (短期入所限度額IDX < 0) {
                throw new ApplicationException(new ErrorMessage("DBDE", "支給限度額の設定でエラーが発生しました。"));
            }
            if (!getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.非該当).equals(短期入所限度額Entityリスト.get(短期入所限度額IDX).get要介護区分())) {
                GendoGakuEntity 短期入所限度額 = 短期入所限度額Entityリスト.get(短期入所限度額IDX);
                短期入所適用開始日ＷＫ = new FlexibleDate(短期入所限度額.get適用開始年月().toDateString().concat("01"));
                短期入所適用終了日ＷＫ = getFlexibleDateFromFlexibleYearMonthBy末日(短期入所限度額.get適用終了年月());
                短期入所基準額ＷＫ = getShikyuGendoTanki(短期入所限度額);
            }
        }
        JukyushaDaichoBuilder builder = 受給者台帳Entity.createBuilderForEdit();
        //TODO 訪問通所支給限度基準額ＷＫ
        builder.set支給限度有効開始年月日(訪問通所支給適用開始日ＷＫ);
        builder.set支給限度有効終了年月日(訪問通所支給適用終了日ＷＫ);
        builder.set短期入所支給限度日数(短期入所基準額ＷＫ.intValue());
        builder.set短期入所支給限度開始年月日(短期入所適用開始日ＷＫ);
        builder.set短期入所支給限度終了年月日(短期入所適用終了日ＷＫ);
        return builder.build();
    }

    private Decimal getShikyuGendoTanki(GendoGakuEntity 短期入所限度額Entity) {
        Decimal 基準額wk = Decimal.ZERO;
        RString 月数wk = RString.EMPTY;
        Decimal 拡大率wk;
        getKakudai(短期入所限度額Entity);
        TankiNyushoShikyuGendoGaku 短期入所系支給限度額 = get系支給限度額(短期入所限度額Entity, 短期入所系支給限度額Entityリスト);
        if (null == 短期入所系支給限度額) {
            return 基準額wk;
        }
        if (!RString.isNullOrEmpty(短期入所限度額Entity.get認定期間月数())) {
            月数wk = 短期入所限度額Entity.get認定期間月数();
        }
        if (月数wk.isEmpty()) {
            月数wk = new RString(get月数(短期入所限度額Entity.get適用開始年月(), 短期入所限度額Entity.get適用終了年月()));
        }
        //TODO 基準額wkに（該当データの短期入所系限度日数　* 月数wk　／　該当データの基準期間）を設定
        基準額wk = 小数点以下切り(短期入所系支給限度額.get支給限度単位数().multiply(new Decimal(月数wk.toString())));
        if (null == 短期入所限度額Entity.get拡大倍数()) {
            return 基準額wk;
        }
        if (新体系.compareTo(短期入所限度額Entity.get拡大倍数()) == 0) {
            RString 要介護状態区分 = 短期入所系支給限度額.get要介護状態区分();
            Decimal 短期入所系限度日数 = 短期入所系支給限度額.get支給限度単位数();
            if (YokaigoJotaiKubun.要介護1.getCode().equals(要介護状態区分)
                    || YokaigoJotaiKubun.要介護2.getCode().equals(要介護状態区分)) {
                基準額wk = 小数点以下切り(短期入所系限度日数.add(DECIMAL_14).multiply(new Decimal(月数wk.toString())).divide(DECIMAL_6));
            } else if (YokaigoJotaiKubun.要介護3.getCode().equals(要介護状態区分)
                    || YokaigoJotaiKubun.要介護4.getCode().equals(要介護状態区分)) {
                基準額wk = 小数点以下切り(短期入所系限度日数.add(DECIMAL_21).multiply(new Decimal(月数wk.toString())).divide(DECIMAL_6));
            } else if (YokaigoJotaiKubun.要介護5.getCode().equals(要介護状態区分)) {
                基準額wk = DECIMAL_42.divide(DECIMAL_2);
                基準額wk = 小数点以下切り(短期入所系限度日数.add(基準額wk).multiply(new Decimal(月数wk.toString())).divide(DECIMAL_6));
            } else if (YokaigoJotaiKubun.要支援_経過的要介護.getCode().equals(要介護状態区分)) {
                基準額wk = 小数点以下切り(短期入所系限度日数.add(DECIMAL_7).multiply(new Decimal(月数wk.toString())).divide(DECIMAL_6));
            }
        } else {
            拡大率wk = new Decimal(短期入所限度額Entity.get拡大倍数().toString()).divide(Decimal.TEN);
            基準額wk = 小数点以下切り(基準額wk.multiply(拡大率wk));
        }
        return 基準額wk;
    }

    private Decimal 小数点以下切り(Decimal 基準額wk) {
        int 基準額 = 基準額wk.intValue();
        if (基準額wk.compareTo(new Decimal(基準額)) > 0) {
            return new Decimal(基準額 + 1);
        }
        return new Decimal(基準額);
    }

    private void getKakudai(GendoGakuEntity 短期入所限度額Entity) {
        JukyushaGendoGakuKanri 受給者限度額 = get受給者限度額(短期入所限度額Entity);
        if (null == 受給者限度額) {
            return;
        }
        if (RString.isNullOrEmpty(受給者限度額.get新体系管理区分())
                && !RString.isNullOrEmpty(受給者限度額.get拡大倍数())) {
            短期入所限度額Entity.set拡大倍数(受給者限度額.get拡大倍数());
        } else if (新体系管理区分_1.equals(受給者限度額.get新体系管理区分())
                && 新体系拡大適用有無_1.equals(受給者限度額.get新体系拡大適用有無())) {
            短期入所限度額Entity.set拡大倍数(新体系);
        }
        短期入所限度額Entity.set認定期間月数(受給者限度額.get限度額管理期間数());
    }

    private JukyushaGendoGakuKanri get受給者限度額(GendoGakuEntity 短期入所限度額Entity) {
        for (JukyushaGendoGakuKanri 受給者限度額 : 受給者限度額Entityリスト) {
            if (識別区分.equals(受給者限度額.get識別区分())
                    && 短期入所限度額Entity.get適用開始年月().equals(受給者限度額.get有効開始年月())
                    && 短期入所限度額Entity.get適用終了年月().equals(受給者限度額.get有効終了年月())) {
                return 受給者限度額;
            }
        }
        return null;
    }

    private int get月数(FlexibleYearMonth 適用開始年月, FlexibleYearMonth 適用終了年月) {
        return (適用終了年月.getYearValue() - 適用開始年月.getYearValue()) * INT_12 + 適用終了年月.getMonthValue() - 適用開始年月.getMonthValue() + 1;
    }

    private FlexibleDate getFlexibleDateFromFlexibleYearMonthBy末日(FlexibleYearMonth 年月) {
        for (int day = INT_31; day >= INT_28; day--) {
            FlexibleDate 年月日 = new FlexibleDate(年月.toDateString().concat(new RString(day)));
            if (年月日.isValid()) {
                return 年月日;
            }
        }
        return null;
    }

    private TankiNyushoShikyuGendoGaku get系支給限度額(GendoGakuEntity 限度額, List<TankiNyushoShikyuGendoGaku> 系支給限度額リスト) {
        for (TankiNyushoShikyuGendoGaku 訪問通所限度額Entity : 系支給限度額リスト) {
            if (訪問通所限度額Entity.get適用開始年月().isBeforeOrEquals(限度額.get適用開始年月())
                    && 限度額.get適用開始年月().isBeforeOrEquals(訪問通所限度額Entity.get適用終了年月())
                    && 訪問通所限度額Entity.get要介護状態区分().equals(限度額.get要介護区分().getColumnValue())) {
                return 訪問通所限度額Entity;
            }
        }
        return null;
    }

    private int get限度額IDX(FlexibleDate 認定開始日, List<GendoGakuEntity> 限度額Entityリスト) {
        for (int 限度額IDX = 0; 限度額IDX < 限度額Entityリスト.size(); 限度額IDX++) {
            if (is含まれる(認定開始日, 限度額Entityリスト.get(限度額IDX).get適用開始年月(),
                    限度額Entityリスト.get(限度額IDX).get適用終了年月())) {
                return 限度額IDX;
            }
        }
        return -1;
    }

    private boolean is含まれる(FlexibleDate 認定開始日, FlexibleYearMonth 適用開始日, FlexibleYearMonth 終了年月日) {
        return 適用開始日.isBeforeOrEquals(認定開始日.getYearMonth()) && 認定開始日.getYearMonth().isBeforeOrEquals(終了年月日);
    }

    private void 受給者台帳Entityリスト修正(List<JukyushaDaicho> 受給者台帳Entityリスト, int index) {
        JukyushaDaicho 受給者台帳 = 受給者台帳Entityリスト.get(index);
        JukyushaDaichoBuilder builder = 受給者台帳.createBuilderForEdit();
        builder.set支給限度単位数(Decimal.ZERO);
        builder.set支給限度有効開始年月日(FlexibleDate.EMPTY);
        builder.set支給限度有効終了年月日(FlexibleDate.EMPTY);
        builder.set短期入所支給限度開始年月日(FlexibleDate.EMPTY);
        builder.set短期入所支給限度終了年月日(FlexibleDate.EMPTY);
        builder.set短期入所支給限度日数(0);
        builder.set短期入所支給限度終了年月日(FlexibleDate.EMPTY);
        受給者台帳Entityリスト.remove(index);
        if (index == 受給者台帳Entityリスト.size() - 1) {
            受給者台帳Entityリスト.add(builder.build());
        } else {
            受給者台帳Entityリスト.add(index, builder.build());
        }
    }

    private boolean makeShikyuGendoList() {
        List<JukyushaDaicho> 受給者情報リスト = get受給者情報();
        短期入所限度額Entityリスト = new ArrayList<>();
        訪問通所限度額Entityリスト = new ArrayList<>();
        for (int 受給者IDX = 0; 受給者IDX < 受給者情報リスト.size(); 受給者IDX++) {
            GendoGakuEntity 短期入所限度額Entity = get限度額EntityFrom受給者情報(受給者情報リスト.get(受給者IDX));
            GendoGakuEntity 訪問通所限度額Entity = get限度額EntityFrom受給者情報(受給者情報リスト.get(受給者IDX));
            if (受給者IDX == 0) {
                短期入所限度額Entityリスト.add(短期入所限度額Entity);
                訪問通所限度額Entityリスト.add(訪問通所限度額Entity);
            } else {
                int 訪問通所限度額IDX = get直近データ限度額IDX();
                int 短期入所限度額IDX = get直近データ限度額IDX();
                if (訪問通所限度額IDX < 0) {
                    訪問通所限度額Entityリスト.add(訪問通所限度額Entity);
                } else {
                    訪問通所限度額Entity設定By直近データが取得可(受給者IDX, 訪問通所限度額IDX, 受給者情報リスト, 訪問通所限度額Entity);
                }
                if (短期入所限度額IDX < 0) {
                    短期入所限度額Entityリスト.add(短期入所限度額Entity);
                } else {
                    短期入所限度額Entity設定By直近データが取得可(受給者IDX, 短期入所限度額IDX, 受給者情報リスト, 短期入所限度額Entity);
                }
            }
        }
        要介護度の復元(短期入所限度額Entityリスト);
        要介護度の復元(訪問通所限度額Entityリスト);
        削除適用終了年月が未設定の限度額Entity(短期入所限度額Entityリスト);
        削除適用終了年月が未設定の限度額Entity(訪問通所限度額Entityリスト);
        return !短期入所限度額Entityリスト.isEmpty() || !訪問通所限度額Entityリスト.isEmpty();
    }

    private void 削除適用終了年月が未設定の限度額Entity(List<GendoGakuEntity> 限度額Entityリスト) {
        List<GendoGakuEntity> 削除限度額Entityリスト = new ArrayList<>();
        for (GendoGakuEntity 限度額Entity : 限度額Entityリスト) {
            if (null == 限度額Entity.get適用終了年月() || 限度額Entity.get適用終了年月().isEmpty()) {
                削除限度額Entityリスト.add(限度額Entity);
            }
        }
        限度額Entityリスト.removeAll(削除限度額Entityリスト);
    }

    private void 要介護度の復元(List<GendoGakuEntity> 限度額Entityリスト) {
        for (int index = 0; index < 限度額Entityリスト.size(); index++) {
            限度額Entityリスト.get(index).set要介護区分(get復元要介護区分(限度額Entityリスト.get(index).get要介護区分()));
        }
    }

    private Code get復元要介護区分(Code 要介護区分) {
        if (自立.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.非該当);
        } else if (要支援１.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援1);
        } else if (要支援.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援_経過的要介護);
        } else if (要支援２.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援2);
        } else if (要介護１.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護1);
        } else if (要介護２.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護2);
        } else if (要介護３.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護3);
        } else if (要介護４.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護4);
        } else if (要介護５.equals(要介護区分)) {
            return getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護5);
        }
        return 要介護区分;
    }

    private void 短期入所限度額Entity設定By直近データが取得可(int 受給者IDX, int 限度額IDX,
            List<JukyushaDaicho> 受給者情報リスト, GendoGakuEntity 限度額Entity) {
        if (短期入所限度額Entityリスト.get(限度額IDX).get適用終了年月()
                .equals(受給者情報リスト.get(受給者IDX).get認定有効期間開始年月日().getYearMonth())) {
            if (is同月(受給者情報リスト.get(受給者IDX).get認定有効期間開始年月日(), 受給者情報リスト.get(受給者IDX).get認定有効期間終了年月日())) {
                短期入所限度額Entityリスト.get(限度額IDX).set認定終了日(受給者情報リスト.get(受給者IDX).get認定有効期間終了年月日());
            } else {
                限度額Entity.set適用開始年月(限度額Entity.get適用開始年月().plusMonth(1));
                短期入所限度額Entityリスト.add(限度額Entity);
            }
        } else {
            短期入所限度額Entityリスト.add(限度額Entity);
        }
    }

    private void 訪問通所限度額Entity設定By直近データが取得可(int 受給者IDX, int 限度額IDX,
            List<JukyushaDaicho> 受給者情報リスト, GendoGakuEntity 限度額Entity) {
        if (訪問通所限度額Entityリスト.get(限度額IDX).get適用終了年月()
                .equals(受給者情報リスト.get(受給者IDX).get認定有効期間開始年月日().getYearMonth())) {
            if (is重み(訪問通所限度額Entityリスト.get(限度額IDX).get要介護区分(), 受給者情報リスト.get(受給者IDX).get要介護認定状態区分コード())) {
                訪問通所限度額Entity設定By期間重複編集(受給者IDX, 限度額IDX, 受給者情報リスト, 限度額Entity);
            } else {
                訪問通所限度額Entity設定By期間重複ない編集(限度額IDX, 限度額Entity);
            }
        } else {
            訪問通所限度額Entityリスト.add(限度額Entity);
        }
    }

    private void 訪問通所限度額Entity設定By期間重複ない編集(int 限度額IDX, GendoGakuEntity 限度額Entity) {
        if (訪問通所限度額Entityリスト.get(限度額IDX).get適用開始年月().isBefore(訪問通所限度額Entityリスト.get(限度額IDX).get適用終了年月())) {
            訪問通所限度額Entityリスト.get(限度額IDX).set適用終了年月(訪問通所限度額Entityリスト.get(限度額IDX).get適用終了年月().minusMonth(1));
        } else {
            限度額Entity.set適用開始年月(訪問通所限度額Entityリスト.get(限度額IDX).get適用開始年月());
            set全項目無効(訪問通所限度額Entityリスト.get(限度額IDX));
        }
        訪問通所限度額Entityリスト.add(限度額Entity);
    }

    private void set全項目無効(GendoGakuEntity 限度額Entity) {
        限度額Entity.set要介護区分(Code.EMPTY);
        限度額Entity.set認定終了日(FlexibleDate.EMPTY);
        限度額Entity.set認定開始日(FlexibleDate.EMPTY);
        限度額Entity.set適用終了年月(FlexibleYearMonth.EMPTY);
        限度額Entity.set適用開始年月(FlexibleYearMonth.EMPTY);
    }

    private void 訪問通所限度額Entity設定By期間重複編集(int 受給者IDX, int 限度額IDX,
            List<JukyushaDaicho> 受給者情報リスト, GendoGakuEntity 限度額Entity) {
        if (is同月(受給者情報リスト.get(受給者IDX).get認定有効期間開始年月日(), 受給者情報リスト.get(受給者IDX).get認定有効期間終了年月日())) {
            訪問通所限度額Entityリスト.get(限度額IDX).set認定終了日(受給者情報リスト.get(受給者IDX).get認定有効期間終了年月日());
        } else {
            限度額Entity.set適用開始年月(限度額Entity.get適用開始年月().plusMonth(1));
            訪問通所限度額Entityリスト.add(限度額Entity);
        }
    }

    private boolean is同月(FlexibleDate 開始年月日, FlexibleDate 終了年月日) {
        if (null == 終了年月日 || 終了年月日.isEmpty()) {
            return false;
        }
        return 開始年月日.getYearMonth().compareTo(終了年月日.getYearMonth()) == 0;
    }

    private boolean is重み(Code code1, Code code2) {
        return Integer.parseInt(code1.value().toString()) >= Integer.parseInt(code2.value().toString());
    }

    private int get直近データ限度額IDX() {
        int 限度額IDX = -1;
        //TODO 直近データを検索、適用終了年月が設定されている限度額IDXを取得する。
        return 限度額IDX;
    }

    private GendoGakuEntity get限度額EntityFrom受給者情報(JukyushaDaicho 受給者情報) {
        GendoGakuEntity 限度額Entity = new GendoGakuEntity();
        限度額Entity.set要介護区分(受給者情報.get要介護認定状態区分コード());
        if (受給者情報.get認定有効期間開始年月日() != null && !受給者情報.get認定有効期間開始年月日().isEmpty()) {
            限度額Entity.set適用開始年月(受給者情報.get認定有効期間開始年月日().getYearMonth());
        }
        if (受給者情報.get認定有効期間終了年月日() != null && !受給者情報.get認定有効期間終了年月日().isEmpty()) {
            限度額Entity.set適用終了年月(受給者情報.get認定有効期間終了年月日().getYearMonth());
        }
        限度額Entity.set認定開始日(受給者情報.get認定有効期間開始年月日());
        限度額Entity.set認定終了日(受給者情報.get認定有効期間終了年月日());
        return 限度額Entity;
    }

    private List<JukyushaDaicho> get受給者情報() {
        List<JukyushaDaicho> 受給者情報リスト = new ArrayList<>();
        for (JukyushaDaicho 受給者情報 : 受給者台帳Entityリスト) {
            if (有効無効区分_有効.equals(受給者情報.get有効無効区分())) {
                受給者情報リスト.add(get受給者情報By重み度変換(受給者情報));
            }
        }
        return 受給者情報リスト;
    }

    private JukyushaDaicho get受給者情報By重み度変換(JukyushaDaicho 受給者情報) {
        JukyushaDaichoBuilder builder = 受給者情報.createBuilderForEdit();
        if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.非該当).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(自立);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援1).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要支援１);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援_経過的要介護).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要支援);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要支援2).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要支援２);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護1).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要介護１);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護2).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要介護２);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護3).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要介護３);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護4).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要介護４);
        } else if (getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun.要介護5).equals(受給者情報.get要介護認定状態区分コード())) {
            builder.set要介護認定状態区分コード(要介護５);
        }
        return builder.build();
    }

    private Code getCodeFromYokaigoJotaiKubun(YokaigoJotaiKubun 要介護状態区分) {
        return new Code(要介護状態区分.getコード());
    }

}
