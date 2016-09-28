/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd206010.DBD206010MybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD206010ProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 資格喪失者選択;
    private RString 事業者選択;
    private RString 事業者番号;
    private RString 事業者名;
    private Long 出力順ID;
    private YMDHMS 処理日時;

    /**
     *
     * @param orderBy RString
     * @return DBD206010MybatisParameter
     */
    public DBD206010MybatisParameter toDBD206010MybatisParameter(RString orderBy) {
        return new DBD206010MybatisParameter(基準日, 資格喪失者選択, 事業者選択, 事業者番号, 事業者名,
                orderBy, 処理日時);
    }
}
