/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の資格喪失等データ抽出する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectTokuchoTeishiDataMyBatisParameter implements IMyBatisParameter {

    private final RYear 賦課年度;
    private final RYear 前年度の賦課年度;
    private final RDateTime 処理日時;
    private final boolean is処理対象月が4月;
    private final boolean is処理対象月が8月以降;
    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理日時 RDateTime
     * @param is処理対象月が4月 boolean
     * @param is処理対象月が8月以降 boolean
     */
    public SelectTokuchoTeishiDataMyBatisParameter(RYear 賦課年度,
            RDateTime 処理日時, boolean is処理対象月が4月,
            boolean is処理対象月が8月以降) {
        this.賦課年度 = 賦課年度;
        this.前年度の賦課年度 = 賦課年度.minusYear(1);
        this.処理名 = ShoriName.特徴異動情報作成.get名称();
        this.処理日時 = 処理日時;
        this.is処理対象月が4月 = is処理対象月が4月;
        this.is処理対象月が8月以降 = is処理対象月が8月以降;
    }

}
