/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医への結果通知書のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0220-030 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class YouKaiGoNinTeiKekTesuChiMybitisParamter implements IMyBatisParameter {

    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final RString 二次判定期間From;
    private final RString 二次判定期間To;
    private final RString 未出力フラグ;
    private final RString 主治医情報;
    private final RString 申請書管理番号;
    private final RString 証記載保険者番号;
    private final RString 支所コード;
    private final RString 認定状況提供日;

    private final boolean use未出力フラグ;
    private final boolean use支所コード;
    private final boolean use二次判定期間From;
    private final boolean use二次判定期間To;
    private final boolean use申請書管理番号;
    private final boolean use主治医情報;

    private final boolean useShoKisaiHokenshaNo;

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
     * @param use未出力フラグ use未出力フラグ
     * @param use支所コード use支所コード
     * @param use二次判定期間From use二次判定期間From
     * @param use二次判定期間To use二次判定期間To
     * @param use申請書管理番号 use申請書管理番号
     * @param use主治医情報 use主治医情報
     * @param useShoKisaiHokenshaNo useShoKisaiHokenshaNo
     */
    private YouKaiGoNinTeiKekTesuChiMybitisParamter(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 未出力フラグ,
            RString 主治医情報,
            RString 申請書管理番号,
            RString 証記載保険者番号,
            RString 支所コード,
            RString 認定状況提供日,
            boolean use未出力フラグ,
            boolean use支所コード,
            boolean use二次判定期間From,
            boolean use二次判定期間To,
            boolean use申請書管理番号,
            boolean use主治医情報,
            boolean useShoKisaiHokenshaNo) {
        this.二次判定期間From = 二次判定期間From;
        this.二次判定期間To = 二次判定期間To;
        this.未出力フラグ = 未出力フラグ;
        this.主治医情報 = 主治医情報;
        this.申請書管理番号 = 申請書管理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.認定状況提供日 = 認定状況提供日;

        this.use未出力フラグ = use未出力フラグ;
        this.use支所コード = use支所コード;
        this.use二次判定期間From = use二次判定期間From;
        this.use二次判定期間To = use二次判定期間To;
        this.use申請書管理番号 = use申請書管理番号;
        this.use主治医情報 = use主治医情報;
        this.useShoKisaiHokenshaNo = useShoKisaiHokenshaNo;
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
     * @param useShoKisaiHokenshaNo useShoKisaiHokenshaNo
     *
     * @return YouKaiGoNinTeiKekTesuChiMapperProcessParameter
     * 主治医への結果通知書のMyBatis用パラメータクラスです。
     */
    public static YouKaiGoNinTeiKekTesuChiMybitisParamter create主治医への結果通知書Parameter(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 未出力フラグ,
            RString 主治医情報,
            RString 申請書管理番号,
            RString 証記載保険者番号,
            RString 支所コード,
            RString 認定状況提供日,
            boolean useShoKisaiHokenshaNo) {
        boolean useTemp未出力フラグ = true;
        boolean useTemp支所コード = true;
        boolean useTemp二次判定期間From = true;
        boolean useTemp二次判定期間To = true;
        boolean useTemp申請書管理番号 = true;
        boolean useTemp主治医情報 = true;
        if (RString.isNullOrEmpty(未出力フラグ) || !new RString("1").equals(未出力フラグ)) {
            useTemp未出力フラグ = false;
        }
        if (RString.isNullOrEmpty(支所コード)) {
            useTemp支所コード = false;
        }
        if (RString.isNullOrEmpty(二次判定期間From)) {
            useTemp二次判定期間From = false;
        }
        if (RString.isNullOrEmpty(二次判定期間To)) {
            useTemp二次判定期間To = false;
        }
        if (RString.isNullOrEmpty(申請書管理番号)) {
            useTemp申請書管理番号 = false;
        }
        if (RString.isNullOrEmpty(主治医情報)) {
            useTemp主治医情報 = false;
        }
        return new YouKaiGoNinTeiKekTesuChiMybitisParamter(二次判定期間From, 二次判定期間To, 未出力フラグ,
                主治医情報, 申請書管理番号, 証記載保険者番号, 支所コード, 認定状況提供日,
                useTemp未出力フラグ, useTemp支所コード, useTemp二次判定期間From, useTemp二次判定期間To, useTemp申請書管理番号, useTemp主治医情報,
                useShoKisaiHokenshaNo);
    }
}
