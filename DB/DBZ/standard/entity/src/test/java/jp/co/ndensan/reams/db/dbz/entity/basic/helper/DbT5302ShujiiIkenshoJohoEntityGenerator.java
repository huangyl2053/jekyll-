/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定主治医意見書情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5302ShujiiIkenshoJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final RString DEFAULT_厚労省IF識別コード = new RString("1");
    public static final RString DEFAULT_主治医意見書依頼区分 = new RString("1");
    public static final RString DEFAULT_主治医医療機関コード = new RString("1");
    public static final RString DEFAULT_主治医コード = new RString("1");
    public static final FlexibleDate DEFAULT_主治医意見書受領年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書記入年月日 = new FlexibleDate("20141030");
    public static final Code DEFAULT_意見書作成回数区分 = new Code("1");
    public static final Code DEFAULT_在宅_施設区分 = new Code("1");
    public static final boolean DEFAULT_意見書同意フラグ = false;
    public static final FlexibleDate DEFAULT_最終診療日 = new FlexibleDate("20141030");
    public static final boolean DEFAULT_他科受診の有無 = false;
    public static final boolean DEFAULT_内科受診の有無 = false;
    public static final boolean DEFAULT_精神科受診の有無 = false;
    public static final boolean DEFAULT_外科受診の有無 = false;
    public static final boolean DEFAULT_整形外科受診の有無 = false;
    public static final boolean DEFAULT_脳神経外科の有無 = false;
    public static final boolean DEFAULT_皮膚科受診の有無 = false;
    public static final boolean DEFAULT_泌尿器科受診の有無 = false;
    public static final boolean DEFAULT_婦人科受診の有無 = false;
    public static final boolean DEFAULT_耳鼻咽喉科受診の有無 = false;
    public static final boolean DEFAULT_リハビリテーション科受診の有無 = false;
    public static final boolean DEFAULT_歯科受診の有無 = false;
    public static final boolean DEFAULT_眼科の有無 = false;
    public static final boolean DEFAULT_その他受診科の有無 = false;
    public static final RString DEFAULT_その他受診科名 = new RString("名称");
    public static final RString DEFAULT_意見書メモ = new RString("名称");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5302ShujiiIkenshoJohoEntityGenerator() {
    }

    public static DbT5302ShujiiIkenshoJohoEntity createDbT5302ShujiiIkenshoJohoEntity() {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setIkenshoIraiKubun(DEFAULT_主治医意見書依頼区分);
        entity.setShujiiIryoKikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setIkenshoJuryoYMD(DEFAULT_主治医意見書受領年月日);
        entity.setIkenshoKinyuYMD(DEFAULT_主治医意見書記入年月日);
        entity.setIkenshoSakuseiKaisuKubun(DEFAULT_意見書作成回数区分);
        entity.setZaitakuShisetsuKubun(DEFAULT_在宅_施設区分);
        entity.setIkenshoDoiFlag(DEFAULT_意見書同意フラグ);
        entity.setSaishuShinryoYMD(DEFAULT_最終診療日);
        entity.setExistTakaJushinFlag(DEFAULT_他科受診の有無);
        entity.setExistNaikaJushinFlag(DEFAULT_内科受診の有無);
        entity.setExistSeishinkaJushinFlag(DEFAULT_精神科受診の有無);
        entity.setExistGekaJushinFlag(DEFAULT_外科受診の有無);
        entity.setExistSeikeigekaJushinFlag(DEFAULT_整形外科受診の有無);
        entity.setExistNoshinkeigekaJushinFlag(DEFAULT_脳神経外科の有無);
        entity.setExistHifukaJushinFlag(DEFAULT_皮膚科受診の有無);
        entity.setExistHinyokikaJushinFlag(DEFAULT_泌尿器科受診の有無);
        entity.setExistFujinkaJushinFlag(DEFAULT_婦人科受診の有無);
        entity.setExistJibiinkokaJushinFlag(DEFAULT_耳鼻咽喉科受診の有無);
        entity.setExistRehabilitationkaJushinFlag(DEFAULT_リハビリテーション科受診の有無);
        entity.setExistShikaJushinFlag(DEFAULT_歯科受診の有無);
        entity.setExistGankaJushinFlag(DEFAULT_眼科の有無);
        entity.setExistSonotaJushinkaFlag(DEFAULT_その他受診科の有無);
        entity.setSonotaJushinKaShimei(DEFAULT_その他受診科名);
        entity.setIkenshoMemo(DEFAULT_意見書メモ);
        return entity;
    }
}
