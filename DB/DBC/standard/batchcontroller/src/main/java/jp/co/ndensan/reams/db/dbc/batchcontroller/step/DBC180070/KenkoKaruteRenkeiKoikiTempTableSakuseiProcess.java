/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki.KenkoKaruteRenkeiKoikiTempTableEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成（広域用）のバッチクラスです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public class KenkoKaruteRenkeiKoikiTempTableSakuseiProcess extends BatchProcessBase<KenkouKaruteRenkeiDataEntity> {

    private static final RString SELECT_KENKOUKARUTERENKEIDATA = new RString("jp.co.ndensan.reams.db.dbc."
            + "persistence.db.mapper.relate.kenkoukaruterenkeidatakoiki.IKenkouKaruteRenkeiDataKoikiMapper.createKenkouKaruteRenkeiData");
    private KenkouKaruteRenkeiDataMybatisParameter mybitisParamter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void initialize() {
        mybitisParamter = new KenkouKaruteRenkeiDataMybatisParameter();
        mybitisParamter.setPsmShikibetsuTaisho(getMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_KENKOUKARUTERENKEIDATA, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(
                KenkoKaruteRenkeiKoikiTempTableEntity.TABLE_NAME, KenkoKaruteRenkeiKoikiTempTableEntity.class);
    }

    @Override
    protected void process(KenkouKaruteRenkeiDataEntity entity) {
        KenkoKaruteRenkeiKoikiTempTableEntity tempTableEntity = new KenkoKaruteRenkeiKoikiTempTableEntity();
        tempTableEntity.setHihokenshaNo(entity.get被保険者番号());
        tempTableEntity.setIdoYMD(entity.get異動日());
        tempTableEntity.setShichosonCode(entity.get市町村コード());
        tempTableEntity.setShikibetsuCode(entity.get識別コード());
        tempTableEntity.setShikakuShutokuYMD(entity.get資格取得年月日());
        tempTableEntity.setShikakuSoshitsuYMD(entity.get資格喪失年月日());
        tempTableEntity.setLogicalDeletedFlag(entity.is論理削除フラグ());
        tempTableEntity.setGyomuCode(entity.get業務コード());
        tempTableEntity.setJuminShubetsuCode(entity.get住民種別コード());
        tempTableEntity.setJuminJotaiCode(entity.get住民状態コード());
        tempTableEntity.setKojinNo(entity.get個人番号());
        tempTableEntity.setMeisho(entity.get名称());
        tempTableEntity.setKanaMeisho(entity.getカナ名称());
        tempTableEntity.setSeinengappiYMD(entity.get生年月日());
        tempTableEntity.setSeibetsuCode(entity.get性別());
        tempTableEntity.setRirekiNo(entity.get履歴番号());
        tempTableEntity.setEdaban(entity.get枝番());
        tempTableEntity.setYokaigoJotaiKubunCode(entity.get要介護認定状態区分コード());
        tempTableEntity.setNinteiYMD(entity.get認定年月日());
        tempTableEntity.setSoshitsuYMD(entity.get喪失年月日());
        tempTableEntity.setNinteiYukoKikanKaishiYMD(entity.get認定有効期間開始年月日());
        tempTableEntity.setNinteiYukoKikanShuryoYMD(entity.get認定有効期間終了年月日());
        tempTableWriter.insert(tempTableEntity);
    }

    private RString getMybitisParamter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先))
                .setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        key.set住民状態(juminJotaiList);
        key.set住民種別(juminShubetsuList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

}
