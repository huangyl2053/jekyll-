/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併内住特者新旧番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final RString DEFAULT_履歴番号 = new RString("1");
    public static final ShikibetsuCode DEFAULT_識別コード_措置元 = new ShikibetsuCode("000001234567890");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final LasdecCode DEFAULT_市町村コード_措置元 = new LasdecCode("202011");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号_措置元 = new HihokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator() {
    }

    public static DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity() {
        DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = new DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShikibetsuCodeSochiMoto(DEFAULT_識別コード_措置元);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShichosonCodeSochiMoto(DEFAULT_市町村コード_措置元);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setHihokenshaNoSochiMoto(DEFAULT_被保険者番号_措置元);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setShuryoYMD(DEFAULT_終了年月日);
        return entity;
    }
}
