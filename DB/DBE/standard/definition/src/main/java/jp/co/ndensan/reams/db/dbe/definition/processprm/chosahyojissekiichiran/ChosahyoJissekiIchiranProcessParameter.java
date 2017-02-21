/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.chosahyojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyojissekiichiran.ChosahyoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran.ChosahyoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosahyoJissekiIchiranProcessParameter implements IBatchProcessParameter {

    private final boolean batchFlag;
    private final RString 帳票出力区分;
    private final RString 基準日FROM;
    private final RString 基準日TO;
    private final RString 基準日区分;
    private final RString 保険者;
    private final RString 証記載保険者;
    private final List<ChosahyoJissekiIchiranKey> keyJoho;
    private final RString 改頁;

    /**
     * コンストラクタです。
     *
     * @param batchFlag
     * @param 帳票出力区分 帳票出力区分
     * @param 基準日FROM 基準日FROM
     * @param 基準日TO 基準日TO
     * @param 基準日区分 基準日区分
     * @param 保険者 保険者
     * @param 証記載保険者 証記載保険者
     * @param keyJoho キー情報Entityリスト
     * @param 改頁
     */
    public ChosahyoJissekiIchiranProcessParameter(boolean batchFlag,
            RString 帳票出力区分,
            RString 基準日FROM,
            RString 基準日TO,
            RString 基準日区分,
            RString 保険者,
            RString 証記載保険者,
            List<ChosahyoJissekiIchiranKey> keyJoho,
            RString 改頁) {
        this.batchFlag = batchFlag;
        this.帳票出力区分 = 帳票出力区分;
        this.基準日FROM = 基準日FROM;
        this.基準日TO = 基準日TO;
        this.基準日区分 = 基準日区分;
        this.保険者 = 保険者;
        this.証記載保険者 = 証記載保険者;
        this.keyJoho = keyJoho;
        this.改頁 = 改頁;
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得パラメータを作成します。
     *
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public ChosahyoJissekiIchiranMybitisParamter toMybitisParamter() {
        return ChosahyoJissekiIchiranMybitisParamter.createParamter(batchFlag,
                基準日FROM,
                基準日TO,
                基準日区分,
                保険者,
                keyJoho,
                改頁);
    }
}
