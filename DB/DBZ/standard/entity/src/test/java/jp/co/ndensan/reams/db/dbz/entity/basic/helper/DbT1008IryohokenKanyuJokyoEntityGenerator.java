/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険医療保険加入状況エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1008IryohokenKanyuJokyoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RString DEFAULT_医療保険種別コード = new RString("1");
    public static final RString DEFAULT_医療保険者番号 = new RString("1");
    public static final RString DEFAULT_医療保険者名称 = new RString("1");
    public static final RString DEFAULT_医療保険記号番号 = new RString("1");
    public static final FlexibleDate DEFAULT_医療保険加入年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_医療保険脱退年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1008IryohokenKanyuJokyoEntityGenerator() {
    }

    public static DbT1008IryohokenKanyuJokyoEntity createDbT1008IryohokenKanyuJokyoEntity() {
        DbT1008IryohokenKanyuJokyoEntity entity = new DbT1008IryohokenKanyuJokyoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
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
