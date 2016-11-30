/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.toushoshotokujohochushutsurenkei;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携_広域のバッチの介護保険所得情報一覧表帳票の帳票出力項目管理Enumです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public enum ShotokuJohoIchiranOrder implements IReportItems {

    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho\".\"kanaMeisho\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"dbT1001HihokenshaDaicho_hihokenshaNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private ShotokuJohoIchiranOrder(RString 項目ID, RString フォームフィールド名,
            RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }
}
