/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8187 久保田 英男
 */
public final class DbT7055GappeiJohoEntityGenerator {

    public static final FlexibleDate DEFAULT_合併年月日 = new FlexibleDate("20140101");
    public static final RString DEFAULT_地域番号 = new RString("01");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("000001");
    public static final RString DEFAULT_合併種類 = new RString("1");
    public static final ShoKisaiHokenshaNo DEFAULT_保険者番号 = new ShoKisaiHokenshaNo("123465");
    public static final FlexibleDate DEFAULT_旧市町村情報付与終了年月日 = new FlexibleDate("20150101");
    public static final FlexibleDate DEFAULT_国保連データ連携開始年月日 = new FlexibleDate("20140102");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7055GappeiJohoEntityGenerator() {
    }

    public static DbT7055GappeiJohoEntity createDbT7055GappeiJohoEntity() {
        DbT7055GappeiJohoEntity entity = new DbT7055GappeiJohoEntity();
        entity.setGappeiYMD(DEFAULT_合併年月日);
        entity.setChiikiNo(DEFAULT_地域番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setGappeiShurui(DEFAULT_合併種類);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setKyuJohoFuyoToYMD(DEFAULT_旧市町村情報付与終了年月日);
        entity.setKokuhorenDataFromYMD(DEFAULT_国保連データ連携開始年月日);
        return entity;
    }

}
