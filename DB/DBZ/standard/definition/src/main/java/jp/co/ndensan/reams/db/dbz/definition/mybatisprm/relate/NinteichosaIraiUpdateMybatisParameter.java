/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査依頼情報更新のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaIraiUpdateMybatisParameter implements IMyBatisParameter {

    private List<RString> 申請書管理番号List;
    private final RString temp_督促日;
    private final RString temp_督促方法;
    private final RString temp_督促メモ;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号List 申請書管理番号List
     * @param temp_督促日 督促日
     * @param temp_督促方法 督促方法
     * @param temp_督促メモ 督促メモ
     */
    public NinteichosaIraiUpdateMybatisParameter(List<RString> 申請書管理番号List,
            RString temp_督促日,
            RString temp_督促方法,
            RString temp_督促メモ
    ) {
        this.申請書管理番号List = 申請書管理番号List;
        this.temp_督促日 = temp_督促日;
        this.temp_督促方法 = temp_督促方法;
        this.temp_督促メモ = temp_督促メモ;
    }

}
