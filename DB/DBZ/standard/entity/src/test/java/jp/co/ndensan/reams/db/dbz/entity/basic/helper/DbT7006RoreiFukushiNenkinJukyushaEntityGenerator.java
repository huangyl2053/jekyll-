/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老齢福祉年金受給者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 賈楽楽
 */
public final class DbT7006RoreiFukushiNenkinJukyushaEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleDate DEFAULT_受給開始日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_受給廃止日 = new FlexibleDate("20140502");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02552"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7006RoreiFukushiNenkinJukyushaEntityGenerator() {
    }

    public static DbT7006RoreiFukushiNenkinJukyushaEntity createDbT7006RoreiFukushiNenkinJukyushaEntity() {
        DbT7006RoreiFukushiNenkinJukyushaEntity entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setJukyuKaishiYMD(DEFAULT_受給開始日);
        entity.setJukyuHaishiYMD(DEFAULT_受給廃止日);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        return entity;
    }
}
