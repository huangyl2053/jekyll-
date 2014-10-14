/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果(簡易版)です。
 *
 * @author N3327 三浦 凌
 */
public class NinteiResultSimple {

    /**
     * 認定結果がないことを表すNinteiResultSimpleのインスタンスです。
     */
    public static final NinteiResultSimple NONE;

    static {
        NONE = new NinteiResultSimple(
                new YokaigoJotaiKubun(new Code(RString.EMPTY), RString.EMPTY, RString.EMPTY),
                new NinteiYukoKikan(FlexibleDate.EMPTY, new NinteiYukoKikanTsukisu(0), FlexibleDate.EMPTY)
        );
    }

    private final YokaigoJotaiKubun yokaigoJotaiKubun;
    private final NinteiYukoKikan ninteiYukoKikan;

    /**
     * コンストラクタ
     *
     * @param 要介護度 要介護度
     * @param 認定有効期間 認定有効期間
     */
    public NinteiResultSimple(YokaigoJotaiKubun 要介護度, NinteiYukoKikan 認定有効期間) {
        this.yokaigoJotaiKubun = 要介護度;
        this.ninteiYukoKikan = 認定有効期間;
    }

    /**
     * 要介護度を返します。
     *
     * @return 要介護度
     */
    public YokaigoJotaiKubun get要介護度() {
        return this.yokaigoJotaiKubun;
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public NinteiYukoKikan get認定有効期間() {
        return this.ninteiYukoKikan;
    }
}
