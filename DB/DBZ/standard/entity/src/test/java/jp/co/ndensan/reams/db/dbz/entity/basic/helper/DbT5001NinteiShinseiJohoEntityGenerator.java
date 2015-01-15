/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class DbT5001NinteiShinseiJohoEntityGenerator {

    public static final RString DEFAULT_申請書管理番号 = new RString("1234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20140101102030");
    public static final RString DEFAULT_証記載保険者番号 = new RString("123456");
    public static final RString DEFAULT_支所コード = new RString("001");
    public static final RString DEFAULT_被保険者番号 = new RString("123456");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("123456");
    public static final FlexibleDate DEFAULT_認定申請年月日 = new FlexibleDate("20150102");
    public static final EdabanCode DEFAULT_認定申請枝番コード = new EdabanCode("123");
    public static final Code DEFAULT_認定申請区分申請時コード = new Code("1");
    public static final Code DEFAULT_認定申請区分法令コード = new Code("1");
    public static final Code DEFAULT_認定申請有効区分 = new Code("1");
    public static final RString DEFAULT_要介護申請要支援申請の区分 = new RString("1");
    public static final RString DEFAULT_認定申請理由 = new RString("1");
    public static final Code DEFAULT_前回要介護状態区分コード = new Code("1");
    public static final int DEFAULT_前回認定有効期間 = 1;
    public static final boolean DEFAULT_情報提供への同意有無 = true;
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final Code DEFAULT_認定調査識別コード = new Code("1");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final RString DEFAULT_介護医療機関コード = new RString("1");
    public static final RString DEFAULT_介護医師コード = new RString("1");
    public static final RString DEFAULT_みなし要介護区分コード = new RString("1");
    public static final boolean DEFAULT_認定延期通知発行に対する同意有無 = true;
    public static final boolean DEFAULT_施設入所の有無 = true;
    public static final RString DEFAULT_市町村連絡事項 = new RString("1");
    public static final Code DEFAULT_取下げ区分コード = new Code("1");
    public static final RString DEFAULT_取下げ理由 = new RString("1");
    public static final FlexibleDate DEFAULT_取下げ年月日 = new FlexibleDate("20150102");
    public static final boolean DEFAULT_審査継続区分 = true;
    public static final Code DEFAULT_要介護認定審査会優先振分区分コード = new Code("1");
    public static final FlexibleDate DEFAULT_IF送付年月日 = new FlexibleDate("20150102");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5001NinteiShinseiJohoEntityGenerator() {
    }

    public static DbT5001NinteiShinseiJohoEntity createDbT5001NinteiShinseiJohoEntity() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setNinteiShinseiYMD(DEFAULT_認定申請年月日);
        entity.setNinteiShinseiEdabanCode(DEFAULT_認定申請枝番コード);
        entity.setNinteiShinseiShinseijiKubunCode(DEFAULT_認定申請区分申請時コード);
        entity.setNinteiShinseiHoreiKubunCode(DEFAULT_認定申請区分法令コード);
        entity.setNinteiShinseiYukoKubunCode(DEFAULT_認定申請有効区分);
        entity.setShienShinseiKubun(DEFAULT_要介護申請要支援申請の区分);
        entity.setShinseiRiyu(DEFAULT_認定申請理由);
        entity.setZenYokaigoKubunCode(DEFAULT_前回要介護状態区分コード);
        entity.setZenYukoKikan(DEFAULT_前回認定有効期間);
        entity.setJohoteikyoDouiUmuKubun(DEFAULT_情報提供への同意有無);
        entity.setNinteichosaIraiRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setNinteichosaShikibetsuCode(DEFAULT_認定調査識別コード);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setKaigoIryokikanCode(DEFAULT_介護医療機関コード);
        entity.setKaigoIshiCode(DEFAULT_介護医師コード);
        entity.setMinashiCode(DEFAULT_みなし要介護区分コード);
        entity.setEnkitsuchiDoiUmuKubun(DEFAULT_認定延期通知発行に対する同意有無);
        entity.setShisetsuNyushoUmuKubun(DEFAULT_施設入所の有無);
        entity.setSichosonRenrakuJiko(DEFAULT_市町村連絡事項);
        entity.setTorisageKubunCode(DEFAULT_取下げ区分コード);
        entity.setTorisageRiyu(DEFAULT_取下げ理由);
        entity.setTorisageYMD(DEFAULT_取下げ年月日);
        entity.setShinsaKeizokuKubun(DEFAULT_審査継続区分);
        entity.setShinsakaiYusenWaritsukeKubunCode(DEFAULT_要介護認定審査会優先振分区分コード);
        entity.setIfSofuYMD(DEFAULT_IF送付年月日);
        return entity;
    }
}
