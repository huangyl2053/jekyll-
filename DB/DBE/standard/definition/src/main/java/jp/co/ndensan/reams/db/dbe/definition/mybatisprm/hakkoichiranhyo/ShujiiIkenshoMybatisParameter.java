/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼履歴一覧のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-150 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShujiiIkenshoMybatisParameter implements IMyBatisParameter {

    private final List<RString> 被保険者番号リスト;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号リスト 被保険者番号リスト
     */
    private ShujiiIkenshoMybatisParameter(List<RString> 被保険者番号リスト) {
        this.被保険者番号リスト = 被保険者番号リスト;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号リスト 被保険者番号リスト
     *
     * @return ShujiiIkenshoMybatisParameter
     */
    public static ShujiiIkenshoMybatisParameter createSelectByKeyParam(List<RString> 被保険者番号リスト) {
        return new ShujiiIkenshoMybatisParameter(被保険者番号リスト);
    }
}
