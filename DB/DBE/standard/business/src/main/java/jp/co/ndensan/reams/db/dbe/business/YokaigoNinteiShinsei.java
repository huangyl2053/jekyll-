/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 要介護認定申請記録で作成するクラスと共有するため、今後修正が入る予定 2014年2月末
//現在のテーブルが最新でないため、自動生成だと項目が足りない。今後の修正時にまとめて修正を行い、Nullチェックなどのテストもそこで行う。
public class YokaigoNinteiShinsei {

    private final ShinseishoKanriNo 申請書管理番号;
    private final YMDHMS 処理日時;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final ShishoCode 支所コード;
    private final KaigoHihokenshaNo 被保番号;
    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 認定申請年月日;
    private final EdabanCode 枝番コード;
    private final Code 認定申請区分_申請時;
    private final Code 認定申請区分_法令;
    private final Code 認定申請有効区分;
    private final Code 要支援申請区分;
    private final NinteiShinseiRiyu 認定申請理由;
    private final NinteiResultSimple 前回認定結果;
    private final boolean 情報提供への同意有無;
    private final NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
    private final int 意見書依頼履歴番号;
    private final Code みなし要介護区分コード;
    private final boolean 延期通知有無同意;
    private final boolean 施設入所;
    private final RString 市町村連絡事項;
    private final NinteiShinseiTorisage 認定申請取下げ;
    private final ShinsakaiYusenWaritsukeKubun 審査会優先割付区分;
    private final FlexibleDate IF送付年月日;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 被保番号 被保番号
     * @param 識別コード 識別コード
     * @param 認定申請年月日 認定申請年月日
     * @param 枝番コード 枝番コード
     * @param 認定申請区分_申請時 認定申請区分_申請時
     * @param 認定申請区分_法令 認定申請区分_法令
     * @param 認定申請有効区分 認定申請有効区分
     * @param 要支援申請区分 要支援申請区分
     * @param 認定申請理由 認定申請理由
     * @param 前回認定結果
     * @param 情報提供への同意有無 情報提供への同意有無
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 意見書依頼履歴番号 意見書依頼履歴番号
     * @param みなし要介護区分コード みなし要介護区分コード
     * @param 延期通知発行同意有無 延期通知同意有無
     * @param is施設入所 施設入所
     * @param 市町村連絡事項 市町村連絡事項
     * @param 認定申請取下げ 認定申請取下げ
     * @param IF送付年月日 IF送付年月日
     */
    public YokaigoNinteiShinsei(ShinseishoKanriNo 申請書管理番号, YMDHMS 処理日時, ShoKisaiHokenshaNo 証記載保険者番号, ShishoCode 支所コード,
            KaigoHihokenshaNo 被保番号, ShikibetsuCode 識別コード, FlexibleDate 認定申請年月日, EdabanCode 枝番コード,
            Code 認定申請区分_申請時, Code 認定申請区分_法令, Code 認定申請有効区分, Code 要支援申請区分, NinteiShinseiRiyu 認定申請理由,
            NinteiResultSimple 前回認定結果, boolean 情報提供への同意有無, NinteichosaIraiRirekiNo 認定調査依頼履歴番号,
            int 意見書依頼履歴番号, Code みなし要介護区分コード, boolean 延期通知発行同意有無, boolean is施設入所,
            RString 市町村連絡事項, NinteiShinseiTorisage 認定申請取下げ, ShinsakaiYusenWaritsukeKubun 審査会優先割付区分, FlexibleDate IF送付年月日) {
        this.申請書管理番号 = 申請書管理番号;
        this.処理日時 = 処理日時;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.被保番号 = 被保番号;
        this.識別コード = 識別コード;
        this.認定申請年月日 = 認定申請年月日;
        this.枝番コード = 枝番コード;
        this.認定申請区分_申請時 = 認定申請区分_申請時;
        this.認定申請区分_法令 = 認定申請区分_法令;
        this.認定申請有効区分 = 認定申請有効区分;
        this.要支援申請区分 = 要支援申請区分;
        this.認定申請理由 = 認定申請理由;
        this.前回認定結果 = 前回認定結果;
        this.情報提供への同意有無 = 情報提供への同意有無;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.意見書依頼履歴番号 = 意見書依頼履歴番号;
        this.みなし要介護区分コード = みなし要介護区分コード;
        this.延期通知有無同意 = 延期通知発行同意有無;
        this.施設入所 = is施設入所;
        this.市町村連絡事項 = 市町村連絡事項;
        this.認定申請取下げ = 認定申請取下げ;
        this.審査会優先割付区分 = 審査会優先割付区分;
        this.IF送付年月日 = IF送付年月日;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return 処理日時;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public NinteichosaIraiRirekiNo get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return 支所コード;
    }

    /**
     * 介護被保険者番号を返します。
     *
     * @return 介護被保険者番号
     */
    public KaigoHihokenshaNo get被保番号() {
        return 被保番号;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コードを返します。
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return 認定申請年月日;
    }

    /**
     * 枝番コードを返します。
     *
     * @return 枝番コードを返します。
     */
    public EdabanCode get枝番コード() {
        return 枝番コード;
    }

    /**
     * 申請時の認定申請区分を返します。
     *
     * @return 申請時の認定申請区分
     */
    public Code get認定申請区分_申請時() {
        return 認定申請区分_申請時;
    }

    /**
     * 法令の認定申請区分を返します。
     *
     * @return 法令の認定申請区分
     */
    public Code get認定申請区分_法令() {
        return 認定申請区分_法令;
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    public Code get認定申請有効区分() {
        return 認定申請有効区分;
    }

    /**
     * 要支援申請区分を返します。
     *
     * @return 要支援申請区分
     */
    public Code get要支援申請区分() {
        return 要支援申請区分;
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    public NinteiShinseiRiyu get認定申請理由() {
        return 認定申請理由;
    }

    /**
     * 前回認定結果を返します。
     *
     * @return 前回認定結果
     */
    public NinteiResultSimple get前回認定結果() {
        return 前回認定結果;
    }

    /**
     * 情報提供に対する同意の有無を判定します。
     *
     * @return 情報提供への同意有無
     */
    public boolean is情報提供への同意有無() {
        return 情報提供への同意有無;
    }

    /**
     * 意見書依頼履歴番号を返します。
     *
     * @return 意見書依頼履歴番号
     */
    public int get意見書依頼履歴番号() {
        return 意見書依頼履歴番号;
    }

    /**
     * みなし要介護区分コードを返します。
     *
     * @return みなし要介護区分コード
     */
    public Code getみなし要介護区分コード() {
        return みなし要介護区分コード;
    }

    /**
     * 延期通知の同意が有るか否かを返します。
     *
     * @return 同意があるならtrue
     */
    public boolean is延期通知有無同意() {
        return 延期通知有無同意;
    }

    /**
     * 施設に入所しているか否かを返します。
     *
     * @return 施設に入所していたならtrue
     */
    public boolean is施設入所() {
        return 施設入所;
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    public RString get市町村連絡事項() {
        return 市町村連絡事項;
    }

    /**
     * 認定申請取下げの情報を返します。
     *
     * @return 認定申請取下げ
     */
    public NinteiShinseiTorisage get認定申請取下げ() {
        return 認定申請取下げ;
    }

    /**
     * 審査会に優先的に割り付けるかどうかの区分を返します。
     *
     * @return 審査会優先割付区分
     */
    public ShinsakaiYusenWaritsukeKubun get審査会優先割付区分() {
        return this.審査会優先割付区分;
    }

    /**
     * IF送付年月日を返します。
     *
     * @return IF送付年月日
     */
    public FlexibleDate getIF送付年月日() {
        return IF送付年月日;
    }
}
