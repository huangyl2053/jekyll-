/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5301ShujiiIkenshoIraiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("01");
    public static final RString DEFAULT_主治医医療機関コード = new RString("名称");
    public static final RString DEFAULT_主治医コード = new RString("名称");
    public static final RString DEFAULT_主治医意見書依頼区分 = new RString("2");
    public static final int DEFAULT_主治医意見書作成回数 = 1;
    public static final Code DEFAULT_医師区分コード = new Code("01");
    public static final FlexibleDate DEFAULT_主治医意見書作成依頼年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書作成期限年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_依頼書出力年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_意見書出力年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_請求書出力年月日 = new FlexibleDate("20141030");
    public static final Code DEFAULT_作成料請求区分 = new Code("01");
    public static final FlexibleDate DEFAULT_主治医意見書作成督促年月日 = new FlexibleDate("20141030");
    public static final RString DEFAULT_主治医意見書作成督促方法 = new RString("9");
    public static final int DEFAULT_主治医意見書作成督促回数 = 1;
    public static final RString DEFAULT_主治医意見書作成督促メモ = new RString("名称");
    public static final boolean DEFAULT_認定情報提供希望フラグ = false;
    public static final FlexibleDate DEFAULT_認定状況提供年月日 = new FlexibleDate("20141030");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5301ShujiiIkenshoIraiJohoEntityGenerator() {
    }

    public static DbT5301ShujiiIkenshoIraiJohoEntity createDbT5301ShujiiIkenshoIraiJohoEntity() {
        DbT5301ShujiiIkenshoIraiJohoEntity entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setIkenshoIraiKubun(DEFAULT_主治医意見書依頼区分);
        entity.setIkenshoIraiKaisu(DEFAULT_主治医意見書作成回数);
        entity.setIshiKubunCode(DEFAULT_医師区分コード);
        entity.setIkenshoSakuseiIraiYMD(DEFAULT_主治医意見書作成依頼年月日);
        entity.setIkenshoSakuseiKigenYMD(DEFAULT_主治医意見書作成期限年月日);
        entity.setIraishoShutsuryokuYMD(DEFAULT_依頼書出力年月日);
        entity.setIkenshoShutsuryokuYMD(DEFAULT_意見書出力年月日);
        entity.setSeikyushoShutsuryokuYMD(DEFAULT_請求書出力年月日);
        entity.setSakuseiryoSeikyuKubun(DEFAULT_作成料請求区分);
        entity.setIkenshoSakuseiTokusokuYMD(DEFAULT_主治医意見書作成督促年月日);
        entity.setIkenshoSakuseiTokusokuHoho(DEFAULT_主治医意見書作成督促方法);
        entity.setIkenshoTokusokuKaisu(DEFAULT_主治医意見書作成督促回数);
        entity.setIkenshoTokusokuMemo(DEFAULT_主治医意見書作成督促メモ);
        entity.setNinteiJohoTeikyoKiboFlag(DEFAULT_認定情報提供希望フラグ);
        entity.setNinteiJohoTeikyoYMD(DEFAULT_認定状況提供年月日);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
