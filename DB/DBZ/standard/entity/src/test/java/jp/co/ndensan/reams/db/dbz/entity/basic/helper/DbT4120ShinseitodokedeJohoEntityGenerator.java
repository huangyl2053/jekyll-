/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8223 朴義一
 */
public final class DbT4120ShinseitodokedeJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("0000000001");
    public static final Code DEFAULT_申請届出代行区分コード = new Code("1");
    public static final AtenaMeisho DEFAULT_申請届出者氏名 = new AtenaMeisho("申請届出者氏名");
    public static final AtenaKanaMeisho DEFAULT_申請届出者氏名カナ = new AtenaKanaMeisho("申請届出者カナ");
    public static final RString DEFAULT_申請届出者続柄コード = new RString("01");
    public static final JigyoshaNo DEFAULT_申請届出代行事業者番号 = new JigyoshaNo("1234567890");
    public static final RString DEFAULT_事業者区分 = new RString("01");
    public static final YubinNo DEFAULT_申請届出者郵便番号 = new YubinNo("123-4567");
    public static final AtenaJusho DEFAULT_申請届出者住所 = new AtenaJusho("申請届出者住所");
    public static final TelNo DEFAULT_申請届出者電話番号 = new TelNo("1234567890");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4120ShinseitodokedeJohoEntityGenerator() {
    }

    public static DbT4120ShinseitodokedeJohoEntity createDbT4120ShinseitodokedeJohoEntity() {
        DbT4120ShinseitodokedeJohoEntity entity = new DbT4120ShinseitodokedeJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShinseiTodokedeDaikoKubunCode(DEFAULT_申請届出代行区分コード);
        entity.setShinseiTodokedeshaShimei(DEFAULT_申請届出者氏名);
        entity.setShinseiTodokedeshaKanaShimei(DEFAULT_申請届出者氏名カナ);
        entity.setShinseiTodokedeshaTsuzukigaraCode(DEFAULT_申請届出者続柄コード);
        entity.setShinseiTodokedeDaikoJigyoshaNo(DEFAULT_申請届出代行事業者番号);
        entity.setJigyoshaKubun(DEFAULT_事業者区分);
        entity.setShinseiTodokedeshaYubinNo(DEFAULT_申請届出者郵便番号);
        entity.setShinseiTodokedeshaJusho(DEFAULT_申請届出者住所);
        entity.setShinseiTodokedeshaTelNo(DEFAULT_申請届出者電話番号);
        return entity;
    }
}
