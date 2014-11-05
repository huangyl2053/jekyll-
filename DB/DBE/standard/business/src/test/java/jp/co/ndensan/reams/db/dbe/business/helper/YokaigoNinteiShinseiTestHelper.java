/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiRiyu;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
 */
public class YokaigoNinteiShinseiTestHelper {

    private static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("申請書管理番号"));
    private static final YMDHMS 処理日時 = new YMDHMS(new RString("20140808102030"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final ShishoCode 支所コード = ShishoCode.NULL_VALUE;
    private static final KaigoHihokenshaNo 介護被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
    private static final FlexibleDate 認定申請年月日 = FlexibleDate.MIN;
    private static final EdabanCode 枝番コード = new EdabanCode(new RString("001"));
    private static final Code 認定申請区分_申請時 = new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード()));
    private static final Code 認定申請区分_法令 = new Code(new RString("認定申請区分（法令）コード"));
    private static final Code 認定申請有効区分 = new Code(new RString("認定申請有効区分"));
    private static final RString 要支援申請区分 = new RString("1");
    private static final RString 認定申請理由 = new RString("認定申請理由");
    private static final NinteiResultSimple 前回認定結果 = NinteiResultSimple.NONE;
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
    private static final TorisageRiyu 取下げ理由 = new TorisageRiyu(new RString("取下げ理由"));
    private static final FlexibleDate 認定申請取下げ年月日 = FlexibleDate.MAX;
    private static final boolean 審査継続区分 = false;
    private static final NinteiShinseiTorisage 認定申請取下げ = new NinteiShinseiTorisage(
            TorisageKubun.取下げ,
            取下げ理由,
            認定申請取下げ年月日,
            ShinsaKeizokuKubun.toValue(審査継続区分));
    private static final FlexibleDate IF送付年月日 = FlexibleDate.MAX;

    private YokaigoNinteiShinseiTestHelper() {
    }

    public static YokaigoNinteiShinsei create認定申請情報() {
        return new YokaigoNinteiShinsei(
                申請書管理番号,
                処理日時,
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
                new NinteiShinseiRiyu(認定申請理由),
                前回認定結果,
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
                認定申請取下げ, ShinsakaiYusenWaritsukeKubun.優先しない,
                IF送付年月日);

    }
}
