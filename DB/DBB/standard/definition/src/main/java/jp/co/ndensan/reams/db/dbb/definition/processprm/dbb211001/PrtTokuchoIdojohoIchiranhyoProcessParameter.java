/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectOutputDataMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の特別徴収異動情報一覧表の発行のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtTokuchoIdojohoIchiranhyoProcessParameter implements IBatchProcessParameter {

    private final RYear 賦課年度;
    private final RString 帳票ID;
    private final YMDHMS システム日時;
    private final RString 出力順ID;
    private final List<RString> 出力条件リスト;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 RYear
     * @param 帳票ID RString
     * @param システム日時 YMDHMS
     * @param 出力順ID RString
     * @param 出力条件リスト List<RString>
     */
    public PrtTokuchoIdojohoIchiranhyoProcessParameter(RYear 賦課年度,
            RString 帳票ID, YMDHMS システム日時, RString 出力順ID, List<RString> 出力条件リスト) {
        this.賦課年度 = 賦課年度;
        this.帳票ID = 帳票ID;
        this.システム日時 = システム日時;
        this.出力順ID = 出力順ID;
        this.出力条件リスト = 出力条件リスト;
    }

    /**
     * SelectOutputDataMyBatisParameterの取得です。
     *
     * @param 出力順 RString
     * @param 処理日 RString
     * @param 科目コード RString
     * @return SelectOutputDataMyBatisParameter
     */
    public SelectOutputDataMyBatisParameter toSelectOutputDataMyBatisParameter(RString 出力順,
            RString 処理日, RString 科目コード) {
        return new SelectOutputDataMyBatisParameter(出力順, 処理日, 科目コード);
    }
}
