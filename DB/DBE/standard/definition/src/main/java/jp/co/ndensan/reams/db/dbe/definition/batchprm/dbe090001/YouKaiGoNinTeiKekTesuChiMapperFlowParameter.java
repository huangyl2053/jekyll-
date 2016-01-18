/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe090001;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医への結果通知書のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class YouKaiGoNinTeiKekTesuChiMapperFlowParameter  extends BatchParameterBase {

    private final RString 二次判定期間From;
    private final RString 二次判定期間To;
    private final RString 未出力フラグ;
    private final RString 主治医情報;
    private final RString 申請書管理番号;
    private final RString 証記載保険者番号;
    private final RString 支所コード;
    private final RString 認定状況提供日;

    /**
     * コンストラクタです。
     *
     * @param 二次判定期間From 二次判定期間From
     * @param 二次判定期間To 二次判定期間To
     * @param 未出力フラグ 未出力フラグ
     * @param 主治医情報 主治医情報
     * @param 申請書管理番号 申請書管理番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 認定状況提供日 認定状況提供日
     */
    private YouKaiGoNinTeiKekTesuChiMapperFlowParameter(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 未出力フラグ,
            RString 主治医情報,
            RString 申請書管理番号,
            RString 証記載保険者番号,
            RString 支所コード,
            RString 認定状況提供日) {
        this.二次判定期間From = 二次判定期間From;
        this.二次判定期間To = 二次判定期間To;
        this.未出力フラグ = 未出力フラグ;
        this.主治医情報 = 主治医情報;
        this.申請書管理番号 = 申請書管理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.認定状況提供日 = 認定状況提供日;
    }

    /**
     * 主治医選択一覧検索用のパラメータを生成します。
     *
     * @param 二次判定期間From 二次判定期間From
     * @param 二次判定期間To 二次判定期間To
     * @param 未出力フラグ １：未出力のみ(画面出力条件「未出力のみ」選択した場合)、２：条件なし
     * @param 主治医情報 主治医医療機関コード+主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 認定状況提供日 認定状況提供日
     *
     * @return YouKaiGoNinTeiKekTesuChiMapperProcessParameter 主治医への結果通知書のMyBatis用パラメータクラスです。
     */
    public static YouKaiGoNinTeiKekTesuChiMapperFlowParameter create主治医への結果通知書Parameter(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 未出力フラグ,
            RString 主治医情報,
            RString 申請書管理番号,
            RString 証記載保険者番号,
            RString 支所コード,
            RString 認定状況提供日) {
        return new YouKaiGoNinTeiKekTesuChiMapperFlowParameter(二次判定期間From, 二次判定期間To, 未出力フラグ,
                主治医情報, 申請書管理番号, 証記載保険者番号, 支所コード, 認定状況提供日);
    }
}
