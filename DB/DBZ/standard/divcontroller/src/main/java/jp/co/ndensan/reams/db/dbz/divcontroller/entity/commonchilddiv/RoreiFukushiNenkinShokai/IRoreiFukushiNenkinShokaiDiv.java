package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0220-010 dongyabin
 */
public interface IRoreiFukushiNenkinShokaiDiv extends ICommonChildDivBaseProperties {
    
    /**
     * 画面を初期化します。
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     */
    public void initialize(ShikibetsuCode shikibetsuCode , HihokenshaNo hihokenshaNo);

}
