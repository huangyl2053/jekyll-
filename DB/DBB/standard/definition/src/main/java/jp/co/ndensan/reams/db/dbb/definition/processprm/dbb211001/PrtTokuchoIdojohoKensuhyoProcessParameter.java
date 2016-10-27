/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の特徴異動情報件数表の発行のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtTokuchoIdojohoKensuhyoProcessParameter implements IBatchProcessParameter {

    private static final RString ZERO = new RString("0");
    private final RYear 賦課年度;
    private final RString 処理対象月;
    private final RString 件数表帳票ID;
    private final YMDHMS システム日時;
    private final List<RString> 出力条件リスト;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 処理対象月 RString
     * @param 件数表帳票ID RString
     * @param システム日時 YMDHMS
     * @param 出力条件リスト List<RString>
     */
    public PrtTokuchoIdojohoKensuhyoProcessParameter(RYear 賦課年度, RString 処理対象月,
            RString 件数表帳票ID, YMDHMS システム日時, List<RString> 出力条件リスト) {
        this.賦課年度 = 賦課年度;
        if (処理対象月.length() == 1) {
            this.処理対象月 = ZERO.concat(処理対象月);
        } else {
            this.処理対象月 = 処理対象月;
        }
        this.件数表帳票ID = 件数表帳票ID;
        this.システム日時 = システム日時;
        this.出力条件リスト = 出力条件リスト;
    }
}
