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
    private final boolean 基準日FROMFlag;
    private final RString 基準日FROM;
    private final boolean 基準日TOFlag;
    private final RString 基準日TO;
    private final boolean 基準日区分Flag;
    private final RString 基準日区分;
    private final boolean 保険者Flag;
    private final RString 保険者;
    private final boolean 件数Flag;
    private final int 件数;
    private final boolean gamenFlag;
    private final List<ChosahyoJissekiIchiranKey> keyJoho;
    private final RString 改頁;

    private ChosahyoJissekiIchiranMybitisParamter(boolean batchFlag,
            boolean 基準日FROMFlag,
            RString 基準日FROM,
            boolean 基準日TOFlag,
            RString 基準日TO,
            boolean 基準日区分Flag,
            RString 基準日区分,
            boolean 保険者Flag,
            RString 保険者,
            boolean 件数Flag,
            int 件数,
            boolean gamenFlag,
            List<ChosahyoJissekiIchiranKey> keyJoho,
            RString 改頁) {
        this.batchFlag = batchFlag;
        this.基準日FROMFlag = 基準日FROMFlag;
        this.基準日FROM = 基準日FROM;
        this.基準日TOFlag = 基準日TOFlag;
        this.基準日TO = 基準日TO;
        this.基準日区分Flag = 基準日区分Flag;
        this.基準日区分 = 基準日区分;
        this.保険者Flag = 保険者Flag;
        this.保険者 = 保険者;
        this.件数Flag = 件数Flag;
        this.件数 = 件数;
        this.gamenFlag = gamenFlag;
        this.keyJoho = keyJoho;
        this.改頁 = 改頁;
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 基準日FROM 基準日FROM
     * @param 基準日TO 基準日TO
     * @param 基準日区分 基準日区分
     * @param 保険者 保険者
     * @param keyJoho 帳票出力用認定調査実績集計表のキー情報
     * @param 改頁
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public static ChosahyoJissekiIchiranMybitisParamter createParamter(boolean batchFlag,
            RString 基準日FROM,
            RString 基準日TO,
            RString 基準日区分,
            RString 保険者,
            List<ChosahyoJissekiIchiranKey> keyJoho,
            RString 改頁) {
        return new ChosahyoJissekiIchiranMybitisParamter(batchFlag,
                !RString.isNullOrEmpty(基準日FROM),
                基準日FROM,
                !RString.isNullOrEmpty(基準日TO),
                基準日TO,
                !RString.isNullOrEmpty(基準日区分),
                基準日区分,
                !RString.isNullOrEmpty(保険者),
                保険者,
                false,
                0,
                false,
                keyJoho,
                改頁);
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 基準日FROM 基準日FROM
     * @param 基準日TO 基準日TO
     * @param 基準日区分
     * @param 保険者 保険者
     * @param 最大表示件数 最大表示件数
     * @param 改頁
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public static ChosahyoJissekiIchiranMybitisParamter createGamenParamter(boolean batchFlag,
            RString 基準日FROM,
            RString 基準日TO,
            RString 基準日区分,
            RString 保険者,
            RString 最大表示件数,
            RString 改頁) {
        return new ChosahyoJissekiIchiranMybitisParamter(batchFlag,
                !RString.isNullOrEmpty(基準日FROM),
                基準日FROM,
                !RString.isNullOrEmpty(基準日TO),
                基準日TO,
                !RString.isNullOrEmpty(基準日区分),
                基準日区分,
                !RString.isNullOrEmpty(保険者),
                保険者,
                !RString.isNullOrEmpty(最大表示件数),
                Integer.parseInt(最大表示件数.toString()),
                true,
                null,
                改頁);
    }
}
