/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護世帯エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7014KaigoSetaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_管理識別区分 = new RString("1");
    public static final FlexibleDate DEFAULT_世帯把握基準年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_世帯員管理連番 = 1;
    public static final ShikibetsuCode DEFAULT_世帯員識別コード = new ShikibetsuCode("000001234567890");
    public static final RString DEFAULT_本人区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7014KaigoSetaiEntityGenerator() {
    }

    public static DbT7014KaigoSetaiEntity createDbT7014KaigoSetaiEntity() {
        DbT7014KaigoSetaiEntity entity = new DbT7014KaigoSetaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKanriShikibetsuKubun(DEFAULT_管理識別区分);
        entity.setSetaiHaakuKijunYMD(DEFAULT_世帯把握基準年月日);
        entity.setSetaiInkanriRenban(DEFAULT_世帯員管理連番);
        entity.setSetaiInshikibetsuCode(DEFAULT_世帯員識別コード);
        entity.setHonninKubun(DEFAULT_本人区分);
        return entity;
    }
}
