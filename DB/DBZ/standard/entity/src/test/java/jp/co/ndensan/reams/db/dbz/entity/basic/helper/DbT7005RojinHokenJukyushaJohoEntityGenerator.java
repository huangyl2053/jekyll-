/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健受給者情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7005RojinHokenJukyushaJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("02"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final LasdecCode DEFAULT_老人保健市町村コード = new LasdecCode(new RString("010210"));
    public static final RString DEFAULT_老人保健受給者番号 = new RString("123456");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7005RojinHokenJukyushaJohoEntityGenerator() {
    }

    public static DbT7005RojinHokenJukyushaJohoEntity createDbT7005RojinHokenJukyushaJohoEntity() {
        DbT7005RojinHokenJukyushaJohoEntity entity = new DbT7005RojinHokenJukyushaJohoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRojinHokenShichosonCode(DEFAULT_老人保健市町村コード);
        entity.setRojinHokenJukyushaNo(DEFAULT_老人保健受給者番号);
        return entity;
    }
}
