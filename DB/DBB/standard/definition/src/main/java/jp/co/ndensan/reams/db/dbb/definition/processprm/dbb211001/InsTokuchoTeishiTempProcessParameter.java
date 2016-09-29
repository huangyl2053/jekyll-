/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTeishiDataMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の資格喪失等のデータ抽出のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTokuchoTeishiTempProcessParameter implements IBatchProcessParameter {

    private static final RString 処理対象月_04月 = new RString("04");
    private static final RString 処理対象月_4月 = new RString("4");
    private static final RString 処理対象月_05月 = new RString("05");
    private static final RString 処理対象月_5月 = new RString("5");
    private static final RString 処理対象月_06月 = new RString("06");
    private static final RString 処理対象月_6月 = new RString("6");
    private final RYear 賦課年度;
    private final RString 処理対象月;
    private final YMDHMS システム日時;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     * @param システム日時 YMDHMS
     */
    public InsTokuchoTeishiTempProcessParameter(RYear 賦課年度, RString 処理対象月, YMDHMS システム日時) {
        this.賦課年度 = 賦課年度;
        this.処理対象月 = 処理対象月;
        this.システム日時 = システム日時;
    }

    /**
     * SelectTokuchoTeishiDataMyBatisParameterの取得です。
     *
     * @return SelectTokuChoIraiDataMyBatisParameter
     */
    public SelectTokuchoTeishiDataMyBatisParameter toSelectTokuchoTeishiDataMyBatisParameter() {
        return new SelectTokuchoTeishiDataMyBatisParameter(賦課年度, システム日時.getRDateTime(),
                is処理対象月が4月(), is処理対象月が８月以降());
    }

    private boolean is処理対象月が4月() {
        return 処理対象月_04月.equals(this.処理対象月)
                || 処理対象月_4月.equals(this.処理対象月);
    }

    private boolean is処理対象月が８月以降() {
        return !(処理対象月_04月.equals(this.処理対象月)
                || 処理対象月_4月.equals(this.処理対象月)
                || 処理対象月_05月.equals(this.処理対象月)
                || 処理対象月_5月.equals(this.処理対象月)
                || 処理対象月_06月.equals(this.処理対象月)
                || 処理対象月_6月.equals(this.処理対象月));
    }

}
