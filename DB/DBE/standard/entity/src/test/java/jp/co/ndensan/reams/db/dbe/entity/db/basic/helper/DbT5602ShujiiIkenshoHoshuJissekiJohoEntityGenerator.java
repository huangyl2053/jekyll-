/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬実績情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @reamsid_L DBE-9999-011 xuyannan
 */
public final class DbT5602ShujiiIkenshoHoshuJissekiJohoEntityGenerator {

    public static final RString DEFAULT_主治医医療機関コード = new RString("0000000001");
    public static final RString DEFAULT_主治医コード = new RString("00000001");
    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("12345620150600020");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final FlexibleDate DEFAULT_主治医意見書作成依頼年月日 = new FlexibleDate("20150110");
    public static final FlexibleDate DEFAULT_主治医意見書記入年月日 = new FlexibleDate("20150610");
    public static final FlexibleDate DEFAULT_主治医意見書受領年月日 = new FlexibleDate("20150622");
    public static final Code DEFAULT_医師区分コード = new Code("1");
    public static final int DEFAULT_主治医意見書作成料 = 5000;
    public static final int DEFAULT_主治医意見書別途診療費 = 0;
    public static final int DEFAULT_主治医意見書報酬 = 5000;
    public static final FlexibleDate DEFAULT_主治医意見書報酬支払年月日 = new FlexibleDate("20200101");
    public static final RString DEFAULT_主治医意見書報酬支払メモ = new RString("メモ");
    public static final boolean DEFAULT_銀行振込出力フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5602ShujiiIkenshoHoshuJissekiJohoEntityGenerator() {
    }

    public static DbT5602ShujiiIkenshoHoshuJissekiJohoEntity createDbT5602ShujiiIkenshoHoshuJissekiJohoEntity() {
        DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity = new DbT5602ShujiiIkenshoHoshuJissekiJohoEntity();
        entity.setShujiiIryoKikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setIraishoSakuseiIraiYMD(DEFAULT_主治医意見書作成依頼年月日);
        entity.setIkenshoKinyuYMD(DEFAULT_主治医意見書記入年月日);
        entity.setIkenshoJuryoYMD(DEFAULT_主治医意見書受領年月日);
        entity.setIshiKubunCode(DEFAULT_医師区分コード);
        entity.setIkenshoSakuseiryo(DEFAULT_主治医意見書作成料);
        entity.setIkenshoBettoShinryohi(DEFAULT_主治医意見書別途診療費);
        entity.setIkenshoHoshu(DEFAULT_主治医意見書報酬);
        entity.setHoshuShiharaiYMD(DEFAULT_主治医意見書報酬支払年月日);
        entity.setHoshuShiharaiMemo(DEFAULT_主治医意見書報酬支払メモ);
        entity.setGinkoFurikomiShutsuryokuFlag(DEFAULT_銀行振込出力フラグ);
        return entity;
    }
}
