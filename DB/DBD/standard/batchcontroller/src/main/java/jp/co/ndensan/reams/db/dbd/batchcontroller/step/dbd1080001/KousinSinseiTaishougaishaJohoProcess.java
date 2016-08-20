    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.KousinSinseiTaishougaishaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.KousinSinseiTaishougaishaJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku.IKousinSinseiTaishougaishaJohoMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmenshinseishotaishohaaku.ZenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）の_process処理クラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public class KousinSinseiTaishougaishaJohoProcess extends BatchProcessBase<KousinSinseiTaishougaishaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID_更新_負担 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IKousinSinseiTaishougaishaJohoMapper.get更新申請対象外者情報_負担限度額認定");
    private static final RString MYBATIS_SELECT_ID_更新_利用者 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IKousinSinseiTaishougaishaJohoMapper.get更新申請対象外者情報_利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_更新_訪問 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IKousinSinseiTaishougaishaJohoMapper.get更新申請対象外者情報_訪問介護利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_更新_社会 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db"
            + ".mapper.relate.gemmenshinseishotaishohaaku.IKousinSinseiTaishougaishaJohoMapper.get更新申請対象外者情報_社会福祉法人等利用者負担軽減");

    private KousinSinseiTaishougaishaJohoProcessParameter processParamter;
    private IKousinSinseiTaishougaishaJohoMapper mapper;
    private FlexibleDate 終了日;
    private FlexibleDate 開始日;
    private GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity item;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter sakuseiTaishoShaTemp;

    @Override
    protected void initialize() {
        終了日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get終了日();
        開始日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get開始日();
        mapper = getMapper(IKousinSinseiTaishougaishaJohoMapper.class);
        mapper.clear世帯員所得情報一時テーブル();
        mapper.clear世帯員把握入力一時テーブル();
        mapper.clear減免減額対象者判定用根拠一時テーブル();
        mapper.clear減免減額対象者判定用根拠作成対象者一時テーブル();
        mapper.delete世帯員所得情報一時テーブル();
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.負担限度額認定)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_更新_負担,
                    processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日, processParamter.get把握処理ID()));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_更新_利用者,
                    processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日, processParamter.get把握処理ID()));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.訪問介護利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_更新_訪問,
                    processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日, processParamter.get把握処理ID()));
        } else {
            return new BatchDbReader(MYBATIS_SELECT_ID_更新_社会,
                    processParamter.toShinseishoHakkoTaishoJohoSakuseiMybatisParameter(開始日, 終了日, processParamter.get把握処理ID()));
        }
    }

    @Override
    protected void createWriter() {
        sakuseiTaishoShaTemp
                = new BatchEntityCreatedTempTableWriter(GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.TABLE_NAME,
                        GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity.class);
    }

    @Override
    protected void process(KousinSinseiTaishougaishaJohoEntity list) {
        item = set減免減額対象者判定用根拠作成対象者(list.get被保険者番号(), processParamter.get基準日());
        sakuseiTaishoShaTemp.insert(item);
    }

    private GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity set減免減額対象者判定用根拠作成対象者(HihokenshaNo 被保険者番号,
            FlexibleDate 基準日) {
        GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity tempTable
                = new GemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTempTableEntity();
        tempTable.setKijunYMD(基準日);
        tempTable.setHihokenshaNo(被保険者番号);
        return tempTable;
    }
}
