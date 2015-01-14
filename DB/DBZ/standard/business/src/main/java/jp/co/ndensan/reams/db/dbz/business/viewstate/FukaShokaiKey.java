/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.viewstate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * viewStateに渡す賦課照会キーです。<br/>
 * 履歴を選択時にその履歴のキー情報を保持し、画面遷移後にキー情報を元にデータを取得します。
 *
 * @author n3317 塚田萌
 */
public class FukaShokaiKey implements Serializable {

    private final ChoteiNendo 調定年度;
    private final FukaNendo 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final RDateTime 処理日時;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 賦課期日;
    private final RString 更正月;
    private final RDateTime 更正日時;
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
     * @param 処理日時 処理日時
     * @param 被保険者番号 被保険者番号
     * @param 賦課期日 賦課期日
     * @param 更正月 更正月
     * @param 更正日時 更正日時
     * @param 算定状態 算定状態
     * @param 減免あり 減免あり
     * @param 徴収猶予あり 徴収猶予あり
     * @param 氏名 氏名
     */
    public FukaShokaiKey(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号,
            RDateTime 処理日時, HihokenshaNo 被保険者番号, FlexibleDate 賦課期日,
            RString 更正月, RDateTime 更正日時, SanteiState 算定状態,
            boolean 減免あり, boolean 徴収猶予あり, AtenaMeisho 氏名) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.処理日時 = 処理日時;
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
    public ChoteiNendo get調定年度() {
        return 調定年度;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FukaNendo get賦課年度() {
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return 処理日時;
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
    public RDateTime get更正日時() {
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
    public AtenaMeisho 氏名() {
        return 氏名;
    }
}
