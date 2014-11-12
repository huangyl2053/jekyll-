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
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.IHihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
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

    private final List<IHihokenshaDaicho> 被保険者台帳List;

    /**
     * コンストラクタです。
     *
     * @param 被保険者台帳List 被保険者台帳List（処理対象の被保険者一人分）
     * @throws NullPointerException 引数がnullの場合
     */
    public KyuShichosonShikaku(List<IHihokenshaDaicho> 被保険者台帳List) throws NullPointerException {
        this.被保険者台帳List = requireNonNull(被保険者台帳List, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳List"));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 「資格取得日≦基準年月日」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年月日 基準年月日
     * @return 被保険者情報
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public IOptional<IHihokenshaDaicho> get最新旧市町村被保険者情報(FlexibleDate 基準年月日)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        if (!基準年月日.isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年月日").evaluate());
        }

        return DbOptional.ofNullable(get最新履歴(基準年月日));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 基準年度の各月（4月から3月）の基準日を基準年月日とし、各月毎、「資格取得日≦基準年月日」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年度 基準年度
     * @param 基準日 基準日
     * @return 被保険者情報List（12ヶ月分）
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public IItemList<IHihokenshaDaicho> get月別最新旧市町村被保険者情報(FlexibleYear 基準年度, int 基準日)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年度, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年度"));
        if (!new FlexibleDate(基準年度.getYearValue(), 1, 基準日).isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年度または基準日").evaluate());
        }

        FlexibleDate 開始日 = new FlexibleDate(基準年度.getYearValue(), 4, 1);
        FlexibleDate 終了日 = get当月末日(開始日.plusMonth(11).getYearMonth());
        Range<FlexibleDate> 対象期間 = new Range<>(開始日, 終了日);

        Map<FlexibleYearMonth, IHihokenshaDaicho> map = new TreeMap<>();
        for (IHihokenshaDaicho 履歴 : 被保険者台帳List) {
            FlexibleDate 取得日 = 履歴.get資格取得日();
            if (対象期間.between(取得日) && 取得日.getDayValue() <= 基準日) {
                IHihokenshaDaicho old履歴 = map.get(取得日.getYearMonth());
                if (old履歴 == null || is新履歴(履歴, old履歴)) {
                    map.put(取得日.getYearMonth(), 履歴);
                }
            }
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
    public IOptional<IHihokenshaDaicho> get最古旧市町村被保険者情報() {
        return DbOptional.ofNullable(get最古履歴(null));
    }

    /**
     * 被保険者台帳の中から旧市町村の被保険者情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * ＜月初月末区分が「指定無」、または「月初」の場合＞<br/>
     * 「資格取得日＝基準年月」、または「資格喪失日＝基準年月」の情報の内、最古の情報を対象とします。<br/>
     * なお、該当する情報が存在しない場合は、「資格取得日＜基準年月」の情報の内、最新の情報を対象とします。<br/>
     * ＜月初月末区分が「月末」の場合＞<br/>
     * 「資格取得日≦基準年月」の情報の内、最新の情報を対象とします。
     *
     * @param 基準年月 基準年月
     * @param 月初月末区分 月初月末区分
     * @return 被保険者情報
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が不正な場合
     */
    public IOptional<IHihokenshaDaicho> get旧市町村被保険者情報By月初月末指定(FlexibleYearMonth 基準年月, GesshoGetsumatsuKubun 月初月末区分)
            throws NullPointerException, IllegalArgumentException {

        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        if (!基準年月.isValid()) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("基準年月").evaluate());
        }

        IHihokenshaDaicho 対象履歴 = null;
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

        return DbOptional.ofNullable(対象履歴);
    }

    /**
     * 被保険者情報を編集して返します。<br/>
     * <br/>
     * 1.旧市町村コードと広住特措置元市町村コードがEMPTYの場合、旧市町村コードに市町村コードを設定します。<br/>
     * 2.旧市町村コードがEMPTY、かつ広住特措置元市町村コードがEMPTY以外の場合、旧市町村コードに広住特措置元市町村コードを設定します。<br/>
     * 3.広住特措置元市町村コードがEMPTY以外の場合、市町村コードに広住特措置元市町村コードを設定します。<br/>
     * 4.資格喪失日がEMPTYの場合、資格喪失日に"99999999"を設定する。
     *
     * @return 編集後の被保険者情報
     */
    public IItemList<IHihokenshaDaicho> edit旧市町村被保険者情報() {
        List<IHihokenshaDaicho> edited履歴List = new ArrayList<>();
        for (IHihokenshaDaicho 編集元 : 被保険者台帳List) {
            HihokenshaDaichoModel 対象履歴 = 編集元.toModel();
            if (編集元.get旧市町村コード().isEmpty() && 編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set旧市町村コード(編集元.get市町村コード());
            }
            if (編集元.get旧市町村コード().isEmpty() && !編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set旧市町村コード(編集元.get広住特措置元市町村コード());
            }
            if (!編集元.get広住特措置元市町村コード().isEmpty()) {
                対象履歴.set市町村コード(編集元.get広住特措置元市町村コード());
            }
            if (編集元.get資格喪失日().isEmpty()) {
                対象履歴.set資格喪失日(new FlexibleDate("99999999"));
            }
            edited履歴List.add(対象履歴);
        }
        return ItemList.of(edited履歴List);
    }

    private IHihokenshaDaicho get最新履歴(FlexibleDate 基準年月日) {
        IHihokenshaDaicho 対象履歴 = null;
        for (IHihokenshaDaicho 履歴 : 被保険者台帳List) {
            if (基準年月日 == null || 履歴.get資格取得日().isBeforeOrEquals(基準年月日)) {
                if (対象履歴 == null || is新履歴(履歴, 対象履歴)) {
                    対象履歴 = 履歴;
                }
            }
        }
        return 対象履歴;
    }

    private IHihokenshaDaicho get最古履歴(FlexibleYearMonth 基準年月) {
        IHihokenshaDaicho 対象履歴 = null;
        for (IHihokenshaDaicho 履歴 : 被保険者台帳List) {
            if (基準年月 == null
                    || (履歴.get資格取得日() != null && 履歴.get資格取得日().isValid() && 基準年月.equals(履歴.get資格取得日().getYearMonth()))
                    || (履歴.get資格喪失日() != null && 履歴.get資格喪失日().isValid() && 基準年月.equals(履歴.get資格喪失日().getYearMonth()))) {
                if (対象履歴 == null || is古履歴(履歴, 対象履歴)) {
                    対象履歴 = 履歴;
                }
            }
        }
        return 対象履歴;
    }

    private boolean is新履歴(IHihokenshaDaicho 対象, IHihokenshaDaicho 比較先) {
        return 比較先.get資格取得日().isBefore(対象.get資格取得日());
    }

    private boolean is古履歴(IHihokenshaDaicho 対象, IHihokenshaDaicho 比較先) {
        FlexibleDate 対象最古 = 対象.get資格取得日();
        if (対象.get資格喪失日() != null && 対象.get資格喪失日().isValid() && 対象.get資格喪失日().isBefore(対象.get資格取得日())) {
            対象最古 = 対象.get資格喪失日();
        }
        FlexibleDate 比較先最古 = 比較先.get資格取得日();
        if (比較先.get資格喪失日() != null && 比較先.get資格喪失日().isValid() && 比較先.get資格喪失日().isBefore(比較先.get資格取得日())) {
            比較先最古 = 比較先.get資格喪失日();
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
