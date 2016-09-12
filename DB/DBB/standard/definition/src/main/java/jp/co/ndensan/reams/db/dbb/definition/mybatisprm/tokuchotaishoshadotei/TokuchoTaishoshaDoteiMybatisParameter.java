/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshadotei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBBBZ81002_2_特徴対象者同定（一括）の MybatisParameterです。
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTaishoshaDoteiMybatisParameter implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private SubGyomuCode サーブ業務コード;
    private RString 処理名;
    private RString 年度内連番;
    private YMDHMS 処理日時;
}
