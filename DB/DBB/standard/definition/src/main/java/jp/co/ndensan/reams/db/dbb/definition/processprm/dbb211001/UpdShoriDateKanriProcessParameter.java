/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.UpdateTableMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の処理日付管理テーブル更新のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdShoriDateKanriProcessParameter implements IBatchProcessParameter {

    private final RYear 賦課年度;
    private final YMDHMS システム日時;
    private final boolean 処理対象月が1月;
    private final boolean 処理対象月が2月;
    private final boolean 処理対象月が3月;
    private final boolean 処理対象月が4月;
    private final boolean 処理対象月が5月;
    private final boolean 処理対象月が6月;
    private final boolean 処理対象月が7月;
    private final boolean 処理対象月が8月;
    private final boolean 処理対象月が9月;
    private final boolean 処理対象月が10月;
    private final boolean 処理対象月が11月;
    private final boolean 処理対象月が12月;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param システム日時 YMDHMS
     * @param 処理対象月が1月 boolean
     * @param 処理対象月が2月 boolean
     * @param 処理対象月が3月 boolean
     * @param 処理対象月が4月 boolean
     * @param 処理対象月が5月 boolean
     * @param 処理対象月が6月 boolean
     * @param 処理対象月が7月 boolean
     * @param 処理対象月が8月 boolean
     * @param 処理対象月が9月 boolean
     * @param 処理対象月が10月 boolean
     * @param 処理対象月が11月 boolean
     * @param 処理対象月が12月 boolean
     */
    public UpdShoriDateKanriProcessParameter(
            RYear 賦課年度, YMDHMS システム日時,
            boolean 処理対象月が1月, boolean 処理対象月が2月,
            boolean 処理対象月が3月, boolean 処理対象月が4月,
            boolean 処理対象月が5月, boolean 処理対象月が6月,
            boolean 処理対象月が7月, boolean 処理対象月が8月,
            boolean 処理対象月が9月, boolean 処理対象月が10月,
            boolean 処理対象月が11月, boolean 処理対象月が12月) {
        this.賦課年度 = 賦課年度;
        this.システム日時 = システム日時;
        this.処理対象月が1月 = 処理対象月が1月;
        this.処理対象月が2月 = 処理対象月が2月;
        this.処理対象月が3月 = 処理対象月が3月;
        this.処理対象月が4月 = 処理対象月が4月;
        this.処理対象月が5月 = 処理対象月が5月;
        this.処理対象月が6月 = 処理対象月が6月;
        this.処理対象月が7月 = 処理対象月が7月;
        this.処理対象月が8月 = 処理対象月が8月;
        this.処理対象月が9月 = 処理対象月が9月;
        this.処理対象月が10月 = 処理対象月が10月;
        this.処理対象月が11月 = 処理対象月が11月;
        this.処理対象月が12月 = 処理対象月が12月;
    }

    /**
     * UpdateTableMyBatisParameterの取得です。
     *
     * @param 処理名 RString
     * @param 年度内連番 RString
     * @return UpdateTableMyBatisParameter
     */
    public UpdateTableMyBatisParameter toUpdateTableMyBatisParameter(
            RString 処理名, RString 年度内連番) {
        return new UpdateTableMyBatisParameter(システム日時, 処理名, 賦課年度, 年度内連番);
    }
}
