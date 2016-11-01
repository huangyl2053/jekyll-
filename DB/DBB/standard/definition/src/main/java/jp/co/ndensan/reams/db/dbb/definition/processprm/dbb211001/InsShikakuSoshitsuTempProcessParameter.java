/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectShikakuSoshitsuMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の（資格喪失等）追加用データ作成のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsShikakuSoshitsuTempProcessParameter implements IBatchProcessParameter {

    private static final RString 処理対象月_04月 = new RString("04");
    private static final RString 処理対象月_05月 = new RString("05");
    private static final RString 処理対象月_06月 = new RString("06");
    private static final RString ZERO = new RString("0");
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
    public InsShikakuSoshitsuTempProcessParameter(RYear 賦課年度, RString 処理対象月, YMDHMS システム日時) {
        this.賦課年度 = 賦課年度;
        if (処理対象月.length() == 1) {
            this.処理対象月 = ZERO.concat(処理対象月);
        } else {
            this.処理対象月 = 処理対象月;
        }
        this.システム日時 = システム日時;
    }

    /**
     * SelectShikakuSoshitsuMyBatisParameterの取得です。
     *
     * @param is年金特徴回付情報が取得できない boolean
     * @param 通知内容コードList List<RString>
     * @return SelectShikakuSoshitsuMyBatisParameter
     */
    public SelectShikakuSoshitsuMyBatisParameter toSelectShikakuSoshitsuMyBatisParameter(
            boolean is年金特徴回付情報が取得できない, List<RString> 通知内容コードList) {
        return new SelectShikakuSoshitsuMyBatisParameter(is処理対象月が８月以降(),
                is年金特徴回付情報が取得できない, 通知内容コードList);
    }

    /**
     * 処理対象月が5月、6月の場合です。
     *
     * @return boolean
     */
    public boolean is処理対象月が5月_6月() {
        return 処理対象月_05月.equals(this.処理対象月)
                || 処理対象月_06月.equals(this.処理対象月);
    }

    private boolean is処理対象月が８月以降() {
        return !(処理対象月_04月.equals(this.処理対象月)
                || 処理対象月_05月.equals(this.処理対象月)
                || 処理対象月_06月.equals(this.処理対象月));
    }
}
