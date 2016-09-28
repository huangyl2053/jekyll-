/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書情報検索データ取得用パラメータクラスです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoJohoSearchParameter implements IMyBatisParameter {

    private RString 申請状況区分;
    private HokenshaNo 市町村コード;
    private FlexibleYear 申請対象年度;
    private FlexibleDate 申請日;
    private RString 介護支給申請書整理番号;
    private RString 医療支給申請書整理番号;
    private boolean 申請基本情報検索有無;
    private boolean 申請代表者氏名前方一致;
    private RString 申請代表者氏名;
    private boolean 被保険者情報検索有無;
    private HihokenshaNo 被保険者番号;
    private boolean 被保険者氏名前方一致;
    private RString 被保険者氏名;
    private List<HihokenshaNo> 被保険者番号リスト;

    /**
     * コンストラクタです
     *
     * @param 申請状況区分 申請状況区分
     * @param 市町村コード 市町村コード
     * @param 申請対象年度 申請対象年度
     * @param 申請日 申請日
     * @param 介護支給申請書整理番号 介護支給申請書整理番号
     * @param 医療支給申請書整理番号 医療支給申請書整理番号
     * @param 申請基本情報検索有無 申請基本情報検索有無
     * @param 申請代表者氏名前方一致 申請代表者氏名前方一致
     * @param 申請代表者氏名 申請代表者氏名
     * @param 被保険者情報検索有無 被保険者情報検索有無
     * @param 被保険者番号 被保険者情報検索有無
     * @param 被保険者氏名前方一致 被保険者氏名前方一致
     * @param 被保険者氏名 被保険者氏名
     * @param 被保険者番号リスト 被保険者番号リスト
     */
    public ShinseishoJohoSearchParameter(
            RString 申請状況区分,
            HokenshaNo 市町村コード,
            FlexibleYear 申請対象年度,
            FlexibleDate 申請日,
            RString 介護支給申請書整理番号,
            RString 医療支給申請書整理番号,
            boolean 申請基本情報検索有無,
            boolean 申請代表者氏名前方一致,
            RString 申請代表者氏名,
            boolean 被保険者情報検索有無,
            HihokenshaNo 被保険者番号,
            boolean 被保険者氏名前方一致,
            RString 被保険者氏名,
            List<HihokenshaNo> 被保険者番号リスト) {
        this.申請状況区分 = 申請状況区分;
        this.市町村コード = 市町村コード;
        this.申請対象年度 = 申請対象年度;
        this.申請日 = 申請日;
        this.介護支給申請書整理番号 = 介護支給申請書整理番号;
        this.医療支給申請書整理番号 = 医療支給申請書整理番号;
        this.申請基本情報検索有無 = 申請基本情報検索有無;
        this.申請代表者氏名前方一致 = 申請代表者氏名前方一致;
        this.申請代表者氏名 = 申請代表者氏名;
        this.被保険者情報検索有無 = 被保険者情報検索有無;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名前方一致 = 被保険者氏名前方一致;
        this.被保険者氏名 = 被保険者氏名;
        this.被保険者番号リスト = 被保険者番号リスト;
    }
}
