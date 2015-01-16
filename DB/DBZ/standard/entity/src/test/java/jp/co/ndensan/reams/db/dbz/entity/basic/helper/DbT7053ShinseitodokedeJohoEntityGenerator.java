/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7053ShinseitodokedeJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RDate DEFAULT_申請届出年月日 = new RDate(2014, 12, 10);
    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo(new RString("2"));
    public static final RString DEFAULT_申請届出種別コード = new RString("1");
    public static final Code DEFAULT_申請届出代行区分コード = new Code("3");
    public static final AtenaMeisho DEFAULT_申請届出者氏名 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_申請届出者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final RString DEFAULT_申請届出者続柄コード = new RString("1");
    public static final JigyoshaNo DEFAULT_申請届出代行事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_事業者区分 = new RString("1");
    public static final YubinNo DEFAULT_申請届出者郵便番号 = new YubinNo(new RString("123-1234"));
    public static final AtenaJusho DEFAULT_申請届出者住所 = new AtenaJusho("申請書記載住所");
    public static final TelNo DEFAULT_申請届出者電話番号 = new TelNo("012-345-6789");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7053ShinseitodokedeJohoEntityGenerator() {
    }

    public static DbT7053ShinseitodokedeJohoEntity createDbT7053ShinseitodokedeJohoEntity() {
        DbT7053ShinseitodokedeJohoEntity entity = new DbT7053ShinseitodokedeJohoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShinseiTodokedeYMD(DEFAULT_申請届出年月日);
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShinseiTodokedeShubetsuCode(DEFAULT_申請届出種別コード);
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
