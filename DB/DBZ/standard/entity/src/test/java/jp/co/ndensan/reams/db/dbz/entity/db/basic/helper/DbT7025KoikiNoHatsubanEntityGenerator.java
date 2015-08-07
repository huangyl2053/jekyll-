/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
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
 * 広域番号発番テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7025KoikiNoHatsubanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_コード区分 = new RString("1");
    public static final RString DEFAULT_番号 = new RString("41235");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7025KoikiNoHatsubanEntityGenerator() {
    }

    public static DbT7025KoikiNoHatsubanEntity createDbT7025KoikiNoHatsubanEntity() {
        DbT7025KoikiNoHatsubanEntity entity = new DbT7025KoikiNoHatsubanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setCodeKubun(DEFAULT_コード区分);
        entity.setNo(DEFAULT_番号);
        return entity;
    }
}
