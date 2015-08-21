/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.viewstate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * viewStateに渡す賦課照会の前履歴取得キーです。<br/>
 * 「前履歴と比較」ボタン押下時に１つ前の履歴のキー情報を保持します。
 *
 * @author n3317 塚田萌
 */
public class MaeRirekiKey implements Serializable {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final Decimal 履歴番号;
    private final SanteiState 算定状態;
    private final AtenaMeisho 氏名;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 算定状態 算定状態
     * @param 氏名 氏名
     */
    public MaeRirekiKey(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号,
            Decimal 履歴番号, SanteiState 算定状態, AtenaMeisho 氏名) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
        this.算定状態 = 算定状態;
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
    public Decimal get履歴番号() {
        return 履歴番号;
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
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return 氏名;
    }
}
