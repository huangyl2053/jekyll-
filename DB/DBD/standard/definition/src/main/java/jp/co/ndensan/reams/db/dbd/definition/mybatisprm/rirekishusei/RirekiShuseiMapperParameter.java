/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.rirekishusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特殊修正のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class RirekiShuseiMapperParameter {

    private final LasdecCode 市町村コード;
    private final HihokenshaNo 被保険者番号;
    private final RString 履歴番号;
    private final RString 枝番;
    private final Code 受給申請事由;
    private final int update回数;

    private final RString 履歴番号Upd;
    private final int update回数Upd;
    private final RDateTime 最終Update日時;
    private final RString ログインid;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @param update回数 update回数
     * @param 履歴番号Upd 履歴番号Upd
     * @param update回数Upd update回数Upd
     * @param 最終Update日時 最終Update日時
     * @param ログインid ログインid
     */
    private RirekiShuseiMapperParameter(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号, RString 履歴番号,
            RString 枝番, Code 受給申請事由, int update回数,
            RString 履歴番号Upd, int update回数Upd,
            RDateTime 最終Update日時, RString ログインid) {
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.枝番 = 枝番;
        this.受給申請事由 = 受給申請事由;
        this.update回数 = update回数;
        this.履歴番号Upd = 履歴番号Upd;
        this.update回数Upd = update回数Upd;
        this.最終Update日時 = 最終Update日時;
        this.ログインid = ログインid;
    }

    /**
     * 特殊修正更新用パラメータを作成する
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @param update回数 update回数
     * @param 履歴番号Upd 履歴番号Upd
     * @param 最終Update日時 最終Update日時
     * @param ログインid ログインid
     * @return 特殊修正更新用パラメータ
     */
    public static RirekiShuseiMapperParameter createUpdParam(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号, RString 履歴番号,
            RString 枝番, Code 受給申請事由, int update回数,
            RString 履歴番号Upd,
            RDateTime 最終Update日時, RString ログインid) {
        return new RirekiShuseiMapperParameter(市町村コード, 被保険者番号, 履歴番号,
                枝番, 受給申請事由, update回数, 履歴番号Upd, update回数 + 1, 最終Update日時, ログインid);
    }

}
