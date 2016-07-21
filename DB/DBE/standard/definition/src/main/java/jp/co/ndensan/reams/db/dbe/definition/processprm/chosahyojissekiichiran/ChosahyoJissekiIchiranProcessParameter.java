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

    private final RString 帳票出力区分;
    private final RString 調査実施日FROM;
    private final RString 調査実施日TO;
    private final RString 保険者;
    private final List<ChosahyoJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 調査実施日FROM 調査実施日FROM
     * @param 調査実施日TO 調査実施日TO
     * @param 保険者 保険者
     * @param keyJoho キー情報Entityリスト
     */
    public ChosahyoJissekiIchiranProcessParameter(RString 帳票出力区分,
            RString 調査実施日FROM,
            RString 調査実施日TO,
            RString 保険者,
            List<ChosahyoJissekiIchiranKey> keyJoho) {
        this.帳票出力区分 = 帳票出力区分;
        this.調査実施日FROM = 調査実施日FROM;
        this.調査実施日TO = 調査実施日TO;
        this.保険者 = 保険者;
        this.keyJoho = keyJoho;
    }

    /**
     * 帳票出力用認定調査実績集計表のデータ取得パラメータを作成します。
     *
     * @return 帳票出力用認定調査実績集計表のデータ取得パラメータ
     */
    public ChosahyoJissekiIchiranMybitisParamter toMybitisParamter() {
        return ChosahyoJissekiIchiranMybitisParamter.createParamter(true,
                調査実施日FROM,
                調査実施日TO,
                保険者,
                keyJoho);
    }
}
