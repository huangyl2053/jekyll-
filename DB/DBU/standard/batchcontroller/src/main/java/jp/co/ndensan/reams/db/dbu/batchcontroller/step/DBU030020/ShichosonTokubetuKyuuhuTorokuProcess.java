/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuTokeiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.TempIchijiTable2MybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ComMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2ProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTable2Entity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoyoshiki1to2.IJigyoHokokuNenpoYoshiki1To2Mapper;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2Manager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村特別給付_データ集計の作成処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class ShichosonTokubetuKyuuhuTorokuProcess extends BatchProcessBase<TempIchijiTable2Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuNenpoYoshiki1To2Mapper.get給付実績被保険者者台帳");
    private JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter;
    private IJigyoHokokuNenpoYoshiki1To2Mapper mapper;
    private JigyoHokokuNenpoYoshiki1To2Manager manager;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void initialize() {
        manager = new JigyoHokokuNenpoYoshiki1To2Manager();
        mapper = getMapper(IJigyoHokokuNenpoYoshiki1To2Mapper.class);
    }

    @Override
    protected void process(TempIchijiTable2Entity rstr) {
    }

    @Override
    protected void afterExecute() {
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelShishoconParam(
                processParameter.get集計年度(), HyoNo.現物_保険給付決定状況.getコード()));
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelShishoconParam(
                processParameter.get集計年度(), HyoNo.現物_保険給付決定状況_旧市町村.getコード()));
        List<ServiceKomokuCode> 項目コードList = mapper.get一時テーブル2項目コード(
                TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, null, 0, null, null));
        manager.ins事業報告統計データFor全体(processParameter, mapper, 項目コードList);
        List<RString> 構成市町村コードList = processParameter.get構成市町村コードリスト();
        if (構成市町村コードList != null && !構成市町村コードList.isEmpty()) {
            for (RString 構成市町村コード : 構成市町村コードList) {
                List<ServiceKomokuCode> 構成項目コードList = mapper.get一時テーブル2項目コード(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(new LasdecCode(構成市町村コード), null, 0, null, null));
                manager.ins事業報告統計データFor市町村別(processParameter, mapper, 構成項目コードList, 構成市町村コード);
            }
        }
        List<RString> 旧市町村コードList = processParameter.get旧市町村コードリスト();
        if (旧市町村コードList != null && !旧市町村コードList.isEmpty()) {
            for (RString 旧市町村コード : 旧市町村コードList) {
                List<ServiceKomokuCode> 旧項目コードList = mapper.get一時テーブル2項目コード(
                        TempIchijiTable2MybatisParameter.createTempIchijiTable2Param(null, new LasdecCode(旧市町村コード), 0, null, null));
                manager.ins事業報告統計データFor旧市町村別(processParameter, mapper, 旧項目コードList, 旧市町村コード);
            }
        }
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelHihokenshaParam(
                processParameter.get集計年度(), HyoNo.現物_一般状況.getコード()));
        mapper.delete事業報告統計データ(Yoshiki1To2ComMybatisParameter.createDelHihokenshaParam(
                processParameter.get集計年度(), HyoNo.現物_一般状況_旧市町村.getコード()));
        List<RString> 市町村コードList = new ArrayList<>();
        市町村コードList.add(processParameter.get市町村コード());
        if (構成市町村コードList != null && !構成市町村コードList.isEmpty()) {
            市町村コードList.addAll(構成市町村コードList);
        }
        if (旧市町村コードList != null && !旧市町村コードList.isEmpty()) {
            市町村コードList.add(RString.HALF_SPACE);
            市町村コードList.addAll(旧市町村コードList);
        }
        manager.ins事業報告統計データFor被保険者数(processParameter, mapper, 市町村コードList);
        mapper.updateShoriDateKanri(JigyoHokokuTokeiMybatisParameter.create処理日付管理マスタParamter(
                processParameter.get構成市町村コードリスト(), processParameter.get旧市町村コードリスト(),
                processParameter.get市町村コード(), processParameter.get集計年度(),
                processParameter.get広域構成市町村区分(), processParameter.get合併市町村区分(),
                processParameter.get処理日時(), processParameter.get作成日時(),
                processParameter.getプリントコントロール区分()));
    }
}
