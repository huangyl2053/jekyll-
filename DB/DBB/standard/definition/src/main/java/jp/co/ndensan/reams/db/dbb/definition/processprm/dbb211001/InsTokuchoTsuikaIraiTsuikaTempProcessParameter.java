/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の（特徴追加依頼）追加用データ作成のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTokuchoTsuikaIraiTsuikaTempProcessParameter implements IBatchProcessParameter {

    private static final RString 処理対象月_02月 = new RString("02");
    private static final RString 処理対象月_04月 = new RString("04");
    private static final RString 処理対象月_06月 = new RString("06");
    private static final RString ZERO = new RString("0");
    private final RYear 賦課年度;
    private final RString 処理対象月;
    private YMDHMS システム日時;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     * @param システム日時 YMDHMS
     */
    public InsTokuchoTsuikaIraiTsuikaTempProcessParameter(RYear 賦課年度,
            RString 処理対象月, YMDHMS システム日時) {
        this.賦課年度 = 賦課年度;
        if (処理対象月.length() == 1) {
            this.処理対象月 = ZERO.concat(処理対象月);
        } else {
            this.処理対象月 = 処理対象月;
        }
        this.システム日時 = システム日時;
    }

    /**
     * SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameterの取得です。
     *
     * @return SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter
     */
    public SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter toSelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter() {
        return new SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter(賦課年度, is処理対象月が4月_6月(),
                is処理対象月が2月());
    }

    private boolean is処理対象月が4月_6月() {
        return 処理対象月_04月.equals(this.処理対象月)
                || 処理対象月_06月.equals(this.処理対象月);
    }

    private boolean is処理対象月が2月() {
        return 処理対象月_02月.equals(this.処理対象月);
    }

}
