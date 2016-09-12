/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請受付のパラメータクラス
 *
 * @reamsid_L DBD-1300-010 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class NinteiShinseiTorokuUketsukeParameter {

    private final HihokenshaNo 被保険者番号;
    private final ShikibetsuCode 識別コード;
    private final ShinseishoKanriNo 申請書管理番号;
    private final RString 表示パターン;
    private final FlexibleDate システム日付;
    private final RString psmShikibetsuTaisho;

    private NinteiShinseiTorokuUketsukeParameter(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            ShinseishoKanriNo 申請書管理番号,
            RString 表示パターン,
            FlexibleDate システム日付,
            RString psmShikibetsuTaisho) {
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.申請書管理番号 = 申請書管理番号;
        this.表示パターン = 表示パターン;
        this.システム日付 = システム日付;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * パラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 表示パターン RString
     * @param システム日付 FlexibleDate
     * @param psmShikibetsuTaisho RString
     * @return NinteiShinseiTorokuUketsukeParameter
     */
    public static NinteiShinseiTorokuUketsukeParameter createParam(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            ShinseishoKanriNo 申請書管理番号,
            RString 表示パターン,
            FlexibleDate システム日付,
            RString psmShikibetsuTaisho) {
        return new NinteiShinseiTorokuUketsukeParameter(被保険者番号, 識別コード, 申請書管理番号, 表示パターン, システム日付, psmShikibetsuTaisho);
    }
}
