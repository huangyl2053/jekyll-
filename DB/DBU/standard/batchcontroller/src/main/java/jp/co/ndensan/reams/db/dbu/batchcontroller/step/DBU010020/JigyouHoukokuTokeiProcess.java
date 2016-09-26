/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyouHoukokuTokeiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyouHoukokuTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.IppanJokyoJigyouHoukokuTokeiEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 事業報告統計データのバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class JigyouHoukokuTokeiProcess extends BatchProcessBase<IppanJokyoJigyouHoukokuTokeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getIppanJokyoJigyouHoukokuTokei");
    private static final RString 選択する区分 = new RString(1);

    private JigyouHoukokuTokeiProcessParameter processParameter;
    private JigyouHoukokuTokeiMybatisParameter mybatisParameter;
    private IJigyoHokokuGeppoIppanMapper mapper;
    private FileSpoolManager manager;
    private RString 出力ファイルPATH;
    private RString 圧縮ファイル名;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7021JigyoHokokuTokeiDataEntity> tableWriter;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toJigyouHoukokuTokeiMybatisParameter();
        mybatisParameter.setShichosoncodeList(getShichosoncodeList());
        mybatisParameter.setShukeinoList(getShukeinoList());
        mybatisParameter.setHyonoList(getHyonoList());
        mapper = getMapper(IJigyoHokokuGeppoIppanMapper.class);
        manager = processParameter.getManager();
        出力ファイルPATH = processParameter.get出力ファイルPATH();
        圧縮ファイル名 = Path.combinePath(出力ファイルPATH, new RString("JigyoHokokuGeppo_Ippan.zip"));
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7021JigyoHokokuTokeiDataEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void beforeExecute() {
        mapper.exeJigyouHoukokuTokeiDelete(mybatisParameter);

    }

    @Override
    protected void process(IppanJokyoJigyouHoukokuTokeiEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity tokeiEntity = new DbT7021JigyoHokokuTokeiDataEntity();
        tokeiEntity.setHokokuYSeireki(processParameter.get報告年月().getYear());
        tokeiEntity.setHokokuM(new RString(processParameter.get報告年月().getMonthValue()));
        tokeiEntity.setShukeiTaishoYSeireki(processParameter.get年度());
        tokeiEntity.setShukeiTaishoM(new RString(processParameter.get集計年月().getMonthValue()));
        tokeiEntity.setToukeiTaishoKubun(entity.getToukeiTaishoKubun());
        tokeiEntity.setShichosonCode(entity.getShichosonCode());
        tokeiEntity.setHyoNo(entity.getHyoNo());
        tokeiEntity.setShukeiNo(entity.getShukeiNo());
        tokeiEntity.setShukeiTani(entity.getShukeiTani());
        tokeiEntity.setTateNo(entity.getTateNo());
        tokeiEntity.setYokoNo(entity.getYokoNo());
        tokeiEntity.setTateKomokuCode(Code.EMPTY);
        tokeiEntity.setShukeiKomokuMeisho(RString.EMPTY);
        tokeiEntity.setYokoKomokuCode(Code.EMPTY);
        tableWriter.insert(tokeiEntity);
    }

    @Override
    protected void afterExecute() {
        mapper.exeShoriDateKanriUpdate(mybatisParameter);
        ZipUtil.createFromFolder(圧縮ファイル名, 出力ファイルPATH);
        manager.spool(圧縮ファイル名);
    }

    private List<RString> getShichosoncodeList() {
        List<RString> shichosoncodeList = new ArrayList<>();
        shichosoncodeList.add(processParameter.get市町村コード());
        if (選択する区分.equals(processParameter.get構成市町村区分())) {
            shichosoncodeList.addAll(processParameter.get構成市町村コードList());
        }
        if (選択する区分.equals(processParameter.get旧市町村区分())) {
            shichosoncodeList.addAll(processParameter.get旧市町村コードList());
        }
        return shichosoncodeList;
    }

    private List<RString> getShukeinoList() {
        List<RString> shukeinoList = new ArrayList<>();
        shukeinoList.add(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_1_第1号被保険者数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード());
        shukeinoList.add(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード());
        shukeinoList.add(ShukeiNo.一般状況_4_利用者負担減額_免除認定_総数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_利用者負担.getコード());
        shukeinoList.add(ShukeiNo.一般状況_7_利用者負担減額_免除認定_再掲_第2号被保険者分.getコード());
        shukeinoList.add(ShukeiNo.一般状況_8_介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第2号被保険者分_利用者負担.getコード());
        shukeinoList.add(ShukeiNo.一般状況_6_食費_居住費に係る負担限度額認定_再掲_第2号被保険者分.getコード());
        shukeinoList.add(ShukeiNo.一般状況_8_介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第2号被保険者分_特定負担限度額.getコード());
        shukeinoList.add(ShukeiNo.一般状況_10_利用者負担第4段階における_食費_居住費の特例減額措置.getコード());
        shukeinoList.add(ShukeiNo.一般状況_9_食費_居住費に係る負担限度額認定_再掲_税制改正による激変緩和措置を受けている者.getコード());
        shukeinoList.add(ShukeiNo.一般状況_11_要介護_要支援_認定者数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_3_食費_居住費に係る負担限度額認定_総数.getコード());
        shukeinoList.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_特定負担限度額.getコード());
        return shukeinoList;
    }

    private List<RString> getHyonoList() {
        List<RString> hyonoList = new ArrayList<>();
        hyonoList.add(HyoNo.現物_一般状況.getコード());
        hyonoList.add(HyoNo.現物_一般状況_旧市町村.getコード());
        return hyonoList;
    }
}
