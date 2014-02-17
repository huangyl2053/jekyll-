/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 要介護認定申請記録で作成するクラスと共有するため、今後修正が入る予定 2014年2月末
//現在のテーブルが最新でないため、自動生成だと項目が足りない。今後の修正時にまとめて修正を行い、Nullチェックなどのテストもそこで行う。
public class NinteiShinseiJoho {

    private ShinseishoKanriNo 申請書管理番号;
    private ShichosonCode 市町村コード;
    private RString 支所コード;
    private KaigoHihokenshaNo 介護被保険者番号;
    private ShikibetsuCode 識別コード;
    private RDate 認定申請年月日;
    private EdabanCode 枝番コード;
    private Code 認定申請区分_申請時;
    private Code 認定申請区分_法令;
    private Code 認定申請有効区分;
    private Code 要支援申請区分;
    private RString 認定申請理由;
    private Code 前回要介護状態区分コード;
    private int 前回申請有効期間;
    private boolean 情報提供への同意有無;
    private int 認定調査依頼履歴番号;
    private int 意見書依頼履歴番号;
    private Code みなし要介護区分コード;
    private boolean is延期通知有無同意;
    private boolean is施設入所;
    private RString 市町村連絡事項;
    private NinteiShinseiTorisage 認定申請取下げ;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @param 介護被保険者番号 介護被保険者番号
     * @param 識別コード 識別コード
     * @param 認定申請年月日 認定申請年月日
     * @param 枝番コード 枝番コード
     * @param 認定申請区分_申請時 認定申請区分_申請時
     * @param 認定申請区分_法令 認定申請区分_法令
     * @param 認定申請有効区分 認定申請有効区分
     * @param 要支援申請区分 要支援申請区分
     * @param 認定申請理由 認定申請理由
     * @param 前回要介護状態区分コード 前回要介護状態区分コード
     * @param 前回申請有効期間 前回申請有効期間
     * @param 情報提供への同意有無 情報提供への同意有無
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 意見書依頼履歴番号 意見書依頼履歴番号
     * @param みなし要介護区分コード みなし要介護区分コード
     * @param is延期通知有無同意 is延期通知有無同意
     * @param is施設入所 is施設入所
     * @param 市町村連絡事項 市町村連絡事項
     * @param 認定申請取下げ 認定申請取下げ
     */
    public NinteiShinseiJoho(ShinseishoKanriNo 申請書管理番号, ShichosonCode 市町村コード, RString 支所コード,
            KaigoHihokenshaNo 介護被保険者番号, ShikibetsuCode 識別コード, RDate 認定申請年月日, EdabanCode 枝番コード,
            Code 認定申請区分_申請時, Code 認定申請区分_法令, Code 認定申請有効区分, Code 要支援申請区分, RString 認定申請理由,
            Code 前回要介護状態区分コード, int 前回申請有効期間, boolean 情報提供への同意有無, int 認定調査依頼履歴番号,
            int 意見書依頼履歴番号, Code みなし要介護区分コード, boolean is延期通知有無同意, boolean is施設入所,
            RString 市町村連絡事項, NinteiShinseiTorisage 認定申請取下げ) {
        this.申請書管理番号 = 申請書管理番号;
        this.市町村コード = 市町村コード;
        this.支所コード = 支所コード;
        this.介護被保険者番号 = 介護被保険者番号;
        this.識別コード = 識別コード;
        this.認定申請年月日 = 認定申請年月日;
        this.枝番コード = 枝番コード;
        this.認定申請区分_申請時 = 認定申請区分_申請時;
        this.認定申請区分_法令 = 認定申請区分_法令;
        this.認定申請有効区分 = 認定申請有効区分;
        this.要支援申請区分 = 要支援申請区分;
        this.認定申請理由 = 認定申請理由;
        this.前回要介護状態区分コード = 前回要介護状態区分コード;
        this.前回申請有効期間 = 前回申請有効期間;
        this.情報提供への同意有無 = 情報提供への同意有無;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.意見書依頼履歴番号 = 意見書依頼履歴番号;
        this.みなし要介護区分コード = みなし要介護区分コード;
        this.is延期通知有無同意 = is延期通知有無同意;
        this.is施設入所 = is施設入所;
        this.市町村連絡事項 = 市町村連絡事項;
        this.認定申請取下げ = 認定申請取下げ;
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
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public ShichosonCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return 支所コード;
    }

    /**
     * 介護被保険者番号を返します。
     *
     * @return 介護被保険者番号
     */
    public KaigoHihokenshaNo get介護被保険者番号() {
        return 介護被保険者番号;
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
    public RDate get認定申請年月日() {
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
    public RString get認定申請理由() {
        return 認定申請理由;
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code get前回要介護状態区分コード() {
        return 前回要介護状態区分コード;
    }

    /**
     * 前回申請有効期間を返します。
     *
     * @return 前回申請有効期間
     */
    public int get前回申請有効期間() {
        return 前回申請有効期間;
    }

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
        return is延期通知有無同意;
    }

    /**
     * 施設に入所しているか否かを返します。
     *
     * @return 施設に入所していたならtrue
     */
    public boolean is施設入所() {
        return is施設入所;
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
}
