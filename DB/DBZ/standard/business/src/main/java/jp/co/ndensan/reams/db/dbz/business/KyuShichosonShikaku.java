/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GesshoGetsumatsuKubun;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;

/**
 * 旧市町村の被保険者情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyuShichosonShikaku {

    private final List<HihokenshaDaichoModel> 被保険者台帳List;

    /**
     * コンストラクタです。
     *
     * @param 被保険者台帳List 被保険者台帳List（処理対象の被保険者一人分）
     * @throws NullPointerException 引数がnullの場合
     */
    public KyuShichosonShikaku(List<HihokenshaDaichoModel> 被保険者台帳List) throws NullPointerException {
        this.被保険者台帳List = requireNonNull(被保険者台帳List, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳List"));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 「資格取得年月日≦基準年月日」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年月日 基準年月日
     * @return 被保険者情報
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public Optional<HihokenshaDaichoModel> get最新旧市町村被保険者情報(FlexibleDate 基準年月日)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        if (!基準年月日.isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年月日").evaluate());
        }

        return Optional.ofNullable(get最新履歴(基準年月日));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 基準年度の各月（4月から3月）の基準日を基準年月日とし、各月毎、「資格取得年月日≦基準年月日」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年度 基準年度
     * @param 基準日 基準日
     * @return 被保険者情報List（12ヶ月分）
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public IItemList<HihokenshaDaichoModel> get月別最新旧市町村被保険者情報(FlexibleYear 基準年度, int 基準日)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年度, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年度"));
        if (!new FlexibleDate(基準年度.getYearValue(), 1, 基準日).isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年度または基準日").evaluate());
        }

        FlexibleDate 開始日 = new FlexibleDate(基準年度.getYearValue(), 4, 1);
        FlexibleDate 終了日 = get当月末日(開始日.plusMonth(11).getYearMonth());
        Range<FlexibleDate> 対象期間 = new Range<>(開始日, 終了日);

        Map<FlexibleYearMonth, HihokenshaDaichoModel> map = new TreeMap<>();
        for (HihokenshaDaichoModel 履歴 : 被保険者台帳List) {
            FlexibleDate 取得日 = 履歴.get資格取得年月日();
            if (!対象期間.between(取得日) || 基準日 < 取得日.getDayValue()) {
                continue;
            }
            HihokenshaDaichoModel old履歴 = map.get(取得日.getYearMonth());
            if (old履歴 != null && !is新履歴(履歴, old履歴)) {
                continue;
            }
            map.put(取得日.getYearMonth(), 履歴);
        }

        return ItemList.of((List) Arrays.asList(map.values().toArray()));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 最古の情報を対象とします。
     *
     * @return 被保険者情報
     */
    public Optional<HihokenshaDaichoModel> get最古旧市町村被保険者情報() {
        return Optional.ofNullable(get最古履歴(null));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * ＜月初月末区分が「指定無」、または「月初」の場合＞<br/>
     * 「資格取得年月日＝基準年月」、または「資格喪失年月日＝基準年月」の情報の内、最古の情報を対象とします。<br/>
     * なお、該当する情報が存在しない場合は、「資格取得年月日＜基準年月」の情報の内、最新の情報を対象とします。<br/>
     * ＜月初月末区分が「月末」の場合＞<br/>
     * 「資格取得年月日≦基準年月」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年月 基準年月
     * @param 月初月末区分 月初月末区分
     * @return 被保険者情報
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public Optional<HihokenshaDaichoModel> get旧市町村被保険者情報By月初月末指定(FlexibleYearMonth 基準年月, GesshoGetsumatsuKubun 月初月末区分)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        if (!基準年月.isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年月").evaluate());
        }

        HihokenshaDaichoModel 対象履歴 = null;
        switch (月初月末区分) {
            case 指定無:
            case 月初:
                対象履歴 = get最古履歴(基準年月);
                if (対象履歴 == null) {
                    対象履歴 = get最新履歴(get前月末日(基準年月));
                }
                break;
            case 月末:
                対象履歴 = get最新履歴(get当月末日(基準年月));
                break;
            default:
                throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("月初月末区分").evaluate());
        }

        return Optional.ofNullable(対象履歴);
    }

    /**
     * 被保険者情報を編集して返します。<br/>
     * <br/>
     * 1.旧市町村コードと広住特措置元市町村コードがEMPTYの場合、旧市町村コードに市町村コードを設定します。<br/>
     * 2.旧市町村コードがEMPTY、かつ広住特措置元市町村コードがEMPTY以外の場合、旧市町村コードに広住特措置元市町村コードを設定します。<br/>
     * 3.広住特措置元市町村コードがEMPTY以外の場合、市町村コードに広住特措置元市町村コードを設定します。<br/>
     * 4.資格喪失年月日がEMPTYの場合、資格喪失年月日に"99999999"を設定する。
     *
     * @return 編集後の被保険者情報
     */
    public IItemList<HihokenshaDaichoModel> edit旧市町村被保険者情報() {
        List<HihokenshaDaichoModel> edited履歴List = new ArrayList<>();
        for (HihokenshaDaichoModel 編集元 : 被保険者台帳List) {
            HihokenshaDaichoModel 対象履歴 = new HihokenshaDaichoModel(編集元.getEntity());
            if (編集元.get旧市町村コード().isEmpty() && 編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set旧市町村コード(編集元.get市町村コード());
            }
            if (編集元.get旧市町村コード().isEmpty() && !編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set旧市町村コード(編集元.get広住特措置元市町村コード());
            }
            if (!編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set市町村コード(編集元.get広住特措置元市町村コード());
            }
            if (編集元.get資格喪失年月日().isEmpty()) {
                対象履歴.set資格喪失年月日(new FlexibleDate("99999999"));
            }
            edited履歴List.add(対象履歴);
        }
        return ItemList.of(edited履歴List);
    }

    private HihokenshaDaichoModel get最新履歴(FlexibleDate 基準年月日) {
        HihokenshaDaichoModel 対象履歴 = null;
        for (HihokenshaDaichoModel 履歴 : 被保険者台帳List) {
            if (基準年月日 != null && !履歴.get資格取得年月日().isBeforeOrEquals(基準年月日)) {
                continue;
            }
            if (対象履歴 != null && !is新履歴(履歴, 対象履歴)) {
                continue;
            }
            対象履歴 = 履歴;
        }
        return 対象履歴;
    }

    private HihokenshaDaichoModel get最古履歴(FlexibleYearMonth 基準年月) {
        HihokenshaDaichoModel 対象履歴 = null;
        for (HihokenshaDaichoModel 履歴 : 被保険者台帳List) {
            if (基準年月 != null
                    && !(履歴.get資格取得年月日() != null && 履歴.get資格取得年月日().isValid() && 基準年月.equals(履歴.get資格取得年月日().getYearMonth()))
                    && !(履歴.get資格喪失年月日() != null && 履歴.get資格喪失年月日().isValid() && 基準年月.equals(履歴.get資格喪失年月日().getYearMonth()))) {
                continue;
            }
            if (対象履歴 != null && !is古履歴(履歴, 対象履歴)) {
                continue;
            }
            対象履歴 = 履歴;
        }
        return 対象履歴;
    }

    private boolean is新履歴(HihokenshaDaichoModel 対象, HihokenshaDaichoModel 比較先) {
        return 比較先.get資格取得年月日().isBefore(対象.get資格取得年月日());
    }

    private boolean is古履歴(HihokenshaDaichoModel 対象, HihokenshaDaichoModel 比較先) {
        FlexibleDate 対象最古 = 対象.get資格取得年月日();
        if (対象.get資格喪失年月日() != null && 対象.get資格喪失年月日().isValid() && 対象.get資格喪失年月日().isBefore(対象.get資格取得年月日())) {
            対象最古 = 対象.get資格喪失年月日();
        }
        FlexibleDate 比較先最古 = 比較先.get資格取得年月日();
        if (比較先.get資格喪失年月日() != null && 比較先.get資格喪失年月日().isValid() && 比較先.get資格喪失年月日().isBefore(比較先.get資格取得年月日())) {
            比較先最古 = 比較先.get資格喪失年月日();
        }
        return 対象最古.isBefore(比較先最古);
    }

    private FlexibleDate get前月末日(FlexibleYearMonth 基準年月) {
        return new FlexibleDate(基準年月.getYearValue(), 基準年月.getMonthValue(), 1).minusDay(1);
    }

    private FlexibleDate get当月末日(FlexibleYearMonth 基準年月) {
        return new FlexibleDate(基準年月.getYearValue(), 基準年月.getMonthValue(), 1).plusMonth(1).minusDay(1);
    }
}
