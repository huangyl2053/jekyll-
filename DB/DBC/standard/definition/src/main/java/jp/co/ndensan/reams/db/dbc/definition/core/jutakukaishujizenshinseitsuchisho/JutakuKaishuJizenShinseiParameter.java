/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 住宅改修事前申請データMyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuJizenShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 被保険者氏名;
    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 申請日;
    private final RString 判定区分;
    private final RString 承認条件;
    private final RString 不承認理由;
    private final FlexibleDate 発行日;

    /**
     * コンストラクタです。
     *
     */
    private JutakuKaishuJizenShinseiParameter(HihokenshaNo 被保険者番号,
            RString 被保険者氏名,
            ShikibetsuCode 識別コード,
            FlexibleDate 申請日,
            RString 判定区分,
            RString 承認条件,
            RString 不承認理由,
            FlexibleDate 発行日) {

        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 被保険者氏名;
        this.識別コード = 識別コード;
        this.申請日 = 申請日;
        this.判定区分 = 判定区分;
        this.承認条件 = 承認条件;
        this.不承認理由 = 不承認理由;
        this.発行日 = 発行日;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 被保険者氏名
     * @param 識別コード
     * @param 申請日
     * @param 判定区分
     * @param 承認条件
     * @param 不承認理由
     * @param 発行日
     * @return
     */
    public static JutakuKaishuJizenShinseiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            RString 被保険者氏名,
            ShikibetsuCode 識別コード,
            FlexibleDate 申請日,
            RString 判定区分,
            RString 承認条件,
            RString 不承認理由,
            FlexibleDate 発行日) {
        return new JutakuKaishuJizenShinseiParameter(被保険者番号, 被保険者氏名, 識別コード, 申請日, 判定区分,
                承認条件, 不承認理由, 発行日);
    }
}
