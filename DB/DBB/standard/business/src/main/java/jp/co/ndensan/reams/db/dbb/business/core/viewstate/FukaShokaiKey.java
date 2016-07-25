/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.viewstate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * viewStateに渡す賦課照会キーです。<br/>
 * 履歴を選択時にその履歴のキー情報を保持し、画面遷移後にキー情報を元にデータを取得します。
 *
 * @author n3317 塚田萌
 */
public class FukaShokaiKey implements Serializable {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final int 履歴番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 賦課期日;
    private final RString 更正月;
    private final YMDHMS 更正日時;
    private final SanteiState 算定状態;
    private final boolean 減免あり;
    private final boolean 徴収猶予あり;
    private final AtenaMeisho 氏名;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     * @param 賦課期日 賦課期日
     * @param 更正月 更正月
     * @param 更正日時 更正日時
     * @param 算定状態 算定状態
     * @param 減免あり 減免あり
     * @param 徴収猶予あり 徴収猶予あり
     * @param 氏名 氏名
     */
    public FukaShokaiKey(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号,
            int 履歴番号, HihokenshaNo 被保険者番号, FlexibleDate 賦課期日,
            RString 更正月, YMDHMS 更正日時, SanteiState 算定状態,
            boolean 減免あり, boolean 徴収猶予あり, AtenaMeisho 氏名) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
        this.被保険者番号 = 被保険者番号;
        this.賦課期日 = 賦課期日;
        this.更正月 = 更正月;
        this.更正日時 = 更正日時;
        this.算定状態 = 算定状態;
        this.減免あり = 減免あり;
        this.徴収猶予あり = 徴収猶予あり;
        this.氏名 = 氏名;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return 調定年度;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return 通知書番号;
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return 履歴番号;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 賦課期日を返します。
     *
     * @return 賦課期日
     */
    public FlexibleDate get賦課期日() {
        return 賦課期日;
    }

    /**
     * 更正月を返します。
     *
     * @return 更正月
     */
    public RString get更正月() {
        return 更正月;
    }

    /**
     * 更正日時を返します。
     *
     * @return 更正日時
     */
    public YMDHMS get更正日時() {
        return 更正日時;
    }

    /**
     * 算定状態を返します。
     *
     * @return 算定状態
     */
    public SanteiState get算定状態() {
        return 算定状態;
    }

    /**
     * 減免ありの場合はtrue、なしの場合はfalseを返します。
     *
     * @return 減免ありの場合はtrue、なしの場合はfalse
     */
    public boolean is減免あり() {
        return 減免あり;
    }

    /**
     * 徴収猶予ありの場合はtrue、なしの場合はfalseを返します。
     *
     * @return 徴収猶予ありの場合はtrue、なしの場合はfalse
     */
    public boolean is徴収猶予あり() {
        return 徴収猶予あり;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return 氏名;
    }

    /**
     * 指定の全要素({@link Items})を検索に用いることができる値として保持する場合、{@code true}を返します。
     *
     * @param e1 要素1(必須)
     * @param any 要素2～n(任意)
     * @return 指定の要素が全て存在する場合、{@code true}.以外、{@code false}
     */
    public boolean hasAll(Items e1, Items... any) {
        List<Items> items = new ArrayList<>();
        items.add(e1);
        items.addAll(Arrays.asList(any));
        for (Items item : items) {
            if (!has(item)) {
                return false;
            }
        }
        if (items.contains(Items.調定年度) && items.contains(Items.賦課年度)) {
            return get賦課年度().isBeforeOrEquals(get調定年度());
        }
        return true;
    }

    private boolean has(Items item) {
        switch (item) {
            case 調定年度:
                return isValid(this.get調定年度());
            case 賦課年度:
                return isValid(this.get賦課年度());
            case 通知書番号:
                return isValid(this.get通知書番号());
            case 履歴番号:
                return isValid履歴番号(this.get履歴番号());
            case 被保険者番号:
                return isValid(this.get被保険者番号());
            default:
                return false;
        }
    }

    private static boolean isValid(FlexibleYear year) {
        return year != null && year.isValid();
    }

    private static boolean isValid(TsuchishoNo value) {
        return value != null && !value.isEmpty();
    }

    private static boolean isValid(HihokenshaNo value) {
        return value != null && !value.isEmpty();
    }

    private static boolean isValid履歴番号(int value) {
        return 0 <= value;
    }

    /**
     * {@link FukaShokaiKey}が保持する値です。
     */
    public static enum Items {

        /**
         * 賦課年度
         */
        賦課年度,
        /**
         * 調定年度
         */
        調定年度,
        /**
         * 通知書番号
         */
        通知書番号,
        /**
         * 履歴番号
         */
        履歴番号,
        /**
         * 被保険者番号
         */
        被保険者番号;
    }
}
