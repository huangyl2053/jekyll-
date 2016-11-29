/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd210010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd210010.DBD210010MybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付制限対象者一覧CSVのprocessパラメータクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD210010ProcessParameter implements IBatchProcessParameter {

    private boolean 全登録者;
    private boolean 二号差止予告登録者;
    private boolean 二号差止登録者;
    private boolean 一号償還予告登録者;
    private boolean 一号償還決定登録者;
    private boolean 一号償還決定登録者_差止中あり;
    private boolean 一号償還決定登録者_保険料控除あり;
    private boolean 一号給付制限登録者;
    private Long 出力順ID;
    private RString 給付制限状態;
    private RString 基準日;

    /**
     * @param 出力順 RString
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return DBD210010MybatisParameter
     */
    public DBD210010MybatisParameter toDBD210010CsvMybatisParameter(RString 出力順, IShikibetsuTaishoPSMSearchKey searchKey) {
        return new DBD210010MybatisParameter(全登録者, 二号差止予告登録者, 二号差止登録者, 一号償還予告登録者,
                一号償還決定登録者, 一号償還決定登録者_差止中あり, 一号償還決定登録者_保険料控除あり, 一号給付制限登録者,
                出力順, 給付制限状態, new FlexibleDate(基準日), searchKey);
    }

    /**
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return DBD210010MybatisParameter
     */
    public DBD210010MybatisParameter toDBD210010MybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new DBD210010MybatisParameter(全登録者, 二号差止予告登録者, 二号差止登録者, 一号償還予告登録者,
                一号償還決定登録者, 一号償還決定登録者_差止中あり, 一号償還決定登録者_保険料控除あり, 一号給付制限登録者,
                RString.EMPTY, 給付制限状態, new FlexibleDate(基準日), searchKey);
    }
}
