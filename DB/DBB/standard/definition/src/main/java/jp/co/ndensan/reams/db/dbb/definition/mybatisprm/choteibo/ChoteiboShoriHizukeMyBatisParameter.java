/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調定簿作成処理日付のMyBatisパラメータ
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboShoriHizukeMyBatisParameter implements IMyBatisParameter {

    private final SubGyomuCode subGyomuCode;
    private final RString shoriName;
    private final FlexibleYear nendo;

    /**
     * コンストラクタです。
     *
     * @param subGyomuCode 業務コード
     * @param shoriName 処理ネーム
     * @param nendo 年度
     */
    public ChoteiboShoriHizukeMyBatisParameter(
            SubGyomuCode subGyomuCode,
            RString shoriName,
            FlexibleYear nendo) {
        this.subGyomuCode = subGyomuCode;
        this.shoriName = shoriName;
        this.nendo = nendo;
    }
}
