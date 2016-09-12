/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.benmeitoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;

/**
 * 弁明登録明細情報パラメータを作成します。
 *
 * @reamsid_L DBU-1080-020  lijia
 * 
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class BenmeiTorokuMeisaiJohoParameter implements IMyBatisParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final HihokenshaNo genshobunHihokenshaNo;
    private final FlexibleDate shinsaseikyuTodokedeYMD;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param genshobunHihokenshaNo 原書弁被保険者番号
     * @param shinsaseikyuTodokedeYMD 審査請求届出年月日
     */
    private BenmeiTorokuMeisaiJohoParameter(
            ShikibetsuCode shikibetsuCode,
            HihokenshaNo genshobunHihokenshaNo,
            FlexibleDate shinsaseikyuTodokedeYMD) {

        this.shikibetsuCode = shikibetsuCode;
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param genshobunHihokenshaNo 原書弁被保険者番号
     * @param shinsaseikyuTodokedeYMD 審査請求届出年月日
     * @return 検索用のパラメータ
     */
    public static BenmeiTorokuMeisaiJohoParameter createParam_common(
            ShikibetsuCode shikibetsuCode,
            HihokenshaNo genshobunHihokenshaNo,
            FlexibleDate shinsaseikyuTodokedeYMD) {
        return new BenmeiTorokuMeisaiJohoParameter(shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD);
    }
}
