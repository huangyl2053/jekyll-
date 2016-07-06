/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran.IkenshoJissekiIchiranKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医意見書作成実績集計表のデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IkenshoJissekiIchiranMybitisParamter implements IMyBatisParameter {

    private final boolean batchFlag;
    private final boolean 意見書記入日FROMFlag;
    private final RString 意見書記入日FROM;
    private final boolean 意見書記入日TOFlag;
    private final RString 意見書記入日TO;
    private final boolean 保険者Flag;
    private final RString 保険者;
    private final List<IkenshoJissekiIchiranKey> keyJoho;

    private IkenshoJissekiIchiranMybitisParamter(boolean batchFlag,
            boolean 意見書記入日FROMFlag,
            RString 意見書記入日FROM,
            boolean 意見書記入日TOFlag,
            RString 意見書記入日TO,
            boolean 保険者Flag,
            RString 保険者,
            List<IkenshoJissekiIchiranKey> keyJoho) {
        this.batchFlag = batchFlag;
        this.意見書記入日FROMFlag = 意見書記入日FROMFlag;
        this.意見書記入日FROM = 意見書記入日FROM;
        this.意見書記入日TOFlag = 意見書記入日TOFlag;
        this.意見書記入日TO = 意見書記入日TO;
        this.保険者Flag = 保険者Flag;
        this.保険者 = 保険者;
        this.keyJoho = keyJoho;
    }

    /**
     * 主治医意見書作成実績集計表のデータ取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 意見書記入日FROM 意見書記入日FROM
     * @param 意見書記入日TO 意見書記入日TO
     * @param 保険者 保険者
     * @param keyJoho 主治医意見書作成実績集計表のキー情報
     * @return 主治医意見書作成実績集計表のデータ取得パラメータ
     */
    public static IkenshoJissekiIchiranMybitisParamter createParamter(boolean batchFlag,
            RString 意見書記入日FROM,
            RString 意見書記入日TO,
            RString 保険者,
            List<IkenshoJissekiIchiranKey> keyJoho) {
        return new IkenshoJissekiIchiranMybitisParamter(batchFlag,
                !RString.isNullOrEmpty(意見書記入日FROM),
                意見書記入日FROM,
                !RString.isNullOrEmpty(意見書記入日TO),
                意見書記入日TO,
                !RString.isNullOrEmpty(保険者),
                保険者,
                keyJoho);

    }

}
