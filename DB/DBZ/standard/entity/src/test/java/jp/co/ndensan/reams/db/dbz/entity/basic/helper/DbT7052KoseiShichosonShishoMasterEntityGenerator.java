/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 構成市町村支所マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7052KoseiShichosonShishoMasterEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode("0001");
    public static final RString DEFAULT_支所名 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7052KoseiShichosonShishoMasterEntityGenerator() {
    }

    public static DbT7052KoseiShichosonShishoMasterEntity createDbT7052KoseiShichosonShishoMasterEntity() {
        DbT7052KoseiShichosonShishoMasterEntity entity = new DbT7052KoseiShichosonShishoMasterEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setShishoMei(DEFAULT_支所名);
        return entity;
    }
}
