/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class YouKaiGoNinTeiKekTesuChiMapperParameter {

    private final RString 二次判定期間From;
    private final RString 二次判定期間To;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;

    private final boolean useNijiHanteiYMDFrom;
    private final boolean useNijiHanteiYMDTo;
    private final boolean useShujiiIryokikanCode;
    private final boolean useShujiiCode;
    private final boolean useMaDaNyuRyouKu;
    private final boolean useSyuRyoKuTaiSyou;

    /**
     * コンストラクタです。
     *
     * @param 二次判定期間From 二次判定期間From
     * @param 二次判定期間To 二次判定期間To
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param useNijiHanteiYMDFrom useNijiHanteiYMDFrom
     * @param useNijiHanteiYMDTo useNijiHanteiYMDTo
     * @param useShujiiIryokikanCode useShujiiIryokikanCode
     * @param useShujiiCode useShujiiCode
     * @param useMaDaNyuRyouKu useMaDaNyuRyouKu
     * @param useSyuRyoKuTaiSyou useSyuRyoKuTaiSyou
     *
     */
    private YouKaiGoNinTeiKekTesuChiMapperParameter(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 主治医医療機関コード,
            RString 主治医コード,
            boolean useNijiHanteiYMDFrom,
            boolean useNijiHanteiYMDTo,
            boolean useShujiiIryokikanCode,
            boolean useShujiiCode,
            boolean useMaDaNyuRyouKu,
            boolean useSyuRyoKuTaiSyou) {

        this.二次判定期間From = 二次判定期間From;
        this.二次判定期間To = 二次判定期間To;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.useNijiHanteiYMDFrom = useNijiHanteiYMDFrom;
        this.useNijiHanteiYMDTo = useNijiHanteiYMDTo;
        this.useShujiiIryokikanCode = useShujiiIryokikanCode;
        this.useShujiiCode = useShujiiCode;
        this.useMaDaNyuRyouKu = useMaDaNyuRyouKu;
        this.useSyuRyoKuTaiSyou = useSyuRyoKuTaiSyou;

    }

    /**
     * 主治医選択一覧検索用のパラメータを生成します。
     *
     * @param 二次判定期間From 二次判定期間From
     * @param 二次判定期間To 二次判定期間To
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 未出力のみ 未出力のみ
     * @param 結果通知出力対象 結果通知出力対象
     * @return YouKaiGoNinTeiKekTesuChiMapperParameter 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです
     */
    public static YouKaiGoNinTeiKekTesuChiMapperParameter createSelectListParam(RString 二次判定期間From,
            RString 二次判定期間To,
            RString 主治医医療機関コード,
            RString 主治医コード,
            boolean 未出力のみ,
            boolean 結果通知出力対象) {
        boolean useNijiHanteiYMDFromTemp = false;
        boolean useNijiHanteiYMDToTemp = false;
        boolean useShujiiIryokikanCodeTemp = false;
        boolean useShujiiCodeTemp = false;
        if (二次判定期間From != null && !二次判定期間From.isEmpty()) {
            useNijiHanteiYMDFromTemp = true;
        }
        if (二次判定期間To != null && !二次判定期間To.isEmpty()) {
            useNijiHanteiYMDToTemp = true;
        }
        if (主治医医療機関コード != null && !主治医医療機関コード.isEmpty()) {
            useShujiiIryokikanCodeTemp = true;
        }
        if (主治医コード != null && !主治医コード.isEmpty()) {
            useShujiiCodeTemp = true;
        }
        return new YouKaiGoNinTeiKekTesuChiMapperParameter(二次判定期間From, 二次判定期間To, 主治医医療機関コード,
                主治医コード, useNijiHanteiYMDFromTemp, useNijiHanteiYMDToTemp, useShujiiIryokikanCodeTemp, useShujiiCodeTemp, 未出力のみ, 結果通知出力対象);
    }

    /**
     * 結果通知出力対象申請者一覧検索用のパラメータを生成します。
     *
     * @param 二次判定期間From 二次判定期間From
     * @param 二次判定期間To 二次判定期間To
     * @return YouKaiGoNinTeiKekTesuChiMapperParameter 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです
     */
    public static YouKaiGoNinTeiKekTesuChiMapperParameter createSelectListParam(RString 二次判定期間From,
            RString 二次判定期間To) {
        return new YouKaiGoNinTeiKekTesuChiMapperParameter(二次判定期間From, 二次判定期間To, null,
                null, true, true, true, true, true, true);
    }

}
