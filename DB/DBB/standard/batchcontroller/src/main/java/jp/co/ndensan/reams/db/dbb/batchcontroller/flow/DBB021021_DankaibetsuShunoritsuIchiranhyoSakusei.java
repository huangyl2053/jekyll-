/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021021.InsDankaibetsuShunoritsuTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021021.PrtDankaibetsuShunoritsuIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021.DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dankaibetsushunoritsu.InsDankaibetsuShunoritsuTmpProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dankaibetsushunoritsu.PrtDankaibetsuShunoritsuIchiranhyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階別収納率一覧表作成のバッチ処理フローです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
public class DBB021021_DankaibetsuShunoritsuIchiranhyoSakusei extends
        BatchFlowBase<DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter> {

    private static final String INS_DANKAIBETSU_SHUNORITSU = "insDankaibetsuShunoritsuTmpProcess";
    private static final String PRT_DANKAIBETSU_SHUNORITSU_ICHIRANHYO = "prtDankaibetsuShunoritsuIchiranhyoProcess";
    private static final RString 生年月日年齢区分_生年月日 = new RString("生年月日");
    private static final RString 生年月日年齢区分_年齢 = new RString("年齢");

    @Override
    protected void defineFlow() {
        executeStep(INS_DANKAIBETSU_SHUNORITSU);
        executeStep(PRT_DANKAIBETSU_SHUNORITSU_ICHIRANHYO);
    }

    /**
     * 保険料段階別収納率一時テーブル（新規）に登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(INS_DANKAIBETSU_SHUNORITSU)
    protected IBatchFlowCommand insDankaibetsuShunoritsuTmpProcess() {
        return loopBatch(InsDankaibetsuShunoritsuTmpProcess.class).
                arguments(createInsProcessParameter()).define();
    }

    /**
     * 保険料段階別収納率一覧表の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(PRT_DANKAIBETSU_SHUNORITSU_ICHIRANHYO)
    protected IBatchFlowCommand prtDankaibetsuShunoritsuIchiranhyoProcess() {
        return loopBatch(PrtDankaibetsuShunoritsuIchiranhyoProcess.class).
                arguments(createPrtProcessParameter()).define();
    }

    private InsDankaibetsuShunoritsuTmpProcessParameter createInsProcessParameter() {
        InsDankaibetsuShunoritsuTmpProcessParameter parameter = new InsDankaibetsuShunoritsuTmpProcessParameter();
        parameter.set開始調定年度(getParameter().get調定年度_開始());
        parameter.set終了調定年度(getParameter().get調定年度_終了());
        parameter.set開始賦課年度(getParameter().get賦課年度_開始());
        parameter.set終了賦課年度(getParameter().get賦課年度_終了());
        parameter.set会計年度(getParameter().get会計年度());
        parameter.set調定基準年月(getParameter().get調定基準年月());
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set基準年月(getParameter().get基準年月());
        if (生年月日年齢区分_生年月日.equals(getParameter().get生年月日年齢区分())) {
            parameter.set開始生年月日(getParameter().get生年月日_開始());
            parameter.set終了生年月日(getParameter().get生年月日_終了());
        } else if (生年月日年齢区分_年齢.equals(getParameter().get生年月日年齢区分())) {
            Decimal 開始年齢 = getParameter().get年齢_開始();
            Decimal 終了年齢 = getParameter().get年齢_終了();
            parameter.set開始生年月日(getParameter().get年齢基準日());
            parameter.set終了生年月日(getParameter().get年齢基準日().plusYear(終了年齢.subtract(開始年齢).intValue()));
        }
        parameter.set広域判定区分(getParameter().get広域判定区分());
        List<RString> 選択対象リスト = new ArrayList<>();
        if (getParameter().get選択対象リスト() != null) {
            for (Entry<RString, RString> entity : getParameter().get選択対象リスト().entrySet()) {
                選択対象リスト.add(entity.getKey());
            }
        }
        parameter.set選択対象区分(getParameter().get選択対象区分());
        parameter.set選択対象リスト(選択対象リスト);
        if (getParameter().get市町村情報() != null) {
            parameter.set市町村情報(getParameter().get市町村情報().get市町村コード());
        }
        if (getParameter().get旧市町村情報() != null) {
            parameter.set旧市町村情報(getParameter().get旧市町村情報().get市町村コード());
        }
        parameter.set完納出力区分(getParameter().get完納出力区分());
        return parameter;
    }

    private PrtDankaibetsuShunoritsuIchiranhyoParameter createPrtProcessParameter() {
        PrtDankaibetsuShunoritsuIchiranhyoParameter parameter = new PrtDankaibetsuShunoritsuIchiranhyoParameter();
        parameter.set開始調定年度(getParameter().get調定年度_開始());
        parameter.set終了調定年度(getParameter().get調定年度_終了());
        parameter.set開始賦課年度(getParameter().get賦課年度_開始());
        parameter.set終了賦課年度(getParameter().get賦課年度_終了());
        parameter.set会計年度(getParameter().get会計年度());
        parameter.set調定基準年月(getParameter().get調定基準年月());
        parameter.set抽出条件(getParameter().get抽出条件());
        parameter.set基準年月(getParameter().get基準年月());
        parameter.set開始生年月日(getParameter().get生年月日_開始());
        parameter.set終了生年月日(getParameter().get生年月日_終了());
        parameter.set年齢基準日(getParameter().get年齢基準日());
        parameter.set開始年齢(getParameter().get年齢_開始().intValue());
        parameter.set終了年齢(getParameter().get年齢_終了().intValue());
        parameter.set広域判定区分(getParameter().get広域判定区分());
        parameter.set選択対象リスト(getParameter().get選択対象リスト());
        if (getParameter().get市町村情報() != null) {
            parameter.set市町村情報(getParameter().get市町村情報().get市町村コード());
            parameter.set市町村情報名称(getParameter().get市町村情報().get市町村名称());
        }
        if (getParameter().get旧市町村情報() != null) {
            parameter.set旧市町村情報(getParameter().get旧市町村情報().get市町村コード());
            parameter.set旧市町村情報名称(getParameter().get旧市町村情報().get市町村名称());
        }
        parameter.set完納出力区分(getParameter().get完納出力区分());
        return parameter;
    }
}
