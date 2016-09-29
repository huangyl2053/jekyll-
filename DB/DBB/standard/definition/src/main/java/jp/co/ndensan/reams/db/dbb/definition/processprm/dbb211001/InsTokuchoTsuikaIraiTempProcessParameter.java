/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTsuikaIraiTempMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の特徴追加依頼データ抽出のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTokuchoTsuikaIraiTempProcessParameter implements IBatchProcessParameter {

    private static final RString 処理対象月_04月 = new RString("04");
    private static final RString 処理対象月_10月 = new RString("10");
    private static final RString 処理対象月_12月 = new RString("12");
    private static final RString ZERO = new RString("0");

    private final RYear 賦課年度;
    private final RString 処理対象月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     */
    public InsTokuchoTsuikaIraiTempProcessParameter(RYear 賦課年度, RString 処理対象月) {
        this.賦課年度 = 賦課年度;
        if (処理対象月.length() == 1) {
            this.処理対象月 = ZERO.concat(処理対象月);
        } else {
            this.処理対象月 = 処理対象月;
        }
    }

    /**
     * SelectTokuchoTsuikaIraiTempMyBatisParameterの取得です。
     *
     * @param 通知内容コード RString
     * @return SelectTokuchoTsuikaIraiTempMyBatisParameter
     */
    public SelectTokuchoTsuikaIraiTempMyBatisParameter toSelectTokuchoTsuikaIraiTempMyBatisParameter(
            RString 通知内容コード) {
        RYearMonth 年月 = new RYearMonth(賦課年度.toDateString().concat(処理対象月));
        RString 処理対象月の4カ月前 = new RString(年月.minusMonth(4).getMonthValue());
        if (処理対象月の4カ月前.length() == 1) {
            return new SelectTokuchoTsuikaIraiTempMyBatisParameter(賦課年度, 賦課年度.minusYear(1),
                    is処理対象月が4月(), 通知内容コード, ZERO.concat(処理対象月の4カ月前));
        }
        return new SelectTokuchoTsuikaIraiTempMyBatisParameter(賦課年度, 賦課年度.minusYear(1),
                is処理対象月が4月(), 通知内容コード, 処理対象月の4カ月前);
    }

    private boolean is処理対象月が4月() {
        return 処理対象月_04月.equals(this.処理対象月);
    }

    /**
     * 処理対象月が10月の場合です。
     *
     * @return boolean
     */
    public boolean is処理対象月が10月() {
        return 処理対象月_10月.equals(this.処理対象月);
    }

    /**
     * 処理対象月が12月の場合です。
     *
     * @return boolean
     */
    public boolean is処理対象月が12月() {
        return 処理対象月_12月.equals(this.処理対象月);
    }
}
