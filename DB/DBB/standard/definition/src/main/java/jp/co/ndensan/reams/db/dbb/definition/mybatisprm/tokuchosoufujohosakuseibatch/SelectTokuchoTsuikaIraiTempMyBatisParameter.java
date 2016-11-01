/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特徴追加依頼データ抽出する用MybatisParameterクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectTokuchoTsuikaIraiTempMyBatisParameter implements IMyBatisParameter {

    private final RYear 賦課年度;
    private final RYear 前年度の賦課年度;
    private final boolean is処理対象月が4月;
    private final RString 通知内容コード;
    private final RString 処理対象月の4カ月前;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 前年度の賦課年度 RYear
     * @param is処理対象月が4月 boolean
     * @param 通知内容コード RString
     * @param 処理対象月の4カ月前 RString
     */
    public SelectTokuchoTsuikaIraiTempMyBatisParameter(RYear 賦課年度,
            RYear 前年度の賦課年度, boolean is処理対象月が4月,
            RString 通知内容コード, RString 処理対象月の4カ月前) {
        this.賦課年度 = 賦課年度;
        this.前年度の賦課年度 = 前年度の賦課年度;
        this.is処理対象月が4月 = is処理対象月が4月;
        this.通知内容コード = 通知内容コード;
        this.処理対象月の4カ月前 = 処理対象月の4カ月前;
    }

}
