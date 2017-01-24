/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran.IkenshoHoshuShokaiIchiranKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 意見書作成報酬照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IkenshoHoshuShokaiMapperParameter implements IMyBatisParameter {

    private final FlexibleDate 作成依頼日終了;
    private final FlexibleDate 作成依頼日開始;
    private final boolean 作成依頼日終了Flag;
    private final boolean 作成依頼日開始Flag;
    private final boolean 保険者Flag;
    private final RString 保険者;
    private final RString 保険者名称;
    private final Decimal 最大表示件数;
    private final boolean 最大表示件数Flag;
    private final boolean batchFlag;
    private final boolean orderByFlag;
    private final List<IkenshoHoshuShokaiIchiranKey> ikenshoBusiness;

    /**
     * コンストラクタ
     *
     * @param 作成依頼日終了 作成依頼日終了
     * @param 作成依頼日開始 作成依頼日開始
     * @param 作成依頼日終了Flag 作成依頼日終了Flag,
     * @param 作成依頼日開始Flag 作成依頼日開始Flag,
     * @param 保険者Flag 保険者Flag
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param 最大表示件数Flag 最大表示件数Flag
     * @param 最大表示件数 最大表示件数
     * @param batchFlag batchFlag
     * @param orderByFlag 並び替えFlag
     * @param ikenshoBusiness 主治医意見書作成報酬合計額リストのキー情報
     */
    private IkenshoHoshuShokaiMapperParameter(
            FlexibleDate 作成依頼日終了,
            FlexibleDate 作成依頼日開始,
            boolean 作成依頼日終了Flag,
            boolean 作成依頼日開始Flag,
            boolean 保険者Flag,
            RString 保険者,
            RString 保険者名称,
            Decimal 最大表示件数,
            boolean 最大表示件数Flag,
            boolean batchFlag,
            boolean orderByFlag,
            List<IkenshoHoshuShokaiIchiranKey> ikenshoBusiness) {
        this.作成依頼日終了 = 作成依頼日終了;
        this.作成依頼日開始 = 作成依頼日開始;
        this.作成依頼日終了Flag = 作成依頼日終了Flag;
        this.作成依頼日開始Flag = 作成依頼日開始Flag;
        this.保険者Flag = 保険者Flag;
        this.保険者 = 保険者;
        this.保険者名称 = 保険者名称;
        this.最大表示件数 = 最大表示件数;
        this.最大表示件数Flag = 最大表示件数Flag;
        this.batchFlag = batchFlag;
        this.orderByFlag = orderByFlag;
        this.ikenshoBusiness = ikenshoBusiness;
    }

    /**
     * 合計額リストのパラメータを生成します。
     *
     * @param 作成依頼日開始 作成依頼日開始
     * @param 作成依頼日終了 作成依頼日終了
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param 最大表示件数 最大表示件数
     * @return 合計額リストのパラメータ
     */
    public static IkenshoHoshuShokaiMapperParameter createSelectBy情報(
            FlexibleDate 作成依頼日開始,
            FlexibleDate 作成依頼日終了,
            RString 保険者,
            RString 保険者名称,
            Decimal 最大表示件数) {
        return new IkenshoHoshuShokaiMapperParameter(
                作成依頼日終了,
                作成依頼日開始,
                !作成依頼日終了.isEmpty(),
                !作成依頼日開始.isEmpty(),
                !RString.isNullOrEmpty(保険者),
                保険者,
                保険者名称,
                最大表示件数,
                最大表示件数 != null,
                false,
                true,
                null);
    }

    /**
     * レコード数取得用パラメータを生成します。
     *
     * @param 作成依頼日開始 作成依頼日開始
     * @param 作成依頼日終了 作成依頼日終了
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @return レコード数取得用パラメータ
     */
    public static IkenshoHoshuShokaiMapperParameter createParameterForGetCount(
            FlexibleDate 作成依頼日開始,
            FlexibleDate 作成依頼日終了,
            RString 保険者,
            RString 保険者名称) {
        return new IkenshoHoshuShokaiMapperParameter(
                作成依頼日終了,
                作成依頼日開始,
                !作成依頼日終了.isEmpty(),
                !作成依頼日開始.isEmpty(),
                !RString.isNullOrEmpty(保険者),
                保険者,
                保険者名称,
                null,
                false,
                false,
                false,
                null);
    }

    /**
     * 合計額リストの帳票出力のパラメータを生成します。
     *
     * @param 作成依頼日開始 作成依頼日開始
     * @param 作成依頼日終了 作成依頼日終了
     * @param 保険者 保険者
     * @param 保険者名称 保険者名称
     * @param ikenshoBusiness 主治医意見書作成報酬合計額リストのキー情報
     * @return 合計額リストの帳票出力のパラメータ
     */
    public static IkenshoHoshuShokaiMapperParameter createParamter(
            FlexibleDate 作成依頼日開始,
            FlexibleDate 作成依頼日終了,
            RString 保険者,
            RString 保険者名称,
            List<IkenshoHoshuShokaiIchiranKey> ikenshoBusiness) {
        return new IkenshoHoshuShokaiMapperParameter(
                作成依頼日終了,
                作成依頼日開始,
                !作成依頼日終了.isEmpty(),
                !作成依頼日開始.isEmpty(),
                !RString.isNullOrEmpty(保険者),
                保険者,
                保険者名称,
                null,
                false,
                true,
                true,
                ikenshoBusiness);
    }

}
