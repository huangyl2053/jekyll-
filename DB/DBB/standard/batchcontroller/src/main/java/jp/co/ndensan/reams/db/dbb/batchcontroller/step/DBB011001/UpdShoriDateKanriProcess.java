/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka.ITokuchoKariSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理更新processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private static final RString 年度内番号 = new RString("0001");
    private TokuchoKarisanteiFukaProcessParameter processParameter;

    @Override
    protected void process() {
        TokuchoKarisanteiFukaMyBatisParameter parameter_特徴仮算定賦課 = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter_特徴仮算定賦課.setサーブ業務コード(SubGyomuCode.DBB介護賦課);
        parameter_特徴仮算定賦課.set処理名(ShoriName.特徴仮算定賦課.get名称());
        parameter_特徴仮算定賦課.set年度(processParameter.get調定年度());
        parameter_特徴仮算定賦課.set調定日時(processParameter.get調定日時());
        getMapper(ITokuchoKariSanteiFukaMapper.class).update処理日付管理テーブル_特徴仮算定賦課(parameter_特徴仮算定賦課);
        TokuchoKarisanteiFukaMyBatisParameter parameter_依頼金額計算 = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter_依頼金額計算.setサーブ業務コード(SubGyomuCode.DBB介護賦課);
        parameter_依頼金額計算.set処理名(ShoriName.特徴仮算定賦課.get名称());
        parameter_依頼金額計算.set年度(processParameter.get調定年度());
        parameter_依頼金額計算.set調定日時(processParameter.get調定日時());
        parameter_依頼金額計算.set年度内番号(年度内番号);
        getMapper(ITokuchoKariSanteiFukaMapper.class).update処理日付管理テーブル_依頼金額計算(parameter_依頼金額計算);
    }

}
