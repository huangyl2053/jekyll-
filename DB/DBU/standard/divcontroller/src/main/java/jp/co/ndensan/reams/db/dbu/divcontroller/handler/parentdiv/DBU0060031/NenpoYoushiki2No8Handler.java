/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0060031;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataBuilder;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiDataIdentifier;
import jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushiki2no8.DetalParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpo.SearchJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.NenpoYoushiki2No8Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgChiikimitchakuyobosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgHisetsugaigosabisujukyu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.dgItakuyobosabisujukyusu_Row;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 事業報告（年報）補正、発行_様式２の８画面のハンドラクラスです。
 *
 * @reamsid_L DBU-1060-030 zhengshukai
 *
 */
public class NenpoYoushiki2No8Handler {

    private static final RString フラグ_削除 = new RString("削除");
    private static final Decimal 横番号_8 = new Decimal("8");
    private static final Decimal 横番号_9 = new Decimal("9");
    private static final Decimal 横番号_12 = new Decimal("12");
    private static final Decimal 横番号_1 = new Decimal("1");
    private static final Decimal 横番号_2 = new Decimal("2");
    private static final Decimal 横番号_3 = new Decimal("3");
    private static final Decimal 横番号_4 = new Decimal("4");
    private static final Decimal 横番号_5 = new Decimal("5");
    private static final Decimal 横番号_6 = new Decimal("6");
    private static final Decimal 横番号_7 = new Decimal("7");
    private static final Decimal 横番号_13 = new Decimal("13");
    private final NenpoYoushiki2No8Div div;

    /**
     * コンストラクタです。
     *
     * @param div NenpoYoushiki2No8Div
     */
    public NenpoYoushiki2No8Handler(NenpoYoushiki2No8Div div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param viewState 補正フラグ
     * @param 報告年度 報告年度
     * @param 集計年度 集計年度
     * @param 保険者コード 保険者コード
     * @param 保険者名称 保険者名称
     */
    public void 初期状態(RString viewState, RDate 報告年度, RDate 集計年度, RString 保険者コード, RString 保険者名称) {
        div.getHihokenshabango().getTxthokokuYM().setValue(new FlexibleDate(報告年度.toDateString()));
        div.getHihokenshabango().getTxthokokuYM().setDisabled(true);
        div.getHihokenshabango().getTxtshukeiY().setValue(new FlexibleDate(集計年度.toDateString()));
        div.getHihokenshabango().getTxtshukeiY().setDisabled(true);
        div.getHihokenshabango().getTxtHihokenshabango().setValue(保険者コード);
        div.getHihokenshabango().getTxtHihokenshabango().setDisabled(true);
        div.getHihokenshabango().getTxthihokenshamei().setValue(保険者名称);
        div.getHihokenshabango().getTxthihokenshamei().setDisabled(true);
        if (viewState.equals(フラグ_削除)) {
            div.getShisetsugaigosabisujukyuMeisai().getDgItakuyobosabisujukyusu().setDisabled(true);
            div.getShisetsugaigosabisujukyuMeisai().getDgHisetsugaigosabisujukyu().setDisabled(true);
            div.getShisetsugaigosabisujukyuMeisai().getDgChiikimitchakuyobosabisujukyu().setDisabled(true);
        }
    }

    /**
     * 行番号を取得します。
     *
     * @param jigyoHokokuNenpoSearch SearchJigyoHokokuNenpo
     * @return 行番list
     */
    public List<Decimal> get行番(SearchJigyoHokokuNenpo jigyoHokokuNenpoSearch) {
        List<Decimal> 行番list = new ArrayList<>();
        List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト = JigyoHokokuNenpoHoseiHakoManager.createInstance().
                getJigyoHokokuNenpoDetal(jigyoHokokuNenpoSearch).records();
        Collections.sort(事業報告集計一覧データリスト, new DateComparator());
        for (JigyoHokokuTokeiData list : 事業報告集計一覧データリスト) {
            行番list.add(list.get縦番号());
        }
        return new ArrayList<>(new LinkedHashSet<>(行番list));
    }

    private static class DateComparator implements Comparator<JigyoHokokuTokeiData>, Serializable {

        private static final long serialVersionUID = -5986624536847792888L;

        @Override
        public int compare(JigyoHokokuTokeiData o1, JigyoHokokuTokeiData o2) {
            return o1.get縦番号().compareTo(o2.get縦番号());
        }
    }

    /**
     * 画面の件数データを取得します。
     *
     * @return List<DetalParameter>　画面の件数データ
     */
    public List<DetalParameter> get件数データ() {
        List<DetalParameter> detalParameter = new ArrayList<>();
        List<dgItakuyobosabisujukyusu_Row> dgItakuyobosabisujukyusu = div.getShisetsugaigosabisujukyuMeisai().
                getDgItakuyobosabisujukyusu().getDataSource();
        int 行番号 = 1;
        for (dgItakuyobosabisujukyusu_Row 画面データ : dgItakuyobosabisujukyusu) {
            Decimal 行番号new = new Decimal(行番号);
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_8, 画面データ.getTxtYoshienIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_9, 画面データ.getTxtYoshienNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_12, 画面データ.getTxtYoshienKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_1, 画面データ.getTxtKekkaYokaigo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_2, 画面データ.getTxtYokaigoIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_3, 画面データ.getTxtYokaigoNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_4, 画面データ.getTxtYokaigoSan().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_5, 画面データ.getTxtYokaigoYon().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_6, 画面データ.getTxtYokaigoGo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_7, 画面データ.getTxtYokaigoKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_13, 画面データ.getTxtGokei().getValue()));
            行番号 = 行番号 + 1;

        }
        return detalParameter;
    }

    /**
     * 画面の費用額データを取得します。
     *
     * @return List<DetalParameter>　画面の費用額データ
     */
    public List<DetalParameter> get費用額データ() {
        List<DetalParameter> detalParameter = new ArrayList<>();
        List<dgChiikimitchakuyobosabisujukyu_Row> dgChiikimitchakuyobosabi = div.getShisetsugaigosabisujukyuMeisai().
                getDgChiikimitchakuyobosabisujukyu().getDataSource();
        int 行番号 = 1;
        for (dgChiikimitchakuyobosabisujukyu_Row 画面データ : dgChiikimitchakuyobosabi) {
            Decimal 行番号new = new Decimal(行番号);
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_8, 画面データ.getTxtYoshienIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_9, 画面データ.getTxtYoshienNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_12, 画面データ.getTxtYoshienKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_1, 画面データ.getTxtKekkaYokaigo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_2, 画面データ.getTxtYokaigoIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_3, 画面データ.getTxtYokaigoNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_4, 画面データ.getTxtYokaigoSan().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_5, 画面データ.getTxtYokaigoYon().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_6, 画面データ.getTxtYokaigoGo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_7, 画面データ.getTxtYokaigoKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_13, 画面データ.getTxtGokei().getValue()));
            行番号 = 行番号 + 1;
        }
        return detalParameter;
    }

    /**
     * 画面の給付額データを取得します。
     *
     * @return List<DetalParameter>　画面の給付額データ
     */
    public List<DetalParameter> get給付額データ() {
        List<DetalParameter> detalParameter = new ArrayList<>();
        List<dgHisetsugaigosabisujukyu_Row> dgHisetsugaigosabisujukyu = div.getShisetsugaigosabisujukyuMeisai().
                getDgHisetsugaigosabisujukyu().getDataSource();
        int 行番号 = 1;
        for (dgHisetsugaigosabisujukyu_Row 画面データ : dgHisetsugaigosabisujukyu) {
            Decimal 行番号new = new Decimal(行番号);
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_8, 画面データ.getTxtYoshienIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_9, 画面データ.getTxtYoshienNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_12, 画面データ.getTxtYoshienKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_1, 画面データ.getTxtKekkaYokaigo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_2, 画面データ.getTxtYokaigoIchi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_3, 画面データ.getTxtYokaigoNi().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_4, 画面データ.getTxtYokaigoSan().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_5, 画面データ.getTxtYokaigoYon().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_6, 画面データ.getTxtYokaigoGo().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_7, 画面データ.getTxtYokaigoKei().getValue()));
            detalParameter.add(DetalParameter.creatDetalParameter(行番号new, 横番号_13, 画面データ.getTxtGokei().getValue()));
            行番号 = 行番号 + 1;
        }
        return detalParameter;
    }

    /**
     * 画面の修正データを取得します。
     *
     * @param 件数タブデータ Models
     * @param 費用額データ Models
     * @param 給付額データ Models
     * @return List<JigyoHokokuTokeiData> 事業報告集計一覧データリスト
     */
    public List<JigyoHokokuTokeiData> get修正データ(
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 件数タブデータ,
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 費用額データ,
            Models<JigyoHokokuTokeiDataIdentifier, JigyoHokokuTokeiData> 給付額データ
    ) {
        List<JigyoHokokuTokeiData> list = new ArrayList<>();
        List<DetalParameter> 件数Parameter = get件数データ();
        for (DetalParameter detal : 件数Parameter) {
            for (JigyoHokokuTokeiData viewdata : 件数タブデータ) {
                if (detal.get縦番号().compareTo(viewdata.get縦番号()) == 0
                        && detal.get横番号().compareTo(viewdata.get横番号()) == 0
                        && detal.get集計結果値().compareTo(viewdata.get集計結果値()) != 0) {
                    viewdata = viewdata.createBuilderForEdit().set集計結果値(detal.get集計結果値()).build();
                    list.add(viewdata);
                }
            }
        }
        List<DetalParameter> 費用額Parameter = get費用額データ();
        for (DetalParameter detal : 費用額Parameter) {
            for (JigyoHokokuTokeiData viewdata : 費用額データ) {
                JigyoHokokuTokeiDataBuilder builder = viewdata.createBuilderForEdit();
                if (detal.get縦番号().compareTo(viewdata.get縦番号()) == 0
                        && detal.get横番号().compareTo(viewdata.get横番号()) == 0
                        && detal.get集計結果値().compareTo(viewdata.get集計結果値()) != 0) {
                    builder.set集計結果値(detal.get集計結果値());
                    viewdata = builder.build();
                    list.add(viewdata);
                }
            }
        }
        List<DetalParameter> 給付額Parameter = get給付額データ();
        for (DetalParameter detal : 給付額Parameter) {
            for (JigyoHokokuTokeiData viewdata : 給付額データ) {
                JigyoHokokuTokeiDataBuilder builder = viewdata.createBuilderForEdit();
                if (detal.get縦番号().compareTo(viewdata.get縦番号()) == 0
                        && detal.get横番号().compareTo(viewdata.get横番号()) == 0
                        && detal.get集計結果値().compareTo(viewdata.get集計結果値()) != 0) {
                    builder.set集計結果値(detal.get集計結果値());
                    viewdata = builder.build();
                    list.add(viewdata);
                }
            }
        }
        return list;
    }
}
