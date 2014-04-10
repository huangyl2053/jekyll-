/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbT5001NinteiShinseiJohoEntityを生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public final class NinteiShinseiJohoTestHelper {

    private static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("申請書管理番号"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final RString 支所コード = new RString("支所コード");
    private static final KaigoHihokenshaNo 介護被保険者番号 = new KaigoHihokenshaNo(new RString("被保険者番号"));
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
    private static final FlexibleDate 認定申請年月日 = FlexibleDate.MIN;
    private static final EdabanCode 枝番コード = new EdabanCode(new RString("001"));
    private static final NinteiShinseiKubunShinsei 認定申請区分_申請時 = NinteiShinseiKubunShinsei.新規申請;
    private static final Code 認定申請区分_法令 = new Code(new RString("認定申請区分（法令）コード"));
    private static final Code 認定申請有効区分 = new Code(new RString("認定申請有効区分"));
    private static final RString 要支援申請区分 = new RString("1");
    private static final RString 認定申請理由 = new RString("認定申請理由");
    private static final Code 前回要介護状態区分コード = new Code(new RString("前回要介護状態区分コード"));
    private static final int 前回申請有効期間 = 0;
    private static final boolean 情報提供への同意有無 = true;
    private static final int 認定調査依頼履歴番号 = 1;
    private static final Code 認定調査識別コード = new Code(new RString("1"));
    private static final int 意見書依頼履歴番号 = 2;
    private static final RString 介護医療機関コード = new RString("1234");
    private static final RString 介護医師機関コード = new RString("123");
    private static final RString みなし要介護区分コード = new RString("2");
    private static final boolean 延期通知有無同意 = false;
    private static final boolean 施設入所 = true;
    private static final RString 市町村連絡事項 = new RString("市町村連絡事項");
    private static final Code 取下げ区分コード = new Code(new RString("3"));
    private static final RString 取下げ理由 = new RString("取下げ理由");
    private static final FlexibleDate 認定申請取下げ年月日 = FlexibleDate.MAX;
    private static final boolean 審査継続区分 = false;
    private static final NinteiShinseiTorisage 認定申請取下げ = new NinteiShinseiTorisage(
            TorisageKubun.取下げ,
            取下げ理由,
            認定申請取下げ年月日,
            ShinsaKeizokuKubun.toValue(審査継続区分));

    private NinteiShinseiJohoTestHelper() {
    }

    public static NinteiShinseiJoho create認定申請情報() {
        return new NinteiShinseiJoho(
                申請書管理番号,
                証記載保険者番号,
                支所コード,
                介護被保険者番号,
                識別コード,
                認定申請年月日,
                枝番コード,
                認定申請区分_申請時,
                認定申請区分_法令,
                認定申請有効区分,
                new Code(要支援申請区分),
                認定申請理由,
                前回要介護状態区分コード,
                前回申請有効期間,
                情報提供への同意有無,
                new NinteichosaIraiRirekiNo(認定調査依頼履歴番号),
                // 認定調査識別コード,
                意見書依頼履歴番号,
                // 介護医療機関コード,
                // 介護医師機関コード,
                new Code(みなし要介護区分コード),
                延期通知有無同意,
                施設入所,
                市町村連絡事項,
                認定申請取下げ);
    }

    public static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setShishoCode(支所コード);
        entity.setHihokenshaNo(介護被保険者番号);
        entity.setShikibetsuCode(識別コード);
        entity.setNinteiShinseiYMD(認定申請年月日);
        entity.setNinteiShinseiEdabanCode(枝番コード);
        entity.setNinteiShinseiShinseijiKubunCode(認定申請区分_申請時);
        entity.setNinteiShinseiHoreiKubunCode(認定申請区分_法令);
        entity.setNinteiShinseiYukoKubunCode(認定申請有効区分);
        entity.setShienShinseiKubun(要支援申請区分);
        entity.setShinseiRiyu(認定申請理由);
        entity.setZenYokaigoKubunCode(前回要介護状態区分コード);
        entity.setZenYukoKikan(前回申請有効期間);
        entity.setJohoteikyoDouiUmuKubun(情報提供への同意有無);
        entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        entity.setNinteichosaShikibetsuCode(認定調査識別コード);
        entity.setIkenshoIraiRirekiNo(意見書依頼履歴番号);
        entity.setKaigoIryokikanCode(介護医療機関コード);
        entity.setKaigoIshiCode(介護医師機関コード);
        entity.setMinashiCode(みなし要介護区分コード);
        entity.setEnkitsuchiDoiUmuKubun(延期通知有無同意);
        entity.setShisetsuNyushoUmuKubun(施設入所);
        entity.setSichosonRenrakuJiko(市町村連絡事項);
        entity.setTorisageKubunCode(取下げ区分コード);
        entity.setTorisageRiyu(取下げ理由);
        entity.setTorisageYMD(認定申請取下げ年月日);
        entity.setShinsaKeizokuKubun(審査継続区分);
        return entity;
    }
}
