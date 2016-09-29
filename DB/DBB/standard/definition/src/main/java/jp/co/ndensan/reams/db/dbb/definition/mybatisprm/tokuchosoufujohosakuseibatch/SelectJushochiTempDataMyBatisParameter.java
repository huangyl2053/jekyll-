/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の住所地特例該当データ抽出する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectJushochiTempDataMyBatisParameter implements IMyBatisParameter {

    private static final int 月_4 = 4;
    private final RYear 賦課年度;
    private final RDateTime 処理日時;
    private final RString 異動事由コード;
    private final int 処理対象月;
    private final boolean is処理対象月が4月;
    private final RString 処理名;
    private final RYear 前年度の賦課年度;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理日時 RDateTime
     * @param 処理対象月 int
     */
    public SelectJushochiTempDataMyBatisParameter(RYear 賦課年度,
            RDateTime 処理日時, int 処理対象月) {
        this.賦課年度 = 賦課年度;
        this.処理日時 = 処理日時;
        this.異動事由コード = ShikakuJutokuTekiyoJiyu.自特例適用.getコード();
        this.処理対象月 = 処理対象月;
        this.is処理対象月が4月 = (処理対象月 == 月_4);
        this.処理名 = ShoriName.特徴異動情報作成.get名称();
        this.前年度の賦課年度 = 賦課年度.minusYear(1);
    }

}
