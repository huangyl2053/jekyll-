/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額適用申請書_年次分作成ののパラメータです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 世帯員把握基準日;
    private FlexibleDate 世帯員把握基準日2;
    private RString temp_出力順;
    private HihokenshaNo 被保険者番号;

}
