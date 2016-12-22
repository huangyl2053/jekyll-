/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran.IkenshoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojissekiichiran.IkenshoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成実績集計表のProcessParameterです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IkenshoJissekiIchiranProcessParameter implements IBatchProcessParameter {

    private final RString 帳票出力区分;
    private final RString 基準日FROM;
    private final RString 基準日TO;
    private final RString 基準日区分;
    private final RString 保険者;
    private final RString 証記載保険者;
    private final List<IkenshoJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 基準日FROM 基準日FROM
     * @param 基準日TO 基準日TO
     * @param 基準日区分 基準日区分
     * @param 証記載保険者 証記載保険者
     * @param 保険者 保険者
     * @param keyJoho キー情報Entityリスト
     */
    public IkenshoJissekiIchiranProcessParameter(RString 帳票出力区分,
            RString 基準日FROM,
            RString 基準日TO,
            RString 基準日区分,
            RString 保険者,
            RString 証記載保険者,
            List<IkenshoJissekiIchiranKey> keyJoho) {
        this.帳票出力区分 = 帳票出力区分;
        this.基準日FROM = 基準日FROM;
        this.基準日TO = 基準日TO;
        this.基準日区分 = 基準日区分;
        this.証記載保険者 = 証記載保険者;
        this.保険者 = 保険者;
        this.keyJoho = keyJoho;
    }

    /**
     * 主治医意見書作成実績集計表のデータ取得パラメータを作成します。
     *
     * @return 主治医意見書作成実績集計表のデータ取得パラメータ
     */
    public IkenshoJissekiIchiranMybitisParamter toMybitisParamter() {
        return IkenshoJissekiIchiranMybitisParamter.createParamter(true,
                基準日FROM,
                基準日TO,
                基準日区分,
                保険者,
                keyJoho);
    }
}
