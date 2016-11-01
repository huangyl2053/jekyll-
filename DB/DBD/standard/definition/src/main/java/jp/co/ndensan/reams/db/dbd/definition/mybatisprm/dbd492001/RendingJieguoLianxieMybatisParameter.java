/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd492001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果連携データ取込MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RendingJieguoLianxieMybatisParameter implements IMyBatisParameter {

    private final RString 被保番号;
    private final RString 保険者番号;
    private final RString 認定申請日;
    private final RString 申請区分_申請時;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;

    /**
     * コンストラクタです。
     *
     * @param データリストList データリスト
     */
    public RendingJieguoLianxieMybatisParameter(List<RString> データリストList) {
        this.保険者番号 = データリストList.get(INDEX_0);
        this.被保番号 = データリストList.get(INDEX_1);
        this.認定申請日 = データリストList.get(INDEX_2);
        this.申請区分_申請時 = データリストList.get(INDEX_3);
    }
}
