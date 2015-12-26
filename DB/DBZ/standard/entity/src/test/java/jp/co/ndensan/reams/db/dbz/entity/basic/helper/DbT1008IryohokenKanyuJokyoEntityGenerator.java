/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険医療保険加入状況エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1008IryohokenKanyuJokyoEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("0000000001");
    public static final int DEFAULT_履歴番号 = 1;
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1234567890");
    public static final RString DEFAULT_医療保険種別コード = new RString("01");
    public static final RString DEFAULT_医療保険者番号 = new RString("あいうえ");
    public static final RString DEFAULT_医療保険者名称 = new RString("あいうえおさしす");
    public static final RString DEFAULT_医療保険記号番号 = new RString("あうお");
    public static final FlexibleDate DEFAULT_医療保険加入年月日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_医療保険脱退年月日 = new FlexibleDate("20141216");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1008IryohokenKanyuJokyoEntityGenerator() {
    }

    public static DbT1008IryohokenKanyuJokyoEntity createDbT1008IryohokenKanyuJokyoEntity() {
        DbT1008IryohokenKanyuJokyoEntity entity = new DbT1008IryohokenKanyuJokyoEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setIryoHokenShubetsuCode(DEFAULT_医療保険種別コード);
        entity.setIryoHokenshaNo(DEFAULT_医療保険者番号);
        entity.setIryoHokenshaMeisho(DEFAULT_医療保険者名称);
        entity.setIryoHokenKigoNo(DEFAULT_医療保険記号番号);
        entity.setIryoHokenKanyuYMD(DEFAULT_医療保険加入年月日);
        entity.setIryoHokenDattaiYMD(DEFAULT_医療保険脱退年月日);
        return entity;
    }
}
