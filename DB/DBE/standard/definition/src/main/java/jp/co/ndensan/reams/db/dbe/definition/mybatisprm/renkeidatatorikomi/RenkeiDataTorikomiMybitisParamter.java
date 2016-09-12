/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.ShiseiDataParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定申請連携データ取込ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class RenkeiDataTorikomiMybitisParamter implements IMyBatisParameter {

    private final RString 市町村コード;
    private final List<ShiseiDataParameter> 申請情報データリスト;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 申請情報データリスト 申請情報データリスト
     */
    public RenkeiDataTorikomiMybitisParamter(RString 市町村コード,
            List<ShiseiDataParameter> 申請情報データリスト) {
        this.市町村コード = 市町村コード;
        this.申請情報データリスト = 申請情報データリスト;
    }
}
