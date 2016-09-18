/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd206010.DBD206010TyohyoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
public class DBD206010TyohyoProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private YMDHMS systemTime;
    private FlexibleDate 基準日;
    private RString 事業者名;
    private RString 事業者選択;
    private RString 資格喪失者選択;
    private RString 事業者番号;
    private Long 出力順ID;

    /**
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param orderBy RString
     * @return DBD206010TyohyoMybatisParameter
     */
    public DBD206010TyohyoMybatisParameter toDBD206010TyohyoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey, RString orderBy) {
        this.searchKey = searchKey;
        return new DBD206010TyohyoMybatisParameter(searchKey, orderBy);
    }
}
