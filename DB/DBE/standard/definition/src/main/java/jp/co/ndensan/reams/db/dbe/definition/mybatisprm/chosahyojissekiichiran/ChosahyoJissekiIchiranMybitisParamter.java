/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyojissekiichiran.ChosahyoJissekiIchiranKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosahyoJissekiIchiranMybitisParamter implements IMyBatisParameter {

    private final boolean batchFlag;
    private final boolean 調査実施日FROMFlag;
    private final RString 調査実施日FROM;
    private final boolean 調査実施日TOFlag;
    private final RString 調査実施日TO;
    private final boolean 保険者Flag;
    private final RString 保険者;
    private final boolean 件数Flag;
    private final int 件数;
    private final boolean gamenFlag;
    private final List<ChosahyoJissekiIchiranKey> keyJoho;

    private ChosahyoJissekiIchiranMybitisParamter(boolean batchFlag,
            boolean 調査実施日FROMFlag,
            RString 調査実施日FROM,
            boolean 調査実施日TOFlag,
            RString 調査実施日TO,
            boolean 保険者Flag,
            RString 保険者,
            boolean 件数Flag,
            int 件数,
            boolean gamenFlag,
            List<ChosahyoJissekiIchiranKey> keyJoho) {
        this.batchFlag = batchFlag;
        this.調査実施日FROMFlag = 調査実施日FROMFlag;
        this.調査実施日FROM = 調査実施日FROM;
        this.調査実施日TOFlag = 調査実施日TOFlag;
        this.調査実施日TO = 調査実施日TO;
        this.保険者Flag = 保険者Flag;
        this.保険者 = 保険者;
        this.件数Flag = 件数Flag;
        this.件数 = 件数;
        this.gamenFlag = gamenFlag;
        this.keyJoho = keyJoho;
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 調査実施日FROM 意見書記入日FROM
     * @param 調査実施日TO 意見書記入日TO
     * @param 保険者 保険者
     * @param keyJoho 帳票出力用認定調査実績集計表のキー情報
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public static ChosahyoJissekiIchiranMybitisParamter createParamter(boolean batchFlag,
            RString 調査実施日FROM,
            RString 調査実施日TO,
            RString 保険者,
            List<ChosahyoJissekiIchiranKey> keyJoho) {
        return new ChosahyoJissekiIchiranMybitisParamter(batchFlag,
                !RString.isNullOrEmpty(調査実施日FROM),
                調査実施日FROM,
                !RString.isNullOrEmpty(調査実施日TO),
                調査実施日TO,
                !RString.isNullOrEmpty(保険者),
                保険者,
                false,
                0,
                false,
                keyJoho);
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 調査実施日FROM 意見書記入日FROM
     * @param 調査実施日TO 意見書記入日TO
     * @param 保険者 保険者
     * @param 最大表示件数 最大表示件数
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public static ChosahyoJissekiIchiranMybitisParamter createGamenParamter(boolean batchFlag,
            RString 調査実施日FROM,
            RString 調査実施日TO,
            RString 保険者,
            RString 最大表示件数) {
        return new ChosahyoJissekiIchiranMybitisParamter(batchFlag,
                !RString.isNullOrEmpty(調査実施日FROM),
                調査実施日FROM,
                !RString.isNullOrEmpty(調査実施日TO),
                調査実施日TO,
                !RString.isNullOrEmpty(保険者),
                保険者,
                !RString.isNullOrEmpty(最大表示件数),
                Integer.parseInt(最大表示件数.toString()),
                true,
                null);
    }
}
