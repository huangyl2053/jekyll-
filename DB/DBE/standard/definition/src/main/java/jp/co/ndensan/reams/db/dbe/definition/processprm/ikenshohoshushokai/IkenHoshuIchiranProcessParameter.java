/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshohoshushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran.IkenshoHoshuShokaiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai.IkenshoHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬実績集計表のProcessParameterです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IkenHoshuIchiranProcessParameter implements IBatchProcessParameter {

    private RString 帳票出力区分;
    private FlexibleDate 作成依頼日期間開始;
    private FlexibleDate 作成依頼日期間終了;
    private List<IkenshoHoshuShokaiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 作成依頼日期間開始 作成依頼日期間開始
     * @param 作成依頼日期間終了 作成依頼日期間終了
     * @param keyJoho キー情報Entityリスト
     */
    public IkenHoshuIchiranProcessParameter(RString 帳票出力区分,
            FlexibleDate 作成依頼日期間開始,
            FlexibleDate 作成依頼日期間終了,
            List<IkenshoHoshuShokaiIchiranKey> keyJoho) {
        this.帳票出力区分 = 帳票出力区分;
        this.作成依頼日期間開始 = 作成依頼日期間開始;
        this.作成依頼日期間終了 = 作成依頼日期間終了;
        this.keyJoho = keyJoho;
    }

    /**
     * 意見書作成報酬のデータ取得パラメータを作成します。
     *
     * @return 意見書作成報酬のデータ取得パラメータ
     */
    public IkenshoHoshuShokaiMapperParameter toMybitisParamter() {
        return IkenshoHoshuShokaiMapperParameter.createParamter(作成依頼日期間開始, 作成依頼日期間終了, keyJoho);
    }
}
