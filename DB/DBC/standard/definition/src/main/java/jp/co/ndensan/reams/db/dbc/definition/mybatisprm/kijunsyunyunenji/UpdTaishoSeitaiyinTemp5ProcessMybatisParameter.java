/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
public class UpdTaishoSeitaiyinTemp5ProcessMybatisParameter implements IMyBatisParameter {

    private RString 世帯コード;
    private FlexibleYear 処理年度;
    private LasdecCode 市町村コード;
    private FlexibleDate システム日付;

}
