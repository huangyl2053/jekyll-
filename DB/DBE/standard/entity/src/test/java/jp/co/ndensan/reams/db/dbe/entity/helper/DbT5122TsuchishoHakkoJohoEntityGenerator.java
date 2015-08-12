/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5122TsuchishoHakkoJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final Code DEFAULT_通知区分 = new Code("01");
    public static final RString DEFAULT_通知理由 = new RString("名称");
    public static final FlexibleDate DEFAULT_通知年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_通知開始年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_通知終了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_通知区分期限 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_通知完了年月日 = new FlexibleDate("20141030");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5122TsuchishoHakkoJohoEntityGenerator() {
    }

    public static DbT5122TsuchishoHakkoJohoEntity createDbT5122TsuchishoHakkoJohoEntity() {
        DbT5122TsuchishoHakkoJohoEntity entity = new DbT5122TsuchishoHakkoJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setTsuchiKubun(DEFAULT_通知区分);
        entity.setTsuchiRiyu(DEFAULT_通知理由);
        entity.setTsuchiYMD(DEFAULT_通知年月日);
        entity.setTsuchiKaishiYMD(DEFAULT_通知開始年月日);
        entity.setTsuchiShuryoYMD(DEFAULT_通知終了年月日);
        entity.setTsuchiKubunKigenYMD(DEFAULT_通知区分期限);
        entity.setTsuchiKanryoYMD(DEFAULT_通知完了年月日);
        return entity;
    }
}
