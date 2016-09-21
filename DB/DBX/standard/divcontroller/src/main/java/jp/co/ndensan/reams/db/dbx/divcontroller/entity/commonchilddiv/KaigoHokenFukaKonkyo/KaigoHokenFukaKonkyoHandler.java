/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.fukajoho.FukaJohoRelateSearchResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 賦課根拠照会【共有子Div】のハンドラクラスです。
 *
 * @reamsid_L DBB-5723-010 xuxin
 */
public class KaigoHokenFukaKonkyoHandler {

    private static final RString 符号 = new RString("～");

    private final KaigoHokenFukaKonkyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     */
    public KaigoHokenFukaKonkyoHandler(KaigoHokenFukaKonkyoDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期表示とデータの取得です。
     *
     * @param 処理日付管理情報 ShoriDateKanri
     * @param resultMax FukaJohoRelateSearchResult
     * @param resultList List<FukaJohoRelateSearchResult>
     */
    public void init(ShoriDateKanri 処理日付管理情報, FukaJohoRelateSearchResult resultMax,
            List<FukaJohoRelateSearchResult> resultList) {

        if (処理日付管理情報 != null
                && 処理日付管理情報.get基準日時().isBeforeOrEquals(resultMax.get介護賦課Result().get調定日時())) {
            set本算定状態(resultMax);
        } else {
            List<FukaJohoRelateSearchResult> resultList仮算定用 = new ArrayList<>();
            for (FukaJohoRelateSearchResult result : resultList) {
                if (resultMax.get介護賦課Result().get賦課年度().minusYear(1).
                        equals(result.get介護賦課Result().get賦課年度())) {
                    resultList仮算定用.add(result);
                }
            }
            if (!resultList仮算定用.isEmpty()) {
                FukaJohoRelateSearchResult resultMax仮算定用 = resultList仮算定用.get(resultList仮算定用.size() - 1);
                set仮算定状態(resultMax仮算定用);   //1.5
            }
        }   //1.4
        List<FlexibleYear> 調定年度List = new ArrayList<>();
        List<FlexibleYear> 賦課年度List = new ArrayList<>();
        List<TsuchishoNo> 通知書番号List = new ArrayList<>();
        for (FukaJohoRelateSearchResult searchResult : resultList) {
            FlexibleYear 調定年度 = searchResult.get介護賦課Result().get調定年度();
            if (!調定年度List.contains(調定年度)) {
                調定年度List.add(調定年度);
            }
            if (resultMax.get介護賦課Result().get調定年度().equals(調定年度)
                    && !賦課年度List.contains(searchResult.get介護賦課Result().get賦課年度())) {
                賦課年度List.add(searchResult.get介護賦課Result().get賦課年度());
            }
            if (resultMax.get介護賦課Result().get調定年度().equals(調定年度)
                    && resultMax.get介護賦課Result().get賦課年度().equals(searchResult.get介護賦課Result().get賦課年度())
                    && !通知書番号List.contains(searchResult.get介護賦課Result().get通知書番号())) {
                通知書番号List.add(searchResult.get介護賦課Result().get通知書番号());
            }
        }
        List<KeyValueDataSource> dataSource調定年度 = new ArrayList<>();
        List<KeyValueDataSource> dataSource賦課年度 = new ArrayList<>();
        List<KeyValueDataSource> dataSource通知書番号 = new ArrayList<>();
        for (FlexibleYear 調定年度 : 調定年度List) {
            dataSource調定年度.add(new KeyValueDataSource(調定年度.seireki().toDateString(),
                    調定年度.wareki().toDateString()));
        }
        div.getDdlChoteiNendo().setDataSource(dataSource調定年度);  // 1.6
        for (FlexibleYear 賦課年度 : 賦課年度List) {
            dataSource賦課年度.add(new KeyValueDataSource(賦課年度.seireki().toDateString(),
                    賦課年度.wareki().toDateString()));
        }
        div.getDdlFukaNendo().setDataSource(dataSource賦課年度);  // 1.7
        for (TsuchishoNo 通知書番号 : 通知書番号List) {
            dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(), 通知書番号.getColumnValue()));
        }
        div.getDdlTsuchishoNo().setDataSource(dataSource通知書番号);  // 1.8
    }

    private void set本算定状態(FukaJohoRelateSearchResult resultMax) {
        div.getTxtHihokenshaNo().setValue(resultMax.get介護賦課Result().get被保険者番号().getColumnValue());
        div.getTxtRirekiNo().setValue(new RString(resultMax.get介護賦課Result().get履歴番号()));

        div.getLblFukaKijunbiData().setText(resultMax.get介護賦課Result().get賦課期日() == null ? null
                : new RString(resultMax.get介護賦課Result().get賦課期日().wareki().toString()));
        div.getLblShikakuShutokubiData().setText(resultMax.get介護賦課Result().get資格取得日() == null ? null
                : new RString(resultMax.get介護賦課Result().get資格取得日().wareki().toString()));
        div.getLblSoshitsubiData().setText(resultMax.get介護賦課Result().get資格喪失日() == null ? null
                : new RString(resultMax.get介護賦課Result().get資格喪失日().wareki().toString()));
        div.getLblSeihoKaishibiData().setText(resultMax.get介護賦課Result().get生保開始日() == null ? null
                : new RString(resultMax.get介護賦課Result().get生保開始日().wareki().toString()));
        div.getLblSeihoShuryobiData().setText(resultMax.get介護賦課Result().get生保廃止日() == null ? null
                : new RString(resultMax.get介護賦課Result().get生保廃止日().wareki().toString()));
        div.getLblronenKaishibiData().setText(resultMax.get介護賦課Result().get老年開始日() == null ? null
                : new RString(resultMax.get介護賦課Result().get老年開始日().wareki().toString()));
        div.getLblRonenShuryobiData().setText(resultMax.get介護賦課Result().get老年廃止日() == null ? null
                : new RString(resultMax.get介護賦課Result().get老年廃止日().wareki().toString()));

        div.getLblMaenendoHokenryoDankai().setVisible(false);
        div.getLblHonninKazei().setVisible(true);
        div.getLblFukaKonkyoData1().setText(resultMax.get介護賦課Result().get課税区分().get名称());
        div.getLblZennendoHokenryoRitsu().setVisible(false);
        div.getLblSetaiKazei().setVisible(true);
        div.getLblFukaKonkyoData2().setText(resultMax.get介護賦課Result().get世帯課税区分().get名称());
        div.getLblZennendoNengakuHokenryo().setVisible(false);
        div.getLblGokeiShotokuKingaku().setVisible(true);
        div.getLblFukaKonkyoData3().setText(doカンマ編集(resultMax.get介護賦課Result().get合計所得金額()));
        div.getLblNenkinShunyugaku().setVisible(true);
        div.getLblFukaKonkyoData4().setText(doカンマ編集(resultMax.get介護賦課Result().get公的年金収入額()));
        div.getLblHokenryoDankai().setVisible(true);
        div.getLblFukaKonkyoData5().setText(RString.isNullOrEmpty(resultMax.get介護賦課Result().get保険料算定段階2())
                ? resultMax.get介護賦課Result().get保険料算定段階1() : resultMax.get介護賦課Result().get保険料算定段階2());
        div.getLblKarisanteiKeisanjoHokenryogaku().setVisible(false);
        div.getLblKeisanjoNenkanHokenryogaku().setVisible(true);
        div.getLblFukaKonkyoData6().setText(doカンマ編集(resultMax.get介護賦課Result().get減免前介護保険料_年額()));
        div.getLblFukaKonkyoData7().setText(doカンマ編集(resultMax.get介護賦課Result().get減免額()));
        div.getLblKarisanteiHokenryogaku().setVisible(false);
        div.getLblKakuteiNenkanHokenryogaku().setVisible(true);
        div.getLblFukaKonkyoData8().setText(doカンマ編集(resultMax.get介護賦課Result().get確定介護保険料_年額()));

        div.getLblKikanData1().setText(resultMax.get介護賦課Result().get月割開始年月1().wareki().toDateString().
                concat(符号).concat(resultMax.get介護賦課Result().get月割終了年月1().wareki().toDateString()));
        div.getLblGessuData1().setText(new RString(resultMax.get介護賦課Result().get月割開始年月1().
                getBetweenMonths(resultMax.get介護賦課Result().get月割終了年月1())));
        div.getLblHokenryoDankaiKubunData1().setText(resultMax.get介護賦課Result().get保険料算定段階1());
        div.getLblHokenryoritsuData1().setText(doカンマ編集(resultMax.get介護賦課Result().get算定年額保険料1()));
        div.getLblHokenryoSanshutsugakuData1().setText(RString.EMPTY);
        div.getLblKikanData2().setText(resultMax.get介護賦課Result().get月割開始年月2().wareki().toDateString().
                concat(符号).concat(resultMax.get介護賦課Result().get月割終了年月2().wareki().toDateString()));
        div.getLblGessuData2().setText(new RString(resultMax.get介護賦課Result().get月割開始年月2().
                getBetweenMonths(resultMax.get介護賦課Result().get月割終了年月2())));
        div.getLblHokenryoDankaiKubunData2().setText(resultMax.get介護賦課Result().get保険料算定段階2());
        div.getLblHokenryoritsuData2().setText(doカンマ編集(resultMax.get介護賦課Result().get算定年額保険料2()));
        div.getLblHokenryoSanshutsugakuData2().setText(RString.EMPTY);

        div.getTxtChoteiJiyu1().setValue(resultMax.get介護賦課Result().get調定事由1().getColumnValue());
        div.getTxtChoteiJiyu2().setValue(resultMax.get介護賦課Result().get調定事由2().getColumnValue());
        div.getTxtChoteiJiyu3().setValue(resultMax.get介護賦課Result().get調定事由3().getColumnValue());
        div.getTxtChoteiJiyu4().setValue(resultMax.get介護賦課Result().get調定事由4().getColumnValue());
    }

    private void set仮算定状態(FukaJohoRelateSearchResult resultMax仮算定用) {
        div.getTxtHihokenshaNo().setValue(resultMax仮算定用.get介護賦課Result().get被保険者番号().getColumnValue());
        div.getTxtRirekiNo().setValue(new RString(resultMax仮算定用.get介護賦課Result().get履歴番号()));

        div.getLblFukaKijunbiData().setText(resultMax仮算定用.get介護賦課Result().get賦課期日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get賦課期日().wareki().toString()));
        div.getLblShikakuShutokubiData().setText(resultMax仮算定用.get介護賦課Result().get資格取得日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get資格取得日().wareki().toString()));
        div.getLblSoshitsubiData().setText(resultMax仮算定用.get介護賦課Result().get資格喪失日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get資格喪失日().wareki().toString()));
        div.getLblSeihoKaishibiData().setText(resultMax仮算定用.get介護賦課Result().get生保開始日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get生保開始日().wareki().toString()));
        div.getLblSeihoShuryobiData().setText(resultMax仮算定用.get介護賦課Result().get生保廃止日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get生保廃止日().wareki().toString()));
        div.getLblronenKaishibiData().setText(resultMax仮算定用.get介護賦課Result().get老年開始日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get老年開始日().wareki().toString()));
        div.getLblRonenShuryobiData().setText(resultMax仮算定用.get介護賦課Result().get老年廃止日() == null ? null
                : new RString(resultMax仮算定用.get介護賦課Result().get老年廃止日().wareki().toString()));

        div.getLblMaenendoHokenryoDankai().setVisible(true);
        div.getLblHonninKazei().setVisible(false);
        div.getLblFukaKonkyoData1().setText(
                RString.isNullOrEmpty(resultMax仮算定用.get介護賦課Result().get保険料算定段階2())
                ? resultMax仮算定用.get介護賦課Result().get保険料算定段階1()
                : resultMax仮算定用.get介護賦課Result().get保険料算定段階2());
        div.getLblZennendoHokenryoRitsu().setVisible(true);
        div.getLblSetaiKazei().setVisible(false);
        div.getLblFukaKonkyoData2().setText(doカンマ編集(
                resultMax仮算定用.get介護賦課Result().get算定年額保険料2() == null
                ? resultMax仮算定用.get介護賦課Result().get算定年額保険料1()
                : resultMax仮算定用.get介護賦課Result().get算定年額保険料2()));
        div.getLblZennendoNengakuHokenryo().setVisible(true);
        div.getLblGokeiShotokuKingaku().setVisible(false);
        div.getLblFukaKonkyoData3().setText(doカンマ編集(resultMax仮算定用.get介護賦課Result().get確定介護保険料_年額()));
        div.getLblNenkinShunyugaku().setVisible(false);
        div.getLblHokenryoDankai().setVisible(false);
        div.getLblKarisanteiKeisanjoHokenryogaku().setVisible(true);
        div.getLblKeisanjoNenkanHokenryogaku().setVisible(false);
        div.getLblFukaKonkyoData6().setText(doカンマ編集(resultMax仮算定用.get調定額().
                add(resultMax仮算定用.get介護賦課Result().get減免額())));
        div.getLblFukaKonkyoData7().setText(doカンマ編集(resultMax仮算定用.get介護賦課Result().get減免額()));
        div.getLblKarisanteiHokenryogaku().setVisible(true);
        div.getLblKakuteiNenkanHokenryogaku().setVisible(false);
        div.getLblFukaKonkyoData8().setText(doカンマ編集(resultMax仮算定用.get調定額()));

        div.getLblKikanData1().setText(resultMax仮算定用.get介護賦課Result().get月割開始年月1().wareki().toDateString().
                concat(符号).concat(resultMax仮算定用.get介護賦課Result().get月割終了年月1().wareki().toDateString()));
        div.getLblGessuData1().setText(new RString(resultMax仮算定用.get介護賦課Result().get月割開始年月1().
                getBetweenMonths(resultMax仮算定用.get介護賦課Result().get月割終了年月1())));
        div.getLblHokenryoDankaiKubunData1().setText(resultMax仮算定用.get介護賦課Result().get保険料算定段階1());
        div.getLblHokenryoritsuData1().setText(doカンマ編集(resultMax仮算定用.get介護賦課Result().get算定年額保険料1()));
        div.getLblHokenryoSanshutsugakuData1().setText(RString.EMPTY);
        div.getLblKikanData2().setText(resultMax仮算定用.get介護賦課Result().get月割開始年月2().wareki().toDateString().
                concat(符号).concat(resultMax仮算定用.get介護賦課Result().get月割終了年月2().wareki().toDateString()));
        div.getLblGessuData2().setText(new RString(resultMax仮算定用.get介護賦課Result().get月割開始年月2().
                getBetweenMonths(resultMax仮算定用.get介護賦課Result().get月割終了年月2())));
        div.getLblHokenryoDankaiKubunData2().setText(resultMax仮算定用.get介護賦課Result().get保険料算定段階2());
        div.getLblHokenryoritsuData2().setText(doカンマ編集(resultMax仮算定用.get介護賦課Result().get算定年額保険料2()));
        div.getLblHokenryoSanshutsugakuData2().setText(RString.EMPTY);

        div.getTxtChoteiJiyu1().setValue(resultMax仮算定用.get介護賦課Result().get調定事由1().getColumnValue());
        div.getTxtChoteiJiyu2().setValue(resultMax仮算定用.get介護賦課Result().get調定事由2().getColumnValue());
        div.getTxtChoteiJiyu3().setValue(resultMax仮算定用.get介護賦課Result().get調定事由3().getColumnValue());
        div.getTxtChoteiJiyu4().setValue(resultMax仮算定用.get介護賦課Result().get調定事由4().getColumnValue());
    }

    private RString doカンマ編集(Decimal decimal) {
        if (decimal != null) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    /**
     * 賦課年度DDLと通知書番号DDLのDataSourceを再設定します。
     *
     * @param 全て賦課情報 List<FukaJohoRelateSearchResult>
     */
    public void setDDL再表示(List<FukaJohoRelateSearchResult> 全て賦課情報) {

        div.getDdlFukaNendo().getDataSource().clear();
        div.getDdlTsuchishoNo().getDataSource().clear();
        List<FlexibleYear> 賦課年度List = new ArrayList<>();
        List<TsuchishoNo> 通知書番号List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 全て賦課情報) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && !賦課年度List.contains(result.get介護賦課Result().get賦課年度())) {
                賦課年度List.add(result.get介護賦課Result().get賦課年度());
            }
        }
        List<KeyValueDataSource> dataSource賦課年度 = new ArrayList<>();
        for (FlexibleYear 賦課年度 : 賦課年度List) {
            dataSource賦課年度.add(new KeyValueDataSource(賦課年度.seireki().toDateString(), 賦課年度.wareki().toDateString()));
        }
        div.getDdlFukaNendo().setDataSource(sort降順ByKey(dataSource賦課年度));
        if (!dataSource賦課年度.isEmpty()) {
            List<KeyValueDataSource> dataSource通知書番号 = new ArrayList<>();
            for (FukaJohoRelateSearchResult result : 全て賦課情報) {
                if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                        && sort降順ByKey(dataSource賦課年度).get(0).getKey().
                        equals(result.get介護賦課Result().get賦課年度().toDateString())
                        && !通知書番号List.contains(result.get介護賦課Result().get通知書番号())) {
                    通知書番号List.add(result.get介護賦課Result().get通知書番号());
                }
            }
            for (TsuchishoNo 通知書番号 : 通知書番号List) {
                dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(), 通知書番号.getColumnValue()));
            }
            div.getDdlTsuchishoNo().setDataSource(sort降順ByKey(dataSource通知書番号));
        }
    }

    /**
     * 通知書番号DDLのDataSourceを再設定します。
     *
     * @param 全て賦課情報 List<FukaJohoRelateSearchResult>
     */
    public void set通知書番号DDL再表示(List<FukaJohoRelateSearchResult> 全て賦課情報) {

        div.getDdlTsuchishoNo().getDataSource().clear();
        List<TsuchishoNo> 通知書番号List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 全て賦課情報) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && !通知書番号List.contains(result.get介護賦課Result().get通知書番号())) {
                通知書番号List.add(result.get介護賦課Result().get通知書番号());
            }
        }
        List<KeyValueDataSource> dataSource通知書番号 = new ArrayList<>();
        for (TsuchishoNo 通知書番号 : 通知書番号List) {
            dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(), 通知書番号.getColumnValue()));
        }
        div.getDdlTsuchishoNo().setDataSource(sort降順ByKey(dataSource通知書番号));
    }

    /**
     * 指定された賦課の情報を取得します。
     *
     * @param 全て賦課情報 List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    public FukaJohoRelateSearchResult get指定賦課情報(List<FukaJohoRelateSearchResult> 全て賦課情報) {

        List<FukaJohoRelateSearchResult> 指定賦課情報List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 全て賦課情報) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(result.get介護賦課Result().get通知書番号())) {
                指定賦課情報List.add(result);
            }
        }
        if (!指定賦課情報List.isEmpty()) {
            FukaJohoRelateSearchResult 指定賦課情報;
            if (指定賦課情報List.size() == 1) {
                指定賦課情報 = 指定賦課情報List.get(0);
            } else {
                指定賦課情報 = sort降順By履歴番号(指定賦課情報List).get(0);
            }
            return 指定賦課情報;
        }
        return null;
    }

    /**
     * 指定された賦課の情報を取得します。（前へ）
     *
     * @param 全て賦課情報 List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    public FukaJohoRelateSearchResult get指定賦課情報前へ(List<FukaJohoRelateSearchResult> 全て賦課情報) {

        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        RString 履歴番号 = div.getTxtRirekiNo().getValue();
        for (int i = 0; i < 全て賦課情報.size(); i++) {
            if (画面調定年度.equals(全て賦課情報.get(i).get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(全て賦課情報.get(i).get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(全て賦課情報.get(i).get介護賦課Result().get通知書番号())
                    && 履歴番号.equals(new RString(全て賦課情報.get(i).get介護賦課Result().get履歴番号()))
                    && i != 0) {
                return 全て賦課情報.get(i - 1);
            }
        }
        return null;
    }

    /**
     * 指定された賦課の情報を取得します。（後へ）
     *
     * @param 全て賦課情報 List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    public FukaJohoRelateSearchResult get指定賦課情報後へ(List<FukaJohoRelateSearchResult> 全て賦課情報) {

        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        RString 履歴番号 = div.getTxtRirekiNo().getValue();
        for (int i = 0; i < 全て賦課情報.size(); i++) {
            if (画面調定年度.equals(全て賦課情報.get(i).get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(全て賦課情報.get(i).get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(全て賦課情報.get(i).get介護賦課Result().get通知書番号())
                    && 履歴番号.equals(new RString(全て賦課情報.get(i).get介護賦課Result().get履歴番号()))
                    && i != 全て賦課情報.size() - 1) {
                return 全て賦課情報.get(i + 1);
            }
        }
        return null;
    }

    private List<KeyValueDataSource> sort降順ByKey(List<KeyValueDataSource> dataSource) {
        if (dataSource.isEmpty()) {
            return dataSource;
        }
        Collections.sort(dataSource,
                new Comparator<KeyValueDataSource>() {
                    @Override
                    public int compare(KeyValueDataSource arg0, KeyValueDataSource arg1) {
                        return arg1.getKey().compareTo(arg0.getKey());
                    }
                }
        );
        return dataSource;
    }

    private List<FukaJohoRelateSearchResult> sort降順By履歴番号(List<FukaJohoRelateSearchResult> resultList) {
        if (resultList.isEmpty()) {
            return resultList;
        }
        Collections.sort(resultList,
                new Comparator<FukaJohoRelateSearchResult>() {
                    @Override
                    public int compare(FukaJohoRelateSearchResult arg0, FukaJohoRelateSearchResult arg1) {
                        return new RString(arg1.get介護賦課Result().get履歴番号()).
                        compareTo(new RString(arg0.get介護賦課Result().get履歴番号()));
                    }
                }
        );
        return resultList;
    }

}
