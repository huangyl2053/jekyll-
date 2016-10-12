/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.inssetaiyinshotokujyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額適用申請書_異動分作成ののパラメータです
 *
 * @reamsid_L DBC-4640-030 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class InsSetaiyin3MybatisParameter implements IMyBatisParameter {

    private SetaiCode 世帯コード;
    private FlexibleYear 年度;
    private int 履歴番号;
    private HihokenshaNo 被保険者番号;

}
