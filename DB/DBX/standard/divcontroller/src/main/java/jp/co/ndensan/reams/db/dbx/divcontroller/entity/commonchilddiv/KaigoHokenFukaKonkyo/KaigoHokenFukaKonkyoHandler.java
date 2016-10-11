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
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ChoteiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 賦課根拠照会【共有子Div】のハンドラクラスです。
 *
 * @reamsid_L DBB-5723-010 xuxin
 */
public class KaigoHokenFukaKonkyoHandler {

    private static final RString 符号 = new RString("～");
    private static final int INT_12 = 12;

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
     * @param 識別コード ShikibetsuCode
     */
    public void init(ShoriDateKanri 処理日付管理情報, FukaJohoRelateSearchResult resultMax,
            List<FukaJohoRelateSearchResult> resultList, ShikibetsuCode 識別コード) {

        div.getBtnBefore().setDisabled(true);
        div.getBtnAfter().setDisabled(true);
        if (処理日付管理情報 != null && 処理日付管理情報.get基準日時() != null
                && resultMax.get介護賦課Result().get調定日時() != null
                && 処理日付管理情報.get基準日時().isBeforeOrEquals(resultMax.get介護賦課Result().get調定日時())) {
            set本算定状態(resultMax);
            setBtn状態_前へ(resultMax, resultList);
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
                set仮算定状態(resultMax, resultMax仮算定用);
                setBtn状態_前へ(resultMax, resultList);
            }
        }
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
        if (!調定年度List.isEmpty()) {
            for (FlexibleYear 調定年度 : 調定年度List) {
                dataSource調定年度.add(new KeyValueDataSource(調定年度.seireki().toDateString(),
                        調定年度.wareki().toDateString()));
            }
            div.getDdlChoteiNendo().setDataSource(sort降順ByKey(dataSource調定年度));
            div.getDdlChoteiNendo().setSelectedIndex(0);
        }
        if (!賦課年度List.isEmpty()) {
            for (FlexibleYear 賦課年度 : 賦課年度List) {
                dataSource賦課年度.add(new KeyValueDataSource(賦課年度.seireki().toDateString(),
                        賦課年度.wareki().toDateString()));
            }
            div.getDdlFukaNendo().setDataSource(sort降順ByKey(dataSource賦課年度));
            div.getDdlFukaNendo().setSelectedIndex(0);
        }
        if (!通知書番号List.isEmpty()) {
            for (TsuchishoNo 通知書番号 : 通知書番号List) {
                dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(), 通知書番号.getColumnValue()));
            }
            div.getDdlTsuchishoNo().setDataSource(sort降順ByKey(dataSource通知書番号));
            div.getDdlTsuchishoNo().setSelectedIndex(0);
        }
    }

    private void setBtn状態_前へ(FukaJohoRelateSearchResult resultMax, List<FukaJohoRelateSearchResult> resultList) {
        List<FukaJohoRelateSearchResult> 計数List = new ArrayList<>();
        for (FukaJohoRelateSearchResult result : resultList) {
            if (resultMax.get介護賦課Result().get調定年度().equals(result.get介護賦課Result().get調定年度())
                    && resultMax.get介護賦課Result().get賦課年度().equals(result.get介護賦課Result().get賦課年度())
                    && resultMax.get介護賦課Result().get通知書番号().equals(result.get介護賦課Result().get通知書番号())) {
                計数List.add(result);
            }
        }
        if (計数List.size() > 1) {
            div.getBtnBefore().setDisabled(false);
        }
    }

    private void set本算定状態(FukaJohoRelateSearchResult resultMax) {

        init本算定状態();
        HihokenshaNo 被保険者番号 = resultMax.get介護賦課Result().get被保険者番号();
        div.getTxtHihokenshaNo().setValue(被保険者番号 == null ? null : 被保険者番号.getColumnValue());
        int 履歴番号 = resultMax.get介護賦課Result().get履歴番号();
        div.getTxtRirekiNo().setValue(new RString(履歴番号));

        FlexibleDate 賦課基準日 = resultMax.get介護賦課Result().get賦課期日();
        div.getLblFukaKijunbiData().setText(賦課基準日 == null ? null : 賦課基準日.wareki().toDateString());
        FlexibleDate 資格取得日 = resultMax.get介護賦課Result().get資格取得日();
        div.getLblShikakuShutokubiData().setText(資格取得日 == null ? null : 資格取得日.wareki().toDateString());
        FlexibleDate 資格喪失日 = resultMax.get介護賦課Result().get資格喪失日();
        div.getLblSoshitsubiData().setText(資格喪失日 == null ? null : 資格喪失日.wareki().toDateString());
        FlexibleDate 生保開始日 = resultMax.get介護賦課Result().get生保開始日();
        div.getLblSeihoKaishibiData().setText(生保開始日 == null ? null : 生保開始日.wareki().toDateString());
        FlexibleDate 生保終了日 = resultMax.get介護賦課Result().get生保廃止日();
        div.getLblSeihoShuryobiData().setText(生保終了日 == null ? null : 生保終了日.wareki().toDateString());
        FlexibleDate 老年開始日 = resultMax.get介護賦課Result().get老年開始日();
        div.getLblronenKaishibiData().setText(老年開始日 == null ? null : 老年開始日.wareki().toDateString());
        FlexibleDate 老年終了日 = resultMax.get介護賦課Result().get老年廃止日();
        div.getLblRonenShuryobiData().setText(老年終了日 == null ? null : 老年終了日.wareki().toDateString());

        div.getLblFukaKonkyoData1().setText(resultMax.get介護賦課Result().get課税区分名称());
        div.getLblFukaKonkyoData2().setText(resultMax.get介護賦課Result().get世帯課税区分名称());
        div.getLblFukaKonkyoData3().setText(doカンマ編集(resultMax.get介護賦課Result().get合計所得金額()));
        div.getLblFukaKonkyoData4().setText(doカンマ編集(resultMax.get介護賦課Result().get公的年金収入額()));
        RString 段階区分 = resultMax.get介護賦課Result().get保険料算定段階();
        if (!RString.isNullOrEmpty(段階区分)) {
            RString 保険料段階 = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List().
                    getBy段階区分(段階区分).get表記();
            div.getLblFukaKonkyoData5().setText(RString.isNullOrEmpty(保険料段階) ? null : 保険料段階);
        }
        div.getLblFukaKonkyoData6().setText(doカンマ編集(resultMax.get介護賦課Result().get減免前介護保険料_年額()));
        div.getLblFukaKonkyoData7().setText(doカンマ編集(resultMax.get介護賦課Result().get減免額()));
        div.getLblFukaKonkyoData8().setText(doカンマ編集(resultMax.get介護賦課Result().get確定介護保険料_年額()));

        FlexibleYearMonth 月割開始年月1 = resultMax.get介護賦課Result().get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = resultMax.get介護賦課Result().get月割終了年月1();
        div.getLblKikanData1().setText(月割開始年月1 != null && 月割終了年月1 != null
                ? 月割開始年月1.wareki().toDateString().concat(符号).concat(月割終了年月1.wareki().toDateString()) : null);
        if (月割開始年月1 != null && !RString.isNullOrEmpty(月割開始年月1.toDateString())
                && 月割終了年月1 != null && !RString.isNullOrEmpty(月割終了年月1.toDateString())) {
            int 月数1 = 月割終了年月1.getBetweenMonths(月割開始年月1) + 1;
            div.getLblGessuData1().setText(new RString(月数1));
        }
        RString 段階区分1 = resultMax.get介護賦課Result().get保険料算定段階1();
        if (!RString.isNullOrEmpty(段階区分1)) {
            RString 保険料段階区分1 = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List().
                    getBy段階区分(段階区分1).get表記();
            div.getLblHokenryoDankaiKubunData1().setText(RString.isNullOrEmpty(保険料段階区分1) ? null : 保険料段階区分1);
        }
        Decimal 保険料率1 = resultMax.get介護賦課Result().get算定年額保険料1();
        div.getLblHokenryoritsuData1().setText(doカンマ編集(保険料率1));
        if (保険料率1 != null && 月割開始年月1 != null && !RString.isNullOrEmpty(月割開始年月1.toDateString())
                && 月割終了年月1 != null && !RString.isNullOrEmpty(月割終了年月1.toDateString())) {
            Decimal 保険料算出額1 = 保険料率1.multiply(月割終了年月1.getBetweenMonths(月割開始年月1)).
                    divide(INT_12).roundHalfUpTo(0);
            div.getLblHokenryoSanshutsugakuData1().setText(doカンマ編集(保険料算出額1));
        }
        FlexibleYearMonth 月割開始年月2 = resultMax.get介護賦課Result().get月割開始年月2();
        FlexibleYearMonth 月割終了年月2 = resultMax.get介護賦課Result().get月割終了年月2();
        div.getLblKikanData2().setText(月割開始年月2 != null && 月割終了年月2 != null
                ? 月割開始年月2.wareki().toDateString().concat(符号).concat(月割終了年月2.wareki().toDateString()) : null);
        if (月割開始年月2 != null && !RString.isNullOrEmpty(月割開始年月2.toDateString())
                && 月割終了年月2 != null && !RString.isNullOrEmpty(月割終了年月2.toDateString())) {
            int 月数2 = 月割終了年月2.getBetweenMonths(月割開始年月2) + 1;
            div.getLblGessuData2().setText(new RString(月数2));
        }
        RString 段階区分2 = resultMax.get介護賦課Result().get保険料算定段階2();
        if (!RString.isNullOrEmpty(段階区分2)) {
            RString 保険料段階区分2 = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List().
                    getBy段階区分(段階区分2).get表記();
            div.getLblHokenryoDankaiKubunData2().setText(RString.isNullOrEmpty(保険料段階区分2) ? null : 保険料段階区分2);
        }
        Decimal 保険料率2 = resultMax.get介護賦課Result().get算定年額保険料2();
        div.getLblHokenryoritsuData2().setText(doカンマ編集(保険料率2));
        if (保険料率2 != null && 月割開始年月2 != null && !RString.isNullOrEmpty(月割開始年月2.toDateString())
                && 月割終了年月2 != null && !RString.isNullOrEmpty(月割終了年月2.toDateString())) {
            Decimal 保険料算出額2 = 保険料率2.multiply(月割終了年月2.getBetweenMonths(月割開始年月2)).
                    divide(INT_12).roundHalfUpTo(0);
            div.getLblHokenryoSanshutsugakuData2().setText(doカンマ編集(保険料算出額2));
        }

        ChoteiJiyu 調定事由1 = resultMax.get介護賦課Result().get調定事由1();
        if (調定事由1 != null && !RString.isNullOrEmpty(調定事由1.getColumnValue())) {
            RString コード略称1 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由1.getColumnValue()));
            div.getTxtChoteiJiyu1().setValue(RString.isNullOrEmpty(コード略称1) ? null : コード略称1);
        }
        ChoteiJiyu 調定事由2 = resultMax.get介護賦課Result().get調定事由2();
        if (調定事由2 != null && !RString.isNullOrEmpty(調定事由2.getColumnValue())) {
            RString コード略称2 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由2.getColumnValue()));
            div.getTxtChoteiJiyu2().setValue(RString.isNullOrEmpty(コード略称2) ? null : コード略称2);
        }
        ChoteiJiyu 調定事由3 = resultMax.get介護賦課Result().get調定事由3();
        if (調定事由3 != null && !RString.isNullOrEmpty(調定事由3.getColumnValue())) {
            RString コード略称3 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由3.getColumnValue()));
            div.getTxtChoteiJiyu3().setValue(RString.isNullOrEmpty(コード略称3) ? null : コード略称3);
        }
        ChoteiJiyu 調定事由4 = resultMax.get介護賦課Result().get調定事由4();
        if (調定事由4 != null && !RString.isNullOrEmpty(調定事由4.getColumnValue())) {
            RString コード略称4 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由4.getColumnValue()));
            div.getTxtChoteiJiyu4().setValue(RString.isNullOrEmpty(コード略称4) ? null : コード略称4);
        }
    }

    private void set仮算定状態(FukaJohoRelateSearchResult resultMax, FukaJohoRelateSearchResult resultMax仮算定用) {

        init仮算定状態();
        HihokenshaNo 被保険者番号 = resultMax.get介護賦課Result().get被保険者番号();
        div.getTxtHihokenshaNo().setValue(被保険者番号 == null ? null : 被保険者番号.getColumnValue());
        int 履歴番号 = resultMax.get介護賦課Result().get履歴番号();
        div.getTxtRirekiNo().setValue(new RString(履歴番号));

        FlexibleDate 賦課基準日 = resultMax.get介護賦課Result().get賦課期日();
        div.getLblFukaKijunbiData().setText(賦課基準日 == null ? null : 賦課基準日.wareki().toDateString());
        FlexibleDate 資格取得日 = resultMax.get介護賦課Result().get資格取得日();
        div.getLblShikakuShutokubiData().setText(資格取得日 == null ? null : 資格取得日.wareki().toDateString());
        FlexibleDate 資格喪失日 = resultMax.get介護賦課Result().get資格喪失日();
        div.getLblSoshitsubiData().setText(資格喪失日 == null ? null : 資格喪失日.wareki().toDateString());
        FlexibleDate 生保開始日 = resultMax.get介護賦課Result().get生保開始日();
        div.getLblSeihoKaishibiData().setText(生保開始日 == null ? null : 生保開始日.wareki().toDateString());
        FlexibleDate 生保終了日 = resultMax.get介護賦課Result().get生保廃止日();
        div.getLblSeihoShuryobiData().setText(生保終了日 == null ? null : 生保終了日.wareki().toDateString());
        FlexibleDate 老年開始日 = resultMax.get介護賦課Result().get老年開始日();
        div.getLblronenKaishibiData().setText(老年開始日 == null ? null : 老年開始日.wareki().toDateString());
        FlexibleDate 老年終了日 = resultMax.get介護賦課Result().get老年廃止日();
        div.getLblRonenShuryobiData().setText(老年終了日 == null ? null : 老年終了日.wareki().toDateString());

        RString 段階区分 = resultMax仮算定用.get介護賦課Result().get保険料算定段階();
        if (!RString.isNullOrEmpty(段階区分)) {
            RString 前年度保険料段階 = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List().
                    getBy段階区分(段階区分).get表記();
            div.getLblFukaKonkyoData1().setText(RString.isNullOrEmpty(前年度保険料段階) ? null : 前年度保険料段階);
        }
        Decimal 前年度保険料率 = resultMax仮算定用.get介護賦課Result().get算定年額保険料2();
        div.getLblFukaKonkyoData2().setText(doカンマ編集(前年度保険料率 == null
                ? resultMax仮算定用.get介護賦課Result().get算定年額保険料1() : 前年度保険料率));
        Decimal 前年度年額保険料 = resultMax仮算定用.get介護賦課Result().get確定介護保険料_年額();
        div.getLblFukaKonkyoData3().setText(doカンマ編集(前年度年額保険料));
        Decimal 減免額 = resultMax仮算定用.get介護賦課Result().get減免額();
        Decimal 仮算定保険料額 = resultMax仮算定用.get調定額();
        if (減免額 != null && 仮算定保険料額 != null) {
            div.getLblFukaKonkyoData6().setText(doカンマ編集(仮算定保険料額.add(減免額)));
        }
        div.getLblFukaKonkyoData7().setText(doカンマ編集(減免額));
        div.getLblFukaKonkyoData8().setText(doカンマ編集(仮算定保険料額));

        ChoteiJiyu 調定事由1 = resultMax.get介護賦課Result().get調定事由1();
        if (調定事由1 != null && !RString.isNullOrEmpty(調定事由1.getColumnValue())) {
            RString コード略称1 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由1.getColumnValue()));
            div.getTxtChoteiJiyu1().setValue(RString.isNullOrEmpty(コード略称1) ? null : コード略称1);
        }
        ChoteiJiyu 調定事由2 = resultMax.get介護賦課Result().get調定事由2();
        if (調定事由2 != null && !RString.isNullOrEmpty(調定事由2.getColumnValue())) {
            RString コード略称2 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由2.getColumnValue()));
            div.getTxtChoteiJiyu2().setValue(RString.isNullOrEmpty(コード略称2) ? null : コード略称2);
        }
        ChoteiJiyu 調定事由3 = resultMax.get介護賦課Result().get調定事由3();
        if (調定事由3 != null && !RString.isNullOrEmpty(調定事由3.getColumnValue())) {
            RString コード略称3 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由3.getColumnValue()));
            div.getTxtChoteiJiyu3().setValue(RString.isNullOrEmpty(コード略称3) ? null : コード略称3);
        }
        ChoteiJiyu 調定事由4 = resultMax.get介護賦課Result().get調定事由4();
        if (調定事由4 != null && !RString.isNullOrEmpty(調定事由4.getColumnValue())) {
            RString コード略称4 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(),
                    new Code(調定事由4.getColumnValue()));
            div.getTxtChoteiJiyu4().setValue(RString.isNullOrEmpty(コード略称4) ? null : コード略称4);
        }
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
     * @param 賦課根拠情報List List<FukaJohoRelateSearchResult>
     */
    public void setDDL再表示(List<FukaJohoRelateSearchResult> 賦課根拠情報List) {

        div.getDdlFukaNendo().getDataSource().clear();
        div.getDdlTsuchishoNo().getDataSource().clear();
        List<FlexibleYear> 賦課年度List = new ArrayList<>();
        List<TsuchishoNo> 通知書番号List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && !賦課年度List.contains(result.get介護賦課Result().get賦課年度())) {
                賦課年度List.add(result.get介護賦課Result().get賦課年度());
            }
        }
        if (!賦課年度List.isEmpty()) {
            List<KeyValueDataSource> dataSource賦課年度 = new ArrayList<>();
            for (FlexibleYear 賦課年度 : 賦課年度List) {
                dataSource賦課年度.add(new KeyValueDataSource(賦課年度.seireki().toDateString(),
                        賦課年度.wareki().toDateString()));
            }
            div.getDdlFukaNendo().setDataSource(sort降順ByKey(dataSource賦課年度));
            div.getDdlFukaNendo().setSelectedIndex(0);
            List<KeyValueDataSource> dataSource通知書番号 = new ArrayList<>();
            for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
                if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                        && div.getDdlFukaNendo().getSelectedKey().
                        equals(result.get介護賦課Result().get賦課年度().toDateString())
                        && !通知書番号List.contains(result.get介護賦課Result().get通知書番号())) {
                    通知書番号List.add(result.get介護賦課Result().get通知書番号());
                }
            }
            if (!通知書番号List.isEmpty()) {
                for (TsuchishoNo 通知書番号 : 通知書番号List) {
                    dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(),
                            通知書番号.getColumnValue()));
                }
                div.getDdlTsuchishoNo().setDataSource(sort降順ByKey(dataSource通知書番号));
                div.getDdlTsuchishoNo().setSelectedIndex(0);
            }
        }
    }

    /**
     * 通知書番号DDLのDataSourceを再設定します。
     *
     * @param 賦課根拠情報List List<FukaJohoRelateSearchResult>
     */
    public void set通知書番号DDL再表示(List<FukaJohoRelateSearchResult> 賦課根拠情報List) {

        div.getDdlTsuchishoNo().getDataSource().clear();
        List<TsuchishoNo> 通知書番号List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && !通知書番号List.contains(result.get介護賦課Result().get通知書番号())) {
                通知書番号List.add(result.get介護賦課Result().get通知書番号());
            }
        }
        if (!通知書番号List.isEmpty()) {
            List<KeyValueDataSource> dataSource通知書番号 = new ArrayList<>();
            for (TsuchishoNo 通知書番号 : 通知書番号List) {
                dataSource通知書番号.add(new KeyValueDataSource(通知書番号.getColumnValue(), 通知書番号.getColumnValue()));
            }
            div.getDdlTsuchishoNo().setDataSource(sort降順ByKey(dataSource通知書番号));
            div.getDdlTsuchishoNo().setSelectedIndex(0);
        }
    }

    /**
     * 指定データの取得と画面の再表示です。
     *
     * @param 処理日付管理情報 ShoriDateKanri
     * @param resultList List<FukaJohoRelateSearchResult>
     */
    public void btnSearch(ShoriDateKanri 処理日付管理情報, List<FukaJohoRelateSearchResult> resultList) {

        FukaJohoRelateSearchResult 指定賦課情報 = get指定賦課情報(resultList);
        if (指定賦課情報 != null) {
            if (処理日付管理情報 != null && 処理日付管理情報.get基準日時() != null
                    && 指定賦課情報.get介護賦課Result().get調定日時() != null
                    && 処理日付管理情報.get基準日時().isBeforeOrEquals(指定賦課情報.get介護賦課Result().get調定日時())) {
                set本算定状態(指定賦課情報);
            } else {
                List<FukaJohoRelateSearchResult> resultList仮算定用 = new ArrayList<>();
                for (FukaJohoRelateSearchResult result : resultList) {
                    if (指定賦課情報.get介護賦課Result().get賦課年度().minusYear(1).
                            equals(result.get介護賦課Result().get賦課年度())) {
                        resultList仮算定用.add(result);
                    }
                }
                if (!resultList仮算定用.isEmpty()) {
                    FukaJohoRelateSearchResult resultMax仮算定用 = resultList仮算定用.get(resultList仮算定用.size() - 1);
                    set仮算定状態(指定賦課情報, resultMax仮算定用);
                }
            }
        }
    }

    /**
     * 指定された賦課の情報を取得します。
     *
     * @param 賦課根拠情報List List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    private FukaJohoRelateSearchResult get指定賦課情報(List<FukaJohoRelateSearchResult> 賦課根拠情報List) {

        List<FukaJohoRelateSearchResult> 指定賦課情報List = new ArrayList<>();
        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(result.get介護賦課Result().get通知書番号())) {
                指定賦課情報List.add(result);
            }
        }
        if (!指定賦課情報List.isEmpty()) {
            FukaJohoRelateSearchResult 指定賦課情報;
            div.getBtnBefore().setDisabled(true);
            div.getBtnAfter().setDisabled(true);
            if (指定賦課情報List.size() == 1) {
                指定賦課情報 = 指定賦課情報List.get(0);
            } else {
                指定賦課情報 = 指定賦課情報List.get(指定賦課情報List.size() - 1);
                div.getBtnBefore().setDisabled(false);
            }
            return 指定賦課情報;
        }
        return null;
    }

    /**
     * 指定データの取得と画面の再表示です。（前へ）
     *
     * @param 処理日付管理情報 ShoriDateKanri
     * @param resultList List<FukaJohoRelateSearchResult>
     */
    public void btnBefore(ShoriDateKanri 処理日付管理情報, List<FukaJohoRelateSearchResult> resultList) {

        FukaJohoRelateSearchResult 指定賦課情報 = get指定賦課情報前へ(resultList);
        if (処理日付管理情報 != null && 処理日付管理情報.get基準日時() != null && 指定賦課情報 != null
                && 指定賦課情報.get介護賦課Result().get調定日時() != null
                && 処理日付管理情報.get基準日時().isBeforeOrEquals(指定賦課情報.get介護賦課Result().get調定日時())) {
            set本算定状態(指定賦課情報);
        } else {
            List<FukaJohoRelateSearchResult> resultList仮算定用 = new ArrayList<>();
            for (FukaJohoRelateSearchResult result : resultList) {
                if (指定賦課情報 != null && 指定賦課情報.get介護賦課Result().get賦課年度().minusYear(1).
                        equals(result.get介護賦課Result().get賦課年度())) {
                    resultList仮算定用.add(result);
                }
            }
            if (!resultList仮算定用.isEmpty()) {
                FukaJohoRelateSearchResult resultMax仮算定用 = resultList仮算定用.get(resultList仮算定用.size() - 1);
                set仮算定状態(指定賦課情報, resultMax仮算定用);
            }
        }
    }

    /**
     * 指定された賦課の情報を取得します。（前へ）
     *
     * @param 賦課根拠情報List List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    private FukaJohoRelateSearchResult get指定賦課情報前へ(List<FukaJohoRelateSearchResult> 賦課根拠情報List) {

        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        RString 画面履歴番号 = div.getTxtRirekiNo().getValue();
        List<FukaJohoRelateSearchResult> result指定賦課情報List = new ArrayList<>();
        for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(result.get介護賦課Result().get通知書番号())) {
                result指定賦課情報List.add(result);
            }
        }
        if (result指定賦課情報List.size() >= 2) {
            for (int i = 1; i < result指定賦課情報List.size(); i++) {
                if (画面履歴番号.equals(new RString(result指定賦課情報List.get(i).get介護賦課Result().get履歴番号()))
                        && i == 1) {
                    div.getBtnBefore().setDisabled(true);
                    div.getBtnAfter().setDisabled(false);
                    return result指定賦課情報List.get(0);
                }
                if (画面履歴番号.equals(new RString(result指定賦課情報List.get(i).get介護賦課Result().get履歴番号()))
                        && i != 1) {
                    div.getBtnBefore().setDisabled(false);
                    div.getBtnAfter().setDisabled(false);
                    return result指定賦課情報List.get(i - 1);
                }
            }
        }
        return null;
    }

    /**
     * 指定データの取得と画面の再表示です。（後へ）
     *
     * @param 処理日付管理情報 ShoriDateKanri
     * @param resultList List<FukaJohoRelateSearchResult>
     */
    public void btnAfter(ShoriDateKanri 処理日付管理情報, List<FukaJohoRelateSearchResult> resultList) {

        FukaJohoRelateSearchResult 指定賦課情報 = get指定賦課情報後へ(resultList);
        if (指定賦課情報 != null) {
            if (処理日付管理情報 != null && 処理日付管理情報.get基準日時() != null
                    && 指定賦課情報.get介護賦課Result().get調定日時() != null
                    && 処理日付管理情報.get基準日時().isBeforeOrEquals(指定賦課情報.get介護賦課Result().get調定日時())) {
                set本算定状態(指定賦課情報);
            } else {
                List<FukaJohoRelateSearchResult> resultList仮算定用 = new ArrayList<>();
                for (FukaJohoRelateSearchResult result : resultList) {
                    if (指定賦課情報.get介護賦課Result().get賦課年度().minusYear(1).
                            equals(result.get介護賦課Result().get賦課年度())) {
                        resultList仮算定用.add(result);
                    }
                }
                if (!resultList仮算定用.isEmpty()) {
                    FukaJohoRelateSearchResult resultMax仮算定用 = resultList仮算定用.get(resultList仮算定用.size() - 1);
                    set仮算定状態(指定賦課情報, resultMax仮算定用);
                }
            }
        }
    }

    /**
     * 指定された賦課の情報を取得します。（後へ）
     *
     * @param 賦課根拠情報List List<FukaJohoRelateSearchResult>
     * @return FukaJohoRelateSearchResult
     */
    private FukaJohoRelateSearchResult get指定賦課情報後へ(List<FukaJohoRelateSearchResult> 賦課根拠情報List) {

        FlexibleYear 画面調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedKey());
        FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
        TsuchishoNo 画面通知書番号 = new TsuchishoNo(div.getDdlTsuchishoNo().getSelectedKey());
        RString 画面履歴番号 = div.getTxtRirekiNo().getValue();
        List<FukaJohoRelateSearchResult> result指定賦課情報List = new ArrayList<>();
        for (FukaJohoRelateSearchResult result : 賦課根拠情報List) {
            if (画面調定年度.equals(result.get介護賦課Result().get調定年度())
                    && 画面賦課年度.equals(result.get介護賦課Result().get賦課年度())
                    && 画面通知書番号.equals(result.get介護賦課Result().get通知書番号())) {
                result指定賦課情報List.add(result);
            }
        }
        if (result指定賦課情報List.size() >= 2) {
            for (int i = result指定賦課情報List.size() - 1 - 1; i >= 0; i--) {
                if (画面履歴番号.equals(new RString(result指定賦課情報List.get(i).get介護賦課Result().get履歴番号()))
                        && i == result指定賦課情報List.size() - 1 - 1) {
                    div.getBtnBefore().setDisabled(false);
                    div.getBtnAfter().setDisabled(true);
                    return result指定賦課情報List.get(result指定賦課情報List.size() - 1);
                }
                if (画面履歴番号.equals(new RString(result指定賦課情報List.get(i).get介護賦課Result().get履歴番号()))
                        && i != result指定賦課情報List.size() - 1 - 1) {
                    div.getBtnBefore().setDisabled(false);
                    div.getBtnAfter().setDisabled(false);
                    return result指定賦課情報List.get(i + 1);
                }
            }
        }
        return null;
    }

    private void init本算定状態() {

        div.getLblMaenendoHokenryoDankai().setDisplayNone(true);
        div.getLblHonninKazei().setDisplayNone(false);
        div.getLblZennendoHokenryoRitsu().setDisplayNone(true);
        div.getLblSetaiKazei().setDisplayNone(false);
        div.getLblZennendoNengakuHokenryo().setDisplayNone(true);
        div.getLblGokeiShotokuKingaku().setDisplayNone(false);
        div.getLblNenkinShunyugaku().setDisplayNone(false);
        div.getLblHokenryoDankai().setDisplayNone(false);
        div.getLblKarisanteiKeisanjoHokenryogaku().setDisplayNone(true);
        div.getLblKeisanjoNenkanHokenryogaku().setDisplayNone(false);
        div.getLblKarisanteiHokenryogaku().setDisplayNone(true);
        div.getLblKakuteiNenkanHokenryogaku().setDisplayNone(false);
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtRirekiNo().clearValue();
        div.getLblFukaKijunbiData().setText(RString.EMPTY);
        div.getLblShikakuShutokubiData().setText(RString.EMPTY);
        div.getLblSoshitsubiData().setText(RString.EMPTY);
        div.getLblSeihoKaishibiData().setText(RString.EMPTY);
        div.getLblSeihoShuryobiData().setText(RString.EMPTY);
        div.getLblronenKaishibiData().setText(RString.EMPTY);
        div.getLblRonenShuryobiData().setText(RString.EMPTY);
        div.getLblFukaKonkyoData1().setText(RString.EMPTY);
        div.getLblFukaKonkyoData2().setText(RString.EMPTY);
        div.getLblFukaKonkyoData3().setText(RString.EMPTY);
        div.getLblFukaKonkyoData4().setText(RString.EMPTY);
        div.getLblFukaKonkyoData5().setText(RString.EMPTY);
        div.getLblFukaKonkyoData6().setText(RString.EMPTY);
        div.getLblFukaKonkyoData7().setText(RString.EMPTY);
        div.getLblFukaKonkyoData8().setText(RString.EMPTY);
        div.getLblKikanData1().setText(RString.EMPTY);
        div.getLblGessuData1().setText(RString.EMPTY);
        div.getLblHokenryoDankaiKubunData1().setText(RString.EMPTY);
        div.getLblHokenryoritsuData1().setText(RString.EMPTY);
        div.getLblHokenryoSanshutsugakuData1().setText(RString.EMPTY);
        div.getLblKikanData2().setText(RString.EMPTY);
        div.getLblGessuData2().setText(RString.EMPTY);
        div.getLblHokenryoDankaiKubunData2().setText(RString.EMPTY);
        div.getLblHokenryoritsuData2().setText(RString.EMPTY);
        div.getLblHokenryoSanshutsugakuData2().setText(RString.EMPTY);
        div.getTxtChoteiJiyu1().clearValue();
        div.getTxtChoteiJiyu2().clearValue();
        div.getTxtChoteiJiyu3().clearValue();
        div.getTxtChoteiJiyu4().clearValue();
    }

    private void init仮算定状態() {

        div.getLblMaenendoHokenryoDankai().setDisplayNone(false);
        div.getLblHonninKazei().setDisplayNone(true);
        div.getLblZennendoHokenryoRitsu().setDisplayNone(false);
        div.getLblSetaiKazei().setDisplayNone(true);
        div.getLblZennendoNengakuHokenryo().setDisplayNone(false);
        div.getLblGokeiShotokuKingaku().setDisplayNone(true);
        div.getLblNenkinShunyugaku().setDisplayNone(true);
        div.getLblHokenryoDankai().setDisplayNone(true);
        div.getLblKarisanteiKeisanjoHokenryogaku().setDisplayNone(false);
        div.getLblKeisanjoNenkanHokenryogaku().setDisplayNone(true);
        div.getLblKarisanteiHokenryogaku().setDisplayNone(false);
        div.getLblKakuteiNenkanHokenryogaku().setDisplayNone(true);
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtRirekiNo().clearValue();
        div.getLblFukaKijunbiData().setText(RString.EMPTY);
        div.getLblShikakuShutokubiData().setText(RString.EMPTY);
        div.getLblSoshitsubiData().setText(RString.EMPTY);
        div.getLblSeihoKaishibiData().setText(RString.EMPTY);
        div.getLblSeihoShuryobiData().setText(RString.EMPTY);
        div.getLblronenKaishibiData().setText(RString.EMPTY);
        div.getLblRonenShuryobiData().setText(RString.EMPTY);
        div.getLblFukaKonkyoData1().setText(RString.EMPTY);
        div.getLblFukaKonkyoData2().setText(RString.EMPTY);
        div.getLblFukaKonkyoData3().setText(RString.EMPTY);
        div.getLblFukaKonkyoData4().setText(RString.EMPTY);
        div.getLblFukaKonkyoData5().setText(RString.EMPTY);
        div.getLblFukaKonkyoData6().setText(RString.EMPTY);
        div.getLblFukaKonkyoData7().setText(RString.EMPTY);
        div.getLblFukaKonkyoData8().setText(RString.EMPTY);
        div.getLblKikanData1().setText(RString.EMPTY);
        div.getLblGessuData1().setText(RString.EMPTY);
        div.getLblHokenryoDankaiKubunData1().setText(RString.EMPTY);
        div.getLblHokenryoritsuData1().setText(RString.EMPTY);
        div.getLblHokenryoSanshutsugakuData1().setText(RString.EMPTY);
        div.getLblKikanData2().setText(RString.EMPTY);
        div.getLblGessuData2().setText(RString.EMPTY);
        div.getLblHokenryoDankaiKubunData2().setText(RString.EMPTY);
        div.getLblHokenryoritsuData2().setText(RString.EMPTY);
        div.getLblHokenryoSanshutsugakuData2().setText(RString.EMPTY);
        div.getTxtChoteiJiyu1().clearValue();
        div.getTxtChoteiJiyu2().clearValue();
        div.getTxtChoteiJiyu3().clearValue();
        div.getTxtChoteiJiyu4().clearValue();
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

}
